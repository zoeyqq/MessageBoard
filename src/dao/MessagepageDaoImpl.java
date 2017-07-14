package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import po.Message;
import po.Pager;
import util.DBHelper;

public class MessagepageDaoImpl implements MessagepageDao{

	@Override
	public Pager<Message> findMessage(Message searchModel, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		List<Message> allMessageList = getAllMessage(searchModel);
		
		Pager<Message> pager = new Pager<Message>(pageNum, pageSize,allMessageList);
		return pager;
	}

	/**
	 * 获取所有数据
	 * @param searchModel 查询参数
	 * @return 查询结果
	 */
	private static  List<Message> getAllMessage(Message searchModel)
	{
		List<Message> result = new ArrayList<Message>();
		List<Object> paramList = new ArrayList<Object>();
		
		String username = searchModel.getUsername();		

		StringBuilder sql = new StringBuilder("select * from zoey_message where 1=1 ");
		
		if(username !=null&&!username.equals(" "))
		{
			sql.append("and username like ?");
			paramList.add("%"+username+"%");		
		}		

		//System.out.println(sql);
		DBHelper dbHelper = null;		
		try {
			dbHelper = new DBHelper();
			dbHelper.getConnection();
			
			List<Map<String, Object>> mapList = dbHelper.findResult(
					sql.toString(), paramList);
			if (mapList != null) {
				for (Map<String, Object> map : mapList) {
					Message s = new Message(map);
					result.add(s);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("查询数据异常！", e);
		}finally {
			if (dbHelper != null) {
				dbHelper.releaseConn(); // 一定要释放资源
			}
		}
		return result;		
	}
	
	public static void main(String[] args) {
		List<Message> lst = getAllMessage(new Message());
		for (Message s : lst) {
			System.out.println(s);
		}
	}
}
