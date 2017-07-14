package service;

import po.Message;
import po.Pager;

public interface MessagePageService {
	
	public Pager<Message> findMessage(Message searcheModel,int pageNum,int pageSize);

}
