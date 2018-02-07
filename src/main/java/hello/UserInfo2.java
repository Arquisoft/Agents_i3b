package hello;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "users")
public class UserInfo2 {

    // Log
    private static final Logger LOG = LoggerFactory.getLogger(UserInfo2.class);

    @Id
    private String id;
    
	private String password;
    
    private String name;
    
    private String email; 
    
    private String location; 
    
    private String kind; 
    
    private String kindCode; 

    private UserInfo2() {}
	
	public UserInfo2(String id,String passw ,String name,String email, String location, String kind) {
        this.id=id;
        this.password=passw;
		this.name = name;
        this.email = email;
        this.location=location;
        this.kind=kind;
    }

    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getId() {
		return id;
	}

	public String getKindCode() {
		try {
		BufferedReader br =new BufferedReader(new FileReader("Libro1.csv"));
        String line = br.readLine();
        while (null!=line) {
           String [] fields = line.split(";");
           if(this.kind==fields[1])
           {
        	   return fields[0];
           }
        }
		}catch(IOException e)
		{
			LOG.error(e.getMessage(), e);
		}
        return null;
	}

    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfo2 other = (UserInfo2) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserInfo [ID=" + id + ", password=" + password + ", location=" + location + ", kind=" + kind
				+ ", kindCode=" + kindCode + ", name=" + name+ ", email=" + email + "]";
	}

}