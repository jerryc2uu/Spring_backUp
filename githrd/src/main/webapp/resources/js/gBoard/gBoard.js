$(document).ready(function(){
	$('.pbtn').click(function(){
		var sno = $(this).attr('id');
		
		$('#nowPage').val(sno);
		$('#frm').submit();
	});
	
	$('#hbtn').click(function(){
		$(location).attr('href', '/www/main.blp');
	});

	$('#lbtn').click(function(){
		$(location).attr('href', '/www/member/login.blp');
	});	

	$('#jbtn').click(function(){
		$(location).attr('href', '/www/member/join.blp');
	});	
	
	$('#obtn').click(function(){
		$('#frm').attr('action', '/www/member/logout.blp');
		$('#view').val('/www/gBoard/gBoardList.blp');
		$('#frm').submit();
	});	

	$('#wbtn').click(function(){
		$('#frm').attr('action', '/www/gBoard/gBoardWrite.blp');
		$('#frm').submit();
	});
	
	$('#addbtn').click(function(){
		
		var str = $('#body').val();
		
		if(!str) {
			return;
		}
		
		$('#frm').submit();
	});
	
});