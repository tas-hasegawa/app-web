package app;

import interceptor.InterceptorBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import javax.ws.rs.ApplicationPath;

/**
 * RESTリクエストを受け付けるサーブレットコンテナーです。
 *
 * @author Hiroshi hASEGAWA
 */
public class AppServletContainer extends ServletContainer {

    public AppServletContainer() {
        super(new AppConfig());
    }

    /**
     * リソースクラス（コントローラクラス）に対する
     * 各種設定情報を定義するConfigクラスです。
     */
    @ApplicationPath("/resource")
    public static class AppConfig extends ResourceConfig {
        public AppConfig() {
            packages(getClass().getPackage().getName());
            register(new InterceptorBinder());
        }
    }
}
