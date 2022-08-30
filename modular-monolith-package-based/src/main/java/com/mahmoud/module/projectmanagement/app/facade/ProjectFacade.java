package com.mahmoud.module.projectmanagement.app.facade;

import com.mahmoud.module.projectmanagement.app.api.rest.CreateProjectRequest;
import com.mahmoud.module.projectmanagement.domain.entity.Project;
import com.mahmoud.module.projectmanagement.domain.repo.ProjectRepository;
import org.springframework.stereotype.Component;

@Component
public class ProjectFacade {
    private final ProjectRepository projectRepository;

    public ProjectFacade(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public void createProject(CreateProjectRequest createProjectRequest) {
        // TODO add validation that the user's maximum project limit is not exceeded
        // This requires a call to the User Management module
        // How will I do that?
        var project = new Project(
                createProjectRequest.name,
                createProjectRequest.description,
                createProjectRequest.projectManagerEmail);
        projectRepository.save(project);
    }
}
