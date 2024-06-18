package com.rookie.bigdata.config;

import com.rookie.bigdata.properties.ZtoProperties;
import com.rookie.bigdata.zto.config.ZTOConfig;
import com.rookie.bigdata.zto.service.ZtoService;
import com.rookie.bigdata.zto.service.impl.ZtoServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Class ZtoExpressAutoConfiguration
 * @Description
 * @Author rookie
 * @Date 2024/6/18 15:29
 * @Version 1.0
 */
@Configuration
@EnableConfigurationProperties(ZtoProperties.class)
@ConditionalOnClass(ZtoService.class)
@ConditionalOnProperty(prefix = "express.zto", value = "enabled", matchIfMissing = true)
public class ZtoExpressAutoConfiguration {
    @Configuration
    @EnableConfigurationProperties(ZtoProperties.class)
    @ConditionalOnClass(ZtoService.class)
    @ConditionalOnProperty(prefix = "express.zto", value = "enabled", matchIfMissing = true)
    public class ZtoServiceAutoConfiguration {
        private ZtoProperties properties;

        @Autowired
        public ZtoServiceAutoConfiguration(ZtoProperties properties) {
            this.properties = properties;
        }

        /**
         * .
         *
         * @return
         */
        @Bean
        @ConditionalOnMissingBean(ZtoService.class)
        public ZtoService ZtoService() {
            final ZtoServiceImpl ztoService = new ZtoServiceImpl();
            ZTOConfig ztoConfig = new ZTOConfig();


            ztoConfig.setAppKey(StringUtils.trimToNull(this.properties.getAppKey()));
            ztoConfig.setAppSecret(StringUtils.trimToNull(this.properties.getAppSecret()));
            if (StringUtils.isNotEmpty(StringUtils.trimToNull(this.properties.getUrl()))) {
                ztoConfig.setZtoBaseUrl(StringUtils.trimToNull(this.properties.getUrl()));
            }


            ztoService.setConfig(ztoConfig);

            return ztoService;
        }

    }
}
