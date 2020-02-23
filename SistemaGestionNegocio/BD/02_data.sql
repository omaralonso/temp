
/* TSA_POLITICA */
INSERT INTO bruno_minelli_db.TSA_POLITICAS (`desc_politica`, `min_puntos_ind`, `max_puntos_ind`, `min_puntos_grupal`, `max_puntos_grupal`, `porcentaje_descuento`) VALUES ('COMISION_1', '80', '160', '400', '800', '0.05');
INSERT INTO bruno_minelli_db.TSA_POLITICAS (`desc_politica`, `min_puntos_ind`, `max_puntos_ind`, `min_puntos_grupal`, `max_puntos_grupal`, `porcentaje_descuento`) VALUES ('COMISION_2', '160', '240', '800', '1200', '0.10');
INSERT INTO bruno_minelli_db.TSA_POLITICAS (`desc_politica`, `min_puntos_ind`, `max_puntos_ind`, `min_puntos_grupal`, `max_puntos_grupal`, `porcentaje_descuento`) VALUES ('COMISION_3', '240', '320', '1200', '1600', '0.15');
INSERT INTO bruno_minelli_db.TSA_POLITICAS (`desc_politica`, `min_puntos_ind`, `max_puntos_ind`, `min_puntos_grupal`, `max_puntos_grupal`, `porcentaje_descuento`) VALUES ('COMISION_4', '320', '10000000', '1600', '1000000000', '0.20');

/* TSA_PARAMETROS */
INSERT INTO bruno_minelli_db.TSA_PARAMETROS (`desc_parametro`, `valor_parametro`, `estado_parametro`) VALUES ('PRODUCTOS_POR_PAGINA', '4', '1');

/* TSA_PERFIL */

INSERT INTO bruno_minelli_db.TSA_PERFIL(CODIGO_PERFIL, DESC_PERFIL) VALUES ("CLI", "CLIENTE");
INSERT INTO bruno_minelli_db.TSA_PERFIL(CODIGO_PERFIL, DESC_PERFIL) VALUES ("DIS", "DISTRIBUIDOR");
INSERT INTO bruno_minelli_db.TSA_PERFIL(CODIGO_PERFIL, DESC_PERFIL) VALUES ("VEN", "ENCARGADO DE VENTAS");
INSERT INTO bruno_minelli_db.TSA_PERFIL(CODIGO_PERFIL, DESC_PERFIL) VALUES ("INV", "ENCARGADO DE INVENTARIOS");
INSERT INTO bruno_minelli_db.TSA_PERFIL(CODIGO_PERFIL, DESC_PERFIL) VALUES ("ADM", "ENCARGADO DE ADMINISTRACION");

/* TSA_USUARIO */

INSERT INTO bruno_minelli_db.TSA_USUARIO(registro_usuario,pass_usuario,fecha_registro,estado_usuario) VALUES ('usuario_cli','Peru123.',NULL,1);
INSERT INTO bruno_minelli_db.TSA_USUARIO(registro_usuario,pass_usuario,fecha_registro,estado_usuario) VALUES ('usuario_dis','Peru123.',NULL,1);
INSERT INTO bruno_minelli_db.TSA_USUARIO(registro_usuario,pass_usuario,fecha_registro,estado_usuario) VALUES ('usuario_ven','Peru123.',NULL,1);
INSERT INTO bruno_minelli_db.TSA_USUARIO(registro_usuario,pass_usuario,fecha_registro,estado_usuario) VALUES ('usuario_inv','Peru123.',NULL,1);
INSERT INTO bruno_minelli_db.TSA_USUARIO(registro_usuario,pass_usuario,fecha_registro,estado_usuario) VALUES ('usuario_adm','Peru123.',NULL,1);
INSERT INTO bruno_minelli_db.TSA_USUARIO(registro_usuario,pass_usuario,fecha_registro,estado_usuario) VALUES ('usuario_adm2','Peru123.','2017-11-19',1);
INSERT INTO bruno_minelli_db.TSA_USUARIO(registro_usuario,pass_usuario,fecha_registro,estado_usuario) VALUES ('jose.diaz','Peru123.',NULL,1);
INSERT INTO bruno_minelli_db.TSA_USUARIO(registro_usuario,pass_usuario,fecha_registro,estado_usuario) VALUES ('maria.torres','Peru123.',NULL,1);
INSERT INTO bruno_minelli_db.TSA_USUARIO(registro_usuario,pass_usuario,fecha_registro,estado_usuario) VALUES ('melissa.loza','Peru123.',NULL,1);
INSERT INTO bruno_minelli_db.TSA_USUARIO(registro_usuario,pass_usuario,fecha_registro,estado_usuario) VALUES ('diego.torres','Peru123.',NULL,1);
INSERT INTO bruno_minelli_db.TSA_USUARIO(registro_usuario,pass_usuario,fecha_registro,estado_usuario) VALUES ('juan.torres','Peru123.',NULL,1);
INSERT INTO bruno_minelli_db.TSA_USUARIO(registro_usuario,pass_usuario,fecha_registro,estado_usuario) VALUES ('eduardo.loza','Peru123.',NULL,1);
INSERT INTO bruno_minelli_db.TSA_USUARIO(registro_usuario,pass_usuario,fecha_registro,estado_usuario) VALUES ('miguel.loza','Peru123.',NULL,1);

