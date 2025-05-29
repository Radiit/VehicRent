package com.TubesRpl.vehicrent.backend.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.TubesRpl.repository.UserRepository;
import com.TubesRpl.repository.ClientRepository;
import com.TubesRpl.repository.RegentRepository;
import com.TubesRpl.repository.StaffRepository;
import com.TubesRpl.repository.KendaraanRepository;
import com.TubesRpl.vehicrent.backend.models.User;
import com.TubesRpl.vehicrent.backend.models.Client;
import com.TubesRpl.vehicrent.backend.models.Regent;
import com.TubesRpl.vehicrent.backend.models.Staff;
import com.TubesRpl.vehicrent.backend.models.Kendaraan;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RegentRepository regentRepository;

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private KendaraanRepository kendaraanRepository;

    @Override
    public void run(String... args) throws Exception {
        // Seed Users
        seedUsers();
        
        // Seed Clients
        seedClients();
        
        // Seed Regents
        seedRegents();
        
        // Seed Staff
        seedStaff();
        
        // Seed Kendaraan
        seedKendaraan();
    }

    private void seedUsers() {
        if (userRepository.count() == 0) {
            // Create Admin
            User admin = new User(
                1234567890,
                "Staff",
                "Admin",
                "System",
                "081234567890",
                "081234567891",
                25,
                "admin@vehicrent.com",
                "admin123",
                "Jl. Admin No. 1",
                "/resources/public/ktp/ktp-admin.jpg",
                "/resources/public/foto_diri/foto-admin.jpg",
                false,
                "Valid"
            );
            userRepository.save(admin);

            // Create Client
            User client = new User(
                1234567891,
                "Client",
                "John",
                "Doe",
                "081234567892",
                "081234567893",
                30,
                "john@example.com",
                "client123",
                "Jl. Client No. 1",
                "/resources/public/ktp/ktp-client.jpg",
                "/resources/public/foto_diri/foto-client.jpg",
                false,
                "Valid"
            );
            userRepository.save(client);

            // Create Regent
            User regent = new User(
                1234567892,
                "Regent",
                "Jane",
                "Smith",
                "081234567894",
                "081234567895",
                35,
                "jane@example.com",
                "regent123",
                "Jl. Regent No. 1",
                "/resources/public/ktp/ktp-regent.jpg",
                "/resources/public/foto_diri/foto-regent.jpg",
                false,
                "Valid"
            );
            userRepository.save(regent);
        }
    }

    private void seedClients() {
        if (clientRepository.count() == 0) {
            User clientUser = userRepository.findByEmail("john@example.com");
            if (clientUser != null) {
                Client client = new Client(
                    1,
                    clientUser,
                    "/resources/public/sim/sim-client.jpg",
                    false,
                    "Valid"
                );
                clientRepository.save(client);
            }
        }
    }

    private void seedRegents() {
        if (regentRepository.count() == 0) {
            User regentUser = userRepository.findByEmail("jane@example.com");
            if (regentUser != null) {
                Regent regent = new Regent(
                    1,
                    regentUser,
                    null, // listKendaraan will be populated later
                    "Valid",
                    false
                );
                regentRepository.save(regent);
            }
        }
    }

    private void seedStaff() {
        if (staffRepository.count() == 0) {
            User adminUser = userRepository.findByEmail("admin@vehicrent.com");
            if (adminUser != null) {
                Staff staff = new Staff(
                    1,
                    adminUser,
                    false
                );
                staffRepository.save(staff);
            }
        }
    }

    private void seedKendaraan() {
        if (kendaraanRepository.count() == 0) {
            Regent regent = regentRepository.findByHiddenFalseAndIdRegent(1).orElse(null);
            if (regent != null) {
                // Mobil 1 - Toyota Avanza
                Kendaraan mobil1 = new Kendaraan();
                mobil1.setRegent(regent);
                mobil1.setJenisKendaraan("Mobil");
                mobil1.setMerkKendaraan("Toyota");
                mobil1.setModel("Avanza");
                mobil1.setNomorPlat("B 1234 ABC");
                mobil1.setWarna("Hitam");
                mobil1.setTahun(2020);
                mobil1.setNomorMesin("ABC123456");
                mobil1.setTransmisi("Automatic");
                mobil1.setHargaSewa(300000);
                mobil1.setKondisiKendaraan("Bagus");
                mobil1.setStnk("/resources/public/stnk/stnk-avanza.jpg");
                mobil1.setMainImage("/resources/public/kendaraan/avanza.jpg");
                mobil1.setTotalRating(4.5f);
                mobil1.setTotalOrdered(10);
                mobil1.setValid("Valid");
                mobil1.setHidden(false);
                kendaraanRepository.save(mobil1);

                // Mobil 2 - Honda Jazz
                Kendaraan mobil2 = new Kendaraan();
                mobil2.setRegent(regent);
                mobil2.setJenisKendaraan("Mobil");
                mobil2.setMerkKendaraan("Honda");
                mobil2.setModel("Jazz");
                mobil2.setNomorPlat("B 4321 XYZ");
                mobil2.setWarna("Putih");
                mobil2.setTahun(2021);
                mobil2.setNomorMesin("XYZ987654");
                mobil2.setTransmisi("Manual");
                mobil2.setHargaSewa(250000);
                mobil2.setKondisiKendaraan("Bagus");
                mobil2.setStnk("/resources/public/stnk/stnk-jazz.jpg");
                mobil2.setMainImage("/resources/public/kendaraan/jazz.jpg");
                mobil2.setTotalRating(4.0f);
                mobil2.setTotalOrdered(5);
                mobil2.setValid("Valid");
                mobil2.setHidden(false);
                kendaraanRepository.save(mobil2);

                // Mobil 3 - Toyota Innova
                Kendaraan mobil3 = new Kendaraan();
                mobil3.setRegent(regent);
                mobil3.setJenisKendaraan("Mobil");
                mobil3.setMerkKendaraan("Toyota");
                mobil3.setModel("Innova");
                mobil3.setNomorPlat("B 5678 DEF");
                mobil3.setWarna("Silver");
                mobil3.setTahun(2022);
                mobil3.setNomorMesin("DEF456789");
                mobil3.setTransmisi("Automatic");
                mobil3.setHargaSewa(450000);
                mobil3.setKondisiKendaraan("Bagus Sekali");
                mobil3.setStnk("/resources/public/stnk/stnk-innova.jpg");
                mobil3.setMainImage("/resources/public/kendaraan/innova.jpg");
                mobil3.setTotalRating(4.8f);
                mobil3.setTotalOrdered(15);
                mobil3.setValid("Valid");
                mobil3.setHidden(false);
                kendaraanRepository.save(mobil3);

                // Mobil 4 - Honda CR-V
                Kendaraan mobil4 = new Kendaraan();
                mobil4.setRegent(regent);
                mobil4.setJenisKendaraan("Mobil");
                mobil4.setMerkKendaraan("Honda");
                mobil4.setModel("CR-V");
                mobil4.setNomorPlat("B 8765 GHI");
                mobil4.setWarna("Merah");
                mobil4.setTahun(2021);
                mobil4.setNomorMesin("GHI789012");
                mobil4.setTransmisi("Automatic");
                mobil4.setHargaSewa(500000);
                mobil4.setKondisiKendaraan("Bagus Sekali");
                mobil4.setStnk("/resources/public/stnk/stnk-crv.jpg");
                mobil4.setMainImage("/resources/public/kendaraan/crv.jpg");
                mobil4.setTotalRating(4.7f);
                mobil4.setTotalOrdered(8);
                mobil4.setValid("Valid");
                mobil4.setHidden(false);
                kendaraanRepository.save(mobil4);

                // Motor 1 - Honda PCX
                Kendaraan motor1 = new Kendaraan();
                motor1.setRegent(regent);
                motor1.setJenisKendaraan("Motor");
                motor1.setMerkKendaraan("Honda");
                motor1.setModel("PCX");
                motor1.setNomorPlat("B 1111 JKL");
                motor1.setWarna("Putih");
                motor1.setTahun(2022);
                motor1.setNomorMesin("JKL123456");
                motor1.setTransmisi("Automatic");
                motor1.setHargaSewa(150000);
                motor1.setKondisiKendaraan("Bagus");
                motor1.setStnk("/resources/public/stnk/stnk-pcx.jpg");
                motor1.setMainImage("/resources/public/kendaraan/pcx.jpg");
                motor1.setTotalRating(4.6f);
                motor1.setTotalOrdered(20);
                motor1.setValid("Valid");
                motor1.setHidden(false);
                kendaraanRepository.save(motor1);

                // Motor 2 - Yamaha NMAX
                Kendaraan motor2 = new Kendaraan();
                motor2.setRegent(regent);
                motor2.setJenisKendaraan("Motor");
                motor2.setMerkKendaraan("Yamaha");
                motor2.setModel("NMAX");
                motor2.setNomorPlat("B 2222 MNO");
                motor2.setWarna("Hitam");
                motor2.setTahun(2021);
                motor2.setNomorMesin("MNO456789");
                motor2.setTransmisi("Automatic");
                motor2.setHargaSewa(150000);
                motor2.setKondisiKendaraan("Bagus");
                motor2.setStnk("/resources/public/stnk/stnk-nmax.jpg");
                motor2.setMainImage("/resources/public/kendaraan/nmax.jpg");
                motor2.setTotalRating(4.4f);
                motor2.setTotalOrdered(18);
                motor2.setValid("Valid");
                motor2.setHidden(false);
                kendaraanRepository.save(motor2);

                // Motor 3 - Kawasaki Ninja
                Kendaraan motor3 = new Kendaraan();
                motor3.setRegent(regent);
                motor3.setJenisKendaraan("Motor");
                motor3.setMerkKendaraan("Kawasaki");
                motor3.setModel("Ninja 250");
                motor3.setNomorPlat("B 3333 PQR");
                motor3.setWarna("Hijau");
                motor3.setTahun(2020);
                motor3.setNomorMesin("PQR789012");
                motor3.setTransmisi("Manual");
                motor3.setHargaSewa(200000);
                motor3.setKondisiKendaraan("Bagus");
                motor3.setStnk("/resources/public/stnk/stnk-ninja.jpg");
                motor3.setMainImage("/resources/public/kendaraan/ninja.jpg");
                motor3.setTotalRating(4.3f);
                motor3.setTotalOrdered(12);
                motor3.setValid("Valid");
                motor3.setHidden(false);
                kendaraanRepository.save(motor3);

                // Mobil 5 - Toyota Fortuner
                Kendaraan mobil5 = new Kendaraan();
                mobil5.setRegent(regent);
                mobil5.setJenisKendaraan("Mobil");
                mobil5.setMerkKendaraan("Toyota");
                mobil5.setModel("Fortuner");
                mobil5.setNomorPlat("B 4444 STU");
                mobil5.setWarna("Hitam");
                mobil5.setTahun(2022);
                mobil5.setNomorMesin("STU012345");
                mobil5.setTransmisi("Automatic");
                mobil5.setHargaSewa(800000);
                mobil5.setKondisiKendaraan("Bagus Sekali");
                mobil5.setStnk("/resources/public/stnk/stnk-fortuner.jpg");
                mobil5.setMainImage("/resources/public/kendaraan/fortuner.jpg");
                mobil5.setTotalRating(4.9f);
                mobil5.setTotalOrdered(7);
                mobil5.setValid("Valid");
                mobil5.setHidden(false);
                kendaraanRepository.save(mobil5);

                // Mobil 6 - Honda Civic
                Kendaraan mobil6 = new Kendaraan();
                mobil6.setRegent(regent);
                mobil6.setJenisKendaraan("Mobil");
                mobil6.setMerkKendaraan("Honda");
                mobil6.setModel("Civic");
                mobil6.setNomorPlat("B 5555 VWX");
                mobil6.setWarna("Biru");
                mobil6.setTahun(2021);
                mobil6.setNomorMesin("VWX345678");
                mobil6.setTransmisi("Automatic");
                mobil6.setHargaSewa(600000);
                mobil6.setKondisiKendaraan("Bagus Sekali");
                mobil6.setStnk("/resources/public/stnk/ ");
                mobil6.setMainImage("/resources/public/kendaraan/civic.jpg");
                mobil6.setTotalRating(4.6f);
                mobil6.setTotalOrdered(9);
                mobil6.setValid("Valid");
                mobil6.setHidden(false);
                kendaraanRepository.save(mobil6);
            }
        }
    }
} 