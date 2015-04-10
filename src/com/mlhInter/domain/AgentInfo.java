package com.mlhInter.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AgentInfo {
	@Id
	@GeneratedValue
	private Long id;
	/**
	 * 关联账号
	 */
	@ManyToOne(optional=false)
	private Account account;
	/**
	 * 所属城市
	 */
	@Column(length=45)
	private String city;
	/**
	 * 所属公司名称
	 */
	@Column(length=100)
	private String corporationName;
	/**
	 * qq
	 */
	@Column(length=45)
	private String qq;
	/**
	 * 身份证号码　
	 */
	@Column(length=45)
	private String idcardNumber;
	/**
	 * 身份证图片正面或背面
	 */
	@Column(length=255)
	private String idcardPhoto1;
	/**
	 * 身份证图片正面或背面
	 */
	@Column(length=255)
	private String idcardPhoto2;
	/**
	 * 名片图片
	 */
	@Column(length=255)
	private String businessCardPhoto;
	/**
	 * 注册机构码
	 */
	@Column(length=45)
	private String certificationNumber;
	/**
	 * 注册机构证书图片
	 */
	@Column(length=45)
	private String certificationPhoto;
	/**
	 * 信息更新时间
	 */
	@Column
	private Date updateTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCorporationName() {
		return corporationName;
	}
	public void setCorporationName(String corporationName) {
		this.corporationName = corporationName;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getIdcardNumber() {
		return idcardNumber;
	}
	public void setIdcardNumber(String idcardNumber) {
		this.idcardNumber = idcardNumber;
	}
	public String getIdcardPhoto1() {
		return idcardPhoto1;
	}
	public void setIdcardPhoto1(String idcardPhoto1) {
		this.idcardPhoto1 = idcardPhoto1;
	}
	public String getIdcardPhoto2() {
		return idcardPhoto2;
	}
	public void setIdcardPhoto2(String idcardPhoto2) {
		this.idcardPhoto2 = idcardPhoto2;
	}
	public String getBusinessCardPhoto() {
		return businessCardPhoto;
	}
	public void setBusinessCardPhoto(String businessCardPhoto) {
		this.businessCardPhoto = businessCardPhoto;
	}
	public String getCertificationNumber() {
		return certificationNumber;
	}
	public void setCertificationNumber(String certificationNumber) {
		this.certificationNumber = certificationNumber;
	}
	public String getCertificationPhoto() {
		return certificationPhoto;
	}
	public void setCertificationPhoto(String certificationPhoto) {
		this.certificationPhoto = certificationPhoto;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AgentInfo other = (AgentInfo) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		return true;
	}
	
}
