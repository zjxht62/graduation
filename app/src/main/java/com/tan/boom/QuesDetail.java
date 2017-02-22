package com.tan.boom;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

//��������

public class QuesDetail extends Activity implements OnClickListener {
	// private EditText detail_chase=(EditText)findViewById(R.id.detail_chase);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.lookques_detail);
		Button detail_back = (Button) findViewById(R.id.detail_back);
		Button detail_zhui = (Button) findViewById(R.id.detail_zhui);
		// EditText detail_chase=(EditText)findViewById(R.id.detail_chase);
		detail_back.setOnClickListener(this);
		detail_zhui.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.detail_back: // ���ذ���������ǰҳ��
			this.finish();
			break;
		case R.id.detail_zhui: // ���׷�ʼ�
			EditText detail_chase = (EditText) findViewById(R.id.detail_chase);
			detail_chase.setEnabled(true); // ׷�ʿ������������
			detail_chase.setBackgroundResource(R.drawable.chase);// ׷�ʿ���Χ���
			break;
		default:
			break;

		}
	}

}
