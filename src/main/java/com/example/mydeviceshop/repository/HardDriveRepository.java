package com.example.mydeviceshop.repository;

import com.example.mydeviceshop.model.hardDrive.HardDrive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HardDriveRepository extends JpaRepository<HardDrive, Long> {
    Optional<HardDrive> findBySeriesNumber( String seriesNumber );
}
