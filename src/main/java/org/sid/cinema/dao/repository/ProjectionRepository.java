package org.sid.cinema.dao.repository;

import org.sid.cinema.dao.modele.Projection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProjectionRepository extends JpaRepository<Projection, Long> {
}
