package calculator;
import javax.swing.JFrame;
import java.awt.BorderLayout;

public class calculator extends JFrame
{

	/**
		create a calculator
	*/

	public calculator()
	{

		setLayout(new BorderLayout());
        
		int rows=5;
		int cols=20;
		screen s = new screen(rows,cols);
		add(s, BorderLayout.NORTH);

		numberPanel nP = new numberPanel(s);
		add(nP, BorderLayout.CENTER);

		arithmeticPanel aP = new arithmeticPanel(s);
		add(aP, BorderLayout.EAST);

		operationPanel oP = new operationPanel(s);
		add(oP, BorderLayout.WEST);

	}

	/**
		display calculator
	*/
	public void start()
	{


		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,600);
		setLocation(200,200);
		setVisible(true);
		setResizable(false);


	}


}
