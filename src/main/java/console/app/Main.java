package console.app;

import console.app.config.AppConfig;
import console.app.console.Application;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        Application application = new Application(context);
        application.run();
    }
}
