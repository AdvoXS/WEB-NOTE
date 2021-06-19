create table note_group(
    id          SERIAL          PRIMARY KEY,
    name        VARCHAR(50)     not null
);

create table note(
    id          SERIAL          PRIMARY KEY,
    group_id     bigint          not null references note_group (id),
    head        VARCHAR(100)    not null,
    body        VARCHAR,
    create_date  DATE            not null
);

create table reference(
    id          SERIAL          PRIMARY KEY,
    group_id     bigint          not null references note_group (id),
    create_date  DATE            not null,
    head        VARCHAR(50),
    description VARCHAR(300),
    reference   VARCHAR         not null
);

create table task(
    id          SERIAL          PRIMARY KEY,
    group_id     bigint          not null references note_group (id),
    priority    integer,
    type        integer,
    progress    real,
    description VARCHAR,
    create_date  DATE            not null,
    end_date     DATE
);
