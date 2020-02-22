
/* TSA_POLITICA */
INSERT INTO `sunshine_andina_db`.`tsa_politicas` (`desc_politica`, `min_puntos_ind`, `max_puntos_ind`, `min_puntos_grupal`, `max_puntos_grupal`, `porcentaje_descuento`) VALUES ('COMISION_1', '80', '160', '400', '800', '0.05');
INSERT INTO `sunshine_andina_db`.`tsa_politicas` (`desc_politica`, `min_puntos_ind`, `max_puntos_ind`, `min_puntos_grupal`, `max_puntos_grupal`, `porcentaje_descuento`) VALUES ('COMISION_2', '160', '240', '800', '1200', '0.10');
INSERT INTO `sunshine_andina_db`.`tsa_politicas` (`desc_politica`, `min_puntos_ind`, `max_puntos_ind`, `min_puntos_grupal`, `max_puntos_grupal`, `porcentaje_descuento`) VALUES ('COMISION_3', '240', '320', '1200', '1600', '0.15');
INSERT INTO `sunshine_andina_db`.`tsa_politicas` (`desc_politica`, `min_puntos_ind`, `max_puntos_ind`, `min_puntos_grupal`, `max_puntos_grupal`, `porcentaje_descuento`) VALUES ('COMISION_4', '320', '10000000', '1600', '1000000000', '0.20');

/* TSA_PARAMETROS */
INSERT INTO `sunshine_andina_db`.`tsa_parametros` (`desc_parametro`, `valor_parametro`, `estado_parametro`) VALUES ('PRODUCTOS_POR_PAGINA', '4', '1');

/* TSA_PERFIL */

INSERT INTO sunshine_andina_db.TSA_PERFIL(CODIGO_PERFIL, DESC_PERFIL) VALUES ("CLI", "CLIENTE");
INSERT INTO sunshine_andina_db.TSA_PERFIL(CODIGO_PERFIL, DESC_PERFIL) VALUES ("DIS", "DISTRIBUIDOR");
INSERT INTO sunshine_andina_db.TSA_PERFIL(CODIGO_PERFIL, DESC_PERFIL) VALUES ("VEN", "ENCARGADO DE VENTAS");
INSERT INTO sunshine_andina_db.TSA_PERFIL(CODIGO_PERFIL, DESC_PERFIL) VALUES ("INV", "ENCARGADO DE INVENTARIOS");
INSERT INTO sunshine_andina_db.TSA_PERFIL(CODIGO_PERFIL, DESC_PERFIL) VALUES ("ADM", "ENCARGADO DE ADMINISTRACION");

/* TSA_USUARIO */

