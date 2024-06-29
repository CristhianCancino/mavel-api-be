CREATE TABLE public.SERVICE_USAGE (
    id INT NOT NULL AUTO_INCREMENT,
    service_name VARCHAR(20) NOT NULL,
    timestamp TIMESTAMP NOT NULL,
    CONSTRAINT service_usage_pk PRIMARY KEY (id)
);