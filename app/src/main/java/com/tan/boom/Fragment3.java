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

//…Ë÷√ΩÁ√Ê
public class Fragment3 extends Fragment {
	Button page_03_down;

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
			@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.page_03, container, false);
		page_03_down = (Button) view.findViewById(R.id.page_03_down);
		page_03_down.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent intent = new Intent();
				intent.setClass(getActivity(), Login.class);
				startActivity(intent);

			}
		});
		return view;
	}

}
