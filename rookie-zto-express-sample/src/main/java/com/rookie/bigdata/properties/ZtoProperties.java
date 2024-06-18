package com.rookie.bigdata.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Class ZtoProperties
 * @Description中通属性配置类
 * @Author rookie
 * @Date 2024/6/18 15:27
 * @Version 1.0
 */
@Data
@ConfigurationProperties(prefix = "express.zto")
public class ZtoProperties {

    private String appKey;

    private String appSecret;

    private String url;
}
