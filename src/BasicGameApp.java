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
    Player dealer;

    public BasicGameApp() {
        setUpGraphics();

        deck = new Deck();
        deck.shuffle();

        player = new Player(deck);
        dealer = new Player(deck);

        player.printInfo();
        System.out.println("Lets Play BlackJack!!!");
        System.out.println("To Hit Press 'h' and to stand press 's'");
    }

    public void moveThings() {

    }

    private void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);
        g.setColor(new Color(0, 120, 30));
        g.fillRect(0, 0, WIDTH, HEIGHT);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("Blackjack (H = Hit, S = Stand)", 250, 50);
        int x = 100;
        int y = 200;


        int dx = 100;
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Dealer", 100, 80);
        g.drawString("Score: " + dealer.getHandValue(), 100, 100);
        for (Card c : dealer.hand.cards) {

            g.drawRect(dx, 120, 80, 120);
            g.drawString(c.namei, dx + 10, 140);
            dx += 100;
        }

        int ex = 100;

        g.drawString("Player", 100, 300);
        g.drawString("Score: " + player.getHandValue(), 100, 320);

        for (Card c : player.hand.cards) {
            g.setColor(Color.WHITE);
            g.fillRect(ex, 340, 80, 120);
            g.setColor(Color.BLACK);
            g.drawRect(ex, 340, 80, 120);
            g.drawString(c.namei, ex + 10, 360);
            ex += 100;
        }




        if (player.getHandValue() > 21) {
            g.drawString("You Lost...", 200, 600);

        } else if (dealer.getHandValue() > 21) {
            g.drawString("Winner Winner Chicken Dinner", 200, 600);

        } else if (player.getHandValue() > dealer.getHandValue() && dealer.getHandValue() >= 17) {
            g.drawString("Winner Winner Chicken Dinner!", 400, 600);

        } else if (dealer.getHandValue() >= 17 && dealer.getHandValue() > player.getHandValue()) {
            g.drawString("You Lost...", 400, 600);
        }
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
        }

        if (e.getKeyChar() == 's') {

            while (dealer.getHandValue() < 17) {
                dealer.hit(deck);
                if (player.getHandValue() > 21) {
                    System.out.println("Player Busts! Dealer Wins.");
                }
                if (player.getHandValue() == dealer.getHandValue()){
                    System.out.println("You draw!");
                }
            }

            int p = player.getHandValue();
            int d = dealer.getHandValue();


        }
    }
public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}



//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
}