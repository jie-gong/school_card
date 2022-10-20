package com.gong.school_card.config;

import com.gong.school_card.config.User.UserLoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong.school_card.config.student.MyMvcConfig
 * @Date: 2022年09月13日 08:40
 * @Description:
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/404.html").setViewName("404");
        registry.addViewController("/studentlogin.html").setViewName("studentlogin");
        registry.addViewController("/main.html").setViewName("dashboard");
        registry.addViewController("/swagger-ui.html").setViewName("swagger-ui");
    }

    /**
     * 拦截器
     */

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserLoginHandlerInterceptor())
                .addPathPatterns("StudentPass.html")
//                不需要拦截的请求进行放行
                .excludePathPatterns(//路径   静态资源
                        "/",
                        "/static/**",
                        //请求
                        "/studentlogin/login",
                        "/user/login",
                        "/retrieve",
                        "/student",
                        "/Admin",
                        "/retrieve/password",
                        "/password",
                        "/card/balance",
                        "/card/student",
                        "/card/adduser",
                        "/card/saveMoney",
                        "/card//update",
                        "/user/use",
                        "/login/studentLogin",
                        "/login/verify",
                        "/card/addStudent",
                        "/commons/commons.html",
                        "/404.html",
                        "/index.html",
                        "/index02.html",
                        "/password.html",
                        "/studentlogin.html",
                        "/clear/session",
                        "/userdashboard.html")
                .excludePathPatterns("/index.html", "/", "/user/login", "/img/**", "/css/**", "/js/**");


        registry.addInterceptor(new LoginHandlerInterceptor())
                //拦截所有请求
                .addPathPatterns("/**")
                //不需要拦截的请求进行放行
                .excludePathPatterns(//路径   静态资源
                        "/",
                        "/static/**"
                )
                .excludePathPatterns(//请求
                        "/studentlogin/login",
                        "/user/login",
                        "/retrieve",
                        "/student",
                        "/Admin",
                        "/retrieve/password",
                        "/password",
                        "/card/balance",
                        "/card/student",
                        "/card/adduser",
                        "/card/saveMoney",
                        "/card//update",
                        "/user/use",
                        "/card/addStudent",
                        "/select/grade",
                        "/login/studentLogin",
                        "/login/verify")
                .excludePathPatterns(
                        "/swagger-ui.html",
                        "/commons/commons.html",
                        "/404.html",
                        "/index.html",
                        "/index02.html",
                        "/password.html",
                        "/studentlogin.html",
                        "/userdashboard.html")
                .excludePathPatterns("/index.html", "/", "/user/login", "/img/**", "/css/**", "/js/**");

        WebMvcConfigurer.super.addInterceptors(registry);
    }

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/", "classpath:/resources/",
            "classpath:/static/", "classpath:/public/"};


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!registry.hasMappingForPattern("/webjars/**")) {
            registry.addResourceHandler("/webjars/**").addResourceLocations(
                    "classpath:/META-INF/resources/webjars/");
        }
        if (!registry.hasMappingForPattern("/**")) {
            registry.addResourceHandler("/**").addResourceLocations(
                    CLASSPATH_RESOURCE_LOCATIONS);
        }

    }

}
