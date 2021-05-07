package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class InMemoryUserDao implements UserDao {

	List<User> users = new ArrayList<User>();

	public InMemoryUserDao() {
		User user1 = new User(1, "Zahid", "Mamedov", "zahid123@gmail.com","43213341324", true);
		User user2 = new User(2, "Cefer", "Babayev", "cefer1234@gmail.com","12345", true);
		User user3 = new User(3, "Yusif", "Mamedov", "yusif123@gmail.com","1243341", true);
		users.add(user1);
		users.add(user2);
		users.add(user3);
	}

	@Override
	public void add(User user) {
		users.add(user);
		
	}

	@Override
	public void update(User user) {
		User userToUpdate = users.stream().filter(u -> u.getId() == user.getId()).findFirst().orElse(null);

		userToUpdate.setFirstName(user.getFirstName());
		userToUpdate.setLastName(user.getLastName());
		userToUpdate.setEmail(user.getEmail());
		userToUpdate.setVerify(user.isVerify());
		userToUpdate.setPassword(user.getPassword());
	}

	@Override
	public void delete(int userId) {
		User userToUpdate = users.stream().filter(u -> u.getId() == userId).findFirst().orElse(null);
		users.remove(userToUpdate);

	}

	@Override
	public User getUserId(int userId) {

		return users.stream().filter(u -> u.getId() == userId).findFirst().orElse(null);
	}

	@Override
	public User getUserEmail(String email) {
User user=users.stream().filter(u -> u.getEmail() == email).findFirst().orElse(null);
		return user;
	}

	@Override
	public List<User> getAll() {
		return users;
	}

}
