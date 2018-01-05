package group.entity;

import javax.persistence.*;

/**
 * 鏂囩珷瀹炰綋绫�
 * @author hope
 *
 */
@Entity
@Table(name = "t_group", schema = "group", catalog = "")
public class Group extends BaseEntity {
	private static final long serialVersionUID = 4968250252502230187L;
	
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
	private int id;

    @ManyToOne
    @JoinColumn(name = "user_userid",referencedColumnName = "userid")
    private User user;
    @Basic
    @Column(name = "name", nullable = false, unique = true, length = 45)

    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
