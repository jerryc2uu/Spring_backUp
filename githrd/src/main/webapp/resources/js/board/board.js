$(document).ready(function(){
	$('#hbtn').click(function(){
		$(location).attr('href', '/www/main.blp');
	});
	
	$('#obtn').click(function(){
		//$(location).attr('href', '/www/member/logout.blp');	
		$('#vw').val("/www/board/boardList.blp");
		$('#frm').attr('action', '/www/member/logout.blp');
		$('#frm').submit();
	});
	
	$('#lbtn').click(function(){
		$('#vw').val('/www/board/boardList.blp');
		$('#frm').attr('action', '/www/member/login.blp');
		$('#frm').submit();
	});
	
	$('#jbtn').click(function(){
		$(location).attr('href', '/www/member/join.blp');	
	});
	
	$('.pbtn').click(function(){
		//클릭된 버튼 아이디 읽고
		var spage = $(this).attr('id');
		$('#nowPage').val(spage);
		$('#bno').prop('disabled', true);
		
		$('#frm').attr('action', '/www/board/boardList.blp');
		$('#frm').submit();
		
	});
	
	$('.brdList').click(function(){
		
		var sno = $(this).attr('id');
		$('#bno').val(sno);
		
		$('#frm').submit();
	});
	
	//글작성
	$('#wbtn').click(function(){
		$('#frm').attr('action', '/www/board/boardWrite.blp');
		$('#frm').submit();
	});
	
	//리셋
	$('#rbtn').click(function(){
		
		document.frm.reset();

	});
	
	//리스트
	$('#listbtn').click(function(){
		
		$('#frm').attr('action', '/www/board/boardList.blp');
		$('#frm').submit();

	});
	
	$('#filebox').on('change', '.upfile', function(evt){
		var str = $(this).val();
		var index = $(this).index();
		var tmp = $('.upfile');
		var max = tmp.length;
		if(!str){
			$(this).remove();
			$('.picbox').eq(index).remove();
			return;
		}
		var path = URL.createObjectURL(evt.target.files[0]);
		var el = $('.upfile');
		if((index + 1) != el.length){
			$('.infoAvtBox').eq(index).attr('src', path);
		}
		
		if(index == max - 1){
			$('#filebox').append('<input type="file" name="file" class="w3-input w3-border w3-margin-bottom upfile">');
			$('#preview').append('<div class="inblock pdAll10 picbox w3-card"><div class="w3-col w3-border" style="width: 100%; height: 100%; overflow: hidden;">' +
							'<img src="' + path + '" class="infoAvtBox">' + 
						'</div></div>');
		}
		$('#previewbox').css('display', 'block');
	});
	
	$('#wpbtn').click(function(){
		//비어있는 input 태그 비활성화
		$('.upfile').last().prop('disabled', true);
		
		//유효성 검사
		var title = $('#title').val();
		if(!title) {
			$('#title').focus();
			return;
		}
	
		var body = $('#body').val();
		if(!body) {
			$('#body').focus();
			return;
		}
		
		$('#frm').submit();
		
	});
	
	//수정 버튼
	$('#edit').click(function(){
		$('#frm').attr('action', '/www/board/boardEdit.blp');
		$('#frm').submit();
	});
	
	$('.evtPic').click(function(){
		//파일 번호 꺼내
		var sno = $(this).attr('id');
		var el = $(this);
		
		if(confirm("삭제할라우?")) {
			$.ajax({
				url: '/www/board/fileDel.blp',
				type: 'POST',
				dataType: 'json',
				data: {
					fno: sno
				},
				success: function(data){
					if(data.result == 'OK') {
						$(el).remove();
					}
				},
				error: function(){
					alert('### 통신에러 ###');
				}
			});
		}
	});
	
	$('#editProc').click(function(){
		$('.upfile').last().prop('disabled', true);
		
		//수정 여부 검사
		var otitle = $('#otitle').val();
		var obody = $('#obody').val();
		
		var title = $('#title').val();
		var body = $('#body').val();
		
		if(otitle == title) {
			$('#title').prop('disabled', true);
		}
		
		if(obody == body) {
			$('#body').prop('disabled', true);
		}
		
		if(otitle == title && obody == body && $('#filebox > input').length == 1) {
			return;
		}
		
		$('#frm').submit();
	});
	
	//글 삭제 버튼
	$('#dbtn').click(function(){
		$('#frm').attr('action', '/www/board/boardDel.blp');
		$('#frm').submit();
	});
});