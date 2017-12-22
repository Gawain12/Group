package blog.service;

import java.util.List;

import blog.entity.Reply;
import blog.util.PageBean;

public interface ReplyService {

	PageBean<Reply> findAllReply(int currPage);

	void delete(int id);

	List<Reply> findReply(int id);

	void save(Reply reply);


}
