package cn.itcast.gjp.service;

import java.util.List;

import cn.itcast.gjp.dao.ZhangWuDao;
import cn.itcast.gjp.domain.ZhangWu;

/*
 *  ҵ�����
 *  ������һ��,���Ʋ�controller������
 *  ��������,���ݸ�dao��,�������ݿ�
 *  ����dao���е���,���Աλ��,����Dao��Ķ���
 */

/**
 * service建议接口化，然后再实现，实现低耦合
 */
public class ZhangWuService {
	private ZhangWuDao dao = new ZhangWuDao();
	/*
	 * ���巽����ʵ��ɾ��������
	 * �ɿ��Ʋ���ã���������id
	 * ����dao�㷽������������id
	 */
	public void deleteZhangWu(int zwid) {
		dao.deleteZhangWu(zwid);
	}
	
	/*
	 * ���巽����ʵ�ֱ༭����
	 * �ɿ��Ʋ���ã�����ZhangWu����
	 * ����dao��ķ���������ZhangWu����
	 */
	public void editZhangWu(ZhangWu zw) {
		dao.editZhangWu(zw);
	}
	
	/*
	 * ���巽����ʵ���������
	 * ���ɿ��Ʋ���ã�����ZhangWu����
	 */
	public void addZhangWu(ZhangWu zw) {
		dao.addZhangWu(zw);
	}
	/*
	 * ���巽��,ʵ��������ѯ����
	 * �����ɿ��Ʋ����,����2�������ַ���
	 * ����dao��ķ���,����2�������ַ���
	 * ��ȡ����ѯ�����
	 */
	public List<ZhangWu> select(String startDate,String endDate){
		return dao.select(startDate, endDate);
	}
	
	/*
	 *  ���巽��,ʵ�ֲ�ѯ���е���������
	 *  �˷���,�ɿ��Ʋ����, ȥ����dao��ķ���
	 *  ���ش洢ZhangWu�����List����
	 */
	public List<ZhangWu> selectAll(){
		return dao.selectAll();
	}

	
	
}
