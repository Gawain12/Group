package blog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import blog.dao.MemberDAO;
import blog.entity.Group;
import blog.entity.Member;

@Transactional
@Service
public class MemberService implements blog.service.MemberService{
	@Resource
	private MemberDAO memberdao;
	
	@Override
	public List<Member> findByName(String membername) {
		return memberdao.findByName(membername);
		
	}
	@Override
	public List<Member> findAllpeople(String groupname){
		return memberdao.findAllpeople(groupname);
	}
	@Override
	public List<Member> findAll(){
		return memberdao.findAll();
	}
	
	@Override
	public void update(Member member) {
		memberdao.update(member);
		
	}
	/**
	 * 删除文章
	 */
	@Override
	public void delete(Member member) {
		 memberdao.delete(member);
		
	}
	/**
	 * 添加文章
	 */
	@Override
	public void save(Member member) {
		memberdao.save(member);
	}
}
