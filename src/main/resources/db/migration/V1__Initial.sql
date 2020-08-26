--Create data struture
CREATE TABLE public.enrollee (
    enrollee_id serial,
    name varchar(255) NOT NULL,
    activation_status boolean NOT NULL,
    birth_date date NOT NULL,
    phone_number varchar(25),
    created_at timestamp,
    modified_at timestamp,
    CONSTRAINT enrollee_enrollee_id PRIMARY KEY (enrollee_id)
);

CREATE TABLE public.dependent (
    id serial,
    name varchar(255) NOT NULL,
    birth_date date NOT NULL,
    created_at timestamp,
    modified_at timestamp,
    dependent_enrollee_id integer,
    CONSTRAINT dependent_id PRIMARY KEY (id),
    CONSTRAINT dependent_enrollee_id FOREIGN KEY (dependent_enrollee_id) REFERENCES public.enrollee(enrollee_id)
);
-- Initial seeding
INSERT INTO public.enrollee (name, activation_status, birth_date)
    VALUES ('Chandler', True, '03-24-1975'), ('Joe', False, '09-13-1979'), ('Ross', False, '03-09-1972');
