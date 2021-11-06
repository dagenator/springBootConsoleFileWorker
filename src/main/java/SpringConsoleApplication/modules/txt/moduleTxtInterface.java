package SpringConsoleApplication.modules.mp3;
import org.apache.commons.io.FilenameUtils;
import SpringConsoleApplication.modules.moduleInterface;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public  interface moduleTxtInterface extends moduleInterface {

    @Override
    public default boolean formatCheck(File f){

        return FilenameUtils.getExtension(f.getAbsolutePath()).equals("txt");
    }


}
