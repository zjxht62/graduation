package com.tan.boom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.renderscript.Element;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

//查看问题目录
public class LookQues extends Activity {
	private DBHelper dbHelper3;
	private SQLiteDatabase db3;

	// private PopWindow mTestPopwindow2 = null;
	//
	// private void InitUI() {
	// // 实例化TestPopwindow2
	// mTestPopwindow2 = new PopWindow(this);
	// // 设置点击其他位置mTestPopwindow2消失
	// mTestPopwindow2.setOnDismissListener(this);
	//
	// Button buttonTest2 = (Button) findViewById(R.id.list_delete);
	// buttonTest2.setOnClickListener(this);
	// }
	//
	// private void OnPopwindowTest2() {
	// if (mTestPopwindow2 == null)
	// return;
	//
	// // location获得控件的位置
	// int[] location = new int[2];
	// View v = findViewById(R.id.list_delete);
	// if (v != null)
	// v.getLocationOnScreen(location); // 控件在屏幕的位置
	// mTestPopwindow2.setAnimationStyle(R.style.AppBaseTheme);
	//
	// // mTestPopwindow2弹出在某控件(button)的下面
	// mTestPopwindow2.showAtLocation(v, Gravity.TOP | Gravity.LEFT,
	// location[0] - v.getWidth(), location[1] + v.getHeight());
	// }
	//
	// // mTestPopwindow2布局控件的监听
	// public void OnclickTestListener(View view) {
	// switch (view.getId()) {
	// case R.id.layoutSeclect1:
	// Toast.makeText(this, "详情", Toast.LENGTH_SHORT).show();
	// break;
	// case R.id.layoutSeclect2:
	// Toast.makeText(this, "删除", Toast.LENGTH_SHORT).show();
	// break;
	// default:
	// break;
	// }
	// if (mTestPopwindow2 != null)
	// mTestPopwindow2.dismiss();
	// }
	// @Override
	// public void onDismiss() {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void onClick(View v) {
	// switch (v.getId()) {
	// case R.id.list_delete:
	// OnPopwindowTest2();
	// break;
	// default:
	// break;
	// }
	//
	// }

	private List<Map<String, Object>> mData = new ArrayList<Map<String, Object>>();
	private int flag;
	public static String question[] = new String[] { "项目上传成果物大小有限制么？", "关于Excel模板下载进程同步的问题" };
	// private Button list_state=(Button)findViewById(R.id.list_detail);
	MyAdapter adapter = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.lookques);

		dbHelper3 = new DBHelper(this, "stu.db", null, 1);

		Button lookques_back = (Button) findViewById(R.id.lookques_back);
		// 结束当前页面
		lookques_back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				LookQues.this.finish();

			}
		});

		// listview
		mData = getData();
		ListView listView = (ListView) findViewById(R.id.lookques_list);
		adapter = new MyAdapter(this);
		listView.setAdapter(adapter);

	}

	// 获取动态数据 可以又其他地方传来（json等）
	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		db3 = dbHelper3.getWritableDatabase();
		Cursor cursor = db3.rawQuery("select * from pm_question_manage", null);
		if (cursor.moveToFirst()) {
			do {
				Map<String, Object> map = new HashMap<String, Object>();
				String title = cursor.getString(cursor.getColumnIndex("title"));
				// System.out.println(cursor.getString(cursor.getColumnIndex("title")));

				map.put("question1", title);
				list.add(map);

			} while (cursor.moveToNext());

		} else {
			Toast.makeText(LookQues.this, "暂无问题", Toast.LENGTH_SHORT).show();
		}

		// List<Map<String,Object>>list=new ArrayList<Map<String,Object>>();
		// for(int i=0;i<question.length;i++){
		// Map<String,Object>map=new HashMap<String,Object>();
		// map.put("question1", question[i]);
		// list.add(map);
		// }
		return list;
	}

	// listview适配器
	public class MyAdapter extends BaseAdapter {

		private LayoutInflater mInflater;

		public MyAdapter(LookQues lookQues) {
			// TODO Auto-generated constructor stub
			this.mInflater = LayoutInflater.from(lookQues);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mData.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			ViewHolder holder = null;
			if (convertView == null) {
				holder = new ViewHolder();
				// 从visit中获取view，之后把view返回给ListView
				convertView = mInflater.inflate(R.layout.lookques_visit, null);
				holder.questions = (TextView) convertView.findViewById(R.id.list_question);
				holder.detail = (Button) convertView.findViewById(R.id.list_detail);
				holder.delete = (Button) convertView.findViewById(R.id.list_delete);
				holder.state = (Button) convertView.findViewById(R.id.list_state);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}

			holder.questions.setText((String) mData.get(position).get("question1"));
			holder.delete.setTag(position);
			holder.detail.setTag(position);
			holder.state.setTag(position);
			holder.state.setOnClickListener(new stateListener(position, holder.state));
			holder.detail.setOnClickListener(new detailListener(position, holder.detail));
			holder.delete.setOnClickListener(new deleteListener(position, holder.delete));
			return convertView;

		}

	}

	// 状态按钮监听器
	private class stateListener implements OnClickListener {
		private int position;
		private Button btn;

		public stateListener(int inposition, Button currentBtn) {
			this.position = position;
			this.btn = currentBtn;
		}

		@Override
		public void onClick(View v) {

			// switch(v.getId()){
			// case R.id.list_detail:
			// Intent intent =new Intent();
			// intent.setClass(LookQues.this, QuesDetail.class);
			// startActivity(intent);
			// break;
			// case R.id.list_state:
			// Button list_state=(Button)findViewById(R.id.list_state);
			btn.setText("已解决");
			btn.setTextColor(0xffa0a0a0);
			// break;
			// default:
			// break;
		}

	}

	// 详情按钮监听器
	private class detailListener implements OnClickListener {
		private int position;
		private Button btn;

		public detailListener(int inposition, Button currentBtn) {
			this.position = position;
			this.btn = currentBtn;
		}

		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(LookQues.this, QuesDetail.class);
			startActivity(intent);

		}

	}

	// 删除按钮监听器
	private class deleteListener implements OnClickListener {
		private int position;
		private Button btn;

		public deleteListener(int inposition, Button currentBtn) {
			this.position = position;
			this.btn = currentBtn;
		}

		@Override
		public void onClick(View v) {
			// 删除当前item
			mData.remove(position);
			// 动态刷新listview
			adapter.notifyDataSetChanged();

		}

	}

	public final class ViewHolder {
		public TextView questions;
		public Button detail;
		public Button state;
		public Button delete;
	}

}
