package com.example.springcloudgateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//yaml 파일이 아닌 자바코드를 이용한 routing 정보 추가
//@Configuration
public class FilterConfig {
//    @Bean
    public RouteLocator getewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/first-service/**")
                        .filters(f -> f
                                .addRequestHeader("first-request", "first-request-header")
                                .addResponseHeader("first-request", "first-response-header"))
                        .uri("http://localhost:9001"))
                .route(r -> r.path("/second-service/**")
                        .filters(f -> f
                                .addRequestHeader("second-request", "second-request-header")
                                .addResponseHeader("second-request", "second-response-header"))
                        .uri("http://localhost:9002"))
                .build();
    }
}
