package logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FilesManager {
    
    FileInputStream input;
    FileOutputStream output;

    public String openFile(File file) {
        String content = "";
        try {
            input = new FileInputStream(file);
            int ascci;
            while ((ascci = input.read()) != -1) {
                char charcater = (char) ascci;
                content += charcater;
            }
        } catch (IOException e) {
        }
        return content;
    }

    public String saveFile(File file, String content) {
        String response = null;
        try {
            output = new FileOutputStream(file);
            byte[] bytesTxt = content.getBytes();
            output.write(bytesTxt);
            response = "Se guardo con exito el archivo";
        } catch (IOException e) {
        }
        return response;
    }
}
