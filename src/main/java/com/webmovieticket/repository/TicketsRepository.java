package com.webmovieticket.repository;

import com.webmovieticket.dto.AuditDTO;
import com.webmovieticket.models.Movies;
import com.webmovieticket.models.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketsRepository extends JpaRepository<Tickets, Long> {

//  Vé của 1 bộ phim chiếu ở rạp ? phòng ? ngày ? giờ ? nào .
    @Query(value = "SELECT * FROM tickets where tickets.cinema_id = :cinemaId and tickets.room_id = :roomId and tickets.movie_id = :movieId and tickets.show_date = :showDate and tickets.show_month = :showMonth and tickets.show_time = :showTime", nativeQuery = true)
    public List<Tickets> getTickets(@Param("cinemaId") Long cinemaId, @Param("roomId") Long roomId, @Param("movieId") Long movieId, @Param("showDate") String showDate, @Param("showMonth") String showMonth, @Param("showTime") String showTime);

    @Query(value = "SELECT * FROM tickets where user_id = :userid", nativeQuery = true)
    public List<Tickets> getTicketsByUserId(@Param("userid") Long userid);

    @Query(value = "SELECT * FROM tickets where tickets.movie_id = :movieId", nativeQuery = true)
    public List<Tickets> getAll(@Param("movieId") Long movieId);

    @Query(value = "SELECT SUM(IF(tickets.payment_status = true, tickets.price, 0)) as sum_price, SUM(IF(tickets.payment_status = true, 1, 0)) as sum_tickets FROM tickets where tickets.movie_id = :movieId", nativeQuery = true)
    public List<Object[]> getAuditByMovie(@Param("movieId") Long movieId);

    public List<Tickets> findAllByMovies(Movies movies);

    @Query(value = "SELECT * FROM tickets where tickets.cinema_id = :cinemaId and tickets.room_id = :roomId and tickets.show_date = :showDate and tickets.show_month = :showMonth and tickets.show_time = :showTime", nativeQuery = true)
    public List<Tickets> getTicketsBySuatChieu(@Param("cinemaId") Long cinemaId, @Param("roomId") Long roomId, @Param("showDate") String showDate, @Param("showMonth") String showMonth, @Param("showTime") String showTime);
}
