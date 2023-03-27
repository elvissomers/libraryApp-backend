-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 27, 2023 at 03:25 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bookstore`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `id` bigint(20) NOT NULL,
  `archived` tinyint(1) DEFAULT 0,
  `author` varchar(100) NOT NULL,
  `description` varchar(5000) DEFAULT NULL,
  `in_language` varchar(255) DEFAULT NULL,
  `isbn` bigint(20) NOT NULL,
  `title` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`id`, `archived`, `author`, `description`, `in_language`, `isbn`, `title`) VALUES
(1, 0, 'Joel Grus', 'Data science libraries, frameworks, modules, and toolkits are great for doing data science, but they\'re also a good way to dive into the discipline without actually understanding data science. With this updated second edition, you\'ll learn how many of the most fundamental data science tools and algorithms work by implementing them from scratch. If you have an aptitude for mathematics and some programming skills, author Joel Grus will help you get comfortable with the math and statistics at the core of data science, and with hacking skills you need to get started as a data scientist. Today\'s messy glut of data holds answers to questions no one\'s even thought to ask. This book provides you with the know-how to dig those answers out.', 'en', 9781492041139, 'Data Science from Scratch First Principles with Python'),
(2, 0, 'Michael Franken', 'Scrum helpt teams om op effectieve wijze te werken. Bovendien is deze projectmanagementmethode heel praktisch in een snel veranderende wereld; het biedt je de kans om snel en flexibel te zijn. Voor iedereen die Scrum wil leren kennen en toepassen, is dit het ideale hands-on boek. Het geeft je alle informatie, tips en adviezen om zelf met Scrum aan de slag te gaan.Michael Franken is de eerste Certified Scrum Trainer in Nederland. Hij geeft regelmatig trainingen, lezingen en workshops over Scrum, Agile en softwareontwikkeling in het algemeen.', 'nl', 9789045350301, 'Voor Dummies - Scrum voor Dummies'),
(3, 0, 'Jeff Sutherland', 'Provides a revolutionary approach to project management that helps to transform everything from software companies to the US military to healthcare in major American hospitals. This book explains how it operates and how it can be made to work for anyone, anywhere? It tells how to how to define, what it is that you are seeking to achieve?  ', 'en', 9781847941107, 'Scrum'),
(4, 0, 'Rik van der Wardt', 'Scrum is aan een opmars bezig! Wat oorspronkelijk als softwareontwikkelmethode is bedacht, wordt tegenwoordig op de meest uiteenlopende projecten toegepast.  Scrum is makkelijk te begrijpen en het is daarom een koud kunstje om het raamwerk te leren en in te zien hoe dit voordelen kan opleveren voor organisaties. Hoe het raamwerk optimaal kan worden ingevuld, is echter een ander verhaal. Wanneer je start met het werken met Scrum stuit je op allerlei hobbels waar in veel boeken niet over wordt gerept. Hoe vul je nu een xc3xa9cht goede Sprint Planning in? Hoe houd je vergaderingen effectief en efficixc3xabnt? Het Scrum Modellenboek biedt de complete verzameling van Scrummodellen en tips &amp; trucs die direct toepasbaar zijn in de praktijk. Het boek is sterk visueel van aard, waardoor je de modellen makkelijk onthoudt en het boek makkelijk leest. Onmisbaar voor elk Scrumteam dat zijn ware potentieel wil benutten.', 'nl', 9789024421794, 'Het Scrum Modellenboek'),
(5, 0, 'Nader K. Rad', 'Dit boek is een eenvoudig te begrijpen handleiding voor iedereen die meer wil weten over de concepten van Agile en het Scrum framework door: - de achtergronden te begrijpen achter de verschillende aanpakken in plaats van alleen te leren wat de doxe2x80x99s en donxe2x80x99ts zijn, en - de diversiteit van de Agile concepten te begrijpen in plaats van alleen de laatste trends.  Dit boek bestaat uit drie onderdelen: 1. Fundamentele concepten: Het eerste en laatste hoofdstuk gaan over de betekenis en dynamiek van Agile projecten. Hiermee wordt een stevige basis gelegd die je aan de ene kant helpt om de details te leren en aan de andere kant je helpt om zelf je weg te vinden in projecten. 2. Frameworks: Het hoofdstuk over Scrum behandelt alle details van dit populairste Agile framework omdat iedereen die is betrokken bij een Agile project hiermee bekend moet zijn. Een ander essentieel onderwerp is Kanban, waaraan een apart hoofdstuk is gewijd. 3. Werkwijzen: Het boek bevat hoofdstukken over Crystal, eXtreme Programming en DSDMxc2xae. Hier wordt uitgelegd hoe deze methodes kunnen worden toegepast bij de meest gangbare Agile werkwijzen en technieken.', 'nl', 9789401807937, 'Agile Scrum Handboek'),
(6, 0, 'Rini van Solingen', 'Een inspirerend verhaal dat een introductie geeft in Scrum.  SCRUM is een op Lean en Agile gebaseerde aanpak voor het snel, incrementeel en maximaal effectief ontwikkelen van producten en/of diensten. Scrum hanteert een feedbackgedreven stap-voor-stapaanpak en stelt waardeverhoging, teamverantwoordelijkheid en klantbetrokkenheid centraal. Scrum is intussen de standaardaanpak in de softwareontwikkeling, maar is daarbuiten ook meer dan uitstekend toepasbaar. Daardoor wint Scrum de laatste jaren in heel veel andere omgevingen enorm aan terrein.  Dit bijzondere managementboek in de stijl van een roman is in twee xc3xa0 drie uur te lezen. Het vertelt het verhaal van Mart Verhulst, CTO bij een bedrijf in medische producten, die worstelt met een hopeloos vertraagd project voor een Amerikaanse klant. Met behulp van Pekka, een Finse Scrum-coach, gooit hij het roer om, waarbij hij een aantal van de veelvoorkomende problemen in zijn organisatie structureel oplost. Tijdens het lezen van dit verhaal krijg je Scrum stapsgewijs uitgelegd op een logische en laagdrempelige manier.  Rini van Solingen is spreker en auteur. Hij is CTO bij Prowareness en deeltijdhoogleraar aan de TU Delft. Eelco Rustenburg (Twitter: @eelco1969) is partner bij BlinkLane Consulting, onderdeel van de Highberg Group. Eelco jongleert met spreken, schrijven, consulting, training en workshops, innoveren en het werken met zijn teams.  xe2x80x98Technologie verandert onze wereld. Deze klassieker leest als een trein en geeft inzicht in een aantal concrete principes om je organisatie succesvol te veranderen met technologie.xe2x80x99 xe2x80x94 Jurrie van Rooijen, directeur IT/CTO, bol.com  xe2x80x98Een aantrekkelijk boek dat je motiveert om met Scrum aan de slag te gaan. Alleen de echte invoering van Scrum in je eigen bedrijf is spannender dan dit boek.xe2x80x99 xe2x80x94 Edgar van Zoelen, Head of HealthSuite Labs &amp; Eco System Management, Philips', 'nl', 9789043039987, 'De kracht van Scrum'),
(7, 0, 'Eric Matthes', 'Crash Course programmeren in Python is een snelle maar diepgaande introductie in programmeren met Python. Leer in korte tijd programmaxe2x80x99s schrijven, problemen oplossen en laat programmaxe2x80x99s ook werken. In de eerste helft van het boek komen basis programmeerconcepten aan de orde, zoals het maken van lijsten, woordenboeken, classes en lussen, en wordt het schrijven van duidelijke en leesbare code aangeleerd met oefeningen over ieder onderwerp. Daarnaast leer je hoe je programmaxe2x80x99s interactief maakt en hoe je code test op veiligheid voordat je het aan een project toevoegt. In de tweede helft gebruik je deze kennis voor het maken van drie projecten: een arcade game gexc3xafnspireerd op Space Invaders, datavisualisatie met de bibliotheken van Python en een eenvoudige webapp. Dit boek is geschikt voor iedereen die serieus overweegt om zich te verdiepen in programmeren. Het boek helpt je op weg en leert je in snel tempo programmaxe2x80x99s maken. Ga nu aan de slag met coderen!  De onderwerpen in dit boek: xe2x80xa2 de krachtige Python bibliotheken en opties gebruiken, inclusief matplotlib, NumPy, and Pygal xe2x80xa2 2D-spellen maken die reageren op toetsenbordaanslagen en muisklikken en die moeilijker worden naarmate het spel vordert xe2x80xa2 werken met data om interactieve visualisaties te maken xe2x80xa2 webapps maken, aanpassen en online verspreiden xe2x80xa2 omgaan met fouten en errors, ofwel programmeerproblemen oplossen  Geschikt voor: Windows, macOS en Linux.  Eric Matthes is docent natuurkunde en wiskunde op een middelbare school in Alaska, waar hij ook introductielessen in Python geeft. Hij heeft al programmaxe2x80x99s geschreven sinds hij vijf jaar oud was.', 'nl', 9789059056749, 'Crash course programmeren in Python'),
(8, 0, 'Studio Visual Steps', 'Programmeren is leuk, uitdagend en de vaardigheden die je daarbij leert, zijn nuttig voor de rest van je leven. Heb jij het programmeren al ontdekt?  Python is een veelgebruikte en makkelijk te leren programmeertaal die ook leuk is om te gebruiken. Met dit boek leer je de basis van het programmeren stap voor stap door te werken aan allerlei korte projecten. Zo maak je bijvoorbeeld een omrekenprogramma om kilometers naar meters om te rekenen, een lettertelprogramma en een programma dat getallen raadt. Hierbij bouw je de programmaxe2x80x99s stap voor stap op. Steeds ga je een stapje verder en uiteindelijk maak je zelfs je eigen versie van het spel Mastermind, waarmee de gebruiker een geheime code moet raden.  Leer hoe je: - commandoxe2x80x99s typt - fouten herkent en herstelt - numerieke en tekstvariabelen gebruikt - input vraagt - beslissingscommandoxe2x80x99s gebruikt - modules gebruikt - lussen maakt - woordenboeken en lijsten maakt - tekent met de turtle - commentaar toevoegt en je programmaxe2x80x99s test  Geschikt voor: Windows 10 en MacOS', 'nl', 9789059056541, 'Stap voor stap leren programmeren met Python'),
(9, 0, 'Luciano Ramalho', 'Don\'t waste time bending Python to fit patterns you\'ve learned in other languages. Python\'s simplicity lets you become productive quickly, but often this means you aren\'t using everything the language has to offer. With the updated edition of this hands-on guide, you\'ll learn how to write effective, modern Python 3 code by leveraging its best ideas. Discover and apply idiomatic Python 3 features beyond your past experience. Author Luciano Ramalho guides you through Python\'s core language features and libraries and teaches you how to make your code shorter, faster, and more readable. Complete with major updates throughout, this new edition features five parts that work as five short books within the book: Data structures: Sequences, dicts, sets, Unicode, and data classes Functions as objects: First-class functions, related design patterns, and type hints in function declarations Object-oriented idioms: Composition, inheritance, mixins, interfaces, operator overloading, protocols, and more static types Control flow: Context managers, generators, coroutines, async/await, and thread/process pools Metaprogramming: Properties, attribute descriptors, class decorators, and new class metaprogramming hooks that replace or simplify metaclasses', 'en', 9781492056355, 'Fluent Python'),
(10, 0, 'Zed Shaw', 'You Will Learn Python 3! Zed Shaw has perfected the world\'s best system for learning Python 3. Follow it and you will succeed-just like the millions of beginners Zed has taught to date! You bring the discipline, commitment, and persistence; the author supplies everything else. In Learn Python 3 the Hard Way, you\'ll learn Python by working through 52 brilliantly crafted exercises. Read them. Type their code precisely. (No copying and pasting!) Fix your mistakes. Watch the programs run. As you do, you\'ll learn how a computer works; what good programs look like; and how to read, write, and think about code. Zed then teaches you even more in 5+ hours of video where he shows you how to break, fix, and debug your code-live, as he\'s doing the exercises. Install a complete Python environment Organize and write code Fix and break code Basic mathematics Variables Strings and text Interact with users Work with files Looping and logic Data structures using lists and dictionaries Program design Object-oriented programming Inheritance and composition Modules, classes, and objects Python packaging Automated testing Basic game development Basic web development It\'ll be hard at first. But soon, you\'ll just get it-and that will feel great! This course will reward you for every minute you put into it. Soon, you\'ll know one of the world\'s most powerful, popular programming languages. You\'ll be a Python programmer. This Book Is Perfect For Total beginners with zero programming experience Junior developers who know one or two languages Returning professionals who haven\'t written code in years Seasoned professionals looking for a fast, simple, crash course in Python 3', 'en', 9780134692883, 'Learn Python 3 the Hard Way'),
(11, 0, 'Dr Charles Russell Severance', 'Python for Everybody is designed to introduce students to programming and software development through the lens of exploring data. You can think of the Python programming language as your tool to solve data problems that are beyond the capability of a spreadsheet.Python is an easy to use and easy to learn programming language that is freely available on Macintosh, Windows, or Linux computers. So once you learn Python you can use it for the rest of your career without needing to purchase any software.This book uses the Python 3 language. The earlier Python 2 version of this book is titled \'\'Python for Informatics: Exploring Information\'\'.There are free downloadable electronic copies of this book in various formats and supporting materials for the book at www.py4e.com. The course materials are available to you under a Creative Commons License so you can adapt them to teach your own Python course.', 'en', 9781530051120, 'Python for Everybody'),
(12, 0, 'John Paul Mueller', ' Python is een van de populairste programmeertalen ter wereld. En dat is niet zo gek: Python biedt betrouwbare code en een bondige syntaxis waarmee je apps kunt maken met minder regels code dan met andere programmeertalen. Bovendien wordt Python voor allerlei onderwerpen gebruikt door mensen zonder programmeerervaring. Met Programmeren met Python voor Dummies leer je in heldere stap-voor-stapinstructies de syntaxis van Python kennen en ontdek je de logica achter het programmeren. Met dit boek heeft Python geen geheimen meer voor jou! John Paul Mueller is auteur en redacteur. Hij heeft zo\'n honderd boeken en meer dan 300 artikelen geproduceerd, onder meer voor verschillende magazines. ', 'nl', 9789045354521, 'Voor Dummies - Programmeren met Python voor Dummies'),
(13, 0, 'Allen B Downey', 'This hands-on guide takes you through the language a step at a time, beginning with basic programming concepts before moving on to functions, recursion, data structures, and object-oriented design. This second edition and its supporting code have been updated for Python 3.  ', 'en', 9781491939369, 'Think Python'),
(14, 0, 'Lee Vaughan', 'Doing Science With Python introduces readers to the most popular coding tools for scientific research, such as Anaconda, Spyder, Jupyter Notebooks, and JupyterLab, as well as dozens of important Python libraries for working with data, including NumPy, matplotlib, and pandas. No prior programming experience is required! You\'ll be guided through setting up a professional coding environment, then get a crash course on programming with Python, and explore the many tools and libraries ideal for working with data, designing visualisations, simulating natural events, and more.', 'en', 9781718502666, 'Python Tools For Scientists'),
(15, 0, 'Wes Mckinney', ' Get the definitive handbook for manipulating, processing, cleaning, and crunching datasets in Python. Updated for Python 3.10 and pandas 1.4, the third edition of this hands-on guide is packed with practical case studies that show you how to solve a broad set of data analysis problems effectively. You\'ll learn the latest versions of pandas, NumPy, and Jupyter in the process.   Written by Wes McKinney, the creator of the Python pandas project, this book is a practical, modern introduction to data science tools in Python. It\'s ideal for analysts new to Python and for Python programmers new to data science and scientific computing. Data files and related material are available on GitHub.   Use the Jupyter notebook and IPython shell for exploratory computing Learn basic and advanced features in NumPy Get started with data analysis tools in the pandas library Use flexible tools to load, clean, transform, merge, and reshape data Create informative visualizations with matplotlib Apply the pandas groupby facility to slice, dice, and summarize datasets Analyze and manipulate regular and irregular time series data Learn how to solve real-world data analysis problems with thorough, detailed examples ', 'en', 9781098103989, 'Python for Data Analysis'),
(16, 0, 'Francois Chollet', 'Deep Learning with Python introduces the field of deep learning using the Python language and the powerful Keras library. Youxe2x80x99ll learn directly from the creator of Keras, Franxc3xa7ois Chollet, building your understanding through intuitive explanations and practical examples. Updated from the original bestseller with over 50% new content, this second edition includes new chapters, cutting-edge innovations, and coverage of the very latest deep learning tools. You\'ll explore challenging concepts and practice with applications in computer vision, natural-language processing, and generative models. By the time you finish, you\'ll have the knowledge and hands-on skills to apply deep learning in your own projects.', 'en', 9781617296864, 'Deep Learning with Python'),
(17, 0, 'David Flanagan', 'JavaScript is the programming language of the web and is used by more software developers today than any other programming language. For nearly 25 years this best seller has been the go-to guide for JavaScript programmers. The seventh edition is fully updated to cover the 2020 version of JavaScript, and new chapters cover classes, modules, iterators, generators, Promises, async/await, and metaprogramming. You\'ll find illuminating and engaging example code throughout. This book is for programmers who want to learn JavaScript and for web developers who want to take their understanding and mastery to the next level. It begins by explaining the JavaScript language itself, in detail, from the bottom up. It then builds on that foundation to cover the web platform and Node.js. Topics include: Types, values, variables, expressions, operators, statements, objects, and arrays Functions, classes, modules, iterators, generators, Promises, and async/await JavaScript\'s standard library: data structures, regular expressions, JSON, i18n, etc. The web platform: documents, components, graphics, networking, storage, and threads Node.js: buffers, files, streams, threads, child processes, web clients, and web servers Tools and language extensions that professional JavaScript developers rely on', 'en', 9781491952023, 'JavaScript The Definitive Guide'),
(18, 0, 'S Selikoff', ' Your complete roadmap to the OCP Java SE 17 Developer exam   The OCP Oraclexc2xae Certified Professional Java SE 17 Developer Study Guide is your one-stop resource for authoritative coverage of the 1Z0-829 exam. This Sybex Study Guide covers 100% of the 1Z0-829 objective domains. Prepare for the exam smarter and faster with Sybex thanks to focused content that validates and measures exam readiness, real-world examples and scenarios, practical exercises, and chapter review questions. Reinforce and retain what youxe2x80x99ve learned with the Sybex online learning environment and test bank, accessible across multiple devices. Prepare for success on the Java SE 17 Developer exam with Sybex.    Coverage of 100% of all exam objectives in this Study Guide means youxe2x80x99ll be ready for:   Directing Flow with Decision Statements, Pattern Matching, and Switch Expressions Working with Primitives, Strings, var, and Text Blocks Creating Lambda Expressions and Method References Designing Classes, Interfaces, Enums, Records, and Sealed Classes Writing Functional Interfaces and Streams Building Modules and Migrating Applications to Modules Applying I/O, NIO.2, JDBC, Threads, and Concurrency Localizing Applications and Formatting Dates/Numbers Gracefully Handling Exceptions and Errors and morexe2x80xa6    ABOUT THE ORACLE CERTIFIED PROFESSIONAL PROGRAM    The OCP Oracle Certified Professional Java SE 17 Developer certification validates advanced understanding of Oracle concepts and skills as well as experience applying them in the real world. The focus is on advanced developer skills with a strong foundation in Java technology.    Interactive learning environment    Take your exam prep to the next level with Sybexxe2x80x99s superior interactive online study tools. To access our learning environment, simply visit www.wiley.com/go/sybextestprep, register your book to receive your unique PIN, and instantly gain one year of FREE access after activation to:   Interactive test bank with 3 practice exams to help you identify areas where further review is needed. Get more than 90% of the answers correct, and youxe2x80x99re ready to take the certification exam.  More than 500 electronic flashcards to reinforce learning and last-minute prep before the exam  Comprehensive glossary in PDF format gives you instant access to the key terms so you are fully prepared  ', 'en', 9781119864585, 'OCP Oracle Certified Professional Java SE 17 Developer Study Guide: Exam 1Z0xe2x80x93829'),
(19, 0, 'Joshua Bloch', 'The definitive guide to Java programming language best practices from Josh Bloch Each chapter of Effective Java, Third Edition, consists of several items, each presented in the form of a short, stand-alone essay that provides specific advice, insight into Java platform subtleties, and code examples. The comprehensive descriptions and explanations for each item illuminate what to do, what not to do, and why. While coverage is through Java 9, this guidance covers core Java features every programmer works with, regardless of which version. Concurrency: write clear, correct, well-documented concurrent programs Objects: creating and destroying; common methods Classes and interfaces: guidelines for making them usable, robust, and flexible Generics: tell the compiler what types of objects are permitted in each collection for safer and clearer programs Enums and annotations: two special-purpose families of reference types Functions: break a big job into smaller pieces that might well be written by different people separated by both time and space. Lambdas and streams: create function objects with more ease Method designs: treat parameters and return values; design method signatures; document methods Exceptions: improve a program\'s readability, reliability, and maintainability Object serialization: the dangers of serialization and how to minimize them General programming: local variables control structures libraries data types reflection native methods optimization naming conventions Programmers still consider this the best book on Java programming today.', 'en', 9780134685991, 'Effective Java'),
(20, 0, 'B Burd', ' Learning Javaxc2xae is smooth sailing with Dummies   The bestselling guide to the Javaxc2xae programming language is back. Java For Dummies is your need-to-read guide for mastering this essential programming language. Even if you arenxe2x80x99t studying Java on the island of Java, youxe2x80x99ll feel like youxe2x80x99re on vacation, with easy-to-understand explanations that make learning easy, for beginners and experienced coders alike. Start with the essential building blocks and bushwhack your way through writing programs that work. Pick up some fancy tips and techniques along the way, and youxe2x80x99ll soon be a native of Java land.   Insidexe2x80xa6    Develop good software Control program flow Create objects and classes Use arrays and collections Respond to button clicks Connect to a database Download the bookxe2x80x99s sample code Get practice with additional exercises ', 'en', 9781119861645, 'Java For Dummies, 8th Edition'),
(21, 0, 'P. Kassenaar', '(X)HTML, CSS en JavaScript vormen de drijvende kracht achter de hedendaagse website. Niet alleen kennis van deze onderdelen, maar ook van de onderlinge interactie is van cruciaal belang om een gelikte, gebruiksvriendelijke en moderne website te ontwikkelen. In het Handboek (X)HTML, CSS &amp; JavaScript laat internetexpert Peter Kassenaar u zien hoe u gebruikmaakt van genoemde technieken, maar vooral ook hoe u ze optimaal laat samenwerken. Het resultaat is een website die zich aan de huidige webstandaarden conformeert en in alle gangbare browsers optimaal presteert. Tot de behandelde onderwerpen behoren: - Beginnen met HTML - Kennismaken met CSS - JavaScript in een notendop - Koppelingen maken - Werken met HTML-lijsten - Verschillende mediatypen op de site gebruiken - Werken met HTML-tabellen - Paginaxc2x92s opmaken met CSS-lagen - Werken met formulieren - Technieken met JavaScript - De site publiceren op het web', 'nl', 9789059404144, 'Handboek (X)HTML, CSS en JavaScript'),
(22, 0, 'Jon Duckett', 'Learn JavaScript and jQuery a nicer way This full-color book adopts a visual approach to teaching JavaScript &amp; jQuery, showing you how to make web pages more interactive and interfaces more intuitive through the use of inspiring code examples, infographics, and photography. The content assumes no previous programming experience, other than knowing how to create a basic web page in HTML &amp; CSS. You\'ll learn how to achieve techniques seen on many popular websites (such as adding animation, tabbed panels, content sliders, form validation, interactive galleries, and sorting data).. Introduces core programming concepts in JavaScript and jQueryUses clear descriptions, inspiring examples, and easy-to-follow diagramsTeaches you how to create scripts from scratch, and understand the thousands of JavaScripts, JavaScript APIs, and jQuery plugins that are available on the webDemonstrates the latest practices in progressive enhancement, cross-browser compatibility, and when you may be better off using CSS3If you\'re looking to create more enriching web experiences and express your creativity through code, then this is the book for you.This book is also available as part of a set in hardcover - Web Design with HTML, CSS, JavaScript and jQuery, 9781119038634 - and in softcover - Web Design with HTML, CSS, JavaScript and jQuery, 9781118907443. ', 'en', 9781118531648, 'JavaScript &amp; Jquery'),
(23, 0, 'Steve Suehring', 'Get the basics on four key web programming tools in one great book!  PHP, JavaScript, and HTML5 are essential programming languages for creating dynamic websites that work with the MySQL database. PHP and MySQL provide a robust, easyxe2x80x93toxe2x80x93learn, openxe2x80x93source solution for creating superb exe2x80x93commerce sites and content management.     7 books in 1   Web Technologies HTML and CSS JavaScript PHP MySQL Web Applications PHP and Templates   In charge of a website? Herexe2x80xb2s what you need to know about key web technologies!   Websites have become much flashier, but the building blocks to create them remain much the same. This informationxe2x80x93packed book covers four essential web technologies: HTML and CSS, JavaScript, PHP, and MySQL. Learn how they work together to create web services, validate web forms, and set up a membersxe2x80x93only site, plus discover how to create a templating system with PHP. Youxe2x80xb2ll build on the basics and take your website to new levels with this friendly For Dummies guide.   Lay the groundwork find out how the web works and how to get and install PHP, MySQL, and a web server Style it create a page with HTML, add style with CSS, build a JavaScript program, and see what jQuery can do for you Rockinxe2x80xb2 with PHP learn about PHP syntax and error messages, build a script, and use PHP to create dynamic web pages Magical MySQL administer MySQL and set up MySQL accounts, design and build databases, keep them updated, and connect MySQL to PHP Service, please create a web service, create and validate web forms, and set up login objects   Open the book and find:   Installation instructions for Windows, Mac, and Linux HTML building blocks How CSS makes creating forms easier The difference between JavaScript and Java Tips on coding more efficiently with jQuery An introduction to objectxe2x80x93 oriented programming Details of database structure How PHP templates can help reduce code ', 'en', 9781118213704, 'PHP MySQL JavaScript &amp; HTML5 All in One'),
(24, 0, 'Michael Kxc3xb6lling', 'In Programmeren met Java in Greenfoot leer je hoe je grafische computerprogramma\'s programmeert met behulp van de programmeertaal Java en de ontwikkelomgeving Greenfoot. Het boek heeft een praktische insteek: je begint direct met eenvoudige oefeningen, zoals het maken van een interactief spel of een simulatie. Tegelijkertijd leer je belangrijke onderliggende programmeerprincipes. Door zelf te experimenteren leer je al doende objectgeorixc3xabnteerd programmeren. Programmeren met Java in Greenfoot is een toegankelijke inleiding tot Greenfoot. Het is daarom zeer geschikt voor studenten aan het middelbaar en hoger beroepsonderwijs. Het boek is tevens geschikt voor zelfstudie. Greenfoot is een opensourceprogramma dat je gratis kunt downloaden via www.greenfoot.org. Op deze site tref je verder ideexc3xabn voor projecten, tutorial video\'s en links naar gerelateerde websites. Michael Kxc3xb6lling is als docent verbonden aan de Universiteit van Kent in Canterbury, en coauteur van Programmeren in Java met BlueJ. Hij is tevens medeontwikkelaar van de BlueJ omge - ving. Programmeren in Java met Greenfoot is voor de Neder lands - talige markt bewerkt door Gertjan Laan, docent aan de Hogeschool van Amsterdam en auteur van diverse studieboeken. ', 'nl', 9789043018791, 'Programmeren in Java met Greenfoot'),
(25, 0, 'Chris Minnick', ' Elke keer dat een website reageert op bewegingen van jouw muis, is JavaScript daar verantwoordelijk voor. Kennis van JavaScript is dus onmisbaar als je een aantrekkelijke, interactieve website wil maken. Heb je geen programmeerervaring? Geen probleem! Dit boek begint bij de basis en bevat duidelijke stap-voor-stapinstructies waarmee iedere beginner succesvol leert programmeren. Je bouwt website-elementen en simpele applicaties, zodat je direct ziet hoe JavaScript wordt gebruikt en welke toepassingen er mogelijk zijn. Met dit boek hebben interactieve sites en apps geen geheimen meer voor jou! Chris Minnick is auteur, trainer en webontwikkelaar en heeft gewerkt aan online en mobiele projecten voor bedrijven. Eva Holland is auteur en geeft online en persoonlijk cursussen. ', 'nl', 9789045354705, 'Voor Dummies - Programmeren met JavaScript voor Dummies'),
(26, 0, 'Robin Nixon', 'Build interactive, data-driven websites with the potent combination of open source technologies and web standards, even if you have only basic HTML knowledge. With the latest edition of this popular hands-on guide, you\'ll tackle dynamic web programming using the most recent versions of today\'s core technologies: PHP, MySQL, JavaScript, CSS, HTML5, and the powerful React and React Native libraries. Web designers will learn how to use these technologies together while picking up valuable web programming practices along the way--including how to optimize websites for mobile devices. Finally, you\'ll put everything together to build a fully functional social networking site suitable for both desktop and mobile browsers. Explore MySQL from database structure to complex queries Use the MySQL PDO extension, PHP\'s improved MySQL interface Create dynamic PHP web pages that tailor themselves to the user Manage cookies and sessions and maintain a high level of security Enhance JavaScript with the React and React Native libraries Use Ajax calls for background browser server communication Style your web pages by acquiring CSS skills Implement HTML5 features, including geolocation, audio, video, and the canvas Reformat your websites into mobile web apps', 'en', 9781492093824, 'Learning PHP, MySQL &amp; JavaScript'),
(27, 0, 'Herbert Schildt', 'The definitive guide to Java programming-thoroughly revised for Java SE 17 Fully updated for the current version of Java, Java SE 17, this practical guide from Oracle Press shows, step by step, how to design, write, troubleshoot, run, and maintain high-performance Java programs. Inside, bestselling author Herbert Schildt covers the entire Java language, including its syntax, keywords, and libraries. The book lays out cutting-edge programming techniques and best practices. Java: The Complete Reference, Twelfth Edition features clear explanations, detailed code samples, and real-world examples that demonstrate how Java can be put to work in the real world. JavaBeans, servlets, applets, Swing, lambda expressions, multithreading, and the default interface method are thoroughly discussed. You will get full details on all of the new features and functions available in Java SE 17. Designed for novice, intermediate, and professional programmers alike Source code for all examples and projects are available for download Written in the clear, uncompromising style for which Herb Schildt is famous', 'en', 9781260463415, 'Java: The Complete Reference, Twelfth Edition'),
(28, 0, 'Aurelien Geron', 'Through a series of recent breakthroughs, deep learning has boosted the entire field of machine learning. Now, even programmers who know close to nothing about this technology can use simple, efficient tools to implement programs capable of learning from data. This practical book shows you how. By using concrete examples, minimal theory, and two production-ready Python frameworks-Scikit-Learn and TensorFlow-author Aurelien Geron helps you gain an intuitive understanding of the concepts and tools for building intelligent systems. Youll learn a range of techniques, starting with simple linear regression and progressing to deep neural networks. With exercises in each chapter to help you apply what youve learned, all you need is programming experience to get started. Explore the machine learning landscape, particularly neural nets Use Scikit-Learn to track an example machine-learning project end-to-end Explore several training models, including support vector machines, decision trees, random forests, and ensemble methods Use the TensorFlow library to build and train neural nets Dive into neural net architectures, including convolutional nets, recurrent nets, and deep reinforcement learning Learn techniques for training and scaling deep neural nets', 'en', 9781492032649, 'Hands-on Machine Learning with Scikit-Learn, Keras, and TensorFlow'),
(29, 0, 'Ian Goodfellow', 'An introduction to a broad range of topics in deep learning, covering mathematical and conceptual background, deep learning techniques used in industry, and research perspectives. Written by three experts in the field, Deep Learning is the only comprehensive book on the subject. -Elon Musk, cochair of OpenAI; cofounder and CEO of Tesla and SpaceX Deep learning is a form of machine learning that enables computers to learn from experience and understand the world in terms of a hierarchy of concepts. Because the computer gathers knowledge from experience, there is no need for a human computer operator to formally specify all the knowledge that the computer needs. The hierarchy of concepts allows the computer to learn complicated concepts by building them out of simpler ones; a graph of these hierarchies would be many layers deep. This book introduces a broad range of topics in deep learning. The text offers mathematical and conceptual background, covering relevant concepts in linear algebra, probability theory and information theory, numerical computation, and machine learning. It describes deep learning techniques used by practitioners in industry, including deep feedforward networks, regularization, optimization algorithms, convolutional networks, sequence modeling, and practical methodology; and it surveys such applications as natural language processing, speech recognition, computer vision, online recommendation systems, bioinformatics, and videogames. Finally, the book offers research perspectives, covering such theoretical topics as linear factor models, autoencoders, representation learning, structured probabilistic models, Monte Carlo methods, the partition function, approximate inference, and deep generative models. Deep Learning can be used by undergraduate or graduate students planning careers in either industry or research, and by software engineers who want to begin using deep learning in their products or platforms. A website offers supplementary material for both readers and instructors.', 'en', 9780262035613, 'Deep Learning'),
(30, 0, 'Osvaldo Simeone', 'This self-contained introduction to machine learning, designed from the start with engineers in mind, will equip students with everything they need to start applying machine learning principles and algorithms to real-world engineering problems. With a consistent emphasis on the connections between estimation, detection, information theory, and optimization, it includes: an accessible overview of the relationships between machine learning and signal processing, providing a solid foundation for further study; clear explanations of the differences between state-of-the-art techniques and more classical methods, equipping students with all the understanding they need to make informed technique choices; demonstration of the links between information-theoretical concepts and their practical engineering relevance; reproducible examples using Matlab, enabling hands-on student experimentation. Assuming only a basic understanding of probability and linear algebra, and accompanied by lecture slides and solutions for instructors, this is the ideal introduction to machine learning for engineering students of all disciplines.', 'en', 9781316512821, 'Machine Learning for Engineers'),
(31, 0, 'Julian McAuley', 'Every day we interact with machine learning systems offering individualized predictions for our entertainment, social connections, purchases, or health. These involve several modalities of data, from sequences of clicks to text, images, and social interactions. This book introduces common principles and methods that underpin the design of personalized predictive models for a variety of settings and modalities. The book begins by revising \'traditional\' machine learning models, focusing on adapting them to settings involving user data, then presents techniques based on advanced principles such as matrix factorization, deep learning, and generative modeling, and concludes with a detailed study of the consequences and risks of deploying personalized predictive systems. A series of case studies in domains ranging from e-commerce to health plus hands-on projects and code examples will give readers understanding and experience with large-scale real-world datasets and the ability to design models and systems for a wide range of applications.', 'en', 9781316518908, 'Personalized Machine Learning'),
(32, 0, 'Kevin P. Murphy', 'A detailed and up-to-date introduction to machine learning, presented through the unifying lens of probabilistic modeling and Bayesian decision theory.This book offers a detailed and up-to-date introduction to machine learning (including deep learning) through the unifying lens of probabilistic modeling and Bayesian decision theory. The book covers mathematical background (including linear algebra and optimization), basic supervised learning (including linear and logistic regression and deep neural networks), as well as more advanced topics (including transfer learning and unsupervised learning). End-of-chapter exercises allow students to apply what they have learned, and an appendix covers notation. Probabilistic Machine Learning grew out of the authorxc2x92s 2012 book, Machine Learning: A Probabilistic Perspective. More than just a simple update, this is a completely new book that reflects the dramatic developments in the field since 2012, most notably deep learning. In addition, the new book is accompanied by online Python code, using libraries such as scikit-learn, JAX, PyTorch, and Tensorflow, which can be used to reproduce nearly all the figures; this code can be run inside a web browser using cloud-based notebooks, and provides a practical complement to the theoretical topics discussed in the book. This introductory text will be followed by a sequel that covers more advanced topics, taking the same probabilistic approach.', 'en', 9780262046824, 'Probabilistic Machine Learning'),
(33, 0, 'Steven L. Brunton', 'Data-driven discovery is revolutionizing how we model, predict, and control complex systems. Now with Python and MATLAB (R), this textbook trains mathematical scientists and engineers for the next generation of scientific discovery by offering a broad overview of the growing intersection of data-driven methods, machine learning, applied optimization, and classical fields of engineering mathematics and mathematical physics. With a focus on integrating dynamical systems modeling and control with modern methods in applied machine learning, this text includes methods that were chosen for their relevance, simplicity, and generality. Topics range from introductory to research-level material, making it accessible to advanced undergraduate and beginning graduate students from the engineering and physical sciences. The second edition features new chapters on reinforcement learning and physics-informed machine learning, significant new sections throughout, and chapter exercises. Online supplementary material - including lecture videos per section, homeworks, data, and code in MATLAB (R), Python, Julia, and R - available on databookuw.com.', 'en', 9781009098489, 'Data-Driven Science and Engineering'),
(34, 0, 'Andriy Burkov', 'Endorsed by top AI authors, academics and industry leaders, The Hundred-Page Machine Learning Book is the number one bestseller on Amazon and the most recommended book for starters and experienced professionals alike.', 'en', 9781999579517, 'The Hundred-Page Machine Learning Book'),
(35, 0, 'Linda van der Meer', 'Deze trainershandleiding is bedoeld voor trainers en professionals die op een didactische wijze vaardigheden willen overbrengen op anderen. Met deze trainershandleiding en bijbehorend lesmateriaal kunt u direct beginnen met de training. Na deze training hebben deelnemers handvatten om anderen feedback te geven. Zij zijn bekend met de regels van feedback. Zij leren waarderend vragen stellen, zodat zij op een constructieve wijze het gedrag van een ander kunnen sturen. Tot slot wordt bekeken wat men zelf kan doen om tot een feedbackcultuur te komen. Het lesmateriaal behorend bij deze training is te downloaden via www.kuratca.nl/leeromgeving met de bijbehorende productcode.', 'nl', 9789463867726, 'Trainershandleiding \'Feedback geven en ontvangen\''),
(36, 0, 'Marieta Koopmans', 'Slik je je kritiek op anderen soms in? Maakt het je wat uit of je commentaar geeft aan je medewerker, collega of baas? Vermijd je het wel eens om positieve feedback te geven? Veel mensen zullen deze vragen bevestigend beantwoorden. Zij vinden het moeilijk om met feedback om te gaan en lopen er liever met een boog omheen. Toch is open communiceren onontbeerlijk voor het bereiken van (top)prestaties in organisaties. Dit praktische boek leert je luisteren naar wat anderen je zeggen en je eigen commentaar zo te geven dat anderen naar je luisteren. Je leert hoe je op een duidelijke manier commentaar kunt geven, zonder met je waardeoordelen anderen te kwetsen of af te kraken. Je krijgt inzicht in de angst en emoties die daarmee gepaard kunnen gaan. Zo verbeter je het persoonlijk functioneren van jezelf en de mensen om je heen.', 'nl', 9789058711878, 'Feedback'),
(37, 0, 'E Freeman', ' Discover the competitive advantages of DevOps Adopt DevOps-friendly tech, including cloud and containers Convert your organization to DevOps methodology   Join the DevOps revolution!   With DevOps, you can accelerate the software delivery life cyclexc2x97once you understand the processes, tools, and mindset that drives DevOps culture. This book helps software engineers and tech executives transform their organizations to adopt a DevOps framework. Learn to create a more customer-centric, iterative style of development and delivery that increases collaboration, eliminates bottlenecks, and accelerates team productivity.   Inside...   Identify your bottlenecks Build your DevOps framework Get your team on board Adapt organizational culture Learn from failure Prepare for incident management Automate manual processes ', 'en', 9781119552222, 'DevOps For Dummies'),
(38, 0, 'Rik Marselis', 'To continuously deliver IT systems at speed with a focus on business value, DevOps teams integrate quality engineering in their way of working.  This book supports teams in implementing quality in their DevOps culture, with practical examples, useful knowledge and some theoretical background. For example, it describes how to benefit from a CI/CD pipeline.  TMAP is the body of knowledge for quality engineering in IT delivery and builds on practical experience from thousands of people in more than twenty-five years. The website, www.tmap.net, supports any kind of IT delivery model. This book, however, focuses on DevOps: todayxe2x80x99s implementation of high-performance IT delivery.', 'en', 9789075414899, 'Quality for DevOps teams'),
(39, 0, 'Gene Kim', 'This award-winning and bestselling business handbook for digital transformation is now fully updated and expanded with the latest research and new case studies!  ', 'en', 9781950508402, 'The DevOps Handbook'),
(40, 0, 'Bradley Smith', 'This book introduces fundamental concepts software developers need to know to flourish in a modern DevOps environment including infrastructure as code, configuration management, security, containerization and orchestration, monitoring and alerting, and troubleshooting. Readers will follow along with hands-on examples to learn how to tackle common DevOps tasks.', 'en', 9781718502482, 'Devops For The Desperate'),
(41, 0, 'Subhajit Chatterjee', ' Written by Microsoft MVPs and Azure experts, this comprehensive guide comes with self-study exercises to help you understand the concepts better and move closer to becoming a skilled Azure DevOps engineer  Key Features  Explore a step-by-step approach to designing and creating a successful DevOps environment Understand how to implement continuous integration and continuous deployment pipelines on Azure Integrate and implement security, compliance, containers, and databases in your DevOps strategies  Book Description  The AZ-400 Designing and Implementing Microsoft DevOps Solutions certification helps DevOps engineers and administrators get to grips with practices such as continuous integration and continuous delivery (CI/CD), containerization, and zero downtime deployments using Azure DevOps Services.   This new edition is updated with advanced topics such as site reliability engineering (SRE), continuous improvement, and planning your cloud transformation journey. The book begins with the basics of CI/CD and automated deployments, and then moves ahead to show you how to apply configuration management and Infrastructure as Code (IaC) along with managing databases in DevOps scenarios. As you make progress, you\'ll explore fitting security and compliance with DevOps and find out how to instrument applications and gather metrics to understand application usage and user behavior. This book will also help you implement a container build strategy and manage Azure Kubernetes Services. Lastly, you\'ll discover quick tips and tricks to confidently apply effective DevOps practices and learn to create your own Azure DevOps organization.   By the end of this DevOps book, you\'ll have gained the knowledge needed to ensure seamless application deployments and business continuity.  What you will learn  Get acquainted with Azure DevOps Services and DevOps practices Discover how to efficiently implement CI/CD processes Build and deploy a CI/CD pipeline with automated testing on Azure Integrate security and compliance in pipelines Understand and implement Azure Container Services Effectively close the loop from production back to development Apply continuous improvement strategies to deliver innovation at scale  Who this book is for  The book is for anyone looking to prepare for the AZ-400 certification exam. Software developers, application developers, and IT professionals who want to implement DevOps practices for the Azure cloud will also find this book helpful. Familiarity with Azure DevOps basics, software development, and development practices is recommended but not necessary. ', 'en', 9781803230283, 'Designing and Implementing Microsoft DevOps Solutions AZ-400 Exam Guide'),
(42, 0, 'Anne Arink', 'Kom maar op met je feedback gaat over feedback in een professionele context en hoe het je kan helpen in het onderwijs effectiever en gelukkiger te worden. Het geeft inzicht en handvatten om beter te worden in het geven en ontvangen van feedback, gericht op professionele groei en cultuurversterking in de school. Het helpt je effectiever te worden in je vak als leidinggevende, leraar, begeleider, onderwijsassistent of op welke andere plek in de school dan ook. We kiezen daarbij allerlei invalshoeken, soms met veel reflectie en diepgang, soms meer technisch-instrumenteel, en maken daarbij steeds de koppeling met het onderwijs. Feedback willen we hiermee transformeren naar iets wat niet bedreigend of eng is, maar juist hanteerbaar en verrijkend. Voor wie werkt in het onderwijs en daar wil genieten en groeien.  Dus: kom maar op met je feedback! Dit boek is bedoeld voor mensen die werken in het po, vo en mbo.', 'nl', 9789065080578, 'Kom maar op met je feedback');
INSERT INTO `book` (`id`, `archived`, `author`, `description`, `in_language`, `isbn`, `title`) VALUES
(43, 0, 'Jeffrey Palermo', ' Use this book as your one-stop shop for architecting a world-class DevOps environment with Microsoft technologies.   .NET DevOps for Azure is a synthesis of practices, tools, and process that, together, can equip a software organization to move fast and deliver the highest quality software. The book begins by discussing the most common challenges faced by developers in DevOps today and offers options and proven solutions on how to implement DevOps for your team.   Daily, millions of developers use .NET to build and operate mission-critical software systems for organizations around the world. While the marketplace has scores of information about the technology, it is completely up to you to put together all the blocks in the right way for your environment.   This book provides you with a model to build on. The relevant principles are covered first along with how to implement that part of the environment. And while variances in tools, language, or requirements will change the needed implementation, the DevOps model is the architecture for the working environment for your team. You can modify parts of the model to customize it to your enterprise, but the architecture will enable all of your teams and applications to accelerate in performance.   What You Will Learn   Get your .NET applications into a DevOps environment in Azure Analyze and address the part of your DevOps process that causes delays or bottlenecks Track code using Azure Repos and conduct acceptance tests Apply the rules for segmenting applications into Git repositories Understand the different types of builds and when to use each Know how to think about code validation in your DevOps environment Provision and configure environments; deploy release candidates across the environments in Azure Monitor and support software that has been deployed to a production environment   Who This Book Is For   .NET Developers who are using or want to use DevOps in Azure but donxe2x80x99t know where to begin ', 'en', 9781484253434, '.NET DevOps for Azure');

-- --------------------------------------------------------

--
-- Table structure for table `book_keywords`
--

CREATE TABLE `book_keywords` (
  `book_id` bigint(20) NOT NULL,
  `keyword_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `book_keywords`
