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
import javax.swing.UIManager;
import javax.swing.JTextField;

public class SensorFirst extends JFrame implements ActionListener, WindowListener {
	private JTextField txtDesCapteurs;
	
	
	SensorInterface sensor ;
	
	public SensorFirst() {
		getContentPane().setBackground(new Color(0, 128, 128));
		getContentPane().setLayout(null);
		
		JTextPane txtpnPlanDeLa = new JTextPane();
		txtpnPlanDeLa.setEditable(false);
		txtpnPlanDeLa.setBackground(new Color(0, 128, 128));
		txtpnPlanDeLa.setForeground(new Color(255, 255, 255));
		txtpnPlanDeLa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnPlanDeLa.setText("PLAN DE LA RESIDENCE");
		txtpnPlanDeLa.setBounds(247, 11, 246, 31);
		getContentPane().add(txtpnPlanDeLa);
		
		JPanel panel = new JPanel();
		panel.setBounds(460, 79, 88, 58);
		getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(396, 79, 73, 58);
		getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(94, 79, 61, 58);
		getContentPane().add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(94, 192, 61, 58);
		getContentPane().add(panel_3);
		
		JPanel panelLibrary = new JPanel();
		panelLibrary.setBackground(new Color(230, 230, 250));
		panelLibrary.setBounds(94, 250, 146, 67);
		getContentPane().add(panelLibrary);
		
		JTextPane txtpnLibrary_1 = new JTextPane();
		txtpnLibrary_1.setText("Library");
		txtpnLibrary_1.setBackground(new Color(230, 230, 250));
		panelLibrary.add(txtpnLibrary_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(144, 79, 73, 58);
		getContentPane().add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(217, 79, 61, 58);
		getContentPane().add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(269, 79, 73, 58);
		getContentPane().add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(333, 79, 73, 58);
		getContentPane().add(panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(533, 79, 61, 58);
		getContentPane().add(panel_9);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBounds(94, 136, 61, 58);
		getContentPane().add(panel_10);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBounds(533, 136, 61, 58);
		getContentPane().add(panel_11);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBounds(533, 192, 61, 58);
		getContentPane().add(panel_12);
		
		JPanel panelLivingRoom = new JPanel();
		panelLivingRoom.setBackground(UIManager.getColor("Button.shadow"));
		panelLivingRoom.setBounds(408, 250, 186, 125);
		getContentPane().add(panelLivingRoom);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("Living Room");
		textPane.setBackground(UIManager.getColor("Button.shadow"));
		panelLivingRoom.add(textPane);
		
		JPanel kitchen = new JPanel();
		kitchen.setBackground(new Color(222, 184, 135));
		kitchen.setBounds(94, 317, 146, 58);
		getContentPane().add(kitchen);
		kitchen.setLayout(null);
		
		JTextPane txtpnKitchen = new JTextPane();
		txtpnKitchen.setText("Kitchen");
		txtpnKitchen.setBackground(new Color(222, 184, 135));
		txtpnKitchen.setBounds(44, 0, 61, 28);
		kitchen.add(txtpnKitchen);
		
		JPanel panelCorridor2 = new JPanel();
		panelCorridor2.setBackground(new Color(255, 245, 238));
		panelCorridor2.setBounds(242, 250, 164, 125);
		getContentPane().add(panelCorridor2);
		panelCorridor2.setLayout(null);
		
		JTextPane txtpnLibrary = new JTextPane();
		txtpnLibrary.setText("Corridor 2");
		txtpnLibrary.setBackground(new Color(255, 240, 245));
		txtpnLibrary.setBounds(48, 11, 70, 20);
		panelCorridor2.add(txtpnLibrary);
		
		JPanel corridor2 = new JPanel();
		corridor2.setBackground(new Color(216, 191, 216));
		corridor2.setBounds(156, 138, 375, 112);
		getContentPane().add(corridor2);
		corridor2.setLayout(null);
		
		JTextPane txtpnCorridor_1 = new JTextPane();
		txtpnCorridor_1.setText("Corridor 1");
		txtpnCorridor_1.setBackground(new Color(216, 191, 216));
		txtpnCorridor_1.setBounds(149, 11, 67, 26);
		corridor2.add(txtpnCorridor_1);
		
		JTextPane txtpnHHumidity = new JTextPane();
		txtpnHHumidity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnHHumidity.setEditable(false);
		txtpnHHumidity.setForeground(new Color(255, 255, 255));
		txtpnHHumidity.setBackground(new Color(0, 128, 128));
		txtpnHHumidity.setText("H : humidity sensor / F : smoke sensor");
		txtpnHHumidity.setBounds(94, 393, 274, 31);
		getContentPane().add(txtpnHHumidity);
		
		JButton btnNewButton = new JButton("Ajouter / Supprimer un capteur");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				  sensor = new SensorInterface();
				  
				  sensor.getFrame().setVisible(true);
				  
				getFrame().dispose();
			}

			
		});
		btnNewButton.setBackground(new Color(211, 211, 211));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(386, 386, 208, 38);
		getContentPane().add(btnNewButton);
		
		JButton btnArrterLalerte = new JButton("Arrêter l'alerte");
		btnArrterLalerte.setBackground(new Color(211, 211, 211));
		btnArrterLalerte.setBounds(386, 435, 208, 38);
		getContentPane().add(btnArrterLalerte);
		btnArrterLalerte.setVisible(false);
		
		txtDesCapteurs = new JTextField();
		txtDesCapteurs.setEditable(false);
		txtDesCapteurs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDesCapteurs.setText("Attention: Des capteurs sont en alerte !");
		txtDesCapteurs.setForeground(new Color(255, 255, 255));
		txtDesCapteurs.setBackground(new Color(128, 0, 0));
		txtDesCapteurs.setBounds(94, 435, 286, 38);
		getContentPane().add(txtDesCapteurs);
		txtDesCapteurs.setColumns(10);
		txtDesCapteurs.setVisible(false);
		
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(this);
	    resize(700, 600);
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
