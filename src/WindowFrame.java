import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Toolkit;

import java.lang.Runnable;

public class WindowFrame extends JFrame implements Runnable {
    static int display_height;
    static int display_width;
    private Thread th = null;

    public WindowFrame() {
        super("起動ランチャー");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        display_width = screenSize.width;
        display_height = screenSize.height;
        int width = 300;
        int height = 110;
        setBounds(display_width / 2 - width / 2,
                display_height / 2 - height / 2,
                width,
                height);
        getContentPane().add(new BootLauncher());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public WindowFrame(String title, int width, int height) {
        super(title);
        setBounds(display_width / 2 - width / 2,
                display_height / 2 - height / 2,
                width,
                height);
        getContentPane().add(new DrawCanvas(width, height));
        this.startGameLoop();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // GameLoop start method
    public synchronized void startGameLoop() {
        if (th == null) {
            th = new Thread(this);
            th.start();
        }
    }

    // GameLoop stop method
    public synchronized void stopGameLoop() {
        if (th != null) {
            th = null;
        }
    }

    // GameLoop
    public void run() {
        while (th != null) {
            try {
                Thread.sleep(25);
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
