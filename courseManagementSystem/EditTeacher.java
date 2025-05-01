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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class EditTeacher extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txName;
	private JTextField txCourse;
	private JTextField txPhNm;
	private JTextField txtPasso;
	private JTextField txEmail;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditTeacher frame = new EditTeacher();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EditTeacher() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditTeacher.class.getResource("/pics/skullyHeartIcon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTeacherEditor = new JLabel("TEACHER EDITOR:");
		lblTeacherEditor.setFont(new Font("JetBrains Mono", Font.BOLD, 15));
		lblTeacherEditor.setBounds(154, 11, 169, 27);
		contentPane.add(lblTeacherEditor);
		
		txName = new JTextField();
		txName.setFont(new Font("JetBrains Mono", Font.PLAIN, 13));
		txName.setColumns(10);
		txName.setBounds(70, 55, 128, 27);
		contentPane.add(txName);
		
		JLabel lblNewLabel_1_1 = new JLabel("TName");
		lblNewLabel_1_1.setFont(new Font("JetBrains Mono", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 61, 105, 27);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblDashboard_3 = new JLabel("");
		lblDashboard_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int result = JOptionPane.showConfirmDialog(lblDashboard_3, "Are you sure you want to proceed?", "Confirmation", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					try {
						String emailValidator = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
	                    String email = txEmail.getText();
	                    Pattern emailpattern = Pattern.compile(emailValidator);
	                    Matcher emailmatcher = emailpattern.matcher(email);
	                    
	                    final String PASSWORD_PATTERN = "^(?=.[a-z])(?=.[A-Z])(?=.\\d)(?=.[@$!%?&])[A-Za-z\\d@$!%?&]{8,}$";
	                    String password = txtPasso.getText();
	                    String passwordString = new String(password);
	                    Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
	                    Matcher passmatcher = pattern.matcher(passwordString);
	                    

	                    if (txName.getText().isEmpty() || txEmail.getText().isEmpty() || txPhNm.getText().isEmpty() || txtPasso.getText().isEmpty() || txCourse.getText().isEmpty()) 
	                    {
	                        JOptionPane.showMessageDialog(null, "All fields are required.", null, JOptionPane.ERROR_MESSAGE);
	                        return;
	                    }
	                    
	                    if (!emailmatcher.matches()) {
	                        JOptionPane.showMessageDialog(null, "Email not valid", "Error", JOptionPane.ERROR_MESSAGE);
	                        return;
	                    }
	                    
	                    if (!passmatcher.matches()) {
	                        JOptionPane.showMessageDialog(null, "The password must contain\n"
	                                + " at least 8 characters,\n"
	                                + " including a lowercase letter,\n"
	                                + " an uppercase letter,\n"
	                                + " a number,\n"
	                                + " and a special character.", "Error", JOptionPane.ERROR_MESSAGE);
	                                return;
	                    }
	                    
						Auth.addTeach(txName.getText(),txEmail.getText(),txtPasso.getText(),txPhNm.getText(),txCourse.getText());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "The data was added successfully :))");
					 int result2 = JOptionPane.showConfirmDialog(lblDashboard_3, "Do you want to add another?", "Confirmation", JOptionPane.YES_NO_OPTION);
					 if (result2 == JOptionPane.YES_OPTION) {				   
					  }	
				
				
					 else if(result2 == JOptionPane.NO_OPTION){
						 dispose();
				}
				}
				else if(result == JOptionPane.NO_OPTION) {
					
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
		lblDashboard_3.setIcon(new ImageIcon(EditTeacher.class.getResource("/pics/addIcon.png")));
		lblDashboard_3.setBounds(174, 191, 24, 33);
		contentPane.add(lblDashboard_3);
		
		JLabel lblDashboard_3_1_1 = new JLabel("");
		lblDashboard_3_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(lblDashboard_3_1_1, "Are you sure you want to proceed?", "Confirmation", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					try {
						Auth.deleteTeach(txEmail.getText());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "The data was removed successfully :))");
					 int result2 = JOptionPane.showConfirmDialog(lblDashboard_3, "Do you want to remove another?", "Confirmation", JOptionPane.YES_NO_OPTION);
					 if (result2 == JOptionPane.YES_OPTION) {				   
					  }
				}
				
				else if(result == JOptionPane.NO_OPTION){					
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
		lblDashboard_3_1_1.setIcon(new ImageIcon(EditTeacher.class.getResource("/pics/trashIcon.png")));
		lblDashboard_3_1_1.setBounds(222, 191, 24, 33);
		contentPane.add(lblDashboard_3_1_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(EditTeacher.class.getResource("/pics/eteachIcon.png")));
		lblNewLabel.setBounds(329, 160, 105, 101);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("TEmail");
		lblNewLabel_1_1_1.setFont(new Font("JetBrains Mono", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(222, 55, 66, 27);
		contentPane.add(lblNewLabel_1_1_1);
		
		txCourse = new JTextField();
		txCourse.setFont(new Font("JetBrains Mono", Font.PLAIN, 13));
		txCourse.setColumns(10);
		txCourse.setBounds(291, 90, 128, 27);
		contentPane.add(txCourse);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("TCourse");
		lblNewLabel_1_1_1_2.setFont(new Font("JetBrains Mono", Font.PLAIN, 15));
		lblNewLabel_1_1_1_2.setBounds(222, 96, 117, 27);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_3 = new JLabel("TPhNum");
		lblNewLabel_1_1_1_3.setFont(new Font("JetBrains Mono", Font.PLAIN, 15));
		lblNewLabel_1_1_1_3.setBounds(10, 100, 117, 27);
		contentPane.add(lblNewLabel_1_1_1_3);
		
		JLabel passlbl = new JLabel("TPass");
		passlbl.setFont(new Font("JetBrains Mono", Font.PLAIN, 15));
		passlbl.setBounds(120, 152, 117, 27);
		contentPane.add(passlbl);
		
		txPhNm = new JTextField();
		txPhNm.setFont(new Font("JetBrains Mono", Font.PLAIN, 13));
		txPhNm.setColumns(10);
		txPhNm.setBounds(70, 93, 128, 27);
		contentPane.add(txPhNm);
		
		txtPasso = new JTextField();
		txtPasso.setFont(new Font("JetBrains Mono", Font.PLAIN, 13));
		txtPasso.setColumns(10);
		txtPasso.setBounds(187, 146, 128, 27);
		contentPane.add(txtPasso);
		
		txEmail = new JTextField();
		txEmail.setFont(new Font("JetBrains Mono", Font.PLAIN, 13));
		txEmail.setColumns(10);
		txEmail.setBounds(290, 49, 128, 27);
		contentPane.add(txEmail);
	}
}
