package SpringConsoleApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringBootConsoleApplication
        implements CommandLineRunner {
    FileService fileService;

    @Autowired
    public void SetFileService(FileService f){fileService = f;}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        args[0] = line;
        SpringApplication.run(SpringBootConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) {

        if (args.length != 1) {
            System.out.println("Error. No filename.");
            return;
        }



    }
}