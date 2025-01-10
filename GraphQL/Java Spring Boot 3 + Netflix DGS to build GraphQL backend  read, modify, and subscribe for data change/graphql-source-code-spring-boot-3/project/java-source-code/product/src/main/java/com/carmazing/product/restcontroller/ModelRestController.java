package com.carmazing.product.restcontroller;

import com.carmazing.product.generated.types.ModelSimple;
import com.carmazing.product.service.query.ModelQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ModelRestController {

    @Autowired
    private ModelQueryService modelQueryService;

    @GetMapping(value = "/api/models/simple", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ModelSimple> modelSimples(
            @RequestParam(name = "modelUuids", required = true) String modelUuidsWithCommaSeparator
    ) {
        var modelUuids = Arrays.asList(
                modelUuidsWithCommaSeparator.split(",")
        );

        return modelQueryService.findModels(modelUuids);
    }

}
