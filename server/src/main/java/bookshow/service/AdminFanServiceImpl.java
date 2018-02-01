package bookshow.service;

import bookshow.model.users.AdminFan;
import bookshow.repository.AdminFanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ivan V. on 28-Jan-18
 */
@Service
public class AdminFanServiceImpl implements AdminFanService {
    @Autowired
    private AdminFanRepository adminFanRepository;

    @Override
    public AdminFan findOne(Long id) {
        return adminFanRepository.findOne(id);
    }

    @Override
    public List<AdminFan> findAll() {
        return adminFanRepository.findAll();
    }

    @Override
    public AdminFan save(AdminFan adminFan) {
        return adminFanRepository.save(adminFan);
    }

    @Override
    public AdminFan update(AdminFan adminFan) {
        return adminFanRepository.save(adminFan);
    }

    @Override
    public void delete(Long id) {
        adminFanRepository.delete(id);
    }
}
