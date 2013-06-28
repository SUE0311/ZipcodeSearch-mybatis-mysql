package com.jsnote.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.jsnote.dao.ZipcodeDAO;
import com.jsnote.model.Zipcode;

/**
 * ZipcodeFrame 컴포넌트에서 필요한 이벤트 메서드로 구성된 EventHandler 클래스
 * @author JIJU LEE
 */
public class EventHandler{
	
	//"동/읍/면/리"로 검색하는 버튼  이벤트 핸들러
	static class SearchByDongEventHandler implements ActionListener
	{
		JTextField srchField_1;
		JTextArea textArea;
		
		private final ZipcodeDAO zipcodeDAO = new ZipcodeDAO();
		
		public SearchByDongEventHandler(JTextField field, JTextArea area) {
			srchField_1 = field;
			textArea = area;
		}
		
		public void actionPerformed(ActionEvent e)
		{
			String dong = srchField_1.getText();
			List<Zipcode> list = zipcodeDAO.selectAllByDong(dong);
			
			if(dong.equals(""))//검색어를 입력하지 않았을 때
			{
				textArea.setText("");
				textArea.append("▶ 입력하신 단어가 없습니다.\n\n▷ 검색창에 찾으시는 검색어를 입력해주세요.");
			}else if(list.isEmpty())//검색한 단어가 데이터베이스에 존재하지 않을 때
			{
				textArea.setText("");
				textArea.append("▶ < " + dong + " >" + " 는 등록되지 않은 단어입니다.\n\n▷ 지번을 정확히 확인하시어 검색해주세요.");
			}
			else//정확한 검색어를 입력했을 때(성공)
			{
				textArea.setText("");
				textArea.append("▶ < " +dong + " >" + " (으)로 검색하신 결과입니다.\n\n");
				for (Zipcode dongList : list) {
					textArea.append(dongList.toString());
		        }
				textArea.append("\n");
				
				srchField_1.setText("");
				srchField_1.requestFocus();
			}
		}
	}
	
	//"구/군"으로 검색하는 버튼 이벤트 핸들러
	static class SearchByGugunEventHandler implements ActionListener
	{
		JTextField srchField_2;
		JTextArea textArea;
		
		private final ZipcodeDAO zipcodeDAO = new ZipcodeDAO();
		
		public SearchByGugunEventHandler(JTextField field, JTextArea area) {
			srchField_2 = field;
			textArea = area;
		}
		
		public void actionPerformed(ActionEvent e)
		{
			String gugun = srchField_2.getText();
			List<Zipcode> list = zipcodeDAO.selectAllByGugun(gugun);

			if(gugun.equals(""))
			{
				textArea.setText("");
				textArea.append("▶ 입력하신 단어가 없습니다.\n\n▷ 검색창에 찾으시는 검색어를 입력해주세요.");
			}else if(list.isEmpty())
			{
				textArea.setText("");
				textArea.append("▶ < " + gugun + " >" + " 는 등록되지 않은 단어입니다.\n\n▷ 지번을 정확히 확인하시어 검색해주세요.");
			}
			else
			{
				textArea.setText("");
				textArea.append("▶ < " +gugun + " >" + " (으)로 검색하신 결과입니다.\n\n");
				for (Zipcode gugunList : list) {
					textArea.append(gugunList.toString());
		        }
				textArea.append("\n");
				
				srchField_2.setText("");
				srchField_2.requestFocus();
			}
		}
	}
	
	//결과창을 클리어하는이벤트 핸들러
	static class ClearEventHandler implements ActionListener
	{
		JTextArea textArea;
		
		public ClearEventHandler(JTextArea area) {
			textArea = area;
		}
		
		public void actionPerformed(ActionEvent e)
		{
			textArea.setText("※ 검색창에 찾으시는 지번 주소를 기입해주세요.");
		}
	}
}


