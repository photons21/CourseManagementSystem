package courseManagementSystem;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

public class Dashboard extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8990917446457470817L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable stdTable;
	private JTable instructorTable;
	private JTable courseTable;
	DbManager db;
	private JTable ctable;
	JLayeredPane layeredPane;
	JTextArea todoArea;
	JTextArea notifArea;
	private String userrole;
	JButton courseEditBtn;
	JButton moduleEditBtn;
	JButton editTeacherBtn;

	public Dashboard(DbManager db, String role, String name) {
		userrole = role;
		setIconImage(Toolkit.getDefaultToolkit().getImage(Dashboard.class.getResource("/pics/titleIcon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 823);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(new Color(255, 255, 255));
		layeredPane.setBounds(198, 139, 674, 608);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel dashboardPanel = new JPanel();
		dashboardPanel.setLocation(-472, -49);
		dashboardPanel.setBackground(new Color(255, 255, 255));
		layeredPane.add(dashboardPanel, "name_455849204305800");
		dashboardPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("DASHBOARD");
		lblNewLabel_1.setForeground(new Color(128, 128, 128));
		lblNewLabel_1.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 12, 136, 33);
		dashboardPanel.add(lblNewLabel_1);
		
		JPanel sp = new JPanel();
		sp.setBorder(UIManager.getBorder("DesktopIcon.border"));
		sp.setBounds(10, 62, 165, 130);
		dashboardPanel.add(sp);
		sp.setLayout(null);
		
		JLabel slbl = new JLabel("Student:");
		slbl.setForeground(new Color(0, 0, 0));
		slbl.setFont(new Font("Inter", Font.BOLD, 14));
		slbl.setBounds(52, 11, 74, 14);
		sp.add(slbl);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(Dashboard.class.getResource("/pics/dashStud.png")));
		lblNewLabel_7.setBounds(32, 29, 123, 94);
		sp.add(lblNewLabel_7);
		
		JPanel totIns = new JPanel();
		totIns.setForeground(new Color(0, 0, 0));
		totIns.setBorder(UIManager.getBorder("DesktopIcon.border"));
		totIns.setBounds(240, 62, 165, 130);
		dashboardPanel.add(totIns);
		totIns.setLayout(null);
		
		JLabel tlbl = new JLabel("Teacher:");
		tlbl.setForeground(new Color(0, 0, 0));
		tlbl.setFont(new Font("Inter", Font.BOLD, 14));
		tlbl.setBounds(52, 11, 77, 14);
		totIns.add(tlbl);
		
		JLabel lblNewLabel_7_1 = new JLabel("");
		lblNewLabel_7_1.setIcon(new ImageIcon(Dashboard.class.getResource("/pics/dashTeach.png")));
		lblNewLabel_7_1.setBounds(32, 26, 123, 101);
		totIns.add(lblNewLabel_7_1);
		
		JPanel totCrs = new JPanel();
		totCrs.setBorder(UIManager.getBorder("DesktopIcon.border"));
		totCrs.setBounds(472, 62, 165, 130);
		dashboardPanel.add(totCrs);
		totCrs.setLayout(null);
		
		JLabel clbl = new JLabel("Course:");
		clbl.setFont(new Font("Inter", Font.BOLD, 14));
		clbl.setBounds(51, 11, 84, 14);
		totCrs.add(clbl);
		
		JLabel lblNewLabel_7_3 = new JLabel("");
		lblNewLabel_7_3.setIcon(new ImageIcon(Dashboard.class.getResource("/pics/dashCourse.png")));
		lblNewLabel_7_3.setBounds(40, 33, 135, 94);
		totCrs.add(lblNewLabel_7_3);
		
		JLabel lblTodo = new JLabel("TO-DO");
		lblTodo.setBounds(98, 222, 69, 44);
		dashboardPanel.add(lblTodo);
		lblTodo.setForeground(new Color(0, 0, 0));
		lblTodo.setFont(new Font("Inter", Font.BOLD, 20));
		
		JLabel lblDashboard_1 = new JLabel("");
		lblDashboard_1.setBounds(167, 222, 24, 44);
		dashboardPanel.add(lblDashboard_1);
		lblDashboard_1.setIcon(new ImageIcon(Dashboard.class.getResource("/pics/todoIcon.png")));
		
		JPanel todoPanel = new JPanel();
		todoPanel.setBounds(40, 260, 230, 311);
		dashboardPanel.add(todoPanel);
		todoPanel.setBorder(UIManager.getBorder("DesktopIcon.border"));
		todoPanel.setBackground(new Color(255, 255, 255));
		todoPanel.setLayout(null);
		
		JLabel lblUsername2 = new JLabel("WELL DONE,");
		lblUsername2.setForeground(new Color(0, 0, 0));
		lblUsername2.setFont(new Font("Inter", Font.BOLD, 20));
		lblUsername2.setBounds(10, 21, 136, 34);
		todoPanel.add(lblUsername2);
		
		JLabel lblCompletedAllThe = new JLabel("all the tasks are completed");
		lblCompletedAllThe.setForeground(new Color(0, 0, 0));
		lblCompletedAllThe.setFont(new Font("Inter", Font.BOLD, 15));
		lblCompletedAllThe.setBounds(10, 57, 210, 19);
		todoPanel.add(lblCompletedAllThe);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Dashboard.class.getResource("/pics/thumbsIcon.png")));
		lblNewLabel_2.setBounds(57, 149, 110, 117);
		todoPanel.add(lblNewLabel_2);
		
		JPanel todoPanel_1 = new JPanel();
		todoPanel_1.setLayout(null);
		todoPanel_1.setBorder(UIManager.getBorder("DesktopIcon.border"));
		todoPanel_1.setBackground(Color.WHITE);
		todoPanel_1.setBounds(398, 262, 230, 311);
		dashboardPanel.add(todoPanel_1);
		
		JLabel lblNoNewNotfication = new JLabel("no new notfications");
		lblNoNewNotfication.setForeground(Color.BLACK);
		lblNoNewNotfication.setFont(new Font("Inter", Font.BOLD, 15));
		lblNoNewNotfication.setBounds(10, 57, 210, 19);
		todoPanel_1.add(lblNoNewNotfication);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(Dashboard.class.getResource("/pics/sleepingIcon.png")));
		lblNewLabel_2_1.setBounds(57, 149, 110, 117);
		todoPanel_1.add(lblNewLabel_2_1);
		
		JLabel lblRingring = new JLabel("Zzzzzzzz,");
		lblRingring.setForeground(Color.BLACK);
		lblRingring.setFont(new Font("Inter", Font.BOLD, 20));
		lblRingring.setBounds(10, 21, 119, 34);
		todoPanel_1.add(lblRingring);
		
		JLabel lblAlert = new JLabel("ALERT");
		lblAlert.setForeground(Color.BLACK);
		lblAlert.setFont(new Font("Inter", Font.BOLD, 20));
		lblAlert.setBounds(474, 222, 69, 44);
		dashboardPanel.add(lblAlert);
		
		JLabel lblDashboard_1_1 = new JLabel("");
		lblDashboard_1_1.setIcon(new ImageIcon(Dashboard.class.getResource("/pics/sirenIcon.png")));
		lblDashboard_1_1.setBounds(541, 222, 24, 44);
		dashboardPanel.add(lblDashboard_1_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(192, 192, 192));
		separator.setBounds(10, 200, 654, 1);
		dashboardPanel.add(separator);
		
		JPanel coursesPanel = new JPanel();
		coursesPanel.setBackground(new Color(255, 255, 255));
		layeredPane.add(coursesPanel, "name_455892295651400");
		coursesPanel.setLayout(null);
		
		JLabel lblNewLabel_1_3 = new JLabel("COURSES");
		lblNewLabel_1_3.setForeground(new Color(128, 128, 128));
		lblNewLabel_1_3.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(10, 30, 102, 33);
		coursesPanel.add(lblNewLabel_1_3);
		
		java.sql.Statement stmt3;
		try {
            stmt3 = db.getConnection().createStatement();
            ResultSet rs = stmt3.executeQuery("SELECT course_ID,course_name FROM courses");
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("id");
            model.addColumn("CourseName");

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("course_ID"),rs.getString("course_name")});
            }
            JScrollPane scrollPane_3 = new JScrollPane();
            scrollPane_3.setBounds(10, 111, 654, 125);
            scrollPane_3.setEnabled(false);
            coursesPanel.add(scrollPane_3);

            courseTable = new JTable(model);
            courseTable.setEnabled(false);
            scrollPane_3.setViewportView(courseTable);

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
		
		
		java.sql.Statement stmt4;
		try {
            stmt4 = db.getConnection().createStatement();
            ResultSet rs = stmt4.executeQuery("SELECT module_ID,module_name,module_type,course_ID FROM modules");
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("module_ID");
            model.addColumn("module_name");
            model.addColumn("module_type");
            model.addColumn("course_ID");
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("module_ID"),rs.getString("module_name"),rs.getString("module_type"),rs.getString("course_ID")});
            }
            JScrollPane scrollPane_4 = new JScrollPane();
    		scrollPane_4.setBounds(10, 325, 654, 228);
    		coursesPanel.add(scrollPane_4);
    		scrollPane_4.setEnabled(false);
    		
    		ctable = new JTable(model);
    		ctable.setEnabled(false);
    		scrollPane_4.setViewportView(ctable);
    		
    		JLabel lblNewLabel_1_3_1 = new JLabel("MODULES");
    		lblNewLabel_1_3_1.setForeground(Color.GRAY);
    		lblNewLabel_1_3_1.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
    		lblNewLabel_1_3_1.setBounds(10, 247, 102, 33);
    		coursesPanel.add(lblNewLabel_1_3_1);
    		
    		courseEditBtn = new JButton("EDIT COURSE");
    		courseEditBtn.addMouseListener(new MouseAdapter() {
    			@Override
    			public void mouseClicked(MouseEvent e) {
    				EditCourse ec = new EditCourse();
    				ec.setVisible(true);
    				ec.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    			}
    		});
    		
    		courseEditBtn.setHorizontalAlignment(SwingConstants.LEFT);
    		courseEditBtn.setFont(new Font("JetBrains Mono", Font.PLAIN, 14));
    		courseEditBtn.setBounds(224, 75, 130, 25);
    		
    		
    		moduleEditBtn = new JButton("EDIT MODULE");
    		moduleEditBtn.addMouseListener(new MouseAdapter() {
    			@Override
    			public void mouseClicked(MouseEvent e) {
    				EditModule em = new EditModule();
    				em.setVisible(true);
    				em.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    			}
    		});
    		moduleEditBtn.setHorizontalAlignment(SwingConstants.LEFT);
    		moduleEditBtn.setFont(new Font("JetBrains Mono", Font.PLAIN, 14));
    		moduleEditBtn.setBounds(224, 289, 130, 25);
    		

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
		
		JPanel teacherPanel = new JPanel();
		teacherPanel.setBackground(new Color(255, 255, 255));
		layeredPane.add(teacherPanel, "name_455920961417500");
		teacherPanel.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("TEACHERS");
		lblNewLabel_1_1.setForeground(new Color(128, 128, 128));
		lblNewLabel_1_1.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(10, 12, 150, 33);
		teacherPanel.add(lblNewLabel_1_1);
		
		java.sql.Statement stmt2;
		try {
            stmt2 = db.getConnection().createStatement();
            ResultSet rs = stmt2.executeQuery("SELECT id, name, email, phoneNo, course FROM auth WHERE role='Teacher'");
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("id");
            model.addColumn("name");
            model.addColumn("email");
            model.addColumn("phoneNo");
            model.addColumn("course");

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("id"),rs.getString("name"), rs.getString("email"),
                                          rs.getString("phoneNo"), rs.getString("course")});
            }
            JScrollPane scrollPane_2 = new JScrollPane();
            scrollPane_2.setBounds(10, 95, 654, 502);
            scrollPane_2.setEnabled(false);
            teacherPanel.add(scrollPane_2);

            instructorTable = new JTable(model);
            instructorTable.setEnabled(false);
            scrollPane_2.setViewportView(instructorTable);

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
		
		editTeacherBtn = new JButton("EDIT ");
		editTeacherBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EditTeacher et = new EditTeacher();
				et.setVisible(true);
				et.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			}
		});
		editTeacherBtn.setFont(new Font("JetBrains Mono", Font.PLAIN, 14));
		editTeacherBtn.setBounds(262, 54, 90, 25);
		
		JPanel studentsPanel = new JPanel();
		studentsPanel.setBackground(new Color(255, 255, 255));
		layeredPane.add(studentsPanel, "name_471990230782800");
		studentsPanel.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("STUDENTS");
		lblNewLabel_1_2.setForeground(new Color(128, 128, 128));
		lblNewLabel_1_2.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(10, 12, 114, 33);
		studentsPanel.add(lblNewLabel_1_2);
		
		java.sql.Statement stmt;
		try {
            stmt = db.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, name, email, phoneNo, course FROM auth WHERE role='Student'");
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("id");
            model.addColumn("name");
            model.addColumn("email");
            model.addColumn("phoneNo");
            model.addColumn("course");

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("id"),rs.getString("name"), rs.getString("email"),
                                          rs.getString("phoneNo"), rs.getString("course")});
            }
            JScrollPane scrollPane_1 = new JScrollPane();
            scrollPane_1.setBounds(10, 75, 654, 522);
            scrollPane_1.setEnabled(false);
            studentsPanel.add(scrollPane_1);

            stdTable = new JTable(model);
            stdTable.setEnabled(false);
            scrollPane_1.setViewportView(stdTable);

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
		
		JPanel settingsPanel = new JPanel();
		settingsPanel.setBackground(new Color(255, 255, 255));
		layeredPane.add(settingsPanel, "name_471995419546200");
		settingsPanel.setLayout(null);
		
		JLabel lblNewLabel_1_4 = new JLabel("SETTINGS");
		lblNewLabel_1_4.setForeground(new Color(128, 128, 128));
		lblNewLabel_1_4.setFont(new Font("JetBrains Mono", Font.BOLD, 20));
		lblNewLabel_1_4.setBounds(10, 27, 105, 33);
		settingsPanel.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_10 = new JLabel("HELP & SUPPORT:");
		lblNewLabel_10.setFont(new Font("Inter", Font.BOLD, 15));
		lblNewLabel_10.setBounds(10, 383, 196, 20);
		settingsPanel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_10_1 = new JLabel("ADD NOTIFICATION:");
		lblNewLabel_10_1.setFont(new Font("Inter", Font.BOLD, 15));
		lblNewLabel_10_1.setBounds(101, 226, 196, 14);
		settingsPanel.add(lblNewLabel_10_1);
		
		JLabel lblNewLabel_10_1_1 = new JLabel("ADD TO-DO:");
		lblNewLabel_10_1_1.setFont(new Font("Inter", Font.BOLD, 15));
		lblNewLabel_10_1_1.setBounds(101, 74, 196, 14);
		settingsPanel.add(lblNewLabel_10_1_1);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 todoPanel.removeAll();
			     JLabel label = new JLabel(notifArea.getText());
			     todoPanel.add(label);
			     todoPanel.revalidate();
			     todoPanel.repaint();					
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setEnabled(false);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setEnabled(true);
			}
		});
		btnNewButton.setFont(new Font("Inter", Font.BOLD, 13));
		btnNewButton.setBounds(350, 248, 89, 23);
		settingsPanel.add(btnNewButton);
		
		JLabel guidelink = new JLabel("Guidelines for students? ");
		guidelink.setForeground(new Color(0, 0, 255));
		guidelink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Desktop browser = Desktop.getDesktop();
				try {
					browser.browse(new URI("https://www.youtube.com/watch?v=yXeSD1w3CpU&ab_channel=JeetDave"));
				} catch (IOException err) {
					err.getStackTrace();
				}
				  catch (URISyntaxException err) {
					  err.getStackTrace();
				}		
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				guidelink.setForeground(new Color(102,51,102));
				guidelink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				guidelink.setForeground(new Color(0,0,255));
				guidelink.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		guidelink.setFont(new Font("Inter", Font.BOLD, 11));
		guidelink.setBounds(10, 414, 310, 14);
		settingsPanel.add(guidelink);
		
		JLabel reportlink = new JLabel("Report technical issues?");
		reportlink.setForeground(new Color(0, 0, 255));
		reportlink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Desktop browser = Desktop.getDesktop();
				try {
					browser.browse(new URI("https://www.youtube.com/shorts/96GnOB1iZQI"));
				} catch (IOException err) {
					err.getStackTrace();
				}
				  catch (URISyntaxException err) {
					  err.getStackTrace();
				}				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				reportlink.setForeground(new Color(102,51,102));
				reportlink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				reportlink.setForeground(new Color(0,0,255));
				reportlink.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		reportlink.setFont(new Font("Inter", Font.BOLD, 11));
		reportlink.setBounds(10, 438, 310, 14);
		settingsPanel.add(reportlink);
		
		JLabel lblNewLabel_13_1_1 = new JLabel("Hotline:");
		lblNewLabel_13_1_1.setFont(new Font("Inter", Font.BOLD, 11));
		lblNewLabel_13_1_1.setBounds(10, 481, 131, 14);
		settingsPanel.add(lblNewLabel_13_1_1);
		
		JLabel emaillink = new JLabel("Email: info@heraldcollege.edu.np");
		emaillink.setForeground(new Color(0, 0, 255));
		emaillink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Desktop browser = Desktop.getDesktop();
				try {
					browser.browse(new URI("https://mail.google.com/mail/u/0/#inbox?compose=new"));
				} catch (IOException err) {
					err.getStackTrace();
				}
				  catch (URISyntaxException err) {
					err.getStackTrace();
				}			
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				emaillink.setForeground(new Color(102,51,102));
				emaillink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				emaillink.setForeground(new Color(0,0,255));
				emaillink.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		emaillink.setFont(new Font("Inter", Font.BOLD, 11));
		emaillink.setBounds(12, 496, 310, 14);
		settingsPanel.add(emaillink);
		
		JLabel lblNewLabel_15 = new JLabel("+977 9801022637");
		lblNewLabel_15.setFont(new Font("Inter", Font.PLAIN, 11));
		lblNewLabel_15.setBounds(14, 533, 96, 14);
		settingsPanel.add(lblNewLabel_15);
		
		JLabel lblNewLabel_15_1 = new JLabel("+977 01-5970120");
		lblNewLabel_15_1.setFont(new Font("Inter", Font.PLAIN, 11));
		lblNewLabel_15_1.setBounds(126, 533, 98, 14);
		settingsPanel.add(lblNewLabel_15_1);
		
		JLabel lblNewLabel_15_2 = new JLabel("+977 9801000078");
		lblNewLabel_15_2.setFont(new Font("Inter", Font.PLAIN, 11));
		lblNewLabel_15_2.setBounds(238, 533, 114, 14);
		settingsPanel.add(lblNewLabel_15_2);
		
		JLabel lblNewLabel_16 = new JLabel("Do let us know for any inconvenience you had to face!");
		lblNewLabel_16.setFont(new Font("Inter", Font.PLAIN, 11));
		lblNewLabel_16.setBounds(12, 456, 309, 14);
		settingsPanel.add(lblNewLabel_16);
		
		JLabel lblNewLabel_13_1_1_1 = new JLabel("Phone Number:");
		lblNewLabel_13_1_1_1.setFont(new Font("Inter", Font.PLAIN, 11));
		lblNewLabel_13_1_1_1.setBounds(12, 516, 114, 14);
		settingsPanel.add(lblNewLabel_13_1_1_1);
		
		JLabel fblink = new JLabel("");
		fblink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Desktop browser = Desktop.getDesktop();
				try {
					browser.browse(new URI("https://www.facebook.com/NotNayan/"));
				} catch (IOException err) {
					err.getStackTrace();
				}
				  catch (URISyntaxException err) {
					err.getStackTrace();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				fblink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				fblink.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		fblink.setIcon(new ImageIcon(Dashboard.class.getResource("/pics/fbIcon.png")));
		fblink.setBounds(52, 562, 24, 22);
		settingsPanel.add(fblink);
		
		JLabel instalink = new JLabel("");
		instalink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Desktop browser = Desktop.getDesktop();
				try {
					browser.browse(new URI("https://www.instagram.com/nayan_raj_khanal/"));
				} catch (IOException err) {
					err.getStackTrace();
				}
				  catch (URISyntaxException err) {
					err.getStackTrace();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				instalink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				instalink.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		instalink.setIcon(new ImageIcon(Dashboard.class.getResource("/pics/instaIcon.png")));
		instalink.setBounds(82, 562, 24, 22);
		settingsPanel.add(instalink);
		
		JLabel twtlink = new JLabel("");
		twtlink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Desktop browser = Desktop.getDesktop();
				try {
					browser.browse(new URI("https://twitter.com/sapupuas"));
				} catch (IOException err) {
					err.getStackTrace();
				}
				  catch (URISyntaxException err) {
					err.getStackTrace();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				twtlink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				twtlink.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		twtlink.setIcon(new ImageIcon(Dashboard.class.getResource("/pics/twtIcon.png")));
		twtlink.setBounds(112, 562, 24, 22);
		settingsPanel.add(twtlink);
		
		JLabel dp = new JLabel("");
		dp.setIcon(new ImageIcon(Dashboard.class.getResource("/DP/1 (1).png")));
		dp.setBounds(449, 11, 215, 205);
		settingsPanel.add(dp);
		
		JButton btnNewButton_2 = new JButton("ADD");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 todoPanel.removeAll();
			     JLabel label = new JLabel(todoArea.getText());
			     todoPanel.add(label);
			     todoPanel.revalidate();
			     todoPanel.repaint();					
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_2.setEnabled(false);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_2.setEnabled(true);
			}
		});
		btnNewButton_2.setFont(new Font("Inter", Font.BOLD, 13));
		btnNewButton_2.setBounds(350, 97, 89, 23);
		settingsPanel.add(btnNewButton_2);
		
		todoArea = new JTextArea();
		todoArea.setBorder(UIManager.getBorder("DesktopIcon.border"));
		todoArea.setBounds(10, 96, 329, 125);
		settingsPanel.add(todoArea);
		
		notifArea = new JTextArea();
		notifArea.setBorder(UIManager.getBorder("DesktopIcon.border"));
		notifArea.setBounds(10, 247, 329, 125);
		settingsPanel.add(notifArea);
		
		JLabel lblNewLabel_4 = new JLabel("YOU");
		lblNewLabel_4.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(644, 219, 33, 14);
		settingsPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("HELLO,");
		lblNewLabel.setForeground(new Color(73, 73, 73));
		lblNewLabel.setFont(new Font("Inter", Font.BOLD, 25));
		lblNewLabel.setBounds(247, 11, 90, 46);
		contentPane.add(lblNewLabel);
				
		JLabel lblUsername = new JLabel(name);
		lblUsername.setForeground(new Color(128, 128, 128));
		lblUsername.setFont(new Font("Inter", Font.BOLD, 20));
		lblUsername.setBounds(341, 13, 119, 46);
		contentPane.add(lblUsername);
		
		JLabel waveIcon = new JLabel(new ImageIcon(getClass().getResource("../pics/cheerIcon.png")));
		waveIcon.setBounds(189, 9, 48, 48);
		contentPane.add(waveIcon);
		
		textField = new JTextField();
		textField.setBounds(0, 0, -28, -18);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JLabel lblRole = new JLabel(userrole);
		lblRole.setForeground(Color.GRAY);
		lblRole.setFont(new Font("Inter", Font.BOLD, 15));
		lblRole.setBounds(210, 60, 119, 19);
		contentPane.add(lblRole);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(112, 112, 112));
		panel.setBounds(-2, 0, 187, 783);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton coursesBt = new JButton("Courses");
		coursesBt.setBounds(24, 140, 140, 110);
		panel.add(coursesBt);
		coursesBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(coursesPanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		
		
		coursesBt.setIcon(new ImageIcon(Dashboard.class.getResource("/pics/courseIcon.png")));
		coursesBt.setHorizontalAlignment(SwingConstants.LEADING);
		coursesBt.setFont(new Font("Inter", Font.BOLD, 13));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Dashboard.class.getResource("/pics/heraldIcon.png")));
		lblNewLabel_3.setBounds(-1, 0, 187, 85);
		panel.add(lblNewLabel_3);
		
		JButton studentsBt = new JButton("Students");
		studentsBt.setBounds(24, 550, 140, 110);
		panel.add(studentsBt);
		studentsBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(studentsPanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		
		
		
		studentsBt.setIcon(new ImageIcon(Dashboard.class.getResource("/pics/studentIcon.png")));
		studentsBt.setHorizontalAlignment(SwingConstants.LEADING);
		studentsBt.setFont(new Font("Inter", Font.BOLD, 13));
		
		JButton teachersBt = new JButton("Teachers");
		teachersBt.setBounds(24, 341, 140, 110);
		panel.add(teachersBt);
		teachersBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(teacherPanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		
		
		
		teachersBt.setIcon(new ImageIcon(Dashboard.class.getResource("/pics/instructorIcon.png")));
		teachersBt.setHorizontalAlignment(SwingConstants.LEADING);
		teachersBt.setFont(new Font("Inter", Font.BOLD, 13));
		
		JLabel lblLogout = new JLabel("");
		lblLogout.setBounds(46, 681, 110, 91);
		panel.add(lblLogout);
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(lblLogout, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					Form form = new Form();
					form.setVisible(true);
					dispose();
				}
				else if(result == JOptionPane.NO_OPTION){
				}	
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblLogout.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		lblLogout.setIcon(new ImageIcon(Dashboard.class.getResource("/pics/logOut.png")));
		
		JLabel byelb = new JLabel("Hasta la vista, baby");
		byelb.setForeground(new Color(255, 128, 0));
		byelb.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
		byelb.setBounds(22, 768, 153, 14);
		panel.add(byelb);
		
		JLabel lblCourseManagement = new JLabel("@2023 Course Management System By Nayan");
		lblCourseManagement.setForeground(Color.GRAY);
		lblCourseManagement.setFont(new Font("Inter", Font.PLAIN, 11));
		lblCourseManagement.setBounds(425, 758, 257, 14);
		contentPane.add(lblCourseManagement);
		
		JLabel lblSettings = new JLabel("");
		lblSettings.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				layeredPane.removeAll();
				layeredPane.add(settingsPanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSettings.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblSettings.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		lblSettings.setIcon(new ImageIcon(Dashboard.class.getResource("/pics/settingsIcon.png")));
		lblSettings.setBounds(242, 100, 24, 37);
		contentPane.add(lblSettings);
		
		JLabel lblDashboard = new JLabel("");
		lblDashboard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				layeredPane.removeAll();
				layeredPane.add(dashboardPanel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblDashboard.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblDashboard.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		lblDashboard.setIcon(new ImageIcon(Dashboard.class.getResource("/pics/dashboardIcon.png")));
		lblDashboard.setBounds(208, 100, 24, 37);
		contentPane.add(lblDashboard);
		
		JLabel lblDashboard_2 = new JLabel("");
		lblDashboard_2.setBounds(784, 106, 24, 37);
		contentPane.add(lblDashboard_2);
		
		JLabel lblCard = new JLabel("");
		lblCard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Reportcard rc;
				StudentView sv;
				try {
					if(role.equals("Teacher")) {
					rc = new Reportcard(DbManager.getInstance());
					rc.setVisible(true);
					rc.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);	
					}
					else if(role.equals("Student")) {
					sv = new StudentView(DbManager.getInstance());
					sv.setVisible(true);
					sv.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);		
					}
				} catch (Exception e1) {					
					e1.printStackTrace();
				}
				
		
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCard.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblCard.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		lblCard.setIcon(new ImageIcon(Dashboard.class.getResource("/pics/gradeIcon.png")));
		lblCard.setBounds(275, 100, 24, 37);	
		
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMMMM dd'th' yyyy");
        JLabel dateLabel = new JLabel(sdf.format(cal.getTime()));
        dateLabel.setForeground(new Color(0, 0, 0));
        dateLabel.setFont(new Font("JetBrains Mono", Font.PLAIN, 20));
        dateLabel.setBounds(531, 106, 357, 23);
        getContentPane().add(dateLabel);
        
        JLabel lblNewLabel_4_1 = new JLabel("**hidden there are many easter eggs, how many can you find?");
        lblNewLabel_4_1.setForeground(new Color(192, 192, 192));
        lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_4_1.setFont(new Font("JetBrains Mono", Font.ITALIC, 8));
        lblNewLabel_4_1.setBounds(463, 1, 458, 14);
        contentPane.add(lblNewLabel_4_1);
        
        if(role.equals("Teacher")){
        	contentPane.add(lblCard);
        	tlbl.setForeground(new Color(255, 0, 255));       	
        }
        if(role.equals("Student")){
        	contentPane.add(lblCard);
        	slbl.setForeground(new Color(255, 0, 255));
        }
        if(role.equals("Admin")){
        	coursesPanel.add(courseEditBtn);
        	coursesPanel.add(moduleEditBtn);
        	teacherPanel.add(editTeacherBtn);
        	tlbl.setForeground(new Color(255, 0, 255));
        	slbl.setForeground(new Color(255, 0, 255));
        	clbl.setForeground(new Color(255, 0, 255));
        }
	}
}
	
