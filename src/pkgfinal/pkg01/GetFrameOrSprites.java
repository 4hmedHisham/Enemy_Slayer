 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.pkg01;

/**
 *
 * @author leno
 */
public class GetFrameOrSprites {
    
    protected int x;
    protected int y;
    static protected int frameindex;
    static protected int monsterframeindex;
    public GetFrameOrSprites(int x, int y) {
        
        this.x=x;
        this.y=y;
        
    }
    public void nextframe(int incX,int incY)
    {
        x=x+incX;
        y=y+incY;
        
    }
    public void resetFrameindex(int a ,int b)
            
    {
        x=a;
        y=b;
    }
    
    
}
