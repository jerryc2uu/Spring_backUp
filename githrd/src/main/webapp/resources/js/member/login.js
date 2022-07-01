$(document).ready(function(){
	$('#lbtn').click(function(){
		$('#frm').attr('action', '/www/member/loginProc.blp');
		$('#frm').submit();
	});
	
	//js는 자바스크립트로 쓰이며 컴파일하지 않는 파일이라 el 사용 불가능
	
	//홈버튼
	$('#hbtn').click(function(){
		$(location).attr('href', '/www/main.blp');
	});
});
