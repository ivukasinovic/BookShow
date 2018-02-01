package bookshow.service;

import bookshow.model.Show;

import java.util.List;

/**
 * Created by Ivan V. on 01-Feb-18
 */
public interface ShowService {
    List<Show> findAll();

    Show findOne(Long id);

    Show save(Show show);

    void delete(Long id);
}
