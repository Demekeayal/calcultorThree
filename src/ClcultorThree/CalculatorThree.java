package ClcultorThree;

import java.awt.BorderLayout;//导入边界局部管理器类
import java.awt.GridLayout;//导入网格局部管理器类
import java.awt.TextField;//导入文本域类
import java.awt.event.*;
import javax.swing.*;

/**
*本例实现了简单计算器代码，具备加减乘除和正弦功能，旨在抛砖引玉。
*熟悉java的同学，可以在此基础上实现更复杂的功能
*@author Liyingfan
*/

public class CalculatorThree{
	//新建对象，在构造函数中进行初始化
	JFrame frame;//新建窗体对象
	JButton buttonzero,buttondot,buttonequal;//新建按钮“0”，“.”“=”
	JButton buttonplus,buttonminus,buttonmultiple,buttondevision,buttonsin,buttontozero;//新建按钮+-*/和归零按钮
	JButton buttonone,buttontwo,buttonthree,buttonfour,buttonfive,buttonsix,buttonseven,buttoneight,buttonnine;//新建数字按钮1234567890
	JPanel panelwest,panelcenter,paneleast;//新建三个面板
	TextField tf;//新建文本区域对象
	public CalculatorThree(){
		//初始化对象
		tf = new TextField(30);//构造空文本字段，字符宽度为30
		frame = new JFrame("CalculatorThree");//搞糟窗体对象，名称为CalculatorThree
		panelcenter = new JPanel();//构造面板，放到窗体中央
		panelwest = new JPanel();//构造面板，放到窗体西边
		paneleast = new JPanel();//构造面板，放到窗体东边
		
		Handle h = new Handle();//新建Handle类对象， Handle类为事件监听类
		//创建数字按钮对象，1、2、3、4、5、6、7、8、9
		buttonone = new JButton("1");
		buttontwo = new JButton("2");
		buttonthree =new JButton("3");
		buttonfour = new JButton("4");
		buttonfive = new JButton("5");
		buttonsix = new JButton("6");
		buttonseven = new JButton("7");
		buttoneight = new JButton("8");
		buttonnine = new JButton("9");
		panelcenter.setLayout(new GridLayout(3,3));//设置面板布局为网格布局，三行三列
		//将数字按钮添加到中间面板
		panelcenter.add(buttonone);
		panelcenter.add(buttontwo);
		panelcenter.add(buttonthree);
		panelcenter.add(buttonfour);
		panelcenter.add(buttonfive);
		panelcenter.add(buttonsix);
		panelcenter.add(buttonseven);
		panelcenter.add(buttoneight);
		panelcenter.add(buttonnine);
		//为十个按钮注册事件监听器
		buttonone.addActionListener(h);
		buttontwo.addActionListener(h);
		buttonthree.addActionListener(h);
		buttonfour.addActionListener(h);
		buttonfive.addActionListener(h);
		buttonsix.addActionListener(h);
		buttonseven.addActionListener(h);
		buttoneight.addActionListener(h);
		buttonnine.addActionListener(h);
		
		//构造按钮“0”“.”“=”，注册事件监听器，设置1行3列布局，添加到西边的面板
		buttonzero = new JButton("0");
		buttondot = new JButton(".");
		buttonequal = new JButton("=");
		buttonzero.addActionListener(h);
		buttondot.addActionListener(h);
		buttonequal.addActionListener(h);
		panelwest.add(buttonzero);
		panelwest.add(buttondot);
		panelwest.add(buttonequal);
		//构造操作按钮“+”“-”“*”“/”“sin”“>0”，其中“>0"为归零按钮
		buttonplus = new JButton("+");
		buttonminus = new JButton("-");
		buttonmultiple = new JButton("*");
		buttondevision = new JButton("/");
		buttonsin = new JButton("sin");
		buttontozero = new JButton(">0");
		paneleast.setLayout(new GridLayout(3,1));//设置西边的布局为3行1列
		//将操作按钮“+”“-”“*”“/”“sin”“>”添加到西边的面板中
		paneleast.add(buttonplus);
		paneleast.add(buttonminus);
		paneleast.add(buttonmultiple);
		paneleast.add(buttondevision);
		paneleast.add(buttonsin);
		paneleast.add(buttontozero);
		//为操作按钮“+”“-”“*”“/”“sin”“.0”注册监听器
		buttonplus.addActionListener(h);
		buttonminus.addActionListener(h);
		buttonmultiple.addActionListener(h);
		buttondevision.addActionListener(h);
		buttonsin.addActionListener(h);
		buttontozero.addActionListener(h);
		
		frame.setLayout(new BorderLayout());//设置窗体为界面布局
		frame.add(paneleast,"East");//将东边面板paneleast添加到窗体的东边
		frame.add(tf, BorderLayout.NORTH);//将tf文本区添加到窗体的北边，即顶部
		frame.add(panelwest, BorderLayout.WEST);//将panelwest面板添加到窗体西边
		frame.add(panelcenter, BorderLayout.CENTER);//将panelcenter面板添加到窗体中间
		frame.pack();//设置窗体大小，适合其子组件的首选大小和布局
		frame.setLocation(500, 500);//设置窗体显示位置为（500，500）
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置布局窗体默认关闭方式
		frame.setVisible(true);//设置窗体可见
	}
	public static void main(String[] args){
		new CalculatorThree();//主方法中新建对象
	}
	class Handle implements ActionListener{//实现动作监听器类
		int biaozhi = 0;
		double flag1 =0,flag2 = 0,flag3 = 0;//flag1、flag2为另个操作数，flag3为结果
		@Override
		public void actionPerformed(ActionEvent e){  //方法重写
			try{//此处可能会产生异常，用try、catch捕捉异常，不用处理
				if(e.getSource()==buttondot)//小数点
					tf.setText("0");
				if(e.getSource()==buttontozero){//归零操作
					tf.setText("");
				}
				if(e.getSource()==buttonzero){//按键0操作
					tf.setText(tf.getText()+"0");
					flag1=Double.parseDouble(tf.getText());//将文本区域转换成double类型
				}
				if(e.getSource()==buttonone){//按键1操作
					tf.setText(tf.getText()+"1");
					flag1=Double.parseDouble(tf.getText());
				}
				if(e.getSource()==buttontwo){//按键2操作
					tf.setText(tf.getText()+"2");
					flag1=Double.parseDouble(tf.getText());
				}
				if(e.getSource()==buttonthree){//按键3操作
					tf.setText(tf.getText()+"3");
					flag1=Double.parseDouble(tf.getText());
				}
				if(e.getSource()==buttonfour){//按键4操作
					tf.setText(tf.getText()+"4");
					flag1=Double.parseDouble(tf.getText());
				}
				if(e.getSource()==buttonfive){//按键5操作
					tf.setText(tf.getText()+"5");
					flag1=Double.parseDouble(tf.getText());
				}
				if(e.getSource()==buttonsix){//按键6操作
					tf.setText(tf.getText()+"6");
					flag1=Double.parseDouble(tf.getText());
				}
				if(e.getSource()==buttonseven){//按键7操作
					tf.setText(tf.getText()+"7");
					flag1=Double.parseDouble(tf.getText());
				}
				if(e.getSource()==buttoneight){//按键8操作
					tf.setText(tf.getText()+"8");
					flag1=Double.parseDouble(tf.getText());
				}
				if(e.getSource()==buttonnine){//按键9操作
					tf.setText(tf.getText()+"9");
					flag1=Double.parseDouble(tf.getText());
				}
				if(e.getSource()==buttonplus){//加法操作
					tf.setText("");
					flag2 = flag1;
					biaozhi = 0;
				}
				if(e.getSource()==buttonminus){//减法操作
					tf.setText("");
					flag2 = flag1;
					biaozhi = 1;
				}
				if(e.getSource()==buttonmultiple){//乘法操作
					tf.setText("");
					flag2 = flag1;
					biaozhi = 2;
				}
				if(e.getSource()==buttondevision){//除法操作
					tf.setText("");
					flag2 = flag1;
					biaozhi = 3;
				}
				if(e.getSource()==buttonsin){//正弦操作
					flag3 = Math.sin(flag1);
					tf.setText(flag3+"");
				}
				if(e.getSource()==buttonequal){//等号操作，利用biaozhi判断进行相应加减乘除操作
					if(biaozhi==0)
						flag3 = flag1 + flag2;
					if(biaozhi==1)
						flag3 = flag1 - flag2;
					if(biaozhi==2)
						flag3 = flag1 * flag2;
					if(biaozhi==3)
						flag3 = flag1 / flag2;
					tf.setText(flag3+"");
				}
			}
			catch(Exception ex){
				
			}
		}
	}
	
}