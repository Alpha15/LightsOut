import java.util.Calendar;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;

public class DrawCanvas extends JPanel implements MouseMotionListener, MouseListener {
    private int panel_width;
    private int panel_height;
    private int cell_width;
    private int cell_height;
    private int margin_horizontal;  // 水平
    private int margin_vertival;  // 垂直
    private int time_pos_x = 0;
    Calendar cTime;
    Point pt;
    LightData[][] data;

    public DrawCanvas(int width, int height) {
        this.panel_width = width;
        this.panel_height = height;
        addMouseMotionListener(this);
        addMouseListener(this);
        data = new LightData[(width - 200) / 50][(height - 200) / 50];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = new LightData(101 + 50 * j, 101 + 50 * i, 48, 48, false);
            }
        }

        JButton reset = new JButton("reset");
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < data.length; i++) {
                    for (int j = 0; j < data[i].length; j++) {
                        data[i][j].setOn_off(false);
                    }
                }
            }
        });
        reset.setBounds(panel_width / 2 - 40, panel_height - 30, 80, 30);
        add(reset);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);

        cTime = Calendar.getInstance();
        g.drawString(
                "現在時刻:"
                + cTime.get(Calendar.HOUR)+ "時" 
                + cTime.get(Calendar.MINUTE) + "分"
                + cTime.get(Calendar.SECOND) + "秒です",
                time_pos_x++, 
                50);
        if (time_pos_x >= 400)
            time_pos_x = -150;

        for (int i = 0; i < (panel_width - 200) / 50; i++) {
            for (int j = 0; j < (panel_height - 200) / 50; j++) {
                g.drawRect(100 + i * 50, 100 + j * 50, 50, 50);
            }
        }

        g.setColor(Color.YELLOW);
        LightData d;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                d = data[i][j];
                if (d.getOn_off()) {
                    g.fillRect(d.getX(), d.getY(), d.getWidth(), d.getHeight());
                }
            }
        }

    }

    public void Check_Clicked(int x, int y) {
        LightData d;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                d = data[i][j];
                if (d.getX() < x && (d.getX() + d.getWidth()) > x) {
                    if (d.getY() < y && (d.getY() + d.getHeight()) > y) {
                        data[i][j].setOn_off(!data[i][j].getOn_off());
                        if (i == 0) {
                            data[i + 1][j].setOn_off(!data[i + 1][j].getOn_off());
                            if (j == 0) {
                                data[i][j + 1].setOn_off(!data[i][j + 1].getOn_off());
                            } else if (j == data[i].length - 1) {
                                data[i][j - 1].setOn_off(!data[i][j - 1].getOn_off());
                            } else {
                                data[i][j + 1].setOn_off(!data[i][j + 1].getOn_off());
                                data[i][j - 1].setOn_off(!data[i][j - 1].getOn_off());
                            }
                        } else if (i == data.length - 1) {
                            data[i - 1][j].setOn_off(!data[i - 1][j].getOn_off());
                            if (j == 0) {
                                data[i][j + 1].setOn_off(!data[i][j + 1].getOn_off());
                            } else if (j == data[i].length - 1) {
                                data[i][j - 1].setOn_off(!data[i][j - 1].getOn_off());
                            } else {
                                data[i][j + 1].setOn_off(!data[i][j + 1].getOn_off());
                                data[i][j - 1].setOn_off(!data[i][j - 1].getOn_off());
                            }
                        } else {
                            data[i + 1][j].setOn_off(!data[i + 1][j].getOn_off());
                            data[i - 1][j].setOn_off(!data[i - 1][j].getOn_off());
                            if (j == 0) {
                                data[i][j + 1].setOn_off(!data[i][j + 1].getOn_off());
                            } else if (j == data[i].length - 1) {
                                data[i][j - 1].setOn_off(!data[i][j - 1].getOn_off());
                            } else {
                                data[i][j + 1].setOn_off(!data[i][j + 1].getOn_off());
                                data[i][j - 1].setOn_off(!data[i][j - 1].getOn_off());
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        pt = e.getPoint();
        Check_Clicked((int) pt.getX(), (int) pt.getY());
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {

    }
}
