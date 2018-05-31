package com.eposapp.config;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;

/**
 * @author chhaichivon on May 31, 2018
 */

public class CookieManager {
	
	public static String USER_NAME_KEY = "USER_NAME_KEY";
	public static String USER_PASSWORD_KEY = "USER_PASSWORD_KEY";
	
	
	public static void setCookie(String key, String value) {
		 HttpServletResponse resp = (HttpServletResponse) Executions.getCurrent().getNativeResponse();
		 Cookie cookie = new Cookie(key, value);
		 cookie.setMaxAge(0);
	     resp.addCookie(cookie);
	}
	
	public static String getCookie(String key) {
		String result = "";
		try {
			Execution exec = Executions.getCurrent();
	        Cookie[] cookies = ((HttpServletRequest) exec.getNativeRequest()).getCookies();
	        if(cookies != null) {
	            for(Cookie cookie : cookies) {
	                if(key.equals(cookie.getName()))
	                	result =  cookie.getValue();
	            }
	        }
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		return result;
	}

}
