/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.pkg01;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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


/**
 *
 * @author leno
 */
public class Knight 

{
    int x=500-150;
    int y=600;//800-150-30-20
    int speed=10;
    int dmg=1;
    int jump=-150;
    int gravity=+30;
    boolean jumpstate=false;
    int KnightDo;
    int score;
    int lives=2;
    int knightleftleg=350+130+30;
    int knightrightleg=350+130+90;
    int knighttophead=y+120;
    BufferedImage [] jumprightimg;
    BufferedImage [] jumpleftimg;
    BufferedImage [] idlerightimg;
    BufferedImage [] idleleftimg;
    BufferedImage [] leftimg;
    BufferedImage [] rightimg;

    public Knight() {
        System.out.println("My Head was first at"+knighttophead);
        
    }
    
    
     
     
     
    public void move(String WASD)
    {
        if(WASD.equalsIgnoreCase("UP"))
        {
         if(jump<0)
         {
             
             jumpstate=true;
          y+=jump+gravity;
          
             
         jump+=gravity; 
         knighttophead=y+120;
        
             System.out.println("My Head at y ="+knighttophead);
         }
         else
         {
             resetjump();
             jumpstate=false;
//          gravity=+30;
//          y+=jump+gravity;
//          jump+=gravity;
//          if(y>=(650-40))
//          {
//           resetjump();
//           jumpstate =false;
//          }
         }
         
        }
//         if(WASD.equalsIgnoreCase("right"))
//        {
//         x=x+50;   
//        }
//          if(WASD.equalsIgnoreCase("UP"))
//        {
//         jump=jump+5;   
//        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
    public void resetjump()
    {
     gravity = 30;   
     jump=-150;
     jumpstate = true;
    }

    public void setJumpstate(boolean jumpstate) {
        this.jumpstate = jumpstate;
    }
    
    public boolean checkjumpstate()
    {
     return jumpstate;   
    }
         
    public void saveAllimages()
    {
        jumprightimg = new BufferedImage[8];
        jumpleftimg = new BufferedImage[8];
        leftimg = new BufferedImage[8];
        rightimg = new BufferedImage [8];
        idlerightimg = new BufferedImage[8];
        idleleftimg = new BufferedImage[8];
        
        
        try {
            for(int i=0;i<8;i++)
            {
                
              File f = new File("Pics\\Materials\\Knight1\\JumpLeft\\"+Integer.toString(i)+".png");   
             
              if(f.exists())
              {
                  BufferedImage frame =ImageIO.read(f);
                  jumpleftimg[i]=frame;
              }
            }
            for(int i=0;i<8;i++)
            {
                
              File f1 = new File("Pics\\Materials\\Knight1\\JumpRight\\"+Integer.toString(i)+".png");   
             
              if(f1.exists())
              {
                  BufferedImage frame =ImageIO.read(f1);
                  jumprightimg[i]=frame;
              }
            }

            for(int i=0;i<8;i++)
            {
              File f2 = new File("Pics\\Materials\\Knight1\\WalkLeft\\"+Integer.toString(i)+".png");   

              if(f2.exists())
              {
                  BufferedImage frame =ImageIO.read(f2);
                  leftimg[i]=frame;
              }
            }
             for(int i=0;i<8;i++)
            {
              File f3 = new File("Pics\\Materials\\Knight1\\idleleft\\"+Integer.toString(i)+".png");   

              if(f3.exists())
              {
                  BufferedImage frame =ImageIO.read(f3);
                  idleleftimg[i]=frame;
              }
            }
             for(int i=0;i<8;i++)
            {
              File f5 = new File("Pics\\Materials\\Knight1\\idleright\\"+Integer.toString(i)+".png");   

              if(f5.exists())
              {
                  BufferedImage frame =ImageIO.read(f5);
                  idlerightimg[i]=frame;
              }
            }
            for(int i=0;i<8;i++)
            {
              File f4 = new File("Pics\\Materials\\Knight1\\WalkRight\\"+Integer.toString(i)+".png");   

              if(f4.exists())
              {
                  BufferedImage frame =ImageIO.read(f4);
                  rightimg[i]=frame;
              }
            }
            
            }
            
        
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void getwhatknightdo(String WASDBARDO)
    {
        if(WASDBARDO.equalsIgnoreCase("JUMPRIGHT"))
        {
            KnightDo=1;
        }
        if(WASDBARDO.equalsIgnoreCase("JUMPLEFT"))
        {
            KnightDo=4;
        }
         if(WASDBARDO.equalsIgnoreCase("RIGHT"))
        {
            KnightDo=0;
        }
         if(WASDBARDO.equals("IDLERIGHT"))
        {
            KnightDo=2;
        }
          if(WASDBARDO.equals("IDLELEFT"))
        {
            KnightDo=5;
        }
         if(WASDBARDO.equalsIgnoreCase("LEFT"))
         {
          KnightDo=3;   
         }
    }
   
  
    
    public void loadimages(Graphics imagebrush){
        
       switch (KnightDo)
       {
               case 0 :
                    imagebrush.drawImage(rightimg[GetFrameOrSprites.frameindex], x, y, null);
                    break;
               case 1:
                    imagebrush.drawImage(jumprightimg[GetFrameOrSprites.frameindex], x, y, null);
                    break;
               case 2 :
                    imagebrush.drawImage(idlerightimg[GetFrameOrSprites.frameindex], x, y, null);
                    break;
                case 3 :
                    imagebrush.drawImage(leftimg[GetFrameOrSprites.frameindex], x, y, null);
        
                    break;
                case 4 :
                    imagebrush.drawImage(jumpleftimg[GetFrameOrSprites.frameindex], x, y, null);
        
                    break;   
                case 5 :
                    imagebrush.drawImage(idleleftimg[GetFrameOrSprites.frameindex], x, y, null);
        
                    break;   
               
       }
//       imagebrush.drawRect(knightleftleg, y, 10, 300);
//       imagebrush.drawRect(knightrightleg, y, 10, 300);
//       imagebrush.fillRect(350+130,knighttophead , 50, 10);
       //y+120
       imagebrush.setColor(Color.green);
       imagebrush.drawString(" "+lives, 350+130, knighttophead);
                   
    }
        //
 }
    