INSERT INTO sunshine_andina_db.tsa_usuario(registro_usuario,pass_usuario,fecha_registro,estado_usuario) VALUES ('usuario_cli','156028e947febe2281f50363ffa9dfafcc6b0ef72293282c5e81b6809faec21b',NULL,1);
INSERT INTO sunshine_andina_db.tsa_usuario(registro_usuario,pass_usuario,fecha_registro,estado_usuario) VALUES ('usuario_dis','156028e947febe2281f50363ffa9dfafcc6b0ef72293282c5e81b6809faec21b',NULL,1);
INSERT INTO sunshine_andina_db.tsa_usuario(registro_usuario,pass_usuario,fecha_registro,estado_usuario) VALUES ('usuario_ven','156028e947febe2281f50363ffa9dfafcc6b0ef72293282c5e81b6809faec21b',NULL,1);
INSERT INTO sunshine_andina_db.tsa_usuario(registro_usuario,pass_usuario,fecha_registro,estado_usuario) VALUES ('usuario_inv','156028e947febe2281f50363ffa9dfafcc6b0ef72293282c5e81b6809faec21b',NULL,1);
INSERT INTO sunshine_andina_db.tsa_usuario(registro_usuario,pass_usuario,fecha_registro,estado_usuario) VALUES ('usuario_adm','156028e947febe2281f50363ffa9dfafcc6b0ef72293282c5e81b6809faec21b',NULL,1);
INSERT INTO sunshine_andina_db.tsa_usuario(registro_usuario,pass_usuario,fecha_registro,estado_usuario) VALUES ('usuario_adm2','80128c3bcdcc153abd3d10487c028b79cbcbb210667f58f1702c428d61056360','2017-11-19',1);
INSERT INTO sunshine_andina_db.tsa_usuario(registro_usuario,pass_usuario,fecha_registro,estado_usuario) VALUES ('jose.diaz','156028e947febe2281f50363ffa9dfafcc6b0ef72293282c5e81b6809faec21b',NULL,1);
INSERT INTO sunshine_andina_db.tsa_usuario(registro_usuario,pass_usuario,fecha_registro,estado_usuario) VALUES ('maria.torres','156028e947febe2281f50363ffa9dfafcc6b0ef72293282c5e81b6809faec21b',NULL,1);
INSERT INTO sunshine_andina_db.tsa_usuario(registro_usuario,pass_usuario,fecha_registro,estado_usuario) VALUES ('melissa.loza','156028e947febe2281f50363ffa9dfafcc6b0ef72293282c5e81b6809faec21b',NULL,1);
INSERT INTO sunshine_andina_db.tsa_usuario(registro_usuario,pass_usuario,fecha_registro,estado_usuario) VALUES ('diego.torres','156028e947febe2281f50363ffa9dfafcc6b0ef72293282c5e81b6809faec21b',NULL,1);
INSERT INTO sunshine_andina_db.tsa_usuario(registro_usuario,pass_usuario,fecha_registro,estado_usuario) VALUES ('juan.torres','156028e947febe2281f50363ffa9dfafcc6b0ef72293282c5e81b6809faec21b',NULL,1);
INSERT INTO sunshine_andina_db.tsa_usuario(registro_usuario,pass_usuario,fecha_registro,estado_usuario) VALUES ('eduardo.loza','156028e947febe2281f50363ffa9dfafcc6b0ef72293282c5e81b6809faec21b',NULL,1);
INSERT INTO sunshine_andina_db.tsa_usuario(registro_usuario,pass_usuario,fecha_registro,estado_usuario) VALUES ('miguel.loza','156028e947febe2281f50363ffa9dfafcc6b0ef72293282c5e81b6809faec21b',NULL,1);

/* TSA_USUARIO_PEFIL*/

INSERT INTO sunshine_andina_db.tsa_usuario_perfil values (1,1);
INSERT INTO sunshine_andina_db.tsa_usuario_perfil values (2,2);
INSERT INTO sunshine_andina_db.tsa_usuario_perfil values (3,3);
INSERT INTO sunshine_andina_db.tsa_usuario_perfil values (4,4);
INSERT INTO sunshine_andina_db.tsa_usuario_perfil values (5,5);
INSERT INTO sunshine_andina_db.tsa_usuario_perfil(id_perfil,id_usuario) VALUES (2,7);
INSERT INTO sunshine_andina_db.tsa_usuario_perfil(id_perfil,id_usuario) VALUES (2,8);
INSERT INTO sunshine_andina_db.tsa_usuario_perfil(id_perfil,id_usuario) VALUES (2,9);
INSERT INTO sunshine_andina_db.tsa_usuario_perfil(id_perfil,id_usuario) VALUES (2,10);
INSERT INTO sunshine_andina_db.tsa_usuario_perfil(id_perfil,id_usuario) VALUES (2,11);
INSERT INTO sunshine_andina_db.tsa_usuario_perfil(id_perfil,id_usuario) VALUES (2,12);
INSERT INTO sunshine_andina_db.tsa_usuario_perfil(id_perfil,id_usuario) VALUES (2,13);