--

INSERT INTO `book_keywords` (`book_id`, `keyword_id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(2, 6),
(2, 7),
(2, 8),
(2, 9),
(2, 10),
(3, 11),
(3, 12),
(3, 13),
(3, 14),
(3, 15),
(4, 16),
(4, 17),
(4, 18),
(4, 19),
(4, 20),
(5, 21),
(5, 22),
(5, 23),
(5, 24),
(5, 25),
(6, 22),
(6, 26),
(6, 27),
(6, 28),
(6, 29),
(7, 30),
(7, 31),
(7, 32),
(7, 33),
(7, 34),
(8, 30),
(8, 35),
(8, 36),
(8, 37),
(8, 38),
(9, 39),
(9, 40),
(9, 41),
(9, 42),
(9, 43),
(10, 44),
(10, 45),
(10, 46),
(10, 47),
(10, 41),
(11, 48),
(11, 49),
(11, 41),
(11, 50),
(11, 51),
(12, 52),
(12, 53),
(12, 54),
(12, 55),
(12, 56),
(13, 41),
(13, 57),
(13, 58),
(13, 59),
(13, 60),
(14, 61),
(14, 41),
(14, 62),
(14, 63),
(14, 64),
(15, 65),
(15, 66),
(15, 61),
(15, 67),
(15, 68),
(16, 69),
(16, 41),
(16, 70),
(16, 71),
(16, 62),
(17, 72),
(17, 73),
(17, 74),
(17, 75),
(17, 76),
(18, 77),
(18, 78),
(18, 79),
(18, 80),
(18, 81),
(19, 82),
(19, 83),
(19, 84),
(19, 85),
(19, 86),
(20, 87),
(20, 73),
(20, 88),
(20, 89),
(20, 90),
(21, 24),
(21, 91),
(21, 92),
(21, 93),
(21, 94),
(22, 95),
(22, 96),
(22, 97),
(22, 98),
(22, 99),
(23, 100),
(23, 48),
(23, 101),
(23, 102),
(23, 103),
(24, 30),
(24, 104),
(24, 105),
(24, 106),
(24, 107),
(25, 34),
(25, 16),
(25, 108),
(25, 109),
(25, 110),
(26, 111),
(26, 101),
(26, 112),
(26, 113),
(26, 114),
(27, 115),
(27, 116),
(27, 117),
(27, 79),
(27, 118),
(28, 119),
(28, 120),
(28, 121),
(28, 122),
(28, 123),
(29, 124),
(29, 125),
(29, 126),
(29, 127),
(29, 62),
(30, 128),
(30, 129),
(30, 130),
(30, 131),
(30, 132),
(31, 133),
(31, 134),
(31, 135),
(31, 136),
(31, 137),
(32, 138),
(32, 139),
(32, 41),
(32, 140),
(32, 141),
(33, 142),
(33, 143),
(33, 144),
(33, 41),
(33, 145),
(34, 146),
(34, 71),
(34, 147),
(34, 148),
(34, 149),
(35, 150),
(35, 52),
(35, 151),
(35, 152),
(35, 153),
(36, 154),
(36, 34),
(36, 104),
(36, 155),
(36, 156),
(37, 157),
(37, 158),
(37, 159),
(37, 160),
(37, 161),
(38, 162),
(38, 158),
(38, 163),
(38, 115),
(38, 164),
(39, 165),
(39, 166),
(39, 167),
(39, 60),
(39, 168),
(40, 158),
(40, 169),
(40, 170),
(40, 62),
(40, 58),
(41, 158),
(41, 171),
(41, 172),
(41, 173),
(41, 174),
(42, 175),
(42, 176),
(42, 177),
(42, 178),
(42, 179),
(43, 180),
(43, 181),
(43, 182),
(43, 158),
(43, 183);

-- --------------------------------------------------------

--
-- Table structure for table `copy`
--

CREATE TABLE `copy` (
  `id` bigint(20) NOT NULL,
  `archived` tinyint(1) DEFAULT 0,
  `available` bit(1) NOT NULL,
  `number` int(11) NOT NULL,
  `book_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `copy`
--

INSERT INTO `copy` (`id`, `archived`, `available`, `number`, `book_id`) VALUES
(1, 0, b'1', 1, 1),
(2, 0, b'1', 2, 1),
(3, 0, b'1', 1, 2),
(4, 0, b'1', 2, 2),
(5, 0, b'1', 3, 2),
(6, 0, b'1', 4, 2),
(7, 0, b'1', 5, 2),
(8, 0, b'1', 6, 2),
(9, 0, b'1', 7, 2),
(10, 0, b'1', 8, 2),
(11, 0, b'1', 9, 2),
(12, 0, b'1', 1, 3),
(13, 0, b'1', 2, 3),
(14, 0, b'1', 3, 3),
(15, 0, b'1', 4, 3),
(16, 0, b'1', 5, 3),
(17, 0, b'1', 6, 3),
(18, 0, b'1', 7, 3),
(19, 0, b'1', 8, 3),
(20, 0, b'1', 1, 4),
(21, 0, b'1', 1, 5),
(22, 0, b'1', 2, 5),
(23, 0, b'1', 3, 5),
(24, 0, b'1', 4, 5),
(25, 0, b'1', 1, 6),
(26, 0, b'1', 2, 6),
(27, 0, b'1', 3, 6),
(28, 0, b'1', 1, 7),
(29, 0, b'1', 1, 8),
(30, 0, b'1', 2, 8),
(31, 0, b'1', 3, 8),
(32, 0, b'1', 1, 9),
(33, 0, b'1', 2, 9),
(34, 0, b'1', 3, 9),
(35, 0, b'1', 4, 9),
(36, 0, b'1', 1, 10),
(37, 0, b'1', 2, 10),
(38, 0, b'1', 3, 10),
(39, 0, b'1', 4, 10),
(40, 0, b'1', 5, 10),
(41, 0, b'1', 6, 10),
(42, 0, b'1', 7, 10),
(43, 0, b'1', 8, 10),
(44, 0, b'1', 1, 11),
(45, 0, b'1', 2, 11),
(46, 0, b'1', 3, 11),
(47, 0, b'1', 4, 11),
(48, 0, b'1', 5, 11),
(49, 0, b'1', 6, 11),
(50, 0, b'1', 1, 12),
(51, 0, b'1', 1, 13),
(52, 0, b'0', 2, 13),
(53, 0, b'1', 1, 14),
(54, 0, b'1', 2, 14),
(55, 0, b'1', 3, 14),
(56, 0, b'1', 4, 14),
(57, 0, b'1', 5, 14),
(58, 0, b'1', 6, 14),
(59, 0, b'1', 7, 14),
(60, 0, b'1', 1, 15),
(61, 0, b'1', 2, 15),
(62, 0, b'1', 3, 15),
(63, 0, b'1', 4, 15),
(64, 0, b'1', 5, 15),
(65, 0, b'1', 6, 15),
(66, 0, b'1', 7, 15),
(67, 0, b'1', 8, 15),
(68, 0, b'1', 1, 16),
(69, 0, b'1', 2, 16),
(70, 0, b'1', 1, 17),
(71, 0, b'1', 2, 17),
(72, 0, b'1', 3, 17),
(73, 0, b'1', 4, 17),
(74, 0, b'1', 5, 17),
(75, 0, b'1', 6, 17),
(76, 0, b'1', 7, 17),
(77, 0, b'1', 8, 17),
(78, 0, b'1', 9, 17),
(79, 0, b'1', 10, 17),
(80, 0, b'1', 1, 18),
(81, 0, b'1', 2, 18),
(82, 0, b'1', 3, 18),
(83, 0, b'1', 4, 18),
(84, 0, b'1', 5, 18),
(85, 0, b'1', 6, 18),
(86, 0, b'1', 7, 18),
(87, 0, b'1', 8, 18),
(88, 0, b'1', 9, 18),
(89, 0, b'1', 1, 19),
(90, 0, b'1', 2, 19),
(91, 0, b'1', 3, 19),
(92, 0, b'1', 4, 19),
(93, 0, b'1', 5, 19),
(94, 0, b'1', 1, 20),
(95, 0, b'1', 2, 20),
(96, 0, b'1', 3, 20),
(97, 0, b'1', 4, 20),
(98, 0, b'1', 5, 20),
(99, 0, b'1', 6, 20),
(100, 0, b'1', 7, 20),
(101, 0, b'1', 8, 20),
(102, 0, b'1', 9, 20),
(103, 0, b'1', 10, 20),
(104, 0, b'1', 1, 21),
(105, 0, b'1', 2, 21),
(106, 0, b'1', 3, 21),
(107, 0, b'1', 1, 22),
(108, 0, b'1', 2, 22),
(109, 0, b'1', 3, 22),
(110, 0, b'1', 4, 22),
(111, 0, b'1', 5, 22),
(112, 0, b'1', 6, 22),
(113, 0, b'1', 1, 23),
(114, 0, b'1', 2, 23),
(115, 0, b'1', 3, 23),
(116, 0, b'1', 4, 23),
(117, 0, b'1', 5, 23),
(118, 0, b'1', 1, 24),
(119, 0, b'1', 2, 24),
(120, 0, b'1', 3, 24),
(121, 0, b'1', 4, 24),
(122, 0, b'1', 5, 24),
(123, 0, b'1', 6, 24),
(124, 0, b'1', 7, 24),
(125, 0, b'1', 8, 24),
(126, 0, b'1', 9, 24),
(127, 0, b'1', 1, 25),
(128, 0, b'1', 2, 25),
(129, 0, b'1', 3, 25),
(130, 0, b'1', 4, 25),
(131, 0, b'1', 5, 25),
(132, 0, b'1', 6, 25),
(133, 0, b'1', 1, 26),
(134, 0, b'1', 2, 26),
(135, 0, b'1', 3, 26),
(136, 0, b'1', 4, 26),
(137, 0, b'1', 5, 26),
(138, 0, b'1', 6, 26),
(139, 0, b'1', 7, 26),
(140, 0, b'1', 8, 26),
(141, 0, b'1', 1, 27),
(142, 0, b'1', 2, 27),
(143, 0, b'1', 3, 27),
(144, 0, b'1', 4, 27),
(145, 0, b'1', 5, 27),
(146, 0, b'1', 6, 27),
(147, 0, b'1', 7, 27),
(148, 0, b'1', 8, 27),
(149, 0, b'1', 1, 28),
(150, 0, b'1', 2, 28),
(151, 0, b'1', 3, 28),
(152, 0, b'1', 4, 28),
(153, 0, b'1', 5, 28),
(154, 0, b'1', 6, 28),
(155, 0, b'1', 7, 28),
(156, 0, b'1', 1, 29),
(157, 0, b'1', 2, 29),
(158, 0, b'1', 3, 29),
(159, 0, b'1', 4, 29),
(160, 0, b'1', 5, 29),
(161, 0, b'1', 6, 29),
(162, 0, b'1', 7, 29),
(163, 0, b'1', 8, 29),
(164, 0, b'1', 9, 29),
(165, 0, b'1', 10, 29),
(166, 0, b'1', 1, 30),
(167, 0, b'1', 2, 30),
(168, 0, b'1', 3, 30),
(169, 0, b'1', 4, 30),
(170, 0, b'1', 5, 30),
(171, 0, b'1', 6, 30),
(172, 0, b'1', 1, 31),
(173, 0, b'1', 2, 31),
(174, 0, b'1', 3, 31),
(175, 0, b'1', 1, 32),
(176, 0, b'1', 1, 33),
(177, 0, b'1', 2, 33),
(178, 0, b'1', 3, 33),
(179, 0, b'1', 4, 33),
(180, 0, b'1', 1, 34),
(181, 0, b'0', 2, 34),
(182, 0, b'1', 3, 34),
(183, 0, b'0', 4, 34),
(184, 0, b'0', 5, 34),
(185, 0, b'1', 1, 35),
(186, 0, b'1', 2, 35),
(187, 0, b'1', 3, 35),
(188, 0, b'1', 4, 35),
(189, 0, b'1', 5, 35),
(190, 0, b'1', 6, 35),
(191, 0, b'1', 7, 35),
(192, 0, b'1', 8, 35),
(193, 0, b'1', 1, 36),
(194, 0, b'1', 2, 36),
(195, 0, b'1', 3, 36),
(196, 0, b'1', 4, 36),
(197, 0, b'1', 5, 36),
(198, 0, b'1', 6, 36),
(199, 0, b'1', 7, 36),
(200, 0, b'1', 8, 36),
(201, 0, b'1', 9, 36),
(202, 0, b'1', 10, 36),
(203, 0, b'1', 1, 37),
(204, 0, b'1', 2, 37),
(205, 0, b'1', 3, 37),
(206, 0, b'1', 4, 37),
(207, 0, b'1', 1, 38),
(208, 0, b'1', 2, 38),
(209, 0, b'1', 3, 38),
(210, 0, b'1', 4, 38),
(211, 0, b'1', 5, 38),
(212, 0, b'1', 6, 38),
(213, 0, b'1', 1, 39),
(214, 0, b'1', 2, 39),
(215, 0, b'1', 3, 39),
(216, 0, b'1', 4, 39),
(217, 0, b'1', 5, 39),
(218, 0, b'1', 1, 40),
(219, 0, b'1', 2, 40),
(220, 0, b'1', 1, 41),
(221, 0, b'1', 2, 41),
(222, 0, b'1', 3, 41),
(223, 0, b'1', 4, 41),
(224, 0, b'1', 1, 42),
(225, 0, b'1', 2, 42),
(226, 0, b'0', 3, 42),
(227, 0, b'1', 4, 42),
(228, 0, b'0', 5, 42),
(229, 0, b'1', 1, 43),
(230, 0, b'1', 2, 43),
(231, 0, b'1', 3, 43),
(232, 0, b'1', 4, 43),
(233, 0, b'1', 5, 43),
(234, 0, b'1', 6, 43),
(235, 0, b'1', 7, 43);

-- --------------------------------------------------------

--
-- Table structure for table `keyword`
--

CREATE TABLE `keyword` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `keyword`
--

INSERT INTO `keyword` (`id`, `name`) VALUES
(1, 'knowhow'),
(2, 'dig'),
(3, 'comfortable'),
(4, 'messy'),
(5, 'toolkits'),
(6, 'adviezen'),
(7, 'teams'),
(8, 'praktisch'),
(9, 'effectieve'),
(10, 'projectmanagementmethode'),
(11, 'tells'),
(12, 'revolutionary'),
(13, 'operates'),
(14, 'helps'),
(15, 'transform'),
(16, 'onmisbaar'),
(17, 'vul'),
(18, 'softwareontwikkelmethode'),
(19, 'trucs'),
(20, 'opmars'),
(21, 'diversiteit'),
(22, 'uitgelegd'),
(23, 'extreme'),
(24, 'gangbare'),
(25, 'eenvoudig'),
(26, 'solingen'),
(27, 'verandert'),
(28, 'omgevingen'),
(29, 'aantrekkelijk'),
(30, 'spel'),
(31, 'course'),
(32, 'aangeleerd'),
(33, 'visualisaties'),
(34, 'leert'),
(35, 'tekstvariabelen'),
(36, 'uitdagend'),
(37, 'veelgebruikte'),
(38, 'kilometers'),
(39, 'firstclass'),
(40, 'ramalho'),
(41, 'python'),
(42, 'metaclasses'),
(43, 'hooks'),
(44, 'itand'),
(45, 'copying'),
(46, 'debug'),
(47, 'looping'),
(48, 'linux'),
(49, 'downloadable'),
(50, 'everybody'),
(51, 'needing'),
(52, 'regels'),
(53, 'heldere'),
(54, 'ontdek'),
(55, 'geheimen'),
(56, 'betrouwbare'),
(57, 'objectoriented'),
(58, 'handson'),
(59, 'supporting'),
(60, 'updated'),
(61, 'jupyter'),
(62, 'introduces'),
(63, 'crash'),
(64, 'simulating'),
(65, 'groupby'),
(66, 'crunching'),
(67, 'notebook'),
(68, 'summarize'),
(69, 'naturallanguage'),
(70, 'keras'),
(71, 'bestseller'),
(72, 'mastery'),
(73, 'arrays'),
(74, 'threads'),
(75, 'servers'),
(76, 'goto'),
(77, 'exam'),
(78, 'sybex'),
(79, 'oracle'),
(80, 'lastminute'),
(81, 'localizing'),
(82, 'compiler'),
(83, 'lambdas'),
(84, 'maintainability'),
(85, 'enums'),
(86, 'serialization'),
(87, 'needtoread'),
(88, 'fancy'),
(89, 'easytounderstand'),
(90, 'bushwhack'),
(91, 'mediatypen'),
(92, 'webstandaarden'),
(93, 'opmaken'),
(94, 'behandelde'),
(95, 'jqueryuses'),
(96, 'crossbrowser'),
(97, 'plugins'),
(98, 'jquery'),
(99, 'softcover'),
(100, 'templating'),
(101, 'server'),
(102, 'superb'),
(103, 'css'),
(104, 'praktische'),
(105, 'coauteur'),
(106, 'site'),
(107, 'omge'),
(108, 'beginner'),
(109, 'stapvoorstapinstructies'),
(110, 'jouw'),
(111, 'pdo'),
(112, 'desktop'),
(113, 'canvas'),
(114, 'ajax'),
(115, 'highperformance'),
(116, 'alike'),
(117, 'programmingthoroughly'),
(118, 'herb'),
(119, 'frameworksscikitlearn'),
(120, 'youll'),
(121, 'aurelien'),
(122, 'youve'),
(123, 'endtoend'),
(124, 'cochair'),
(125, 'spacex'),
(126, 'gathers'),
(127, 'supplementary'),
(128, 'informationtheoretical'),
(129, 'stateoftheart'),
(130, 'selfcontained'),
(131, 'equipping'),
(132, 'slides'),
(133, 'personalized'),
(134, 'revising'),
(135, 'underpin'),
(136, 'adapting'),
(137, 'clicks'),
(138, 'logistic'),
(139, 'cloudbased'),
(140, 'sequel'),
(141, 'endofchapter'),
(142, 'physicsinformed'),
(143, 'revolutionizing'),
(144, 'matlab'),
(145, 'datadriven'),
(146, 'hundredpage'),
(147, 'starters'),
(148, 'endorsed'),
(149, 'academics'),
(150, 'vaardigheden'),
(151, 'bekeken'),
(152, 'lesmateriaal'),
(153, 'handvatten'),
(154, 'emoties'),
(155, 'liever'),
(156, 'gepaard'),
(157, 'mindset'),
(158, 'devops'),
(159, 'devopsfriendly'),
(160, 'iterative'),
(161, 'incident'),
(162, 'twentyfive'),
(163, 'tmap'),
(164, 'supports'),
(165, 'awardwinning'),
(166, 'bestselling'),
(167, 'latest'),
(168, 'transformation'),
(169, 'containerization'),
(170, 'developers'),
(171, 'confidently'),
(172, 'downtime'),
(173, 'azure'),
(174, 'kubernetes'),
(175, 'effectiever'),
(176, 'reflectie'),
(177, 'transformeren'),
(178, 'bedreigend'),
(179, 'genieten'),
(180, 'variances'),
(181, 'missioncritical'),
(182, 'customize'),
(183, 'repos');

-- --------------------------------------------------------

--
-- Table structure for table `loan`
--

CREATE TABLE `loan` (
  `id` bigint(20) NOT NULL,
  `end_date` date DEFAULT NULL,
  `start_date` date NOT NULL,
  `copy_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `loan`
--

INSERT INTO `loan` (`id`, `end_date`, `start_date`, `copy_id`, `user_id`) VALUES
(1, '2023-03-27', '2023-03-27', 51, 1),
(2, '2023-03-27', '2023-03-27', 150, 1),
(3, '2023-03-27', '2023-03-27', 73, 1),
(4, NULL, '2023-03-27', 52, 1),
(5, '2023-03-27', '2023-03-27', 182, 1),
(6, '2023-03-27', '2023-03-27', 73, 1),
(7, '2023-03-27', '2023-03-27', 20, 40),
(8, NULL, '2023-03-27', 228, 18),
(9, NULL, '2023-03-27', 184, 17),
(10, '2023-03-27', '2023-03-27', 227, 86),
(11, NULL, '2023-03-27', 226, 86),
(12, NULL, '2023-03-27', 181, 1),
(13, NULL, '2023-03-27', 183, 1);

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE `reservation` (
  `id` bigint(20) NOT NULL,
  `date` date NOT NULL,
  `book_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reservation`
--

INSERT INTO `reservation` (`id`, `date`, `book_id`, `user_id`) VALUES
(1, '2021-02-05', 2, 65),
(2, '2022-01-04', 15, 52),
(3, '2021-11-13', 8, 80),
(4, '2022-06-03', 2, 56),
(5, '2021-04-12', 2, 92),
(6, '2021-08-10', 28, 41),
(7, '2022-12-15', 39, 48),
(8, '2022-12-15', 42, 62),
(10, '2021-03-14', 32, 83),
(11, '2022-05-26', 31, 59),
(12, '2021-04-29', 26, 27),
(13, '2020-12-10', 6, 82),
(14, '2023-01-29', 42, 94),
(15, '2021-11-04', 25, 14),
(16, '2022-01-19', 7, 69),
(17, '2021-10-03', 26, 99),
(18, '2021-06-19', 11, 42),
(19, '2021-08-05', 12, 78),
(20, '2021-07-26', 22, 49),
(21, '2021-12-05', 35, 26),
(22, '2021-06-21', 32, 49),
(23, '2023-02-14', 17, 22),
(24, '2022-02-07', 27, 71),
(25, '2021-12-06', 24, 69),
(26, '2022-08-07', 38, 13),
(27, '2022-10-14', 32, 84),
(28, '2022-02-26', 33, 86),
(29, '2022-04-23', 43, 38),
(30, '2021-06-06', 39, 60),
(31, '2022-12-10', 20, 18),
(32, '2022-06-28', 24, 53),
(33, '2022-01-07', 24, 77),
(34, '2021-02-21', 12, 7),
(35, '2021-01-08', 8, 22),
(36, '2020-11-14', 24, 62),
(37, '2021-10-30', 10, 68),
(38, '2023-01-12', 22, 75),
(39, '2021-07-30', 35, 80),
(40, '2021-12-19', 40, 73),
(41, '2022-08-02', 32, 36),
(42, '2020-12-04', 42, 59),
(43, '2022-06-15', 26, 7),
(44, '2022-08-15', 29, 40),
(45, '2022-05-04', 41, 65),
(46, '2020-11-07', 35, 37),
(47, '2020-10-13', 18, 99),
(48, '2022-12-18', 38, 33),
(49, '2022-12-14', 26, 100),
(51, '2023-03-27', 5, 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `admin` bit(1) NOT NULL,
  `archived` bit(1) DEFAULT NULL,
  `email_address` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(128) NOT NULL,
  `token` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `admin`, `archived`, `email_address`, `first_name`, `last_name`, `password`, `token`) VALUES
(1, b'1', b'0', 'admin@admin.com', 'admin', 'admin', '1234', 'hxd8h7Cp3OXlnewW88oFHBjBMTwPFcGa38bvbGqB1wueUvZfdxXRaFpFDNnY'),
(2, b'0', b'0', 'John_Fleming@kpn.nl', 'John', 'Fleming', '1234', NULL),
(3, b'0', b'0', 'Robert_Hernandez@gmail.com', 'Robert', 'Hernandez', '1234', NULL),
(4, b'0', b'0', 'Edmundo_Davis@gmail.com', 'Edmundo', 'Davis', '1234', NULL),
(5, b'1', b'0', 'Jacinto_Sears@kpn.nl', 'Jacinto', 'Sears', '1234', NULL),
(6, b'0', b'0', 'Patrick_Pace@kpn.nl', 'Patrick', 'Pace', '1234', NULL),
(7, b'0', b'0', 'Tami_Brown@hotmail.com', 'Tami', 'Brown', '1234', NULL),
(8, b'0', b'0', 'Inell_Vaughan@outlook.com', 'Inell', 'Vaughan', '1234', NULL),
(9, b'0', b'0', 'Ruth_Blackwell@hotmail.com', 'Ruth', 'Blackwell', '1234', NULL),
(10, b'0', b'0', 'Whitney_Polkinghorn@hotmail.com', 'Whitney', 'Polkinghorn', '1234', NULL),
(11, b'0', b'0', 'Angela_Depriest@kpn.nl', 'Angela', 'Depriest', '1234', NULL),
(12, b'1', b'0', 'James_Pence@kpn.nl', 'James', 'Pence', '1234', NULL),
(13, b'0', b'0', 'Arthur_Britt@outlook.com', 'Arthur', 'Britt', '1234', NULL),
(14, b'0', b'0', 'Pat_Sedrakyan@outlook.com', 'Pat', 'Sedrakyan', '1234', NULL),
(15, b'0', b'0', 'Charles_Ray@kpn.nl', 'Charles', 'Ray', '1234', NULL),
(16, b'0', b'0', 'Richard_Lee@outlook.com', 'Richard', 'Lee', '1234', NULL),
(17, b'0', b'0', 'Adelaide_Albert@gmail.com', 'Adelaide', 'Albert', '1234', NULL),
(18, b'1', b'0', 'Norma_Alexander@outlook.com', 'Norma', 'Alexander', '1234', NULL),
(19, b'0', b'0', 'Kathryn_Blanchette@outlook.com', 'Kathryn', 'Blanchette', '1234', NULL),
(20, b'0', b'0', 'Luke_Nunez@outlook.com', 'Luke', 'Nunez', '1234', NULL),
(21, b'0', b'0', 'Susan_Watkins@gmail.com', 'Susan', 'Watkins', '1234', NULL),
(22, b'0', b'0', 'Corey_Juarez@hotmail.com', 'Corey', 'Juarez', '1234', NULL),
(23, b'0', b'0', 'Stephanie_Gaitan@hotmail.com', 'Stephanie', 'Gaitan', '1234', NULL),
(24, b'0', b'0', 'Marvin_Brown@kpn.nl', 'Marvin', 'Brown', '1234', NULL),
(25, b'0', b'0', 'William_Poole@gmail.com', 'William', 'Poole', '1234', NULL),
(26, b'0', b'0', 'Michael_Williams@gmail.com', 'Michael', 'Williams', '1234', NULL),
(27, b'0', b'0', 'Carl_Bridgham@kpn.nl', 'Carl', 'Bridgham', '1234', NULL),
(28, b'0', b'0', 'Lawrence_Patterson@hotmail.com', 'Lawrence', 'Patterson', '1234', NULL),
(29, b'0', b'0', 'Elma_Robbins@gmail.com', 'Elma', 'Robbins', '1234', NULL),
(30, b'0', b'0', 'Diane_Spencer@outlook.com', 'Diane', 'Spencer', '1234', NULL),
(31, b'0', b'0', 'Ronald_Vargas@gmail.com', 'Ronald', 'Vargas', '1234', NULL),
(32, b'0', b'0', 'Marc_Duran@hotmail.com', 'Marc', 'Duran', '1234', NULL),
(33, b'0', b'0', 'Gary_Matlock@kpn.nl', 'Gary', 'Matlock', '1234', NULL),
(34, b'0', b'0', 'Sharon_Whitley@gmail.com', 'Sharon', 'Whitley', '1234', NULL),
(35, b'0', b'0', 'Katie_Bathe@hotmail.com', 'Katie', 'Bathe', '1234', NULL),
(36, b'1', b'0', 'Alfredo_Waithe@outlook.com', 'Alfredo', 'Waithe', '1234', NULL),
(37, b'0', b'0', 'Oliver_Barnhart@gmail.com', 'Oliver', 'Barnhart', '1234', NULL),
(38, b'1', b'0', 'Olga_Sanderlin@gmail.com', 'Olga', 'Sanderlin', '1234', NULL),
(39, b'0', b'0', 'Sherry_Fellows@gmail.com', 'Sherry', 'Fellows', '1234', NULL),
(40, b'0', b'0', 'Julio_Hake@gmail.com', 'Julio', 'Hake', '1234', NULL),
(41, b'0', b'0', 'Albert_Rich@hotmail.com', 'Albert', 'Rich', '1234', NULL),
(42, b'0', b'0', 'Christi_Runyan@kpn.nl', 'Christi', 'Runyan', '1234', NULL),
(43, b'1', b'0', 'Roger_Rogers@hotmail.com', 'Roger', 'Rogers', '1234', NULL),
(44, b'1', b'0', 'Anastasia_Austin@outlook.com', 'Anastasia', 'Austin', '1234', NULL),
(45, b'0', b'0', 'Nellie_Phillips@gmail.com', 'Nellie', 'Phillips', '1234', NULL),
(46, b'0', b'0', 'Edward_Frias@outlook.com', 'Edward', 'Frias', '1234', NULL),
(47, b'0', b'0', 'Anna_Holman@kpn.nl', 'Anna', 'Holman', '1234', NULL),
(48, b'1', b'0', 'Cheryl_Gould@outlook.com', 'Cheryl', 'Gould', '1234', NULL),
(49, b'0', b'0', 'Dorothy_Mccann@kpn.nl', 'Dorothy', 'Mccann', '1234', NULL),
(50, b'0', b'0', 'Gertrude_Flores@hotmail.com', 'Gertrude', 'Flores', '1234', NULL),
(51, b'0', b'0', 'Harry_James@hotmail.com', 'Harry', 'James', '1234', NULL),
(52, b'0', b'0', 'Melanie_Ashcraft@hotmail.com', 'Melanie', 'Ashcraft', '1234', NULL),
(53, b'0', b'0', 'Carolyn_Williams@hotmail.com', 'Carolyn', 'Williams', '1234', NULL),
(54, b'0', b'0', 'Dale_Bell@gmail.com', 'Dale', 'Bell', '1234', NULL),
(55, b'0', b'0', 'Elizabeth_Ryder@gmail.com', 'Elizabeth', 'Ryder', '1234', NULL),
(56, b'0', b'0', 'Myrtle_Barker@outlook.com', 'Myrtle', 'Barker', '1234', NULL),
(57, b'0', b'0', 'Mark_Hickman@kpn.nl', 'Mark', 'Hickman', '1234', NULL),
(58, b'0', b'0', 'Evelyne_Boyd@kpn.nl', 'Evelyne', 'Boyd', '1234', NULL),
(59, b'0', b'0', 'Vera_Mcafee@outlook.com', 'Vera', 'Mcafee', '1234', NULL),
(60, b'0', b'0', 'Joseph_Dettman@kpn.nl', 'Joseph', 'Dettman', '1234', NULL),
(61, b'0', b'0', 'Janette_Huff@gmail.com', 'Janette', 'Huff', '1234', NULL),
(62, b'1', b'0', 'Charles_Gracia@hotmail.com', 'Charles', 'Gracia', '1234', NULL),
(63, b'1', b'0', 'Richard_Flores@outlook.com', 'Richard', 'Flores', '1234', NULL),
(64, b'1', b'0', 'Charles_Young@hotmail.com', 'Charles', 'Young', '1234', NULL),
(65, b'0', b'0', 'Dorothy_Smithheart@kpn.nl', 'Dorothy', 'Smithheart', '1234', NULL),
(66, b'0', b'0', 'Karina_Stahl@kpn.nl', 'Karina', 'Stahl', '1234', NULL),
(67, b'0', b'0', 'Willie_Clark@hotmail.com', 'Willie', 'Clark', '1234', NULL),
(68, b'0', b'0', 'Lynn_Demski@kpn.nl', 'Lynn', 'Demski', '1234', NULL),
(69, b'0', b'0', 'Elaine_Scurry@outlook.com', 'Elaine', 'Scurry', '1234', NULL),
(70, b'0', b'0', 'Gary_Stephens@kpn.nl', 'Gary', 'Stephens', '1234', NULL),
(71, b'0', b'0', 'Nicholas_Spencer@gmail.com', 'Nicholas', 'Spencer', '1234', NULL),
(72, b'0', b'0', 'Toney_Jones@kpn.nl', 'Toney', 'Jones', '1234', NULL),
(73, b'0', b'0', 'David_Nixon@hotmail.com', 'David', 'Nixon', '1234', NULL),
(74, b'0', b'0', 'Charles_Bergstrom@gmail.com', 'Charles', 'Bergstrom', '1234', NULL),
(75, b'0', b'0', 'Vivian_Coatney@kpn.nl', 'Vivian', 'Coatney', '1234', NULL),
(76, b'0', b'0', 'Nelson_Davis@hotmail.com', 'Nelson', 'Davis', '1234', NULL),
(77, b'0', b'0', 'Edith_Park@hotmail.com', 'Edith', 'Park', '1234', NULL),
(78, b'0', b'0', 'Daniel_Landeros@outlook.com', 'Daniel', 'Landeros', '1234', NULL),
(79, b'0', b'0', 'Cory_Maskell@outlook.com', 'Cory', 'Maskell', '1234', NULL),
(80, b'0', b'0', 'Mary_Hoyt@outlook.com', 'Mary', 'Hoyt', '1234', NULL),
(81, b'0', b'0', 'Teresa_Weldon@hotmail.com', 'Teresa', 'Weldon', '1234', NULL),
(82, b'0', b'0', 'Marian_Ruppe@gmail.com', 'Marian', 'Ruppe', '1234', NULL),
(83, b'0', b'0', 'Sharon_Spier@outlook.com', 'Sharon', 'Spier', '1234', NULL),
(84, b'0', b'0', 'Bethany_Crow@hotmail.com', 'Bethany', 'Crow', '1234', NULL),
(85, b'0', b'0', 'Lynda_Wakley@outlook.com', 'Lynda', 'Wakley', '1234', NULL),
(86, b'0', b'0', 'George_Aldridge@gmail.com', 'George', 'Aldridge', '1234', NULL),
(87, b'0', b'0', 'Jennifer_Daigle@gmail.com', 'Jennifer', 'Daigle', '1234', NULL),
(88, b'1', b'0', 'Esther_Hodges@hotmail.com', 'Esther', 'Hodges', '1234', NULL),
(89, b'0', b'0', 'Mervin_Shafer@outlook.com', 'Mervin', 'Shafer', '1234', NULL),
(90, b'0', b'0', 'Richard_Bowman@hotmail.com', 'Richard', 'Bowman', '1234', NULL),
(91, b'0', b'0', 'Shirley_Miles@hotmail.com', 'Shirley', 'Miles', '1234', NULL),
(92, b'0', b'0', 'Mary_Hatfield@outlook.com', 'Mary', 'Hatfield', '1234', NULL),
(93, b'0', b'0', 'Jim_Eubanks@hotmail.com', 'Jim', 'Eubanks', '1234', NULL),
(94, b'0', b'0', 'Milo_Cook@outlook.com', 'Milo', 'Cook', '1234', NULL),
(95, b'1', b'0', 'Ruth_Hilyer@kpn.nl', 'Ruth', 'Hilyer', '1234', NULL),
(96, b'0', b'0', 'Frank_Griffin@kpn.nl', 'Frank', 'Griffin', '1234', NULL),
(97, b'0', b'0', 'Elizabeth_Lovett@gmail.com', 'Elizabeth', 'Lovett', '1234', NULL),
(98, b'0', b'0', 'Benjamin_Starr@gmail.com', 'Benjamin', 'Starr', '1234', NULL),
(99, b'0', b'0', 'Dennis_Straw@gmail.com', 'Dennis', 'Straw', '1234', NULL),
(100, b'0', b'0', 'Thomas_Telesco@gmail.com', 'Thomas', 'Telesco', '1234', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `book_keywords`
--
ALTER TABLE `book_keywords`
  ADD KEY `FKs85552w5nwl6s1lobfh5ofj6j` (`keyword_id`),
  ADD KEY `FKobxm8gdxf4vhmsynxkmrp8sif` (`book_id`);

--
-- Indexes for table `copy`
--
ALTER TABLE `copy`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKof5k7k6c41i06j6fj3slgsmam` (`book_id`);

--
-- Indexes for table `keyword`
--
ALTER TABLE `keyword`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `loan`
--
ALTER TABLE `loan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKw8dbi4aoljiy817dnmnpaikd` (`copy_id`),
  ADD KEY `FKxxm1yc1xty3qn1pthgj8ac4f` (`user_id`);

--
-- Indexes for table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK6hhmrbhb80oj21rh0itinebpb` (`user_id`,`book_id`),
  ADD KEY `FKirxtcw4s6lhwi6l9ocrk6bjfy` (`book_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_d0ar1h7wcp7ldy6qg5859sol6` (`email_address`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT for table `copy`
--
ALTER TABLE `copy`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=236;

--
-- AUTO_INCREMENT for table `keyword`
--
ALTER TABLE `keyword`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=184;

--
-- AUTO_INCREMENT for table `loan`
--
ALTER TABLE `loan`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `book_keywords`
--
ALTER TABLE `book_keywords`
  ADD CONSTRAINT `FKobxm8gdxf4vhmsynxkmrp8sif` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  ADD CONSTRAINT `FKs85552w5nwl6s1lobfh5ofj6j` FOREIGN KEY (`keyword_id`) REFERENCES `keyword` (`id`);

--
-- Constraints for table `copy`
--
ALTER TABLE `copy`
  ADD CONSTRAINT `FKof5k7k6c41i06j6fj3slgsmam` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`);

--
-- Constraints for table `loan`
--
ALTER TABLE `loan`
  ADD CONSTRAINT `FKw8dbi4aoljiy817dnmnpaikd` FOREIGN KEY (`copy_id`) REFERENCES `copy` (`id`),
  ADD CONSTRAINT `FKxxm1yc1xty3qn1pthgj8ac4f` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `FKirxtcw4s6lhwi6l9ocrk6bjfy` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  ADD CONSTRAINT `FKm4oimk0l1757o9pwavorj6ljg` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
