--
-- PostgreSQL database dump
--

-- Dumped from database version 14.0
-- Dumped by pg_dump version 14.0

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

DROP DATABASE if exists iss;
--
-- Name: iss; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE iss WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1252';


ALTER DATABASE iss OWNER TO postgres;

\connect iss

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
-- Name: plan; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.plan (
    id bigint NOT NULL,
    time_line integer
);


ALTER TABLE public.plan OWNER TO postgres;

--
-- Name: plan1_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.plan1_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.plan1_id_seq OWNER TO postgres;

--
-- Name: plan1_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.plan1_id_seq OWNED BY public.plan.id;


--
-- Name: product; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product (
    depreciation double precision,
    price double precision,
    quantity double precision,
    total_price double precision,
    id bigint NOT NULL,
    parent_id bigint
);


ALTER TABLE public.product OWNER TO postgres;

--
-- Name: product_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.product_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.product_id_seq OWNER TO postgres;

--
-- Name: product_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.product_id_seq OWNED BY public.product.id;


--
-- Name: products_plans; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.products_plans (
    product_id bigint NOT NULL,
    plan_id bigint NOT NULL
);


ALTER TABLE public.products_plans OWNER TO postgres;

--
-- Name: relations_plans; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.relations_plans (
    parent_id integer NOT NULL,
    child_id integer NOT NULL
);


ALTER TABLE public.relations_plans OWNER TO postgres;

--
-- Name: relations_plans_child_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.relations_plans_child_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.relations_plans_child_id_seq OWNER TO postgres;

--
-- Name: relations_plans_child_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.relations_plans_child_id_seq OWNED BY public.relations_plans.child_id;


--
-- Name: relations_plans_parent_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.relations_plans_parent_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.relations_plans_parent_id_seq OWNER TO postgres;

--
-- Name: relations_plans_parent_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.relations_plans_parent_id_seq OWNED BY public.relations_plans.parent_id;


--
-- Name: plan id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.plan ALTER COLUMN id SET DEFAULT nextval('public.plan1_id_seq'::regclass);


--
-- Name: product id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product ALTER COLUMN id SET DEFAULT nextval('public.product_id_seq'::regclass);


--
-- Name: relations_plans parent_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.relations_plans ALTER COLUMN parent_id SET DEFAULT nextval('public.relations_plans_parent_id_seq'::regclass);


--
-- Name: relations_plans child_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.relations_plans ALTER COLUMN child_id SET DEFAULT nextval('public.relations_plans_child_id_seq'::regclass);


--
-- Data for Name: plan; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.plan (id, time_line) FROM stdin;
52	1
53	99
54	2
55	99
56	1
57	1
58	1
59	1
60	1
61	123
62	2
63	123
64	123
65	2
66	123
67	123
68	2
69	123
70	123
71	2
72	123
73	123
74	2
75	123
76	2
77	123
78	123
79	2
80	123
81	123
82	2
83	123
84	123
85	2
86	123
87	1
88	1
89	1
90	123
91	2
92	123
93	123
94	2
95	123
96	123
97	2
98	123
99	123
100	2
101	123
102	123
103	2
104	123
\.


--
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.product (depreciation, price, quantity, total_price, id, parent_id) FROM stdin;
1	1	1	1	21	\N
99	99	99	99	22	\N
1	1	1	1	23	\N
888	888	888	888	24	\N
888	888	888	888	25	\N
123	123	123	123	26	\N
123	123	123	123	27	\N
123	123	123	123	28	\N
123	123	123	123	29	\N
123	123	123	123	30	\N
123	123	123	123	31	\N
123	123	123	123	32	\N
123	123	123	123	33	\N
888	888	888	888	34	\N
123	123	123	123	35	\N
888	888	888	888	36	\N
1	1	1	1	37	\N
888	888	888	888	38	\N
888	888	888	888	39	\N
888	888	888	888	40	\N
888	888	888	888	41	\N
888	888	888	888	42	\N
123	123	123	123	43	\N
123	123	123	123	44	\N
123	123	123	123	45	\N
123	123	123	123	46	\N
1	1	1	1	47	\N
1	1	1	1	48	\N
1	1	1	1	49	\N
888	888	888	888	50	\N
1	1	1	1	51	\N
888	888	888	888	52	\N
1	1	1	1	53	\N
888	888	888	888	54	\N
1	1	1	1	55	\N
888	888	888	888	56	\N
1	1	1	1	57	\N
1	1	1	1	58	\N
888	888	888	888	59	58
1	1	1	1	60	\N
888	888	888	888	61	60
888	888	888	888	62	\N
\.


--
-- Data for Name: products_plans; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.products_plans (product_id, plan_id) FROM stdin;
43	93
44	96
45	99
46	102
22	90
62	90
26	61
27	64
28	67
29	70
30	75
31	78
32	81
21	84
34	84
21	53
25	53
\.


--
-- Data for Name: relations_plans; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.relations_plans (parent_id, child_id) FROM stdin;
84	85
53	52
53	89
93	94
96	97
99	100
102	103
90	91
\.


--
-- Name: plan1_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.plan1_id_seq', 104, true);


--
-- Name: product_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.product_id_seq', 62, true);


--
-- Name: relations_plans_child_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.relations_plans_child_id_seq', 1, false);


--
-- Name: relations_plans_parent_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.relations_plans_parent_id_seq', 1, false);


--
-- Name: plan plan1_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.plan
    ADD CONSTRAINT plan1_pkey PRIMARY KEY (id);


--
-- Name: product product_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);


--
-- Name: products_plans products_plans_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products_plans
    ADD CONSTRAINT products_plans_pk PRIMARY KEY (product_id, plan_id);


--
-- Name: relations_plans relations_plans_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.relations_plans
    ADD CONSTRAINT relations_plans_pk PRIMARY KEY (parent_id, child_id);


--
-- Name: product fkgmb19wbjvpu06559t7w33wqoc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT fkgmb19wbjvpu06559t7w33wqoc FOREIGN KEY (parent_id) REFERENCES public.product(id);


--
-- Name: products_plans products_plans_product_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products_plans
    ADD CONSTRAINT products_plans_product_id_fk FOREIGN KEY (product_id) REFERENCES public.product(id);


--
-- Name: relations_plans relations_plans_plan_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.relations_plans
    ADD CONSTRAINT relations_plans_plan_id_fk FOREIGN KEY (parent_id) REFERENCES public.plan(id);


--
-- Name: relations_plans relations_plans_plan_id_fk_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.relations_plans
    ADD CONSTRAINT relations_plans_plan_id_fk_2 FOREIGN KEY (child_id) REFERENCES public.plan(id);


--
-- PostgreSQL database dump complete
--

