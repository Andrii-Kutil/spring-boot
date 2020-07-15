package springboot.demo.service;

import java.util.List;
import springboot.demo.model.Role;

public interface RoleService {
    Iterable<Role> saveAll(List<Role> roles);
}
