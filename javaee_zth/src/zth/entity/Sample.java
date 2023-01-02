package zth.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the sample database table.
 * 
 */
@Entity
@NamedQuery(name="Sample.findAll", query="SELECT s FROM Sample s")
public class Sample implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="test_no")
	private String testNo;

	@Column(name="sample_time")
	private String sampleTime;

	private String state;

	@Column(name="upload_time")
	private String uploadTime;

	//bi-directional many-to-many association to UserInfo
	@ManyToMany
	@JoinTable(
		name="ref_user_sample"
		, joinColumns={
			@JoinColumn(name="sample_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="user_id")
			}
		)
	private List<UserInfo> userInfos=new ArrayList<UserInfo>();

	public Sample() {
	}

	public String getTestNo() {
		return this.testNo;
	}

	public void setTestNo(String testNo) {
		this.testNo = testNo;
	}

	public String getSampleTime() {
		return this.sampleTime;
	}

	public void setSampleTime(String sampleTime) {
		this.sampleTime = sampleTime;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUploadTime() {
		return this.uploadTime;
	}

	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}

	public List<UserInfo> getUserInfos() {
		return this.userInfos;
	}

	public void setUserInfos(List<UserInfo> userInfos) {
		this.userInfos = userInfos;
	}

}