package com.asc.squash.exposition.api;

import com.asc.squash.application.service.IJoueurManagment;
import com.asc.squash.exposition.dto.JoueurDto;
import com.asc.squash.infrastructure.Joueur.JoueurEntity;
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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/joueur")
@Secured({"ROLE_USER","ROLE_RESP","ROLE_ADMIN"})
@Api(value = "permet la création/mise à jour/suppression dans la base")
public class JoueurController {

    private static Logger logger = LoggerFactory.getLogger(JoueurController.class);

    @Autowired
    private IJoueurManagment joueurManagment;

    @PostMapping("/create")
    @ApiOperation(value = "crée un joueur")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Création effectuée"),
            @ApiResponse(code = 400,message = "données en entrée incorrectes"),
            @ApiResponse(code = 409, message = "joueur existant")
    })
    public ResponseEntity<String> createJoueur(@RequestBody JoueurDto joueurDto) {
        logger.info("joueurDto : "+joueurDto.toString());
        return new ResponseEntity<String>(joueurManagment.createJoueur(joueurDto), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    @ApiOperation(value = "récupère la liste des joueurs")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Liste des joueurs retournée"),
            @ApiResponse(code = 404, message = "aucun joueur trouvé")
    })
    public ResponseEntity<List<JoueurDto>> listJoueur(){
        return new ResponseEntity<List<JoueurDto>>(joueurManagment.listJoueurDto(), HttpStatus.OK);
    }

    @PostMapping("/update")
    @ApiOperation(value = "Mise à jour d'un joueur")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Mise à jour effectuée"),
            @ApiResponse(code = 404, message = "Aucun joueur trouvé")
    })
    public ResponseEntity<JoueurDto> updateJoueur(@RequestBody JoueurDto joueurDto) {
        logger.info("joueurDto : "+joueurDto.toString());
        return new ResponseEntity<JoueurDto>(joueurManagment.updateJoueur(joueurDto), HttpStatus.OK);
    }

    @ApiOperation(value = "Supprime un joueur")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Ok, suppression effectuée"),
            @ApiResponse(code = 404,message = "joueur non supprimé : joueur absent ou problème lors de la suppression en base")
    })
    @DeleteMapping("/delete/{idAsc}")
    public ResponseEntity<String> deleteJoueur(@PathVariable("idAsc") String idAsc){
        return new ResponseEntity<String>(joueurManagment.deleteJoueur(idAsc), HttpStatus.OK);
    }
}
