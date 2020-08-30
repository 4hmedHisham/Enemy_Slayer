/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.pkg01;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author leno
 */
public class Weapons extends Knight {
    static BufferedImage FireBreathleft[];
     static BufferedImage FireBreathright[];
    
    BufferedImage frame;
    int fireFrameIndex=0;
    int theknightsY;
    int firey;
    int firex;
    boolean caniflame=true;
    boolean firebreathon=false;
    static int frameplacex;
    static int frameplacey;
    int firebreathlimit=250+(fireFrameIndex*40)-80;
    int firebreathleftlimit=250-15+150-(fireFrameIndex*40)+80;
    int maxoindexleft=25;
    static boolean firebreathpickedup=false;
    
    int maxindexGo=610;
    String firedirec="left";

    public Weapons() {
        FireBreathleft = new BufferedImage[50];
        FireBreathright = new BufferedImage[50];
        
        
       
            }
    
     public static void saveFireBreath()
    {
        
        
        
        try {
            for(int i=0;i<=49;i++)
            {
                
              File f = new File("Pics\\Materials\\FIRE.left\\"+Integer.toString(i)+".png");   
             
              if(f.exists())
              {
                  BufferedImage frame =ImageIO.read(f);
                  
                  FireBreathleft[i]=frame;
              }
        
        
    }
                for(int i=0;i<=49;i++)
            {
                
              File f = new File("Pics\\Materials\\FIRE.right\\"+Integer.toString(i)+".png");   
            
              if(f.exists())
              {
                  BufferedImage frame =ImageIO.read(f);
                  
                  FireBreathright[i]=frame;
              }
        
        
    }
}
        catch(IOException e)
                {
                    
                }

    
    
}
     public boolean flamepickup(Knight k)
                
