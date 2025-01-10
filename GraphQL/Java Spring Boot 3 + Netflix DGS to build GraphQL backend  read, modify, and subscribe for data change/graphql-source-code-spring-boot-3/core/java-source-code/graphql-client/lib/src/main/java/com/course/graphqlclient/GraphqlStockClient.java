package com.course.graphqlclient;

import com.apollographql.apollo3.ApolloClient;
import com.apollographql.apollo3.rx3.Rx3Apollo;

public class GraphqlStockClient {
  private final ApolloClient apolloClient;

  public GraphqlStockClient(String serverEndpoint, String subscriptionEndpoint) {
    this.apolloClient =
      new ApolloClient.Builder()
        .serverUrl(serverEndpoint)
        .webSocketServerUrl(subscriptionEndpoint)
        .build();
  }

  public void subscribeStock() {
    var subscription = apolloClient.subscription(new GetStockEveryIntervalSubscription());

    Rx3Apollo.flowable(subscription).forEach(c -> System.out.println(c.data.randomStock));
  }
}
