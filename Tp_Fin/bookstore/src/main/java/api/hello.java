package api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class hello {
	@GET
	@Path("/print") // -> chemin vers notre api http://localhost:8080 + rest-lesson + /api/ + 
    @Produces({ MediaType.APPLICATION_JSON }) // -> renvoyé
	public String getHelloWorld() {
		return "Je m'appelle christopher";
	}
}