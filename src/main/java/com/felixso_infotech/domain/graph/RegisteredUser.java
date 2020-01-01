package com.felixso_infotech.domain.graph;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;


@NodeEntity
public class RegisteredUser {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  
    private String firstName;
   
    private String lastName;
    
    private String userId;
    
    @Relationship(type = "FRIEND_OF", direction = Relationship.DIRECTION)
	private List<RegisteredUser> friends = new ArrayList<>();
    
    @Relationship(type = "WELLWISHER_OF", direction = Relationship.INCOMING)
	private List<RegisteredUser> wellwishers = new ArrayList<>();
    
    @Relationship(type = "WELLWISHING_OF", direction = Relationship.OUTGOING)
	private List<RegisteredUser> wellwishingList = new ArrayList<>();
    
    

	public List<RegisteredUser> getWellwishers() {
		return wellwishers;
	}

	public void setWellwishers(List<RegisteredUser> wellwishers) {
		this.wellwishers = wellwishers;
	}

	public List<RegisteredUser> getWellwishingList() {
		return wellwishingList;
	}

	public void setWellwishingList(List<RegisteredUser> wellwishingList) {
		this.wellwishingList = wellwishingList;
	}

	public void setFriends(List<RegisteredUser> friends) {
		this.friends = friends;
	}

	public List<RegisteredUser> getFriends() {
		return friends;
	}
   
    public RegisteredUser() {
		
	}

	// jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public RegisteredUser firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public RegisteredUser lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserId() {
        return userId;
    }

    public RegisteredUser userId(String userId) {
        this.userId = userId;
        return this;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

   

	

}
