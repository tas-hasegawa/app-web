package app;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("")
public class AppConfig extends ResourceConfig {

    public AppConfig() {
        packages(false, this.getClass().getPackage().getName() + ".controller");
    }

}
