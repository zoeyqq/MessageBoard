package service;

import java.util.List;

import dao.MessageListDao;
import dao.MessageListDaoImpl;
import po.Message;

public class MessageListServiceImpl implements MessageListService{
	private MessageListDao listDao = new MessageListDaoImpl();

	@Override
	public List<Message> getMessageList() {
		// TODO Auto-generated method stub
		return listDao.getMessageList();
	}

}
