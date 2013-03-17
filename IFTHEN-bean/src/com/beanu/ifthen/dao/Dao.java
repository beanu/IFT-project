package com.beanu.ifthen.dao;

import com.beanu.ifthen.bean.DBItem;

/**
 * 所有的数据操作
 * 
 * @author beanu
 * 
 */
public interface Dao {

	public static Dao instance = new DaoImpl();

	public void saveDBItem(DBItem item);

	public DBItem getDBItem(long id);

	// public AReceiveSms creatAReceiveSms();
	//
	// public AReceiveSms.Builder getAReceiveSmsBuilder(AReceiveSms ars);
}
