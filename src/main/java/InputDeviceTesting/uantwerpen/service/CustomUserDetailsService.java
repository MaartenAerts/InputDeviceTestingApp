package InputDeviceTesting.uantwerpen.service;

import InputDeviceTesting.uantwerpen.model.Researcher;
import InputDeviceTesting.uantwerpen.model.Role;
import InputDeviceTesting.uantwerpen.repo.ResearcherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public Researcher findById(Long id){
        return this.researcherRepo.findById(id);
    }

    public String save(final Researcher researcher) {
        this.researcherRepo.save(researcher);
        return researcher.toString() + " Saved";
    }

    public String deleteById(final Long id){
        Researcher researcher = researcherRepo.findById(id);
        this.researcherRepo.deleteById(id);
        return researcher.toString() + " Deleted";
    }

    /*public String updateResearcher(Researcher researcher){
        this.researcherRepo.save(researcher);
        return researcher.toString() + "Updated";
    }*/


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException { //username = email
        Researcher researcher = researcherRepo.findByEmail(email);
        List<GrantedAuthority> authorities = buildUserAuthority(researcher.getRoles());

        return buildUserForAuthentication(researcher, authorities);
    }

    private User buildUserForAuthentication(Researcher researcher, List<GrantedAuthority> authorities) {
        return new User(researcher.getEmail(), researcher.getPassword(), authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<Role> researcherRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // Build user's authorities
        for (Role researcherRole : researcherRoles) {
            setAuths.add(new SimpleGrantedAuthority(researcherRole.getRoleName()));
        }

        return new ArrayList<GrantedAuthority>(setAuths);
    }
}
