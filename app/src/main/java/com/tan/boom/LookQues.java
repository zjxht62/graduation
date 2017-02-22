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

//�鿴����Ŀ¼
public class LookQues extends Activity {
	private DBHelper dbHelper3;
	private SQLiteDatabase db3;

	// private PopWindow mTestPopwindow2 = null;
	//
	// private void InitUI() {
	// // ʵ����TestPopwindow2
	// mTestPopwindow2 = new PopWindow(this);
	// // ���õ������λ��mTestPopwindow2��ʧ
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
	// // location��ÿؼ���λ��
	// int[] location = new int[2];
	// View v = findViewById(R.id.list_delete);
	// if (v != null)
	// v.getLocationOnScreen(location); // �ؼ�����Ļ��λ��
	// mTestPopwindow2.setAnimationStyle(R.style.AppBaseTheme);
	//
	// // mTestPopwindow2������ĳ�ؼ�(button)������
	// mTestPopwindow2.showAtLocation(v, Gravity.TOP | Gravity.LEFT,
	// location[0] - v.getWidth(), location[1] + v.getHeight());
	// }
	//
	// // mTestPopwindow2���ֿؼ��ļ���
	// public void OnclickTestListener(View view) {
	// switch (view.getId()) {
	// case R.id.layoutSeclect1:
	// Toast.makeText(this, "����", Toast.LENGTH_SHORT).show();
	// break;
	// case R.id.layoutSeclect2:
	// Toast.makeText(this, "ɾ��", Toast.LENGTH_SHORT).show();
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
	public static String question[] = new String[] { "��Ŀ�ϴ��ɹ����С������ô��", "����Excelģ�����ؽ���ͬ��������" };
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
		// ������ǰҳ��
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

	// ��ȡ��̬���� �����������ط�������json�ȣ�
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
			Toast.makeText(LookQues.this, "��������", Toast.LENGTH_SHORT).show();
		}

		// List<Map<String,Object>>list=new ArrayList<Map<String,Object>>();
		// for(int i=0;i<question.length;i++){
		// Map<String,Object>map=new HashMap<String,Object>();
		// map.put("question1", question[i]);
		// list.add(map);
		// }
		return list;
	}

	// listview������
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
				// ��visit�л�ȡview��֮���view���ظ�ListView
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

	// ״̬��ť������
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
			btn.setText("�ѽ��");
			btn.setTextColor(0xffa0a0a0);
			// break;
			// default:
			// break;
		}

	}

	// ���鰴ť������
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

	// ɾ����ť������
	private class deleteListener implements OnClickListener {
		private int position;
		private Button btn;

		public deleteListener(int inposition, Button currentBtn) {
			this.position = position;
			this.btn = currentBtn;
		}

		@Override
		public void onClick(View v) {
			// ɾ����ǰitem
			mData.remove(position);
			// ��̬ˢ��listview
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
