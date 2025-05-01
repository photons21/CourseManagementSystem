package courseManagementSystem;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;

public class Reportcard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLayeredPane layeredPane = new JLayeredPane();
	private JTextField sid;
	private JTextField mid;
	private JTextField m;
	private JPanel defPane;
	private JPanel generatePanel;
	private JPanel viewPanel;
	
	private JTable table;
	Connection connection = null;
	PreparedStatement pStatement = null;
	ResultSet rSet = null;
	String name;

	public Reportcard(DbManager db) {
	
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Reportcard.class.getResource("/pics/skullyHeartIcon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		layeredPane.setBounds(10, 42, 628, 304);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		defPane = new JPanel();
		layeredPane.add(defPane, "name_20420669423300");
		defPane.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				layeredPane.removeAll();
				layeredPane.add(generatePanel);
				layeredPane.repaint();
				layeredPane.revalidate();	
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		lblNewLabel_3.setIcon(new ImageIcon(Reportcard.class.getResource("/pics/welcomeIcon.png")));
		lblNewLabel_3.setBounds(517, 89, 101, 121);
		defPane.add(lblNewLabel_3);
		
		JLabel lblWelcome = new JLabel("WELCOME,");
		lblWelcome.setForeground(new Color(0, 0, 0));
		lblWelcome.setFont(new Font("Inter", Font.BOLD, 40));
		lblWelcome.setBounds(10, 11, 224, 67);
		defPane.add(lblWelcome);
		
		JLabel lblLetsMarkKids = new JLabel("let's grade students and have fun shall we?");
		lblLetsMarkKids.setForeground(Color.GRAY);
		lblLetsMarkKids.setFont(new Font("Inter", Font.BOLD, 15));
		lblLetsMarkKids.setBounds(294, 77, 324, 19);
		defPane.add(lblLetsMarkKids);
		
		JLabel lblOrHasIt = new JLabel("or perhaps you want to watch?");
		lblOrHasIt.setForeground(Color.GRAY);
		lblOrHasIt.setFont(new Font("Inter", Font.BOLD, 15));
		lblOrHasIt.setBounds(10, 191, 324, 19);
		defPane.add(lblOrHasIt);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				layeredPane.removeAll();
				layeredPane.add(viewPanel);
				layeredPane.repaint();
				layeredPane.revalidate();	
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_3_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_3_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		lblNewLabel_3_1.setIcon(new ImageIcon(Reportcard.class.getResource("/pics/watchIcon.png")));
		lblNewLabel_3_1.setBounds(10, 208, 101, 101);
		defPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4 = new JLabel("**click on icons to interact");
		lblNewLabel_4.setFont(new Font("JetBrains Mono", Font.ITALIC, 11));
		lblNewLabel_4.setBounds(432, 287, 196, 14);
		defPane.add(lblNewLabel_4);
		
		generatePanel = new JPanel();
		layeredPane.add(generatePanel, "name_20275255026400");
		generatePanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("SID");
		lblNewLabel_1.setFont(new Font("JetBrains Mono", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(155, 70, 38, 14);
		generatePanel.add(lblNewLabel_1);
		
		sid = new JTextField();
		sid.setColumns(10);
		sid.setBounds(220, 62, 158, 27);
		generatePanel.add(sid);
		
		JLabel lblNewLabel_1_1 = new JLabel("MID");
		lblNewLabel_1_1.setFont(new Font("JetBrains Mono", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(155, 112, 38, 14);
		generatePanel.add(lblNewLabel_1_1);
		
		mid = new JTextField();
		mid.setColumns(10);
		mid.setBounds(220, 102, 158, 27);
		generatePanel.add(mid);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("MARKS");
		lblNewLabel_1_1_1.setFont(new Font("JetBrains Mono", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(155, 151, 63, 14);
		generatePanel.add(lblNewLabel_1_1_1);
		
		m = new JTextField();
		m.setColumns(10);
		m.setBounds(220, 142, 158, 27);
		generatePanel.add(m);
		
		JButton btnNewButton = new JButton("GENERATE");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					  Auth.addResults(sid.getText(),mid.getText(),m.getText());
					  JOptionPane.showMessageDialog(null, "The report was created successfully :))");
					  int result = JOptionPane.showConfirmDialog(btnNewButton, "Do you want generate another report?", "Confirmation", JOptionPane.YES_NO_OPTION);
					  if (result == JOptionPane.YES_OPTION) {					   
					  }
					  else if(result == JOptionPane.NO_OPTION){
					    layeredPane.removeAll();
					    layeredPane.add(defPane);
					    layeredPane.repaint();
					    layeredPane.revalidate();
					  }	
					} catch (Exception e1) {
					  JOptionPane.showMessageDialog(null, "Duplicate or Incorrect Entries in the field");
					}
			}
		});
		btnNewButton.setFont(new Font("Inter", Font.BOLD, 15));
		btnNewButton.setBounds(219, 209, 130, 23);
		generatePanel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Reportcard.class.getResource("/pics/gRIcon.png")));
		lblNewLabel_2.setBounds(10, 224, 80, 69);
		generatePanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				layeredPane.removeAll();
				layeredPane.add(defPane);
				layeredPane.repaint();
				layeredPane.revalidate();	
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_5_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_5_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		lblNewLabel_5_1.setIcon(new ImageIcon(Reportcard.class.getResource("/pics/backIcon.png")));
		lblNewLabel_5_1.setBounds(10, 11, 32, 27);
		generatePanel.add(lblNewLabel_5_1);
		
		viewPanel = new JPanel();
		layeredPane.add(viewPanel, "name_20282022884300");
		viewPanel.setLayout(null);

		java.sql.Statement stmt;

		try {
            stmt = db.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT student_id, module_id, marks FROM results");
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Student id");
            model.addColumn("Module id");
            model.addColumn("Marks");
            model.addColumn("Remarks");

            int passCount = 0;
            int totalModules = 8;
            while (rs.next()) {
                String studentId = rs.getString("student_id");
                String moduleId = rs.getString("module_id");
                int marks = Integer.parseInt(rs.getString("marks"));

                String remarks = "Fail";
                if (marks >= 40) {
                    passCount++;
                    remarks = "Pass";
                }
                model.addRow(new Object[]{studentId, moduleId, marks, remarks});
            }

            JScrollPane scrollPane = new JScrollPane();
            scrollPane.setBounds(30, 7, 580, 255);
            scrollPane.setEnabled(false);
            viewPanel.add(scrollPane);

            table = new JTable(model);
            table.setEnabled(false);
            scrollPane.setViewportView(table);
            
            JLabel lblPromotion = new JLabel("");
            lblPromotion.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
            lblPromotion.setHorizontalAlignment(SwingConstants.RIGHT);
    		lblPromotion.setBounds(30, 273, 580, 14);
    		viewPanel.add(lblPromotion);

            int totalRows = model.getRowCount();
            if (totalRows == totalModules) {
                if (passCount >= 4) {
                    lblPromotion.setText("Promoted");
                    lblPromotion.setForeground(new Color(0,255,0));
                    lblPromotion.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
                } else {
                    lblPromotion.setText("Not Promoted");
                    lblPromotion.setForeground(new Color(255,0,0));
                    lblPromotion.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
                }
            } else {
                lblPromotion.setText("Marks of all modules are not published");
                lblPromotion.setForeground(new Color(0,0,255));
                lblPromotion.setFont(new Font("JetBrains Mono", Font.BOLD, 11));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				layeredPane.removeAll();
				layeredPane.add(defPane);
				layeredPane.repaint();
				layeredPane.revalidate();	
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_5.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		lblNewLabel_5.setIcon(new ImageIcon(Reportcard.class.getResource("/pics/backIcon.png")));
		lblNewLabel_5.setBounds(5, 7, 32, 27);
		viewPanel.add(lblNewLabel_5);

		JLabel lblNewLabel = new JLabel("Performance Report:");
		lblNewLabel.setFont(new Font("JetBrains Mono", Font.BOLD, 25));
		lblNewLabel.setBounds(164, 11, 321, 27);
		contentPane.add(lblNewLabel);
	}
}
