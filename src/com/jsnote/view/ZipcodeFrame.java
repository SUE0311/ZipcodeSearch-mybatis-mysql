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
 * Swing ������Ʈ�� ������ ZipcodeFrame
 * - �˻�â(textField) 2��, �˻� ��� â(textArea) 1��
 * * @author JIJU LEE
 */
public class ZipcodeFrame extends JFrame
{
	//"��/��/��/��" �˻� â
	JTextField srchField_1 = new JTextField(20);
	JButton srchBtn_1 = new JButton("�˻�");
	
	//"��/��" �˻� â
	JTextField srchField_2 = new JTextField(20);
	JButton srchBtn_2 = new JButton("�˻�");
	
	//�˻� ��� â
		JTextArea textArea = new JTextArea(30,25);
		
	//�˻� ��� ����� ��ư
	JButton clearBtn = new JButton("�˻� ��� �����");

	public ZipcodeFrame(String title)
	{
		super(title);
		
		setBounds(100, 200, 550, 350);
		setLayout(new BorderLayout());
		
		Border border = BorderFactory.createEtchedBorder();
		
		Border srchBorder_1 = BorderFactory.createTitledBorder(border, "�����ּ� : �� / �� / �� / �� �̸��� �Է��ϼ���");
		JPanel srchPanel_1 = new JPanel();
		srchPanel_1.setBorder(srchBorder_1);
		srchPanel_1.setLayout(new FlowLayout());
		srchPanel_1.add(srchField_1);
		srchPanel_1.add(srchBtn_1);
		srchPanel_1.add(clearBtn);
		
		Border srchBorder_2 = BorderFactory.createTitledBorder(border, "�����ּҰ� �������� ������? �� / �� / �� �̸��� �Է��ϼ���");
		JPanel srchPanel_2 = new JPanel();
		srchPanel_2.setBorder(srchBorder_2);
		srchPanel_2.setLayout(new FlowLayout());
		srchPanel_2.add(srchField_2);
		srchPanel_2.add(srchBtn_2);

		
		JScrollPane scrollTextArea = new JScrollPane(textArea);
		Border textBorder = BorderFactory.createTitledBorder(border, "�˻� ���");
		scrollTextArea.setBorder(textBorder);
		
		add(srchPanel_1, BorderLayout.NORTH);
		add(srchPanel_2, BorderLayout.SOUTH);
		add(scrollTextArea, BorderLayout.CENTER);
		
		//NORTH(��/��/��/��) �˻� ��ư
		srchBtn_1.addActionListener(new EventHandler.SearchByDongEventHandler(srchField_1, textArea));
		
		//SOUTH(��/��) �˻� ��ư
		srchBtn_2.addActionListener(new EventHandler.SearchByGugunEventHandler(srchField_2, textArea));
		
		//CLEAR ��ư
		clearBtn.addActionListener(new EventHandler.ClearEventHandler(textArea));
		
		//NORTH �˻�â�� ��Ŀ��
		srchField_1.requestFocus();
		
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
}
