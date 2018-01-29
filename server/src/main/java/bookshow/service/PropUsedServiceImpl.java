package bookshow.service;

import bookshow.model.props.PropUsed;
import bookshow.repository.PropUsedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ivan V. on 29-Jan-18
 */
@Service
public class PropUsedServiceImpl implements PropUsedService {
    @Autowired
    private PropUsedRepository propUsedRepository;

    @Override
    public List<PropUsed> findAll() {
        return propUsedRepository.findAll();
    }

    @Override
    public PropUsed findOne(Long id) {
        return propUsedRepository.findOne(id);
    }

    @Override
    public PropUsed save(PropUsed propUsed) {
        return propUsedRepository.save(propUsed);
    }

    @Override
    public void delete(Long id) {
        propUsedRepository.delete(id);
    }
}
