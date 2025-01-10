package com.carmazing.sales.client;

import com.carmazing.sales.generated.types.SimpleModel;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Set;

@Component
public class ProductRestClient {

    private static final String URL = "http://localhost:8881/";

    private RestTemplate restTemplate = new RestTemplate();

    public List<SimpleModel> fetchRestSimpleModels(Set<String> modelUuids) {
        var url = UriComponentsBuilder.fromHttpUrl(
                        URL + "api/models/simple"
                ).queryParam("modelUuids", String.join(",", modelUuids))
                .build().toUri();

        var response = restTemplate.exchange(
                url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<SimpleModel>>() {
                }
        );

        return response.getBody();
    }

}
