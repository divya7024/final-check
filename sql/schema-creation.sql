-- 1. Design the schema for movie cruiser in MySQL Workbench
-- 2. Generate the SQL schema script in MySQL Workbench
-- 3. Paste the generated the SQL code here
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Movie Crusier
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Movie Crusier
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `moviecrusier` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `moviecrusier` ;

-- -----------------------------------------------------
-- Table Movie Crusier.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moviecrusier` .`user` (
  `us_id` INT NOT NULL AUTO_INCREMENT,
  `us_name` VARCHAR(60) NULL,
  PRIMARY KEY (`us_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Movie Crusier.`movie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moviecrusier` .`movie_list` (
  `mv_id` INT NOT NULL AUTO_INCREMENT,
  `mv_title` VARCHAR(100) NULL,
  `mv_box_office` DECIMAL(15,2) NULL,
  `mv_active` VARCHAR(3) NULL,
  `mv_date_of_launch` DATE NULL,
  `mv_genre` VARCHAR(45) NULL,
  `mv_has_teaser` VARCHAR(3) NULL,
  PRIMARY KEY (`mv_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table Movie Crusier.favorites
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moviecrusier` .`favorites` (
  `fv_id` INT NOT NULL AUTO_INCREMENT,
  `fv_us_id` INT NULL,
  `fv_pr_id` INT NULL,
  PRIMARY KEY (`fv_id`),
  INDEX `fv_us_fk_idx` (`fv_us_id` ASC),
  INDEX `fv_pr_fk_idx` (`fv_pr_id` ASC),
  CONSTRAINT `fv_us_fk`
    FOREIGN KEY (`fv_us_id`)
    REFERENCES `moviecrusier`.`user` (`us_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fv_pr_fk`
    FOREIGN KEY (`fv_pr_id`)
    REFERENCES `moviecrusier`.`movie_list` (`mv_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
