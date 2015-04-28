package interceptor;

import org.glassfish.hk2.api.InterceptionService;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import javax.inject.Singleton;

public class TxInterceptorBinder extends AbstractBinder {

    @Override
    protected void configure() {
        bind(TxInterceptionService.class)
                .to(InterceptionService.class)
                .in(Singleton.class);
    }
}
