package app;

import interceptor.InterceptorBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import javax.ws.rs.ApplicationPath;

public class AppServlet extends ServletContainer {

    public AppServlet() {
        super(new AppConfig());
    }

    @ApplicationPath("/resource")
    public static class AppConfig extends ResourceConfig {
        public AppConfig() {
            packages(getClass().getPackage().getName());
            register(new InterceptorBinder());
        }
    }
}
