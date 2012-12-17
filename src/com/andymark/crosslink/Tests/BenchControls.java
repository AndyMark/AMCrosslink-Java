package com.andymark.crosslink.Tests;


import com.andymark.crosslink.Outputs.Relay;
import com.andymark.crosslink.Outputs.RelayState;
import com.andymark.crosslink.Outputs.Solenoid;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JProgressBar;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


@SuppressWarnings("serial")
public class BenchControls extends JFrame{
	
	private JTextField ipAddr;
	private JTextField txtDisconnected;
	private JTextField enabledStatus;
	private JTextField[] ledSolenoid = new JTextField[8];
	
	private  JProgressBar batteryBar;
	private  JProgressBar analogBar_0;
	private  JProgressBar analogBar_1;
	private  JProgressBar analogBar_2;
	private  JProgressBar analogBar_3;
	private  JProgressBar analogBar_4;
	private  JProgressBar analogBar_5;
	private  JProgressBar analogBar_6;
	private  JProgressBar analogBar_7;	
	
	private JButton btnSolenoid_0;	
	
	private JTextField ledSolenoid_0;
	private JTextField ledSolenoid_1;
	private JTextField ledSolenoid_2;
	private JTextField ledSolenoid_3;
	private JTextField ledSolenoid_4;
	private JTextField ledSolenoid_5;
	private JTextField ledSolenoid_6;
	private JTextField ledSolenoid_7;
	
	private JTextField txtQuad_0;
	private JTextField txtQuad_1;
	private JTextField txtQuad_2;
	private JTextField txtQuad_3;
	
	private JTextField txtVelocity_3;
	private JTextField txtVelocity_2;
	private JTextField txtVelocity_1;
	private JTextField txtVelocity_0;
	private JTextField txtGPIO_DDR;
	
	private  Bench ricksDesk;
			
