package calculator;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Font;
class numberPanel extends JPanel
{


	public numberPanel(screen s)
	{


		int rows=4;
		int cols=3;

		setBackground(new Color(0,0,127));
		setLayout(new GridLayout(rows, cols));

		String bT;//button's text
			
		for(int i=0; i<rows*cols; i++)
		{

			bT=String.valueOf(i);
			switch(i)
			{

				case 10:
					bT = "00";
					break;

				case 11:
					bT = "000";
					break;


			}
		
			var b=new button(bT,s);
			b.setBackground(new Color(60,100,100));
			add(b);


		}


	}


}

