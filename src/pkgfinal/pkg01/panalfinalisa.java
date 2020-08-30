/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.pkg01;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import sun.audio.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
/**
 *
 * @author leno
 */
public class panalfinalisa extends JPanel
{
    Timer tick;
    boolean backgroundsong=false;
    boolean onetimegate=true;
    boolean onetimegate3=true;
    boolean onetimegate4=true;
    boolean onetimegate5=true;
    boolean onleoncegate=true;
    boolean onlythistime=true;
    boolean onetimegate9=true;
    boolean knockback=false;
    int     knockbackindex=0;
    int     knocking=0; // from 1 to 5 accoring to monsters
    int countaaa;
       String playerName;
    
    int  jumptimer=700;
    int  tickcounter;
    boolean firstjumpframe=true;
    boolean animationtest=false;
    boolean Spressed;
    boolean iamLoading;
    JLabel Scoreboard;
//    OptionWindow o;
    
    char c;
    String s;
    
    
//    int frameindexx;
    
    
//    Graphics brushhhh;
     Knight k1;
     Weapons FIREbreath;
     
//     ArrayList<Weapons> firebreathes;
//     Weapons badfire;
     Dagger d;
//    Imagesss idle;
//    Imagesss walk;
//    Imagesss jump;
     CommandMove cm;
     boolean controlState=true;
     
     int nowstate=1;// these 2 will determine each tick if i need to reset the frame or not
     //1 idleleft 2 idleright 3walkleft 4 walkright 5 jump left 6 jumpright
     int previousstate=1;
     
     int jumpcount=0;//0 for no jump 1 for 1 jump 2 for double jump
     
     boolean isjumpon = false;
     
     
     boolean soundon=true;
     
     boolean firstgate=false;
     
     boolean secondgate=false;
     
//     boolean ucanpressup=false;
//     
//     boolean jumpreleased=false;
     
     boolean istile=true;
     boolean onetimegate2=true;
     boolean timerbegin=false;
     
     boolean leftkeypressed= false;
     
     boolean rightkeypressed= false;
     
     boolean firstidle=true;
     
     boolean jumpkeystate=true;
     
//    
     
     
     
     
     String Jumplr="JUMPLEFT";
    
     String idlelr="IDLELEFT";
     String previousstring="IDLELEFT";
     
     
     int mousex;
     int mousey;
     JLabel xy;
     
     JMenuBar thebar;
     JMenu menu;
     JMenuItem save;
     
     
     Tiles t;
     Sounds sss;
    
     public void lab()
    {
        JOptionPane.showMessageDialog(this, "please load the hall of fame file");
    }
     // here is the update
    public void massege(int i)
    {
        if(i == 1)
        {
            JOptionPane.showMessageDialog(this, "Welcome back ");
        }
        else 
        {
            JOptionPane.showMessageDialog(this, "Welcome");          
        }
    }

    public void startgame()
    {
        setDoubleBuffered(true);
        //--------------------------
//        thebar = new JMenuBar();
//        this.add(thebar , BorderLayout.NORTH);
//        
//        //Create JMenu and add it to the MenuBar
//        menu = new JMenu("Files");
//        thebar.add(menu);
//        
//        //Create Save MenuItem and Add it to the Files Menu
//        save = new JMenuItem("save");
//        menu.add(save);
//        
//        save.addActionListener(
//                new ActionListener() {
//           @Override
//           public void actionPerformed(ActionEvent ae) {
//              OptionWindow o = new OptionWindow();
//               System.out.println(k1.y + "    " + t.mapmovex);
//              o.Saving(k1.y , t.mapmovex);
//               
//               
//           }
//       }
//        );
//        
//        o=new OptionWindow();
        
        //------------------------------------------
        setLayout(null);
       
        Scoreboard= new  JLabel();
        setBackground(Color.red);
        Scoreboard.setBounds(1330, 150, 100,100);
        
        
       
       
        sss= new Sounds();
//        sss.PlayBackgoundSound();
         k1 = new Knight();
         
          Scoreboard.setText("Score :  "+k1.score);
          add(Scoreboard);
         k1.saveAllimages();
//         FIREbreath= new Weapons();
//                  badfire=new Weapons();
////        Weapons.saveFireBreath();
//         firebreathes = new ArrayList<Weapons>();
         FIREbreath= new Weapons();
                Weapons.saveFireBreath();
                
                d=new Dagger();
                Dagger.saveDagger();
                
         
         s=new String();
         
         
         cm =new CommandMove();
         
         
         xy = new JLabel();
         xy.setBackground(Color.red);
         xy.setBounds(500, 30, 150, 150);
         this.add(xy);
         
         
         t= new Tiles();
         t.savetiles();
        t.M1.lives=1;
        t.M2.lives=20;
        t.M3.lives=3;
        t.M4.lives=3;
        t.M5.lives=100;
        
        
         
//         t.tilesPosition();
         
       
         
        
//         jump = new Imagesss();
//         walk = new Imagesss();
//         idle = new Imagesss();
//         
//         idle.saveidleimages();
//         jump.saveJumpimages(); 
//         walk.saveWalkimages();
        this.addMouseListener(
        
        new MouseAdapter() {
             @Override
             public void mouseClicked(MouseEvent e) {
                  xy.setText("X:--"+e.getX()+"Y:--"+e.getY());
                  

             }
             
             
            
}
        );
        
        
        this.addKeyListener(
        new KeyAdapter() {
            
   
            
            @Override
            public void keyPressed(KeyEvent e) {
                
//                s=KeyEvent.getKeyText(e.getKeyCode());
//               if(s.equalsIgnoreCase("S"))
//               {
//                 Spressed=true;   
//               }
//                
               cm.SetKeyState(e.getKeyCode(), true);
               //<editor-fold defaultstate="collapsed" desc="comment">
               
               if(cm.GetKeyState(KeyEvent.VK_UP))
               {
                   firstgate=true;
               }
//</editor-fold>
//              if(cm.GetKeyState(KeyEvent.VK_LEFT))
//                      {
//                       leftkeypressed=true;   
//                      }
//              if(cm.GetKeyState(KeyEvent.VK_RIGHT))
//              {
//               rightkeypressed=true;   
//              }
            }

            @Override
            public void keyReleased(KeyEvent e) {
              cm.SetKeyState(e.getKeyCode(),false);
               
              
              
              
//              if(cm.GetKeyState(KeyEvent.VK_UP))
//              {
//               jumpkeystate=false;   
//              }
               if(cm.GetKeyState(KeyEvent.VK_UP))
               {
                   secondgate=true;
               }
              
             
            }
        }
        );
        
        
         
        setBounds(0, -140, 1000, 1000);
        
        setBackground(Color.red);
        setFocusable(true);
        
        
        tick = new Timer(55, null);
        tick.addActionListener(
        new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                     if(iamLoading == true)
                {
                update();
                tick.stop();
              
//                 if(backgroundsong==true&&onetimegate)
//                 {
//                   sss.PlayBackgoundSound();  
//                   onetimegate=false;
//                 }
                }
                else
                {
                    update();
               
                backgroundsong=true;
                 if(backgroundsong==true&&onetimegate)
                 {
                   sss.PlayBackgoundSound();  
                   onetimegate=false;
                 }
                }
                
            }
        }
        );
