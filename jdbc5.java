//wap to insert specific(limited) data in the databse table using query
import java.sql.*;
import java.util.Scanner;

class jdbc5{
    public static void main(String args[]){
        Connection con;
        Statement st;
        ResultSet rs;
        Scanner sc=new Scanner(System.in);
        int gempid,gbasic;
        String gname;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url="jdbc:oracle:thin:@localhost:1521:";
            con=DriverManager.getConnection(url,"system","oracle"); // system(username of oracle), oracle(user's password)
            System.out.println("Database Connected");
            System.out.println("\nCreate Employee Database");
            System.out.print("Enter Employee Id:");
            gempid=Integer.parseInt(sc.nextLine());
            System.out.print("Enter Employee Name:");
            gname=sc.nextLine();
            System.out.print("Enter Employee Basic:");
            gbasic=Integer.parseInt(sc.nextLine());
            st=con.createStatement();
            String sql="insert into emp (empid,name,basic) values("+gempid+",'"+gname+"',"+gbasic+")";
            int res=st.executeUpdate(sql);
            if(res!=0) System.out.println("Record inserted!");
            else System.out.println("No Record inserted!");
            con.close();
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
}