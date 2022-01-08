// wap which read id,name,age and address and insert it into record table
import java.sql.*;
import java.util.Scanner;

class jdbc3{
    public static void main(String args[]){
        Connection con;
        Statement st;
        ResultSet rs;
        Scanner sc=new Scanner(System.in);
        String gname,gaddress;
        int gid,gage;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url="jdbc:oracle:thin:@localhost:1521:";
            con=DriverManager.getConnection(url,"system","oracle"); // system(username of oracle), oracle(user's password)
            System.out.println("Database Connected");
            System.out.print("Enter id:");
            gid=Integer.parseInt(sc.nextLine());
            System.out.print("Enter name:");
            gname=sc.nextLine();
            System.out.print("Enter age:");
            gage=Integer.parseInt(sc.nextLine());
            System.out.print("Enter address:");
            gaddress=sc.nextLine();
            st=con.createStatement();
            String sql="insert into record values("+gid+",+'"+gname+"',+"+gage+",+'"+gaddress+"')";
            int res=st.executeUpdate(sql);
            if(res!=0) System.out.println("Record Inserted!");
            else System.out.println("No Record Inserted!");
            con.close();
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
}