--
-- ER/Studio 8.0 SQL Code Generation
-- Company :      bk
-- Project :      QUAN LY HIEU THUOC - dung.dm1
-- Author :       DinhTu
--
-- Date Created : Tuesday, August 12, 2014 14:51:14
-- Target DBMS : MySQL 5.x
--

-- 
-- TABLE: CATEGORY 
--

CREATE TABLE CATEGORY(
    CATEGORY_ID    INT                      AUTO_INCREMENT,
    NAME           NATIONAL VARCHAR(200)    NOT NULL,
    DESCRIPT       NATIONAL VARCHAR(300),
    ACTIVE         BIT(1),
    PRIMARY KEY (CATEGORY_ID)
)ENGINE=MYISAM
;



-- 
-- TABLE: DIARY_BOOK 
--

CREATE TABLE DIARY_BOOK(
    DBK_ID               INT                      AUTO_INCREMENT,
    NAME                 NATIONAL VARCHAR(200)    NOT NULL,
    DATE_CREATE          DATE                     NOT NULL,
    COVER_PHOTO          VARCHAR(100),
    `BACKGROUND-IMAGES`  VARCHAR(100),
    BACKGROUND_AUDIO     CHAR(10),
    AUDIO_AUTOPLAY       BIT(1),
    CATEGORY_ID          INT,
    PRIMARY KEY (DBK_ID)
)ENGINE=MYISAM
;



-- 
-- TABLE: DIARY_BOOK_CONTENT 
--

CREATE TABLE DIARY_BOOK_CONTENT(
    DBC_ID          INT                      AUTO_INCREMENT,
    TITLE           NATIONAL VARCHAR(300),
    CONTENT         TEXT,
    DATE_WRITTEN    DATE,
    PAGE            INT,
    DBK_ID          INT,
    PRIMARY KEY (DBC_ID)
)ENGINE=MYISAM
;



-- 
-- TABLE: DIVINATION 
--

CREATE TABLE DIVINATION(
    DIVINATION_ID    INT                      AUTO_INCREMENT,
    NAME             NATIONAL VARCHAR(100),
    DESCRIPT         NATIONAL VARCHAR(500),
    DCY_ID           INT,
    PRIMARY KEY (DIVINATION_ID)
)ENGINE=MYISAM
;



-- 
-- TABLE: DIVINATION_CATEGORY 
--

CREATE TABLE DIVINATION_CATEGORY(
    DCY_ID      INT                      AUTO_INCREMENT,
    NAME        NATIONAL VARCHAR(100)    NOT NULL,
    DESCRIPT    NATIONAL VARCHAR(500),
    PRIMARY KEY (DCY_ID)
)ENGINE=MYISAM
;



-- 
-- TABLE: DIVINATION_FAST 
--

CREATE TABLE DIVINATION_FAST(
    DFN_ID           INT                      AUTO_INCREMENT,
    DESCRIPT         NATIONAL VARCHAR(500),
    NAME             TEXT                     NOT NULL,
    DIVINATION_ID    INT,
    PRIMARY KEY (DFN_ID)
)ENGINE=MYISAM
;



-- 
-- TABLE: DIVINATION_LONG 
--

CREATE TABLE DIVINATION_LONG(
    DLG_ID           INT                      AUTO_INCREMENT,
    IMAGES           CHAR(200),
    NAME             TEXT                     NOT NULL,
    DESCRIPT         NATIONAL VARCHAR(500),
    DIVINATION_ID    INT,
    PRIMARY KEY (DLG_ID)
)ENGINE=MYISAM
;



-- 
-- TABLE: DIVINATION_LONG_CONTENTS 
--

CREATE TABLE DIVINATION_LONG_CONTENTS(
    DLC_ID      INT     AUTO_INCREMENT,
    QUESTION    TEXT    NOT NULL,
    A           TEXT    NOT NULL,
    B           TEXT    NOT NULL,
    D           TEXT    NOT NULL,
    C           TEXT    NOT NULL,
    MARK_A      INT,
    MARK_B      INT,
    MARK_C      INT,
    MARK_D      INT,
    DLG_ID      INT,
    PRIMARY KEY (DLC_ID)
)ENGINE=MYISAM
;



-- 
-- TABLE: FUNCTION 
--

CREATE TABLE FUNCTION(
    RESOURCE_ID    INT                      NOT NULL,
    NAME           NATIONAL VARCHAR(100),
    NOTE           NATIONAL VARCHAR(100),
    STATUS         BIT(1)                   DEFAULT 1,
    PRIMARY KEY (RESOURCE_ID)
)ENGINE=MYISAM
;



-- 
-- TABLE: FUNNY_IMAGES 
--

CREATE TABLE FUNNY_IMAGES(
    FIS_ID    INT    AUTO_INCREMENT,
    PRIMARY KEY (FIS_ID)
)ENGINE=MYISAM
;



-- 
-- TABLE: PERMISSION 
--

