package com.asc.squash.exposition.api;

import com.asc.squash.application.service.ICreneauManagement;
import com.asc.squash.application.service.IUserManagment;
import com.asc.squash.exposition.dto.CreneauDto;
import com.asc.squash.exposition.dto.CreneauDtoResult;
import com.asc.squash.exposition.dto.InfoDtoResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/creneau")
@Secured({"ROLE_USER","ROLE_RESP","ROLE_ADMIN"})
@Api(value = "permet la création/mise à jour/suppression dans la base")
public class CreneauController {

    private static Logger logger = LoggerFactory.getLogger(CreneauController.class);

    @Autowired
    private ICreneauManagement creneauManagement;

    @Autowired
    private IUserManagment userManagment;

    @PostMapping("/create")
    @ApiOperation(value = "crée un créneau de réservation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Création effectuée"),
            @ApiResponse(code = 400,message = "données en entrée incorrectes")
    })
    public ResponseEntity<CreneauDtoResult> create(@RequestBody CreneauDto creneauDto) {

        CreneauDtoResult creneauDtoResult = creneauManagement.createCreneau(creneauDto);
        if (creneauDtoResult == null){
            return new ResponseEntity<CreneauDtoResult>(new CreneauDtoResult(0L, creneauDto), HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<CreneauDtoResult>(creneauDtoResult, HttpStatus.CREATED);
        }
    }

    @PostMapping("/addPlayer")
    @ApiOperation(value = "Ajouter un joueur à une réservation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Utilisateur ajoutée à la liste"),
            @ApiResponse(code = 404, message = "Créneau non trouvé")
    })
    public ResponseEntity<CreneauDtoResult> addPlayer(@RequestBody CreneauDtoResult creneauDto) {

        CreneauDtoResult creneauDtoResult = creneauManagement.addPlayer(creneauDto);
        if (creneauDtoResult == null){
            return new ResponseEntity<CreneauDtoResult>(creneauDto, HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<CreneauDtoResult>(creneauDtoResult, HttpStatus.OK);
        }
    }

    @PostMapping("/update")
    @ApiOperation(value = "Mettre à jour une réservation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Mise à jour effectuée"),
            @ApiResponse(code = 404, message = "Créneau non trouvé")
    })
    public ResponseEntity<CreneauDtoResult> update(@RequestBody CreneauDtoResult creneauDto) {

        CreneauDtoResult creneauDtoResult = creneauManagement.update(creneauDto);
        if (creneauDtoResult == null){
            return new ResponseEntity<CreneauDtoResult>(creneauDto, HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<CreneauDtoResult>(creneauDtoResult, HttpStatus.OK);
        }
    }
}
