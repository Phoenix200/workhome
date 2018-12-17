package com.czxy.jmyp.config;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
/**
 * @ClassName FilterProperties
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/17 10:55
 * @Version 1.0
 **/
@ConfigurationProperties(prefix = "sc.filter")
public class FilterProperties {

    private List<String> allowPaths;

    public List<String> getAllowPaths() {
        return allowPaths;
    }

    public void setAllowPaths(List<String> allowPaths) {
        this.allowPaths = allowPaths;
    }
}
