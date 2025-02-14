public class Main {

    public static Window_Frame frame;

    public static void main(String[] args) {
        frame = new Window_Frame();
    }
}

/*
 * 
 * ランチャーウィンドウで実装以下
 * 
 */
// class Pretend extends JFrame implements ActionListener{
// public String[] size_str = {"3×3","5×5","7×7"};
// int display_width,display_height;

// public Pretend(String title,int width,int height){
// super(title);
// defineVal();

// setBounds(display_width/2-width/2,display_height/2-height/2,width,height);
// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// setVisible(true);

// }
// void defineVal(){
// Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
// display_width = screenSize.width;
// display_height = screenSize.height;

// JComboBox select_size = new JComboBox(size_str);
// JButton button_boot = new JButton("起動");

// button_boot.addActionListener(this);
// button_boot.setActionCommand("boot");

// JButton button_exit = new JButton("終了");
// button_exit.addActionListener(new ActionListener(){
// public void actionPerformed(ActionEvent e){
// System.out.println("終了");
// System.exit(1);
// }
// });
// JPanel p = new JPanel();
// p.setLayout(new FlowLayout());
// p.add(button_boot);
// p.add(button_exit);

// this.getContentPane().setLayout(new GridLayout(2,1));
// this.add(select_size);
// this.add(p);

// }
// public void actionPerformed(ActionEvent e){
// if(e.getActionCommand().equals("boot")){
// this.dispose();

// }
// }
// }