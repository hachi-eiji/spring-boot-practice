package com.hachiyae.boot.serivce;

import lombok.Data;
import net.spy.memcached.*;
import net.spy.memcached.spring.MemcachedClientFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


@Data
@Service
@ConfigurationProperties(prefix = "memcached")
public class MemcacheService {
    private String addresses;
    private int expireSeconds = 100000;

    private MemcachedClient memcachedClient;

    @PostConstruct
    public void init() throws Exception {
        MemcachedClientFactoryBean memcachedClientFactoryBean = new MemcachedClientFactoryBean();
        memcachedClientFactoryBean.setServers(addresses);
        memcachedClientFactoryBean.setProtocol(ConnectionFactoryBuilder.Protocol.BINARY);
        memcachedClientFactoryBean.setFailureMode(FailureMode.Redistribute);
        memcachedClientFactoryBean.setLocatorType(ConnectionFactoryBuilder.Locator.ARRAY_MOD);
        memcachedClientFactoryBean.setHashAlg(DefaultHashAlgorithm.KETAMA_HASH);
        memcachedClient = (MemcachedClient) memcachedClientFactoryBean.getObject();
    }

    public void set(String key, Object value) {
        memcachedClient.set(key, expireSeconds, value);
    }

    public <T> T get(String key, Class<T> clazz) {
        return (T) memcachedClient.get(key);
    }
}
