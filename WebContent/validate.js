      function validate(funcName) {
    	  const custno = document.querySelector('#custno');
    	  const custname = document.querySelector('#custname');
    	  const phone = document.querySelector('#phone');
    	  const address = document.querySelector('#address');
    	  const joindate = document.querySelector('#joindate');
    	  const grade = document.querySelector('#grade');
    	  const city = document.querySelector('#city');
    	  
     	  if (custno.value === '' || custno.value === '오류') {
    		  alert("회원번호 가져오기에 실패했습니다\n관리자에게 문의해주세요")
    	  } 
    	  if (custname.value === '') {
    		  alert('회원성명이 입력되지 않았습니다')
    		  return
    	  }
    	  if (phone.value === '') {
    		  alert('회원번호가 입력되지 않았습니다\n')
    		  return
    	  } 
    	  if (address.value === '') {
    		  alert('회원주소가 입력되지 않았습니다\n')
    		  return
    	  } 
    	  if (joindate.value === '') {
    		  alert('가입일자가 입력되지 않았습니다\n')
    		  return
    	  } 
    	  if (grade.value === '') {
    		  alert('고객등급이 입력되지 않았습니다\n')
    		  return
    	  } 
    	  if (city.value === '') {
    		  alert('도시코드가 입력되지 않았습니다\n')
    		  return
    	  } 	  
			window[funcName]();
      }