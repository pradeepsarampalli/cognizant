import java.sql.*;
public class JDBCDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/module";
        String username = "root";
        String password = "system";
        // try {
        //     Connection conn = DriverManager.getConnection(url, username, password);
        //     System.out.println("Connected to the database successfully!");
        //     // String query = "SELECT * FROM users";
        //     Statement stmt = conn.createStatement();
        //     // stmt.executeUpdate("insert into users values(9,'pradeep','pradeep@sample.com','peddapalli','2026-06-01')");
        //     //stmt.executeUpdate("update users set full_name='S Pradeep' where user_id=9");
        //     //stmt.executeUpdate("delete from users where user_id=9");
            
        //     // PreparedStatement ptsmt = conn.prepareStatement("insert into users values(?,?,?,?,?)");
        //     // ptsmt.setInt(1, 10);
        //     // ptsmt.setString(2, "pradeep");
        //     // ptsmt.setString(3, "pradeep@sample.com");
        //     // ptsmt.setString(4, "peddapalli");
        //     // ptsmt.setDate(5, Date.valueOf("2026-06-01"));
        //     // ptsmt.executeUpdate();

        //     // PreparedStatement ptsmt = conn.prepareStatement("update users set full_name=? where user_id=?");
        //     // ptsmt.setString(1, "S Pradeep");
        //     // ptsmt.setInt(2, 10);
        //     // ptsmt.executeUpdate();

        //     // PreparedStatement ptsmt = conn.prepareStatement("delete from users where user_id=?");
        //     // ptsmt.setInt(1, 10);
        //     // ptsmt.executeUpdate();

        //     // ResultSet rs = stmt.executeQuery("select * from users limit 1");
        //     // while(rs.next()){
        //     //     int id = rs.getInt(1);
        //     //     String name = rs.getString("full_name");
        //     //     String email = rs.getString("email");
        //     //     String city = rs.getString("city");
        //     //     Date regDate = rs.getDate("registration_date");
        //     //     System.out.println("User ID: " + id + ", Name: " + name + ", Email: " + email + ", City: " + city + ", Registration Date: " + regDate);
        //     //     
        //     // }
        //     stmt.close();
        //     conn.close();
        // } catch (SQLException e) {
        //     e.printStackTrace();
        // }

        //transactions
        Connection con=null;
        try{
            con = DriverManager.getConnection(url, username, password);
            con.setAutoCommit(false);
            
            String credit = "update accounts set balance=balance+? where user_id=?";
            String debit = "update accounts set balance=balance-? where user_id=?";

            int amount = 1000;
            int userId1 = 9;
            int userId2=10;
            PreparedStatement pDebit = con.prepareStatement(debit);
            PreparedStatement pCredit = con.prepareStatement(credit);

            pDebit.setInt(1,amount);
            pDebit.setInt(2, userId1);
            int status1 = pDebit.executeUpdate();

            pDebit.setInt(1,amount);
            pDebit.setInt(2, userId2);
            int status2 = pCredit.executeUpdate();

            if(status1==1 && status2==1){
                con.commit();
                System.out.println("Transaction sucess!");
            }else{
                con.rollback();
                System.out.println("Transaction failed!");
            }

            pCredit.close();
            pDebit.close();
        }
        catch(Exception e){
            try{
            if(con!=null){
            con.rollback();
            System.out.println("Error occurred transaction rolled back");
            }
            }
            catch(SQLException se){
            System.out.println("Exception occured rolled back!");
            }
        }
        finally{
            try{
            if(con!=null){
            con.setAutoCommit(true);
            con.close();
            }
        }
        catch(SQLException se){
            System.err.println("Error occured!");
        }
        }

    }

}
