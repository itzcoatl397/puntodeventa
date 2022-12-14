PGDMP     ;    #                z           puntodeventa    14.5    14.4     ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    16384    puntodeventa    DATABASE     i   CREATE DATABASE puntodeventa WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Mexico.1252';
    DROP DATABASE puntodeventa;
                postgres    false            ?            1259    16394    login    TABLE     ?   CREATE TABLE public.login (
    user_id integer NOT NULL,
    username character varying(50) NOT NULL,
    password character varying(50) NOT NULL
);
    DROP TABLE public.login;
       public         heap    postgres    false            ?            1259    16393    login_user_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.login_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.login_user_id_seq;
       public          postgres    false    210            ?           0    0    login_user_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.login_user_id_seq OWNED BY public.login.user_id;
          public          postgres    false    209            ?            1259    16406 	   productos    TABLE     ?   CREATE TABLE public.productos (
    codigoproducto character varying(50) NOT NULL,
    nombreproducto character varying(50) NOT NULL,
    cantidad text
);
    DROP TABLE public.productos;
       public         heap    postgres    false            `           2604    16397    login user_id    DEFAULT     n   ALTER TABLE ONLY public.login ALTER COLUMN user_id SET DEFAULT nextval('public.login_user_id_seq'::regclass);
 <   ALTER TABLE public.login ALTER COLUMN user_id DROP DEFAULT;
       public          postgres    false    209    210    210            ?          0    16394    login 
   TABLE DATA           <   COPY public.login (user_id, username, password) FROM stdin;
    public          postgres    false    210   -       ?          0    16406 	   productos 
   TABLE DATA           M   COPY public.productos (codigoproducto, nombreproducto, cantidad) FROM stdin;
    public          postgres    false    211   e       ?           0    0    login_user_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.login_user_id_seq', 1, false);
          public          postgres    false    209            b           2606    16399    login login_username_key 
   CONSTRAINT     W   ALTER TABLE ONLY public.login
    ADD CONSTRAINT login_username_key UNIQUE (username);
 B   ALTER TABLE ONLY public.login DROP CONSTRAINT login_username_key;
       public            postgres    false    210            d           2606    16413 &   productos productos_codigoproducto_key 
   CONSTRAINT     k   ALTER TABLE ONLY public.productos
    ADD CONSTRAINT productos_codigoproducto_key UNIQUE (codigoproducto);
 P   ALTER TABLE ONLY public.productos DROP CONSTRAINT productos_codigoproducto_key;
       public            postgres    false    211            ?   (   x?3?LL????,??/?2???/J?K?4426?????? ?m\      ?   O   x?304515?L??K?H?4?204250?t?????L?L??J
KS??9?A*?L?9??B??\?&&??E ?1z\\\ X??     