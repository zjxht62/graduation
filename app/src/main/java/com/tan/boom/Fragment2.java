package com.tan.boom;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

//问答栏
public class Fragment2 extends Fragment {

	private Button page_02_ask;
	private Button page_02_look;

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
			@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.page_02, container, false);
		page_02_ask = (Button) view.findViewById(R.id.page_02_ask);
		page_02_look = (Button) view.findViewById(R.id.page_02_look);
		// 跳转到提问界面
		page_02_ask.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent intent = new Intent();
				intent.setClass(getActivity(), AskQues.class);
				startActivity(intent);

			}
		});
		// 跳转到查看问题目录界面
		page_02_look.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent intent = new Intent();
				intent.setClass(getActivity(), LookQues.class);
				startActivity(intent);

			}

		});
		return view;
	}

}
