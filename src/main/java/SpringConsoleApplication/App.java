package SpringConsoleApplication;

import java.util.Arrays;

import SpringConsoleApplication.modules.module;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages= "SpringConsoleApplication.modules",
        includeFilters=
        @ComponentScan.Filter(
                type= FilterType.ASSIGNABLE_TYPE,
                classes= module.class),
        useDefaultFilters=false)
public class App {

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //String line = in.nextLine();
        //File file = new File(line);
        //SpringApplication.run(App.class, args);
    }

    //Почему это метод работает? ват?

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            var beanNames = ctx.getBeansOfType(module.class);

            for (var beanName : beanNames.keySet()) {
                System.out.println(beanName +" "+beanNames.get(beanName).getDescription());
            }

        };
    }

}