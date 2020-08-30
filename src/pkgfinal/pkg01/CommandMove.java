/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkgfinal.pkg01;

import java.awt.event.KeyEvent;
/**
 *
 * @author leno
 */
public class CommandMove 
{
    boolean [] PressedKeys;

    public CommandMove() 
    {
        PressedKeys = new boolean[8];
        
    }
    
    private int AsCiToIndex (int code)
    {
        switch(code)
        {
            case KeyEvent.VK_UP:
                 return 0;
                
            case KeyEvent.VK_C:
                return 1;
            case KeyEvent.VK_LEFT:
                 return 2;
            case KeyEvent.VK_RIGHT:
                 return 3;
//            case KeyEvent.VK_W:
//                 return 4;
//            case KeyEvent.VK_A:
//                 return 5;
            case KeyEvent.VK_S:
                 return 6;
            case KeyEvent.VK_D:
                 return 7;  
            default:
                return -1;
        }
                
        
        
    }
    public void SetKeyState(int AsCi , boolean state)
    {
        int index =AsCiToIndex(AsCi);
     if(index !=-1)
     {
         PressedKeys[index]=state;
     }
        
    }
    public boolean GetKeyState(int AsCi)
    {
        int index =AsCiToIndex(AsCi);
     if(index !=-1)
     {
        return PressedKeys[index];
     }
     return false;//3ashan el code yrun bas.. i think.
        
    }
    
   
    
    
    
    
}
