package dao;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class tables {
    
    public static void main(String[] args){
        Connection con = null;
        Statement st = null;
        try{
            con = ConnectionProvider.getCon();
            st = con.createStatement();
            //st.executeUpdate("create table appuser(appuser_pk int AUTO_INCREMENT primary key, userRole varchar(50), name varchar(200), mobileNumber varchar(50), email varchar(200), password varchar(50), address varchar(200), status varchar(50)");
            st.executeUpdate("insert into appuser(userRole, name, mobileNumber, email, password, address, status) values ('SuperAdmin', 'Super Admin', '5432687909', 'superadmin@gmail.com', 'admin', 'India', 'true')");
            JOptionPane.showMessageDialog(null, "Table Created Successfully");
        }   
        catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            try{
                con.close();
                st.close();
            }
            catch(SQLException e){
                System.out.println(e);
            }
        }
    }

    
}
