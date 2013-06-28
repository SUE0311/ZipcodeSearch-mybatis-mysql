package com.jsnote.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

/**
 * Swing 컴포넌트로 구성한 ZipcodeFrame
 * - 검색창(textField) 2개, 검색 결과 창(textArea) 1개
 * * @author JIJU LEE
 */
public class ZipcodeFrame extends JFrame
{
	//"동/읍/면/리" 검색 창
	JTextField srchField_1 = new JTextField(20);
	JButton srchBtn_1 = new JButton("검색");
	
	//"구/군" 검색 창
	JTextField srchField_2 = new JTextField(20);
	JButton srchBtn_2 = new JButton("검색");
	
	//검색 결과 창
		JTextArea textArea = new JTextArea(30,25);
		
	//검색 결과 지우는 버튼
	JButton clearBtn = new JButton("검색 결과 지우기");

	public ZipcodeFrame(String title)
	{
		super(title);
		
		setBounds(100, 200, 550, 350);
		setLayout(new BorderLayout());
		
		Border border = BorderFactory.createEtchedBorder();
		
		Border srchBorder_1 = BorderFactory.createTitledBorder(border, "지번주소 : 동 / 읍 / 면 / 리 이름을 입력하세요");
		JPanel srchPanel_1 = new JPanel();
		srchPanel_1.setBorder(srchBorder_1);
		srchPanel_1.setLayout(new FlowLayout());
		srchPanel_1.add(srchField_1);
		srchPanel_1.add(srchBtn_1);
		srchPanel_1.add(clearBtn);
		
		Border srchBorder_2 = BorderFactory.createTitledBorder(border, "지번주소가 생각나지 않을때? 시 / 구 / 군 이름을 입력하세요");
		JPanel srchPanel_2 = new JPanel();
		srchPanel_2.setBorder(srchBorder_2);
		srchPanel_2.setLayout(new FlowLayout());
		srchPanel_2.add(srchField_2);
		srchPanel_2.add(srchBtn_2);

		
		JScrollPane scrollTextArea = new JScrollPane(textArea);
		Border textBorder = BorderFactory.createTitledBorder(border, "검색 결과");
		scrollTextArea.setBorder(textBorder);
		
		add(srchPanel_1, BorderLayout.NORTH);
		add(srchPanel_2, BorderLayout.SOUTH);
		add(scrollTextArea, BorderLayout.CENTER);
		
		//NORTH(동/읍/면/리) 검색 버튼
		srchBtn_1.addActionListener(new EventHandler.SearchByDongEventHandler(srchField_1, textArea));
		
		//SOUTH(구/군) 검색 버튼
		srchBtn_2.addActionListener(new EventHandler.SearchByGugunEventHandler(srchField_2, textArea));
		
		//CLEAR 버튼
		clearBtn.addActionListener(new EventHandler.ClearEventHandler(textArea));
		
		//NORTH 검색창에 포커스
		srchField_1.requestFocus();
		
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
}
