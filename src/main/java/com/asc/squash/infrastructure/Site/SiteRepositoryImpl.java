package com.asc.squash.infrastructure.Site;

import com.asc.squash.domaine.ISiteDomaine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SiteRepositoryImpl implements ISiteDomaine {

    @Autowired
    private ISiteRepository siteRepository;
}
