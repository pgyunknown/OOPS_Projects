package com.hotelManagmentSystem;

import java.sql.*;

public final class RoomsDAO {
    private Connection con;
    public RoomsDAO(Connection con){
        this.con=con;
    }
    private final String insertRoom ="insert into room(room_number,room_type,available,price) values(?,?,?,?)";
    private final String viewRoom="select room_id,room_number,room_type,available,price from room";

    public void addRoom(Rooms room) throws SQLException {
        PreparedStatement ps=con.prepareStatement(insertRoom);
        ps.setInt(1,room.getRoomNumber());
        ps.setString(2,room.getRoomType());
        ps.setBoolean(3,room.isAvaliability());
        ps.setDouble(4,room.getPrice());
        int rows=ps.executeUpdate();
        System.out.println("Rows affects: "+rows); 
    }
     public void veiwRoom() throws SQLException{
        boolean found =false;
        PreparedStatement ps=con.prepareStatement(viewRoom);
        ResultSet rs= ps.executeQuery();
        while (rs.next()){
            found=true;
            System.out.println("ID: " + rs.getInt("room_id") +
                    " | Room No: " + rs.getInt("room_number") +
                    " | Type: " + rs.getString("room_type") +
                    " | Available: " + rs.getBoolean("available") +
                    " | Price: $" + rs.getDouble("price"));
        }
        if(!found) System.out.println("No rooms found in database");
     }
}
