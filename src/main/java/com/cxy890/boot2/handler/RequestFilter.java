///*
//package com.cxy890.boot2.handler;
//
//import org.springframework.http.HttpCookie;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.ReactiveSecurityContextHolder;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.stereotype.Component;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.server.ServerWebExchange;
//import org.springframework.web.server.WebFilter;
//import org.springframework.web.server.WebFilterChain;
//import org.springframework.web.server.WebSession;
//import reactor.core.publisher.Mono;
//
//import java.util.Map;
//import java.util.function.Consumer;
//import java.util.function.Function;
//
//*/
///**
// * @author BD-PC27
// *//*
//
//@Component
//public class RequestFilter implements WebFilter {
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
//        ServerHttpRequest request = exchange.getRequest();
//
//
//
//
////        Mono<SecurityContext> context = ReactiveSecurityContextHolder.getContext();
////        context.subscribe(new Consumer<SecurityContext>() {
////            @Override
////            public void accept(SecurityContext securityContext) {
////                Authentication authentication = securityContext.getAuthentication();
////                Object principal = authentication.getPrincipal();
////                System.out.println(principal.toString());
////            }
////        });
////        MultiValueMap<String, HttpCookie> cookies = request.getCookies();
//        Mono<WebSession> session = exchange.getSession();
//        final Authentication[] authentication = new Authentication[1];
//        session.subscribe(new Consumer<WebSession>() {
//            @Override
//            public void accept(WebSession webSession) {
//                Map<String, Object> attributes = webSession.getAttributes();
//                if (attributes.containsKey("SPRING_SECURITY_CONTEXT")) {
//                    SecurityContext securityContext = (SecurityContext) attributes.get("SPRING_SECURITY_CONTEXT");
//                    authentication[0] = securityContext.getAuthentication();
//                }
//
//            }
//        });
//        Mono<SecurityContext> context = ReactiveSecurityContextHolder.getContext();
//        Mono<Object> messageByUsername = ReactiveSecurityContextHolder.getContext()
//                .map(SecurityContext::getAuthentication)
//                .map(Authentication::getName)
//                .flatMap(new Function<String, Mono<?>>() {
//                    @Override
//                    public Mono<?> apply(String s) {
//                        return Mono.just("11111");
//                    }
//                })
//                // In a WebFlux application the `subscriberContext` is automatically setup using `ReactorContextWebFilter`
//                .subscriberContext(ReactiveSecurityContextHolder.withAuthentication(authentication[0]));
//
////        String cookie = buildCookie(cookies);
//
////        Mono<MapSession> sessionMono = reactiveSessionRepository.findById(cookie);
//
////        Mono<MapSession> mapSessionMono = sessionMono.defaultIfEmpty(new MapSession());
//        return chain.filter(exchange);
//    }
//
//    private static String buildCookie(MultiValueMap<String, HttpCookie> cookies) {
//        StringBuilder cookieBuilder = new StringBuilder();
//        cookies.forEach((s, httpCookies) ->
//                httpCookies.forEach(httpCookie ->
//                        cookieBuilder.append(";")
//                                .append(httpCookie.getName()).append("=")
//                                .append(httpCookie.getValue())
//                )
//        );
//        return cookieBuilder.deleteCharAt(0).toString();
//    }
//
//}
//*/
