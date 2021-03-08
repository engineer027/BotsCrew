package console.app.service;

import console.app.model.Lecturer;
import java.util.List;

public interface LecturerService {
    List<Lecturer> findAllByTemplate(String template);

    Lecturer add(Lecturer lecturer);
}
