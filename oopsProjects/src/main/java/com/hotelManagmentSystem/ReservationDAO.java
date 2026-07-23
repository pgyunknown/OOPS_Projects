package com.hotelManagmentSystem;
import java.sql.*;
//import java.time.*;


public class ReservationDAO {
    private Connection con;
    public ReservationDAO(Connection con){
        this.con=con;
    }
    private final String insertReservation="insert into reservation(room_id,guest_name,phone_number,gov_id,check_in,check_out) values(?,?,?,?,?,?)";
    private final String viewReservation="select reservation_id,room_id,guest_name,phone_number,gov_id,check_in,check_out from reservation";

    public void addReservation(Reservation reservation) throws SQLException {
        PreparedStatement ps= con.prepareStatement(insertReservation);
        ps.setInt(1,reservation.getRoomId());
        ps.setString(2,reservation.getGuestName());
        ps.setString(3,reservation.getPhoneNumber());
        ps.setString(4,reservation.getGovId());
        ps.setDate(5, Date.valueOf(reservation.getCheckIn()));
        ps.setDate(6, Date.valueOf(reservation.getCheckOut()));
        int rows=ps.executeUpdate();
        System.out.println("Rows affected: "+rows);
    }

    public void veiwReservation() throws SQLException {
        boolean found = false;
        PreparedStatement ps = con.prepareStatement(viewReservation);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            found = true;
            System.out.println(
                    " | Reservation ID: " + rs.getInt("reservation_id") +
                            " | Room ID: " + rs.getInt("room_id") +
                            " | Guest Name: " + rs.getString("guest_name") +
                            " | Phone: " + rs.getString("phone_number") +
                            " | Gov ID: " + rs.getString("gov_id") +
                            " | Check-In: " + rs.getDate("check_in") +
                            " | Check-Out: " + rs.getDate("check_out")
            );
            if (!found) System.out.println("No rooms found in database");
        }


    }
    public void cancelReservation(int reservationId, int roomId) throws SQLException {
        String deleteReservationSql = "DELETE FROM reservation WHERE reservation_id = ?";
        String updateRoomSql = "UPDATE room SET available = true WHERE room_id = ?";

        try (PreparedStatement ps1 = con.prepareStatement(deleteReservationSql)) {
            ps1.setInt(1, reservationId);
            int rowsDeleted = ps1.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Reservation " + reservationId + " deleted successfully!");

                try (PreparedStatement ps2 = con.prepareStatement(updateRoomSql)) {
                    ps2.setInt(1, roomId);
                    ps2.executeUpdate();
                    System.out.println("Room " + roomId + " is now available again!");
                }
            } else {
                System.out.println("No reservation found with ID: " + reservationId);
            }
        }
    }
}
