package group.service;

import java.util.List;

import group.entity.Group;

public interface GroupService {
	public List<Group> findgroup(String groupname);
	
	public List<Group> findByMyOwnGroup(String username);
	public Group findByid(int i);
	public void update(Group group);
	public void delete(Group group);
	public void save(Group group);
	public List<Group> findAll();
}
