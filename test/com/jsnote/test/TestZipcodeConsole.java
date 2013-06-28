package com.jsnote.test;

import java.util.List;

import com.jsnote.dao.ZipcodeDAO;
import com.jsnote.model.Zipcode;
import com.jsnote.view.ZipcodeFrame;

/**
 * Test Case By Console
 * 
 * @author JISU LEE
 */
public class TestZipcodeConsole {
	
	private final ZipcodeDAO zipcodeDAO = new ZipcodeDAO();

	//"��/��"���� �˻��ϴ� �޼���
	public void selectAllByGugun() {	
		String gugun = "�����";
		List<Zipcode> list = zipcodeDAO.selectAllByGugun(gugun);

		System.out.println(list);
	}

	//"��/��/��/��"�� �˻��ϴ� �޼���
	public void selectAllByDong() {
		String dong = "�ϰ赿";
		List<Zipcode> list = zipcodeDAO.selectAllByDong(dong);
		
		System.out.println(list);
	}
	
	//"�����ȣ"�� �˻��ϴ� �޼���
	public void selectByZipcode() {
		
		String zipcode = "791-718";
		Zipcode zip = zipcodeDAO.selectByZipcode(zipcode);
		
		System.out.println(zip);
	}
	
	public static void main(String[] args) {

		TestZipcodeConsole test = new TestZipcodeConsole();
		
		test.selectAllByDong();
//		test.selectAllByGugun();
//		test.selectByZipcode();
		
	}
}
