package business.concretes;

import java.util.List;

import business.abstracts.UserService;
import core.Adapters.abstracts.MailService;
import core.Utils.TokenValidate;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService {

	private UserDao userDao;
	private MailService mailService;
	public UserManager(UserDao userDao,MailService mailService) {
		this.userDao = userDao;
		this.mailService=mailService;
	}

	@Override
	public void add(User user) {
		if(userValidate(user)) {
			userDao.add(user);
			mailService.send(user.getEmail(), "Emailini dogrula : "+TokenValidate.createdToken());
			System.out.println( user.getFullName()+" eklendi");
		}
		
	}
	
	@Override
	public void add(String email) {
		User user=new User();
		user.setEmail(email);
		userDao.add(user);
		System.out.println("Kullanici eklendi : "+ user.getEmail());
		mailService.send(email, "Kayit olsunuz. "+user.getEmail()+"Lutfen emailinizi dogrulayin ve bilgileriniz guncelleyin. "+TokenValidate.createdToken() );
	}

	@Override
	public void update(User user) {
		if(userValidate(user)) {
			userDao.update(user);
			System.out.println("User guncellendi");
		}
	}

	@Override
	public void delete(int userId) {
		userDao.delete(userId);
		System.out.println("User silindi");
		
	}

	@Override
	public User getUserId(int userId) {
		return userDao.getUserId(userId);
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		for (User user : userDao.getAll()) {
			System.out.println(user.getFullName()+" "+user.getEmail());
		}
		return userDao.getAll();
	}

	public boolean userValidate(User user) {
		if (user.getFirstName().length()>=2&&user.getLastName().length()>=2) {
			return true;
		}
		System.out.println("kullanici adi ve soyadi minimum 2 kakakter olmali");
		return false;
	}

	@Override
	public User getUserEmail(String email) {
			
		return userDao.getUserEmail(email);
	}


}
