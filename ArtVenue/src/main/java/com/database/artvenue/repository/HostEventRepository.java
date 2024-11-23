package com.database.artvenue.repository;

import com.database.artvenue.domain.mapping.HostEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostEventRepository extends JpaRepository<HostEvent, Long> {
}
