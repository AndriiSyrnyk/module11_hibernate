package javadeveloper.module11.client;

import jakarta.persistence.*;
import javadeveloper.module11.ticket.Ticket;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "client")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ToString.Exclude
    @OneToMany(mappedBy = "client")
    private List<Ticket> tickets;
}
