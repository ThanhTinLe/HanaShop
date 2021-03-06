USE [LeThanhTin_Assignment1]
GO
/****** Object:  Table [dbo].[tblCategorys]    Script Date: 4/15/2021 7:45:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblCategorys](
	[categoryID] [varchar](10) NOT NULL,
	[category] [varchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[categoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblCustomer]    Script Date: 4/15/2021 7:45:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblCustomer](
	[userName] [varchar](50) NOT NULL,
	[fullName] [nvarchar](50) NULL,
	[password] [varchar](50) NULL,
	[role] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[userName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblOrder]    Script Date: 4/15/2021 7:45:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblOrder](
	[orderID] [int] IDENTITY(1,1) NOT NULL,
	[cartPrice] [float] NULL,
	[userName] [varchar](50) NULL,
	[buyDate] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[orderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblOrderCart]    Script Date: 4/15/2021 7:45:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblOrderCart](
	[proID] [int] NOT NULL,
	[orderID] [int] NOT NULL,
	[numOfProduct] [int] NULL,
	[totalPrice] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[proID] ASC,
	[orderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblProducts]    Script Date: 4/15/2021 7:45:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblProducts](
	[proID] [int] IDENTITY(1,1) NOT NULL,
	[proName] [varchar](100) NULL,
	[proPrice] [float] NULL,
	[quantity] [int] NULL,
	[description] [nvarchar](4000) NULL,
	[proImage] [varchar](4000) NULL,
	[status] [bit] NOT NULL,
	[createDate] [date] NULL,
	[expiryDate] [date] NULL,
	[categoryID] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[proID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblUpdateLogs]    Script Date: 4/15/2021 7:45:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblUpdateLogs](
	[proID] [int] NULL,
	[userName] [varchar](50) NULL,
	[updateDate] [date] NULL,
	[isUpdate] [bit] NULL
) ON [PRIMARY]
GO
INSERT [dbo].[tblCategorys] ([categoryID], [category]) VALUES (N'CF ', N'Caffee')
INSERT [dbo].[tblCategorys] ([categoryID], [category]) VALUES (N'CK', N'Cakes')
INSERT [dbo].[tblCategorys] ([categoryID], [category]) VALUES (N'SD', N'Soft drink')
INSERT [dbo].[tblCategorys] ([categoryID], [category]) VALUES (N'TEA', N'Tea')
INSERT [dbo].[tblCustomer] ([userName], [fullName], [password], [role]) VALUES (N'duytt', N'Thân Thanh Duy', N'1', 1)
INSERT [dbo].[tblCustomer] ([userName], [fullName], [password], [role]) VALUES (N'hoaitq', N'Thái Quốc Hoài', N'1', 1)
INSERT [dbo].[tblCustomer] ([userName], [fullName], [password], [role]) VALUES (N'tinlt', N'Lê Thành Tín', N'1', 0)
SET IDENTITY_INSERT [dbo].[tblOrder] ON 

INSERT [dbo].[tblOrder] ([orderID], [cartPrice], [userName], [buyDate]) VALUES (1, 100, N'duytt', CAST(N'2021-04-15' AS Date))
INSERT [dbo].[tblOrder] ([orderID], [cartPrice], [userName], [buyDate]) VALUES (2, 22, N'duytt', CAST(N'2021-04-13' AS Date))
SET IDENTITY_INSERT [dbo].[tblOrder] OFF
INSERT [dbo].[tblOrderCart] ([proID], [orderID], [numOfProduct], [totalPrice]) VALUES (7, 1, 10, 100)
INSERT [dbo].[tblOrderCart] ([proID], [orderID], [numOfProduct], [totalPrice]) VALUES (7, 2, 1, 10)
INSERT [dbo].[tblOrderCart] ([proID], [orderID], [numOfProduct], [totalPrice]) VALUES (8, 2, 1, 12)
SET IDENTITY_INSERT [dbo].[tblProducts] ON 

INSERT [dbo].[tblProducts] ([proID], [proName], [proPrice], [quantity], [description], [proImage], [status], [createDate], [expiryDate], [categoryID]) VALUES (1, N'cocacola', 12, 9, N'1', N'https://i.ebayimg.com/images/g/kb0AAOSw3ftersx3/s-l400.jpg', 1, CAST(N'2021-04-13' AS Date), CAST(N'2021-05-01' AS Date), N'SD')
INSERT [dbo].[tblProducts] ([proID], [proName], [proPrice], [quantity], [description], [proImage], [status], [createDate], [expiryDate], [categoryID]) VALUES (2, N'cocacola-1', 12, 100, N'1', N'https://i.ebayimg.com/images/g/kb0AAOSw3ftersx3/s-l400.jpg', 1, CAST(N'2021-04-13' AS Date), CAST(N'2021-05-08' AS Date), N'SD')
INSERT [dbo].[tblProducts] ([proID], [proName], [proPrice], [quantity], [description], [proImage], [status], [createDate], [expiryDate], [categoryID]) VALUES (3, N'cocacola-2', 3, 100, N'1', N'https://i.ebayimg.com/images/g/kb0AAOSw3ftersx3/s-l400.jpg', 1, CAST(N'2021-04-13' AS Date), CAST(N'2021-05-08' AS Date), N'SD')
INSERT [dbo].[tblProducts] ([proID], [proName], [proPrice], [quantity], [description], [proImage], [status], [createDate], [expiryDate], [categoryID]) VALUES (4, N'cocacola-3', 10, 100, N'1', N'https://i.ebayimg.com/images/g/kb0AAOSw3ftersx3/s-l400.jpg', 1, CAST(N'2021-04-13' AS Date), CAST(N'2021-04-29' AS Date), N'SD')
INSERT [dbo].[tblProducts] ([proID], [proName], [proPrice], [quantity], [description], [proImage], [status], [createDate], [expiryDate], [categoryID]) VALUES (5, N'cocacola-4', 10, 100, N'1', N'https://i.ebayimg.com/images/g/kb0AAOSw3ftersx3/s-l400.jpg', 1, CAST(N'2021-04-13' AS Date), CAST(N'2021-04-29' AS Date), N'SD')
INSERT [dbo].[tblProducts] ([proID], [proName], [proPrice], [quantity], [description], [proImage], [status], [createDate], [expiryDate], [categoryID]) VALUES (6, N'cocacola-5', 10, 100, N'1', N'https://i.ebayimg.com/images/g/kb0AAOSw3ftersx3/s-l400.jpg', 1, CAST(N'2021-04-13' AS Date), CAST(N'2021-04-13' AS Date), N'SD')
INSERT [dbo].[tblProducts] ([proID], [proName], [proPrice], [quantity], [description], [proImage], [status], [createDate], [expiryDate], [categoryID]) VALUES (7, N'Caffee', 10, 99, N'1', N'https://th.bing.com/th/id/OIP.r7WPRCmy_W636vkGjqc8VwHaFV?pid=ImgDet&rs=1', 0, CAST(N'2021-04-13' AS Date), CAST(N'2021-04-22' AS Date), N'CF ')
INSERT [dbo].[tblProducts] ([proID], [proName], [proPrice], [quantity], [description], [proImage], [status], [createDate], [expiryDate], [categoryID]) VALUES (8, N'Caffee-1', 12, 99, N'1', N'https://th.bing.com/th/id/OIP.r7WPRCmy_W636vkGjqc8VwHaFV?pid=ImgDet&rs=1', 1, CAST(N'2021-04-13' AS Date), CAST(N'2021-04-30' AS Date), N'CF ')
INSERT [dbo].[tblProducts] ([proID], [proName], [proPrice], [quantity], [description], [proImage], [status], [createDate], [expiryDate], [categoryID]) VALUES (9, N'Caffee-2', 10, 100, N'1', N'https://th.bing.com/th/id/OIP.r7WPRCmy_W636vkGjqc8VwHaFV?pid=ImgDet&rs=1', 1, CAST(N'2021-04-13' AS Date), CAST(N'2021-05-08' AS Date), N'CF ')
INSERT [dbo].[tblProducts] ([proID], [proName], [proPrice], [quantity], [description], [proImage], [status], [createDate], [expiryDate], [categoryID]) VALUES (10, N'Caffee-3', 10, 100, N'1', N'https://th.bing.com/th/id/OIP.r7WPRCmy_W636vkGjqc8VwHaFV?pid=ImgDet&rs=1', 1, CAST(N'2021-04-13' AS Date), CAST(N'2021-04-28' AS Date), N'CF ')
INSERT [dbo].[tblProducts] ([proID], [proName], [proPrice], [quantity], [description], [proImage], [status], [createDate], [expiryDate], [categoryID]) VALUES (11, N'Caffee-4', 10, 100, N'1', N'https://th.bing.com/th/id/OIP.r7WPRCmy_W636vkGjqc8VwHaFV?pid=ImgDet&rs=1', 1, CAST(N'2021-04-13' AS Date), CAST(N'2021-04-23' AS Date), N'CF ')
INSERT [dbo].[tblProducts] ([proID], [proName], [proPrice], [quantity], [description], [proImage], [status], [createDate], [expiryDate], [categoryID]) VALUES (12, N'Caffee-5', 10, 100, N'1', N'https://th.bing.com/th/id/OIP.r7WPRCmy_W636vkGjqc8VwHaFV?pid=ImgDet&rs=1', 1, CAST(N'2021-04-13' AS Date), CAST(N'2021-04-30' AS Date), N'CF ')
INSERT [dbo].[tblProducts] ([proID], [proName], [proPrice], [quantity], [description], [proImage], [status], [createDate], [expiryDate], [categoryID]) VALUES (13, N'Cake', 13, 100, N'1', N'https://thumbs.dreamstime.com/b/fruit-tart-10324611.jpg', 1, CAST(N'2021-04-13' AS Date), CAST(N'2021-05-08' AS Date), N'CK')
INSERT [dbo].[tblProducts] ([proID], [proName], [proPrice], [quantity], [description], [proImage], [status], [createDate], [expiryDate], [categoryID]) VALUES (14, N'Cake-1', 10, 100, N'1', N'https://thumbs.dreamstime.com/b/fruit-tart-10324611.jpg', 1, CAST(N'2021-04-13' AS Date), CAST(N'2021-05-07' AS Date), N'CK')
INSERT [dbo].[tblProducts] ([proID], [proName], [proPrice], [quantity], [description], [proImage], [status], [createDate], [expiryDate], [categoryID]) VALUES (15, N'Cake-2', 10, 100, N'1', N'https://thumbs.dreamstime.com/b/fruit-tart-10324611.jpg', 1, CAST(N'2021-04-13' AS Date), CAST(N'2021-05-07' AS Date), N'CK')
INSERT [dbo].[tblProducts] ([proID], [proName], [proPrice], [quantity], [description], [proImage], [status], [createDate], [expiryDate], [categoryID]) VALUES (16, N'Cake-3', 10, 100, N'1', N'https://thumbs.dreamstime.com/b/fruit-tart-10324611.jpg', 1, CAST(N'2021-04-13' AS Date), CAST(N'2021-04-22' AS Date), N'CK')
INSERT [dbo].[tblProducts] ([proID], [proName], [proPrice], [quantity], [description], [proImage], [status], [createDate], [expiryDate], [categoryID]) VALUES (17, N'Cake-4', 10, 100, N'1', N'https://thumbs.dreamstime.com/b/fruit-tart-10324611.jpg', 1, CAST(N'2021-04-13' AS Date), CAST(N'2021-05-06' AS Date), N'CK')
INSERT [dbo].[tblProducts] ([proID], [proName], [proPrice], [quantity], [description], [proImage], [status], [createDate], [expiryDate], [categoryID]) VALUES (18, N'Cake-5', 1, 100, N'1', N'https://thumbs.dreamstime.com/b/fruit-tart-10324611.jpg', 1, CAST(N'2021-04-13' AS Date), CAST(N'2021-04-22' AS Date), N'CK')
INSERT [dbo].[tblProducts] ([proID], [proName], [proPrice], [quantity], [description], [proImage], [status], [createDate], [expiryDate], [categoryID]) VALUES (19, N'Tea', 10, 100, N'1', N'https://img.culturacolectiva.com/content/2013/12/pasos-para-hacer-el-te-medium.jpeg', 1, CAST(N'2021-04-13' AS Date), CAST(N'2021-04-29' AS Date), N'TEA')
INSERT [dbo].[tblProducts] ([proID], [proName], [proPrice], [quantity], [description], [proImage], [status], [createDate], [expiryDate], [categoryID]) VALUES (20, N'Tea-1', 10, 100, N'1', N'https://img.culturacolectiva.com/content/2013/12/pasos-para-hacer-el-te-medium.jpeg', 1, CAST(N'2021-04-13' AS Date), CAST(N'2021-04-22' AS Date), N'TEA')
INSERT [dbo].[tblProducts] ([proID], [proName], [proPrice], [quantity], [description], [proImage], [status], [createDate], [expiryDate], [categoryID]) VALUES (21, N'Tea-2', 10, 100, N'1', N'https://img.culturacolectiva.com/content/2013/12/pasos-para-hacer-el-te-medium.jpeg', 1, CAST(N'2021-04-13' AS Date), CAST(N'2021-04-29' AS Date), N'TEA')
INSERT [dbo].[tblProducts] ([proID], [proName], [proPrice], [quantity], [description], [proImage], [status], [createDate], [expiryDate], [categoryID]) VALUES (22, N'Tea-3', 10, 100, N'1', N'https://img.culturacolectiva.com/content/2013/12/pasos-para-hacer-el-te-medium.jpeg', 1, CAST(N'2021-04-13' AS Date), CAST(N'2021-04-27' AS Date), N'TEA')
INSERT [dbo].[tblProducts] ([proID], [proName], [proPrice], [quantity], [description], [proImage], [status], [createDate], [expiryDate], [categoryID]) VALUES (23, N'Tea-4', 10, 100, N'1', N'https://img.culturacolectiva.com/content/2013/12/pasos-para-hacer-el-te-medium.jpeg', 1, CAST(N'2021-04-13' AS Date), CAST(N'2021-04-27' AS Date), N'TEA')
INSERT [dbo].[tblProducts] ([proID], [proName], [proPrice], [quantity], [description], [proImage], [status], [createDate], [expiryDate], [categoryID]) VALUES (24, N'Tea-5', 10, 100, N'1', N'https://img.culturacolectiva.com/content/2013/12/pasos-para-hacer-el-te-medium.jpeg', 1, CAST(N'2021-04-13' AS Date), CAST(N'2021-05-04' AS Date), N'TEA')
INSERT [dbo].[tblProducts] ([proID], [proName], [proPrice], [quantity], [description], [proImage], [status], [createDate], [expiryDate], [categoryID]) VALUES (25, N'Tea-6', 11, 100, N'1', N'https://img.culturacolectiva.com/content/2013/12/pasos-para-hacer-el-te-medium.jpeg', 1, CAST(N'2021-04-13' AS Date), CAST(N'2021-05-06' AS Date), N'TEA')
INSERT [dbo].[tblProducts] ([proID], [proName], [proPrice], [quantity], [description], [proImage], [status], [createDate], [expiryDate], [categoryID]) VALUES (26, N'cocacola-6', 1, 100, N'1', N'https://i.ebayimg.com/images/g/kb0AAOSw3ftersx3/s-l400.jpg', 1, CAST(N'2021-04-13' AS Date), CAST(N'2021-04-30' AS Date), N'SD')
INSERT [dbo].[tblProducts] ([proID], [proName], [proPrice], [quantity], [description], [proImage], [status], [createDate], [expiryDate], [categoryID]) VALUES (27, N'Caffee', 10, 100, N'1', N'https://th.bing.com/th/id/OIP.r7WPRCmy_W636vkGjqc8VwHaFV?pid=ImgDet&rs=1', 1, CAST(N'2021-04-13' AS Date), CAST(N'2021-04-22' AS Date), N'CF ')
SET IDENTITY_INSERT [dbo].[tblProducts] OFF
INSERT [dbo].[tblUpdateLogs] ([proID], [userName], [updateDate], [isUpdate]) VALUES (10, N'tinlt', CAST(N'2021-04-14' AS Date), 0)
INSERT [dbo].[tblUpdateLogs] ([proID], [userName], [updateDate], [isUpdate]) VALUES (11, N'tinlt', CAST(N'2021-04-14' AS Date), 0)
INSERT [dbo].[tblUpdateLogs] ([proID], [userName], [updateDate], [isUpdate]) VALUES (18, N'tinlt', CAST(N'2021-04-14' AS Date), 0)
INSERT [dbo].[tblUpdateLogs] ([proID], [userName], [updateDate], [isUpdate]) VALUES (7, N'tinlt', CAST(N'2021-04-14' AS Date), 1)
INSERT [dbo].[tblUpdateLogs] ([proID], [userName], [updateDate], [isUpdate]) VALUES (8, N'tinlt', CAST(N'2021-04-14' AS Date), 1)
INSERT [dbo].[tblUpdateLogs] ([proID], [userName], [updateDate], [isUpdate]) VALUES (8, N'tinlt', CAST(N'2021-04-14' AS Date), 1)
INSERT [dbo].[tblUpdateLogs] ([proID], [userName], [updateDate], [isUpdate]) VALUES (25, N'tinlt', CAST(N'2021-04-14' AS Date), 1)
INSERT [dbo].[tblUpdateLogs] ([proID], [userName], [updateDate], [isUpdate]) VALUES (7, N'tinlt', CAST(N'2021-04-15' AS Date), 1)
INSERT [dbo].[tblUpdateLogs] ([proID], [userName], [updateDate], [isUpdate]) VALUES (7, N'tinlt', CAST(N'2021-04-15' AS Date), 1)
ALTER TABLE [dbo].[tblOrder]  WITH CHECK ADD FOREIGN KEY([userName])
REFERENCES [dbo].[tblCustomer] ([userName])
GO
ALTER TABLE [dbo].[tblOrderCart]  WITH CHECK ADD FOREIGN KEY([orderID])
REFERENCES [dbo].[tblOrder] ([orderID])
GO
ALTER TABLE [dbo].[tblOrderCart]  WITH CHECK ADD FOREIGN KEY([proID])
REFERENCES [dbo].[tblProducts] ([proID])
GO
ALTER TABLE [dbo].[tblProducts]  WITH CHECK ADD FOREIGN KEY([categoryID])
REFERENCES [dbo].[tblCategorys] ([categoryID])
GO
ALTER TABLE [dbo].[tblUpdateLogs]  WITH CHECK ADD FOREIGN KEY([proID])
REFERENCES [dbo].[tblProducts] ([proID])
GO
ALTER TABLE [dbo].[tblUpdateLogs]  WITH CHECK ADD FOREIGN KEY([userName])
REFERENCES [dbo].[tblCustomer] ([userName])
GO
