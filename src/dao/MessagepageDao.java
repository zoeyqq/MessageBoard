package dao;

import po.Message;
import po.Pager;

public interface MessagepageDao {

	/**
	 * ���ݲ�ѯ������ѯ���Է�ҳ��Ϣ
	 * @param searcheModel ��װ��ѯ����
	 * @param pageNum  ��ѯ�ڼ�ҳ����
	 * @param pageSize ÿҳ��ʾ��������¼
	 * @return ��ѯ���
	 */
	public Pager<Message> findMessage(Message searcheModel,int pageNum,int pageSize);
}
