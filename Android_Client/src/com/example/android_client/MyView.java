package com.example.android_client;

import org.w3c.dom.Element;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
public class MyView extends LinearLayout implements GUIView, Property, GUIPropertyAdjustment, GUISelfOnClick, GUIRealView {

	private BgStyle mBgStyle;
    private Layout mLayout;
	
	private String mTicketNum="";
	private String mTheme="";
	private String mOpened="";
	private String mOwner="";
	private String mReporter="";
	private String mPriority="";
	private String mMilestone="";
	private String mComponent="";
	private String mAntistop="";
	private String mCopy="";
	private String mVersions="";
	private String mRegression="";
	

	public MyView(Context context) {
		super(context);
		//table支持一下背景色和边框
		mBgStyle = new BgStyle();
		mBgStyle.addDecorate(BgStyle.BG_ROUNDED | BgStyle.BG_BORDER);
		//设置一下默认背景色
//		mBgStyle.setStyleByName(Entity.NODE_ATTRIBUTE_BACKGROUND_COLOR, "f0f0f0");	
		
		
	}
	


	@Override
	public void onBindElement(Element element) {
	

	}

	@Override
	public Layout onBuildLayout() {
		Layout mlayout = new ComplexLayout(Layout.MATCH_PARENT, Layout.WRAP_CONTENT);
		mlayout.setStyle(mBgStyle);
		
		return mlayout;
	}


	@Override
	public boolean luaPropertyAdjustment(String name, String value) {
		if (name.equals("TicketNum")) {
			mTicketNum=value;
			return true;
		}
		if (name.equals("Opened")) {
			mOpened=value;
		}
		if (name.equals("Theme")) {
			mTheme=value;
		}
		if (name.equals("Reporter")) {
			mReporter=value;
		}
		if (name.equals("Owner")) {
			mOwner=value;
		}
		if (name.equals("Priority")) {
			mPriority=value;
		}
		if (name.equals("Milestone")) {
			mMilestone=value;
		}
		if (name.equals("Component")) {
			mComponent=value;
		}
		if (name.equals("Versions")) {
			mVersions=value;
		}
		if (name.equals("Antistop")) {
			mAntistop=value;
		}
		if (name.equals("Copy")) {
			mCopy=value;
		}
		if (name.equals("Regression")) {
			mRegression=value;
		}
		
		
		return false;
	
		
	}

	@Override
	public boolean setPropertyByName(String name, String value) {
		if (name.equals("TicketNum")) {
			mTicketNum=value;
			
		}
		if (name.equals("Opened")) {
			mOpened=value;
		}
		if (name.equals("Theme")) {
			mTheme=value;
		}
		if (name.equals("Reporter")) {
			mReporter=value;
		}
		if (name.equals("Owner")) {
			mOwner=value;
		}
		if (name.equals("Priority")) {
			mPriority=value;
		}
		if (name.equals("Milestone")) {
			mMilestone=value;
		}
		if (name.equals("Component")) {
			mComponent=value;
		}
		if (name.equals("Versions")) {
			mVersions=value;
		}
		if (name.equals("Antistop")) {
			mAntistop=value;
		}
		if (name.equals("Copy")) {
			mCopy=value;
		}
		if (name.equals("Regression")) {
			mRegression=value;
		}
		
		
		return false;
	}

	@Override
	public void initRealView(Context context) {
		
		Activity activity =  (Activity) context;
		LayoutInflater inflater = activity.getLayoutInflater();
        LinearLayout innerView=(LinearLayout) inflater.inflate(Utils.getResourcesId(activity, "extable", "layout"), this, false);
		//填进去
        LayoutParams lp=new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        addView(innerView, lp);
     
        TextView TicketNum = (TextView) innerView.findViewById(
				Utils.getResourcesId(activity, "TicketNum", "id"));
        TextView Opened = (TextView) innerView.findViewById(
				Utils.getResourcesId(activity, "Opened", "id"));
        TextView Theme = (TextView) innerView.findViewById(
				Utils.getResourcesId(activity, "Theme", "id"));
        TextView Reporter = (TextView) innerView.findViewById(
				Utils.getResourcesId(activity, "Reporter", "id"));
        TextView Owner = (TextView) innerView.findViewById(
				Utils.getResourcesId(activity, "Owner", "id"));
        TextView Priority = (TextView) innerView.findViewById(
				Utils.getResourcesId(activity, "Priority", "id"));
        TextView Milestone = (TextView) innerView.findViewById(
				Utils.getResourcesId(activity, "Milestone", "id"));
        TextView Component = (TextView) innerView.findViewById(
				Utils.getResourcesId(activity, "Component", "id"));
        TextView Versions = (TextView) innerView.findViewById(
				Utils.getResourcesId(activity, "Versions", "id"));
        TextView Antistop = (TextView) innerView.findViewById(
				Utils.getResourcesId(activity, "Antistop", "id"));
        TextView Copy = (TextView) innerView.findViewById(
				Utils.getResourcesId(activity, "Copy", "id"));
        TextView Regression = (TextView) innerView.findViewById(
				Utils.getResourcesId(activity, "Regression", "id"));
		
       
        TicketNum.setText(mTicketNum);
        Opened.setText(mOpened);
        Theme.setText(mTheme);
        Reporter.setText(mReporter);
        Owner.setText(mOwner);
        Priority.setText(mPriority);
        Milestone.setText(mMilestone);
        Component.setText(mComponent);
        Versions.setText(mVersions);
        Antistop.setText(mAntistop);
        Copy.setText(mCopy);
        Regression.setText(mRegression);
        
        Copy.setOnClickListener(new View.OnClickListener(){
	

        		public void onClick(View v) {
        				// TODO Auto-generated method stub
//        			 mLayout.getEMPRender().alert(null, mText11);
        			 
        			Toast.makeText(getContext(), mCopy,Toast.LENGTH_LONG).show();
        			
        			}
        		});
	}



	@Override
	public void selfClick(EMPRender empRender) {
		
	}



	

	@Override
	public String getPropertyValue(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}