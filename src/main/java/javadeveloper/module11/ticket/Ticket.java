package javadeveloper.module11.ticket;

import jakarta.persistence.*;
import javadeveloper.module11.client.Client;
import javadeveloper.module11.planet.Planet;
import lombok.Data;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
@Table(name = "ticket")
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "created_at")
    @Generated(GenerationTime.INSERT)
    private String createdAt;

    @ManyToOne()
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne()
    @JoinColumn(name = "from_planet_id", nullable = false)
    private Planet fromPlanet;

    @ManyToOne()
    @JoinColumn(name = "to_planet_id", nullable = false)
    private Planet toPlanet;
}