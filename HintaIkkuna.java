import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class HintaIkkuna extends JFrame {

	private JPanel contentPane;

	
	public static JTextField textField95;
	private JButton hinta95;
	private JButton hinta98;
	private JButton hintaD;
	private JButton mainos;
	public static JTextField textField98;
	public static JTextField textFieldD;
	public static JTextField textField_3;

	/**
	 * Create the frame.
	 */
	public HintaIkkuna() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 694);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField95 = new JTextField();
		textField95.setHorizontalAlignment(SwingConstants.CENTER);
		textField95.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		textField95.setBounds(186, 65, 219, 43);
		contentPane.add(textField95);
		textField95.setColumns(10);
		
		hinta95 = new JButton("Hinta 95");
		hinta95.setFont(new Font("Century Gothic", Font.BOLD, 18));
		hinta95.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String filename = "src/txt/95.txt";
				kirjoitaTiedostoon(textField95.getText(), filename);
				PaaIkkuna.hinta5.setText(textField95.getText());
			}
		});
		hinta95.setBounds(24, 65, 131, 43);
		contentPane.add(hinta95);
		
		hinta98 = new JButton("Hinta 98");
		hinta98.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String filename = "src/txt/98.txt";
				kirjoitaTiedostoon(textField98.getText(), filename);
				PaaIkkuna.hinta8.setText(textField98.getText());
			}
		});
		hinta98.setFont(new Font("Century Gothic", Font.BOLD, 18));
		hinta98.setBounds(24, 187, 131, 43);
		contentPane.add(hinta98);
		
		hintaD = new JButton("Hinta diesel");
		hintaD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String filename = "src/txt/diesel.txt";
				kirjoitaTiedostoon(textFieldD.getText(), filename);
				PaaIkkuna.hintad.setText(textFieldD.getText());
			}
		});
		hintaD.setFont(new Font("Century Gothic", Font.BOLD, 17));
		hintaD.setBounds(24, 299, 131, 43);
		contentPane.add(hintaD);
		
		mainos = new JButton("Mainos");
		mainos.setFont(new Font("Century Gothic", Font.BOLD, 18));
		mainos.setBounds(24, 503, 131, 43);
		contentPane.add(mainos);
		
		textField98 = new JTextField();
		textField98.setHorizontalAlignment(SwingConstants.CENTER);
		textField98.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		textField98.setColumns(10);
		textField98.setBounds(186, 187, 219, 43);
		contentPane.add(textField98);
		
		textFieldD = new JTextField();
		textFieldD.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldD.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		textFieldD.setColumns(10);
		textFieldD.setBounds(186, 299, 219, 43);
		contentPane.add(textFieldD);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(186, 421, 219, 208);
		contentPane.add(textField_3);
	}
	
//public String lueViisi(String filename) {
//		
//		String alltext = "";
//					
//		try {
//			FileReader freader = new FileReader(filename);
//			BufferedReader br = new BufferedReader(freader);
//			String line;
//			while ((line = br.readLine()) != null) {
//			alltext = alltext + line + "\n";
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			alltext = "";
//			}
//					
//			return alltext;
//	}
				
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
