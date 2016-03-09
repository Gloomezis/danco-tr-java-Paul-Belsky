CREATE DATABASE IF NOT EXISTS mydb;

USE mydb;

CREATE TABLE IF NOT EXISTS `mydb`.`product` (
  `maker` VARCHAR(10) NOT NULL,
  `model` VARCHAR(50) NOT NULL,
  `type` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`model`))
ENGINE = InnoDB

CREATE TABLE IF NOT EXISTS `mydb`.`laptop` (
  `code` INT NOT NULL,
  `model` VARCHAR(50) NOT NULL,
  `speed` SMALLINT NOT NULL,
  `ram` SMALLINT NOT NULL,
  `hd` REAL NOT NULL,
  `price` DOUBLE NULL,
  `screen` TINYINT NOT NULL,
  PRIMARY KEY (`code`),
  INDEX `model_idx` (`model` ASC),
  CONSTRAINT `model`
    FOREIGN KEY (`model`)
    REFERENCES `mydb`.`product` (`model`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB

CREATE TABLE IF NOT EXISTS `mydb`.`pc` (
  `code` INT NOT NULL,
  `model` VARCHAR(50) NOT NULL,
  `speed` SMALLINT NOT NULL,
  `ram` SMALLINT NOT NULL,
  `hd` REAL NOT NULL,
  `cd` VARCHAR(10) NOT NULL,
  `price` DOUBLE NULL,
  PRIMARY KEY (`code`),
  INDEX `model_idx` (`model` ASC),
  CONSTRAINT `model`
    FOREIGN KEY (`model`)
    REFERENCES `mydb`.`product` (`model`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB

CREATE TABLE IF NOT EXISTS `mydb`.`printer` (
  `code` INT NOT NULL,
  `model` VARCHAR(50) NOT NULL,
  `color` CHAR(1) NOT NULL,
  `type` VARCHAR(10) NOT NULL,
  `price` DOUBLE NULL,
  PRIMARY KEY (`code`),
  INDEX `model_idx` (`model` ASC),
  CONSTRAINT `model`
    FOREIGN KEY (`model`)
    REFERENCES `mydb`.`product` (`model`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB