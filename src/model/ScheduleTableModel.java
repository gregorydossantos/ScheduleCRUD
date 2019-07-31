package model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ScheduleTableModel extends AbstractTableModel {
    
    //Variables...
    public static final int COL_ID = 0;
    public static final int COL_NAME = 1;
    public static final int COL_NUMBER = 2;
    public static final int COL_NICK_NAME = 3;
    public static final int COL_EMAIL = 4;
    public ArrayList<Schedule> list;
    
    //Builders...
    public ScheduleTableModel(ArrayList<Schedule> l){
        list = new ArrayList<Schedule>(l);
        
    }

    //Abstracts methods...
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int lines, int column) {
        Schedule schedule = list.get(lines);
        if (column == COL_ID) return schedule.getId();
        if (column == COL_NAME) return schedule.getName();    
        if (column == COL_NUMBER) return schedule.getNumber();
        if (column == COL_NICK_NAME) return schedule.getNick_name();
        if (column == COL_EMAIL) return schedule.getEmail();
        return "";
        
    }
    
    @Override
    public String getColumnName(int column){
        if (column == COL_ID) return "id";
        if (column == COL_NAME) return "name";    
        if (column == COL_NUMBER) return "number";
        if (column == COL_NICK_NAME) return "nick_name";
        if (column == COL_EMAIL) return "email";
        return "";
        
    }

}
