package calculator;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class button extends JButton
{


	public button(String bT,screen s)//button's text
	{


		super(bT);

		setFont(new Font("SERIF", Font.PLAIN, 32));
		setBackground(new Color(60,100,100));

		addActionListener(new buttonListener(this,s));


	}


}


