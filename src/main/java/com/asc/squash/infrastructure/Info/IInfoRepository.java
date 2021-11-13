package com.asc.squash.infrastructure.Info;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IInfoRepository extends JpaRepository<InfoEntity, Long> {

    List<InfoEntity> findByIdInfoNotNull();
    InfoEntity findByIdInfo(Long idInfo);
}
