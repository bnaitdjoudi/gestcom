--
-- PostgreSQL database dump
--

-- Dumped from database version 11.7
-- Dumped by pg_dump version 11.2

-- Started on 2020-03-22 23:04:02

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 6 (class 2615 OID 16609)
-- Name: fac1; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA fac1;


ALTER SCHEMA fac1 OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 199 (class 1259 OID 16612)
-- Name: article; Type: TABLE; Schema: fac1; Owner: postgres
--

CREATE TABLE fac1.article (
    type character varying(1),
    reference character varying(20),
    nomarticle character varying(50),
    prixachat numeric(10,2),
    tauxtaxe numeric(10,2),
    unite character varying(10),
    minqte numeric(10,2),
    image character varying(100),
    user_create character varying(25),
    date_maj timestamp with time zone,
    date_create timestamp with time zone DEFAULT now() NOT NULL,
    id bigint NOT NULL,
    idcateg bigint,
    idcompte bigint
);


ALTER TABLE fac1.article OWNER TO postgres;

--
-- TOC entry 3035 (class 0 OID 0)
-- Dependencies: 199
-- Name: COLUMN article.type; Type: COMMENT; Schema: fac1; Owner: postgres
--

COMMENT ON COLUMN fac1.article.type IS 'type d''article : service, produit';


--
-- TOC entry 3036 (class 0 OID 0)
-- Dependencies: 199
-- Name: COLUMN article.reference; Type: COMMENT; Schema: fac1; Owner: postgres
--

COMMENT ON COLUMN fac1.article.reference IS 'référence de l''article représente la numérotation du fournisseur ou  du client
cette numérotation est définit par tiers ';


--
-- TOC entry 3037 (class 0 OID 0)
-- Dependencies: 199
-- Name: COLUMN article.tauxtaxe; Type: COMMENT; Schema: fac1; Owner: postgres
--

COMMENT ON COLUMN fac1.article.tauxtaxe IS 'tauxtaxe : montant de taxe 
exemple: 0.19,0.17,0.09,...
pour affichage on affiche 19%,17%,9%,...';


--
-- TOC entry 3038 (class 0 OID 0)
-- Dependencies: 199
-- Name: COLUMN article.unite; Type: COMMENT; Schema: fac1; Owner: postgres
--

COMMENT ON COLUMN fac1.article.unite IS 'unite: unité de mesure 
ex: heure, kg,m2, km,.....';


--
-- TOC entry 3039 (class 0 OID 0)
-- Dependencies: 199
-- Name: COLUMN article.minqte; Type: COMMENT; Schema: fac1; Owner: postgres
--

COMMENT ON COLUMN fac1.article.minqte IS 'minqte: quantité minimum de l''article
cette quantité est utilisé pour le module Gestion de stock  ';


--
-- TOC entry 3040 (class 0 OID 0)
-- Dependencies: 199
-- Name: COLUMN article.date_maj; Type: COMMENT; Schema: fac1; Owner: postgres
--

COMMENT ON COLUMN fac1.article.date_maj IS 'derniére date de mis a jour';


--
-- TOC entry 220 (class 1259 OID 16975)
-- Name: article_id_seq; Type: SEQUENCE; Schema: fac1; Owner: postgres
--

CREATE SEQUENCE fac1.article_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE fac1.article_id_seq OWNER TO postgres;

--
-- TOC entry 3041 (class 0 OID 0)
-- Dependencies: 220
-- Name: article_id_seq; Type: SEQUENCE OWNED BY; Schema: fac1; Owner: postgres
--

ALTER SEQUENCE fac1.article_id_seq OWNED BY fac1.article.id;


--
-- TOC entry 200 (class 1259 OID 16617)
-- Name: bl; Type: TABLE; Schema: fac1; Owner: postgres
--

CREATE TABLE fac1.bl (
    blnum character varying(8) NOT NULL,
    bldat date,
    iddevis bigint,
    idfacture bigint,
    date_create timestamp with time zone DEFAULT now() NOT NULL,
    date_maj timestamp with time zone,
    user_create character varying(25),
    id bigint NOT NULL,
    idtiers bigint
);


ALTER TABLE fac1.bl OWNER TO postgres;

--
-- TOC entry 3042 (class 0 OID 0)
-- Dependencies: 200
-- Name: COLUMN bl.blnum; Type: COMMENT; Schema: fac1; Owner: postgres
--

COMMENT ON COLUMN fac1.bl.blnum IS 'blnum: numéro du bon de livraison 
ex: 00000/20
pour l''état d''édition 
ça sera : BL00000/20 
';


--
-- TOC entry 3043 (class 0 OID 0)
-- Dependencies: 200
-- Name: COLUMN bl.iddevis; Type: COMMENT; Schema: fac1; Owner: postgres
--

COMMENT ON COLUMN fac1.bl.iddevis IS 'iddevis: le numéro du devis ';


--
-- TOC entry 3044 (class 0 OID 0)
-- Dependencies: 200
-- Name: COLUMN bl.idfacture; Type: COMMENT; Schema: fac1; Owner: postgres
--

COMMENT ON COLUMN fac1.bl.idfacture IS 'idfacture: c''est le numéro de la facture ';


--
-- TOC entry 3045 (class 0 OID 0)
-- Dependencies: 200
-- Name: COLUMN bl.date_create; Type: COMMENT; Schema: fac1; Owner: postgres
--

COMMENT ON COLUMN fac1.bl.date_create IS 'date de creation';


--
-- TOC entry 221 (class 1259 OID 16983)
-- Name: bl_id_seq; Type: SEQUENCE; Schema: fac1; Owner: postgres
--

CREATE SEQUENCE fac1.bl_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE fac1.bl_id_seq OWNER TO postgres;

--
-- TOC entry 3046 (class 0 OID 0)
-- Dependencies: 221
-- Name: bl_id_seq; Type: SEQUENCE OWNED BY; Schema: fac1; Owner: postgres
--

ALTER SEQUENCE fac1.bl_id_seq OWNED BY fac1.bl.id;


--
-- TOC entry 202 (class 1259 OID 16625)
-- Name: detail_bl; Type: TABLE; Schema: fac1; Owner: postgres
--

CREATE TABLE fac1.detail_bl (
    idarticle bigint,
    duree numeric(10,2),
    qte numeric(10,2),
    blid bigint NOT NULL,
    date_create timestamp with time zone DEFAULT now() NOT NULL,
    user_create character varying(25),
    date_maj timestamp with time zone,
    id bigint NOT NULL
);


ALTER TABLE fac1.detail_bl OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 17014)
-- Name: detail_bl_id_seq; Type: SEQUENCE; Schema: fac1; Owner: postgres
--

