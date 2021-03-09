package console.app.console;

import console.app.model.Lecturer;
import console.app.service.LecturerService;
import java.util.List;
import java.util.Scanner;
import org.springframework.stereotype.Component;

@Component
public class GlobalSearchCommandImpl implements Command {
    private final LecturerService lecturerService;

    public GlobalSearchCommandImpl(LecturerService lecturerService) {
        this.lecturerService = lecturerService;
    }

    @Override
    public void handle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter template: ");
        String template = scanner.nextLine();
        List<Lecturer> allByTemplate = lecturerService.findAllByTemplate(template);
        if (allByTemplate.size() == 0) {
            System.out.println("I'm sorry, but I can't find anything.");
            return;
        }
        System.out.println("Global search by " + template + ": ");
        for (Lecturer lecturer: allByTemplate) {
            System.out.println(lecturer.getSurname() + " " + lecturer.getLastname());
        }
    }
}
