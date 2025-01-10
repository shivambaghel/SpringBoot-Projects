package com.course.graphql;

import com.course.graphql.client.StarwarsGraphqlClient;
import com.course.graphql.client.request.GraphqlRestRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StarwarsGraphqlClientTests {

    @Autowired
    private StarwarsGraphqlClient client;

    @Test
    void testAsJson() throws Exception {
        var json = client.asJson("allPlanets", null, null);

        assertNotNull(json);
    }

    @Test
    void testAsJson_Invalid() throws Exception {
        assertThrows(
                RuntimeException.class,
                () -> {
                    var json = client.asJson(
                            "invalidOperationName", null, null
                    );
                }
        );
    }

    @Test
    void testAllPlanets() throws Exception {
        var result = client.allPlanets();
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    void testOneStarshipFixed() throws Exception {
        var result = client.oneStarshipFixed();
        assertNotNull(result);
        assertNotNull(result.getModel());
        assertNotNull(result.getName());
        assertNotNull(result.getManufacturers());
    }

    @Test
    void testOneFilm_Right() throws Exception {
        var result = client.oneFilm("1");
        assertNotNull(result);
        assertNotNull(result.getTitle());
    }

    @Test
    void testOneFilm_Invalid() throws Exception {
        var errors = client.oneFilmInvalid();
        assertNotNull(errors);
        assertFalse(errors.isEmpty());
    }

}
