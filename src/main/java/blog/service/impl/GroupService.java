package blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import blog.dao.GroupDAO;
import blog.entity.Article;
import blog.entity.Group;

@Transactional
@Service
public class GroupService implements blog.service.GroupService{
	@Resource
	private GroupDAO groupdao;
	
	@Override
	public Group findByid(int i) {
		return groupdao.findById(i);
	}
	
	@Override
	public List<Group> findgroup(String groupname) {
		return groupdao.findByName(groupname);
	}
	
	@Override
	public List<Group> findByMyOwnGroup(String username) {
		return groupdao.findByMyOwnGroup(username);
	}
	
	@Override
	public List<Group> findAll() {
		return groupdao.findAll();
	}
	
  
	@Override
	public void update(Group group) {
		groupdao.update(group);
		
	}
	/**
	 * 删除文章
	 */
	@Override
	public void delete(Group group) {
		groupdao.delete(group);
		
	}
	/**
	 * 添加文章
	 */
	@Override
	public void save(Group group) {
		groupdao.save(group);
	}
	/*@Override
	public List<Group> findMyOwnGroup(String username) {
		return groupdao.findByMygroup(username);
	}*/
}
