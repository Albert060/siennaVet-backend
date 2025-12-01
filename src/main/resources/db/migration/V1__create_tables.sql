
create table if not exists clientes(
id_cliente int primary key auto_increment not null,
nombre varchar(255),
apellido varchar(255),
dni varchar(10),
direccion varchar(255),
telefono varchar(255),
codigo_postal varchar(255)
);

create table if not exists vets(
id_vet int primary key auto_increment not null,
nombre varchar(255),
apellido varchar(255),
dni varchar(10),
sexo varchar(10),
num_colegiado varchar(255),
email varchar(255),
contrasena varchar(255),
telefono varchar(255),
fecha_inicio date
);

create table if not exists razas(
id_raza int primary key auto_increment not null,
tipo_raza varchar(255),
nombre varchar(255)
);

create table if not exists fichas(
id_ficha int primary key auto_increment not null,
nombre varchar(255),
sexo varchar(10),
edad varchar(10),
peso varchar(10),
chip varchar(10),
id_raza int,
id_cliente int,
foreign key(id_raza) references razas(id_raza),
foreign key(id_cliente) references clientes(id_cliente)
);

create table if not exists jaulas(
id_jaula int primary key auto_increment not null,
tamano varchar(255),
disponibilidad varchar(10)
);

create table if not exists citas(
id_cita int primary key auto_increment not null,
fecha date,
detalles varchar(255),
hora time,
id_ficha int,
id_vet int,
foreign key(id_vet) references vets(id_vet),
foreign key(id_ficha) references fichas(id_ficha)
);

create table if not exists ficha_actualizacion(
id_ficha_actualizacion int primary key auto_increment not null,
comentario varchar(255),
fecha date,
hora time,
es_Urgencia boolean,
costo double,
forma_pago varchar(255),
id_ficha int,
id_vet int,
foreign key(id_ficha) references fichas( id_ficha),
foreign key(id_vet) references vets(id_vet)
);

create table if not exists contactos(
id_contacto int primary key auto_increment not null,
nombre varchar(255),
email varchar(255),
servicio varchar(255),
mensaje varchar(255)
);
