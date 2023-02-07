CREATE SEQUENCE IF NOT EXISTS charging_history_id_sequence START WITH 1 INCREMENT BY 1;
CREATE TABLE charging_history
(
    id         int4      NOT NULL DEFAULT nextval('charging_history_id_sequence'::regclass),
    created_at timestamp NOT NULL,
    drone_id   int4      not null,
    level      int,
    CONSTRAINT charging_history_pk PRIMARY KEY (id),
    CONSTRAINT charging_history_drone_fkey FOREIGN KEY (drone_id) REFERENCES drones (id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE
INDEX charging_history_drone_id_idx ON charging_history (drone_id, created_at);
