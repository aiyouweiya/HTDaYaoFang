-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 26, 2017 at 12:01 PM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `yaodian`
--

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `jobID` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `position` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`jobID`, `name`, `password`, `position`) VALUES
(1, '张三', '123', '经理'),
(2, '李四', '123', '仓库管理员'),
(3, '王五', '123', '收银员');

-- --------------------------------------------------------

--
-- Table structure for table `yao`
--

CREATE TABLE `yao` (
  `bianhao` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `type` varchar(20) NOT NULL,
  `sellPrice` varchar(20) NOT NULL,
  `pifaPrice` varchar(20) NOT NULL,
  `remainCount` varchar(20) NOT NULL,
  `isDelete` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `yao`
--

INSERT INTO `yao` (`bianhao`, `name`, `type`, `sellPrice`, `pifaPrice`, `remainCount`, `isDelete`) VALUES
('12', '乌鸡', '中药', '1212.0', '12120.0', '9', 1),
('123', '何首乌', '西药', '1233.0', '123.0', '123', 0),
('90', '阿莫西林', '西药', '123', '12', '12390', 1),
('999', '999感冒灵', '西药', '30', '12', '1090', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`jobID`);

--
-- Indexes for table `yao`
--
ALTER TABLE `yao`
  ADD PRIMARY KEY (`bianhao`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `jobID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
