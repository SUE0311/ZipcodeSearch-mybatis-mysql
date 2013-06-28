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

	//"구/군"으로 검색하는 메서드
	public void selectAllByGugun() {	
		String gugun = "노원구";
		List<Zipcode> list = zipcodeDAO.selectAllByGugun(gugun);

		System.out.println(list);
	}

	//"동/읍/면/리"로 검색하는 메서드
	public void selectAllByDong() {
		String dong = "하계동";
		List<Zipcode> list = zipcodeDAO.selectAllByDong(dong);
		
		System.out.println(list);
	}
	
	//"우편번호"로 검색하는 메서드
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
