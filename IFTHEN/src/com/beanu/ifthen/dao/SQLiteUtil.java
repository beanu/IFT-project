package com.beanu.ifthen.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLiteUtil extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;

	public static final String ENCODE = "UTF_8";
	public static final String DB_NAME = "ifthen.db";

	public static final String TABLE_IFTHEN = "ifthen";
	public static final String IFTHEN_ID = "id";
	public static final String IFTHEN_A = "a";
	public static final String IFTHEN_ATYPE = "atype";
	public static final String IFTHEN_CONTENT = "content";
	public static final String IFTHEN_B = "b";
	public static final String IFTHEN_BTYPE = "btype";
	public static final String IFTHEN_STATE = "state";

	// Database creation sql statement
	private static final String TABLE_CREATE_HOME = "create table if not exists "
			+ TABLE_IFTHEN
			+ " ("
			+ IFTHEN_ID
			+ " integer primary key,"
			+ IFTHEN_A
			+ " varchar,"
			+ IFTHEN_ATYPE
			+ " varchar,"
			+ IFTHEN_CONTENT
			+ " varchar,"
			+ IFTHEN_B
			+ " varchar,"
			+ IFTHEN_BTYPE + " varchar," + IFTHEN_STATE + " varchar)";

	public SQLiteUtil(Context context) {
		super(context, DB_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(TABLE_CREATE_HOME);
		Log.d("mengyou", "DB 数据库被创建");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(SQLiteUtil.class.getName(), "Upgrading database from version "
				+ oldVersion + " to " + newVersion
				+ ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_IFTHEN);
		onCreate(db);
	}

}
