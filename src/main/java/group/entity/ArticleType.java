package group.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 鏂囩珷绫诲埆瀹炰綋绫�
 * @author hope
 *
 */
@Entity
@Table(name="t_articletype",schema = "group")
public class ArticleType {
	private int id;
	private String type;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="type",nullable = false,length = 30)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
