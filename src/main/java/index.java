import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class index {

    static JFrame frame = new JFrame();

    public static void main(String[] arg){


        System.out.println(System.getProperty("user.dir"));

        try {

            String path = "file://"+ System.getProperty("user.dir").replace(" ","%20")+"/src/main/java/index.html";


            System.out.println(path);
            Desktop.getDesktop().browse(new URL(path).toURI());
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }


    }


}
