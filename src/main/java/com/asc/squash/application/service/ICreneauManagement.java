package com.asc.squash.application.service;

import com.asc.squash.exposition.dto.CreneauDto;
import com.asc.squash.exposition.dto.CreneauDtoResult;

public interface ICreneauManagement {
    CreneauDtoResult createCreneau(CreneauDto creneauDto);

    CreneauDtoResult addPlayer(CreneauDtoResult creneauDto);

    CreneauDtoResult update(CreneauDtoResult creneauDto);
}
