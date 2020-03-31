public class MyOperatorButton extends Button implements ActionListener{

	MyCalculatrice cl;  
	  
	MyOperatorButton(int x,int y, int width,int height,String cap, MaCalculatrice clc)  
	{  
	super(cap);  
	setBounds(x,y,width,height);  
	this.cl=clc;  
	this.cl.add(this);  
	addActionListener(this);  
	}  
	
	public void actionPerformed(ActionEvent ev)  
	{  
	String opText=((MyOperatorButton)ev.getSource()).getLabel();  
	  
	cl.setClear=true;  
	double temp=Double.parseDouble(cl.displayLabel.getText());  
	  
	if(opText.equals("1/x"))  
	    {  
	    try  
	        {double tempd=1/(double)temp;  
	        cl.displayLabel.setText(MaCalculatrice.getFormattedText(tempd));}  
	    catch(ArithmeticException excp)  
	                        {cl.displayLabel.setText("Divide by 0.");}  
	    return;  
	    }  
	if(opText.equals("sqrt"))  
	    {  
	    try  
	        {double tempd=Math.sqrt(temp);  
	        cl.displayLabel.setText(MaCalculatrice.getFormattedText(tempd));}  
	            catch(ArithmeticException excp)  
	                    {cl.displayLabel.setText("Divide by 0.");}  
	    return;  
	    }  
	if(!opText.equals("="))  
	    {  
	    cl.number=temp;  
	    cl.op=opText.charAt(0);  
	    return;  
	    }  
	switch(cl.op)  
	{  
	case '+':  
	    temp+=cl.number;break;  
	case '-':  
	    temp=cl.number-temp;break;  
	case '*':  
	    temp*=cl.number;break;  
	case '%':  
	    try{temp=cl.number%temp;}  
	    catch(ArithmeticException excp)  
	        {cl.displayLabel.setText("Divide by 0."); return;}  
	    break;  
	case '/':  
	    try{temp=cl.number/temp;}  
	        catch(ArithmeticException excp)  
	                {cl.displayLabel.setText("Divide by 0."); return;}  
	    break;  
	}
	  
	cl.displayLabel.setText(MaCalculatrice.getFormattedText(temp));  
	cl.number=temp;  
	} 
	}
