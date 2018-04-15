package bookshow.domain.users;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Ivan V. on 28-Jan-18
 */
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String passwordHash;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(nullable = true)
    private Date lastPasswordReset;
   
    @Column
    private boolean firstTimeLogged;
    @Column(nullable = false)
    private boolean activated;
  
   //broj poslatih requestova(sluzi za rejting korisnika)
    @Column(nullable = false)
    private Long points;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RatingType type;
  

    @Column
    private String friendList;
    
    @Column
    private String istorijaPoseta;
    
    /**
     * Zahtevi koji su mu drugi korisnici poslali
     * a koje jos nije prihvatio / odbio
     */
    @Column
    private String friendRequests;
    
    /**
     * Zahtevi koji je korisnik poslao drugim korisnicima
     * a koji jos nisu prihvaceni / odbijeni
     */
    @Column
    private String pendingRequests;

	public String getFriendRequests() {
		return friendRequests;
	}

	public void setFriendRequests(String friendRequests) {
		this.friendRequests = friendRequests;
	}

	public String getPendingRequests() {
		return pendingRequests;
	}

	public void setPendingRequests(String pendingRequests) {
		this.pendingRequests = pendingRequests;
	}


	public boolean isActivated() {
		  return activated;
	  }

    public void setActivated(boolean activated) {
      this.activated = activated;
    }
   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Date getLastPasswordReset() {
        return lastPasswordReset;
    }

    public void setLastPasswordReset(Date lastPasswordReset) {
        this.lastPasswordReset = lastPasswordReset;
    }

	public boolean isFirstTimeLogged() {
		return firstTimeLogged;
	}

	public void setFirstTimeLogged(boolean firstTimeLogged) {
		this.firstTimeLogged = firstTimeLogged;
	}



    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public RatingType getType() {
        return type;
    }

    public void setType(RatingType type) {
        this.type = type;
    }

	public String getFriendList() {
		return friendList;
	}

	public void setFriendList(String friendList) {
		this.friendList = friendList;
	}

	public String getIstorijaPoseta() {
		return istorijaPoseta;
	}

	public void setIstorijaPoseta(String istorijaPoseta) {
		this.istorijaPoseta = istorijaPoseta;
	}
}
