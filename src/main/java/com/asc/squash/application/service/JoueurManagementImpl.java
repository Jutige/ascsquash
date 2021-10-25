package com.asc.squash.application.service;

import com.asc.squash.exposition.dto.JoueurDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class JoueurManagementImpl implements IJoueurManagment {


    @Override
    public String createJoueur(JoueurDto joueurDto) {
        return null;
    }
}
