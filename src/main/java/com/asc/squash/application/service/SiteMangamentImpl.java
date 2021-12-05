package com.asc.squash.application.service;

import com.asc.squash.exposition.dto.SiteDto;
import com.asc.squash.exposition.dto.SiteDtoResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SiteMangamentImpl implements ISiteManagment{


    @Override
    public SiteDtoResult createSite(SiteDto siteDto) {
        return null;
    }
}
