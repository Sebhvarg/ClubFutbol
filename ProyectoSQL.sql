CREATE database club_De_Futbol;
use Club_De_Futbol;

CREATE TABLE EmpleadosDelClub(
	idEmpleados smallint NOT NULL,
    cedula varchar(11),
    nombres varchar(255),
    apellidos varchar(255),
    nacionalidad varchar(255),
    periodoActual varchar(255),
    inicioContrato date,
    finContrato date,
    sueldo float,
    email varchar(255),
    fechNacimiento date,
    numCelular varchar(10),
    tipoEmpleado varchar(100),
    PRIMARY KEY (idEmpleados)
);

CREATE TABLE Club(
	idClub int NOT NULL,
    nombre varchar(255),
    ciudad varchar(255),
    pais varchar(255),
    estadio varchar(255),
    posicionLiga int,
    fechFundacion date,
    titulos int,
    
    PRIMARY KEY (idClub)
);

CREATE TABLE Jugador(
	idJugador smallint NOT NULL,
    idEmpleados smallint,
    PRIMARY KEY (idJugador),
	FOREIGN KEY (idEmpleados) REFERENCES EmpleadosDelClub(idEmpleados)
);

CREATE TABLE InformacionJugador(
	idJugador smallint,
    valoracionActual smallint,
    valoracionPotencia smallint,
    seleccionado boolean,
    piernaHabil varchar(255),
    sueldo decimal(3,1),
    temporadasEnElClub int,
    altura float,
    peso float,
    lesion boolean,
    dorsal int,
    tipoFichaje varchar (250),    
    FOREIGN KEY (idJugador) REFERENCES Jugador(idJugador)
);

CREATE TABLE EstadisticaJugador(
	idJugador smallint,
    minutosJugados int,
    goles smallint,
    asistencias smallint,
	tarjAmarillas smallint,
    tarjRojas smallint,
    precisionPase smallint,
    valoracionDisciplina smallint,
    recuperacionBalon smallint,
    centros smallint,
    arcosInvictos smallint,
    golesRecibidos smallint,
    penalesAtajados smallint,
    promedioAtajadas decimal(3,1),
    FOREIGN KEY (idJugador) REFERENCES Jugador(idJugador)
);
CREATE TABLE Temporada(
	año smallint NOT NULL,
    pJugados smallint,
    pGanados smallint,
    pEmpatados smallint,
    pPerdidos  smallint,
    puntosObtenidos smallint,
    posicionLiga smallint,
    titulosObtenidos smallint,
    primary key (año)
    
);
CREATE TABLE torneo(
	idTorneo smallint NOT NULL AUTO_INCREMENT,
    nombre varchar(200),
    temporada varchar(5),
    categoría varchar(30),
    PRIMARY KEY (idLiga)
);
CREATE TABLE Partido(
	idPartido smallint NOT NULL,
    ciudad varchar(200),
    estadio varchar(200),
    situacion varchar(200),
    fecha date,
    rival varchar(200),
    torneo varchar (200),
    XIinicial varchar(5000),
    
    Primary Key (idPartido)
);
CREATE TABLE estadisticaPartido(
	idEstadistica smallint NOT NULL,
    
    Primary Key (idEstadistica)
);

-- PROCESO LOGIN
-- LOGIN
DELIMITER //
CREATE PROCEDURE login( in lemail varchar(255), in lcedula varchar(11), out tipo varchar(50))
BEGIN 
SET tipo = ( SELECT tipoEmpleado FROM club_de_futbol.empleadosdelclub WHERE lcedula = cedula AND lemail = email);
	IF tipo is null 
	THEN SET tipo ="0"; 
	END IF;
END
//
DELIMITER 
-- INSERTS
-- Empleados
INSERT INTO empleadosdelclub value(1, "0945176178", "Carlos Alejandro", "Alfaro Moreno", "Argentina - Ecuatoriana", "Activo", "2022-10-25", "2026-10-24", 7000.5, "alfmno@torerosfc.ec","1964-10-18", "0962565432", "Presidente");
INSERT INTO empleadosdelclub value(2, "0934657886", "Fabian Daniel", "Bustos Barbero", "Argentina - Ecuatoriana", "Activo", "2022-10-25", "2024-10-24", 4000.00, "fbustos@torerosfc.ec","1969-03-28", "0998997865", "DT");
INSERT INTO empleadosdelclub value(3, "AAF532592", "Javier Nicolás", "Burrai", "Argentina", "Activo", "2020-02-10", "2024-02-10", 2700, "jbrrai@torerosfc.ec","1990-10-09", "0976868658", "Jugador");
-- CLUBES
INSERT INTO CLUB value(1, "Toreros FC", "Guayaquil", "Ecuador" ,"Monumental Banco Pichincha", 2, "1925-05-01", 16);
INSERT INTO CLUB value(2, "SD Aucas", "Quito", "Ecuador" ,"Gonzalo Pozo Ripalda", 1, "1945-02-06", 1);
INSERT INTO CLUB value(3, "CEAR Independiente del Valle", "Sangolqui", "Ecuador" , "Banco Guayaquil", 3, "1958-03-01", 4);
INSERT INTO CLUB value(4, "CD Universidad Católica", "Quito", "Ecuador" , "Olimpico Atahualpa", 4, "1963-05-15", 0);
INSERT INTO CLUB value(5, "Liga Deportiva Universitaria", "Quito", "Ecuador"  ,"Rodrigo Paz Delgado", 5, "1930-01-11", 18);
INSERT INTO CLUB value(6, "CS Emelec", "Guayaquil", "Ecuador"  ,"George Capwell", 6, "1945-10-11", 14);
INSERT INTO CLUB value(7, "CD Cuenca", "Cuenca", "Ecuador"  ,"Alejandro Serrano Aguilar", 7, "1971-03-04", 1);
INSERT INTO CLUB value(8, "Delfin SC", "Manta", "Jocay", "Ecuador"  ,8, "1989-03-01", 1);
INSERT INTO CLUB value(9, "Guayaquil City FC", "Guayaquil", "Ecuador"  ,"Modelo 'Alberto Especer'", 9, "2007-09-07", 0);
INSERT INTO CLUB value(10, "Cumbayá FC", "Quito", "Ecuador"  ,"Olimpico Atahualpa", 10, "1951-10-25", 0);
INSERT INTO CLUB value(11, "Gualaceo SC", "Gualaceo", "Ecuador"  ,"Jorge Andrade Cantos", 11, "2000-04-02", 0);
INSERT INTO CLUB value(12, "Mushuc Runa SC", "Ambato", "Ecuador"  ,"COAC Mushuc Runa", 12, "2003-01-02", 0);
INSERT INTO CLUB value(13, "Orense SC", "Machala","Ecuador" ,"9 de Mayo", 13, "2009-12-15", 0);
INSERT INTO CLUB value(14, "CD Técnico Universitario", "Ambato", "Ecuador" ,"Bellavista", 14, "1971-03-26", 0);
INSERT INTO CLUB value(15, "CD El Nacional", "Quito","Ecuador"  ,"Olimpico Atahualpa", 15, "1960-03-07", 0);
INSERT INTO CLUB value(16, "Libertad FC", "Loja","Ecuador"  ,"Reina del Cisne", 16, "2017-05-17", 0);