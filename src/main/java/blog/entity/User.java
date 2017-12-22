
package blog.entity;


import javax.persistence.*;

/**
 * User绫�
 * author hope
 */
@Entity
@Table(name = "t_user", schema = "group", catalog = "")
public class User extends BaseEntity{
	private static final long serialVersionUID = -2544170046153290639L;
	
	private int userid;
    private String username;
    private String password;
    private String email;
    private String phone;
 

    @Id
    @GeneratedValue
    @Column(name = "userid", nullable = false)
    public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
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
    @Column(name = "password", nullable = false, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


    
//    @OneToMany(mappedBy = "userByUserId")
//	public Collection<Article> getArticleById() {
//		return articleById;
//	}
//
//	public void setArticleById(Collection<Article> articleById) {
//		this.articleById = articleById;
//	}
}
