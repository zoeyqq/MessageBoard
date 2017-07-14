package dao;

import po.Message;
import po.Pager;

public interface MessagepageDao {

	/**
	 * 根据查询条件查询留言分页信息
	 * @param searcheModel 封装查询条件
	 * @param pageNum  查询第几页数据
	 * @param pageSize 每页显示多少条记录
	 * @return 查询结果
	 */
	public Pager<Message> findMessage(Message searcheModel,int pageNum,int pageSize);
}
