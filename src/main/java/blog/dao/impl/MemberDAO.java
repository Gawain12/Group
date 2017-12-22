package blog.dao.impl;

import java.util.List;

import blog.entity.Group;
import blog.entity.Member;

public class MemberDAO extends BaseDaoImpl<Member> implements blog.dao.MemberDAO{
	public List<Member> findByName(String membername) {
		String hql = "from Member a where a.name like '%?%'";
		return super.find(hql, membername);
	}
	public List<Member> findAllpeople(String groupname){
		String hql = "from Member a where a.name like '%?%'";
		return super.find(hql, groupname);
	}
	
}
