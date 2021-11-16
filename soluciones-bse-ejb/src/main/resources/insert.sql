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

/* hasta aca HIBERNATE_SEQUENCE=10*/
INSERT INTO ComponenteSoftware(id,fechaVersioN, nombre, version) values (NEXT VALUE FOR HIBERNATE_SEQUENCE, '2021-10-01', 'Historia Clinica Electrónica', '2021');
INSERT INTO Solucion(id,descripcion) VALUES(11,'Soft componentes de la HCE');
INSERT INTO Solucion_ComponenteSoftware (Solucion_id, componentes_id) values (11,9);
INSERT INTO Solucion_ComponenteSoftware (Solucion_id, componentes_id) values (11,7);

/* hasta aca HIBERNATE_SEQUENCE=11*/
INSERT INTO Stakeholder (id, mail , nombre , telefono , tipo) values (NEXT VALUE FOR HIBERNATE_SEQUENCE, 'cacho@gmail.com', 'Cacho', '9999999', 1);
INSERT INTO Stakeholder (id, mail , nombre , telefono , tipo) values (NEXT VALUE FOR HIBERNATE_SEQUENCE, 'pepe@gmail.com', 'Pepe', '88888888', 0);
INSERT INTO Stakeholder (id, mail , nombre , telefono , tipo) values (NEXT VALUE FOR HIBERNATE_SEQUENCE, 'fulano@gmail.com', 'Fulano', '777777', 0);
INSERT INTO Stakeholder (id, mail , nombre , telefono , tipo) values (NEXT VALUE FOR HIBERNATE_SEQUENCE, 'toto@gmail.com', 'Toto', '66666666', 1);
INSERT INTO Stakeholder (id, mail , nombre , telefono , tipo) values (NEXT VALUE FOR HIBERNATE_SEQUENCE, 'mengano@gmail.com', 'Mengano', '5555555', 0);

/* hasta aca HIBERNATE_SEQUENCE=16*/
INSERT INTO StakeholdersComponente (id, rol, componente_id, stakeholder_id) values (NEXT VALUE FOR HIBERNATE_SEQUENCE, 0, 11, 16);
INSERT INTO StakeholdersComponente (id, rol, componente_id, stakeholder_id) values (NEXT VALUE FOR HIBERNATE_SEQUENCE, 1, 11, 15);
INSERT INTO StakeholdersComponente (id, rol, componente_id, stakeholder_id) values (NEXT VALUE FOR HIBERNATE_SEQUENCE, 2, 11, 14);
INSERT INTO StakeholdersComponente (id, rol, componente_id, stakeholder_id) values (NEXT VALUE FOR HIBERNATE_SEQUENCE, 3, 11, 13);
INSERT INTO StakeholdersComponente (id, rol, componente_id, stakeholder_id) values (NEXT VALUE FOR HIBERNATE_SEQUENCE, 0, 9, 16);
INSERT INTO StakeholdersComponente (id, rol, componente_id, stakeholder_id) values (NEXT VALUE FOR HIBERNATE_SEQUENCE, 1, 9, 13);
INSERT INTO StakeholdersComponente (id, rol, componente_id, stakeholder_id) values (NEXT VALUE FOR HIBERNATE_SEQUENCE, 0, 7, 15);
INSERT INTO StakeholdersComponente (id, rol, componente_id, stakeholder_id) values (NEXT VALUE FOR HIBERNATE_SEQUENCE, 1, 7, 14);
INSERT INTO StakeholdersComponente (id, rol, componente_id, stakeholder_id) values (NEXT VALUE FOR HIBERNATE_SEQUENCE, 0, 10, 16);
INSERT INTO StakeholdersComponente (id, rol, componente_id, stakeholder_id) values (NEXT VALUE FOR HIBERNATE_SEQUENCE, 1, 10, 13);

/* hasta aca HIBERNATE_SEQUENCE=26*/
INSERT INTO Ambiente (id, directorio, entorno, puerto, url, aplicacion_id, solInfra_id) values(NEXT VALUE FOR HIBERNATE_SEQUENCE,'---', 0,'8080','http://jboss-desa.bse.com.uy:8080/MAGIK/index.html',9,4);