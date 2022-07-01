$(document).ready(function(){
	$('#msgClose').click(function(){
		$('#msgWin').css('display', 'none');
		
		$.ajax({
			url: '/www/mainMsgCheck.blp',
			type: 'post',
			dataType: 'json',
			success: function(data) {
				if(data.result == 'OK') {
					//처리 성공
					$('#msgWin').remove();		
				}
			},
			error: function(){
				alert('#### 통신에러 ####');
			}
		});
	});
	
	//로그인 버튼
	$('#lbtn').click(function(){
		$(location).attr('href', '/www/member/login.blp');
	});

	//로그아웃 버튼
	$('#obtn').click(function(){
		$(location).attr('href', '/www/member/logout.blp');
	});
	
	//join 버튼
	$('#jbtn').click(function(){
		$(location).attr('href', '/www/member/join.blp');		
	});
		
	//내정보 버튼
	$('#ibtn').click(function(){
		$('#frm').attr('action', '/www/member/myInfo.blp');
		$('#frm').submit();
	});
	
	//회원 목록 버튼
	$('#mlbtn').click(function(){
		$(location).attr('href', '/www/member/memberList.blp');
	});
	
	//방명록 버튼
	$('#gbtn').click(function(){
		$(location).attr('href', '/www/gBoard/gBoardList.blp');
	});
	
	//댓글 게시판 버튼
	$('#rbtn').click(function(){
		$(location).attr('href', '/www/reBoard/reBoardList.blp');
	});
	
	//설문조사 버튼
	$('#sbtn').click(function(){
		$('#frm').attr('action', '/www/survey/surveyInfo.blp');
		$('#frm').submit();
	});
	
	//댓글 쓰기 버튼
	
	//파일 게시판 버튼
	$('#fbtn').click(function(){
		$(location).attr('href', '/www/board/boardList.blp');
	});
	
	//사원페이지
	$('#emp').click(function(){
		$(location).attr('href', '/www/emp/empPage.blp');
	});
});