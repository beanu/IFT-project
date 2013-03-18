package com.beanu.ifthen.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.beanu.ifthen.bean.DBItem;

public class IFTDAO {
	// Database fields
	private SQLiteDatabase mDatabase;
	private SQLiteUtil mSQLitehelper;

	private String[] allColumns = { SQLiteUtil.IFTHEN_ID, SQLiteUtil.IFTHEN_A,
			SQLiteUtil.IFTHEN_ATYPE, SQLiteUtil.IFTHEN_CONTENT,
			SQLiteUtil.IFTHEN_B, SQLiteUtil.IFTHEN_BTYPE,
			SQLiteUtil.IFTHEN_STATE };

	public IFTDAO(SQLiteUtil helper) {
		mSQLitehelper = helper;
		mDatabase = mSQLitehelper.getWritableDatabase();
	}

	public void insert(DBItem item) {
		mDatabase = mSQLitehelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(SQLiteUtil.IFTHEN_ID, item.getId());
		values.put(SQLiteUtil.IFTHEN_A, item.getA());
		values.put(SQLiteUtil.IFTHEN_ATYPE, item.getaType());
		values.put(SQLiteUtil.IFTHEN_CONTENT, item.getContent());
		values.put(SQLiteUtil.IFTHEN_B, item.getB());
		values.put(SQLiteUtil.IFTHEN_BTYPE, item.getbType());
		values.put(SQLiteUtil.IFTHEN_STATE, item.getState());

		mDatabase.insert(SQLiteUtil.TABLE_IFTHEN, null, values);
		mDatabase.close();
	}

	public void delete(DBItem item) {
		mDatabase = mSQLitehelper.getWritableDatabase();
		long id = item.getId();
		mDatabase.delete(SQLiteUtil.TABLE_IFTHEN, SQLiteUtil.IFTHEN_ID + " = "
				+ id, null);
		mDatabase.close();
	}

	public DBItem select(long id) {
		mDatabase = mSQLitehelper.getWritableDatabase();
		Cursor cursor = mDatabase.query(SQLiteUtil.TABLE_IFTHEN, allColumns,
				SQLiteUtil.IFTHEN_ID + "=?",
				new String[] { String.valueOf(id) }, null, null, null);
		DBItem item = null;
		if (cursor.moveToNext()) {
			item = cursorToItem(cursor);
		}
		cursor.close();
		mDatabase.close();
		return item;
	}

	public void update(DBItem item) {
		mDatabase = mSQLitehelper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(SQLiteUtil.IFTHEN_A, item.getA());
		values.put(SQLiteUtil.IFTHEN_ATYPE, item.getaType());
		values.put(SQLiteUtil.IFTHEN_CONTENT, item.getContent());
		values.put(SQLiteUtil.IFTHEN_B, item.getB());
		values.put(SQLiteUtil.IFTHEN_BTYPE, item.getbType());
		values.put(SQLiteUtil.IFTHEN_STATE, item.getState());

		mDatabase.update(SQLiteUtil.TABLE_IFTHEN, values, SQLiteUtil.IFTHEN_ID
				+ "=?", new String[] { String.valueOf(item.getId()) });
		mDatabase.close();
	}

	public void deleteAll() {
		mDatabase = mSQLitehelper.getWritableDatabase();
		mDatabase.delete(SQLiteUtil.TABLE_IFTHEN, null, null);
		mDatabase.close();
	}

	public List<DBItem> getAll() {
		mDatabase = mSQLitehelper.getWritableDatabase();
		List<DBItem> list = new ArrayList<DBItem>();

		Cursor cursor = mDatabase.query(SQLiteUtil.TABLE_IFTHEN, allColumns,
				null, null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			DBItem item = cursorToItem(cursor);
			list.add(item);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		mDatabase.close();
		return list;
	}

	private DBItem cursorToItem(Cursor cursor) {
		DBItem item = new DBItem();
		item.setId(cursor.getLong(0));
		item.setA(cursor.getString(1));
		item.setaType(cursor.getString(2));
		item.setContent(cursor.getString(3));
		item.setB(cursor.getString(4));
		item.setbType(cursor.getString(5));
		item.setState(cursor.getString(6));
		return item;
	}
}
