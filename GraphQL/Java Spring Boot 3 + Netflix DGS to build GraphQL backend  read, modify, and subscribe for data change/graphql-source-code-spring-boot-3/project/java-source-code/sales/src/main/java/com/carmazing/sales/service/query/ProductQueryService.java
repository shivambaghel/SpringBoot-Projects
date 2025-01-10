package com.carmazing.sales.service.query;

import com.carmazing.sales.client.ProductGraphQLClient;
import com.carmazing.sales.client.ProductRestClient;
import com.carmazing.sales.constant.ProductConstants;
import com.carmazing.sales.generated.types.SimpleModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductQueryService {

    @Autowired
    private ProductGraphQLClient productGraphQLClient;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ProductRestClient productRestClient;

    public Map<String, SimpleModel> loadSimpleModels(Set<String> modelUuids) {
        var variablesMap = Map.ofEntries(
                Map.entry(ProductConstants.VARIABLE_NAME_MODEL_UUIDS, modelUuids)
        );

        var simpleModelsGraphQLResponse = productGraphQLClient.fetchGraphQLResponse(
                ProductConstants.QUERY_SIMPLE_MODELS,
                ProductConstants.OPERATION_NAME_SIMPLE_MODELS,
                variablesMap
        );

        try {
            var jsonNode = objectMapper.readTree(simpleModelsGraphQLResponse.getJson());
            var simpleModelsJson = jsonNode.get("data").get("simpleModels").toString();
            var listSimpleModels = objectMapper.readValue(
                    simpleModelsJson,
                    new TypeReference<List<SimpleModel>>() {
                    }
            );

            return Maps.uniqueIndex(listSimpleModels, SimpleModel::getUuid);
        } catch (Exception e) {
            return Collections.emptyMap();
        }
    }

    public Map<String, SimpleModel> loadSimpleModelsRest(Set<String> modelUuids) {
        var listSimpleModels = productRestClient.fetchRestSimpleModels(modelUuids);

        return Maps.uniqueIndex(listSimpleModels, SimpleModel::getUuid);
    }

}
