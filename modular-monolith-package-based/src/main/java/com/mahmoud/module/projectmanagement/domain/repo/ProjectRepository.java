package com.mahmoud.module.projectmanagement.domain.repo;

import com.mahmoud.module.projectmanagement.domain.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
