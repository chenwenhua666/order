package com.plm.order.message.config;

/**
 * @author : cwh
 * 2018/12/26 0026
 * description ：
 */
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*@Configuration
@AutoConfigureAfter(MybatisDataSourceConfig.class)*/
public class MybatisMapperScanerConfig {

    /*@Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.plm.order.message.mapper");
        return mapperScannerConfigurer;
    }*/

}
