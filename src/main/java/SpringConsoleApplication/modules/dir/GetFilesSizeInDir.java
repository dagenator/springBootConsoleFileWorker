package SpringConsoleApplication.modules.dir;

import SpringConsoleApplication.modules.dir.moduleDirInterface;
import SpringConsoleApplication.modules.moduleInterface;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class GetFilesSizeInDir  implements moduleDirInterface {

    @Override
    public String getDescription() {
        return "подсчет размера всех файлов в каталоге";
    }

    @Override
    public void workWithFile(File f) {
        var listFiles =  f.listFiles();
        assert listFiles != null;
        for (var file :listFiles) {
            System.out.println(file.getName() +" "+file.length());
        }
    }
}
