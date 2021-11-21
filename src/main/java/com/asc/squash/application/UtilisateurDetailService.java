package com.asc.squash.application;

import com.asc.squash.domaine.IUserDomaine;
import com.asc.squash.domaine.RoleTypeEnum;
import com.asc.squash.domaine.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class UtilisateurDetailService implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(UtilisateurDetailService.class);

    @Autowired
    IUserDomaine userDomaine;

    @Override
    public UserDetails loadUserByUsername(String idUser) throws UsernameNotFoundException {

        User userSquash = userDomaine.findByIdUser(idUser);
        if (userSquash == null){
            throw new UsernameNotFoundException("Utilisateur, id : " + idUser+ "non trouvé");
        }
        logger.info(userSquash.getIdUser() + " ,password : "+userSquash.getPassword());
        return new org.springframework.security.core.userdetails.User(idUser, userSquash.getPassword(), getRolesAuthorities(userSquash));
    }

    private Collection<? extends GrantedAuthority> getRolesAuthorities(User user)throws UsernameNotFoundException {

        List<GrantedAuthority> rolesAuthorities = new ArrayList<GrantedAuthority>();
        if (rolesAuthorities !=null) {
            for (RoleTypeEnum role : user.getRole()) {
                rolesAuthorities.add(new SimpleGrantedAuthority(role.name()));
                logger.info(user.getIdUser()+" : ROLE - "+role.name());
            }
        }
        return rolesAuthorities;
    }
}
