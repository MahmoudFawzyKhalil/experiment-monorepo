package com.mahmoud.module.projectmanagement.app.api.rest;

import com.mahmoud.module.projectmanagement.app.facade.ProjectFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectFacade projectFacade;

    public ProjectController(ProjectFacade projectFacade) {
        this.projectFacade = projectFacade;
    }

    @PostMapping
    public ResponseEntity<Void> createProject(@RequestBody CreateProjectRequest createProjectRequest) {
        projectFacade.createProject(createProjectRequest);
        return ResponseEntity.ok().build();
    }
}