	public BenchControls() {
		setTitle("Crosslink - Java");
		getContentPane().setLayout(null);
		setSize(1030, 514);
		
		JLabel lblIp = new JLabel("IP :");
		lblIp.setBounds(10, 54, 46, 14);
		getContentPane().add(lblIp);
		
		ipAddr = new JTextField();
		ipAddr.setEnabled(false);
		ipAddr.setBounds(33, 51, 86, 20);
		getContentPane().add(ipAddr);
		ipAddr.setColumns(10);
		
		final JPanel sliders = new JPanel();
		sliders.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sliders.setBackground(Color.WHITE);
		sliders.setBounds(337, 156, 513, 308);
		getContentPane().add(sliders);
		
		sliders.setLayout(null);
		
		txtDisconnected = new JTextField();
		txtDisconnected.setEnabled(false);
		txtDisconnected.setForeground(Color.LIGHT_GRAY);
		txtDisconnected.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDisconnected.setHorizontalAlignment(SwingConstants.CENTER);
		txtDisconnected.setBackground(Color.GRAY);
		txtDisconnected.setText("DISCONNECTED");
		txtDisconnected.setBounds(135, 92, 19, 20);
		getContentPane().add(txtDisconnected);
		txtDisconnected.setColumns(10);
		
		JPanel relays = new JPanel();
		relays.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		relays.setBackground(Color.WHITE);
		relays.setBounds(23, 156, 109, 308);
		getContentPane().add(relays);
		relays.setLayout(null);
		
		btnSolenoid_0 = new JButton("Solenoid 1");
		btnSolenoid_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Toggle Relay_0 
				//Double click to create these
				toggleSolenoid(ricksDesk.light_1);	
			}
		});
		btnSolenoid_0.setBounds(10, 11, 89, 23);
		relays.add(btnSolenoid_0);
		
		JButton btnSolenoid_1 = new JButton("Solenoid 2");
		btnSolenoid_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Toggle Relay_1 
				toggleSolenoid(ricksDesk.light_2);	
			}
		});
		btnSolenoid_1.setBounds(10, 45, 89, 23);
		relays.add(btnSolenoid_1);
		
		JButton btnSolenoid_2 = new JButton("Solenoid 3");
		btnSolenoid_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Toggle Relay_2
				toggleSolenoid(ricksDesk.light_3);	
			}
		});
		btnSolenoid_2.setBounds(10, 79, 89, 23);
		relays.add(btnSolenoid_2);
		
		JButton btnSolenoid_3 = new JButton("Solenoid 4");
		btnSolenoid_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Toggle Relay_3
				toggleSolenoid(ricksDesk.light_4);	
			}
		});
		btnSolenoid_3.setBounds(10, 113, 89, 23);
		relays.add(btnSolenoid_3);
		
		JButton btnSolenoid_4 = new JButton("Solenoid 5");
		btnSolenoid_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toggleSolenoid(ricksDesk.light_5);	
			}
		});
		btnSolenoid_4.setBounds(10, 147, 89, 23);
		relays.add(btnSolenoid_4);
		
		JButton btnSolenoid_5 = new JButton("Solenoid 6");
		btnSolenoid_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toggleSolenoid(ricksDesk.light_6);	
			}
		});
		btnSolenoid_5.setBounds(10, 180, 89, 23);
		relays.add(btnSolenoid_5);
		
		JButton btnSolenoid_6 = new JButton("Solenoid 7");
		btnSolenoid_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toggleSolenoid(ricksDesk.light_7);	
			}
		});
		btnSolenoid_6.setBounds(10, 214, 89, 23);
		relays.add(btnSolenoid_6);
		
		JButton btnSolenoid_7 = new JButton("Solenoid 8");
		btnSolenoid_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toggleSolenoid(ricksDesk.light_8);	
			}
		});
		btnSolenoid_7.setBounds(10, 248, 89, 23);
		relays.add(btnSolenoid_7);
				
		final JSlider pwm0 = new JSlider();
		pwm0.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){				
				ricksDesk.testMotor.Throttle((pwm0.getValue() * 2.0 /100.0)-1.0);	
			}
		});
		pwm0.setBounds(98, 15, 194, 23);
		sliders.add(pwm0);
		
		JLabel lblPwm = new JLabel("PWM 1-PWM Vic");
		lblPwm.setBounds(10, 15, 170, 14);
		sliders.add(lblPwm);
		
		
		
		final JSlider pwm1 = new JSlider();
		pwm1.setBounds(98, 49, 194, 23);
		pwm1.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				ricksDesk.testJag.Throttle((pwm1.getValue() *2.0/100.0)-1.0);	
			}
		});
		sliders.add(pwm1);
		
		
		
		final JSlider pwm2 = new JSlider();
		pwm2.setBounds(98, 87, 194, 23);
		pwm2.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				ricksDesk.rearMotor.Throttle((pwm2.getValue() *2.0/100.0)-1.0);		
			}
		});
		sliders.add(pwm2);
		
		final JSlider pwm3 = new JSlider();
		pwm3.setBounds(98, 121, 194, 23);
		pwm3.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				ricksDesk.penFlipper.Position((pwm3.getValue() *2.0/100.0)-1.0);				
			}
		});
		sliders.add(pwm3);
		
		
		final JSlider pwm4 = new JSlider();
		pwm4.setBounds(98, 155, 194, 23);
		pwm4.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				ricksDesk.Strafe((pwm4.getValue() *2.0/100.0)-1.0);			
			}
		});
		sliders.add(pwm4);		
		
		final JSlider pwm5 = new JSlider();
		pwm5.setBounds(98, 189, 194, 23);
		pwm5.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				updatePWM( 5, pwm5.getValue());				
			}
		});
		sliders.add(pwm5);
		
		final JSlider pwm6 = new JSlider();
		pwm6.setBounds(98, 227, 194, 23);
		pwm6.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				updatePWM( 6, pwm6.getValue());				
			}
		});
		sliders.add(pwm6);
		
		final JSlider pwm7 = new JSlider();
		pwm7.setBounds(98, 261, 194, 23);
		pwm7.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				updatePWM( 7, pwm7.getValue());				
			}
		});
		sliders.add(pwm7);
				
		//Labels
		JLabel lblPwm_1 = new JLabel("PWM 2-CAN Jag");
		lblPwm_1.setBounds(10, 49, 84, 14);
		sliders.add(lblPwm_1);
		
		JLabel lblPwm_2 = new JLabel("PWM 3-Rear");
		lblPwm_2.setBounds(10, 87, 84, 14);
		sliders.add(lblPwm_2);		
		
		JLabel lblPwm_3 = new JLabel("PWM 4-Servo");
		lblPwm_3.setBounds(10, 121, 84, 14);
		sliders.add(lblPwm_3);			
		
		JLabel lblPwm_4 = new JLabel("PWM 5-Strafe");
		lblPwm_4.setBounds(10, 155, 84, 14);
		sliders.add(lblPwm_4);
		
		JLabel lblPwm_5 = new JLabel("PWM 6");
		lblPwm_5.setBounds(10, 189, 84, 14);
		sliders.add(lblPwm_5);
		
		JLabel lblPwm_6 = new JLabel("PWM 7");
		lblPwm_6.setBounds(10, 227, 84, 14);
		sliders.add(lblPwm_6);
		
		JLabel lblPwm_7 = new JLabel("PWM 8");
		lblPwm_7.setBounds(10, 261, 84, 14);
		sliders.add(lblPwm_7);
		
		analogBar_0 = new JProgressBar();
		analogBar_0.setBounds(355, 15, 146, 14);
		sliders.add(analogBar_0);
		
		analogBar_1 = new JProgressBar();
		analogBar_1.setBounds(355, 49, 146, 14);
		sliders.add(analogBar_1);
		
		analogBar_2 = new JProgressBar();
		analogBar_2.setBounds(355, 87, 146, 14);
		sliders.add(analogBar_2);
		
		analogBar_3 = new JProgressBar();
		analogBar_3.setBounds(355, 121, 146, 14);
		sliders.add(analogBar_3);
		
		analogBar_4 = new JProgressBar();
		analogBar_4.setBounds(355, 155, 146, 14);
		sliders.add(analogBar_4);
		
		analogBar_5 = new JProgressBar();
		analogBar_5.setBounds(355, 189, 146, 14);
		sliders.add(analogBar_5);
		
		analogBar_6 = new JProgressBar();
		analogBar_6.setBounds(355, 227, 146, 14);
		sliders.add(analogBar_6);
		
		analogBar_7 = new JProgressBar();
		analogBar_7.setBounds(355, 261, 146, 14);
		sliders.add(analogBar_7);
		
		
		JLabel lblAnalog_0 = new JLabel("Analog 1");
		lblAnalog_0.setBounds(302, 15, 53, 14);
		sliders.add(lblAnalog_0);
		
		JLabel lblAnalog_1 = new JLabel("Analog 2");
		lblAnalog_1.setBounds(302, 49, 53, 14);
		sliders.add(lblAnalog_1);
		
		JLabel lblAnalog_2 = new JLabel("Analog 3");
		lblAnalog_2.setBounds(302, 87, 53, 14);
		sliders.add(lblAnalog_2);
		
		JLabel lblAnalog_3 = new JLabel("Analog 4");
		lblAnalog_3.setBounds(302, 121, 53, 14);
		sliders.add(lblAnalog_3);
		
		JLabel lblAnalog_4 = new JLabel("Analog 5");
		lblAnalog_4.setBounds(302, 155, 53, 14);
		sliders.add(lblAnalog_4);
		
		JLabel lblAnalog_5 = new JLabel("Analog 6");
		lblAnalog_5.setBounds(302, 189, 53, 14);
		sliders.add(lblAnalog_5);
		
		JLabel lblAnalog_6 = new JLabel("Analog 7");
		lblAnalog_6.setBounds(302, 227, 53, 14);
		sliders.add(lblAnalog_6);
		
		JLabel lblAnalog_7 = new JLabel("Analog 8");
		lblAnalog_7.setBounds(302, 261, 53, 14);
		sliders.add(lblAnalog_7);
		
		
		
		JButton btnEnable = new JButton("Enable");
		btnEnable.setEnabled(false);
		btnEnable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnEnable.setBounds(33, 122, 89, 23);
		getContentPane().add(btnEnable);
		
		enabledStatus = new JTextField();
		enabledStatus.setEditable(false);
		enabledStatus.setForeground(Color.GRAY);
		enabledStatus.setEnabled(false);
		enabledStatus.setBackground(Color.GRAY);
		enabledStatus.setBounds(135, 123, 19, 20);
		getContentPane().add(enabledStatus);
		enabledStatus.setColumns(10);
		
		JButton btnStop = new JButton("STOP");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Stop communications. Kill the program
				dispose();
				System.exit(0);
			}
		});
		btnStop.setBounds(177, 92, 89, 23);
		getContentPane().add(btnStop);
		
		JButton btnReset = new JButton("Reset PWM");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pwm0.setValue(50);
				pwm1.setValue(50);
				pwm2.setValue(50);
				pwm3.setValue(50);
				pwm4.setValue(50);
				pwm5.setValue(50);
				pwm6.setValue(50);
				pwm7.setValue(50);				
			}
		});
		btnReset.setBounds(177, 122, 89, 23);
		getContentPane().add(btnReset);
		
		batteryBar = new JProgressBar();
		batteryBar.setBounds(836, 39, 122, 52);
		getContentPane().add(batteryBar);
		batteryBar.setFont(new Font("Tahoma", Font.BOLD, 31));
		batteryBar.setForeground(new Color(51, 204, 51));
		batteryBar.setStringPainted(true);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				
				String ip_addr = ipAddr.getText();
				System.out.println(ip_addr);
				try {
					
					connectToRobot(Inet4Address.getByName("10.10.0.121"));
					System.out.println("Connection Established: 10.10.0.121");
				} catch (UnknownHostException e) {					
					e.printStackTrace();
				}					
								
				Timer timer = new Timer();
				timer.schedule(new PeatandRepeat() ,0,200);
				
			}
		});
		btnConnect.setBounds(33, 92, 89, 23);
		getContentPane().add(btnConnect);
		
		JPanel solinoidStatus = new JPanel();
		solinoidStatus.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		solinoidStatus.setBackground(Color.WHITE);
		solinoidStatus.setBounds(135, 156, 46, 308);
		getContentPane().add(solinoidStatus);
		solinoidStatus.setLayout(null);
		
		ledSolenoid_0 = new JTextField();
		ledSolenoid_0.setBounds(10, 12, 19, 20);
		solinoidStatus.add(ledSolenoid_0);
		ledSolenoid_0.setBackground(Color.GRAY);
		ledSolenoid_0.setColumns(10);
		
		ledSolenoid_1 = new JTextField();
		ledSolenoid_1.setColumns(10);
		ledSolenoid_1.setBackground(Color.GRAY);
		ledSolenoid_1.setBounds(10, 46, 19, 20);
		solinoidStatus.add(ledSolenoid_1);
		
		ledSolenoid_2 = new JTextField();
		ledSolenoid_2.setColumns(10);
		ledSolenoid_2.setBackground(Color.GRAY);
		ledSolenoid_2.setBounds(10, 80, 19, 20);
		solinoidStatus.add(ledSolenoid_2);
		
		ledSolenoid_3 = new JTextField();
		ledSolenoid_3.setColumns(10);
		ledSolenoid_3.setBackground(Color.GRAY);
		ledSolenoid_3.setBounds(10, 114, 19, 20);
		solinoidStatus.add(ledSolenoid_3);
		
		ledSolenoid_4 = new JTextField();
		ledSolenoid_4.setColumns(10);
		ledSolenoid_4.setBackground(Color.GRAY);
		ledSolenoid_4.setBounds(10, 148, 19, 20);
		solinoidStatus.add(ledSolenoid_4);
		
		ledSolenoid_5 = new JTextField();
		ledSolenoid_5.setColumns(10);
		ledSolenoid_5.setBackground(Color.GRAY);
		ledSolenoid_5.setBounds(10, 181, 19, 20);
		solinoidStatus.add(ledSolenoid_5);
		
		ledSolenoid_6 = new JTextField();
		ledSolenoid_6.setColumns(10);
		ledSolenoid_6.setBackground(Color.GRAY);
		ledSolenoid_6.setBounds(10, 215, 19, 20);
		solinoidStatus.add(ledSolenoid_6);
		
		ledSolenoid_7 = new JTextField();
		ledSolenoid_7.setColumns(10);
		ledSolenoid_7.setBackground(Color.GRAY);
		ledSolenoid_7.setBounds(10, 249, 19, 20);
		solinoidStatus.add(ledSolenoid_7);
		
		ledSolenoid[0] = ledSolenoid_0;
		ledSolenoid[1] = ledSolenoid_1;
		ledSolenoid[2] = ledSolenoid_2;
		ledSolenoid[3] = ledSolenoid_3;
		ledSolenoid[4] = ledSolenoid_4;
		ledSolenoid[5] = ledSolenoid_5;
		ledSolenoid[6] = ledSolenoid_6;
		ledSolenoid[7] = ledSolenoid_7;
		
		JPanel pnlEncoders = new JPanel();
		pnlEncoders.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlEncoders.setBackground(Color.WHITE);
		pnlEncoders.setBounds(860, 156, 142, 308);
		getContentPane().add(pnlEncoders);
		pnlEncoders.setLayout(null);
		
		JLabel lblQuad_0 = new JLabel("QUAD 1 :");
		lblQuad_0.setBounds(10, 15, 46, 14);
		pnlEncoders.add(lblQuad_0);
		
		JLabel lblQuad_1 = new JLabel("QUAD 2 :");
		lblQuad_1.setBounds(10, 49, 46, 14);
		pnlEncoders.add(lblQuad_1);
		
		JLabel lblQuad_2 = new JLabel("QUAD 3 :");
		lblQuad_2.setBounds(10, 87, 46, 14);
		pnlEncoders.add(lblQuad_2);
		
		JLabel lblQuad_3 = new JLabel("QUAD 4 :");
		lblQuad_3.setBounds(10, 121, 46, 14);
		pnlEncoders.add(lblQuad_3);
		
		txtQuad_0 = new JTextField();
		txtQuad_0.setBounds(66, 12, 46, 20);
		pnlEncoders.add(txtQuad_0);
		txtQuad_0.setColumns(10);
		
		txtQuad_1 = new JTextField();
		txtQuad_1.setColumns(10);
		txtQuad_1.setBounds(66, 46, 46, 20);
		pnlEncoders.add(txtQuad_1);
		
		txtQuad_2 = new JTextField();
		txtQuad_2.setColumns(10);
		txtQuad_2.setBounds(66, 84, 46, 20);
		pnlEncoders.add(txtQuad_2);
		
		txtQuad_3 = new JTextField();
		txtQuad_3.setColumns(10);
		txtQuad_3.setBounds(66, 118, 46, 20);
		pnlEncoders.add(txtQuad_3);
		
		txtVelocity_3 = new JTextField();
		txtVelocity_3.setColumns(10);
		txtVelocity_3.setBounds(66, 260, 46, 20);
		pnlEncoders.add(txtVelocity_3);
		
		JLabel lblVelocity_3 = new JLabel("VEL 4 :");
		lblVelocity_3.setBounds(10, 263, 46, 14);
		pnlEncoders.add(lblVelocity_3);
		
		JLabel lblVelocity_2 = new JLabel("VEL 3 :");
		lblVelocity_2.setBounds(10, 229, 46, 14);
		pnlEncoders.add(lblVelocity_2);
		
		txtVelocity_2 = new JTextField();
		txtVelocity_2.setColumns(10);
		txtVelocity_2.setBounds(66, 226, 46, 20);
		pnlEncoders.add(txtVelocity_2);
		
		txtVelocity_1 = new JTextField();
		txtVelocity_1.setColumns(10);
		txtVelocity_1.setBounds(66, 188, 46, 20);
		pnlEncoders.add(txtVelocity_1);
		
		JLabel lblVelocity_1 = new JLabel("VEL 2 :");
		lblVelocity_1.setBounds(10, 191, 46, 14);
		pnlEncoders.add(lblVelocity_1);
		
		JLabel lblVelocity_0 = new JLabel("VEL 1 :");
		lblVelocity_0.setBounds(10, 157, 46, 14);
		pnlEncoders.add(lblVelocity_0);
		
		txtVelocity_0 = new JTextField();
		txtVelocity_0.setColumns(10);
		txtVelocity_0.setBounds(66, 154, 46, 20);
		pnlEncoders.add(txtVelocity_0);
		
		JPanel pnlRelay = new JPanel();
		pnlRelay.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlRelay.setBackground(Color.WHITE);
		pnlRelay.setBounds(187, 156, 138, 308);
		getContentPane().add(pnlRelay);
		pnlRelay.setLayout(null);
		
		final JComboBox cbRelay_0 = new JComboBox();
		cbRelay_0.setModel(new DefaultComboBoxModel(new String[] {"Forward", "Neutral", "Reverse"}));
		cbRelay_0.setBounds(56, 13, 70, 22);
		cbRelay_0.setSelectedIndex(1);		
		cbRelay_0.addActionListener (new ActionListener () {
			public void actionPerformed(ActionEvent e) {		    	
				setRelay(ricksDesk.relay_1, RelayState.valueOf(cbRelay_0.getItemAt(cbRelay_0.getSelectedIndex()).toString()));   		        
			}
		});
		
		pnlRelay.add(cbRelay_0);
		
		final JComboBox cbRelay_1 = new JComboBox();
		cbRelay_1.setModel(new DefaultComboBoxModel(new String[] {"Forward", "Neutral", "Reverse"}));
		cbRelay_1.setSelectedIndex(1);
		cbRelay_1.setBounds(56, 48, 70, 22);
		cbRelay_1.addActionListener (new ActionListener () {
			public void actionPerformed(ActionEvent e) {	
				//System.out.println(RelayState.valueOf(cbRelay_1.getItemAt(cbRelay_1.getSelectedIndex()).toString()));
				setRelay(ricksDesk.relay_2, RelayState.valueOf(cbRelay_1.getItemAt(cbRelay_1.getSelectedIndex()).toString()));
 		        
			}
		});
		pnlRelay.add(cbRelay_1);
		
		
		JComboBox cbRelay_2 = new JComboBox();
		cbRelay_2.setModel(new DefaultComboBoxModel(new String[] {"Forward", "Neutral", "Reverse"}));
		cbRelay_2.setSelectedIndex(1);
		cbRelay_2.setBounds(56, 79, 70, 22);
		cbRelay_2.addActionListener (new ActionListener () {
			public void actionPerformed(ActionEvent e) {		    	
				setRelay(ricksDesk.relay_3, RelayState.Forward);   		        
			}
		});
		pnlRelay.add(cbRelay_2);
		
		JComboBox cbRelay_3 = new JComboBox();
		cbRelay_3.setModel(new DefaultComboBoxModel(new String[]{"Forward", "Neutral", "Reverse"}));
		cbRelay_3.setSelectedIndex(1);
		cbRelay_3.setBounds(56, 114, 70, 22);
		cbRelay_3.addActionListener (new ActionListener () {
			public void actionPerformed(ActionEvent e) {		    	
				setRelay(ricksDesk.relay_4, RelayState.Forward);  		        
			}
		});
		pnlRelay.add(cbRelay_3);		
		
		JLabel lblRelay_0 = new JLabel("Relay 1");
		lblRelay_0.setBounds(12, 17, 46, 14);
		pnlRelay.add(lblRelay_0);
		
		JLabel lblRelay_1 = new JLabel("Relay 2");
		lblRelay_1.setBounds(12, 52, 46, 14);
		pnlRelay.add(lblRelay_1);
		
		JLabel lblRelay_2 = new JLabel("Relay 3");
		lblRelay_2.setBounds(12, 83, 46, 14);
		pnlRelay.add(lblRelay_2);
		
		JLabel lblRelay_3 = new JLabel("Relay 4");
		lblRelay_3.setBounds(12, 118, 46, 14);
		pnlRelay.add(lblRelay_3);
		
		txtGPIO_DDR = new JTextField();
		txtGPIO_DDR.setText("1111");
		txtGPIO_DDR.setHorizontalAlignment(SwingConstants.RIGHT);
		txtGPIO_DDR.setBounds(294, 94, 39, 20);
		getContentPane().add(txtGPIO_DDR);
		txtGPIO_DDR.setColumns(10);		
		
	}
	
	class PeatandRepeat extends TimerTask{
		public void run(){
			
			if (ricksDesk.ReceivingPackets()){
				//txtDisconnected.setBackground(Color.GREEN);
				updateThings();			
			}
			
		}
		
	}
	
	public void updateThings() {		
		
		//Quads		
		txtQuad_0.setText(Integer.toString(ricksDesk.E1.Position()));
		txtQuad_1.setText(Integer.toString(ricksDesk.E2.Position()));
		txtQuad_2.setText(Integer.toString(ricksDesk.E3.Position()));
		txtQuad_3.setText(Integer.toString(ricksDesk.E4.Position()));
						
		//Velocities 
		txtVelocity_0.setText(Integer.toString(ricksDesk.E1.Rate()));		 
		txtVelocity_1.setText(Integer.toString(ricksDesk.E2.Rate()));	
		txtVelocity_2.setText(Integer.toString(ricksDesk.E3.Rate()));	
		txtVelocity_3.setText(Integer.toString(ricksDesk.E4.Rate()));
		
		//Analogs
		batteryBar.setValue((int)(100*(ricksDesk.GetBatteryVoltage()/13)));
		analogBar_0.setValue((int)(100*(ricksDesk.A1.Voltage()/5)));
		analogBar_1.setValue((int)(100*(ricksDesk.A2.Voltage()/5)));
		analogBar_2.setValue((int)(100*(ricksDesk.A3.Voltage()/5)));
		analogBar_3.setValue((int)(100*(ricksDesk.A4.Voltage()/5)));
		analogBar_4.setValue((int)(100*(ricksDesk.A5.Voltage()/5)));
		analogBar_5.setValue((int)(100*(ricksDesk.A6.Voltage()/5)));
		analogBar_6.setValue((int)(100*(ricksDesk.A7.Voltage()/5)));
		analogBar_7.setValue((int)(100*(ricksDesk.A8.Voltage()/5)));
				
		//GPIO
		//txtGPIO_DDR.setText(String.format("%4s", Integer.toBinaryString(ricksDesk..getGpioDDR())).replace(" ","0"));
				
	}
	

	public void updatePWM(int i, int ii){
		
		System.out.println("DEPRECATED - Create a speed controller object in Bench inorder to use PWM" + i);
		
	}
	
	
	public Bench connectToRobot(InetAddress inetAddress){
	
		//Create new Robot Object
		ricksDesk = new Bench((Inet4Address) inetAddress);
		ricksDesk.teleop();	
		
		return ricksDesk;			
	}
		
	public void toggleSolenoid(Solenoid solenoid){
	
		if (ledSolenoid[solenoid.GetChannel() -1].getBackground() == Color.GRAY){
			solenoid.State(true);
			ledSolenoid[solenoid.GetChannel() - 1].setBackground(Color.RED);
		}else{
			solenoid.State(false);	
			ledSolenoid[solenoid.GetChannel() - 1].setBackground(Color.GRAY);
		}
	
	}
	

	public void setRelay(Relay relay, RelayState value){			
		relay.State(value);		
	}
	

	
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					} catch (ClassNotFoundException e) {
					} catch (InstantiationException e) {
					} catch (IllegalAccessException e) {
					} catch (UnsupportedLookAndFeelException e) {
					}
					
					new BenchControls().setVisible(true);
					
				
					
					
				}
			});
		}
}
