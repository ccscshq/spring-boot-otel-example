package io.github.ccscshq.otelapp.handler;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import io.github.ccscshq.otelapp.model.RollResult;
import reactor.core.publisher.Mono;

@Component
public class DiceHandler {

  private static final Logger log = LoggerFactory.getLogger(DiceHandler.class);

  private final Random random = new Random();

  public Mono<ServerResponse> roll(ServerRequest req) {
    int val = random.nextInt(1, 7);
    RollResult result = new RollResult(val);
    String method = req.method().toString();
    String path = req.path();
    log.info("{} {}, result: {}", method, path, result.toString());
    return ServerResponse.ok().body(Mono.just(result), RollResult.class);
  }
}
