package group.service.impl;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import group.dao.UserDao;
import group.entity.User;

@Transactional
@Service
public class UserService implements group.service.UserService{
	@Resource
	private UserDao userDao;
	
	@Override
	public User login(User user) {
		return userDao.login(user);
	}
	
	@Override
	public User findUser(int i) {
		return userDao.findById(i);
	}
	@Override
	public void updateUser(User user) {
		userDao.update(user);
	}
	@Override
	public void saveUser(User user) {
		userDao.save(user);
	}
	
	@Override
	public void updateUserPassword(User user) {
		userDao.updateUserPassword(user);
	}
	@Override
	public List<User> findAllUser() {
		return userDao.findAll();
	}
	@Override
	public User findUserByName(String userName) {
		return userDao.findByName(userName);
	}
}
