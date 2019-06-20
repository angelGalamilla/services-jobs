INSERT INTO CAT_PROCESO (id_cat_proceso, CLAVE, NOMBRE) VALUES (1,'1','Registros');
INSERT INTO CAT_PROCESO (id_cat_proceso, CLAVE, NOMBRE) VALUES (2,'2','Traspasos');
INSERT INTO CAT_PROCESO (id_cat_proceso, CLAVE, NOMBRE) VALUES (3,'3','Recaudación');
INSERT INTO CAT_PROCESO (id_cat_proceso, CLAVE, NOMBRE) VALUES (4,'4','Ahorro voluntario');
INSERT INTO CAT_PROCESO (id_cat_proceso, CLAVE, NOMBRE) VALUES (5,'5','Retiros');
INSERT INTO CAT_PROCESO (id_cat_proceso, CLAVE, NOMBRE) VALUES (6,'6','Créditos de vivienda');
INSERT INTO CAT_PROCESO (id_cat_proceso, CLAVE, NOMBRE) VALUES (7,'7','Devoluciones');
INSERT INTO CAT_PROCESO (id_cat_proceso, CLAVE, NOMBRE) VALUES (8,'8','Administración de la cuenta');
INSERT INTO CAT_PROCESO (id_cat_proceso, CLAVE, NOMBRE) VALUES (9,'9','Solicitudes terminales en Servicio a Clientes');
INSERT INTO CAT_PROCESO (id_cat_proceso, CLAVE, NOMBRE) VALUES (10,'10','Administración de Empleados certificables');

INSERT INTO CAT_SUBPROCESO (id_cat_subproceso, CLAVE, NOMBRE, id_proceso) VALUES (1,'1','Gestión de solicitud de Domiciliación', 4);
INSERT INTO CAT_SUBPROCESO (id_cat_subproceso, CLAVE, NOMBRE, id_proceso) VALUES (2,'2','Alta / Baja',4);
INSERT INTO CAT_SUBPROCESO (id_cat_subproceso, CLAVE, NOMBRE, id_proceso) VALUES (3,'3','Cobranza',4);
INSERT INTO CAT_SUBPROCESO (id_cat_subproceso, CLAVE, NOMBRE, id_proceso) VALUES (4,'4','Recaudación',4);
INSERT INTO CAT_SUBPROCESO (id_cat_subproceso, CLAVE, NOMBRE, id_proceso) VALUES (5,'5','Información autoridad',4);
INSERT INTO CAT_SUBPROCESO (id_cat_subproceso, CLAVE, NOMBRE, id_proceso) VALUES (6,'6','Devolución de aportaciones',4);

INSERT INTO CAT_TRAMITE (id_cat_tramite, CLAVE, NOMBRE, id_sub_proceso) VALUES (1,'1','Ahorro Voluntario Bancomer Origen XXI',4);
INSERT INTO CAT_TRAMITE (id_cat_tramite, CLAVE, NOMBRE, id_sub_proceso) VALUES (2,'2','Ahorro Voluntario Banorte por Internet',4);
INSERT INTO CAT_TRAMITE (id_cat_tramite, CLAVE, NOMBRE, id_sub_proceso) VALUES (3,'3','Ahorro Voluntario Domiciliación Bancomer',4);
INSERT INTO CAT_TRAMITE (id_cat_tramite, CLAVE, NOMBRE, id_sub_proceso) VALUES (4,'4','Ahorro Voluntario Domiciliación Banorte',4);
INSERT INTO CAT_TRAMITE (id_cat_tramite, CLAVE, NOMBRE, id_sub_proceso) VALUES (5,'5','Ahorro Voluntario Emisora CEP',4);
INSERT INTO CAT_TRAMITE (id_cat_tramite, CLAVE, NOMBRE, id_sub_proceso) VALUES (6,'6','Ahorro Voluntario En el extranjero (Uniteller-Remesas)',4);
INSERT INTO CAT_TRAMITE (id_cat_tramite, CLAVE, NOMBRE, id_sub_proceso) VALUES (7,'7','Ahorro Voluntario Nómina programada  Bancomer',4);
INSERT INTO CAT_TRAMITE (id_cat_tramite, CLAVE, NOMBRE, id_sub_proceso) VALUES (8,'8','Ahorro Voluntario Portabilidad Bancomer',4);
INSERT INTO CAT_TRAMITE (id_cat_tramite, CLAVE, NOMBRE, id_sub_proceso) VALUES (9,'9','Ahorro Voluntario Redes Comerciales',4);
INSERT INTO CAT_TRAMITE (id_cat_tramite, CLAVE, NOMBRE, id_sub_proceso) VALUES (10,'10','Ahorro Voluntario Ventanilla Bancomer',4);
INSERT INTO CAT_TRAMITE (id_cat_tramite, CLAVE, NOMBRE, id_sub_proceso) VALUES (11,'11','Ahorro Voluntario Nómina programada Clientes estratégicos',4);

