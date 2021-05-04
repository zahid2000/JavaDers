package Concrete;

import Abstract.GamerCheckService;
import Abstract.UserService;
import Entity.Concrete.User;

public class UserManager implements UserService {

	@Override
	public void add(User user) {
		System.out.println(user.getFirstName()+" isimli kullanici eklendi");
	}

	@Override
	public void update(User user) {
		System.out.println(user.getFirstName()+" isimli kullanici guncellendi");

	}

	@Override
	public void delete(User user) {
		System.out.println(user.getFirstName()+" isimli kullanici silindi");

	}

}
