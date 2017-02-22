package com.tan.boom;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;

//弹出菜单的适配器 暂时没用

public class PopWindow extends PopupWindow {
	private View mRootView;
	LayoutInflater mInflater;

	public PopWindow(Activity context) {
		super(context);
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mRootView = mInflater.inflate(R.layout.test_popwindow_2, null);
		setContentView(mRootView);

		this.setWidth(LayoutParams.WRAP_CONTENT);
		this.setHeight(LayoutParams.WRAP_CONTENT);

		setTouchable(true);
		setOutsideTouchable(true);
		setFocusable(true);
		setBackgroundDrawable(new BitmapDrawable(context.getResources()));
		update();

		getContentView().setFocusableInTouchMode(true);
		getContentView().setFocusable(true);
		setAnimationStyle(R.style.AppBaseTheme);

	}
}
