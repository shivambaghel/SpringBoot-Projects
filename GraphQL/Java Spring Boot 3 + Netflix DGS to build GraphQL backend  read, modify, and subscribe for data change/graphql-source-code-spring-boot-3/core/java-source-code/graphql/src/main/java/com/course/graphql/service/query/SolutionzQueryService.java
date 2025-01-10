package com.course.graphql.service.query;

import com.course.graphql.datasource.problemz.entity.Solutionz;
import com.course.graphql.datasource.problemz.repository.SolutionzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolutionzQueryService {

    @Autowired
    private SolutionzRepository repository;

    public List<Solutionz> solutionzByKeyword(String keyword) {
        return repository.findByKeyword("%" + keyword + "%");
    }

}
