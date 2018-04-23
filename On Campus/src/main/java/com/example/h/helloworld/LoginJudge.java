package com.example.h.helloworld;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginDemo {
	//OA登录地址
	private static final String url = "https://cas.ecit.cn/index.jsp?service=http://portal.ecit.cn/Authentication";
	//获取动态参数lt的正则表达式
	private static final String regex_lt  = "LT-\\d+-\\w+";
	//保存登录成功的cookie备用。
	public static String cookie = null;
	//保存动态成绩网址的网页源码
//	public static String res_persionInformation = null;

	
//	public static void main(String[] args) throws Exception {
//		ecit_Login("20163033207", "lwk36036036");
//	}
	/**
	 * 登录方法
	 * @author Mr_Fan
	 * @param user 登录的用户名
	 * @param psw 登录的密码
	 * 
	 * @return 0为登录失败，1为登录成功
	 * 
	 * */ 
	public static int ecit_Login(String user, String psw){
		//学分制综合教务
		String lt = null;
		String res_loginPage = null;
		String res_informationPage = null;
		res_loginPage = HttpUtil.sendGet(url, "");
		
		//System.out.println("res_loginPage:"+res_loginPage);
		
		Pattern p = Pattern.compile(regex_lt);
		Matcher m = p.matcher(res_loginPage);
		if(m.find()){
			lt = m.group();
			//System.out.println("lt:"+lt);
		}else{
			return 0;
		}
		res_informationPage = HttpUtil.sendPost(url, "username="+user+"&password="+psw+"&lt="+lt+"&Submit=", false);
		//res_persionInformation = HttpUtil.sendGet("http://cjjw.ecit.cn/","");
		
		//System.out.println(res_persionInformation);
		//System.out.println("res_informationPage:"+res_informationPage);
		
		if(isLoginSuccessful(res_informationPage)){
			System.out.println("Successful");
			cookie = HttpUtil.cookie; //返回登录成功的cookie
			return 1;
		}else{
			System.out.println("False");
			return 0;
		}
	}

	private static boolean isLoginSuccessful(String res){
		String regex = "进入教务系统";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(res);
		if(m.find()){
			return true;
		}else{
			return false;
		}
	}

}
