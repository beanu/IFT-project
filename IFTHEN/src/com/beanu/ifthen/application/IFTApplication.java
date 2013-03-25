package com.beanu.ifthen.application;

import android.app.Application;

import com.beanu.ifthen.dao.DBAdapter;
import com.beanu.ifthen.dao.Dao;
import com.beanu.ifthen.dao.DaoImpl;

public class IFTApplication extends Application {

	public DBAdapter adapter;

	@Override
	public void onCreate() {
		super.onCreate();
		adapter = new DBAdapter(getApplicationContext());
		DaoImpl impl = (DaoImpl) Dao.instance;
		impl.setIO(adapter);
	}

}
