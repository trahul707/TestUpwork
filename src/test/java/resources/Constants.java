package resources;

public enum Constants {

	Create("/posts"),
	Read("/posts"),
	Update("/posts"),
	Delete("/posts");
	private String resource;
	
	Constants(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}
	
}
