USE [PayPlanBD]
GO
/****** Object:  Table [dbo].[tipo_producto]    Script Date: 12/20/2014 19:58:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tipo_producto](
	[id_tipo_producto] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[detalle] [varchar](500) NOT NULL,
	[estado] [bit] NOT NULL,
 CONSTRAINT [PK_tipo_producto] PRIMARY KEY CLUSTERED 
(
	[id_tipo_producto] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[tipo_producto] ON
INSERT [dbo].[tipo_producto] ([id_tipo_producto], [nombre], [detalle], [estado]) VALUES (1, N'Tipo Producto 1', N'Tipo Producto 1', 1)
INSERT [dbo].[tipo_producto] ([id_tipo_producto], [nombre], [detalle], [estado]) VALUES (2, N'Tipo Producto 2', N'Tipo Producto 2', 1)
INSERT [dbo].[tipo_producto] ([id_tipo_producto], [nombre], [detalle], [estado]) VALUES (3, N'Tipo Producto 3', N'Tipo Producto 3', 1)
SET IDENTITY_INSERT [dbo].[tipo_producto] OFF
/****** Object:  Table [dbo].[tipo_pago]    Script Date: 12/20/2014 19:58:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tipo_pago](
	[id_tipo_pago] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[pago] [decimal](18, 4) NOT NULL,
	[estado] [bit] NOT NULL,
 CONSTRAINT [PK_tipo_pago] PRIMARY KEY CLUSTERED 
(
	[id_tipo_pago] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tipo_movimiento]    Script Date: 12/20/2014 19:58:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tipo_movimiento](
	[id_tipo_movimiento] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[estado] [bit] NOT NULL,
 CONSTRAINT [PK_tipo_movimiento] PRIMARY KEY CLUSTERED 
(
	[id_tipo_movimiento] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[tipo_movimiento] ON
INSERT [dbo].[tipo_movimiento] ([id_tipo_movimiento], [nombre], [estado]) VALUES (1, N'Movimiento Unico', 1)
INSERT [dbo].[tipo_movimiento] ([id_tipo_movimiento], [nombre], [estado]) VALUES (2, N'Movimiento a Plazos', 1)
INSERT [dbo].[tipo_movimiento] ([id_tipo_movimiento], [nombre], [estado]) VALUES (3, N'Movimiento Mensual', 1)
SET IDENTITY_INSERT [dbo].[tipo_movimiento] OFF
/****** Object:  Table [dbo].[departamento]    Script Date: 12/20/2014 19:58:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[departamento](
	[id_departamento] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
 CONSTRAINT [PK__Departam__787A433D2F10007B] PRIMARY KEY CLUSTERED 
(
	[id_departamento] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[departamento] ON
INSERT [dbo].[departamento] ([id_departamento], [nombre]) VALUES (1, N'Amazonas')
INSERT [dbo].[departamento] ([id_departamento], [nombre]) VALUES (2, N'Ancash')
INSERT [dbo].[departamento] ([id_departamento], [nombre]) VALUES (3, N'Apurimac')
INSERT [dbo].[departamento] ([id_departamento], [nombre]) VALUES (4, N'Arequipa')
INSERT [dbo].[departamento] ([id_departamento], [nombre]) VALUES (5, N'Ayacucho')
INSERT [dbo].[departamento] ([id_departamento], [nombre]) VALUES (6, N'Cajamarca')
INSERT [dbo].[departamento] ([id_departamento], [nombre]) VALUES (7, N'Cusco')
INSERT [dbo].[departamento] ([id_departamento], [nombre]) VALUES (8, N'Huancavelica')
INSERT [dbo].[departamento] ([id_departamento], [nombre]) VALUES (9, N'Huanuco')
INSERT [dbo].[departamento] ([id_departamento], [nombre]) VALUES (10, N'Ica')
INSERT [dbo].[departamento] ([id_departamento], [nombre]) VALUES (11, N'Junín')
INSERT [dbo].[departamento] ([id_departamento], [nombre]) VALUES (12, N'La Libertad')
INSERT [dbo].[departamento] ([id_departamento], [nombre]) VALUES (13, N'Lambayeque')
INSERT [dbo].[departamento] ([id_departamento], [nombre]) VALUES (14, N'Lima')
INSERT [dbo].[departamento] ([id_departamento], [nombre]) VALUES (15, N'Prov. Const. del   Callao')
INSERT [dbo].[departamento] ([id_departamento], [nombre]) VALUES (16, N'Loreto')
INSERT [dbo].[departamento] ([id_departamento], [nombre]) VALUES (17, N'Madre de Dios')
INSERT [dbo].[departamento] ([id_departamento], [nombre]) VALUES (18, N'Moquegua')
INSERT [dbo].[departamento] ([id_departamento], [nombre]) VALUES (19, N'Pasco')
INSERT [dbo].[departamento] ([id_departamento], [nombre]) VALUES (20, N'Piura')
INSERT [dbo].[departamento] ([id_departamento], [nombre]) VALUES (21, N'Puno')
INSERT [dbo].[departamento] ([id_departamento], [nombre]) VALUES (22, N'San Martín')
INSERT [dbo].[departamento] ([id_departamento], [nombre]) VALUES (23, N'Tacna')
INSERT [dbo].[departamento] ([id_departamento], [nombre]) VALUES (24, N'Tumbes')
INSERT [dbo].[departamento] ([id_departamento], [nombre]) VALUES (25, N'Ucayali')
SET IDENTITY_INSERT [dbo].[departamento] OFF
/****** Object:  Table [dbo].[banco]    Script Date: 12/20/2014 19:58:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[banco](
	[id_banco] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[estado] [bit] NOT NULL,
 CONSTRAINT [PK_banco] PRIMARY KEY CLUSTERED 
(
	[id_banco] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[banco] ON
INSERT [dbo].[banco] ([id_banco], [nombre], [estado]) VALUES (1, N'Banco 1 ', 1)
INSERT [dbo].[banco] ([id_banco], [nombre], [estado]) VALUES (2, N'Banco 2', 1)
INSERT [dbo].[banco] ([id_banco], [nombre], [estado]) VALUES (3, N'Banco 3', 1)
SET IDENTITY_INSERT [dbo].[banco] OFF
/****** Object:  Table [dbo].[marca]    Script Date: 12/20/2014 19:58:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[marca](
	[id_marca] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[estado] [bit] NOT NULL,
 CONSTRAINT [PK_marca] PRIMARY KEY CLUSTERED 
(
	[id_marca] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[marca] ON
INSERT [dbo].[marca] ([id_marca], [nombre], [estado]) VALUES (1, N'Marca 1', 1)
INSERT [dbo].[marca] ([id_marca], [nombre], [estado]) VALUES (2, N'Marca 2', 1)
INSERT [dbo].[marca] ([id_marca], [nombre], [estado]) VALUES (3, N'Marca 3', 1)
SET IDENTITY_INSERT [dbo].[marca] OFF
/****** Object:  Table [dbo].[servicio]    Script Date: 12/20/2014 19:58:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[servicio](
	[id_servicio] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[estado] [bit] NOT NULL,
	[fecha_actualizacion] [datetime] NULL,
 CONSTRAINT [PK_servicio] PRIMARY KEY CLUSTERED 
(
	[id_servicio] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[servicio] ON
INSERT [dbo].[servicio] ([id_servicio], [nombre], [estado], [fecha_actualizacion]) VALUES (1, N'Servicio 1', 1, CAST(0x0000A12500000000 AS DateTime))
INSERT [dbo].[servicio] ([id_servicio], [nombre], [estado], [fecha_actualizacion]) VALUES (2, N'Servicio 2', 1, CAST(0x0000A12500000000 AS DateTime))
INSERT [dbo].[servicio] ([id_servicio], [nombre], [estado], [fecha_actualizacion]) VALUES (3, N'Servicio 3', 1, CAST(0x0000A12500000000 AS DateTime))
SET IDENTITY_INSERT [dbo].[servicio] OFF
/****** Object:  Table [dbo].[provincia]    Script Date: 12/20/2014 19:58:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[provincia](
	[id_provincia] [int] IDENTITY(1,1) NOT NULL,
	[id_departamento] [int] NULL,
	[nombre] [varchar](50) NULL,
 CONSTRAINT [PK__Provinci__EED7445532E0915F] PRIMARY KEY CLUSTERED 
(
	[id_provincia] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[provincia] ON
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (1, 1, N'Bagua')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (2, 1, N'Bongará')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (3, 1, N'Condorcanqui')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (4, 1, N'Chachapoyas')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (5, 1, N'Luya')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (6, 1, N'Rodríguez de Mendoza')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (7, 1, N'Utcubamba')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (8, 2, N'Aija')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (9, 2, N'Antonio Raymondi')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (10, 2, N'Asunción')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (11, 2, N'Bolognesi')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (12, 2, N'Casma')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (13, 2, N'Carhuaz')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (14, 2, N'Carlos Fitzcarrald')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (15, 2, N'Corongo')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (16, 2, N'Huaraz')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (17, 2, N'Huari')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (18, 2, N'Huarmey')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (19, 2, N'Huaylas')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (20, 2, N'Mariscal Luzuriaga')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (21, 2, N'Ocros')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (22, 2, N'Pallasca')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (23, 2, N'Pomabamba')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (24, 2, N'Recuay')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (25, 2, N'Santa')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (26, 2, N'Sihuas')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (27, 2, N'Yungay')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (28, 3, N'Abancay')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (29, 3, N'Andahuaylas')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (30, 3, N'Antabamba')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (31, 3, N'Aymaraes')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (32, 3, N'Cotabambas')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (33, 3, N'Chincheros')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (34, 3, N'Grau')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (35, 4, N'Arequipa')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (36, 4, N'Caylloma')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (37, 4, N'Camaná')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (38, 4, N'Caravelí')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (39, 4, N'Castilla')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (40, 4, N'Condesuyos')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (41, 4, N'Islay')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (42, 4, N'La Unión')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (43, 5, N'Cangallo')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (44, 5, N'Huamanga')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (45, 5, N'Huanca Sancos')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (46, 5, N'Huanta')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (47, 5, N'La Mar')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (48, 5, N'Lucanas')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (49, 5, N'Parinacochas')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (50, 5, N'Paucar del SaraSara')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (51, 5, N'Sucre')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (52, 5, N'Víctor Fajardo')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (53, 5, N'Vilcashuamán')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (54, 6, N'Cajabamba')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (55, 6, N'Cajamarca')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (56, 6, N'Celendín')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (57, 6, N'Contumazá')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (58, 6, N'Cutervo')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (59, 6, N'Chota')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (60, 6, N'Hualgayoc')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (61, 6, N'Jaén')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (62, 6, N'San Ignacio')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (63, 6, N'San Marcos')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (64, 6, N'San Miguel')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (65, 6, N'San Pablo')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (66, 6, N'Santa Cruz')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (67, 7, N'Acomayo')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (68, 7, N'Anta')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (69, 7, N'Calca')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (70, 7, N'Canas')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (71, 7, N'Canchis')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (72, 7, N'Cuzco')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (73, 7, N'Chumbivilca')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (74, 7, N'Espinar')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (75, 7, N'La Convención')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (76, 7, N'Paruro')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (77, 7, N'Paucartambo')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (78, 7, N'Quispicanchis')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (79, 7, N'Urubamba')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (80, 8, N'Acobamba')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (81, 8, N'Angaraes')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (82, 8, N'Castrovirreyna')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (83, 8, N'Churcampa')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (84, 8, N'Huancavelica')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (85, 8, N'Huaytará')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (86, 8, N'Tayacaja')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (87, 9, N'Ambo')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (88, 9, N'Dos de Mayo')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (89, 9, N'Huacaybamba')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (90, 9, N'Huamalíes')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (91, 9, N'Huánuco')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (92, 9, N'Leoncio Prado')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (93, 9, N'Marañon')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (94, 9, N'Pachitea')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (95, 9, N'Puerto Inca')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (96, 9, N'Yarowilca')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (97, 9, N'Lauricocha')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (98, 10, N'Chincha')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (99, 10, N'Ica')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (100, 10, N'Nazca')
GO
print 'Processed 100 total records'
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (101, 10, N'Palpa')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (102, 10, N'Pisco')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (103, 11, N'Concepción')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (104, 11, N'Chanchamayo')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (105, 11, N'Chupaca')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (106, 11, N'Huancayo')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (107, 11, N'Jauja')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (108, 11, N'Junín')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (109, 11, N'Satipo')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (110, 11, N'Tarma')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (111, 11, N'Yauli')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (112, 12, N'Ascope')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (113, 12, N'Bolívar')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (114, 12, N'Chepén')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (115, 12, N'Gran Chimú')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (116, 12, N'Julcán')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (117, 12, N'Otuzco')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (118, 12, N'Pacasmayo')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (119, 12, N'Pataz')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (120, 12, N'Sánchez Carrión')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (121, 12, N'Santiago de Chuco')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (122, 12, N'Trujillo')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (123, 12, N'Virú')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (124, 13, N'Chiclayo')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (125, 13, N'Ferreñafe')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (126, 13, N'Lambayeque')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (127, 14, N'Barranca')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (128, 14, N'Cajatambo')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (129, 14, N'Canta')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (130, 14, N'Cañete')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (131, 14, N'Huaral')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (132, 14, N'Huarochirí')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (133, 14, N'Huaura')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (134, 14, N'Lima')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (135, 14, N'Oyón')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (136, 14, N'Yauyos')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (137, 15, N'Prov. Const. Callao')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (138, 16, N'Alto Amazonas')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (139, 16, N'Loreto')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (140, 16, N'Mariscal Castilla')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (141, 16, N'Maynas')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (142, 16, N'Requena')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (143, 16, N'Ucayali')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (144, 17, N'Manu')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (145, 17, N'Tahuamanu')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (146, 17, N'Tambopata')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (147, 18, N'Ilo')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (148, 18, N'Mariscal Nieto')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (149, 18, N'Sánchez Cerro')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (150, 19, N'Daniel Alcides Carrión')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (151, 19, N'Oxapampa')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (152, 19, N'Pasco')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (153, 20, N'Ayabaca')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (154, 20, N'Huancabamba')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (155, 20, N'Morropón')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (156, 20, N'Paita')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (157, 20, N'Piura')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (158, 20, N'Sechura')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (159, 20, N'Sullana')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (160, 20, N'Talara')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (161, 21, N'Azángaro')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (162, 21, N'Carabaya')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (163, 21, N'Chucuito')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (164, 21, N'El Collao')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (165, 21, N'Huancané')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (166, 21, N'Lampa')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (167, 21, N'Melgar')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (168, 21, N'Moho')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (169, 21, N'San Antonio de Putina')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (170, 21, N'San Román')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (171, 21, N'Sandia')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (172, 21, N'Puno')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (173, 21, N'Yunguyo')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (174, 22, N'Bellavista')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (175, 22, N'El Dorado')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (176, 22, N'Huallaga')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (177, 22, N'Lamas')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (178, 22, N'Mariscal Cáceres')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (179, 22, N'Moyobamba')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (180, 22, N'Picota')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (181, 22, N'Rioja')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (182, 22, N'San Martín')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (183, 22, N'Tocache')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (184, 23, N'Candarave')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (185, 23, N'Jorge Basadre')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (186, 23, N'Tacna')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (187, 23, N'Tarata')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (188, 24, N'Contralmirante Villar')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (189, 24, N'Tumbes')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (190, 24, N'Zarumilla')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (191, 25, N'Atalaya')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (192, 25, N'Coronel Portillo')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (193, 25, N'Padre Abad')
INSERT [dbo].[provincia] ([id_provincia], [id_departamento], [nombre]) VALUES (194, 25, N'Purús')
SET IDENTITY_INSERT [dbo].[provincia] OFF
/****** Object:  Table [dbo].[producto]    Script Date: 12/20/2014 19:58:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[producto](
	[id_producto] [int] IDENTITY(1,1) NOT NULL,
	[id_tipo_producto] [int] NOT NULL,
	[id_marca] [int] NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[fecha_creacion] [datetime] NOT NULL,
	[fecha_actualizacion] [datetime] NOT NULL,
	[estado] [tinyint] NOT NULL,
 CONSTRAINT [PK_producto] PRIMARY KEY CLUSTERED 
(
	[id_producto] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[producto] ON
INSERT [dbo].[producto] ([id_producto], [id_tipo_producto], [id_marca], [nombre], [fecha_creacion], [fecha_actualizacion], [estado]) VALUES (2, 1, 1, N'Producto 1', CAST(0x0000A3F70118152F AS DateTime), CAST(0x0000A3F70118152F AS DateTime), 1)
INSERT [dbo].[producto] ([id_producto], [id_tipo_producto], [id_marca], [nombre], [fecha_creacion], [fecha_actualizacion], [estado]) VALUES (3, 1, 2, N'Producto 2', CAST(0x0000A3F70118152F AS DateTime), CAST(0x0000A3F70118152F AS DateTime), 1)
INSERT [dbo].[producto] ([id_producto], [id_tipo_producto], [id_marca], [nombre], [fecha_creacion], [fecha_actualizacion], [estado]) VALUES (4, 1, 3, N'Producto 3', CAST(0x0000A3F70118152F AS DateTime), CAST(0x0000A3F70118152F AS DateTime), 1)
INSERT [dbo].[producto] ([id_producto], [id_tipo_producto], [id_marca], [nombre], [fecha_creacion], [fecha_actualizacion], [estado]) VALUES (5, 2, 1, N'Producto 4', CAST(0x0000A3F70118152F AS DateTime), CAST(0x0000A3F70118152F AS DateTime), 1)
INSERT [dbo].[producto] ([id_producto], [id_tipo_producto], [id_marca], [nombre], [fecha_creacion], [fecha_actualizacion], [estado]) VALUES (6, 2, 2, N'Producto 5', CAST(0x0000A3F70118152F AS DateTime), CAST(0x0000A3F70118152F AS DateTime), 1)
INSERT [dbo].[producto] ([id_producto], [id_tipo_producto], [id_marca], [nombre], [fecha_creacion], [fecha_actualizacion], [estado]) VALUES (7, 2, 3, N'Producto 6', CAST(0x0000A3F70118152F AS DateTime), CAST(0x0000A3F70118152F AS DateTime), 1)
INSERT [dbo].[producto] ([id_producto], [id_tipo_producto], [id_marca], [nombre], [fecha_creacion], [fecha_actualizacion], [estado]) VALUES (8, 3, 1, N'Producto 7', CAST(0x0000A3F70118152F AS DateTime), CAST(0x0000A3F70118152F AS DateTime), 1)
INSERT [dbo].[producto] ([id_producto], [id_tipo_producto], [id_marca], [nombre], [fecha_creacion], [fecha_actualizacion], [estado]) VALUES (9, 3, 2, N'Producto 8', CAST(0x0000A3F70118152F AS DateTime), CAST(0x0000A3F70118152F AS DateTime), 1)
SET IDENTITY_INSERT [dbo].[producto] OFF
/****** Object:  Table [dbo].[pago]    Script Date: 12/20/2014 19:58:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[pago](
	[id_pago] [int] IDENTITY(1,1) NOT NULL,
	[id_tipo_pago] [int] NOT NULL,
	[fecha_creacion] [datetime] NOT NULL,
	[fecha_culminacion] [date] NOT NULL,
 CONSTRAINT [PK_pago] PRIMARY KEY CLUSTERED 
(
	[id_pago] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  StoredProcedure [dbo].[SP_Listar_Marca]    Script Date: 12/20/2014 19:58:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[SP_Listar_Marca]
as
select m.id_marca,m.nombre,m.estado from marca m
GO
/****** Object:  StoredProcedure [dbo].[SP_Listar_Tipo_Producto]    Script Date: 12/20/2014 19:58:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[SP_Listar_Tipo_Producto]
as
select tp.id_tipo_producto,tp.nombre,tp.nombre,tp.detalle,tp.estado
from  tipo_producto tp
GO
/****** Object:  StoredProcedure [dbo].[SP_Listar_Servicio]    Script Date: 12/20/2014 19:58:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[SP_Listar_Servicio]
as
select id_servicio,nombre,estado from servicio
GO
/****** Object:  StoredProcedure [dbo].[SP_Listar_Banco]    Script Date: 12/20/2014 19:58:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[SP_Listar_Banco]
as
select id_banco,nombre,estado from banco
GO
/****** Object:  StoredProcedure [dbo].[SP_Listar_Producto]    Script Date: 12/20/2014 19:58:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[SP_Listar_Producto]
as
select p.id_producto,p.nombre,p.fecha_creacion,p.fecha_actualizacion,p.estado,
p.id_tipo_producto,tp.nombre,tp.detalle,tp.estado,p.id_marca,m.nombre,m.estado
from  producto p inner join tipo_producto tp on p.id_tipo_producto=tp.id_tipo_producto
inner join marca m on p.id_marca=m.id_marca
GO
/****** Object:  StoredProcedure [dbo].[SP_Insertar_Producto]    Script Date: 12/20/2014 19:58:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[SP_Insertar_Producto]
(
	@id_producto INT,
	@id_tipo_producto INT,
	@id_marca INT,
	@nombre VARCHAR(50),
	@estado tinyint
)
as
BEGIN
	if exists(select * from producto where id_producto=@id_producto)
	BEGIN
		UPDATE producto SET id_tipo_producto=@id_tipo_producto, id_marca=@id_marca,
		nombre=@nombre ,fecha_actualizacion=GETDATE(), estado=@estado WHERE id_producto=@id_producto
		SELECT 0
	END
	ELSE
	BEGIN
		INSERT INTO producto 
		(id_tipo_producto,id_marca,nombre,fecha_creacion,fecha_actualizacion,estado)
		VALUES 
		(@id_tipo_producto,@id_marca,@nombre,GETDATE(),GETDATE(),@estado)
		SELECT @@identity
	END
END
GO
/****** Object:  Table [dbo].[distrito]    Script Date: 12/20/2014 19:58:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[distrito](
	[id_distrito] [int] IDENTITY(1,1) NOT NULL,
	[id_provincia] [int] NULL,
	[nombre] [varchar](50) NULL,
 CONSTRAINT [PK_Distrito] PRIMARY KEY CLUSTERED 
(
	[id_distrito] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[distrito] ON
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1, 1, N'Bagua')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (2, 1, N'La Peca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (3, 1, N'Aramango')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (4, 1, N'Copallin')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (5, 1, N'El Parco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (6, 1, N'Imaza')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (7, 2, N'Corosha')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (8, 2, N'Cuispes')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (9, 2, N'Chisquilla')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (10, 2, N'Churuja')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (11, 2, N'Florida')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (12, 2, N'Jazán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (13, 2, N'Recta')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (14, 2, N'San Carlos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (15, 2, N'Shipasbamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (16, 2, N'Valera')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (17, 2, N'Yambrasbamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (18, 3, N'El Cenepa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (19, 3, N'Nieva')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (20, 3, N'Río Santiago')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (21, 4, N'Chachapoyas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (22, 4, N'Asunción')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (23, 4, N'Balsas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (24, 4, N'Cheto')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (25, 4, N'Chiliquín')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (26, 4, N'Chuquibamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (27, 4, N'Granada')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (28, 4, N'Huancas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (29, 4, N'La Jalca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (30, 4, N'Leymebamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (31, 4, N'Levanto')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (32, 4, N'Magdalena')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (33, 4, N'Mariscal Castilla')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (34, 4, N'Molinopampa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (35, 4, N'Montevideo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (36, 4, N'Olleros')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (37, 4, N'Quinjalca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (38, 4, N'San Francisco de Daguas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (39, 4, N'San Isidro de Maino')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (40, 4, N'Soloco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (41, 4, N'Sonche')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (42, 5, N'Camporredondo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (43, 5, N'Cocabamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (44, 5, N'Colcamar')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (45, 5, N'Conila')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (46, 5, N'Inguilpata')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (47, 5, N'Lámud')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (48, 5, N'Longuita')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (49, 5, N'Lonya Chico')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (50, 5, N'Luya')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (51, 5, N'Luya Viejo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (52, 5, N'María')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (53, 5, N'Ocalli')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (54, 5, N'Ocumal')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (55, 5, N'Pisuquía')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (56, 5, N'Providencia')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (57, 5, N'San Cristóbal')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (58, 5, N'San Francisco del Yeso')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (59, 5, N'San Jerónimo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (60, 5, N'San Juan de Lopecancha')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (61, 5, N'Santa Catalina')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (62, 5, N'Santo Tomás')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (63, 5, N'Tingo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (64, 5, N'Trita')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (65, 6, N'Chirimoto')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (66, 6, N'Cochamal')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (67, 6, N'Huambo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (68, 6, N'Limabamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (69, 6, N'Longar')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (70, 6, N'Mariscal Benavides')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (71, 6, N'Milpuc')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (72, 6, N'Omia')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (73, 6, N'San Nicolás')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (74, 6, N'Santa Rosa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (75, 6, N'Totora')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (76, 6, N'Vista Alegre')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (77, 7, N'Bagua Grande')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (78, 7, N'Cajaruro')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (79, 7, N'Cumba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (80, 7, N'El Milagro')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (81, 7, N'Jamalca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (82, 7, N'Lonya Grande')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (83, 7, N'Yamón')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (84, 8, N'Aija')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (85, 8, N'Coris')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (86, 8, N'Huacllán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (87, 8, N'La Merced')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (88, 8, N'Succha')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (89, 9, N'Llamellín')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (90, 9, N'Aczo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (91, 9, N'Chaccho')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (92, 9, N'Chingas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (93, 9, N'Mirgas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (94, 9, N'San Juan de Rontoy')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (95, 10, N'Chacas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (96, 10, N'Acochaca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (97, 11, N'Abelardo Pardo Lezameta')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (98, 11, N'Antonio Raymondi')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (99, 11, N'Aquia')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (100, 11, N'Canis')
GO
print 'Processed 100 total records'
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (101, 11, N'Colquioc')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (102, 11, N'Cajacay')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (103, 11, N'Chiquián')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (104, 11, N'Huallanca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (105, 11, N'Huasta')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (106, 11, N'Huayllacayán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (107, 11, N'La Primavera')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (108, 11, N'Mangas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (109, 11, N'Pacllón')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (110, 11, N'San Miguel de Corpanqui')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (111, 11, N'Ticllos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (112, 12, N'Casma')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (113, 12, N'Buena Vista Alta')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (114, 12, N'Comandante Noel')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (115, 12, N'Yaután')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (116, 13, N'Carhuás')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (117, 13, N'Acopampa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (118, 13, N'Amashca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (119, 13, N'Anta')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (120, 13, N'Ataquero')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (121, 13, N'Marcará')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (122, 13, N'Pariahuanca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (123, 13, N'San Miguel de Aco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (124, 13, N'Shilla')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (125, 13, N'Tinco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (126, 13, N'Yungar')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (127, 14, N'San Luis')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (128, 14, N'San Nicolás')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (129, 14, N'Yauya')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (130, 15, N'Aco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (131, 15, N'Bambas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (132, 15, N'Cusca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (133, 15, N'La Pampa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (134, 15, N'Yánac')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (135, 15, N'Yupán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (136, 16, N'Cochabamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (137, 16, N'Colcabamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (138, 16, N'Huanchay')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (139, 16, N'Independencia')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (140, 16, N'Jangas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (141, 16, N'La Libertad')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (142, 16, N'Olleros')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (143, 16, N'Pampas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (144, 16, N'Pariacoto')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (145, 16, N'Pira')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (146, 16, N'Tarica')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (147, 17, N'Huari')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (148, 17, N'Anra')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (149, 17, N'Cajay')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (150, 17, N'Chavín de Huantar')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (151, 17, N'Huacachi')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (152, 17, N'Huacchis')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (153, 17, N'Huachis')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (154, 17, N'Huantar')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (155, 17, N'Masin')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (156, 17, N'Paucas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (157, 17, N'Pontó')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (158, 17, N'Rahuapampa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (159, 17, N'Rapayán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (160, 17, N'San Marcos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (161, 17, N'San Pedro de Chaná')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (162, 17, N'Uco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (163, 18, N'Huarmey')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (164, 18, N'Cochapeti')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (165, 18, N'Culebras')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (166, 18, N'Huayan')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (167, 18, N'Malvas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (168, 19, N'Caraz')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (169, 19, N'Huallanca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (170, 19, N'Huata')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (171, 19, N'Huaylas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (172, 19, N'Mato')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (173, 19, N'Pamparomás')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (174, 19, N'Pueblo Libre')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (175, 19, N'Santa Cruz')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (176, 19, N'Santo Toribio')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (177, 19, N'Yuracmarca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (178, 20, N'Piscobamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (179, 20, N'Casca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (180, 20, N'Eleazar Guzmán Barrón')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (181, 20, N'Fidel OIivas Escudero')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (182, 20, N'Llama')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (183, 20, N'Llumpa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (184, 20, N'Musga')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (185, 20, N'Lucma')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (186, 21, N'Ocros')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (187, 21, N'Acas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (188, 21, N'Cajamarquilla')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (189, 21, N'Carhuapamga')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (190, 21, N'Cochas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (191, 21, N'Congas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (192, 21, N'Llipa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (193, 21, N'San Cristóbal de Raján')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (194, 21, N'San Pedro')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (195, 21, N'Santiago de Chilcas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (196, 22, N'Cabana')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (197, 22, N'Bolognesi')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (198, 22, N'Conchucos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (199, 22, N'Huacaschuque')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (200, 22, N'Huandoval')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (201, 22, N'Lacabamba')
GO
print 'Processed 200 total records'
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (202, 22, N'Llapo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (203, 22, N'Pallasca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (204, 22, N'Pampas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (205, 22, N'Santa Rosa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (206, 22, N'Tauca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (207, 23, N'Pomabamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (208, 23, N'Huayllán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (209, 23, N'Parobamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (210, 23, N'Quinuabamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (211, 24, N'Recuay')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (212, 24, N'Catac')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (213, 24, N'Cotaparaco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (214, 24, N'Huayllapampa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (215, 24, N'Llacllín')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (216, 24, N'Marca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (217, 24, N'Pampas Chico')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (218, 24, N'Pararín')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (219, 24, N'Tapacocha')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (220, 24, N'Ticapampa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (221, 25, N'Chimbote (cercado)')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (222, 25, N'Cáceres del Perú')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (223, 25, N'Coishco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (224, 25, N'Macate')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (225, 25, N'Moro')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (226, 25, N'Nepeña')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (227, 25, N'Nuevo Chimbote')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (228, 25, N'Samanco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (229, 25, N'Santa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (230, 26, N'Sihuas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (231, 26, N'Acobamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (232, 26, N'Alfonso Ugarte')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (233, 26, N'Cashapampa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (234, 26, N'Chingalpo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (235, 26, N'Huayllabamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (236, 26, N'Quiches')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (237, 26, N'Ragash')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (238, 26, N'San Juan')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (239, 26, N'Sicsibamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (240, 27, N'Yungay')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (241, 27, N'Cascapara')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (242, 27, N'Mancos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (243, 27, N'Matacoto')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (244, 27, N'Quillo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (245, 27, N'Ranrahirca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (246, 27, N'Shupluy')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (247, 27, N'Yanama')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (248, 28, N'Abancay')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (249, 28, N'Chacoche')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (250, 28, N'Circa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (251, 28, N'Curahuasi')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (252, 28, N'Huanipaca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (253, 28, N'Lambrama')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (254, 28, N'Pichirhua')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (255, 28, N'San Pedro de Cachora')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (256, 28, N'Tamburco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (257, 29, N'Andahuaylas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (258, 29, N'Andarapa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (259, 29, N'Chiara')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (260, 29, N'Huancarama')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (261, 29, N'Huancaray')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (262, 29, N'Huayana')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (263, 29, N'Kaquiabamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (264, 29, N'Kishuara')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (265, 29, N'Pacobamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (266, 29, N'Pacucha')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (267, 29, N'Pampachiri')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (268, 29, N'Pomacocha')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (269, 29, N'San Antonio de Cachi')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (270, 29, N'San Jerónimo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (271, 29, N'San Miguel de Chaccrapampa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (272, 29, N'Santa María de Chicmo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (273, 29, N'Talavera de la Reyna')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (274, 29, N'Tumay Huaraca ')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (275, 29, N'Turpo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (276, 30, N'Antabamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (277, 30, N'El Oro')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (278, 30, N'Huaquirca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (279, 30, N'Juan Espinoza Medrano')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (280, 30, N'Oropesa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (281, 30, N'Pachaconas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (282, 30, N'Sabaino')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (283, 31, N'Chalhuanca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (284, 31, N'Capaya')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (285, 31, N'Caraybamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (286, 31, N'Chapimarca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (287, 31, N'Colcabamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (288, 31, N'Cotaruse')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (289, 31, N'Huayllu')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (290, 31, N'Justo Apu Sahuaraura')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (291, 31, N'Lucre')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (292, 31, N'Pocohuanca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (293, 31, N'San Juan de Chacña')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (294, 31, N'Sañayca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (295, 31, N'Soraya')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (296, 31, N'Tapairihua')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (297, 31, N'Tintay')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (298, 31, N'Toraya')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (299, 31, N'Yanaca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (300, 32, N'Tambobamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (301, 32, N'Cotabambas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (302, 32, N'Coyllurqui')
GO
print 'Processed 300 total records'
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (303, 32, N'Haquira')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (304, 32, N'Mara')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (305, 32, N'Chalhuahuacho')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (306, 33, N'Chincheros')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (307, 33, N'Anco-Huallo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (308, 33, N'Cocharcas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (309, 33, N'Huaccana')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (310, 33, N'Ocobamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (311, 33, N'Ongoy')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (312, 33, N'Uranmarca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (313, 33, N'Ranracancha')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (314, 34, N'Chuquibambilla')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (315, 34, N'Curpahuasi')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (316, 34, N'Gamarra')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (317, 34, N'Huayllati')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (318, 34, N'Mamara')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (319, 34, N'Micaela Bastidas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (320, 34, N'Pataypampa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (321, 34, N'Progreso')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (322, 34, N'San Antonio')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (323, 34, N'Santa Rosa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (324, 34, N'Turpay')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (325, 34, N'Vilcabamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (326, 34, N'Virundo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (327, 34, N'Curasco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (328, 35, N'Alto Selva Alegre')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (329, 35, N'Arequipa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (330, 35, N'Cayma')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (331, 35, N'Cerro Colorado')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (332, 35, N'Characato')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (333, 35, N'Chiguata')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (334, 35, N'Jacobo Hunter')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (335, 35, N'José Luis Bustamante y Rivero')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (336, 35, N'La Joya')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (337, 35, N'Mariano Melgar')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (338, 35, N'Miraflores')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (339, 35, N'Mollebaya')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (340, 35, N'Paucarpata')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (341, 35, N'Pocsi')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (342, 35, N'Polobaya')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (343, 35, N'Quequeña')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (344, 35, N'Sabandía')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (345, 35, N'Sachaca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (346, 35, N'San Juan de Siguas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (347, 35, N'San Juan de Tarucani')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (348, 35, N'Santa Isabel de Siguas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (349, 35, N'Santa Rita de Siguas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (350, 35, N'Socabaya')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (351, 35, N'Tiabaya')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (352, 35, N'Uchumayo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (353, 35, N'Vitor')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (354, 35, N'Yanahuara')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (355, 35, N'Yarabamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (356, 35, N'Yura')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (357, 36, N'Achoma')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (358, 36, N'Cabanaconde')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (359, 36, N'Callalli')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (360, 36, N'Caylloma')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (361, 36, N'Chivay')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (362, 36, N'Coporaque')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (363, 36, N'Huambo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (364, 36, N'Huanca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (365, 36, N'Ichupampa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (366, 36, N'Lari')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (367, 36, N'Lluta')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (368, 36, N'Maca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (369, 36, N'Madrigal')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (370, 36, N'San Antonio de Chuca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (371, 36, N'Sibayo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (372, 36, N'Tapay')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (373, 36, N'Tisco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (374, 36, N'Tuti')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (375, 36, N'Yanque')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (376, 37, N'Camaná')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (377, 37, N'José María Quimper')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (378, 37, N'Mariano Nicolás Valcarcel')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (379, 37, N'Mariscal Cáceres')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (380, 37, N'Nicolás de Piérola')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (381, 37, N'Ocoña')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (382, 37, N'Quilca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (383, 37, N'Samuel Pastor')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (384, 38, N'Caravelí')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (385, 38, N'Acarí')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (386, 38, N'Atico')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (387, 38, N'Atiquipa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (388, 38, N'Bella Unión')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (389, 38, N'Cahuacho')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (390, 38, N'Chala')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (391, 38, N'Chaparra')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (392, 38, N'Huanuhuanu')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (393, 38, N'Jaqui')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (394, 38, N'Lomas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (395, 38, N'Quicacha')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (396, 38, N'Yauca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (397, 39, N'Aplao')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (398, 39, N'Andahua')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (399, 39, N'Ayo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (400, 39, N'Chachas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (401, 39, N'Chilcaymarca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (402, 39, N'Choco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (403, 39, N'Huancarqui')
GO
print 'Processed 400 total records'
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (404, 39, N'Machaguay')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (405, 39, N'Orcopampa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (406, 39, N'Pampacolca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (407, 39, N'Tipán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (408, 39, N'Uñón')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (409, 39, N'Uraca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (410, 39, N'Viraco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (411, 40, N'Chuquibamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (412, 40, N'Andaray')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (413, 40, N'Cayarani')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (414, 40, N'Chichas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (415, 40, N'Iray')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (416, 40, N'Río Grande')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (417, 40, N'Salamanca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (418, 40, N'Yanaquihua - Ispacas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (419, 41, N'Mollendo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (420, 41, N'Cocachacra')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (421, 41, N'Deán Valdivia')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (422, 41, N'Islay')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (423, 41, N'Mejía')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (424, 41, N'Punta de Bombón')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (425, 42, N'Alca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (426, 42, N'Charcana')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (427, 42, N'Huaynacotas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (428, 42, N'Pampamarca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (429, 42, N'Puyca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (430, 42, N'Quechualla')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (431, 42, N'Sayla')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (432, 42, N'Tauría')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (433, 42, N'Tomepampa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (434, 42, N'Toro')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (435, 43, N'Cangallo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (436, 43, N'Chuschi')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (437, 43, N'Los Morochucos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (438, 43, N'María Parado de Bellido')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (439, 43, N'Paras')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (440, 43, N'Totos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (441, 44, N'Ayacucho')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (442, 44, N'Acocro')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (443, 44, N'Acos Vinchos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (444, 44, N'Carmen Alto')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (445, 44, N'Chiara')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (446, 44, N'Jesús Nazareno')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (447, 44, N'Ocros')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (448, 44, N'Pacaycasa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (449, 44, N'Quinua')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (450, 44, N'San José de Ticllas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (451, 44, N'San Juan Bautista')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (452, 44, N'Santiago de Pischa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (453, 44, N'Socos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (454, 44, N'Tambillo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (455, 44, N'Vinchos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (456, 45, N'Carapo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (457, 45, N'Sacsamarca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (458, 45, N'Sancos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (459, 45, N'Santiago de Lucanamarca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (460, 46, N'Huanta')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (461, 46, N'Ayahuanco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (462, 46, N'Huamanguilla')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (463, 46, N'Iguain')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (464, 46, N'Llochegua')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (465, 46, N'Luricocha')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (466, 46, N'Santillana')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (467, 46, N'Sivia')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (468, 47, N'San Miguel')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (469, 47, N'Anco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (470, 47, N'Ayna')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (471, 47, N'Chilcas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (472, 47, N'Chungui')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (473, 47, N'Luis Carranza')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (474, 47, N'San Francisco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (475, 47, N'Santa Rosa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (476, 47, N'Tambo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (477, 47, N'Samugari1')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (478, 48, N'Puquio')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (479, 48, N'Aucara')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (480, 48, N'Cabana')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (481, 48, N'Carmen Salcedo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (482, 48, N'Chaviña')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (483, 48, N'Chipao')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (484, 48, N'Huac-Huas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (485, 48, N'Laramate')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (486, 48, N'Leoncio Prado')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (487, 48, N'Llauta')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (488, 48, N'Lucanas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (489, 48, N'Ocaña')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (490, 48, N'Otoca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (491, 48, N'Saisa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (492, 48, N'San Cristóbal')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (493, 48, N'San Juan')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (494, 48, N'San Pedro')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (495, 48, N'San Pedro de Palco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (496, 48, N'Sancos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (497, 48, N'Santa Ana de Huaycahuacho')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (498, 48, N'Santa Lucía')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (499, 49, N'Coracora')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (500, 49, N'Chumpi')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (501, 49, N'Coronel Castañeda')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (502, 49, N'Pacapausa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (503, 49, N'Pullo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (504, 49, N'Puyusca')
GO
print 'Processed 500 total records'
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (505, 49, N'San Francisco de Ravacayco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (506, 49, N'Upahuacho')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (507, 50, N'Pauza')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (508, 50, N'Colta')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (509, 50, N'Corculla')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (510, 50, N'Lampa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (511, 50, N'Marcabamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (512, 50, N'Oyolo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (513, 50, N'Pararca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (514, 50, N'San Javier de Alpabamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (515, 50, N'San José de Ushua')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (516, 50, N'Sara Sara')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (517, 51, N'Querobamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (518, 51, N'Belén')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (519, 51, N'Chalcos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (520, 51, N'Chilcayoc')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (521, 51, N'Huacaña')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (522, 51, N'Morcolla')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (523, 51, N'Paico')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (524, 51, N'San Pedro de Larcay')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (525, 51, N'San Salvador de Quije')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (526, 51, N'Santiago de Paucaray')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (527, 51, N'Soras')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (528, 52, N'Huancapi')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (529, 52, N'Alcamenca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (530, 52, N'Apongo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (531, 52, N'Asquipata')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (532, 52, N'Canaria')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (533, 52, N'Cayara')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (534, 52, N'Colca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (535, 52, N'Huamanquiquia')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (536, 52, N'Huaya')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (537, 52, N'Sarhua')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (538, 52, N'Vilcanchos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (539, 53, N'Vilcashuamán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (540, 53, N'Accomarca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (541, 53, N'Carhuanca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (542, 53, N'Concepción')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (543, 53, N'Huambalpa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (544, 53, N'Independencia')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (545, 53, N'Saurama')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (546, 53, N'Vischongo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (547, 54, N'Cachachi')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (548, 54, N'Cajabamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (549, 54, N'Condebamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (550, 54, N'Sitacocha')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (551, 55, N'Cajamarca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (552, 55, N'Asunción')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (553, 55, N'Chetilla')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (554, 55, N'Cospán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (555, 55, N'Jesús')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (556, 55, N'Llacanora')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (557, 55, N'La Encañada')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (558, 55, N'Los Baños del Inca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (559, 55, N'Magdalena')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (560, 55, N'Matará')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (561, 55, N'Namora')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (562, 55, N'San Juan')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (563, 56, N'Celendín')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (564, 56, N'Chumuch')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (565, 56, N'Cortegana')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (566, 56, N'Huasmin')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (567, 56, N'Jorge Chávez')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (568, 56, N'José Gálvez')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (569, 56, N'La Libertad de Pallán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (570, 56, N'Miguel Iglesias')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (571, 56, N'Oxamarca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (572, 56, N'Sorochuco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (573, 56, N'Sucre')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (574, 56, N'Utco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (575, 57, N'Contumazá')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (576, 57, N'Chilete')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (577, 57, N'Cupisnique')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (578, 57, N'Guzmango')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (579, 57, N'San Benito')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (580, 57, N'Santa Cruz de Toledo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (581, 57, N'Tantarica')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (582, 57, N'Yonán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (583, 58, N'Cutervo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (584, 58, N'Callayuc')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (585, 58, N'Choros')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (586, 58, N'Cujillo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (587, 58, N'La Ramada')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (588, 58, N'Pimpingos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (589, 58, N'Querocotillo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (590, 58, N'San Andrés de Cutervo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (591, 58, N'San Juan de Cutervo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (592, 58, N'San Luis de Lucma')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (593, 58, N'Santa Cruz')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (594, 58, N'Santo Domingo de la Capilla')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (595, 58, N'Santo Tomás')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (596, 58, N'Socota')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (597, 58, N'Toribio Casanova')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (598, 59, N'Chota')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (599, 59, N'Anguía')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (600, 59, N'Chadín')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (601, 59, N'Chalamarca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (602, 59, N'Chiguirip')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (603, 59, N'Chimban')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (604, 59, N'Choropampa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (605, 59, N'Cochabamba')
GO
print 'Processed 600 total records'
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (606, 59, N'Conchán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (607, 59, N'Huambos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (608, 59, N'Lajas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (609, 59, N'Llama')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (610, 59, N'Miracosta')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (611, 59, N'Paccha')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (612, 59, N'Pion')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (613, 59, N'Querocoto')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (614, 59, N'San Juan de Licupis')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (615, 59, N'Tacabamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (616, 59, N'Tocmoche')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (617, 60, N'Bambamarca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (618, 60, N'Chugur')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (619, 60, N'Hualgayoc')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (620, 61, N'Jaén')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (621, 61, N'Bellavista')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (622, 61, N'Chontalí')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (623, 61, N'Colasay')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (624, 61, N'Huabal')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (625, 61, N'Las Pirias')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (626, 61, N'Pomahuaca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (627, 61, N'Pucará')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (628, 61, N'Sallique')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (629, 61, N'San Felipe')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (630, 61, N'San José del Alto')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (631, 61, N'Santa Rosa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (632, 62, N'San Ignacio')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (633, 62, N'Chirinos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (634, 62, N'Huarango')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (635, 62, N'La Coipa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (636, 62, N'Namballe')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (637, 62, N'San José de Lourdes')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (638, 62, N'Tabaconas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (639, 63, N'Pedro Gálvez')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (640, 63, N'Eduardo Villanueva')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (641, 63, N'Gregorio Pita')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (642, 63, N'Ichocán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (643, 63, N'Jose Manuel Quiroz')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (644, 63, N'José Sabogal')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (645, 63, N'Chancay')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (646, 64, N'San Miguel')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (647, 64, N'Bolívar')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (648, 64, N'Calquis')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (649, 64, N'Catilluc')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (650, 64, N'El Prado')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (651, 64, N'La Florida')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (652, 64, N'Llapa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (653, 64, N'Nanchoc')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (654, 64, N'Niepos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (655, 64, N'San Gregorio')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (656, 64, N'San Silvestre de Conchán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (657, 64, N'Tongod')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (658, 64, N'Unión Agua Blanca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (659, 65, N'San Pablo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (660, 65, N'San Bernardino')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (661, 65, N'San Luis')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (662, 65, N'Tumbaden')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (663, 66, N'Santa Cruz')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (664, 66, N'Andabamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (665, 66, N'Catache')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (666, 66, N'Chancaybaños')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (667, 66, N'La Esperanza')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (668, 66, N'Ninabamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (669, 66, N'Pulán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (670, 66, N'Saucepampa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (671, 66, N'Sexi')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (672, 66, N'Uticyacu')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (673, 66, N'Yauyucan')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (674, 66, N'Udima')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (675, 67, N'Acomayo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (676, 67, N'Acopia')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (677, 67, N'Acos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (678, 67, N'Mosoc Llacta')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (679, 67, N'Pomacanchi')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (680, 67, N'Rondocan')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (681, 67, N'Sangarará')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (682, 68, N'Anta')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (683, 68, N'Ancahuasi')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (684, 68, N'Cachimayo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (685, 68, N'Chinchaypujio')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (686, 68, N'Huarocondo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (687, 68, N'Limatambo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (688, 68, N'Mollepata')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (689, 68, N'Pucyura')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (690, 68, N'Zurite')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (691, 69, N'Calca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (692, 69, N'Coya')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (693, 69, N'Lamay')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (694, 69, N'Lares')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (695, 69, N'Pisac')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (696, 69, N'San Salvador')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (697, 69, N'Taray')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (698, 69, N'Yanatile')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (699, 70, N'Yanaoca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (700, 70, N'Checca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (701, 70, N'Kunturkanki')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (702, 70, N'Langui')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (703, 70, N'Layo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (704, 70, N'Pampamarca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (705, 70, N'Quehue')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (706, 70, N'Túpac Amaru')
GO
print 'Processed 700 total records'
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (707, 71, N'Sicuani')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (708, 71, N'Checacupe')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (709, 71, N'Combapata')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (710, 71, N'Marangani')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (711, 71, N'Pitumarca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (712, 71, N'San Pablo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (713, 71, N'San Pedro')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (714, 71, N'Tinta')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (715, 72, N'Cuzco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (716, 72, N'Ccorca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (717, 72, N'Poroy')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (718, 72, N'San Jerónimo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (719, 72, N'San Sebastián')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (720, 72, N'Santiago')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (721, 72, N'Saylla')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (722, 72, N'Wanchaq')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (723, 73, N'Santo Tomás')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (724, 73, N'Capacmarca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (725, 73, N'Chamaca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (726, 73, N'Colquemarca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (727, 73, N'Livitaca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (728, 73, N'Llusco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (729, 73, N'Quiñota')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (730, 73, N'Velille')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (731, 74, N'Yauri')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (732, 74, N'Condoroma')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (733, 74, N'Coporaque')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (734, 74, N'Ocoruro')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (735, 74, N'Pallpata')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (736, 74, N'Pichigua')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (737, 74, N'Suykutambo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (738, 74, N'Alto Pichigua')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (739, 75, N'Santa Ana')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (740, 75, N'Echarate')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (741, 75, N'Huayopata')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (742, 75, N'Kimbiri')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (743, 75, N'Maranura')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (744, 75, N'Ocobamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (745, 75, N'Pichari')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (746, 75, N'Quelloúno')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (747, 75, N'Santa Teresa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (748, 75, N'Vilcabamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (749, 76, N'Paruro')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (750, 76, N'Accha')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (751, 76, N'Ccapi')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (752, 76, N'Colcha')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (753, 76, N'Huanoquite')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (754, 76, N'Omacha')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (755, 76, N'Paccaritambo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (756, 76, N'Pillpinto')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (757, 76, N'Yaurisque')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (758, 77, N'Paucartambo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (759, 77, N'Caicay')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (760, 77, N'Challabamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (761, 77, N'Colquepata')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (762, 77, N'Huancarani')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (763, 77, N'Kosñipata')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (764, 78, N'Andahuaylillas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (765, 78, N'Camanti')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (766, 78, N'Ccarhuayo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (767, 78, N'Ccatca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (768, 78, N'Cusipata')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (769, 78, N'Huaro')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (770, 78, N'Lucre')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (771, 78, N'Marcapata')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (772, 78, N'Ocongate')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (773, 78, N'Oropesa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (774, 78, N'Quiquijana')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (775, 78, N'Urcos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (776, 79, N'Urubamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (777, 79, N'Chinchero')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (778, 79, N'Huayllabamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (779, 79, N'Machupicchu')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (780, 79, N'Maras')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (781, 79, N'Ollantaytambo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (782, 79, N'Yucay')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (783, 80, N'Acobamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (784, 80, N'Andabamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (785, 80, N'Anta')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (786, 80, N'Caja')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (787, 80, N'Marcas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (788, 80, N'Paucará')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (789, 80, N'Pomacocha')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (790, 80, N'Rosario')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (791, 81, N'Lircay')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (792, 81, N'Anchonga')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (793, 81, N'Callanmarca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (794, 81, N'Ccochaccasa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (795, 81, N'Chincho')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (796, 81, N'Congalla')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (797, 81, N'Huanca-Huanca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (798, 81, N'Huayllay Grande')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (799, 81, N'Julcamarca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (800, 81, N'San Antonio de Antaparco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (801, 81, N'Santo Tomás de Pata')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (802, 81, N'Seclla')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (803, 82, N'Castrovirreyna')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (804, 82, N'Arma')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (805, 82, N'Aurahuá')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (806, 82, N'Capillas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (807, 82, N'Chupamarca')
GO
print 'Processed 800 total records'
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (808, 82, N'Cocas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (809, 82, N'Huachos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (810, 82, N'Huamatambo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (811, 82, N'Mollepampa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (812, 82, N'San Juan')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (813, 82, N'Santa Ana')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (814, 82, N'Tantara')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (815, 82, N'Ticrapo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (816, 83, N'Churcampa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (817, 83, N'Anco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (818, 83, N'Chinchihuasi')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (819, 83, N'Cosme1')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (820, 83, N'El Carmen')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (821, 83, N'La Merced')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (822, 83, N'Locroja')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (823, 83, N'Pachamarca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (824, 83, N'Paucarbamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (825, 83, N'San Miguel de Mayocc')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (826, 83, N'San Pedro de Coris')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (827, 84, N'Acobambilla')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (828, 84, N'Acoria')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (829, 84, N'Ascención')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (830, 84, N'Conayca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (831, 84, N'Cuenca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (832, 84, N'Huachocolpa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (833, 84, N'Huando')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (834, 84, N'Huancavelica')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (835, 84, N'Huayllahuara')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (836, 84, N'Izcuchaca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (837, 84, N'Laria')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (838, 84, N'Manta')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (839, 84, N'Mariscal Cáceres')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (840, 84, N'Moya')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (841, 84, N'Nuevo Occoro')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (842, 84, N'Palca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (843, 84, N'Pilchaca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (844, 84, N'Vilca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (845, 84, N'Yauli')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (846, 85, N'Huaytará')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (847, 85, N'Ayaví')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (848, 85, N'Córdova')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (849, 85, N'Huayacundo Arma')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (850, 85, N'Laramarca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (851, 85, N'Ocoyo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (852, 85, N'Pilpichaca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (853, 85, N'Querco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (854, 85, N'Quito-Arma')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (855, 85, N'San Antonio de Cusicancha')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (856, 85, N'San Francisco de Sangayaico')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (857, 85, N'San Isidro')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (858, 85, N'Santiago de Chocorvos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (859, 85, N'Santiago de Quirahuara')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (860, 85, N'Santo Domingo de Capillas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (861, 85, N'Tambo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (862, 86, N'Pampas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (863, 86, N'Acostambo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (864, 86, N'Acraquía')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (865, 86, N'Ahuaycha')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (866, 86, N'Colcabamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (867, 86, N'Daniel Hernández')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (868, 86, N'Huachocolpa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (869, 86, N'Huaribamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (870, 86, N'Ñahuimpuquio')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (871, 86, N'Pazos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (872, 86, N'Quishuar')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (873, 86, N'Salcabamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (874, 86, N'Salcahuasi')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (875, 86, N'San Marcos de Rocchac')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (876, 86, N'Surcubamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (877, 86, N'Tintay Puncu')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (878, 87, N'Ambo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (879, 87, N'Cayna')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (880, 87, N'Colpas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (881, 87, N'Conchamarca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (882, 87, N'Huacar')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (883, 87, N'San Francisco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (884, 87, N'San Rafael')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (885, 87, N'Tomay Kichwa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (886, 88, N'La Unión')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (887, 88, N'Chuquis')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (888, 88, N'Marías')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (889, 88, N'Pachas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (890, 88, N'Quivilla')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (891, 88, N'Ripán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (892, 88, N'Shunqui')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (893, 88, N'Sillapata')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (894, 88, N'Yanas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (895, 89, N'Huacaybamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (896, 89, N'Canchabamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (897, 89, N'Cochabamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (898, 89, N'Pinra')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (899, 90, N'Llata')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (900, 90, N'Arancay')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (901, 90, N'Chavín de Pariarca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (902, 90, N'Jacas Grande')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (903, 90, N'Jircan')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (904, 90, N'Miraflores')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (905, 90, N'Monzón')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (906, 90, N'Punchao')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (907, 90, N'Puños')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (908, 90, N'Singa')
GO
print 'Processed 900 total records'
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (909, 90, N'Tantamayo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (910, 90, N'Huanuquito')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (911, 91, N'Huánuco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (912, 91, N'Amarilis')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (913, 91, N'Chinchao')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (914, 91, N'Churumbamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (915, 91, N'Margos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (916, 91, N'Pillco Marca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (917, 91, N'Quisqui (Kichki)')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (918, 91, N'San Francisco de Cayrán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (919, 91, N'San Pedro de Chaulán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (920, 91, N'Santa María del Valle')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (921, 91, N'Yarumayo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (922, 91, N'Yacus')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (923, 92, N'Rupa-Rupa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (924, 92, N'Daniel Alomía Robles')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (925, 92, N'Hermilio Valdizán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (926, 92, N'José Crespo y Castillo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (927, 92, N'Luyando')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (928, 92, N'Mariano Dámaso Beraún')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (929, 93, N'Huacrachuco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (930, 93, N'Cholón')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (931, 93, N'San Buenaventura')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (932, 94, N'Panao')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (933, 94, N'Chaglla')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (934, 94, N'Molino')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (935, 94, N'Umari')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (936, 95, N'Puerto Inca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (937, 95, N'Codo del Pozuzo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (938, 95, N'Honoria')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (939, 95, N'Tournavista')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (940, 95, N'Yuyapichis')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (941, 96, N'Chavinillo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (942, 96, N'Cahuac')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (943, 96, N'Chacabamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (944, 96, N'Aparicio Pomares')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (945, 96, N'Jacas Chico')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (946, 96, N'Obas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (947, 96, N'Pampamarca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (948, 96, N'Choras')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (949, 97, N'Baños')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (950, 97, N'Jesús')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (951, 97, N'Jivia')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (952, 97, N'Queropalca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (953, 97, N'Rondos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (954, 97, N'San Francisco de Asís')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (955, 97, N'San Miguel de Cauri')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (956, 97, N'Lichkacachka')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (957, 98, N'Chincha Alta')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (958, 98, N'Alto Larán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (959, 98, N'Chavín')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (960, 98, N'Chincha Baja')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (961, 98, N'El Carmen')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (962, 98, N'Grocio Prado')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (963, 98, N'Pueblo Nuevo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (964, 98, N'San Juan de Yanac')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (965, 98, N'San Pedro de Huacarpana')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (966, 98, N'Sunampe')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (967, 98, N'Tambo de Mora')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (968, 99, N'Ica')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (969, 99, N'La Tinguiña')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (970, 99, N'Los Aquijes')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (971, 99, N'Ocucaje')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (972, 99, N'Pachacutec')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (973, 99, N'Parcona')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (974, 99, N'Pueblo Nuevo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (975, 99, N'Salas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (976, 99, N'San José de los Molinos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (977, 99, N'San Juan Bautista')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (978, 99, N'Santiago')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (979, 99, N'Subtanjalla')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (980, 99, N'Tate')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (981, 99, N'Yauca del Rosario')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (982, 100, N'Nazca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (983, 100, N'Changuillo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (984, 100, N'El Ingenio')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (985, 100, N'Marcona')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (986, 100, N'Vista Alegre')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (987, 101, N'Palpa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (988, 101, N'Llipata')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (989, 101, N'Río Grande')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (990, 101, N'Santa Cruz')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (991, 101, N'Tibillo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (992, 102, N'Pisco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (993, 102, N'Huancano')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (994, 102, N'Humay')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (995, 102, N'Independencia')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (996, 102, N'Paracas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (997, 102, N'San Andrés')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (998, 102, N'San Clemente')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (999, 102, N'Túpac Amaru Inca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1000, 103, N'Concepción')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1001, 103, N'Aco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1002, 103, N'Andamarca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1003, 103, N'Chambara')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1004, 103, N'Cochas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1005, 103, N'Comas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1006, 103, N'Heroínas Toledo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1007, 103, N'Manzanares')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1008, 103, N'Mariscal Castilla')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1009, 103, N'Matahuasi')
GO
print 'Processed 1000 total records'
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1010, 103, N'Mito')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1011, 103, N'Nueve de Julio')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1012, 103, N'Orcotuna')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1013, 103, N'San José de Quero')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1014, 103, N'Santa Rosa de Ocopa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1015, 104, N'Chanchamayo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1016, 104, N'San Luis de Shuaro')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1017, 104, N'Perené')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1018, 104, N'Pichanaqui')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1019, 104, N'San Ramón')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1020, 104, N'Vitoc')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1021, 105, N'Chupaca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1022, 105, N'Ahuac')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1023, 105, N'Chongos Bajo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1024, 105, N'Huachac')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1025, 105, N'Huamancaca Chico')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1026, 105, N'San Juan de Yscos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1027, 105, N'San Juan de Jarpa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1028, 105, N'Tres de Diciembre')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1029, 105, N'Yanacancha')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1030, 106, N'Huancayo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1031, 106, N'Carhuacallanga')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1032, 106, N'Chacapampa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1033, 106, N'Chicche')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1034, 106, N'Chilca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1035, 106, N'Chongos Alto')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1036, 106, N'Chupuro')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1037, 106, N'Colca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1038, 106, N'Cullhuas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1039, 106, N'El Tambo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1040, 106, N'Huacrapuquio')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1041, 106, N'Hualhuas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1042, 106, N'Huancán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1043, 106, N'Huasicancha')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1044, 106, N'Huayucachi')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1045, 106, N'Ingenio')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1046, 106, N'Pariahuanca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1047, 106, N'Pilcomayo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1048, 106, N'Pucará')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1049, 106, N'Qhichuay')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1050, 106, N'Quilcas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1051, 106, N'San Agustín de Cajas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1052, 106, N'San Jerónimo de Tunán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1053, 106, N'San Pedro de Saño')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1054, 106, N'Santo Domingo de Acobamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1055, 106, N'Sapallanga')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1056, 106, N'Sicaya')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1057, 106, N'Viques')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1058, 107, N'Jauja')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1059, 107, N'Acolla')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1060, 107, N'Apata')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1061, 107, N'Ataura')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1062, 107, N'Canchayllo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1063, 107, N'Curicaca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1064, 107, N'El Mantaro')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1065, 107, N'Huamalí')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1066, 107, N'Huaripampa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1067, 107, N'Huertas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1068, 107, N'Janjaillo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1069, 107, N'Julcán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1070, 107, N'Leonor Ordóñez')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1071, 107, N'Llocllapampa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1072, 107, N'Marco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1073, 107, N'Masma')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1074, 107, N'Masma Chicche')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1075, 107, N'Molinos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1076, 107, N'Monobamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1077, 107, N'Muqui')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1078, 107, N'Muquiyauyo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1079, 107, N'Paca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1080, 107, N'Paccha')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1081, 107, N'Pancán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1082, 107, N'Parco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1083, 107, N'Pomacancha')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1084, 107, N'Ricrán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1085, 107, N'San Lorenzo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1086, 107, N'San Pedro de Chunán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1087, 107, N'Sausa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1088, 107, N'Sincos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1089, 107, N'Tunan Marca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1090, 107, N'Yauli')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1091, 107, N'Yauyos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1092, 108, N'Junín')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1093, 108, N'Carhuamayo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1094, 108, N'Ondores')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1095, 108, N'Ulcumayo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1096, 109, N'Satipo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1097, 109, N'Coviriali')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1098, 109, N'Llaylla')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1099, 109, N'Mazamari')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1100, 109, N'Pampa Hermosa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1101, 109, N'Pangoa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1102, 109, N'Río Negro')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1103, 109, N'Río Tambo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1104, 110, N'Tarma')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1105, 110, N'Acobamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1106, 110, N'Huaricolca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1107, 110, N'Huasahuasi')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1108, 110, N'La Unión')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1109, 110, N'Palca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1110, 110, N'Palcamayo')
GO
print 'Processed 1100 total records'
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1111, 110, N'San Pedro de Cajas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1112, 110, N'Tapo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1113, 111, N'La Oroya')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1114, 111, N'Cacapalpa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1115, 111, N'Huay-Huay')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1116, 111, N'Marcapomacocha')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1117, 111, N'Morococha')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1118, 111, N'Paccha')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1119, 111, N'Santa Barbara de Carhuacayán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1120, 111, N'Santa Rosa de Sacco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1121, 111, N'Suitucancha')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1122, 111, N'Yauli')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1123, 112, N'Ascope')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1124, 112, N'Chicama')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1125, 112, N'Chocope')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1126, 112, N'Magdalena de Cao')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1127, 112, N'Paiján')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1128, 112, N'Rázuri')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1129, 112, N'Santiago de Cao')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1130, 112, N'Casa Grande')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1131, 113, N'Bolívar')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1132, 113, N'Bambamarca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1133, 113, N'Condormarca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1134, 113, N'Longotea')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1135, 113, N'Uchumarca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1136, 113, N'Ucuncha')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1137, 114, N'Chepén')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1138, 114, N'Pacanga')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1139, 114, N'Pueblo Nuevo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1140, 115, N'Cascas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1141, 115, N'Lucma')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1142, 115, N'Marmot')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1143, 115, N'Sayapullo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1144, 116, N'Julcán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1145, 116, N'Calamarca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1146, 116, N'Carabamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1147, 116, N'Huaso')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1148, 117, N'Otuzco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1149, 117, N'Agallpampa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1150, 117, N'Charat')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1151, 117, N'Huaranchal')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1152, 117, N'La Cuesta')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1153, 117, N'Mache')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1154, 117, N'Paranday')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1155, 117, N'Salpo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1156, 117, N'Sinsicap')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1157, 117, N'Usquil')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1158, 118, N'San Pedro de Lloc')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1159, 118, N'Guadalupe')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1160, 118, N'Jequetepeque')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1161, 118, N'Pacasmayo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1162, 118, N'San José')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1163, 119, N'Tayabamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1164, 119, N'Buldibuyo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1165, 119, N'Chillia')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1166, 119, N'Huancaspata')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1167, 119, N'Huaylillas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1168, 119, N'Huayo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1169, 119, N'Ongón')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1170, 119, N'Parcoy')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1171, 119, N'Patáz')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1172, 119, N'Pías')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1173, 119, N'Challas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1174, 119, N'Taurija')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1175, 119, N'Urpay')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1176, 120, N'Huamachuco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1177, 120, N'Chugay')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1178, 120, N'Cochorco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1179, 120, N'Curgos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1180, 120, N'Marcabal')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1181, 120, N'Sanagorán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1182, 120, N'Sarín')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1183, 120, N'Sartimbamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1184, 121, N'Santiago de Chuco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1185, 121, N'Angasmarca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1186, 121, N'Cachicadán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1187, 121, N'Mollebamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1188, 121, N'Mollepata')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1189, 121, N'Quiruvilca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1190, 121, N'Santa Cruz de Chuca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1191, 121, N'Sitabamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1192, 122, N'Trujillo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1193, 122, N'El Porvenir')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1194, 122, N'Florencia de Mora')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1195, 122, N'Huanchaco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1196, 122, N'La Esperanza')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1197, 122, N'Laredo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1198, 122, N'Moche')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1199, 122, N'Poroto')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1200, 122, N'Salaverry')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1201, 122, N'Simbal')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1202, 122, N'Victor Larco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1203, 123, N'Virú')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1204, 123, N'Chao')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1205, 123, N'Guadalupito')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1206, 124, N'Chiclayo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1207, 124, N'Cayalti')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1208, 124, N'Chongoyape')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1209, 124, N'Etén')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1210, 124, N'Puerto Etén')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1211, 124, N'José Leonardo Ortiz')
GO
print 'Processed 1200 total records'
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1212, 124, N'La Victoria')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1213, 124, N'Lagunas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1214, 124, N'Monsefu')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1215, 124, N'Nueva Arica')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1216, 124, N'Oyotún')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1217, 124, N'Patapo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1218, 124, N'Picsi')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1219, 124, N'Pimentel')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1220, 124, N'Pomalca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1221, 124, N'Pucalá')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1222, 124, N'Reque')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1223, 124, N'Santa Rosa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1224, 124, N'Tumán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1225, 124, N'Saña')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1226, 125, N'Ferreñafe')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1227, 125, N'Cañaris')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1228, 125, N'Incahuasi')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1229, 125, N'Manuel Antonio Mesones Muro')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1230, 125, N'Pítipo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1231, 125, N'Pueblo Nuevo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1232, 126, N'Lambayeque')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1233, 126, N'Chóchope')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1234, 126, N'Íllimo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1235, 126, N'Jayanca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1236, 126, N'Mochumí')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1237, 126, N'Mórrope')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1238, 126, N'Motupe')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1239, 126, N'Olmos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1240, 126, N'Pacora')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1241, 126, N'Salas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1242, 126, N'San José')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1243, 126, N'Túcume')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1244, 127, N'Barranca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1245, 127, N'Paramonga')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1246, 127, N'Pativilca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1247, 127, N'Supe')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1248, 127, N'Supe Puerto')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1249, 128, N'Manás')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1250, 128, N'Gorgor')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1251, 128, N'Huancapón')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1252, 128, N'Cajatambo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1253, 128, N'Copa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1254, 129, N'Canta')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1255, 129, N'Arahuay')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1256, 129, N'Huamantanga')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1257, 129, N'Huaros')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1258, 129, N'Lachaqui')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1259, 129, N'San Buenaventura')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1260, 129, N'Santa Rosa de Quives')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1261, 130, N'Asia')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1262, 130, N'Calango')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1263, 130, N'Cerro Azul')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1264, 130, N'Chilca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1265, 130, N'Coayllo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1266, 130, N'Imperial')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1267, 130, N'Lunahuaná')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1268, 130, N'Mala')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1269, 130, N'Nuevo Imperial')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1270, 130, N'Pacarán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1271, 130, N'Quilmaná')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1272, 130, N'San Antonio')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1273, 130, N'San Luis')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1274, 130, N'San Vicente de Cañete')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1275, 130, N'Santa Cruz de Flores')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1276, 130, N'Zúñiga')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1277, 131, N'27 de noviembre')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1278, 131, N'Atavillos Alto')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1279, 131, N'Atavillos Bajo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1280, 131, N'Aucallama')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1281, 131, N'Chancay')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1282, 131, N'Huaral')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1283, 131, N'Ihuarí')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1284, 131, N'Lampían')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1285, 131, N'Pacaraos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1286, 131, N'Santa Cruz de Andamarca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1287, 131, N'Sumbilca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1288, 131, N'San Miguel de Acos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1289, 132, N'Matucana')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1290, 132, N'Antioquía')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1291, 132, N'Callahuanca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1292, 132, N'Carampoma')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1293, 132, N'Chicla')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1294, 132, N'Cuenca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1295, 132, N'Huachupampa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1296, 132, N'Huanza')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1297, 132, N'Huarochirí')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1298, 132, N'Lahuaytambo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1299, 132, N'Langa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1300, 132, N'Laraos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1301, 132, N'Mariatana')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1302, 132, N'Ricardo Palma')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1303, 132, N'San Andrés de Tupicocha')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1304, 132, N'San Antonio de Chaclla')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1305, 132, N'San Bartolomé')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1306, 132, N'San Damián')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1307, 132, N'San Juan de Iris')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1308, 132, N'San Juan de Tantaranche')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1309, 132, N'San Lorenzo de Quinti')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1310, 132, N'San Mateo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1311, 132, N'San Mateo de Otao')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1312, 132, N'San Pedro de Casta')
GO
print 'Processed 1300 total records'
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1313, 132, N'San Pedro de Huancayre')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1314, 132, N'Sangallaya')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1315, 132, N'Santa Cruz de Cocachacra')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1316, 132, N'Santa Eulalia')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1317, 132, N'Santiago de Anchucaya')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1318, 132, N'Santiago de Tuna')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1319, 132, N'Santo Domingo de los Olleros')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1320, 132, N'San Jerónimo de Surco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1321, 133, N'Huacho')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1322, 133, N'Ámbar')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1323, 133, N'Caleta de Carquín')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1324, 133, N'Checras')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1325, 133, N'Hualmay')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1326, 133, N'Huaura')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1327, 133, N'Leoncio Prado')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1328, 133, N'Paccho')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1329, 133, N'Santa Leonor')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1330, 133, N'Santa María')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1331, 133, N'Sayán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1332, 133, N'Vegueta')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1333, 134, N'Lima')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1334, 134, N'Ancón')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1335, 134, N'Ate')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1336, 134, N'Barranco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1337, 134, N'Breña')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1338, 134, N'Carabayllo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1339, 134, N'Chaclacayo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1340, 134, N'Chorrillos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1341, 134, N'Cieneguilla')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1342, 134, N'Comas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1343, 134, N'El Agustino')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1344, 134, N'Independencia')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1345, 134, N'Jesús María')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1346, 134, N'La Molina')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1347, 134, N'La Victoria')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1348, 134, N'Lince')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1349, 134, N'Los Olivos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1350, 134, N'Lurigancho-Chosica')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1351, 134, N'Lurin')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1352, 134, N'Magdalena del Mar')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1353, 134, N'Pueblo Libre')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1354, 134, N'Miraflores')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1355, 134, N'Pachacámac')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1356, 134, N'Pucusana')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1357, 134, N'Puente Piedra')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1358, 134, N'Punta Hermosa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1359, 134, N'Punta Negra')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1360, 134, N'Rímac')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1361, 134, N'San Bartolo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1362, 134, N'San Borja')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1363, 134, N'San Isidro')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1364, 134, N'San Juan de Lurigancho')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1365, 134, N'San Juan de Mirafloresv')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1366, 134, N'San Luis')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1367, 134, N'San Martín de Porres')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1368, 134, N'San Miguel')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1369, 134, N'Santa Anita')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1370, 134, N'Santa María del Mar')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1371, 134, N'Santa Rosa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1372, 134, N'Santiago de Surco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1373, 134, N'Surquillo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1374, 134, N'Villa El Salvador')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1375, 134, N'Villa María del Triunfo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1376, 135, N'Oyón')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1377, 135, N'Andajes')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1378, 135, N'Caujul')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1379, 135, N'Cochamarca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1380, 135, N'Naván')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1381, 135, N'Pachangara')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1382, 136, N'Yauyos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1383, 136, N'Alis')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1384, 136, N'Ayauca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1385, 136, N'Ayaviri')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1386, 136, N'Azángaro')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1387, 136, N'Cacra')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1388, 136, N'Carania')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1389, 136, N'Catahuasi')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1390, 136, N'Chocos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1391, 136, N'Cochas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1392, 136, N'Colonia')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1393, 136, N'Hongos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1394, 136, N'Huampara')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1395, 136, N'Huancaya')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1396, 136, N'Huangáscar')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1397, 136, N'Huantán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1398, 136, N'Huañec')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1399, 136, N'Laraos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1400, 136, N'Lincha')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1401, 136, N'Madean')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1402, 136, N'Miraflores')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1403, 136, N'Omas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1404, 136, N'San Lorenzo de Putinza')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1405, 136, N'Quinches')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1406, 136, N'Quinocay')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1407, 136, N'San Joaquín')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1408, 136, N'San Pedro de Pilas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1409, 136, N'Tanta')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1410, 136, N'Tauripampa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1411, 136, N'Tomas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1412, 136, N'Tupe')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1413, 136, N'Viñac')
GO
print 'Processed 1400 total records'
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1414, 136, N'Vitis')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1415, 137, N'Prov. Const. Callao')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1416, 138, N'Yurimaguas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1417, 138, N'Balsapuerto')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1418, 138, N'Jeberos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1419, 138, N'Lagunas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1420, 138, N'Santa Cruz')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1421, 138, N'Teniente César López Rojas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1422, 139, N'Nauta')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1423, 139, N'Parinari')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1424, 139, N'Tigre')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1425, 139, N'Trompeteros')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1426, 139, N'Urarinas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1427, 140, N'Ramón Castilla')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1428, 140, N'Pebas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1429, 140, N'Yavari')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1430, 140, N'San Pablo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1431, 141, N'Iquitos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1432, 141, N'Alto Nanay')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1433, 141, N'Fernando Lores')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1434, 141, N'Indiana')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1435, 141, N'Las Amazonas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1436, 141, N'Mazán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1437, 141, N'Napo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1438, 141, N'Punchana')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1439, 141, N'Putumayo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1440, 141, N'Torres Causana')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1441, 141, N'Belen')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1442, 141, N'San Juan Bautista')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1443, 141, N'Teniente Manuel Clavero')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1444, 142, N'Requena')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1445, 142, N'Alto Tapiche')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1446, 142, N'Capelo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1447, 142, N'Emilio San Martín')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1448, 142, N'Maquía')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1449, 142, N'Puinahua')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1450, 142, N'Saquena')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1451, 142, N'Soplin')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1452, 142, N'Tapiche')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1453, 142, N'Jenaro Herrera')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1454, 142, N'Yaquerana')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1455, 143, N'Contamana')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1456, 143, N'Inahuaya')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1457, 143, N'Padre Márquez')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1458, 143, N'Pampa Hermosa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1459, 143, N'Sarayacu')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1460, 143, N'Alfredo Vargas Guerra')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1461, 143, N'Yanayacu')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1462, 144, N'Manu')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1463, 144, N'Fitzcarrald')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1464, 144, N'Madre de Dios')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1465, 144, N'Huepetuhe')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1466, 145, N'Iñapari')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1467, 145, N'Iberia')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1468, 145, N'Tahuamanu')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1469, 146, N'Tambopata')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1470, 146, N'Inambari')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1471, 146, N'Las Piedras')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1472, 146, N'Laberinto')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1473, 147, N'Ilo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1474, 147, N'El Algarrobal')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1475, 147, N'Pacocha')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1476, 148, N'Moquegua')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1477, 148, N'Carumas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1478, 148, N'Cuchumbaya')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1479, 148, N'Samegua')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1480, 148, N'San Cristobal de Calacoa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1481, 148, N'Torata')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1482, 149, N'Omate')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1483, 149, N'Chojata')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1484, 149, N'Coalaque')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1485, 149, N'Ichuña')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1486, 149, N'La Capilla')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1487, 149, N'Lloque')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1488, 149, N'Matalaque')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1489, 149, N'Puquina')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1490, 149, N'Quinistaquillas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1491, 149, N'Ubinas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1492, 149, N'Yunga')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1493, 150, N'Yanahuanca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1494, 150, N'Chacayán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1495, 150, N'Goyllarisquizga')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1496, 150, N'Paucar')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1497, 150, N'San Pedro de Pillao')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1498, 150, N'Santa Ana de Tusi')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1499, 150, N'Tapuc')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1500, 150, N'Vilcabamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1501, 151, N'Oxapampa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1502, 151, N'Chontabamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1503, 151, N'Huancabamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1504, 151, N'Palcazú')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1505, 151, N'Pozuzo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1506, 151, N'Puerto Bermúdez')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1507, 151, N'Villa Rica')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1508, 151, N'Ciudad Constitución')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1509, 152, N'Chaupimarca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1510, 152, N'Huachón')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1511, 152, N'Huariaca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1512, 152, N'Huayllay')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1513, 152, N'Ninacaca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1514, 152, N'Pallanchacra')
GO
print 'Processed 1500 total records'
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1515, 152, N'Paucartambo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1516, 152, N'San Francisco de Asís de Yarusyacán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1517, 152, N'Simón Bolívar')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1518, 152, N'Ticlacayán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1519, 152, N'Tinyahuarco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1520, 152, N'Vicco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1521, 152, N'Yanacancha')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1522, 153, N'Ayabaca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1523, 153, N'Frías')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1524, 153, N'Jililí')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1525, 153, N'Lagunas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1526, 153, N'Montero')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1527, 153, N'Pacaipampa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1528, 153, N'Paimas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1529, 153, N'Sapillica')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1530, 153, N'Sicchez')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1531, 153, N'Suyo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1532, 154, N'Huancabamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1533, 154, N'Canchaque')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1534, 154, N'El Carmen de la Frontera')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1535, 154, N'Huarmaca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1536, 154, N'Lalaquiz')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1537, 154, N'San Miguel de El Faique')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1538, 154, N'Sondor')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1539, 154, N'Sondorillo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1540, 155, N'Chulucanas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1541, 155, N'Buenos Aires')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1542, 155, N'Chalaco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1543, 155, N'La Matanza')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1544, 155, N'Morropón')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1545, 155, N'Salitral')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1546, 155, N'San Juan de Bigote')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1547, 155, N'Santa Catalina de Mossa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1548, 155, N'Santo Domingo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1549, 155, N'Yamango')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1550, 156, N'Paita')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1551, 156, N'Amotape')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1552, 156, N'Colán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1553, 156, N'El Arenal')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1554, 156, N'La Huaca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1555, 156, N'Tamarindo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1556, 156, N'Vichayal')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1557, 157, N'Piura')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1558, 157, N'Castilla')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1559, 157, N'Catacaos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1560, 157, N'Cura Mori')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1561, 157, N'El Tallán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1562, 157, N'La Arena')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1563, 157, N'La Unión')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1564, 157, N'Las Lomas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1565, 157, N'Tambo Grande')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1566, 158, N'Sechura')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1567, 158, N'Bellavista de la Unión')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1568, 158, N'Bernal')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1569, 158, N'Cristo nos Valga')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1570, 158, N'Rinconada Llicuar')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1571, 158, N'Vice')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1572, 159, N'Sullana')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1573, 159, N'Bellavista')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1574, 159, N'Ignacio Escudero')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1575, 159, N'Lancones')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1576, 159, N'Marcavelica')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1577, 159, N'Miguel Checa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1578, 159, N'Querecotillo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1579, 159, N'Salitral')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1580, 160, N'Pariñas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1581, 160, N'El Alto')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1582, 160, N'La Brea')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1583, 160, N'Lobitos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1584, 160, N'Los Órganos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1585, 160, N'Máncora')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1586, 161, N'Azángaro')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1587, 161, N'Achaya')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1588, 161, N'Arapa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1589, 161, N'Asillo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1590, 161, N'Caminaca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1591, 161, N'Chupa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1592, 161, N'José Domingo Choquehuanca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1593, 161, N'Muñani')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1594, 161, N'Potoni')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1595, 161, N'Samán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1596, 161, N'San Antón')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1597, 161, N'San José')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1598, 161, N'San Juan de Salinas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1599, 161, N'Santiago de Pupuja')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1600, 161, N'Tirapata')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1601, 162, N'Ajoyani')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1602, 162, N'Ayapata')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1603, 162, N'Coasa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1604, 162, N'Corani')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1605, 162, N'Crucero')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1606, 162, N'Ituata')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1607, 162, N'Macusani')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1608, 162, N'Ollachea')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1609, 162, N'San Gabán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1610, 162, N'Usicayos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1611, 163, N'Desaguadero')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1612, 163, N'Huacullani')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1613, 163, N'Juli')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1614, 163, N'Kelluyo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1615, 163, N'Pisacoma')
GO
print 'Processed 1600 total records'
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1616, 163, N'Pomata')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1617, 163, N'Zepita')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1618, 164, N'Capazo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1619, 164, N'Conduriri')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1620, 164, N'Ilave')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1621, 164, N'Pilcuyo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1622, 164, N'Santa Rosa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1623, 165, N'Cojata')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1624, 165, N'Huancané')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1625, 165, N'Huatasani')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1626, 165, N'Inchupalla')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1627, 165, N'Pusi')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1628, 165, N'Rosaspata')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1629, 165, N'Taraco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1630, 165, N'Vilque Chico')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1631, 166, N'Cabanilla')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1632, 166, N'Calapuja')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1633, 166, N'Lampa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1634, 166, N'Nicasio')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1635, 166, N'Ocuviri')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1636, 166, N'Palca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1637, 166, N'Paratia')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1638, 166, N'Pucará')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1639, 166, N'Santa Lucía')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1640, 166, N'Vilavila')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1641, 167, N'Antauta')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1642, 167, N'Ayaviri')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1643, 167, N'Cupi')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1644, 167, N'Llalli')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1645, 167, N'Macari')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1646, 167, N'Ñuñoa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1647, 167, N'Orurillo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1648, 167, N'Santa Rosa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1649, 167, N'Umachiri')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1650, 168, N'Conina')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1651, 168, N'Huayrapata')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1652, 168, N'Moho')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1653, 168, N'Tilali')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1654, 169, N'Ananea')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1655, 169, N'Pedro Vilca Apaza')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1656, 169, N'Putina')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1657, 169, N'Quilcapuncu')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1658, 169, N'Sina')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1659, 170, N'Cabana')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1660, 170, N'Cabanillas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1661, 170, N'Caracoto')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1662, 170, N'Juliaca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1663, 171, N'Massiapo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1664, 171, N'Cuyocuyo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1665, 171, N'Limbani')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1666, 171, N'Patambuco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1667, 171, N'Quiaca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1668, 171, N'San Juan del Oro')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1669, 171, N'San Pedro de Putina Punco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1670, 171, N'Sandia')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1671, 171, N'Yanahuaya')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1672, 171, N'Phara')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1673, 172, N'Ácora')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1674, 172, N'Amantaní')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1675, 172, N'Atuncolla')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1676, 172, N'Capachica')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1677, 172, N'Chucuito')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1678, 172, N'Coata')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1679, 172, N'Huata')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1680, 172, N'Mañazo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1681, 172, N'Paucarcolla')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1682, 172, N'Pichacani')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1683, 172, N'Platería')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1684, 172, N'Puno')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1685, 172, N'San Antonio')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1686, 172, N'Tiquillaca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1687, 172, N'Vilque')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1688, 173, N'Yunguyo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1689, 173, N'Anapia')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1690, 173, N'Copani')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1691, 173, N'Cuturapi')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1692, 173, N'Ollaraya')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1693, 173, N'Tinicachi')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1694, 173, N'Unicachi')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1695, 174, N'Bellavista')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1696, 174, N'Alto Biavo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1697, 174, N'Bajo Biavo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1698, 174, N'Huallaga')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1699, 174, N'San Pablo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1700, 174, N'San Rafael')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1701, 175, N'San José de Sisa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1702, 175, N'Agua Blanca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1703, 175, N'San Martín')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1704, 175, N'Santa Rosa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1705, 175, N'Shantoja')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1706, 176, N'Saposoa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1707, 176, N'Alto Saposoa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1708, 176, N'El Eslabón')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1709, 176, N'Piscoyacu')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1710, 176, N'Sacanche')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1711, 176, N'Tingo de Saposoa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1712, 177, N'Lamas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1713, 177, N'Alonso de Alvarado')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1714, 177, N'Barranquita')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1715, 177, N'Caynarachi')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1716, 177, N'Cuñumbuqui')
GO
print 'Processed 1700 total records'
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1717, 177, N'Pinto Recodo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1718, 177, N'Rumisapa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1719, 177, N'San Roque de Cumbaza')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1720, 177, N'Shanao')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1721, 177, N'Tabalosos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1722, 177, N'Zapatero')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1723, 178, N'Juanjuí')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1724, 178, N'Campanilla')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1725, 178, N'Huicungo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1726, 178, N'Pachiza')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1727, 178, N'Pajarillo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1728, 178, N'Juanjuicillo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1729, 179, N'Moyobamba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1730, 179, N'Calzada')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1731, 179, N'Habana')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1732, 179, N'Jepelacio')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1733, 179, N'Soritor')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1734, 179, N'Yantalo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1735, 180, N'Picota')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1736, 180, N'Buenos Aires')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1737, 180, N'Caspisapa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1738, 180, N'Pilluana')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1739, 180, N'Pucacaca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1740, 180, N'San Cristóbal')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1741, 180, N'San Hilarión')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1742, 180, N'Shamboyacu')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1743, 180, N'Leoncio Prado')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1744, 180, N'Tingo de Ponazav')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1745, 180, N'Tres Unidos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1746, 181, N'Rioja')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1747, 181, N'Awajún')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1748, 181, N'Elías Soplín Vargas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1749, 181, N'Nueva Cajamarca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1750, 181, N'Pardo Miguel')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1751, 181, N'Posic')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1752, 181, N'San Fernando')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1753, 181, N'Yorongos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1754, 181, N'Yuracyacu')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1755, 182, N'Tarapoto')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1756, 182, N'Alberto Leveau')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1757, 182, N'Cacatachi')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1758, 182, N'Chazuta')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1759, 182, N'Chipurana')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1760, 182, N'El Porvenir')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1761, 182, N'Huimbayoc')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1762, 182, N'Juan Guerra')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1763, 182, N'La Banda de Shilcayo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1764, 182, N'Morales')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1765, 182, N'Papaplaya')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1766, 182, N'San Antonio')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1767, 182, N'Sauce')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1768, 182, N'Shapaja')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1769, 183, N'Tocache')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1770, 183, N'Nuevo Progreso')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1771, 183, N'Pólvora')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1772, 183, N'Shunte')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1773, 183, N'Uchiza')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1774, 184, N'Candarave')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1775, 184, N'Cairani')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1776, 184, N'Camilaca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1777, 184, N'Curibaya')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1778, 184, N'Huanuara')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1779, 184, N'Quilahuani')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1780, 185, N'Ilabaya')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1781, 185, N'Ite')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1782, 185, N'Locumba')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1783, 186, N'Tacna')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1784, 186, N'Alto de la Alianza')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1785, 186, N'Calana')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1786, 186, N'Ciudad Nueva')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1787, 186, N'Coronel Gregorio Albarracín Lanchipa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1788, 186, N'Inclán')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1789, 186, N'Pachía')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1790, 186, N'Palca')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1791, 186, N'Pocollay')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1792, 186, N'Sama')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1793, 187, N'Tarata')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1794, 187, N'Chucatamani')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1795, 187, N'Estique')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1796, 187, N'Estique-Pampa')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1797, 187, N'Sitajara')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1798, 187, N'Susapaya')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1799, 187, N'Tarucachi')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1800, 187, N'Ticaco')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1801, 188, N'Canoas de Punta Sal')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1802, 188, N'Casitas')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1803, 188, N'Zorritos')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1804, 189, N'Tumbes')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1805, 189, N'Corrales')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1806, 189, N'La Cruz')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1807, 189, N'Pampas de Hospital')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1808, 189, N'San Jacinto')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1809, 189, N'San Juan de la Virgen')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1810, 190, N'Zarumilla')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1811, 190, N'Aguas Verdes')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1812, 190, N'Matapalo')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1813, 190, N'Papayal')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1814, 191, N'Raimondi')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1815, 191, N'Sepahua')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1816, 191, N'Tahuanía')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1817, 191, N'Yurúa')
GO
print 'Processed 1800 total records'
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1818, 192, N'Callería')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1819, 192, N'Campoverde')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1820, 192, N'Iparía')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1821, 192, N'Manantay')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1822, 192, N'Masisea')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1823, 192, N'Yarinacocha')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1824, 192, N'Nueva Requena')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1825, 193, N'Padre Abad')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1826, 193, N'Irazola')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1827, 193, N'Curimaná')
INSERT [dbo].[distrito] ([id_distrito], [id_provincia], [nombre]) VALUES (1828, 194, N'Purús')
SET IDENTITY_INSERT [dbo].[distrito] OFF
/****** Object:  Table [dbo].[agente]    Script Date: 12/20/2014 19:58:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[agente](
	[id_agente] [int] IDENTITY(1,1) NOT NULL,
	[id_banco] [int] NOT NULL,
	[nombre] [varchar](500) NOT NULL,
	[latitud] [float] NOT NULL,
	[longitud] [float] NOT NULL,
	[nombre_enrcargado] [varchar](500) NOT NULL,
	[email] [varchar](50) NOT NULL,
	[telefeno] [varchar](9) NOT NULL,
	[telefono_encargado] [varchar](9) NOT NULL,
	[direccion] [varchar](500) NOT NULL,
	[estado] [bit] NOT NULL,
	[fecha_creacion] [datetime] NOT NULL,
	[fecha_actualizacion] [datetime] NOT NULL,
	[hora_incio] [datetime] NOT NULL,
	[hora_fin] [datetime] NOT NULL,
	[id_distrito] [int] NOT NULL,
 CONSTRAINT [PK_agente] PRIMARY KEY CLUSTERED 
(
	[id_agente] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[agente] ON
INSERT [dbo].[agente] ([id_agente], [id_banco], [nombre], [latitud], [longitud], [nombre_enrcargado], [email], [telefeno], [telefono_encargado], [direccion], [estado], [fecha_creacion], [fecha_actualizacion], [hora_incio], [hora_fin], [id_distrito]) VALUES (1, 1, N'Agente 1', -8.084388376189116, -79.042723051217649, N'encargado 1 ', N'email 1', N'123456789', N'123456789', N'direccion 1', 1, CAST(0x0000A12500000000 AS DateTime), CAST(0x0000A12500000000 AS DateTime), CAST(0x00000000005265C0 AS DateTime), CAST(0x00000000009450C0 AS DateTime), 1192)
INSERT [dbo].[agente] ([id_agente], [id_banco], [nombre], [latitud], [longitud], [nombre_enrcargado], [email], [telefeno], [telefono_encargado], [direccion], [estado], [fecha_creacion], [fecha_actualizacion], [hora_incio], [hora_fin], [id_distrito]) VALUES (2, 2, N'Agente 2', -8.09628507925185, -79.02023541083679, N'encargado 2', N'email 2', N'123456789', N'123456789', N'direccion 2', 1, CAST(0x0000A12500000000 AS DateTime), CAST(0x0000A12500000000 AS DateTime), CAST(0x00000000005265C0 AS DateTime), CAST(0x00000000009450C0 AS DateTime), 1192)
INSERT [dbo].[agente] ([id_agente], [id_banco], [nombre], [latitud], [longitud], [nombre_enrcargado], [email], [telefeno], [telefono_encargado], [direccion], [estado], [fecha_creacion], [fecha_actualizacion], [hora_incio], [hora_fin], [id_distrito]) VALUES (6, 3, N'Agente2', -8.1112404359310322, -79.032251707223509, N'encargado 3', N'email 3', N'123456789', N'123456789', N'direccion 3', 1, CAST(0x0000A12500000000 AS DateTime), CAST(0x0000A12500000000 AS DateTime), CAST(0x00000000005265C0 AS DateTime), CAST(0x00000000009450C0 AS DateTime), 1192)
SET IDENTITY_INSERT [dbo].[agente] OFF
/****** Object:  Table [dbo].[empresa]    Script Date: 12/20/2014 19:58:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[empresa](
	[id_empresa] [int] IDENTITY(1,1) NOT NULL,
	[nombre_usuario] [varchar](50) NOT NULL,
	[apellidos_usuario] [varchar](50) NOT NULL,
	[email_usuario] [varchar](50) NOT NULL,
	[telefono] [varchar](9) NOT NULL,
	[celular] [varchar](9) NOT NULL,
	[usuario] [varchar](50) NOT NULL,
	[clave] [varchar](50) NOT NULL,
	[id_distrito] [int] NOT NULL,
	[razon_social] [varchar](500) NULL,
	[ruc] [varchar](11) NULL,
	[direccion] [varchar](500) NOT NULL,
	[estado] [tinyint] NOT NULL,
	[empresa] [bit] NOT NULL,
	[fecha_creacion] [datetime] NOT NULL,
	[fecha_actualizacion] [datetime] NOT NULL,
 CONSTRAINT [PK_empresa] PRIMARY KEY CLUSTERED 
(
	[id_empresa] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[empresa] ON
INSERT [dbo].[empresa] ([id_empresa], [nombre_usuario], [apellidos_usuario], [email_usuario], [telefono], [celular], [usuario], [clave], [id_distrito], [razon_social], [ruc], [direccion], [estado], [empresa], [fecha_creacion], [fecha_actualizacion]) VALUES (1, N'Francisco', N'Otiniano', N'otiniano@gmail.com', N'123456789', N'123456789', N'otiniano', N'123456', 1192, N'Transportes otiniano', N'12345678901', N'casa', 0, 1, CAST(0x0000A0E600000000 AS DateTime), CAST(0x0000A0E600000000 AS DateTime))
INSERT [dbo].[empresa] ([id_empresa], [nombre_usuario], [apellidos_usuario], [email_usuario], [telefono], [celular], [usuario], [clave], [id_distrito], [razon_social], [ruc], [direccion], [estado], [empresa], [fecha_creacion], [fecha_actualizacion]) VALUES (6, N'Juan', N'López castillo', N'Juan@gmail.com', N'044272631', N'969416440', N'Juan', N'123456', 1192, N'Transportes otiniano', N'12345678901', N'Jr.  Alexander pensión 325', 0, 0, CAST(0x0000A3FE01394E7B AS DateTime), CAST(0x0000A3FE01394E7B AS DateTime))
INSERT [dbo].[empresa] ([id_empresa], [nombre_usuario], [apellidos_usuario], [email_usuario], [telefono], [celular], [usuario], [clave], [id_distrito], [razon_social], [ruc], [direccion], [estado], [empresa], [fecha_creacion], [fecha_actualizacion]) VALUES (7, N'marlon', N'angulo', N'foxprogramarlon@gmail.com', N'949422273', N'044293973', N'marlon', N'123456', 1196, N'', N'', N'jrhshsurhs', 0, 0, CAST(0x0000A3FF01528EA0 AS DateTime), CAST(0x0000A3FF01528EA0 AS DateTime))
INSERT [dbo].[empresa] ([id_empresa], [nombre_usuario], [apellidos_usuario], [email_usuario], [telefono], [celular], [usuario], [clave], [id_distrito], [razon_social], [ruc], [direccion], [estado], [empresa], [fecha_creacion], [fecha_actualizacion]) VALUES (8, N'hola', N'yo', N'foxprogramarlon@gmail.com', N'388962586', N'563289654', N'yoyo', N'123456', 25, N'', N'', N'fhfbhd', 0, 0, CAST(0x0000A3FF0167B4BB AS DateTime), CAST(0x0000A3FF0167B4BB AS DateTime))
INSERT [dbo].[empresa] ([id_empresa], [nombre_usuario], [apellidos_usuario], [email_usuario], [telefono], [celular], [usuario], [clave], [id_distrito], [razon_social], [ruc], [direccion], [estado], [empresa], [fecha_creacion], [fecha_actualizacion]) VALUES (9, N'jsjsj', N'bdbebe', N'foxprogramarlon@gmail.com', N'111111111', N'222222222', N'asus', N'123456', 407, N'', N'', N'hoka', 0, 0, CAST(0x0000A40000760793 AS DateTime), CAST(0x0000A40000760793 AS DateTime))
SET IDENTITY_INSERT [dbo].[empresa] OFF
/****** Object:  Table [dbo].[movimiento]    Script Date: 12/20/2014 19:58:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[movimiento](
	[id_movimiento] [int] IDENTITY(1,1) NOT NULL,
	[id_tipo_movimiento] [int] NOT NULL,
	[id_servicio] [int] NULL,
	[id_empresa] [int] NOT NULL,
	[ingreso] [bit] NOT NULL,
	[detalle] [varchar](500) NOT NULL,
	[total] [decimal](18, 4) NOT NULL,
	[total_acumulado] [decimal](18, 4) NOT NULL,
	[couta_total] [int] NOT NULL,
	[coutas_ingresadas] [int] NOT NULL,
	[estado] [tinyint] NOT NULL,
	[inicio_alerta] [int] NOT NULL,
	[repeticion_alerta] [int] NOT NULL,
	[fecha_movimiento] [datetime] NOT NULL,
	[fecha_creacion] [datetime] NOT NULL,
 CONSTRAINT [PK_movimiento] PRIMARY KEY CLUSTERED 
(
	[id_movimiento] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[movimiento] ON
INSERT [dbo].[movimiento] ([id_movimiento], [id_tipo_movimiento], [id_servicio], [id_empresa], [ingreso], [detalle], [total], [total_acumulado], [couta_total], [coutas_ingresadas], [estado], [inicio_alerta], [repeticion_alerta], [fecha_movimiento], [fecha_creacion]) VALUES (7, 1, 1, 1, 1, N'XD', CAST(12.0000 AS Decimal(18, 4)), CAST(0.0000 AS Decimal(18, 4)), 4, 0, 0, 1, 4, CAST(0x0000A3FE004EF88E AS DateTime), CAST(0x0000A3FE004EF94C AS DateTime))
INSERT [dbo].[movimiento] ([id_movimiento], [id_tipo_movimiento], [id_servicio], [id_empresa], [ingreso], [detalle], [total], [total_acumulado], [couta_total], [coutas_ingresadas], [estado], [inicio_alerta], [repeticion_alerta], [fecha_movimiento], [fecha_creacion]) VALUES (8, 3, 1, 1, 1, N'Sfs', CAST(35.0000 AS Decimal(18, 4)), CAST(0.0000 AS Decimal(18, 4)), 0, 0, 0, 0, 0, CAST(0x0000A3FF0059D9A7 AS DateTime), CAST(0x0000A3FE005A2B24 AS DateTime))
INSERT [dbo].[movimiento] ([id_movimiento], [id_tipo_movimiento], [id_servicio], [id_empresa], [ingreso], [detalle], [total], [total_acumulado], [couta_total], [coutas_ingresadas], [estado], [inicio_alerta], [repeticion_alerta], [fecha_movimiento], [fecha_creacion]) VALUES (9, 2, 1, 1, 1, N'Fsd', CAST(26.0000 AS Decimal(18, 4)), CAST(0.0000 AS Decimal(18, 4)), 0, 0, 0, 1, 1, CAST(0x0000A3FF005A04E2 AS DateTime), CAST(0x0000A3FE005A5599 AS DateTime))
INSERT [dbo].[movimiento] ([id_movimiento], [id_tipo_movimiento], [id_servicio], [id_empresa], [ingreso], [detalle], [total], [total_acumulado], [couta_total], [coutas_ingresadas], [estado], [inicio_alerta], [repeticion_alerta], [fecha_movimiento], [fecha_creacion]) VALUES (10, 3, 2, 1, 1, N'Sd', CAST(23.0000 AS Decimal(18, 4)), CAST(0.0000 AS Decimal(18, 4)), 0, 0, 0, 3, 2, CAST(0x0000A3FF005A312E AS DateTime), CAST(0x0000A3FE005A8395 AS DateTime))
INSERT [dbo].[movimiento] ([id_movimiento], [id_tipo_movimiento], [id_servicio], [id_empresa], [ingreso], [detalle], [total], [total_acumulado], [couta_total], [coutas_ingresadas], [estado], [inicio_alerta], [repeticion_alerta], [fecha_movimiento], [fecha_creacion]) VALUES (11, 2, 1, 1, 1, N'Htry ', CAST(86.0000 AS Decimal(18, 4)), CAST(0.0000 AS Decimal(18, 4)), 0, 0, 0, 0, 0, CAST(0x0000A3FF005A88D1 AS DateTime), CAST(0x0000A3FE005AD6AE AS DateTime))
INSERT [dbo].[movimiento] ([id_movimiento], [id_tipo_movimiento], [id_servicio], [id_empresa], [ingreso], [detalle], [total], [total_acumulado], [couta_total], [coutas_ingresadas], [estado], [inicio_alerta], [repeticion_alerta], [fecha_movimiento], [fecha_creacion]) VALUES (12, 2, 1, 1, 1, N'Dale', CAST(45.0000 AS Decimal(18, 4)), CAST(0.0000 AS Decimal(18, 4)), 5, 0, 0, 0, 1, CAST(0x0000A4000110C7B8 AS DateTime), CAST(0x0000A3FE01113884 AS DateTime))
INSERT [dbo].[movimiento] ([id_movimiento], [id_tipo_movimiento], [id_servicio], [id_empresa], [ingreso], [detalle], [total], [total_acumulado], [couta_total], [coutas_ingresadas], [estado], [inicio_alerta], [repeticion_alerta], [fecha_movimiento], [fecha_creacion]) VALUES (13, 3, 2, 1, 1, N'Pago de luz', CAST(56.0000 AS Decimal(18, 4)), CAST(0.0000 AS Decimal(18, 4)), 0, 0, 0, 1, 1, CAST(0x0000A40101131DDD AS DateTime), CAST(0x0000A3FE0113713A AS DateTime))
INSERT [dbo].[movimiento] ([id_movimiento], [id_tipo_movimiento], [id_servicio], [id_empresa], [ingreso], [detalle], [total], [total_acumulado], [couta_total], [coutas_ingresadas], [estado], [inicio_alerta], [repeticion_alerta], [fecha_movimiento], [fecha_creacion]) VALUES (14, 2, 1, 1, 0, N'Xd', CAST(56.0000 AS Decimal(18, 4)), CAST(0.0000 AS Decimal(18, 4)), 5, 0, 0, 0, 0, CAST(0x0000A3FF01156C50 AS DateTime), CAST(0x0000A3FE0115C0D6 AS DateTime))
INSERT [dbo].[movimiento] ([id_movimiento], [id_tipo_movimiento], [id_servicio], [id_empresa], [ingreso], [detalle], [total], [total_acumulado], [couta_total], [coutas_ingresadas], [estado], [inicio_alerta], [repeticion_alerta], [fecha_movimiento], [fecha_creacion]) VALUES (15, 1, 1, 6, 1, N'Compra XD ', CAST(55.0000 AS Decimal(18, 4)), CAST(0.0000 AS Decimal(18, 4)), 0, 0, 0, 0, 0, CAST(0x0000A3FF0139728F AS DateTime), CAST(0x0000A3FE0139C36F AS DateTime))
SET IDENTITY_INSERT [dbo].[movimiento] OFF
/****** Object:  Table [dbo].[agente_servicio]    Script Date: 12/20/2014 19:58:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[agente_servicio](
	[id_agente_servicio] [int] IDENTITY(1,1) NOT NULL,
	[id_servicio] [int] NULL,
	[id_agente] [int] NULL,
 CONSTRAINT [PK_agente_servicio] PRIMARY KEY CLUSTERED 
(
	[id_agente_servicio] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[agente_servicio] ON
INSERT [dbo].[agente_servicio] ([id_agente_servicio], [id_servicio], [id_agente]) VALUES (1, 1, 1)
INSERT [dbo].[agente_servicio] ([id_agente_servicio], [id_servicio], [id_agente]) VALUES (2, 1, 2)
INSERT [dbo].[agente_servicio] ([id_agente_servicio], [id_servicio], [id_agente]) VALUES (3, 2, 2)
INSERT [dbo].[agente_servicio] ([id_agente_servicio], [id_servicio], [id_agente]) VALUES (5, 2, 6)
INSERT [dbo].[agente_servicio] ([id_agente_servicio], [id_servicio], [id_agente]) VALUES (6, 3, 6)
INSERT [dbo].[agente_servicio] ([id_agente_servicio], [id_servicio], [id_agente]) VALUES (7, 3, 1)
SET IDENTITY_INSERT [dbo].[agente_servicio] OFF
/****** Object:  Table [dbo].[proforma]    Script Date: 12/20/2014 19:58:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[proforma](
	[id_proforma] [int] IDENTITY(1,1) NOT NULL,
	[id_empresa] [int] NOT NULL,
	[fecha_creacion] [datetime] NOT NULL,
	[fecha_finalizacion] [datetime] NOT NULL,
	[estado] [tinyint] NOT NULL,
 CONSTRAINT [PK_proforma] PRIMARY KEY CLUSTERED 
(
	[id_proforma] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[proforma] ON
INSERT [dbo].[proforma] ([id_proforma], [id_empresa], [fecha_creacion], [fecha_finalizacion], [estado]) VALUES (12, 1, CAST(0x0000A3FF0038084A AS DateTime), CAST(0x0000A3FF0038084A AS DateTime), 0)
INSERT [dbo].[proforma] ([id_proforma], [id_empresa], [fecha_creacion], [fecha_finalizacion], [estado]) VALUES (13, 6, CAST(0x0000A3FF00423FCF AS DateTime), CAST(0x0000A3FF00423FCF AS DateTime), 0)
INSERT [dbo].[proforma] ([id_proforma], [id_empresa], [fecha_creacion], [fecha_finalizacion], [estado]) VALUES (14, 1, CAST(0x0000A3FF00468EF8 AS DateTime), CAST(0x0000A3FF00468EF8 AS DateTime), 0)
INSERT [dbo].[proforma] ([id_proforma], [id_empresa], [fecha_creacion], [fecha_finalizacion], [estado]) VALUES (15, 6, CAST(0x0000A3FF004D26B0 AS DateTime), CAST(0x0000A3FF004D26B0 AS DateTime), 0)
INSERT [dbo].[proforma] ([id_proforma], [id_empresa], [fecha_creacion], [fecha_finalizacion], [estado]) VALUES (16, 1, CAST(0x0000A3FF005D2158 AS DateTime), CAST(0x0000A3FF005D2158 AS DateTime), 0)
INSERT [dbo].[proforma] ([id_proforma], [id_empresa], [fecha_creacion], [fecha_finalizacion], [estado]) VALUES (17, 1, CAST(0x0000A3FF00BE294B AS DateTime), CAST(0x0000A3FF00BE294B AS DateTime), 0)
INSERT [dbo].[proforma] ([id_proforma], [id_empresa], [fecha_creacion], [fecha_finalizacion], [estado]) VALUES (18, 6, CAST(0x0000A3FF01355BC2 AS DateTime), CAST(0x0000A3FF01355BC2 AS DateTime), 0)
INSERT [dbo].[proforma] ([id_proforma], [id_empresa], [fecha_creacion], [fecha_finalizacion], [estado]) VALUES (19, 6, CAST(0x0000A3FF013EBA73 AS DateTime), CAST(0x0000A3FF013EBA73 AS DateTime), 0)
INSERT [dbo].[proforma] ([id_proforma], [id_empresa], [fecha_creacion], [fecha_finalizacion], [estado]) VALUES (20, 6, CAST(0x0000A3FF0143C7EE AS DateTime), CAST(0x0000A3FF0143C7EE AS DateTime), 0)
INSERT [dbo].[proforma] ([id_proforma], [id_empresa], [fecha_creacion], [fecha_finalizacion], [estado]) VALUES (21, 6, CAST(0x0000A3FF0145968A AS DateTime), CAST(0x0000A3FF0145968A AS DateTime), 0)
INSERT [dbo].[proforma] ([id_proforma], [id_empresa], [fecha_creacion], [fecha_finalizacion], [estado]) VALUES (22, 6, CAST(0x0000A3FF014A1FCA AS DateTime), CAST(0x0000A3FF014A1FCA AS DateTime), 0)
INSERT [dbo].[proforma] ([id_proforma], [id_empresa], [fecha_creacion], [fecha_finalizacion], [estado]) VALUES (23, 7, CAST(0x0000A3FF0152CFBE AS DateTime), CAST(0x0000A3FF0152CFBE AS DateTime), 0)
INSERT [dbo].[proforma] ([id_proforma], [id_empresa], [fecha_creacion], [fecha_finalizacion], [estado]) VALUES (24, 7, CAST(0x0000A3FF0153231B AS DateTime), CAST(0x0000A3FF0153231B AS DateTime), 0)
SET IDENTITY_INSERT [dbo].[proforma] OFF
/****** Object:  Table [dbo].[producto_empresa]    Script Date: 12/20/2014 19:58:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[producto_empresa](
	[id_producto_empresa] [int] IDENTITY(1,1) NOT NULL,
	[id_producto] [int] NOT NULL,
	[id_empresa] [int] NOT NULL,
	[precio] [decimal](18, 4) NULL,
	[estado] [tinyint] NULL,
 CONSTRAINT [PK_producto_empresa] PRIMARY KEY CLUSTERED 
(
	[id_producto_empresa] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[producto_empresa] ON
INSERT [dbo].[producto_empresa] ([id_producto_empresa], [id_producto], [id_empresa], [precio], [estado]) VALUES (2, 2, 1, CAST(2.0000 AS Decimal(18, 4)), 0)
INSERT [dbo].[producto_empresa] ([id_producto_empresa], [id_producto], [id_empresa], [precio], [estado]) VALUES (3, 3, 1, CAST(4.0000 AS Decimal(18, 4)), 0)
INSERT [dbo].[producto_empresa] ([id_producto_empresa], [id_producto], [id_empresa], [precio], [estado]) VALUES (4, 4, 1, CAST(6.0000 AS Decimal(18, 4)), 0)
INSERT [dbo].[producto_empresa] ([id_producto_empresa], [id_producto], [id_empresa], [precio], [estado]) VALUES (5, 5, 1, CAST(6.0000 AS Decimal(18, 4)), 0)
SET IDENTITY_INSERT [dbo].[producto_empresa] OFF
/****** Object:  Table [dbo].[pago_empresa]    Script Date: 12/20/2014 19:58:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[pago_empresa](
	[id_pago_empresa] [int] IDENTITY(1,1) NOT NULL,
	[id_pago] [int] NULL,
	[id_empresa] [int] NULL,
	[fecha_creacion] [datetime] NULL,
	[estado] [bit] NULL,
 CONSTRAINT [PK_pago_usuario] PRIMARY KEY CLUSTERED 
(
	[id_pago_empresa] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  StoredProcedure [dbo].[SP_Insertar_Empresa]    Script Date: 12/20/2014 19:58:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[SP_Insertar_Empresa]
(
	@nombre_usuario VARCHAR(50),
	@apellidos_usuario VARCHAR(50),
	@email_usuario VARCHAR(50),
	@telefono VARCHAR(9),
	@celular VARCHAR(9),
	@usuario VARCHAR(50),
	@clave VARCHAR(50),
	@id_distrito INT,
	@razon_social VARCHAR(500),
	@ruc VARCHAR(11),
	@direccion VARCHAR(500),
	@empresa bit
)
as
INSERT INTO Empresa 
(nombre_usuario,apellidos_usuario,email_usuario,telefono,celular,usuario,clave,id_distrito,razon_social,
ruc,direccion,estado,empresa,fecha_creacion,fecha_actualizacion)
VALUES 
(@nombre_usuario,@apellidos_usuario,@email_usuario,@telefono,@celular,@usuario,@clave,@id_distrito,@razon_social,
@ruc,@direccion,0,@empresa,GETDATE(),GETDATE());
SELECT @@identity;
GO
/****** Object:  StoredProcedure [dbo].[SP_Listar_Agente]    Script Date: 12/20/2014 19:58:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[SP_Listar_Agente]
as
select a.id_agente,a.nombre,a.latitud,a.longitud,a.nombre_enrcargado,a.email,a.telefeno,a.telefono_encargado,a.direccion,a.
estado,a.fecha_creacion,a.hora_incio,a.hora_fin,a.id_distrito,a.id_banco,b.nombre,b.estado from agente a inner join banco b
on a.id_banco=b.id_banco
GO
/****** Object:  StoredProcedure [dbo].[SP_Login_Empresa]    Script Date: 12/20/2014 19:58:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[SP_Login_Empresa]
(
	@usuario varchar(50),	
	@clave varchar(50)
)
as
select id_empresa,nombre_usuario,apellidos_usuario,email_usuario,telefono,celular,usuario,clave,razon_social,ruc,direccion,
estado,empresa,fecha_creacion,fecha_actualizacion,id_distrito from empresa where usuario=@usuario and clave=@clave and estado=0;
GO
/****** Object:  StoredProcedure [dbo].[SP_Listar_Producto_Empresa]    Script Date: 12/20/2014 19:58:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[SP_Listar_Producto_Empresa]
	@id_empresa int
as
if(@id_empresa=0)
begin
	select id_producto_empresa,id_producto,id_empresa,precio,estado from producto_empresa
end
else
begin
	select id_producto_empresa,id_producto,id_empresa,precio,estado from producto_empresa 
	where id_empresa=@id_empresa AND estado=0;
end
GO
/****** Object:  StoredProcedure [dbo].[SP_Listar_Movimiento]    Script Date: 12/20/2014 19:58:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[SP_Listar_Movimiento]
(
@id_empresa int
)
as
if(@id_empresa>0)
begin
select id_movimiento,id_tipo_movimiento,id_servicio,id_empresa,ingreso,detalle,total,total_acumulado,couta_total,
coutas_ingresadas,estado,inicio_alerta,repeticion_alerta,fecha_movimiento,fecha_creacion from movimiento where 
id_empresa=@id_empresa
end
else
begin
select id_movimiento,id_tipo_movimiento,id_servicio,id_empresa,ingreso,detalle,total,total_acumulado,couta_total,
coutas_ingresadas,estado,inicio_alerta,repeticion_alerta,fecha_movimiento,fecha_creacion from movimiento
end
GO
/****** Object:  StoredProcedure [dbo].[SP_Listar_Proforma_Empresa]    Script Date: 12/20/2014 19:58:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[SP_Listar_Proforma_Empresa]
(
@id_empresa int
)
as
select id_proforma,id_empresa,fecha_creacion,fecha_finalizacion,estado from proforma where id_empresa=@id_empresa
GO
/****** Object:  StoredProcedure [dbo].[SP_Insertar_Proforma]    Script Date: 12/20/2014 19:58:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[SP_Insertar_Proforma]
(
	@id_empresa int
)
as
INSERT INTO proforma 
(id_empresa,fecha_creacion,fecha_finalizacion,estado)
VALUES 
(@id_empresa,GETDATE(),GETDATE(),0);
SELECT @@identity;
GO
/****** Object:  StoredProcedure [dbo].[SP_Insertar_Producto_Empresa]    Script Date: 12/20/2014 19:58:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[SP_Insertar_Producto_Empresa]
(
	@id_producto_empresa int,
	@id_producto int,	
	@id_empresa int,
	@precio decimal(18,4),
	@estado tinyint
)
as
if(@estado=0)
	begin
		insert into producto_empresa(id_producto,id_empresa,precio,estado)
		values(@id_producto,@id_empresa,@precio,0);
		SELECT @@identity;
	end
else if(@estado=1)
	begin
		update producto_empresa set precio=@precio where id_producto_empresa=@id_producto_empresa;
		select 0;
	end
else if(@estado=3)
	begin
		delete producto_empresa where id_producto_empresa=@id_producto_empresa;
		select -1;
	end
GO
/****** Object:  StoredProcedure [dbo].[SP_Insertar_Movimiento]    Script Date: 12/20/2014 19:58:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[SP_Insertar_Movimiento]
(
	@id_tipo_movimiento INT,
	@id_servicio INT,
	@id_empresa INT,
	@ingreso bit,
	@detalle VARCHAR(500),
	@total decimal(18,4),
	@couta_total INT,
	@inicio_alerta INT,
	@repeticion_alerta INT,
	@fecha_movimiento datetime
)
as
INSERT INTO movimiento 
(id_tipo_movimiento,id_servicio,id_empresa,ingreso,detalle,total,total_acumulado,couta_total,coutas_ingresadas,
estado,inicio_alerta,repeticion_alerta,fecha_movimiento,fecha_creacion)
VALUES 
(@id_tipo_movimiento,@id_servicio,@id_empresa,@ingreso,@detalle,@total,0,@couta_total,0,
0,@inicio_alerta,@repeticion_alerta,@fecha_movimiento,GETDATE());
SELECT @@identity;
GO
/****** Object:  StoredProcedure [dbo].[SP_Listar_Agente_Servicio]    Script Date: 12/20/2014 19:58:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[SP_Listar_Agente_Servicio]
as
select id_agente_servicio,id_servicio,id_agente from agente_servicio
GO
/****** Object:  Table [dbo].[item_movimiento]    Script Date: 12/20/2014 19:58:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[item_movimiento](
	[id_item_movimiento] [int] IDENTITY(1,1) NOT NULL,
	[id_movimiento] [int] NOT NULL,
	[numero_couta] [int] NOT NULL,
	[pago] [decimal](18, 4) NOT NULL,
	[fecha_creacion] [datetime] NOT NULL,
 CONSTRAINT [PK_item_movimiento] PRIMARY KEY CLUSTERED 
(
	[id_item_movimiento] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[cotizacion]    Script Date: 12/20/2014 19:58:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[cotizacion](
	[id_cotizacion] [int] IDENTITY(1,1) NOT NULL,
	[id_empresa] [int] NOT NULL,
	[id_proforma] [int] NULL,
	[fecha_creacion] [datetime] NOT NULL,
	[fecha_finalizacion] [datetime] NOT NULL,
	[estado] [tinyint] NOT NULL,
 CONSTRAINT [PK_cotizacion] PRIMARY KEY CLUSTERED 
(
	[id_cotizacion] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[cotizacion] ON
INSERT [dbo].[cotizacion] ([id_cotizacion], [id_empresa], [id_proforma], [fecha_creacion], [fecha_finalizacion], [estado]) VALUES (4, 1, 13, CAST(0x0000A3FF00C06160 AS DateTime), CAST(0x0000A3FF00C06160 AS DateTime), 0)
INSERT [dbo].[cotizacion] ([id_cotizacion], [id_empresa], [id_proforma], [fecha_creacion], [fecha_finalizacion], [estado]) VALUES (5, 1, 15, CAST(0x0000A3FF00C06DA2 AS DateTime), CAST(0x0000A3FF00C06DA2 AS DateTime), 0)
INSERT [dbo].[cotizacion] ([id_cotizacion], [id_empresa], [id_proforma], [fecha_creacion], [fecha_finalizacion], [estado]) VALUES (6, 1, 18, CAST(0x0000A3FF013F1F9B AS DateTime), CAST(0x0000A3FF013F1F9B AS DateTime), 0)
INSERT [dbo].[cotizacion] ([id_cotizacion], [id_empresa], [id_proforma], [fecha_creacion], [fecha_finalizacion], [estado]) VALUES (7, 1, 19, CAST(0x0000A3FF01439C9B AS DateTime), CAST(0x0000A3FF01439C9B AS DateTime), 0)
INSERT [dbo].[cotizacion] ([id_cotizacion], [id_empresa], [id_proforma], [fecha_creacion], [fecha_finalizacion], [estado]) VALUES (8, 1, 24, CAST(0x0000A3FF01533CEE AS DateTime), CAST(0x0000A3FF01533CEE AS DateTime), 0)
SET IDENTITY_INSERT [dbo].[cotizacion] OFF
/****** Object:  Table [dbo].[detalle_proforma]    Script Date: 12/20/2014 19:58:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[detalle_proforma](
	[id_detalle_proforma] [int] IDENTITY(1,1) NOT NULL,
	[id_proforma] [int] NOT NULL,
	[id_producto] [int] NOT NULL,
	[cantidad] [int] NOT NULL,
	[estado] [tinyint] NOT NULL,
 CONSTRAINT [PK_detalle_proforma] PRIMARY KEY CLUSTERED 
(
	[id_detalle_proforma] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[detalle_proforma] ON
INSERT [dbo].[detalle_proforma] ([id_detalle_proforma], [id_proforma], [id_producto], [cantidad], [estado]) VALUES (2, 12, 6, 6, 0)
INSERT [dbo].[detalle_proforma] ([id_detalle_proforma], [id_proforma], [id_producto], [cantidad], [estado]) VALUES (3, 12, 7, 3, 0)
INSERT [dbo].[detalle_proforma] ([id_detalle_proforma], [id_proforma], [id_producto], [cantidad], [estado]) VALUES (4, 13, 6, 23, 0)
INSERT [dbo].[detalle_proforma] ([id_detalle_proforma], [id_proforma], [id_producto], [cantidad], [estado]) VALUES (5, 13, 3, 6, 0)
INSERT [dbo].[detalle_proforma] ([id_detalle_proforma], [id_proforma], [id_producto], [cantidad], [estado]) VALUES (6, 13, 9, 6, 0)
INSERT [dbo].[detalle_proforma] ([id_detalle_proforma], [id_proforma], [id_producto], [cantidad], [estado]) VALUES (7, 14, 2, 6, 0)
INSERT [dbo].[detalle_proforma] ([id_detalle_proforma], [id_proforma], [id_producto], [cantidad], [estado]) VALUES (8, 14, 4, 5, 0)
INSERT [dbo].[detalle_proforma] ([id_detalle_proforma], [id_proforma], [id_producto], [cantidad], [estado]) VALUES (9, 14, 5, 2, 0)
INSERT [dbo].[detalle_proforma] ([id_detalle_proforma], [id_proforma], [id_producto], [cantidad], [estado]) VALUES (10, 15, 3, 5, 0)
INSERT [dbo].[detalle_proforma] ([id_detalle_proforma], [id_proforma], [id_producto], [cantidad], [estado]) VALUES (11, 15, 4, 5, 0)
INSERT [dbo].[detalle_proforma] ([id_detalle_proforma], [id_proforma], [id_producto], [cantidad], [estado]) VALUES (13, 17, 3, 6, 0)
INSERT [dbo].[detalle_proforma] ([id_detalle_proforma], [id_proforma], [id_producto], [cantidad], [estado]) VALUES (14, 17, 6, 23, 0)
INSERT [dbo].[detalle_proforma] ([id_detalle_proforma], [id_proforma], [id_producto], [cantidad], [estado]) VALUES (15, 17, 9, 6, 0)
INSERT [dbo].[detalle_proforma] ([id_detalle_proforma], [id_proforma], [id_producto], [cantidad], [estado]) VALUES (16, 18, 2, 5, 0)
INSERT [dbo].[detalle_proforma] ([id_detalle_proforma], [id_proforma], [id_producto], [cantidad], [estado]) VALUES (17, 18, 5, 5, 0)
INSERT [dbo].[detalle_proforma] ([id_detalle_proforma], [id_proforma], [id_producto], [cantidad], [estado]) VALUES (18, 19, 9, 5, 0)
INSERT [dbo].[detalle_proforma] ([id_detalle_proforma], [id_proforma], [id_producto], [cantidad], [estado]) VALUES (19, 19, 3, 5, 0)
INSERT [dbo].[detalle_proforma] ([id_detalle_proforma], [id_proforma], [id_producto], [cantidad], [estado]) VALUES (20, 19, 8, 6, 0)
INSERT [dbo].[detalle_proforma] ([id_detalle_proforma], [id_proforma], [id_producto], [cantidad], [estado]) VALUES (21, 20, 2, 5, 0)
INSERT [dbo].[detalle_proforma] ([id_detalle_proforma], [id_proforma], [id_producto], [cantidad], [estado]) VALUES (22, 20, 5, 5, 0)
INSERT [dbo].[detalle_proforma] ([id_detalle_proforma], [id_proforma], [id_producto], [cantidad], [estado]) VALUES (23, 20, 7, 8, 0)
INSERT [dbo].[detalle_proforma] ([id_detalle_proforma], [id_proforma], [id_producto], [cantidad], [estado]) VALUES (24, 21, 2, 5, 0)
INSERT [dbo].[detalle_proforma] ([id_detalle_proforma], [id_proforma], [id_producto], [cantidad], [estado]) VALUES (25, 22, 4, 6, 0)
INSERT [dbo].[detalle_proforma] ([id_detalle_proforma], [id_proforma], [id_producto], [cantidad], [estado]) VALUES (26, 22, 9, 5, 0)
INSERT [dbo].[detalle_proforma] ([id_detalle_proforma], [id_proforma], [id_producto], [cantidad], [estado]) VALUES (27, 23, 8, 26, 0)
INSERT [dbo].[detalle_proforma] ([id_detalle_proforma], [id_proforma], [id_producto], [cantidad], [estado]) VALUES (28, 24, 2, 46, 0)
INSERT [dbo].[detalle_proforma] ([id_detalle_proforma], [id_proforma], [id_producto], [cantidad], [estado]) VALUES (29, 24, 8, 64, 0)
SET IDENTITY_INSERT [dbo].[detalle_proforma] OFF
/****** Object:  Table [dbo].[detalle_cotizacion]    Script Date: 12/20/2014 19:58:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[detalle_cotizacion](
	[id_detalle_cotizacion] [int] IDENTITY(1,1) NOT NULL,
	[id_cotizacion] [int] NOT NULL,
	[id_producto] [int] NOT NULL,
	[cantidad] [int] NOT NULL,
	[costo] [decimal](18, 4) NOT NULL,
	[estado] [tinyint] NOT NULL,
 CONSTRAINT [PK_detalle_cotizacion] PRIMARY KEY CLUSTERED 
(
	[id_detalle_cotizacion] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[detalle_cotizacion] ON
INSERT [dbo].[detalle_cotizacion] ([id_detalle_cotizacion], [id_cotizacion], [id_producto], [cantidad], [costo], [estado]) VALUES (5, 4, 3, 6, CAST(0.0000 AS Decimal(18, 4)), 0)
INSERT [dbo].[detalle_cotizacion] ([id_detalle_cotizacion], [id_cotizacion], [id_producto], [cantidad], [costo], [estado]) VALUES (6, 4, 6, 23, CAST(0.0000 AS Decimal(18, 4)), 0)
INSERT [dbo].[detalle_cotizacion] ([id_detalle_cotizacion], [id_cotizacion], [id_producto], [cantidad], [costo], [estado]) VALUES (7, 4, 9, 6, CAST(0.0000 AS Decimal(18, 4)), 0)
INSERT [dbo].[detalle_cotizacion] ([id_detalle_cotizacion], [id_cotizacion], [id_producto], [cantidad], [costo], [estado]) VALUES (8, 5, 4, 5, CAST(0.0000 AS Decimal(18, 4)), 0)
INSERT [dbo].[detalle_cotizacion] ([id_detalle_cotizacion], [id_cotizacion], [id_producto], [cantidad], [costo], [estado]) VALUES (9, 5, 3, 5, CAST(0.0000 AS Decimal(18, 4)), 0)
INSERT [dbo].[detalle_cotizacion] ([id_detalle_cotizacion], [id_cotizacion], [id_producto], [cantidad], [costo], [estado]) VALUES (10, 6, 5, 5, CAST(6.0000 AS Decimal(18, 4)), 0)
INSERT [dbo].[detalle_cotizacion] ([id_detalle_cotizacion], [id_cotizacion], [id_producto], [cantidad], [costo], [estado]) VALUES (11, 6, 2, 5, CAST(2.0000 AS Decimal(18, 4)), 0)
INSERT [dbo].[detalle_cotizacion] ([id_detalle_cotizacion], [id_cotizacion], [id_producto], [cantidad], [costo], [estado]) VALUES (12, 7, 3, 5, CAST(4.0000 AS Decimal(18, 4)), 0)
INSERT [dbo].[detalle_cotizacion] ([id_detalle_cotizacion], [id_cotizacion], [id_producto], [cantidad], [costo], [estado]) VALUES (13, 7, 9, 5, CAST(0.0000 AS Decimal(18, 4)), 0)
INSERT [dbo].[detalle_cotizacion] ([id_detalle_cotizacion], [id_cotizacion], [id_producto], [cantidad], [costo], [estado]) VALUES (14, 7, 8, 6, CAST(0.0000 AS Decimal(18, 4)), 0)
INSERT [dbo].[detalle_cotizacion] ([id_detalle_cotizacion], [id_cotizacion], [id_producto], [cantidad], [costo], [estado]) VALUES (15, 8, 2, 46, CAST(2.0000 AS Decimal(18, 4)), 0)
INSERT [dbo].[detalle_cotizacion] ([id_detalle_cotizacion], [id_cotizacion], [id_producto], [cantidad], [costo], [estado]) VALUES (16, 8, 8, 64, CAST(0.0000 AS Decimal(18, 4)), 0)
SET IDENTITY_INSERT [dbo].[detalle_cotizacion] OFF
/****** Object:  StoredProcedure [dbo].[SP_Insertar_Detalle_Proforma]    Script Date: 12/20/2014 19:58:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[SP_Insertar_Detalle_Proforma]
(
	@id_proforma int,
	@id_producto int,
	@cantidad int
)
as
INSERT INTO detalle_proforma 
(id_proforma,id_producto,cantidad,estado)
VALUES 
(@id_proforma,@id_producto,@cantidad,0);
SELECT @@identity;
GO
/****** Object:  StoredProcedure [dbo].[SP_Listar_Cotizacion]    Script Date: 12/20/2014 19:58:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[SP_Listar_Cotizacion]
(
@id_empresa int
)
as
select c.id_cotizacion,c.id_proforma,c.fecha_creacion,c.fecha_finalizacion,c.estado,c.id_empresa,e.nombre_usuario,
e.apellidos_usuario,e.telefono,e.empresa,e.razon_social,e.ruc,e.direccion from cotizacion c
inner join proforma p on p.id_proforma=c.id_proforma inner join empresa e on e.id_empresa=c.id_empresa
 where p.id_empresa=@id_empresa
GO
/****** Object:  StoredProcedure [dbo].[SP_Insertar_Cotizacion]    Script Date: 12/20/2014 19:58:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[SP_Insertar_Cotizacion]
(
	@id_empresa int,
	@id_proforma int
)
as
INSERT INTO cotizacion 
(id_empresa,id_proforma,fecha_creacion,fecha_finalizacion,estado)
VALUES 
(@id_empresa,@id_proforma,GETDATE(),GETDATE(),0);
SELECT @@identity;
GO
/****** Object:  StoredProcedure [dbo].[SP_Insertar_Item_Movimiento]    Script Date: 12/20/2014 19:58:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[SP_Insertar_Item_Movimiento]
(
	@id_movimiento INT,	
	@pago decimal(18,4)
)
as
DECLARE @id_item_movimiento int,@id_tipo_movimiento INT,@couta_total INT,@coutas_ingresadas INT;
set @coutas_ingresadas=(select coutas_ingresadas from movimiento where id_movimiento=@id_movimiento)+1;
set @couta_total=(select couta_total from movimiento where id_movimiento=@id_movimiento);
INSERT INTO item_movimiento 
(id_movimiento,numero_couta,pago,fecha_creacion)
VALUES 
(@id_movimiento,@coutas_ingresadas,@pago,GETDATE());
set @id_item_movimiento=@@identity;
set @id_tipo_movimiento=(select id_tipo_movimiento from movimiento where id_movimiento=@id_movimiento);
if(@id_movimiento=1)
	begin
		update movimiento set coutas_ingresadas=@coutas_ingresadas,total_acumulado=total_acumulado+@pago,
		estado=0 where id_movimiento=@id_movimiento;
	end
else 
	begin
		update movimiento set coutas_ingresadas=@coutas_ingresadas,total_acumulado=total_acumulado+@pago,
		estado=0,fecha_movimiento=(SELECT DATEADD(month,1,fecha_movimiento)) where id_movimiento=@id_movimiento;
	end
if(@couta_total=@coutas_ingresadas and @id_tipo_movimiento<3)
begin
	update movimiento set estado=1 where id_movimiento=@id_movimiento;
end
select @id_item_movimiento;
GO
/****** Object:  StoredProcedure [dbo].[SP_Listar_Proforma]    Script Date: 12/20/2014 19:58:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[SP_Listar_Proforma]
(
@id_empresa int
)
as
select DISTINCT p.id_proforma,p.fecha_creacion,p.fecha_finalizacion,p.estado,p.id_empresa,e.nombre_usuario,
e.apellidos_usuario,e.telefono,e.empresa,e.razon_social,e.ruc,e.direccion from proforma p 
inner join detalle_proforma d on p.id_proforma=d.id_proforma inner join producto pro
on pro.id_producto=d.id_producto inner join producto_empresa pe on pro.id_producto=pe.id_producto
inner join empresa e on e.id_empresa=p.id_empresa LEFT join cotizacion co on co.id_proforma=p.id_proforma 
where pe.id_empresa=@id_empresa and p.id_empresa!=@id_empresa AND co.id_cotizacion IS NULL
GO
/****** Object:  StoredProcedure [dbo].[SP_Listar_Item_Movimiento]    Script Date: 12/20/2014 19:58:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[SP_Listar_Item_Movimiento]
(
@id_empresa int
)
as
select i.id_item_movimiento,i.id_movimiento,i.numero_couta,i.pago,i.fecha_creacion from item_movimiento 
i inner join movimiento m on i.id_movimiento=m.id_movimiento where m.id_empresa=@id_empresa
GO
/****** Object:  StoredProcedure [dbo].[SP_Listar_Detalle_Proforma_Empresa]    Script Date: 12/20/2014 19:58:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[SP_Listar_Detalle_Proforma_Empresa]
(
@id_empresa int
)
as
select d.id_detalle_proforma,d.id_proforma,d.id_producto,d.cantidad,d.estado from detalle_proforma d inner join
proforma p on d.id_proforma=p.id_proforma where p.id_empresa=@id_empresa
GO
/****** Object:  StoredProcedure [dbo].[SP_Listar_Detalle_Proforma]    Script Date: 12/20/2014 19:58:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[SP_Listar_Detalle_Proforma]
as
select d.id_detalle_proforma,d.id_proforma,d.id_producto,d.cantidad,d.estado from detalle_proforma d
GO
/****** Object:  StoredProcedure [dbo].[SP_Listar_Detalle_Cotizacion]    Script Date: 12/20/2014 19:58:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[SP_Listar_Detalle_Cotizacion]
as
select d.id_detalle_cotizacion,d.id_cotizacion,d.id_producto,d.cantidad,d.costo,d.estado from detalle_cotizacion d
GO
/****** Object:  StoredProcedure [dbo].[SP_Insertar_Detalle_Cotizacion]    Script Date: 12/20/2014 19:58:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[SP_Insertar_Detalle_Cotizacion]
(
	@id_cotizacion int,
	@id_producto int,
	@cantidad int,
	@costo decimal(18, 4)
	
)
as
INSERT INTO detalle_cotizacion 
(id_cotizacion,id_producto,cantidad,costo,estado)
VALUES 
(@id_cotizacion,@id_producto,@cantidad,@costo,0);
SELECT @@identity;
GO
/****** Object:  ForeignKey [FK_agente_banco]    Script Date: 12/20/2014 19:58:22 ******/
ALTER TABLE [dbo].[agente]  WITH CHECK ADD  CONSTRAINT [FK_agente_banco] FOREIGN KEY([id_banco])
REFERENCES [dbo].[banco] ([id_banco])
GO
ALTER TABLE [dbo].[agente] CHECK CONSTRAINT [FK_agente_banco]
GO
/****** Object:  ForeignKey [FK_agente_distrito]    Script Date: 12/20/2014 19:58:22 ******/
ALTER TABLE [dbo].[agente]  WITH CHECK ADD  CONSTRAINT [FK_agente_distrito] FOREIGN KEY([id_distrito])
REFERENCES [dbo].[distrito] ([id_distrito])
GO
ALTER TABLE [dbo].[agente] CHECK CONSTRAINT [FK_agente_distrito]
GO
/****** Object:  ForeignKey [FK_agente_servicio_agente]    Script Date: 12/20/2014 19:58:22 ******/
ALTER TABLE [dbo].[agente_servicio]  WITH CHECK ADD  CONSTRAINT [FK_agente_servicio_agente] FOREIGN KEY([id_agente])
REFERENCES [dbo].[agente] ([id_agente])
GO
ALTER TABLE [dbo].[agente_servicio] CHECK CONSTRAINT [FK_agente_servicio_agente]
GO
/****** Object:  ForeignKey [FK_agente_servicio_servicio]    Script Date: 12/20/2014 19:58:22 ******/
ALTER TABLE [dbo].[agente_servicio]  WITH CHECK ADD  CONSTRAINT [FK_agente_servicio_servicio] FOREIGN KEY([id_servicio])
REFERENCES [dbo].[servicio] ([id_servicio])
GO
ALTER TABLE [dbo].[agente_servicio] CHECK CONSTRAINT [FK_agente_servicio_servicio]
GO
/****** Object:  ForeignKey [FK_cotizacion_empresa]    Script Date: 12/20/2014 19:58:22 ******/
ALTER TABLE [dbo].[cotizacion]  WITH CHECK ADD  CONSTRAINT [FK_cotizacion_empresa] FOREIGN KEY([id_empresa])
REFERENCES [dbo].[empresa] ([id_empresa])
GO
ALTER TABLE [dbo].[cotizacion] CHECK CONSTRAINT [FK_cotizacion_empresa]
GO
/****** Object:  ForeignKey [FK_cotizacion_proforma]    Script Date: 12/20/2014 19:58:22 ******/
ALTER TABLE [dbo].[cotizacion]  WITH CHECK ADD  CONSTRAINT [FK_cotizacion_proforma] FOREIGN KEY([id_proforma])
REFERENCES [dbo].[proforma] ([id_proforma])
GO
ALTER TABLE [dbo].[cotizacion] CHECK CONSTRAINT [FK_cotizacion_proforma]
GO
/****** Object:  ForeignKey [FK_detalle_cotizacion_cotizacion]    Script Date: 12/20/2014 19:58:22 ******/
ALTER TABLE [dbo].[detalle_cotizacion]  WITH CHECK ADD  CONSTRAINT [FK_detalle_cotizacion_cotizacion] FOREIGN KEY([id_cotizacion])
REFERENCES [dbo].[cotizacion] ([id_cotizacion])
GO
ALTER TABLE [dbo].[detalle_cotizacion] CHECK CONSTRAINT [FK_detalle_cotizacion_cotizacion]
GO
/****** Object:  ForeignKey [FK_detalle_cotizacion_producto]    Script Date: 12/20/2014 19:58:22 ******/
ALTER TABLE [dbo].[detalle_cotizacion]  WITH CHECK ADD  CONSTRAINT [FK_detalle_cotizacion_producto] FOREIGN KEY([id_producto])
REFERENCES [dbo].[producto] ([id_producto])
GO
ALTER TABLE [dbo].[detalle_cotizacion] CHECK CONSTRAINT [FK_detalle_cotizacion_producto]
GO
/****** Object:  ForeignKey [FK_detalle_proforma_producto]    Script Date: 12/20/2014 19:58:22 ******/
ALTER TABLE [dbo].[detalle_proforma]  WITH CHECK ADD  CONSTRAINT [FK_detalle_proforma_producto] FOREIGN KEY([id_producto])
REFERENCES [dbo].[producto] ([id_producto])
GO
ALTER TABLE [dbo].[detalle_proforma] CHECK CONSTRAINT [FK_detalle_proforma_producto]
GO
/****** Object:  ForeignKey [FK_detalle_proforma_proforma]    Script Date: 12/20/2014 19:58:22 ******/
ALTER TABLE [dbo].[detalle_proforma]  WITH CHECK ADD  CONSTRAINT [FK_detalle_proforma_proforma] FOREIGN KEY([id_proforma])
REFERENCES [dbo].[proforma] ([id_proforma])
GO
ALTER TABLE [dbo].[detalle_proforma] CHECK CONSTRAINT [FK_detalle_proforma_proforma]
GO
/****** Object:  ForeignKey [FK_distrito_provincia1]    Script Date: 12/20/2014 19:58:22 ******/
ALTER TABLE [dbo].[distrito]  WITH CHECK ADD  CONSTRAINT [FK_distrito_provincia1] FOREIGN KEY([id_provincia])
REFERENCES [dbo].[provincia] ([id_provincia])
GO
ALTER TABLE [dbo].[distrito] CHECK CONSTRAINT [FK_distrito_provincia1]
GO
/****** Object:  ForeignKey [FK_empresa_distrito1]    Script Date: 12/20/2014 19:58:22 ******/
ALTER TABLE [dbo].[empresa]  WITH CHECK ADD  CONSTRAINT [FK_empresa_distrito1] FOREIGN KEY([id_distrito])
REFERENCES [dbo].[distrito] ([id_distrito])
GO
ALTER TABLE [dbo].[empresa] CHECK CONSTRAINT [FK_empresa_distrito1]
GO
/****** Object:  ForeignKey [FK_item_movimiento_movimiento]    Script Date: 12/20/2014 19:58:22 ******/
ALTER TABLE [dbo].[item_movimiento]  WITH CHECK ADD  CONSTRAINT [FK_item_movimiento_movimiento] FOREIGN KEY([id_movimiento])
REFERENCES [dbo].[movimiento] ([id_movimiento])
GO
ALTER TABLE [dbo].[item_movimiento] CHECK CONSTRAINT [FK_item_movimiento_movimiento]
GO
/****** Object:  ForeignKey [FK_movimiento_empresa]    Script Date: 12/20/2014 19:58:22 ******/
ALTER TABLE [dbo].[movimiento]  WITH CHECK ADD  CONSTRAINT [FK_movimiento_empresa] FOREIGN KEY([id_empresa])
REFERENCES [dbo].[empresa] ([id_empresa])
GO
ALTER TABLE [dbo].[movimiento] CHECK CONSTRAINT [FK_movimiento_empresa]
GO
/****** Object:  ForeignKey [FK_movimiento_servicio]    Script Date: 12/20/2014 19:58:22 ******/
ALTER TABLE [dbo].[movimiento]  WITH CHECK ADD  CONSTRAINT [FK_movimiento_servicio] FOREIGN KEY([id_servicio])
REFERENCES [dbo].[servicio] ([id_servicio])
GO
ALTER TABLE [dbo].[movimiento] CHECK CONSTRAINT [FK_movimiento_servicio]
GO
/****** Object:  ForeignKey [FK_movimiento_tipo_movimiento]    Script Date: 12/20/2014 19:58:22 ******/
ALTER TABLE [dbo].[movimiento]  WITH CHECK ADD  CONSTRAINT [FK_movimiento_tipo_movimiento] FOREIGN KEY([id_tipo_movimiento])
REFERENCES [dbo].[tipo_movimiento] ([id_tipo_movimiento])
GO
ALTER TABLE [dbo].[movimiento] CHECK CONSTRAINT [FK_movimiento_tipo_movimiento]
GO
/****** Object:  ForeignKey [FK_pago_tipo_pago]    Script Date: 12/20/2014 19:58:22 ******/
ALTER TABLE [dbo].[pago]  WITH CHECK ADD  CONSTRAINT [FK_pago_tipo_pago] FOREIGN KEY([id_tipo_pago])
REFERENCES [dbo].[tipo_pago] ([id_tipo_pago])
GO
ALTER TABLE [dbo].[pago] CHECK CONSTRAINT [FK_pago_tipo_pago]
GO
/****** Object:  ForeignKey [FK_pago_empresa_empresa]    Script Date: 12/20/2014 19:58:22 ******/
ALTER TABLE [dbo].[pago_empresa]  WITH CHECK ADD  CONSTRAINT [FK_pago_empresa_empresa] FOREIGN KEY([id_empresa])
REFERENCES [dbo].[empresa] ([id_empresa])
GO
ALTER TABLE [dbo].[pago_empresa] CHECK CONSTRAINT [FK_pago_empresa_empresa]
GO
/****** Object:  ForeignKey [FK_pago_usuario_pago]    Script Date: 12/20/2014 19:58:22 ******/
ALTER TABLE [dbo].[pago_empresa]  WITH CHECK ADD  CONSTRAINT [FK_pago_usuario_pago] FOREIGN KEY([id_pago])
REFERENCES [dbo].[pago] ([id_pago])
GO
ALTER TABLE [dbo].[pago_empresa] CHECK CONSTRAINT [FK_pago_usuario_pago]
GO
/****** Object:  ForeignKey [FK_producto_marca]    Script Date: 12/20/2014 19:58:22 ******/
ALTER TABLE [dbo].[producto]  WITH CHECK ADD  CONSTRAINT [FK_producto_marca] FOREIGN KEY([id_marca])
REFERENCES [dbo].[marca] ([id_marca])
GO
ALTER TABLE [dbo].[producto] CHECK CONSTRAINT [FK_producto_marca]
GO
/****** Object:  ForeignKey [FK_producto_tipo_producto]    Script Date: 12/20/2014 19:58:22 ******/
ALTER TABLE [dbo].[producto]  WITH CHECK ADD  CONSTRAINT [FK_producto_tipo_producto] FOREIGN KEY([id_tipo_producto])
REFERENCES [dbo].[tipo_producto] ([id_tipo_producto])
GO
ALTER TABLE [dbo].[producto] CHECK CONSTRAINT [FK_producto_tipo_producto]
GO
/****** Object:  ForeignKey [FK_producto_empresa_empresa]    Script Date: 12/20/2014 19:58:22 ******/
ALTER TABLE [dbo].[producto_empresa]  WITH CHECK ADD  CONSTRAINT [FK_producto_empresa_empresa] FOREIGN KEY([id_empresa])
REFERENCES [dbo].[empresa] ([id_empresa])
GO
ALTER TABLE [dbo].[producto_empresa] CHECK CONSTRAINT [FK_producto_empresa_empresa]
GO
/****** Object:  ForeignKey [FK_producto_empresa_producto]    Script Date: 12/20/2014 19:58:22 ******/
ALTER TABLE [dbo].[producto_empresa]  WITH CHECK ADD  CONSTRAINT [FK_producto_empresa_producto] FOREIGN KEY([id_producto])
REFERENCES [dbo].[producto] ([id_producto])
GO
ALTER TABLE [dbo].[producto_empresa] CHECK CONSTRAINT [FK_producto_empresa_producto]
GO
/****** Object:  ForeignKey [FK_proforma_empresa]    Script Date: 12/20/2014 19:58:22 ******/
ALTER TABLE [dbo].[proforma]  WITH CHECK ADD  CONSTRAINT [FK_proforma_empresa] FOREIGN KEY([id_empresa])
REFERENCES [dbo].[empresa] ([id_empresa])
GO
ALTER TABLE [dbo].[proforma] CHECK CONSTRAINT [FK_proforma_empresa]
GO
/****** Object:  ForeignKey [FK_Provincia_Departamento]    Script Date: 12/20/2014 19:58:22 ******/
ALTER TABLE [dbo].[provincia]  WITH CHECK ADD  CONSTRAINT [FK_Provincia_Departamento] FOREIGN KEY([id_departamento])
REFERENCES [dbo].[departamento] ([id_departamento])
GO
ALTER TABLE [dbo].[provincia] CHECK CONSTRAINT [FK_Provincia_Departamento]
GO
