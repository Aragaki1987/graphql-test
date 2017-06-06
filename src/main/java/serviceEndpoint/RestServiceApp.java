package serviceEndpoint;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


@ApplicationPath("graphqlserver")
public class RestServiceApp extends Application {
	
	private Set<Object> singletons = new HashSet<Object>();

	public RestServiceApp() {
		singletons.add(new RestService());
		singletons.add(new GraphqlService());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
