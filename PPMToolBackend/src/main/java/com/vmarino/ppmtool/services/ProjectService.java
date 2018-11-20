package com.vmarino.ppmtool.services;

import com.vmarino.ppmtool.domain.Project;
import com.vmarino.ppmtool.exceptions.ProjectIdentifierDuplicateException;
import com.vmarino.ppmtool.exceptions.ProjectNotFoundException;
import com.vmarino.ppmtool.repositories.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepo projectRepo;

    public Project saveOrUpdateProject(Project project) {

        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepo.save(project);
        } catch (Exception e) {
            if(e instanceof DataIntegrityViolationException) {
                if(e.getMessage().contains("PROJECT_IDENTIFIER"))
                    throw new ProjectIdentifierDuplicateException("Duplicated Project Identifier: " + project.getProjectIdentifier());
            }
        }

        return null;

    }

    public Project findProjectByIdentifier(String identifier) {
        Project project = projectRepo.findByProjectIdentifier(identifier.toUpperCase());
        if (project == null) {
            throw new ProjectNotFoundException(identifier + " not found");
        }
        return projectRepo.findByProjectIdentifier(identifier.toUpperCase());
    }
}
