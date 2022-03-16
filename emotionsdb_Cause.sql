create table Cause
(
    idCause          varchar(11) not null
        primary key,
    descriptionCause longtext    null,
    idEmotion        varchar(11) not null,
    constraint fk_Cause_Emotion
        foreign key (idEmotion) references Emotion (idEmotion)
);

INSERT INTO emotionsdb.Cause (idCause, descriptionCause, idEmotion) VALUES ('ca-001', 'Los estudiantes comprenden los contenidos.', 'em-001');
INSERT INTO emotionsdb.Cause (idCause, descriptionCause, idEmotion) VALUES ('ca-002', 'La utilización de metodos de enseñanza innovadores involucran a los estudiantes.', 'em-001');
INSERT INTO emotionsdb.Cause (idCause, descriptionCause, idEmotion) VALUES ('ca-003', 'Los estudiantes muestran confianza con el docente.', 'em-001');
INSERT INTO emotionsdb.Cause (idCause, descriptionCause, idEmotion) VALUES ('ca-004', 'Falta de material didáctico.', 'em-002');
INSERT INTO emotionsdb.Cause (idCause, descriptionCause, idEmotion) VALUES ('ca-005', 'Presenta material en el que se encuentra mucho texto.', 'em-002');
INSERT INTO emotionsdb.Cause (idCause, descriptionCause, idEmotion) VALUES ('ca-006', 'No busca formas innovadoras de presentar un tema.', 'em-002');
INSERT INTO emotionsdb.Cause (idCause, descriptionCause, idEmotion) VALUES ('ca-007', 'Los estudiantes no comprenden los contenidos', 'em-003');
INSERT INTO emotionsdb.Cause (idCause, descriptionCause, idEmotion) VALUES ('ca-008', 'La metodología de enseñanza no es óptima para la clase.', 'em-003');
INSERT INTO emotionsdb.Cause (idCause, descriptionCause, idEmotion) VALUES ('ca-009', 'Los estudiantes no están satisfechos con los resultados de aprendizaje.', 'em-003');
INSERT INTO emotionsdb.Cause (idCause, descriptionCause, idEmotion) VALUES ('ca-010', 'Los contenidos son nuevos los estudiantes.', 'em-004');
INSERT INTO emotionsdb.Cause (idCause, descriptionCause, idEmotion) VALUES ('ca-011', 'El docente no genera confianza en los estudiantes.', 'em-004');
INSERT INTO emotionsdb.Cause (idCause, descriptionCause, idEmotion) VALUES ('ca-012', 'Los estudiantes se muestran preocupados por los resultados de aprendizaje de la materia.', 'em-004');
INSERT INTO emotionsdb.Cause (idCause, descriptionCause, idEmotion) VALUES ('ca-013', 'La clase resulta interesante y comprensible para los estudiantes.', 'em-005');
INSERT INTO emotionsdb.Cause (idCause, descriptionCause, idEmotion) VALUES ('ca-014', 'Se aplican metodologías de enseñanza que fomentan la participación de los estudiantes.', 'em-005');
INSERT INTO emotionsdb.Cause (idCause, descriptionCause, idEmotion) VALUES ('ca-015', 'Los estudiantes se sienten cómdos con el desenvolvimiento del docente en clase.', 'em-005');
