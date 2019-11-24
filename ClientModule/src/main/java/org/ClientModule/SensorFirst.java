package org.ClientModule;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Window;

public class SensorFirst extends JFrame implements ActionListener, WindowListener {
	
	JButton humidityL; 
	JButton smokeL;
	JButton humidityLIB;
	JButton smokeLIB;
	JButton humidity1;
	JButton humidity2;
	JButton humidity3;
	JButton smoke1;
	JButton smoke2;
	JButton smoke3;
	JButton smokeK;
	JButton humidityK;
	
	
	
	
	public SensorFirst() {
		getContentPane().setBackground(new Color(0, 128, 128));
		getContentPane().setLayout(null);
		
		JTextPane txtpnPlanDeLa = new JTextPane();
		txtpnPlanDeLa.setBackground(new Color(0, 128, 128));
		txtpnPlanDeLa.setForeground(new Color(255, 255, 255));
		txtpnPlanDeLa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnPlanDeLa.setText("PLAN DE LA RESIDENCE");
		txtpnPlanDeLa.setBounds(247, 11, 246, 31);
		getContentPane().add(txtpnPlanDeLa);
		
		JPanel panel = new JPanel();
		panel.setBounds(23, 79, 61, 58);
		getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(23, 138, 61, 58);
		getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(23, 197, 61, 58);
		getContentPane().add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(23, 257, 61, 58);
		getContentPane().add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(23, 317, 61, 58);
		getContentPane().add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(156, 79, 61, 58);
		getContentPane().add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(219, 79, 61, 58);
		getContentPane().add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(281, 79, 61, 58);
		getContentPane().add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(345, 79, 61, 58);
		getContentPane().add(panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(571, 79, 61, 58);
		getContentPane().add(panel_9);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBounds(571, 138, 61, 58);
		getContentPane().add(panel_10);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBounds(571, 197, 61, 58);
		getContentPane().add(panel_11);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBounds(571, 257, 61, 58);
		getContentPane().add(panel_12);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBounds(571, 317, 61, 58);
		getContentPane().add(panel_13);
		
		JPanel living = new JPanel();
		living.setBackground(new Color(188, 143, 143));
		living.setBounds(156, 257, 122, 118);
		getContentPane().add(living);
		living.setLayout(null);
		
		humidityL = new JButton("H");
		humidityL.setForeground(Color.BLACK);
		humidityL.setBackground(SystemColor.controlDkShadow);
		humidityL.setBounds(37, 32, 47, 23);
		humidityL.setVisible(false);
		living.add(humidityL);
		
	    smokeL = new JButton("F");
		smokeL.setForeground(Color.BLACK);
		smokeL.setBackground(SystemColor.controlDkShadow);
		smokeL.setBounds(37, 66, 47, 23);
		smokeL.setVisible(false);
		living.add(smokeL);
		
		JTextPane txtpnLivRoom = new JTextPane();
		txtpnLivRoom.setText("Living Room");
		txtpnLivRoom.setBackground(new Color(188, 143, 143));
		txtpnLivRoom.setBounds(0, 0, 122, 23);
		living.add(txtpnLivRoom);
		
		JPanel kitchen = new JPanel();
		kitchen.setBackground(new Color(222, 184, 135));
		kitchen.setBounds(281, 257, 61, 118);
		getContentPane().add(kitchen);
		kitchen.setLayout(null);
		
		 humidityK = new JButton("H");
		humidityK.setForeground(Color.BLACK);
		humidityK.setBackground(SystemColor.controlDkShadow);
		humidityK.setBounds(10, 34, 47, 23);
		humidityK.setVisible(false);
		kitchen.add(humidityK);
		
		 smokeK = new JButton("F");
		smokeK.setForeground(Color.BLACK);
		smokeK.setBackground(SystemColor.controlDkShadow);
		smokeK.setBounds(10, 66, 47, 23);
		smokeK.setVisible(false);
		kitchen.add(smokeK);
		
		JTextPane txtpnKitchen = new JTextPane();
		txtpnKitchen.setText("kitchen");
		txtpnKitchen.setBackground(new Color(222, 184, 135));
		txtpnKitchen.setBounds(0, 0, 61, 28);
		kitchen.add(txtpnKitchen);
		
		JPanel library = new JPanel();
		library.setBackground(new Color(205, 92, 92));
		library.setBounds(345, 257, 61, 118);
		getContentPane().add(library);
		library.setLayout(null);
		
		 humidityLIB = new JButton("H");
		humidityLIB.setForeground(Color.BLACK);
		humidityLIB.setBackground(SystemColor.controlDkShadow);
		humidityLIB.setBounds(10, 34, 47, 23);
		humidityLIB.setVisible(false);
		library.add(humidityLIB);
		
		 smokeLIB = new JButton("F");
		smokeLIB.setForeground(Color.BLACK);
		smokeLIB.setBackground(SystemColor.controlDkShadow);
		smokeLIB.setBounds(10, 68, 47, 23);
		smokeLIB.setVisible(false);
		library.add(smokeLIB);
		
		JTextPane txtpnLibrary = new JTextPane();
		txtpnLibrary.setText("library");
		txtpnLibrary.setBackground(new Color(205, 92, 92));
		txtpnLibrary.setBounds(0, 0, 57, 28);
		library.add(txtpnLibrary);
		
		JPanel corridor1 = new JPanel();
		corridor1.setBackground(new Color(255, 222, 173));
		corridor1.setBounds(86, 79, 67, 296);
		getContentPane().add(corridor1);
		corridor1.setLayout(null);
		
		 humidity1 = new JButton("H");
		humidity1.setForeground(new Color(0, 0, 0));
		humidity1.setBackground(new Color(105, 105, 105));
		humidity1.setBounds(10, 73, 47, 23);
		humidity1.setVisible(false);
		corridor1.add(humidity1);
		
		 smoke1 = new JButton("F");
		smoke1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		smoke1.setForeground(Color.BLACK);
		smoke1.setBackground(SystemColor.controlDkShadow);
		smoke1.setBounds(10, 174, 47, 23);
		smoke1.setVisible(false);
		corridor1.add(smoke1);
		
		JTextPane txtpnCorridor = new JTextPane();
		txtpnCorridor.setBackground(new Color(255, 222, 173));
		txtpnCorridor.setText("Corridor 1");
		txtpnCorridor.setBounds(10, 11, 47, 40);
		corridor1.add(txtpnCorridor);
		
		JPanel corridor3 = new JPanel();
		corridor3.setBackground(new Color(176, 224, 230));
		corridor3.setBounds(410, 79, 159, 296);
		getContentPane().add(corridor3);
		corridor3.setLayout(null);
		
		 humidity3 = new JButton("H");
		humidity3.setForeground(Color.BLACK);
		humidity3.setBackground(SystemColor.controlDkShadow);
		humidity3.setBounds(57, 65, 47, 23);
		humidity3.setVisible(false);
		corridor3.add(humidity3);
		
		 smoke3 = new JButton("F");
		smoke3.setForeground(Color.BLACK);
		smoke3.setBackground(SystemColor.controlDkShadow);
		smoke3.setBounds(57, 169, 47, 23);
		smoke3.setVisible(false);
		corridor3.add(smoke3);
		
		JTextPane txtpnCorridor_2 = new JTextPane();
		txtpnCorridor_2.setText("Corridor 3");
		txtpnCorridor_2.setBackground(new Color(176, 224, 230));
		txtpnCorridor_2.setBounds(57, 227, 47, 40);
		corridor3.add(txtpnCorridor_2);
		
		JPanel corridor2 = new JPanel();
		corridor2.setBackground(new Color(216, 191, 216));
		corridor2.setBounds(156, 138, 250, 117);
		getContentPane().add(corridor2);
		corridor2.setLayout(null);
		
		 humidity2 = new JButton("H");
		humidity2.setForeground(Color.BLACK);
		humidity2.setBackground(SystemColor.controlDkShadow);
		humidity2.setBounds(39, 48, 47, 23);
		humidity2.setVisible(false);
		corridor2.add(humidity2);
		
		 smoke2 = new JButton("F");
		smoke2.setForeground(Color.BLACK);
		smoke2.setBackground(SystemColor.controlDkShadow);
		smoke2.setBounds(146, 48, 47, 23);
		smoke2.setVisible(false);
		corridor2.add(smoke2);
		
		JTextPane txtpnCorridor_1 = new JTextPane();
		txtpnCorridor_1.setText("Corridor 2");
		txtpnCorridor_1.setBackground(new Color(216, 191, 216));
		txtpnCorridor_1.setBounds(96, 11, 47, 40);
		corridor2.add(txtpnCorridor_1);
		
		JTextPane txtpnHHumidity = new JTextPane();
		txtpnHHumidity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnHHumidity.setEditable(false);
		txtpnHHumidity.setForeground(new Color(255, 255, 255));
		txtpnHHumidity.setBackground(new Color(0, 128, 128));
		txtpnHHumidity.setText("H : humidity sensor / F : smoke sensor");
		txtpnHHumidity.setBounds(53, 408, 387, 58);
		getContentPane().add(txtpnHHumidity);
		
		JButton btnNewButton = new JButton("Ajouter / Modifier un capteur");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new SensorInterface();
				getFrame().dispose();
			}

			
		});
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(404, 443, 235, 38);
		getContentPane().add(btnNewButton);
		
		
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(this);
	    resize(1000, 800);
	}
	
	
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args)
	{
		new SensorFirst();
	}




	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	private Frame getFrame() {
		// TODO Auto-generated method stub
		return this;
	}


	@Override
	public void windowOpened(WindowEvent arg0) {
		
		
	}
}
