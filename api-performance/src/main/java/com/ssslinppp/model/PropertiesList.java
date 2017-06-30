package com.ssslinppp.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by liulin on 2017/6/30.
 */
@ConfigurationProperties(prefix = "master")
@PropertySource("classpath:my.properties")
@Component
public class PropertiesList {
    private List<PoolConfiguration> pool;

    public static class PoolConfiguration {

        private String id;

        private String endpoint;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getEndpoint() {
            return endpoint;
        }

        public void setEndpoint(String endpoint) {
            this.endpoint = endpoint;
        }

        @Override
        public String toString() {
            return "PoolConfiguration{" +
                    "id='" + id + '\'' +
                    ", endpoint='" + endpoint + '\'' +
                    '}';
        }
    }

    /**
     * 根据资源池编码，获取API接口URI
     *
     * @param poolId
     * @return
     */
    public String endpoint(String poolId) {
        if (CollectionUtils.isEmpty(pool))
            return null;

        for (PoolConfiguration config : pool) {
            if (config.getId().equals(poolId)) {
                return config.getEndpoint();
            }
        }
        return null;
    }

    public List<PoolConfiguration> getPool() {
        return pool;
    }

    public void setPool(List<PoolConfiguration> pool) {
        this.pool = pool;
    }

    @Override
    public String toString() {
        return "PropertiesList{" +
                "pool=" + pool +
                '}';
    }
}
