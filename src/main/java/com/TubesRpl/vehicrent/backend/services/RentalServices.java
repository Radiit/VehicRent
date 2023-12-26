package com.TubesRpl.vehicrent.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.TubesRpl.vehicrent.backend.models.Rental;
import com.TubesRpl.repository.RentalRepository;

@Service
public class RentalServices {

    @Autowired
    private RentalRepository rentalRepository;

    // Mendapatkan semua data Rental
    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    // Menyimpan data Rental
    public Rental saveRental(Rental rental) {
        return rentalRepository.save(rental);
    }

    // Mendapatkan data Rental berdasarkan ID
    public Rental getRentalById(Long id) {
        return rentalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rental not found with id: " + id));
    }

    // Menghapus data Rental berdasarkan ID
    public void deleteRentalById(Long id) {
        rentalRepository.deleteById(id);
    }
}
