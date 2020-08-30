/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.pkg01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author leno
 */
public class Imagesss {
    
    BufferedImage [] AllImgs;

    public Imagesss() {
        AllImgs = new BufferedImage[7];
    }
    public void saveJumpimages()
    {
        try {
            for(int i=0;i<7;i++)
            {
                
              File f = new File("Pics\\Materials\\Knight1\\Jump\\"+Integer.toString(i)+".png");   
              if(f.exists())
              {
                  BufferedImage frame =ImageIO.read(f);
                  AllImgs[i]=frame;
              }
                  
              
              
            }
            
            
            
        } catch (Exception e) {
        }
    }
    public void saveWalkimages()
    {
        try {
            for(int i=0;i<7;i++)
            {
                
              File f = new File("Pics\\Materials\\Knight1\\Walk\\"+Integer.toString(i)+".png");   
              if(f.exists())
              {
                  BufferedImage frame =ImageIO.read(f);
                  AllImgs[i]=frame;
              }
                  
              
              
            }
            
            
            
        } catch (Exception e) {
        }
    }
     public void saveidleimages()
    {
        try {
            for(int i=0;i<7;i++)
            {
                
              File f = new File("Pics\\Materials\\Knight1\\idle\\"+Integer.toString(i)+".png");   
              if(f.exists())
              {
                  BufferedImage frame =ImageIO.read(f);
                  AllImgs[i]=frame;
              }
                  
              
              
            }
            
            
            
        } catch (Exception e) {
        }
    }
    
    public void loadimages(Graphics imagebrush){
        
        imagebrush.drawImage(AllImgs[GetFrameOrSprites.frameindex], 0, 0, null);
        
    }
        //
    }
    
    
    
    
    
    
    
    

