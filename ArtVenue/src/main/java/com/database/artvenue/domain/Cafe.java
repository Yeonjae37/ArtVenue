package com.database.artvenue.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Cafe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cafeId;

    @OneToOne
    @JoinColumn(referencedColumnName = "userId")
    private User owner;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private Integer capacity;

    @Column(nullable = false)
    private Double rentalFee;

    @OneToMany(mappedBy = "cafe", cascade = CascadeType.ALL)
    private Set<Event> events;
}