/* TSA_USUARIO_PEFIL*/

INSERT INTO bruno_minelli_db.TSA_USUARIO_PERFIL values (1,1);
INSERT INTO bruno_minelli_db.TSA_USUARIO_PERFIL values (2,2);
INSERT INTO bruno_minelli_db.TSA_USUARIO_PERFIL values (3,3);
INSERT INTO bruno_minelli_db.TSA_USUARIO_PERFIL values (4,4);
INSERT INTO bruno_minelli_db.TSA_USUARIO_PERFIL values (5,5);
INSERT INTO bruno_minelli_db.TSA_USUARIO_PERFIL(id_perfil,id_usuario) VALUES (2,7);
INSERT INTO bruno_minelli_db.TSA_USUARIO_PERFIL(id_perfil,id_usuario) VALUES (2,8);
INSERT INTO bruno_minelli_db.TSA_USUARIO_PERFIL(id_perfil,id_usuario) VALUES (2,9);
INSERT INTO bruno_minelli_db.TSA_USUARIO_PERFIL(id_perfil,id_usuario) VALUES (2,10);
INSERT INTO bruno_minelli_db.TSA_USUARIO_PERFIL(id_perfil,id_usuario) VALUES (2,11);
INSERT INTO bruno_minelli_db.TSA_USUARIO_PERFIL(id_perfil,id_usuario) VALUES (2,12);
INSERT INTO bruno_minelli_db.TSA_USUARIO_PERFIL(id_perfil,id_usuario) VALUES (2,13);

