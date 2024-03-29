package group.service;

import java.util.List;

import group.entity.User;

public interface UserService {

	User login(User user);

	User findUser(int i);
	
	User findUserByName(String userName);

	void updateUser(User user);
	
	void saveUser(User user);

	void updateUserPassword(User user);

	List<User> findAllUser();
}
