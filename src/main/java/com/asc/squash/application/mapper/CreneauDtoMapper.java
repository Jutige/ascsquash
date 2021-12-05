package com.asc.squash.application.mapper;

import com.asc.squash.domaine.Creneau;
import com.asc.squash.exposition.dto.CreneauDto;
import com.asc.squash.infrastructure.AbstractMapper;
import org.springframework.stereotype.Component;

@Component
public class CreneauDtoMapper extends AbstractMapper<Creneau, CreneauDto> {

    @Override
    public Creneau mapToDomain(CreneauDto dto) {
        return new Creneau(0L,
                dto.getDateDebut(),
                dto.getDateFin(),
                dto.getNbJoueursMax(),
                dto.getListUserCreaneau(),
                dto.getSiteCreaneau(),
                dto.getStatutCreneau());
    }

    @Override
    public CreneauDto mapToEntity(Creneau creneau) {

        return new CreneauDto(creneau.getDateDebut(),
                creneau.getDateFin(),
                creneau.getNbJoueursMax(),
                creneau.getListUserCreaneau(),
                creneau.getSiteCreaneau(),
                creneau.getStatutCreneau());
    }
}
