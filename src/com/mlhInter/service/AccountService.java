package com.mlhInter.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.mlhInter.domain.Account;

/**
 * 对Account表的CRUD操作
 * @author pxj
 *
 */
@Service
public class AccountService extends BaseService {
	/**
	 * 根据手机号码查找Account
	 * @param phoneNumber 手机号码
	 * @return 找到的Account
	 * @throws Exception
	 */
	public Account findByPhoneNumber(String phoneNumber) throws Exception {
		return this.getFirst(Account.class, "from Account where phoneNumber=?",
				phoneNumber);
	}
	/**
	 * 根据邮箱查找Account
	 * @param email 邮箱地址
	 * @return 找到的Account
	 * @throws Exception
	 */
	public Account findByEmail(String email) throws Exception {
		return this.getFirst(Account.class, "from Account where email=?",
				email);
	}
	/**
	 * 添加Account
	 * @param Account 用户信息
	 * @throws Exception
	 */
	@Transactional
	public void add(Account Account) throws Exception{
		this.save(Account);
	}
	/**
	 * 修改Account
	 * @param newAccount 新用户信息
	 * @throws Exception
	 */
	@Transactional
	public void edit(Account newAccount) throws Exception{
		this.update(newAccount);
	}
	/**
	 * 用手机号判断用户是否有效
	 * @param phoneNumber 手机号
	 * @param pwd	密码
	 * @return	true有效，false无效
	 */
	public Boolean isPhoneNumberValid(String phoneNumber,String pwd)
	{
		try {
			Account c=findByPhoneNumber(phoneNumber);
			return c.getPasswd().equals(pwd);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	/**
	 * 用邮箱判断用户是否有效
	 * @param email 邮箱
	 * @param pwd	密码
	 * @return	true有效，false无效
	 */
	public Boolean isEmailValid(String email,String pwd)
	{
		try {
			Account c=findByEmail(email);
			return c.getPasswd().equals(pwd);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 手机号唯一性验证
	 * @param phoneNumber 手机号
	 */
	public Boolean isPhoneNumberExist(String phoneNumber){
		try {
			Account account = findByPhoneNumber(phoneNumber);
			if (null==account) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	/**
	 * 邮箱唯一性验证
	 * @param email 邮箱
	 */
	public Boolean isEailExist(String email){
		try {
			Account account = findByEmail(email);
			if (null==account) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
}
