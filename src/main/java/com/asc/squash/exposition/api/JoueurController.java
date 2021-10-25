package com.asc.squash.exposition.api;

import com.asc.squash.application.service.IJoueurManagment;
import com.asc.squash.exposition.dto.JoueurDto;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/joueur")
@Api(value = "permet la création/mise à jour/suppression dans la base")
public class JoueurController {

    private static Logger logger = LoggerFactory.getLogger(JoueurController.class);

    @Autowired
    private IJoueurManagment joueurManagment;

    public ResponseEntity<String> createJoueur(@RequestBody JoueurDto joueurDto) {
        return new ResponseEntity<String>(joueurManagment.createJoueur(joueurDto), HttpStatus.CREATED);
    }
}
