create database lacos;

create table pretendente(
pretendente_id serial primary key,
nome_pretendente varchar(200),
cpf varchar(32)
);

insert into pretendente values
(1, 'Jussara', md5('12345678')),
(2, 'Rodolfo', md5('7654321')),
(3, 'Rosângela', md5('98654223'));

create table crianca(
crianca_id serial primary key,
pretendente_id int references pretendente(pretendente_id)
);

insert into crianca values
(1,1),
(2,2),
(3,3);

create table usuario(
usuario_id serial primary key,
nome_usuario varchar(200),
email varchar(210),
senha varchar(20)
);

insert into usuario values
(1, 'José', 'jose@gmail', '1234', 'FUNCIONARIO'),
(2, 'Clara', 'clara@gmail', '12345', 'FUNCIONARIO'),
(3, 'Ronaldo', 'ronaldo@gmail', '12348', 'FUNCIONARIO');

DELETE FROM agendamento WHERE agendamento_id IN (1, 2, 3);
DELETE FROM usuario WHERE usuario_id IN (1, 2, 3);

select * from usuario;

create table agendamento(
agendamento_id serial primary key,
data date,
usuario_id int references usuario(usuario_id),
crianca_id int references crianca(crianca_id)
);

insert into agendamento values
(1, '2026-11-12', 1, 1),
(2, '2026-11-13', 2, 2),
(3, '2026-11-14', 3, 3);

alter table usuario add column perfil varchar(100);

SELECT setval(pg_get_serial_sequence('pretendente', 'pretendente_id'), COALESCE((SELECT MAX(pretendente_id) FROM pretendente), 0) + 1, false);
SELECT setval(pg_get_serial_sequence('crianca', 'crianca_id'), COALESCE((SELECT MAX(crianca_id) FROM crianca), 0) + 1, false);
SELECT setval(pg_get_serial_sequence('usuario', 'usuario_id'), COALESCE((SELECT MAX(usuario_id) FROM usuario), 0) + 1, false);
SELECT setval(pg_get_serial_sequence('agendamento', 'agendamento_id'), COALESCE((SELECT MAX(agendamento_id) FROM agendamento), 0) + 1, false);