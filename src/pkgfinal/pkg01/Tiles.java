/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.pkg01;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;

/**
 *
 * @author leno
 */
public class Tiles 
{
    BufferedImage tile;
    BufferedImage background;
    int level=1;  
    BufferedImage gate;
//    BufferedImage tilespos [] [];
//    BufferedImage tilesonscreen[][];
    int theY =900;//1000-50-50+8, far2 el They and k1.y are multiples of 30(gravity)
    int mapmovex=0;
    int mapmovey=0;
    int textnumbershow=1;
    boolean enteronetime=true;
    boolean enteronetime2=true;
    boolean enteronetime3=true;
    boolean enteronetime4=true;
    boolean enteronetime5=true;
    boolean enteronetime6=true;
    boolean shownextone=false;
  
    boolean easteregg=false;
     boolean onetimeoff=false;
    int lastXB4Death;
    int gateend=90000;
    int Yinc=60;
    int lastYB4Death;
    Tilexy [] realpos;
//    ArrayList<Tilexy> realpos;
    int index;
    int indexend;
    Tilexy leh;
    Monster M1;
    Monster M2;
    Monster M3;
    Monster M4;
    Monster M5;
//    boolean monsteralive=true;
//    boolean monster2alive=true;
    boolean changedirec=false;
    boolean onetimegate=true;
    
    

