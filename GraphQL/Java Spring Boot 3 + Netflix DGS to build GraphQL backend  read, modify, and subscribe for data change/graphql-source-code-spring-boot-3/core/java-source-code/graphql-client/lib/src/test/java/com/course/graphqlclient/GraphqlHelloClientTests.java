package com.course.graphqlclient;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.ThreadLocalRandom;

import org.junit.jupiter.api.Test;

import com.course.graphqlclient.type.HelloInput;

class GraphqlHelloClientTests {
  private final String SERVER_ENDPOINT = "http://localhost:8080/graphql";

  private final GraphqlHelloClient client = new GraphqlHelloClient(SERVER_ENDPOINT);

//  @Test
  void testAddHello() {
    var newHello = HelloInput
      .builder()
      .text("New Hello")
      .number(ThreadLocalRandom.current().nextInt())
      .build();

    var mutationResult = client.addHello(newHello);

    assertTrue(mutationResult > 0);
  }

//  @Test
  void testReplaceHelloText() {
    var replacementHello = HelloInput
        .builder()
        .text("Replacement Hello")
        .number(195)
        .build();
    
    var mutationResult = client.replaceHelloText(replacementHello);
    
    assertNotNull(mutationResult);
  }

  @Test
  void testDeleteHello() {
    var mutationResult = client.deleteHello(4995);
    
    assertTrue(mutationResult > 0);
  }
}
