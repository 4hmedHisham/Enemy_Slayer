
package pkgfinal.pkg01;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.lang.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;

public class OptionWindow extends JFrame 
    
{
    String name ;
    
    Frammefinalisa frame ;
    HallOfFame hallFame;
    int i;

    Label lbl;
    TextField txtfld;
    JButton start ;
    JButton HallOfFame;
    JButton load ;
    boolean uslessboolean;

    public OptionWindow() 
    {
        //***********************************
        this.setTitle("Enemy Slayer");
        this.setBounds(10, 10, 500, 170+180+75);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
       //***************************************   
       frame = new Frammefinalisa();
       hallFame = new HallOfFame();
       //***************************************
              
       lbl = new Label();
       Font trb = new Font("TimesRoman", Font.BOLD, 18);
                lbl.setFont(trb);
       lbl.setText("please enter your name to start the game");
       lbl.setBounds(0, 0, 500, 50);
       lbl.setBackground(Color.GREEN);
       this.add(lbl);
      
       

       
    //*************************************************    
       txtfld = new TextField();
       txtfld.setBounds(0, 50, 500, 50);
       this.add(txtfld);
   //*****************************************************    
        start = new JButton("Start");
        start.setBounds(0,100 ,500 , 100);
        this.add(start);
        
        start.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) { 
                 name = txtfld.getText();
               if(!(name.equalsIgnoreCase("")))
               {
               frame.gamepnl.playerName = name;
               // frame.gamepnl.lab();
               // hallFame.file();
                int i ;
              
                   i = hallFame.checkExistance(name);
                   frame.gamepnl.massege(i);
                   frame.setVisible(true);                 
                   setVisible(false);
                   
                   frame.gamepnl.startgame();
                   frame.gamepnl.tick.start();
                   
               }
            }
        }
        );
        //**************************************
        load = new JButton("load");
        load.setBounds(0, 170+25 , 500, 100);
        this.add(load);
        load.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.gamepnl.iamLoading = true;
                frame.gamepnl.startgame();
                frame.gamepnl.tick.start();
                Loading();
                frame.gamepnl.iamLoading = false;
                
               //frame.gamepnl.lab();
               // hallFame.file();
                frame.gamepnl.massege(1);
                setVisible(false);               
                frame.setVisible(true);
                frame.gamepnl.tick.start();
              
             
            }
        }
        );
       //****************************************** 
        HallOfFame = new JButton("Hall Of Fame");
        HallOfFame.setBounds(0,170+75+50 , 500, 100);
        this.add(HallOfFame);
        HallOfFame.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {              
                //setVisible(false);
                hallFame.setVisible(true);
               // hallFame.file();
                hallFame.printH();
                   Sounds.playHalloffame();
            }
        }
        );  
        //*******************************************
    }
    
  
            
    public void Loading()
    {
        try {
            JFileChooser jf = new JFileChooser();
        jf.showOpenDialog(null);
        
        File selectedFile = jf.getSelectedFile();
        String filepath = selectedFile.getPath();
            LoadingUpdate(filepath);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
         void LoadingUpdate(String path) 
    {

        try
        {  
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
         
          frame.gamepnl.playerName = ois.readUTF();
            System.out.println(frame.gamepnl.playerName);
        frame.gamepnl.s= ois.readUTF();
        frame.gamepnl.Jumplr = ois.readUTF();
        frame.gamepnl.idlelr= ois.readUTF();
        frame.gamepnl.previousstring= ois.readUTF();
        frame.gamepnl.t.M1.Monsterdirec= ois.readUTF();
        frame.gamepnl.t.M2.Monsterdirec= ois.readUTF();
        frame.gamepnl.t.M3.Monsterdirec= ois.readUTF();
        frame.gamepnl.t.M4.Monsterdirec= ois.readUTF();
        frame.gamepnl.t.M5.Monsterdirec= ois.readUTF();
        frame.gamepnl.FIREbreath.firedirec= ois.readUTF();
        frame.gamepnl. d.daggerdirec= ois.readUTF();   
            
        frame.gamepnl.backgroundsong = ois.readBoolean();
          uslessboolean=ois.readBoolean();
       frame.gamepnl.onetimegate = true;
        frame.gamepnl.onetimegate3 = ois.readBoolean();
        frame.gamepnl.onetimegate4 = ois.readBoolean();
        frame.gamepnl.onetimegate5 = ois.readBoolean();
        frame.gamepnl.onleoncegate = ois.readBoolean();
        frame.gamepnl.onlythistime = ois.readBoolean();
        frame.gamepnl.onetimegate9 = ois.readBoolean();       
        frame.gamepnl.firstjumpframe = ois.readBoolean();
        //*********************
        frame.gamepnl.isjumpon = ois.readBoolean();
        frame.gamepnl.soundon = ois.readBoolean();
        frame.gamepnl. firstgate = ois.readBoolean();
        frame.gamepnl.secondgate = ois.readBoolean();
        frame.gamepnl.istile = ois.readBoolean();
        frame.gamepnl.onetimegate2 = ois.readBoolean();
        frame.gamepnl.timerbegin = ois.readBoolean();
        frame.gamepnl.leftkeypressed = ois.readBoolean();
        frame.gamepnl.rightkeypressed = ois.readBoolean();
        frame.gamepnl.firstidle = ois.readBoolean();
        frame.gamepnl.jumpkeystate = ois.readBoolean();
        
        //tiles****************
        
       frame.gamepnl.t.enteronetime = ois.readBoolean();
        frame.gamepnl.t.enteronetime2 =ois.readBoolean();
       frame.gamepnl.t.enteronetime3= ois.readBoolean();
        frame.gamepnl.t.enteronetime4= ois.readBoolean();
        frame.gamepnl.t.enteronetime5= ois.readBoolean();
        frame.gamepnl.t.enteronetime6= ois.readBoolean();
        frame.gamepnl. t.shownextone= ois.readBoolean();
        frame.gamepnl.t.easteregg= ois.readBoolean();
        frame.gamepnl. t.onetimeoff= ois.readBoolean();
        
        //monster**************
        
        //M1
       frame.gamepnl.t.M1.alive = ois.readBoolean();
        frame.gamepnl.t.M1.amimovinright= ois.readBoolean();
        frame.gamepnl. t.M1.flippinggate= ois.readBoolean();
        frame.gamepnl. t.M1.prevchangedirec= ois.readBoolean();
        frame.gamepnl. t.M1.explosionfinish= ois.readBoolean();
        frame.gamepnl. t.M1.setconstindex= ois.readBoolean();
        //M2
        frame.gamepnl. t.M2.alive= ois.readBoolean();
       frame.gamepnl. t.M2.amimovinright= ois.readBoolean();
        frame.gamepnl.t.M2.flippinggate= ois.readBoolean();
        frame.gamepnl. t.M2.prevchangedirec= ois.readBoolean();
       frame.gamepnl. t.M2.explosionfinish= ois.readBoolean();
        frame.gamepnl.t.M2.setconstindex= ois.readBoolean();
        //M3
        frame.gamepnl. t.M3.alive= ois.readBoolean();
        frame.gamepnl. t.M3.amimovinright= ois.readBoolean();
        frame.gamepnl. t.M3.flippinggate= ois.readBoolean();
        frame.gamepnl. t.M3.prevchangedirec= ois.readBoolean();
        frame.gamepnl. t.M3.explosionfinish= ois.readBoolean();
        frame.gamepnl.t.M3.setconstindex= ois.readBoolean();
        //M4
        frame.gamepnl. t.M4.alive= ois.readBoolean();
        frame.gamepnl.t.M4.amimovinright= ois.readBoolean();
        frame.gamepnl. t.M4.flippinggate= ois.readBoolean();
        frame.gamepnl.t.M4.prevchangedirec= ois.readBoolean();
        frame.gamepnl.t.M4.explosionfinish= ois.readBoolean();
        frame.gamepnl.t.M4.setconstindex= ois.readBoolean();
        //M5
        frame.gamepnl.t.M5.alive= ois.readBoolean();
        frame.gamepnl. t.M5.amimovinright= ois.readBoolean();
        frame.gamepnl.t.M5.flippinggate= ois.readBoolean();
        frame.gamepnl.t.M5.prevchangedirec= ois.readBoolean();
        frame.gamepnl.t.M5.explosionfinish= ois.readBoolean();
        frame.gamepnl.t.M5.setconstindex= ois.readBoolean();
        
        //Weapons********************
        
        frame.gamepnl.FIREbreath.caniflame=ois.readBoolean();
        frame.gamepnl.FIREbreath.firebreathon=ois.readBoolean();
        frame.gamepnl.FIREbreath.firebreathpickedup =ois.readBoolean();
        
        //Knight no booleans*********
        
        //Dagger*********************
        
        frame.gamepnl. d.daggeron=ois.readBoolean();
        frame.gamepnl. d.stabon=ois.readBoolean();
        
        //************************************************************
         //Panalfinalisa****************
        
        frame.gamepnl. countaaa = ois.readInt();
        frame.gamepnl. jumptimer = ois.readInt();
        frame.gamepnl.tickcounter= ois.readInt();
        frame.gamepnl.jumpcount= ois.readInt();
        
        //Tiles***********************
        
        frame.gamepnl.t.level= ois.readInt();
       frame.gamepnl.t.theY= ois.readInt();
        frame.gamepnl.t.mapmovey= ois.readInt();
        frame.gamepnl. t.mapmovex= ois.readInt();
        frame.gamepnl.t.textnumbershow= ois.readInt();
        frame.gamepnl.t.lastXB4Death= ois.readInt();
        frame.gamepnl. t.Yinc= ois.readInt();
        frame.gamepnl.t.lastYB4Death= ois.readInt();
        
        //Monster*********************
        //M1
        
        frame.gamepnl.t.M1.drawx= ois.readInt();
        frame.gamepnl. t.M1.drawy= ois.readInt();
        frame.gamepnl. t.M1.monsterlegx1= ois.readInt();
        frame.gamepnl.t.M1.monsterlegx2= ois.readInt();
        frame.gamepnl.t.M1.monsterlegy= ois.readInt();
        frame.gamepnl. t.M1.monsterreallegx1= ois.readInt();
        frame.gamepnl. t.M1.monsterreallegx2= ois.readInt();
        frame.gamepnl.t.M1.monsterlegaddx2= ois.readInt();
        frame.gamepnl.t.M1.hieghtfromdrawy= ois.readInt();
        frame.gamepnl.t.M1.explosionindex= ois.readInt();
        frame.gamepnl.t.M1.whereidrawlegx= ois.readInt();
        frame.gamepnl.t.M1.lives= ois.readInt();
        frame.gamepnl.t.M1.movmentIndex= ois.readInt();
        frame.gamepnl.t.M1.constindex= ois.readInt();
        //M2
        frame.gamepnl.t.M2.drawx= ois.readInt();
        frame.gamepnl. t.M2.drawy= ois.readInt();
        frame.gamepnl. t.M2.monsterlegx1= ois.readInt();
        frame.gamepnl.t.M2.monsterlegx2= ois.readInt();
        frame.gamepnl.t.M2.monsterlegy= ois.readInt();
        frame.gamepnl. t.M2.monsterreallegx1= ois.readInt();
        frame.gamepnl. t.M2.monsterreallegx2= ois.readInt();
        frame.gamepnl.t.M2.monsterlegaddx2= ois.readInt();
        frame.gamepnl.t.M2.hieghtfromdrawy= ois.readInt();
        frame.gamepnl.t.M2.explosionindex= ois.readInt();
        frame.gamepnl.t.M2.whereidrawlegx= ois.readInt();
        frame.gamepnl.t.M2.lives= ois.readInt();
        frame.gamepnl.t.M2.movmentIndex= ois.readInt();
        frame.gamepnl.t.M2.constindex= ois.readInt();
        //M3
        frame.gamepnl.t.M3.drawx= ois.readInt();
        frame.gamepnl. t.M3.drawy= ois.readInt();
        frame.gamepnl. t.M3.monsterlegx1= ois.readInt();
        frame.gamepnl.t.M3.monsterlegx2= ois.readInt();
        frame.gamepnl.t.M3.monsterlegy= ois.readInt();
        frame.gamepnl. t.M3.monsterreallegx1= ois.readInt();
        frame.gamepnl. t.M3.monsterreallegx2= ois.readInt();
        frame.gamepnl.t.M3.monsterlegaddx2= ois.readInt();
        frame.gamepnl.t.M3.hieghtfromdrawy= ois.readInt();
        frame.gamepnl.t.M3.explosionindex= ois.readInt();
        frame.gamepnl.t.M3.whereidrawlegx= ois.readInt();
        frame.gamepnl.t.M3.lives= ois.readInt();
        frame.gamepnl.t.M3.movmentIndex= ois.readInt();
        frame.gamepnl.t.M3.constindex= ois.readInt();
        //M4
        frame.gamepnl.t.M4.drawx= ois.readInt();
        frame.gamepnl. t.M4.drawy= ois.readInt();
        frame.gamepnl. t.M4.monsterlegx1= ois.readInt();
        frame.gamepnl.t.M4.monsterlegx2= ois.readInt();
        frame.gamepnl.t.M4.monsterlegy= ois.readInt();
        frame.gamepnl. t.M4.monsterreallegx1= ois.readInt();
        frame.gamepnl. t.M4.monsterreallegx2= ois.readInt();
        frame.gamepnl.t.M4.monsterlegaddx2= ois.readInt();
        frame.gamepnl.t.M4.hieghtfromdrawy= ois.readInt();
        frame.gamepnl.t.M4.explosionindex= ois.readInt();
        frame.gamepnl.t.M4.whereidrawlegx= ois.readInt();
        frame.gamepnl.t.M4.lives= ois.readInt();
        frame.gamepnl.t.M4.movmentIndex= ois.readInt();
        frame.gamepnl.t.M4.constindex= ois.readInt();
        //M5
        frame.gamepnl.t.M5.drawx= ois.readInt();
        frame.gamepnl. t.M5.drawy= ois.readInt();
        frame.gamepnl. t.M5.monsterlegx1= ois.readInt();
        frame.gamepnl.t.M5.monsterlegx2= ois.readInt();
        frame.gamepnl.t.M5.monsterlegy= ois.readInt();
        frame.gamepnl. t.M5.monsterreallegx1= ois.readInt();
        frame.gamepnl. t.M5.monsterreallegx2= ois.readInt();
        frame.gamepnl.t.M5.monsterlegaddx2= ois.readInt();
        frame.gamepnl.t.M5.hieghtfromdrawy= ois.readInt();
        frame.gamepnl.t.M5.explosionindex= ois.readInt();
        frame.gamepnl.t.M5.whereidrawlegx= ois.readInt();
        frame.gamepnl.t.M5.lives= ois.readInt();
        frame.gamepnl.t.M5.movmentIndex= ois.readInt();
        frame.gamepnl.t.M5.constindex= ois.readInt();
        
        //Weapons***********************
        
        frame.gamepnl. FIREbreath.fireFrameIndex=ois.readInt();
        frame.gamepnl. FIREbreath.theknightsY=ois.readInt();
        frame.gamepnl.FIREbreath.firey=ois.readInt();
        frame.gamepnl. FIREbreath.firex=ois.readInt();
        frame.gamepnl.FIREbreath. frameplacex=ois.readInt();
        frame.gamepnl.FIREbreath.frameplacey=ois.readInt();
        frame.gamepnl. FIREbreath.firebreathlimit=ois.readInt();
        frame.gamepnl.FIREbreath.firebreathleftlimit=ois.readInt();
        
        //Knight***********************
        
        frame.gamepnl. k1.y=ois.readInt();
        frame.gamepnl. k1.speed=ois.readInt();
        frame.gamepnl. k1.jump=ois.readInt();
        frame.gamepnl.k1.gravity=ois.readInt();
        frame.gamepnl.k1.KnightDo=ois.readInt();
        frame.gamepnl.k1.score=ois.readInt();
        frame.gamepnl.k1.knightleftleg=ois.readInt();
        frame.gamepnl.k1.knightrightleg=ois.readInt();
        frame.gamepnl. k1.knighttophead=ois.readInt();
        
        //Dagger*************************
        
        frame.gamepnl. d.daggerleftx=ois.readInt();
        frame.gamepnl. d.daggerrightx=ois.readInt();
        frame.gamepnl. d.k1y=ois.readInt();
        frame.gamepnl. d.daggerxplace =ois.readInt();
        frame.gamepnl.d.daggeryplace=ois.readInt();
        
        //GetFrameOrSprites
        // hena ya HHHHHHH 3awez ale ta7t zay ale fo2 
        GetFrameOrSprites.frameindex=ois.readInt();
        GetFrameOrSprites.monsterframeindex=ois.readInt();   
            
        //*******************************
        
        
        
//        for(int j = 0 ; j < 1060 ; j++)
//        frame.gamepnl.t.realpos[j] =(Tilexy)ois.readObject();
            ois.close();
            fis.close();  
        }
        catch(IOException e )
         {
             System.out.println(e.getMessage()); 
         }
//        catch(ClassNotFoundException ex)
//        {
//            System.out.println(ex.getMessage());
//        }
    }
     public void Saving(boolean x[] , int y[] , char c , String s[])
    {
        try
        {
            
        JFileChooser jf = new JFileChooser();
        jf.showSaveDialog(null);
        
        File selectedFile = jf.getSelectedFile();
        //path of file to save shapes into
        String filepath = selectedFile.getPath();
        FileOutputStream fos = new FileOutputStream(filepath);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        int n;
        
        for(n=0 ; n<12 ; n++)
        oos.writeUTF(s[n]);

        
        for( n = 0 ; n<64 ; n++)       
        oos.writeBoolean(x[n]);
        
        for( n= 0 ; n<107 ; n++)
        {
            if(n!=11)
            {
             oos.writeInt(y[n]);
            }
        }
        hallFame.addinformation(s[0], y[96]);
       // oos.writeChars(c);
       
//        for(n = 0 ;n<1060 ;n++)
//        {
//        real[n]=new Tilexy();
//        oos.writeObject(real[n]);
//        }
       
        System.out.println(s[0]);
        
            

            oos.close();
            fos.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage()); 
        }
       // SavingUpdate(filepath );
        
    }
    
//     public void SavingUpdate(String path)
//    {
//
//        try 
//        {
//            FileOutputStream fos = new FileOutputStream(path);
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            
//            int i = frame.gamepnl.t.mapmovex;
//            System.out.println("pk " + i);
//
//            oos.close();
//            fos.close();
//        } 
//        catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//
//    }
   
    
}
    

