-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema paje
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema paje
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `paje` DEFAULT CHARACTER SET utf8 ;
USE `paje` ;

-- -----------------------------------------------------
-- Table `paje`.`type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `paje`.`type` (
  `alias` VARCHAR(20) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `depth` INT NULL,
  `parent_type_alias` VARCHAR(20) NULL,
  PRIMARY KEY (`alias`),
  INDEX `fk_type_type1_idx` (`parent_type_alias` ASC),
  CONSTRAINT `fk_type_type1`
    FOREIGN KEY (`parent_type_alias`)
    REFERENCES `paje`.`type` (`alias`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `paje`.`container`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `paje`.`container` (
  `alias` VARCHAR(20) NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `startTime` INT NULL,
  `endTime` INT NULL,
  `parent_container_alias` VARCHAR(20) NULL,
  `type_alias` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`alias`),
  INDEX `fk_container_container_idx` (`parent_container_alias` ASC),
  INDEX `fk_container_type1_idx` (`type_alias` ASC),
  CONSTRAINT `fk_container_container`
    FOREIGN KEY (`parent_container_alias`)
    REFERENCES `paje`.`container` (`alias`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_container_type1`
    FOREIGN KEY (`type_alias`)
    REFERENCES `paje`.`type` (`alias`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `paje`.`value`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `paje`.`value` (
  `alias` VARCHAR(20) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `color` VARCHAR(15) NULL,
  `type_alias` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`alias`, `type_alias`),
  INDEX `fk_value_type1_idx` (`type_alias` ASC),
  CONSTRAINT `fk_value_type1`
    FOREIGN KEY (`type_alias`)
    REFERENCES `paje`.`type` (`alias`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `paje`.`event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `paje`.`event` (
  `time` INT NOT NULL,
  `container_alias` VARCHAR(20) NOT NULL,
  `value_alias` VARCHAR(20) NOT NULL,
  `type_alias` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`container_alias`, `value_alias`, `type_alias`),
  INDEX `fk_event_container1_idx` (`container_alias` ASC),
  INDEX `fk_event_value1_idx` (`value_alias` ASC),
  INDEX `fk_event_type1_idx` (`type_alias` ASC),
  CONSTRAINT `fk_event_container1`
    FOREIGN KEY (`container_alias`)
    REFERENCES `paje`.`container` (`alias`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_event_value1`
    FOREIGN KEY (`value_alias`)
    REFERENCES `paje`.`value` (`alias`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_event_type1`
    FOREIGN KEY (`type_alias`)
    REFERENCES `paje`.`type` (`alias`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `paje`.`variable`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `paje`.`variable` (
  `time` INT NOT NULL,
  `value` INT NOT NULL,
  `container_alias` VARCHAR(20) NOT NULL,
  `type_alias` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`time`, `container_alias`, `type_alias`),
  INDEX `fk_variable_container1_idx` (`container_alias` ASC),
  INDEX `fk_variable_type1_idx` (`type_alias` ASC),
  CONSTRAINT `fk_variable_container1`
    FOREIGN KEY (`container_alias`)
    REFERENCES `paje`.`container` (`alias`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_variable_type1`
    FOREIGN KEY (`type_alias`)
    REFERENCES `paje`.`type` (`alias`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `paje`.`state`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `paje`.`state` (
  `startTime` INT NOT NULL,
  `endTime` INT NOT NULL,
  `type_alias` VARCHAR(20) NOT NULL,
  `value_alias` VARCHAR(20) NOT NULL,
  `container_alias` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`startTime`, `type_alias`, `value_alias`, `container_alias`),
  INDEX `fk_state_type1_idx` (`type_alias` ASC),
  INDEX `fk_state_value1_idx` (`value_alias` ASC),
  INDEX `fk_state_container1_idx` (`container_alias` ASC),
  CONSTRAINT `fk_state_type1`
    FOREIGN KEY (`type_alias`)
    REFERENCES `paje`.`type` (`alias`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_state_value1`
    FOREIGN KEY (`value_alias`)
    REFERENCES `paje`.`value` (`alias`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_state_container1`
    FOREIGN KEY (`container_alias`)
    REFERENCES `paje`.`container` (`alias`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
