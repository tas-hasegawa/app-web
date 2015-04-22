package app;

import org.apache.catalina.Context;
import org.apache.catalina.servlets.DefaultServlet;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        File base = new File("src/main/webapp/");
        Context context = tomcat.addContext("/app", base.getAbsolutePath());

        Tomcat.addServlet(context, "default", new DefaultServlet()).addMapping("/static/*");
        Tomcat.addServlet(context, "jersey-container-servlet", new AppServlet());
        context.addServletMapping("/*", "jersey-container-servlet");

        tomcat.start();
        tomcat.getServer().await();
    }
}
