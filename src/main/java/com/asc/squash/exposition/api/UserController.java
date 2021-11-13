package com.asc.squash.exposition.api;

import com.asc.squash.application.service.IUserManagment;
import com.asc.squash.exposition.dto.JoueurDto;
import com.asc.squash.exposition.dto.UserDto;
import com.asc.squash.exposition.dto.UserDtoCreate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/user")
@Api(value = "permet la création/mise à jour/suppression dans la base")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserManagment userManagment;

    @PostMapping("/create")
    @ApiOperation(value = "crée un utilisateur")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Créatione effectuée"),
            @ApiResponse(code = 400,message = "données en entrée incorrectes"),
            @ApiResponse(code = 409, message = "utilisateur existant")
    })
    public ResponseEntity<String> createUser(@RequestBody UserDtoCreate userDto) {
        return new ResponseEntity<String>(userManagment.createUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    @ApiOperation(value = "récupère la liste des utilisateurs")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Liste des utilisateurs retournée"),
            @ApiResponse(code = 404, message = "aucun utilisateur trouvé")
    })
    public ResponseEntity<List<UserDto>> listJoueur(){
        return new ResponseEntity<List<UserDto>>(userManagment.listUserDto(), HttpStatus.OK);
    }
/*
    @PostMapping("/update")
    @ApiOperation(value = "Mise à jour d'un joueur")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Mise à jour effectuée"),
            @ApiResponse(code = 404, message = "Aucun joueur trouvé")
    })
    public ResponseEntity<JoueurDto> updateJoueur(@RequestBody JoueurDto joueurDto) {
        return new ResponseEntity<JoueurDto>(joueurManagment.updateJoueur(joueurDto), HttpStatus.OK);
    }
*/
    @ApiOperation(value = "Supprime un utilisateur")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Ok, suppression effectuée"),
            @ApiResponse(code = 404,message = "utilisateur non supprimé : utilisateur absent ou problème lors de la suppression en base")
    })
    @DeleteMapping("/delete/{mail}")
    public ResponseEntity<String> deleteJoueur(@PathVariable("mail") String mail){
        return new ResponseEntity<String>(userManagment.deleteUser(mail), HttpStatus.OK);
    }

}
