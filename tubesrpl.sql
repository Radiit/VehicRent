-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 30, 2023 at 04:59 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tubesrpl`
--

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `id_client` int(11) NOT NULL,
  `hidden` bit(1) DEFAULT NULL,
  `sim` varchar(255) DEFAULT NULL,
  `valid` varchar(255) DEFAULT NULL,
  `nik` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`id_client`, `hidden`, `sim`, `valid`, `nik`) VALUES
(1, b'0', '/resources/public/sim/sim-9c376362-c529-4619-964d-43a6b86e2ab7.jpeg', 'Pending', 1403010);

-- --------------------------------------------------------

--
-- Table structure for table `image_kendaraan`
--

CREATE TABLE `image_kendaraan` (
  `id_image_kendaraan` int(11) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `id_kendaraan` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `kendaraan`
--

CREATE TABLE `kendaraan` (
  `id_kendaraan` int(11) NOT NULL,
  `harga_sewa` int(11) DEFAULT NULL,
  `hidden` bit(1) DEFAULT NULL,
  `jenis_kendaraan` varchar(255) DEFAULT NULL,
  `kondisi_kendaraan` varchar(255) DEFAULT NULL,
  `main_image` varchar(255) DEFAULT NULL,
  `merk_kendaraan` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `nomor_mesin` varchar(255) DEFAULT NULL,
  `nomor_plat` varchar(255) DEFAULT NULL,
  `stnk` varchar(255) DEFAULT NULL,
  `tahun` int(11) DEFAULT NULL,
  `total_ordered` int(11) DEFAULT NULL,
  `total_rating` float DEFAULT NULL,
  `transmisi` varchar(255) DEFAULT NULL,
  `valid` varchar(255) DEFAULT NULL,
  `warna` varchar(255) DEFAULT NULL,
  `id_regent` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `kendaraan`
--

INSERT INTO `kendaraan` (`id_kendaraan`, `harga_sewa`, `hidden`, `jenis_kendaraan`, `kondisi_kendaraan`, `main_image`, `merk_kendaraan`, `model`, `nomor_mesin`, `nomor_plat`, `stnk`, `tahun`, `total_ordered`, `total_rating`, `transmisi`, `valid`, `warna`, `id_regent`) VALUES
(1, 350000, b'0', 'Mobil Keluarga', 'Bagus', '/resources/public/kendaraan/vehicle-a07ee406-cc6e-48b2-a0f7-51f70f870457.jpg', 'Toyota', 'Avanza', '12312312', 'B 1676 SSU', '/resources/public/stnk/stnk-3373d436-f57d-4aa4-88e7-e3b880d32fde.png', 123123, 0, 0, 'Automatic', 'Pending', 'Silver', 1),
(2, 100000, b'0', 'Mobil Keluarga', 'Bagus', '/resources/public/kendaraan/vehicle-3d0fe08d-2f90-453d-b4fd-8390ba3ba868.jpg', 'Honda', 'Beat', '12321331', 'B 1234 ABC', '/resources/public/stnk/stnk-84b9fbf9-599e-4431-b604-de391bc1806d.png', 2019, 0, 0, 'Automatic', 'Pending', 'Merah', 1),
(3, 300000, b'0', 'Mobil Keluarga', 'Bagus', '/resources/public/kendaraan/vehicle-d8607d6f-7489-4355-89f6-51c8948a96cc.jpg', 'Daihatsu', 'Xenia', '12321', 'L 9012 GHI', '/resources/public/stnk/stnk-e22cd3ee-b263-47fd-b533-eb3bd1442fe6.png', 2019, 0, 0, 'Manual', 'Pending', 'Silver', 1),
(4, 320000, b'0', 'Mobil Keluarga', 'Bagus', '/resources/public/kendaraan/vehicle-a893ef06-f9d7-4fa5-9cf0-4bab5bfc7d65.jpg', 'Suzuki', 'Ertiga', '12321312', 'Z 3456 XYZ', '/resources/public/stnk/stnk-f4f0e15e-801f-4000-b2c7-8f8a5dc88a1e.png', 2013, 0, 0, 'Automatic', 'Pending', 'Silver', 1),
(5, 80000, b'0', 'Mobil Keluarga', 'Bagus', '/resources/public/kendaraan/vehicle-4b6a777c-5443-4050-bb76-e62d18100b8f.jpg', 'Honda', 'Scoopy', '123123123', 'C 5678 MNO', '/resources/public/stnk/stnk-32f0be04-2a8f-445f-ae38-a1d5b7043100.png', 2020, 0, 0, 'Automatic', 'Pending', 'Cream', 1);

-- --------------------------------------------------------

--
-- Table structure for table `rating`
--

CREATE TABLE `rating` (
  `id_rating` int(11) NOT NULL,
  `hidden` bit(1) DEFAULT NULL,
  `komentar` varchar(255) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `tanggal_rating` datetime(6) DEFAULT NULL,
  `id_client` int(11) DEFAULT NULL,
  `id_kendaraan` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `regent`
--

CREATE TABLE `regent` (
  `id_regent` int(11) NOT NULL,
  `hidden` bit(1) DEFAULT NULL,
  `valid` varchar(255) DEFAULT NULL,
  `nik` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `regent`
--

INSERT INTO `regent` (`id_regent`, `hidden`, `valid`, `nik`) VALUES
(1, b'0', 'Pending', 1234567890);

-- --------------------------------------------------------

--
-- Table structure for table `rental`
--

CREATE TABLE `rental` (
  `id` bigint(20) NOT NULL,
  `nama` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `id_staff` int(11) NOT NULL,
  `hidden` bit(1) DEFAULT NULL,
  `nik` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` int(11) NOT NULL,
  `date_transaksi` datetime(6) DEFAULT NULL,
  `destination` varchar(255) DEFAULT NULL,
  `drop_off_address` varchar(255) DEFAULT NULL,
  `harga_total` int(11) DEFAULT NULL,
  `hidden` bit(1) DEFAULT NULL,
  `lama_sewa` bigint(20) DEFAULT NULL,
  `order_name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `pick_up_address` varchar(255) DEFAULT NULL,
  `rent_date_end` date DEFAULT NULL,
  `rent_date_start` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `id_client` int(11) DEFAULT NULL,
  `id_kendaraan` int(11) DEFAULT NULL,
  `id_regent` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `nik` int(11) NOT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `foto_diri` varchar(255) DEFAULT NULL,
  `hidden` bit(1) DEFAULT NULL,
  `kontak_darurat` varchar(255) DEFAULT NULL,
  `ktp` varchar(255) DEFAULT NULL,
  `nama_belakang` varchar(255) DEFAULT NULL,
  `nama_depan` varchar(255) DEFAULT NULL,
  `no_telepon` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role_user` varchar(255) DEFAULT NULL,
  `umur` int(11) DEFAULT NULL,
  `valid` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`nik`, `alamat`, `email`, `foto_diri`, `hidden`, `kontak_darurat`, `ktp`, `nama_belakang`, `nama_depan`, `no_telepon`, `password`, `role_user`, `umur`, `valid`) VALUES
