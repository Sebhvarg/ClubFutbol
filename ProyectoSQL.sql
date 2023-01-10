CREATE database club_De_Futbol;
use Club_De_Futbol;

CREATE TABLE EmpleadosDelClub(
	idEmpleados smallint NOT NULL AUTO_INCREMENT,
    cedula varchar(11),
    nombre varchar(255),
    apellido varchar(255),
    periodoActual varchar(255),
    inicioContrato varchar(255),
    finContrato varchar(255),
    sueldo decimal(3,1),
    email varchar(255),
    fechNacimiento date,
    numCelular varchar(10),
    PRIMARY KEY (idEmpleados)
);

CREATE TABLE Club(
	idClub int NOT NULL AUTO_INCREMENT,
    nombre varchar(255),
    ciudad varchar(255),
    socios varchar(255),
    estadio varchar(255),
    posicionLiga varchar(255),
    fechFundacion decimal(3,1),
    titulos varchar(255),
    PRIMARY KEY (idClub)
);

CREATE TABLE Jugador(
	idJugador smallint NOT NULL AUTO_INCREMENT,
    idEmpleados smallint,
    PRIMARY KEY (idJugador),
	FOREIGN KEY (idEmpleados) REFERENCES EmpleadosDelClub(idEmpleados)
);

CREATE TABLE InformacionJugador(
	idJugador smallint,
    valoracionActual smallint,
    valoracionPotencia smallint,
    seleccionado boolean,
    division varchar(255),
    piernaHabil varchar(255),
    finContrato varchar(255),
    sueldo decimal(3,1),
    email varchar(255),
    fechNacimiento date,
    numCelular varchar(15),
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

CREATE TABLE Manager(
	idManager smallint NOT NULL AUTO_INCREMENT,
    cedula varchar(10),
    nombre varchar(255),
    fechNacimiento date,
    numCelular varchar(15),
    dirigeJugador varchar(255),
    email varchar(255),
	PRIMARY KEY (idManager)
);
CREATE TABLE Temporada(
	año smallint NOT NULL,
    pJugados smallint,
    pGanados smallint,
    pEmpatados smallint,
    pPerdidos  smallint,
    puntosObtenidos smallint,
    posicionLiga smallint,
    primary key (año)
    
);
CREATE TABLE Liga(
	idLiga smallint NOT NULL AUTO_INCREMENT,
    nombre varchar(200),
    temporada varchar(5),
    categoría varchar(30),
    PRIMARY KEY (idLiga)
);
CREATE TABLE Partido(
	idPartido smallint NOT NULL AUTO_INCREMENT,
    ciudad varchar(200),
    estadio varchar(200),
    situacion varchar(200),
    fecha date,
    rival varchar(200),
    torneo varchar (200),
    XIinicial varchar(5000),
    Primary Key (idPartido)
);

