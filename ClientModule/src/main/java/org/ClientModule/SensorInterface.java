package org.ClientModule;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Panel;
import javax.swing.JTextPane;

public class SensorInterface extends JFrame implements ActionListener {
	private JTextField textLocation;
	private JTextField textName;
	private JTextField textType;
	private JTextField textState;
	
	public SensorInterface() {
		getContentPane().setBackground(new Color(0, 128, 128));
		getContentPane().setLayout(null);
		
		textLocation = new JTextField();
		textLocation.setBackground(new Color(240, 248, 255));
		textLocation.setBounds(341, 300, 202, 47);
		add(textLocation);
		textLocation.setColumns(10);
		
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBackground(new Color(240, 248, 255));
		textName.setBounds(341, 369, 202, 47);
		add(textName);
		
		textType = new JTextField();
		textType.setColumns(10);
		textType.setBackground(new Color(240, 248, 255));
		textType.setBounds(341, 438, 202, 47);
		add(textType);
		
		textState = new JTextField();
		textState.setColumns(10);
		textState.setBackground(new Color(240, 248, 255));
		textState.setBounds(341, 506, 202, 47);
		add(textState);
		
		JButton buttonSubmit = new JButton("SUBMIT");
		buttonSubmit.setForeground(new Color(47, 79, 79));
		buttonSubmit.setFont(new Font("Sitka Heading", Font.PLAIN, 18));
		buttonSubmit.setBackground(new Color(240, 248, 255));
		buttonSubmit.setBounds(638, 405, 132, 47);
		add(buttonSubmit);
		buttonSubmit.addActionListener(this);
		
		JTextPane txtpnLocation = new JTextPane();
		txtpnLocation.setForeground(new Color(240, 248, 255));
		txtpnLocation.setBackground(new Color(0, 128, 128));
		txtpnLocation.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		txtpnLocation.setText("Location :");
		txtpnLocation.setBounds(160, 306, 171, 41);
		add(txtpnLocation);
		
		JTextPane txtpnSensorName = new JTextPane();
		txtpnSensorName.setText("Sensor Name :");
		txtpnSensorName.setForeground(new Color(240, 248, 255));
		txtpnSensorName.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		txtpnSensorName.setBackground(new Color(0, 128, 128));
		txtpnSensorName.setBounds(160, 375, 171, 41);
		add(txtpnSensorName);
		
		JTextPane txtpnSensorType = new JTextPane();
		txtpnSensorType.setText("Sensor Type  :");
		txtpnSensorType.setForeground(new Color(240, 248, 255));
		txtpnSensorType.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		txtpnSensorType.setBackground(new Color(0, 128, 128));
		txtpnSensorType.setBounds(160, 444, 171, 41);
		add(txtpnSensorType);
		
		JTextPane txtpnStateOn = new JTextPane();
		txtpnStateOn.setText("State (ON /OFF):");
		txtpnStateOn.setForeground(new Color(240, 248, 255));
		txtpnStateOn.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		txtpnStateOn.setBackground(new Color(0, 128, 128));
		txtpnStateOn.setBounds(160, 512, 171, 41);
		add(txtpnStateOn);
		
		JTextPane txtpnEhpadServices = new JTextPane();
		txtpnEhpadServices.setFont(new Font("Sitka Text", Font.BOLD, 40));
		txtpnEhpadServices.setText("Ehpad Services");
		txtpnEhpadServices.setBackground(new Color(0, 128, 128));
		txtpnEhpadServices.setForeground(new Color(240, 248, 255));
		txtpnEhpadServices.setBounds(273, 117, 496, 88);
		add(txtpnEhpadServices);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(this);
	    resize(1000, 800);
	    
		
	}

	public void actionPerformed(ActionEvent e) {
		
		BackEnd instance = new BackEnd(textLocation.getText(),textName.getText(), textType.getText(), textState.getText());
		instance.start();
		
	}
	public static void main(String[] args)
	{
		new SensorInterface();
	}
	
	
	
	
}
