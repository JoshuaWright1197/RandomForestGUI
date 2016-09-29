package ForestGUI;

import java.awt.*;
import javax.swing.*;
import java.math.*;

public class ForestGUI extends JFrame
{
	private final int difx = 60;
	private final int dify = 90;
	private final Color carray[] = {Color.red ,Color.orange ,Color.yellow,Color.green,Color.cyan,Color.blue,Color.MAGENTA};
	private Color brwon;
	private int xpoints[];
	private int ypoints[];
	private int npoints;
	
	public ForestGUI()
	{
		super("Forset");
		setSize(500,600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);  
		setResizable(false);
		
		Draw d = new Draw();

		this.add(d);
		
		setVisible(true);
	}
	
	private class Draw extends Canvas
	{
		
		private void doForest (Graphics g , int forestx ,int foresty, int treenum , Color array[])
		{
			for(int i = 0;i <treenum;i++)
			{
				int x = (int) (1l + Math.random()* (forestx -1));
				int y = (int) (1 + Math.random()* (foresty -1));
				int r = (int) (0 + Math.random()* (7 -0));
				tree(g, x,y,array[r]);	
			}	
		}
		
		private void tree( Graphics g ,int x , int y , Color c)
		{
			xpoints = new int[]{(x + difx/2)  , x, x + difx};
		    ypoints = new int[]{y, y+dify, y+dify};
		    npoints = 3;
		    brwon = new Color(169, 104, 54);
		    
		    g.setColor(c);
		    g.fillPolygon(xpoints, ypoints, npoints);
		    
		    g.setColor(Color.black);
		    g.drawPolygon(xpoints, ypoints, npoints);
		    
		    g.setColor(brwon);
		    g.fillRect(x + difx/3, y+dify, 20, 30);	
		    
		    g.setColor(Color.black);
		    g.drawRect(x + difx/3, y+dify, 20, 30);	
		}
		
		@Override
		public void paint( Graphics g)
	    {
			doForest(g,400,400 ,40,carray);
	    }	
	}
	
	
	public static void main(String[] args)
	{
	    ForestGUI frame = new ForestGUI();
	}
}