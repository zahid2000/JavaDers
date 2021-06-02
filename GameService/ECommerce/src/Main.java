import java.util.Scanner;

import business.concretes.AuthManager;
import business.concretes.UserManager;
import core.Adapters.abstracts.MailService;
import core.Adapters.concretes.AmazonMailManagerAdapter;
import dataAccess.abstracts.UserDao;
import dataAccess.concretes.InMemoryUserDao;
import entities.concretes.LoginDto;
import entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		UserDao dao = new InMemoryUserDao();

		MailService mailService = new AmazonMailManagerAdapter();

		UserManager userManager = new UserManager(dao, mailService);

		AuthManager authManager = new AuthManager(userManager);
		User user=new User();
		LoginDto dto=new LoginDto();
		
		while(true) {
			System.out.println("1 kullanıcı bilgilerini gir");
			System.out.println("2 kullanıcının kaydını yaptır");
			System.out.println("3 Emaili dogrula");
			System.out.println("4 login ol");
			System.out.println("5  tüm kullanıcıları getir");
			System.out.println("0 programı söndür");
			
			Scanner myObj = new Scanner(System.in);
			int say=myObj.nextInt();
			
			if(say==1) {
				  user = createUser(myObj);
			}
			if(say==2) {
				authManager.register(user);
			}
			if(say==3) {
				verifyEmail(authManager, myObj, user);
			}
			if(say==4) {
				dto=new LoginDto(user.getEmail(),user.getPassword());
				authManager.login(dto);
			}
			if(say==5) {
				getAllUser(userManager);
			}
			if(say==0) {
				System.out.println("Tebrikler!!!!");
				break;
			}
			
			
			
		}
		

	}

	private static User createUser(Scanner myObj) {
		System.out.println("Kullanici id - sini gir");
		int id = myObj.nextInt();

		System.out.println("Kullanici ismini gir");
		String firstName = myObj.next();

		System.out.println("Kullanici soyadini gir");
		String lastName = myObj.next();

		System.out.println("Kullanici ePostasini gir");
		String email = myObj.next();

		System.out.println("Kullanici parolasini gir");
		String password = myObj.next();

		User user = new User(id, firstName, lastName, email, password, false);
		System.out.println("id : "+user.getId()+" Full Name : "+user.getFullName()+" Email : "+ user.getEmail()+" Password : "+user.getPassword());
		System.out.println();
		return user;
	}

	private static void verifyEmail(AuthManager authManager, Scanner myObj, User user) {
		System.out.println("Emailini dogrulama tokenini gir");
		String token = myObj.next();
		authManager.verify(user, token);
		System.out.println();
	}

	private static void getAllUser(UserManager userManager) {
		System.out.println("Kullanicilar");
		userManager.getAll();
		System.out.println();
	}

}
