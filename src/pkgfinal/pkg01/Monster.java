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
public class Monster


{
//    int Mx=1000;
//    int My=690;
    int drawx;
    int drawy;
    int xDie;
    int Ydie;
    int monsterlegx1;
    int monsterlegx2;
    int monsterlegy;
    int explosiontatmomvementindex;
    boolean alive=true;
    int monsterlegaddy=370;
    int monsterlegaddx1=165;
    int monsterreallegx1;
    int monsterreallegx2;
    int monsterlegaddx2=230;
    int legsonfloorInc=342;
    int hieghtfromdrawy=drawy+100;
    int redmonsterheight=250;
    int explosionindex=0;
    int whereidrawlegx;
    int lives;
  static BufferedImage [] leftimg;
  static BufferedImage [] rightimg;  
  static BufferedImage [] expimg;
    int movmentIndex=0;
    boolean amimovinright=true;
    boolean flippinggate=true;
    boolean prevchangedirec=false;
    boolean explosionfinish=false;
    boolean setconstindex=true;
    int constindex;
    String Monsterdirec="left";

    public Monster() {
        monsterlegx1=drawx+monsterlegaddx1;
        monsterlegx2=drawx+monsterlegaddx2;
        monsterlegy=drawy+monsterlegaddy;
       
    }
    
    
    public static void SaveAllImages()
            
            
    {
       rightimg = new BufferedImage[6];
       leftimg = new BufferedImage[6];
       expimg = new BufferedImage[5];
        try {
            for(int i=0;i<=4;i++)
            {
                
              File f9 = new File("Pics\\Materials\\Explosion\\"+Integer.toString(i)+".png");   
             
              if(f9.exists())
              {
                  BufferedImage frame =ImageIO.read(f9);
                 
                  expimg[i]=frame;
              }
            }
            for(int i=0;i<6;i++)
            {
                
              File f = new File("Pics\\Materials\\Knight3\\run.left\\"+Integer.toString(i)+".png");   
             
              if(f.exists())
              {
                  BufferedImage frame =ImageIO.read(f);
                 
                  leftimg[i]=frame;
              }
            }
            for(int i=0;i<6;i++)
            {
                
              File f1 = new File("Pics\\Materials\\Knight3\\run.right\\"+Integer.toString(i)+".png");   
             
              if(f1.exists())
              {
                  BufferedImage frame =ImageIO.read(f1);
                  rightimg[i]=frame;
              }
            }
        }
        catch(IOException e)
        {
            
        }
    }

    public void setxDie(int xDie) {
        this.xDie = xDie;
        if(setconstindex)
        {
         constindex=movmentIndex;   
         setconstindex=false;
        }
         whereidrawlegx=drawx+monsterlegaddx1+constindex;
    }

