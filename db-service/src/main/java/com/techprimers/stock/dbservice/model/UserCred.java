package com.techprimers.stock.dbservice.model;

import javax.persistence.*;

@Entity
@Table(name = "User_Cred", catalog = "test")
public class UserCred {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid")
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String quote;
    
    @Column(name = "ssn")
    private String ssn;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "driverLicense")
    private String driverLicense;

    private String getSsn() {
		return ssn;
	}

	private void setSsn(String ssn) {
		this.ssn = ssn;
	}

	private String getEmail() {
		return email;
	}

	private void setEmail(String email) {
		this.email = email;
	}

	private String getDriverLicense() {
		return driverLicense;
	}

	private void setDriverLicense(String driverLicense) {
		this.driverLicense = driverLicense;
	}

	public UserCred() {
    }

    public UserCred(String userName, String password) {
        this.userName = userName;
        this.quote = quote;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
