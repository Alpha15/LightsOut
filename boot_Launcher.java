import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class boot_Launcher extends JPanel implements ActionListener {
    String[] size_str = { "3x3", "5x5" };
    JComboBox select_size;

    public boot_Launcher() {
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
                width = 50 * 3;
                height = 50 * 3;
            } else if (size.equals("5x5")) {
                width = 50 * 5;
                height = 50 * 5;
            } else {
                width = 50 * 3;
                height = 50 * 3;
            }
            Main.frame.dispose();
            Main.frame = new Window_Frame("LightsOut:" + size, 200 + width, 200 + height);
        }
        if (e.getActionCommand().equals("exit")) {
            System.exit(1);
        }
    }
}