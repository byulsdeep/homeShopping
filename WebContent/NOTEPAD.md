1. lib - JRE System JDK[JE_11] 잡히지 않아 수동으로 추가. <br>
2. update.jsp 파일의 "조회"를 누를 시 list.html로 이어지는데, 해당 파일이 없어 list.jsp로 href를 고쳐서 코딩함. <br>
  ㄴ 혹시 원래 list.html 파일을 새로 만들어서 구현하도록 설계했다면 주석 요망. <br>
3. webContent에 lib 폴더가 없어서 우리가 따로 임의로 생성 후, jar import함. <br>
  ㄴ 오라클 데이터베이스 버전이 달라서 jdbc.jar을 전부 넣음. <br>
4. JavaScript 부분이 없는데, 이 부분을 백 쪽에서 구현을 해야하는지 주석 요망. <br>
5. 오늘 commit된 내용들처럼 계속해서 진행하면 될지 방향성에 대해 주석 요망. <br>

-- 23.04.02 --
6. 회원매출조회 total을 구하는 곳에서 error
  ㄴ SELECT mem.custno, custname,  grade, SUM(price) as total 
  FROM member_tbl_02 mem, money_tbl_02 mon 
  WHERE mem.custno = mon.custno AND custname = ? 
  GROUP BY custname;
  ㄴ errorLog: "index에서 누락된 in 또는 out 매개변수"; 
7. build/classes 폴더 안에 .java의 .class 파일이 자동생성되지 않음
  ㄴ 임의로 .class 파일을 넣어도 되지 않고, cmd로 컴파일조차 되지 않음
