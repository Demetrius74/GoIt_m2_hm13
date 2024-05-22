package org.august.model;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Planet {
    @Id
    @Pattern(regexp = "^[A-Z0-9]+$")
    @Size(max = 50)
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Column(name = "name", nullable = false, length = 500)
    @Size(min = 1, max = 500)
    private String name;

    @OneToMany(mappedBy = "fromPlanet", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ticket> departures;

    @OneToMany(mappedBy = "toPlanet", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ticket> arrivals;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Ticket> getDepartures() {
        return departures;
    }

    public void setDepartures(Set<Ticket> departures) {
        this.departures = departures;
    }

    public Set<Ticket> getArrivals() {
        return arrivals;
    }

    public void setArrivals(Set<Ticket> arrivals) {
        this.arrivals = arrivals;
    }
}