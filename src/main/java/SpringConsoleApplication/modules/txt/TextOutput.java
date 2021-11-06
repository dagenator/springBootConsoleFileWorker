package SpringConsoleApplication.modules.txt;

import SpringConsoleApplication.modules.moduleInterface;
import SpringConsoleApplication.modules.mp3.moduleTxtInterface;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class TextOutput implements moduleInterface {
    @Override
    public boolean formatCheck(File f) {
        return false;
    }

    @Override
    public String getDescription() {
        return "вывод текста";
    }

    @Override
    public void workWithFile(File f) {

    }
}

