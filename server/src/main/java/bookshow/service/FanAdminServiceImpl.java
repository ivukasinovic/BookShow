package bookshow.service;

import bookshow.model.users.FanAdmin;
import bookshow.repository.FanAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ivan V. on 28-Jan-18
 */
@Service
public class FanAdminServiceImpl implements FanAdminService {
    @Autowired
    private FanAdminRepository fanAdminRepository;

    @Override
    public FanAdmin findOne(Long id) {
        return fanAdminRepository.findOne(id);
    }

    @Override
    public List<FanAdmin> findAll() {
        return fanAdminRepository.findAll();
    }

    @Override
    public FanAdmin save(FanAdmin fanAdmin) {
        return fanAdminRepository.save(fanAdmin);
    }

    @Override
    public FanAdmin update(FanAdmin fanAdmin) {
        return fanAdminRepository.save(fanAdmin);
    }

    @Override
    public void delete(Long id) {
        fanAdminRepository.delete(id);
    }
}
