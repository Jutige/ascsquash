package com.asc.squash.exposition.dto;


import com.asc.squash.domaine.Site;
import com.asc.squash.domaine.StatutEnum;
import com.asc.squash.domaine.User;

import java.util.Date;
import java.util.List;

public class CreneauDtoResult extends CreneauDto{

    private Long idCreneau;

    public CreneauDtoResult() {
    }

    public CreneauDtoResult(Long idCreneau, CreneauDto creneauDto) {
        super(creneauDto.getDateDebut(),
                creneauDto.getDateFin(),
                creneauDto.getNbJoueursMax(),
                creneauDto.getListUserCreaneau(),
                creneauDto.getSiteCreaneau(),
                creneauDto.getStatutCreneau()
        );
        this.idCreneau = idCreneau;
    }

    public CreneauDtoResult(Date dateDebut, Date dateFin, int nbJoueursMax, List<User> listUserCreaneau, Site siteCreaneau, StatutEnum statutCreneau, Long idCreneau) {
        super(dateDebut, dateFin, nbJoueursMax, listUserCreaneau, siteCreaneau, statutCreneau);
        this.idCreneau = idCreneau;
    }
}
