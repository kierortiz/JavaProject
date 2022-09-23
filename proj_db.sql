-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 28, 2020 at 08:47 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `proj_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `prod_id` int(11) NOT NULL,
  `prod_name` varchar(20) NOT NULL,
  `prod_brand` varchar(20) NOT NULL,
  `prod_desc` varchar(50) NOT NULL,
  `prod_price` int(20) NOT NULL,
  `prod_stock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`prod_id`, `prod_name`, `prod_brand`, `prod_desc`, `prod_price`, `prod_stock`) VALUES
(211, 'Samsung S20 Ultra', 'Samsung', '64GB Storage + 8GB RAM', 40000, 131),
(212, 'Samsung S20 Ultra', 'Samsung', '128GB Storage + 12GB RAM', 55000, 131),
(213, 'Samsung Galaxy S10', 'Samsung', '64GB Storage + 6GB RAM', 35000, 136),
(214, 'Samsung Galaxy S10', 'Samsung', '128GB Storage + 8GB RAM', 49000, 105),
(215, 'Samsung A30s', 'Samsung', '64GB Storage + 4GB RAM', 25000, 150),
(216, 'Samsung A30s', 'Samsung', '128GB Storage + 6GB RAM', 30000, 139),
(217, 'Oppo X2 Find Pro', 'Oppo', '128GB Storage + 8GB RAM', 44000, 120),
(218, 'Oppo X2 Find Pro', 'Oppo', '512GB Storage + 12GB RAM', 59000, 134),
(219, 'Oppo Reno 2', 'Oppo', '128GB Storage + 8GB RAM', 28000, 141),
(220, 'Oppo Reno 2', 'Oppo', '256GB Storage + 12GB RAM', 39000, 148),
(221, 'Oppo F15', 'Oppo', '64GB Storage + 4GB RAM', 21000, 150),
(222, 'Oppo F15', 'Oppo', '128GB Storage + 6GB RAM', 29000, 150),
(223, 'Pocophone F1', 'Xiaomi', '64GB Storage + 6GB RAM', 17000, 148),
(224, 'Pocophone F1', 'Xiaomi', '128GB Storage + 6GB RAM', 19000, 150),
(225, 'Redmi mi10', 'Xiaomi', '64GB Storage + 8GB RAM', 28000, 149),
(226, 'Redmi mi10', 'Xiaomi', '128GB Storage + 8GB RAM', 33000, 149),
(227, 'Redmi Mi8', 'Xiaomi', '128GB Storage + 4GB RAM', 25000, 150),
(228, 'Redmi Mi8', 'Xiaomi', '256GB Storage + 6GB RAM', 31000, 150),
(229, 'iPhone 11 PRO Max', 'Apple', '256GB Storage + 8GB RAM', 49000, 148),
(230, 'iPhone 11 PRO Max', 'Apple', '512GB Storage + 8GB RAM', 59000, 149),
(231, 'iPhone X', 'Apple', '64GB Storage + 8GB RAM', 39000, 148),
(232, 'iPhone X', 'Apple', '256GB Storage + 8GB RAM', 51000, 149),
(233, 'iPhone 8', 'Apple', '128GB Storage + 4GB RAM', 28000, 134),
(234, 'iPhone 8', 'Apple', '256GB Storage + 4GB RAM', 37000, 150),
(235, 'Vivo V19', 'Vivo', '128GB Storage + 8GB RAM', 35000, 149),
(236, 'Vivo V19', 'Vivo', '256GB Storage + 12GB RAM', 45000, 148),
(237, 'Vivo Nex 3', 'Vivo', '128GB Storage + 8GB RAM', 39000, 148),
(238, 'Vivo Nex 3', 'Vivo', '256GB Storage + 12GB RAM', 51000, 148),
(239, 'Vivo S5', 'Vivo', '64GB Storage + 4GB RAM', 22000, 150),
(240, 'Vivo S5', 'Vivo', '128GB Storage + 6GB RAM', 26000, 135);

-- --------------------------------------------------------

--
-- Table structure for table `prod_added`
--

CREATE TABLE `prod_added` (
  `prod_id` int(11) NOT NULL,
  `prod_name` varchar(20) NOT NULL,
  `prod_brand` varchar(20) NOT NULL,
  `prod_desc` varchar(50) NOT NULL,
  `prod_color` varchar(20) NOT NULL,
  `prod_price` int(11) NOT NULL,
  `prod_qty` int(11) NOT NULL,
  `prod_user` varchar(20) NOT NULL,
  `added_time` datetime NOT NULL,
  `prod_stat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `user_uname` varchar(20) NOT NULL,
  `user_pass` varchar(20) NOT NULL,
  `user_fname` varchar(20) NOT NULL,
  `user_lname` varchar(20) NOT NULL,
  `user_pos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `user_uname`, `user_pass`, `user_fname`, `user_lname`, `user_pos`) VALUES
(1, 'admin', '1234', 'dfwfrd', 'fwefwef', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`prod_id`);

--
-- Indexes for table `prod_added`
--
ALTER TABLE `prod_added`
  ADD PRIMARY KEY (`prod_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `prod_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=241;

--
-- AUTO_INCREMENT for table `prod_added`
--
ALTER TABLE `prod_added`
  MODIFY `prod_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=66;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
