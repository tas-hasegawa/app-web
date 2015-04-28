package interceptor;

import common.service.EntityService;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import javax.persistence.EntityManager;

public class TxInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        // TODO logger
        System.out.println("begin transaction.");
        EntityManager em = EntityService.getInstance().getEntityManager();
        em.getTransaction().begin();
        try {
            Object returnValue = invocation.proceed();

            // TODO logger
            System.out.println("commit.");
            em.getTransaction().commit();

            return returnValue;
        } catch (Throwable t) {
            // TODO logger
            System.out.println("rollback");
            em.getTransaction().rollback();
            throw t;
        }
    }
}
