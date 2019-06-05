-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 05, 2019 at 02:34 AM
-- Server version: 5.7.26
-- PHP Version: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pms`
--

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `ProductId` int(11) NOT NULL AUTO_INCREMENT,
  `ProductName` varchar(255) NOT NULL,
  `Supplier` varchar(255) NOT NULL,
  `ProductSalePrice` double NOT NULL,
  `ProductBuyPrice` double NOT NULL,
  `InStock` varchar(255) NOT NULL,
  PRIMARY KEY (`ProductId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `receipt`
--

DROP TABLE IF EXISTS `receipt`;
CREATE TABLE IF NOT EXISTS `receipt` (
  `ReceiptId` int(11) NOT NULL AUTO_INCREMENT,
  `IssueDate` varchar(255) NOT NULL,
  `TotalPrice` double NOT NULL,
  `StaffId` int(11) NOT NULL,
  PRIMARY KEY (`ReceiptId`),
  KEY `StaffId` (`StaffId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `soldproduct`
--

DROP TABLE IF EXISTS `soldproduct`;
CREATE TABLE IF NOT EXISTS `soldproduct` (
  `Quantity` int(11) NOT NULL,
  `ProductId` int(11) NOT NULL,
  `ReceiptId` int(11) NOT NULL,
  KEY `ProductId` (`ProductId`),
  KEY `ReceiptId` (`ReceiptId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
CREATE TABLE IF NOT EXISTS `staff` (
  `StaffId` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  `Sex` char(1) NOT NULL,
  `Position` varchar(255) NOT NULL,
  `Contact` varchar(255) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `Salary` double NOT NULL,
  `Password` varchar(255) NOT NULL,
  PRIMARY KEY (`StaffId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`StaffId`, `Name`, `Sex`, `Position`, `Contact`, `Address`, `Salary`, `Password`) VALUES
(1, 'admin', 'M', 'Admin', '086 47 38 39', 'Phnom Penh', 1200, 'admin'),
(2, 'cashier', 'F', 'Cashier', '069 60 69 31', 'Phnom Penh', 1000, 'cashier');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `receipt`
--
ALTER TABLE `receipt`
  ADD CONSTRAINT `receipt_ibfk_1` FOREIGN KEY (`StaffId`) REFERENCES `staff` (`StaffId`);

--
-- Constraints for table `soldproduct`
--
ALTER TABLE `soldproduct`
  ADD CONSTRAINT `soldproduct_ibfk_1` FOREIGN KEY (`ProductId`) REFERENCES `product` (`ProductId`),
  ADD CONSTRAINT `soldproduct_ibfk_2` FOREIGN KEY (`ReceiptId`) REFERENCES `receipt` (`ReceiptId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
