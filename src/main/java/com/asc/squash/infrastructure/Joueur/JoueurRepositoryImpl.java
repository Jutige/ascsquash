package com.asc.squash.infrastructure.Joueur;

import com.asc.squash.domaine.IJoueurDomaine;
import com.asc.squash.domaine.Joueur;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JoueurRepositoryImpl implements IJoueurDomaine {

    private static Logger logger = LoggerFactory.getLogger(JoueurRepositoryImpl.class);

    @Autowired
    IJoueurRepository joueurRepository;

    @Autowired
    JoueurEntityMapper joueurEntityMapper;

    @Override
    public boolean create(Joueur joueur) {

        JoueurEntity joueurEntity = joueurRepository.findByIdAsc(joueur.getIdAsc());
        if (joueurEntity != null) {
            return false;
        }else {
            JoueurEntity joueurEntitySave = new JoueurEntity(joueur.getNomJoueur(),
                    joueur.getPrenomJoueur(),
                    joueur.getMailJoueur(),
                    joueur.getNumeroTelJoueur(),
                    joueur.getIdAsc());
            joueurRepository.save(joueurEntitySave);
            return true;
        }
    }

    @Override
    public List<Joueur> findAllJoueur() {

        List<JoueurEntity> joueurEntityList = joueurRepository.findByIdAscNotNull();
        List<Joueur> joueurList = new ArrayList<Joueur>();
        joueurList = joueurEntityMapper.mapToDomainList(joueurEntityList);
        return joueurList;
    }

    @Override
    public Joueur UpdateJoueur(Joueur joueur) {
        JoueurEntity joueurEntity = joueurRepository.findByIdAsc(joueur.getIdAsc());
        if (joueurEntity == null) {
            return null;
        }else {
            joueurEntity.setMailJoueur(joueur.getMailJoueur());
            joueurEntity.setNomJoueur(joueur.getNomJoueur());
            joueurEntity.setPrenomJoueur(joueur.getPrenomJoueur());
            joueurEntity.setNumeroTelJoueur(joueur.getNumeroTelJoueur());
            joueurRepository.save(joueurEntity);
            return joueur;
        }
    }

    @Override
    public boolean deleteJoueur(String idAsc) {

        JoueurEntity joueurEntity = joueurRepository.findByIdAsc(idAsc);
        if (joueurEntity != null ) {
            joueurRepository.delete(joueurEntity);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Joueur findJoueurById (String idUSer) {
        JoueurEntity joueurEntity = joueurRepository.findByIdAsc(idUSer);
        if (joueurEntity != null) {
            return joueurEntityMapper.mapToDomain(joueurRepository.findByIdAsc(idUSer));
        }
        return null;
    }
}
