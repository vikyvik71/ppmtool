package com.vmarino.ppmtool.web;

import com.vmarino.ppmtool.domain.Project;
import com.vmarino.ppmtool.services.MapValidationErrorService;
import com.vmarino.ppmtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result) {

        ResponseEntity<?> res = mapValidationErrorService.checkAndValidate(result);
        if(res != null) return res;

        project = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }

    @GetMapping("/{projectIdentifier}")
    public ResponseEntity<?> getProject(@PathVariable String projectIdentifier) {
        return new ResponseEntity<>(projectService.findProjectByIdentifier(projectIdentifier), HttpStatus.OK);
    }
}
