package console.app.console;

import org.springframework.stereotype.Component;

@Component
public class MenuConsoleApp implements Command {
    @Override
    public void handle() {
        System.out.println("Please write the command:");
        System.out.println("Who is head of department;");
        System.out.println("Show department statistics;");
        System.out.println("Show the average salary for the department;");
        System.out.println("Show count of employee;");
        System.out.println("Global search;");
        System.out.println("close - exit the app.");
    }
}
