package com.example.distributed.eb.eb_client;

import io.vertx.core.AbstractVerticle;

import io.vertx.core.eventbus.EventBus;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public class ReceiverVerticle extends AbstractVerticle {

  private final Logger logger = LoggerFactory.getLogger(ReceiverVerticle.class);

  @Override
  public void start() {
    final EventBus eventBus = vertx.eventBus();
    eventBus.consumer("kodcu.com", receivedMessage -> logger.info("Received message: {}"+receivedMessage.body()));
    logger.info("Receiver ready!");
  }
}
