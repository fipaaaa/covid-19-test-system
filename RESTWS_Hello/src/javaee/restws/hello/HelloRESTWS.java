package javaee.restws.hello;
import java.util.List;

import javax.persistence.*;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import model.UserInfo;

@Path("/helloworld")
public class HelloRESTWS {

	@GET
	@Path("/sayHi")
	@Produces("text/plain") 
	public String sayHi(@QueryParam("stunumber") String stu_number) { 
		EntityManagerFactory factory =
			       Persistence.createEntityManagerFactory("javaee_zth",null);
			       EntityManager manager = factory.createEntityManager();
 	  Query query = manager.createQuery("Select u from UserInfo u where u.stuNumber=?1");
 	  query.setParameter(1,stu_number);
 	  List<UserInfo> results=query.getResultList();
 	   String name;
 	  if(results.isEmpty()){
 		  name="none";
 	  }
 	  else{
 	  UserInfo user=results.get(0);
	  name=user.getName();
 	  }
	return name;
	}
	

	
}