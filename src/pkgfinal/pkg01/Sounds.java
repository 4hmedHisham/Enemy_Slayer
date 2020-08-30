/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.pkg01;


import sun.audio.*;
import sun.audio.ContinuousAudioDataStream;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

class Sounds
{
public  static void playSound() {
    try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Pics\\SoundItems\\hahaaa.wav").getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
        audioInputStream.close();
//        clip.close();
    } catch(Exception ex) {
        System.out.println("Error with playing sound.");
       
    }
}
public static void Death()
{
     try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Pics\\SoundItems\\DeathWacCut.wav").getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
        audioInputStream.close();
//        clip.close();
    } catch(Exception ex) {
        System.out.println("Error with playing sound.");
       
    }
    
}
public static void playfallingsound()
{
    try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Pics\\SoundItems\\M23.wav").getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
        audioInputStream.close();
//        clip.close();
    } catch(Exception ex) {
        System.out.println("Error with playing sound.");
       
    }
}
//********************************************************************************************************
public static void playHalloffame()
{
     try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Pics//SoundItems//fame.wav").getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
       
        
        clip.start();
        clip.loop(1000);
      
        audioInputStream.close();
//        clip.close();
    } catch(Exception ex) {
        System.out.println("Error with playing sound12.");
       
    }
}
public static void playstabsound()
{
    try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Pics\\SoundItems\\Stabb.wav").getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
        audioInputStream.close();
//        clip.close();
    } catch(Exception ex) {
        System.out.println("Error with playing sound.");
        System.out.println(ex.getMessage());
       
    }
}
    public static void playflamesound()
{
    try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Pics\\SoundItems\\fifth.wav").getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
        audioInputStream.close();
//        clip.close();
    } catch(Exception ex) {
        System.out.println("Error with playing sound.");
        System.out.println(ex.getMessage());
       
    }
}

public void PlayBackgoundSound()
{
     try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Pics\\SoundItems\\GM.wav").getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
                 clip.loop(1000);

        audioInputStream.close();
//        clip.close();
    } catch(Exception ex) {
        System.out.println("Error with playing sound.");
       
    }
}
}

/**
 *
 * @author leno
 */

    