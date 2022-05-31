$(document).ready(function(){
	$('#lbtn').click(function(){
		$('#frm').attr('action', '/www/member/loginProc.blp');
		$('#frm').submit();
	});
});
