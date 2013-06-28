/*
 * �����Ű�� ��, �����ͺ��̽��� ���̺�  �����
 * Database: MySQL
 * SCHEMA �� : note
 * TABLE �� : Zipcode
 */

DROP SCHEMA IF EXISTS `jsnote`;
CREATE SCHEMA IF NOT EXISTS `jsnote`;
USE `jsnote`;

DROP TABLE IF EXISTS `jsnote`.`Zipcode`;

CREATE  TABLE `jsnote`.`Zipcode` (
  `ZIPCODE` char(7) NOT NULL ,
  `SIDO` char(4) NOT NULL ,
  `GUGUN` char(17) NOT NULL ,
  `DONG` char(26) NULL ,
  `RI` char(15) NULL ,
  `BLDG` char(42) NULL ,
  `BUNJI` char(17) NULL ,
  `SEQ` char(5) NULL ,
  PRIMARY KEY (`ZIPCODE`)
) 
ENGINE=InnoDB  DEFAULT CHARSET = utf8;


/*
 * Zipcode ���̺��� ���� �� sql ������ �ִ� zipcode_20130201.csv ������ �����ͺ��̽��� ����
 * path/ : ��θ� ���� �� "\" �� �ƴ϶� "/" ���� ����!
 * LOAD DATA �� ��� ','�� �����ڷ� �� �����͸� import��Ű�� ������ fields terminated by ','�־�� ��
 * Mysql���� �����ϴ� workbench�� �̿��ϴ� ����� ������, �ڲ� �ٿ�Ǵ� ��찡 �־� �����ϰ� sql������ ����
 */
load data local infile 'path/zipcode_20130201.txt' into table Zipcode fields terminated by ',';


/*
 * "txt ����"�� Mysql�� ���� �� �ֵ��� "cvs ����"�� �����ϴ� TIP!
 * 
 * �����ȣ ���� ������ ���ó : http://www.zipfinder.co.kr/zipcode/ (�����������)
 * �����Ǵ� ���� ���� : zipcode_20130201.txt(������ tab)
 * �ؽ�Ʈ ������ �������� 'cvs����'�� ����(������ ","�� ���� ��)
 * ����� csv ������ �޸��忡�� ���� ���ڵ� "UTF-8"�� �� �����ؼ� �����ؾ� ��! ���̺��� CHARSET�� ����!
 */