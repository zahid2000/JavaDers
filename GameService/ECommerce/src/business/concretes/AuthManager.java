package business.concretes;

import business.abstracts.AuthService;
import business.abstracts.UserService;
import core.Utils.TokenValidate;
import core.Utils.emailValidate;
import entities.concretes.LoginDto;
import entities.concretes.User;

public class AuthManager implements AuthService {

	UserService userService;

	public AuthManager(UserService userService) {
		super();
		this.userService = userService;
	}

	@Override
	public void register(User user) {
		if (userValidate(user) && passwordValidate(user.getPassword())
				&& emailValidate.validateWithRegex(user.getEmail())
				&&!userExist(user.getEmail())) {
			userService.add(user);
		}else {
			System.out.println("Kayit tamamlanmadi.");
		}
		
	}

	@Override
	public void verify(User user, String token) {
		if(TokenValidate.tokenValidate(token)) {
			User existUser=userService.getUserEmail(user.getEmail());
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
		User user= userService.getUserEmail(dto.getEmail());
		if(user!=null && user.getPassword().equals(dto.getPassword())) {
			System.out.println("Giris basarili");
		}
		else {
			System.out.println("Kullanici bulunamadi");
		}
	}

	@Override
	public boolean userExist(String email) {
		if(userService.getUserEmail(email)==null) {			
		return false;
		}
		System.out.println("Kullanici mevcut!");
		return true;
	}

	private boolean userValidate(User user) {
		if (user != null && user.getFirstName() != null && user.getLastName() != null && user.getEmail() != null
				&& user.getPassword() != null) {
			return true;
		}
		System.out.println("Kullanici bilgileri zorunludur");
		return false;
	}

	private boolean passwordValidate(String password) {
		if (password.length() >= 6) {
			return true;
		}
		System.out.println("Parola minimum 6 karakter olmali");
		return false;
	}

}
