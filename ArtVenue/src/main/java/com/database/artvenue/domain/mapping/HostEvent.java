package com.database.artvenue.domain.mapping;

import com.database.artvenue.domain.Event;
import com.database.artvenue.domain.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class HostEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User host;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    private String note; // 주최자 메모
}