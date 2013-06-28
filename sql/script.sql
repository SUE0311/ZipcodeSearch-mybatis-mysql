/*
 * 실행시키기 전, 데이터베이스에 테이블  만들기
 * Database: MySQL
 * SCHEMA 명 : note
 * TABLE 명 : Zipcode
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
 * Zipcode 테이블을 만들 후 sql 폴더에 있는 zipcode_20130201.csv 파일을 데이터베이스에 삽입
 * path/ : 경로를 적을 때 "\" 가 아니라 "/" 임을 유의!
 * LOAD DATA 의 경우 ','을 구분자로 한 데이터를 import시키기 때문에 fields terminated by ','넣어야 함
 * Mysql에서 제공하는 workbench를 이용하는 방법도 있지만, 자꾸 다운되는 경우가 있어 안전하게 sql문으로 삽입
 */
load data local infile 'path/zipcode_20130201.txt' into table Zipcode fields terminated by ',';


/*
 * "txt 파일"을 Mysql에 넣을 수 있도록 "cvs 파일"로 변경하는 TIP!
 * 
 * 우편번호 원본 데이터 출원처 : http://www.zipfinder.co.kr/zipcode/ (우정사업본부)
 * 제공되는 원본 파일 : zipcode_20130201.txt(구분자 tab)
 * 텍스트 파일을 엑셀에서 'cvs파일'로 변경(구분자 ","로 변경 됨)
 * 변경된 csv 파일을 메모장에서 열어 인코딩 "UTF-8"로 꼭 변경해서 저장해야 함! 테이블의 CHARSET과 동일!
 */