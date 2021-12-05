package com.asc.squash.application.service;

import com.asc.squash.application.mapper.CreneauDtoMapper;
import com.asc.squash.domaine.Creneau;
import com.asc.squash.domaine.ICreneauDomaine;
import com.asc.squash.exposition.dto.CreneauDto;
import com.asc.squash.exposition.dto.CreneauDtoResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CreneauManagmentImpl implements ICreneauManagement{

    @Autowired
    private ICreneauDomaine creneauDomaine;

    @Autowired
    private CreneauDtoMapper mapperCreneau;
    private static Logger logger = LoggerFactory.getLogger(CreneauManagmentImpl.class);

    @Override
    public CreneauDtoResult createCreneau(CreneauDto creneauDto) {
        Creneau creneau = creneauDomaine.createCreneau(mapperCreneau.mapToDomain(creneauDto));
        if (creneau != null){
            CreneauDto dto = mapperCreneau.mapToEntity(creneau);
            return new CreneauDtoResult(creneau.getIdCreneau(),dto);
        }
        return null;
    }

    @Override
    public CreneauDtoResult addPlayer(CreneauDtoResult creneauDto) {
        return null;
    }

    @Override
    public CreneauDtoResult update(CreneauDtoResult creneauDto) {
        return null;
    }
}
