package servlet;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import po.Users;
import service.LoginService;
import service.LoginServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LoginService service = new LoginServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getContextPath();  
        request.setCharacterEncoding("UTF-8");  
        response.setContentType("text/html; charset=utf-8");  
        PrintWriter out = response.getWriter();
        
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Users u = new Users();
		u.setUsername(username);
		u.setPassword(password);
	
		System.out.println(u.getUsername()+","+u.getPassword());
		
		String sMessage = "";
		
		/*验证码部分*/
		String piccode  = (String)request.getSession().getAttribute("piccode");
		String checkcode = request.getParameter("checkcode");
		checkcode = checkcode.toUpperCase();

		if(checkcode.equals(piccode))
		{
			out.println("Right");	
			System.out.println("验证码正确");
			/*验证码验证正确后判断登陆名和密码是否匹配*/
			boolean flag=service.loginUser(u);
			System.out.println(flag);
			if(flag)
			{
				//out.println("登陆成功");
				System.out.println("登陆成功！");
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", username);
				//request.getSession().setAttribute("loginUser",u.getUsername());
				//request.getRequestDispatcher("/login_success.jsp").forward(request,response);
				response.sendRedirect(path+"/message.jsp");
			}
			else
			{
				out.println("登陆失败");
				sMessage="用户名或密码错误";
				
				HttpSession session = request.getSession();
				session.setAttribute("showMessage", sMessage);				
				response.sendRedirect(path+"/login.jsp");
				//response.sendRedirect(path+"/login_failure.jsp");
			}
		}
		else
		{
			//out.println("Wrong");
			System.out.println("验证码错误");
			sMessage="验证码错误";
			HttpSession session = request.getSession();
			session.setAttribute("showMessage", sMessage);
			response.sendRedirect(path+"/login.jsp");
		}
		out.flush();
		out.close();
					
	}

}
