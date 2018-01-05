package group.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import group.dao.ArticleDAO;
import group.entity.Article;
import group.util.PageBean;

@Transactional // 开启事务注解
@Service 
public class ArticleService implements group.service.ArticleService {
	@Resource
	private ArticleDAO articleDao;
	/**
	 * 分页查询article,service实现
	 */
	@Override
	public PageBean<Article> findAll(Integer currPage) {
		PageBean<Article> pageBean = new PageBean<Article>();
		// 封装当前页数
		pageBean.setCurrPage(currPage);
		// 封装每页记录数
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		// 封装总记录数
		int totalCount = articleDao.findCount();
		pageBean.setTotalCount(totalCount);
		// 封装页数
		int totalPage;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 封装当前页记录
		int begin = (currPage - 1) * pageSize;
		List<Article> list = articleDao.findAll(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}
    /**
     * 根据id查询article，service实现
     */
	@Override
	public Article findById(int article_id) {
		Article a = articleDao.findById(article_id);
		return a;
	}
    /**
     * 根据title查询article
     */	
	@Override
	public List<Article> findByTitle(String title) {
		List<Article> list = articleDao.findByTitle(title);
		return list;
	}
	/**
	 * 更新文章
	 */
	@Override
	public void update(Article article) {
		articleDao.update(article);
		
	}
	@Override
	public List<Article> findByUserid(int userid) {
		List<Article> list = articleDao.findByUserid(userid);
		return list;
	}
	/**
	 * 删除文章
	 */
	@Override
	public void delete(Article article) {
		articleDao.delete(article);
		
	}
	/**
	 * 添加文章
	 */
	@Override
	public void save(Article article) {
		articleDao.save(article);
	}
	@Override
	public void addArticle(Article article, int userid) {
		this.articleDao.addArticle(article, userid);
	}
	
	
}
