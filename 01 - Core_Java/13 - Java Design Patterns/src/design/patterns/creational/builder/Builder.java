package design.patterns.creational.builder;

interface Builder {
	
	public void buildFloor(); 
	  
    public void buildWalls(); 
  
    public void bulidTerrace(); 
  
  
    public Home getComplexHomeObject();  
	
}
