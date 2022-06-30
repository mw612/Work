
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;




public class Listener_Window extends WindowAdapter{

    @Override
    public void windowClosing(WindowEvent e){
        JFrame frame = (JFrame) e.getSource();
        frame.dispose();
        System.exit(0);
      }   
}
