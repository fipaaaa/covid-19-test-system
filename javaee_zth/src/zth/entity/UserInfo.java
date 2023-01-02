package zth.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the user_info database table.
 * 
 */
@Entity
@Table(name="user_info")
@NamedQuery(name="UserInfo.findAll", query="SELECT u FROM UserInfo u")
public class UserInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="stu_number")
	private String stuNumber;

	private String level;

	private String name;

	private String password;

	private String username;

	//bi-directional many-to-many association to Sample
	@ManyToMany(mappedBy="userInfos")
	private List<Sample> samples=new ArrayList<Sample>();

	public UserInfo() {
	}

	public String getStuNumber() {
		return this.stuNumber;
	}

	public void setStuNumber(String stuNumber) {
		this.stuNumber = stuNumber;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Sample> getSamples() {
		return this.samples;
	}

	public void setSamples(List<Sample> samples) {
		this.samples = samples;
	}

}