create table data
(
    id bigserial primary key,
    bank_id bigint not null,
    ts_timestamp timestamp not null,
    from_address bigint not null,
    to_address bigint not null,
    amount decimal not null,
    type varchar(8)
);