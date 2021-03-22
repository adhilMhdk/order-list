import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class index {

    static JFrame frame = new JFrame();

    public static void main(String[] arg){
        frame.setSize(400,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);

        JLabel jLabel = new JLabel("Setting up environments...",SwingConstants.CENTER);
        jLabel.setSize(50,50);
        frame.add(jLabel);

        jLabel.setText("Getting os");

        jLabel.setText("Detected "+getOperatingSystem());

        System.out.println(getOperatingSystem());

        jLabel.setText("installing dependencies");
        try {
            Process prs= Runtime.getRuntime().exec("git commit -m 'intial init'");
            printResults(prs);
            jLabel.setText("done");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static Process execCmd(String cmd) throws java.io.IOException {
        String[] args = new String[] {"/bin/bash", "-c", "java -version", "with", "args"};
        return new ProcessBuilder(args).start();

    }
    public static void printResults(Process process) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = "";
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

    public static String getOperatingSystem() {
        return System.getProperty("os.name");
    }
}
