package javadeveloper.module11.planet;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import javadeveloper.module11.ticket.Ticket;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "planet")
@Data
public class Planet {
    @Id
    private String id;

    private String name;

    @ToString.Exclude
    @OneToMany(mappedBy = "fromPlanet")
    private List<Ticket> ticketsFrom;

    @ToString.Exclude
    @OneToMany(mappedBy = "toPlanet")
    private List<Ticket> ticketsTo;
}
