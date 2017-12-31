package group.dao.impl;

import java.util.List;

import group.entity.Group;
import group.entity.Member;

public class MemberDAO extends BaseDaoImpl<Member> implements group.dao.MemberDAO{
	public List<Member> findByName(String membername) {
		String hql = "from Member a where a.name like '%?%'";
		return super.find(hql, membername);
	}
	public List<Member> findAllpeople(String groupname){
		String hql = "from Member a where a.name like '%?%'";
		return super.find(hql, groupname);
	}
	
}
