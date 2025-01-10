package com.course.graphqlclient;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

class GraphqlStockClientTests {
  
  private final String SERVER_ENDPOINT = "http://localhost:8080/graphql";

  private final String SUBSCRIPTION_ENDPOINT = "ws://localhost:8080/subscriptions";

  private GraphqlStockClient client = new GraphqlStockClient(SERVER_ENDPOINT, SUBSCRIPTION_ENDPOINT);

  @Test
  void testSubscribeStock() throws Exception {
    client.subscribeStock();
    
    TimeUnit.SECONDS.sleep(15);
  }
}
