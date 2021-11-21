package com.asc.squash.exposition.api;

import com.asc.squash.application.service.IInfoManagment;
import com.asc.squash.exposition.dto.InfoDto;
import com.asc.squash.exposition.dto.InfoDtoResult;
import com.asc.squash.exposition.dto.JoueurDto;
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
@RequestMapping("v1/info")
@Secured({"ROLE_USER","ROLE_RESP","ROLE_ADMIN"})
@Api(value = "permet la création/mise à jour/suppression dans la base")
public class InfoController {

    private static Logger logger = LoggerFactory.getLogger(JoueurController.class);

    @Autowired
    private IInfoManagment infoManagment;

    @PostMapping("/create")
    @ApiOperation(value = "crée un message d'information")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Création effectuée"),
            @ApiResponse(code = 400,message = "données en entrée incorrectes")
    })
    public ResponseEntity<InfoDtoResult> createMessage(@RequestBody InfoDto infoDto) {

        InfoDtoResult infoDtoResult = infoManagment.createInfo(infoDto);
        if (infoDtoResult == null){
            return new ResponseEntity<InfoDtoResult>(new InfoDtoResult(0L, infoDto), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<InfoDtoResult>(infoDtoResult, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    @ApiOperation(value = "récupère la liste des messages d'informations")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Liste des messages retournée"),
            @ApiResponse(code = 404, message = "aucun message trouvé")
    })
    public ResponseEntity<List<InfoDtoResult>> listMessage(){
        return new ResponseEntity<List<InfoDtoResult>>(infoManagment.listInfo(), HttpStatus.OK);
    }

    @PostMapping("/update")
    @ApiOperation(value = "Mise à jour d'un message d'information")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Mise à jour effectuée"),
            @ApiResponse(code = 404, message = "Message non trouvé trouvé")
    })
    public ResponseEntity<String> updateInfo(@RequestBody InfoDtoResult infoDtoResult) {

        if (infoManagment.updateInfo(infoDtoResult)) {
            return new ResponseEntity<String>("Mise à jour effectuée", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Message non trouvé", HttpStatus.NOT_FOUND);
    }


    @ApiOperation(value = "Supprime un message d'information")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Ok, suppression effectuée"),
            @ApiResponse(code = 404,message = "message non supprimé : message absent ou problème lors de la suppression en base")
    })
    @DeleteMapping("/delete/{idInfo}")
    public ResponseEntity<String> deleteMessage(@PathVariable("idInfo") Long idInfo){
        if (infoManagment.deleteInfo(idInfo)) {
            return new ResponseEntity<String>("Suppression effectuée", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Suppression non effectuée", HttpStatus.NOT_FOUND);
    }

}
