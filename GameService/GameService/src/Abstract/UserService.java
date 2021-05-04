package Abstract;

import Entity.Concrete.User;

public interface UserService {
	void add(User user);
	void update(User user);
	void delete(User user);
}
