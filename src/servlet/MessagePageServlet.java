package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.Constant;
import po.Message;
import po.Pager;
import util.StringUtil;

import service.MessagePageService;
import service.MessagePageServiceImpl;

/**
 * Servlet implementation class MessagePageServlet
 */
@WebServlet("/MessagePageServlet")
public class MessagePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MessagePageService  pageService = new MessagePageServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessagePageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getContextPath();
		String username = request.getParameter("username");
		// У��pageNum��������Ϸ���
		String pageNumStr = request.getParameter("pageNum"); 
		if(pageNumStr !=null && !StringUtil.isNum(pageNumStr)){
			request.setAttribute("errorMsg", "�����������");
			request.getRequestDispatcher("message.jsp").forward(request, response);
			return;
		}
		
		int pageNum = Constant.DEFAULT_PAGE_NUM; //��ʾ�ڼ�ҳ����
		if(pageNumStr!=null && !"".equals(pageNumStr.trim())){
			pageNum = Integer.parseInt(pageNumStr);
		}
		
		int pageSize = Constant.DEFAULT_PAGE_SIZE;  // ÿҳ��ʾ��������¼
		String pageSizeStr = request.getParameter("pageSize");
		if(pageSizeStr!=null && !"".equals(pageSizeStr.trim())){
			pageSize = Integer.parseInt(pageSizeStr);
		}
		
		//��װ��ѯ����
		Message searchModel = new Message();
		searchModel.setUsername(username);
		
		
		//����service��ȡ��ѯ���
		Pager<Message> result = pageService.findMessage(searchModel, pageNum, pageSize);
		
		//System.out.println(result.getDataList());
		//System.out.println(result.getCurrentPage()+","+result.getTotalRecord()+","+result.getTotalPage());
		request.getSession().setAttribute("result", result);
		
		response.sendRedirect(path+"/message.jsp");
		
	}
	
	

}
