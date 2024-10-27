package com.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gateway.filter.JwtAuthFilter;

@Configuration
public class GatewayConfig {

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder, JwtAuthFilter jwtAuthFilter) {
		return builder.routes().route("EMPLOYEE_DATA",
				r -> r.path("/employee/**").filters(f -> f.filter(jwtAuthFilter.apply(new JwtAuthFilter.Config())))
						.uri("http://localhost:8081"))
				.route("AUTH_SERVICE",
						r -> r.path("/auth/**").filters(f -> f.filter(jwtAuthFilter.apply(new JwtAuthFilter.Config())))
								.uri("http://localhost:8082"))
				.build();
	}

}
