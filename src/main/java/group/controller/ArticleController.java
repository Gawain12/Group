package group.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



import group.entity.Article;
import group.entity.ArticleType;
import group.entity.Authority;
import group.entity.Group;
import group.entity.Reply;
import group.entity.User;
import group.service.ArticleService;
import group.service.ArticleTypeService;
import group.service.AuthorityService;
import group.service.ReplyService;
import group.service.UserService;
import group.util.PageBean;

@Controller
public class ArticleController {
	@Resource
	private ArticleService articleService;
	@Resource
	private ArticleTypeService articleTypeService;
	@Resource
	private ReplyService replyService;
	@Resource
	private AuthorityService authorityService;
	@Resource
	private UserService userService;
	
	/**
	 * 分页查询所有文章
	 * @param currPage
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/doMarticle")
	public String findMyArticle(@RequestParam int currPage,HttpServletRequest req,Model model,Article article){ //
		if(currPage<1){
		   	currPage = 1;
		}
		// 查询当前展示页所有信息

		User loginUser = (User) req.getSession().getAttribute("username");


		List<User> userList = userService.findAllUser();
		List<Article> listArticle = articleService.findByUserid(loginUser.getUserid());
		//PageBean<Article> listArticle = articleService.findAll(currPage);
		// 查询所有分类

		List<ArticleType> typeList = articleTypeService.findAllType();
	//	int article_id = Article.getId();
		// 值存储，绑定到request上
		model.addAttribute("listArticle", listArticle);
		model.addAttribute("typeList", typeList);
		model.addAttribute("userList", userList);
	//	authorityService.addAuthority(article_id,loginUser.getUserid()); 
		 //System.out.println(listArticle.getCurrPage()+":"+listArticle.getTotalCount()+":"+listArticle.getList().get(0).getContent());
		return "/m_article";
	}
	@RequestMapping(value = "/doAarticle")
	public String findAllArticle(@RequestParam int currPage,Model model){ //
		if(currPage<1){
		   	currPage = 1;
		}
		// 查询当前展示页所有信息
		PageBean<Article> listArticle = articleService.findAll(currPage);
		// 查询所有分类
		List<ArticleType> typeList = articleTypeService.findAllType();

		// 值存储，绑定到request上
		model.addAttribute("listArticle", listArticle);
		model.addAttribute("typeList", typeList);

		
		System.out.println(listArticle.getCurrPage()+":"+listArticle.getTotalCount()+":"+listArticle.getList().get(0).getContent());
		return "/A_article";
	}


	/**
	 * 跳转到编辑文章页面
	 * @param article_id url后面的参数
	 * @return
	 */
	@RequestMapping(value = "/doPublish")
	public String editArticle(@RequestParam int article_id,ModelMap map){
		// 根据文章id查询
		Article article = articleService.findById(article_id);
		map.put("article",article);
		//map.put("articletype", article.getArticleType());
		System.out.println("文章类别id:"+article.getArticleType().getId());
		// 查询所有文章分类
		List<ArticleType> typeList = articleTypeService.findAllType();
		map.put("typeList",typeList);
		return "/U_article";
	}
	@RequestMapping(value = "/doAuthority")
	public String addAthority(@RequestParam int article_id,@RequestParam int userId){
		// 根据文章id查询

    	authorityService.addAuthority(article_id,userId); 
		return "/Authority";
	}
	/*
@RequestMapping(value = "/wArticle", method = RequestMethod.POST)
    
    public String addArticle(Article article ,HttpServletRequest request){
        try {  
        	
            int userid = Integer.valueOf(request.getParameter("user_userid"));  
            System.out.println(userid); 
        	
            articleService.addArticle(article, userid); 
            return "redirect:/c_article";  
        } catch (Exception e) {  
            return "error";  
        }    
    }
    */
	/**
	 * modelAttribute方法会在springmvc controller执行之前执行
	 * @param id
	 * @param map
	 */
	
