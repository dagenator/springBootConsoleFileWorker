package SpringConsoleApplication.modules.img;

import SpringConsoleApplication.modules.module;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class ImageSize  implements module {

    @Override
    public boolean formatCheck(File f) {
        return false;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void workWithFile(File f) {

    }
}
