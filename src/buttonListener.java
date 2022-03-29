package calculator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.math.BigDecimal;

class buttonListener implements ActionListener
{


	button b;
	screen s;

	public buttonListener(button b,screen s)
	{


		this.b=b;	
		this.s=s;	


	}

	/**
		set screen's Text when button pressed
	*/
	@Override public void actionPerformed(ActionEvent ae)
	{


		var bT = b.getText();//button's text
		var sT = s.getText();//screen's text
		System.out.println("button "+bT+" pressed");	
		System.out.println("screen's text:"+sT);	

		sT=process(sT,bT);

		s.setText(sT);


	}	

	/**
		form array{n1,n2,0} to calculates by n1on2(n1,n2,number,o,arithmetic
		@param cT will split to number and arithmetic  to calculate's Text
	*/
	public String arithmetic(String cT)
	{

	
		var rT=cT;//result's text
		var ns = cT.split("[^\\d]");
		var os = cT.split("[^\\+\\-\\*\\/\\%]");

		var O = "";
		var n1 = new BigDecimal("0") ;
		var n2 = new BigDecimal("0") ;
		var n3 = new BigDecimal("0") ;
		var n1n2o =new String[]{n1.toString(),n2.toString(),O};//number and arithmetic
		var n1n2oI = 0;//string array n1n2o 's index

		for(String n:ns)
		{	
			if(!n.equals("")) n1n2o[n1n2oI++]=n;
		}

		n1=new BigDecimal(n1n2o[0]);
		n2=new BigDecimal(n1n2o[1]);
		var os2 =new String[2];
		var os2I =0;

		for(String o:os)
		{
			if(!o.equals(""))
			{
				os2[os2I]=o;
				os2I++;
			}
		}

		if(os2[1]==null)
		{
			O=os2[0];
		}
		else
		{
			O=os2[1];
			n1=new BigDecimal(os2[0].concat(n1.toString()));//当前一个计算结果为负数时，将-号拼接
		}	
		
		switch(O)
		{


			case "+":
				n3=n1.add(n2);	
				break;
			case "-":
				n3=n1.subtract(n2);	
				break;
			case "*":
				n3=n1.multiply(n2);
				break;
			case "/":
				n3=(n2.toString().equals("0")?BigDecimal.ZERO:n1.divide(n2));
				break;
			case "%":
				n3=(n2.toString().equals("0")?BigDecimal.ZERO:(n1.divideAndRemainder(n2))[1]);
				break;


			}

			rT=n3.toString();
			System.out.printf("\nn1:%s\nn2:%s\nn3:%s\nO:%s\n",n1,n2,n3,O);

		return rT;


	}

	/**
		according to buttonText to process screeText
		@param sT screen'Text
		@param bT button'Text
	*/
	public String process(String sT, String bT)
	{

		var pT = sT;
		//bT == "c"||bT == "r"
		var ecb = bT.equals("c");//equals "c"'s boolean
		var erb = bT.equals("r");//equals "r"'s boolean
		if(ecb || erb) pT = (ecb?"":sT.substring(0, ((sT.length()==0)?0:sT.length()-1)));	

		//bT == (number or arithmetic)
		var format = "((\\-)?(\\d)([\\+\\-\\*\\/\\%]?))+";
		var tmp = (sT.contains("=")?sT.substring(sT.lastIndexOf("=")+1, sT.length()):sT)+bT;
		var p = Pattern.compile(format);
		var m = p.matcher(tmp);
		var formatOk = m.matches();

		if(formatOk)
		{
			var arithmeticFormat = "(\\-)?(\\d)+([\\+\\-\\*\\/\\%])(\\d)+([\\+\\-\\*\\/\\%])";

			p = Pattern.compile(arithmeticFormat);
			m = p.matcher(tmp);
			var arithmeticFormatOk = m.matches();
			if(arithmeticFormatOk)
			{
				pT=sT+"\n="+arithmetic(tmp.substring(0,tmp.length()-1))+bT;
			}
			else
			{
				pT=tmp;
			}
		}

			System.out.printf("\nsT:%s\n\npT:%s\nbT:%s\ntmp:%s\n",sT,pT,bT,tmp);
		return pT;


	}


}
