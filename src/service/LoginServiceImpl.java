package service;

import dao.LoginDao;
import dao.LoginDaoImpl;
import po.Users;

public class LoginServiceImpl implements LoginService{
    private LoginDao loginDao = new LoginDaoImpl();
	@Override
	public boolean loginUser(Users u) {
		// TODO Auto-generated method stub
		return loginDao.loginUser(u);
	}

}
