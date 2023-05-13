package dbTesting_Automation;
import dbTesting.BaseClass;
import org.testng.annotations.Test;
import java.sql.*;
public class DataBaseAutomation extends BaseClass{
    @Test
    public void getTableData_Success() throws SQLException {
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * From college1");
        //statement.executeQuery("SET FOREIGN_KEY_CHECKS=0");
        while (rs.next()){
            int ClgId = rs.getInt(1);
            String ClgName = rs.getString(2);
            int StuID = rs.getInt(3);
            System.out.println(ClgId +" "+ClgName+" "+StuID);
        }
    }

    @Test
    public void insertIntoTable_Success() throws SQLException {
        PreparedStatement pst = con.prepareStatement("INSERT INTO college1 VALUES(?,?,?)");
        pst.setInt(1,104);
        pst.setString(2, "gayatri");
        pst.setInt(3,1);
        pst.executeUpdate();
        getTableData_Success();
    }

    @Test
    public void updateTable() throws SQLException{
        PreparedStatement pst = con.prepareStatement("Update college1 SET ClgName = ? WHERE ClgId = ?");
        pst.setString(1,"Anits");
        pst.setInt(2, 102);
        pst.executeUpdate();
        getTableData_Success();
    }

    @Test
    public void specificDataFromTable() throws SQLException{
        PreparedStatement pst = con.prepareStatement("SELECT * From college1 where ClgId = ?");
        pst.setInt(1, 101);
        ResultSet rs = pst.executeQuery();
        while (rs.next()){
            int ClgId = rs.getInt(1);
            String ClgName = rs.getString(2);
            int StuID = rs.getInt(3);

            System.out.println(ClgId +" "+ClgName+" "+StuID);
        }
    }

    @Test
    public void  deleteSpecificDataFromTable() throws SQLException{
        PreparedStatement pst = con.prepareStatement("SELECT * From college1 where ClgId = ?");
        pst.setInt(1, 101);
        ResultSet rs = pst.executeQuery();
        int ClgId = rs.getInt(1);
        String ClgName = rs.getString(2);
        int StuID = rs.getInt(3);
    }

    @Test
    public void addColumnIntoTable() throws SQLException{
        PreparedStatement pst = con.prepareStatement("ALTER TABLE college1 ADD column  ClgLocation = ?");
        pst.setInt(1, 4);
        ResultSet rs = pst.executeQuery();
        String ClgLocation =rs.getString(4);
        System.out.println(ClgLocation);
    }


}
