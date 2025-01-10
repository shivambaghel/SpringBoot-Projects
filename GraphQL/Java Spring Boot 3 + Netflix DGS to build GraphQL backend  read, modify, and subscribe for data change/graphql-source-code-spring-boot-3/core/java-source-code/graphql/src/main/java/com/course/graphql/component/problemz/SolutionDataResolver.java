package com.course.graphql.component.problemz;

import com.course.graphql.datasource.problemz.entity.Solutionz;
import com.course.graphql.datasource.problemz.repository.SolutionzRepository;
import com.course.graphql.exception.ProblemzAuthenticationException;
import com.course.graphql.generated.DgsConstants;
import com.course.graphql.generated.types.Solution;
import com.course.graphql.generated.types.SolutionCreateInput;
import com.course.graphql.generated.types.SolutionResponse;
import com.course.graphql.generated.types.SolutionVoteInput;
import com.course.graphql.service.command.SolutionzCommandService;
import com.course.graphql.service.query.ProblemzQueryService;
import com.course.graphql.service.query.UserzQueryService;
import com.course.graphql.util.GraphqlBeanMapper;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import com.netflix.graphql.dgs.exceptions.DgsEntityNotFoundException;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import reactor.core.publisher.Flux;

import java.util.Optional;
import java.util.UUID;

@DgsComponent
public class SolutionDataResolver {

    @Autowired
    private UserzQueryService userzQueryService;

    @Autowired
    private ProblemzQueryService problemzQueryService;

    @Autowired
    private SolutionzCommandService solutionzCommandService;

    @DgsData(parentType = DgsConstants.MUTATION.TYPE_NAME,
            field = DgsConstants.MUTATION.SolutionCreate)
    public SolutionResponse createSolution(
            @RequestHeader(name = "authToken", required = true) String authToken,
            @InputArgument(name = "solution") SolutionCreateInput solutionCreateInput
    ) {
        var userz = userzQueryService.findUserzByAuthToken(authToken)
                .orElseThrow(ProblemzAuthenticationException::new);
        var problemzId = UUID.fromString(solutionCreateInput.getProblemId());
        var problemz = problemzQueryService.problemzDetail(problemzId)
                .orElseThrow(DgsEntityNotFoundException::new);
        var solutionz = GraphqlBeanMapper.mapToEntity(solutionCreateInput, userz, problemz);
        var created = solutionzCommandService.createSolutionz(solutionz);

        return SolutionResponse.newBuilder().solution(GraphqlBeanMapper.mapToGraphql(created)).build();
    }

    @DgsData(parentType = DgsConstants.MUTATION.TYPE_NAME,
            field = DgsConstants.MUTATION.SolutionVote)
    public SolutionResponse createSolutionVote(
            @RequestHeader(name = "authToken", required = true) String authToken,
            @InputArgument(name = "vote") SolutionVoteInput solutionVoteInput
    ) {
        Optional<Solutionz> updated;
        userzQueryService.findUserzByAuthToken(authToken).orElseThrow(ProblemzAuthenticationException::new);

        if (solutionVoteInput.getVoteAsGood()) {
            updated = solutionzCommandService.voteGood(
                    UUID.fromString(solutionVoteInput.getSolutionId())
            );
        } else {
            updated = solutionzCommandService.voteBad(
                    UUID.fromString(solutionVoteInput.getSolutionId())
            );
        }

        if (updated.isEmpty()) {
            throw new DgsEntityNotFoundException("Solution "
                    + solutionVoteInput.getSolutionId() + " not found");
        }

        return SolutionResponse.newBuilder().solution(GraphqlBeanMapper.mapToGraphql(updated.get())).build();
    }

    @DgsData(parentType = DgsConstants.SUBSCRIPTION_TYPE,
            field = DgsConstants.SUBSCRIPTION.SolutionVoteChanged)
    public Flux<Solution> subscribeSolutionVote(@InputArgument(name = "solutionId") String solutionId) {
        return solutionzCommandService.solutionzFlux().map(GraphqlBeanMapper::mapToGraphql);
    }

}
