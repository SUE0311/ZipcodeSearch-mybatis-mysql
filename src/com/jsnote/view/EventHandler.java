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
 * ZipcodeFrame ������Ʈ���� �ʿ��� �̺�Ʈ �޼���� ������ EventHandler Ŭ����
 * @author JIJU LEE
 */
public class EventHandler{
	
	//"��/��/��/��"�� �˻��ϴ� ��ư  �̺�Ʈ �ڵ鷯
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
			
			if(dong.equals(""))//�˻�� �Է����� �ʾ��� ��
			{
				textArea.setText("");
				textArea.append("�� �Է��Ͻ� �ܾ �����ϴ�.\n\n�� �˻�â�� ã���ô� �˻�� �Է����ּ���.");
			}else if(list.isEmpty())//�˻��� �ܾ �����ͺ��̽��� �������� ���� ��
			{
				textArea.setText("");
				textArea.append("�� < " + dong + " >" + " �� ��ϵ��� ���� �ܾ��Դϴ�.\n\n�� ������ ��Ȯ�� Ȯ���Ͻþ� �˻����ּ���.");
			}
			else//��Ȯ�� �˻�� �Է����� ��(����)
			{
				textArea.setText("");
				textArea.append("�� < " +dong + " >" + " (��)�� �˻��Ͻ� ����Դϴ�.\n\n");
				for (Zipcode dongList : list) {
					textArea.append(dongList.toString());
		        }
				textArea.append("\n");
				
				srchField_1.setText("");
				srchField_1.requestFocus();
			}
		}
	}
	
	//"��/��"���� �˻��ϴ� ��ư �̺�Ʈ �ڵ鷯
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
				textArea.append("�� �Է��Ͻ� �ܾ �����ϴ�.\n\n�� �˻�â�� ã���ô� �˻�� �Է����ּ���.");
			}else if(list.isEmpty())
			{
				textArea.setText("");
				textArea.append("�� < " + gugun + " >" + " �� ��ϵ��� ���� �ܾ��Դϴ�.\n\n�� ������ ��Ȯ�� Ȯ���Ͻþ� �˻����ּ���.");
			}
			else
			{
				textArea.setText("");
				textArea.append("�� < " +gugun + " >" + " (��)�� �˻��Ͻ� ����Դϴ�.\n\n");
				for (Zipcode gugunList : list) {
					textArea.append(gugunList.toString());
		        }
				textArea.append("\n");
				
				srchField_2.setText("");
				srchField_2.requestFocus();
			}
		}
	}
	
	//���â�� Ŭ�����ϴ��̺�Ʈ �ڵ鷯
	static class ClearEventHandler implements ActionListener
	{
		JTextArea textArea;
		
		public ClearEventHandler(JTextArea area) {
			textArea = area;
		}
		
		public void actionPerformed(ActionEvent e)
		{
			textArea.setText("�� �˻�â�� ã���ô� ���� �ּҸ� �������ּ���.");
		}
	}
}


