package com.webmovieticket.repository;

import com.webmovieticket.models.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketsRepository extends JpaRepository<Tickets, Long> {

//  Vé của 1 bộ phim chiếu ở rạp ? phòng ? ngày ? giờ ? nào .
    @Query(value = "select tickets.id, tickets.price, tickets.show_date, tickets.show_month, tickets.show_time, tickets.payment_status, movies.name, cinemas.cinema_name, cinema_rooms.room_name ,seats.seat_name, tickets.category from tickets inner join movies on tickets.movie_id = movies.id inner join cinemas on cinemas.id = tickets.cinema_id inner join cinema_rooms on cinema_rooms.id = tickets.room_id inner join seats on seats.id = tickets.seat_id where cinemas.id = :cinemaId and cinema_rooms.id = :roomId and movies.id = :movieId and tickets.show_date = :showDate and tickets.show_month = :showMonth and tickets.show_time = :showTime", nativeQuery = true)
    public List<Object[]> getTickets(@Param("cinemaId") Long cinemaId, @Param("roomId") Long roomId, @Param("movieId") Long movieId, @Param("showDate") String showDate, @Param("showMonth") String showMonth, @Param("showTime") String showTime);

    @Query(value = "SELECT * FROM tickets where user_id = :userid", nativeQuery = true)
    public List<Tickets> getTicketsByUserId(@Param("userid") Long userid);

    @Query(value = "select tickets.id, tickets.price, tickets.show_date, tickets.show_month, tickets.show_time, tickets.payment_status, movies.name, cinemas.cinema_name, cinema_rooms.room_name ,seats.seat_name, tickets.category from tickets inner join movies on tickets.movie_id = movies.id inner join cinemas on cinemas.id = tickets.cinema_id inner join cinema_rooms on cinema_rooms.id = tickets.room_id inner join seats on seats.id = tickets.seat_id where movies.id = :movieId", nativeQuery = true)
    public List<Object[]> getAll(@Param("movieId") Long movieId);
}
