package edu.tcu.cs.springsecurity6h2consoleproblem.controller;

import edu.tcu.cs.springsecurity6h2consoleproblem.domain.Artifact;
import edu.tcu.cs.springsecurity6h2consoleproblem.domain.Result;
import edu.tcu.cs.springsecurity6h2consoleproblem.domain.StatusCode;
import edu.tcu.cs.springsecurity6h2consoleproblem.service.ArtifactService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artifacts")
public class ArtifactController {

    private ArtifactService artifactService;


    public ArtifactController(ArtifactService artifactService) {
        this.artifactService = artifactService;
    }

    @GetMapping
    public Result findAll() {
        List<Artifact> foundArtifacts = artifactService.findAll();
        Result result = new Result(true, StatusCode.SUCCESS, "Find All Artifacts Success.", foundArtifacts);
        return result;
    }

}
