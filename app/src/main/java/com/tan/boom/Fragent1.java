package com.tan.boom;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragent1 extends Fragment {

	// private PopWindow Popwindow = null;
	private Button mLeftMenu;

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
			@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.page_01, container, false);
		// mLeftMenu = (Button) view.findViewById(R.id.btn_open);
		mLeftMenu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent intent = new Intent();
				intent.setClass(getActivity(), Upload.class);

				startActivity(intent);

			}
		});
		return view;
	}

	// @Override
	// public void onCreate(Bundle savedInstanceState) {
	// // TODO Auto-generated method stub
	// super.onCreate(savedInstanceState);
	// Button buttonadd1=(Button)view.findViewById(R.id.btn_open);
	// //ButtonListener buttonListener = new ButtonListener();
	// buttonadd1.setOnClickListener(this);
	// }

	/// @Override
	// public void onClick(View v) {
	// // TODO Auto-generated method stub
	// switch(v.getId()){
	// case R.id.btn_open:
	// Intent intent =new Intent();
	// intent.setClass(getActivity(), Upload.class);
	//
	// startActivity(intent);
	// break;
	// default:
	// break;
	// }
	// }

}
