package hello;

public class AgentDTO 
{
	 private String name;
	    
    private String email; 
	    
    private String location; 
	    
    private String kind; 
	    
    private String kindCode;
    
    private String id;
    
    public AgentDTO(){}
    
    public AgentDTO(User u)
    {
    	this.email=u.getEmail();
    	this.kind=u.getKind();
    	this.kindCode=u.getKindCode();
    	this.location="";
    	if(u.getLocation()!=null)
    		this.location=u.getLocation();
    	this.name=u.getName();
    	this.id=u.getId();
    }
    
}
