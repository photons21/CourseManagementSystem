package courseManagementSystem;

import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class EditModule extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tx2;
	private JTextField tx1;
	private JTextField tx;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditModule frame = new EditModule();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EditModule() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditModule.class.getResource("/pics/skullyHeartIcon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModuleEditor = new JLabel("MODULE EDITOR:");
		lblModuleEditor.setFont(new Font("JetBrains Mono", Font.BOLD, 15));
		lblModuleEditor.setBounds(153, 24, 138, 27);
		contentPane.add(lblModuleEditor);
		
		JLabel lblNewLabel_1 = new JLabel("CID");
		lblNewLabel_1.setFont(new Font("JetBrains Mono", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(113, 152, 38, 14);
		contentPane.add(lblNewLabel_1);
		
		tx2 = new JTextField();
		tx2.setFont(new Font("JetBrains Mono", Font.PLAIN, 13));
		tx2.setColumns(10);
		tx2.setBounds(161, 148, 158, 27);
		contentPane.add(tx2);
		
		JLabel lblNewLabel_1_1 = new JLabel("moduleType");
		lblNewLabel_1_1.setFont(new Font("JetBrains Mono", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(55, 113, 96, 27);
		contentPane.add(lblNewLabel_1_1);
		
		tx1 = new JTextField();
		tx1.setFont(new Font("JetBrains Mono", Font.PLAIN, 13));
		tx1.setColumns(10);
		tx1.setBounds(161, 111, 158, 27);
		contentPane.add(tx1);
		
		JLabel lblDashboard_3 = new JLabel("");
		lblDashboard_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tx.getText().isEmpty() || tx1.getText().isEmpty() || tx2.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All fields are required.");
                    
                }else {
				int result = JOptionPane.showConfirmDialog(lblDashboard_3, "Are you sure you want to proceed?", "Confirmation", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					try {
						Auth.addModule(tx.getText(), tx1.getText(), tx2.getText());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "The data was added successfully :))");
					 int result2 = JOptionPane.showConfirmDialog(lblDashboard_3, "Do you want generate another report?", "Confirmation", JOptionPane.YES_NO_OPTION);
					 if (result2 == JOptionPane.YES_OPTION) {				   
					  }
					 else if(result2 == JOptionPane.NO_OPTION) {
					dispose();
					 }
				}	
				
				else if(result == JOptionPane.NO_OPTION){					
				}	
			}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblDashboard_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblDashboard_3.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		lblDashboard_3.setIcon(new ImageIcon(EditModule.class.getResource("/pics/addIcon.png")));
		lblDashboard_3.setBounds(209, 187, 24, 33);
		contentPane.add(lblDashboard_3);
		
		JLabel lblDashboard_3_1_1 = new JLabel("");
		lblDashboard_3_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tx.getText().isEmpty() || tx1.getText().isEmpty() || tx2.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All fields are required.");
                    
                }else {
				int result = JOptionPane.showConfirmDialog(lblDashboard_3_1_1, "Are you sure you want to proceed?", "Confirmation", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					
					
					try {
						Auth.deleteModule(tx.getText());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "The data was deleted successfully :))");
					 int result2 = JOptionPane.showConfirmDialog(lblDashboard_3, "Do you want to delete another module?", "Confirmation", JOptionPane.YES_NO_OPTION);
					 if (result2 == JOptionPane.YES_OPTION) {				   
					  }
					 else if(result2 == JOptionPane.NO_OPTION) {
					dispose();
					 }	
					
				}
				
				else if(result == JOptionPane.NO_OPTION){					
				}	
                }
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblDashboard_3_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblDashboard_3_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		lblDashboard_3_1_1.setIcon(new ImageIcon(EditModule.class.getResource("/pics/trashIcon.png")));
		lblDashboard_3_1_1.setBounds(255, 187, 24, 33);
		contentPane.add(lblDashboard_3_1_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(EditModule.class.getResource("/pics/creportIcon.png")));
		lblNewLabel.setBounds(338, 172, 96, 100);
		contentPane.add(lblNewLabel);
		
		tx = new JTextField();
		tx.setFont(new Font("JetBrains Mono", Font.PLAIN, 13));
		tx.setColumns(10);
		tx.setBounds(161, 73, 158, 27);
		contentPane.add(tx);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("moduleName");
		lblNewLabel_1_1_1.setFont(new Font("JetBrains Mono", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(55, 75, 96, 27);
		contentPane.add(lblNewLabel_1_1_1);
	}

}
