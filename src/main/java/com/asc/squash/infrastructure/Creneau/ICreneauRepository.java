package com.asc.squash.infrastructure.Creneau;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICreneauRepository extends JpaRepository<CreneauEntity, Long> {

}