/* TSA_CLIENTE */
INSERT INTO bruno_minelli_db.TSA_CLIENTE(id_usuario,primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,tel_celular,tel_fijo,direccion,email,dni) VALUES (1,'JEFFERSON','AGUSTIN','FARFAN','GUADALUPE',999988880,4421210,'AV. SEPARADORA INDUSTRIAL 1258 ATE','JEFFERSON.FARFAN@GMAIL.COM',78794547);
INSERT INTO bruno_minelli_db.TSA_CLIENTE(id_usuario,primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,tel_celular,tel_fijo,direccion,email,dni) VALUES (2,'JOSE','PAOLO','GUERRERO','GONZALES',999988889,4421210,'AV. CONQUISTADORES 208 SAN ISIDRO','PAOLO.GUERRERO@GMAIL.COM',78794546);
INSERT INTO bruno_minelli_db.TSA_CLIENTE(id_usuario,primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,tel_celular,tel_fijo,direccion,email,dni) VALUES (7,'JOSE',NULL,'DIAZ',NULL,NULL,NULL,NULL,NULL,'11111112');
INSERT INTO bruno_minelli_db.TSA_CLIENTE(id_usuario,primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,tel_celular,tel_fijo,direccion,email,dni) VALUES (8,'MARIA',NULL,'TORRES',NULL,NULL,NULL,NULL,NULL,'11111113');
INSERT INTO bruno_minelli_db.TSA_CLIENTE(id_usuario,primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,tel_celular,tel_fijo,direccion,email,dni) VALUES (9,'MELISSA',NULL,'LOZA',NULL,NULL,NULL,NULL,NULL,'11111114');
INSERT INTO bruno_minelli_db.TSA_CLIENTE(id_usuario,primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,tel_celular,tel_fijo,direccion,email,dni) VALUES (10,'DIEGO',NULL,'TORRES',NULL,NULL,NULL,NULL,NULL,'11111115');
INSERT INTO bruno_minelli_db.TSA_CLIENTE(id_usuario,primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,tel_celular,tel_fijo,direccion,email,dni) VALUES (11,'JUAN',NULL,'TORRES',NULL,NULL,NULL,NULL,NULL,'11111116');
INSERT INTO bruno_minelli_db.TSA_CLIENTE(id_usuario,primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,tel_celular,tel_fijo,direccion,email,dni) VALUES (12,'EDUARDO',NULL,'LOZA',NULL,NULL,NULL,NULL,NULL,'11111117');
INSERT INTO bruno_minelli_db.TSA_CLIENTE(id_usuario,primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,tel_celular,tel_fijo,direccion,email,dni) VALUES (13,'MIGUEL',NULL,'LOZA',NULL,NULL,NULL,NULL,NULL,'11111118');


/* TSA_EMPLEADO */

INSERT INTO bruno_minelli_db.TSA_EMPLEADO (id_usuario, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, tel_celular, tel_fijo, email, ruc)
values (3, "SIMON", null, "BOLIVAR", "BOLIVAR", "987654321", "4879653", "SIMON.BOLIVAR@GMAIL.COM", 10787946431);
INSERT INTO bruno_minelli_db.TSA_EMPLEADO (id_usuario, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, tel_celular, tel_fijo, email, ruc)
values (4, "JUAN", null, "BOLIVAR", "COLON", "987654321", "4879654", "JUAN.BOLIVAR@GMAIL.COM", 10787946432);
INSERT INTO bruno_minelli_db.TSA_EMPLEADO (id_usuario, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, tel_celular, tel_fijo, email, ruc)
values (5, "JOSE", null, "PIZARRO", "BOLIVAR", "987654321", "4879655", "JOSE.BOLIVAR@GMAIL.COM", 10787946433);

/*TSA_PEDIDO */
INSERT INTO bruno_minelli_db.TSA_PEDIDO (`id_cliente`, `estado_pedido`, `precio_acumulado_pedido`, `puntos_acumulado_pedido`) VALUES ('2', 'PAGADO', '10', '30');
INSERT INTO bruno_minelli_db.TSA_PEDIDO (`id_cliente`, `estado_pedido`, `precio_acumulado_pedido`, `puntos_acumulado_pedido`) VALUES ('1', 'CANCELADO', '15', '20');