CREATE SEQUENCE fac1.detail_bl_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE fac1.detail_bl_id_seq OWNER TO postgres;

--
-- TOC entry 3047 (class 0 OID 0)
-- Dependencies: 222
-- Name: detail_bl_id_seq; Type: SEQUENCE OWNED BY; Schema: fac1; Owner: postgres
--

ALTER SEQUENCE fac1.detail_bl_id_seq OWNED BY fac1.detail_bl.id;


--
-- TOC entry 201 (class 1259 OID 16623)
-- Name: detail_bl_seq; Type: SEQUENCE; Schema: fac1; Owner: postgres
--

CREATE SEQUENCE fac1.detail_bl_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE fac1.detail_bl_seq OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16632)
-- Name: detail_devis; Type: TABLE; Schema: fac1; Owner: postgres
--

CREATE TABLE fac1.detail_devis (
    idarticle integer,
    duree numeric(10,2),
    qte numeric(10,2),
    pu numeric(10,2),
    mtn numeric(10,2),
    remise numeric(10,2),
    mtva numeric(10,2),
    mttc numeric(10,2),
    date_create timestamp with time zone DEFAULT now() NOT NULL,
    user_create character varying(25),
    date_maj timestamp with time zone,
    id bigint NOT NULL,
    idttv bigint,
    idtr bigint,
    iddevis bigint
);


ALTER TABLE fac1.detail_devis OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 17022)
-- Name: detail_devis_id_seq; Type: SEQUENCE; Schema: fac1; Owner: postgres
--

CREATE SEQUENCE fac1.detail_devis_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE fac1.detail_devis_id_seq OWNER TO postgres;

--
-- TOC entry 3048 (class 0 OID 0)
-- Dependencies: 223
-- Name: detail_devis_id_seq; Type: SEQUENCE OWNED BY; Schema: fac1; Owner: postgres
--

ALTER SEQUENCE fac1.detail_devis_id_seq OWNED BY fac1.detail_devis.id;


--
-- TOC entry 203 (class 1259 OID 16630)
-- Name: detail_devis_seq; Type: SEQUENCE; Schema: fac1; Owner: postgres
--

CREATE SEQUENCE fac1.detail_devis_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE fac1.detail_devis_seq OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 16639)
-- Name: detail_facture; Type: TABLE; Schema: fac1; Owner: postgres
--

CREATE TABLE fac1.detail_facture (
    idarticle integer,
    duree numeric(10,2),
    qte numeric(10,2),
    pu numeric(10,2),
    mtn numeric(10,2),
    remise numeric(10,2),
    mtva numeric(10,2),
    mttc numeric(10,2),
    idfacture bigint,
    date_create character varying DEFAULT now() NOT NULL,
    user_create character varying(25),
    date_maj timestamp with time zone,
    id bigint NOT NULL,
    idttv bigint,
    idtr bigint
);


ALTER TABLE fac1.detail_facture OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 17030)
-- Name: detail_facture_id_seq; Type: SEQUENCE; Schema: fac1; Owner: postgres
--

CREATE SEQUENCE fac1.detail_facture_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE fac1.detail_facture_id_seq OWNER TO postgres;

--
-- TOC entry 3049 (class 0 OID 0)
-- Dependencies: 224
-- Name: detail_facture_id_seq; Type: SEQUENCE OWNED BY; Schema: fac1; Owner: postgres
--

ALTER SEQUENCE fac1.detail_facture_id_seq OWNED BY fac1.detail_facture.id;


--
-- TOC entry 205 (class 1259 OID 16637)
-- Name: detail_facture_seq; Type: SEQUENCE; Schema: fac1; Owner: postgres
--

CREATE SEQUENCE fac1.detail_facture_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE fac1.detail_facture_seq OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 16647)
-- Name: deviis_seq; Type: SEQUENCE; Schema: fac1; Owner: postgres
--

CREATE SEQUENCE fac1.deviis_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE fac1.deviis_seq OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 16649)
-- Name: devis; Type: TABLE; Schema: fac1; Owner: postgres
--

CREATE TABLE fac1.devis (
    devdat date,
    devmtn numeric(10,2),
    devremise numeric(10,2),
    devtva numeric(10,2),
    devtmb numeric(10,2),
    devttc numeric(10,2),
    mrgcod character varying(2),
    date_create timestamp with time zone DEFAULT now(),
    user_create character varying(25),
    date_maj timestamp with time zone,
    devnum character varying(8),
    id bigint NOT NULL,
    codetiers bigint
);


ALTER TABLE fac1.devis OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 17041)
-- Name: devis_id_seq; Type: SEQUENCE; Schema: fac1; Owner: postgres
--

CREATE SEQUENCE fac1.devis_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE fac1.devis_id_seq OWNER TO postgres;

--
-- TOC entry 3050 (class 0 OID 0)
-- Dependencies: 225
-- Name: devis_id_seq; Type: SEQUENCE OWNED BY; Schema: fac1; Owner: postgres
--

ALTER SEQUENCE fac1.devis_id_seq OWNED BY fac1.devis.id;


--
-- TOC entry 210 (class 1259 OID 16656)
-- Name: facture; Type: TABLE; Schema: fac1; Owner: postgres
--

CREATE TABLE fac1.facture (
    factdat date,
    factmtn numeric(10,2),
    factremise numeric(10,2),
    facttva numeric(10,2),
    facttmb numeric(10,2),
    factttc numeric(10,2),
    mrgcod character varying(2),
    date_create timestamp with time zone DEFAULT now() NOT NULL,
    user_create character varying(25),
    date_maj timestamp with time zone,
    id bigint NOT NULL,
    codetiers bigint,
    facnum character varying(8)
);


ALTER TABLE fac1.facture OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 17050)
-- Name: facture_id_seq; Type: SEQUENCE; Schema: fac1; Owner: postgres
--

CREATE SEQUENCE fac1.facture_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE fac1.facture_id_seq OWNER TO postgres;

--
-- TOC entry 3051 (class 0 OID 0)
-- Dependencies: 226
-- Name: facture_id_seq; Type: SEQUENCE OWNED BY; Schema: fac1; Owner: postgres
--

ALTER SEQUENCE fac1.facture_id_seq OWNED BY fac1.facture.id;


--
-- TOC entry 209 (class 1259 OID 16654)
-- Name: facture_seq; Type: SEQUENCE; Schema: fac1; Owner: postgres
--

CREATE SEQUENCE fac1.facture_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE fac1.facture_seq OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 16661)
-- Name: infotrs; Type: TABLE; Schema: fac1; Owner: postgres
--

