package business.abstracts;

import entities.concretes.LoginDto;
import entities.concretes.User;

public interface AuthService {
void register(User user);
void verify(User user,String token);
void login(LoginDto dto);
boolean userExist(String email);
}
