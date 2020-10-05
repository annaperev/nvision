CREATE TABLE public.job
(
    id bigint NOT NULL,
    type varchar (50) NOT NULL,
    user varchar (50) NOT NULL,
    device varchar (50) NOT NULL,
    amount numeric(10,2) NOT NULL,
    time date NOT NULL
)

