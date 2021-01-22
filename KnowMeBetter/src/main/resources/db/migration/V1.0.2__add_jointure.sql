CREATE TABLE  knowmebetter.jointure (
id SERIAL PRIMARY KEY,
optlock TIMESTAMP (3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
source BIGINT UNSIGNED,
target BIGINT UNSIGNED,
constraint  fk_source_author foreign key (source) references knowmebetter.author(id),
constraint  fk_target_author foreign key (target) references knowmebetter.author(id)
);


CREATE TABLE  knowmebetter.jointure2 (
id SERIAL PRIMARY KEY,
optlock TIMESTAMP (3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
source BIGINT UNSIGNED,
target BIGINT UNSIGNED,
constraint  fk_source_author2 foreign key (source) references knowmebetter.author2(id),
constraint  fk_target_author2 foreign key (target) references knowmebetter.author2(id)
);

CREATE TABLE  knowmebetter.jointure3 (
id SERIAL PRIMARY KEY,
optlock TIMESTAMP (3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
source BIGINT UNSIGNED,
target BIGINT UNSIGNED,
constraint  fk_source_author3 foreign key (source) references knowmebetter.author3(id),
constraint  fk_target_author3 foreign key (target) references knowmebetter.author3(id)
);


CREATE TABLE  knowmebetter.jointure4 (
id SERIAL PRIMARY KEY,
optlock TIMESTAMP (3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
source BIGINT UNSIGNED,
target BIGINT UNSIGNED,
constraint  fk_source_author4 foreign key (source) references knowmebetter.author4(id),
constraint  fk_target_author4 foreign key (target) references knowmebetter.author4(id)
);

CREATE TABLE  knowmebetter.jointure5 (
id SERIAL PRIMARY KEY,
optlock TIMESTAMP (3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
source BIGINT UNSIGNED,
target BIGINT UNSIGNED,
constraint  fk_source_author5 foreign key (source) references knowmebetter.author5(id),
constraint  fk_target_author5 foreign key (target) references knowmebetter.author5(id)
);
