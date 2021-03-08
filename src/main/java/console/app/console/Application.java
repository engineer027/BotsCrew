package console.app.console;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Application {
    private final Map<String, Command> commandMap;

    public Application(ApplicationContext applicationContext) {
        this.commandMap = new HashMap<>();
        commandMap.put("Who is head of department",
                applicationContext.getBean(HeadOfDepartmentCommandImpl.class));
        commandMap.put("Show department statistics",
                applicationContext.getBean(DepartmentStatisticCommandImpl.class));
        commandMap.put("Show the average salary for the department",
                applicationContext.getBean(AverageSalaryForDepartmentCommandImpl.class));
        commandMap.put("Show count of employee",
                applicationContext.getBean(CountOfEmployeeCommandImpl.class));
        commandMap.put("Global search",
                applicationContext.getBean(GlobalSearchCommandImpl.class));
        commandMap.put("close",
                applicationContext.getBean(ExitCommandImpl.class));
    }

    public void run() {
        new MenuConsoleApp().handle();
        Scanner scanner = new Scanner(System.in);
        String comand = scanner.nextLine();
        commandReader(comand);

    }

    private void commandReader(String command) {
        while (true) {
            if (command.equals("menu")) {
                new MenuConsoleApp().handle();
                Scanner scanner = new Scanner(System.in);
                commandReader(scanner.nextLine());
            }
            commandMap.getOrDefault(command, new UnknownCommandImpl()).handle();
            command = "menu";
        }
    }
}
