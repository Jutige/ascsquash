package com.asc.squash.application.service;

import com.asc.squash.exposition.dto.SiteDto;
import com.asc.squash.exposition.dto.SiteDtoResult;

public interface ISiteManagment {

    SiteDtoResult createSite(SiteDto siteDto);
}
