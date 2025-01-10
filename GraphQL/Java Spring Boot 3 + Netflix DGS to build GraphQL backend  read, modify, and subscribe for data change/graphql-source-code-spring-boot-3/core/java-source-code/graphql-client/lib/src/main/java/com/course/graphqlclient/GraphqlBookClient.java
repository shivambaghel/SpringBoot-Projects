package com.course.graphqlclient;

import java.util.List;

import com.apollographql.apollo3.ApolloClient;
import com.apollographql.apollo3.api.Optional;
import com.apollographql.apollo3.rx3.Rx3Apollo;
import com.course.graphqlclient.BooksByReleasedQuery.BooksByReleased;
import com.course.graphqlclient.BooksQuery.Book;

public class GraphqlBookClient {
  private final ApolloClient apolloClient;

  public GraphqlBookClient(String serverEndpoint) {
    this.apolloClient = new ApolloClient.Builder().serverUrl(serverEndpoint).build();
  }

  public List<Book> allBooks() {
    var query = apolloClient.query(new BooksQuery());
    var queryResponse = Rx3Apollo.single(query);

    return queryResponse.blockingGet().data.books;
  }

  public List<BooksByReleased> booksByReleased(
    int releaseYear,
    boolean releasePrintedEdition
  ) {
    var query = apolloClient.query(
      new BooksByReleasedQuery(
        Optional.present(releaseYear),
        Optional.present(releasePrintedEdition)
      )
    );

    var queryResponse = Rx3Apollo.single(query);

    return queryResponse.blockingGet().data.booksByReleased;
  }
}
