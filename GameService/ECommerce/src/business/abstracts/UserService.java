package business.abstracts;

import java.util.List;

import entities.concretes.User;

public interface UserService {
	void add(User user);
	void add(String email);

	void update(User user);

	void delete(int userId);

	User getUserId(int userId);
	User getUserEmail(String email);

	List<User> getAll();
}
