package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import po.Message;
import util.DBHelper;


public class MessageDaoImpl implements MessageDao{

	@Override
	public boolean messageLoad(Message m) {
		// TODO Auto-generated method stub
		Date date=new Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sysdate=df.format(date);
		boolean flag = false;
		int result = -1;
		DBHelper dbHelper = null;
		try {
			dbHelper = new DBHelper();
			Connection conn = dbHelper.getConnection();
			String sql="insert into zoey_message(username,message,indate) values(?,?,?)";
			PreparedStatement ptmt=conn.prepareStatement(sql);	
			//String message1 = m.getMessage();
			//String toMessage = EncodeTypeChange.UTF8toISO(message1);
			ptmt.setString(1, m.getUsername());		
			ptmt.setString(2, m.getMessage());
			ptmt.setString(3, sysdate);
						
			System.out.println(m.getUsername()+","+m.getMessage());
			
			//ptmt.execute();
			result = ptmt.executeUpdate();
			flag = result > 0 ? true : false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

}
