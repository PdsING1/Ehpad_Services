package org.ClientModule;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JPanel;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Window;
import javax.swing.UIManager;

import org.ServerModule.Sensor;

import javax.swing.JTextField;

public class SensorFirst extends JPanel implements ActionListener{
	public JTextField txtDesCapteurs;


	SensorInterface sensor ;
	BackEndSensorFirst back;

	public JPanel kitchen ;
	public JPanel panelLibrary;
	public JPanel panelLivingRoom;
	public JPanel panelCorridor2;
	public JPanel corridor1 ;
	JTextPane txtSensor ;
	JTextField textState;

	JFrame frame;
	JButton btnArrterLalerte ;



	public JFrame getFrame() {
		return frame;
	}



	public void setFrame(JFrame frame) {
		this.frame = frame;
	}



	public static void main(String[] args )
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {


				try {

					SensorFirst window = new SensorFirst();
					//window.setVisible(true);
					



				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



	public SensorFirst() {

		initialize();
	}
	public SensorFirst (int i)
	{
		initialize2();
	}

	public void initialize2()
	{



		frame = new JFrame();

		frame.getContentPane().setEnabled(false);
		frame.getContentPane().setBackground(new Color(0, 128, 128));
		frame.getContentPane().setLayout(null);

		JTextPane txtpnPlanDeLa = new JTextPane();
		txtpnPlanDeLa.setEditable(false);
		txtpnPlanDeLa.setBackground(new Color(0, 128, 128));
		txtpnPlanDeLa.setForeground(new Color(255, 255, 255));
		txtpnPlanDeLa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnPlanDeLa.setText("PLAN DE LA RESIDENCE");
		txtpnPlanDeLa.setBounds(247, 11, 246, 31);
		frame.getContentPane().add(txtpnPlanDeLa);

		JPanel panel = new JPanel();
		panel.setBounds(460, 79, 88, 58);
		frame.getContentPane().add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(396, 79, 73, 58);
		frame.getContentPane().add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(42, 79, 113, 58);
		frame.getContentPane().add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(42, 192, 204, 58);
		frame.getContentPane().add(panel_3);

		panelLibrary = new JPanel();
		panelLibrary.setBackground(new Color(230, 230, 250));
		panelLibrary.setBounds(42, 250, 204, 142);
		panelLibrary.setLayout(new FlowLayout());
		frame.getContentPane().add(panelLibrary);

		JTextPane txtpnLibrary_1 = new JTextPane();
		txtpnLibrary_1.setText("Library");
		txtpnLibrary_1.setBackground(new Color(230, 230, 250));
		panelLibrary.add(txtpnLibrary_1);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(144, 79, 73, 58);
		frame.getContentPane().add(panel_5);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(217, 79, 61, 58);
		frame.getContentPane().add(panel_6);

		JPanel panel_7 = new JPanel();
		panel_7.setBounds(269, 79, 73, 58);
		frame.getContentPane().add(panel_7);

		JPanel panel_8 = new JPanel();
		panel_8.setBounds(333, 79, 73, 58);
		frame.getContentPane().add(panel_8);

		JPanel panel_9 = new JPanel();
		panel_9.setBounds(533, 79, 179, 58);
		frame.getContentPane().add(panel_9);

		JPanel panel_10 = new JPanel();
		panel_10.setBounds(42, 136, 204, 58);
		frame.getContentPane().add(panel_10);

		JPanel panel_11 = new JPanel();
		panel_11.setBounds(624, 136, 88, 58);
		frame.getContentPane().add(panel_11);

		JPanel panel_12 = new JPanel();
		panel_12.setBounds(624, 192, 88, 58);
		frame.getContentPane().add(panel_12);

		panelLivingRoom = new JPanel();
		panelLivingRoom.setBackground(UIManager.getColor("Button.shadow"));
		panelLivingRoom.setBounds(411, 395, 301, 149);
		panelLivingRoom.setLayout(new FlowLayout());
		frame.getContentPane().add(panelLivingRoom);

		JTextPane textPane = new JTextPane();
		textPane.setText("Living Room");
		textPane.setBackground(UIManager.getColor("Button.shadow"));
		panelLivingRoom.add(textPane);

		kitchen = new JPanel();
		kitchen.setBackground(new Color(222, 184, 135));
		kitchen.setBounds(42, 395, 204, 149);
		kitchen.setLayout(new FlowLayout());
		frame.getContentPane().add(kitchen);


		JTextPane txtpnKitchen = new JTextPane();
		txtpnKitchen.setBounds(41, 11, 61, 28);
		kitchen.add(txtpnKitchen);
		txtpnKitchen.setText("Kitchen");
		txtpnKitchen.setBackground(new Color(222, 184, 135));

		panelCorridor2 = new JPanel();
		panelCorridor2.setBackground(new Color(255, 245, 238));
		panelCorridor2.setBounds(247, 395, 164, 148);
		panelCorridor2.setLayout(new FlowLayout());
		frame.getContentPane().add(panelCorridor2);


		JTextPane txtpnLibrary = new JTextPane();
		txtpnLibrary.setText("Corridor 2");
		txtpnLibrary.setBackground(new Color(255, 240, 245));
		txtpnLibrary.setBounds(48, 11, 70, 20);
		panelCorridor2.add(txtpnLibrary);

		corridor1 = new JPanel();
		corridor1.setBackground(new Color(216, 191, 216));
		corridor1.setBounds(245, 138, 378, 254);
		corridor1.setLayout(new FlowLayout());
		frame.getContentPane().add(corridor1);


		JTextPane txtpnCorridor_1 = new JTextPane();
		txtpnCorridor_1.setText("Corridor 1");
		txtpnCorridor_1.setBackground(new Color(216, 191, 216));
		txtpnCorridor_1.setBounds(149, 11, 67, 26);
		corridor1.add(txtpnCorridor_1);

		JTextPane txtpnHHumidity = new JTextPane();
		txtpnHHumidity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnHHumidity.setEditable(false);
		txtpnHHumidity.setForeground(new Color(255, 255, 255));
		txtpnHHumidity.setBackground(new Color(0, 128, 128));
		txtpnHHumidity.setText("H : humidity sensor / F : smoke sensor");
		txtpnHHumidity.setBounds(42, 575, 274, 31);
		frame.getContentPane().add(txtpnHHumidity);

		JButton btnNewButton = new JButton("Ajouter / Supprimer un capteur");
		btnNewButton.setEnabled(true);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				//frame.dispose();
				sensor = new SensorInterface();

				sensor.getFrame().setVisible(true);
                
				
			
			}


		});
		
