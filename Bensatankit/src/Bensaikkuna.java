import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.JEditorPane;
import java.io.IOException; 

import java.nio.file.Files; 

import java.nio.file.Paths; 
import java.text.DecimalFormat;

public class Bensaikkuna extends JFrame {
	
	
	
	static DecimalFormat df = new DecimalFormat("###.##");
	private JPanel contentPane;
	public  JButton Buttontilaa;
	private JButton Button1;
	private JButton Button2;
	private JButton Button3;
	private JButton Button6;
	private JButton Button5;
	private JButton Button4;
	private JButton Button7;
	private JButton Button8;
	private JButton Button9;
	private JButton Button0;
	private JButton Buttonclr;
	private JButton Buttonback;
	public static JTextField maara;
	private JLabel lblNewLabel;
	private JRadioButton button95;
	private JRadioButton button98;
	private JRadioButton buttondiesel;


	public static String filename = "C:/temp/BensaAsema/Tilaushistoria.txt";
	public static String tankki_95e = "C:/temp/BensaAsema/T95E.txt";
	public static String tankki_98e = "C:/temp/BensaAsema/T98E.txt";
	public static String tankki_diesel = "C:/temp/BensaAsema/Tdiesel.txt";
	public static JTextField Kapasiteetti;
	public static String teksti95;
	private JLabel lblNewLabel_1;
	private JTextField yhteensa;
	
	


