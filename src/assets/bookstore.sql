-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 14, 2023 at 03:42 PM
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
-- Database: `bookstore`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `id` bigint(20) NOT NULL,
  `author` varchar(100) NOT NULL,
  `isbn` bigint(20) NOT NULL,
  `title` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`id`, `author`, `isbn`, `title`) VALUES
(1, 'Joel Grus', 9781492041139, 'Data Science from Scratch First Principles with Python'),
(2, 'Michael Franken', 9789045350301, 'Voor Dummies - Scrum voor Dummies'),
(3, 'Jeff Sutherland', 9781847941107, 'Scrum'),
(4, 'Rik van der Wardt', 9789024421794, 'Het Scrum Modellenboek'),
(5, 'Nader K. Rad', 9789401807937, 'Agile Scrum Handboek'),
(6, 'Rini van Solingen', 9789043039987, 'De kracht van Scrum'),
(7, 'Eric Matthes', 9789059056749, 'Crash course programmeren in Python'),
(8, 'Studio Visual Steps', 9789059056541, 'Stap voor stap leren programmeren met Python'),
(9, 'Luciano Ramalho', 9781492056355, 'Fluent Python'),
(10, 'Zed Shaw', 9780134692883, 'Learn Python 3 the Hard Way'),
(11, 'Dr Charles Russell Severance', 9781530051120, 'Python for Everybody'),
(12, 'John Paul Mueller', 9789045354521, 'Voor Dummies - Programmeren met Python voor Dummies'),
(13, 'Allen B Downey', 9781491939369, 'Think Python'),
(14, 'Lee Vaughan', 9781718502666, 'Python Tools For Scientists'),
(15, 'Wes Mckinney', 9781098103989, 'Python for Data Analysis'),
(16, 'Francois Chollet', 9781617296864, 'Deep Learning with Python'),
(17, 'David Flanagan', 9781491952023, 'JavaScript The Definitive Guide'),
(18, 'Scott Selikoff', 9781119864585, 'OCP Oracle Certified Professional Java SE 17 Developer Study Guide'),
(19, 'Joshua Bloch', 9780134685991, 'Effective Java'),
(20, 'B Burd', 9781119861645, 'Java For Dummies, 8th Edition'),
(21, 'P. Kassenaar', 9789059404144, 'Handboek (X)HTML, CSS en JavaScript'),
(22, 'Jon Duckett', 9781118531648, 'JavaScript &amp; Jquery'),
(23, 'Steve Suehring', 9781118213704, 'PHP MySQL JavaScript &amp; HTML5 All in One'),
(24, 'Michael Kxc3xb6lling', 9789043018791, 'Programmeren in Java met Greenfoot'),
(25, 'Chris Minnick', 9789045354705, 'Voor Dummies - Programmeren met JavaScript voor Dummies'),
(26, 'Robin Nixon', 9781492093824, 'Learning PHP, MySQL &amp; JavaScript'),
(27, 'Herbert Schildt', 9781260463415, 'Java: The Complete Reference, Twelfth Edition'),
(28, 'Aurelien Geron', 9781492032649, 'Hands-on Machine Learning with Scikit-Learn, Keras, and TensorFlow'),
(29, 'Ian Goodfellow', 9780262035613, 'Deep Learning'),
(30, 'Osvaldo Simeone', 9781316512821, 'Machine Learning for Engineers'),
(31, 'Julian McAuley', 9781316518908, 'Personalized Machine Learning'),
(32, 'Kevin P. Murphy', 9780262046824, 'Probabilistic Machine Learning'),
(33, 'Steven L. Brunton', 9781009098489, 'Data-Driven Science and Engineering'),
(34, 'Andriy Burkov', 9781999579517, 'The Hundred-Page Machine Learning Book'),
(35, 'Linda van der Meer', 9789463867726, 'Trainershandleiding \'Feedback geven en ontvangen\''),
(36, 'Marieta Koopmans', 9789058711878, 'Feedback'),
(37, 'Anne Arink', 9789065080578, 'Kom maar op met je feedback'),
(38, 'E Freeman', 9781119552222, 'DevOps For Dummies'),
(39, 'Rik Marselis', 9789075414899, 'Quality for DevOps teams'),
(40, 'Gene Kim', 9781950508402, 'The DevOps Handbook'),
(41, 'Bradley Smith', 9781718502482, 'Devops For The Desperate'),
(42, 'Subhajit Chatterjee', 9781803230283, 'Designing and Implementing Microsoft DevOps Solutions AZ-400 Exam Guide'),
(43, 'Jeffrey Palermo', 9781484253434, '.NET DevOps for Azure');

-- --------------------------------------------------------

--
-- Table structure for table `book_keywords`
--

