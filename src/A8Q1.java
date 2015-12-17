
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author sevcm7279
 */
public class A8Q1 extends JComponent {

    // Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000) / desiredFPS;
    int x1 = 350;
    int x2 = 450;

    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);

        // GAME DRAWING GOES HERE
        Color skyBlue = new Color(28, 198, 255);
        g.setColor(skyBlue);
        g.fillRect(0, 0, 800, 600);

        //hair
        Color teal = new Color(18, 111, 117);
        g.setColor(teal);
        g.fillOval(150, 150, 200, 200);
        g.fillOval(450, 150, 200, 200);
        g.fillOval(100, 150, 100, 100);
        g.fillOval(600, 150, 100, 100);


        //head
        g.setColor(Color.WHITE);
        g.fillOval(275, 35, 250, 250);
        g.fillRect(275, 150, 250, 250);
        Color stuble = new Color(245, 208, 171);
        g.setColor(stuble);
        g.fillOval(275, 260, 250, 250);

        //ears
        g.setColor(Color.WHITE);
        g.fillOval(235, 250, 60, 60);
        g.fillOval(505, 250, 60, 60);

        //nose
        g.setColor(Color.RED);
        g.fillOval(350, 250, 100, 75);

        //bangs
        g.setColor(teal);
        g.fillOval(350, 10, 100, 100);

        //eyes
        //outline
        g.setColor(Color.BLACK);
        g.fillOval(300, 155, 100, 100);
        g.fillOval(400, 155, 100, 100);

        //eyeballs
        g.setColor(Color.WHITE);
        g.fillOval(305, 157, 90, 95);
        g.fillOval(405, 157, 90, 95);

        //pupils
        g.setColor(Color.BLACK);
        g.fillOval(x1, 200, 20, 20);
        g.fillOval(x2, 200, 20, 20);

        //mouth
        g.drawArc(250, 400, 280, 100, 30, 100);




        // GAME DRAWING ENDS HERE
    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void run() {
        // Used to keep track of time used to draw and update the game
        // This is used to limit the framerate later on
        long startTime;
        long deltaTime;

        // the main game loop section
        // game will end if you set done = false;
        boolean done = false;
        while (!done) {
            // determines when we started so we can keep a framerate
            startTime = System.currentTimeMillis();

            // all your game rules and move is done in here
            // GAME LOGIC STARTS HERE 
            if (x1 < 370) {
                x1++;
                x2++;
                if (x1 == 370) {
                    while (x1 > 300) {
                        x1--;
                        x2--;
                    }
                }
            }



            // GAME LOGIC ENDS HERE 

            // update the drawing (calls paintComponent)
            repaint();



            // SLOWS DOWN THE GAME BASED ON THE FRAMERATE ABOVE
            // USING SOME SIMPLE MATH
            deltaTime = System.currentTimeMillis() - startTime;
            if (deltaTime > desiredTime) {
                //took too much time, don't wait
            } else {
                try {
                    Thread.sleep(desiredTime - deltaTime);
                } catch (Exception e) {
                };
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates a windows to show my game
        JFrame frame = new JFrame("My Game");

        // creates an instance of my game
        A8Q1 game = new A8Q1();
        // sets the size of my game
        game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // adds the game to the window
        frame.add(game);

        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);

        // starts my game loop
        game.run();
    }
}