(1403010, 'Jl. Sukabirus No 31', 'client@dummy.com', '/resources/public/foto_diri/fotoDiri-c2a2c924-65e1-4824-825a-f7853b54915d.png', b'0', '0831313132', '/resources/public/ktp/ktp-0ff52ba1-3f1f-45c8-812c-c9ca164ff06f.jpeg', 'dummy', 'dummy', '081231131', 'password123', 'Client', 31, 'Pending'),
(1234567890, 'Jl. Merdeka No. 1, Jakarta', 'regent@dummy.com', '/resources/public/foto_diri/fotoDiri-0e1271b9-0165-483e-98db-6195d15e54d8.png', b'0', '081234567890', '/resources/public/ktp/ktp-9098f50c-f9b4-426f-9af9-0320244dc101.jpeg', 'Doe', 'John', '089876543210', 'password123', 'Regent', 30, 'Pending');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id_client`),
  ADD KEY `FK76ewm4kxqgofdakikm6yqbwy0` (`nik`);

--
-- Indexes for table `image_kendaraan`
--
ALTER TABLE `image_kendaraan`
  ADD PRIMARY KEY (`id_image_kendaraan`),
  ADD KEY `FKqoonbqdi8revavegvfvp1fjds` (`id_kendaraan`);

--
-- Indexes for table `kendaraan`
--
ALTER TABLE `kendaraan`
  ADD PRIMARY KEY (`id_kendaraan`),
  ADD KEY `FK4tuopep1cnigwx0jmno3uarbl` (`id_regent`);

--
-- Indexes for table `rating`
--
ALTER TABLE `rating`
  ADD PRIMARY KEY (`id_rating`),
  ADD KEY `FK94kknn7ctn31t4x9yunati010` (`id_client`),
  ADD KEY `FK9tygq7f5x4yog0pfrn1cbcoby` (`id_kendaraan`);

--
-- Indexes for table `regent`
--
ALTER TABLE `regent`
  ADD PRIMARY KEY (`id_regent`),
  ADD KEY `FK742racmchjbvdqbptgughu6mk` (`nik`);

--
-- Indexes for table `rental`
--
ALTER TABLE `rental`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`id_staff`),
  ADD KEY `FK6nek23o22k7yiver5nc2fvs9f` (`nik`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `FKe8jk0kao22mkwudhpdr6n91ug` (`id_client`),
  ADD KEY `FKgn2s0pqi5yfqbttw99qav956u` (`id_kendaraan`),
  ADD KEY `FKt18a1pnbep5x7anoy8yv4e0e5` (`id_regent`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`nik`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `id_client` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `image_kendaraan`
--
ALTER TABLE `image_kendaraan`
  MODIFY `id_image_kendaraan` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `kendaraan`
--
ALTER TABLE `kendaraan`
  MODIFY `id_kendaraan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `rating`
