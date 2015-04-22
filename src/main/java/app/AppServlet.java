package app;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import javax.ws.rs.ApplicationPath;

/**
 * REST���N�G�X�g���󂯕t����T�[�u���b�g�N���X�ł��B
 *
 * @author Hasegawa HIROSHI
 */
public class AppServlet extends ServletContainer {

    public AppServlet() {
        super(new AppConfig());
    }

    /**
     * JAX-RS(Jersey)�ɂ�����AResource�̐ݒ�N���X�ł��B
     */
    @ApplicationPath("/resource")
    public static class AppConfig extends ResourceConfig {
        public AppConfig() {
            packages(getClass().getPackage().getName());
        }
    }
}
