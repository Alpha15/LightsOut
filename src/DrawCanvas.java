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
    private int margin_vertical;  // 垂直
    private int time_pos_x = 0;
    private Calendar cTime;
    private Point pt;
    private LightData[][] data;

    public DrawCanvas(int p_width, int p_height, int c_width, int c_height, int m_horizontal, int m_vertical) {
        this.panel_width = p_width;
        this.panel_height = p_height;
        this.cell_width = c_width;
        this.cell_height = c_height;
        this.margin_horizontal = m_horizontal;
        this.margin_vertical = m_vertical;
        addMouseMotionListener(this);
        addMouseListener(this);
        data = new LightData[(this.panel_width - this.margin_horizontal) / this.cell_width][(this.panel_height - this.margin_vertical) / this.cell_height];
        /*
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = new LightData(101 + 50 * j, 101 + 50 * i, 48, 48, false);
            }
        }
        */
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = new LightData(
                        ((this.margin_horizontal/2)+1) + this.cell_width * j,
                        ((this.margin_vertical/2)+1) + this.cell_height * i,
                        this.cell_width - 2,
                        this.cell_height - 2,
                        false
                        );
            }
        }

        JButton reset = new JButton("reset");
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < data.length; i++) {
                    for (int j = 0; j < data[i].length; j++) {
                        data[i][j].setIsActive(false);
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

        /*
        for (int i = 0; i < (panel_width - 200) / 50; i++) {
            for (int j = 0; j < (panel_height - 200) / 50; j++) {
                g.drawRect(100 + i * 50, 100 + j * 50, 50, 50);
            }
        }
        */
        for (int i = 0; i < (this.panel_width - this.margin_horizontal) / this.cell_width; i++) {
            for (int j = 0; j < (this.panel_height - this.margin_vertical) / this.cell_height; j++) {
                g.drawRect(
                        (this.margin_horizontal/2) + i * this.cell_width,  // width
                        (this.margin_vertical/2) + j * this.cell_height,  // height
                        this.cell_width, this.cell_height  // x, y
                        );
            }
        }

        g.setColor(Color.YELLOW);
        LightData d;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                d = data[i][j];
                if (d.getIsActive()) {
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
                        data[i][j].setIsActive(!data[i][j].getIsActive());
                        if (i == 0) {
                            data[i + 1][j].setIsActive(!data[i + 1][j].getIsActive());
                            if (j == 0) {
                                data[i][j + 1].setIsActive(!data[i][j + 1].getIsActive());
                            } else if (j == data[i].length - 1) {
                                data[i][j - 1].setIsActive(!data[i][j - 1].getIsActive());
                            } else {
                                data[i][j + 1].setIsActive(!data[i][j + 1].getIsActive());
                                data[i][j - 1].setIsActive(!data[i][j - 1].getIsActive());
                            }
                        } else if (i == data.length - 1) {
                            data[i - 1][j].setIsActive(!data[i - 1][j].getIsActive());
                            if (j == 0) {
                                data[i][j + 1].setIsActive(!data[i][j + 1].getIsActive());
                            } else if (j == data[i].length - 1) {
                                data[i][j - 1].setIsActive(!data[i][j - 1].getIsActive());
                            } else {
                                data[i][j + 1].setIsActive(!data[i][j + 1].getIsActive());
                                data[i][j - 1].setIsActive(!data[i][j - 1].getIsActive());
                            }
                        } else {
                            data[i + 1][j].setIsActive(!data[i + 1][j].getIsActive());
                            data[i - 1][j].setIsActive(!data[i - 1][j].getIsActive());
                            if (j == 0) {
                                data[i][j + 1].setIsActive(!data[i][j + 1].getIsActive());
                            } else if (j == data[i].length - 1) {
                                data[i][j - 1].setIsActive(!data[i][j - 1].getIsActive());
                            } else {
                                data[i][j + 1].setIsActive(!data[i][j + 1].getIsActive());
                                data[i][j - 1].setIsActive(!data[i][j - 1].getIsActive());
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

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        pt = e.getPoint();
        Check_Clicked((int) pt.getX(), (int) pt.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