CREATE TABLE `book_keywords` (
  `book_id` bigint(20) NOT NULL,
  `keyword_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `book_keywords`
--

INSERT INTO `book_keywords` (`book_id`, `keyword_id`) VALUES
(24, 3),
(1, 1),
(7, 2);

-- --------------------------------------------------------

--
-- Table structure for table `copy`
--

CREATE TABLE `copy` (
  `id` bigint(20) NOT NULL,
  `available` bit(1) NOT NULL,
  `book_id` bigint(20) NOT NULL,
  `number` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `copy`
--

INSERT INTO `copy` (`id`, `available`, `book_id`, `number`) VALUES
(1, b'1', 1, 1),
(2, b'1', 1, 2),
(3, b'1', 2, 1),
(4, b'1', 3, 1),
(5, b'1', 3, 2);

-- --------------------------------------------------------

--
-- Table structure for table `keyword`
--

CREATE TABLE `keyword` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `keyword`
--

INSERT INTO `keyword` (`id`, `name`) VALUES
(1, 'Mystery'),
(2, 'Avontuur'),
(3, 'Java');

-- --------------------------------------------------------

--
-- Table structure for table `loan`
--

CREATE TABLE `loan` (
  `id` bigint(20) NOT NULL,
  `end_date` date DEFAULT NULL,
  `start_date` date NOT NULL,
  `copy_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `loan`
--

INSERT INTO `loan` (`id`, `end_date`, `start_date`, `copy_id`, `user_id`) VALUES
(1, '2023-03-08', '2023-03-01', 1, 1),
(2, '2023-03-09', '2023-03-02', 2, 1),
(3, '2023-03-10', '2023-03-03', 3, 2),
(4, '2023-03-11', '2023-03-04', 4, 2);

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE `reservation` (
  `id` bigint(20) NOT NULL,
  `date` date NOT NULL,
  `book_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reservation`
--

INSERT INTO `reservation` (`id`, `date`, `book_id`, `user_id`) VALUES
(1, '2023-03-01', 1, 1),
(2, '2023-03-02', 2, 2),
(3, '2023-03-03', 3, 3);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `admin` bit(1) NOT NULL,
  `email_address` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(128) NOT NULL,
  `token` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `admin`, `email_address`, `first_name`, `last_name`, `password`, `token`) VALUES
(1, b'1', 'john.doe@example.com', 'John', 'Doe', '1234', NULL),
(2, b'0', 'jane.doe@example.com', 'Jane', 'Doe', '1234', NULL),
(3, b'0', 'bob.smith@example.com', 'Bob', 'Smith', '1234', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `book_keywords`
--
ALTER TABLE `book_keywords`
  ADD KEY `FKs85552w5nwl6s1lobfh5ofj6j` (`keyword_id`),
  ADD KEY `FKobxm8gdxf4vhmsynxkmrp8sif` (`book_id`);

--
-- Indexes for table `copy`
--
ALTER TABLE `copy`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKof5k7k6c41i06j6fj3slgsmam` (`book_id`);

--
-- Indexes for table `keyword`
--
ALTER TABLE `keyword`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `loan`
--
ALTER TABLE `loan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKw8dbi4aoljiy817dnmnpaikd` (`copy_id`),
  ADD KEY `FKxxm1yc1xty3qn1pthgj8ac4f` (`user_id`);

--
-- Indexes for table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKirxtcw4s6lhwi6l9ocrk6bjfy` (`book_id`),
  ADD KEY `FKm4oimk0l1757o9pwavorj6ljg` (`user_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT for table `copy`
--
ALTER TABLE `copy`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `keyword`
--
ALTER TABLE `keyword`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `loan`
--
ALTER TABLE `loan`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `book_keywords`
--
ALTER TABLE `book_keywords`
  ADD CONSTRAINT `FKobxm8gdxf4vhmsynxkmrp8sif` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  ADD CONSTRAINT `FKs85552w5nwl6s1lobfh5ofj6j` FOREIGN KEY (`keyword_id`) REFERENCES `keyword` (`id`);

--
-- Constraints for table `copy`
--
ALTER TABLE `copy`
  ADD CONSTRAINT `FKof5k7k6c41i06j6fj3slgsmam` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`);

--
-- Constraints for table `loan`
--
ALTER TABLE `loan`
  ADD CONSTRAINT `FKw8dbi4aoljiy817dnmnpaikd` FOREIGN KEY (`copy_id`) REFERENCES `copy` (`id`),
  ADD CONSTRAINT `FKxxm1yc1xty3qn1pthgj8ac4f` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `FKirxtcw4s6lhwi6l9ocrk6bjfy` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  ADD CONSTRAINT `FKm4oimk0l1757o9pwavorj6ljg` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
