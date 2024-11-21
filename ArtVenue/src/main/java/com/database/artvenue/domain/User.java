package com.database.artvenue.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(nullable = false)
    private String name;

    private String contactInfo;

    private String userType;

    @OneToOne(mappedBy = "owner", cascade = CascadeType.ALL)
    private Cafe cafe;
}