/* TSA_TIPO_LIDER */
INSERT INTO bruno_minelli_db.TSA_TIPO_LIDER (`desc_tipo_lider`, `lideres_min`, `lideres_max`, `porcentaje`) VALUES ('NO_LIDER', '0', '0', '0');
INSERT INTO bruno_minelli_db.TSA_TIPO_LIDER (`desc_tipo_lider`, `lideres_min`, `lideres_max`, `porcentaje`) VALUES ('NINGUNO', '0', '0', '0');
INSERT INTO bruno_minelli_db.TSA_TIPO_LIDER (`desc_tipo_lider`, `lideres_min`, `lideres_max`, `porcentaje`) VALUES ('BRONCE', '1', '2', '0.05');
INSERT INTO bruno_minelli_db.TSA_TIPO_LIDER (`desc_tipo_lider`, `lideres_min`, `lideres_max`, `porcentaje`) VALUES ('COBRE', '3', '4', '0.06');
INSERT INTO bruno_minelli_db.TSA_TIPO_LIDER (`desc_tipo_lider`, `lideres_min`, `lideres_max`, `porcentaje`) VALUES ('PLATA', '5', '6', '0.07');
INSERT INTO bruno_minelli_db.TSA_TIPO_LIDER (`desc_tipo_lider`, `lideres_min`, `lideres_max`, `porcentaje`) VALUES ('ESMERALDA', '7', '8', '0.08');
INSERT INTO bruno_minelli_db.TSA_TIPO_LIDER (`desc_tipo_lider`, `lideres_min`, `lideres_max`, `porcentaje`) VALUES ('ORO', '9', '10', '0.09');
INSERT INTO bruno_minelli_db.TSA_TIPO_LIDER (`desc_tipo_lider`, `lideres_min`, `lideres_max`, `porcentaje`) VALUES ('RUBÍ', '11', '12', '0.10');
INSERT INTO bruno_minelli_db.TSA_TIPO_LIDER (`desc_tipo_lider`, `lideres_min`, `lideres_max`, `porcentaje`) VALUES ('ZAFIRO', '13', '14', '0.11');
INSERT INTO bruno_minelli_db.TSA_TIPO_LIDER (`desc_tipo_lider`, `lideres_min`, `lideres_max`, `porcentaje`) VALUES ('PLATINO', '15', '16', '0.12');
INSERT INTO bruno_minelli_db.TSA_TIPO_LIDER (`desc_tipo_lider`, `lideres_min`, `lideres_max`, `porcentaje`) VALUES ('DIAMANTE', '17', '30', '0.13');

/* TSA_DISTRIBUIDOR */
INSERT INTO bruno_minelli_db.TSA_DISTRIBUIDOR(id_cliente,id_tipo_lider,id_distribuidor_padre,codigo_distribuidor,estado_distribuidor) VALUES ('3',3,null,"2-000001",1);
INSERT INTO bruno_minelli_db.TSA_DISTRIBUIDOR(id_cliente,id_tipo_lider,id_distribuidor_padre,codigo_distribuidor,estado_distribuidor) VALUES ('4',2,1,"2-000002",1);
INSERT INTO bruno_minelli_db.TSA_DISTRIBUIDOR(id_cliente,id_tipo_lider,id_distribuidor_padre,codigo_distribuidor,estado_distribuidor) VALUES ('5',2,1,"2-000003",1);
INSERT INTO bruno_minelli_db.TSA_DISTRIBUIDOR(id_cliente,id_tipo_lider,id_distribuidor_padre,codigo_distribuidor,estado_distribuidor) VALUES ('6',1,2,"2-000004",1);
INSERT INTO bruno_minelli_db.TSA_DISTRIBUIDOR(id_cliente,id_tipo_lider,id_distribuidor_padre,codigo_distribuidor,estado_distribuidor) VALUES ('7',1,2,"2-000005",1);
INSERT INTO bruno_minelli_db.TSA_DISTRIBUIDOR(id_cliente,id_tipo_lider,id_distribuidor_padre,codigo_distribuidor,estado_distribuidor) VALUES ('8',1,3,"2-000006",1);
INSERT INTO bruno_minelli_db.TSA_DISTRIBUIDOR(id_cliente,id_tipo_lider,id_distribuidor_padre,codigo_distribuidor,estado_distribuidor) VALUES ('9',1,3,"2-000007",1);

