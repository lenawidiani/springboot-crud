-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Aug 29, 2019 at 05:37 AM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `task-btpn`
--

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `id` bigint(20) NOT NULL,
  `nik` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `tgl_lahir` varchar(8) NOT NULL,
  `pendapatan` double NOT NULL,
  `status` smallint(1) NOT NULL DEFAULT 1,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `deleted_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`id`, `nik`, `nama`, `tgl_lahir`, `pendapatan`, `status`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 1, 'lena', '06/06/19', 10000000, 0, '2019-08-27 16:34:57', '2019-08-27 16:36:37', '2019-08-27 16:43:55'),
(2, 2, 'lena', '06/06/19', 10000000, 0, '2019-08-27 16:44:46', '2019-08-27 16:44:46', '2019-08-28 19:27:30'),
(3, 3, 'lena', '06/06/19', 10000000, 0, '2019-08-28 07:22:53', '2019-08-28 07:22:53', '2019-08-28 19:28:17'),
(4, 4, 'lena', '06/06/19', 10000000, 1, '2019-08-28 07:23:03', '2019-08-28 07:23:03', NULL),
(5, 5, '1ena', '06/06/19', 10000000, 1, '2019-08-28 07:23:53', '2019-08-28 07:23:53', NULL),
(6, 6, '134', '06/06/19', 10000000, 1, '2019-08-28 07:24:14', '2019-08-28 07:24:14', NULL),
(7, 7, 'lena', '06/06/00', 10000000, 1, '2019-08-28 07:33:01', '2019-08-28 07:33:01', NULL),
(8, 8, 'lena', '06/06/00', 10000000, 1, '2019-08-28 07:42:25', '2019-08-28 07:42:25', NULL),
(9, 12345, 'lena', '10/10/00', 10000000, 1, '2019-08-28 19:19:24', '2019-08-28 19:19:24', NULL),
(10, 123467, 'lena', '06/06/00', 10000000, 1, '2019-08-28 19:23:30', '2019-08-28 20:43:09', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employees`
--
ALTER TABLE `employees`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
