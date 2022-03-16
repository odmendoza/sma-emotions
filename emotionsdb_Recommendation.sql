create table Recommendation
(
    idRecommendation          varchar(11) not null
        primary key,
    descriptionRecommendation longtext    null,
    idEmotion                 varchar(11) not null,
    constraint fk_Recommendation_Emotion
        foreign key (idEmotion) references Emotion (idEmotion)
);

INSERT INTO emotionsdb.Recommendation (idRecommendation, descriptionRecommendation, idEmotion) VALUES ('re-001', 'Estimular producción de los estudiantes.', 'em-002');
INSERT INTO emotionsdb.Recommendation (idRecommendation, descriptionRecommendation, idEmotion) VALUES ('re-002', 'Promover el dialogo y discusiones respetuosas.', 'em-002');
INSERT INTO emotionsdb.Recommendation (idRecommendation, descriptionRecommendation, idEmotion) VALUES ('re-003', 'Brindar la opción de mayor participación al alumno.', 'em-002');
INSERT INTO emotionsdb.Recommendation (idRecommendation, descriptionRecommendation, idEmotion) VALUES ('re-004', 'Confrontar distintos puntos de vista.', 'em-002');
INSERT INTO emotionsdb.Recommendation (idRecommendation, descriptionRecommendation, idEmotion) VALUES ('re-005', 'Tratar contenido contextualizados en las experiencias propias cuya aplicación se pueda visualizar en la práctica.', 'em-003');
INSERT INTO emotionsdb.Recommendation (idRecommendation, descriptionRecommendation, idEmotion) VALUES ('re-006', 'Valorar al estudiante y su esfuerzo.', 'em-003');
INSERT INTO emotionsdb.Recommendation (idRecommendation, descriptionRecommendation, idEmotion) VALUES ('re-007', 'Ampliar la capacidad de tolerancia.', 'em-003');
INSERT INTO emotionsdb.Recommendation (idRecommendation, descriptionRecommendation, idEmotion) VALUES ('re-008', 'Ofrecer retroalimentación a sus alumnos.', 'em-003');
INSERT INTO emotionsdb.Recommendation (idRecommendation, descriptionRecommendation, idEmotion) VALUES ('re-009', 'Captar los distintos mensajes que transmiten los alumnos.', 'em-003');
INSERT INTO emotionsdb.Recommendation (idRecommendation, descriptionRecommendation, idEmotion) VALUES ('re-010', 'Motivar un ambiente de confianza en la clase en la que exista una relación cómoda entre estudiante - docente para mejorar los resultados de aprendizaje.', 'em-004');
INSERT INTO emotionsdb.Recommendation (idRecommendation, descriptionRecommendation, idEmotion) VALUES ('re-011', 'Continuar aplicando metodologías de enseñanza innovadoras aplicando TICS para fomentar la participación de los estudiantes.', 'em-005');
