import javax.swing.*;
import java.awt.*;

public class VideoTraining  extends JFrame {

    VideoTraining(){
        getContentPane().setBackground(new Color(0, 33, 72));
        setLayout(null);

        ///////////////////

        setSize(1120, 630);
        setLocation(300, 100);
        setVisible(true);
    }

    public static void main(String[] args) {
        new VideoTraining();
    }
}
