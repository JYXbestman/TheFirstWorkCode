package com.weibang.videohome.setting;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import springfox.documentation.service.Contact;

/**
 * Swagger 的相关设置
 *
 * @author vivo
 */
@Component
@ConfigurationProperties(prefix = "mine.setting.swagger")
@PropertySource(value = "classpath:application.properties", encoding = "UTF-8")
public class SwaggerSetting {

    /**
     * 是否开启swagger，正式环境一般是需要关闭的，可根据springboot的多环境配置进行设置
     */
    private boolean enable;
    @Value("path-mapping")
    private String pathMapping;
    @Value("base-package")
    private String basePackage;
    private String title;
    private String description;
    @Value("api-version")
    private String apiVersion;


    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getPathMapping() {
        return pathMapping;
    }

    public void setPathMapping(String pathMapping) {
        this.pathMapping = pathMapping;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public Contact getContact() {
        return new Contact("", "", "");
    }


    @Override
    public String toString() {
        return "SwaggerSetting{" +
                "enable=" + enable +
                ", pathMapping='" + pathMapping + '\'' +
                ", basePackage='" + basePackage + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", apiVersion='" + apiVersion + '\'' +
                '}';
    }
}
