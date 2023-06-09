--DROP TABLE MEMBER_TBL_02 CASCADE CONSTRAINTS;
--DROP TABLE MONEY_TBL_02 CASCADE CONSTRAINTS;
--DROP PUBLIC SYNONYM MEM;
--DROP PUBLIC SYNONYM MONEY;
--DROP SEQUENCE CUSTNO_SEQ;
--DROP SEQUENCE SALENOL_SEQ;

CREATE TABLE MEMBER_TBL_02(
CUSTNO NUMBER(6) PRIMARY KEY NOT NULL,
CUSTNAME NVARCHAR2(20),
PHONE NVARCHAR2(13),
ADDRESS NVARCHAR2(60),
JOINDATE DATE,
GRADE NCHAR(1),
CITY NCHAR(2)
);
CREATE PUBLIC SYNONYM MEM FOR MEMBER_TBL_02;

CREATE SEQUENCE CUSTNO_SEQ
START WITH 100001
INCREMENT BY 1
NOCACHE;

CREATE TABLE MONEY_TBL_02(
CUSTNO NUMBER(6) NOT NULL,
SALENOL NUMBER(8) NOT NULL,
PCOST NUMBER(8),
AMOUNT NUMBER(4),
PRICE NUMBER(8),
PCODE NVARCHAR2(4),
SDATE DATE,
PRIMARY KEY(
CUSTNO, SALENOL),
FOREIGN KEY(
CUSTNO)
REFERENCES MEMBER_TBL_02 (CUSTNO)
);
CREATE PUBLIC SYNONYM MONEY FOR MONEY_TBL_02;

CREATE SEQUENCE SALENOL_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE;

INSERT INTO MEMBER_TBL_02(CUSTNO, CUSTNAME, PHONE, ADDRESS, JOINDATE, GRADE, CITY) VALUES(CUSTNO_SEQ.NEXTVAL, '김행복', '010-1111-2222', '서울 동대문구 휘경1동', TO_DATE('20151202', 'YYYYMMDD'), 'A', '01');
INSERT INTO MEMBER_TBL_02(CUSTNO, CUSTNAME, PHONE, ADDRESS, JOINDATE, GRADE, CITY) VALUES(CUSTNO_SEQ.NEXTVAL, '이축복', '010-1111-3333', '서울 동대문구 휘경2동', TO_DATE('20151206', 'YYYYMMDD'), 'B', '01');
INSERT INTO MEMBER_TBL_02(CUSTNO, CUSTNAME, PHONE, ADDRESS, JOINDATE, GRADE, CITY) VALUES(CUSTNO_SEQ.NEXTVAL, '장믿음', '010-1111-4444', '울릉군 울릉읍 독도1리', TO_DATE('20151001', 'YYYYMMDD'), 'B', '30');
INSERT INTO MEMBER_TBL_02(CUSTNO, CUSTNAME, PHONE, ADDRESS, JOINDATE, GRADE, CITY) VALUES(CUSTNO_SEQ.NEXTVAL, '최사랑', '010-1111-5555', '울릉군 울릉읍 독도2리', TO_DATE('20151113', 'YYYYMMDD'), 'A', '30');
INSERT INTO MEMBER_TBL_02(CUSTNO, CUSTNAME, PHONE, ADDRESS, JOINDATE, GRADE, CITY) VALUES(CUSTNO_SEQ.NEXTVAL, '진평화', '010-1111-6666', '제주도 제주시 외나무골', TO_DATE('20151225', 'YYYYMMDD'), 'B', '60');
INSERT INTO MEMBER_TBL_02(CUSTNO, CUSTNAME, PHONE, ADDRESS, JOINDATE, GRADE, CITY) VALUES(CUSTNO_SEQ.NEXTVAL, '차공단', '010-1111-7777', '제주도 제주시 감나무골', TO_DATE('20151211', 'YYYYMMDD'), 'C', '60');

INSERT INTO MONEY_TBL_02(CUSTNO, SALENOL, PCOST, AMOUNT, PRICE, PCODE, SDATE) VALUES(100001, '2016' || LPAD(SALENOL_SEQ.NEXTVAL, 4, '0'), 500, 5, 2500, 'A001', TO_DATE('20160101', 'YYYYMMDD'));
INSERT INTO MONEY_TBL_02(CUSTNO, SALENOL, PCOST, AMOUNT, PRICE, PCODE, SDATE) VALUES(100001, '2016' || LPAD(SALENOL_SEQ.NEXTVAL, 4, '0'), 1000, 4, 4000, 'A002', TO_DATE('20160101', 'YYYYMMDD'));
INSERT INTO MONEY_TBL_02(CUSTNO, SALENOL, PCOST, AMOUNT, PRICE, PCODE, SDATE) VALUES(100001, '2016' || LPAD(SALENOL_SEQ.NEXTVAL, 4, '0'), 500, 3, 1500, 'A008', TO_DATE('20160101', 'YYYYMMDD'));
INSERT INTO MONEY_TBL_02(CUSTNO, SALENOL, PCOST, AMOUNT, PRICE, PCODE, SDATE) VALUES(100002, '2016' || LPAD(SALENOL_SEQ.NEXTVAL, 4, '0'), 2000, 1, 2000, 'A004', TO_DATE('20160102', 'YYYYMMDD'));
INSERT INTO MONEY_TBL_02(CUSTNO, SALENOL, PCOST, AMOUNT, PRICE, PCODE, SDATE) VALUES(100002, '2016' || LPAD(SALENOL_SEQ.NEXTVAL, 4, '0'), 500, 1, 500, 'A001', TO_DATE('20160103', 'YYYYMMDD'));
INSERT INTO MONEY_TBL_02(CUSTNO, SALENOL, PCOST, AMOUNT, PRICE, PCODE, SDATE) VALUES(100003, '2016' || LPAD(SALENOL_SEQ.NEXTVAL, 4, '0'), 1500, 2, 3000, 'A003', TO_DATE('20160103', 'YYYYMMDD'));
INSERT INTO MONEY_TBL_02(CUSTNO, SALENOL, PCOST, AMOUNT, PRICE, PCODE, SDATE) VALUES(100004, '2016' || LPAD(SALENOL_SEQ.NEXTVAL, 4, '0'), 500, 2, 1000, 'A001', TO_DATE('20160104', 'YYYYMMDD'));
INSERT INTO MONEY_TBL_02(CUSTNO, SALENOL, PCOST, AMOUNT, PRICE, PCODE, SDATE) VALUES(100004, '2016' || LPAD(SALENOL_SEQ.NEXTVAL, 4, '0'), 300, 1, 300, 'A005', TO_DATE('20160104', 'YYYYMMDD'));
INSERT INTO MONEY_TBL_02(CUSTNO, SALENOL, PCOST, AMOUNT, PRICE, PCODE, SDATE) VALUES(100004, '2016' || LPAD(SALENOL_SEQ.NEXTVAL, 4, '0'), 600, 1, 600, 'A006', TO_DATE('20160104', 'YYYYMMDD'));
INSERT INTO MONEY_TBL_02(CUSTNO, SALENOL, PCOST, AMOUNT, PRICE, PCODE, SDATE) VALUES(100004, '2016' || LPAD(SALENOL_SEQ.NEXTVAL, 4, '0'), 3000, 1, 3000, 'A007', TO_DATE('20160106', 'YYYYMMDD'));

COMMIT;
--SELECT * FROM MEM;
--SELECT * FROM MONEY;
