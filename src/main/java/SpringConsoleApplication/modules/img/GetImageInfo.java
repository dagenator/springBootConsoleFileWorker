package SpringConsoleApplication.modules.img;

import SpringConsoleApplication.modules.moduleInterface;
import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Collection;
import java.util.Iterator;

@Component
public class GetImageInfo implements moduleImgInterface {

    @Override
    public String getDescription() {
        return "изображение - вывод информации exif (metadata-extractor)";
    }

    @Override
    public void workWithFile(File f) {

        InputStream is = null;
        try {
            is = new FileInputStream(f);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

        try {
            // Базовый объект операционный объект
            Metadata metadata = ImageMetadataReader.readMetadata(is);
            // Получить все различные типы каталогов, такие как ExifSubIFDDirectory, ExifInteropDirectory, ExifThumbnailDirectory и т. Д., Эти классы ExifDirectoryBase расширяет подклассы каталога
            // Обходим каждый каталог отдельно, и соответствующую информацию можно прочитать в соответствии с тегами каталога
            Iterable<Directory> iterable = metadata.getDirectories();
            for (Iterator<Directory> iter = iterable.iterator(); iter.hasNext();) {
                Directory dr = iter.next();
                Collection<Tag> tags = dr.getTags();
                for (Tag tag : tags) {
                    System.out.println(tag.getTagName() + ", " + tag.getDescription());
                }
            }
        } catch (ImageProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
