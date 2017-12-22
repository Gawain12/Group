package blog.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import blog.entity.User;

@Repository
public class UserDAO extends BaseDaoImpl<User> implements blog.dao.UserDao {
	public User login(User user) {
		String hql = "from User where username=? and password=?";
		@SuppressWarnings("unchecked")
		List<User> userList =  (List<User>) super.hibernateTemplate.find(hql,user.getUsername(),user.getPassword());
		if(userList.size()>0){
			//
			System.out.println(userList.get(0).getUsername()+"鏌ユ壘鎴愬姛");
			return userList.get(0);
		}
		return null;
	}
	
	public User findUser(int i) {
		return super.findById(i);
	}
   /**
    * 
    */
	public void updateUser(User user) {
		super.update(user);		
	}

    /**
     * 
     */
	public void updateUserPassword(User user) {
		User u = super.hibernateTemplate.get(User.class, user.getUserid());
		u.setPassword(user.getPassword());
		u.setUsername(user.getUsername());
		super.update(u);		
	}
	
    /*
     * 
     */
	public User findByName(String userName) {
		String hql = "from User where username=?";
		@SuppressWarnings("unchecked")
		List<User> userList =  (List<User>) super.hibernateTemplate.find(hql, userName);
		if(userList.size() > 0){
			// 
			System.out.println(userList.get(0).getUsername()+"鏌ユ壘鎴愬姛");
			return userList.get(0);
		}
		return null;
	}
	
}
