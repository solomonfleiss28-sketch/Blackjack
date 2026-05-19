// Graphics Libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;

public class BasicGameApp implements Runnable, KeyListener {

    final int WIDTH = 1000;
    final int HEIGHT = 700;

    Deck deck;
    Player player;

    public BasicGameApp() {
        setUpGraphics();

        deck = new Deck();
        deck.shuffle();

        player = new Player(deck);

        player.printInfo();
        System.out.println("Lets Play BlackJack!!!");
        System.out.println("To Hit Press 'h' and to stand press 's'");
    }

    public void moveThings() {

    }

    private void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);
        g.dispose();
        bufferStrategy.show();
    }



    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;
    public BufferStrategy bufferStrategy;

    public static void main(String[] args) {
        BasicGameApp ex = new BasicGameApp();
        new Thread(ex).start();
    }

    public void run() {

        while (true) {
            moveThings();
            render();
            pause(10);
        }
    }

    public void pause(int time ) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }

    private Image getImage(String filename){
        return Toolkit.getDefaultToolkit().getImage(filename);
    }

    //Graphics setup method
    private void setUpGraphics() {
        frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.

        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
        panel.setLayout(null);   //set the layout

        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);
        canvas.addKeyListener(this);

        panel.add(canvas);

        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
        frame.setResizable(false);   //makes it so the frame cannot be resized
        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
        System.out.println("DONE graphic setup");
    }

    public void keyPressed(KeyEvent e) {

        if (e.getKeyChar() == 'h') {
            player.hit(deck);
            player.printInfo();
        }

        if (e.getKeyChar() == 's') {
            System.out.println("Final Score: " + player.getHandValue());
        }
    }
public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}



//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
}