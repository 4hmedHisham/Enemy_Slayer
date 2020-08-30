package pkgfinal.pkg01;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.imageio.ImageIO;
import javax.print.DocFlavor;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.*;
import sun.java2d.pipe.DrawImage;

 

public class HallOfFame extends JFrame
{
    //BufferedImage im;
    String newname  ;
    int newnmb = -5;
    String path;
    int arraySize =0;
    boolean emptyfile;
    int[] score ;
    String[] names;
    boolean create = true ;
    BufferedImage TheGif[];
    int frameindex=0;
    Timer tick;
    
    ImageIcon icon;
    JLabel l;
   // Graphics g;
  
    

    public HallOfFame()
    {
        tick= new Timer(50, null);
        
        tick.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        }
        
        
        
        );
        tick.start();
        
        TheGif= new BufferedImage[55];    
        try {
             for(int i=0;i<=54;i++)
            {
                
              File f9 = new File("Pics\\Gif\\"+Integer.toString(i)+".gif");   
             
              if(f9.exists())
              {
                  BufferedImage frame =ImageIO.read(f9);
                 
                  TheGif[i]=frame;
              }
            }
        } catch (Exception e) {
        }
//        File file = new File("I:\\omar\\semester 4\\back.jpg");
//       // File file2 = new File("I:\\omar\\semester 4\\Game development\\Project imp\\iesm7lh.gif");
//    
//        
//        if (file.exists()) 
//        {
//            try { 
//                //icon = ImageIcon("I:\\omar\\iesm7lh.gif");
//                 im = ImageIO.read(file);
//            } 
//            catch (IOException e)
//            {
//                System.out.println("hall of fame image is not found");
//            }
//        }
        
        

        score = new int[50];
        names = new String[50];
        this.setTitle("Hall of fame");
        this.setBounds(0, 0, 750, 420);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
          icon = new ImageIcon("I:\\omar\\semester 4\\Game development\\gify.gif");
        l = new JLabel(icon);
        l.setBounds(0, 0, 750, 420);
              this.add(l);

          
         
     //  icon = new ImageIcon("I:\\omar\\semester 4\\Game development\\gify.gif");
        //repaint();
        

    }

    
    @Override
    public void paint(Graphics grphcs) {
        //super.paint(grphcs); 
        
        Font stringFont = new Font("sherif", Font.ROMAN_BASELINE, 20 );
        grphcs.setFont(stringFont);
        grphcs.setColor(Color.BLACK);
        //icon.paintIcon(this, grphcs, WIDTH, WIDTH);
        //grphcs.setColor(Color.darkGray);
       // grphcs.drawImage(im, 0, 0, null);
       
//      icon.paintIcon(this, grphcs, 0, 0);
        
        grphcs.drawImage(TheGif[frameindex], 0, 0, null);
        if(frameindex==54)
        {
         frameindex=0;   
        }
        else{frameindex++;}
        //icon.
//         icon = new ImageIcon("I:\\omar\\semester 4\\Game development\\gify.gif");
//        l = new JLabel(icon);
//        this.add(l);



        //grphcs.drawImage(icon.getImage(), 10, 20, null);
        grphcs.setColor(Color.white);
      
        grphcs.drawString("Top Player", 420-40, 60);
        grphcs.drawString("Score", 550, 60);
        int y = 60+120-25;
        for(int i = 0 ; i<arraySize ; i++)
        {
            String t = String.valueOf(i+1);
            String s = String.valueOf(score[i]);
            y = y+20;
            grphcs.setColor(Color.white);
            grphcs.drawString(t,370+30 , y);
            grphcs.drawString("-",400+30 , y);           
            grphcs.drawString(names[i], 420+30, y);
            grphcs.drawString(s,550+40 , y);
            
    }
    }
        
    
    
    
    public void printH()
    {
        
        create = false;
        loadFromFile();
         //drawing();

//        arrangeInformation();
//        g.drawString("PlayerName", 400, 100);
//        g.drawRect(100, 100, 100, 100);
//        
//        for( int i = 1 ; i <arraySize; i++)
//        {
            
//        }
        
        
//        int i = 0;
//        lbls[i].setText("PLAYER NAMES                                  PLAYER SCORE ");
//        for( i = 0 ; i<arraySize ; i++)
//        {
//            lbls[i+1].setText( i+1+ " -  "+ names[i] + "                                         "+score[i]);
//        }
      
        
    }
    private void arrangeInformation()
    {
        String tmpName = new String();
        int tmpnumber ;
        for(int x=0 ; x<arraySize-1 ; x++)
        {
            for( int y = x ; y<arraySize ; y++ )
            {
                if(score[x] < score[y])
                {
                    tmpName = names[x];
                    tmpnumber = score[x];
                    names[x] = names[y];
                    score[x] = score[y];
                    names[y] = tmpName;
                    score[y] = tmpnumber;
                }
            }
        } 
    }
    
   public int checkExistance(String givenName)
   {
       
       create = false;
       loadFromFile();
       create = true;
       for(int a = 0 ; a<arraySize ; a++)
       {
           if(names[a].equalsIgnoreCase(givenName))
           {
               return 1;
           }
       }
       return 0;
   }
    
    
    public void addinformation(String s , int k )
    {
        newname = s;
        newnmb = k;
        create = true;
        loadFromFile();
    }
    

    public void file12()
    {
        
        
        try
        {
        File f = new File("myHallOffame3.txt");
        if(!f.exists())
        {
            emptyfile = true;
            if(create == true)
            {
            f.createNewFile();
            }
        }
            System.out.println(f.getPath());
            path = f.getPath();
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        
    }
    
    public void loadFromFile()
    {
        try
        {
         file12();
         arraySize=0;
        
        if(emptyfile == false)
        {
           
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        int i = ois.available();  
          
            while(i!=0)
            {
                 names[arraySize] = ois.readUTF();
                 score[arraySize] = ois.readInt();
                 i = ois.available();
                 arraySize++;
                 
            }  
            ois.close();
            fis.close();
        }
        
        }
        catch(Exception e)
        {
            
            System.out.println(e.getMessage());
        }
       save(  );

    }
    
    
    public void save( )
    {
        try
        {
            if(create == true)
            {
              emptyfile = false  ;
            if(newnmb != -5)
            {
            names[arraySize] = newname;
            score[arraySize] = newnmb;
            arraySize++;
            newnmb = -5;
            }
            
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            for(int i = 0 ; i<arraySize ; i++)
            {
                oos.writeUTF(names[i]);
                System.out.println(names[i]+ "   "  + score[i]);
                oos.writeInt(score[i]);
            }
            
            oos.close();
            fos.close();
            }
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    
    
    //    public void file()
//    {
//        try
//        {
//         JFileChooser jf = new JFileChooser();
//        jf.showOpenDialog(null);       
//        File selectedFile = jf.getSelectedFile(); 
//        path = selectedFile.getPath();
//        FileInputStream fis = new FileInputStream(selectedFile.getPath());
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        ois.close();
//        fis.close();
//        
//        }
//        catch(Exception e)
//        {
//            System.out.println(e.getMessage());
//            emptyfile = true;
//        }
//        
//    }
    
        
    
}

