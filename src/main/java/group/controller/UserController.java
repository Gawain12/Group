package group.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import group.entity.Group;
import group.entity.User;
import group.service.UserService;
import group.util.PageBean;
import group.service.GroupService;

@Controller
public class UserController {
	@Resource	
	private UserService userService;

	private GroupService groupService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String Login() {
		return "/login";
	}
	@RequestMapping(value = "/AuError", method = RequestMethod.GET)
	public String AuError() {
		return "/AuError";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String Register() {
		return "/register";
	}
	
	@RequestMapping(value = "/doRegister", method = RequestMethod.POST)
	public ModelAndView doRegister(User user, HttpServletRequest req) {
		ModelAndView view = new ModelAndView();		
		if(userService.findUserByName(user.getUsername()) == null){
			userService.saveUser(user);
			System.out.println("注册成功");
			view.setViewName("redirect:login");
		} else {
			view.addObject("errorMsg","注册失败");
			view.setViewName("forward:register");
		}
		return view;
	}
	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public String doLogin(User user, HttpServletRequest req) {
		HttpSession session = req.getSession();
		User existUser = userService.login(user);
		System.out.println("登录");
		if (existUser != null) {
			session.setAttribute("username", existUser);
			return "/index";
		}
		return "redirect:login";
	}
	@RequestMapping(value = "/SignOut")
	public String SignOut(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		session.removeAttribute("username");
		return "redirect:login";
	}
	@RequestMapping(value = "/doModify")
	public String modify(HttpServletRequest req, ModelMap map) {
		User loginUser = (User) req.getSession().getAttribute("username");
		User user = userService.findUser(loginUser.getUserid());
		map.put("user", user);
		return "/my_info";
	}
	@RequestMapping(value = "/updateUser")
	public String updateUserdata(User user) {
		User u = userService.findUser(user.getUserid());
		u.setEmail(user.getEmail());
		u.setPhone(user.getPhone());
		u.setUsername(user.getUsername());
		
		userService.updateUser(u);
		return "/my_info";
	}
	@RequestMapping(value = "doUser/{role}/{path}")
	public String doUser(@PathVariable String role, @PathVariable String path,
			ModelMap map) {
		User user = userService.findUser(1);
		userService.updateUserPassword(user);
		map.put("user", user);
		System.out.println("user,鏇存柊瀵嗙爜鎴愬姛");
		return role + "/" + path;
	}
	@RequestMapping(value = "updateUserPassword")
	public String updateUserP(User user) {
		userService.updateUserPassword(user);
		System.out.print("瀵嗙爜鏇存柊鎴愬姛");
		return "/userModify";
	}
	@RequestMapping(value = "Index")
	public String doHome() {
		return "/index";
	}
	@RequestMapping(value = "/doArticle")
	public String doArticle() {
		System.out.println("article鐧诲綍鎴愬姛");
		return "/S_article";
	}

}