/* TSA_CLIENTE */
INSERT INTO sunshine_andina_db.tsa_cliente(id_usuario,primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,tel_celular,tel_fijo,direccion,email,dni) VALUES (1,'JEFFERSON','AGUSTIN','FARFAN','GUADALUPE',999988880,4421210,'AV. SEPARADORA INDUSTRIAL 1258 ATE','JEFFERSON.FARFAN@GMAIL.COM',78794547);
INSERT INTO sunshine_andina_db.tsa_cliente(id_usuario,primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,tel_celular,tel_fijo,direccion,email,dni) VALUES (2,'JOSE','PAOLO','GUERRERO','GONZALES',999988889,4421210,'AV. CONQUISTADORES 208 SAN ISIDRO','PAOLO.GUERRERO@GMAIL.COM',78794546);
INSERT INTO sunshine_andina_db.tsa_cliente(id_usuario,primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,tel_celular,tel_fijo,direccion,email,dni) VALUES (7,'JOSE',NULL,'DIAZ',NULL,NULL,NULL,NULL,NULL,'11111112');
INSERT INTO sunshine_andina_db.tsa_cliente(id_usuario,primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,tel_celular,tel_fijo,direccion,email,dni) VALUES (8,'MARIA',NULL,'TORRES',NULL,NULL,NULL,NULL,NULL,'11111113');
INSERT INTO sunshine_andina_db.tsa_cliente(id_usuario,primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,tel_celular,tel_fijo,direccion,email,dni) VALUES (9,'MELISSA',NULL,'LOZA',NULL,NULL,NULL,NULL,NULL,'11111114');
INSERT INTO sunshine_andina_db.tsa_cliente(id_usuario,primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,tel_celular,tel_fijo,direccion,email,dni) VALUES (10,'DIEGO',NULL,'TORRES',NULL,NULL,NULL,NULL,NULL,'11111115');
INSERT INTO sunshine_andina_db.tsa_cliente(id_usuario,primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,tel_celular,tel_fijo,direccion,email,dni) VALUES (11,'JUAN',NULL,'TORRES',NULL,NULL,NULL,NULL,NULL,'11111116');
INSERT INTO sunshine_andina_db.tsa_cliente(id_usuario,primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,tel_celular,tel_fijo,direccion,email,dni) VALUES (12,'EDUARDO',NULL,'LOZA',NULL,NULL,NULL,NULL,NULL,'11111117');
INSERT INTO sunshine_andina_db.tsa_cliente(id_usuario,primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,tel_celular,tel_fijo,direccion,email,dni) VALUES (13,'MIGUEL',NULL,'LOZA',NULL,NULL,NULL,NULL,NULL,'11111118');


/* TSA_EMPLEADO */

INSERT INTO sunshine_andina_db.tsa_empleado (id_usuario, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, tel_celular, tel_fijo, email, ruc)
values (3, "SIMON", null, "BOLIVAR", "BOLIVAR", "987654321", "4879653", "SIMON.BOLIVAR@GMAIL.COM", 10787946431);

INSERT INTO sunshine_andina_db.tsa_empleado (id_usuario, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, tel_celular, tel_fijo, email, ruc)
values (4, "JUAN", null, "BOLIVAR", "COLON", "987654321", "4879654", "JUAN.BOLIVAR@GMAIL.COM", 10787946432);

INSERT INTO sunshine_andina_db.tsa_empleado (id_usuario, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, tel_celular, tel_fijo, email, ruc)
values (5, "JOSE", null, "PIZARRO", "BOLIVAR", "987654321", "4879655", "JOSE.BOLIVAR@GMAIL.COM", 10787946433);

/*TSA_PEDIDO */
INSERT INTO `sunshine_andina_db`.`tsa_pedido` (`id_cliente`, `estado_pedido`, `precio_acumulado_pedido`, `puntos_acumulado_pedido`) VALUES ('2', 'PAGADO', '10', '30');
INSERT INTO `sunshine_andina_db`.`tsa_pedido` (`id_cliente`, `estado_pedido`, `precio_acumulado_pedido`, `puntos_acumulado_pedido`) VALUES ('1', 'CANCELADO', '15', '20');

