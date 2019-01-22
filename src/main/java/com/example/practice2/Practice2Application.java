package com.example.practice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@SpringBootApplication
public class Practice2Application {
    @RequestMapping("/")
    public String index(Model model){
        Person person = new Person("张三",20);
        List<Person> people = new ArrayList<Person>();
        Person p1 = new Person("a",11);
        Person p2 = new Person("b",22);
        Person p3 = new Person("c",33);
        people.add(p1);
        people.add(p2);
        people.add(p3);

        model.addAttribute("singlePerson",person);
        model.addAttribute("people",people);
        return "index";
    }

    @Component
    public class CustomServletContainer implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

        @Override
        public void customize(ConfigurableServletWebServerFactory factory) {
            factory.setPort(8888);
            factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/404.html"));
//        factory.setSession(new Session());
        }
    }
    public static void main(String[] args) {
        SpringApplication.run(Practice2Application.class, args);
    }

}

