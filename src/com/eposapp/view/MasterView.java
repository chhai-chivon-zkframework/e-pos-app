package com.eposapp.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Div;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import com.eposapp.config.CookieManager;
import com.eposapp.entity.SysFunction;


/**
 * @author chhaichivon on May 30, 2018
 */

public class MasterView extends SelectorComposer<Component>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3387170680377467669L;

	@Wire
	Borderlayout masterPage;
	
	@Wire 
	Toolbarbutton tlbSwitchDept;
	
	@Wire
	Toolbarbutton tlbHome;
		
	@Wire
	Tabbox tbLeftMenu;
	
	@Wire
	Tab tbRoot;
	
	@Wire
	Tab tbOperation;
	
	@Wire
	Tab tbView;
	
	@Wire
	Tab tbSystem;
	
	@Wire
	Tab tbSecurity;
	
	@Wire
	Tabpanel tpRoot;
	
	@Wire
	Tabpanel tpOperation;
	
	@Wire
	Grid grOperation;
	
	@Wire
	Tabpanel tpView;
	
	@Wire
	Grid grView;
	
	@Wire
	Tabpanel tpSystem;
	
	@Wire
	Grid grSystem;
	
	@Wire
	Tabpanel tpSecurity;
	
	@Wire
	Grid grSecurity;
	
	@Wire
	Hbox hbContent; 
	
	@Wire
	Textbox txtDeptIdHide;
	
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		

		tbSystem.setVisible(true);
        tbSecurity.setVisible(true);

        tpSystem.setVisible(true);
        tpSecurity.setVisible(true);

        grSystem.setVisible(true);
        grSecurity.setVisible(true);
        
        
        this.onSecurityRedirection();
	}
	
	
	private void onSecurityRedirection() {
		//CookieManager.setCookie(CookieManager.USER_NAME_KEY, "");
		//CookieManager.setCookie(CookieManager.USER_PASSWORD_KEY,"");
		if(CookieManager.getCookie(CookieManager.USER_NAME_KEY).compareToIgnoreCase("") == 0 && 
				CookieManager.getCookie(CookieManager.USER_PASSWORD_KEY).compareToIgnoreCase("") == 0) {
			Executions.sendRedirect("login.zul");	
		}
	}
	
	public void onLoadComponents() {
		Map<Grid,List<SysFunction>> map = getMapSysFunction();
		onLoadLeftComponent(map);
	}

	private Map<Grid,List<SysFunction>> getMapSysFunction(){
		SysFunction sysFunction;
		List<SysFunction> sysFunctions;
		List<Grid> gridList = new ArrayList<Grid>();

		gridList.add(grOperation);
		gridList.add(grView);
		gridList.add(grSecurity);
		gridList.add(grSystem);

		Map<Grid,List<SysFunction>> map = new HashMap<Grid, List<SysFunction>>();
		for (int i = 0 ; i < gridList.size() ; i++){
			sysFunctions = new ArrayList<SysFunction>();
			for (int k = 0; k < 10 ; k++){
				sysFunction  = new SysFunction();
				sysFunction.setAppCode("code " + k);
				sysFunction.setFuncDesc("group "  + k);
				sysFunctions.add(sysFunction);
			}
			map.put(gridList.get(i),sysFunctions);
		}
		return map;
	}

	private void onLoadLeftComponent(Map<Grid,List<SysFunction>> map){
		Rows rows;
		Row rw;
		Div dv;
		Image img;
		Label lbl;
		clearLeftComponent();
		for (Map.Entry<Grid,List<SysFunction>> entry : map.entrySet()){
			rows = new Rows();
			for (SysFunction sysFunction  : entry.getValue()){
				rw = new Row();
				dv  = new Div();
				img = new Image();
				lbl  = new Label();

				///start add event
				final String tmpFuncId = "ITADSURF.zul";
				lbl.addEventListener(Events.ON_CLICK, new EventListener() {
					public void onEvent(Event event) throws Exception {
						//IFrameSrc(tmpFuncId, null);
					}
				});
				///end event

				img.setSrc("images/icon/" + "");
				img.setParent(dv);
				lbl.setValue(sysFunction.getAppCode());
				lbl.setSclass("leftMenuItem");
				lbl.setParent(dv);
				dv.setParent(rw);
				rw.setParent(rows);
				rows.setParent(entry.getKey());
			}
		}
	}

	private void clearLeftComponent(){
		grOperation.getChildren().clear();
		grView.getChildren().clear();
		grSystem.getChildren().clear();
		grSecurity.getChildren().clear();
	}
}
