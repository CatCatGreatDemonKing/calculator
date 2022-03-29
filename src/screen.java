package calculator;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;

class screen extends JTextArea
{


	public screen(int rs, int cs)
	{



		super(rs,cs);
		setFont(new Font("SERIF", Font.BOLD, 24));
		setBackground(new Color(127,127,127));
		setEditable(false);
		setLineWrap(true);

/*
			addCaretListener(new CaretListener()
			{


				@Override public void caretUpdate(CaretEvent ce)
				{



				}
		

			});
*/			


	}


}

