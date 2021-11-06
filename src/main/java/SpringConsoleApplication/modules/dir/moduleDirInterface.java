package SpringConsoleApplication.modules.dir;

import SpringConsoleApplication.modules.moduleInterface;

import java.io.File;

public  interface moduleDirInterface extends moduleInterface {

    @Override
    public default boolean formatCheck(File f) {
        return f.isDirectory();
    }


}
