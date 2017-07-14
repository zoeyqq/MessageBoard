package service;

import dao.RegisterDao;
import dao.RegisterDaoImpl;
import po.Users;

public class RegisterServiceImpl implements RegisterService{
	private RegisterDao registerDao = new RegisterDaoImpl();
    
	@Override
	public boolean registerUser(Users u) {
		// TODO Auto-generated method stub
		return registerDao.registerUser(u);
	}
    
}