CREATE TABLE fac1.infotrs (
    paycod character varying(6) NOT NULL,
    trsadr character varying(80),
    trsvil character varying(80),
    trstel character varying(20),
    trsfax character varying(20),
    trsweb character varying(80),
    trseml character varying(80),
    trsbnq character varying(80),
    dateinfo date,
    id bigint NOT NULL,
    codetiers bigint,
    date_maj timestamp with time zone,
    date_create timestamp with time zone,
    user_create character varying(25)
);


ALTER TABLE fac1.infotrs OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 17058)
-- Name: infotrs_id_seq; Type: SEQUENCE; Schema: fac1; Owner: postgres
--

CREATE SEQUENCE fac1.infotrs_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE fac1.infotrs_id_seq OWNER TO postgres;

--
-- TOC entry 3052 (class 0 OID 0)
-- Dependencies: 227
-- Name: infotrs_id_seq; Type: SEQUENCE OWNED BY; Schema: fac1; Owner: postgres
--

ALTER SEQUENCE fac1.infotrs_id_seq OWNED BY fac1.infotrs.id;


--
-- TOC entry 212 (class 1259 OID 16664)
-- Name: prix_article; Type: TABLE; Schema: fac1; Owner: postgres
--

CREATE TABLE fac1.prix_article (
    prix numeric(20,2),
    idarticle bigint,
    date_prix timestamp with time zone DEFAULT now(),
    active boolean DEFAULT true,
    id bigint NOT NULL,
    date_create timestamp with time zone,
    user_create character varying(25),
    date_maj timestamp with time zone
);


ALTER TABLE fac1.prix_article OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 17066)
-- Name: prix_article_id_seq; Type: SEQUENCE; Schema: fac1; Owner: postgres
--

CREATE SEQUENCE fac1.prix_article_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE fac1.prix_article_id_seq OWNER TO postgres;

--
-- TOC entry 3053 (class 0 OID 0)
-- Dependencies: 228
-- Name: prix_article_id_seq; Type: SEQUENCE OWNED BY; Schema: fac1; Owner: postgres
--

ALTER SEQUENCE fac1.prix_article_id_seq OWNED BY fac1.prix_article.id;


--
-- TOC entry 213 (class 1259 OID 16671)
-- Name: ref_categ_tiers; Type: TABLE; Schema: fac1; Owner: postgres
--

CREATE TABLE fac1.ref_categ_tiers (
    libelle character varying(20),
    id bigint NOT NULL,
    user_create character varying(25),
    date_create timestamp with time zone,
    date_maj timestamp with time zone
);


ALTER TABLE fac1.ref_categ_tiers OWNER TO postgres;

--
-- TOC entry 229 (class 1259 OID 17074)
-- Name: ref_categ_tiers_id_seq; Type: SEQUENCE; Schema: fac1; Owner: postgres
--

CREATE SEQUENCE fac1.ref_categ_tiers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE fac1.ref_categ_tiers_id_seq OWNER TO postgres;

--
-- TOC entry 3054 (class 0 OID 0)
-- Dependencies: 229
-- Name: ref_categ_tiers_id_seq; Type: SEQUENCE OWNED BY; Schema: fac1; Owner: postgres
--

ALTER SEQUENCE fac1.ref_categ_tiers_id_seq OWNED BY fac1.ref_categ_tiers.id;


--
-- TOC entry 214 (class 1259 OID 16674)
-- Name: ref_categorie; Type: TABLE; Schema: fac1; Owner: postgres
--

CREATE TABLE fac1.ref_categorie (
    libelle character varying(50),
    id bigint NOT NULL,
    date_create timestamp with time zone,
    date_maj timestamp with time zone,
    user_create character varying(25)
);


ALTER TABLE fac1.ref_categorie OWNER TO postgres;

--
-- TOC entry 230 (class 1259 OID 17082)
-- Name: ref_categorie_id_seq; Type: SEQUENCE; Schema: fac1; Owner: postgres
--

CREATE SEQUENCE fac1.ref_categorie_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE fac1.ref_categorie_id_seq OWNER TO postgres;

--
-- TOC entry 3055 (class 0 OID 0)
-- Dependencies: 230
-- Name: ref_categorie_id_seq; Type: SEQUENCE OWNED BY; Schema: fac1; Owner: postgres
--

ALTER SEQUENCE fac1.ref_categorie_id_seq OWNED BY fac1.ref_categorie.id;


--
-- TOC entry 215 (class 1259 OID 16677)
-- Name: ref_compte; Type: TABLE; Schema: fac1; Owner: postgres
--

CREATE TABLE fac1.ref_compte (
    scfcod character varying(6) NOT NULL,
    libelle character varying(50),
    datecmp date,
    id bigint NOT NULL,
    user_create character varying(25),
    date_create timestamp with time zone,
    date_maj character varying(25)
);


ALTER TABLE fac1.ref_compte OWNER TO postgres;

--
-- TOC entry 231 (class 1259 OID 17090)
-- Name: ref_compte_id_seq; Type: SEQUENCE; Schema: fac1; Owner: postgres
--

CREATE SEQUENCE fac1.ref_compte_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE fac1.ref_compte_id_seq OWNER TO postgres;

--
-- TOC entry 3056 (class 0 OID 0)
-- Dependencies: 231
-- Name: ref_compte_id_seq; Type: SEQUENCE OWNED BY; Schema: fac1; Owner: postgres
--

ALTER SEQUENCE fac1.ref_compte_id_seq OWNED BY fac1.ref_compte.id;


--
-- TOC entry 216 (class 1259 OID 16680)
-- Name: ref_type_taux; Type: TABLE; Schema: fac1; Owner: postgres
--

CREATE TABLE fac1.ref_type_taux (
    libelle character varying(20),
    id bigint NOT NULL,
    date_maj timestamp with time zone,
    user_create character varying(25),
    date_create timestamp with time zone
);


ALTER TABLE fac1.ref_type_taux OWNER TO postgres;

--
-- TOC entry 232 (class 1259 OID 17098)
-- Name: ref_type_taux_id_seq; Type: SEQUENCE; Schema: fac1; Owner: postgres
--

CREATE SEQUENCE fac1.ref_type_taux_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE fac1.ref_type_taux_id_seq OWNER TO postgres;

--
-- TOC entry 3057 (class 0 OID 0)
-- Dependencies: 232
-- Name: ref_type_taux_id_seq; Type: SEQUENCE OWNED BY; Schema: fac1; Owner: postgres
--

ALTER SEQUENCE fac1.ref_type_taux_id_seq OWNED BY fac1.ref_type_taux.id;


--
-- TOC entry 217 (class 1259 OID 16683)
-- Name: ref_type_tiers; Type: TABLE; Schema: fac1; Owner: postgres
--

CREATE TABLE fac1.ref_type_tiers (
    tirlib character varying(40),
    id bigint NOT NULL,
    date_create timestamp with time zone,
    date_maj timestamp with time zone,
    user_create character varying(25)
);


