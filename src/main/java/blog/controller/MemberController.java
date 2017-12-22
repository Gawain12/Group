package blog.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import blog.entity.Group;
import blog.entity.Member;
import blog.entity.User;
import blog.service.GroupService;
import blog.service.MemberService;

public class MemberController {
	@Resource	
	private GroupService groupservice;
	@Resource	
	private MemberService memberservice;
	
	
	@RequestMapping(value = "/JoinGroup/{groupname}")//加入 小 组
	public String joingroup(@RequestParam String groupname,HttpServletRequest request,Member member) {
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		member.setGroupname(groupname);
		member.setMembername(user.getUsername());
		memberservice.save(member);
		
		return "/my_group";
	}
	@RequestMapping(value = "/OutGroup/{groupname}")//退出 小组
	public String delete(@RequestParam String groupname,HttpServletRequest request,Group group,Member member) {
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		member.setGroupname(groupname);
		member.setMembername(user.getUsername());
		memberservice.delete(member);
		
		return "/my_group";
	}
	@RequestMapping(value = "/GetGroupAllPeople/{groupname}")//查看 小组 成员
	public String getall(@RequestParam String groupname,List<Member> member,ModelMap map) {
		member =memberservice.findAllpeople(groupname);
		map.put("Member", member);
		return "/main_list";
	}
	
}
