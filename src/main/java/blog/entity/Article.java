package blog.entity;

import java.sql.Date;
import javax.persistence.*;

/**
 * 鏂囩珷瀹炰綋绫�
 * @author hope
 *
 */
@Entity
@Table(name = "t_article", schema = "group", catalog = "")
public class Article extends BaseEntity {
	private static final long serialVersionUID = 4968250252502230187L;
	
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
	private int id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "content", nullable = false, length = 100)
    private String content;
    
    @Basic
    @Column(name = "pub_date", nullable = false)
    private Date pubDate;
    
    @ManyToOne
    @JoinColumn(name = "articletype_id",referencedColumnName = "id")    
    private ArticleType articletype;
    
    @ManyToOne
    @JoinColumn(name = "userid",referencedColumnName = "userid")
    private User user;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }
    
	public ArticleType getArticleType() {
		return articletype;
	}

	public void setArticleType(ArticleType articletype) {
		this.articletype = articletype;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

//    @OneToMany(mappedBy="article")
//	public Collection<Reply> getReply() {
//		return reply;
//	}
//
//	public void setReply(Collection<Reply> reply) {
//		this.reply = reply;
//	}
	
	
    
}