	    txtSensor = new JTextPane();
		txtSensor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSensor.setEditable(false);
		txtSensor.setForeground(new Color(255, 255, 255));
		txtSensor.setBackground(new Color(0, 128, 128));
		txtSensor.setText("Entrez le nom de la pièce où vous souahitez eteindre l'alerte ");
		txtSensor.setBounds(42, 680, 274, 101);
		frame.getContentPane().add(txtSensor); 
		txtSensor.setVisible(false);
		
		 textState= new JTextField();
		 textState.setBackground(new Color(240, 248, 255));
		 textState.setBounds(42, 790, 100, 100);
		 frame.getContentPane().add(textState);
		 txtSensor.setVisible(false);
		
		btnNewButton.setBackground(new Color(211, 211, 211));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(504, 568, 208, 38);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButtonRefresh = new JButton("Refresh");
		btnNewButtonRefresh.setEnabled(true);
		btnNewButton.setBackground(new Color(211, 211, 211));
		btnNewButtonRefresh.setBounds(504, 750, 208, 38);
		btnNewButtonRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				frame.dispose();
				refresh();
				
			}


		});
		frame.getContentPane().add(btnNewButtonRefresh);

		btnArrterLalerte = new JButton("Arrêter l'alerte");
		btnArrterLalerte.setBackground(new Color(211, 211, 211));
		btnArrterLalerte.setBounds(504, 617, 208, 38);
		btnArrterLalerte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				refresh();
				System.out.println("action button UPDATE");

				Sensor sensor = new Sensor();
				sensor.query = "UPDATE";
				sensor.location = textState.getText();
				sensor.sensorName =  "";
				sensor.sensorType =  "";
				sensor.state =  "ALERTE";


				if(textState.getText().toUpperCase().equals("CORRIDOR1") ||textState.getText().toUpperCase().equals("CORRIDOR2") || textState.getText().toUpperCase().equals("KITCHEN") || textState.getText().toUpperCase().equals("LIVINGROOM")|| textState.getText().toUpperCase().equals("LIBRARY"))
				{

					
						
							if(! textState.getText().isEmpty() )
							{


								System.out.println(sensor.toString());
								Jsonb jsonb = JsonbBuilder.create();
								String result = jsonb.toJson(sensor);
								System.out.println(result);


								//ClientSocket client = new ClientSocket();


								String answer = SocketConnection.returnClientSocket().getSocket(result);
							}else 
							{
								System.out.println("La localisation ne peut pas etre vide !");
							}

						

					}else 
					{
						System.out.println("La localisation n'existe pas !");
					}
						
			
				
			}


		});
		frame.getContentPane().add(btnArrterLalerte);
		btnArrterLalerte.setVisible(false);
		
		
		

		
		

		txtDesCapteurs = new JTextField();
		txtDesCapteurs.setEditable(false);
		txtDesCapteurs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDesCapteurs.setText("Attention: Des capteurs sont en alerte !");
		txtDesCapteurs.setForeground(new Color(255, 255, 255));
		txtDesCapteurs.setBackground(new Color(128, 0, 0));
		txtDesCapteurs.setBounds(42, 617, 286, 38);
		frame.getContentPane().add(txtDesCapteurs);
		txtDesCapteurs.setColumns(10);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(624, 250, 88, 58);
		frame.getContentPane().add(panel_4);

		JPanel panel_13 = new JPanel();
		panel_13.setBounds(624, 308, 88, 84);
		frame.getContentPane().add(panel_13);
		txtDesCapteurs.setVisible(false);

		this.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(this);
		frame.resize(800, 1000);
		frame.setResizable(false);
		frame.setVisible(true);

	}

	public void initialize()
	{

		
		try {
			SocketConnection.callSocket();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		back = new BackEndSensorFirst(this);
		back.start();
	}

	public void refresh()
	{
		System.out.println("action Window Opened");
		//ClientSocket client = new ClientSocket();

		Sensor sensor = new Sensor();
		sensor.query = "SELECT";
		sensor.location = "location";
		sensor.sensorName ="sensorName"  ;
		sensor.sensorType = "sensorType" ;
		sensor.state = "state" ;


		

			System.out.println(sensor.toString());
			Jsonb jsonb = JsonbBuilder.create();
			String result = jsonb.toJson(sensor);
			System.out.println(result);

			SensorFirst sensorFirst = new SensorFirst();

			String answer = SocketConnection.returnClientSocket().getSocket(result);

			List<Sensor> sensors = getDeserializedObject(answer);


			for (int i = 0; i < sensors.size (); i++)
			{

				if(	sensors.get(i).location.toUpperCase().equals("CORRIDOR1"))
				{
					if(sensors.get(i).state.toUpperCase().equals("ON"))
					{
						if(sensors.get(i).sensorType.toUpperCase().equals("SMOKE"))
						{
							JButton btn = new JButton("F");
							btn.setBackground(Color.GREEN);
							btn.setBounds(50, 50,50,50);


							sensorFirst.corridor1.add(btn);


							btn.setVisible(true);

						}else if(sensors.get(i).sensorType.toUpperCase().equals("HUMIDITY"))
						{
							JButton btn = new JButton("H");
							btn.setBackground(Color.GREEN);
							btn.setBounds(50, 50,50,50);
							sensorFirst.corridor1.add(btn);
							btn.setVisible(true);

						}else {}

					}else if(sensors.get(i).state.toUpperCase().equals("OFF"))
					{
						if(sensors.get(i).sensorType.toUpperCase().equals("SMOKE"))
						{
							JButton btn = new JButton("F");
							btn.setBackground(Color.GRAY);
							btn.setBounds(50, 50,50,50);
							sensorFirst.corridor1.add(btn);
							btn.setVisible(true);

						}else if(sensors.get(i).sensorType.toUpperCase().equals("HUMIDITY"))
						{
							JButton btn = new JButton("H");
							btn.setBackground(Color.GRAY);
							btn.setBounds(50, 50,50,50);
							sensorFirst.corridor1.add(btn);
							btn.setVisible(true);

						}else {}

					}else if(sensors.get(i).state.toUpperCase().equals("ALERTE"))
					{
						if(sensors.get(i).sensorType.toUpperCase().equals("SMOKE"))
						{
							JButton btn = new JButton("F");
							btn.setBackground(Color.RED);
							btn.setBounds(50, 50,50,50);
							sensorFirst.corridor1.add(btn);
							btn.setVisible(true);
							btnArrterLalerte.setVisible(true);
							txtDesCapteurs.setVisible(true);
							txtSensor.setVisible(true);
							textState.setVisible(true);

						}else if(sensors.get(i).sensorType.toUpperCase().equals("HUMIDITY"))
						{
							JButton btn = new JButton("H");
							btn.setBackground(Color.RED);
							btn.setBounds(50, 50,50,50);
							sensorFirst.corridor1.add(btn);
							btn.setVisible(true);
							btnArrterLalerte.setVisible(true);
							txtDesCapteurs.setVisible(true);
							txtSensor.setVisible(true);
							textState.setVisible(true);
							

						}else {}

					}else
					{

					}

				}else if(	sensors.get(i).location.toUpperCase().equals("CORRIDOR2"))
				{
					if(sensors.get(i).state.toUpperCase().equals("ON"))
					{
						if(sensors.get(i).sensorType.toUpperCase().equals("SMOKE"))
						{
							JButton btn = new JButton("F");
							btn.setBackground(Color.GREEN);
							btn.setBounds(50, 50,50,50);
							sensorFirst.panelCorridor2.add(btn);
							btn.setVisible(true);

						}else if(sensors.get(i).sensorType.toUpperCase().equals("HUMIDITY"))
						{
							JButton btn = new JButton("H");
							btn.setBackground(Color.GREEN);
							btn.setBounds(50, 50,50,50);
							sensorFirst.panelCorridor2.add(btn);
							btn.setVisible(true);

						}else {}

					}else if(sensors.get(i).state.toUpperCase().equals("OFF"))
					{
						if(sensors.get(i).sensorType.toUpperCase().equals("SMOKE"))
						{
							JButton btn = new JButton("F");
							btn.setBackground(Color.GRAY);
							btn.setBounds(50, 50,50,50);
							sensorFirst.panelCorridor2.add(btn);
							btn.setVisible(true);

						}else if(sensors.get(i).sensorType.toUpperCase().equals("HUMIDITY"))
						{
							JButton btn = new JButton("H");
							btn.setBackground(Color.GRAY);
							btn.setBounds(50, 50,50,50);
							sensorFirst.panelCorridor2.add(btn);
							btn.setVisible(true);

						}else {}

					}else if(sensors.get(i).state.toUpperCase().equals("ALERTE"))
					{
						if(sensors.get(i).sensorType.toUpperCase().equals("SMOKE"))
						{
							JButton btn = new JButton("F");
							btn.setBackground(Color.RED);
							btn.setBounds(50, 50,50,50);
							sensorFirst.panelCorridor2.add(btn);
							btn.setVisible(true);
							btnArrterLalerte.setVisible(true);
							txtDesCapteurs.setVisible(true);
							txtSensor.setVisible(true);
							textState.setVisible(true);

						}else if(sensors.get(i).sensorType.toUpperCase().equals("HUMIDITY"))
						{
							JButton btn = new JButton("H");
							btn.setBackground(Color.RED);
							btn.setBounds(50, 50,50,50);
							sensorFirst.panelCorridor2.add(btn);
							btn.setVisible(true);
							btnArrterLalerte.setVisible(true);
							txtDesCapteurs.setVisible(true);
							txtSensor.setVisible(true);
							textState.setVisible(true);

						}else {}

					}else
					{

					}

				}else if(	sensors.get(i).location.toUpperCase().equals("KITCHEN"))
				{
					if(sensors.get(i).state.toUpperCase().equals("ON"))
					{
						if(sensors.get(i).sensorType.toUpperCase().equals("SMOKE"))
						{
							JButton btn = new JButton("F");
							btn.setBackground(Color.GREEN);
							btn.setBounds(30, 30,30,30);
							sensorFirst.kitchen.add(btn);
							btn.setVisible(true);

						}else if(sensors.get(i).sensorType.toUpperCase().equals("HUMIDITY"))
						{
							JButton btn = new JButton("H");
							btn.setBackground(Color.GREEN);
							btn.setBounds(30, 30,30,30);
							sensorFirst.kitchen.add(btn);
							btn.setVisible(true);

						}else {}

					}else if(sensors.get(i).state.toUpperCase().equals("OFF"))
					{
						if(sensors.get(i).sensorType.toUpperCase().equals("SMOKE"))
						{
							JButton btn = new JButton("F");
							btn.setBackground(Color.GRAY);
							btn.setBounds(30, 30,30,30);
							sensorFirst.kitchen.add(btn);
							btn.setVisible(true);

						}else if(sensors.get(i).sensorType.toUpperCase().equals("HUMIDITY"))
						{
							JButton btn = new JButton("H");
							btn.setBackground(Color.GRAY);
							btn.setBounds(30, 30,30,30);
							sensorFirst.kitchen.add(btn);
							btn.setVisible(true);

						}else {}

					}else if(sensors.get(i).state.toUpperCase().equals("ALERTE"))
					{
						if(sensors.get(i).sensorType.toUpperCase().equals("SMOKE"))
						{
							JButton btn = new JButton("F");
							btn.setBackground(Color.RED);
							btn.setBounds(30, 30,30,30);
							sensorFirst.kitchen.add(btn);
							btn.setVisible(true);
							btnArrterLalerte.setVisible(true);
							txtDesCapteurs.setVisible(true);
							txtSensor.setVisible(true);
							textState.setVisible(true);

						}else if(sensors.get(i).sensorType.toUpperCase().equals("HUMIDITY"))
						{
							JButton btn = new JButton("H");
							btn.setBackground(Color.RED);
							btn.setBounds(30, 30,30,30);
							sensorFirst.kitchen.add(btn);
							btn.setVisible(true);
							btnArrterLalerte.setVisible(true);
							txtDesCapteurs.setVisible(true);
							txtSensor.setVisible(true);
							textState.setVisible(true);

						}else {}

					}else
					{

					}

				}else if(	sensors.get(i).location.toUpperCase().equals("LIBRARY"))
				{
					if(sensors.get(i).state.toUpperCase().equals("ON"))
					{
						if(sensors.get(i).sensorType.toUpperCase().equals("SMOKE"))
						{
							JButton btn = new JButton("F");
							btn.setBackground(Color.GREEN);
							btn.setBounds(30, 30,30,30);
							sensorFirst.panelLibrary.add(btn);
							btn.setVisible(true);

						}else if(sensors.get(i).sensorType.toUpperCase().equals("HUMIDITY"))
						{
							JButton btn = new JButton("H");
							btn.setBackground(Color.GREEN);
							btn.setBounds(30, 30,30,30);
							sensorFirst.panelLibrary.add(btn);
							btn.setVisible(true);

						}else {}

					}else if(sensors.get(i).state.toUpperCase().equals("OFF"))
					{
						if(sensors.get(i).sensorType.toUpperCase().equals("SMOKE"))
						{
							JButton btn = new JButton("F");
							btn.setBackground(Color.GRAY);
							btn.setBounds(30, 30,30,30);
							sensorFirst.panelLibrary.add(btn);
							btn.setVisible(true);

						}else if(sensors.get(i).sensorType.toUpperCase().equals("HUMIDITY"))
						{
							JButton btn = new JButton("H");
							btn.setBackground(Color.GRAY);
							btn.setBounds(30, 30,30,30);
							sensorFirst.panelLibrary.add(btn);
							btn.setVisible(true);
						}else {}

					}else if(sensors.get(i).state.toUpperCase().equals("ALERTE"))
					{
						if(sensors.get(i).sensorType.toUpperCase().equals("SMOKE"))
						{
							JButton btn = new JButton("F");
							btn.setBackground(Color.RED);
							btn.setBounds(30, 30,30,30);
							sensorFirst.panelLibrary.add(btn);
							btn.setVisible(true);
							btnArrterLalerte.setVisible(true);
							txtDesCapteurs.setVisible(true);
							txtSensor.setVisible(true);
							textState.setVisible(true);

						}else if(sensors.get(i).sensorType.toUpperCase().equals("HUMIDITY"))
						{
							JButton btn = new JButton("H");
							btn.setBackground(Color.RED);
							btn.setBounds(30, 30,30,30);
							sensorFirst.panelLibrary.add(btn);
							btn.setVisible(true);
							btnArrterLalerte.setVisible(true);
							txtDesCapteurs.setVisible(true);
							txtSensor.setVisible(true);
							textState.setVisible(true);

						}else {}

					}else
					{

					}

				}else if(	sensors.get(i).location.toUpperCase().equals("LIVINGROOM"))
				{
					if(sensors.get(i).state.toUpperCase().equals("ON"))
					{
						if(sensors.get(i).sensorType.toUpperCase().equals("SMOKE"))
						{
							JButton btn = new JButton("F");
							btn.setBackground(Color.GREEN);
							btn.setBounds(30, 30,30,30);
							sensorFirst.panelLivingRoom.add(btn);
							btn.setVisible(true);

						}else if(sensors.get(i).sensorType.toUpperCase().equals("HUMIDITY"))
						{
							JButton btn = new JButton("H");
							btn.setBackground(Color.GREEN);
							btn.setBounds(30, 30,30,30);
							sensorFirst.panelLivingRoom.add(btn);
							btn.setVisible(true);

						}else {}

					}else if(sensors.get(i).state.toUpperCase().equals("OFF"))
					{
						if(sensors.get(i).sensorType.toUpperCase().equals("SMOKE"))
						{
							JButton btn = new JButton("F");
							btn.setBackground(Color.GRAY);
							btn.setBounds(30, 30,30,30);
							sensorFirst.panelLivingRoom.add(btn);
							btn.setVisible(true);

						}else if(sensors.get(i).sensorType.toUpperCase().equals("HUMIDITY"))
						{
							JButton btn = new JButton("H");
							btn.setBackground(Color.GRAY);
							btn.setBounds(30, 30,30,30);
							sensorFirst.panelLivingRoom.add(btn);
							btn.setVisible(true);

						}else {}

					}else if(sensors.get(i).state.toUpperCase().equals("ALERTE"))
					{
						if(sensors.get(i).sensorType.toUpperCase().equals("SMOKE"))
						{
							JButton btn = new JButton("F");
							btn.setBackground(Color.RED);
							btn.setBounds(30, 30,30,30);
							sensorFirst.panelLivingRoom.add(btn);
							btn.setVisible(true);
							btnArrterLalerte.setVisible(true);
							txtDesCapteurs.setVisible(true);
							txtSensor.setVisible(true);
							textState.setVisible(true);

						}else if(sensors.get(i).sensorType.toUpperCase().equals("HUMIDITY"))
						{
							JButton btn = new JButton("H");
							btn.setBackground(Color.RED);
							btn.setBounds(30, 30,30,30);
							sensorFirst.panelLivingRoom.add(btn);
							btn.setVisible(true);
							btnArrterLalerte.setVisible(true);
							txtDesCapteurs.setVisible(true);
							txtSensor.setVisible(true);
							textState.setVisible(true);

						}else {}

					}else
					{

					}

				}else
				{

				}

			}
		

	}

	public List<Sensor> getDeserializedObject(String jsQuery){		


		List<Sensor> liste = new ArrayList();
		
		Jsonb jsonb = JsonbBuilder.create();

		Sensor[] sensorArray = jsonb.fromJson(jsQuery, Sensor[].class);  

		for(Sensor sensor : sensorArray) {
			liste.add(sensor);
			System.out.println(sensor);	

		}

		return liste;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}




}
