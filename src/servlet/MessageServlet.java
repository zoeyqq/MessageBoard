package servlet;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.Message;
import service.MessageService;
import service.MessageServiceImpl;

/**
 * Servlet implementation class MessageServlet
 */
@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MessageService service = new MessageServiceImpl();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageServlet() {
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
		
		String message = request.getParameter("message");
		String username = (String)request.getSession().getAttribute("loginUser");
		
		
		Message m = new Message();
		m.setUsername(username);
		m.setMessage(message);

		
		boolean flag = service.messageLoad(m);
		if(flag){
			out.println("¡Ù—‘≥…π¶");
			response.sendRedirect(path+"/message.jsp");
		}
		else
		{
			out.println("¡Ù—‘ ß∞‹");
			response.sendRedirect(path+"/message.jsp");
		}
		
		
	}

}
