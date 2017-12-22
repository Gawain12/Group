package blog.dao;

import blog.entity.User;

public interface UserDao extends BaseDao<User>{

	User login(User user);
	User findUser(int i);
	User findByName(String userName);
	void updateUser(User user);
	void updateUserPassword(User user);

}
