CREATE TABLE `frequently_questions`  (
  `id` int NULL,
  `question` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL,
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL
);

CREATE TABLE `reading_room`  (
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
);

CREATE TABLE `room_borrow`  (
  `id` int NOT NULL,
  `roomId` int NULL,
  `accountId` int NULL,
  `borrowTime` datetime(0) NULL,
  `dueTime` datetime(0) NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `accounts`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `userId` int NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `status` enum('active','block') CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT 'active',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `userId`(`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

CREATE TABLE `author_book`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `idAuthor` int NULL DEFAULT NULL,
  `idBook` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idAuthor`(`idAuthor`) USING BTREE,
  INDEX `idBook`(`idBook`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

CREATE TABLE `authors`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

CREATE TABLE `book_borrow`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `borrowTime` datetime(0) NULL DEFAULT NULL,
  `dueTime` datetime(0) NULL DEFAULT NULL,
  `bookItemId` int NULL DEFAULT NULL,
  `accountId` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `bookItemId`(`bookItemId`) USING BTREE,
  INDEX `accountId`(`accountId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

CREATE TABLE `book_items`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `barcode` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `status` enum('available','notavailable') CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT 'available',
  `canBorrow` tinyint(1) NULL DEFAULT NULL,
  `bookId` int NULL DEFAULT NULL,
  `shelf` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `publishdate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `bookId`(`bookId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

CREATE TABLE `book_reservations`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `userId` int NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `userId`(`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

CREATE TABLE `books`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `publisherId` int NULL DEFAULT NULL,
  `isbn` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `categoryId` int NULL DEFAULT NULL,
  `fine` double NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `publisher`(`publisherId`) USING BTREE,
  INDEX `category`(`categoryId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

CREATE TABLE `cards`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `barcode` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `readerID` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `readerID`(`readerID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

CREATE TABLE `categories`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

CREATE TABLE `fines`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `createdAt` datetime(0) NULL DEFAULT NULL,
  `bookBorrowID` int NULL DEFAULT NULL,
  `amount` double NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `bookBorrowID`(`bookBorrowID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

CREATE TABLE `publishers`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

CREATE TABLE `reader_types`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

CREATE TABLE `readers`  (
  `personID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `dob` datetime(0) NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `type` int NULL DEFAULT NULL,
  PRIMARY KEY (`personID`) USING BTREE,
  INDEX `type`(`type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = DYNAMIC;

ALTER TABLE `room_borrow` ADD CONSTRAINT `rombrow_readingroom_fk` FOREIGN KEY (`roomId`) REFERENCES `reading_room` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `room_borrow` ADD CONSTRAINT `romborrow_account_fk` FOREIGN KEY (`accountId`) REFERENCES `accounts` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `accounts` ADD CONSTRAINT `accounts_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `readers` (`personID`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `author_book` ADD CONSTRAINT `author_book_ibfk_1` FOREIGN KEY (`idAuthor`) REFERENCES `authors` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `author_book` ADD CONSTRAINT `author_book_ibfk_2` FOREIGN KEY (`idBook`) REFERENCES `books` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `book_borrow` ADD CONSTRAINT `book_borrow_ibfk_1` FOREIGN KEY (`bookItemId`) REFERENCES `book_items` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `book_borrow` ADD CONSTRAINT `book_borrow_ibfk_2` FOREIGN KEY (`accountId`) REFERENCES `accounts` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `book_items` ADD CONSTRAINT `book_items_ibfk_1` FOREIGN KEY (`bookId`) REFERENCES `books` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `book_reservations` ADD CONSTRAINT `book_reservations_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `accounts` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `books` ADD CONSTRAINT `books_ibfk_1` FOREIGN KEY (`publisherId`) REFERENCES `publishers` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `books` ADD CONSTRAINT `books_ibfk_2` FOREIGN KEY (`categoryId`) REFERENCES `categories` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `cards` ADD CONSTRAINT `cards_ibfk_1` FOREIGN KEY (`readerID`) REFERENCES `readers` (`personID`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `fines` ADD CONSTRAINT `fines_ibfk_1` FOREIGN KEY (`bookBorrowID`) REFERENCES `book_borrow` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE `readers` ADD CONSTRAINT `readers_ibfk_1` FOREIGN KEY (`type`) REFERENCES `reader_types` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

alter table book_reservations add bookItemId int;
alter table book_reservations add foreign key (bookItemId) references book_items(id);

create table constants(
    id int auto_increment primary key ,
    k varchar(255),
    value varchar(255)
);

-- alter table accounts change userId readerId int;

create table user_responses(
    id int auto_increment primary key ,
    accountId int,
    content varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
    createTime datetime
);

alter table user_responses add foreign key (accountId) references accounts(id);
alter table reading_room add roomName varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci;


