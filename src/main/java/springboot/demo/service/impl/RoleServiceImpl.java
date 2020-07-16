package springboot.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.demo.model.Role;
import springboot.demo.repository.RoleRepository;
import springboot.demo.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Iterable<Role> saveAll(List<Role> roles) {
        return roleRepository.saveAll(roles);
    }
}
