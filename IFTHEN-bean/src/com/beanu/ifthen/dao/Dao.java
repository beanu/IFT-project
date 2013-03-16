package com.beanu.ifthen.dao;


public interface Dao {

	public static Dao instance = new DaoImpl();

	public void setAll(All all);

	public All getAll();

	public All.Builder getBuild();

	public void buildAll();

	public void setIO(DaoIO io);

	public void save();

	public void read();

	public Trigger createTri(String _if);

	public void saveTri(Trigger tri);

	public Trigger getTrigger(long id);

	public Trigger.Builder getTriggerBuilder(Trigger tri);
}
