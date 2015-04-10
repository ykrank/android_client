package com.example.android_client;


import com.android.debug.hv.ViewServer;
import com.rytong.emp.android.EMPActivity;
import com.rytong.emp.dom.Entity;
import com.rytong.emp.gui.GUIRepository;
import com.rytong.emp.gui.atom.TextArea;
import com.rytong.emp.lua.EMPLua;
import com.rytong.emp.render.EMPRender;
import com.rytong.emp.tool.Utils;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;

public class MainActivity extends EMPActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ViewServer.get(this).addWindow(this);
	}
	
	public void onResume() {
		super.onResume();
		ViewServer.get(this).setFocusedWindow(this);
	}
	
	@Override
	public void onInitActivity() {
		// 隐藏系统标题栏
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// 当 Thread 因未捕获的异常而崩溃，处理程序的接口。
		// Thread.setDefaultUncaughtExceptionHandler(new
		// EMPUncaughtExceptionHandler());
	}
	@Override
	public void onAddGUIView() {
	
		GUIRepository.addGUIView(Entity.NODE_TEXT_AREA, TextArea.class);
		GUIRepository.addGUIView(Entity.NODE_MYVIEW,MyView.class);
		GUIRepository.addGUIView("mylist",MyList.class);
		GUIRepository.addGUIView("modifie",Modifie.class);
	}
	
	


	@Override
	public void onLoadStartPage(EMPRender empRender) {
		// 加载assets下页面
		empRender.loadLocalFile("assets:ip.xml",true);
	}
	



}
