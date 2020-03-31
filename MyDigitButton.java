public class MyDigitButton extends Button implements ActionListene {
	{  
		MaCalculatrice cl;  
		  
		MyDigitButton(int x,int y, int width,int height,String cap, MyCalculator clc)  
		{  
		super(cap);  
		setBounds(x,y,width,height);  
		this.cl=clc;  
		this.cl.add(this);  
		addActionListener(this);  
		}  
		
		
		static boolean isInString(String s, char ch)  
		{  
		for(int i=0; i<s.length();i++) if(s.charAt(i)==ch) return true;  
		return false;  
		}  
		
		
		public void actionPerformed(ActionEvent ev)  
		{  
		String tempText=((MyDigitButton)ev.getSource()).getLabel();  
		  
		if(tempText.equals("."))  
		{  
		 if(cl.setClear)   
		    {cl.displayLabel.setText("0.");cl.setClear=false;}  
		 else if(!isInString(cl.displayLabel.getText(),'.'))  
		    cl.displayLabel.setText(cl.displayLabel.getText()+".");  
		 return;  
		}  
		  
		int index=0;  
		try{  
		        index=Integer.parseInt(tempText);  
		    }catch(NumberFormatException e){return;}  
		  
		if (index==0 && cl.displayLabel.getText().equals("0")) return;  
		  
		if(cl.setClear)  
		            {cl.displayLabel.setText(""+index);cl.setClear=false;}  
		else  
		    cl.displayLabel.setText(cl.displayLabel.getText()+index);  
		} 
		}   

}
