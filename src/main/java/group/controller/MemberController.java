package group.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import group.entity.Group;
import group.entity.Member;
import group.entity.User;
import group.service.GroupService;
import group.service.MemberService;

public class MemberController {
	@Resource	
	private GroupService groupservice;
	@Resource	
	private MemberService memberservice;
	
	
	@RequestMapping(value = "/JoinGroup/{groupname}")//���� С ��
	public String joingroup(@RequestParam String groupname,HttpServletRequest request,Member member) {
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		member.setGroupname(groupname);
		member.setMembername(user.getUsername());
		memberservice.save(member);
		
		return "/my_group";
	}
	@RequestMapping(value = "/OutGroup/{groupname}")//�˳� С��
	public String delete(@RequestParam String groupname,HttpServletRequest request,Group group,Member member) {
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		member.setGroupname(groupname);
		member.setMembername(user.getUsername());
		memberservice.delete(member);
		
		return "/my_group";
	}
	@RequestMapping(value = "/GetGroupAllPeople/{groupname}")//�鿴 С�� ��Ա
	public String getall(@RequestParam String groupname,List<Member> member,ModelMap map) {
		member =memberservice.findAllpeople(groupname);
		map.put("Member", member);
		return "/main_list";
	}
	
}
