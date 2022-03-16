create table Emotion
(
    idEmotion   varchar(11) not null
        primary key,
    nameEmotion varchar(45) not null
);

INSERT INTO emotionsdb.Emotion (idEmotion, nameEmotion) VALUES ('em-001', 'Alegría');
INSERT INTO emotionsdb.Emotion (idEmotion, nameEmotion) VALUES ('em-002', 'Aburrimiento');
INSERT INTO emotionsdb.Emotion (idEmotion, nameEmotion) VALUES ('em-003', 'Enojo');
INSERT INTO emotionsdb.Emotion (idEmotion, nameEmotion) VALUES ('em-004', 'Miedo');
INSERT INTO emotionsdb.Emotion (idEmotion, nameEmotion) VALUES ('em-005', 'Interés');
