package org.wintrisstech;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * This project is designed as a starting point for students learning about
 * arrays. <p> Images in this project are public domain from
 * http://openclipart.org
 *
 * @author aaron@wintrisstech.org (Aaron VonderHaar)
 * @author http://wintrisstech.org
 */
public class CardFlipping extends JComponent
{

    private int windowWidth = 800;
    private int windowHeight = 600;
    private Color tableColor = new Color(24, 117, 21);
    private Color edgingColor = new Color(237, 208, 76);
    private int edgingInset = 20;
    private int edgingWidth = 5;
    
    private int cardWidth = 100;
    private int cardHeight = 136;
    
    private Image redBack;
    private Image blueBack;
    private Image ace;
    private Image blank;

    public static void main(String[] args) throws IOException
    {
        JFrame window = new JFrame("Cards");
        CardFlipping game = new CardFlipping();
        window.add(game);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public CardFlipping() throws IOException
    {
        redBack = ImageIO.read(getClass().getResource("nicubunu_Card_backs_grid_red.png"));
        blueBack = ImageIO.read(getClass().getResource("nicubunu_Card_backs_grid_blue.png"));
        ace = ImageIO.read(getClass().getResource("nicubunu_Ornamental_deck_Ace_of_spades.png"));
        blank = ImageIO.read(getClass().getResource("card_blank.png"));
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(windowWidth, windowHeight);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        // Draw the table
        g.setColor(tableColor);
        g.fillRect(0, 0, windowWidth, windowHeight);
        g.setColor(edgingColor);
        for (int i = 0; i < edgingWidth; i++)
        {
            g.drawRect(edgingInset + i, edgingInset + i,
                    windowWidth - 2 * (edgingInset + i),
                    windowHeight - 2 * (edgingInset + i));
        }

        // Draw the cards
        g.drawImage(redBack, (windowWidth - cardWidth) / 2, 
                (windowHeight - cardHeight) / 2, cardWidth, cardHeight, null);

    }
}
