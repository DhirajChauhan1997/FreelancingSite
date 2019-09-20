-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 15, 2018 at 06:03 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_prolancer`
--

-- --------------------------------------------------------

--
-- Structure for view `view_user_groups`
--

CREATE ALGORITHM=UNDEFINED DEFINER=`dhiraj`@`localhost` SQL SECURITY DEFINER VIEW `view_user_groups`  AS  select `user_group`.`userid` AS `userid`,`user_group`.`groupid` AS `groupid`,`user`.`username` AS `username`,`user`.`password` AS `password`,`grouptbl`.`groupname` AS `groupName` from ((`user_group` join `user` on((`user_group`.`userid` = `user`.`userid`))) join `grouptbl` on((`user_group`.`groupid` = `grouptbl`.`groupid`))) ;

--
-- VIEW  `view_user_groups`
-- Data: None
--

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
