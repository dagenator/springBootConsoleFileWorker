package SpringConsoleApplication.modules.img;

import SpringConsoleApplication.modules.moduleInterface;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public  interface moduleImgInterface extends moduleInterface {

    @Override
    public default boolean formatCheck(File f)  {
        BufferedImage image = null;
        try {
            image = ImageIO.read(f);
        } catch (IOException e) {
            return false;
        }
        return image !=null;
    }


}
