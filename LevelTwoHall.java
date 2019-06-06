import javax.swing.JPanel;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

/**
 * @author James Houle and Juan Diego Castano
 * @version 1 06.02.19
 */
public class LevelTwoHall extends JPanel implements ActionListener, KeyListener {
  
  Images sprite;
  Images friendSprite;
  Images background;
  
  SpringLayout layout;
  
  int x,y,dx,dy;
  Timer timer = new Timer (5, this);
  
  MenuButton menuButton;
  
  public LevelTwoHall (){
    
    sprite = new Images ("AlexSmile.png",200,200);
    //friendSprite = new Images (
    background = new Images ("LevelTwoHall.png",8000,750);
    
    x = 0;
    y = -120;
    dx = 0;
    dy = 0;
    
    menuButton = new MenuButton (135,40);
    
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
    
    layout.putConstraint (layout.EAST, menuButton, -25, layout.EAST, this);
    layout.putConstraint (layout.NORTH, menuButton, 10, layout.NORTH, this);
    add (menuButton);
    
    layout.putConstraint (layout.WEST, background, -x, layout.WEST, this);
    layout.putConstraint (layout.SOUTH, background, 0, layout.SOUTH, this);
    add (background);
    
    update ();
  }
  
  public void actionPerformed (ActionEvent e){
    
   // if (x > 2500)
   //   System.out.println (x);
    
    update ();
    x += dx;
    y += dy;
    repaint ();
  }
  
  public void keyPressed (KeyEvent e){
    int c = e.getKeyCode();
    if (c == KeyEvent.VK_LEFT || c == KeyEvent.VK_A) {
      dx = -3;
    }
    if (c == KeyEvent.VK_RIGHT || c == KeyEvent.VK_D){
      dx = 3;
    }
    if (c == KeyEvent.VK_E && x >= 0 && x <= 150){
      menuButton.setPath (5);
    }
    if (c == KeyEvent.VK_E && x >=1730 && x <= 1950){
      menuButton.setPath (9);
    }
    if (c == KeyEvent.VK_E && x >=3140 && x <= 3370){
      menuButton.setPath (10);
    }
    
  }
  
  public void keyTyped (KeyEvent e){}
  
  public void keyReleased (KeyEvent e){
    if (dy == 0)
      dx = 0;
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
  
  //temp
  public static void main (String [] args){
    new AnxiousAlex ();
  }
}