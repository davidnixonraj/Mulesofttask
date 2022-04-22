import java.util.Scanner;
import java.sql.*;
public class Query
{
 public static void main( String args[] )
 {
  String flag="Y";
  do
  {
   System.out.println("Select Operation For Movie Table...");
   System.out.println("1. Insert");
   System.out.println("2. Update");
   System.out.println("3. Delete");
   System.out.println("4. Select all");
   System.out.println("5. Select with Actor name");
   System.out.println("6. Exit");
   Scanner reader = new Scanner(System.in);
   System.out.println("Enter a choice: ");
   int n = reader.nextInt();
   Connection c = null;
   Statement stmt = null;
   try 
   {
    Class.forName("org.sqlite.JDBC");
    c = DriverManager.getConnection("jdbc:sqlite:SqliteJavaDB.db");
    c.setAutoCommit(false);
    stmt = c.createStatement();
    String movie="",Actor="",Actress="",Director="",sql="",Actor1="";
    int yor,Movid;
    Scanner scanName;
    switch(n)
    {
     case 1:
     scanName=new Scanner(System.in);
     System.out.println("Enter Movie Name:");
     movie=scanName.nextLine();
     System.out.println("Enter  Actor Name:");
     Actor=scanName.nextLine();
     System.out.println("Enter  Actress Name:");
     Actress=scanName.nextLine();
     System.out.println("Enter Year of Release:");
     yor=scanName.nextInt();
     scanName.nextLine();
     System.out.println("Enter Director Name:");
     Director=scanName.nextLine();
     sql = "INSERT INTO Movies (MovName,Actor,Actress,Yearofrelease,Director) " +
     "VALUES ('" +movie+ "','" +
     Actor+ "','" +Actress+ "'," + yor +
     ",'" +Director+ "')";
     stmt.executeUpdate(sql);
     System.out.println("Inserted Successfully!!!");
     break;
 
     case 2:
     scanName=new Scanner(System.in);
     System.out.println("Enter Movie ID:");
     Movid=scanName.nextInt();
     scanName.nextLine();
     System.out.println("Enter Movie Name:");
     movie=scanName.nextLine();
     System.out.println("Enter  Actor Name:");
     Actor=scanName.nextLine();
     System.out.println("Enter  Actress Name:");
     Actress=scanName.nextLine();
     System.out.println("Enter Year of Release:");
     yor=scanName.nextInt();
     scanName.nextLine();
     System.out.println("Enter Director Name:");
     Director=scanName.nextLine();
     sql = "UPDATE Movies SET MovName = '"+movie+ "',Actor=" +
     Actor+ ",Actress=" +Actress+ ",Yearofrelease=" +yor+
     ",Director=" +Director+ " WHERE Movid=" +Movid ;
     stmt.executeUpdate(sql);
     System.out.println("Updated Successfully!!!");
     break; 

     case 3:
     System.out.println("Enter Movie id:");
     scanName=new Scanner(System.in);
     Movid=scanName.nextInt();
     sql="DELETE FROM Movies WHERE Movid=" + Movid+";";
     stmt.executeUpdate(sql);
     System.out.println("Deleted Successfully!!!");
     break;
 
     case 4:
     ResultSet rs = stmt.executeQuery("SELECT * FROM Movies;");
     System.out.println("MOVID\t MovName\t Actor\t Actress\t YearOfRelease\t Director ");
     while ( rs.next() ) 
     {
      Movid = rs.getInt("Movid");
      movie = rs.getString("MovName");
      Actor = rs.getString("Actor");
      Actress = rs.getString("Actress");     
      yor = rs.getInt("Yearofrelease");
      Director = rs.getString("Director");
      System.out.println(Movid+"\t "+movie+" \t "+Actor+"\t "+Actress+" \t "+yor+" \t\t "+Director);
     }
     rs.close();
     break; 

     case 5:
     scanName=new Scanner(System.in);
     System.out.println("Enter Actor Name to be viewed: \n note: Enter inside double quotes ");
     Actor1=scanName.nextLine();

     ResultSet rs2 = stmt.executeQuery("SELECT * FROM Movies WHERE Actor ="+ Actor1 +";");
     System.out.println("MOVID\t MovName\t Actor\t Actress\t YearOfRelease\t Director ");
     while ( rs2.next() ) 
     {
      Movid = rs2.getInt("Movid");
      movie = rs2.getString("MovName");
      Actor = rs2.getString("Actor");
      Actress = rs2.getString("Actress");     
      yor = rs2.getInt("Yearofrelease");
      Director = rs2.getString("Director");
      System.out.println(Movid+"\t "+movie+" \t "+Actor+"\t "+Actress+" \t "+yor+" \t\t "+Director);
     }
     rs2.close();
     break;

     case 6:
     System.exit(0);
     break;

     default:
     System.out.println("Oops!!! Wrong Choice...");
     break;

     }
    stmt.close();
    c.commit();
    c.close();
    }

    catch ( Exception e )

    {
     System.err.println( e.getClass().getName() + ": " + e.getMessage() );
     System.exit(0);
    }

    System.out.println("Continue Y OR N?");
    reader=new Scanner(System.in);
    flag=reader.nextLine();
    }
 while(flag.equalsIgnoreCase("Y"));
 System.exit(0);

 }

}