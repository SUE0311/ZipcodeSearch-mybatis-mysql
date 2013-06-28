package com.jsnote.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jsnote.model.Zipcode;

/**
 * Zipcode DAO
 * 
 * @author JISU LEE
 */
public class ZipcodeDAO {
	
	private SqlSessionFactory sqlSessionFactory; 
	
	public ZipcodeDAO(){
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}

	/**
	 * �����ͺ��̽��κ��� "��/��"���� �˻��� ����� ������
	 */
	@SuppressWarnings("unchecked")
	public List<Zipcode> selectAllByGugun(String gugun){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<Zipcode> list = session.selectList("Zipcode.getByGugun",gugun);
			return list;
		} finally {
			session.close();
		}
	}
	
	/**
	 * �����ͺ��̽��κ��� "��/��/��/��"�� �˻��� ����� ������
	 */
	@SuppressWarnings("unchecked")
	public List<Zipcode> selectAllByDong(String dong){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<Zipcode> list = session.selectList("Zipcode.getByDong",dong);
			return list;
		} finally {
			session.close();
		}
	}
	
	/**
	 * �����ͺ��̽��κ��� "�����ȣ"�� �˻��� ����� ������
	 */
	public Zipcode selectByZipcode(String zipcode){

		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			Zipcode contact = (Zipcode) session.selectOne("Zipcode.getByZipcode",zipcode);
			return contact;
		} finally {
			session.close();
		}
	}
}
