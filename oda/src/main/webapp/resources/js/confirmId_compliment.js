$(document).ready(function(){
	var checkId = 0;
	
	//아이디 중복 체크
	$('#confirmId').click(function(){
		if($('#com_deli').val()==''){
			$('#message_id').css('color','red').text('아이디를 입력하세요');
			return;
		}
		
		$('#message_id').text(''); //메시지 초기화
		$('#loading').show(); //로딩 이미지 노출
		
		$.ajax({
			url:'../member/confirmId.do',
			type:'post',
			data:{id:$('#com_deli').val()},
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				$('#loading').hide();//로딩 이미지 감추기
				
				if(data.result == 'idNotFound'){
					$('#message_id').css('color','red')
					                .text('존재하지 않는 배달자');
					checkId = 0;
				}else if(data.result == 'idDuplicated'){
					$('#message_id').css('color','#000')
	                                .text('등록가능 배달자');
					$('#id').val('').focus();
	                checkId = 1;
				}else if(data.result == 'notMatchPattern'){
					$('#message_id').css('color','red')
                                    .text('영문,숫자 4~10자로 입력');
					$('#id').val('').focus();
					checkId = 0;
				}else{
					alert('ID 존재확인 오류');
				}
			},
			error:function(){
				$('#loading').hide();//로딩 이미지 감추기
				alert('네트워크 오류 발생');
			}
		});
	});
	
	//아이디 중복 안내 메시지 초기화 및 아이디 중복 값 초기화
	$('#register_form #com_deli').keydown(function(){
		checkId=0;
		$('#message_id').text('');
	});
	
	//submit 이벤트 발생시 아이디 중복 체크 여부 확인
	$('#register_form').submit(function(){
		if(checkId==0){
			$('#message_id').css('color','red').text('아이디 확인 필수!');
			if($('#com_deli').val()==''){
				$('#com_deli').focus();
			}
			return false;
		}
	});
});



