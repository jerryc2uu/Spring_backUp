$(document).ready(function(){

	//홈버튼
	$('#hbtn').click(function(){
		$(location).attr('href', '/www/');
	});
	
	//회원 목록 버튼
	$('.lbtn').click(function(){
		//어떤 회원 번호가 클릭됐는지 알아내고
		var sno = $(this).attr('id');
		//입력 태그에 데이터 심고
		$('#mno').val(sno);
		//폼 전송
		$('#frm').submit();
	});
	
});