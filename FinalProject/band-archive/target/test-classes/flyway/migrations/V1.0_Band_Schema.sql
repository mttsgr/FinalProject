drop table if exists album;
drop table if exists band;
drop table if exists genre;

create table genre (
	genre_pk int unsigned not null auto_increment,
	genre_id enum('Punk', 'Emo', 'Hardcore', 'Metal', 'Rock', 'Indie', 'Pop', 'Experimental', 'Shoegaze', 'Folk') not null,
	genre_description varchar (200) not null,
	primary key (genre_pk)
);

create table band (
	band_pk int unsigned not null auto_increment,
	genre1_fk int unsigned not null,
	genre2_fk int unsigned not null,
	band_id varchar(40) not null,
	band_name varchar(100) not null,
	years_active varchar(30) not null,
	city_of_origin varchar(50) not null,
	primary key (band_pk),
	foreign key (genre1_fk) references genre(genre_pk),
	foreign key (genre2_fk)references genre(genre_pk)
	);
	
create table album (
	album_pk int unsigned not null auto_increment,
	band_fk int unsigned not null,
	genre_fk int unsigned not null,
	album_id varchar(40) not null,
	album_name varchar(100) not null,
	release_year varchar(10) not null,
	album_length varchar(40) not null,
	primary key (album_pk),
	foreign key(band_fk) references band(band_pk),
	foreign key (genre_fk) references genre(genre_pk)
);
