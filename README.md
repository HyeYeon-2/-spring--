# -spring- Ajax 이메일 인증 -

## pom.xml

<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-mail -->
		<dependency>
		    <groupId>org.springframework.boot</groupId>
		    <artifactId>spring-boot-starter-mail</artifactId>
		    <version>2.2.6.RELEASE</version>
		</dependency>

## mail-context.xml 생성

## web.xml에 mail-context.xml 등록
 - 상단에 넣어줌(경로 맞추기)
	 	<context-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>
				classpath:root-context.xml
				/WEB-INF/spring/mail-context.xml		
			</param-value>
		</context-param>

## .jsp에 스크립트 

		$('#send').on('click', function() {
			$('#emailNum').show();

			$.ajax({
				url : 'sendemail.me',
				data : {
					mail : $('#email').val(),
					what : '회원가입' // 메일 전송시 '~~ 메일입니다.' 상황에 맞게 문구 변경
				},
				success : function(data) {
					console.log(data);
					$('#emailNum').on('keyup blur', function(){
						if(data == $(this).val()){
							$('#email').attr('readonly', true); // 이메일인증이 완료되면 readonly로 변경하여 수정 X
							$('#emailNum').hide();
						}
					});
				}
			});
		});

