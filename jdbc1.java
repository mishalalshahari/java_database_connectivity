import java.sql.*;

class jdbc1{
    public static void main(String args[]){
        Connection con;
        Statement st;
        ResultSet rs;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url="jdbc:oracle:thin:@localhost:1521:";
            con=DriverManager.getConnection(url,"system","oracle"); // system(username of oracle), oracle(user's password)
            System.out.println("Database Connected");
            st=con.createStatement();
            String sql="select * from record";
            rs=st.executeQuery(sql);
            while(rs.next()){
                System.out.print(rs.getInt(1)+" ");
                System.out.print(rs.getString(2)+" ");
                System.out.print(rs.getInt(3)+" ");
                System.out.println(rs.getString(4)+" ");
            }
            con.close();
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
}