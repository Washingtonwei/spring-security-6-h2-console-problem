package edu.tcu.cs.springsecurity6h2consoleproblem.service;

import edu.tcu.cs.springsecurity6h2consoleproblem.dao.ArtifactDao;
import edu.tcu.cs.springsecurity6h2consoleproblem.domain.Artifact;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ArtifactService {

    private ArtifactDao artifactDao;


    public ArtifactService(ArtifactDao artifactDao) {
        this.artifactDao = artifactDao;
    }

    public List<Artifact> findAll() {
        return artifactDao.findAll();
    }

}
