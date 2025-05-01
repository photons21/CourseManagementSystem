package courseManagementSystem;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class StudentView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	
	public StudentView(DbManager db) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Performance Report:");
		lblNewLabel.setFont(new Font("JetBrains Mono", Font.BOLD, 25));
		lblNewLabel.setBounds(198, 11, 321, 27);
		contentPane.add(lblNewLabel);
		
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
            scrollPane.setBounds(40, 49, 612, 299);
            scrollPane.setEnabled(false);
            contentPane.add(scrollPane);

            table = new JTable(model);
            table.setEnabled(false);
            scrollPane.setViewportView(table);
            
            JLabel lblPromotion = new JLabel("");
            lblPromotion.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));
            lblPromotion.setHorizontalAlignment(SwingConstants.RIGHT);
    		lblPromotion.setBounds(72, 359, 580, 14);
    		contentPane.add(lblPromotion);

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
	}
}
