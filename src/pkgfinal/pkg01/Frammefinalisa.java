/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.pkg01;

/**
 *
 * @author leno
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


public class Frammefinalisa extends JFrame {
   panalfinalisa gamepnl;
   JPanel scorePanel;
   JLabel Scoreboard;
    
    
    public Frammefinalisa()
    {
        setTitle("Enemy Slayer");
        setResizable(false);
        setLayout(null);
       setBounds(0, 0, 1000, 810);
       setBackground(Color.yellow);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
     
             gamepnl=new panalfinalisa();
            
            
             
     
        add(gamepnl);
       
        
         gamepnl.startgame();
         
         
         
    }
    
}
