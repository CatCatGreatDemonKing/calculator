import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;
import java.math.BigDecimal;

public class c{


	public static void main(String[] arg)
	{


		var sc = new Scanner(System.in);
		
		while(sc.hasNextLine())
		{


			var text = sc.nextLine();

			if(text.equals("exit")){System.exit(0);}

			if(filter(text))
			{

				System.out.println("calculate: "+text);
				BigDecimal r = calculates(text.toCharArray());

				System.out.println("result: "+r);	


			}
			else{System.out.println("input error.");}


		}


	}

	/**
		@param cs "([\\+\\-\\%]??)(\\d+)([\\+\\-\\*\\/\\%]+?)(\\d+)"
	*/
	private static BigDecimal calculates(char[] cs)
	{

		BigDecimal r=new BigDecimal("303");

		var o = new int[2];//operation's index

		for(int i=0; i<cs.length; i++)
		{


			char c = cs[i];

			if(i==0&&(c=='+'||c=='-'||c=='%')) o[0]=i;

			if(i!=0&&(c=='+'||c=='-'||c=='%'||c=='*')) o[1]=i;


		}
	
		BigDecimal n1 = new BigDecimal(String.valueOf(cs, (o[0]==0?0:1), o[1]-o[0]));	
		BigDecimal n2 = new BigDecimal(String.valueOf(cs, o[1]+1, (cs.length-(o[1]+1))));	
	
		switch(cs[o[1]])
		{


			case '+':
				r=n1.add(n2);
				break;		
			case '-':
				r=n1.subtract(n2);
				break;
			case '*':
				r=n1.multiply(n2);
				break;	
			case '%':
				var dandr = n1.divideAndRemainder(n2);
				r=dandr[1];
				break;
			case '/':
				var dandr1= n1.divideAndRemainder(n2);
				r=dandr1[0];
				break;


		}
	
		return r;


	}

	private static boolean filter(String s)
	{


		//将一个字符串编译为Pattern 对象
		Pattern p = Pattern.compile("([\\+\\-\\%]??)(\\d+)(\\.??)(\\d*?)([\\+\\-\\*\\/\\%]+?)(\\d+)(\\.??)(\\d*?)");
		
		//使用Pattern对象创建Matcher对象
		Matcher m = p.matcher(s);
		boolean b = m.matches();

		return b;


	}	


}
