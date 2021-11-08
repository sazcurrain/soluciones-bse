INSERT INTO PROFESION (ID,DESCRIPCION) VALUES (1, 'INGENIERO')
INSERT INTO PROFESION (ID,DESCRIPCION) VALUES (2, 'COCINERO')
INSERT INTO PROFESION (ID,DESCRIPCION) VALUES (3, 'ESTUDIANTE')
INSERT INTO PROFESION (ID,DESCRIPCION) VALUES (4, 'DOCENTE')
INSERT INTO PROFESION (ID,DESCRIPCION) VALUES (5, 'CARPINTERO')

INSERT INTO SolInfra (entorno, sistema_operativo, version, id) VALUES (0,'IOS','2.5',1)
INSERT INTO SolInfra (entorno, sistema_operativo, version, id) VALUES (1,'Android','2.5',2)
INSERT INTO SolInfra (entorno, sistema_operativo, version, id) VALUES (0,'Linux','2.5',3)
INSERT INTO SolInfra (entorno, sistema_operativo, version, id) VALUES (0,'Linux','2.5',4)
INSERT INTO SolInfra (entorno, sistema_operativo, version, id) VALUES (0,'Linux','2.5',5)
INSERT INTO SolInfra (entorno, sistema_operativo, version, id) VALUES (0,'Linux','2.5',6)

INSERT INTO TIENDA (nombre,url, id) VALUES('TuHBSEapp_IOS','https://www.apple.com/es/app-store/',1)
INSERT INTO TIENDA (nombre,url,id) VALUES('TuHBSEapp_ANDROID','https://play.google.com/store?hl=es&gl=US',2)

INSERT INTO NUBE (nombre,url,id) VALUES('BSE_CLOUD','https://signin.aws.amazon.com/signin',3)

INSERT INTO Servidor(IP, almacenamientoGB, memoriaRamGB, modeloCPU, nombre, numeroCPU, virtual, id) VALUES ('10.80.15.215',197152,16384,'I7','Magik_Server',8,0,4);
INSERT INTO Servidor(IP, almacenamientoGB, memoriaRamGB, modeloCPU, nombre, numeroCPU, virtual, id) VALUES ('10.80.15.139',97152,16384,'I7','Apex_Server',5,1,5);

INSERT INTO Cluster(IPs,  cantNodos   , nombre ,totalAlmacenamientoGB  , totalMemoriaRamGB  , totalNumeroCPU, virtual, id) VALUES ('10.80.15.13',4,'CLUSTER_RECTOR',2097152,32768,24,0,6);
