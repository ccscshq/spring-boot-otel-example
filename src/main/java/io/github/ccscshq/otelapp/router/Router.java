package io.github.ccscshq.otelapp.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import io.github.ccscshq.otelapp.handler.DiceHandler;

@Configuration
public class Router {

  @Bean
  public RouterFunction<ServerResponse> diceRouter(DiceHandler diceHandler) {
    return RouterFunctions.route()
      .GET("/dice/roll", diceHandler::roll)
      .build();
  }
}
