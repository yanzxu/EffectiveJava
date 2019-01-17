package main.java.chapter1.staticfactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Services {
    private Services() {
    }

    private static final Map<String, Provider> providers = new ConcurrentHashMap<>();

    private static final String DEFAULT_PROVIDER_NAME = "test";

    public static void registerDefaultProvider(Provider provider) {
        registerProvider(DEFAULT_PROVIDER_NAME, provider);
    }

    public static void registerProvider(String name, Provider prodiver) {
        providers.put(name,prodiver);
    }

    public static Service newInstance() {
        return newInstance(DEFAULT_PROVIDER_NAME);

    }

    public static Service newInstance(String name){
        Provider p = providers.get(name);

        if (p == null) throw new IllegalArgumentException("No provider registered with name: " + name);

        return p.newService();
    }
}
