package com.power.yuneng.nonparty;

import com.power.yuneng.nonparty.client.config.SimpleResponseErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2017/6/8.
 */
@ImportResource(locations={"classpath*:*.xml"})
@ComponentScan(basePackages = {"com.power"})
@SpringBootApplication
public class PowerZhiluClientStarter extends SpringBootServletInitializer {
    // 启动的时候要注意，由于我们在controller中注入了RestTemplate，所以启动的时候需要实例化该类的一个实例
    @Autowired
    private RestTemplateBuilder builder;
    @Autowired
    private SimpleResponseErrorHandler simpleResponseErrorHandler;
    // 使用RestTemplateBuilder来实例化RestTemplate对象，spring默认已经注入了RestTemplateBuilder实例
    @Bean
    public RestTemplate restTemplate() {
//        SocketAddress address = new InetSocketAddress("127.0.0.1", 48888);
//        Proxy proxy = new Proxy(Proxy.Type.HTTP, address);
//        httpRequestFactory.setProxy(proxy);

        RestTemplate restTemplate = builder.build();
        restTemplate.setErrorHandler(simpleResponseErrorHandler);
        return restTemplate;
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PowerZhiluClientStarter.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(PowerZhiluClientStarter.class, args);
    }
}
