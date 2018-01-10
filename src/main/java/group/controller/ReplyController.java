package group.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import group.entity.Article;
import group.entity.Reply;
import group.entity.User;
import group.service.ArticleService;
import group.service.ReplyService;
import group.util.PageBean;

@Controller
public class ReplyController {
	@Resource
	private ReplyService replyService;
	@Resource
	private ArticleService articleService;
	/**
	 * 分页查询reply页面
	 * @return
	 */
    @RequestMapping(value="/doReply")
    public String reply(@RequestParam int currPage,Model model){
    	PageBean<Reply> listReply = replyService.findAllReply(currPage);
    	// 值存储，绑定到request上
    	model.addAttribute("listReply",listReply);
    	return "/reply";
    }
    
    /**
     * 删除评论
     * @param id
     * @return
     */
    @RequestMapping(value="/deReply")
    public String delete(@RequestParam int id){
    	replyService.delete(id);
    	System.out.println("删除成功");
    	return "redirect:/doMarticle?currPage=1";
    }
    
    /**
     * 保存评论
     * @param content
     * @param article_id
     * @return
     */
    @RequestMapping(value = "/reply", method = RequestMethod.GET)  
    public String saveReply(@RequestParam String content,@RequestParam int article_id,HttpServletRequest request) {  
    	try { 
    	Map<String,Object> map=new HashMap<String,Object>(); 
    	System.out.println("进入getReply");
    	// 创建reply对象
    	Reply reply = new Reply();
    	// 获取当前时间
    	java.util.Date nDate = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sDate = sdf.format(nDate);
        java.sql.Date now = java.sql.Date.valueOf(sDate);
        reply.setContent(content);
        reply.setTime(now);
        // 获取所评论文章
    	User loginUser = (User) request.getSession().getAttribute("username");
        Article article = articleService.findById(article_id);
        reply.setArticle(article);
    	//replyService.save(reply);

    	replyService.addReply(reply,loginUser.getUserid()); 
    	System.out.print("saveReply()执行成功");
    	map.put("reply", reply);
      return "/Authority";  
    	  } catch (Exception e) {  
              return "/Error";  
           }   
    }
    
}
