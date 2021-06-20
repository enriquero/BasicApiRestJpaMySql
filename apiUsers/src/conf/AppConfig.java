package conf;

import org.glassfish.jersey.server.ResourceConfig;

import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("rest")
public class AppConfig extends ResourceConfig {
	
	public AppConfig() {
		register(new MyApplicationBinder());
		packages(true, "rest.recursos");
	}
}