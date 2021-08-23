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
 -  /WEB-INF/spring/mail-context.xml

## .jsp에 스크립트 

		$('#send').on('click', function() {
			$('#emailNum').show();

			$.ajax({
				url : 'sendemail.me',
				data : {
					mail : $('#email').val(),
					what : '회원가입'
				},
				success : function(data) {
					console.log(data);
					$('#emailNum').on('keyup blur', function(){
						if(data == $(this).val()){
							$('#email').attr('readonly', true);
							$('#emailNum').hide();
						}
					});
				}
			});
		});

