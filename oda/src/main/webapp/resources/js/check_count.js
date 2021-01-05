$(document).ready(function(){
	
	if($('#message_count').index()>=0){
		$.ajax({
			url:'../main/check_count.do',
			type:'get',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				$('#message_count').text(data.check_count);
			},
			error:function(){
				$('#loading').hide();//로딩 이미지 감추기
				alert('네트워크 오류 발생');
			}
		});
	}
});