    public Tiles() {
        realpos = new Tilexy[1060];
        M1= new Monster();
        M2= new Monster();
        M3= new Monster();
        M4= new Monster();
        M5= new Monster();
    }
    
    
    public void savetiles()
    {              
        Monster.SaveAllImages();
//        realpos = new ArrayList<>();
     
//        tilespos = new BufferedImage[10000][10000];
//        tilesonscreen = new BufferedImage[10000][10000];
     File f = new File("Pics\\ground.png"); 
     File f2 = new File("Pics\\Materials\\Knight1\\JumpRight\\grassy_plains_by_theodenn.jpg ");
     File f3 = new File("Pics\\Gate.png");
             
              try {
            if(f.exists())
              {
                 tile =ImageIO.read(f);   
                 background=ImageIO.read(f2);
                 gate=ImageIO.read(f3);
              }
        } catch (Exception e) {
        }
    }
    public void tilesPosition(Graphics imagebrush)//upon building the map make sure to have increment of 30 at hight and of 50 at x to not mess up the game's logic/physics
    {
        if(level==1)
        {
         
        Yinc=60;

      for(int i=0;i<=3650;){
//          if(i==1050)
//          {
////              indexend=index;
////              index=0;
////
////                   i+=50;
//          }
          if(i>=1000&&i<=1300)
          {
             
//                 if(i==1200)
//                  {
//                      Font trb = new Font("TimesRoman", Font.BOLD, 36);
//               imagebrush.setColor(Color.black );
//               imagebrush.setFont(trb);
//                  
//                  }
             imagebrush.drawImage(tile, i-mapmovex, theY-210, null);
             if(i==1200)
             {
                      Font trb = new Font("TimesRoman", Font.BOLD, 36);
               imagebrush.setColor(Color.black );
               imagebrush.setFont(trb);
                  if(textnumbershow==5)
                  {
                    imagebrush.drawString("Thats When we use the firebreath by pressing (D)", i-mapmovex-100 , theY-700);   
                  }
             }
             if(M1.alive&&i==1000)
             {
//                MonstersHaveBrainsToo(M1.monsterlegx1, M1.monsterlegy);
//                M1.movementindexManger();
                M1.setDrawx(i-mapmovex);
                M1.setDrawy(theY-210-M1.legsonfloorInc);
                M1.loadimages(imagebrush);
                
                imagebrush.setColor(Color.black);
               
                 
                 
                
              
                      }
             if(!M1.alive&&enteronetime)//&&enteronetime
             {
                 M1.setxDie(M1.whereidrawlegx);
                 M1.setYdie(M1.drawy);
                 
//              M1.setDrawx(0);
//              M1.setDrawy(0);
              enteronetime=false;
              
             }
             if(!M1.alive)
             {
                 if(!M1.alive&&enteronetime6)
                 {
                  textnumbershow=4;
                  enteronetime6=false;
                 }
              M1.setxDie(M1.whereidrawlegx);
              M1.setDrawy(M1.drawy);
             }
             
             
             
             
//              tilespos[i][theY+50]=tile;
              realpos[index]=new Tilexy();
              realpos[index].setTilex(i-mapmovex);
              realpos[index].setTiley(theY-210);
              index++;
//              indexend=index;
//              index=0;
                   i+=50;
             
//              
//              }
             
              
          }
          else if (i==3650)
          {
            imagebrush.drawImage(gate, i-mapmovex, theY-Yinc-350, null);
//            imagebrush.drawRect(i-mapmovex+35,theY-Yinc-350 , 10, 350);
            gateend=i-mapmovex+35;
           i+=50;
          }
          else if (i>3100)
          {
               imagebrush.drawImage(tile, i-mapmovex, theY-Yinc, null);
              
              realpos[index]=new Tilexy();
              realpos[index].setTilex(i-mapmovex);
              realpos[index].setTiley(theY-Yinc);
              index++;
              
//              indexend=index;
//              index=0;
                   i+=50;
          }
          else if(i>=2600&&i<=3100)
          {
              
              imagebrush.drawImage(tile, i-mapmovex, theY-Yinc, null);
              realpos[index]=new Tilexy();
              realpos[index].setTilex(i-mapmovex);
              realpos[index].setTiley(theY-Yinc);
              index++;
              Yinc=Yinc+60;
//              indexend=index;
//              index=0;
                   i+=100;
              
          }
          else if(i>=2300&&i<=2600)
          {
                if(i==2500&&textnumbershow==6)
                  {
                      
               Font trb = new Font("TimesRoman", Font.BOLD, 36);
               imagebrush.setColor(Color.black );
               imagebrush.setFont(trb);
               imagebrush.drawString("Now climb up to the unkown", i-mapmovex-100 , theY-700);
                      
                  }
               imagebrush.drawImage(tile, i-mapmovex, theY, null);
              realpos[index]=new Tilexy();
              realpos[index].setTilex(i-mapmovex);
              realpos[index].setTiley(theY);
              index++;
//              Yinc=Yinc+60;
//              indexend=index;
//              index=0;
                   i+=50;
          }                            
          else if (i==0)
          {
             for(int z=0;z<=500;)
             {
                imagebrush.setColor(Color.green);
               imagebrush.drawImage(tile,i-mapmovex,theY-z,null);  
             
             realpos[index]=new Tilexy();
             realpos[index].setTilex((i-mapmovex));
             realpos[index].setTiley(theY-z);
             index++;   
             z+=50;
             }

                  i+=50;
          }
          else if(i>2000&&i<=2300)
          {
                imagebrush.drawImage(tile, i-mapmovex, theY-210, null);
             if(M2.alive&&i==2050)
             {
//                MonstersHaveBrainsToo(M1.monsterlegx1, M1.monsterlegy);
//                M1.movementindexManger();
                M2.setDrawx(i-mapmovex);
                M2.setDrawy(theY-210-M2.legsonfloorInc);
                
                M2.loadimages(imagebrush);
                
                imagebrush.setColor(Color.black);
               
                 
                 
                
              
                      }
//             if(i==2050)
//             {
//              imagebrush.drawOval(i-mapmovex, theY-210-M2.legsonfloorInc, 50, 50);   
//             }
             if(!M2.alive)//&&enteronetime2
             {
                
                 M2.setxDie(M2.whereidrawlegx);
                 M2.setYdie(theY-210-M2.legsonfloorInc);
//              M2.setDrawx(0);
//              M2.setDrawy(0);
//             enteronetime2=false;
              
             }
             else if(M2.alive==false)
                 
             {
              M2.setxDie(M2.whereidrawlegx);
               M2.setYdie(theY-210-M2.legsonfloorInc);
             }
             
             
             
             
//              tilespos[i][theY+50]=tile;
              realpos[index]=new Tilexy();
              realpos[index].setTilex(i-mapmovex);
              realpos[index].setTiley(theY-210);
              index++;
//              indexend=index;
//              index=0;
                   i+=50;
             
//              
//              }
             
              
          }
          else if (i==0)
          {
             for(int z=0;z<=500;)
             {
                imagebrush.setColor(Color.green);
               imagebrush.drawImage(tile,i-mapmovex,theY-z,null);  
             
             realpos[index]=new Tilexy();
             realpos[index].setTilex((i-mapmovex));
             realpos[index].setTiley(theY-z);
             index++;   
             z+=50;
             }

                  i+=50;
          }
          else
          
          {
              if(i!=200)
              {
                
                  if(i==400)
                  {
                      Font trb = new Font("TimesRoman", Font.BOLD, 36);
               imagebrush.setColor(Color.black );
               imagebrush.setFont(trb);
                  if(textnumbershow==1)
                  {
                    imagebrush.drawString("Use (ARROWS) to move", i-mapmovex-100 , theY-700);   
                  }
                  }
                   if(i==500)
                   {
                       Font trb = new Font("TimesRoman", Font.BOLD, 36);
                     imagebrush.setColor(Color.black );
                     imagebrush.setFont(trb);
                     if(textnumbershow==4)
                  {
                    imagebrush.drawString("Some monsters will be harder to kill with that dagger", i-mapmovex-100 , theY-700);   
                  }  
                   }
                  if(i==600)
                  {
                      Font trb = new Font("TimesRoman", Font.BOLD, 36);
               imagebrush.setColor(Color.black );
               imagebrush.setFont(trb);
                  if(textnumbershow==2)
                  {
                    imagebrush.drawString("Pick up the dagger and press (S)!!", i-mapmovex-100 , theY-700);   
                  }
                  if(textnumbershow==3)
                  {
                     imagebrush.drawString("Now use it to kill the monster", i-mapmovex-100 , theY-700);    
                  }
                  
                  }
                   if(i==850)
                   {
                       
                   if(Dagger.daggerpickedup==false)
                   {
                     imagebrush.drawImage(Dagger.frameright, i-mapmovex, theY-60, null);
//                    imagebrush.drawRect(i-mapmovex+10, theY-60, 135, 58);
                       Dagger.daggerxplace=i-mapmovex+10;
                       Dagger.daggeryplace=theY-60;   
                   }
                   
                   }
                   if(i==1400)
                   {
                    if(Weapons.firebreathpickedup==false)
                   {
                    imagebrush.drawImage(Weapons.FireBreathright[2], i-mapmovex-260,theY-120, null) ;  
                    imagebrush.drawRect(i-mapmovex+70, theY-80, 70, 70);  
                    Weapons.frameplacex=i-mapmovex+70;
                    Weapons.frameplacey=theY-80;
                    
                   }   
                   }
                   
                  imagebrush.setColor(Color.green);
               imagebrush.drawImage(tile,i-mapmovex,theY,null);  
             
             realpos[index]=new Tilexy();
             realpos[index].setTilex((i-mapmovex));
             realpos[index].setTiley(theY);
             index++;
//                 leh = new Tilexy();
//                 leh.setTilex(i-mapmovex);
//                realpos.add(leh);
                  i+=50;
                
                
              }
              else
              {
               i=i+200;   
              }
              

          }
          
      }
       indexend=index;
              index=0;
                 MonstersHaveBrainsToo(M1.monsterlegx1, M1.monsterlegy,M1);
                                       M1.movementindexManger();
                  MonstersHaveBrainsToo(M2.monsterlegx1, M2.monsterlegy,M2);
                                        M2.movementindexManger();

                      
        }
        if(level==2)
        {
            if(enteronetime5==true)
            {
             enteronetime5=false;
             mapmovex=0;
            }
            Yinc=60;
            
            for(int i=0;i<=5000;){
                
                
                if(i==1300)
                {
//                
                     if(Dagger.daggerpickedup==false)
                   {
                     imagebrush.drawImage(Dagger.frameright, i-mapmovex, theY-60, null);
//                    imagebrush.drawRect(i-mapmovex+10, theY-60, 135, 58);
                       Dagger.daggerxplace=i-mapmovex+10;
                       Dagger.daggeryplace=theY-60;   
                   }
                }
                if(i==900)
                {
                   
                    
                   
                    
                     if(M3.alive&&i==900)
             {
//                MonstersHaveBrainsToo(M1.monsterlegx1, M1.monsterlegy);
//                M1.movementindexManger();
                M3.setDrawx(i-mapmovex);
                M3.setDrawy(theY-M3.legsonfloorInc);
                
                M3.loadimages(imagebrush);
                
                imagebrush.setColor(Color.black);
               
                 
                 
                
              
                      }
            
             if(!M3.alive)//&&enteronetime2
             {
                 M3.setxDie(M3.whereidrawlegx);
                 M3.setYdie(theY-M3.legsonfloorInc);
//              M2.setDrawx(0);
//              M2.setDrawy(0);
//             enteronetime2=false;
              
             }
//             else if(M3.alive==false)
//                 
//             {
//              M3.setxDie(M3.whereidrawlegx);
//               M3.setYdie(theY-210-M3.legsonfloorInc);
//             }
             imagebrush.setColor(Color.green);
               imagebrush.drawImage(tile,i-mapmovex,theY,null);  
             
             realpos[index]=new Tilexy();
             realpos[index].setTilex((i-mapmovex));
             realpos[index].setTiley(theY);
             index++;
//                 leh = new Tilexy();
//                 leh.setTilex(i-mapmovex);
//                realpos.add(leh);
                  i+=50;
                }
                else if (i>4000&&i<=5000)
                 {
                   imagebrush.drawImage(tile,i-mapmovex,theY,null);  
                   
                   if(i==4400)
                   {
                   
                       Font trb = new Font("TimesRoman", Font.BOLD, 36);
                     imagebrush.setColor(Color.black );
                     imagebrush.setFont(trb);
                     if(textnumbershow==10)
                  {
                    imagebrush.drawString("Killing THE BOSS will respawn the victory portal", i-mapmovex-100 , theY-700);   
                  }  
                     
                   }
                   
                    if (i==5000)
                 {
                    if(!M5.alive==true) 
                    { imagebrush.drawImage(gate, i-mapmovex, theY-350, null);
//            imagebrush.drawRect(i-mapmovex+35,theY-350 , 10, 350);
            gateend=i-mapmovex+35;
           
                    }
                 }
                    if(M5.alive&&i==4400)
             {
//                MonstersHaveBrainsToo(M1.monsterlegx1, M1.monsterlegy);
//                M1.movementindexManger();
                M5.setDrawx(i-mapmovex);
                M5.setDrawy(theY-M5.legsonfloorInc);
                
                M5.loadimages(imagebrush);
                      }
            
             if(!M5.alive)//&&enteronetime2
             {
                 M5.setxDie(M5.whereidrawlegx);
                 M5.setYdie(theY-M5.legsonfloorInc);
//              M2.setDrawx(0);
//              M2.setDrawy(0);
//             enteronetime2=false;
              
             }
                   
             
             realpos[index]=new Tilexy();
             realpos[index].setTilex((i-mapmovex));
             realpos[index].setTiley(theY);
             index++;
             i+=50;
                }
                else if(i==3000&&easteregg)
                {
                     imagebrush.drawImage(tile,i-mapmovex,theY-360,null);  
             
             realpos[index]=new Tilexy();
             realpos[index].setTilex((i-mapmovex));
             realpos[index].setTiley(theY-360);
             index++;
             i+=50;
                }
                else if(i>3000&&i<=4000)
                {
         
                    
              if(i==3050&&easteregg)
              {
               for(int z=50;z<300;)   
               {
                   imagebrush.drawImage(tile,i-mapmovex,theY-z,null); 
                    realpos[index]=new Tilexy();
             realpos[index].setTilex((i-mapmovex));
             realpos[index].setTiley(theY-z);
             index++;
             z+=50;
               }
              }
              imagebrush.drawImage(tile,i-mapmovex,theY,null);  
             
             realpos[index]=new Tilexy();
             realpos[index].setTilex((i-mapmovex));
             realpos[index].setTiley(theY);
             index++;
             if((i>3100&&i<3800)||easteregg)
             {
                 imagebrush.drawImage(tile,i-mapmovex,theY-360,null);  
                 if(i==3400)
                 {
                     
                            Font trb = new Font("TimesRoman", Font.BOLD, 36);
               imagebrush.setColor(Color.black );
               imagebrush.setFont(trb);
                  if(textnumbershow==9)
                  {
                    imagebrush.drawString("It might be a good idea to get that fire breath somehow", i-mapmovex-100 , theY-700);   
                   
                  }   
                 }
                 if(i==3200)
                    {
                      if(Weapons.firebreathpickedup==false)
                   {
                    imagebrush.drawImage(Weapons.FireBreathright[2], i-mapmovex-260,theY-120-360, null) ;  
//                    imagebrush.drawRect(i-mapmovex+70, theY-80-360, 70, 70);  
                    Weapons.frameplacex=i-mapmovex+70;
                    Weapons.frameplacey=theY-80-360;
                    
                   }        
                    }
                     
                       if(M4.alive&&i==3150)
             {
//                MonstersHaveBrainsToo(M1.monsterlegx1, M1.monsterlegy);
//                M1.movementindexManger();
                M4.setDrawx(i-mapmovex);
                M4.setDrawy(theY-360-M4.legsonfloorInc);
                M4.loadimages(imagebrush);
                
                imagebrush.setColor(Color.black);
               
                 
                 
                
              
                      }
             if(!M4.alive)//&&enteronetime
             {
                 M4.setxDie(M4.whereidrawlegx);
                 M4.setYdie(M4.drawy);
//              M1.setDrawx(0);
//              M1.setDrawy(0);
//              enteronetime=false;
              
             }
             if(!M4.alive)
             {
              M4.setxDie(M4.whereidrawlegx);
              M4.setDrawy(M4.drawy);
             }
             
                      
             
             realpos[index]=new Tilexy();
             realpos[index].setTilex((i-mapmovex));
             realpos[index].setTiley(theY-360);
             index++;   
             }
             if(i==4000&&easteregg)
             {
                for(int z=50;z<300;)   
               {
                   imagebrush.drawImage(tile,i-mapmovex,theY-z,null); 
                    realpos[index]=new Tilexy();
             realpos[index].setTilex((i-mapmovex));
             realpos[index].setTiley(theY-z);
             index++;
             z+=50;
               }
             }
           if(i==4000)
           {
            i+=250;   
           }
           else{i+=50;
               
           }
                }
                else if(i>2300&&i<=3000)
                {
                    if(i==2950&&easteregg)
                    {
                               imagebrush.drawImage(tile,i-mapmovex,theY,null);  
             
             realpos[index]=new Tilexy();
             realpos[index].setTilex((i-mapmovex));
             realpos[index].setTiley(theY);
             index++;
             
                      imagebrush.drawImage(tile,i-mapmovex,theY-360,null);  
             
             realpos[index]=new Tilexy();
             realpos[index].setTilex((i-mapmovex));
             realpos[index].setTiley(theY-360);
             index++;
             
                    }
                    
                    imagebrush.drawImage(tile, i-mapmovex, theY-Yinc, null);
                    
              realpos[index]=new Tilexy();
              realpos[index].setTilex(i-mapmovex);
              realpos[index].setTiley(theY-Yinc);
              index++;
              Yinc=Yinc-60;
//              indexend=index;
//              index=0;
                  if(i>2800)
                  {
                   i+=100;   
                  }
                  else{i+=200;}
              
                }
                 else if(i>1600&&i<=2300)
          {
              
                    if (i==1850)
                    {
                         Font trb = new Font("TimesRoman", Font.BOLD, 36);
               imagebrush.setColor(Color.black );
               imagebrush.setFont(trb);
                  if(textnumbershow==9)
                  {
                   imagebrush.drawString("Don't fall now", i-mapmovex-100, theY-700);
                  }
                    }
              imagebrush.drawImage(tile, i-mapmovex, theY-Yinc, null);
              realpos[index]=new Tilexy();
              realpos[index].setTilex(i-mapmovex);
              realpos[index].setTiley(theY-Yinc);
              index++;
              Yinc=Yinc+60;
//              indexend=index;
//              index=0;
                   i+=200;
              
          }
                
                else 
                {
                    
                    
                    if (i==400)
                    {
                         Font trb = new Font("TimesRoman", Font.BOLD, 36);
               imagebrush.setColor(Color.black );
               imagebrush.setFont(trb);
                  if(textnumbershow==7)
                  {
                    imagebrush.drawString("Now we need to know how to dodge", i-mapmovex-100 , theY-700);   
                    if(shownextone==true)
                    {
                        imagebrush.drawString("Jump to dodge the enemy hit", i-mapmovex-100 , theY-650);   
                    }
                  }
                        
                    }
                 
              
                  imagebrush.setColor(Color.green);
               imagebrush.drawImage(tile,i-mapmovex,theY,null);  
             
             realpos[index]=new Tilexy();
             realpos[index].setTilex((i-mapmovex));
             realpos[index].setTiley(theY);
             index++;
//                 leh = new Tilexy();
//                 leh.setTilex(i-mapmovex);
//                realpos.add(leh);
                  i+=50;
                
                
                 
               }
               
            
                
                
            }
             indexend=index;
                index=0;
                MonstersHaveBrainsToo(M3.monsterlegx1, M3.monsterlegy,M3);
                                       M3.movementindexManger();
                MonstersHaveBrainsToo(M4.monsterlegx1, M4.monsterlegy,M4);
                                      M4.movementindexManger();
                MonstersHaveBrainsToo(M5.monsterlegx1, M5.monsterlegy,M5);
                                      M5.movementindexManger();
        }
    
    }
    public void drawbackground(Graphics imagebrush)
    {
     imagebrush.drawImage(background, 0, 0, null);
    }