CREATE TABLE PERMISSION(
    PERM_ID     INT                      AUTO_INCREMENT,
    NAME        NATIONAL VARCHAR(40),
    DESCRIPT    NATIONAL VARCHAR(300),
    STATUS      BIT(1)                   DEFAULT 1,
    PRIMARY KEY (PERM_ID)
)ENGINE=MYISAM
;



-- 
-- TABLE: REMIND 
--

CREATE TABLE REMIND(
    REMIND_ID            INT                      AUTO_INCREMENT,
    TITLE                NATIONAL VARCHAR(200),
    CONTENT              TEXT                     NOT NULL,
    CALENDAR_REMINDER    DATE,
    STATUS               BIT(1),
    PRIMARY KEY (REMIND_ID)
)ENGINE=MYISAM
;



-- 
-- TABLE: RESOURCE 
--

CREATE TABLE RESOURCE(
    RESOURCE_KEY      CHAR(100)                NOT NULL,
    RESOURCE_VALUE    TEXT,
    DESCRIPT          NATIONAL VARCHAR(200),
    PRIMARY KEY (RESOURCE_KEY)
)ENGINE=MYISAM
;



-- 
-- TABLE: RESULTS_DIVINATION_COUPLES 
--

CREATE TABLE RESULTS_DIVINATION_COUPLES(
    RDC_ID            INT                      AUTO_INCREMENT,
    SCORE_MIN         INT,
    SCORE_MAX         INT,
    COUPLES_ZODIAC    NATIONAL VARCHAR(100),
    RESULT_CONTENT    TEXT                     NOT NULL,
    DIVINATION_ID     INT,
    PRIMARY KEY (RDC_ID)
)ENGINE=MYISAM
;



-- 
-- TABLE: RESULTS_DIVINATION_FAST 
--

CREATE TABLE RESULTS_DIVINATION_FAST(
    RDF_ID    INT          AUTO_INCREMENT,
    IMAGES    CHAR(200),
    ANSWER    TEXT         NOT NULL,
    RESULT    TEXT         NOT NULL,
    DFN_ID    INT,
    PRIMARY KEY (RDF_ID)
)ENGINE=MYISAM
;



-- 
-- TABLE: RESULTS_DIVINATION_LONG 
--

CREATE TABLE RESULTS_DIVINATION_LONG(
    RDL_ID       INT     AUTO_INCREMENT,
    SCORE_MAX    INT     NOT NULL,
    SCORE_MIN    INT     NOT NULL,
    RESULTS      TEXT    NOT NULL,
    DLG_ID       INT,
    PRIMARY KEY (RDL_ID)
)ENGINE=MYISAM
;



-- 
-- TABLE: ROLE 
--

CREATE TABLE ROLE(
    ROLE_ID     INT                      AUTO_INCREMENT,
    NAME        NATIONAL VARCHAR(40),
    DESCRIPT    NATIONAL VARCHAR(300),
    STATUS      BIT(1)                   DEFAULT 1,
    PRIMARY KEY (ROLE_ID)
)ENGINE=MYISAM
;



-- 
-- TABLE: ROLE_PERM 
--

CREATE TABLE ROLE_PERM(
    RPM_ID         INT    AUTO_INCREMENT,
    PERM_ID        INT    NOT NULL,
    ROLE_ID        INT    NOT NULL,
    RESOURCE_ID    INT,
    PRIMARY KEY (RPM_ID)
)ENGINE=MYISAM
;



-- 
-- TABLE: USER 
--

CREATE TABLE USER(
    USER_ID     INT                      AUTO_INCREMENT,
    NAME        NATIONAL VARCHAR(30),
    USERNAME    VARCHAR(100),
    BIRTHDAY    DATE,
    AVARTAR     VARCHAR(100),
    ADDRESS     NATIONAL VARCHAR(100),
    PHONE       CHAR(11),
    EMAIL       VARCHAR(40),
    GENDER      BIT(1),
    PASSWORD    VARCHAR(30),
    ACTIVE      BIT(1)                   DEFAULT 1,
    PRIMARY KEY (USER_ID)
)ENGINE=MYISAM
;



-- 
-- TABLE: USER_DIARY_BOOK 
--

CREATE TABLE USER_DIARY_BOOK(
    UDB_ID       INT       AUTO_INCREMENT,
    STATUS       BIT(1),
    USER_ID      INT,
    DBK_ID       INT,
    REMIND_ID    INT,
    PRIMARY KEY (UDB_ID)
)ENGINE=MYISAM
;



-- 
-- TABLE: USER_ROLE 
--

CREATE TABLE USER_ROLE(
    ERE        INT       AUTO_INCREMENT,
    USER_ID    INT,
    ROLE_ID    INT,
    STATUS     BIT(1),
    PRIMARY KEY (ERE)
)ENGINE=MYISAM
;



-- 
-- TABLE: ZODIAC 
--

