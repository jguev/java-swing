
// Author: Johanna Guevara
// Project Description:
// This project creates a rectangle placement display using JPanel
// and MouseMotion listeners.

import java.awt.*;
import java.util.ArrayList;
import java.awt.geom.Rectangle2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Mouse extends JPanel
        implements
        MouseListener,
        MouseMotionListener {

    private double x1, y1;              // holds the initial x and y coordinates of rect top corner
    private static final Color EVEN_COLOR = Color.PINK;
    private static final Color ODD_COLOR = Color.DARK_GRAY;
    private static final Color INITIAL_COLOR = Color.BLACK;
    private ArrayList<Rectangle2D> r;   // array of objects
    private Rectangle2D MagicRect;

    public Mouse() {
        setPreferredSize(new Dimension(800, 600));
        r = new ArrayList<Rectangle2D>();
        MagicRect = null;
        addMouseListener(this); // pressed
        addMouseMotionListener(this); // movement
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graph = (Graphics2D) g;
        int count = 0;

        for (Rectangle2D rect : r) {
            graph.setStroke(new BasicStroke(10));
            if(count%2 == 0) {
                graph.setColor(ODD_COLOR);
            }
            else{
                graph.setColor(EVEN_COLOR);
            }
            graph.draw(rect);
            count++;
        }

        if (MagicRect != null) {
            graph.setColor(INITIAL_COLOR);
            graph.draw(MagicRect);
        }
    }



    // ALL MOUSE EVENTS NEEDED TO REGISTER
    // mouseClicked - initiates the drawing process, marks top left x,y
    // mouseMoved - guides the rendering of a repainted rect in motion
    // mouseEntered - within the constraints
    // mouseExited - outside of constraints

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {

        if (MagicRect == null) {

            x1 = e.getX();
            y1 = e.getY();
            MagicRect = new Rectangle2D.Double(x1, y1, 0, 0);

            repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (MagicRect != null) {
            r.add(MagicRect);
            MagicRect = null;
            repaint();
        }
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        //
        // Find the new width and height positions marked by (*)
        // They will be denoted referencing the initial x,y
        //
        //      X,Y *************(*)
        //      *                 *
        //      *                 *
        //     (*)*****************
        //

        if (MagicRect != null) {

            double custom_width = e.getX() - x1;
            double custom_height = e.getY() - y1;

            double cx = 0, cy = 0;

            // Width: Negative lengths
            if (custom_width < 0) {
                cx = custom_width;
                custom_width = custom_width * -1;
            }
            // Height: Negative lengths
            if (custom_height < 0) {
                cy = custom_height;
                custom_height = custom_height * -1;
            }
            MagicRect = new Rectangle2D.Double(x1 + cx, y1 + cy, custom_width, custom_height);
            repaint();
        }
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("COMP 585: Project 2");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new Mouse());
        f.pack();
        f.setVisible(true);
    }
}
