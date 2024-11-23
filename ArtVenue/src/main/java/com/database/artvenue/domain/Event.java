package com.database.artvenue.domain;
import com.database.artvenue.domain.mapping.HostEvent;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer EventId;

    @ManyToOne
    private Cafe cafe;

    private String eventType;

    private java.sql.Date eventDate;

    private java.sql.Time startTime;

    private java.sql.Time endTime;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private Set<Reservation> reservations;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private Set<HostEvent> hostEvents;
}