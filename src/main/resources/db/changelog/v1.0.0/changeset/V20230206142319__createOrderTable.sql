CREATE SEQUENCE IF NOT EXISTS order_id_sequence START WITH 1 INCREMENT BY 1;
CREATE TABLE orders
(
    id         int4      NOT NULL DEFAULT nextval('order_id_sequence'::regclass),
    created_at timestamp NOT NULL,
    drone_id   int4      not null,
    CONSTRAINT order_pk PRIMARY KEY (id),
    CONSTRAINT order_drone_fkey FOREIGN KEY (drone_id) REFERENCES drones (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE SEQUENCE IF NOT EXISTS order_item_id_sequence START WITH 1 INCREMENT BY 1;
create table order_items
(
    id          int4 NOT NULL DEFAULT nextval('order_item_id_sequence'::regclass),
    order_id    int4 not null,
    medicine_id int4 not null,
    count       int  not null,
    CONSTRAINT order_item_pk PRIMARY KEY (id),
    CONSTRAINT order_item_order_fkey FOREIGN KEY (order_id) REFERENCES orders (id) ON DELETE CASCADE
);
