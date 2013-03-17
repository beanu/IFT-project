package com.beanu.ifthen.dao;

import com.beanu.ifthen.bean.DBItem;

import android.content.Context;

public class DBAdapter implements DaoIO {
	private SQLiteUtil dbHelper;
	// DAO
	private IFTDAO iftDao;

	// private BoutiqueDAO boutiqueDao;

	public DBAdapter(Context context) {
		dbHelper = SQLiteUtil.getInstance(context);
	}

	// public void open() throws SQLException {
	// database = dbHelper.getWritableDatabase();
	// }

	// private void close() {
	// dbHelper.close();
	// }

	private IFTDAO getIFTDao() {
		if (iftDao == null) {
			iftDao = new IFTDAO(dbHelper);
		}
		return iftDao;
	}

	// private BoutiqueDAO getBoutiqueDao() {
	// if (boutiqueDao == null) {
	// boutiqueDao = new BoutiqueDAO(dbHelper);
	// }
	// return boutiqueDao;
	// }

	/** =============================实现DaoIO=================================== */

	@Override
	public void saveDBItem(DBItem item) {
		if (getIFTDao().select(item.getId()) == null) {
			getIFTDao().insert(item);
		} else {
			getIFTDao().update(item);
		}
	}

	@Override
	public DBItem getDBItem(long id) {
		return getIFTDao().select(id);
	}

}