        {
            if(((frameplacex-k.knightrightleg)<0||(frameplacex-k.knightleftleg)<60)&&((k.y+300)>frameplacey)&&(k.knighttophead)<frameplacey)//135 dagger length,60 knights width
            {
                  firebreathpickedup=true;
                System.out.println("PickedUp");
             return true;   
            }
            else 
            {
             return  false;
            }
        }
     public void loadFireBreath(Graphics g)
     {
         if(fireFrameIndex==49)
         {
          firebreathlimit=250+(fireFrameIndex*40)-80;
          firebreathleftlimit=250-15+150-(fireFrameIndex*400)+80;
          fireFrameIndex=0; 
          firebreathon=false;
          caniflame=true;
         }
         else if(fireFrameIndex==0)
         {
              
          firebreathon=true;
              if(firedirec.equalsIgnoreCase("left"))
              {
                g.drawImage(FireBreathleft[fireFrameIndex], firebreathleftlimit, theknightsY+150 , null);   
                 fireFrameIndex++;   
             firey=theknightsY;
              }
              else{ g.drawImage(FireBreathright[fireFrameIndex], firebreathlimit-15, theknightsY+150 , null);}
              
//               firex=250+(fireFrameIndex*40);
         fireFrameIndex++;   
             firey=theknightsY;
             
         }
         else {
             try {
               
//                   g.fillRect(500, 500, 1500, 1500);
                    if(firedirec.equalsIgnoreCase("left"))
           { 
                g.drawImage(FireBreathleft[fireFrameIndex], firebreathleftlimit, theknightsY+150 , null);   
//                g.drawRect(firebreathleftlimit+30, theknightsY+150+45, 400, 60);
//                g.setColor(Color.red);
//                g.fillRect(firebreathleftlimit+30, theknightsY+150+45, 10, 10);
                if(firebreathleftlimit==maxoindexleft+80)
              {
               firebreathleftlimit=maxoindexleft+80;   
               firebreathlimit=maxindexGo-80;
               
               
              }
                else
                {
                     firebreathleftlimit=250-15+150-(fireFrameIndex*40)+80;
                }
                fireFrameIndex++;  
          }
              else{ 
                        g.drawImage(FireBreathright[fireFrameIndex], firebreathlimit, theknightsY+150 , null);
//                        g.drawRect(firebreathlimit, theknightsY+150+45, 400, 60);
//                        g.fillRect(firebreathlimit+400, theknightsY+150+45, 20, 20);
                   if(firebreathlimit==maxindexGo-80)
              {
               firebreathlimit=maxindexGo-80;   
                firebreathleftlimit=maxoindexleft+80; 
              }
                   else{firebreathlimit=250+(fireFrameIndex*40)-80;}
                   fireFrameIndex++;  
                    }
//                   firex=250+(fireFrameIndex*30);
//         fireFrameIndex++;   
             } catch (Exception e) {
                 System.out.println(e.getMessage());
             }
         }
     }
      public boolean haveCripsed(Monster M,Knight k)
    {
        int emshy3alaelfirekolo;
        
        if(firedirec.equalsIgnoreCase("left"))
        {
            for(int i=0;i<k.knightleftleg;i++)
            {
                emshy3alaelfirekolo=firebreathleftlimit+30+i;
                
             //+30 for the final adjustments of the breath
            //65 is monster width
          if(((((-M.monsterreallegx2+emshy3alaelfirekolo)<0)&&(-M.monsterreallegx2+emshy3alaelfirekolo>-65))) &&(((theknightsY+150+45)>M.hieghtfromdrawy)&&((theknightsY+150+45)<(M.hieghtfromdrawy+M.redmonsterheight)))&&(((theknightsY+150+45+60)>M.hieghtfromdrawy)&&((theknightsY+150+45+60)<(M.hieghtfromdrawy+M.redmonsterheight))))//400 is rectangle's length(rectange is my 
              //  if((((-M.monsterlegx1+firebreathleftlimit+30)<400)||((-M.monsterlegx2+firebreathleftlimit)<400)) &&(((theknightsY+150+45)>M.hieghtfromdrawy)&&((theknightsY+150+45)<(M.hieghtfromdrawy+M.redmonsterheight)))&&(((theknightsY+150+45+60)>M.hieghtfromdrawy)&&((theknightsY+150+45+60)<(M.hieghtfromdrawy+M.redmonsterheight))))//400 is rectangle's length(rectange is my 
        {
//              System.out.println("Crisped");
           return true; 
          
        }      
            }
            return false;
        }
        if(firedirec.equalsIgnoreCase("right"))
        {
           for(int i =0;i<k.knightrightleg;i++)
           {
               //400 deh el hea 2a3la 7ta fel fire ymen
               emshy3alaelfirekolo=firebreathlimit-i+400;
           
             if(((((M.monsterreallegx1-emshy3alaelfirekolo)<0)&&(M.monsterreallegx1-emshy3alaelfirekolo>-65))) &&(((theknightsY+150+45)>M.hieghtfromdrawy)&&((theknightsY+150+45)<(M.hieghtfromdrawy+M.redmonsterheight)))&&(((theknightsY+150+45+60)>M.hieghtfromdrawy)&&((theknightsY+150+45+60)<(M.hieghtfromdrawy+M.redmonsterheight))))//400 is rectangle's length(rectange is my 
              //  if((((-M.monsterlegx1+firebreathleftlimit+30)<400)||((-M.monsterlegx2+firebreathleftlimit)<400)) &&(((theknightsY+150+45)>M.hieghtfromdrawy)&&((theknightsY+150+45)<(M.hieghtfromdrawy+M.redmonsterheight)))&&(((theknightsY+150+45+60)>M.hieghtfromdrawy)&&((theknightsY+150+45+60)<(M.hieghtfromdrawy+M.redmonsterheight))))//400 is rectangle's length(rectange is my 
        {
//              System.out.println("Crisped");
           return true; 
          
        } 
           }
           return false;
           }
       
        
   return false; 
}
}