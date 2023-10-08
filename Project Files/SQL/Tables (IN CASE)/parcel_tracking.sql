-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:4001
-- Generation Time: Apr 23, 2023 at 07:23 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `parcel`
--

-- --------------------------------------------------------

--
-- Table structure for table `parcel_tracking`
--

CREATE TABLE `parcel_tracking` (
  `id` int(8) NOT NULL,
  `src_add` varchar(50) NOT NULL,
  `src_pinCode` int(6) NOT NULL,
  `dst_add` varchar(50) NOT NULL,
  `dst_pinCode` int(6) NOT NULL,
  `curr_loc` varchar(50) NOT NULL,
  `delivery_status` varchar(25) NOT NULL DEFAULT 'In-Transit'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `parcel_tracking`
--

INSERT INTO `parcel_tracking` (`id`, `src_add`, `src_pinCode`, `dst_add`, `dst_pinCode`, `curr_loc`, `delivery_status`) VALUES
(10000001, 'Sahibganj', 816109, 'Phagwara', 144411, 'Ludhiana', 'Delivered');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `parcel_tracking`
--
ALTER TABLE `parcel_tracking`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `parcel_tracking`
--
ALTER TABLE `parcel_tracking`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10000004;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