/* TSA_TIPO_LIDER */
INSERT INTO `sunshine_andina_db`.`tsa_tipo_lider` (`desc_tipo_lider`, `lideres_min`, `lideres_max`, `porcentaje`) VALUES ('NO_LIDER', '0', '0', '0');
INSERT INTO `sunshine_andina_db`.`tsa_tipo_lider` (`desc_tipo_lider`, `lideres_min`, `lideres_max`, `porcentaje`) VALUES ('NINGUNO', '0', '0', '0');
INSERT INTO `sunshine_andina_db`.`tsa_tipo_lider` (`desc_tipo_lider`, `lideres_min`, `lideres_max`, `porcentaje`) VALUES ('BRONCE', '1', '2', '0.05');
INSERT INTO `sunshine_andina_db`.`tsa_tipo_lider` (`desc_tipo_lider`, `lideres_min`, `lideres_max`, `porcentaje`) VALUES ('COBRE', '3', '4', '0.06');
INSERT INTO `sunshine_andina_db`.`tsa_tipo_lider` (`desc_tipo_lider`, `lideres_min`, `lideres_max`, `porcentaje`) VALUES ('PLATA', '5', '6', '0.07');
INSERT INTO `sunshine_andina_db`.`tsa_tipo_lider` (`desc_tipo_lider`, `lideres_min`, `lideres_max`, `porcentaje`) VALUES ('ESMERALDA', '7', '8', '0.08');
INSERT INTO `sunshine_andina_db`.`tsa_tipo_lider` (`desc_tipo_lider`, `lideres_min`, `lideres_max`, `porcentaje`) VALUES ('ORO', '9', '10', '0.09');
INSERT INTO `sunshine_andina_db`.`tsa_tipo_lider` (`desc_tipo_lider`, `lideres_min`, `lideres_max`, `porcentaje`) VALUES ('RUBÍ', '11', '12', '0.10');
INSERT INTO `sunshine_andina_db`.`tsa_tipo_lider` (`desc_tipo_lider`, `lideres_min`, `lideres_max`, `porcentaje`) VALUES ('ZAFIRO', '13', '14', '0.11');
INSERT INTO `sunshine_andina_db`.`tsa_tipo_lider` (`desc_tipo_lider`, `lideres_min`, `lideres_max`, `porcentaje`) VALUES ('PLATINO', '15', '16', '0.12');
INSERT INTO `sunshine_andina_db`.`tsa_tipo_lider` (`desc_tipo_lider`, `lideres_min`, `lideres_max`, `porcentaje`) VALUES ('DIAMANTE', '17', '30', '0.13');

/* TSA_DISTRIBUIDOR */
INSERT INTO sunshine_andina_db.tsa_distribuidor(id_cliente,id_tipo_lider,id_distribuidor_padre,codigo_distribuidor,estado_distribuidor) VALUES ('3',3,null,"2-000001",1);
INSERT INTO sunshine_andina_db.tsa_distribuidor(id_cliente,id_tipo_lider,id_distribuidor_padre,codigo_distribuidor,estado_distribuidor) VALUES ('4',2,1,"2-000002",1);
INSERT INTO sunshine_andina_db.tsa_distribuidor(id_cliente,id_tipo_lider,id_distribuidor_padre,codigo_distribuidor,estado_distribuidor) VALUES ('5',2,1,"2-000003",1);
INSERT INTO sunshine_andina_db.tsa_distribuidor(id_cliente,id_tipo_lider,id_distribuidor_padre,codigo_distribuidor,estado_distribuidor) VALUES ('6',1,2,"2-000004",1);
INSERT INTO sunshine_andina_db.tsa_distribuidor(id_cliente,id_tipo_lider,id_distribuidor_padre,codigo_distribuidor,estado_distribuidor) VALUES ('7',1,2,"2-000005",1);
INSERT INTO sunshine_andina_db.tsa_distribuidor(id_cliente,id_tipo_lider,id_distribuidor_padre,codigo_distribuidor,estado_distribuidor) VALUES ('8',1,3,"2-000006",1);
INSERT INTO sunshine_andina_db.tsa_distribuidor(id_cliente,id_tipo_lider,id_distribuidor_padre,codigo_distribuidor,estado_distribuidor) VALUES ('9',1,3,"2-000007",1);

