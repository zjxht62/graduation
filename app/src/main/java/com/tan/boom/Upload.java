package com.tan.boom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

//�ļ��ϴ�����
public class Upload extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.upload);
		Button upload_back = (Button) findViewById(R.id.upload_back);
		Button upload_up = (Button) findViewById(R.id.upload_up);
		Button upload_add = (Button) findViewById(R.id.upload_add);
		upload_back.setOnClickListener(this);
		upload_up.setOnClickListener(this);
		upload_add.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.upload_back: // ������ǰ����
			this.finish();
			break;
		// case R.id.upload_add: //ѡ������ļ�
		//
		// break;
		// case R.id.upload_up: //�ύ
		//
		// break;
		default:
			break;
		}
	}

}
