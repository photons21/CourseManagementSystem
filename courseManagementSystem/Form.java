package courseManagementSystem;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Form extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLayeredPane layeredPane = new JLayeredPane();
	private JPanel logIn;
	private JPanel signUp;
	private JTextField txtEmail;
	private JPasswordField txtPass;
	private JTextField textField;
	private JTextField txtUsername;
	private JPasswordField txtPass2;
	private JTextField semail;
	private JTextField txtPhoneNumber;
	JComboBox<String> comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form frame = new Form();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private void updateCombo() {
		try {
			  Auth auth = new Auth(DbManager.getInstance());
			  ResultSet rs = auth.getAddComboItemsStmt().executeQuery();
			  while (rs.next()) {
				  comboBox.addItem(rs.getString("course_name"));
			  }
			} catch (Exception e) {
			  e.printStackTrace();
			}
	  }
	
	public Form() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Form.class.getResource("/pics/titleIcon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1135, 622);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		layeredPane.setBounds(0, 0, 368, 583);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		logIn = new JPanel();
		logIn.setBackground(new Color(255, 255, 255));
		layeredPane.add(logIn, "name_388540908994900");
		logIn.setLayout(null);
		
		JLabel lb1 = new JLabel("WELCOME BACK");
		lb1.setForeground(Color.BLACK);
		lb1.setFont(new Font("JetBrains Mono", Font.BOLD, 40));
		lb1.setBounds(31, 11, 312, 92);
		logIn.add(lb1);
		
		JLabel lb2 = new JLabel("Please enter your details.");
		lb2.setFont(new Font("Inter", Font.PLAIN, 20));
		lb2.setBounds(62, 92, 248, 23);
		logIn.add(lb2);
		
		txtEmail = new JTextField();
		txtEmail.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {    	
                if(txtEmail.getText().equals("E-Mail")){
                	txtEmail.setText("");
                	txtEmail.setForeground(Color.BLACK);
                } 
            }
            
            public void focusLost(FocusEvent e) {
            	if(new String(txtEmail.getText()).isEmpty() && !new String(txtEmail.getText()).equals("E-Mail")) {
            		txtEmail.setForeground(new Color(192, 192, 192));
            		txtEmail.setText("E-Mail");
                    }
            	
            }
        });
		txtEmail.setForeground(Color.GRAY);
		txtEmail.setFont(new Font("Inter", Font.BOLD, 11));
		txtEmail.setHorizontalAlignment(SwingConstants.LEFT);
		txtEmail.setText("E-Mail");
		txtEmail.setColumns(10);
		txtEmail.setBounds(119, 206, 177, 40);
		logIn.add(txtEmail);
		
		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Inter", Font.BOLD, 11));
		txtPass.setForeground(Color.GRAY);
		txtPass.setEchoChar((char)0);
		 txtPass.setText("Password");
		txtPass.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
            if(new String(txtPass.getPassword()).equals("Password")){
            txtPass.setEchoChar('*');
            txtPass.setText("");
            txtPass.setForeground(Color.black);
            }
            }
            public void focusLost(FocusEvent e) {
            if(new String(txtPass.getPassword()).isEmpty() && !new String(txtPass.getPassword()).equals("Password")) {
            txtPass.setEchoChar((char)0);
            txtPass.setForeground(new Color(192, 192, 192));
            txtPass.setText("Password");
            }
            }
            });
		txtPass.setBounds(119, 293, 177, 40);
		logIn.add(txtPass);
		
		JButton logbt = new JButton("Log In");
		
		logbt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					Auth auth = new Auth(DbManager.getInstance());
					ArrayList<String> data = auth.login(txtEmail.getText(), new String(txtPass.getPassword()));
					String role = data.get(1);
					String name = data.get(0);
					Dashboard dashboard = new Dashboard(DbManager.getInstance(), role, name);

                    JOptionPane.showMessageDialog(null, "Hi WELCOME :))");
					dispose();
    				dashboard.setVisible(true);
    				
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage(),null,JOptionPane.ERROR_MESSAGE);
                }
            }
		
		});

		logbt.setFont(new Font("Inter", Font.BOLD, 15));
		logbt.setBounds(148, 367, 109, 30);
		logIn.add(logbt);
		
		JLabel lb3 = new JLabel("Don't have an account?");
		lb3.setFont(new Font("Inter", Font.PLAIN, 15));
		lb3.setBounds(119, 426, 177, 14);
		logIn.add(lb3);
		
		JLabel snup = new JLabel("SIGN UP");
		snup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				layeredPane.removeAll();
				layeredPane.add(signUp);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				snup.setForeground(new Color(102,51,102));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				snup.setForeground(new Color(0,0,0));
			}
		});
		
		snup.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		snup.setBounds(177, 439, 52, 23);
		logIn.add(snup);
		
		JLabel emailIcon  = new JLabel(new ImageIcon(getClass().getResource("../pics/envelopeIcon.png")));
		emailIcon.setBounds(63, 206, 46, 40);
		logIn.add(emailIcon);
		
		JLabel passIcon = new JLabel(new ImageIcon(getClass().getResource("../pics/passIcon.png")));
		passIcon.setBounds(63, 293, 46, 40);
		logIn.add(passIcon);
		
		JLabel handIcon = new JLabel(new ImageIcon(getClass().getResource("../pics/handShake.png")));
		handIcon.setBounds(161, 116, 46, 48);
		logIn.add(handIcon);
		
		textField = new JTextField();
		textField.setBounds(0, 0, -7, -12);
		logIn.add(textField);
		textField.setColumns(10);
		
		JLabel lblCourseManagement = new JLabel("@2023 Course Management System By Nayan");
		lblCourseManagement.setForeground(Color.GRAY);
		lblCourseManagement.setFont(new Font("Inter", Font.PLAIN, 11));
		lblCourseManagement.setBounds(56, 558, 257, 14);
		logIn.add(lblCourseManagement);
		
		signUp = new JPanel();
		signUp.setBackground(new Color(255, 255, 255));
		layeredPane.add(signUp, "name_388642746536700");
		signUp.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create your account");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Inter", Font.BOLD, 25));
		lblNewLabel.setBounds(35, 13, 281, 46);
		signUp.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter the fields below to get started.");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Inter", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(78, 62, 201, 14);
		signUp.add(lblNewLabel_1);
		
		JLabel userIcon2 = new JLabel(new ImageIcon(getClass().getResource("../pics/userIcon.png")));
		userIcon2.setFont(new Font("Inter", Font.PLAIN, 13));
		userIcon2.setBounds(36, 113, 48, 48);
		signUp.add(userIcon2);
		
		JLabel passIcon2 = new JLabel(new ImageIcon(getClass().getResource("../pics/passIcon.png")));
		passIcon2.setFont(new Font("Inter", Font.PLAIN, 13));
		passIcon2.setBounds(35, 186, 48, 48);
		signUp.add(passIcon2);
		
		JLabel emalIcon2 = new JLabel(new ImageIcon(getClass().getResource("../pics/envelopeIcon.png")));
		emalIcon2.setFont(new Font("Inter", Font.PLAIN, 13));
		emalIcon2.setBounds(35, 253, 48, 48);
		signUp.add(emalIcon2);
		
		JLabel phoneIcon = new JLabel(new ImageIcon(getClass().getResource("../pics/phoneIcon.png")));
		phoneIcon.setFont(new Font("Inter", Font.PLAIN, 13));
		phoneIcon.setBounds(35, 320, 48, 48);
		signUp.add(phoneIcon);
		
		JLabel lblCourseManagement_1 = new JLabel("@2023 Course Management System By Nayan");
		lblCourseManagement_1.setForeground(Color.GRAY);
		lblCourseManagement_1.setFont(new Font("Inter", Font.PLAIN, 11));
		lblCourseManagement_1.setBounds(59, 558, 257, 14);
		signUp.add(lblCourseManagement_1);
		
		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {    	
                if(txtUsername.getText().equals("Username")){
                	txtUsername.setText("");
                	txtUsername.setForeground(Color.BLACK);
                } 
            }
            
            public void focusLost(FocusEvent e) {
            	if(new String(txtUsername.getText()).isEmpty() && !new String(txtUsername.getText()).equals("Username")) {
            		txtUsername.setForeground(new Color(192, 192, 192));
            		txtUsername.setText("Username");
                    }
            	
            }
        });
		txtUsername.setText("Username");
		txtUsername.setHorizontalAlignment(SwingConstants.LEFT);
		txtUsername.setForeground(Color.GRAY);
		txtUsername.setFont(new Font("Inter", Font.BOLD, 11));
		txtUsername.setColumns(10);
		txtUsername.setBounds(92, 113, 177, 40);
		signUp.add(txtUsername);
		
		txtPass2 = new JPasswordField();
		txtPass2.setFont(new Font("Inter", Font.BOLD, 11));
		txtPass2.setForeground(Color.GRAY);
		txtPass2.setEchoChar((char)0);
		txtPass2.setText("Password");
		txtPass2.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
            if(new String(txtPass2.getPassword()).equals("Password")){
            txtPass2.setEchoChar('*');
            txtPass2.setText("");
            txtPass2.setForeground(Color.black);
            }
            }
            public void focusLost(FocusEvent e) {
            if(new String(txtPass2.getPassword()).isEmpty() && !new String(txtPass2.getPassword()).equals("Password")) {
            txtPass2.setEchoChar((char)0);
            txtPass2.setForeground(new Color(192, 192, 192));
            txtPass2.setText("Password");
            }
            }
            });
		txtPass2.setBounds(91, 186, 177, 40);
		signUp.add(txtPass2);
		
		semail = new JTextField();
		semail.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {    	
                if(semail.getText().equals("E-Mail")){
                	semail.setText("");
                	semail.setForeground(Color.BLACK);
                } 
            }
            
            public void focusLost(FocusEvent e) {
            	if(new String(semail.getText()).isEmpty() && !new String(semail.getText()).equals("E-Mail")) {
            		semail.setForeground(new Color(192, 192, 192));
            		semail.setText("E-Mail");
                    }
            	
            }
        });
		semail.setText("E-Mail");
		semail.setHorizontalAlignment(SwingConstants.LEFT);
		semail.setForeground(Color.GRAY);
		semail.setFont(new Font("Inter", Font.BOLD, 11));
		semail.setColumns(10);
		semail.setBounds(91, 253, 177, 40);
		signUp.add(semail);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {    	
                if(txtPhoneNumber.getText().equals("Phone Number")){
                	txtPhoneNumber.setText("");
                	txtPhoneNumber.setForeground(Color.BLACK);
                } 
            }
            
            public void focusLost(FocusEvent e) {
            	if(new String(txtPhoneNumber.getText()).isEmpty() && !new String(txtPhoneNumber.getText()).equals("Phone Number")) {
            		txtPhoneNumber.setForeground(new Color(192, 192, 192));
            		txtPhoneNumber.setText("Phone Number");
                    }
            	
            }
        });
		txtPhoneNumber.setText("Phone Number");
		txtPhoneNumber.setHorizontalAlignment(SwingConstants.LEFT);
		txtPhoneNumber.setForeground(Color.GRAY);
		txtPhoneNumber.setFont(new Font("Inter", Font.BOLD, 11));
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBounds(91, 320, 177, 40);
		signUp.add(txtPhoneNumber);
		
		JLabel lblCourseManagement_1_1 = new JLabel("Already have an account?");
		lblCourseManagement_1_1.setForeground(Color.BLACK);
		lblCourseManagement_1_1.setFont(new Font("Inter", Font.PLAIN, 11));
		lblCourseManagement_1_1.setBounds(78, 517, 137, 14);
		signUp.add(lblCourseManagement_1_1);
		
		JLabel lnin = new JLabel("LOG IN");
		lnin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				layeredPane.removeAll();
				layeredPane.add(logIn);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lnin.setForeground(new Color(102,51,102));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lnin.setForeground(new Color(0,0,0));
			}
		});
		lnin.setFont(new Font("Inter", Font.BOLD, 11));
		lnin.setBounds(213, 517, 46, 14);
		signUp.add(lnin);
		
		JLabel accountIcon = new JLabel(new ImageIcon(getClass().getResource("../pics/accountIcon.png")));
		accountIcon.setBounds(305, 12, 48, 48);
		signUp.add(accountIcon);
		
		comboBox = new JComboBox<String>();
		updateCombo();

		comboBox.setBounds(92, 393, 177, 39);
		signUp.add(comboBox);
		
		JLabel phoneIcon_1 = new JLabel(new ImageIcon(Form.class.getResource("/pics/googleIcon.png")));
		phoneIcon_1.setFont(new Font("Inter", Font.PLAIN, 13));
		phoneIcon_1.setBounds(35, 390, 48, 48);
		signUp.add(phoneIcon_1);
		
		JLabel pherror = new JLabel("Phone number must be atleast 10 characters long");
		pherror.setForeground(new Color(128, 0, 255));
		pherror.setVisible(false);
		pherror.setBounds(92, 362, 261, 14);
		signUp.add(pherror);
		
		JLabel emailerror = new JLabel("Please enter a valid email");
		emailerror.setForeground(new Color(128, 0, 255));
		emailerror.setVisible(false);
		emailerror.setBounds(92, 295, 261, 14);
		signUp.add(emailerror);
		
		JLabel passerror1 = new JLabel("Password cannot be empty");
		passerror1.setForeground(new Color(128, 0, 255));
		passerror1.setVisible(false);
		passerror1.setBounds(92, 228, 177, 14);
		signUp.add(passerror1);
		
		JLabel passerror = new JLabel("Password: 8 character, upper & lower case & number");
		passerror.setForeground(new Color(128, 0, 255));
		passerror.setVisible(false);
		passerror.setBounds(92, 228, 261, 14);
		signUp.add(passerror);
		
		JLabel usererror = new JLabel("Please enter a valid email");
		usererror.setForeground(new Color(128, 0, 255));
		usererror.setVisible(false);
		usererror.setBounds(92, 155, 261, 14);
		signUp.add(usererror);
		
		JLabel img = new JLabel(new ImageIcon(getClass().getResource("../pics/bgImg.png")));
		img.setHorizontalAlignment(SwingConstants.TRAILING);
		img.setBounds(366, 0, 753, 583);
		contentPane.add(img);
		
		JButton createbt = new JButton("Sign Up");
		createbt.setFont(new Font("Inter", Font.BOLD, 11));
		
		createbt.setEnabled(false);
		txtPass2.getDocument().addDocumentListener(new DocumentListener() {
	    public void insertUpdate(DocumentEvent e) {
	        validatePassword();
	    }
	    
	    public void removeUpdate(DocumentEvent e) {
	        validatePassword();
	    }

	    public void changedUpdate(DocumentEvent e) {
	        validatePassword();
	    }

	    private void validatePassword() {
	        String password = new String(txtPass2.getPassword());
	        if (password.isEmpty()) {
	            passerror.setVisible(true);
	            passerror1.setVisible(false);
	            createbt.setEnabled(false);
	        } else if (!Regex.validatePassword(password)) {
	            passerror1.setText("Password: 8 character, upper & lower case & number");
	            passerror1.setVisible(true);
	            passerror.setVisible(false);
	            createbt.setEnabled(false);
	        } else {
	            passerror1.setVisible(false);
	            if (Regex.validatePassword(new String(txtPass2.getPassword()))) {
	            	passerror.setVisible(false);
	                createbt.setEnabled(true);
	            }
	        }
	    }
	});

	semail.getDocument().addDocumentListener(new DocumentListener() {
	    public void changedUpdate(DocumentEvent e) {
	        validateEmail();
	    }

	    public void removeUpdate(DocumentEvent e) {
	        validateEmail();
	    }

	    public void insertUpdate(DocumentEvent e) {
	        validateEmail();
	    }

	    private void validateEmail() {
	        String email = semail.getText().trim();
	        if (email.isEmpty()) {
	        	emailerror.setText("Email cannot be empty");
	            
	            emailerror.setVisible(true);
	            createbt.setEnabled(false);
	        } else if (!Regex.validateEmail(email)) {
	        	emailerror.setText("Email is not valid");
	            emailerror.setVisible(true);
	            createbt.setEnabled(false);
	        } else {
	            emailerror.setVisible(false);
	            if (Regex.validatePassword(semail.getText())) {
	                createbt.setEnabled(true);
	            }
	        }
	    }
	});
	
	txtUsername.getDocument().addDocumentListener(new DocumentListener() {
	    public void changedUpdate(DocumentEvent e) {
	        validateUsername();
	    }

	    public void removeUpdate(DocumentEvent e) {
	        validateUsername();
	    }

	    public void insertUpdate(DocumentEvent e) {
	        validateUsername();
	    }

	    private void validateUsername() {
	        String username = txtUsername.getText().trim();
	        if (username.isEmpty()) {
	        	usererror.setText("Username cannot be empty");
	            
	            usererror.setVisible(true);
	            createbt.setEnabled(false);
	        } else if (!Regex.validateUsername(username)) {
	        	usererror.setText("Username must be greater than 4 letters");
	            usererror.setVisible(true);
	            createbt.setEnabled(false);
	        } else {
	            usererror.setVisible(false);
	            if (Regex.validatePassword(txtUsername.getText())) {
	                createbt.setEnabled(true);
	            }
	        }
	    }
	});
	
	txtPhoneNumber.getDocument().addDocumentListener(new DocumentListener() {
	    public void changedUpdate(DocumentEvent e) {
	        validatePhoneNum();
	    }

	    public void removeUpdate(DocumentEvent e) {
	        validatePhoneNum();
	    }

	    public void insertUpdate(DocumentEvent e) {
	        validatePhoneNum();
	    }

	    private void validatePhoneNum() {
	        String phonenum = txtPhoneNumber.getText().trim();
	        if (phonenum.isEmpty()) {
	        	pherror.setText("Phone number cannot be empty");
	            
	            pherror.setVisible(true);
	            createbt.setEnabled(false);
	        } else if (!Regex.validatePhoneNum(phonenum)) {
	        	pherror.setText("Provide proper Phone number");
	            pherror.setVisible(true);
	            createbt.setEnabled(false);
	        } else {
	            pherror.setVisible(false);
	            if (Regex.validatePhoneNum(txtPhoneNumber.getText())) {
	                createbt.setEnabled(true);
	            }
	        }
	    }
	});
		
		createbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    if (txtUsername.getText().isEmpty() || txtUsername.getText().equals("Name") ||  semail.getText().isEmpty() || semail.getText().equals("Email") || txtPhoneNumber.getText().isEmpty() || txtPhoneNumber.getText().equals("Phone Number") || new String(txtPass2.getPassword()).isEmpty() || new String(txtPass2.getPassword()).equals("Password")){
                        JOptionPane.showMessageDialog(null, "All fields are required.", null, JOptionPane.ERROR_MESSAGE);
                    } else {
                        Auth auth = new Auth(DbManager.getInstance());
                    	auth.addCredential(txtUsername.getText(), semail.getText(), txtPhoneNumber.getText(),new String(txtPass2.getPassword()),(String) comboBox.getSelectedItem());
                        JPanel diagpanel = new JPanel();
        				JLabel wellab= new JLabel("Welcome to Course Management System"); 
        				JOptionPane optionPane = new JOptionPane(diagpanel, JOptionPane.PLAIN_MESSAGE);
        		        JDialog dialog = optionPane.createDialog("Account Creation Succesful");
        				wellab.setFont(new Font("Inter", Font.PLAIN, 11));
        				wellab.setHorizontalAlignment(SwingConstants.CENTER);
        				wellab.setBounds(93, 30, 250, 14);
        		        JLabel label = new JLabel(new ImageIcon(getClass().getResource("../pics/confetti.png")));
        		        label.setBounds(0, 0, 108, 113);
        		        diagpanel.setLayout(null);
        		        diagpanel.add(wellab);
        		        diagpanel.add(label);
        		        
        		        JButton btnNewButton = new JButton("CONTINUE");
        		        btnNewButton.addActionListener(new ActionListener() {
        		        	public void actionPerformed(ActionEvent e) {
        		        		layeredPane.removeAll();
        						layeredPane.add(logIn);
        						layeredPane.repaint();
        						layeredPane.revalidate();
        						dialog.dispose();
        		        	}
        		        });
        		        
        		        btnNewButton.setFont(new Font("Inter", Font.BOLD, 11));
        		        btnNewButton.setBounds(159, 60, 108, 23);
        		        diagpanel.add(btnNewButton);
        		        dialog.setSize(new Dimension(365,160));
        		        optionPane.setOptions(new Object[]{});
        		        dialog.setVisible(true);
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage(), null, JOptionPane.ERROR_MESSAGE);
                }
			}
		});
		createbt.setBounds(126, 483, 89, 23);
		signUp.add(createbt);
		
	}
	
}
