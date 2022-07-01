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
	
	//로그인 (get방식으로)
	$('#lbtn').click(function(){
		$(location).attr('href', '/www/member/login.blp?vw=/www/reBoard/reBoardList.blp&nowPage=' + $('#nowPage').val());
	});
	
	//회원가입
	$('#jbtn').click(function(){
		$(document.frm).attr('action', '/www/member/join.blp');
		$('#frm').submit();
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
	
	//댓글
	$('.comment').click(function(){
		
		var sno = $(this).parent().attr('id');
		$('#bno').val(sno);
		
		$('#frm').attr('action', '/www/reBoard/commentWrite.blp');
		$('#frm').submit();
	});
	
	//댓글 등록
	$('#cmtbtn').click(function(){
		
		var txt = $('#body').val();
		if(!txt) {
			return;
		}
		
		$('#frm').attr('action', '/www/reBoard/commentProc.blp');
		$('#frm').submit();
	});
	
	//글 수정 버튼
	$('.editbtn').click(function(){
		var sno = $(this).parent().attr('id');
		
		$('#bno').val(sno);
		$('#frm').attr('action', '/www/reBoard/reBoardEdit.blp');
		$('#frm').submit();
	});
	
	//글 수정 등록
	$('#editbtn').click(function(){
		//태그 내용 읽고
		var oritxt = $('#obody').val();
		var txt = $('#body').val();
		
		if(oritxt == txt) {
			alert('### 수정된 내용이 없어요 ###');
			return;
		}
		
		$('#frm').submit();			
	});
	
	$('.delbtn').click(function(){
		var sno = $(this).parent().attr('id');
		$('#bno').val(sno);
		$('#frm').attr('action', '/www/reBoard/delReBoard.blp');
		$('#frm').submit();
	});
});