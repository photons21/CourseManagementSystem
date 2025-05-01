package courseManagementSystem;

import java.awt.Cursor;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class EditCourse extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tx1;


	public EditCourse() {
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditCourse.class.getResource("/pics/skullyHeartIcon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCourseEditor = new JLabel("COURSE EDITOR:");
		lblCourseEditor.setFont(new Font("JetBrains Mono", Font.BOLD, 15));
		lblCourseEditor.setBounds(151, 21, 138, 27);
		contentPane.add(lblCourseEditor);
		
		JLabel lblNewLabel_1_1 = new JLabel("courseName");
		lblNewLabel_1_1.setFont(new Font("JetBrains Mono", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(56, 110, 96, 14);
		contentPane.add(lblNewLabel_1_1);
		
		tx1 = new JTextField();
		tx1.setFont(new Font("JetBrains Mono", Font.PLAIN, 13));
		tx1.setColumns(10);
		tx1.setBounds(162, 97, 158, 27);
		contentPane.add(tx1);
		
		JLabel lblDashboard_3 = new JLabel("");
		lblDashboard_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tx1.getText().isEmpty()) {

                    JOptionPane.showMessageDialog(null, "All fields are required.");
                }else {
				int result = JOptionPane.showConfirmDialog(lblDashboard_3, "Are you sure you want to proceed?", "Confirmation", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					try {
						Auth.addCourse(tx1.getText());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "The data was added successfully :))");
					 int result2 = JOptionPane.showConfirmDialog(lblDashboard_3, "Do you want to add another?", "Confirmation", JOptionPane.YES_NO_OPTION);
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
		lblDashboard_3.setIcon(new ImageIcon(EditCourse.class.getResource("/pics/addIcon.png")));
		lblDashboard_3.setBounds(203, 167, 24, 33);
		contentPane.add(lblDashboard_3);
		
		JLabel lblDashboard_3_1_1 = new JLabel("");
		lblDashboard_3_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tx1.getText().isEmpty()) {

                    JOptionPane.showMessageDialog(null, "All fields are required.");
                }else {
				int result = JOptionPane.showConfirmDialog(lblDashboard_3_1_1, "Are you sure you want to proceed?", "Confirmation", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					try {
						Auth.deleteCourse(tx1.getText());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "The data was deleted successfully :))");
					 int result2 = JOptionPane.showConfirmDialog(lblDashboard_3_1_1, "Do you want delete another module?", "Confirmation", JOptionPane.YES_NO_OPTION);
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
		lblDashboard_3_1_1.setIcon(new ImageIcon(EditCourse.class.getResource("/pics/trashIcon.png")));
		lblDashboard_3_1_1.setBounds(237, 167, 24, 33);
		contentPane.add(lblDashboard_3_1_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(EditCourse.class.getResource("/pics/bookshelfIcon.png")));
		lblNewLabel.setBounds(346, 155, 88, 106);
		contentPane.add(lblNewLabel);
		
	}
}
