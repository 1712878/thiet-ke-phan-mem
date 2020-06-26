CREATE TABLE `readers` (
  `personID` varchar(255) PRIMARY KEY,
  `name` nvarchar,
  `dob` datetime,
  `address` nvarchar,
  `email` varchar(255),
  `phone` varchar(255),
  `type` int
);

CREATE TABLE `reader_types` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255)
);

CREATE TABLE `accounts` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `userId` int,
  `username` varchar(255),
  `password` varchar(255),
  `status` ENUM ('active', 'block')
);

CREATE TABLE `publishers` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255)
);

CREATE TABLE `categories` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255)
);

CREATE TABLE `books` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `title` varchar(255),
  `publisher` int,
  `isbn` varchar(255),
  `category` int,
  `fine` double
);

CREATE TABLE `authors` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255),
  `description` varchar(255)
);

CREATE TABLE `author_book` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `idAuthor` int,
  `idBook` int
);

CREATE TABLE `book_items` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `barcode` varchar(255),
  `status` ENUM ('available', 'notavailable'),
  `canBorrow` bool,
  `bookId` int,
  `shelf` varchar(255),
  `publishdate` datetime
);

CREATE TABLE `book_reservations` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `userId` int,
  `time` datetime
);

CREATE TABLE `book_borrow` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `borrowTime` datetime,
  `dueTime` datetime,
  `bookItemId` int,
  `accountId` int
);

CREATE TABLE `cards` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `barcode` varchar(255),
  `readerID` varchar(255)
);

CREATE TABLE `fines` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `createdAt` datetime,
  `bookBorrowID` int,
  `amount` double
);

ALTER TABLE `readers` ADD FOREIGN KEY (`type`) REFERENCES `reader_types` (`id`);

ALTER TABLE `accounts` ADD FOREIGN KEY (`userId`) REFERENCES `readers` (`personID`);

ALTER TABLE `books` ADD FOREIGN KEY (`publisher`) REFERENCES `publishers` (`id`);

ALTER TABLE `books` ADD FOREIGN KEY (`category`) REFERENCES `categories` (`id`);

ALTER TABLE `author_book` ADD FOREIGN KEY (`idAuthor`) REFERENCES `authors` (`id`);

ALTER TABLE `author_book` ADD FOREIGN KEY (`idBook`) REFERENCES `books` (`id`);

ALTER TABLE `book_items` ADD FOREIGN KEY (`bookId`) REFERENCES `books` (`id`);

ALTER TABLE `book_reservations` ADD FOREIGN KEY (`userId`) REFERENCES `accounts` (`id`);

ALTER TABLE `book_borrow` ADD FOREIGN KEY (`bookItemId`) REFERENCES `book_items` (`id`);

ALTER TABLE `book_borrow` ADD FOREIGN KEY (`accountId`) REFERENCES `accounts` (`id`);

ALTER TABLE `cards` ADD FOREIGN KEY (`readerID`) REFERENCES `readers` (`personID`);

ALTER TABLE `fines` ADD FOREIGN KEY (`bookBorrowID`) REFERENCES `book_borrow` (`id`);
