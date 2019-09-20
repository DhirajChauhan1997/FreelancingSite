-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 15, 2018 at 06:34 PM
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
-- Table structure for table `apply_project`
--

CREATE TABLE `apply_project` (
  `apply_project_id` int(11) NOT NULL,
  `postid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `status` text NOT NULL,
  `coverlatter` text NOT NULL,
  `applyon` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `apply_project`
--

INSERT INTO `apply_project` (`apply_project_id`, `postid`, `userid`, `status`, `coverlatter`, `applyon`) VALUES
(1, 12, 22, 'un complate', 'ajjhjfhjshfjsfhjshfjshfjsf', '22/8/2018');

-- --------------------------------------------------------

--
-- Table structure for table `categ`
--

CREATE TABLE `categ` (
  `categid` int(11) NOT NULL,
  `categname` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `categ`
--

INSERT INTO `categ` (`categid`, `categname`) VALUES
(1, 'Mobile App'),
(2, 'Web Development'),
(5, 'Information Technology'),
(6, 'Marketing');

-- --------------------------------------------------------

--
-- Table structure for table `grouptbl`
--

CREATE TABLE `grouptbl` (
  `groupid` int(11) NOT NULL,
  `groupname` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `grouptbl`
--

INSERT INTO `grouptbl` (`groupid`, `groupname`) VALUES
(1, 'admin'),
(2, 'user');

-- --------------------------------------------------------

--
-- Table structure for table `job_complete`
--

CREATE TABLE `job_complete` (
  `job_complate_id` int(11) NOT NULL,
  `postid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `finish_on` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `post`
--

CREATE TABLE `post` (
  `postid` int(11) NOT NULL,
  `posterid` int(11) NOT NULL,
  `title` varchar(50) NOT NULL,
  `skillid` int(11) NOT NULL,
  `price` varchar(10) NOT NULL,
  `duration` varchar(20) NOT NULL,
  `hmworker` varchar(10) NOT NULL,
  `jobdescr` varchar(300) NOT NULL,
  `categid` int(11) NOT NULL,
  `postedon` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `post`
--

INSERT INTO `post` (`postid`, `posterid`, `title`, `skillid`, `price`, `duration`, `hmworker`, `jobdescr`, `categid`, `postedon`) VALUES
(12, 23, 'test', 31, '1000', '12', '12', 'ajhsgshgghgdshdgshgd', 5, '22/8/2015');

-- --------------------------------------------------------

--
-- Table structure for table `skill`
--

CREATE TABLE `skill` (
  `skillid` int(11) NOT NULL,
  `skill` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `skill`
--

INSERT INTO `skill` (`skillid`, `skill`) VALUES
(30, 'Web Development'),
(31, 'Android Developer'),
(32, 'Asp.net Dvelopment'),
(33, 'PHP Developement'),
(35, 'Anguler JS Developer');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userid` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `mobno` varchar(15) NOT NULL,
  `fname` varchar(25) NOT NULL,
  `lname` varchar(25) NOT NULL,
  `photo` text,
  `skillid` int(11) NOT NULL,
  `description` text,
  `createdon` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userid`, `username`, `password`, `email`, `mobno`, `fname`, `lname`, `photo`, `skillid`, `description`, `createdon`) VALUES
(22, 'mahi', 'mahi', 'mahi@d.com', '9904750956', 'mahi', 'chauhan', 'mahi.jpg', 31, 'i am android develorr', '8/08/2018'),
(23, 'dhiraj', 'dhiraj', 'mahi@d.com', '9904750956', 'mahi', 'chauhan', 'mahi.jpg', 31, 'i am android develorr', '8/08/2018'),
(24, 'sandip', 'sandip', 'sandip@d.com', '878787887', 'sandip', 'valvi', 'sandip.jpg', 30, 'i am sandip', '22/09/2018'),
(25, 'tetst', 'fsffsf', 'sandip@d.com', '878787887', 'sandip', 'valvi', 'sandip.jpg', 30, 'i am sandip', '22/09/2018'),
(26, 'tetst', 'fsffsf', 'sandip@d.com', '878787887', 'sandip', 'valvi', 'sandip.jpg', 30, 'i am sandip', '22/09/2018');

-- --------------------------------------------------------

--
-- Table structure for table `user_group`
--

CREATE TABLE `user_group` (
  `user_group_id` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `groupid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_group`
--

INSERT INTO `user_group` (`user_group_id`, `userid`, `groupid`) VALUES
(16, 24, 1),
(17, 25, 1),
(18, 26, 1),
(19, 23, 2),
(20, 24, 1);

-- --------------------------------------------------------

--
-- Stand-in structure for view `view_user_groups`
-- (See below for the actual view)
--
CREATE TABLE `view_user_groups` (
`userid` int(11)
,`groupid` int(11)
,`username` varchar(50)
,`password` varchar(50)
,`groupName` varchar(100)
);

-- --------------------------------------------------------

--
-- Structure for view `view_user_groups`
--
DROP TABLE IF EXISTS `view_user_groups`;

CREATE ALGORITHM=UNDEFINED DEFINER=`dhiraj`@`localhost` SQL SECURITY DEFINER VIEW `view_user_groups`  AS  select `user_group`.`userid` AS `userid`,`user_group`.`groupid` AS `groupid`,`user`.`username` AS `username`,`user`.`password` AS `password`,`grouptbl`.`groupname` AS `groupName` from ((`user_group` join `user` on((`user_group`.`userid` = `user`.`userid`))) join `grouptbl` on((`user_group`.`groupid` = `grouptbl`.`groupid`))) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `apply_project`
--
ALTER TABLE `apply_project`
  ADD PRIMARY KEY (`apply_project_id`),
  ADD KEY `pjobid` (`postid`),
  ADD KEY `userid` (`userid`);

--
-- Indexes for table `categ`
--
ALTER TABLE `categ`
  ADD PRIMARY KEY (`categid`);

--
-- Indexes for table `grouptbl`
--
ALTER TABLE `grouptbl`
  ADD PRIMARY KEY (`groupid`);

--
-- Indexes for table `job_complete`
--
ALTER TABLE `job_complete`
  ADD PRIMARY KEY (`job_complate_id`),
  ADD KEY `pjobid` (`postid`),
  ADD KEY `userid` (`userid`);

--
-- Indexes for table `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`postid`),
  ADD KEY `posterid` (`posterid`),
  ADD KEY `skillid` (`skillid`),
  ADD KEY `categ_id` (`categid`);

--
-- Indexes for table `skill`
--
ALTER TABLE `skill`
  ADD PRIMARY KEY (`skillid`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userid`),
  ADD KEY `skillid` (`skillid`);

--
-- Indexes for table `user_group`
--
ALTER TABLE `user_group`
  ADD PRIMARY KEY (`user_group_id`),
  ADD KEY `group_id` (`groupid`),
  ADD KEY `userid` (`userid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `apply_project`
--
ALTER TABLE `apply_project`
  MODIFY `apply_project_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `categ`
--
ALTER TABLE `categ`
  MODIFY `categid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `grouptbl`
--
ALTER TABLE `grouptbl`
  MODIFY `groupid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `job_complete`
--
ALTER TABLE `job_complete`
  MODIFY `job_complate_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `post`
--
ALTER TABLE `post`
  MODIFY `postid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `skill`
--
ALTER TABLE `skill`
  MODIFY `skillid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `userid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `user_group`
--
ALTER TABLE `user_group`
  MODIFY `user_group_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `apply_project`
--
ALTER TABLE `apply_project`
  ADD CONSTRAINT `apply_project_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `apply_project_ibfk_2` FOREIGN KEY (`postid`) REFERENCES `post` (`postid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `job_complete`
--
ALTER TABLE `job_complete`
  ADD CONSTRAINT `job_complete_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `post`
--
ALTER TABLE `post`
  ADD CONSTRAINT `post_ibfk_1` FOREIGN KEY (`posterid`) REFERENCES `user` (`userid`),
  ADD CONSTRAINT `post_ibfk_2` FOREIGN KEY (`skillid`) REFERENCES `skill` (`skillid`),
  ADD CONSTRAINT `post_ibfk_3` FOREIGN KEY (`categid`) REFERENCES `categ` (`categid`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`skillid`) REFERENCES `skill` (`skillid`);

--
-- Constraints for table `user_group`
--
ALTER TABLE `user_group`
  ADD CONSTRAINT `user_group_ibfk_1` FOREIGN KEY (`groupid`) REFERENCES `grouptbl` (`groupid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `user_group_ibfk_2` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
