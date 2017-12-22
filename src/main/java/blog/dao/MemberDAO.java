package blog.dao;

import java.util.List;

import blog.entity.Member;
import blog.entity.User;

public interface MemberDAO extends BaseDao<Member>{
	public List<Member> findByName(String membername);
	public List<Member> findAllpeople(String groupname);
}
