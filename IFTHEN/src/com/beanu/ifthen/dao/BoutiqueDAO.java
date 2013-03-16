package com.beanu.ifthen.dao;

//TODO delete
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class BoutiqueDAO {
	// Database fields
	private SQLiteDatabase mDatabase;
	private SQLiteUtil mSQLitehelper;

	private String[] allColumns = {};

	public BoutiqueDAO(SQLiteUtil helper) {
		mSQLitehelper = helper;
		mDatabase = mSQLitehelper.getWritableDatabase();
	}

	public void insertBoutique(String appid, String minimg, String midimg,
			String maximg) {
		mDatabase = mSQLitehelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		// values.put(SQLiteUtil.BOUTIQUE_APPID, appid);
		// values.put(SQLiteUtil.BOUTIQUE_MINIMG, minimg);
		// values.put(SQLiteUtil.BOUTIQUE_MIDIMG, midimg);
		// values.put(SQLiteUtil.BOUTIQUE_MAXIMG, maximg);
		// mDatabase.insert(SQLiteUtil.TABLE_HOME_BOUTIQUE, null, values);
	}

	public void deleteAllBoutique() {
		mDatabase = mSQLitehelper.getWritableDatabase();
		// mDatabase.delete(SQLiteUtil.TABLE_HOME_BOUTIQUE, null, null);
	}

	public List<Map<String, String>> getAllBoutique() {
		mDatabase = mSQLitehelper.getWritableDatabase();
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();

		// Cursor cursor = mDatabase.query(SQLiteUtil.TABLE_HOME_BOUTIQUE,
		// allColumns, null, null, null, null, null);
		//
		// cursor.moveToFirst();
		// while (!cursor.isAfterLast()) {
		// Map<String, String> map = new HashMap<String, String>();
		// map.put(SQLiteUtil.BOUTIQUE_APPID, cursor.getString(1));
		// map.put(SQLiteUtil.BOUTIQUE_MINIMG, cursor.getString(2));
		// map.put(SQLiteUtil.BOUTIQUE_MIDIMG, cursor.getString(3));
		// map.put(SQLiteUtil.BOUTIQUE_MAXIMG, cursor.getString(4));
		// list.add(map);
		// cursor.moveToNext();
		// }
		// Make sure to close the cursor
		// cursor.close();
		return list;
	}

}