/* TSA_HISTORICO_DISTRIBUIDOR*/
INSERT INTO `sunshine_andina_db`.`tsa_historico_distribuidor` (`id_distribuidor`, `puntos_individual`, `puntos_grupal`, `ventas_soles_ind`, `ventas_soles_grupal`, `mes_historico`, `anio_historico`) VALUES ('1', '1000', '2640', '5000', '13200', '11', '2017');
INSERT INTO `sunshine_andina_db`.`tsa_historico_distribuidor` (`id_distribuidor`, `puntos_individual`, `puntos_grupal`, `ventas_soles_ind`, `ventas_soles_grupal`, `mes_historico`, `anio_historico`) VALUES ('2', '1000', '400', '5000', '2000', '11', '2017');
INSERT INTO `sunshine_andina_db`.`tsa_historico_distribuidor` (`id_distribuidor`, `puntos_individual`, `puntos_grupal`, `ventas_soles_ind`, `ventas_soles_grupal`, `mes_historico`, `anio_historico`) VALUES ('3', '1000', '240', '5000', '1200', '11', '2017');
INSERT INTO `sunshine_andina_db`.`tsa_historico_distribuidor` (`id_distribuidor`, `puntos_individual`, `puntos_grupal`, `ventas_soles_ind`, `ventas_soles_grupal`, `mes_historico`, `anio_historico`) VALUES ('4', '240', '0', '1200', '0', '11', '2017');
INSERT INTO `sunshine_andina_db`.`tsa_historico_distribuidor` (`id_distribuidor`, `puntos_individual`, `puntos_grupal`, `ventas_soles_ind`, `ventas_soles_grupal`, `mes_historico`, `anio_historico`) VALUES ('5', '160', '0', '800', '0', '11', '2017');
INSERT INTO `sunshine_andina_db`.`tsa_historico_distribuidor` (`id_distribuidor`, `puntos_individual`, `puntos_grupal`, `ventas_soles_ind`, `ventas_soles_grupal`, `mes_historico`, `anio_historico`) VALUES ('6', '160', '0', '800', '0', '11', '2017');
INSERT INTO `sunshine_andina_db`.`tsa_historico_distribuidor` (`id_distribuidor`, `puntos_individual`, `puntos_grupal`, `ventas_soles_ind`, `ventas_soles_grupal`, `mes_historico`, `anio_historico`) VALUES ('7', '80', '0', '400', '0', '11', '2017');

/* TSA_COMISION */
INSERT INTO `sunshine_andina_db`.`tsa_comision` (`id_distribuidor`, `monto_comision`, `mes_comision`, `anio_comision`) VALUES ('1', '1660', '11', '2017');
INSERT INTO `sunshine_andina_db`.`tsa_comision` (`id_distribuidor`, `monto_comision`, `mes_comision`, `anio_comision`) VALUES ('2', '1050', '11', '2017');
INSERT INTO `sunshine_andina_db`.`tsa_comision` (`id_distribuidor`, `monto_comision`, `mes_comision`, `anio_comision`) VALUES ('3', '930', '11', '2017');