    public void mapmove(String Movee)
    {
     if(Movee.equalsIgnoreCase("RIGHT"))
     {
      mapmovex=mapmovex+20;
     }
     if(Movee.equalsIgnoreCase("LEFT"))
     {
      mapmovex=mapmovex-20;
     }
    }
    
    public boolean istheretile(Knight k)
    {
          int xInc;
          int yInc;
                for (int i=0;i<indexend;i++)
        {
           xInc=0;
           yInc=0;
           boolean flag=true;
            
            
           for(int b=0; b<=50;b++)
           {
//               if(realpos[i].getTilex()==460)//tester
//               {
//                   System.out.println("OverHere");   
//               }
               if(i==16)//tester
               {
//                   System.out.println("OverHere");   
               }
               try {
                    if(flag==true)
                    {
                        xInc=realpos[i].getTilex();
                        yInc=realpos[i].getTiley();
                        flag=false;
                    }
//                    if(b==20)//tester
//                    {
//                        System.out.println("AmHereTany");   
//                    }
//                   
                if(((realpos[i].getTilex()==k.knightleftleg)||((xInc)==k.knightleftleg-b)||(xInc==k.knightrightleg-b))&&(k.y+300==realpos[i].getTiley()))//x=480
                {
                   
//                   
//                      System.out.println("I had real pos of "+(xInc-b)+" At Index "+i+" Knight's leg was at "+(350+130
//System.out.println("I had leg's y of "+(y+300)+"Tiles were at "+realpos[i].getTiley());
                 return true;
                  
                
                }
               } catch (Exception e) {
                   System.out.println("I wat Couldnt Check Index No."+(i));
               }
           }
           
        }
//                System.out.println("WATCH OUT NO TILE");
        return false;
    }
    
