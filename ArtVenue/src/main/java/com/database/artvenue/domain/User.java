package com.database.artvenue.domain;

import com.database.artvenue.enums.UserType;
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

    @Column(nullable = false)
    private String password;

    private String contactInfo;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @OneToOne(mappedBy = "owner", cascade = CascadeType.ALL)
    private Cafe cafe;
}
