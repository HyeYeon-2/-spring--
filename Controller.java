@Controller
public class EmailController {

	@RequestMapping("sendemail.me")
	@ResponseBody
	public void sendEmail(@RequestParam("mail") String email, @RequestParam("what") String what,
			HttpServletResponse response) throws IOException {
		response.setContentType("application/json; charset=UTF-8");

		String rand = "";
		for (int i = 0; i < 6; i++) {
			rand += (int) (Math.random() * 9 + 1);
		}

		String mailContent = "<div style='text-align: center;'><h1>코드모아 " + what + "이메일 인증</h1>";
		mailContent += "<h3>인증번호를 입력해주세요</h3>";
		mailContent += "<div style='background : #333; color: #ffffff; padding: 15px;'><h5>" + rand
				+ "</h5></div></div>";

		try {
			MimeMessage mail = mailSender.createMimeMessage();
			mail.setSubject("[CodeMoa] 이메일을 인증하세요 ", "utf-8");
			mail.setText(mailContent, "utf-8", "html");
			mail.setFrom(new InternetAddress(mailSender.getUsername()));
			mail.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			mailSender.send(mail);
			response.getWriter().println(rand);
			System.out.println("========================== 전송완료! =============================");
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}
}
