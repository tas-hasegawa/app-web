package interceptor;

import common.annotations.Transactional;
import org.aopalliance.intercept.ConstructorInterceptor;
import org.aopalliance.intercept.MethodInterceptor;
import org.glassfish.hk2.api.Filter;
import org.glassfish.hk2.api.InterceptionService;
import org.glassfish.hk2.internal.StarFilter;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class TxInterceptionService implements InterceptionService {

    @Override
    public Filter getDescriptorFilter() {
        return StarFilter.getDescriptorFilter();
    }

    @Override
    public List<MethodInterceptor> getMethodInterceptors(Method method) {
        return Stream
                .of(method, method.getDeclaringClass())
                .filter(a -> a.isAnnotationPresent(Transactional.class))
                .findAny()
                .map(a -> Arrays.<MethodInterceptor>asList(new TxInterceptor()))
                .orElse(Collections.emptyList());
    }

    @Override
    public List<ConstructorInterceptor> getConstructorInterceptors(Constructor<?> constructor) {
        return Collections.emptyList();
    }
}
