package hello;

public class AgentDTO 
{
	private String id;
	private String name;    
    private String email;     
    private String location;     
    private String kind;     
    private String kindCode;
    
    
    public AgentDTO(){}
    
    public AgentDTO(UserInfo2 u)
    {
    	this.id=u.getId();
    	this.name=u.getName();
    	this.email=u.getEmail();
    	this.location=u.getLocation();
    	this.kind=u.getKind();
    	this.kindCode=u.getKindCode();
    	
    	
    }
    
}
