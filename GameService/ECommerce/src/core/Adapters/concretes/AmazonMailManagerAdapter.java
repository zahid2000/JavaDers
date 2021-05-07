package core.Adapters.concretes;

import AmazonMailManager.AmazonMailManager;
import core.Adapters.abstracts.MailService;

public class AmazonMailManagerAdapter implements MailService {
private AmazonMailManager amazonMailManager;
	public AmazonMailManagerAdapter() {
	this.amazonMailManager = new AmazonMailManager();
}
	@Override
	public void send(String email, String message) {
		amazonMailManager.send(email, message);
	}

}
