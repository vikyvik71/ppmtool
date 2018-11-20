package com.vmarino.ppmtool.repositories;

import com.vmarino.ppmtool.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepo extends CrudRepository<Project, Long> {

    Project findByProjectIdentifier(String projectIdentifier);
}