ALTER TABLE fac1.ref_type_tiers OWNER TO postgres;

--
-- TOC entry 233 (class 1259 OID 17106)
-- Name: ref_type_tiers_id_seq; Type: SEQUENCE; Schema: fac1; Owner: postgres
--

CREATE SEQUENCE fac1.ref_type_tiers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE fac1.ref_type_tiers_id_seq OWNER TO postgres;

--
-- TOC entry 3058 (class 0 OID 0)
-- Dependencies: 233
-- Name: ref_type_tiers_id_seq; Type: SEQUENCE OWNED BY; Schema: fac1; Owner: postgres
--

ALTER SEQUENCE fac1.ref_type_tiers_id_seq OWNED BY fac1.ref_type_tiers.id;


--
-- TOC entry 198 (class 1259 OID 16610)
-- Name: sequence_article; Type: SEQUENCE; Schema: fac1; Owner: postgres
--

CREATE SEQUENCE fac1.sequence_article
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE fac1.sequence_article OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16686)
-- Name: taux; Type: TABLE; Schema: fac1; Owner: postgres
--

CREATE TABLE fac1.taux (
    libelle character varying(20),
    mtntaxe numeric(10,2),
    id bigint NOT NULL,
    idttaux bigint,
    date_create timestamp with time zone,
    date_maj timestamp with time zone,
    user_create character varying(25)
);


ALTER TABLE fac1.taux OWNER TO postgres;

--
-- TOC entry 235 (class 1259 OID 17122)
-- Name: taux_id_seq; Type: SEQUENCE; Schema: fac1; Owner: postgres
--

CREATE SEQUENCE fac1.taux_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE fac1.taux_id_seq OWNER TO postgres;

--
-- TOC entry 3059 (class 0 OID 0)
-- Dependencies: 235
-- Name: taux_id_seq; Type: SEQUENCE OWNED BY; Schema: fac1; Owner: postgres
--

ALTER SEQUENCE fac1.taux_id_seq OWNED BY fac1.taux.id;


--
-- TOC entry 219 (class 1259 OID 16689)
-- Name: tiers; Type: TABLE; Schema: fac1; Owner: postgres
--

CREATE TABLE fac1.tiers (
    trscod character varying(6) NOT NULL,
    trsnom character varying(80),
    trsnif character varying(20),
    trsnis integer,
    trsrc character varying(20),
    idcatiers bigint,
    date_create timestamp with time zone DEFAULT now() NOT NULL,
    user_create character varying(25),
    date_maj timestamp with time zone,
    id bigint NOT NULL,
    idtyptiers bigint,
    idcompte bigint
);


ALTER TABLE fac1.tiers OWNER TO postgres;

--
-- TOC entry 234 (class 1259 OID 17114)
-- Name: tiers_id_seq; Type: SEQUENCE; Schema: fac1; Owner: postgres
--

CREATE SEQUENCE fac1.tiers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE fac1.tiers_id_seq OWNER TO postgres;

--
-- TOC entry 3060 (class 0 OID 0)
-- Dependencies: 234
-- Name: tiers_id_seq; Type: SEQUENCE OWNED BY; Schema: fac1; Owner: postgres
--

ALTER SEQUENCE fac1.tiers_id_seq OWNED BY fac1.tiers.id;


--
-- TOC entry 2792 (class 2604 OID 16977)
-- Name: article id; Type: DEFAULT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.article ALTER COLUMN id SET DEFAULT nextval('fac1.article_id_seq'::regclass);


--
-- TOC entry 2794 (class 2604 OID 16985)
-- Name: bl id; Type: DEFAULT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.bl ALTER COLUMN id SET DEFAULT nextval('fac1.bl_id_seq'::regclass);


--
-- TOC entry 2796 (class 2604 OID 17016)
-- Name: detail_bl id; Type: DEFAULT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.detail_bl ALTER COLUMN id SET DEFAULT nextval('fac1.detail_bl_id_seq'::regclass);


--
-- TOC entry 2798 (class 2604 OID 17024)
-- Name: detail_devis id; Type: DEFAULT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.detail_devis ALTER COLUMN id SET DEFAULT nextval('fac1.detail_devis_id_seq'::regclass);


--
-- TOC entry 2800 (class 2604 OID 17032)
-- Name: detail_facture id; Type: DEFAULT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.detail_facture ALTER COLUMN id SET DEFAULT nextval('fac1.detail_facture_id_seq'::regclass);


--
-- TOC entry 2802 (class 2604 OID 17043)
-- Name: devis id; Type: DEFAULT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.devis ALTER COLUMN id SET DEFAULT nextval('fac1.devis_id_seq'::regclass);


--
-- TOC entry 2804 (class 2604 OID 17052)
-- Name: facture id; Type: DEFAULT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.facture ALTER COLUMN id SET DEFAULT nextval('fac1.facture_id_seq'::regclass);


--
-- TOC entry 2805 (class 2604 OID 17060)
-- Name: infotrs id; Type: DEFAULT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.infotrs ALTER COLUMN id SET DEFAULT nextval('fac1.infotrs_id_seq'::regclass);


--
-- TOC entry 2808 (class 2604 OID 17068)
-- Name: prix_article id; Type: DEFAULT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.prix_article ALTER COLUMN id SET DEFAULT nextval('fac1.prix_article_id_seq'::regclass);


--
-- TOC entry 2809 (class 2604 OID 17076)
-- Name: ref_categ_tiers id; Type: DEFAULT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.ref_categ_tiers ALTER COLUMN id SET DEFAULT nextval('fac1.ref_categ_tiers_id_seq'::regclass);


--
-- TOC entry 2810 (class 2604 OID 17084)
-- Name: ref_categorie id; Type: DEFAULT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.ref_categorie ALTER COLUMN id SET DEFAULT nextval('fac1.ref_categorie_id_seq'::regclass);


--
-- TOC entry 2811 (class 2604 OID 17092)
-- Name: ref_compte id; Type: DEFAULT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.ref_compte ALTER COLUMN id SET DEFAULT nextval('fac1.ref_compte_id_seq'::regclass);


--
-- TOC entry 2812 (class 2604 OID 17100)
-- Name: ref_type_taux id; Type: DEFAULT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.ref_type_taux ALTER COLUMN id SET DEFAULT nextval('fac1.ref_type_taux_id_seq'::regclass);


--
-- TOC entry 2813 (class 2604 OID 17108)
-- Name: ref_type_tiers id; Type: DEFAULT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.ref_type_tiers ALTER COLUMN id SET DEFAULT nextval('fac1.ref_type_tiers_id_seq'::regclass);


