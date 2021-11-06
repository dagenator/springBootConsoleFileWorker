package SpringConsoleApplication.modules.mp3;

import SpringConsoleApplication.modules.moduleInterface;
import org.springframework.stereotype.Component;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.util.Map;

@Component
public class GetLenghtInMin implements moduleMp3Interface {

    @Override
    public String getDescription() {
        return "вывод длительности в минутах";
    }

    @Override
    public void workWithFile(File f) {

        AudioFileFormat baseFileFormat = null;
        try {
            baseFileFormat = AudioSystem.getAudioFileFormat(f);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map properties = baseFileFormat.properties();
        Long duration = (Long) properties.get("duration");
        System.out.println("Duration in min: "+ (int)(duration/60) );
    }
}

