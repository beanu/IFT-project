package com.beanu.ifthen.dao;

import android.content.Context;

public class DBAdapter {
	private SQLiteUtil dbHelper;
	// DAO
	private IFTDAO iftDao;
	private BoutiqueDAO boutiqueDao;

	public DBAdapter(Context context) {
		dbHelper = SQLiteUtil.getInstance(context);
	}

	// public void open() throws SQLException {
	// database = dbHelper.getWritableDatabase();
	// }

	public void close() {
		dbHelper.close();
	}

	public IFTDAO getIFTDao() {
		if (iftDao == null) {
			iftDao = new IFTDAO(dbHelper);
		}
		return iftDao;
	}

	public BoutiqueDAO getBoutiqueDao() {
		if (boutiqueDao == null) {
			boutiqueDao = new BoutiqueDAO(dbHelper);
		}
		return boutiqueDao;
	}

}
