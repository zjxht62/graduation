package com.tan.boom;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBHelper extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 1;
	public static final String CREATE_USERS = "create table if not exists users ("
			+ "id INTEGER PRIMARY KEY AUTOINCREMENT," + "username VARCHAR, " + "password VARCHAR)";
	public static final String CREATE_BAS_ACCESSORY = "create table if not exists bas_accessory ("
			+ "oid varchar(32) primary key not null," + "refoid varchar(32), " + "reftype char(1), "
			+ "filename varchar(100), " + "filepath varchar(200), " + "filetype varchar(10), "
			+ "uploaduser varchar(32), " + "uploaddate date, " + "relaycontent varchar(500), "
			+ "relayer varchar(100), " + "content varchar(500)) ";
	// + "password VARCHAR)";
	public static final String CREATE_PM_TOPIC_INFO = "create table if not exists pm_topic_info ("
			+ "oid varchar(32) primary key not null," + "topic_name varchar(100) not null,"
			+ "planner varchar(32) not null, " + "apply_person varchar(500), " + "plan_date date not null, "
			+ "planbook_id varchar(32), " + "train_purpose varchar(500), " + "topic_target varchar(500), "
			+ "summary_content varchar(2000), " + "task_require varchar(2000), " + "topic_period varchar(100), "
			+ "schedule_plan varchar(500), " + "topic_outline varchar(2000), " + "status char(1) not null, "
			+ "fixed_name_type char(2), " + "verify_reason varchar(200), " + "start_date date, "
			+ "topic_type char(2) not null) ";
	// + "password VARCHAR)";
	public static final String CREATE_PM_QUESTION = "create table if not exists pm_question ("
			+ "oid varchar(32) primary key not null," + "content varchar(1000), " + "asker varchar(32), "
			+ "answer varchar(32), " + "askdate date, " + "state char(1), " + "relaycontent varchar(1000), "
			+ "refoid varchar(32), " + "qtype char(1)) ";
	// + "password VARCHAR)";
	public static final String CREATE_PM_QUESTION_DETAIL = "create table if not exists pm_question_detail ("
			+ "oid varchar(32) not null," + "qid varchar(32) not null," + "qaid char(3), " + "content varchar(1000), "
			+ "qaname varchar(32), " + "qadate date, " + "qakbn char(1)," + "primary key (oid,qid))";
	public static final String CREATE_PM_QUESTION_MANAGE = "create table if not exists pm_question_manage ("
			+ "oid varchar(32) not null," + "qid varchar(32) not null," + "title varchar(100), "
			+ "content varchar(1000), " + "state char(1), " + "refoid varchar(32), " + "qtype char(1), "
			+ "askdate date, " + "asker varchar(32), " + "answer varchar(32), " + "system_type char(2),"
			+ "primary key (oid,qid))";
	private Context mContext;

	public DBHelper(Context context, String name, CursorFactory factory, int version) {
		// CursorFactory����Ϊnull,ʹ��Ĭ��ֵ
		super(context, name, factory, version);
		mContext = context;
	}

	// ���ݿ��һ�α�����ʱonCreate�ᱻ����
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_USERS);
		db.execSQL(CREATE_BAS_ACCESSORY);
		db.execSQL(CREATE_PM_TOPIC_INFO);
		db.execSQL(CREATE_PM_QUESTION);
		db.execSQL(CREATE_PM_QUESTION_DETAIL);
		db.execSQL(CREATE_PM_QUESTION_MANAGE);
		db.execSQL(
				"insert into pm_topic_info values('1', '���ݽṹ','�պ�','����','2013-9-1','���ݽṹ���㷨','ѵ��Ŀ��','�γ�Ŀ��','��Ҫ����','����Ҫ��','��������','���ȹ滮','������','1','����','��ͨ��ԭ��','2013-9-1','01')");
		// db.execSQL("insert into pm_question values('1',
		// '���ǲ���ɵ','����','������','2013-9-1','1','���tmɵ��','1','1')");

		db.execSQL("insert into users(username, password) values('zjx', '123456')");
		db.execSQL("insert into users(username, password) values('wjc', 'ffffff')");
		db.execSQL("insert into users(username, password) values('honoka', '0803')");
		db.execSQL("insert into users(username, password) values('umi', '0315')");

		Toast.makeText(mContext, "create succesed", Toast.LENGTH_SHORT).show();
	}

	// ���DATABASE_VERSIONֵ����Ϊ2,ϵͳ�����������ݿ�汾��ͬ,�������onUpgrade
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table if exists Users");
		onCreate(db);
		// db.execSQL("ALTER TABLE users ADD COLUMN other STRING");
	}
}
