package console.app.console;

import org.springframework.stereotype.Component;

@Component
public class UnknownCommandImpl implements Command {
    @Override
    public void handle() {
        System.out.println("Sorry, I don't understand what you want. Please try again");
    }
}
