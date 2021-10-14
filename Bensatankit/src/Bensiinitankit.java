import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JToolBar;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.JTextPane;
import java.awt.Panel;

public class Bensiinitankit extends JFrame {

	static DecimalFormat df = new DecimalFormat("###.##");
	private JPanel contentPane;
	private JButton button;
	private Bensaikkuna Bensaikkuna = new Bensaikkuna();
	private JMenuBar menuBar;
	private JMenu Valikko1;
	private JMenuItem Poistu_nappi;
	private JLabel laatulabel;
	private JLabel bensalabel;
	private JLabel tankkilabel;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	public static JTextField textField;
	public static JTextField textField_1;
	public static JTextField textField_2;

	public static String filename = "C:/temp/BensaAsema/Tilaushistoria.txt";
	public static String file_95e = "C:/temp/BensaAsema/T95E.txt";
	public static String file_98e = "C:/temp/BensaAsema/T98E.txt";
	public static String file_diesel = "C:/temp/BensaAsema/TDiesel.txt";
	private JButton btnNewButton;
	private JButton btnTilaaeTyteen;
	private JButton btnTilaaDieTyteen;

	// "C:/temp/BensaAsema/agency-fb.ttf"
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bensiinitankit frame = new Bensiinitankit();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Bensiinitankit() {
		setTitle("Tankit");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 449);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		Valikko1 = new JMenu("Valikko");
		menuBar.add(Valikko1);

