package com.example.practice2;

import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @Auther: 10062376
 * @Date: 2019/1/22 16:51
 * @Description:
 */
//public class CustomServletContainer implements EmbeddedServletContainerCustomizer {
//spring boot2.0以上EmbeddedServletContainerCustomizer被替换为WebServerFactoryCustomizer
@Component
public class CustomServletContainer implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

    @Override
    public void customize(ConfigurableServletWebServerFactory factory) {
        factory.setPort(8888);
        factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/404.html"));
//        factory.setSession(new Session());
    }
}