--
-- TOC entry 2814 (class 2604 OID 17124)
-- Name: taux id; Type: DEFAULT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.taux ALTER COLUMN id SET DEFAULT nextval('fac1.taux_id_seq'::regclass);


--
-- TOC entry 2816 (class 2604 OID 17116)
-- Name: tiers id; Type: DEFAULT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.tiers ALTER COLUMN id SET DEFAULT nextval('fac1.tiers_id_seq'::regclass);


--
-- TOC entry 2993 (class 0 OID 16612)
-- Dependencies: 199
-- Data for Name: article; Type: TABLE DATA; Schema: fac1; Owner: postgres
--

INSERT INTO fac1.article VALUES ('P', 'P00001', 'viande du mouton', 800.00, 0.09, 'KG', 50.00, 'c:/viande.jpg', 'kamel', '2020-03-21 00:00:00+01', '2020-03-21 00:00:00+01', 1, 1, 4);


--
-- TOC entry 2994 (class 0 OID 16617)
-- Dependencies: 200
-- Data for Name: bl; Type: TABLE DATA; Schema: fac1; Owner: postgres
--

INSERT INTO fac1.bl VALUES ('B0001/20', '2020-03-22', 1, 1, '2020-03-22 00:00:00+01', '2020-03-22 00:00:00+01', 'kamel', 1, 1);


--
-- TOC entry 2996 (class 0 OID 16625)
-- Dependencies: 202
-- Data for Name: detail_bl; Type: TABLE DATA; Schema: fac1; Owner: postgres
--

INSERT INTO fac1.detail_bl VALUES (1, NULL, 10.00, 1, '2020-03-22 00:00:00+01', 'kamel', '2020-03-22 00:00:00+01', 1);


--
-- TOC entry 2998 (class 0 OID 16632)
-- Dependencies: 204
-- Data for Name: detail_devis; Type: TABLE DATA; Schema: fac1; Owner: postgres
--

INSERT INTO fac1.detail_devis VALUES (1, NULL, 10.00, 1200.00, 12000.00, 600.00, 1026.00, 12426.00, '2020-03-22 00:00:00+01', 'kamel', '2020-03-22 00:00:00+01', 1, 2, 4, 1);


--
-- TOC entry 3000 (class 0 OID 16639)
-- Dependencies: 206
-- Data for Name: detail_facture; Type: TABLE DATA; Schema: fac1; Owner: postgres
--

