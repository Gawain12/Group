package group.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import group.entity.ArticleType;
import group.service.ArticleTypeService;
import group.util.PageBean;

@Controller
public class ArticleTypeController {
	@Resource
	private ArticleTypeService articleTypeService;
	
	@RequestMapping(value = "/doPublish2")
	public String findAllType(ModelMap map){
		List<ArticleType> typeList = articleTypeService.findAllType();
		map.put("typeList", typeList);
		return "/c_article";
	}
	/**
	 * 分页查找catagory
	 * @param currPage
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/doCatagory")
	public String findAllArticleType(@RequestParam int currPage,Model model){
		PageBean<ArticleType> listType = articleTypeService.findAll(currPage);
		model.addAttribute("listType", listType);
		return "/catagory";
	}
	/**
	 * 更新类别
	 * @param at
	 * @return
	 */
	@RequestMapping(value="/updateArticleT")
	public String goUpdate(ArticleType at){
		System.out.println("id:"+at.getId()+",type:"+at.getType());
		articleTypeService.update(at);
		return "redirect:doCatagory?currPage=1";
	}
	/**
	 * 添加文章类别
	 * @param at
	 * @return
	 */
    @RequestMapping(value= "/addCatagory")
    public String addCatagory(ArticleType at){
    	articleTypeService.save(at);
    	return "redirect:doCatagory?currPage=1";
    }
    /**
     * 删除文章类别
     * @param articletype_id
     * @return
     */
    @RequestMapping(value = "/deleteArticleT")
    public String delete(@RequestParam int articletype_id){
    	ArticleType at = articleTypeService.findById(articletype_id);
    	articleTypeService.delete(at);
    	return "redirect:doCatagory?currPage=1";
    }
}
