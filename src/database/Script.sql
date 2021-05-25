create table if not exists clienti
(
    id_client int auto_increment,
    primary key (id_client),

    id_card int null,
    unique (id_card),

    #clientul poate strange puncte doar daca are un card
    puncte int null,
    constraint clienti_puncte_check
        check ((id_card is null and puncte > 0) or (id_card is not null)),

    nume varchar(30) not null,
    prenume varchar(30) not null,

    # 15 ca sa incapa si prefixul, daca e un strain
    telefon varchar(15) null,
    constraint clienti_check_telefon
        check (telefon not like '[A-Za-z]%'),

    mail varchar(50) null,
    constraint clienti_check_mail
        check (mail like '%_@_%.__%'),

    data_nastere date null

);

create table if not exists oferte
(
    id_oferta int auto_increment,
    primary key (id_oferta),

    descriere varchar(500) not null,
    data_expirare date null,
    puncte int not null
);

create table if not exists cabinet
(
    id_cabinet int auto_increment,
    primary key (id_cabinet),

    nume varchar(30) not null,
    adresa varchar(100) not null,

    mail varchar(50) null,
    constraint cabinet_check_mail
        check (mail like '%_@__%.__%'),
    telefon varchar(15) null,
    constraint cabinet_check_telefon
        check (telefon not like '[A-Za-z]%')
);

create table if not exists medici
(
    id_medic int auto_increment,
    primary key (id_medic),

    nume varchar(30) not null,
    prenume varchar(30) not null,

    mail varchar(50) null,
    constraint medici_check_mail
        check (mail like '%_@__%.__%'),

    telefon varchar(15) not null,
    constraint medici_check_telefon
        check (telefon not like '[A-Za-z]%'),

    id_cabinet int not null,
    constraint medici_id_cabinet
        foreign key (id_cabinet) references cabinet (id_cabinet) on delete cascade
);

create table if not exists servicii
(
    id_serviciu int auto_increment,
    primary key (id_serviciu),

    puncte int not null,

    pret int not null,
    constraint servicii_check_pret
        check (pret > 0),

    #durata e in minute
    durata int not null
);

create table if not exists programari
(
    id_programare int auto_increment,
    primary key (id_programare),

    data_ora_programare datetime not null,
    data_ora_efectuata datetime null,

    id_medic int not null,
    id_client int not null,
    id_serviciu int not null,
    foreign key (id_medic) references medici (id_medic) ,
    constraint programari_clienti_id_client_fk
        foreign key (id_client) references clienti (id_client) on delete cascade ,
    constraint programari_servicii_id_serviciu_fk
        foreign key (id_serviciu) references servicii (id_serviciu) on delete cascade
);

create table if not exists stoc
(
    id_stoc int auto_increment,
    primary key (id_stoc),

    descriere varchar(500) not null
);

create table if not exists produse
(
    cod_bare int primary key,

    nume char(50) not null,
    pret int not null,
    pret_vanzare int not null
);

# Nu sterg tabelul cos, pentru controalele fiscale.
create table if not exists cos
(
    id_cos int auto_increment,
    primary key (id_cos),
    id_client int not null,

    data date not null,

    constraint Cos_clienti_id_client_fk
        foreign key (id_client) references clienti (id_client)
);

create table if not exists nr_prod
(
    nr_prod int not null,
    constraint nr_prod_conex
        check ( nr_prod > 0 ),

    id_cos int not null,
    cod_bare int not null,
    primary key (id_cos, cod_bare),

    constraint nr_prod_id_cos_fk
        foreign key (id_cos) references cos (id_cos) on delete cascade,
    constraint nr_prod_cod_bare_fk
        foreign key (cod_bare) references produse (cod_bare) on delete cascade
);

create table if not exists produse_in_stoc
(
    nr_prod int not null,

    id_stoc int not null,
    cod_bare int not null,
    primary key (id_stoc, cod_bare),
    constraint produse_in_stoc_id_stoc_fk
        foreign key (id_stoc) references stoc (id_stoc) on delete cascade,
    constraint produse_in_stoc_cod_bare_fk
        foreign key (cod_bare) references produse (cod_bare) on delete cascade
);





