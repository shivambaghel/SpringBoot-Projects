package com.course.graphql.client.request;

import java.util.Map;

public class GraphqlRestRequest {

    private String query;

    private Map<String, ? extends Object> variables;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Map<String, ? extends Object> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, ? extends Object> variables) {
        this.variables = variables;
    }
}
