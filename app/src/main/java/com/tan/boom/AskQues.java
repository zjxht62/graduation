package com.tan.boom;

import java.security.PublicKey;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

//提问页面
public class AskQues extends Activity implements OnClickListener {
	private EditText qcontent;
	private EditText qtitle;
	private DBHelper dbHelper2;
	private SQLiteDatabase db2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.askques);
		dbHelper2 = new DBHelper(this, "stu.db", null, 1);
		Button askques_up = (Button) findViewById(R.id.askques_up);
		Button askques_back = (Button) findViewById(R.id.askques_back);
		qtitle = (EditText) findViewById(R.id.askques_title);
		qcontent = (EditText) findViewById(R.id.askques_content);
		askques_back.setOnClickListener(this);
		askques_up.setOnClickListener(this);
	    

		askques_back.setOnClickListener(this);

	}

	// 按钮监听器
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.askques_back:
			this.finish();

			break;
		case R.id.askques_up:
			if (TextUtils.isEmpty(qcontent.getText()) || TextUtils.isEmpty(qtitle.getText())) {

				Toast.makeText(AskQues.this, "请填写问题标题及内容", Toast.LENGTH_SHORT).show();
			}

			else {
				Spinner spinner_teacher = (Spinner) findViewById(R.id.askques_teacher);
				spinner_teacher.setOnItemSelectedListener(new OnItemSelectedListener() {
					// 选择提问老师
					@Override
					public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
						// TODO Auto-generated method stub
						String teacher = getResources().getStringArray(R.array.teacher)[position];
						//return String teacher//System.out.println(teacher);
						
						//String teachername= spinner_teacher.getSelectedItem().toString();
					}

					@Override
					public void onNothingSelected(AdapterView<?> parent) {
						// TODO Auto-generated method stub

					}

				});

				String oid = Get32Unique.Get32().toString();
				String refoid = Get32Unique.Get32().toString();
				String qid = Get32Unique.Get32().toString();
				
				db2 = dbHelper2.getWritableDatabase();
				ContentValues values = new ContentValues();
				values.put("oid", oid);
				values.put("content", qcontent.getText().toString());
				values.put("asker", "挂机的学生");
				values.put("answer", spinner_teacher.getSelectedItem().toString());
				values.put("askdate", "2016-9-1");
				values.put("state", "n");
				values.put("relaycontent", "好好听课了么");
				values.put("refoid", refoid);
				values.put("qtype", "1");
				db2.insert("pm_question", null, values);
				values.clear();
				values.put("oid", oid);
				values.put("qid", qid);
				values.put("qaid", "001");
				values.put("content", "好好听了啊");
				values.put("qaname", "挂机的学生");
				values.put("qadate", "2016-9-2");
				values.put("qakbn", "1");
				db2.insert("pm_question_detail", null, values);
				values.clear();
				values.put("oid", oid);
				values.put("qid", qid);
				values.put("title", qtitle.getText().toString());
				values.put("content", qcontent.getText().toString());
				values.put("state", "n");
				values.put("refoid", refoid);
				values.put("qtype", "1");
				values.put("askdate", "2016-9-1");
				values.put("asker", "挂机的学生");
				values.put("answer", spinner_teacher.getSelectedItem().toString());
				values.put("system_type", "01");
				db2.insert("pm_question_manage", null, values);
				values.clear();
				dbHelper2.getWritableDatabase().close();
				Toast.makeText(AskQues.this, "问题提交成功", Toast.LENGTH_SHORT).show();
			}

			// values.put("oid",Get32Unique.Get32());

			break;

		default:
			break;
		}

	}
}
