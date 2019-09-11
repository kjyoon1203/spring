package kr.or.ddit.user.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;

public class User {
	private String userId;
	private String pass;
	private String userNm;
	private String alias;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date reg_dt;
	
	private int age;
	
	private String addr1;	// 주소1
	private String addr2;	// 주소2
	private String zipcode;	// 우편번호
	private String filename;
	private String realfilename;
	
	
	public User() {}
	
	public User(String userId) {
		this.userId = userId;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getRealfilename() {
		return realfilename;
	}

	public void setRealfilename(String realfilename) {
		this.realfilename = realfilename;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", pass=" + pass + ", userNm=" + userNm + ", alias=" + alias + ", reg_dt="
				+ reg_dt + ", age=" + age + ", addr1=" + addr1 + ", addr2=" + addr2 + ", zipcode=" + zipcode
				+ ", filename=" + filename + ", realfilename=" + realfilename + "]";
	}

	public boolean checkLoginValidate(String userId, String pass) {
		// 암호화 문장끼리 비교 (08/27)   KISA_SHA256.encrypt(pass)
		if(userId.equals(this.userId) && KISA_SHA256.encrypt(pass).equals(this.pass)) {
			return true;
		}
		return false;
	}
}
