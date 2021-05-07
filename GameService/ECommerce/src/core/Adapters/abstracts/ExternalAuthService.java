package core.Adapters.abstracts;

import entities.concretes.LoginDto;


public interface ExternalAuthService {
	void register(String email);
	void verify(String email,String token);
	void login(LoginDto dto);
	boolean userExist(String email);
}
