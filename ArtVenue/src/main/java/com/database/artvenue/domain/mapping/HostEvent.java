package com.database.artvenue.domain.mapping;

import com.database.artvenue.domain.Event;
import com.database.artvenue.domain.User;
import jakarta.persistence.*;

@Entity
public class HostEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User host;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    private String note;
}