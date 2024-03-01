import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ProjectTableDemo extends JFrame
{
       //private static final String DB_URL = "jdbc:postgres//192.168.1.254:5432/exam27";
       //private static final String USER = "exam27";
       //private static final String PASS ="exam27";
       
       public ProjectTableDemo()
       {
              super("Project Table Demo");
              setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              setSize(600,400);
              setLocationRelativeTo(null);
              getContentPane().add(new JScrollPane(getProjectTable()));
              setVisible(true);
       }
       private JTable getProjectTable()
       {
               String[] columns = {"Project ID","Project Name","Project Description","Project Status"};
               DefaultTableModel model = new DefaultTableModel(columns,0);
               
               try
               {
                   Connection conn = DriverManager.getConnection("jdbc:postgresql://192.168.1.254/exam27","exam27","exam27");
                   Statement stmt = conn.createStatement();
                   stmt.executeUpdate("CREATE TABLE IF NOT EXISTS PROJECT("+"PROJECT_ID INT PRIMARY KEY,"+"PROJECT_NAME VARCHAR(255),"+"PROJECT_DESCRIPTION VARCHAR(255),"+"PROJECT_STATUS VARCHAR(255)"+")");
                   
                   stmt.executeUpdate("INSERT INTO PROJECT(PROJECT_ID,PROJECT_NAME,PROJECT_DESCRIPTION,PROJECT_STATUS) VALUES(1,'TODO LIST','Create Application','IN PROGRESS')");
                   
                   stmt.executeUpdate("INSERT INTO PROJECT(PROJECT_ID,PROJECT_NAME,PROJECT_DESCRIPTION,PROJECT_STATUS) VALUES(2,'Documentation','Creating Documentation','COMPLETED')");
                   
                   ResultSet rs = stmt.executeQuery("SELECT * FROM PROJECT");
                   
                   while (rs.next())
                   {
                          int id = rs.getInt("PROJECT_ID");
                          String name = rs.getString("PROJECT_NAME");
                          String desc = rs.getString("PROJECT_DESCRIPTION");
                          String status = rs.getString("PROJECT_STATUS");
                          model.addRow(new Object[]{id,name,desc,status});
                   }
                   conn.close();
               }
               catch (SQLException e)
               {
                     e.printStackTrace();
               }
               return new JTable(model);
       }
       public static void main(String[] args)
       {
              new ProjectTableDemo();
       }
}








import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class ProjectManagementSystem extends JFrame {
    private JTable table;

    public ProjectManagementSystem() {
        setTitle("Project Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        displayData();

        setVisible(true);
    }

    private void displayData() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database_name", "username", "password");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PROJECT");

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            DefaultTableModel model = new DefaultTableModel();

            // Add column names to the table model
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                model.addColumn(metaData.getColumnName(columnIndex));
            }

            // Add data to the table model
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    row[i] = resultSet.getObject(i + 1);
                }
                model.addRow(row);
            }

            // Set the table model
            table.setModel(model);

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProjectManagementSystem::new);
    }
}
