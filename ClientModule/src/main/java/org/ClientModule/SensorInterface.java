package org.ClientModule;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Panel;
import javax.swing.JTextPane;
import java.awt.Window.Type;

public class SensorInterface extends JPanel implements ActionListener {
	public static JTextField textLocation;
	public static JTextField textName;
	public static JTextField textType;
	public static JTextField textState;
	
	private JFrame frame ;
	public static String getTextLocation() {
		return textLocation.getText();
	}

	public void setTextLocation(JTextField textLocation) {
		this.textLocation = textLocation;
	}

	public static String getTextName() {
		return textName.getText();
	}

	public void setTextName(JTextField textName) {
		this.textName = textName;
	}

	public static String getTextType() {
		return textType.getText();
	}

	public void setTextType(JTextField textType) {
		this.textType = textType;
	}

	public static String getTextState() {
		return textState.getText();
	}

	public void setTextState(JTextField textState) {
		this.textState = textState;
	}

	public static JButton getButtonSubmit() {
		return buttonSubmit;
	}

	public void setButtonSubmit(JButton buttonSubmit) {
		this.buttonSubmit = buttonSubmit;
	}

	public static JButton getButtonRetour() {
		return buttonRetour;
	}

	public void setButtonRetour(JButton buttonRetour) {
		this.buttonRetour = buttonRetour;
	}

	public static JButton getButtonSupprimer() {
		return buttonSupprimer;
	}

	public void setButtonSupprimer(JButton buttonSupprimer) {
		this.buttonSupprimer = buttonSupprimer;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public BackEnd getSensorBack() {
		return sensorBack;
	}

	public void setSensorBack(BackEnd sensorBack) {
		this.sensorBack = sensorBack;
	}


	public static JButton buttonSubmit;
	public static JButton buttonRetour ;
	public static JButton buttonSupprimer;
	
	SensorFirst sensorFirst;
	
	
	public BackEnd sensorBack; 
	private JTextField Legende;
	
	public static void main(String[] args) {
		new Thread(new Runnable() {
			public void run() {


				try {

					SensorInterface window = new SensorInterface();
				    window.setVisible(true);
				



				} catch (Exception e) {
				e.printStackTrace();
				}
			}
		}).start();
	}
	
	public SensorInterface() {
		initialize();
	}
	
	public void initialize () {
		
		sensorBack = new BackEnd(this);
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 128));
		//frame.setType(Type.POPUP);
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		
		setBackground(new Color(0, 128, 128));
		setLayout(null);
		frame.getContentPane().setLayout(null);

		//final SensorFirst instance2 = new SensorFirst();
		textLocation = new JTextField();
		textLocation.setBackground(new Color(240, 248, 255));
		textLocation.setBounds(341, 300, 202, 47);
		frame.getContentPane().add(textLocation);
		textLocation.setColumns(10);

		textName = new JTextField();
		textName.setColumns(10);
		textName.setBackground(new Color(240, 248, 255));
		textName.setBounds(341, 369, 202, 47);
		frame.getContentPane().add(textName);

		textType = new JTextField();
		textType.setColumns(10);
		textType.setBackground(new Color(240, 248, 255));
		textType.setBounds(341, 438, 202, 47);
		frame.getContentPane().add(textType);

		textState = new JTextField();
		textState.setColumns(10);
		textState.setBackground(new Color(240, 248, 255));
		textState.setBounds(341, 506, 202, 47);
		frame.getContentPane().add(textState);

		 buttonSubmit = new JButton("SUBMIT");
		 buttonSubmit.setEnabled(true);
		buttonSubmit.setForeground(new Color(47, 79, 79));
		buttonSubmit.setFont(new Font("Sitka Heading", Font.PLAIN, 18));
		buttonSubmit.setBackground(new Color(240, 248, 255));
		buttonSubmit.setBounds(638, 405, 132, 47);
		frame.getContentPane().add(buttonSubmit);
		buttonSubmit.addActionListener(sensorBack);

//		 buttonRetour = new JButton("Retour");
//		buttonRetour.setForeground(new Color(47, 79, 79));
//		buttonRetour.setFont(new Font("Sitka Heading", Font.PLAIN, 18));
//		buttonRetour.setBackground(new Color(240, 248, 255));
//		buttonRetour.setBounds(638,505 , 132, 47);
//		frame.getContentPane().add(buttonRetour);
//		buttonRetour.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				
//				sensorFirst = new SensorFirst();
//							
//				sensorFirst.getFrame().setVisible(true);
//				  
//				  getFrame().dispose();
//			}
//
//			
//			
//		});
		
