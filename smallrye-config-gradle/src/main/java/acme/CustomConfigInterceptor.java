package acme;

import io.smallrye.config.ConfigSourceInterceptor;
import io.smallrye.config.ConfigSourceInterceptorContext;
import io.smallrye.config.ConfigValue;
import io.smallrye.config.Priorities;
import jakarta.annotation.Priority;

@Priority(Priorities.APPLICATION)
public class CustomConfigInterceptor implements ConfigSourceInterceptor {
    @Override
    public ConfigValue getValue(ConfigSourceInterceptorContext context, String name) {
        if ("property".equals(name)) {
            return new ConfigValue.ConfigValueBuilder().withValue("pong").build();
        }
        return context.proceed(name);
    }
}
