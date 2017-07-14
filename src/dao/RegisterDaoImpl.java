package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import po.Users;
import util.DBHelper;

public class RegisterDaoImpl implements RegisterDao{

	@Override
	public boolean registerUser(Users u) {
		boolean flag=false;
		int result = -1;

		DBHelper dbHelper = null;
		try {
			dbHelper = new DBHelper();
			Connection conn = dbHelper.getConnection();
			String sql="insert into zoey_oper(username,password,name) values(?,?,?)";
			PreparedStatement ptmt=conn.prepareStatement(sql);			
			ptmt.setString(1, u.getUsername());
			ptmt.setString(2, u.getPassword());
			ptmt.setString(3, u.getRealname());
			
			result = ptmt.executeUpdate();
			flag = result > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

}
