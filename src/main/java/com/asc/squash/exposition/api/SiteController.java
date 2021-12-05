package com.asc.squash.exposition.api;

import com.asc.squash.application.service.ISiteManagment;
import com.asc.squash.exposition.dto.CreneauDto;
import com.asc.squash.exposition.dto.CreneauDtoResult;
import com.asc.squash.exposition.dto.SiteDto;
import com.asc.squash.exposition.dto.SiteDtoResult;
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
@RequestMapping("v1/site")
@Secured({"ROLE_USER","ROLE_RESP","ROLE_ADMIN"})
@Api(value = "permet la création/mise à jour/suppression dans la base")
public class SiteController {

    private static Logger logger = LoggerFactory.getLogger(SiteController.class);

    @Autowired
    private ISiteManagment siteManagment;

    @PostMapping("/create")
    @ApiOperation(value = "crée un site de squash")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Création effectuée"),
            @ApiResponse(code = 400,message = "données en entrée incorrectes")
    })
    public ResponseEntity<SiteDtoResult> create(@RequestBody SiteDto siteDto) {

        SiteDtoResult siteDtoResult = siteManagment.createSite(siteDto);
        if (siteDtoResult == null){
            return new ResponseEntity<SiteDtoResult>(new SiteDtoResult(0L, siteDto), HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<SiteDtoResult>(siteDtoResult, HttpStatus.CREATED);
        }
    }
}
