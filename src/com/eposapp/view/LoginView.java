package com.eposapp.view;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Textbox;

import com.eposapp.config.CookieManager;

/**
 * @author chhaichivon on May 31, 2018
 */

public class LoginView  extends SelectorComposer<Component>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3179034594895952874L;

	
	@Wire
	Textbox txtLoginID;
	@Wire
	Textbox txtPassword;
	@Wire
	Button btnLogin;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		
		
		
	
		btnLogin.addEventListener(Events.ON_CLICK, event -> {
			if(txtLoginID.getValue().contains("Admin") &&  txtPassword.getValue().contains("123")){
				CookieManager.setCookie(CookieManager.USER_NAME_KEY, txtLoginID.getValue());
				CookieManager.setCookie(CookieManager.USER_PASSWORD_KEY,txtPassword.getValue());
				Executions.sendRedirect("/");
			}
		});
	}
	
	
	
}
