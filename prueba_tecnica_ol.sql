

--RETO 1

CREATE TABLE roles (
    rol_id INTEGER PRIMARY KEY,
    nombre_rol VARCHAR2(150)
);

CREATE TABLE municipios (
    municipio_id INTEGER primary key,
    nombre_municipio VARCHAR2(150)
);

create table usuarios(
    usuario_id integer PRIMARY KEY,
    nombre VARCHAR2(50) not null,
    correo_electronico VARCHAR2(200) unique not null,
    clave VARCHAR2(30) not null,
    rol_id integer not null,
    CONSTRAINT fk_roles_usuarios FOREIGN KEY (rol_id)
    REFERENCES roles(rol_id)
);

create table comerciantes(
    comerciante_id integer primary key,
    nombre VARCHAR2(200) not null,
    telefono VARCHAR2(12) not null,
    correo_electronico VARCHAR2(200) not null,
    municipio_id integer not null,
    fecha_registro DATE,
    estado NUMBER(1),
    fecha_actualizacion date,
    usuario_modifica integer,
    CONSTRAINT fk_com_usu FOREIGN KEY (usuario_modifica)
    references usuarios(usuario_id),
    CONSTRAINT fk_com_mun FOREIGN KEY (municipio_id)
    references municipios(municipio_id)
);

create table establecimientos(
    establecimiento_id integer primary key,
    nombre varchar2(50),
    ingresos NUMBER(10,2),
    cantidad_empleados integer,
    comerciante_id integer,
    fecha_actualizacion date,
    usuario_modifica integer,
    CONSTRAINT fk_est_usu FOREIGN KEY (usuario_modifica)
    references usuarios(usuario_id),
    CONSTRAINT fk_est_com FOREIGN KEY (comerciante_id)
    references comerciantes(comerciante_id)
);

--RETO 2

create sequence sec_roles
INCREMENT by 1
MAXVALUE 999999
MINVALUE 1
NOCYCLE
order
NOCACHE;

create sequence sec_municipios
INCREMENT by 1
MAXVALUE 999999
MINVALUE 1
NOCYCLE
order
NOCACHE;

create sequence sec_usuarios
INCREMENT by 1
MAXVALUE 999999
MINVALUE 1
NOCYCLE
order
NOCACHE;

create sequence sec_comerciantes
INCREMENT by 1
MAXVALUE 999999
MINVALUE 1
NOCYCLE
order
NOCACHE;

create sequence sec_establecimientos
INCREMENT by 1
MAXVALUE 999999
MINVALUE 1
NOCYCLE
order
NOCACHE;

create or replace trigger roles_trg
before insert on roles
for each row
begin
    select sec_roles.nextval into :NEW.rol_id from dual;
end;
/
create or replace trigger municipio_trg
before insert on municipios
for each row
begin
    select sec_municipios.nextval into :NEW.municipio_id from dual;
end;
/

create or replace TRIGGER comerciantes_trg
before insert or update on comerciantes
for each ROW
begin
    if inserting then
        select sec_comerciantes.nextval into :new.comerciante_id from dual;
        :new.fecha_registro := SYSDATE;
    ELSIF UPDATING THEN
        :new.fecha_actualizacion := SYSDATE;
    end if;
end;
/

create or replace TRIGGER establecimientos_trg
before insert or update on establecimientos
for each ROW
begin
    if inserting then
        select sec_establecimientos.nextval into :new.establecimiento_id from dual;
    ELSIF UPDATING THEN
        :new.fecha_actualizacion := SYSDATE;
    end if;
end;
/
create or replace TRIGGER usuarios_trg
before insert on usuarios
for each ROW
begin
        select sec_usuarios.nextval into :new.usuario_id from dual;
end;
/

--RETO 3

insert into roles(nombre_rol) values('Administrador');
insert into roles(nombre_rol) values('Auxiliar de Registro');

insert into municipios(nombre_municipio) values ('Valle del cauca');

insert into usuarios (nombre, correo_electronico, clave, rol_id) values ('Bronnie Galley', 'bgalley0@timesonline.co', 'n1c0l4s10', 1);
insert into usuarios (nombre, correo_electronico, clave, rol_id) values ('Emili Swain', 'eswain1@usa.gov', 'n1c0l4s10', 2);

