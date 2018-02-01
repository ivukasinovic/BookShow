package bookshow.service;

import bookshow.model.users.SysAdmin;
import bookshow.repository.SysAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ivan V. on 29-Jan-18
 */
@Service
public class SysAdminServiceImpl implements SysAdminService {
    @Autowired
    private SysAdminRepository sysAdminRepository;

    @Override
    public List<SysAdmin> findAll() {
        return sysAdminRepository.findAll();
    }

    @Override
    public SysAdmin findOne(Long id) {
        return sysAdminRepository.findOne(id);
    }

    @Override
    public SysAdmin save(SysAdmin sysAdmin) {
        return sysAdminRepository.save(sysAdmin);
    }

    @Override
    public void delete(Long id) {
        sysAdminRepository.delete(id);
    }
}
