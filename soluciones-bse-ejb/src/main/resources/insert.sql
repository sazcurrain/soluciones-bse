INSERT INTO PROFESION (ID,DESCRIPCION) VALUES (1, 'INGENIERO')
INSERT INTO PROFESION (ID,DESCRIPCION) VALUES (2, 'COCINERO')
INSERT INTO PROFESION (ID,DESCRIPCION) VALUES (3, 'ESTUDIANTE')
INSERT INTO PROFESION (ID,DESCRIPCION) VALUES (4, 'DOCENTE')
INSERT INTO PROFESION (ID,DESCRIPCION) VALUES (5, 'CARPINTERO')

INSERT INTO SolInfra (nombre, entorno, sistema_operativo, version, id) VALUES ('TuHBSEapp_IOS', 0,'IOS','2.5',NEXT VALUE FOR HIBERNATE_SEQUENCE)
INSERT INTO SolInfra (nombre, entorno, sistema_operativo, version, id) VALUES ('TuHBSEapp_ANDROID',1,'Android','2.5',NEXT VALUE FOR HIBERNATE_SEQUENCE)
INSERT INTO SolInfra (nombre, entorno, sistema_operativo, version, id) VALUES ('BSE_CLOUD',0,'Linux','2.5',NEXT VALUE FOR HIBERNATE_SEQUENCE)
INSERT INTO SolInfra (nombre, entorno, sistema_operativo, version, id) VALUES ('Magik_Server',0,'Linux','2.5',NEXT VALUE FOR HIBERNATE_SEQUENCE)
INSERT INTO SolInfra (nombre, entorno, sistema_operativo, version, id) VALUES ('Apex_Server',0,'Linux','2.5',NEXT VALUE FOR HIBERNATE_SEQUENCE)
INSERT INTO SolInfra (nombre, entorno, sistema_operativo, version, id) VALUES ('CLUSTER_RECTOR',0,'Linux','2.5',NEXT VALUE FOR HIBERNATE_SEQUENCE)

INSERT INTO TIENDA (url, id) VALUES('https://www.apple.com/es/app-store/',1)
INSERT INTO TIENDA (url,id) VALUES('https://play.google.com/store?hl=es&gl=US',2)

INSERT INTO NUBE (url,id) VALUES('https://signin.aws.amazon.com/signin',3)

INSERT INTO Servidor(IP, almacenamientoGB, memoriaRamGB, modeloCPU, numeroCPU, virtual, id) VALUES ('10.80.15.215',197152,16384,'I7',8,0,4);
INSERT INTO Servidor(IP, almacenamientoGB, memoriaRamGB, modeloCPU, numeroCPU, virtual, id) VALUES ('10.80.15.139',97152,16384,'I7',5,1,5);

INSERT INTO Cluster(IPs,  cantNodos   , totalAlmacenamientoGB  , totalMemoriaRamGB  , totalNumeroCPU, virtual, id) VALUES ('10.80.15.13',4,2097152,32768,24,0,6);

INSERT INTO ComponenteSoftware(id,fechaVersioN, nombre, version) values (NEXT VALUE FOR HIBERNATE_SEQUENCE, '2021-10-11', 'sissan', '2021_R1');
INSERT INTO Aplicacion(id) VALUES(7);
INSERT INTO ComponenteSoftware(id,fechaVersioN, nombre, version) values (NEXT VALUE FOR HIBERNATE_SEQUENCE, '2021-10-11', 'sissan_rest', '2021_R1_R1');
INSERT INTO Interfaz(implementacion, tipo , id, aplicacion_id) values (0, 1, 8, 7);

INSERT INTO ComponenteSoftware(id,fechaVersioN, nombre, version) values (NEXT VALUE FOR HIBERNATE_SEQUENCE, '2019-05-11', 'Magik', '2021_V9');
INSERT INTO Aplicacion(id) VALUES(9);
INSERT INTO ComponenteSoftware(id,fechaVersioN, nombre, version) values (NEXT VALUE FOR HIBERNATE_SEQUENCE, '2021-10-11', 'Magik_Personas_rest', '2021_R1_R1');
INSERT INTO Interfaz(implementacion, tipo , id, aplicacion_id) values (0, 1, 10, 9);
INSERT INTO app_consume_inter (app_fk, inter_fk) values (7,10);


INSERT INTO ComponenteSoftware(id,fechaVersioN, nombre, version) values (NEXT VALUE FOR HIBERNATE_SEQUENCE, '2021-10-01', 'Historia Clinica Electrónica', '2021');
INSERT INTO Solucion(id,descripcion) VALUES(11,'Soft componentes de la HCE');
INSERT INTO Solucion_ComponenteSoftware (Solucion_id, componentes_id) values (11,9);
INSERT INTO Solucion_ComponenteSoftware (Solucion_id, componentes_id) values (11,7);
