package com.beanu.ifthen.dao;


public class DaoImpl implements Dao {

	private All it;
	private All.Builder itBuilder;
	private DaoIO io;

	protected DaoImpl() {}

	@Override
	public All getAll() {
		return it;
	}

	@Override
	public void setAll(All it) {
		this.it = it;
		this.itBuilder = it.toBuilder();
	}

	@Override
	public Builder getBuild() {
		return itBuilder;
	}

	public void setIO(DaoIO io) {
		this.io = io;
	}

	@Override
	public void save() {
		this.io.save(this);
	}

	@Override
	public void read() {
		this.io.read(this);
	}

	@Override
	public Trigger createTri(String _if) {
		Trigger tri = Trigger.newBuilder().setId(System.currentTimeMillis())
				.setIf(_if).setSwitch(false).build();
		return tri;
	}

	@Override
	public void saveTri(Trigger tri) {
		itBuilder.addTrigger(tri);
		it = itBuilder.build();
		this.save();
	}

	@Override
	public void buildAll() {
		it = itBuilder.build();
		this.save();
	}

	@Override
	public Trigger.Builder getTriggerBuilder(Trigger tri) {
		for (Trigger.Builder builder : itBuilder.getTriggerBuilderList()) {
			if (builder.getId() == tri.getId()) {
				return builder;
			}
		}
		return null;
	}

	@Override
	public Trigger getTrigger(long id) {
		for (Trigger tri : it.getTriggerList()) {
			if (tri.getId() == id) {
				return tri;
			}
		}
		return null;
	}
}
