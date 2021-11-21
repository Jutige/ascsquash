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
                entity.getNumeroTelJoueur(),
                entity.getIdAsc());
    }

    @Override
    public JoueurEntity mapToEntity(Joueur domaine) {

        JoueurEntity entity = joueurRepository.findByIdAsc(domaine.getIdAsc());
        if (entity == null) {
            entity = new JoueurEntity(domaine.getNomJoueur(),
                    domaine.getPrenomJoueur(),
                    domaine.getMailJoueur(),
                    domaine.getNumeroTelJoueur(),
                    domaine.getIdAsc()) ;
        }
        return entity;
    }
}
