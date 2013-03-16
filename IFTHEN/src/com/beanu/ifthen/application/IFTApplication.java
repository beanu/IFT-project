package com.beanu.ifthen.application;

import android.app.Application;

import com.beanu.ifthen.dao.DBAdapter;

public class IFTApplication extends Application {

	public static IFTApplication instance;

	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
		dbAdapter = new DBAdapter(getApplicationContext());

	}

	// 数据库
	private DBAdapter dbAdapter;

	public DBAdapter getDbAdapter() {
		return dbAdapter;
	}

}
