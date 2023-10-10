package com.gregpalacios.webflux.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.gregpalacios.webflux.client.handler.ProductoHandler;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class RouterConfig {

	@Bean
	public RouterFunction<ServerResponse> routesProducto(ProductoHandler handler) {
		return RouterFunctions.route(GET("/api/client"), handler::listar)
				.andRoute(GET("/api/client/{id}"), handler::ver).andRoute(POST("/api/client"), handler::crear)
				.andRoute(PUT("/api/client/{id}"), handler::editar)
				.andRoute(DELETE("/api/client/{id}"), handler::eliminar)
				.andRoute(POST("/api/client/upload/{id}"), handler::upload);
	}
}