/* TSA_HISTORICO_DISTRIBUIDOR*/
INSERT INTO bruno_minelli_db.TSA_HISTORICO_DISTRIBUIDOR (`id_distribuidor`, `puntos_individual`, `puntos_grupal`, `ventas_soles_ind`, `ventas_soles_grupal`, `mes_historico`, `anio_historico`) VALUES ('1', '1000', '2640', '5000', '13200', '11', '2017');
INSERT INTO bruno_minelli_db.TSA_HISTORICO_DISTRIBUIDOR (`id_distribuidor`, `puntos_individual`, `puntos_grupal`, `ventas_soles_ind`, `ventas_soles_grupal`, `mes_historico`, `anio_historico`) VALUES ('2', '1000', '400', '5000', '2000', '11', '2017');
INSERT INTO bruno_minelli_db.TSA_HISTORICO_DISTRIBUIDOR (`id_distribuidor`, `puntos_individual`, `puntos_grupal`, `ventas_soles_ind`, `ventas_soles_grupal`, `mes_historico`, `anio_historico`) VALUES ('3', '1000', '240', '5000', '1200', '11', '2017');
INSERT INTO bruno_minelli_db.TSA_HISTORICO_DISTRIBUIDOR (`id_distribuidor`, `puntos_individual`, `puntos_grupal`, `ventas_soles_ind`, `ventas_soles_grupal`, `mes_historico`, `anio_historico`) VALUES ('4', '240', '0', '1200', '0', '11', '2017');
INSERT INTO bruno_minelli_db.TSA_HISTORICO_DISTRIBUIDOR (`id_distribuidor`, `puntos_individual`, `puntos_grupal`, `ventas_soles_ind`, `ventas_soles_grupal`, `mes_historico`, `anio_historico`) VALUES ('5', '160', '0', '800', '0', '11', '2017');
INSERT INTO bruno_minelli_db.TSA_HISTORICO_DISTRIBUIDOR (`id_distribuidor`, `puntos_individual`, `puntos_grupal`, `ventas_soles_ind`, `ventas_soles_grupal`, `mes_historico`, `anio_historico`) VALUES ('6', '160', '0', '800', '0', '11', '2017');
INSERT INTO bruno_minelli_db.TSA_HISTORICO_DISTRIBUIDOR (`id_distribuidor`, `puntos_individual`, `puntos_grupal`, `ventas_soles_ind`, `ventas_soles_grupal`, `mes_historico`, `anio_historico`) VALUES ('7', '80', '0', '400', '0', '11', '2017');

/* TSA_COMISION */
INSERT INTO bruno_minelli_db.TSA_COMISION (`id_distribuidor`, `monto_comision`, `mes_comision`, `anio_comision`) VALUES ('1', '1660', '11', '2017');
INSERT INTO bruno_minelli_db.TSA_COMISION (`id_distribuidor`, `monto_comision`, `mes_comision`, `anio_comision`) VALUES ('2', '1050', '11', '2017');
INSERT INTO bruno_minelli_db.TSA_COMISION (`id_distribuidor`, `monto_comision`, `mes_comision`, `anio_comision`) VALUES ('3', '930', '11', '2017');


/* TSA_CATEGORIA */
INSERT INTO bruno_minelli_db.TSA_CATEGORIA(id_categoria,nombre_categoria,desc_categoria,estado_categoria) VALUES (1,'Hombre','Diseños para varones',1);
INSERT INTO bruno_minelli_db.TSA_CATEGORIA(id_categoria,nombre_categoria,desc_categoria,estado_categoria) VALUES (2,'Mujer','Diseños para damas',1);
INSERT INTO bruno_minelli_db.TSA_CATEGORIA(id_categoria,nombre_categoria,desc_categoria,estado_categoria) VALUES (3,'Niños','Para los pequeños del hogar',1);
INSERT INTO bruno_minelli_db.TSA_CATEGORIA(id_categoria,nombre_categoria,desc_categoria,estado_categoria) VALUES (4,'Deportes','Training y deporte',1);


