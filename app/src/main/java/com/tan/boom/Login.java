package com.tan.boom;

import com.tan.boom.*;
//import com.example.muse.;
//import com.example.studentmanagersystem.StudentInformationManagerActivity;

import android.R.string;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.*;

public class Login extends Activity {

	private DBHelper dbHelper;
	private SQLiteDatabase db;
	private EditText userName;
	private EditText userPassword;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login_layout);
		userName = (EditText) findViewById(R.id.editText1);
		userPassword = (EditText) findViewById(R.id.editText2);

		dbHelper = new DBHelper(this, "stu.db", null, 1);
		db = dbHelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		// values.put("username", "zjx");
		// values.put("password", "123456");
		// db.insert("Users", null, values);
		// values.clear();
		// values.put("username", "wjc");
		// values.put("password", "sbff");
		// db.insert("Users", null, values);
		// values.clear();
		// values.put("username", "honoka");
		// values.put("password", "0803");
		// db.insert("Users", null, values);
		// values.clear();
		// values.put("username", "umi");
		// values.put("password", "0315");
		// db.insert("Users", null, values);
		// values.clear();
		//

		Button loginbutton = (Button) findViewById(R.id.button_1);
		loginbutton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				login();

				//
				// EditText editText1 = (EditText) findViewById(R.id.editText1);
				// final String username = editText1.getText().toString();
				// EditText editText2 = (EditText) findViewById(R.id.editText2);
				// final String password = editText2.getText().toString();
				//
				// if (("honoka".equals(username)) && ("0803".equals(password)))
				// {
				// Intent intent = new Intent(Login.this, Information.class);
				// startActivity(intent);
				// } else
				// Toast.makeText(Login.this, "密码输入错误",
				// Toast.LENGTH_LONG).show();
				//
				// // }// TODO Auto-generated method stub
				//
			}
		});

	}

	public void login() {
		
		if (TextUtils.isEmpty(userName.getText()) || TextUtils.isEmpty(userPassword.getText())) {
			Toast.makeText(Login.this, "请输入用户名或密码", Toast.LENGTH_SHORT).show();
		}
		else{

			
			
			
			Cursor cursor1 = db
					.rawQuery("select count(*) from Users where username = '" + userName.getText().toString() + "'", null);
			cursor1.moveToNext();
			int count = cursor1.getInt(0);
			if (count == 1) {
				Cursor cursor = db.rawQuery(
						"select username,password from Users where username = '" + userName.getText().toString() + "'",
						null);
				cursor.moveToNext();
				if ((userName.getText().toString()).equals(cursor.getString(0).toString())
						&& (userPassword.getText().toString()).equals(cursor.getString(1).toString())) {
					Toast.makeText(Login.this, "登录成功！", Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(Login.this, MainActivity.class);
					startActivity(intent);

				} else {
					Toast.makeText(Login.this, "您输入的用户名或密码错误！", Toast.LENGTH_SHORT).show();
				}
				cursor.close();
			}
			cursor1.close();
			// dbHelper.getWritableDatabase().close();
		
		}
	}

}
