package SpringConsoleApplication;

import SpringConsoleApplication.modules.moduleInterface;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

@Service
public class FileService {

    File file;
    public void FindFileType(String line) throws FileNotFoundException {
        file = new File(line);
        moduleInterface finModule;
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
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public moduleInterface[] GetModules(File f){
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(SpringBootConsoleApplication.class);
        ArrayList<moduleInterface> list = new ArrayList<moduleInterface>();
        for(var m: ctx.getBeansOfType(moduleInterface.class).values()){
            if(m.formatCheck(f)) list.add((moduleInterface) m);
        }
        return    list.toArray(new moduleInterface[0]);
        //var m1 = ctx.getBeansOfType(moduleInterface.class);
        //var m2 =m1
        //        .values().stream();
        //var m4 = m2
        //        .filter( e -> e.formatCheck(f));

        //var m3 = m2
         //       .toArray(moduleInterface[]::new);
        //return m3;

    }

    public moduleInterface AskUserModule(moduleInterface[] modules){
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
