/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.pkg01;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import static pkgfinal.pkg01.Weapons.FireBreathleft;

/**
 *
 * @author leno
 */
public class Dagger {
    String daggerdirec="left";
      static BufferedImage frameleft;
      static BufferedImage frameright;
     int daggerleftx=250;
     int daggerrightx=250-15+150+100+100;
     int k1y;
     boolean daggeron=false;
     boolean stabon=true;
     static int daggerxplace;
     static int daggeryplace;
   
     static boolean daggerpickedup=false;
     
    
    
    public static void saveDagger()
    {
        
        
        
        try {
           
            
                
                File f = new File("Pics\\Materials\\Dagger\\left.4.png");   
             
              if(f.exists())
              {
              frameleft =ImageIO.read(f);
                  
                 
              }
         File f2 = new File("Pics\\Materials\\Dagger\\right.4.png");   
            
              if(f2.exists())
              {
              frameright =ImageIO.read(f2);
                  
                 
              }
        
    
}
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void loadDagger(Graphics g)
    {
            if(daggerdirec.equalsIgnoreCase("left")&&daggerpickedup)
              {
                if(daggerleftx<70)
                {
                  daggeron=false;
                  daggerleftx=250;
                  stabon=true;
     
                }
                else
                {
//                  g.drawRect(daggerleftx+10, k1y+150, 135 , 58);
                g.drawImage(frameleft, daggerleftx, k1y+150 , null);   
             daggerleftx-=40;   
             
                }
              }
            else if(daggerpickedup)
            {   
               if(daggerrightx>710)
               {
                 daggeron=false;
                 daggerrightx=250-15+150+100+100;
                 stabon=true;
               }
               else
               {
//                   g.drawRect(daggerrightx, k1y+150, 135, 58);
                g.drawImage(frameright, daggerrightx, k1y+150 , null);   
                daggerrightx+=40;    
                
               }
              
//               firex=250+(fireFrameIndex*40);
         
             
         }

    }
        public boolean daggerpickup(Knight k)
                
        {
            if(((daggerxplace-k.knightrightleg)<0||(daggerxplace-k.knightleftleg)<60)&&((k.y+300)>daggeryplace)&&(k.knighttophead)<daggeryplace)//135 dagger length,60 knights width
            {
                  daggerpickedup=true;
                System.out.println("PickedUp");
             return true;   
            }
            else 
            {
             return  false;
            }
        }
   public boolean didDaggerStab(Monster M,Knight k)
    {
        
    int emshy3alaeldaggerkolo;
              if(daggerdirec.equalsIgnoreCase("left")&&daggerpickedup)
        {
         for(int i=0;i<daggerleftx+10+135;i++)
            {
                emshy3alaeldaggerkolo=daggerleftx+10+i;
                //+10 final adjustof rec of dagger
                
             //+30 for the final adjustments of the breath
            //65 is monster width
          if(((((-M.monsterreallegx2+emshy3alaeldaggerkolo)<0)&&(-M.monsterreallegx2+emshy3alaeldaggerkolo>-65))) &&(((k.y+150+45)>M.hieghtfromdrawy)&&((k.y+150+45)<(M.hieghtfromdrawy+M.redmonsterheight)))&&(((k.y+150+45+60)>M.hieghtfromdrawy)&&((k.y+150+45+60)<(M.hieghtfromdrawy+M.redmonsterheight))))//400 is rectangle's length(rectange is my 
              //  if((((-M.monsterlegx1+firebreathleftlimit+30)<400)||((-M.monsterlegx2+firebreathleftlimit)<400)) &&(((theknightsY+150+45)>M.hieghtfromdrawy)&&((theknightsY+150+45)<(M.hieghtfromdrawy+M.redmonsterheight)))&&(((theknightsY+150+45+60)>M.hieghtfromdrawy)&&((theknightsY+150+45+60)<(M.hieghtfromdrawy+M.redmonsterheight))))//400 is rectangle's length(rectange is my 
        {
//              System.out.println("Crisped");
           return true; 
          
        }      
        }
         return false;
        }
        if(daggerdirec.equalsIgnoreCase("right"))
        {
          for(int i =0;i<daggerrightx-135;i++)
           {
               //400 deh el hea 2a3la 7ta fel fire ymen
               //135 tol el dagger
               emshy3alaeldaggerkolo=daggerrightx-i+135;
           
             if(((((M.monsterreallegx1-emshy3alaeldaggerkolo)<0)&&(M.monsterreallegx1-emshy3alaeldaggerkolo>-65))) &&(((k.y+150+45)>M.hieghtfromdrawy)&&((k.y+150+45)<(M.hieghtfromdrawy+M.redmonsterheight)))&&(((k.y+150+45+60)>M.hieghtfromdrawy)&&((k.y+150+45+60)<(M.hieghtfromdrawy+M.redmonsterheight))))//400 is rectangle's length(rectange is my 
              //  if((((-M.monsterlegx1+firebreathleftlimit+30)<400)||((-M.monsterlegx2+firebreathleftlimit)<400)) &&(((theknightsY+150+45)>M.hieghtfromdrawy)&&((theknightsY+150+45)<(M.hieghtfromdrawy+M.redmonsterheight)))&&(((theknightsY+150+45+60)>M.hieghtfromdrawy)&&((theknightsY+150+45+60)<(M.hieghtfromdrawy+M.redmonsterheight))))//400 is rectangle's length(rectange is my 
        {
//              System.out.println("Crisped");
           return true; 
          
        } 
        }
//        System.out.println("HES ALIVE");
        return false;
       
    }
        return false;
    }
}

//   if((((M.monsterlegx1-daggerrightx)<400)||((M.monsterlegx2-daggerrightx)<400)) &&(((k1y+150+45)>M.hieghtfromdrawy)&&((k1y+150+45)<(M.hieghtfromdrawy+M.redmonsterheight)))&&(((k1y+150+45+60)>M.hieghtfromdrawy)&&((k1y+150+45+60)<(M.hieghtfromdrawy+M.redmonsterheight))))//400 is rectangle's length(rectange is my hitbox)&((theknightsY+150+45)>&)
                 //&&(((theknightsY+150+45)>M.hieghtfromdrawy)&&((theknightsY+150+45)<M.drawy))&&(((theknightsY+150+45+60)>M.hieghtfromdrawy)&&((theknightsY+150+45+60)<M.drawy))
                     //(firebreathlimit+400)>M.monsterlegx1&&(firebreathlimit+400)<M.monsterlegx2)
//        {
////              System.out.println("Stabbed");
//           return true; 
//          
//        }   

