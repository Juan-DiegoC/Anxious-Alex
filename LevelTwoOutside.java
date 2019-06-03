import javax.swing.JPanel;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

/**
 * 
 * @author James Houle and Juan Diego Castano
 * @version 1 05.30.19
 */ 
public class LevelTwoOutside extends JPanel implements ActionListener, KeyListener {

  Images sprite;
  Images background;
  Images brotherSprite;
  Images friendSprite;
  SpringLayout layout;
  int x,y,dx,dy;
  CustomButton path;
  Timer timer = new Timer(5,this);
  
  public LevelTwoOutside () { //maybe add the ability for the player to come back outside??
    
    sprite = new Images ("AlexSmile.png",200,200);
    background = new Images ("OutsideSchoolV1.png",2500,750);
    brotherSprite = new Images ("BigBrother.png",210,200);
    //friendSprite = new Images ("Friend.png",200,200); need to create friend sprite
    path = new CustomButton ();
    
    x = 0;
    y = -40;
    dx = 0;
    dy = 0;
    
    //This code is taken from https://www.youtube.com/watch?v=Km81XyczqC4
    timer.start ();
    addKeyListener(this);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);
    //End of source code
    
    layout = new SpringLayout ();
    setLayout (layout);
        
    layout.putConstraint (layout.WEST, sprite, 280, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, sprite, y, layout.SOUTH, this);
    add (sprite);
    
    layout.putConstraint (layout.WEST, background, -x, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, background, 0, layout.SOUTH, this);
    add (background);
    
    update ();
  }
  
  public void actionPerformed (ActionEvent e){
    if (x < 0){
      x = 0;
      dx = 0;
    }
    if (x > 1200){
      x = 1200;
      dx = 0;
    } 
    //defines the jump motion
    if (x < 300){
      if (y < -240){
        y = -240;
        dy = 2;
      }
      if (y > -40){
        y = -40;
        dy = 0;
      }
      if (dy == 0)
        y = -40;
    }
    //first step
    if (x >= 300 && x <= 370 && y <= -80){
      if (y < -280){
        y = -280;
        dy = 2;
      }
      if (y > -80){
        y = -80;
        dy = 0;
      }
      if (dy == 0)
        y = -80;
    }
    //blocks the player from walking through the second step
   /* if (x > 370 && y > -120){
      x = 370;
      dy = 0;
    }*/
    
    //top platform
    if (x >= 370){
      if (y < -320){
        dy = 2;
        y = -320;
      }
      if (y > -120){
        dy = 0;
        y = -120;
      }
    }
    
    update ();
    x += dx;
    y += dy;
    repaint ();
  }
  
  public void update (){
    
    layout.putConstraint (layout.WEST, sprite, 280, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, sprite, y, layout.SOUTH, this);
    
    layout.putConstraint (layout.WEST, background, -x, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, background, 0, layout.SOUTH, this);
    
    refresh ();
  }
  
  public void refresh (){
    repaint ();
    revalidate ();
  }
  
  @Override
  public void keyPressed (KeyEvent e){ //put override?
    
    int c = e.getKeyCode();
    if (c == KeyEvent.VK_LEFT || c == KeyEvent.VK_A) {
      dx = -3;
    }
    if (c == KeyEvent.VK_RIGHT || c == KeyEvent.VK_D){
      dx = 3;
    }
    if ((c == KeyEvent.VK_UP || c == KeyEvent.VK_W) && (y == -40 || y == -80)){
      dy = -2;
    }
    if (c == KeyEvent.VK_E && x >= 985 && x <= 1200){
      path.setPath (8);
    }
    
    update ();
  }
  
  public void keyTyped (KeyEvent e){} //put override?
  
  public void keyReleased (KeyEvent e){ //put override?
    if (dy == 0)
      dx = 0;
  }
  
  //temp
  public static void main (String [] args){
    new AnxiousAlex ();
  }
}
  
  
    
  
  
  
  