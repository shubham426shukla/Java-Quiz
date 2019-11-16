/*Online Java Paper Test*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;

class OnlineTest extends JFrame implements ActionListener
{

    
        JLabel l;
	JRadioButton jb[]=new JRadioButton[5];
	JButton b1,b2;
	ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0;int Money=0;
	int m[]=new int[10];	
	OnlineTest(String s)
	{
		super(s);
		l=new JLabel();
		add(l);
		bg=new ButtonGroup();
		for(int i=0;i<5;i++)
		{
			jb[i]=new JRadioButton();	
			add(jb[i]);
			bg.add(jb[i]);
		}
		b1=new JButton("Next");
		b2=new JButton("Bookmark");
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(b1);add(b2);
		set();
		l.setBounds(30,40,450,20);
		jb[0].setBounds(50,80,100,20);
		jb[1].setBounds(50,110,100,20);
		jb[2].setBounds(50,140,100,20);
		jb[3].setBounds(50,170,100,20);
		b1.setBounds(100,240,100,30);
		b2.setBounds(270,240,100,30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250,100);
		setVisible(true);
		setSize(1000,650);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			if(check())
				count=count+1;
			current++;
			set();	
			if(current==9)
			{
				b1.setEnabled(false);
				b2.setText("Result");
			}
		}
		if(e.getActionCommand().equals("Bookmark"))
		{
			JButton bk=new JButton("Bookmark"+x);
			bk.setBounds(480,20+30*x,100,30);
			add(bk);
			bk.addActionListener(this);
			m[x]=current;
			x++;
			current++;
			set();	
			if(current==9)
				b2.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for(int i=0,y=1;i<x;i++,y++)
		{
		if(e.getActionCommand().equals("Bookmark"+y))
		{
			if(check())
				count=count+1;
			now=current;
			current=m[y];
			set();
			((JButton)e.getSource()).setEnabled(false);
			current=now;
		}
		}
	
		if(e.getActionCommand().equals("Result"))
		{
			if(check()){
				count=count+1;Money+=10;}
			current++;

			//System.out.println("correct ans="+count);
			JOptionPane.showMessageDialog(this,"correct ans="+count);
                        if(count>=5)
                         { 
                           JOptionPane.showMessageDialog(this,"YOU HAVE SUCCESFULLY PASSED THE QUIZ");
                          JOptionPane.showMessageDialog(this,"WELCOME TO MANIPAL UNIVERSITY");

                          }     

                        else
                            {
                               JOptionPane.showMessageDialog(this,"SORRY YOU HAVE FAILED BETTER LUCK NEXT TIME");
                              }
                           
                          



			System.exit(0);
		}
	}
	void set()
	{
		jb[4].setSelected(true);
		if(current==0)
		{
			l.setText("Que1: Which of these can be used to fully abstract a class from its implementation");
			jb[0].setText("object");jb[1].setText("Package");jb[2].setText("Interface");jb[3].setText("NONE");	
		}
		if(current==1)
		{
			l.setText("Que2: Which class is available to all the class automatically");
			jb[0].setText("Swing");jb[1].setText("Applet");jb[2].setText("Object");jb[3].setText("ActionEvent");
		}
		if(current==2)
		{
			l.setText("Que3:  Which of these access specifiers can be used for an interface?");
			jb[0].setText("public");jb[1].setText("private");jb[2].setText("protected");jb[3].setText("NONE");
		}
		if(current==3)
		{
			l.setText("Que4: String class is defined in which package");
			jb[0].setText("lang");jb[1].setText("Swing");jb[2].setText("Applet");jb[3].setText("awt");
		}
		if(current==4)
		{
			l.setText("Que5:  Literal can be of which of these data types?");
			jb[0].setText("integer");jb[1].setText("float");jb[2].setText("boolean");jb[3].setText("all of the above");
		}
		if(current==5)
		{
			l.setText("Que6: Which one among these is not a keyword");
			jb[0].setText("class");jb[1].setText("int");jb[2].setText("so");jb[3].setText("if");
		}
		if(current==6)
		{
			l.setText("Que7:What is the prototype of the default constructor");
			jb[0].setText("Test()");jb[1].setText("Test(void)");jb[2].setText("public Test()");jb[3].setText("NONE");
		}
		if(current==7)
		{
			l.setText("Que8: which one among these is not a function of Object class");
			jb[0].setText("toString");jb[1].setText("finalize");jb[2].setText("equals");jb[3].setText("getDocumentBase");		
		}
		if(current==8)
		{
			l.setText("Que9: Which of these values can a boolean variable contain?");
			jb[0].setText("0 & 1");jb[1].setText("True or False");jb[2].setText("-1");jb[3].setText("NONE");
		}
		if(current==9)
		{
			l.setText("Que10:  Which of these coding types is used for data type characters in Java?");
			jb[0].setText("Ascii");jb[1].setText("Isco-Latin 1");jb[2].setText("UNICODE");jb[3].setText("NONE");
		}
		l.setBounds(30,40,450,20);
		for(int i=0,j=0;i<=90;i+=30,j++)
			jb[j].setBounds(50,80+i,200,20);
	}
	boolean check()
	{
		if(current==0)
			return(jb[2].isSelected());
		if(current==1)
			return(jb[2].isSelected());
		if(current==2)
			return(jb[0].isSelected());
		if(current==3)
			return(jb[0].isSelected());
		if(current==4)
			return(jb[3].isSelected());
		if(current==5)
			return(jb[2].isSelected());
		if(current==6)
			return(jb[2].isSelected());
		if(current==7)
			return(jb[3].isSelected());
		if(current==8)
			return(jb[1].isSelected());
		if(current==9)
			return(jb[2].isSelected());
		return false;
	} 
	public static void main(String s[])
	{
		new OnlineTest("JAVA QUIZ FOR ENTRANCE EXAM IN MUJ JAVA SUBJECT");
	}


}
