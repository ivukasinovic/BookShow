package bookshow.service;

import bookshow.model.users.AdminSys;
import bookshow.repository.AdminSysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ivan V. on 29-Jan-18
 */
@Service
public class AdminSysServiceImpl implements AdminSysService {
    @Autowired
    private AdminSysRepository adminSysRepository;

    @Override
    public List<AdminSys> findAll() {
        return adminSysRepository.findAll();
    }

    @Override
    public AdminSys findOne(Long id) {
        return adminSysRepository.findOne(id);
    }

    @Override
    public AdminSys save(AdminSys adminSys) {
        return adminSysRepository.save(adminSys);
    }

    @Override
    public void delete(Long id) {
        adminSysRepository.delete(id);
    }
}
