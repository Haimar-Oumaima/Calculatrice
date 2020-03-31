public class MyMemoryButton extends Button implements ActionListener{

	MyCalculator cl;  
	  
MyMemoryButton(int x,int y, int width,int height,String cap, MyCalculator clc)  
{  
super(cap);  
setBounds(x,y,width,height);  
this.cl=clc;  
this.cl.add(this);  
addActionListener(this);  
}  
public MyMemoryButton(int tempX, int y, int wIDTH, int hEIGHT, String cap, MyCalculator clc) {
	// TODO Auto-generated constructor stub
}
public void actionPerformed(ActionEvent ev)  
{  
char memop=((MyMemoryButton)ev.getSource()).getLabel().charAt(1);  

cl.setClear=true;  
double temp=Double.parseDouble(cl.displayLabel.getText());  

switch(memop)  
{  
case 'C':   
cl.memLabel.setText(" ");cl.memValue=0.0;break;  
case 'R':   
cl.displayLabel.setText(MyCalculator.getFormattedText(cl.memValue));break;  
case 'S':  
cl.memValue=0.0;  
case '+':   
cl.memValue+=Double.parseDouble(cl.displayLabel.getText());  
if(cl.displayLabel.getText().equals("0") || cl.displayLabel.getText().equals("0.0")  )  
cl.memLabel.setText(" ");  
else   
cl.memLabel.setText("M");     
break;  
} 
} 
} 
