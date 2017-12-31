package group.dao;

import java.util.List;

import group.entity.Group;
import group.entity.User;

public interface GroupDAO extends BaseDao<Group>{
	public List<Group> findByName(String groupname);
	public List<Group> findByMyOwnGroup(String username);
	//public List<Group> findByMygroup(String username);
}