		Poistu_nappi = new JMenuItem("Poistu");
		Poistu_nappi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Haluatko varmasti lopettaa?", "Lopetus?",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (result == JOptionPane.OK_OPTION) {
					// tulostaTiedostoon(Poistu_nappi.getText(), filename);
					System.exit(0);
				}
				if (result == JOptionPane.NO_OPTION) {
				}
			}
		});

		Valikko1.add(Poistu_nappi);
		
		
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		getContentPane().setBackground(new Color(240, 255, 255)); 
		contentPane.setBorder(new LineBorder(new Color(107, 142, 35), 3));
		contentPane.setLayout(null);

		
		
		//Tilaa lisää polttoainetta nappi
		
		button = new JButton("Tilaa lis\u00E4\u00E4 polttoainetta");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bensaikkuna.dispose();
				Bensaikkuna = new Bensaikkuna();

				Bensaikkuna.setVisible(true);

			}
		});
		button.setBounds(10, 322, 222, 51);
		contentPane.add(button);

		laatulabel = new JLabel("Laatu");
		laatulabel.setHorizontalAlignment(SwingConstants.CENTER);
		laatulabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		laatulabel.setBounds(0, 95, 88, 35);
		contentPane.add(laatulabel);

		bensalabel = new JLabel("Bensam\u00E4\u00E4r\u00E4");
		bensalabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		bensalabel.setBounds(171, 91, 206, 43);
		contentPane.add(bensalabel);

		tankkilabel = new JLabel("POLTTOAINETANKIT");
		tankkilabel.setHorizontalAlignment(SwingConstants.CENTER);
		tankkilabel.setVerticalAlignment(SwingConstants.TOP);
		tankkilabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		tankkilabel.setBounds(183, 11, 318, 35);
		contentPane.add(tankkilabel);

		label1 = new JLabel("95E");
		label1.setBackground(Color.WHITE);
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("Tahoma", Font.BOLD, 22));
		label1.setForeground(Color.BLACK);
		label1.setBounds(0, 142, 91, 35);
		contentPane.add(label1);

		label2 = new JLabel("98E");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setForeground(Color.BLACK);
		label2.setFont(new Font("Tahoma", Font.BOLD, 22));
		label2.setBounds(0, 210, 91, 35);
		contentPane.add(label2);

		label3 = new JLabel("Diesel");
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setForeground(Color.BLACK);
		label3.setFont(new Font("Tahoma", Font.BOLD, 22));
		label3.setBounds(0, 276, 91, 35);
		contentPane.add(label3);

		// 95E tankin määrä

		textField = new JTextField();
		textField.setEditable(false);

		String teksti95 = luetiedostosta(file_95e);
		
		double ysiviis = Double.parseDouble(teksti95);
		
		
		if (ysiviis >= 0 && ysiviis <= 2000) {
			
			textField.setBackground(Color.RED);
			
			
		}

		else if (ysiviis >= 2000.0 && ysiviis < 6000.0) {
			textField.setBackground(Color.YELLOW);
			
		}

		else if (ysiviis >= 6000) {
			
			textField.setBackground(Color.GREEN);
			
					}
		else return;
		
		textField.setText(teksti95);

		textField.setFont(new Font("Monospaced", Font.BOLD, 22));
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setBounds(181, 145, 121, 35);
		contentPane.add(textField);
		textField.setColumns(10);

		// 98E tankin määrä

		textField_1 = new JTextField(10000);
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setFont(new Font("Monospaced", Font.BOLD, 22));
		textField_1.setEditable(false);

		String teksti98 = luetiedostosta(file_98e);
		
		double ysikasi = Double.parseDouble(teksti98);

		
		if (ysikasi >= 0 && ysikasi <= 2000) {
			textField_1.setBackground(Color.RED);
			
		}

		else if (ysikasi >= 2000.0 && ysikasi < 6000.0) {
			textField_1.setBackground(Color.YELLOW);
		
		}

		else if (ysikasi >= 6000) {
			textField_1.setBackground(Color.GREEN);
		}
		else return;
		textField_1.setText(teksti98);
		textField_1.setColumns(10);
		textField_1.setBounds(181, 210, 121, 35);
		contentPane.add(textField_1);

		// diesel tankin määrä
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_2.setFont(new Font("Monospaced", Font.BOLD, 22));
		textField_2.setEditable(false);
		
		String tekstidiesel = luetiedostosta(file_diesel);
		
		double diesel = Double.parseDouble(tekstidiesel);

		
		if (diesel >= 0 && diesel <= 2000) {
			textField_2.setBackground(Color.RED);
		}

		else if (diesel >= 2000.0 && diesel < 6000.0) {
			textField_2.setBackground(Color.YELLOW);
		}

		else if (diesel >= 6000) {
			textField_2.setBackground(Color.GREEN);
		}
		else return;

		textField_2.setText(tekstidiesel);
		textField_2.setColumns(10);
		textField_2.setBounds(181, 276, 121, 35);
		contentPane.add(textField_2);
		
		
		
		// Tilataan 95 tankki täyteen tästä
		btnNewButton = new JButton("Tilaa 95E täyteen");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String luku1 = ("10000.0");

				double ysiviis = Double.parseDouble(luku1);

				int result = JOptionPane.showConfirmDialog(null, "Tilataanko tankki täyteen?", "UUSI TAPAHTUMA!",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (result == JOptionPane.OK_OPTION) {
					textField.setText(luku1);
					textField.setBackground(Color.GREEN);
					kirjoitaTiedostoon95(luku1, file_95e);
					kirjoitaTiedostoon(
							"TILATTU" + "\n" + "Valittu laatu: 95E " + "\n" + "Tilattu tankki täyteen!" + "\n",
							filename);
				}

				if (result == JOptionPane.NO_OPTION) {

				}

			}
		});	
		btnNewButton.setBounds(364, 145, 252, 31);
		contentPane.add(btnNewButton);
		
		
		


		// Tilataan 98 tankki täyteen tästä
		btnTilaaeTyteen = new JButton("Tilaa 98E täyteen");
		btnTilaaeTyteen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String luku1 = ("10000.0");

				double ysikasi = Double.parseDouble(luku1);

				int result = JOptionPane.showConfirmDialog(null, "Tilataanko tankki täyteen?", "UUSI TAPAHTUMA!",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

				if (result == JOptionPane.OK_OPTION) {
					textField_1.setText(luku1);
					textField_1.setBackground(Color.GREEN);
					kirjoitaTiedostoon95(luku1, file_98e);
					{
						kirjoitaTiedostoon(
								"TILATTU" + "\n" + "Valittu laatu: 98E " + "\n" + "Tilattu tankki täyteen!" + "\n",
								filename);
					}

					if (result == JOptionPane.NO_OPTION) {

					}
				}
			}
		});
		btnTilaaeTyteen.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnTilaaeTyteen.setBounds(364, 214, 252, 31);
		contentPane.add(btnTilaaeTyteen);

		
		
		
		// Tilataan diesel tankki täyteen tästä
		btnTilaaDieTyteen = new JButton("Tilaa DIE täyteen");
		btnTilaaDieTyteen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String luku1 = ("10000.0");

				double diesel = Double.parseDouble(luku1);

				int result = JOptionPane.showConfirmDialog(null, "Tilataanko tankki täyteen?", "UUSI TAPAHTUMA!",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (result == JOptionPane.OK_OPTION) {
					textField_2.setText(luku1);
					textField_2.setBackground(Color.GREEN);
					kirjoitaTiedostoon95(luku1, file_diesel);
					{
						kirjoitaTiedostoon(
								"TILATTU" + "\n" + "Valittu laatu: DIESEL " + "\n" + "Tilattu tankki täyteen!" + "\n",
								filename);
					}

					if (result == JOptionPane.NO_OPTION) {

					}
				}
			}
		});
		btnTilaaDieTyteen.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnTilaaDieTyteen.setBounds(364, 280, 252, 31);
		contentPane.add(btnTilaaDieTyteen);

	}

	

	public static String luetiedostosta(String filePath)

	{
		String content = "";

		try

		{

			content = new String(Files.readAllBytes(Paths.get(filePath)));

		}

		catch (IOException e)

		{

			e.printStackTrace();

			content = "";

		}

		return removeLastChars(content, 0);

	}
	
	public static String removeLastChars(String str, int chars) {

		return str.substring(0, str.length() - chars);
	}
	
	
	
	public void kirjoitaTiedostoon95(String txt, String file_95e) {

		try {

			FileWriter fwriter = new FileWriter(file_95e, false);
			fwriter.write(txt);
			fwriter.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	

	public void kirjoitaTiedostoon98(String txt, String file_98e) {

		try {

			FileWriter fwriter = new FileWriter(file_98e, false);
			fwriter.write(txt);
			fwriter.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void kirjoitaTiedostoondie(String txt, String file_diesel) {

		try {

			FileWriter fwriter = new FileWriter(file_diesel, false);
			fwriter.write(txt);
			fwriter.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void kirjoitaTiedostoon(String txt, String filename) {
		try {
			java.util.Date date = new java.util.Date();
			FileWriter fwriter = new FileWriter(filename, true);
			fwriter.write(date.toString() + "\n");
			fwriter.write(txt + "\n");
			fwriter.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	
	}
}
