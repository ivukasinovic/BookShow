package bookshow.service;

import bookshow.model.props.NewProp;
import bookshow.repository.NewPropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ivan V. on 29-Jan-18
 */
@Service
public class NewPropServiceImpl implements NewPropService {
    @Autowired
    private NewPropRepository newPropRepository;

    @Override
    public List<NewProp> findAll() {
        return newPropRepository.findAll();
    }

    @Override
    public NewProp findOne(Long id) {
        return newPropRepository.findOne(id);
    }

    @Override
    public NewProp save(NewProp newProp) {
        return newPropRepository.save(newProp);
    }

    @Override
    public void delete(Long id) {
        newPropRepository.delete(id);
    }


}
