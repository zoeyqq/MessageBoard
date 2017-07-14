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
		// 校验pageNum参数输入合法性
		String pageNumStr = request.getParameter("pageNum"); 
		if(pageNumStr !=null && !StringUtil.isNum(pageNumStr)){
			request.setAttribute("errorMsg", "参数传输错误");
			request.getRequestDispatcher("message.jsp").forward(request, response);
			return;
		}
		
		int pageNum = Constant.DEFAULT_PAGE_NUM; //显示第几页数据
		if(pageNumStr!=null && !"".equals(pageNumStr.trim())){
			pageNum = Integer.parseInt(pageNumStr);
		}
		
		int pageSize = Constant.DEFAULT_PAGE_SIZE;  // 每页显示多少条记录
		String pageSizeStr = request.getParameter("pageSize");
		if(pageSizeStr!=null && !"".equals(pageSizeStr.trim())){
			pageSize = Integer.parseInt(pageSizeStr);
		}
		
		//组装查询条件
		Message searchModel = new Message();
		searchModel.setUsername(username);
		
		
		//调用service获取查询结果
		Pager<Message> result = pageService.findMessage(searchModel, pageNum, pageSize);
		
		//System.out.println(result.getDataList());
		//System.out.println(result.getCurrentPage()+","+result.getTotalRecord()+","+result.getTotalPage());
		request.getSession().setAttribute("result", result);
		
		response.sendRedirect(path+"/message.jsp");
		
	}
	
	

}
