package com.asc.squash.exposition.api;

import com.asc.squash.application.service.IUserManagment;
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
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/user")
@Secured({"ROLE_USER","ROLE_RESP","ROLE_ADMIN"})
@Api(value = "permet la création/mise à jour/suppression dans la base")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserManagment userManagment;

    @PostMapping("/create")
    @ApiOperation(value = "crée un utilisateur")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Création effectuée"),
            @ApiResponse(code = 400,message = "données en entrée incorrectes"),
            @ApiResponse(code = 409, message = "utilisateur existant")
    })
    public ResponseEntity<String> createUser(@RequestBody UserDtoCreate userDto) {
        logger.info("idUser : " + userDto.getIdUSer());
        logger.info("idASC : " + userDto.getIdAsc());
        logger.info("roles : " + userDto.getRoles());
        if (userDto.getIdUSer() == null && userDto.getIdAsc() !=null){
            userDto.setIdUSer(userDto.getIdAsc());
        }
        return new ResponseEntity<String>(userManagment.createUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping("/get/{idUser}")
    @ApiOperation(value = "récupère les propriété d'un utilisateur à partir de l'id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "utilisateur retourné"),
            @ApiResponse(code = 404, message = "aucun utilisateur trouvé")
    })
    public ResponseEntity<UserDto> getUser (@PathVariable("idUser") String idUser) {
        logger.info(idUser);
        return new ResponseEntity<UserDto>(userManagment.findUserById(idUser), HttpStatus.OK);
    }

    @GetMapping("/list")
    @ApiOperation(value = "récupère la liste des utilisateurs")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Liste des utilisateurs retournée"),
            @ApiResponse(code = 404, message = "aucun utilisateur trouvé")
    })
    public ResponseEntity<List<UserDto>> listUser(){
        return new ResponseEntity<List<UserDto>>(userManagment.listUserDto(), HttpStatus.OK);
    }

    @PostMapping("/update")
    @ApiOperation(value = "Mise à jour d'un utilisateur")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Mise à jour effectuée"),
            @ApiResponse(code = 404, message = "Aucun utilisateur trouvé")
    })
    public ResponseEntity<UserDtoCreate> updateJoueur(@RequestBody UserDtoCreate userDto) {

        return new ResponseEntity<UserDtoCreate>(userManagment.updateUser(userDto), HttpStatus.OK);
    }

    @ApiOperation(value = "Supprime un utilisateur")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "Ok, suppression effectuée"),
            @ApiResponse(code = 404,message = "utilisateur non supprimé : utilisateur absent ou problème lors de la suppression en base")
    })
    @DeleteMapping("/delete/{idUser}")
    public ResponseEntity<String> deleteJoueur(@PathVariable("idUser") String idUser){
        return new ResponseEntity<String>(userManagment.deleteUser(idUser), HttpStatus.OK);
    }

}
