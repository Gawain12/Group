package blog.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import blog.service.GroupService;
import blog.service.MemberService;
import blog.entity.User;
import blog.dao.impl.GroupDAO;
import blog.dao.impl.MemberDAO;
import blog.entity.Group;
import blog.entity.Member;

public class GroupController {
	@Resource	
	private GroupService groupservice;
	@Resource	
	private MemberService memberservice;

	
	@RequestMapping(value = "/GroupAdd/{groupname}")//创建组
	public String groupadd(@RequestParam String groupname,HttpServletRequest request,Group group)
	{
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		group.setGroupname(groupname);
		group.setUsername(user.getUsername());
		groupservice.save(group);

		return "/Myowngroup";
	}
	
	/*@RequestMapping(value = "/JoinGroup/{groupname}")//加入小组
	public String joingroup(@RequestParam String groupname,HttpServletRequest request,Member member) {
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		member.setGroupname(groupname);
		member.setMembername(user.getUsername());
		memberservice.save(member);
		return "/my_group";
		
	}*/
	
	@RequestMapping(value = "/GroupDelte/{groupid}")//删除小组
	public String delete(@RequestParam int groupid,HttpServletRequest request,Group group) {
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		group.setGroupid(groupid);
		groupservice.delete(group);
		
		return "/Myowngroup";
	}
	@RequestMapping(value = "/GetAllGroup")//获取全部小组
	public String getAll(List<Group> group3,ModelMap map) {
		group3 = groupservice.findAll();
		map.put("Group3", group3);
		
		return "/main_message";
	}
	@RequestMapping(value = "/Myowngroup")//我的小组和 我创建的小组，group1为我创建的小组，group2为我加入的小组
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
