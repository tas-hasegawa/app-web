package app;

import org.apache.catalina.Context;
import org.apache.catalina.servlets.DefaultServlet;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

/**
 * 組み込みTomcatの実行クラスです。
 *
 * @author Hasegawa HIROSHI
 */
public class Main {

    /**
     * Tomcatを起動します。
     * @param args 実行時引数
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();

        // ポートの設定
        tomcat.setPort(8080);

        // コンテキストルートパスを指定
        File base = new File("src/main/webapp/");
        Context context = tomcat.addContext("/app", base.getAbsolutePath());

        // 静的ファイルへのマッピング
        Tomcat.addServlet(context, "default", new DefaultServlet()).addMapping("/static/*");

        // RESTリクエストの窓口となるサーブレットを登録。
        Tomcat.addServlet(context, "jersey-container-servlet", new AppServletContainer());
        context.addServletMapping("/*", "jersey-container-servlet");

        // Tomcatの起動
        tomcat.start();
        tomcat.getServer().await();
    }
}
