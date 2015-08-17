package ClcultorThree;

import java.awt.BorderLayout;//����߽�ֲ���������
import java.awt.GridLayout;//��������ֲ���������
import java.awt.TextField;//�����ı�����
import java.awt.event.*;
import javax.swing.*;

/**
*����ʵ���˼򵥼��������룬�߱��Ӽ��˳������ҹ��ܣ�ּ����ש����
*��Ϥjava��ͬѧ�������ڴ˻�����ʵ�ָ����ӵĹ���
*@author Liyingfan
*/

public class CalculatorThree{
	//�½������ڹ��캯���н��г�ʼ��
	JFrame frame;//�½��������
	JButton buttonzero,buttondot,buttonequal;//�½���ť��0������.����=��
	JButton buttonplus,buttonminus,buttonmultiple,buttondevision,buttonsin,buttontozero;//�½���ť+-*/�͹��㰴ť
	JButton buttonone,buttontwo,buttonthree,buttonfour,buttonfive,buttonsix,buttonseven,buttoneight,buttonnine;//�½����ְ�ť1234567890
	JPanel panelwest,panelcenter,paneleast;//�½��������
	TextField tf;//�½��ı��������
	public CalculatorThree(){
		//��ʼ������
		tf = new TextField(30);//������ı��ֶΣ��ַ����Ϊ30
		frame = new JFrame("CalculatorThree");//���㴰���������ΪCalculatorThree
		panelcenter = new JPanel();//������壬�ŵ���������
		panelwest = new JPanel();//������壬�ŵ���������
		paneleast = new JPanel();//������壬�ŵ����嶫��
		
		Handle h = new Handle();//�½�Handle����� Handle��Ϊ�¼�������
		//�������ְ�ť����1��2��3��4��5��6��7��8��9
		buttonone = new JButton("1");
		buttontwo = new JButton("2");
		buttonthree =new JButton("3");
		buttonfour = new JButton("4");
		buttonfive = new JButton("5");
		buttonsix = new JButton("6");
		buttonseven = new JButton("7");
		buttoneight = new JButton("8");
		buttonnine = new JButton("9");
		panelcenter.setLayout(new GridLayout(3,3));//������岼��Ϊ���񲼾֣���������
		//�����ְ�ť��ӵ��м����
		panelcenter.add(buttonone);
		panelcenter.add(buttontwo);
		panelcenter.add(buttonthree);
		panelcenter.add(buttonfour);
		panelcenter.add(buttonfive);
		panelcenter.add(buttonsix);
		panelcenter.add(buttonseven);
		panelcenter.add(buttoneight);
		panelcenter.add(buttonnine);
		//Ϊʮ����ťע���¼�������
		buttonone.addActionListener(h);
		buttontwo.addActionListener(h);
		buttonthree.addActionListener(h);
		buttonfour.addActionListener(h);
		buttonfive.addActionListener(h);
		buttonsix.addActionListener(h);
		buttonseven.addActionListener(h);
		buttoneight.addActionListener(h);
		buttonnine.addActionListener(h);
		
		//���찴ť��0����.����=����ע���¼�������������1��3�в��֣���ӵ����ߵ����
		buttonzero = new JButton("0");
		buttondot = new JButton(".");
		buttonequal = new JButton("=");
		buttonzero.addActionListener(h);
		buttondot.addActionListener(h);
		buttonequal.addActionListener(h);
		panelwest.add(buttonzero);
		panelwest.add(buttondot);
		panelwest.add(buttonequal);
		//���������ť��+����-����*����/����sin����>0�������С�>0"Ϊ���㰴ť
		buttonplus = new JButton("+");
		buttonminus = new JButton("-");
		buttonmultiple = new JButton("*");
		buttondevision = new JButton("/");
		buttonsin = new JButton("sin");
		buttontozero = new JButton(">0");
		paneleast.setLayout(new GridLayout(3,1));//�������ߵĲ���Ϊ3��1��
		//��������ť��+����-����*����/����sin����>����ӵ����ߵ������
		paneleast.add(buttonplus);
		paneleast.add(buttonminus);
		paneleast.add(buttonmultiple);
		paneleast.add(buttondevision);
		paneleast.add(buttonsin);
		paneleast.add(buttontozero);
		//Ϊ������ť��+����-����*����/����sin����.0��ע�������
		buttonplus.addActionListener(h);
		buttonminus.addActionListener(h);
		buttonmultiple.addActionListener(h);
		buttondevision.addActionListener(h);
		buttonsin.addActionListener(h);
		buttontozero.addActionListener(h);
		
		frame.setLayout(new BorderLayout());//���ô���Ϊ���沼��
		frame.add(paneleast,"East");//���������paneleast��ӵ�����Ķ���
		frame.add(tf, BorderLayout.NORTH);//��tf�ı�����ӵ�����ı��ߣ�������
		frame.add(panelwest, BorderLayout.WEST);//��panelwest�����ӵ���������
		frame.add(panelcenter, BorderLayout.CENTER);//��panelcenter�����ӵ������м�
		frame.pack();//���ô����С���ʺ������������ѡ��С�Ͳ���
		frame.setLocation(500, 500);//���ô�����ʾλ��Ϊ��500��500��
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ò��ִ���Ĭ�Ϲرշ�ʽ
		frame.setVisible(true);//���ô���ɼ�
	}
	public static void main(String[] args){
		new CalculatorThree();//���������½�����
	}
	class Handle implements ActionListener{//ʵ�ֶ�����������
		int biaozhi = 0;
		double flag1 =0,flag2 = 0,flag3 = 0;//flag1��flag2Ϊ�����������flag3Ϊ���
		@Override
		public void actionPerformed(ActionEvent e){  //������д
			try{//�˴����ܻ�����쳣����try��catch��׽�쳣�����ô���
				if(e.getSource()==buttondot)//С����
					tf.setText("0");
				if(e.getSource()==buttontozero){//�������
					tf.setText("");
				}
				if(e.getSource()==buttonzero){//����0����
					tf.setText(tf.getText()+"0");
					flag1=Double.parseDouble(tf.getText());//���ı�����ת����double����
				}
				if(e.getSource()==buttonone){//����1����
					tf.setText(tf.getText()+"1");
					flag1=Double.parseDouble(tf.getText());
				}
				if(e.getSource()==buttontwo){//����2����
					tf.setText(tf.getText()+"2");
					flag1=Double.parseDouble(tf.getText());
				}
				if(e.getSource()==buttonthree){//����3����
					tf.setText(tf.getText()+"3");
					flag1=Double.parseDouble(tf.getText());
				}
				if(e.getSource()==buttonfour){//����4����
					tf.setText(tf.getText()+"4");
					flag1=Double.parseDouble(tf.getText());
				}
				if(e.getSource()==buttonfive){//����5����
					tf.setText(tf.getText()+"5");
					flag1=Double.parseDouble(tf.getText());
				}
				if(e.getSource()==buttonsix){//����6����
					tf.setText(tf.getText()+"6");
					flag1=Double.parseDouble(tf.getText());
				}
				if(e.getSource()==buttonseven){//����7����
					tf.setText(tf.getText()+"7");
					flag1=Double.parseDouble(tf.getText());
				}
				if(e.getSource()==buttoneight){//����8����
					tf.setText(tf.getText()+"8");
					flag1=Double.parseDouble(tf.getText());
				}
				if(e.getSource()==buttonnine){//����9����
					tf.setText(tf.getText()+"9");
					flag1=Double.parseDouble(tf.getText());
				}
				if(e.getSource()==buttonplus){//�ӷ�����
					tf.setText("");
					flag2 = flag1;
					biaozhi = 0;
				}
				if(e.getSource()==buttonminus){//��������
					tf.setText("");
					flag2 = flag1;
					biaozhi = 1;
				}
				if(e.getSource()==buttonmultiple){//�˷�����
					tf.setText("");
					flag2 = flag1;
					biaozhi = 2;
				}
				if(e.getSource()==buttondevision){//��������
					tf.setText("");
					flag2 = flag1;
					biaozhi = 3;
				}
				if(e.getSource()==buttonsin){//���Ҳ���
					flag3 = Math.sin(flag1);
					tf.setText(flag3+"");
				}
				if(e.getSource()==buttonequal){//�ȺŲ���������biaozhi�жϽ�����Ӧ�Ӽ��˳�����
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