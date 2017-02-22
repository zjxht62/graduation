package com.tan.boom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

//查看文件目录
public class LookFile extends Activity {
	private List<Map<String, Object>> mData = new ArrayList<Map<String, Object>>();
	Myadapterfile adapter = null;

	// 文件名和时间
	public static String filename[] = new String[] { "会议纪要", "总结" };
	public static String time[] = new String[] { "2016-11-11", "2016-5-21" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.lookfile);
		Button lookfile_back = (Button) findViewById(R.id.lookfile_back);
		// 结束当前界面
		lookfile_back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				LookFile.this.finish();

			}
		});
		mData = getData1();
		ListView listView = (ListView) findViewById(R.id.lookfile_list);
		adapter = new Myadapterfile(this);
		listView.setAdapter(adapter);
	}

	// 获取动态数据 可以又其他地方传来（json等）
	private List<Map<String, Object>> getData1() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < filename.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("filename", filename[i]);
			map.put("time", time[i]);
			list.add(map);
		}
		return list;
	}

	//// public void showInfo(final int position){
	//// new AlertDialog.Builder(this).setTitle("提示").setMessage("确定要删除吗？")
	//// .setPositiveButton("确定",new DialogInterface.OnClickListener(){
	////
	//// @Override
	//// public void onClick(DialogInterface dialog, int which) {
	//// mData.remove(position);
	//// ListView listView=(ListView)findViewById(R.id.lookfile_list);
	//// listView.setAdapter(adapter);
	////
	//// }
	////
	//// }).show();
	//// }
	//
	public class Myadapterfile extends BaseAdapter {

		private LayoutInflater mInflater;

		public Myadapterfile(LookFile lookFile) {
			this.mInflater = LayoutInflater.from(lookFile);

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
				convertView = mInflater.inflate(R.layout.lookfile_visit, null);
				holder.filename = (TextView) convertView.findViewById(R.id.file_name);
				holder.time = (TextView) convertView.findViewById(R.id.file_time);
				holder.deletefile = (Button) convertView.findViewById(R.id.file_delete);
				holder.download = (Button) convertView.findViewById(R.id.file_download);
				convertView.setTag(holder);

			} else {
				holder = (ViewHolder) convertView.getTag();

			}
			holder.filename.setText((String) mData.get(position).get("filename"));
			holder.time.setText((String) mData.get(position).get("time"));
			holder.deletefile.setTag(position);
			holder.download.setTag(position);
			// 给Buton添加单击事件 添加Button之后ListView将失去焦点  需要的直接把Button的焦点去掉
			holder.deletefile.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// 删除当前item项
					mData.remove(position);
					// 动态刷新listview
					adapter.notifyDataSetChanged();

				}

			});
			return convertView;
		}

	}

	public final class ViewHolder {
		public TextView filename;
		public Button deletefile;
		public Button download;
		public TextView time;
	}
	// public void showInfo(int position){
	// new
	// AlertDialog.Builder(this).setMessage(filename[position]+"正在下载").show();
	// }
}
