package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.Users;
import service.RegisterService;
import service.RegisterServiceImpl;


/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RegisterService service = new RegisterServiceImpl();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");  
        response.setContentType("text/html; charset=utf-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String realname = request.getParameter("realname");
		
		Users u= new Users();
		
		u.setUsername(username);
		u.setPassword(password);
		u.setRealname(realname);
		
		System.out.println(u.getUsername()+","+u.getPassword()+","+u.getRealname());
				
		boolean flag = service.registerUser(u);
		if(flag)
		{
			response.sendRedirect(path+"/register_success.jsp");
			out.println("×¢²á³É¹¦");
		}
		else
		{
			response.sendRedirect(path+"/register_failure.jsp");
			out.println("×¢²áÊ§°Ü");
		}
	}

}
