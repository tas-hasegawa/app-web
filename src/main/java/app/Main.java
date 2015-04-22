package app;

import org.apache.catalina.Context;
import org.apache.catalina.servlets.DefaultServlet;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

/**
 * �g�ݍ���Tomcat�̎��s�N���X�ł��B
 *
 * @author Hasegawa HIROSHI
 */
public class Main {

    /**
     * Tomcat���N�����܂��B
     * @param args ���s������
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();

        // �|�[�g�̐ݒ�
        tomcat.setPort(8080);

        // �R���e�L�X�g���[�g�p�X���w��
        File base = new File("src/main/webapp/");
        Context context = tomcat.addContext("/app", base.getAbsolutePath());

        // �ÓI�t�@�C���ւ̃}�b�s���O
        Tomcat.addServlet(context, "default", new DefaultServlet()).addMapping("/static/*");

        // REST���N�G�X�g�̑����ƂȂ�T�[�u���b�g��o�^�B
        Tomcat.addServlet(context, "jersey-container-servlet", new AppServlet());
        context.addServletMapping("/*", "jersey-container-servlet");

        // Tomcat�̋N��
        tomcat.start();
        tomcat.getServer().await();
    }
}
