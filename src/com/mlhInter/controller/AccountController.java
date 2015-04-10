package com.mlhInter.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mlhInter.domain.Account;
import com.mlhInter.service.AccountService;
import com.mlhInter.util.EncryptUtils;
import com.mlhInter.util.JSONResult;

/**
 * 账户信息管理服务端接口。
 * 
 * @RestController标注表示，本类的所有方法均以json的方式返回数据
 * @author pxj
 *
 */
@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	/**
	 * 用户注册 接口映射到/account/register.do
	 * 
	 * @param phoneNumber
	 *            手机号码
	 * @param email
	 *            邮箱
	 * @param code
	 *            验证码
	 * @param pwd
	 *            密码
	 * @return 返回“注册成功”表示注册成功，其他信息表示注册失败（其他信息包括“手机号已注册”、“邮箱已注册”等）。
	 */
	@RequestMapping(value = "/account/register.do")
	public JSONResult register(String phoneNumber, String email, String pwd) {
		JSONResult result= new JSONResult();
		Account account = new Account();
		if(phoneNumber==null&&email==null){
			result.setMsg("手机号和邮箱不能都为空，用户注册失败");
			result.setState(false);
			return result;
		//手机号不为空,邮箱为空
		}else if(phoneNumber!=null&&email==null){
			if(accountService.isPhoneNumberExist(phoneNumber)){
				account.setPhoneNumber(phoneNumber);
			}else{
				result.setMsg("该手机号已被注册，用户注册失败");
				result.setState(false);
				return result;
			}
		//手机号空，邮箱不为空
		}else if(phoneNumber==null&&email!=null){
			if(accountService.isEailExist(email)){
				account.setEmail(email);
			}else{
				result.setMsg("该邮箱已被注册，用户注册失败");
				result.setState(false);
				return result;
			}
		}else{
			if(accountService.isPhoneNumberExist(phoneNumber)&&accountService.isEailExist(email)){
				account.setPhoneNumber(phoneNumber);
				account.setEmail(email);
			}else if(!accountService.isPhoneNumberExist(phoneNumber)){
				result.setMsg("该手机号已被注册，用户注册失败");
				result.setState(false);
				return result;
			}else if(!accountService.isEailExist(email)){
				result.setMsg("该邮箱已被注册，用户注册失败");
				result.setState(false);
				return result;
			}
		}
		try {
			//TODO  账号自动生成的策略
			account.setAccountName("mlhInter"+phoneNumber);
			
			account.setCreateTime(new Date());
			account.setRoleCode(1);
			//密码md5加密
			EncryptUtils encryptUtils = new EncryptUtils();
			account.setPasswd(encryptUtils.encodeMD5String(pwd));
			accountService.add(account);
			
			result.setMsg("用户注册成功");
			result.setState(true);
		} catch (Exception e1) {
			e1.printStackTrace();
			result.setMsg("服务器异常，用户注册失败");
			result.setState(false);
		}
		return result;
	}
}
