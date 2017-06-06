package serviceEndpoint;



import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import entities.WatchList;


@Path("/main")
public class RestService{
	

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testRestService(){

		String s = "rest works!";
		return s;
	}
	
	@Path("/get")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public WatchList getWatchList(){
		
		WatchList wl = new WatchList();
		wl.setId(1);
		wl.setName("test name");
		
		return wl;
	}	
	

	
	

}
