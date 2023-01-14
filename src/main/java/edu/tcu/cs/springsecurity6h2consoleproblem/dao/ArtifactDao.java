package edu.tcu.cs.springsecurity6h2consoleproblem.dao;

import edu.tcu.cs.springsecurity6h2consoleproblem.domain.Artifact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtifactDao extends JpaRepository<Artifact, String> {

}
