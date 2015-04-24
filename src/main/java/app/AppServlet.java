package app;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import javax.ws.rs.ApplicationPath;

/**
 * RESTリクエストを受け付けるサーブレットクラスです。
 *
 * @author Hasegawa HIROSHI
 */
public class AppServlet extends ServletContainer {

    public AppServlet() {
        super(new AppConfig());
    }

    /**
     * JAX-RS(Jersey)における、Resourceの設定クラスです。
     */
    @ApplicationPath("/resource")
    public static class AppConfig extends ResourceConfig {
        public AppConfig() {
            packages(getClass().getPackage().getName());
        }
    }
}
