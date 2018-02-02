package bookshow.service;

import bookshow.model.users.RegisteredUser;
import bookshow.repository.RegisteredUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ivan V. on 28-Jan-18
 */
@Service
public class RegisteredUserServiceImpl implements RegisteredUserService {
    @Autowired
    RegisteredUserRepository registeredUserRepository;

    @Override
    public RegisteredUser findOne(Long id) {
        return registeredUserRepository.findOne(id);
    }

    @Override
    public RegisteredUser findByUsername(String username) {
        return registeredUserRepository.findByUsername(username);
    }

    @Override
    public List<RegisteredUser> findAll() {
        return registeredUserRepository.findAll();
    }

    @Override
    public RegisteredUser save(RegisteredUser regUser) {
        return registeredUserRepository.save(regUser);
    }

    @Override
    public void delete(Long id) {
        registeredUserRepository.delete(id);
    }
}
