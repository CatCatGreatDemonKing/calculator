package calculator;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;

class arithmeticPanel extends JPanel
{


	public arithmeticPanel(screen s)
	{

		int rows=5;
		int cols=1;
		var a =new String[]{"+","-","*","/","%"};

		setLayout(new GridLayout(rows,cols));
		setBackground(new Color(0,127,0));

		for(int i =0; i<rows*cols; i++)
		{


			var b = new button(a[i],s);
			add(b);


		}


	}


}


