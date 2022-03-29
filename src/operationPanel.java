package calculator;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;

class operationPanel extends JPanel
{


	public operationPanel(screen s)
	{

		var o = new char[]{'c', 'r'};

		setLayout(new GridLayout(2,1));
		setBackground(new Color(127,127,0));

		for(int i=0; i<o.length; i++)
		{


			var b=new button(String.valueOf(o[i]),s);
			add(b);


		}


	}


}


