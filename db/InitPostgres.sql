--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: sstu-finder-db; Type: DATABASE; Schema: -; Owner: sstuuser
--

-- CREATE DATABASE "sstu-finder-db" WITH TEMPLATE = template0 ENCODING = 'UTF8';


ALTER DATABASE "sstu-finder-db" OWNER TO sstuuser;

\connect -reuse-previous=on "dbname='sstu-finder-db'"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: test; Type: TABLE; Schema: public; Owner: sstuuser
--

CREATE TABLE public.test (
    id bigint NOT NULL,
    firstname character varying NOT NULL,
    lastname character varying(40) NOT NULL
);


ALTER TABLE public.test OWNER TO sstuuser;

--
-- Name: test_id_seq; Type: SEQUENCE; Schema: public; Owner: sstuuser
--

CREATE SEQUENCE public.test_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.test_id_seq OWNER TO sstuuser;

--
-- Name: test_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: sstuuser
--

ALTER SEQUENCE public.test_id_seq OWNED BY public.test.id;


--
-- Name: test id; Type: DEFAULT; Schema: public; Owner: sstuuser
--

ALTER TABLE ONLY public.test ALTER COLUMN id SET DEFAULT nextval('public.test_id_seq'::regclass);


--
-- Data for Name: test; Type: TABLE DATA; Schema: public; Owner: sstuuser
--

COPY public.test (id, firstname, lastname) FROM stdin;
1	Ринат	Гей
2	Yagudin	GAY
3	RInat	GAY(гей)
\.


--
-- Name: test_id_seq; Type: SEQUENCE SET; Schema: public; Owner: sstuuser
--

SELECT pg_catalog.setval('public.test_id_seq', 3, true);


--
-- Name: test test_pk; Type: CONSTRAINT; Schema: public; Owner: sstuuser
--

ALTER TABLE ONLY public.test
    ADD CONSTRAINT test_pk PRIMARY KEY (id);


--
-- Name: test_id_uindex; Type: INDEX; Schema: public; Owner: sstuuser
--

CREATE UNIQUE INDEX test_id_uindex ON public.test USING btree (id);


--
-- PostgreSQL database dump complete
--

