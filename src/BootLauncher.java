import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BootLauncher extends JPanel implements ActionListener {
    private String[] size_str = { "3x3", "5x5", "7x7" };
    private JComboBox select_size;
    private final int c_w = 50;  // cell_width
    private final int c_h = 50;  // cell_height

    public BootLauncher() {
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        select_size = new JComboBox(size_str);
        JButton button_boot = new JButton("起動");
        JButton button_exit = new JButton("終了");

        p1.setLayout(new GridLayout(2, 1));
        p2.setLayout(new FlowLayout());

        button_boot.addActionListener(this);
        button_boot.setActionCommand("boot");
        button_exit.addActionListener(this);
        button_exit.setActionCommand("exit");

        p1.add(select_size);
        p2.add(button_boot);
        p2.add(button_exit);
        p1.add(p2);
        this.add(p1);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("boot")) {
            String title;
            int width, height;
            System.out.println(select_size.getSelectedItem());
            String size = (String) select_size.getSelectedItem();
            if (size.equals("3x3")) {
                width = c_w * 3;
                height = c_h * 3;
            } else if (size.equals("5x5")) {
                width = c_w * 5;
                height = c_h * 5;
            } else if (size.equals("7x7")) {
                width = c_w * 7;
                height = c_h * 7;
            } else {
                width = c_w * 3;
                height = c_h * 3;
            }
            Main.frame.dispose();
            Main.frame = new WindowFrame("LightsOut:" + size, 200 + width, 200 + height);
        }
        if (e.getActionCommand().equals("exit")) {
            System.exit(0);
        }
    }
}
