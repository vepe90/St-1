import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.JDesktopPane;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import javax.swing.JEditorPane;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class PaaIkkuna extends JFrame {






	private JPanel contentPane;
	private JButton mainos;
	private JLabel lblNewLabel;

	private JButton viisi;
	private JButton kasi;
	private JButton diesel;
	public static JLabel hinta5;
	public static JLabel hinta8;
	public static JLabel hintad;

	private HintaIkkuna hintaIkkuna = new HintaIkkuna();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaaIkkuna frame = new PaaIkkuna();
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
	public PaaIkkuna() {
		setTitle("St Hamk");
		setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage(PaaIkkuna.class.getResource("/Img/station.png")));
		setForeground(new Color(102, 102, 51));
		setBackground(new Color(107, 142, 35));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 666);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(144, 238, 144));
		contentPane.setBorder(new LineBorder(new Color(107, 142, 35), 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		viisi = new JButton("");
		viisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hintaIkkuna.dispose();
				hintaIkkuna = new HintaIkkuna();
				hintaIkkuna.setVisible(true);
			}
		});
		viisi.setIcon(new ImageIcon(PaaIkkuna.class.getResource("/Img/95p.jpg")));
		viisi.setBorder(new LineBorder(new Color(107, 142, 35), 2, true));
		viisi.setBackground(new Color(255, 255, 255));
		viisi.setBounds(47, 167, 105, 105);
		contentPane.add(viisi);
		
		kasi = new JButton("");
		kasi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hintaIkkuna.dispose();
				hintaIkkuna = new HintaIkkuna();
				hintaIkkuna.setVisible(true);
			}
		});
		kasi.setIcon(new ImageIcon(PaaIkkuna.class.getResource("/Img/98p.jpg")));
		kasi.setBorder(new LineBorder(new Color(107, 142, 35), 2, true));
		kasi.setBackground(new Color(255, 255, 255));
		kasi.setBounds(47, 293, 105, 105);
		contentPane.add(kasi);
		
		diesel = new JButton("");
		diesel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hintaIkkuna.dispose();
				hintaIkkuna = new HintaIkkuna();
				hintaIkkuna.setVisible(true);
			}
		});
		diesel.setIcon(new ImageIcon(PaaIkkuna.class.getResource("/Img/dieselp.jpg")));
		diesel.setBorder(new LineBorder(new Color(107, 142, 35), 2, true));
		diesel.setBackground(new Color(255, 255, 255));
		diesel.setBounds(47, 424, 105, 105);
		contentPane.add(diesel);
		
		hinta5 = new JLabel("");
		hinta5.setHorizontalAlignment(SwingConstants.CENTER);
		hinta5.setFont(new Font("Agency FB", Font.BOLD, 50));
		hinta5.setBorder(new LineBorder(new Color(107, 142, 35), 2, true));
		hinta5.setOpaque(true);
		hinta5.setBackground(new Color(255, 255, 255));
		hinta5.setBounds(190, 186, 178, 67);
		contentPane.add(hinta5);
		
		hinta8 = new JLabel("");
		hinta8.setHorizontalAlignment(SwingConstants.CENTER);
		hinta8.setFont(new Font("Agency FB", Font.BOLD, 50));
		hinta8.setOpaque(true);
		hinta8.setBorder(new LineBorder(new Color(107, 142, 35), 2, true));
		hinta8.setBackground(new Color(255, 255, 255));
		hinta8.setBounds(190, 314, 178, 67);
		contentPane.add(hinta8);
		
		hintad = new JLabel("");
		hintad.setFont(new Font("Agency FB", Font.BOLD, 50));
		hintad.setHorizontalAlignment(SwingConstants.CENTER);
		hintad.setOpaque(true);
		hintad.setBorder(new LineBorder(new Color(107, 142, 35), 2, true));
		hintad.setBackground(Color.WHITE);
		hintad.setBounds(190, 443, 178, 67);
		contentPane.add(hintad);
		
		mainos = new JButton("");
		mainos.setBounds(67, 28, 55, 55);
		contentPane.add(mainos);
		mainos.setBackground(new Color(255, 255, 255));
		mainos.setBorder(new LineBorder(new Color(107, 142, 35), 3, true));
		mainos.setIcon(new ImageIcon(PaaIkkuna.class.getResource("/Img/gas.png")));
		
		lblNewLabel = new JLabel("Tervetuloa!");
		lblNewLabel.setBorder(new LineBorder(new Color(107, 142, 35), 4, true));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBounds(153, 23, 260, 67);
		contentPane.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 36));
	}
}