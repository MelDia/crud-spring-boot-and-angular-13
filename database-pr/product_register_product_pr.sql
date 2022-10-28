-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: product_register
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `product_pr`
--

DROP TABLE IF EXISTS `product_pr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_pr` (
  `id` bigint NOT NULL,
  `description` varchar(455) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `images` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_pr`
--

LOCK TABLES `product_pr` WRITE;
/*!40000 ALTER TABLE `product_pr` DISABLE KEYS */;
INSERT INTO `product_pr` VALUES (17,'Ride and fight into a deadly, post pandemic America. Play as Deacon St. John, a drifter and bounty hunter who rides the broken road, fighting to survive.','US$ 19,99',_binary '','Days gone','https://res.cloudinary.com/dseoamxml/image/upload/v1666821551/header6_bwtavc.jpg'),(18,'Batman is dead. Gotham\'s safety now depends on Batgirl, Nightwing, Red Hood and Robin.','US$ 59,99',_binary '','Gotham knights','https://res.cloudinary.com/dseoamxml/image/upload/v1666819446/header_jo6thi.jpg'),(19,'Six years have passed since the biological disaster in Raccoon City. Leon S. Kennedy, one of the survivors, tracks the president\'s kidnapped daughter to a secluded European village, where there is something terribly wrong with the locals.','US$ 69,99',_binary '','Resident evil 4','https://res.cloudinary.com/dseoamxml/image/upload/v1666821551/header4_utxkva.jpg'),(20,'Jill Valentine is one of the last remaining people in Raccoon City to witness the atrocities Umbrella performed. To stop her, Umbrella unleashes their ultimate secret weapon: Nemesis!','US$ 11,99',_binary '\0','Resident evil 3','https://res.cloudinary.com/dseoamxml/image/upload/v1666821551/header5_tkb8rk.jpg'),(21,'Play as Nathan Drake and Chloe Frazer in their own standalone adventures as they confront their pasts and forge their own legacies.','US$ 10,99',_binary '\0','Uncharted collection','https://res.cloudinary.com/dseoamxml/image/upload/v1666821552/header3_eumvco.jpg'),(22,'After the events of Marvel’s Spider-Man Remastered, teenage Miles Morales is adjusting to his new home while following in the footsteps of his mentor, Peter Parker, as a new Spider-Man.','US$ 69,99',_binary '\0','Marvel’s Spider-Man: Miles Morales','https://res.cloudinary.com/dseoamxml/image/upload/v1666821551/header7_vhfkcd.jpg'),(23,'Embark on a heartrending journey into a brutal, breathtaking world, and discover the cost of saving those you love in a desperate struggle for survival.','US$ 49,99',_binary '','A plague tale requiem','https://res.cloudinary.com/dseoamxml/image/upload/v1666820745/header2_phw7eh.jpg'),(24,'Fear and isolation seep through the walls of an abandoned southern farmhouse.','US$ 29,99',_binary '\0','Resident evil 7','https://res.cloudinary.com/dseoamxml/image/upload/v1666836396/header10_ftg94i.jpg'),(25,'Experience survival horror like never before in the 8th major installment in the Resident Evil franchise - Resident Evil Village.','US$ 29,99',_binary '','Resident evil 8','https://res.cloudinary.com/dseoamxml/image/upload/v1666836396/header8_qtgr44.jpg'),(26,'Embark on an odyssey for the Lost Ark in a vast, vibrant world: explore new lands, seek out lost treasures, and test yourself in thrilling action combat in this action-packed free-to-play RPG.','US$ 29,99',_binary '\0','Lost ark','https://res.cloudinary.com/dseoamxml/image/upload/v1666836396/header9_t5kxwj.jpg');
/*!40000 ALTER TABLE `product_pr` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-27 21:18:26
