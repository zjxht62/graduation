package com.tan.boom;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

//��ҳ����ĸ�����
public class MainActivity extends FragmentActivity implements OnClickListener {

	// �ײ��˵�4��Linearlayout
	private LinearLayout ll_home;
	private LinearLayout ll_address;
	private LinearLayout ll_friend;
	private LinearLayout ll_setting;

	// �ײ��˵�4��ImageView
	private ImageView iv_home;
	private ImageView iv_address;
	private ImageView iv_friend;
	private ImageView iv_setting;

	// �ײ��˵�4���˵�����
	private TextView tv_home;
	private TextView tv_address;
	private TextView tv_friend;
	private TextView tv_setting;

	// 4��Fragment
	private Fragment homeFragment;
	private Fragment addressFragment;
	private Fragment friendFragment;
	private Fragment settingFragment;

	// // �м���������
	// private ViewPager viewPager;
	//
	// // ViewPager������ContentAdapter
	// private ContentAdapter adapter;
	//
	// private List<View> views;
	//// private PopWindow mPopwindow = null;
	//
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		// initUI();
		initView();
		initEvent();
		initFragment(0);
	}

	private void initFragment(int index) {
		// ������������V4���µ�Fragment����������Ĺ�����Ҫ��getSupportFragmentManager��ȡ
		FragmentManager fragmentManager = getSupportFragmentManager();
		// ��������
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		// ��������Fragment
		hideFragment(transaction);
		switch (index) {
		case 0:
			if (homeFragment == null) {
				homeFragment = new Fragment0();
				transaction.add(R.id.vp_content, homeFragment);
			} else {
				transaction.show(homeFragment);
			}
			break;
		case 1:
			if (addressFragment == null) {
				addressFragment = new Fragment1();
				transaction.add(R.id.vp_content, addressFragment);
			} else {
				transaction.show(addressFragment);
			}

			break;
		case 2:
			if (friendFragment == null) {
				friendFragment = new Fragment2();
				transaction.add(R.id.vp_content, friendFragment);
			} else {
				transaction.show(friendFragment);
			}

			break;
		case 3:
			if (settingFragment == null) {
				settingFragment = new Fragment3();
				transaction.add(R.id.vp_content, settingFragment);
			} else {
				transaction.show(settingFragment);
			}

			break;

		default:
			break;
		}

		// �ύ����
		transaction.commit();

	}

	private void hideFragment(FragmentTransaction transaction) {
		if (homeFragment != null) {
			transaction.hide(homeFragment);
		}
		if (addressFragment != null) {
			transaction.hide(addressFragment);
		}
		if (friendFragment != null) {
			transaction.hide(friendFragment);
		}
		if (settingFragment != null) {
			transaction.hide(settingFragment);
		}

	}

	//
	//// private void initUI() {
	//// // TODO Auto-generated method stub
	//// mPopwindow = new PopWindow(this);
	//// mPopwindow.setOnDismissListener(this);
	//// Button buttonadd = (Button)findViewById(R.id.btn_open);
	//// buttonadd.setOnClickListener(this);
	////
	//// }
	////
	//// private void OnPopwindowTest2(){
	//// if(mPopwindow==null)
	//// return;
	//// int[] location=new int[2];
	//// View v = findViewById(R.id.btn_open);
	//// if(v!=null)
	//// v.getLocationOnScreen(location);
	//// mPopwindow.setAnimationStyle(R.style.AppBaseTheme);
	//// mPopwindow.showAtLocation(v, Gravity.TOP |Gravity.LEFT,
	// location[0]-v.getWidth(), location[1]-35);
	//// }
	////
	//// public void OnclickTestListener(View view){
	//// switch(view.getId()){
	//// case R.id.layoutSeclect1:
	//// Toast.makeText(this, "�ϴ�", Toast.LENGTH_SHORT).show();
	//// break;
	//// default:
	//// break;
	//// }
	//// if(mPopwindow!=null)
	//// mPopwindow.dismiss();
	//// }
	//
	private void initEvent() {
		// ���ð�ť����
		ll_home.setOnClickListener(this);
		ll_address.setOnClickListener(this);
		ll_friend.setOnClickListener(this);
		ll_setting.setOnClickListener(this);
		//
		// //����ViewPager��������
		// viewPager.setOnPageChangeListener(this);
		//
		//
	}

	//
	private void initView() {
		// �ײ��˵�4��Linearlayout
		this.ll_home = (LinearLayout) findViewById(R.id.ll_home);
		this.ll_address = (LinearLayout) findViewById(R.id.ll_address);
		this.ll_friend = (LinearLayout) findViewById(R.id.ll_friend);
		this.ll_setting = (LinearLayout) findViewById(R.id.ll_setting);

		// �ײ��˵�4��ImageView
		this.iv_home = (ImageView) findViewById(R.id.iv_home);
		this.iv_address = (ImageView) findViewById(R.id.iv_address);
		this.iv_friend = (ImageView) findViewById(R.id.iv_friend);
		this.iv_setting = (ImageView) findViewById(R.id.iv_setting);

		// �ײ��˵�4���˵�����
		this.tv_home = (TextView) findViewById(R.id.tv_home);
		this.tv_address = (TextView) findViewById(R.id.tv_address);
		this.tv_friend = (TextView) findViewById(R.id.tv_friend);
		this.tv_setting = (TextView) findViewById(R.id.tv_setting);
		//
		// // �м���������ViewPager
		// this.viewPager = (ViewPager) findViewById(R.id.vp_content);
		//
		// // ������
		// View page_01 = View.inflate(MainActivity.this, R.layout.page_01,
		// null);
		// View page_02 = View.inflate(MainActivity.this, R.layout.page_02,
		// null);
		// View page_03 = View.inflate(MainActivity.this, R.layout.page_03,
		// null);
		// //View page_04 = View.inflate(MainActivity.this, R.layout.page_04,
		// null);
		//
		// views = new ArrayList<View>();
		// views.add(page_01);
		// views.add(page_02);
		// views.add(page_03);
		// //views.add(page_04);
		//
		// this.adapter = new ContentAdapter(views);
		// viewPager.setAdapter(adapter);
		//
	}

	//
	// /*@Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// // Inflate the menu; this adds items to the action bar if it is present.
	// getMenuInflater().inflate(R.menu.main, menu);
	// return true;
	// }*/
	//
	//// @Override
	//// public boolean onOptionsItemSelected(MenuItem item) {
	//// // Handle action bar item clicks here. The action bar will
	//// // automatically handle clicks on the Home/Up button, so long
	//// // as you specify a parent activity in AndroidManifest.xml.
	//// int id = item.getItemId();
	//// if (id == R.id.action_settings) {
	//// return true;
	//// }
	//// return super.onOptionsItemSelected(item);
	//// }
	//
	// @Override
	// public void onPageScrollStateChanged(int arg0) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void onPageScrolled(int arg0, float arg1, int arg2) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void onPageSelected(int arg0) {
	// restartBotton();
	// //��ǰview��ѡ���ʱ��,�ı�ײ��˵�ͼƬ��������ɫ
	// switch (arg0) {
	// case 0:
	// iv_home.setImageResource(R.drawable.tab_weixin_pressed);
	// tv_home.setTextColor(0xff019ec7);
	// break;
	// case 1:
	// iv_address.setImageResource(R.drawable.tab_address_pressed);
	// tv_address.setTextColor(0xff019ec7);
	// break;
	// case 2:
	// iv_friend.setImageResource(R.drawable.tab_find_frd_pressed);
	// tv_friend.setTextColor(0xff019ec7);
	// break;
	//// case 3:
	//// iv_setting.setImageResource(R.drawable.tab_find_frd_pressed);
	//// tv_setting.setTextColor(0xff019ec7);
	//// break;
	//
	// default:
	// break;
	// }
	//
	//
	// }
	//
	@Override
	public void onClick(View v) {
		// ��ÿ�ε�������еĵײ���ť(ImageView,TextView)��ɫ��Ϊ��ɫ��Ȼ����ݵ����ɫ
		restartBotton();
		// ImageView��TetxView��Ϊ��ɫ��ҳ����֮��ת
		switch (v.getId()) {
		case R.id.ll_home:
			iv_home.setImageResource(R.drawable.tab_setting_pressed);
			tv_home.setTextColor(0xff019ec7);
			initFragment(0);
			break;
		case R.id.ll_address:
			iv_address.setImageResource(R.drawable.tab_weixin_pressed);
			tv_address.setTextColor(0xff019ec7);
			initFragment(1);
			break;
		case R.id.ll_friend:
			iv_friend.setImageResource(R.drawable.tab_address_pressed);
			tv_friend.setTextColor(0xff019ec7);
			initFragment(2);
			break;
		// case R.id.btn_open:
		// OnPopwindowTest2();
		// break;
		case R.id.ll_setting:
			iv_setting.setImageResource(R.drawable.tab_find_frd_pressed);
			tv_setting.setTextColor(0xff019ec7);
			initFragment(3);
			break;

		default:
			break;
		}

	}

	//
	private void restartBotton() {
		// ImageView��Ϊ��ɫ
		iv_home.setImageResource(R.drawable.tab_setting_normal);
		iv_address.setImageResource(R.drawable.tab_weixin_normal);
		iv_friend.setImageResource(R.drawable.tab_address_normal);
		iv_setting.setImageResource(R.drawable.tab_find_frd_normal);
		// TextView��Ϊ��ɫ
		tv_home.setTextColor(0xff000000);
		tv_address.setTextColor(0xff000000);
		tv_friend.setTextColor(0xff000000);
		tv_setting.setTextColor(0xff000000);
	}
	//
	// @Override
	// public void onDismiss() {
	// // TODO Auto-generated method stub
	//
	// }

}
