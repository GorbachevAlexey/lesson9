package ru.sbt.javaschool;

import java.lang.reflect.Proxy;

public class CacheProxy {
    private final String cachePath;
    private final CacheType defaultCacheType;

    public CacheProxy(String cachePath, CacheType defaultCacheType) {
        this.cachePath = cachePath;
        this.defaultCacheType = defaultCacheType;
    }

    public Service cache(ServiceImpl serviceImpl){
        return (Service) Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(),
                new Class[]{Service.class},
                new ProxyHandler(serviceImpl, cachePath, defaultCacheType));
    }
}
