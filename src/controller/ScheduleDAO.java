package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Schedule;

public class ScheduleDAO {

    //Variables...
    private Connection conn;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;
    private ArrayList<Schedule> list = new ArrayList<Schedule>();

    //Builders...
    public ScheduleDAO() {
        conn = new ConnectionSchedule().getConnect();
    }
    /*
    * CRUD METHODS
    */
    //Method to insert in the DB...
    public void insert(Schedule schedule) {
        String sql = "insert into phone_book (name, number, nick_name, email) values (?, ?, ?, ?)";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, schedule.getName());
            stmt.setString(2, schedule.getNumber());
            stmt.setString(3, schedule.getNick_name());
            stmt.setString(4, schedule.getEmail());
            stmt.execute();
            stmt.close();

        } catch (Exception error) {
            throw new RuntimeException("Error 2: " + error);
        }
    }
    //Method for making changes to DB...
    public void alter(Schedule schedule) {
        String sql = "update phone_book set name = ?, number = ?, nick_name = ?, email = ? where id = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, schedule.getName());
            stmt.setString(2, schedule.getNumber());
            stmt.setString(3, schedule.getNick_name());
            stmt.setString(4, schedule.getEmail());
            stmt.setInt(5, schedule.getId());
            stmt.execute();
            stmt.close();

        } catch (Exception error) {
            throw new RuntimeException("Error 3: " + error);
        }
    }
    //Method to delete data from DB...
    public void delete(int id) {
        String sql = "delete from phone_book where id = " + id;
        try {
            st = conn.createStatement();
            st.execute(sql);
            st.close();

        } catch (Exception error) {
            throw new RuntimeException("Error 4: " + error);
        }
    }
    //Method to list all datas from DB...
    public ArrayList<Schedule>  listAll(){
        String sql = "select * from phone_book";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                Schedule schedule = new Schedule();
                schedule.setId(rs.getInt("id"));
                schedule.setName(rs.getString("name"));
                schedule.setNumber(rs.getString("number"));
                schedule.setNick_name(rs.getString("nick_name"));
                schedule.setEmail(rs.getString("email"));
                list.add(schedule);
            }
        } catch (Exception error){
            throw new RuntimeException("Error 5: " + error);
        }
        
        return list;
    }
    //Method to list DB data by keywords...
    public ArrayList<Schedule>  listAllDesc(String value){
        String sql = "select * from phone_book where name like '%" + value + "%' ";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                Schedule schedule = new Schedule();
                schedule.setId(rs.getInt("id"));
                schedule.setName(rs.getString("name"));
                schedule.setNumber(rs.getString("number"));
                schedule.setNick_name(rs.getString("nick_name"));
                schedule.setEmail(rs.getString("email"));
                list.add(schedule);
            }
        } catch (Exception error){
            throw new RuntimeException("Error 6: " + error);
        }
        
        return list;
    }
}
