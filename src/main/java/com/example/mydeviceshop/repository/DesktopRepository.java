package com.example.mydeviceshop.repository;

import com.example.mydeviceshop.model.desktop.Desktop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DesktopRepository extends JpaRepository<Desktop, Long> {
    Optional<Desktop> findBySeriesNumber( String seriesNumber );
}
