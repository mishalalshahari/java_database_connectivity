//wap which read roll no of a student and show the details of the student
import java.sql.*;
import java.util.Scanner;

class jdbc2{
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
            System.out.print("Enter roll number:");
            gid=sc.nextInt();
            st=con.createStatement();
            String sql="select * from record where id="+gid+"";
            rs=st.executeQuery(sql);
            if(rs.next()){
                System.out.print("Name="+rs.getString(2)+" ");
                System.out.print("Age="+rs.getInt(3)+" ");
                System.out.println("Address="+rs.getString(4)+" ");
            }
            else{
                System.out.println("No record found!");
            }
            con.close();
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
}