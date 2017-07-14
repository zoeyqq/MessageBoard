package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.Message;
import service.MessageListService;
import service.MessageListServiceImpl;

/**
 * Servlet implementation class MessageListServlet
 */
@WebServlet("/MessageListServlet")
public class MessageListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MessageListService service = new MessageListServiceImpl();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageListServlet() {
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
		
		List<Message> list = service.getMessageList();
		request.getSession().setAttribute("REPORT", list);
        response.sendRedirect(path+"/login_success.jsp");
	}

}
