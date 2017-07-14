package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import po.Users;
import util.DBHelper;

public class LoginDaoImpl implements LoginDao{

	@Override
	public boolean loginUser(Users u) {
		// TODO Auto-generated method stub
		PreparedStatement stmt = null;
		boolean flag = false;
		DBHelper dbHelper = null;
		try {
			dbHelper = new DBHelper();
			Connection conn = dbHelper.getConnection();
			String sql = "select * from zoey_oper where username=? and password=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, u.getUsername());
			stmt.setString(2, u.getPassword());
			ResultSet rs = stmt.executeQuery();
			//System.out.println(rs.next());
			if(rs.next())
			{
				flag=true;
				rs.close();
                stmt.close();
			}
			else
			{
				flag=false;
				rs.close();
                stmt.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

}
