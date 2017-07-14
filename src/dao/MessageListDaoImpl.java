package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import po.Message;
import util.DBHelper;

public class MessageListDaoImpl implements MessageListDao{


	@Override
	public List<Message> getMessageList() {
		List<Message> list = new ArrayList<Message>();
		PreparedStatement stmt = null;
		
		DBHelper dbHelper = null;
		try {
			dbHelper = new DBHelper();
			Connection conn = dbHelper.getConnection();
			String sql="select username,indate,message from zoey_message";
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			Message m = null;
			while(rs.next())
			{
				m = new Message();
				m.setUsername(rs.getString("username"));
				m.setIndate(rs.getString("indate"));
				m.setMessage(rs.getString("message"));
				list.add(m);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;						
	}

}
