package InputDeviceTesting.uantwerpen.service;

import InputDeviceTesting.uantwerpen.model.Researcher;
import InputDeviceTesting.uantwerpen.model.Role;
import InputDeviceTesting.uantwerpen.repo.ResearcherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.*;

/**
 * Created by Niels on 23/10/2015.
 */
//@Qualifier("ResearcherService")
//@Configurable
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private ResearcherRepo researcherRepo;


    public List<Researcher> findAll(){
        return this.researcherRepo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String Email) throws UsernameNotFoundException {
        UserDetails ud = null;
        for (Researcher researcher : findAll()){
            if (Email.equals(researcher.getEmail())){
                Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                for (Role role : researcher.getRoles()) {
                        authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
                }

                ud = new org.springframework.security.core.userdetails.User(Email, researcher.getPassword(), true, true, true, true,authorities);
            }
        }
        if (ud == null) throw new UsernameNotFoundException("No Researcher with email '" + Email + "' found!");
        return ud;
    }

}
