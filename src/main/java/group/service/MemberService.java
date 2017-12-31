package group.service;

import java.util.List;

import group.entity.Member;

public interface MemberService {
	 List<Member> findAll();
	 List<Member> findAllpeople(String groupname);
	 public List<Member> findByName(String membername);
	 public void update(Member member);
	 public void delete(Member member);
	 public void save(Member member) ;
}
