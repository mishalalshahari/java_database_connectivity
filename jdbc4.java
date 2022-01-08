//wap to delete a record by taking an id from user
import java.sql.*;
import java.util.Scanner;

class jdbc4{
    public static void main(String args[]){
        Connection con;
        Statement st;
        ResultSet rs;
        Scanner sc=new Scanner(System.in);
        int gid;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url="jdbc:oracle:thin:@localhost:1521:";
            con=DriverManager.getConnection(url,"system","oracle"); // system(username of oracle), oracle(user's password)
            System.out.println("Database Connected");
            System.out.print("Enter id to delete:");
            gid=sc.nextInt();
            st=con.createStatement();
            String sql="delete from record where id="+gid+"";
            int res=st.executeUpdate(sql);
            if(res!=0) System.out.println("Record deleted!");
            else System.out.println("No Record deleted!");
            con.close();
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
}