insert into comerciantes (nombre, telefono, correo_electronico, municipio_id, estado) values ('Joell Murtagh', '234-224-2380', 'jmurtagh0@foxnews.com', 1, 1);
insert into comerciantes (nombre, telefono, correo_electronico, municipio_id, estado) values ('Laney Bergstram', '834-453-8649', 'lbergstram1@miibeian.gov.cn', 1, 1);
insert into comerciantes (nombre, telefono, correo_electronico, municipio_id, estado) values ('Brunhilde Sindall', '839-384-3402', 'bsindall2@sciencedirect.com', 1, 1);
insert into comerciantes (nombre, telefono, correo_electronico, municipio_id, estado) values ('Hobard Geffinger', '412-205-6290', 'hgeffinger3@ning.com', 1, 1);
insert into comerciantes (nombre, telefono, correo_electronico, municipio_id, estado) values ('Tallia Ridler', '780-932-5405', 'tridler4@prweb.com', 1, 1);

insert into establecimientos (nombre, ingresos, cantidad_empleados, comerciante_id) values ('Ashford Hospitality Trust Inc', 7459489.29, 922, 1);
insert into establecimientos (nombre, ingresos, cantidad_empleados, comerciante_id) values ('Resonant Inc.', 3851155.93, 945, 2);
insert into establecimientos (nombre, ingresos, cantidad_empleados, comerciante_id) values ('Arbor Realty Trust', 6178254.72, 293, 3);
insert into establecimientos (nombre, ingresos, cantidad_empleados, comerciante_id) values ('BioShares Biotechnology Products Fund', 3718048.21, 340, 4);
insert into establecimientos (nombre, ingresos, cantidad_empleados, comerciante_id) values ('JetPay Corporation', 7288474.97, 580, 5);
insert into establecimientos (nombre, ingresos, cantidad_empleados, comerciante_id) values ('American Realty Investors, Inc.', 6588338.35, 514, 1);
insert into establecimientos (nombre, ingresos, cantidad_empleados, comerciante_id) values ('Ecopetrol S.A.', 1498651.15, 802, 2);
insert into establecimientos (nombre, ingresos, cantidad_empleados, comerciante_id) values ('Marine Products Corporation', 1319499.6, 635, 3);
insert into establecimientos (nombre, ingresos, cantidad_empleados, comerciante_id) values ('Radware Ltd.', 8436495.77, 479, 2);
insert into establecimientos (nombre, ingresos, cantidad_empleados, comerciante_id) values ('International Speedway Corporation', 3811019.38, 371, 1);


-- RETO 4

select c.nombre,m.nombre_municipio,c.telefono,c.correo_electronico,c.fecha_registro,c.estado,
count(e.establecimiento_id) as cantidad_establecimientos, sum(e.ingresos) as ingresos_totales, 
sum(e.cantidad_empleados) as cantidad_empleados 
from comerciantes c
inner join municipios m on (c.municipio_id = m.municipio_id)
inner join establecimientos e on (e.comerciante_id = c.comerciante_id)
where c.estado = 1
group by c.nombre,m.nombre_municipio,c.telefono,c.correo_electronico,c.fecha_registro,c.estado
order by 7 desc;

CREATE OR REPLACE FUNCTION obtener_comerciantes_activos
RETURN SYS_REFCURSOR
IS
    comerciantes_cursor SYS_REFCURSOR;
BEGIN
    OPEN comerciantes_cursor FOR
    select c.nombre,m.nombre_municipio,c.telefono,c.correo_electronico,c.fecha_registro,c.estado,count(e.establecimiento_id) as cantidad_establecimientos, sum(e.ingresos) as ingresos_totales, sum(e.cantidad_empleados) as cantidad_empleados 
    from comerciantes c inner join municipios m on (c.municipio_id = m.municipio_id) inner join establecimientos e on (e.comerciante_id = c.comerciante_id)
    where c.estado = 1
    group by c.nombre,m.nombre_municipio,c.telefono,c.correo_electronico,c.fecha_registro,c.estado
    order by 7 desc;

    RETURN comerciantes_cursor;
END obtener_comerciantes_activos;