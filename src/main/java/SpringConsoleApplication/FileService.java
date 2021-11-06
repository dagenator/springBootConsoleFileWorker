package SpringConsoleApplication;

import SpringConsoleApplication.modules.module;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

@Service
public class FileService {

    File file;
    public void FindFileType(String line) throws FileNotFoundException {
        file = new File(line);
        module finModule;
        try{
            if(!file.exists()) throw new FileNotFoundException();
            var modules = GetModules(file);
            if(modules.length == 0) System.out.println("There is no modules for your file");
            finModule =  AskUserModule(modules);
            finModule.workWithFile(file);

        }catch( BeansException e ){
            System.out.println("Something goes wrong with beans. Maybe there is no beans for your file");
        }catch( FileNotFoundException ex ){
            System.out.println("there is no such file");
        }

    }

    public module[] GetModules(File f){
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext("com.example.SpringConsoleApplication.modules");
        return ctx.getBeansOfType(module.class)
                .entrySet()
                .stream()
                .filter( e -> e.getValue().formatCheck(f))
                .toArray(module[]::new);

    }

    public module AskUserModule(module[] modules){
        System.out.println("Choose your fighter");
        for (int i = 0; i < modules.length; i++) {
            System.out.println((i+1)+" "+modules[i].getDescription());
        }
        Scanner in = new Scanner(System.in);
        while (true){
            int num = in.nextInt()-1;
            if( num > modules.length || num < 0 ){
                System.out.println("there is no such module");
                continue;
            }
            return modules[num];
        }
    }
}
