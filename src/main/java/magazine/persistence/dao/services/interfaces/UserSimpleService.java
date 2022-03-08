package magazine.persistence.dao.services.interfaces;

import magazine.persistence.model.User;

public interface UserSimpleService {
    User addUser(User user);

    User getUserByLogin(String login);
}