CREATE TABLE ZODIAC(
    ZODIAC_ID    INT                      AUTO_INCREMENT,
    NAME         NATIONAL VARCHAR(100)    NOT NULL,
    DATE         VARCHAR(100)             NOT NULL,
    IMAGES       VARCHAR(100)             NOT NULL,
    PRIMARY KEY (ZODIAC_ID)
)ENGINE=MYISAM
;



-- 
-- TABLE: DIARY_BOOK 
--

ALTER TABLE DIARY_BOOK ADD CONSTRAINT RefCATEGORY155 
    FOREIGN KEY (CATEGORY_ID)
    REFERENCES CATEGORY(CATEGORY_ID)
;


-- 
-- TABLE: DIARY_BOOK_CONTENT 
--

ALTER TABLE DIARY_BOOK_CONTENT ADD CONSTRAINT RefDIARY_BOOK156 
    FOREIGN KEY (DBK_ID)
    REFERENCES DIARY_BOOK(DBK_ID)
;


-- 
-- TABLE: DIVINATION 
--

ALTER TABLE DIVINATION ADD CONSTRAINT RefDIVINATION_CATEGORY187 
    FOREIGN KEY (DCY_ID)
    REFERENCES DIVINATION_CATEGORY(DCY_ID)
;


-- 
-- TABLE: DIVINATION_FAST 
--

ALTER TABLE DIVINATION_FAST ADD CONSTRAINT RefDIVINATION189 
    FOREIGN KEY (DIVINATION_ID)
    REFERENCES DIVINATION(DIVINATION_ID)
;


-- 
-- TABLE: DIVINATION_LONG 
--

ALTER TABLE DIVINATION_LONG ADD CONSTRAINT RefDIVINATION181 
    FOREIGN KEY (DIVINATION_ID)
    REFERENCES DIVINATION(DIVINATION_ID)
;


-- 
-- TABLE: DIVINATION_LONG_CONTENTS 
--

ALTER TABLE DIVINATION_LONG_CONTENTS ADD CONSTRAINT RefDIVINATION_LONG186 
    FOREIGN KEY (DLG_ID)
    REFERENCES DIVINATION_LONG(DLG_ID)
;


-- 
-- TABLE: RESULTS_DIVINATION_COUPLES 
--

ALTER TABLE RESULTS_DIVINATION_COUPLES ADD CONSTRAINT RefDIVINATION188 
    FOREIGN KEY (DIVINATION_ID)
    REFERENCES DIVINATION(DIVINATION_ID)
;


-- 
-- TABLE: RESULTS_DIVINATION_FAST 
--

ALTER TABLE RESULTS_DIVINATION_FAST ADD CONSTRAINT RefDIVINATION_FAST185 
    FOREIGN KEY (DFN_ID)
    REFERENCES DIVINATION_FAST(DFN_ID)
;


-- 
-- TABLE: RESULTS_DIVINATION_LONG 
--

ALTER TABLE RESULTS_DIVINATION_LONG ADD CONSTRAINT RefDIVINATION_LONG190 
    FOREIGN KEY (DLG_ID)
    REFERENCES DIVINATION_LONG(DLG_ID)
;


-- 
-- TABLE: ROLE_PERM 
--

ALTER TABLE ROLE_PERM ADD CONSTRAINT RefFUNCTION191 
    FOREIGN KEY (RESOURCE_ID)
    REFERENCES FUNCTION(RESOURCE_ID)
;

ALTER TABLE ROLE_PERM ADD CONSTRAINT RefROLE106 
    FOREIGN KEY (ROLE_ID)
    REFERENCES ROLE(ROLE_ID)
;

ALTER TABLE ROLE_PERM ADD CONSTRAINT RefPERMISSION108 
    FOREIGN KEY (PERM_ID)
    REFERENCES PERMISSION(PERM_ID)
;


-- 
-- TABLE: USER_DIARY_BOOK 
--

ALTER TABLE USER_DIARY_BOOK ADD CONSTRAINT RefUSER152 
    FOREIGN KEY (USER_ID)
    REFERENCES USER(USER_ID)
;

ALTER TABLE USER_DIARY_BOOK ADD CONSTRAINT RefDIARY_BOOK154 
    FOREIGN KEY (DBK_ID)
    REFERENCES DIARY_BOOK(DBK_ID)
;

ALTER TABLE USER_DIARY_BOOK ADD CONSTRAINT RefREMIND164 
    FOREIGN KEY (REMIND_ID)
    REFERENCES REMIND(REMIND_ID)
;


-- 
-- TABLE: USER_ROLE 
--

ALTER TABLE USER_ROLE ADD CONSTRAINT RefUSER148 
    FOREIGN KEY (USER_ID)
    REFERENCES USER(USER_ID)
;

ALTER TABLE USER_ROLE ADD CONSTRAINT RefROLE119 
    FOREIGN KEY (ROLE_ID)
    REFERENCES ROLE(ROLE_ID)
;


