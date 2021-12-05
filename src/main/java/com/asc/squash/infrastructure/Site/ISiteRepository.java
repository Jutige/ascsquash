package com.asc.squash.infrastructure.Site;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISiteRepository extends JpaRepository<SiteEntity,Long> {

    List<SiteEntity> findBySiteIdNotNull();
    SiteEntity findBySiteId(Long siteId);
}
