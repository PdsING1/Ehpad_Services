package org.ServerModule;

import java.sql.Connection;
import java.util.List;

public abstract class AbDAO<Obj> {
	
	protected Connection connection;

	public AbDAO(Connection connection) {
		this.connection = connection;
		
	}
	
	public abstract Obj create(Obj obj);
	
	public abstract void update(Obj obj);
	
	public abstract void delete(Obj obj);	
	
	public abstract List<Obj> find(List<String> values);
	
	public abstract List<Obj> findAll();

}
