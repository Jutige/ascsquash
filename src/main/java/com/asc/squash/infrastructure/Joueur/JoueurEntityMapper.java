package com.asc.squash.infrastructure.Joueur;

import com.asc.squash.domaine.Joueur;
import com.asc.squash.infrastructure.AbstractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JoueurEntityMapper extends AbstractMapper<Joueur,JoueurEntity> {

    @Autowired
    private IJoueurRepository joueurRepository;

    @Override
    public Joueur mapToDomain(JoueurEntity entity) {
        return new Joueur(entity.getNomJoueur(),
                entity.getPrenomJoueur(),
                entity.getMailJoueur(),
                entity.getNumeroTelJoueur());
    }

    @Override
    public JoueurEntity mapToEntity(Joueur domaine) {

        JoueurEntity entity = joueurRepository.findByMailJoueur(domaine.getMailJoueur());
        if (entity == null) {
            entity = new JoueurEntity(domaine.getNomJoueur(),
                    domaine.getPrenomJoueur(),
                    entity.getMailJoueur(),
                    entity.getNumeroTelJoueur()) ;
        }
        return entity;
    }
}
