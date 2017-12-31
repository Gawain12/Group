package group.dao;

import java.util.List;

import group.entity.Member;
import group.entity.User;

public interface MemberDAO extends BaseDao<Member>{
	public List<Member> findByName(String membername);
	public List<Member> findAllpeople(String groupname);
}
