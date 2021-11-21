package com.asc.squash.application.service;

import com.asc.squash.application.mapper.JoueurDtoMapper;
import com.asc.squash.domaine.IJoueurDomaine;
import com.asc.squash.domaine.Joueur;
import com.asc.squash.exposition.dto.JoueurDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class JoueurManagementImpl implements IJoueurManagment {

    @Autowired
    private IJoueurDomaine joueurDomaine;

    @Autowired
    private JoueurDtoMapper joueurDtoMapper;

    private static Logger logger = LoggerFactory.getLogger(JoueurManagementImpl.class);

    @Override
    public String createJoueur(JoueurDto joueurDto) {

        if (joueurDomaine.create(joueurDtoMapper.mapToJoueur(joueurDto))){
            return joueurDto.getIdAsc();
        }
        else{return null;}
    }

    @Override
    public List<JoueurDto> listJoueurDto() {
        List<JoueurDto> joueurDtoList = new ArrayList<JoueurDto>();
        for (Joueur joueur: joueurDomaine.findAllJoueur()){
            joueurDtoList.add(joueurDtoMapper.mapToJoueurDto(joueur));
        }
        return joueurDtoList;
    }

    @Override
    public JoueurDto updateJoueur(JoueurDto joueurDto) {
        return joueurDtoMapper.mapToJoueurDto(joueurDomaine.UpdateJoueur(joueurDtoMapper.mapToJoueur(joueurDto)));
    }

    @Override
    public String deleteJoueur(String idAsc) {

        if (joueurDomaine.deleteJoueur(idAsc)) {
            return "Suppression effectuée";
        }else {
            return "Suppression non effectuée";
        }
    }
}