	@ModelAttribute  
	public void getArticle(@RequestParam(value="id",required=false) Integer id,   
	        Map<String, Object> map){  
	    System.out.println("modelAttribute method");  
	    if(id != null){  
	        //模拟从数据库中获取对象  
	        Article article = articleService.findById(id); 
	        System.out.println("从数据库中获取一个对象: " + article);  
	          
	        map.put("article", article); 
	    }  
	}
	/**
	 * 更新文章
	 * @param article
	 * @param articletype
	 * @return
	 */
	@RequestMapping(value = "/doUpdate", method = RequestMethod.POST)
	public String updateArticle(Article at){
		// 获取更新后的select值articletype
		/*Article u = articleService.findById(id);
		u.setContent(article.getContent());
		u.setTitle(article.getTitle());
		u.setArticleType(article.getArticleType());
		*/
		articleService.update(at);
		return "redirect:doMarticle?currPage=1";
	}
	/**
	 * 删除文章
	 * @param article_id
	 * @return
	 */
    @RequestMapping(value = "/doDelete")
    public String delete(@RequestParam int article_id){
    	Article article = articleService.findById(article_id);
    	articleService.delete(article);
    	System.out.println("删除成功");
    	return "redirect:doMarticle?currPage=1";
    }
    
    /**
     * 添加文章
     * @param article
     * @param articletype
     * @param req 
     * @return
     */
    @RequestMapping(value = "/doSave", method = RequestMethod.POST)
    public String save(Article article,@RequestParam int articletype, Object req,HttpServletRequest request){
    	// 获取当前时间
    	try { 
    	java.util.Date nDate = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sDate = sdf.format(nDate);
        java.sql.Date now = java.sql.Date.valueOf(sDate);
        
        //int userid = Integer.valueOf(request.getParameter("user_userid"));  
        //System.out.println(userid); 

		User loginUser = (User) request.getSession().getAttribute("username");

        
        ArticleType at = articleTypeService.findById(articletype);
    	article.setPubDate(now);
    	article.setArticleType(at);
    	articleService.addArticle(article,loginUser.getUserid()); 

    	
   // 	articleService.save(article);
    	return "redirect:doMarticle?currPage=1";
      } catch (Exception e) {  
          return "/Error";  
       }   
    }
 @RequestMapping(value = "/check", method = RequestMethod.GET)
    
    public String getUserArticleCheck(@RequestParam int articleId, Model model,  HttpSession httpSession,ModelMap map){
    	System.out.println("所查文章的ID:" +articleId);
		User loginUser = (User) httpSession.getAttribute("username");
    	int userId = loginUser.getUserid();
    	System.out.println("当前用户的ID:" +userId);
		Authority curAuthority =authorityService.Check(articleId,userId);
    	if(curAuthority == null)
    	{
    		return "/AuError";
    	}else 
    	{
    		List<Reply> listReply = replyService.findReply(articleId);

    	
      		// 值存储，绑定到request上
      		map.put("listReply", listReply);

        	model.addAttribute("article", articleService.findById(articleId));
            return "/S_article";
    	}

    }
    /**
     * 异步請求article
     * @return
     */
    @RequestMapping(value = "/article")
	@ResponseBody
	public Map<String,Object> listArticle(@RequestParam int currPage){
    	System.out.println("進入json");
		Map<String, Object> map = new HashMap<String, Object>();
		PageBean<Article> listArticle = articleService.findAll(currPage);
		// 值存储，绑定到request上
		map.put("listArticle", listArticle);
		System.out.println("json請求成功");
		return map;
	}
    /**
     * 异步请求articleShow
     */
    @RequestMapping(value = "/articleShow",method = RequestMethod.GET)
    
  	public String article(Article article,@RequestParam int articleId,ModelMap map,Model model){
    	System.out.println("所查文章的ID:" +articleId);
		
    		List<Reply> listReply = replyService.findReply(articleId);

    		List<User> userList = userService.findAllUser();
    	
      		// 值存储，绑定到request上
      		map.put("listReply", listReply);

    		model.addAttribute("userList", userList);
        	model.addAttribute("article", articleService.findById(articleId));
            return "/S_article";
    	}
    }



