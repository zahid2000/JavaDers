package kodlamaio.hrms.core.utilities.adapters.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.adapters.abstracts.EmailService;
import kodlamaio.hrms.googleEmailService.GoogleEmailService;

@Service
public class GoogleEmailServiceAdapter implements EmailService {

	 GoogleEmailService googleEmailService=new GoogleEmailService();
	
	
	@Override
	public void sendEmail(String email) {
		this.googleEmailService.sendEmail(email);
		
	}

}
