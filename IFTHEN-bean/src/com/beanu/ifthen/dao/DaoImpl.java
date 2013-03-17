package com.beanu.ifthen.dao;

import com.beanu.ifthen.bean.DBItem;

/**
 * 实现接口
 * 
 * @author beanu
 * 
 */

public class DaoImpl implements Dao {

	private DaoIO io;

	public void setIO(DaoIO io) {
		this.io = io;
	}

	@Override
	public void saveDBItem(DBItem item) {
		this.io.saveDBItem(item);
	}

	@Override
	public DBItem getDBItem(long id) {
		return this.io.getDBItem(id);
	}

}
