package SpringConsoleApplication.modules;

import java.io.File;
import java.io.IOException;

public interface moduleInterface {


    public boolean formatCheck(File f);

    public String getDescription();

    public void workWithFile(File f);

}
