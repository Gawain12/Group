package group.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import group.dao.ArticleTypeDAO;
import group.entity.ArticleType;
import group.util.PageBean;

@Transactional
@Service
public class ArticleTypeService implements group.service.ArticleTypeService {
	@Resource
	private ArticleTypeDAO articleTypeDao;
    /**
     * 鏌ユ壘鎵�鏈夋枃绔犵被鍨�?
     */
	@Override
	public List<ArticleType> findAllType() {
		return articleTypeDao.findAll();
	}
	
    /**
     * 鍒嗛〉鏌ヨ鏂囩珷绫诲�??
     */
	@Override
	public PageBean<ArticleType> findAll(int currPage) {
		PageBean<ArticleType> pageBean = new PageBean<ArticleType>();
		// 灏佽褰撳墠椤垫�?
		pageBean.setCurrPage(currPage);
		// 灏佽姣忛�?�璁板綍鏁�
		int pageSize = 7;
		pageBean.setPageSize(pageSize);
		// 灏佽鎬昏褰曟�?
		int totalCount = articleTypeDao.findCount();
		pageBean.setTotalCount(totalCount);
		// 灏佽椤垫暟
		int totalPage;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 灏佽褰撳墠椤佃褰�?
		int begin = (currPage - 1) * pageSize;
		List<ArticleType> list = articleTypeDao.findAll(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}
    /**
     * 鏍规嵁id鏌ヨarticletype
     */
	@Override
	public ArticleType findById(Integer id) {
		return articleTypeDao.findById(id);
	}
	/**
	 * 鏇存柊鏂囩珷绫诲�?
	 */
	@Override
	public void update(ArticleType articletype) {
		articleTypeDao.update(articletype);
		
	}
    /**
     * 澧炲姞鏂囩珷鍒嗙�?
     */
	@Override
	public void save(ArticleType at) {
		articleTypeDao.save(at);
	}
    /**
     * 鍒犻櫎鏂囩珷鍒嗙�?
     */
	@Override
	public void delete(ArticleType at) {
		articleTypeDao.delete(at);
	}
}
