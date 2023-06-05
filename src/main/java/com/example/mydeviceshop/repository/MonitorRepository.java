package com.example.mydeviceshop.repository;

import com.example.mydeviceshop.model.monitor.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MonitorRepository extends JpaRepository<Monitor, Long> {
    Optional<Monitor> findBySeriesNumber( String seriesNumber );
}
