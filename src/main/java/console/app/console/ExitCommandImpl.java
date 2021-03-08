package console.app.console;

import org.springframework.stereotype.Component;

@Component
public class ExitCommandImpl implements Command {
    @Override
    public void handle() {
        System.out.println("Good – bye then! Mind how you go!");
        System.exit(0);
    }
}
