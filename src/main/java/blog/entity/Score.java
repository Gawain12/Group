package blog.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_score", schema = "group", catalog = "")
public class Score extends BaseEntity{
	private static final long serialVersionUID = -2544170046153290639L;
	
	private int id;
	private String username;
	private String title;
	private int score;
	
	
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Basic
    @Column(name = "username", nullable = false, unique = true, length = 45)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Basic
    @Column(name = "title", nullable = false, unique = true, length = 45)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Basic
    @Column(name = "score", nullable = false, unique = true, length = 45)
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	

}
