CREATE TABLE  knowmebetter.jointure (
id SERIAL PRIMARY KEY,
optlock TIMESTAMP (3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
source BIGINT UNSIGNED,
target BIGINT UNSIGNED,
constraint  fk_source_author foreign key (source) references knowmebetter.author(id),
constraint  fk_target_author foreign key (target) references knowmebetter.author(id)
);