/* TSA_CATEGORIA */
INSERT INTO sunshine_andina_db.tsa_categoria(id_categoria,nombre_categoria,desc_categoria,estado_categoria) VALUES (1,'SISTEMAS DEL CUERPO','ESPECIAL PARA LOS SISTEMAS DEL CUERPO',1);
INSERT INTO sunshine_andina_db.tsa_categoria(id_categoria,nombre_categoria,desc_categoria,estado_categoria) VALUES (2,'TEMAS DE SALUD','PARA EL CUIDADO DE LA SALUD',1);
INSERT INTO sunshine_andina_db.tsa_categoria(id_categoria,nombre_categoria,desc_categoria,estado_categoria) VALUES (3,'ACEITES ESENCIALES Y VEGETALES','TODO TIPO DE ACEITES',1);
INSERT INTO sunshine_andina_db.tsa_categoria(id_categoria,nombre_categoria,desc_categoria,estado_categoria) VALUES (4,'ANTIOXIDANTES','PARA PREVENIR ENFERMEDADES',1);
INSERT INTO sunshine_andina_db.tsa_categoria(id_categoria,nombre_categoria,desc_categoria,estado_categoria) VALUES (5,'APOYO ESTADO ANIMICO','PARA MEJORAR LA SALUD',1);
INSERT INTO sunshine_andina_db.tsa_categoria(id_categoria,nombre_categoria,desc_categoria,estado_categoria) VALUES (6,'CIRCULATORIO','PARA MEJORAR EL SISTEMA CIRCULATORIO',1);
INSERT INTO sunshine_andina_db.tsa_categoria(id_categoria,nombre_categoria,desc_categoria,estado_categoria) VALUES (7,'CONTROL DE PESO','ESPECIAL PARA MANTENER EL PESO ADECUADO',1);
INSERT INTO sunshine_andina_db.tsa_categoria(id_categoria,nombre_categoria,desc_categoria,estado_categoria) VALUES (8,'COLESTEROL','PARA CONTROLAR LAS GRASAS',1);
INSERT INTO sunshine_andina_db.tsa_categoria(id_categoria,nombre_categoria,desc_categoria,estado_categoria) VALUES (9,'COSMETICA NATURAL','PARA LA ESTETICA PERSONAL',1);
INSERT INTO sunshine_andina_db.tsa_categoria(id_categoria,nombre_categoria,desc_categoria,estado_categoria) VALUES (10,'DEPORTE','ESPECIAL PARA ATLETAS',1);
INSERT INTO sunshine_andina_db.tsa_categoria(id_categoria,nombre_categoria,desc_categoria,estado_categoria) VALUES (11,'DESINTOXICACION','PARA LIMPIAR EL CUERPO',1);
INSERT INTO sunshine_andina_db.tsa_categoria(id_categoria,nombre_categoria,desc_categoria,estado_categoria) VALUES (12,'DIGESTION','PARA MEJORAR EL SISTEMA DIGESTIVO',1);
INSERT INTO sunshine_andina_db.tsa_categoria(id_categoria,nombre_categoria,desc_categoria,estado_categoria) VALUES (13,'ENERGIA Y CONDICION FISICA','PARA OBTENER UN RENDIMIENTO OPTIMO',1);
INSERT INTO sunshine_andina_db.tsa_categoria(id_categoria,nombre_categoria,desc_categoria,estado_categoria) VALUES (14,'HEPATICO','PARA EL CUIDADO DEL HIGADO',1);
INSERT INTO sunshine_andina_db.tsa_categoria(id_categoria,nombre_categoria,desc_categoria,estado_categoria) VALUES (15,'HUESOS','PARA MEJORAR EL ESTADO DE LAS ARTICULACIONES',1);
INSERT INTO sunshine_andina_db.tsa_categoria(id_categoria,nombre_categoria,desc_categoria,estado_categoria) VALUES (16,'INMUNOLOGICO','PARA AUMENTAR LAS DEFENSAS',1);
INSERT INTO sunshine_andina_db.tsa_categoria(id_categoria,nombre_categoria,desc_categoria,estado_categoria) VALUES (17,'NERVIOSO','ESPECIAL PARA EL SISTEMA NERVIOSO',1);
INSERT INTO sunshine_andina_db.tsa_categoria(id_categoria,nombre_categoria,desc_categoria,estado_categoria) VALUES (18,'RESPIRATORIO','ESPECIAL PARA EL SISTEMA RESPIRATORIO',1);
INSERT INTO sunshine_andina_db.tsa_categoria(id_categoria,nombre_categoria,desc_categoria,estado_categoria) VALUES (19,'SALUD DEL CEREBRO Y MEMORIA','PARA MANTENER LA CAPACIDAD COGNITIVA',1);
INSERT INTO sunshine_andina_db.tsa_categoria(id_categoria,nombre_categoria,desc_categoria,estado_categoria) VALUES (20,'SUPLEMENTOS ALIMENTICIOS','PARA REFORZAR LA ALIMENTACION',1);
INSERT INTO sunshine_andina_db.tsa_categoria(id_categoria,nombre_categoria,desc_categoria,estado_categoria) VALUES (21,'URINARIO','PARA MEJORAR EL SISTEMA URINARIO',1);


