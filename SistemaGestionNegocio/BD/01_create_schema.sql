-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema bruno_minelli_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bruno_minelli_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bruno_minelli_db` DEFAULT CHARACTER SET utf8 ;
USE `bruno_minelli_db` ;


-- -----------------------------------------------------
-- Table `bruno_minelli_db`.`TSA_POLITICAS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bruno_minelli_db`.`TSA_POLITICAS` ;

CREATE TABLE IF NOT EXISTS `bruno_minelli_db`.`TSA_POLITICAS` (
  `id_politica` INT NOT NULL AUTO_INCREMENT,
  `desc_politica` VARCHAR(100) NULL,
  `min_puntos_ind` INT NULL,
  `max_puntos_ind` INT NULL,
  `min_puntos_grupal` INT NULL,
  `max_puntos_grupal` INT NULL,
  `porcentaje_descuento` DECIMAL(4,2) NULL,
  PRIMARY KEY (`id_politica`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bruno_minelli_db`.`TSA_CATEGORIA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bruno_minelli_db`.`TSA_CATEGORIA` ;

CREATE TABLE IF NOT EXISTS `bruno_minelli_db`.`TSA_CATEGORIA` (
  `id_categoria` INT NOT NULL AUTO_INCREMENT,
  `nombre_categoria` VARCHAR(100) NULL,
  `desc_categoria` VARCHAR(500) NULL,
  `estado_categoria` TINYINT NULL, 
  PRIMARY KEY (`id_categoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bruno_minelli_db`.`TSA_PRODUCTO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bruno_minelli_db`.`TSA_PRODUCTO` ;

CREATE TABLE IF NOT EXISTS `bruno_minelli_db`.`TSA_PRODUCTO` (
  `id_producto` INT NOT NULL AUTO_INCREMENT,
  `id_categoria` INT NOT NULL,
  `nombre_producto` VARCHAR(200) NULL,
  `precio_producto` DECIMAL(10,2) NULL,
  `puntos_producto` INT NULL,
  `stock_producto` INT NULL,
  `imagen_producto` VARCHAR(500) NULL,
  `estado_producto` TINYINT(1) NULL,
  `descripcion_producto` VARCHAR(400) NULL,
  PRIMARY KEY (`id_producto`),
  INDEX `fk_TSA_PRODUCTO_TSA_CATEGORIA1_idx` (`id_categoria` ASC),
  CONSTRAINT `fk_TSA_PRODUCTO_TSA_CATEGORIA1`
    FOREIGN KEY (`id_categoria`)
    REFERENCES `bruno_minelli_db`.`TSA_CATEGORIA` (`id_categoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bruno_minelli_db`.`TSA_USUARIO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bruno_minelli_db`.`TSA_USUARIO` ;

CREATE TABLE IF NOT EXISTS `bruno_minelli_db`.`TSA_USUARIO` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `registro_usuario` VARCHAR(32) NULL,
  `pass_usuario` VARCHAR(100) NULL,
  `fecha_registro` DATE NULL,
  `estado_usuario` TINYINT(1) NULL,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bruno_minelli_db`.`TSA_CLIENTE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bruno_minelli_db`.`TSA_CLIENTE` ;

CREATE TABLE IF NOT EXISTS `bruno_minelli_db`.`TSA_CLIENTE` (
  `id_cliente` INT NOT NULL AUTO_INCREMENT,
  `id_usuario` INT NOT NULL,
  `primer_nombre` VARCHAR(100) NULL,
  `segundo_nombre` VARCHAR(100) NULL,
  `primer_apellido` VARCHAR(100) NULL,
  `segundo_apellido` VARCHAR(100) NULL,
  `tel_celular` VARCHAR(9) NULL,
  `tel_fijo` VARCHAR(7) NULL,
  `direccion` VARCHAR(200) NULL,
  `email` VARCHAR(200) NULL,
  `dni` VARCHAR(8) NULL,
  PRIMARY KEY (`id_cliente`),
  INDEX `fk_TSA_CLIENTE_TSA_USUARIO1_idx` (`id_usuario` ASC),
  UNIQUE INDEX `dni_UNIQUE` (`dni` ASC),
  CONSTRAINT `fk_TSA_CLIENTE_TSA_USUARIO1`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `bruno_minelli_db`.`TSA_USUARIO` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bruno_minelli_db`.`TSA_PEDIDO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bruno_minelli_db`.`TSA_PEDIDO` ;

CREATE TABLE IF NOT EXISTS `bruno_minelli_db`.`TSA_PEDIDO` (
  `id_pedido` INT NOT NULL AUTO_INCREMENT,
  `id_cliente` INT NOT NULL,
  `estado_pedido` VARCHAR(45) NULL,
  `precio_acumulado_pedido` DECIMAL(10,2) NULL,
  `puntos_acumulado_pedido` INT NULL,
  `fecha_creacion` DATE NULL,
  `fecha_modificacion` DATE NULL,
  PRIMARY KEY (`id_pedido`),
  INDEX `fk_TSA_PEDIDO_TSA_CLIENTE1_idx` (`id_cliente` ASC),
  CONSTRAINT `fk_TSA_PEDIDO_TSA_CLIENTE1`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `bruno_minelli_db`.`TSA_CLIENTE` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bruno_minelli_db`.`TSA_DETALLE_PEDIDO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bruno_minelli_db`.`TSA_DETALLE_PEDIDO` ;

CREATE TABLE IF NOT EXISTS `bruno_minelli_db`.`TSA_DETALLE_PEDIDO` (
  `id_detalle_pedido` INT NOT NULL AUTO_INCREMENT,
  `id_producto` INT NOT NULL,
  `id_pedido` INT NOT NULL,
  `cantidad` INT NULL,
  `precio_detalle_pedido` DECIMAL(10,2) NULL,
  `puntos_detalle_pedido` INT NULL,
  PRIMARY KEY (`id_detalle_pedido`),
  INDEX `fk_TSA_DETALLE_PEDIDO_TSA_PRODUCTO1_idx` (`id_producto` ASC),
  INDEX `fk_TSA_DETALLE_PEDIDO_TSA_PEDIDO1_idx` (`id_pedido` ASC),
  CONSTRAINT `fk_TSA_DETALLE_PEDIDO_TSA_PRODUCTO1`
    FOREIGN KEY (`id_producto`)
    REFERENCES `bruno_minelli_db`.`TSA_PRODUCTO` (`id_producto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TSA_DETALLE_PEDIDO_TSA_PEDIDO1`
    FOREIGN KEY (`id_pedido`)
    REFERENCES `bruno_minelli_db`.`TSA_PEDIDO` (`id_pedido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bruno_minelli_db`.`TSA_CARRITO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bruno_minelli_db`.`TSA_CARRITO` ;

CREATE TABLE IF NOT EXISTS `bruno_minelli_db`.`TSA_CARRITO` (
  `id_carrito` INT NOT NULL AUTO_INCREMENT,
  `id_cliente` INT NOT NULL,
  `precio_acumulado_carrito` DECIMAL(10,2) NULL,
  `puntos_acumulado_carrito` INT NULL,
  `fecha_creacion` DATE NULL,
  `fecha_modificacion` DATE NULL,
  PRIMARY KEY (`id_carrito`),
  INDEX `fk_TSA_CARRITO_TSA_CLIENTE1_idx` (`id_cliente` ASC),
  CONSTRAINT `fk_TSA_CARRITO_TSA_CLIENTE1`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `bruno_minelli_db`.`TSA_CLIENTE` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bruno_minelli_db`.`TSA_DETALLE_CARRITO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bruno_minelli_db`.`TSA_DETALLE_CARRITO` ;

CREATE TABLE IF NOT EXISTS `bruno_minelli_db`.`TSA_DETALLE_CARRITO` (
  `id_detalle_carrito` INT NOT NULL AUTO_INCREMENT,
  `id_producto` INT NOT NULL,
  `id_carrito` INT NOT NULL,
  `cantidad` INT NULL,
  `precio_detalle_carrito` DECIMAL(10,2) NULL,
  `puntos_detalle_carrito` INT NULL,
  PRIMARY KEY (`id_detalle_carrito`),
  INDEX `fk_TSA_DETALLE_CARRITO_TSA_PRODUCTO1_idx` (`id_producto` ASC),
  INDEX `fk_TSA_DETALLE_CARRITO_TSA_CARRITO1_idx` (`id_carrito` ASC),
  CONSTRAINT `fk_TSA_DETALLE_CARRITO_TSA_PRODUCTO1`
    FOREIGN KEY (`id_producto`)
    REFERENCES `bruno_minelli_db`.`TSA_PRODUCTO` (`id_producto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TSA_DETALLE_CARRITO_TSA_CARRITO1`
    FOREIGN KEY (`id_carrito`)
    REFERENCES `bruno_minelli_db`.`TSA_CARRITO` (`id_carrito`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bruno_minelli_db`.`TSA_OFERTA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bruno_minelli_db`.`TSA_OFERTA` ;

CREATE TABLE IF NOT EXISTS `bruno_minelli_db`.`TSA_OFERTA` (
  `id_oferta` INT NOT NULL AUTO_INCREMENT,
  `id_categoria` INT NOT NULL,
  `fecha_inicio` DATE NULL,
  `fecha_fin` DATE NULL,
  `porcentaje_oferta` DECIMAL(4,2) NULL,
  PRIMARY KEY (`id_oferta`),
  INDEX `fk_TSA_OFERTA_TSA_CATEGORIA1_idx` (`id_categoria` ASC),
  CONSTRAINT `fk_TSA_OFERTA_TSA_CATEGORIA1`
    FOREIGN KEY (`id_categoria`)
    REFERENCES `bruno_minelli_db`.`TSA_CATEGORIA` (`id_categoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bruno_minelli_db`.`TSA_PERFIL`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bruno_minelli_db`.`TSA_PERFIL` ;

CREATE TABLE IF NOT EXISTS `bruno_minelli_db`.`TSA_PERFIL` (
  `id_perfil` INT NOT NULL AUTO_INCREMENT,
  `codigo_perfil` VARCHAR(5) NULL,
  `desc_perfil` VARCHAR(100) NULL,
  PRIMARY KEY (`id_perfil`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bruno_minelli_db`.`TSA_USUARIO_PERFIL`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bruno_minelli_db`.`TSA_USUARIO_PERFIL` ;

CREATE TABLE IF NOT EXISTS `bruno_minelli_db`.`TSA_USUARIO_PERFIL` (
  `id_perfil` INT NOT NULL,
  `id_usuario` INT NOT NULL,
  INDEX `fk_TSA_USUARIO_PERFIL_TSA_PERFIL_idx` (`id_perfil` ASC),
  INDEX `fk_TSA_USUARIO_PERFIL_TSA_USUARIO1_idx` (`id_usuario` ASC),
  PRIMARY KEY (`id_perfil`, `id_usuario`),
  CONSTRAINT `fk_TSA_USUARIO_PERFIL_TSA_PERFIL`
    FOREIGN KEY (`id_perfil`)
    REFERENCES `bruno_minelli_db`.`TSA_PERFIL` (`id_perfil`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TSA_USUARIO_PERFIL_TSA_USUARIO1`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `bruno_minelli_db`.`TSA_USUARIO` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
