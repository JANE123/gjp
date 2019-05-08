package cn.itcast.gjp.dao;
/*
 *  ʵ�ֶ����ݱ� gjp_zhangwu ������ɾ�Ĳ����
 *  dbuils���������,���Ա����QueryRunner����,ָ������Դ
 */
/**
 * 数据访问对象，一方面连接试题对象，一方面连接数据库操作（这边用原生SQL没什么问题）
 * tips： 建议用框架，这些简单的CRUD操作直接用就可以了，mybatis里的insert之类，jpa中也是类似的
 */

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.gjp.domain.ZhangWu;
import cn.itcast.gjp.tools.JDBCUtils;

public class ZhangWuDao {
	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	/*
	 * ���巽����ʵ��ɾ��ҵ��
	 * ҵ�����ã���������id
	 */
	public void deleteZhangWu(int zwid) {
		try {
			//ƴдɾ������SQL
			String sql = "DELETE FROM gjp_zhangwu WHERE zwid=?";
			qr.update(sql, zwid);
		} catch (SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("ɾ������ʧ��");
		}
	}
	/*
	 * ���巽����ʵ�ֱ༭����
	 * ��ҵ�����ã�����ZhangWu����
	 * �������е����ݣ����µ����ݱ�
	 */
	public void editZhangWu(ZhangWu zw) {
		try {
			//�������ݵ�SQL
			String sql = "UPDATE gjp_zhangwu SET flname=?,money=?,zhanghu=?,createtime=?,description=? WHERE zwid=?";
			//����������飬��װ��������
			Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription(),zw.getZwid()};
			//����qr���󷽷�updateִ�и���
			qr.update(sql, params);
		} catch (SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("�༭����ʧ��");
		}
		
	}
	/*
	 * ���巽����ʵ�����������
	 * ��ҵ�����ã�����ZhangWu����
	 * ��ZhangWu�����е����ݣ���ӵ����ݿ�
	 */
	public void addZhangWu(ZhangWu zw) {
		try{
			 //ƴ��������ݵ�sql
			String sql = "INSERT INTO gjp_zhangwu (flname,money,zhanghu,createtime,description) VALUES(?,?,?,?,?)";
			//�����������飬����5��ռλ����ʵ�ʲ���
			//ʵ�ʲ�����Դ�Ǵ��ݹ����Ķ���ZhangWu
			Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription()};
			//����qr�����еķ���updateִ�����
			qr.update(sql, params);
		}catch(SQLException ex) {
			System.out.println(ex);
			throw new RuntimeException("�������ʧ��");
		}
	}
	/*
	 * ���巽��,��ѯ���ݿ�,��������ȥ��ѯ�����
	 * ��ҵ������,��ѯ������洢��Bean����,�洢��List����
	 * �����ߴ���2�������ַ���
	 */
	public List<ZhangWu> select(String startDate,String endDate){
		try{
			//ƴд������ѯ��SQL���
			String sql = "SELECT * FROM gjp_zhangwu WHERE createtime BETWEEN ? AND ?";
			//�����������,�洢?ռλ��
			Object[] params = {startDate,endDate};
			//����qr����ķ���query��ѯ���ݱ�,��ȡ�����
			return qr.query(sql, new BeanListHandler<>(ZhangWu.class),params);
		}catch(SQLException ex){
			System.out.println(ex);
			throw new RuntimeException("������ѯʧ��");
		}
	}
	
	/*
	 * ���巽��,��ѯ���ݿ�,��ȡ���е���������
	 * ����,��ҵ������
	 * �����,�����е���������,�洢��Bean������,�洢��������
	 */
	public List<ZhangWu> selectAll(){
		try{
		//��ѯ�������ݵ�SQL���
			String sql = "SELECT * FROM gjp_zhangwu";
			//����qr����ķ���,query����,�����BeanListHandler
			List<ZhangWu> list = qr.query(sql, new BeanListHandler<>(ZhangWu.class));
			return list;
		}catch(SQLException ex){
			System.out.println(ex);
			throw new RuntimeException("��ѯ��������ʧ��");
		}
	}
	
	
}
