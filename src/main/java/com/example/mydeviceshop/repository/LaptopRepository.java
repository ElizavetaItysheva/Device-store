package com.example.mydeviceshop.repository;

import com.example.mydeviceshop.model.laptop.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
    Optional<Laptop> findBySeriesNumber( String seriesNumber );
}
