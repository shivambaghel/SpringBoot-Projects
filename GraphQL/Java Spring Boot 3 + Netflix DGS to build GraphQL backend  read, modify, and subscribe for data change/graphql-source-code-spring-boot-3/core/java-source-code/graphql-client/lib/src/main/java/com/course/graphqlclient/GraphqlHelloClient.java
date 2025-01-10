package com.course.graphqlclient;

import java.util.List;

import com.apollographql.apollo3.ApolloClient;
import com.apollographql.apollo3.rx3.Rx3Apollo;
import com.course.graphqlclient.ReplaceHelloTextMutation.ReplaceHelloText;
import com.course.graphqlclient.type.HelloInput;

public class GraphqlHelloClient {
  private final ApolloClient apolloClient;

  public GraphqlHelloClient(String serverEndpoint) {
    this.apolloClient = new ApolloClient.Builder().serverUrl(serverEndpoint).build();
  }

  public int addHello(HelloInput helloInput) {
    var mutation = apolloClient.mutation(new AddHelloMutation(helloInput));
    var mutationResponse = Rx3Apollo.single(mutation);

    return mutationResponse.blockingGet().data.addHello;
  }

  public List<ReplaceHelloText> replaceHelloText(HelloInput helloInput) {
    var mutation = apolloClient.mutation(new ReplaceHelloTextMutation(helloInput));
    var mutationResponse = Rx3Apollo.single(mutation);

    return mutationResponse.blockingGet().data.replaceHelloText;
  }

  public int deleteHello(int helloNumber) {
    var mutation = apolloClient.mutation(new DeleteHelloMutation(helloNumber));
    var mutationResponse = Rx3Apollo.single(mutation);

    return mutationResponse.blockingGet().data.deleteHello;
  }
}
