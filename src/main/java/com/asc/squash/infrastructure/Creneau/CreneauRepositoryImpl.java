package com.asc.squash.infrastructure.Creneau;

import com.asc.squash.domaine.Creneau;
import com.asc.squash.domaine.ICreneauDomaine;
import com.asc.squash.domaine.User;
import com.asc.squash.infrastructure.Site.ISiteRepository;
import com.asc.squash.infrastructure.Site.SiteEntity;
import com.asc.squash.infrastructure.User.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CreneauRepositoryImpl implements ICreneauDomaine {

    @Autowired
    private ISiteRepository siteRepository;

    @Autowired
    private ICreneauRepository creneauRepository;

    @Override
    public Creneau createCreneau(Creneau creneau) {
        SiteEntity siteEntity = siteRepository.findBySiteId(creneau.getSiteCreaneau().getSiteId());
        List<UserEntity> users = new ArrayList<UserEntity>();
        CreneauEntity creneauEntity = new CreneauEntity(
                creneau.getDateDebut(),
                creneau.getDateFin(),
                creneau.getNbJoueursMax(),
                users,
                siteEntity,
                creneau.getStatutCreneau()
        );
        CreneauEntity creneauCreate = creneauRepository.save(creneauEntity);
        return new Creneau(creneauCreate.getIdCreneau(),
                creneauCreate.getDateDebut(),
                creneauCreate.getDateFin(),
                creneauCreate.getNbJoueursMax(),
                new ArrayList<User>(),
                creneau.getSiteCreaneau(),
                creneau.getStatutCreneau());
    }


}
