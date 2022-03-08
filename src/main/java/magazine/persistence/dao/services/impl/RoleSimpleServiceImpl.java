package magazine.persistence.dao.services.impl;

import magazine.persistence.dao.repositories.RoleRepository;
import magazine.persistence.dao.services.interfaces.RoleSimpleService;
import magazine.persistence.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleSimpleServiceImpl implements RoleSimpleService {
    private RoleRepository roleRepository;

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
}
