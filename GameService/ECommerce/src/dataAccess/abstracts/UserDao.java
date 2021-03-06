package dataAccess.abstracts;

import java.util.List;

import entities.concretes.User;

public interface UserDao {
void add(User user);
void update(User user);
void delete(int userId);
User getUserId(int userId);
User getUserEmail(String email);
List<User> getAll();
}
