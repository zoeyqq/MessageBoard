package service;

import dao.MessagepageDao;
import dao.MessagepageDaoImpl;
import po.Message;
import po.Pager;

public class MessagePageServiceImpl implements MessagePageService {
	
	private MessagepageDao messagepageDao;
	
	public MessagePageServiceImpl(){
		messagepageDao = new MessagepageDaoImpl();
	}

	@Override
	public Pager<Message> findMessage(Message searcheModel, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		Pager<Message> result = messagepageDao.findMessage(searcheModel, pageNum, pageSize);
		return result;
	}

	public MessagepageDao getMessagepageDao() {
		return messagepageDao;
	}

	public void setMessagepageDao(MessagepageDao messagepageDao) {
		this.messagepageDao = messagepageDao;
	}
	
	

}
