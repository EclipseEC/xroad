package ee.cyber.camins.services;

import java.time.LocalDateTime;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/rest")
public class RESTService {

    @GET
    @Path("/ping")
    public String ping() {
        return "pong";
    }

    @GET
    @Path("/time")
    public String time() {
        return LocalDateTime.now().toString();
    }
}
