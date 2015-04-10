package com.example.android_client;

import org.w3c.dom.Element;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.AbsoluteLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rytong.emp.dom.Entity;
import com.rytong.emp.dom.css.BgStyle;
import com.rytong.emp.dom.css.ComplexLayout;
import com.rytong.emp.dom.css.Layout;
import com.rytong.emp.gui.GUIPropertyAdjustment;
import com.rytong.emp.gui.GUIRealView;
import com.rytong.emp.gui.GUISelfOnClick;
import com.rytong.emp.gui.GUIView;
import com.rytong.emp.gui.Property;
import com.rytong.emp.render.EMPRender;
import com.rytong.qrcode.Utils;

/**
 * 功能：扩展table<br>
 * <p>
 * 说明：<br>
 * </p>
 */
public class MyList extends LinearLayout implements GUIView, Property, GUIPropertyAdjustment, GUISelfOnClick, GUIRealView {

	private BgStyle mBgStyle;
	
	private String mTime="";
	private String mPerson="";
	private String mText="";

	public MyList(Context context) {
		super(context);
		//table支持一下背景色和边框
		mBgStyle = new BgStyle();
		
		mBgStyle.addDecorate(BgStyle.BG_ROUNDED | BgStyle.BG_BORDER);
	}
	


	@Override
	public void onBindElement(Element element) {
	

	}

	@Override
	public Layout onBuildLayout() {
		Layout layout = new ComplexLayout(Layout.MATCH_PARENT, Layout.WRAP_CONTENT);
		layout.setStyle(mBgStyle);
		return layout;
	}


	@Override
	public boolean luaPropertyAdjustment(String name, String value) {
		if (name.equals("text")) {
			return true;
		}
		return false;
	}

	@Override
	public boolean setPropertyByName(String name, String value) {
		if (name.equals("time")) {
			mTime=value;
		}
		if (name.equals("person")) {
			mPerson=value;
		}
		if (name.equals("text")) {
			mText=value;
		}
		return false;
	}

	@Override
	public void initRealView(Context context) {
		//这里的context
		Activity activity =  (Activity) context;
		LayoutInflater inflater = activity.getLayoutInflater();
        LinearLayout innerView=(LinearLayout) inflater.inflate(Utils.getResourcesId(activity, "list", "layout"), this, false);
		//填进去
        
        addView(innerView, LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
     
        TextView Time = (TextView) innerView.findViewById(
				Utils.getResourcesId(activity, "time", "id"));
        TextView Person = (TextView) innerView.findViewById(
				Utils.getResourcesId(activity, "person", "id"));
        TextView Text = (TextView) innerView.findViewById(
				Utils.getResourcesId(activity, "text", "id"));
        Time.setText(mTime);
        Person.setText(mPerson);
        Text.setText(mText);
	}

	@Override
	public void selfClick(EMPRender empRender) {
		
	}



	/**
	 * 设置mText
	 * 
	 * @param mText
	 */
	public void setText(String text) {
		//this.mText = text;
	}

	@Override
	public String getPropertyValue(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}