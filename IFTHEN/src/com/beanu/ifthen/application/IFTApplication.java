package com.beanu.ifthen.application;

import com.beanu.ifthen.dao.DBAdapter;
import com.beanu.ifthen.dao.Dao;
import com.beanu.ifthen.dao.DaoImpl;

import android.app.Application;

public class IFTApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		DBAdapter adapter = new DBAdapter(getApplicationContext());
		DaoImpl impl = (DaoImpl) Dao.instance;
		impl.setIO(adapter);
	}

}
