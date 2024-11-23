package com.database.artvenue.domain;
import com.database.artvenue.domain.enums.EventType;
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
    private Integer eventId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reservation_id", referencedColumnName = "id")
    private Reservation reservation;

    @ManyToOne
    @JoinColumn(name = "cafe_id", referencedColumnName = "cafeId")
    private Cafe cafe;

    private EventType eventType;

    private java.sql.Date eventDate;

    private java.sql.Time startTime;

    private java.sql.Time endTime;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private Set<HostEvent> hostEvents;
}