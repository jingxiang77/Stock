package com.isoft.stockplus.manager.po;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "stockplus")
public class User implements java.io.Serializable
{

	// Fields

	private Integer userId;
	private String userName;
	private String userPassword;
	private String userTel;
	private String userHobby;
	private String userSex;
	private short userAccount;
/*	@JsonFormat(pattern="yyyy:mm:dd hh:mm:ss")*/	
	private String recordDate;
	private String userEmail;
	
	// Constructors

	/** default constructor */
	public User()
	{
	}

	/** minimal constructor */
	public User( Integer userId ,String userName, String userPassword, String userTel,
			String userHobby, String userSex, short userAccount,
			String recordDate, String userEmail)
	{
		this.userId=userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userTel = userTel;
		this.userHobby = userHobby;
		this.userSex = userSex;
		this.userAccount = userAccount;
		this.recordDate = recordDate;
		this.userEmail = userEmail;
	}



	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_id", unique = true)
	public Integer getUserId()
	{
		return this.userId;
	}

	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}

	@Column(name = "user_name")
	public String getUserName()
	{
		return this.userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	@Column(name = "user_password")
	public String getUserPassword()
	{
		return this.userPassword;
	}

	public void setUserPassword(String userPassword)
	{
		this.userPassword = userPassword;
	}

	@Column(name = "user_tel")
	public String getUserTel()
	{
		return this.userTel;
	}

	public void setUserTel(String userTel)
	{
		this.userTel = userTel;
	}

	@Column(name = "user_hobby")
	public String getUserHobby()
	{
		return this.userHobby;
	}

	public void setUserHobby(String userHobby)
	{
		this.userHobby = userHobby;
	}

	@Column(name = "user_sex")
	public String getUserSex()
	{
		return this.userSex;
	}

	public void setUserSex(String userSex)
	{
		this.userSex = userSex;
	}

	@Column(name = "user_account")
	public short getUserAccount()
	{
		return this.userAccount;
	}

	public void setUserAccount(short userAccount)
	{
		this.userAccount = userAccount;
	}

	@Column(name = "record_date", length = 20)
	public String getRecordDate()
	{
		return this.recordDate;
	}

	public void setRecordDate(String recordDate)
	{
		this.recordDate = recordDate;
	}

	@Column(name = "user_email")
	public String getUserEmail()
	{
		return this.userEmail;
	}

	public void setUserEmail(String userEmail)
	{
		this.userEmail = userEmail;
	}

}