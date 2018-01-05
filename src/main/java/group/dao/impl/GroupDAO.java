package group.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import group.entity.Group;
import group.entity.User;

@Repository
public class GroupDAO extends BaseDaoImpl<Group> implements group.dao.GroupDAO{
	@Autowired
    private SessionFactory sessionFactory;
	public List<Group> findByName(String groupname) {
		String hql = "from Group a where a.name like '%?%'";
		return super.find(hql, groupname);
	}
	
	public List<Group> findByMyOwnGroup(String username){
		String hql = "from Group a where a.name like '%?%'";
		return super.find(hql, username);
	}

	

@SuppressWarnings("unchecked")
@Override
public List<Group> findByUserid(int userid){

	String hql ="from Group u where u.user.userid=:userid";
    Query query = sessionFactory.getCurrentSession().createQuery(hql);  
    query.setParameter("userid", userid);
    return query.list(); 
}
@Override
public void addGroup(Group group, int userid) {
	User user = (User) sessionFactory.getCurrentSession().load(User.class, new Integer(userid));
	group.setUser(user);
	sessionFactory.getCurrentSession().save(group);
}
}