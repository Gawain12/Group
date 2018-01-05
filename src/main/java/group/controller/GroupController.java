package group.controller;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import group.dao.impl.GroupDAO;
//import group.dao.impl.MemberDAO;
import group.entity.Group;
///import group.entity.Member;
import group.entity.User;
import group.service.GroupService;
//import group.service.MemberService;
import group.util.PageBean;


@Controller
public class GroupController {
	@Resource	
	private GroupService groupService;
	/*@Resource	
	private MemberService memberService;*/

	
	
/*	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String Login() {
		return "/login";
	}*/
	
  /*@RequestMapping(value = "/JoinGroup/{groupname}")//����С��
	public String joingroup(@RequestParam String groupname,HttpServletRequest request,Member member) {
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		member.setGroupname(groupname);
		member.setMembername(user.getUsername());
		memberService.save(member);
		return "/my_group";
	}*/
	@RequestMapping(value = "/doPublishG",method = RequestMethod.GET)
	public String findAllGroup(){
		
		return "/c_group";
	}
	@RequestMapping(value = "/GroupDelte/{groupid}")//ɾ��С��
	public String delete(@RequestParam int groupid,HttpServletRequest request,Group group) {
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		group.setId(groupid);
		groupService.delete(group);
		
		return "/Myowngroup";
	}

	@RequestMapping(value = "/Myowngroup")
	public String findMyGroup(HttpServletRequest req,Model model){ //
	
		// 查询当前展示页所有信息

		User loginUser = (User) req.getSession().getAttribute("username");

		List<Group> listGroup = groupService.findByUserid(loginUser.getUserid());
		//PageBean<Article> listArticle = articleService.findAll(currPage);
		// 查询所有分类
		model.addAttribute("listGroup", listGroup);
		 //System.out.println(listArticle.getCurrPage()+":"+listArticle.getTotalCount()+":"+listArticle.getList().get(0).getContent());
		return "/my_group";
	}
	@RequestMapping(value = "/GetAllGroup")
	public String findAllArticle(@RequestParam int currPage,Model model){ //
		if(currPage<1){
		   	currPage = 1;
		}
		// 查询当前展示页所有信息
		PageBean<Group> listGroup = groupService.findAll(currPage);
		// 查询所有分类
		// 值存储，绑定到request上
		model.addAttribute("listGroup", listGroup);
		System.out.println(listGroup.getCurrPage()+":"+listGroup.getTotalCount()+":"+listGroup.getList().get(0).getName());
		return "/A_group";
	}
	@RequestMapping(value = "/GroupAdd")//������
	public String groupadd(@RequestParam String name,HttpServletRequest request,Group group)
	{
		try { 
		User loginUser = (User) request.getSession().getAttribute("username");
		group.setName(name);
        groupService.addGroup(group,loginUser.getUserid()); 
		return "redirect:Myowngroup";
		  } catch (Exception e) {  
	          return "/Error";  
	       }   
	}
/*	@RequestMapping(value = "/GetAllGroup")//��ȡȫ��С��
	public String getAll(List<Group> group3,ModelMap map) {
		group3 = groupService.findAll();
		map.put("Group3", group3);
		
		return "/main_message";
	}*/
	/*@RequestMapping(value = "/Myowngroup")//�ҵ�С��� �Ҵ�����С�飬group1Ϊ�Ҵ�����С�飬group2Ϊ�Ҽ����С��
	public String Myowngroup(HttpServletRequest request,List<Group> group1,List<Member> member,ModelMap map) {
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		group1 = groupService.findByMyOwnGroup(user.getUsername());
		member=memberService.findByName(user.getUsername());
		map.put("group1", group1);
		map.put("group2", member);
		
		return "/main_message";
	}*/


}