//         tick.start();
        
    
        
                }
    public void update()
            
    {
        
//        Scanner s = new Scanner(System.in);
//        String i = s.next();
        FIREbreath.theknightsY=k1.y;
        
//        if(Spressed)
//        {
//            
//        }
//        System.out.println(s);
//        tickcounter+=1;
                        if(t.istheretile(k1))
       {
           istile=true;
//           jumpcount=0;
//           System.out.println("JumpReset");
       }
       else{
          
           istile=false;
                }
      repaint();
        motion();
       
    }
     public void arrange1()
    {
        boolean[] x = new boolean[64];
        x[0]= backgroundsong;
        x[1]= onetimegate;
        x[2]= onetimegate3;
        x[3]= onetimegate4;
        x[4]= onetimegate5;
        x[5]= onleoncegate;
        x[6]= onlythistime;
        x[7]= onetimegate9;
        
        x[8]=firstjumpframe;
        //*********************
        x[9]=isjumpon;
        x[10]= soundon;
        x[11]= firstgate;
        x[12]=secondgate;
        x[13]=istile;
        x[14]=onetimegate2;
        x[15]=timerbegin;
        x[16]=leftkeypressed;
        x[17]=rightkeypressed;
        x[18]=firstidle;
        x[19]=jumpkeystate;
        
        //tiles****************
        
        x[20]= t.enteronetime;
        x[21]= t.enteronetime2;
        x[22]= t.enteronetime3;
        x[23]= t.enteronetime4;
        x[24]=t.enteronetime5;
        x[25]=t.enteronetime6;
        x[26]= t.shownextone;
        x[27]= t.easteregg;
        x[28]= t.onetimeoff;
        
        //monster**************
        
        //M1
        x[29]= t.M1.alive;
        x[30]= t.M1.amimovinright;
        x[31]= t.M1.flippinggate;
        x[32]= t.M1.prevchangedirec;
        x[33]= t.M1.explosionfinish;
        x[34]= t.M1.setconstindex;
        //M2
        x[35]= t.M2.alive;
        x[36]= t.M2.amimovinright;
        x[37]= t.M2.flippinggate;
        x[38]= t.M2.prevchangedirec;
        x[39]= t.M2.explosionfinish;
        x[40]= t.M2.setconstindex;
        //M3
        x[41]= t.M3.alive;
        x[42]= t.M3.amimovinright;
        x[43]= t.M3.flippinggate;
        x[44]= t.M3.prevchangedirec;
        x[45]= t.M3.explosionfinish;
        x[46]= t.M3.setconstindex;
        //M4
        x[47]= t.M4.alive;
        x[48]= t.M4.amimovinright;
        x[49]= t.M4.flippinggate;
        x[50]= t.M4.prevchangedirec;
        x[51]= t.M4.explosionfinish;
        x[52]= t.M4.setconstindex;
        //M5
        x[53]= t.M5.alive;
        x[54]= t.M5.amimovinright;
        x[55]= t.M5.flippinggate;
        x[56]= t.M5.prevchangedirec;
        x[57]= t.M5.explosionfinish;
        x[58]= t.M5.setconstindex;
        
        //Weapons********************
        
        x[59]=FIREbreath.caniflame;
        x[60]=FIREbreath.firebreathon;
        x[61]=Weapons.firebreathpickedup;
        
        //Knight no booleans*********
        
        //Dagger*********************
        
        x[62]= d.daggeron;
        x[63]= d.stabon;
        
        //Tilexy no booleans and GetFrameOrSprites*********
        
        int[] y = new int[107];
        
        //Panalfinalisa****************
        
        y[0]= countaaa;
        y[1]= jumptimer;
        y[2]= tickcounter;
        y[3]= jumpcount;
        
        //Tiles***********************
        
        y[4]= t.level;
        y[5]= t.theY;
        y[6]= t.mapmovey;
        y[7]= t.mapmovex;
        y[8]= t.textnumbershow;
        y[9]= t.lastXB4Death;
        y[10]= t.Yinc;
        y[12]= t.lastYB4Death;
        
        //Monster*********************
        //M1
        
        y[13]= t.M1.drawx;
        y[14]= t.M1.drawy;
        y[15]= t.M1.monsterlegx1;
        y[16]= t.M1.monsterlegx2;
        y[17]= t.M1.monsterlegy;
        y[18]= t.M1.monsterreallegx1;
        y[19]= t.M1.monsterreallegx2;
        y[20]= t.M1.monsterlegaddx2;
        y[21]= t.M1.hieghtfromdrawy;
        y[22]= t.M1.explosionindex;
        y[23]= t.M1.whereidrawlegx;
        y[24]= t.M1.lives;
        y[25]= t.M1.movmentIndex;
        y[26]= t.M1.constindex;
        //M2
        y[27]= t.M2.drawx;
        y[28]= t.M2.drawy;
        y[29]= t.M2.monsterlegx1;
        y[30]= t.M2.monsterlegx2;
        y[31]= t.M2.monsterlegy;
        y[32]= t.M2.monsterreallegx1;
        y[33]= t.M2.monsterreallegx2;
        y[34]= t.M2.monsterlegaddx2;
        y[35]= t.M2.hieghtfromdrawy;
        y[36]= t.M2.explosionindex;
        y[37]= t.M2.whereidrawlegx;
        y[38]= t.M2.lives;
        y[39]= t.M2.movmentIndex;
        y[40]= t.M2.constindex;
        //M3
        y[41]= t.M3.drawx;
        y[42]= t.M3.drawy;
        y[43]= t.M3.monsterlegx1;
        y[44]= t.M3.monsterlegx2;
        y[45]= t.M3.monsterlegy;
        y[46]= t.M3.monsterreallegx1;
        y[47]= t.M3.monsterreallegx2;
        y[48]= t.M3.monsterlegaddx2;
        y[49]= t.M3.hieghtfromdrawy;
        y[50]= t.M3.explosionindex;
        y[51]= t.M3.whereidrawlegx;
        y[52]= t.M3.lives;
        y[53]= t.M3.movmentIndex;
        y[54]= t.M3.constindex;
        //M4
        y[55]= t.M4.drawx;
        y[56]= t.M4.drawy;
        y[57]= t.M4.monsterlegx1;
        y[58]= t.M4.monsterlegx2;
        y[59]= t.M4.monsterlegy;
        y[60]= t.M4.monsterreallegx1;
        y[61]= t.M4.monsterreallegx2;
        y[62]= t.M4.monsterlegaddx2;
        y[63]= t.M4.hieghtfromdrawy;
        y[64]= t.M4.explosionindex;
        y[65]= t.M4.whereidrawlegx;
        y[66]= t.M4.lives;
        y[67]= t.M4.movmentIndex;
        y[68]= t.M4.constindex;
        //M5
        y[69]= t.M5.drawx;
        y[70]= t.M5.drawy;
        y[71]= t.M5.monsterlegx1;
        y[72]= t.M5.monsterlegx2;
        y[73]= t.M5.monsterlegy;
        y[74]= t.M5.monsterreallegx1;
        y[75]= t.M5.monsterreallegx2;
        y[76]= t.M5.monsterlegaddx2;
        y[77]= t.M5.hieghtfromdrawy;
        y[78]= t.M5.explosionindex;
        y[79]= t.M5.whereidrawlegx;
        y[80]= t.M5.lives;
        y[81]= t.M5.movmentIndex;
        y[82]= t.M5.constindex;
        
        //Weapons***********************
        
        y[83]= FIREbreath.fireFrameIndex;
        y[84]= FIREbreath.theknightsY;
        y[85]= FIREbreath.firey;
        y[86]= FIREbreath.firex;
        y[87]= Weapons.frameplacex;
        y[88]= Weapons.frameplacey;
        y[89]= FIREbreath.firebreathlimit;
        y[90]= FIREbreath.firebreathleftlimit;
        
        //weapons***********************
        
        y[91]= k1.y;
        y[92]= k1.speed;
        y[93]= k1.jump;
        y[94]= k1.gravity;
        y[95]= k1.KnightDo;
        y[96]=k1.score;
        y[97]= k1.knightleftleg;
        y[98]=k1.knightrightleg;
        y[99]= k1.knighttophead;
        
        //Dagger*************************
        
        y[100]= d.daggerleftx;
        y[101]= d.daggerrightx;
        y[102]= d.k1y;
        y[103]= Dagger.daggerxplace;
        y[104]= Dagger.daggeryplace;
        
        //GetFrameOrSprites
        
        y[105]= GetFrameOrSprites.frameindex;
        y[106]= GetFrameOrSprites.monsterframeindex;
        
        
         
        
        
        String[] b = new String[12];
        
        //Panelfinalisa
        
        b[0]= playerName;
        b[1]= s;
        b[2]= Jumplr;
        b[3]= idlelr;
        b[4]= previousstring;
        b[5]= t.M1.Monsterdirec;
        b[6]= t.M2.Monsterdirec;
        b[7]= t.M3.Monsterdirec;
        b[8]= t.M4.Monsterdirec;
        b[9]= t.M5.Monsterdirec;
        b[10]= FIREbreath.firedirec;
        b[11]= d.daggerdirec;
        //b[12]= (String)c;
               
        OptionWindow s = new OptionWindow();
        s.Saving(x,y,c,b );
        
        
        
        
        
                
        
    }
    
    public void motion()
    {  
          if(cm.GetKeyState((KeyEvent.VK_C)))
       {
           System.out.println("hi "+t.mapmovex);
           tick.stop();
           arrange1();
           
           cm.SetKeyState(KeyEvent.VK_C, false);
           System.exit(0);
           
       }
         if(t.isLevelCleared(k1)&&t.level==2)
            {
             JOptionPane.showMessageDialog(this, "You Won!");
             tick.stop();
             System.exit(0);
            }
         if(t.isLevelCleared(k1)&&onetimegate2&&t.level==1)
        {
            onetimegate2=false;
          t.level=2;
          t.textnumbershow=7;
          t.gateend=90000;
          Dagger.daggerpickedup=false;
          Weapons.firebreathpickedup=false;
          timerbegin=true;
            
        }
           
        if(timerbegin==true)
        {
         countaaa=countaaa+70;   
        }
        if(countaaa>1700&&timerbegin==true)
        {
            
         timerbegin=false;
         t.shownextone=true;
        }
        
        //------------------------------
       //------------------------------
        if(t.M1.monsterkilledPlayer(k1)&&t.M1.alive)
        {
           if(k1.lives==0)
           {
             System.out.println("BAM!!!!");   
            tick.stop();
            JOptionPane.showMessageDialog(this, "You Lost!");
             System.exit(0);   
           }
           else{
               if(t.M1.Monsterdirec=="left")
               {
                   t.mapmovex-=30;
                    knocking=1+5;
               }
               else{
                   t.mapmovex+=30;
                    knocking=1;
               }
               k1.lives--;
               knockback=true;
              
               
           }
      
     
            
        }
         if(t.M2.monsterkilledPlayer(k1)&&t.M2.alive)
        {
              if(k1.lives==0)
           {
             System.out.println("BAM!!!!");   
            tick.stop();
            JOptionPane.showMessageDialog(this, "You Lost!");
             System.exit(0);   
           }
           else{
               if(t.M2.Monsterdirec=="left")
               {
                   t.mapmovex-=30;
                   knocking=2+5;
               }
               else{
                   t.mapmovex+=30;
                   knocking=2;
                   
               }
               k1.lives--;
                 knockback=true;
                 
           }
        }
         if(t.M3.monsterkilledPlayer(k1)&&t.M3.alive)
         {
              if(k1.lives==0)
           {
             System.out.println("BAM!!!!");   
            tick.stop();
            JOptionPane.showMessageDialog(this, "You Lost!");
             System.exit(0);   
           }
           else{
               if(t.M3.Monsterdirec=="left")
               {
                   t.mapmovex-=30;
                      knocking=3+5;
               }
               else{
                   t.mapmovex+=30;
                      knocking=3;
               }
               k1.lives--;
                 knockback=true;
              
               
           }
            
             
         }
          if(t.M4.monsterkilledPlayer(k1)&&t.M4.alive)
         {
              if(k1.lives==0)
           {
             System.out.println("BAM!!!!");   
            tick.stop();
            JOptionPane.showMessageDialog(this, "You Lost!");
             System.exit(0);   
           }
           else{
               if(t.M4.Monsterdirec=="left")
               {
                   t.mapmovex-=30;
                   knocking=4+5;
               }
               else{
                   t.mapmovex+=30;
                   knocking=4;
               }
               k1.lives--;
                 knockback=true;
                 
           }
            
             
         }
           if(t.M5.monsterkilledPlayer(k1)&&t.M5.alive)
         {
               if(k1.lives==0)
           {
             System.out.println("BAM!!!!");   
            tick.stop();
            JOptionPane.showMessageDialog(this, "You Lost!");
             System.exit(0);   
           }
           else{
               if(t.M5.Monsterdirec=="left")
               {
                   t.mapmovex-=30;
                    knocking=5+5;
               }
               else{
                   t.mapmovex+=30;
                    knocking=5;
               }
               k1.lives--;
                 knockback=true;
                
           }
            
             
         }
           //------------------------------
           
           if(knockback==true&&knocking==1)
           {
               t.mapmovex=t.mapmovex+30;
               knockbackindex=knockbackindex+30;
               if(knockbackindex==300)
               {
                knockback=false;  
                 knockbackindex=0;
               }
           }
            if(knockback==true&&knocking==2)
           {
               t.mapmovex=t.mapmovex+30;
               knockbackindex=knockbackindex+30;
               if(knockbackindex==300)
               {
                knockback=false;   
                 knockbackindex=0;
               }
           }
             if(knockback==true&&knocking==3)
           {
               t.mapmovex=t.mapmovex+30;
               knockbackindex=knockbackindex+30;
               if(knockbackindex==300)
               {
                knockback=false;   
                 knockbackindex=0;
               }
           }
              if(knockback==true&&knocking==4)
           {
               t.mapmovex=t.mapmovex+30;
               knockbackindex=knockbackindex+30;
               if(knockbackindex==300)
               {
                knockback=false;   
                 knockbackindex=0;
               }
           }
               if(knockback==true&&knocking==5)
           {
               t.mapmovex=t.mapmovex+30;
               knockbackindex=knockbackindex+30;
               if(knockbackindex==300)
                    
               {
                knockback=false;   
                knockbackindex=0;
                }
           }
                
                //----------------------------------
                 if(knockback==true&&knocking==6)
           {
               t.mapmovex=t.mapmovex-30;
               knockbackindex=knockbackindex+30;
               if(knockbackindex==300)
               {
                knockback=false;   
                knockbackindex=0;
               }
           }
             if(knockback==true&&knocking==7)
           {
               t.mapmovex=t.mapmovex-30;
               knockbackindex=knockbackindex+30;
               if(knockbackindex==300)
               {
                knockback=false;
                 knockbackindex=0;
               }
           }
              if(knockback==true&&knocking==8)
           {
               t.mapmovex=t.mapmovex-30;
               knockbackindex=knockbackindex+30;
               if(knockbackindex==300)
               {
                knockback=false; 
                 knockbackindex=0;
               }
           }
               if(knockback==true&&knocking==9)
           {
               t.mapmovex=t.mapmovex-30;
               knockbackindex=knockbackindex+30;
               if(knockbackindex==300)
               {
                knockback=false;  
                 knockbackindex=0;
               }
           }
                if(knockback==true&&knocking==10)
           {
               t.mapmovex=t.mapmovex-30;
               knockbackindex=knockbackindex+30;
               if(knockbackindex==300)
               {
                knockback=false;   
                 knockbackindex=0;
               }
           }
           
           
           
           //-------------------------------------------------------------------------------------------------------------------------
           d.daggerpickup(k1);
           if(d.daggerpickup(k1)&&onetimegate4&&t.level==1)
           {
               onetimegate4=false;
            t.textnumbershow=2;
           }
           if(d.daggerpickup(k1)&&onetimegate9&&t.level==2)
           {
               onetimegate9=false;
            t.textnumbershow=9;
           }
           FIREbreath.flamepickup(k1);
           if(FIREbreath.flamepickup(k1)&&onetimegate5)
           {
               onetimegate5=false;
            t.textnumbershow=5;
           }
           
         
         //------------------------------------------------------------------------------------------------
        if(d.didDaggerStab(t.M1,k1)&&d.daggeron&&t.M1.alive&&Dagger.daggerpickedup)
        {
           if(d.stabon)
           {
            d.stabon=false;
             System.out.println("Stabbed");
             t.M1.monsterlives();
              k1.score=k1.score+1;
         Scoreboard.setText("Score : "+k1.score);
           Sounds.playstabsound();
           }
             if(t.M1.lives==0)
             {
              t.M1.alive=false;  
              Sounds.Death();   
         
             }
        
         
        }
        else{
//            System.out.println("MISSED IT");
        }
        //--------------------------------------------------
        if(d.didDaggerStab(t.M2,k1)&&d.daggeron&&t.M2.alive&&Dagger.daggerpickedup)
        {
            if(d.stabon)
            {
                d.stabon=false;
             System.out.println("Stabbed");
             t.M2.monsterlives(); 
              k1.score=k1.score+1;
             Scoreboard.setText("Score : "+k1.score);
               Sounds.playstabsound();
            }
             if(t.M2.lives==0)
             {
              t.M2.alive=false;
                Sounds.Death();
               
               
              
             }
           
          
        }
         //--------------------------------------------------
        if(d.didDaggerStab(t.M3,k1)&&d.daggeron&&t.M3.alive&&Dagger.daggerpickedup)
        {
            
            if(d.stabon)
            {
                d.stabon=false;
             System.out.println("Stabbed");
             t.M3.monsterlives(); 
                k1.score=k1.score+1;
             Scoreboard.setText("Score : "+k1.score);
               Sounds.playstabsound();
            }
             if(t.M3.lives==0)
             {
              t.M3.alive=false; 
              Sounds.Death();
             }
         
            
        }
        
         //--------------------------------------------------
        if(d.didDaggerStab(t.M4,k1)&&d.daggeron&&t.M4.alive&&Dagger.daggerpickedup)
        {
            if(d.stabon)
            {
                d.stabon=false;
             System.out.println("Stabbed");
             t.M4.monsterlives();   
              k1.score=k1.score+1;
             Scoreboard.setText("Score : "+k1.score);
                Sounds.playstabsound();
            }
             if(t.M4.lives==0)
             {
              t.M4.alive=false; 
              t.easteregg=true;
              t.textnumbershow=10;
              Sounds.Death();
             }
           
            
        }
         //--------------------------------------------------
        if(d.didDaggerStab(t.M5,k1)&&d.daggeron&&t.M5.alive&&Dagger.daggerpickedup)
        {
           
            if(d.stabon)
            {
                d.stabon=false;
             System.out.println("Stabbed");
             t.M5.monsterlives(); 
             k1.score=k1.score+1;
             Scoreboard.setText("Score : "+k1.score);
               Sounds.playstabsound();
            }
             if(t.M5.lives==0)
             {
              t.M5.alive=false; 
              Sounds.Death();
              
             }
            
            
        }
        //----------------------------------------------------------------------------------------------------------
       if( FIREbreath.haveCripsed(t.M1,k1)&&FIREbreath.firebreathon&&t.M1.alive&&FIREbreath.firebreathpickedup)
       {
          t.M1.monsterlives();
             if(t.M1.lives==0)
             {
              t.M1.alive=false;  
            
//         o.Saving(k1.y, t.mapmovex);
         Sounds.Death();
             }   
                k1.score=k1.score+1;
         Scoreboard.setText("Score : "+k1.score);
        
           
         
       }
       //------------------------------
       if(FIREbreath.haveCripsed(t.M2,k1)&&FIREbreath.firebreathon&&t.M2.alive&&FIREbreath.firebreathpickedup)
       {
            System.out.println("Crisped");
             t.M2.monsterlives();
             if(t.M2.lives==0)
             {
              t.M2.alive=false; 
              t.textnumbershow=6;
             Sounds.Death();
             
             }
              k1.score=k1.score+1;
             Scoreboard.setText("Score : "+k1.score);
            
           
       }
        //------------------------------
       if(FIREbreath.haveCripsed(t.M3,k1)&&FIREbreath.firebreathon&&t.M3.alive&&FIREbreath.firebreathpickedup)
       {
            System.out.println("Crisped");
             t.M3.monsterlives();
             if(t.M3.lives==0)
             {
              t.M3.alive=false; 
             
             Sounds.Death();
             }
              k1.score=k1.score+1;
             Scoreboard.setText("Score : "+k1.score);
            
           
       }
        //------------------------------
       if(FIREbreath.haveCripsed(t.M4,k1)&&FIREbreath.firebreathon&&t.M4.alive&&FIREbreath.firebreathpickedup)
       {
            System.out.println("Crisped");
              t.M4.monsterlives();
             if(t.M4.lives==0)
             {
              t.M4.alive=false; 
             
             Sounds.Death();
             }
             k1.score=k1.score+1;
             Scoreboard.setText("Score : "+k1.score);
           
       }
        //------------------------------
       if(FIREbreath.haveCripsed(t.M5,k1)&&FIREbreath.firebreathon&&t.M5.alive&&FIREbreath.firebreathpickedup)
       {
            System.out.println("Crisped");
              t.M5.monsterlives();
             if(t.M5.lives==0)
             {
              t.M5.alive=false; 
            
             Sounds.Death();
             }
                k1.score=k1.score+1;
             Scoreboard.setText("Score : "+k1.score);
           
           
       }
       
                
        if(t.istheretile(k1))
       {
//           lklklklkl  istile=true;
         
//           System.out.println("JumpReset");
       }
       else{
           k1.y+=30;
           k1.knighttophead=k1.y+120;
//          lklklklklkl istile=false;
//         
       }
         if(k1.y>1000)
     {
//         Sounds.playfallingsound();
      tick.stop();
      JOptionPane.showMessageDialog(this, "You Lost!");
         System.exit(0);
     }
//         if(t.CheckBlocked(k1.getY()))
//         {
//             controlState=false;
//          if(idlelr.equalsIgnoreCase("idleleft"))
//          {
//              t.mapmovex+=20;   
//          }
//          else
//          {
//              t.mapmovex-=20;   
//          }
//         }
//         else{
//         controlState=true;
//         }

//     }
//        if(istile)
//    {
//     k1.y+=30;
//    
//    }
       
//        
//        if(firstgate)
//        {
//         if(secondgate)   
//         {
//          ucanpressup=true;   
//          firstgate=false;
//          secondgate=false;
//         }
//        }
       
            if(cm.GetKeyState(KeyEvent.VK_S))
            {
//                FIREbreath.saveFireBreath();
//                FIREbreath= new Weapons();
//                Weapons.saveFireBreath();
                if(cm.GetKeyState(KeyEvent.VK_S)&&d.daggerpickedup&&onetimegate3)
                {
                    t.textnumbershow=3;
                    onetimegate3=false;
                  
                }
            FIREbreath.theknightsY=k1.y;
            d.daggeron=true;
            d.k1y=k1.y;
//         firebreathes.add(FIREbreath);
//         fireon=true;
            }
            if(cm.GetKeyState(KeyEvent.VK_D)&&FIREbreath.firebreathpickedup)
            {
//                FIREbreath.saveFireBreath();
//                FIREbreath= new Weapons();
//                Weapons.saveFireBreath();
            FIREbreath.theknightsY=k1.y;
//            d.daggeron=true;
//            d.k1y=k1.y;
//         firebreathes.add(FIREbreath);
//         fireon=true;
            }
       
         if(cm.GetKeyState(KeyEvent.VK_UP)&&istile)
         {
          k1.move("UP");
         }
         if(k1.jumpstate==true)
        {

            k1.move("UP");
            isjumpon=true;
           
        }   
       
      if(controlState)
      {
             if(cm.GetKeyState(KeyEvent.VK_RIGHT))
        {
           t.mapmove("RIGHT");
           Jumplr ="JUMPRIGHT";
           idlelr="IDLERIGHT";
           FIREbreath.firedirec="Right";
           d.daggerdirec="Right";
           t.M1.Monsterdirec="right";
           t.M2.Monsterdirec="right";
           t.M3.Monsterdirec="left";
           t.M4.Monsterdirec="left";
           t.M5.Monsterdirec="left";
        }
       if(cm.GetKeyState(KeyEvent.VK_LEFT))
        {
           t.mapmove("LEFT");
            Jumplr ="JUMPLEFT";
           idlelr="IDLELEFT";
           FIREbreath.firedirec="left";
               d.daggerdirec="left";
               t.M1.Monsterdirec="left";
               t.M2.Monsterdirec="left";
               t.M3.Monsterdirec="left";
               t.M4.Monsterdirec="left";
               t.M5.Monsterdirec="left";
        }   
      }
        if(t.CheckBlocked(k1))
         {
             controlState=false;
          if(idlelr.equalsIgnoreCase("idleleft"))
          {
              t.mapmovex+=20;   
          }
          else
          {
              t.mapmovex-=20;   
          }
         }
         else{
         controlState=true;
         } 
    }


    @Override
    public void paint(Graphics g) {
//    super.paint(g); //To change body of generated methods, choose Tools | Templates.
//    t.loadtiles(g);
  super.paint(g);
  t.drawbackground(g);
  
 
  t.tilesPosition(g);
 if((cm.GetKeyState(KeyEvent.VK_S))||d.daggeron)//||FIREbreath.firebreathon==true
      {
          try {
              
//                FIREbreath.loadFireBreath(g);
                d.loadDagger(g);
                    } 
          catch (Exception e) {
              System.out.println(e.getMessage());
          }
      }
 if(((cm.GetKeyState(KeyEvent.VK_D))||FIREbreath.firebreathon==true)&&FIREbreath.firebreathpickedup)//||FIREbreath.firebreathon==true
      {
          try {
              
//                FIREbreath.loadFireBreath(g);
                FIREbreath.loadFireBreath(g);
                if(FIREbreath.fireFrameIndex==1)
                {
                 Sounds.playflamesound();   
                }
                    } 
          catch (Exception e) {
              System.out.println(e.getMessage());
          }
      }
// if((s.equalsIgnoreCase("s")&&Spressed)||FIREbreath.firebreathon==true)
// {
//  FIREbreath.loadFireBreath(g);
// }
  
//   for(Weapons f : firebreathes)
//   {
//       
//       if((cm.GetKeyState(KeyEvent.VK_S))||f.firebreathon==true)
//      {
//          try {
//              
//                f.loadFireBreath(g);
//                if(f.fireFrameIndex==48)
//              {
//                  badfire=f;
//              }          } catch (Exception e) {
//              System.out.println(e.getMessage());
//          }
//     }
//
//      }
//   firebreathes.remove(badfire);
//   }
//         if(f.firex>2000)
//       {
//        badfire= f;
//      }
//   firebreathes.remove(badfire);

 

 if(GetFrameOrSprites.monsterframeindex==5)
 {
  GetFrameOrSprites.monsterframeindex=0;   
 }
 else{GetFrameOrSprites.monsterframeindex++;}
 //<editor-fold defaultstate="collapsed" desc="comment">
 if((cm.GetKeyState(KeyEvent.VK_UP)&&istile)||isjumpon==true)
 {
      if(Jumplr.equalsIgnoreCase("JumpLEFT"))
      {
       nowstate=5;   
      }
      if(Jumplr.equalsIgnoreCase("JUMPRIGHT"))
      {
          nowstate=6;
      }
      if(!((previousstate==5)||(previousstate==6)))
          //previousstate!=nowstate&&!(previousstring.equalsIgnoreCase(Jumplr))
     {
         GetFrameOrSprites.frameindex=0;
         previousstate=nowstate;
         previousstring=Jumplr;
     }
     
      
   
//     if(soundon)//&&jumpreleased
//     {
//         Sounds.playSound();
//         soundon=false;
//     }
     
    
//     if(tickcounter>1||firstjumpframe)
//     {
     tickcounter=0;
     firstjumpframe=false;
     if(GetFrameOrSprites.frameindex ==7)
     {
//            brushhhh = getGraphics();
         k1.getwhatknightdo(Jumplr);
         k1.loadimages(g);
         GetFrameOrSprites.frameindex=0;
         isjumpon=false;
//         soundon=true;
         leftkeypressed=false;
     }

     else
     {
                if(GetFrameOrSprites.frameindex==0)
      {
//       soundon=true;
          Sounds.playSound();
      }
//            brushhhh = getGraphics();
         k1.getwhatknightdo(Jumplr);
         k1.loadimages(g);
          GetFrameOrSprites.frameindex++;
//         animationtest=!animationtest;
//         if(animationtest)
//         {
//          GetFrameOrSprites.frameindex++;
//          
//         }
//         isjumpon=true;
         
         
     }
     
         
     }
     
// }
//</editor-fold>
 //<editor-fold defaultstate="collapsed" desc="comment">
//<editor-fold defaultstate="collapsed" desc="comment">
 else if(cm.GetKeyState(KeyEvent.VK_RIGHT)&&isjumpon==false)
 {
     nowstate=4;
     
     if(previousstate!=nowstate)
     {
         GetFrameOrSprites.frameindex=0;
         previousstate=nowstate;
        
     }
      
      
     if(GetFrameOrSprites.frameindex ==7)
     {
//            brushhhh = getGraphics();
         k1.getwhatknightdo("RIGHT");
         k1.loadimages(g);
         GetFrameOrSprites.frameindex=0;
         
     }
     else
     {
//            brushhhh = getGraphics();
         k1.getwhatknightdo("RIGHT");
         k1.loadimages(g);
          GetFrameOrSprites.frameindex++;
//         animationtest=!animationtest;
//         if(animationtest)
//         {
//          GetFrameOrSprites.frameindex++;
//          
//         }
     }
     
 }
//</editor-fold>
//</editor-fold>
 //<editor-fold defaultstate="collapsed" desc="comment">
 else if(cm.GetKeyState(KeyEvent.VK_LEFT)&&isjumpon==false)
 {
     nowstate=3;
     
     if(previousstate!=nowstate)
     {
         GetFrameOrSprites.frameindex=0;
         previousstate=nowstate;
        
     }
     if(GetFrameOrSprites.frameindex ==7)
     {
//            brushhhh = getGraphics();
         k1.getwhatknightdo("LEFT");
         k1.loadimages(g);
         GetFrameOrSprites.frameindex=0;
         
     }
     else
     {
//            brushhhh = getGraphics();
         k1.getwhatknightdo("LEFT");
         k1.loadimages(g);
          GetFrameOrSprites.frameindex++;
//          animationtest=!animationtest;
//         if(animationtest)
//         {
//          GetFrameOrSprites.frameindex++;
//          
//         }
     }
     
 }
//</editor-fold>
 //<editor-fold defaultstate="collapsed" desc="comment">
 else
 { 
     if(isjumpon==false)
 {
     if(idlelr.equalsIgnoreCase("IDLELEFT"))
      {
       nowstate=1;   
      }
      if(idlelr.equalsIgnoreCase("IDLERIGHT"))
      {
          nowstate=2;
      }
      if(previousstate!=nowstate&&!(previousstring.equalsIgnoreCase(idlelr)))
     {
         GetFrameOrSprites.frameindex=0;
         previousstate=nowstate;
         previousstring=idlelr;
     }
     
     if(GetFrameOrSprites.frameindex ==7)
     {
//            brushhhh = getGraphics();
         k1.getwhatknightdo(idlelr);
         k1.loadimages(g);
         GetFrameOrSprites.frameindex=0;
     }
     else
     {
//            brushhhh = getGraphics();
         k1.getwhatknightdo(idlelr);
         k1.loadimages(g);
          GetFrameOrSprites.frameindex++;
//          animationtest=!animationtest;
//         if(animationtest)
//         {
//          GetFrameOrSprites.frameindex++;
//          
//         }
     }
//      g.fillRect(350+130, k1.y, 20, 300);
//             g.fillRect(350+130+60, 800-80, 20, 20);
     
 }
//</editor-fold>
        
//        if(t.M1.alive==false)
//        {
//         t.M1.loadexplosion(g);
//        }
//        if(t.M2.alive==false)
//        {
//            
//         t.M2.loadexplosion(g);
//        }
//        if(t.M3.alive==false)
//        {
//            
//         t.M3.loadexplosion(g);
//        }
//        if(t.M4.alive==false)
//        {
//            
//         t.M4.loadexplosion(g);
//        }
//        if(t.M5.alive==false)
//        {
//            
//         t.M5.loadexplosion(g);
//        }
        
    }
 
     Font trb = new Font("TimesRoman", Font.BOLD, 18);
    g.setColor(Color.black );
    g.setFont(trb);
    g.drawString("Score = "+k1.score, 500, 60+100);
        
  }
   
 }
    
       
  

//    @Override
//    public void paint(Graphics g) {
//        super.paint(g); 
//
// 
//       if(GetFrameOrSprites.frameindex ==6)
//       {
//            brushhhh = getGraphics();
//            im.loadimages(brushhhh);
//            GetFrameOrSprites.frameindex=0;
//       }
//       else{
//            brushhhh = getGraphics();
//            im.loadimages(brushhhh);
//           GetFrameOrSprites.frameindex++;
//       }
//    }//To change body of generated methods, choose Tools | Templates.
//    }
//
//    /**
//     *
//     */
//    
    
