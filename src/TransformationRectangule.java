
import java.awt.*;
import java.awt.event.*;


public class TransformationRectangule extends Frame implements ActionListener {


    int[] x = {400,600,600,400};
    int[] y = {400,400,200,200};

    public TransformationRectangule() {
        int windowWidth = 800;

        addWindowListener(new MyFinishWindow());  // Add WindowListener to exit the program when window is closed
        setTitle("Transformation");  // Set title

        MenuBar menu_bar = new MenuBar();  // Create menu
        Menu def = new Menu("Menu");
        def.add(new MenuItem("Set Default"));
        def.addActionListener(this);
        menu_bar.add(def);
        setMenuBar(menu_bar);

        Panel panel=new Panel();  // Add control panel
        panel.setBounds(0,50,windowWidth ,50); //Black region with buttons



        // Creating buttons
        Button button_s = new Button();
        button_s.setLabel("Shear in X"); //First button
        button_s.addActionListener(this);
        Button button_b = new Button();
        button_b.addActionListener(this);
        button_b.setLabel("Shear in Y"); //Second button
        Button button_ = new Button();
        button_.addActionListener(this);
        button_.setLabel("Stretch in X"); //Third button
        Button button2 = new Button();
        button2.addActionListener(this);
        button2.setLabel("Stretch in Y"); //Fourth button
        Button button3 = new Button();
        button3.addActionListener(this);
        button3.setLabel("Scale Up"); //Fifth button
        Button button4 = new Button();
        button4.addActionListener(this);
        button4.setLabel("Scale Down"); //Sixth button

        //Adding buttons
        panel.add(button_s);
        panel.add(button_b);
        panel.add(button_);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);


        //color of the panel
        panel.setBackground(Color.black);
        add(panel);
        setLayout(null); //setting layout
        setBackground(Color.getHSBColor(0.8f, 0.2f, 0.9f)); //setting background color

    }
    public class MyFinishWindow extends WindowAdapter //Adapter controls the exit operation
    {
        public void windowClosing(WindowEvent e)
        {
            System.exit(0);
        }
    }

    //Drawing square
    public void paint(Graphics g) {

        Graphics2D gd = (Graphics2D) g;//g2d object
        gd.setColor(Color.white);//white color for lines
        gd.drawLine(400, 0, 400, 800); //drawing lines
        gd.drawLine(0, 400, 800, 400);
        gd.setColor(Color.yellow);
        gd.fillPolygon(x, y, 4); //fill square
    }

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String but = e.getActionCommand();
        if(but.equals("Set Default")) {
            x[0]=600;
            x[1]=800;
            x[2]=800;
            x[3]=600;

            y[0]=600;
            y[1]=600;
            y[2]=400;
            y[3]=400;

            repaint();

        }
        else if(but.equals("Shear in X")) {
            x[2]=x[2]+35;
            x[3]=x[3]+35;
            repaint();
        }
        else if(but.equals("Shear in Y")) {
            y[1]=y[1]-35;
            y[2]=y[2]-35;

            repaint();
        }
        else if(but.equals("Stretch in X")) {

            x[1]=x[1]+35;
            x[2]=x[2]+35;


            repaint();
        }
        else if(but.equals("Stretch in Y")) {
            y[2]=y[2]-35;
            y[3]=y[3]-35;

            repaint();
        }
        else if(but.equals("Scale Up")) {
            x[1]=x[1]+35;
            x[2]=x[2]+35;
            y[2]=y[2]-35;
            y[3]=y[3]-35;
            repaint();
        }
        else if(but.equals("Scale Down")) {

            x[1]=x[1]-35;
            x[2]=x[2]-35;
            y[2]=y[2]+35;
            y[3]=y[3]+35;
            repaint();
        }
    }
    public static void main(String[] args) {
        TransformationRectangule lab6=new TransformationRectangule();
        lab6.setSize(800, 800); // Set Frame s ize to 800x800)
        lab6.setVisible(true);// Make the vindow visible.

    }

}