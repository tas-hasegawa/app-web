package interceptor;

import org.glassfish.hk2.api.InterceptionService;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import javax.inject.Singleton;

/**
 * インターセプターのバインダークラスです。
 *
 * @author Hiroshi HASEGAWA
 */
public class InterceptorBinder extends AbstractBinder {

    /**
     * DI機能にバインドするインターセプターのサービスをバインドします。
     */
    @Override
    protected void configure() {
        bind(AppInterceptionService.class).to(InterceptionService.class).in(Singleton.class);
    }
}
