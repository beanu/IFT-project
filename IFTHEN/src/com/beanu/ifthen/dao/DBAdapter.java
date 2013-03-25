package com.beanu.ifthen.dao;

import android.content.Context;
import android.database.SQLException;

import com.beanu.ifthen.bean.DBItem;

public class DBAdapter {
	private SQLiteUtil dbHelper;
	// DAO
	private IFTDAO iftDao;

	public DBAdapter(Context context) {
		dbHelper = new SQLiteUtil(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

	public IFTDAO getIFTDao() {
		if (iftDao == null) {
			iftDao = new IFTDAO(dbHelper);
		}
		return iftDao;
	}

}
