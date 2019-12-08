package org.ClientModule;

public enum Queries {
	
	INSERT,
	SELECT,
	DELETE;
	
	public static Queries getQueries(String query)
	{
		Queries[] values = Queries.values();
		for(Queries value : values)
		{
			if(value.toString().equalsIgnoreCase(query))
				return value;
		}
		return null;
	}
}
