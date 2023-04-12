-- to avoid error that table exists already when we re-run app, we need to have drop code ahead.
drop table if exists employees;

create table employees (
                id bigint not null,
                name varchar (255),
                primary key (id)
);