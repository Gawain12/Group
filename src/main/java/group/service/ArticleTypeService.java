package group.service;

import java.util.List;

import group.entity.ArticleType;
import group.util.PageBean;

public interface ArticleTypeService {

	List<ArticleType> findAllType();

	PageBean<ArticleType> findAll(int currPage);

	ArticleType findById(Integer id);

	void update(ArticleType articletype);

	void save(ArticleType at);

	void delete(ArticleType at);

}
