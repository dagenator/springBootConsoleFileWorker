package SpringConsoleApplication.modules.mp3;

import SpringConsoleApplication.modules.moduleInterface;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Component;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.*;

@Component
public class GetName implements moduleMp3Interface {

    @Override
    public String getDescription() {
        return "вывод названия трека из тегов (ffmpeg)";
    }

    @Override
    public void workWithFile(File f) {

    }


}

