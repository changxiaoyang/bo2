package com.cxy890.boot2.config;

//import com.cxy890.boot2.handler.RequestFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.result.method.RequestMappingInfo;
import org.springframework.web.reactive.result.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;

/**
 * @author BD-PC27
 */
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class WebfluxSecurityConfig {

//    private final RequestMappingHandlerMapping requestMappingHandlerMapping;

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http
                .authorizeExchange()
                .pathMatchers("/register/**", "/passport/**", "/**").permitAll()
                .anyExchange().authenticated()
                .and()/*.addFilterAt(new RequestFilter(), SecurityWebFiltersOrder.REACTOR_CONTEXT)*/
                .httpBasic().and()
                .formLogin();
        return http.build();
    }

    @PostConstruct
    public void config() {
//        RequestMappingInfo mappingInfo = RequestMappingInfo
//                .paths("/login")
//                .methods(RequestMethod.POST)
//                .mappingName("/login")
//                .options(new RequestMappingInfo.BuilderConfiguration())
//                .build();
//        Method login = null;
//        try {
//            login = UserService.class.getDeclaredMethod("login", String.class, String.class, ServerHttpRequest.class, ServerHttpResponse.class);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }

//        requestMappingHandlerMapping.registerMapping(mappingInfo, userService, login);
    }
}