--
ALTER TABLE `rating`
  MODIFY `id_rating` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `regent`
--
ALTER TABLE `regent`
  MODIFY `id_regent` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `rental`
--
ALTER TABLE `rental`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `staff`
--
ALTER TABLE `staff`
  MODIFY `id_staff` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `FK76ewm4kxqgofdakikm6yqbwy0` FOREIGN KEY (`nik`) REFERENCES `user` (`nik`);

--
-- Constraints for table `image_kendaraan`
--
ALTER TABLE `image_kendaraan`
  ADD CONSTRAINT `FKqoonbqdi8revavegvfvp1fjds` FOREIGN KEY (`id_kendaraan`) REFERENCES `kendaraan` (`id_kendaraan`);

--
-- Constraints for table `kendaraan`
--
ALTER TABLE `kendaraan`
  ADD CONSTRAINT `FK4tuopep1cnigwx0jmno3uarbl` FOREIGN KEY (`id_regent`) REFERENCES `regent` (`id_regent`);

--
-- Constraints for table `rating`
--
ALTER TABLE `rating`
  ADD CONSTRAINT `FK94kknn7ctn31t4x9yunati010` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`),
  ADD CONSTRAINT `FK9tygq7f5x4yog0pfrn1cbcoby` FOREIGN KEY (`id_kendaraan`) REFERENCES `kendaraan` (`id_kendaraan`);

--
-- Constraints for table `regent`
--
ALTER TABLE `regent`
  ADD CONSTRAINT `FK742racmchjbvdqbptgughu6mk` FOREIGN KEY (`nik`) REFERENCES `user` (`nik`);

--
-- Constraints for table `staff`
--
ALTER TABLE `staff`
  ADD CONSTRAINT `FK6nek23o22k7yiver5nc2fvs9f` FOREIGN KEY (`nik`) REFERENCES `user` (`nik`);

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `FKe8jk0kao22mkwudhpdr6n91ug` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`),
  ADD CONSTRAINT `FKgn2s0pqi5yfqbttw99qav956u` FOREIGN KEY (`id_kendaraan`) REFERENCES `kendaraan` (`id_kendaraan`),
  ADD CONSTRAINT `FKt18a1pnbep5x7anoy8yv4e0e5` FOREIGN KEY (`id_regent`) REFERENCES `regent` (`id_regent`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
