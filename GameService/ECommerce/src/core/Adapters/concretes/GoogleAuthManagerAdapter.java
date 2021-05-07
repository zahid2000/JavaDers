package core.Adapters.concretes;

import business.abstracts.UserService;
import core.Adapters.abstracts.ExternalAuthService;
import core.Utils.TokenValidate;
import entities.concretes.LoginDto;
import entities.concretes.User;

public class GoogleAuthManagerAdapter implements ExternalAuthService {

	private UserService userService;

	public GoogleAuthManagerAdapter(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void register(String email) {
		if(!userExist(email)) {
		userService.add(email);
		}
		else {
			User existUser=userService.getUserEmail(email);
			LoginDto dto=new LoginDto(email, existUser.getPassword());
					login(dto);
		}
	}

	@Override
	public void verify(String email, String token) {
		if(TokenValidate.tokenValidate(token)) {
			User existUser=userService.getUserEmail(email);
			existUser.setVerify(true);
			userService.update(existUser);
			System.out.println("Email dogrualdni");
		}
		else {
			System.out.println("Email dogrulanamdi");
		}

	}

	@Override
	public void login(LoginDto dto) {
		System.out.println("Giris basarili : "+dto.getEmail());
	}

	@Override
	public boolean userExist(String email) {
		if(userService.getUserEmail(email)==null) {			
			return false;
			}
			System.out.println("Kullanici mevcut!");
			return true;
	}

}
