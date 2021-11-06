package SpringConsoleApplication.modules.txt;

import SpringConsoleApplication.modules.moduleInterface;
import SpringConsoleApplication.modules.mp3.moduleTxtInterface;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class SymbolRate implements moduleTxtInterface {
    @Override
    public boolean formatCheck(File f) {
        return false;
    }

    @Override
    public String getDescription() {
        return "вывод частоты вхождения каждого символа";
    }

    @Override
    public void workWithFile(File f) {

    }
}