INSERT INTO fac1.detail_facture VALUES (1, NULL, 10.00, 1200.00, 12000.00, 600.00, 1026.00, 12426.00, 1, '22/03/20
', 'kamel', '2020-03-22 00:00:00+01', 1, 2, NULL);


--
-- TOC entry 3002 (class 0 OID 16649)
-- Dependencies: 208
-- Data for Name: devis; Type: TABLE DATA; Schema: fac1; Owner: postgres
--

INSERT INTO fac1.devis VALUES ('2020-03-22', 12000.00, 600.00, 1026.00, 20.00, 13100.00, 'EP', '2020-03-22 00:00:00+01', 'kamel', '2020-03-22 00:00:00+01', 'D0001/20', 1, 1);


--
-- TOC entry 3004 (class 0 OID 16656)
-- Dependencies: 210
-- Data for Name: facture; Type: TABLE DATA; Schema: fac1; Owner: postgres
--

INSERT INTO fac1.facture VALUES ('2020-03-22', 12000.00, 600.00, 1026.00, 20.00, 12446.00, 'EP', '2020-03-22 00:00:00+01', '22/03/20

', '2020-03-22 00:00:00+01', 1, 1, 'F0001/20');


--
-- TOC entry 3005 (class 0 OID 16661)
-- Dependencies: 211
-- Data for Name: infotrs; Type: TABLE DATA; Schema: fac1; Owner: postgres
--

INSERT INTO fac1.infotrs VALUES ('ALG', 'alger algérie', 'alger', '021458965', '021458965', 'www.epal.dz', 'epal@gmail.com', 'cpa', '2020-03-21', 1, 1, '2020-03-21 00:00:00+01', '2020-03-21 00:00:00+01', 'kamel');


--
-- TOC entry 3006 (class 0 OID 16664)
-- Dependencies: 212
-- Data for Name: prix_article; Type: TABLE DATA; Schema: fac1; Owner: postgres
--

INSERT INTO fac1.prix_article VALUES (1200.00, 1, '2020-03-21 00:00:00+01', true, 1, '2020-03-21 00:00:00+01', 'kamel', '2020-03-21 00:00:00+01');


--
-- TOC entry 3007 (class 0 OID 16671)
-- Dependencies: 213
-- Data for Name: ref_categ_tiers; Type: TABLE DATA; Schema: fac1; Owner: postgres
--

INSERT INTO fac1.ref_categ_tiers VALUES ('Client', 1, 'kamel', '2020-03-21 00:00:00+01', '2020-03-21 00:00:00+01');
INSERT INTO fac1.ref_categ_tiers VALUES ('Fournisseur', 2, 'kamel', '2020-03-21 00:00:00+01', '2020-03-21 00:00:00+01');
INSERT INTO fac1.ref_categ_tiers VALUES ('Salarié', 3, 'kamel', '2020-03-21 00:00:00+01', '2020-03-21 00:00:00+01');


--
-- TOC entry 3008 (class 0 OID 16674)
-- Dependencies: 214
-- Data for Name: ref_categorie; Type: TABLE DATA; Schema: fac1; Owner: postgres
--

INSERT INTO fac1.ref_categorie VALUES ('Produits alimentaires', 1, '2020-03-21 00:00:00+01', '2020-03-21 00:00:00+01', 'kamel');
INSERT INTO fac1.ref_categorie VALUES ('Produits pharmaceutiques', 2, '2020-03-21 00:00:00+01', '2020-03-21 00:00:00+01', 'kamel');
INSERT INTO fac1.ref_categorie VALUES ('Produits nettoyages', 3, '2020-03-21 00:00:00+01', '2020-03-21 00:00:00+01', 'kamel');
INSERT INTO fac1.ref_categorie VALUES ('Service de transport', 4, '2020-03-21 00:00:00+01', '2020-03-21 00:00:00+01', 'kamel');


--
-- TOC entry 3009 (class 0 OID 16677)
-- Dependencies: 215
-- Data for Name: ref_compte; Type: TABLE DATA; Schema: fac1; Owner: postgres
--

INSERT INTO fac1.ref_compte VALUES ('411000', 'Client à terme', '2020-03-21', 1, 'kamel', '2020-03-21 00:00:00+01', '21/03/2020');
INSERT INTO fac1.ref_compte VALUES ('411010', 'Client comptant chèque', '2020-03-21', 2, 'kamel', '2020-03-21 00:00:00+01', '21/03/2020');
INSERT INTO fac1.ref_compte VALUES ('411011', 'Client comptant espèce', '2020-03-21', 3, 'kamel', '2020-03-21 00:00:00+01', '21/03/2020');
INSERT INTO fac1.ref_compte VALUES ('711000', 'produit', '2020-03-21', 4, 'kamel', '2020-03-21 00:00:00+01', '21/03/2020');
INSERT INTO fac1.ref_compte VALUES ('712000', 'pestation', '2020-03-21', 5, 'kamel', '2020-03-21 00:00:00+01', '21/03/2020');


--
-- TOC entry 3010 (class 0 OID 16680)
-- Dependencies: 216
-- Data for Name: ref_type_taux; Type: TABLE DATA; Schema: fac1; Owner: postgres
--

INSERT INTO fac1.ref_type_taux VALUES ('Taxe TVA', 1, '2020-03-21 00:00:00+01', 'kamel', '2020-03-21 00:00:00+01');
INSERT INTO fac1.ref_type_taux VALUES ('Réduction', 2, '2020-03-21 00:00:00+01', 'kamel', '2020-03-21 00:00:00+01');


--
-- TOC entry 3011 (class 0 OID 16683)
-- Dependencies: 217
-- Data for Name: ref_type_tiers; Type: TABLE DATA; Schema: fac1; Owner: postgres
--

INSERT INTO fac1.ref_type_tiers VALUES ('Professionnel', 1, '2020-03-21 00:00:00+01', '2020-03-21 00:00:00+01', 'kamel');
INSERT INTO fac1.ref_type_tiers VALUES ('Particulier', 2, '2020-03-21 00:00:00+01', '2020-03-21 00:00:00+01', 'kamel');


--
-- TOC entry 3012 (class 0 OID 16686)
-- Dependencies: 218
-- Data for Name: taux; Type: TABLE DATA; Schema: fac1; Owner: postgres
--

INSERT INTO fac1.taux VALUES ('TVA 19%', 0.19, 1, 1, '2020-03-21 00:00:00+01', '2020-03-21 00:00:00+01', 'kamel');
INSERT INTO fac1.taux VALUES ('TVA 9%', 0.09, 2, 1, '2020-03-21 00:00:00+01', '2020-03-21 00:00:00+01', 'kamel');
INSERT INTO fac1.taux VALUES ('TVA 0%', 0.00, 3, 1, '2020-03-21 00:00:00+01', '2020-03-21 00:00:00+01', 'kamel');
INSERT INTO fac1.taux VALUES ('Réduction 5%', 0.05, 4, 2, '2020-03-21 00:00:00+01', '2020-03-21 00:00:00+01', 'kamel');


--
-- TOC entry 3013 (class 0 OID 16689)
-- Dependencies: 219
-- Data for Name: tiers; Type: TABLE DATA; Schema: fac1; Owner: postgres
--

INSERT INTO fac1.tiers VALUES ('C00001', 'EPAL TRANS', '210000d212', 2123654568, 'a1254566666', 1, '2020-03-21 00:00:00+01', 'kamel', '2020-03-21 00:00:00+01', 1, 1, 1);


--
-- TOC entry 3061 (class 0 OID 0)
-- Dependencies: 220
-- Name: article_id_seq; Type: SEQUENCE SET; Schema: fac1; Owner: postgres
--

SELECT pg_catalog.setval('fac1.article_id_seq', 1, true);


--
-- TOC entry 3062 (class 0 OID 0)
-- Dependencies: 221
-- Name: bl_id_seq; Type: SEQUENCE SET; Schema: fac1; Owner: postgres
--

SELECT pg_catalog.setval('fac1.bl_id_seq', 1, true);


--
-- TOC entry 3063 (class 0 OID 0)
-- Dependencies: 222
-- Name: detail_bl_id_seq; Type: SEQUENCE SET; Schema: fac1; Owner: postgres
--

SELECT pg_catalog.setval('fac1.detail_bl_id_seq', 1, true);


--
-- TOC entry 3064 (class 0 OID 0)
-- Dependencies: 201
-- Name: detail_bl_seq; Type: SEQUENCE SET; Schema: fac1; Owner: postgres
--

SELECT pg_catalog.setval('fac1.detail_bl_seq', 1, false);


--
-- TOC entry 3065 (class 0 OID 0)
-- Dependencies: 223
-- Name: detail_devis_id_seq; Type: SEQUENCE SET; Schema: fac1; Owner: postgres
--

SELECT pg_catalog.setval('fac1.detail_devis_id_seq', 4, true);


--
-- TOC entry 3066 (class 0 OID 0)
-- Dependencies: 203
-- Name: detail_devis_seq; Type: SEQUENCE SET; Schema: fac1; Owner: postgres
--

SELECT pg_catalog.setval('fac1.detail_devis_seq', 1, false);


--
-- TOC entry 3067 (class 0 OID 0)
-- Dependencies: 224
-- Name: detail_facture_id_seq; Type: SEQUENCE SET; Schema: fac1; Owner: postgres
--

SELECT pg_catalog.setval('fac1.detail_facture_id_seq', 1, true);


--
-- TOC entry 3068 (class 0 OID 0)
-- Dependencies: 205
-- Name: detail_facture_seq; Type: SEQUENCE SET; Schema: fac1; Owner: postgres
--

SELECT pg_catalog.setval('fac1.detail_facture_seq', 1, false);


--
-- TOC entry 3069 (class 0 OID 0)
-- Dependencies: 207
-- Name: deviis_seq; Type: SEQUENCE SET; Schema: fac1; Owner: postgres
--

SELECT pg_catalog.setval('fac1.deviis_seq', 1, false);


--
-- TOC entry 3070 (class 0 OID 0)
-- Dependencies: 225
-- Name: devis_id_seq; Type: SEQUENCE SET; Schema: fac1; Owner: postgres
--

SELECT pg_catalog.setval('fac1.devis_id_seq', 1, true);


--
-- TOC entry 3071 (class 0 OID 0)
-- Dependencies: 226
-- Name: facture_id_seq; Type: SEQUENCE SET; Schema: fac1; Owner: postgres
--

SELECT pg_catalog.setval('fac1.facture_id_seq', 1, true);


--
-- TOC entry 3072 (class 0 OID 0)
-- Dependencies: 209
-- Name: facture_seq; Type: SEQUENCE SET; Schema: fac1; Owner: postgres
--

SELECT pg_catalog.setval('fac1.facture_seq', 1, false);


--
-- TOC entry 3073 (class 0 OID 0)
-- Dependencies: 227
-- Name: infotrs_id_seq; Type: SEQUENCE SET; Schema: fac1; Owner: postgres
--

SELECT pg_catalog.setval('fac1.infotrs_id_seq', 1, true);


--
-- TOC entry 3074 (class 0 OID 0)
-- Dependencies: 228
-- Name: prix_article_id_seq; Type: SEQUENCE SET; Schema: fac1; Owner: postgres
--

SELECT pg_catalog.setval('fac1.prix_article_id_seq', 1, true);


--
-- TOC entry 3075 (class 0 OID 0)
-- Dependencies: 229
-- Name: ref_categ_tiers_id_seq; Type: SEQUENCE SET; Schema: fac1; Owner: postgres
--

SELECT pg_catalog.setval('fac1.ref_categ_tiers_id_seq', 3, true);


--
-- TOC entry 3076 (class 0 OID 0)
-- Dependencies: 230
-- Name: ref_categorie_id_seq; Type: SEQUENCE SET; Schema: fac1; Owner: postgres
--

SELECT pg_catalog.setval('fac1.ref_categorie_id_seq', 4, true);


--
-- TOC entry 3077 (class 0 OID 0)
-- Dependencies: 231
-- Name: ref_compte_id_seq; Type: SEQUENCE SET; Schema: fac1; Owner: postgres
--

SELECT pg_catalog.setval('fac1.ref_compte_id_seq', 5, true);


--
-- TOC entry 3078 (class 0 OID 0)
-- Dependencies: 232
-- Name: ref_type_taux_id_seq; Type: SEQUENCE SET; Schema: fac1; Owner: postgres
--

SELECT pg_catalog.setval('fac1.ref_type_taux_id_seq', 2, true);


--
-- TOC entry 3079 (class 0 OID 0)
-- Dependencies: 233
-- Name: ref_type_tiers_id_seq; Type: SEQUENCE SET; Schema: fac1; Owner: postgres
--

SELECT pg_catalog.setval('fac1.ref_type_tiers_id_seq', 2, true);


--
-- TOC entry 3080 (class 0 OID 0)
-- Dependencies: 198
-- Name: sequence_article; Type: SEQUENCE SET; Schema: fac1; Owner: postgres
--

SELECT pg_catalog.setval('fac1.sequence_article', 5, true);


--
-- TOC entry 3081 (class 0 OID 0)
-- Dependencies: 235
-- Name: taux_id_seq; Type: SEQUENCE SET; Schema: fac1; Owner: postgres
--

SELECT pg_catalog.setval('fac1.taux_id_seq', 4, true);


--
-- TOC entry 3082 (class 0 OID 0)
-- Dependencies: 234
-- Name: tiers_id_seq; Type: SEQUENCE SET; Schema: fac1; Owner: postgres
--

SELECT pg_catalog.setval('fac1.tiers_id_seq', 1, true);


--
-- TOC entry 2818 (class 2606 OID 16982)
-- Name: article article_pkey; Type: CONSTRAINT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.article
    ADD CONSTRAINT article_pkey PRIMARY KEY (id);


--
-- TOC entry 2820 (class 2606 OID 16990)
-- Name: bl bl_pkey; Type: CONSTRAINT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.bl
    ADD CONSTRAINT bl_pkey PRIMARY KEY (id);


--
-- TOC entry 2822 (class 2606 OID 17021)
-- Name: detail_bl detailbl_pkey; Type: CONSTRAINT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.detail_bl
    ADD CONSTRAINT detailbl_pkey PRIMARY KEY (id);


--
-- TOC entry 2824 (class 2606 OID 17029)
-- Name: detail_devis detaildevis_pkey; Type: CONSTRAINT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.detail_devis
    ADD CONSTRAINT detaildevis_pkey PRIMARY KEY (id);


--
-- TOC entry 2826 (class 2606 OID 17040)
-- Name: detail_facture detailfact_pkey; Type: CONSTRAINT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.detail_facture
    ADD CONSTRAINT detailfact_pkey PRIMARY KEY (id);


--
-- TOC entry 2828 (class 2606 OID 17048)
-- Name: devis devis_pkey; Type: CONSTRAINT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.devis
    ADD CONSTRAINT devis_pkey PRIMARY KEY (id);


--
-- TOC entry 2830 (class 2606 OID 17057)
-- Name: facture facture_pkey; Type: CONSTRAINT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.facture
    ADD CONSTRAINT facture_pkey PRIMARY KEY (id);


--
-- TOC entry 2832 (class 2606 OID 17065)
-- Name: infotrs infotrs_pkey; Type: CONSTRAINT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.infotrs
    ADD CONSTRAINT infotrs_pkey PRIMARY KEY (id);


--
-- TOC entry 2834 (class 2606 OID 17073)
-- Name: prix_article prixarticle_pkey; Type: CONSTRAINT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.prix_article
    ADD CONSTRAINT prixarticle_pkey PRIMARY KEY (id);


--
-- TOC entry 2838 (class 2606 OID 17089)
-- Name: ref_categorie ref_categorie_pkey; Type: CONSTRAINT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.ref_categorie
    ADD CONSTRAINT ref_categorie_pkey PRIMARY KEY (id);


--
-- TOC entry 2836 (class 2606 OID 17081)
-- Name: ref_categ_tiers refcategtiers_pkey; Type: CONSTRAINT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.ref_categ_tiers
    ADD CONSTRAINT refcategtiers_pkey PRIMARY KEY (id);


--
-- TOC entry 2840 (class 2606 OID 17097)
-- Name: ref_compte refcompte_pkey; Type: CONSTRAINT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.ref_compte
    ADD CONSTRAINT refcompte_pkey PRIMARY KEY (id);


--
-- TOC entry 2842 (class 2606 OID 17105)
-- Name: ref_type_taux reftypetaux_pkey; Type: CONSTRAINT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.ref_type_taux
    ADD CONSTRAINT reftypetaux_pkey PRIMARY KEY (id);


--
-- TOC entry 2844 (class 2606 OID 17113)
-- Name: ref_type_tiers reftypetiers_pkey; Type: CONSTRAINT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.ref_type_tiers
    ADD CONSTRAINT reftypetiers_pkey PRIMARY KEY (id);


--
-- TOC entry 2846 (class 2606 OID 17129)
-- Name: taux taux_pkey; Type: CONSTRAINT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.taux
    ADD CONSTRAINT taux_pkey PRIMARY KEY (id);


--
-- TOC entry 2848 (class 2606 OID 17121)
-- Name: tiers tiers_pkey; Type: CONSTRAINT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.tiers
    ADD CONSTRAINT tiers_pkey PRIMARY KEY (id);


--
-- TOC entry 2849 (class 2606 OID 17131)
-- Name: article article1_fk; Type: FK CONSTRAINT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.article
    ADD CONSTRAINT article1_fk FOREIGN KEY (idcateg) REFERENCES fac1.ref_categorie(id) MATCH FULL;


--
-- TOC entry 2850 (class 2606 OID 17136)
-- Name: article article2_fk; Type: FK CONSTRAINT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.article
    ADD CONSTRAINT article2_fk FOREIGN KEY (idcompte) REFERENCES fac1.ref_compte(id) MATCH FULL;


--
-- TOC entry 2851 (class 2606 OID 17288)
-- Name: bl bl_fk1; Type: FK CONSTRAINT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.bl
    ADD CONSTRAINT bl_fk1 FOREIGN KEY (iddevis) REFERENCES fac1.devis(id) MATCH FULL;


--
-- TOC entry 2852 (class 2606 OID 17293)
-- Name: bl bl_fk2; Type: FK CONSTRAINT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.bl
    ADD CONSTRAINT bl_fk2 FOREIGN KEY (idfacture) REFERENCES fac1.facture(id) MATCH FULL;


--
-- TOC entry 2853 (class 2606 OID 17265)
-- Name: detail_bl detailbl_fk1; Type: FK CONSTRAINT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.detail_bl
    ADD CONSTRAINT detailbl_fk1 FOREIGN KEY (idarticle) REFERENCES fac1.article(id) MATCH FULL;


--
-- TOC entry 2854 (class 2606 OID 17275)
-- Name: detail_bl detailbl_fk2; Type: FK CONSTRAINT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.detail_bl
    ADD CONSTRAINT detailbl_fk2 FOREIGN KEY (blid) REFERENCES fac1.bl(id) MATCH FULL;


--
-- TOC entry 2855 (class 2606 OID 17237)
-- Name: detail_devis detaildevis_fk1; Type: FK CONSTRAINT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.detail_devis
    ADD CONSTRAINT detaildevis_fk1 FOREIGN KEY (idarticle) REFERENCES fac1.article(id) MATCH FULL;


--
-- TOC entry 2856 (class 2606 OID 17242)
-- Name: detail_devis detaildevis_fk2; Type: FK CONSTRAINT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.detail_devis
    ADD CONSTRAINT detaildevis_fk2 FOREIGN KEY (idttv) REFERENCES fac1.taux(id) MATCH FULL;


--
-- TOC entry 2857 (class 2606 OID 17247)
-- Name: detail_devis detaildevis_fk3; Type: FK CONSTRAINT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.detail_devis
    ADD CONSTRAINT detaildevis_fk3 FOREIGN KEY (idtr) REFERENCES fac1.taux(id) MATCH FULL;


--
-- TOC entry 2858 (class 2606 OID 17252)
-- Name: detail_devis detaildevis_fk4; Type: FK CONSTRAINT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.detail_devis
    ADD CONSTRAINT detaildevis_fk4 FOREIGN KEY (iddevis) REFERENCES fac1.devis(id) MATCH FULL;


--
-- TOC entry 2859 (class 2606 OID 17202)
-- Name: detail_facture detailfacture_fk1; Type: FK CONSTRAINT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.detail_facture
    ADD CONSTRAINT detailfacture_fk1 FOREIGN KEY (idarticle) REFERENCES fac1.article(id) MATCH FULL;


--
-- TOC entry 2860 (class 2606 OID 17207)
-- Name: detail_facture detailfacture_fk2; Type: FK CONSTRAINT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.detail_facture
    ADD CONSTRAINT detailfacture_fk2 FOREIGN KEY (idttv) REFERENCES fac1.taux(id) MATCH FULL;


--
-- TOC entry 2861 (class 2606 OID 17212)
-- Name: detail_facture detailfacture_fk3; Type: FK CONSTRAINT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.detail_facture
    ADD CONSTRAINT detailfacture_fk3 FOREIGN KEY (idtr) REFERENCES fac1.taux(id) MATCH FULL;


--
-- TOC entry 2862 (class 2606 OID 17217)
-- Name: detail_facture detailfacture_fk4; Type: FK CONSTRAINT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.detail_facture
    ADD CONSTRAINT detailfacture_fk4 FOREIGN KEY (idfacture) REFERENCES fac1.facture(id) MATCH FULL;


--
-- TOC entry 2863 (class 2606 OID 17190)
-- Name: devis devis_fk1; Type: FK CONSTRAINT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.devis
    ADD CONSTRAINT devis_fk1 FOREIGN KEY (codetiers) REFERENCES fac1.tiers(id) MATCH FULL;


--
-- TOC entry 2864 (class 2606 OID 17185)
-- Name: facture facture_fk1; Type: FK CONSTRAINT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.facture
    ADD CONSTRAINT facture_fk1 FOREIGN KEY (codetiers) REFERENCES fac1.tiers(id) MATCH FULL;


--
-- TOC entry 2865 (class 2606 OID 17175)
-- Name: infotrs infotrs_fk1; Type: FK CONSTRAINT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.infotrs
    ADD CONSTRAINT infotrs_fk1 FOREIGN KEY (codetiers) REFERENCES fac1.tiers(id) MATCH FULL;


--
-- TOC entry 2866 (class 2606 OID 17301)
-- Name: prix_article prix_article1_fk; Type: FK CONSTRAINT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.prix_article
    ADD CONSTRAINT prix_article1_fk FOREIGN KEY (idarticle) REFERENCES fac1.article(id) MATCH FULL;


--
-- TOC entry 2867 (class 2606 OID 17165)
-- Name: taux taux1_fk; Type: FK CONSTRAINT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.taux
    ADD CONSTRAINT taux1_fk FOREIGN KEY (idttaux) REFERENCES fac1.ref_type_taux(id) MATCH FULL;


--
-- TOC entry 2868 (class 2606 OID 17150)
-- Name: tiers tiers1_fk; Type: FK CONSTRAINT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.tiers
    ADD CONSTRAINT tiers1_fk FOREIGN KEY (idcompte) REFERENCES fac1.ref_compte(id) MATCH FULL;


--
-- TOC entry 2869 (class 2606 OID 17155)
-- Name: tiers tiers2_fk; Type: FK CONSTRAINT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.tiers
    ADD CONSTRAINT tiers2_fk FOREIGN KEY (idtyptiers) REFERENCES fac1.ref_type_tiers(id) MATCH FULL;


--
-- TOC entry 2870 (class 2606 OID 17160)
-- Name: tiers tiers3_fk; Type: FK CONSTRAINT; Schema: fac1; Owner: postgres
--

ALTER TABLE ONLY fac1.tiers
    ADD CONSTRAINT tiers3_fk FOREIGN KEY (idcatiers) REFERENCES fac1.ref_categ_tiers(id) MATCH FULL;


-- Completed on 2020-03-22 23:04:03

--
-- PostgreSQL database dump complete
--

