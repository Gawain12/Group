package group.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import group.dao.impl.GroupDAO;
import group.dao.impl.MemberDAO;
import group.entity.Group;
import group.entity.Member;
import group.entity.User;
import group.service.GroupService;
import group.service.MemberService;

public class GroupController {
	@Resource	
	private GroupService groupservice;
	@Resource	
	private MemberService memberservice;

	
	@RequestMapping(value = "/GroupAdd/{groupname}")//������
	public String groupadd(@RequestParam String groupname,HttpServletRequest request,Group group)
	{
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		group.setGroupname(groupname);
		group.setUsername(user.getUsername());
		groupservice.save(group);

		return "/Myowngroup";
	}
	
	/*@RequestMapping(value = "/JoinGroup/{groupname}")//����С��
	public String joingroup(@RequestParam String groupname,HttpServletRequest request,Member member) {
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		member.setGroupname(groupname);
		member.setMembername(user.getUsername());
		memberservice.save(member);
		return "/my_group";
		
	}*/
	
	@RequestMapping(value = "/GroupDelte/{groupid}")//ɾ��С��
	public String delete(@RequestParam int groupid,HttpServletRequest request,Group group) {
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		group.setGroupid(groupid);
		groupservice.delete(group);
		
		return "/Myowngroup";
	}
	@RequestMapping(value = "/GetAllGroup")//��ȡȫ��С��
	public String getAll(List<Group> group3,ModelMap map) {
		group3 = groupservice.findAll();
		map.put("Group3", group3);
		
		return "/main_message";
	}
	@RequestMapping(value = "/Myowngroup")//�ҵ�С��� �Ҵ�����С�飬group1Ϊ�Ҵ�����С�飬group2Ϊ�Ҽ����С��
	public String Myowngroup(HttpServletRequest request,List<Group> group1,List<Member> member,ModelMap map) {
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		group1 = groupservice.findByMyOwnGroup(user.getUsername());
		member=memberservice.findByName(user.getUsername());
		map.put("group1", group1);
		map.put("group2", member);
		
		return "/main_message";
	}
	
}
