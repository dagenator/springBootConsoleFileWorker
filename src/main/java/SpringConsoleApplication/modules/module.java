package SpringConsoleApplication.modules;

import java.io.File;

public interface module {

    public boolean formatCheck(File f);

    public String getDescription();

    public void workWithFile(File f);

}
