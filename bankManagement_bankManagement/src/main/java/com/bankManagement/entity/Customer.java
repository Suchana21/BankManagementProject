package com.bankManagement.entity;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Size;

//import org.hibernate.annotations.GenericGenerator;

//import jakarta.persistence.*;
																						
@Entity
public class Customer {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;
    
    @Column(unique=true)
	private int cACno;
    
    @NotBlank
	private String cname;
	private int cbal;	
	@NotBlank
	@Column(unique=true)
	private String cmail;	
	@NotBlank
	private String cpass;
	@NotBlank
	private String cmob;
	@NotBlank
	private String cadd;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Transaction> transaction;
	
	
	public Customer(int cid, int cACno, String cname, int cbal, String cmail, String cpass, String cmob, String cadd) {
		super();
		this.cid = cid;
		this.cACno = cACno;
		this.cname = cname;
		this.cbal = cbal;
		this.cmail = cmail;
		this.cpass = cpass;
		this.cmob = cmob;
		this.cadd = cadd;
	}
	
	
	public Customer() {
		super();
	}
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getcACno() {
		return cACno;
	}
	public void setcACno(int cACno) {
		this.cACno = cACno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCbal() {
		return cbal;
	}
	public void setCbal(int cbal) {
		this.cbal = cbal;
	}
	public String getCmail() {
		return cmail;
	}
	public void setCmail(String cmail) {
		this.cmail = cmail;
	}
	public String getCpass() {
		return cpass;
	}
	public void setCpass(String cpass) {
		this.cpass = cpass;
	}
	public String getCmob() {
		return cmob;
	}
	public void setCmob(String cmob) {
		this.cmob = cmob;
	}
	public String getCadd() {
		return cadd;
	}
	public void setCadd(String cadd) {
		this.cadd = cadd;
	}
	
	
}
