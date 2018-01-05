package group.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import group.dao.GroupDAO;
import group.entity.Group;
import group.util.PageBean;

@Transactional
@Service
public class GroupService implements group.service.GroupService{
	@Resource
	private GroupDAO groupDao;

	@Override
	public PageBean<Group> findAll(Integer currPage) {
		PageBean<Group> pageBean = new PageBean<Group>();
		// 封装当前页数
		pageBean.setCurrPage(currPage);
		// 封装每页记录数
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		// 封装总记录数
		int totalCount = groupDao.findCount();
		pageBean.setTotalCount(totalCount);
		// 封装页数
		int totalPage;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 封装当前页记录
		int begin = (currPage - 1) * pageSize;
		List<Group> list = groupDao.findAll(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	@Override
	public Group findByid(int i) {
		return groupDao.findById(i);
	}
	
	@Override
	public List<Group> findgroup(String groupname) {
		return groupDao.findByName(groupname);
	}
	
	@Override
	public List<Group> findByMyOwnGroup(String username) {
		return groupDao.findByMyOwnGroup(username);
	}
	
	@Override
	public List<Group> findAll() {
		return groupDao.findAll();
	}
	
  
	@Override
	public void update(Group group) {
		groupDao.update(group);
		
	}
	/**
	 * 删除文章
	 */
	@Override
	public void delete(Group group) {
		groupDao.delete(group);
		
	}
	/**
	 * 添加文章
	 */
	@Override
	public void save(Group group) {
		groupDao.save(group);
	}
	@Override
	public void addGroup(Group group, int userid) {
		this.groupDao.addGroup(group, userid);
	}
	@Override
	public List<Group> findByUserid(int userid) {
		List<Group> list = groupDao.findByUserid(userid);
		return list;
	}
	/*@Override
	public List<Group> findMyOwnGroup(String username) {
		return groupdao.findByMygroup(username);
	}*/
}
