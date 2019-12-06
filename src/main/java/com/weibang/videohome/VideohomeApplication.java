package com.weibang.videohome;

import com.weibang.videohome.setting.MineSetting;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
      MineSetting.class
})
@MapperScan("com.weibang.videohome.dao")
public class VideohomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideohomeApplication.class, args);
    }

}