     public boolean MonstersHaveBrainsToo(int x ,int y,Monster M)
    {
          int xInc;
          int yInc;
          boolean true1=false;
          boolean true2=false;
                for (int i=0;i<indexend;i++){
        
           xInc=0;
           yInc=0;
           boolean flag=true;
            
            
           for(int b=0; b<=50;b++)
           {
//               if(realpos[i].getTilex()==460)//tester
//               {
//                   System.out.println("OverHere");   
//               }
               if(i==16)//tester
               {
//                   System.out.println("OverHere");   
               }
               try {
                    if(flag==true)
                    {
                        xInc=realpos[i].getTilex();
                        yInc=realpos[i].getTiley();
                        flag=false;
                    }
//                    if(b==20)//tester
//                    {
//                        System.out.println("AmHereTany");   
//                    }
//                        if(i==20)
//                        {
//                            System.out.println("AmHere");   
//                        }
//                  
                       
                if(((realpos[i].getTilex()==M.monsterlegx1+M.movmentIndex)||(((xInc)==M.monsterlegx1+M.movmentIndex-b)||(xInc==M.monsterlegx2+M.movmentIndex-b)))&&((M.drawy+M.legsonfloorInc)==(realpos[i].getTiley())))//x=480
                {
//                   
                    if((realpos[i].getTilex()==M.monsterlegx1+M.movmentIndex))
                    return true;
                    if(((xInc)==M.monsterlegx1+M.movmentIndex-b)||true1==true)
                    {true1=true;
                     if((xInc==M.monsterlegx2+M.movmentIndex-b))   
                     {
                      return  true;
                     }
                     if((xInc==M.monsterlegx2+M.movmentIndex-b)||true2==true)//true 1 and 2 is a bad example of how to keep both his legs in the ground
                     {true2=true;
                      if((xInc)==M.monsterlegx1+M.movmentIndex-b)
                      {
                       return true;   
                      }
                     }
                    }
                   
                   
//                   
//                      System.out.println("I had real pos of "+(xInc-b)+" At Index "+i+" Knight's leg was at "+(350+130
//System.out.println("I had leg's y of "+(y+300)+"Tiles were at "+realpos[i].getTiley());
//                 M1.changedirction=true;
                  
                
                }
                
               } catch (Exception e) {
                   System.out.println("I watOfMobs Couldnt Check Index No."+(i));
               }
           }
           
        }
                   
                    
                        M.flippinggate=!M.flippinggate;
                        return false;
                
//        return false;
    }
     public boolean isLevelCleared(Knight k)
     {
         if(k.knightrightleg>gateend)
         {
          return true;   
         }
         else {return false;}
     }
    public boolean CheckBlocked(Knight k)
    {
      int xInc;
          int yInc;
                for (int i=0;i<indexend;i++)
        {
           xInc=0;
           yInc=0;
           boolean flag=true;
            
            
           for(int b=0; b<=50;b++)
           {
//               if(realpos[i].getTilex()==460)//tester
//               {
//                   System.out.println("OverHere");   
//               }
               if(i==16)//tester
               {
//                   System.out.println("OverHere");   
               }
               try {
                    if(flag==true)
                    {
                        xInc=realpos[i].getTilex();
                        yInc=realpos[i].getTiley();
                        flag=false;
                    }
//                    if(b==20)//tester
//                    {
//                        System.out.println("AmHereTany");   
//                    }
//                   
                if(((realpos[i].getTilex()==350+130)||((xInc)==k.knightleftleg-b)||(xInc==k.knightrightleg-b))&&(((k.y+300)>realpos[i].getTiley())&&(((k.knighttophead)<realpos[i].getTiley())||(k.knighttophead)<(realpos[i].getTiley()+50))))//x=480
                {
                   
                   
//                      System.out.println("I had real pos of "+(xInc-b)+" At Index "+i+" Knight's leg was at "+(350+130));
                      System.out.println("Blocked");
                 return true;
                  
                
                }
               } catch (Exception e) {
                   System.out.println("I watwat Couldnt Check Index No."+(i));
               }
           }
           
    }
                return false;
    }
//        for(Tilexy t :realpos)
//        {
//           for(int b =35;b>=0;b--)  
//           {
//               if(t.getTilex()==x)
//               {
//                return true;   
//               }
//           }
//        }
//        return false;
    
//        for (int i=0;i<endtilesindex;i++)
//        {
//            
//           for(int b=35; b>0;b--)
//           {
//                if(realpos[i].getTilex()==x);
//                {
//                 return true;
//                
//                }
//           }
//           
//        }
//        return false;
    }
        
//        for(int i =x;i>(x-35);i--)
//            
//        {
//            if(tilesonscreen[i ][theY]!=null);
//            {
//               return true;
//              
//                
//            }
//           
//        }
//        return false;
       
        
        
   

