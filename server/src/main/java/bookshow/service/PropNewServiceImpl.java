package bookshow.service;

import bookshow.model.props.PropNew;
import bookshow.repository.PropNewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ivan V. on 29-Jan-18
 */
@Service
public class PropNewServiceImpl implements PropNewService {
    @Autowired
    private PropNewRepository propNewRepository;

    @Override
    public List<PropNew> findAll() {
        return propNewRepository.findAll();
    }

    @Override
    public PropNew findOne(Long id) {
        return propNewRepository.findOne(id);
    }

    @Override
    public PropNew save(PropNew propNew) {
        return propNewRepository.save(propNew);
    }

    @Override
    public void delete(Long id) {
        propNewRepository.delete(id);
    }


}
