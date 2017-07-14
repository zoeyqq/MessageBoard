package service;

import dao.MessageDao;
import dao.MessageDaoImpl;
import po.Message;

public class MessageServiceImpl implements MessageService{
	private MessageDao messageDao = new MessageDaoImpl();

	@Override
	public boolean messageLoad(Message m) {
		// TODO Auto-generated method stub
		return messageDao.messageLoad(m);
	}

}
