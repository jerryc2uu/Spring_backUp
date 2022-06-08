$(document).ready(function(){
	//페이징처리
	$('.pbtn').click(function(){
		var sno = $(this).attr('id');
		
		$('#nowPage').val(sno);
		$('#frm').submit();
	});
	
	//홈버튼
	$('#hbtn').click(function(){
		$(location).attr('href', '/www/main.blp');
	});
	
	//로그인
	$('#lbtn').click(function(){
		$(location).attr('href', '/www/member/login.blp');
	});
	
	//회원가입
	$('#jbtn').click(function(){
		$(location).attr('href', '/www/member/join.blp');
	});
	
	//로그아웃
	$('#obtn').click(function(){
		$('#frm').attr('action', '/www/member/logout.blp');
		$('#view').val('/www/reBoard/reBoardList.blp');
		$('#bno').prop('disabled',true);
		$('#frm').submit();
	});
	
	//글작성
	$('#wbtn').click(function(){
		$('#bno').prop('disabled', true);
		$('#view').prop('disabled', true);
		$('#frm').attr('action', '/www/reBoard/reBoardWrite.blp');
		$('#frm').submit();
	});
	
	//리셋
	$('#rbtn').click(function(){
		document.frm.reset();
	});
	
	//리스트
	$('#listbtn').click(function(){
		$('#frm').attr('action', '/www/reBoard/reBoardList.blp');	
		$('#frm').submit();
	});
	
	//글 등록
	$('#wpbtn').click(function(){
		//데이터 유효성 검사
		var txt = $('#body').val();
		
		if(!txt) {
			alert('내용 입력');
			return;
		}
		
		$('#frm').submit();
	});
});