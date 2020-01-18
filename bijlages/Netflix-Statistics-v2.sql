USE [master]
GO
DROP DATABASE IF EXISTS NetflixStatistix;
GO
CREATE DATABASE NetflixStatistix;
GO
USE [NetflixStatistix]
GO
CREATE TABLE Account(
	[AccountName] [nvarchar](20) NOT NULL,
	[Email] [nvarchar](25) NOT NULL,
	[PhoneNumber] [nvarchar](15) NOT NULL,
	[Password] [nvarchar](25) NOT NULL,
	[AddressId] [int] NOT NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[AccountName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
----
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE Address(
	[StreetName] [nvarchar](50) NOT NULL,
	[Number] [int] NOT NULL,
	[Addition] [nvarchar](25) NULL,
	[City] [nvarchar](50) NOT NULL,
	[AddressId] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_Address] PRIMARY KEY CLUSTERED 
(
	[AddressId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
----
CREATE TABLE Administrator(
	[AccountName] [nvarchar](20) NOT NULL,
	[IsAdmin] [bit] NOT NULL,
 CONSTRAINT [PK_Administrator_1] PRIMARY KEY CLUSTERED 
(
	[AccountName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
----
CREATE TABLE Episode(
	[EpisodeNumber] [int] NOT NULL,
	[SeasonNumber] [int] NOT NULL,
	[ProgramId] [int] NOT NULL,
	[Name] [nvarchar](50) NULL,
 CONSTRAINT [PK_Episode] PRIMARY KEY CLUSTERED 
(
	[ProgramId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
----
CREATE TABLE Film(
	[Language] [nvarchar](25) NOT NULL,
	[Genre] [nvarchar](10) NOT NULL,
	[AgeGroup] [int] NOT NULL,
	[ProgramId] [int] NOT NULL,
 CONSTRAINT [PK_Film] PRIMARY KEY CLUSTERED 
(
	[ProgramId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
----
CREATE TABLE Profile(
	[ProfileName] [nvarchar](15) NOT NULL,
	[ProfileLanguage] [nvarchar](25) NOT NULL,
	[Birthday] [datetime2](7) NOT NULL,
	[AccountName] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_Profile] PRIMARY KEY CLUSTERED 
(
	[ProfileName] ASC,
	[AccountName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
----
CREATE TABLE Profile_Program(
	[PercentageWatched] [tinyint] NULL,
	[ProgramId] [int] NOT NULL,
	[ProfileName] [nvarchar](15) NOT NULL,
	[AccountName] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_Profile_Program] PRIMARY KEY CLUSTERED 
(
	[ProgramId] ASC,
	[ProfileName] ASC,
	[AccountName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
----
CREATE TABLE Program(
	[ProgramId] [int] NOT NULL,
	[Title] [nvarchar](50) NOT NULL,
	[Length] [nvarchar](8) NULL,
 CONSTRAINT [PK_Program] PRIMARY KEY CLUSTERED 
(
	[ProgramId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
----
CREATE TABLE Series(
	[Name] [nvarchar](50) NOT NULL,
	[Language] [nvarchar](25) NOT NULL,
	[Genre] [nvarchar](10) NOT NULL,
	[Recommendation] [nvarchar](50) NULL,
 CONSTRAINT [PK_Series] PRIMARY KEY CLUSTERED 
(
	[Name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
----
/** Relaties **/
ALTER TABLE [dbo].[Account]  WITH CHECK ADD  CONSTRAINT [FK_Account_Address1] FOREIGN KEY([AddressId])
REFERENCES [dbo].[Address] ([AddressId])
GO
ALTER TABLE [dbo].[Account] CHECK CONSTRAINT [FK_Account_Address1]
GO
ALTER TABLE [dbo].[Administrator]  WITH CHECK ADD  CONSTRAINT [FK_Administrator_Account] FOREIGN KEY([AccountName])
REFERENCES [dbo].[Account] ([AccountName])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Administrator] CHECK CONSTRAINT [FK_Administrator_Account]
GO
ALTER TABLE [dbo].[Episode]  WITH CHECK ADD  CONSTRAINT [FK_Episode_Program] FOREIGN KEY([ProgramId])
REFERENCES [dbo].[Program] ([ProgramId])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Episode] CHECK CONSTRAINT [FK_Episode_Program]
GO
ALTER TABLE [dbo].[Episode]  WITH CHECK ADD  CONSTRAINT [FK_Episode_Series] FOREIGN KEY([Name])
REFERENCES [dbo].[Series] ([Name])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Episode] CHECK CONSTRAINT [FK_Episode_Series]
GO
ALTER TABLE [dbo].[Film]  WITH CHECK ADD  CONSTRAINT [FK_Film_Program1] FOREIGN KEY([ProgramId])
REFERENCES [dbo].[Program] ([ProgramId])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Film] CHECK CONSTRAINT [FK_Film_Program1]
GO
ALTER TABLE [dbo].[Profile]  WITH CHECK ADD  CONSTRAINT [FK_Profile_Account1] FOREIGN KEY([AccountName])
REFERENCES [dbo].[Account] ([AccountName])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Profile] CHECK CONSTRAINT [FK_Profile_Account1]
GO
ALTER TABLE [dbo].[Profile_Program]  WITH CHECK ADD  CONSTRAINT [FK_Profile_Program_Profile1] FOREIGN KEY([ProfileName], [AccountName])
REFERENCES [dbo].[Profile] ([ProfileName], [AccountName])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Profile_Program] CHECK CONSTRAINT [FK_Profile_Program_Profile1]
GO
ALTER TABLE [dbo].[Profile_Program]  WITH CHECK ADD  CONSTRAINT [FK_Profile_Program_Program1] FOREIGN KEY([ProgramId])
REFERENCES [dbo].[Program] ([ProgramId])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Profile_Program] CHECK CONSTRAINT [FK_Profile_Program_Program1]
GO
USE [master]
GO
ALTER DATABASE [NetflixStatistix] SET  READ_WRITE 
GO
USE [NetflixStatistix]
/** Data Insert Address, Account, Profile, Administrator **/
SET IDENTITY_INSERT [dbo].[Address] ON
INSERT [dbo].[Address] ([StreetName], [Number], [Addition], [City], [AddressId]) VALUES (N'Teststraat', 1,NULL,N'Rotterdam',1)
INSERT [dbo].[Address] ([StreetName], [Number], [Addition], [City], [AddressId]) VALUES (N'Prottenstraat', 2,NULL,N'Den Haag',2)
INSERT [dbo].[Address] ([StreetName], [Number], [Addition], [City], [AddressId]) VALUES (N'Hogeschoollaan', 3,NULL,N'Vliewijk',3)
INSERT [dbo].[Address] ([StreetName], [Number], [Addition], [City], [AddressId]) VALUES (N'Achterstraat', 3,NULL,N'Scheveningen',4)
INSERT [dbo].[Address] ([StreetName], [Number], [Addition], [City], [AddressId]) VALUES (N'Weigeweg', 3,NULL,N'Schiedam',5)
INSERT [dbo].[Address] ([StreetName], [Number], [Addition], [City], [AddressId]) VALUES (N'Boomlaan', 3,NULL,N'Zandvoort',6)
INSERT [dbo].[Address] ([StreetName], [Number], [Addition], [City], [AddressId]) VALUES (N'Duinenplein', 3,NULL,N'Greppel',7)
INSERT [dbo].[Address] ([StreetName], [Number], [Addition], [City], [AddressId]) VALUES (N'Hovenshof', 3,NULL,N'Roterdam',8)
INSERT [dbo].[Address] ([StreetName], [Number], [Addition], [City], [AddressId]) VALUES (N'Hogeschoollaan', 3,NULL,N'Breda',9)
----
INSERT [dbo].[Account] ([AccountName], [Email], [PhoneNumber], [Password], [AddressId]) VALUES (N'wdejonge', N'wesley@avans.nl',064587964,N'wesley',1)
INSERT [dbo].[Account] ([AccountName], [Email], [PhoneNumber], [Password], [AddressId]) VALUES (N'Noah', N'noah@avans.nl',065479541,N'noah',2)
INSERT [dbo].[Account] ([AccountName], [Email], [PhoneNumber], [Password], [AddressId]) VALUES (N'Job', N'job@avans.nl',065493158,N'job',3)
INSERT [dbo].[Account] ([AccountName], [Email], [PhoneNumber], [Password], [AddressId]) VALUES (N'Kees', N'Kees@avans.nl',064545448,N'kees',4)
INSERT [dbo].[Account] ([AccountName], [Email], [PhoneNumber], [Password], [AddressId]) VALUES (N'Klaas', N'Klaas@avans.nl',063114687,N'klaas',5)
INSERT [dbo].[Account] ([AccountName], [Email], [PhoneNumber], [Password], [AddressId]) VALUES (N'Rob', N'Rob@avans.nl',068541365,N'rob',6)
INSERT [dbo].[Account] ([AccountName], [Email], [PhoneNumber], [Password], [AddressId]) VALUES (N'Peter', N'Peter@avans.nl',061254882,N'peter',7)
INSERT [dbo].[Account] ([AccountName], [Email], [PhoneNumber], [Password], [AddressId]) VALUES (N'Bas', N'Bas@avans.nl',069648231,N'bas',8)
INSERT [dbo].[Account] ([AccountName], [Email], [PhoneNumber], [Password], [AddressId]) VALUES (N'Administrator', N'Administrator@avans.nl',069648231,N'Admin#12345',9)
----
INSERT [dbo].[Profile] ([ProfileName], [ProfileLanguage], [Birthday], [AccountName]) VALUES (N'wesley', N'Dutch','1997-10-07',N'wdejonge')
INSERT [dbo].[Profile] ([ProfileName], [ProfileLanguage], [Birthday], [AccountName]) VALUES (N'Noah', N'Dutch','2000-06-24',N'Noah')
INSERT [dbo].[Profile] ([ProfileName], [ProfileLanguage], [Birthday], [AccountName]) VALUES (N'Job', N'Dutch','1999-03-15',N'Job')
INSERT [dbo].[Profile] ([ProfileName], [ProfileLanguage], [Birthday], [AccountName]) VALUES (N'Kees Hendriks', N'Dutch','1969-04-18',N'Kees')
INSERT [dbo].[Profile] ([ProfileName], [ProfileLanguage], [Birthday], [AccountName]) VALUES (N'Lies Hendriks', N'Dutch','1972-08-23',N'Kees')
INSERT [dbo].[Profile] ([ProfileName], [ProfileLanguage], [Birthday], [AccountName]) VALUES (N'fam-hendriks', N'Dutch','2005-01-11',N'Kees')
INSERT [dbo].[Profile] ([ProfileName], [ProfileLanguage], [Birthday], [AccountName]) VALUES (N'Klaas', N'Dutch','1977-09-05',N'Klaas')
INSERT [dbo].[Profile] ([ProfileName], [ProfileLanguage], [Birthday], [AccountName]) VALUES (N'Rob Tomas', N'Dutch','1991-04-18',N'Rob')
INSERT [dbo].[Profile] ([ProfileName], [ProfileLanguage], [Birthday], [AccountName]) VALUES (N'Pieter Tomas', N'Dutch','1991-04-18',N'Rob')
INSERT [dbo].[Profile] ([ProfileName], [ProfileLanguage], [Birthday], [AccountName]) VALUES (N'Pa Tomas', N'Dutch','1968-01-30',N'Rob')
INSERT [dbo].[Profile] ([ProfileName], [ProfileLanguage], [Birthday], [AccountName]) VALUES (N'Peter', N'Dutch','1999-03-15',N'Peter')
INSERT [dbo].[Profile] ([ProfileName], [ProfileLanguage], [Birthday], [AccountName]) VALUES (N'Kinderen', N'Dutch','2010-12-31',N'Peter')
INSERT [dbo].[Profile] ([ProfileName], [ProfileLanguage], [Birthday], [AccountName]) VALUES (N'Bas', N'Dutch','1969-12-02',N'Bas')
INSERT [dbo].[Profile] ([ProfileName], [ProfileLanguage], [Birthday], [AccountName]) VALUES (N'Administrator', N'Dutch','2020-01-18',N'Administrator')
----
INSERT [dbo].[Administrator] ([AccountName], [IsAdmin]) VALUES (N'wdejonge', 1)
INSERT [dbo].[Administrator] ([AccountName], [IsAdmin]) VALUES (N'Noah', 1)
INSERT [dbo].[Administrator] ([AccountName], [IsAdmin]) VALUES (N'Job', 1)
INSERT [dbo].[Administrator] ([AccountName], [IsAdmin]) VALUES (N'Kees', 0)
INSERT [dbo].[Administrator] ([AccountName], [IsAdmin]) VALUES (N'Klaas', 0)
INSERT [dbo].[Administrator] ([AccountName], [IsAdmin]) VALUES (N'Rob', 0)
INSERT [dbo].[Administrator] ([AccountName], [IsAdmin]) VALUES (N'Peter', 0)
INSERT [dbo].[Administrator] ([AccountName], [IsAdmin]) VALUES (N'Bas', 0)
INSERT [dbo].[Administrator] ([AccountName], [IsAdmin]) VALUES (N'Administrator', 1)

/** Data Insert Netflix **/
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (1001, N'A Study in Pink', '01:28:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (1002, N'The Blind Banker', '01:28:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (1003, N'The Great Game', '01:28:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (1004, N'A Scandal in Belgravia', '01:28:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (1005, N'The Hounds of Baskerville', '01:28:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (1006, N'The Reichenbach Fall', '01:28:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (1007, N'The Empty Hearse', '01:28:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (1008, N'The Sign of Three', '01:28:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (1009, N'His Last Vow', '01:28:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (1010, N'The Abominable Bride', '01:29:00')
-----
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (2000, N'Pilot Bad', '00:58:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (2001, N'Cat''s in the Bag…', '00:48:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (2002, N'…And the Bag''s in the River', '00:48:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (2003, N'Cancer Man', '00:48:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (2004, N'Gray Matter', '00:48:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (2005, N'Crazy Handful of Nothin''', '00:48:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (2006, N'A No-Rough-Stuff-Type Deal', '00:48:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (2007, N'Seven Thirty-Seven', '00:48:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (2008, N'Grilled', '00:48:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (2009, N'Bit by a Dead Bee', '00:48:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (2010, N'Down', '00:48:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (2011, N'Breakage', '00:48:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (2012, N'Peekaboo', '00:48:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (2013, N'Negro Y Azul', '00:48:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (2014, N'Better Call Saul', '00:48:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (2015, N'4 Days Out', '00:48:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (2016, N'Over', '00:48:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (2017, N'Mandala', '00:48:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (2018, N'Phoenix', '00:48:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (2019, N'ABQ', '00:48:00')
----
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (3001, N'The Crocodile''s Dilemma', '01:08:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (3002, N'The Rooster Prince', '01:08:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (3003, N'A Muddy Road', '01:08:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (3004, N'Eating the Blame', '01:08:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (3005, N'The Six Ungraspables', '01:08:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (3006, N'Buridan''s Ass', '01:08:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (3007, N'Who Shaves the Barber?', '01:08:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (3008, N'The Heap', '01:08:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (3009, N'A Fox, a Rabbit, and a Cabbage', '01:08:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (3010, N'Morton''s Fork', '01:08:00')
----
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (3101, N'Waiting for Dutch', '01:08:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (3102, N'Before the Law', '01:08:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (3103, N'Waiting for Dutch', '01:08:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (3104, N'Fear and Trembling', '01:08:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (3105, N'The Gift of the Magi', '01:08:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (3106, N'Rhinoceros', '01:08:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (3107, N'Did you do this? No, you did it!', '01:08:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (3108, N'Loplop', '01:08:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (3109, N'The Castle', '01:08:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (3110, N'Palindrome', '01:08:00')
----
/** Films **/
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (8001, N'The Life of Brian', '01:34:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (8002, N'Pulp Fiction', '02:34:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (8004, N'Pruimebloesem', '01:20:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (8008, N'Reservoir Dogs', '01:39:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (8010, N'The Good, the Bad and the Ugly', '02:41:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (8011, N'Andy Warhol''s Dracula', '01:43:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (8012, N'Ober', '01:37:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (8014, N'Der Untergang', '02:58:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (8016, N'De helaasheid der dingen', '01:48:00')
INSERT [dbo].[Program] ([ProgramId], [Title], [Length]) VALUES (8017, N'A Clockwork Orange', '02:16:00')
----
INSERT [dbo].[Film] ([Language], [Genre], [AgeGroup], [ProgramId]) VALUES (N'Engels', N'Detective', 12, 1010)
INSERT [dbo].[Film] ([Language], [Genre], [AgeGroup], [ProgramId]) VALUES (N'Engels', N'Humor', 12, 8001)
INSERT [dbo].[Film] ([Language], [Genre], [AgeGroup], [ProgramId]) VALUES (N'Engels-Amerikaans', N'Misdaad', 16, 8002)
INSERT [dbo].[Film] ([Language], [Genre], [AgeGroup], [ProgramId]) VALUES (N'Nederlands', N'Erotiek', 18, 8004)
INSERT [dbo].[Film] ([Language], [Genre], [AgeGroup], [ProgramId]) VALUES (N'Engels-Amerikaans', N'Misdaad', 16, 8008)
INSERT [dbo].[Film] ([Language], [Genre], [AgeGroup], [ProgramId]) VALUES (N'Engels-Amerikaans', N'Westerm', 12, 8010)
INSERT [dbo].[Film] ([Language], [Genre], [AgeGroup], [ProgramId]) VALUES (N'Engels-Amerikaans', N'Humor', 16, 8011)
INSERT [dbo].[Film] ([Language], [Genre], [AgeGroup], [ProgramId]) VALUES (N'Nederlands', N'Humor', 06, 8012)
INSERT [dbo].[Film] ([Language], [Genre], [AgeGroup], [ProgramId]) VALUES (N'Duits', N'Oorlog', 06, 8014)
INSERT [dbo].[Film] ([Language], [Genre], [AgeGroup], [ProgramId]) VALUES (N'Vlaams', N'Humor', 12, 8016)
INSERT [dbo].[Film] ([Language], [Genre], [AgeGroup], [ProgramId]) VALUES (N'Engels', N'SF', 16, 8017)
----
/** SERIES **/
INSERT [dbo].[Series] ([Name], [Language], [Genre], [Recommendation]) VALUES (N'Sherlock', N'Engels', N'Detective', N'Fargo')
INSERT [dbo].[Series] ([Name], [Language], [Genre], [Recommendation]) VALUES (N'Breaking Bad', N'Engels-Amerikaans', N'Spanning', N'Fargo')
INSERT [dbo].[Series] ([Name], [Language], [Genre], [Recommendation]) VALUES (N'Fargo', N'Engels-Amerikaans', N'Spanning', N'Breaking Bad')

----
/** Episodes **/
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (1, 1, 1001, N'Sherlock')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (2, 1, 1002, N'Sherlock')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (3, 1, 1003, N'Sherlock')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (1, 2, 1004, N'Sherlock')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (2, 2, 1005, N'Sherlock')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (3, 2, 1006, N'Sherlock')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (1, 3, 1007, N'Sherlock')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (2, 3, 1008, N'Sherlock')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (3, 3, 1009, N'Sherlock')
----
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (1, 1, 2000, N'Breaking Bad')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (2, 1, 2001, N'Breaking Bad')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (3, 1, 2002, N'Breaking Bad')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (4, 1, 2003, N'Breaking Bad')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (5, 1, 2004, N'Breaking Bad')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (6, 1, 2005, N'Breaking Bad')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (7, 1, 2006, N'Breaking Bad')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (1, 2, 2007, N'Breaking Bad')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (2, 2, 2008, N'Breaking Bad')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (3, 2, 2009, N'Breaking Bad')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (4, 2, 2010, N'Breaking Bad')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (5, 2, 2011, N'Breaking Bad')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (6, 2, 2012, N'Breaking Bad')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (7, 2, 2013, N'Breaking Bad')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (8, 2, 2014, N'Breaking Bad')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (9, 2, 2015, N'Breaking Bad')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (10, 2, 2016, N'Breaking Bad')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (11, 2, 2017, N'Breaking Bad')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (12, 2, 2018, N'Breaking Bad')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (13, 2, 2019, N'Breaking Bad')
----
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (1, 1, 3001, N'Fargo')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (2, 1, 3002, N'Fargo')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (3, 1, 3003, N'Fargo')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (4, 1, 3004, N'Fargo')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (5, 1, 3005, N'Fargo')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (6, 1, 3006, N'Fargo')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (7, 1, 3007, N'Fargo')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (8, 1, 3008, N'Fargo')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (9, 1, 3009, N'Fargo')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (10, 1, 3010, N'Fargo')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (1, 2, 3101, N'Fargo')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (2, 2, 3102, N'Fargo')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (3, 2, 3103, N'Fargo')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (4, 2, 3104, N'Fargo')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (5, 2, 3105, N'Fargo')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (6, 2, 3106, N'Fargo')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (7, 2, 3107, N'Fargo')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (8, 2, 3108, N'Fargo')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (9, 2, 3109, N'Fargo')
INSERT [dbo].[Episode] ([EpisodeNumber], [SeasonNumber], [ProgramId], [Name]) VALUES (10, 2, 3110, N'Fargo')
----
/** Data insert Watched Program **/
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 1001, N'Kees Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 1002, N'Kees Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 1003, N'Kees Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 1004, N'Kees Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 1005, N'Kees Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 1006, N'Kees Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 1007, N'Kees Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 1008, N'Kees Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 1009, N'Kees Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 1010, N'Kees Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 2000, N'Kees Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 2001, N'Kees Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 2002, N'Kees Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 2003, N'Kees Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 2004, N'Kees Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 2005, N'Kees Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 2006, N'Kees Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 2007, N'Kees Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 2008, N'Kees Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 2009, N'Kees Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 2010, N'Kees Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 2011, N'Kees Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 2012, N'Kees Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 2013, N'Kees Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 2014, N'Kees Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 2015, N'Kees Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 2016, N'Kees Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 3001, N'Kees Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 3002, N'Kees Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (65, 8010, N'Kees Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (22, 8002, N'Kees Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (77, 8004, N'Kees Hendriks', N'Kees')
--
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 1001, N'Lies Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (98, 1002, N'Lies Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (99, 1003, N'Lies Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (98, 1004, N'Lies Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (98, 1005, N'Lies Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (97, 1006, N'Lies Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (99, 3001, N'Lies Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (97, 3002, N'Lies Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (99, 3003, N'Lies Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (98, 3004, N'Lies Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 3005, N'Lies Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 3006, N'Lies Hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (99, 3007, N'Lies Hendriks', N'Kees')
--
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 8012, N'fam-hendriks', N'Kees')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 8016, N'fam-hendriks', N'Kees')
--
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 3001, N'Klaas', N'Klaas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 3002, N'Klaas', N'Klaas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 3003, N'Klaas', N'Klaas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 3004, N'Klaas', N'Klaas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 3005, N'Klaas', N'Klaas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 3006, N'Klaas', N'Klaas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 3007, N'Klaas', N'Klaas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 3008, N'Klaas', N'Klaas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 3009, N'Klaas', N'Klaas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 3010, N'Klaas', N'Klaas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 3101, N'Klaas', N'Klaas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 3102, N'Klaas', N'Klaas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 3103, N'Klaas', N'Klaas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 3104, N'Klaas', N'Klaas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 3105, N'Klaas', N'Klaas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 3106, N'Klaas', N'Klaas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 3107, N'Klaas', N'Klaas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 3108, N'Klaas', N'Klaas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 3109, N'Klaas', N'Klaas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 3110, N'Klaas', N'Klaas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (37, 8014, N'Klaas', N'Klaas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 8002, N'Klaas', N'Klaas')
--
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 1001, N'Rob Tomas', N'Rob')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 1002, N'Rob Tomas', N'Rob')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 1003, N'Rob Tomas', N'Rob')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 1004, N'Rob Tomas', N'Rob')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 1005, N'Rob Tomas', N'Rob')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (68, 1006, N'Rob Tomas', N'Rob')
--
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 1001, N'Pieter Tomas', N'Rob')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 1002, N'Pieter Tomas', N'Rob')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 1003, N'Pieter Tomas', N'Rob')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 1004, N'Pieter Tomas', N'Rob')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 1005, N'Pieter Tomas', N'Rob')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 1006, N'Pieter Tomas', N'Rob')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 1007, N'Pieter Tomas', N'Rob')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 1008, N'Pieter Tomas', N'Rob')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 1010, N'Pieter Tomas', N'Rob')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 3001, N'Pieter Tomas', N'Rob')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 3002, N'Pieter Tomas', N'Rob')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 3003, N'Pieter Tomas', N'Rob')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 3004, N'Pieter Tomas', N'Rob')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 3005, N'Pieter Tomas', N'Rob')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 8001, N'Pieter Tomas', N'Rob')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 8011, N'Pieter Tomas', N'Rob')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (1, 3006, N'Pieter Tomas', N'Rob')
--
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (5, 1001, N'Pa Tomas', N'Rob')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (18, 2000, N'Pa Tomas', N'Rob')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (44, 3001, N'Pa Tomas', N'Rob')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 8002, N'Pa Tomas', N'Rob')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 8014, N'Pa Tomas', N'Rob')
--
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (22, 8001, N'Peter', N'Peter')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (22, 8002, N'Peter', N'Peter')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (22, 8008, N'Peter', N'Peter')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (22, 8010, N'Peter', N'Peter')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (22, 8011, N'Peter', N'Peter')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (22, 8012, N'Peter', N'Peter')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (22, 8014, N'Peter', N'Peter')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (22, 8016, N'Peter', N'Peter')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (22, 8017, N'Peter', N'Peter')
--
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 8016, N'Kinderen', N'Peter')
--
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 1001, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 1002, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (98, 1003, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (97, 1004, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (96, 1005, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (98, 1006, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (97, 1007, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (95, 1008, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (94, 1009, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (97, 2001, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (97, 2002, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (96, 2003, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (99, 2004, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (92, 2005, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (99, 2006, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (95, 2007, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (96, 2008, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (97, 2009, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (99, 2010, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (96, 2011, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (94, 2012, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (98, 2013, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (96, 2014, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (93, 2015, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (87, 2016, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (99, 2017, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (99, 2018, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 2019, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 3001, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (100, 3002, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (90, 3003, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (98, 3004, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (97, 3005, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (96, 3006, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (96, 3007, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (97, 3008, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (91, 3009, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (94, 3010, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (99, 3101, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (95, 3102, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (91, 3103, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (94, 3104, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (98, 3105, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (92, 3106, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (98, 3107, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (93, 3108, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (97, 3109, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (95, 3110, N'Bas', N'Bas')
INSERT [dbo].[Profile_Program] ([PercentageWatched], [ProgramId], [ProfileName], [AccountName]) VALUES (15, 8004, N'Bas', N'Bas')