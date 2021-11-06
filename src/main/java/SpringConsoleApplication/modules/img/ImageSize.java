package SpringConsoleApplication.modules.img;

import SpringConsoleApplication.modules.moduleInterface;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Component
public class ImageSize  implements moduleImgInterface {


    @Override
    public String getDescription() {
        return "изображение - вывод размера изображения";
    }

    @Override
    public void workWithFile(File f) {
        BufferedImage bimg = null;
        try {
            bimg = ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int width = bimg.getWidth();
        int height = bimg.getHeight();
        System.out.println("width " + width);
        System.out.println("height " + height);
    }
}