	/**
	 * Create the frame.
	 */
	public Bensaikkuna() {
		setTitle("Tilaa polttoaine");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 391, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setBackground(new Color(240, 255, 255)); 
		contentPane.setBorder(new LineBorder(new Color(107, 142, 35), 3));
		contentPane.setLayout(null);
		

		
		//Numero näppäimistö tilaukselle
		Button1 = new JButton("1");		
		Button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maara.setText(maara.getText() +"1");
			}
		});
		Button1.setBounds(10, 135, 59, 42);
		contentPane.add(Button1);
		
		Button2 = new JButton("2");
		Button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maara.setText(maara.getText() +"2");
			}
		});
		Button2.setBounds(76, 135, 59, 42);
		contentPane.add(Button2);
		
		
		Button3 = new JButton("3");
		Button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maara.setText(maara.getText() +"3");
			}
		});
		Button3.setBounds(145, 135, 59, 42);
		contentPane.add(Button3);
		
		Button6 = new JButton("6");
		Button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maara.setText(maara.getText() +"6");
			}
		});
		Button6.setBounds(145, 188, 59, 42);
		contentPane.add(Button6);
		
		Button5 = new JButton("5");
		Button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maara.setText(maara.getText() +"5");
			}
		});
		Button5.setBounds(76, 188, 59, 42);
		contentPane.add(Button5);
		
		Button4 = new JButton("4");
		Button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maara.setText(maara.getText() +"4");
			}
		});
		Button4.setBounds(10, 188, 59, 42);
		contentPane.add(Button4);
		
		Button7 = new JButton("7");
		Button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maara.setText(maara.getText() +"7");
			}
		});
		Button7.setBounds(10, 241, 59, 42);
		contentPane.add(Button7);
		
		Button8 = new JButton("8");
		Button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maara.setText(maara.getText() +"8");
			}
		});
		Button8.setBounds(76, 241, 59, 42);
		contentPane.add(Button8);
		
		Button9 = new JButton("9");
		Button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maara.setText(maara.getText() +"9");
			}
		});
		Button9.setBounds(145, 241, 59, 42);
		contentPane.add(Button9);
		
		Button0 = new JButton("0");
		Button0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maara.setText(maara.getText() +"0");
			}
		});
		Button0.setBounds(76, 294, 59, 42);
		contentPane.add(Button0);
		
		Buttonclr = new JButton("C");
		Buttonclr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maara.setText("");
				
			}
		});
		Buttonclr.setBounds(10, 294, 59, 42);
		contentPane.add(Buttonclr);
		
		Buttonback = new JButton("<-");
		Buttonback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				String value = maara.getText();
				int lenght =value.length();
				
				if(lenght>0){
					StringBuilder builder = new StringBuilder(value);
					builder.deleteCharAt(lenght-1);
					maara.setText(builder.toString());
				}
				
			}
		});

		Buttonback.setBounds(145, 294, 59, 42);
		contentPane.add(Buttonback);
		
		lblNewLabel = new JLabel("Maara");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(228, 112, 109, 23);
		contentPane.add(lblNewLabel);
		
		//***********************************************//
		
		
		
		
		

		// Bensa valinta nappulat//


		
		//95 nappi
				button95 = new JRadioButton("95E");
				button95.setBackground(new Color(240, 255, 255));
				button95.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Kapasiteetti.setText(Bensiinitankit.textField.getText());
						
						if(button95.isSelected()) {
							button98.setSelected(false);
							buttondiesel.setSelected(false);
						}
					}
				});
				button95.setFont(new Font("Tahoma", Font.BOLD, 20));
				button95.setBounds(10, 69, 109, 31);
				contentPane.add(button95);
				
				
				
				
				
				
		//98 nappi
		button98 = new JRadioButton("98E");
		button98.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Kapasiteetti.setText(Bensiinitankit.textField_1.getText());
				if(button98.isSelected()) {
					button95.setSelected(false);
					buttondiesel.setSelected(false);
				}
			}
		});
		button98.setBackground(new Color(240, 255, 255));
		button98.setFont(new Font("Tahoma", Font.BOLD, 20));
		button98.setBounds(121, 69, 109, 31);
		contentPane.add(button98);
		

		
		
		
		
		
		//Diesel nappi
		buttondiesel = new JRadioButton("Diesel");
		buttondiesel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Kapasiteetti.setText(Bensiinitankit.textField_2.getText());
				
				if(buttondiesel.isSelected()) {
					button98.setSelected(false);
					button95.setSelected(false);
				}
			}
		});
		buttondiesel.setBackground(new Color(240, 255, 255));
		buttondiesel.setFont(new Font("Tahoma", Font.BOLD, 20));
		buttondiesel.setBounds(228, 69, 109, 31);
		contentPane.add(buttondiesel);
		
		
		
		
		
		
		
		//Bensamäärä paljon laitetaan
		
		maara = new JTextField();
		maara.setFont(new Font("Tahoma", Font.BOLD, 20));
		maara.setHorizontalAlignment(SwingConstants.RIGHT);
		maara.setEditable(false);
		maara.setBounds(228, 146, 137, 31);
		contentPane.add(maara);
		maara.setColumns(10);
		
		
		Kapasiteetti = new JTextField();
		Kapasiteetti.setEditable(false);
		
		Kapasiteetti.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		Kapasiteetti.setText("");
		Kapasiteetti.setHorizontalAlignment(SwingConstants.RIGHT);	
		Kapasiteetti.setBounds(10, 373, 199, 31);
		contentPane.add(Kapasiteetti);
		Kapasiteetti.setColumns(10);
		
		//***************************************************//

		

		
		
		
		
		//Tilaus nappi. Tässä asetetaan komento sille, että tilausnappia painamalla
		//lisätäään polttoainetta tankkeihin
		
		Buttontilaa = new JButton("Tilaa");
		Buttontilaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String luku1 = maara.getText();
				String luku2 = Kapasiteetti.getText();
				
				try {
					
				double num1 = Double.parseDouble(luku1);
				double num2 = Double.parseDouble(luku2);
				double num3 = num1 + num2;
				
				
				yhteensa.setText(num3+"");
				if (num3>=10000.0+1.0) {
					JOptionPane.showMessageDialog(null, "Max kapasiteetti 10000l");
				}
		
				
				
				else if(button95.isSelected()) {				
					
					
					
				kirjoitaTiedostoon95(num3, tankki_95e);
				Bensiinitankit.textField.setText(yhteensa.getText());
				
					
				kirjoitaTiedostoon ("TILATTU" + "\n" + "Valittu laatu: 95E "  + "\n" + "Valittu määrä: " + maara.getText() + " litraa."+ "\n", filename);
				JOptionPane.showMessageDialog(null,  "TILATTU" + "\n" + "Valittu laatu: 95E "  + "\n" + "Tilattu määrä: " + 
				maara.getText() + " litraa.");
				maara.setText("");
				}
				

				
				
			
				//98E tilaus

				else if (button98.isSelected())
				{
					kirjoitaTiedostoon98(num3, tankki_98e);
					Bensiinitankit.textField_1.setText(yhteensa.getText());
					kirjoitaTiedostoon ("TILATTU" + "\n" + "Valittu laatu: 98E "  + "\n" + "Valittu määrä: " + maara.getText() + " litraa."+ "\n", filename);
					JOptionPane.showMessageDialog(null,  "TILATTU" + "\n" + "Valittu laatu: 98E "  + "\n" + "Tilattu määrä: " + 
							maara.getText() + " litraa.");
					maara.setText("");
				}

				//Dieselin tilaus
				else if (buttondiesel.isSelected())
				{
					
					
					kirjoitaTiedostoondie(num3, tankki_diesel);
					Bensiinitankit.textField_2.setText(yhteensa.getText());
					
					
					kirjoitaTiedostoon ("TILATTU" + "\n" + "Valittu laatu: DIESEL "  + "\n" + "Valittu määrä: " + maara.getText() + " litraa."+ "\n", filename);
					JOptionPane.showMessageDialog(null,  "TILATTU" + "\n" + "Valittu laatu: DIESEL "  + "\n" + "Tilattu määrä: " + 
							maara.getText() + " litraa.");
					maara.setText("");
				}
			
					
				
				
				} catch (Exception e2) {

					JOptionPane.showMessageDialog(null, "");

					maara.setText("");

			
				}
				
				
				
				
			
			}

				
			
		});
		Buttontilaa.setFont(new Font("Georgia", Font.PLAIN, 16));
		Buttontilaa.setBounds(276, 330, 89, 74);
		contentPane.add(Buttontilaa);
		
		lblNewLabel_1 = new JLabel("Bensatankin tila");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 340, 199, 31);
		contentPane.add(lblNewLabel_1);
		
		yhteensa = new JTextField();
		yhteensa.setHorizontalAlignment(SwingConstants.RIGHT);
		yhteensa.setFont(new Font("Tahoma", Font.BOLD, 20));
		yhteensa.setEditable(false);
		yhteensa.setColumns(10);
		yhteensa.setBounds(228, 199, 137, 31);
		yhteensa.setVisible(false);
		contentPane.add(yhteensa);
		}
		

		public void kirjoitaTiedostoon95(double num3,String tankki_95e) {
			
		
	
			try {
				
			
						
				FileWriter fwriter = new FileWriter(tankki_95e, false);
				fwriter.write(Double.toString(num3));
				fwriter.close();
			
			} catch (Exception e) {
				e.printStackTrace();
			
			}
		}
			public void kirjoitaTiedostoon98(double num3,String tankki_98e) {
				
				try {

					FileWriter fwriter = new FileWriter(tankki_98e, false);
					fwriter.write(Double.toString(num3));
					fwriter.close();
				
				} catch (Exception e) {
					e.printStackTrace();
				}
				}
				public void kirjoitaTiedostoondie(double num3,String tankki_diesel) {
					
					
					
					try {

						FileWriter fwriter = new FileWriter(tankki_diesel, false);
						fwriter.write(Double.toString(num3));
						fwriter.close();
					
					} catch (Exception e) {
						e.printStackTrace();
				
					}}
					public void kirjoitaTiedostoon(String txt, String filename) {
						try {
							java.util.Date date = new java.util.Date();
							FileWriter fwriter = new FileWriter(filename, true);
							fwriter.write(date.toString() + "\n");
							fwriter.write(txt + "\n");
							fwriter.close();
						} catch (Exception e) {
							e.printStackTrace();
							
							
						}}
					
					public static class file{
						
						public static String readFile(String filename) {
							String alltext = "";
							
							try {
								FileReader freader = new FileReader(filename);
								BufferedReader br = new BufferedReader(freader);
								String line;
								while((line = br.readLine()) != null) {
									alltext += line + "\n";
								}
								br.close();
							}
							catch(Exception e) {
								e.printStackTrace();
								alltext = "";
							}
							return alltext;
							
						}

			
	}
}
