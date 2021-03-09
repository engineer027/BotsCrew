package console.app.service;

import console.app.dao.LecturerDao;
import console.app.model.Lecturer;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class LecturerServiceImpl implements LecturerService {
    private final LecturerDao lecturerDao;

    public LecturerServiceImpl(LecturerDao lecturerDao) {
        this.lecturerDao = lecturerDao;
    }

    @Override
    public List<Lecturer> findAllByTemplate(String template) {
        return lecturerDao.findAllByTemplate(template);
    }

    @Override
    public Lecturer add(Lecturer lecturer) {
        return lecturerDao.add(lecturer);
    }
}
