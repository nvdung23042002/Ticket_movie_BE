package com.webmovieticket.repository;

import com.webmovieticket.models.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketsRepository extends JpaRepository<Tickets, Long> {

//  Vé của 1 bộ phim chiếu ở rạp ? phòng ? ngày ? giờ ? nào .
    @Query(value = "select tickets.id, tickets.price, tickets.show_date, tickets.show_time, tickets.payment_status, movies.name, cinemas.cinema_name, cinema_rooms.room_name ,seats.seat_name, tickets.category from tickets inner join movies on tickets.movie_id = movies.id inner join cinemas on cinemas.id = tickets.cinema_id inner join cinema_rooms on cinema_rooms.id = tickets.room_id inner join seats on seats.id = tickets.seat_id where cinemas.cinema_name = :cinemaName and cinema_rooms.room_name = :roomName and movies.name = :movieName and tickets.show_date = :showDate and tickets.show_time = :showTime", nativeQuery = true)
    public List<Object[]> getTickets(@Param("cinemaName") String cinemaName, @Param("roomName") String roomName, @Param("movieName") String movieName, @Param("showDate") String showDate, @Param("showTime") String showTime);
}
