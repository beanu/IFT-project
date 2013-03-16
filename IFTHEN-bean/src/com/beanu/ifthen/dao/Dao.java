package com.beanu.ifthen.dao;

import com.beanu.ifthen.bean.DBItem;

public interface Dao {

	public static Dao instance = new DaoImpl();

	public void saveDBItem(DBItem item);

	public DBItem getIFT(long id);

//	public AReceiveSms creatAReceiveSms();
//
//	public AReceiveSms.Builder getAReceiveSmsBuilder(AReceiveSms ars);
}
