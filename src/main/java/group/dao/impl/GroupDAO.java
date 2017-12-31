package group.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import group.entity.Group;

@Repository
public class GroupDAO extends BaseDaoImpl<Group> implements group.dao.GroupDAO{
	public List<Group> findByName(String groupname) {
		String hql = "from Group a where a.name like '%?%'";
		return super.find(hql, groupname);
	}
	
	public List<Group> findByMyOwnGroup(String username){
		String hql = "from Group a where a.name like '%?%'";
		return super.find(hql, username);
	}

	
}
