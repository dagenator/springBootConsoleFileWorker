package SpringConsoleApplication.modules.dir;

import SpringConsoleApplication.modules.dir.moduleDirInterface;
import SpringConsoleApplication.modules.moduleInterface;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class GetDirWeight implements moduleDirInterface {

    @Override
    public String getDescription() {
        return "вывод общего веса каталога";
    }

    @Override
    public void workWithFile(File f) {
        var listFiles =  f.listFiles();
        assert listFiles != null;
        double sum =0;
        for (var file :listFiles) {
            sum =+ file.length();
        }
        try {
            System.out.println("Weight of"+ f.getCanonicalPath()+" is: " +sum);
        } catch (IOException e) {
            System.out.println("Weight is: " +sum);
        }
    }
}