/* TSA_PRODUCTO */
INSERT INTO bruno_minelli_db.TSA_PRODUCTO (`id_producto`,`id_categoria`,`nombre_producto`,`precio_producto`,`puntos_producto`,`stock_producto`,`imagen_producto`,`estado_producto`,`descripcion_producto`) VALUES (1,1,'Pantalón bermuda camuflado drill stresh para hombre',45.00,45,76,'https://ropa-modelos.s3.amazonaws.com/bermuda-drill.png',1,'Pantalón bermuda camuflado drill stresh para hombre');
INSERT INTO bruno_minelli_db.TSA_PRODUCTO (`id_producto`,`id_categoria`,`nombre_producto`,`precio_producto`,`puntos_producto`,`stock_producto`,`imagen_producto`,`estado_producto`,`descripcion_producto`) VALUES (2,1,'Pantalón bermuda stresh para hombre',99.90,99,17,'https://ropa-modelos.s3.amazonaws.com/bermuda-strech-hombre.png',1,'Bermuda varonil');
INSERT INTO bruno_minelli_db.TSA_PRODUCTO (`id_producto`,`id_categoria`,`nombre_producto`,`precio_producto`,`puntos_producto`,`stock_producto`,`imagen_producto`,`estado_producto`,`descripcion_producto`) VALUES (3,1,'CAMISA SLIM FIT PARA HOMBRE',25.00,25,79,'https://ropa-modelos.s3.amazonaws.com/camisa-slim-fit.png',1,'PRODUCTO HECHO DE ALGODÓN PURO');
INSERT INTO bruno_minelli_db.TSA_PRODUCTO (`id_producto`,`id_categoria`,`nombre_producto`,`precio_producto`,`puntos_producto`,`stock_producto`,`imagen_producto`,`estado_producto`,`descripcion_producto`) VALUES (4,1,'CAMISA JEANS STRECH PARA HOMBRE',79.99,75,20,'https://ropa-modelos.s3.amazonaws.com/camisa-strech.png',1,'CAMISA JUVENIL IDEAL PARA EL VERANO');
INSERT INTO bruno_minelli_db.TSA_PRODUCTO (`id_producto`,`id_categoria`,`nombre_producto`,`precio_producto`,`puntos_producto`,`stock_producto`,`imagen_producto`,`estado_producto`,`descripcion_producto`) VALUES (5,1,'Casaca poleras y buzos en fresh terry para hombre',55.00,50,11,'https://ropa-modelos.s3.amazonaws.com/casaca-buzo.png',1,'Casa ligera');
INSERT INTO bruno_minelli_db.TSA_PRODUCTO (`id_producto`,`id_categoria`,`nombre_producto`,`precio_producto`,`puntos_producto`,`stock_producto`,`imagen_producto`,`estado_producto`,`descripcion_producto`) VALUES (6,1,'Casaca látex lavable para hombre',49.90,50,17,'https://ropa-modelos.s3.amazonaws.com/casaca-dunkelvolk.png',1,'Casa hecha de material sintético');
INSERT INTO bruno_minelli_db.TSA_PRODUCTO (`id_producto`,`id_categoria`,`nombre_producto`,`precio_producto`,`puntos_producto`,`stock_producto`,`imagen_producto`,`estado_producto`,`descripcion_producto`) VALUES (7,1,'Casaca poleras y buzos en fresh terry para hombre',120.00,150,199,'https://ropa-modelos.s3.amazonaws.com/casaca-terry-hombre.png',1,'Modelo casual');
INSERT INTO bruno_minelli_db.TSA_PRODUCTO (`id_producto`,`id_categoria`,`nombre_producto`,`precio_producto`,`puntos_producto`,`stock_producto`,`imagen_producto`,`estado_producto`,`descripcion_producto`) VALUES (8,1,'Polo flame slim fit para hombre',99.99,100,79,'https://ropa-modelos.s3.amazonaws.com/polo-flame-slim-fit.png',1,'Modelo sport 100% algodón');
INSERT INTO bruno_minelli_db.TSA_PRODUCTO (`id_producto`,`id_categoria`,`nombre_producto`,`precio_producto`,`puntos_producto`,`stock_producto`,`imagen_producto`,`estado_producto`,`descripcion_producto`) VALUES (16,1,'Casaca con capucha DRSK worry less - negro/VR',105.00,210,9,'https://ropa-modelos.s3.amazonaws.com/casaca-DRSK.jpg',1,'Diseño Urbano especial para skateboarding');
INSERT INTO bruno_minelli_db.TSA_PRODUCTO (`id_producto`,`id_categoria`,`nombre_producto`,`precio_producto`,`puntos_producto`,`stock_producto`,`imagen_producto`,`estado_producto`,`descripcion_producto`) VALUES (17,1,'Boston - Pack x3 Polo Hombre Básico - Plomo Blanco y Negro',64.90,65,99,'https://ropa-modelos.s3.amazonaws.com/boston-pack-x3.jpg',1,'Recomendado para todo tipo de ocasion');
INSERT INTO bruno_minelli_db.TSA_PRODUCTO (`id_producto`,`id_categoria`,`nombre_producto`,`precio_producto`,`puntos_producto`,`stock_producto`,`imagen_producto`,`estado_producto`,`descripcion_producto`) VALUES (18,1,'ROPA DE BAÑO',124.50,125,70,'https://ropa-modelos.s3.amazonaws.com/ropa-bano-quicksilver.jpg',1,'FABRICADO A BASE DE BOTELLAS DE PLÁSTICO');
INSERT INTO bruno_minelli_db.TSA_PRODUCTO (`id_producto`,`id_categoria`,`nombre_producto`,`precio_producto`,`puntos_producto`,`stock_producto`,`imagen_producto`,`estado_producto`,`descripcion_producto`) VALUES (19,1,'CASACA LEVIS TRUCKER JACKET MEDIUM STONEWASH',249.00,200,50,'https://ropa-modelos.s3.amazonaws.com/casaca-levistrucker.jpg',1,'ELABORADOS CON MATERIALES DE PRIMERA CALIDAD.');
INSERT INTO bruno_minelli_db.TSA_PRODUCTO (`id_producto`,`id_categoria`,`nombre_producto`,`precio_producto`,`puntos_producto`,`stock_producto`,`imagen_producto`,`estado_producto`,`descripcion_producto`) VALUES (20,2,'BLUSA BOLILLO BOTONES',79.95,80,44,'https://ropa-modelos.s3.amazonaws.com/blusa-bolillo-botones.webp',1,'BLUSA MANGA LARGA CON DETALLE DE BOLILLO EN MANGAS Y ESCOTE DE CUELLO. CUENTA CON DETALLE DE TEXTURA EN TODA LA BLUSA Y BOTONES EN DELANTERO.');
INSERT INTO bruno_minelli_db.TSA_PRODUCTO (`id_producto`,`id_categoria`,`nombre_producto`,`precio_producto`,`puntos_producto`,`stock_producto`,`imagen_producto`,`estado_producto`,`descripcion_producto`) VALUES (21,2,'BLUSA ELASTIC PRINT',59.95,60,30,'https://ropa-modelos.s3.amazonaws.com/blusa-elastic-print.webp',1,'BLUSA MANGA 3/4 CON CUELLO CAMISERO. CUENTA CON DETALLE DE BOLSILLOS EN EL DELANTERO Y PRETINA ELASTICADA.');
INSERT INTO bruno_minelli_db.TSA_PRODUCTO (`id_producto`,`id_categoria`,`nombre_producto`,`precio_producto`,`puntos_producto`,`stock_producto`,`imagen_producto`,`estado_producto`,`descripcion_producto`) VALUES (22,2,'Blusa Nudo Lace',69.95,70,12,'https://ropa-modelos.s3.amazonaws.com/blusa-nudo-lace.webp',1,'Blusa cuello camisero, con detalle de encaje en hombros. Cuenta con detalle de regulador de manga, botones y nudo en delantero.');
INSERT INTO bruno_minelli_db.TSA_PRODUCTO (`id_producto`,`id_categoria`,`nombre_producto`,`precio_producto`,`puntos_producto`,`stock_producto`,`imagen_producto`,`estado_producto`,`descripcion_producto`) VALUES (23,2,'Blusa Bobo',79.95,80,5,'https://ropa-modelos.s3.amazonaws.com/blusa-bobo.webp',1,'Blusa manga larga, con escote estilo V. Cuenta con detalle de botones en el delantero y volado en basta de mangas y contorno de prenda.');
INSERT INTO bruno_minelli_db.TSA_PRODUCTO (`id_producto`,`id_categoria`,`nombre_producto`,`precio_producto`,`puntos_producto`,`stock_producto`,`imagen_producto`,`estado_producto`,`descripcion_producto`) VALUES (24,2,'VESTIDO SHORT',50.00,50,150,NULL,1,'TIPO DE TELA: LINO\nSON TALLAS COMPLETAS');
