package interceptor;

import org.aopalliance.intercept.ConstructorInterceptor;
import org.aopalliance.intercept.MethodInterceptor;
import org.glassfish.hk2.api.Descriptor;
import org.glassfish.hk2.api.Filter;
import org.glassfish.hk2.api.InterceptionService;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * アプリケーションのインターセプタークラスです。
 * インターセプターの処理を実行する対象を定義します。
 *
 * @author Hiroshi HASEGAWA
 */
public class AppInterceptionService implements InterceptionService {

    /**
     * インターセプトする対象をフィルタリングします。
     * @return フィルタ結果
     */
    @Override
    public Filter getDescriptorFilter() {
        return new Filter() {
            @Override
            public boolean matches(Descriptor d) {
                String clazz = d.getImplementation();
                return clazz.endsWith("Controller");
            }
        };
    }

    /**
     * インターセプトするメソッドを取得します。
     * @param method メソッド
     * @return インターセプトするメソッドのリスト
     */
    @Override
    public List<MethodInterceptor> getMethodInterceptors(Method method) {
        return Stream
                .of(method, method.getDeclaringClass())
                .findAny()
                .map(m -> Arrays.<MethodInterceptor>asList(new AppInterceptor()))
                .orElse(Collections.emptyList());
    }

    /**
     * インターセプトするコンストラクタを取得します。
     * @param constructor コンストラクタ
     * @return インターセプトするコンストラクタのリスト
     */
    @Override
    public List<ConstructorInterceptor> getConstructorInterceptors(Constructor<?> constructor) {
        return Collections.emptyList();
    }
}
