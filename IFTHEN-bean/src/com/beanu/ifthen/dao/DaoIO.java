package com.beanu.ifthen.dao;

import com.beanu.ifthen.bean.DBItem;

/**
 * 数据的读取操作
 * 
 * @author beanu
 * 
 */
public interface DaoIO {

	public void saveDBItem(DBItem item);

	public DBItem getDBItem(long id);
}
