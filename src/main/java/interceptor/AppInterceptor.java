package interceptor;

import common.service.EntityService;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.lang.reflect.Method;

import static common.utils.StringUtils.*;

public class AppInterceptor implements MethodInterceptor {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();
        String executeClassName = method.getDeclaringClass().getName();
        String executeMethodName = method.getName();
        log.info(fmt("%s#%s - start", executeClassName, executeMethodName));

        EntityManager em = EntityService.getInstance().getEntityManager();
        em.getTransaction().begin();
        log.info("begin transaction.");

        try {
            Object returnValue = invocation.proceed();
            em.getTransaction().commit();
            log.info("commit transaction.");
            return returnValue;
        } catch (Throwable t) {
            em.getTransaction().rollback();
            log.info("rollback transaction.");
            throw t;
        } finally {
            log.info(fmt("%s#%s - end", executeClassName, executeMethodName));
        }
    }
}