    public void setYdie(int Ydie) {
        this.Ydie = Ydie;
    }
    
//    public void loadexplosion(Graphics imagebrush)
//    {
//        if(explosionindex==4)
//        {
//          explosionindex=0;
//          explosionfinish=true;
//        }
//        else if (explosionindex!=4&&explosionfinish==false)
//        {
//            try {
//                 imagebrush.drawImage(expimg[explosionindex],xDie ,Ydie+150, null);
//                 
////                 imagebrush.fillRect(drawx+monsterlegaddx1+movmentIndex,drawy , 10, drawy);
////                 imagebrush.fillRect(xDie, Ydie, 100, 100);
//        explosionindex++;   
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        }
//    }

    public void setDrawx(int drawx) {
        this.drawx = drawx;
        monsterlegx1=drawx+monsterlegaddx1;
        monsterlegx2=drawx+monsterlegaddx2;
        monsterreallegx1=drawx+monsterlegaddx1+movmentIndex;
        monsterreallegx2=drawx+monsterlegaddx2+movmentIndex;
       
    }

    public void setDrawy(int drawy) {
        this.drawy = drawy;
        hieghtfromdrawy=drawy+100;
      
    }
    

    public void movementindexManger()
    {
        if(flippinggate)
            
        {
         amimovinright=true;
         movmentIndex+=20;
//            System.out.println("Right");
            Monsterdirec="right";
        }
        else
        {
         amimovinright=false;
         movmentIndex-=20;
          Monsterdirec="left";
        }
//        if(amimovinright)
//        {
//            if(changedirction==true)
//            {
//                amimovinright=false;    
//                
//                
//            }
//     if(amimovinright)
//     {
//             movmentIndex+=20;   
//     }
//         
////         prevchangedirec=changedirction;
//        }
//        else{
//            if(amimovinright==false)
//            {
//                 movmentIndex-=20;
//            }
//            
//            
//            else if(changedirction==true)
//            {
//             amimovinright=true;   
//             
//            }
           
//            prevchangedirec=changedirction;
        }
        
       
    
    
    
    
   public void loadimages(Graphics imagebrush){
        try {
//            imagebrush.setColor(Color.gray);
//            imagebrush.fillRect(350, 690, 300, 300);
           if(flippinggate)
           {
             imagebrush.drawImage(rightimg[GetFrameOrSprites.monsterframeindex], drawx+movmentIndex,drawy, null);
//            imagebrush.fillRect(drawx+monsterlegaddx1+movmentIndex,drawy , 10, drawy);
//            imagebrush.fillRect(drawx+monsterlegaddx2+movmentIndex,drawy , 10, drawy);
//            imagebrush.fillRect(drawx+monsterlegaddx2+movmentIndex, hieghtfromdrawy, 80, 20);
            Font trb = new Font("TimesRoman", Font.BOLD, 36);
               imagebrush.setColor(Color.red );
               imagebrush.setFont(trb);
            imagebrush.drawString(" "+lives,drawx+monsterlegaddx1+movmentIndex , hieghtfromdrawy);
//            movementindexManger();
               
           }
           else
           {
             imagebrush.drawImage(leftimg[GetFrameOrSprites.monsterframeindex], drawx+movmentIndex,drawy, null);
//            imagebrush.fillRect(drawx+monsterlegaddx1+movmentIndex,drawy , 10, drawy);
//            imagebrush.fillRect(drawx+monsterlegaddx2+movmentIndex,drawy , 10, drawy);
//            movementindexManger();
//               imagebrush.fillRect(drawx+monsterlegaddx2+movmentIndex, hieghtfromdrawy, 80, 20);
              Font trb = new Font("TimesRoman", Font.BOLD, 36);
               imagebrush.setColor(Color.red );
               imagebrush.setFont(trb);
                  imagebrush.drawString(" "+lives,drawx+monsterlegaddx2+movmentIndex , hieghtfromdrawy);
               
           }
           
            // int x=500-150;
  
       } catch (Exception e) {
            System.out.println(e.getMessage());
       }
   }
   public int monsterlives()
   {
       
   if(lives!=0)
   {
    lives=lives-1;   
    return lives;
   }
   return lives;
   }
   
   public boolean monsterkilledPlayer(Knight k)
   {
       
       
      //((((monsterlegx1-k.knightleftleg)<90)&&(monsterlegx1-k.knightleftleg)>0)||((monsterlegx1-k.knightrightleg)<90&&(monsterlegx1-k.knightrightleg)>0))
       if(alive)
       {
        if(Monsterdirec=="left")
       {
          if( (  ( ((monsterreallegx1-k.knightleftleg)<90)&&((monsterreallegx1-k.knightleftleg)>0))||(((monsterreallegx1-k.knightrightleg)<90 )&&((monsterreallegx1-k.knightrightleg)>0)) )&&(((k.y+300)>hieghtfromdrawy)&&((k.y+300-10)<=(hieghtfromdrawy+redmonsterheight)))&&(((k.knighttophead)<hieghtfromdrawy+redmonsterheight)&&((k.knighttophead)>(hieghtfromdrawy))))//400 is rectangle's length(rectange is my 
        {
//              System.out.println("Crisped");
            
           return true; 
          
        }   
       }
        
        if (Monsterdirec=="right")
        {
             if((((-monsterreallegx1+k.knightleftleg)<65&&(-monsterreallegx1+k.knightleftleg)>0)||((-monsterreallegx1+k.knightrightleg)<65)&&(-monsterreallegx1+k.knightrightleg)>0) &&(((k.y+300)>hieghtfromdrawy)&&((k.y+300-10)<=(hieghtfromdrawy+redmonsterheight)))&&(((k.knighttophead)<hieghtfromdrawy+redmonsterheight)&&((k.knighttophead)>(hieghtfromdrawy))))//400 is rectangle's length(rectange is my hitbox)&((theknightsY+150+45)>&)
                 //&&(((theknightsY+150+45)>M.hieghtfromdrawy)&&((theknightsY+150+45)<M.drawy))&&(((theknightsY+150+45+60)>M.hieghtfromdrawy)&&((theknightsY+150+45+60)<M.drawy))
                     //(firebreathlimit+400)>M.monsterlegx1&&(firebreathlimit+400)<M.monsterlegx2)
        {
//              System.out.println("Crisped");
           return true; 
          
        }   
        }
        
//        System.out.println("HES ALIVE");
        return false;
          
       }
       else
       {
        return  false;
       }
    }
   }
    
    
    