		 buttonSupprimer = new JButton("Supprimer");
		 buttonSupprimer.setEnabled(true);
		buttonSupprimer.setForeground(new Color(47, 79, 79));
		buttonSupprimer.setFont(new Font("Sitka Heading", Font.PLAIN, 18));
		buttonSupprimer.setBackground(new Color(240, 248, 255));
		buttonSupprimer.setBounds(638,605 , 132, 47);
		frame.getContentPane().add(buttonSupprimer);
		buttonSupprimer.addActionListener(sensorBack);

		JTextPane txtpnLocation = new JTextPane();
		txtpnLocation.setForeground(new Color(240, 248, 255));
		txtpnLocation.setBackground(new Color(0, 128, 128));
		txtpnLocation.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		txtpnLocation.setText("Location : ");
		txtpnLocation.setBounds(160, 306, 171, 41);
		frame.getContentPane().add(txtpnLocation);

		JTextPane txtpnSensorName = new JTextPane();
		txtpnSensorName.setEditable(false);
		txtpnSensorName.setText("Sensor Name :");
		txtpnSensorName.setForeground(new Color(240, 248, 255));
		txtpnSensorName.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		txtpnSensorName.setBackground(new Color(0, 128, 128));
		txtpnSensorName.setBounds(160, 375, 171, 41);
		frame.getContentPane().add(txtpnSensorName);

		JTextPane txtpnSensorType = new JTextPane();
		txtpnSensorType.setEditable(false);
		txtpnSensorType.setText("Sensor Type  :");
		txtpnSensorType.setForeground(new Color(240, 248, 255));
		txtpnSensorType.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		txtpnSensorType.setBackground(new Color(0, 128, 128));
		txtpnSensorType.setBounds(160, 444, 171, 41);
		frame.getContentPane().add(txtpnSensorType);

		JTextPane txtpnStateOn = new JTextPane();
		txtpnStateOn.setEditable(false);
		txtpnStateOn.setText("State : (ON /OFF / ALERTE)");
		txtpnStateOn.setForeground(new Color(240, 248, 255));
		txtpnStateOn.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		txtpnStateOn.setBackground(new Color(0, 128, 128));
		txtpnStateOn.setBounds(160, 512, 200, 100);
		frame.getContentPane().add(txtpnStateOn);
		
		Legende = new JTextField();
		Legende.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Legende.setEditable(false);
		Legende.setText("Location : Corridor1 / Corridor2/ Kitchen / LivingRoom / Library   Sensor Type : Smoke/Humidity/MOVEMENT   State : ON/OFF/ALERTE");
		Legende.setForeground(new Color(255, 255, 224));
		Legende.setBackground(new Color(0, 128, 128));
		Legende.setBounds(10, 119, 800, 150);
		frame.getContentPane().add(Legende);
		Legende.setColumns(10);
		Legende.setVisible(true);

		JTextPane txtpnEhpadServices = new JTextPane();
		txtpnEhpadServices.setEditable(false);
		txtpnEhpadServices.setText("         Ajouter/Supprimer un capteur");
		txtpnEhpadServices.setFont(new Font("Sitka Text", Font.BOLD, 40));
		txtpnEhpadServices.setBackground(new Color(0, 128, 128));
		txtpnEhpadServices.setForeground(Color.WHITE);
		txtpnEhpadServices.setBounds(0, 0, 790, 611);
		frame.getContentPane().add(txtpnEhpadServices);
		
		
		frame.setVisible(true);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(this);
		frame.resize(800, 1000);
		frame.setResizable(false);


	}
	
	
	public void actionPerformed(ActionEvent e) {



	}
}
