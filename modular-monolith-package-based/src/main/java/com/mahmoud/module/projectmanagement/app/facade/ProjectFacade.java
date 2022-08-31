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
        // I could have a synchronous internal API along with the REST API for internal use only, as not all use cases
        // will have to use the REST API. Some are just for internal use.
        // I will also have to TRANSLATE the project subdomain to the dto of the internal API, and also translate back whatever they give me. No filthy DTO in domain!
        // Also, should I replicate some of the data of the User here as a ProjectManager entity using domain events?
        var project = new Project(
                createProjectRequest.name,
                createProjectRequest.description,
                createProjectRequest.projectManagerEmail);
        projectRepository.save(project);
    }
}
