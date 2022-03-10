package magazine.persistence.dao.services.impl;

import magazine.persistence.dao.repositories.UserRepository;
import magazine.persistence.dao.services.interfaces.UserSimpleService;
import magazine.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSimpleServiceImpl implements UserSimpleService {
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserByLogin(String userName) {
        return userRepository.getUserByLogin(userName);
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
