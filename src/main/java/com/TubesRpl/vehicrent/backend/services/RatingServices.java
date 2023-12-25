package com.TubesRpl.vehicrent.backend.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.TubesRpl.repository.ClientRepository;
import com.TubesRpl.repository.KendaraanRepository;
import com.TubesRpl.repository.RatingRepository;
import com.TubesRpl.vehicrent.backend.models.Client;
import com.TubesRpl.vehicrent.backend.models.Kendaraan;
import com.TubesRpl.vehicrent.backend.models.Rating;
import com.TubesRpl.vehicrent.backend.payloads.requests.RatingRequest;
import com.TubesRpl.vehicrent.backend.payloads.response.Response;

@Service
public class RatingServices {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private KendaraanRepository kendaraanRepository;

    public Response giveRating(RatingRequest request){
        try {
            Client client = clientRepository.findByHiddenFalseAndIdClient(request.getIdClient()).orElse(null);
            if (client == null) {
                return new Response(HttpStatus.NOT_FOUND.value(), "Client not found", null);
            }
            Kendaraan kendaraan = kendaraanRepository.findByHiddenFalseAndIdKendaraan(request.getIdKendaraan()).orElse(null);
            if (kendaraan == null) {
                return new Response(HttpStatus.NOT_FOUND.value(), "Kendaraan not found", null);
            }
            Rating ratingKendaraan = new Rating();
            ratingKendaraan.setClient(client);
            ratingKendaraan.setKendaraan(kendaraan);
            ratingKendaraan.setRating(request.getRating());
            ratingKendaraan.setKomentar(request.getKomentar());
            ratingKendaraan.setHidden(false);
            ratingKendaraan.setTanggalRating(LocalDateTime.now());
            kendaraan.getRating().add(ratingKendaraan);

            int totalRatings = kendaraan.getRating().size();
            float totalRatingSum = kendaraan.getRating().stream().mapToInt(Rating::getRating).sum();
            float averageRating = totalRatingSum / totalRatings;
            kendaraan.setTotalRating(averageRating);
            kendaraanRepository.save(kendaraan);
            System.out.println("Give rating to kendaraan with id: " + kendaraan.getIdKendaraan()+ " by client with id: " + client.getIdClient());
            return new Response(HttpStatus.OK.value(), "Success", ratingKendaraan);
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }

    public Response updateRating(Integer id, RatingRequest request){
        try {
            Rating rating = ratingRepository.findByHiddenFalseAndIdRating(id).orElse(null);
            if (rating == null) {
                return new Response(HttpStatus.NOT_FOUND.value(), "Rating not found", null);
            }
            rating.setRating(request.getRating());
            rating.setKomentar(request.getKomentar());
            rating.setTanggalRating(LocalDateTime.now());
            kendaraanRepository.save(rating.getKendaraan());
            System.out.println("Update rating with id: " + rating.getIdRating());
            return new Response(HttpStatus.OK.value(), "Success", rating);
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }

    public Response displayRatingById(Integer id){
        try {
            Rating rating = ratingRepository.findByHiddenFalseAndIdRating(id).orElse(null);
            if (rating != null) {
                System.out.println("Display rating by id : " + id);
                return new Response(HttpStatus.OK.value(), "Success", rating);
            } else {
                return new Response(HttpStatus.NOT_FOUND.value(), "Rating not found", null);
            }
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }

    public Response deleteRating(Integer id){
        try {
            Rating rating = ratingRepository.findByHiddenFalseAndIdRating(id).orElse(null);
            if (rating != null) {
                rating.setHidden(true);
                ratingRepository.save(rating);
                System.out.println("Delete rating with id: " + rating.getIdRating());
                return new Response(HttpStatus.OK.value(), "Success", null);
            } else {
                return new Response(HttpStatus.NOT_FOUND.value(), "Rating not found", null);
            }
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }
}
