package console.app.dao;

import console.app.model.Lecturer;
import java.util.List;

public interface LecturerDao {
    List<Lecturer> findAllByTemplate(String template);

    public Lecturer add(Lecturer lecturer);
}
