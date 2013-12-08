# Квалификационный интерфейс
## Лаборатория Продвинутого дистанционного обучения (ADL)

>"Инициировано ADL, Министерство обороны США, 2013. Все права сохранены.

>Лицензировано лицензией Apache 2.0 (далее «Лицензия»). Вы не можете использовать этот документ без
>согласования с Лицензией. Вы можете получить копию Лицензии тут:
>http://www.apache.org/licenses/LICENSE-2.0

>При отсутствии законодательных требований или письменных соглашений, программное обеспечение по лицензии
>распространяется «КАК ЕСТЬ», БЕЗ КАКИХ-ЛИБО ГАРАНТИЙ ИЛИ УСЛОВИЙ, явных или подразумеваемых.
>Основные разрешения и ограничения смотрите в Лицензии."

>Данный документ написан участниками команды  разработчиков Квалификационного интерфейса (см.
>список на стр. 7-8) при поддержке Заместитель помощника секретаря обороны ADL.
>Пожалуйста, отправляйте отзывы и вопросы на адрес helpdesk@adlnet.gov

>Перевод написан студентами СПб НИУ ИТМО. de@mail.ifmo.ru  

## Содержание
*	1.0.	[Обзор истории](#revhistory)  
*	2.0.	[Роль Квалификационного интерфейса](#roleofxapi)
	*	2.1.	[Роль ADL при разработке Квалификационного интерфейса](#adlrole)  
 	*	2.2.	[Авторы](#contributors)
 		*	2.2.1.	[Команда участников](#wg)  
		*	2.2.2.	[Участники сбора требований](#reqparticipants) 
	*	2.2.3	[Указания к прочтению для нетехнического уклона](#readingguidelines)
*	3.0.	[Определения](#definitions)  
*	4.0.	[Statement](#statement)  
    *	4.1.	[Statement Properties](#stmtprops)  
        *	4.1.1.	[ID](#stmtid)  
        *	4.1.2.	[Actor](#actor)  
        *	4.1.3.	[Verb](#verb)  
        *	4.1.4.	[Object](#object)  
        *	4.1.5.	[Result](#result)  
        *	4.1.6.	[Context](#context)  
        *	4.1.7.	[Timestamp](#timestamp)  
        *	4.1.8.	[Stored](#stored)  
        *	4.1.9.	[Authority](#authority)  
        *	4.1.10.	[Version](#version)  
        *	4.1.11.	[Attachments](#attachments)  
        *	4.1.12.	[Data Constraints](#dataconstraints)  
    *	4.2.	[Retrieval of Statements](#retstmts)  
	*	4.3.	[Voided](#voided)  
	*	4.4.	[Signed Statements](#signature)  
*	5.0.	[Miscellaneous Types](#misctypes)  
    *	5.1.	[Document](#miscdocument)  
    *	5.2.	[Language Map](#misclangmap)  
    *	5.3.	[Extensions](#miscext)  
    *	5.4.	[Identifier Metadata](#miscmeta)  
*	6.0.	[Run-time Communication](#rtcom)  
    *	6.1.	[Encoding](#encoding)  
    *	6.2.	[API Versioning](#apiversioning)  
    *	6.3.	[Concurrency](#concurrency)  
    *	6.4.	[Security](#security)  
		*	6.4.1.	[Process for Each Scenario](#authdefs)  
		*	6.4.2.	[OAuth Authorization Scope](#oauthscope)  
*	7.0.	[Data Transfer (REST)](#datatransfer)  
    *	7.1.	[Error Codes](#errorcodes)  
    *	7.2.	[Statement API](#stmtapi)
    	*	7.2.1 [PUT Statements](#stmtapiput)
    	*	7.2.2 [POST Statements](#stmtapipost)
    	*	7.2.3 [GET Statements](#stmtapiget)
    	*	7.2.4 [Voided Statements](#voidedStatements)	  
    *	7.3.	[Document APIs](#docapis)  
    *	7.4.	[State API](#stateapi)  
    *	7.5.	[Activity Profile API](#actprofapi)  
    *	7.6.	[Agent Profile API](#agentprofapi)  
    *	7.7.	[About resource](#aboutresource)  
    *	7.8.	[Cross Origin Requests](#cors)  
    *	7.9.	[Validation](#validation)  
    *	7.10.	[HTTP HEAD](#httphead)  
*	[Appendix A: Bookmarklet](#AppendixA)  
*	[Appendix B: Creating an "IE Mode" Request](#AppendixB)  
*	[Appendix C: Example Statements](#AppendixC)  
*	[Appendix D: Example statement objects of different types](#AppendixD)  
*	[Appendix E: Example definitions for Activities of type "cmi.interaction"](#AppendixE)  
*	[Appendix F: Converting Statements to 1.0.0](#AppendixF)   
*	[Appendix G: Example Signed Statement](#AppendixG)
*	[Appendix H: Table of All Endpoints](#AppendixH)

<a name="revhistory"/>  

## 1.0 Обзор истории
###### 0.8 (Первый выход проекта Tin Can API) - 0.9 (31 марта 2012)  
  
Компания Rustici Software, разработавшая проект Tin Can API, вносисла изменения в 
API до ознакомительной встречи в апреле 2012 года. На этой встрече было решено 
использовать изменения в текущей спецификации, версии 0.9.

###### 0.90 - 0.95 (31 августа 2012)  

«Ядровые» Действия (Verb) и типы Задач (Activity) удалены из спецификации. Ссылки 
на эти команды так же удалены. При реализации API рекомендуется использовать команды, 
определённые сообществом, а не создавать свои собственные.
- Действия, типы Задач и ключи расширений теперь в виде URI.
- Переписано и уточнено (???) о некоторых других деталях и объёме реализации.
- Переход от человек-ориентированного представления Cубъекта (Agent) к образ-ориентированному.
- Требование объединения Друга Друга (Friend of a Friend, FOAF) Субъекта удалено.
- Субъект должен иметь ровно одно уникальное идентифицирующее свойство, а не хотя бы одно.

###### 0.95 - 1.0.0 (26 апреля 2013) 
Различные усовершенствования и оптимизация, в том числе:
- Вложения
- Данные о Задачах сохраняются в JSON, а не в XML
- Изменения в Утверждениях аннулирования (voiding Statements)
- Оптимизация и именование API Документа (Document)
- Изменения в вызывании API Утверждений
- Подписанные Утверждения

###### 1.0.0 - 1.0.1 (1 октября 2013)
Оптиизация и примеры, в том числе:
- Исправление опечаток
- Дополнительные примеры в приложениях

<a name="roleofxapi"/>

## 2.0 Роль Квалификационного интерфейса  
Квалификационный интерфейс -- это сервис, позволяющий сохранять утверждения о квалификации
в Хранилище записей об обучении (Learning Record Store, LRS). Как правило, это записи
об учебном процессе, но API позволяет сделать утверждения о чём угодно по квалификации.
Квалификационный интерфейс зависит от Источника задач (Activity Provider, AP), чтобы
создавать и отслеживать эти утверждения; данная спецификация предоставляет модель данных
и сопутствующие компоненты для достижения цели.

А именно, Квалификационный интерфейс предоставляет:  

* Структуру и определение Утверждения, Состояния, Учащегося, Задачи и Объектов,
в которых Источник задач трактует квалификацию.

* Методы передачи данных для сохранения и выборки (но не валидации) этих
объектов в Хранилище записей об обучении. Заметьте, что системы, сохраняющие
и читающие записи, могут не быть Источниками задач. Хранилища могут
взаимодействовать меджу собой и с системами отчётов.

* Методы защиты, обеспечивающие надёжный обмен данными между
Хранилищем и доверенными источниками.  

Квалификационный интерфейс -- первая из многочисленных технологий, включающая
расширенную архитектуру онлайн-обучения. Сервисы аутентификации, сервисы запросов,
сервисы визуализации и сервисы персональных данных -- только некоторые из
дополнительных технологий, поддержка которых предусмотрена Квалификационным
интерфейсом. Хотя детали реализации тут не рассматриваются, стандарт разработан
с расчётом на широкие возможности архитектуры.
 
<a name="adlrole"/>

### 2.1 Роль ADL при разработке Квалификационного интерфейса  
Компания ADL сыграла роль руководителя и помошника при разработке.
Квалификационный интерфейс рассматривается, как часть Архитектуры обучения ADL,
способствующей обучению когда угодно и где угодно. ADL представляет его, как
улучшенную версию Модели связанных объектов и совместного доступа к контенту (SCORM), поддерживающую аналагичные варианты использования, а так же
другие, отобранные ADL, относящиеся к дистанционному обучению, но не включённые в SCORM.  
 
<a name="contributors"/> 

### 2.2 Авторы
>_"Я благодарен всем, кто принимал участие в этом проекте. Многие из вас
участвовали в еженедельных совещаниях и помогали сделать спецификацию
полезной для всего сообщества дистанционного обучения. Многие из вас
помогали в создании примеров кода, продукции и документации, чтобы
поддержать тех, кто разрабатывает и подтверждает спецификацию. Я так же хочу
поблагодарить всех тех, кто поделился полезной, честной информацией
об использовании в их компаниях SCORM и других технологий обучения.
По предложенным требованиям, предоставленному опыту и Вашим знаниям ADL
и сообщество чётко определило первый шаг в создании Архитектуры Тренинга
и Обучения -- Квалификационного интерфейса. Вы настоящие лидеры сообщества,
от которых мы зависим, делая наше обучение наилучшим."_

Kristy S. Murray, Ed.D.  
Директор компании ADL  
OSD, Training Readiness & Strategy (TRS)  

<a name="wg"/>

### 2.2.1 Команда участников  
<table>
	<tr><th>Name</th><th>Organization</th></tr>
	<tr><td>Aaron Silvers</td><td>ADL</td></tr>
	<tr><td>Al Bejcek</td><td>NetDimensions</td></tr>
	<tr><td>Ali Shahrazad</td><td>SaLTBOX</td></tr>
	<tr><td>Andrew Downes</td><td>Epic</td></tr>
	<tr><td>Andy Johnson</td><td>ADL</td></tr>
	<tr><td>Andy Whitaker</td><td>Rustici Software</td></tr>
	<tr><td>Anthony Altieri</td><td>American Red Cross</td></tr>
	<tr><td>Anto Valan</td><td>Omnivera Learning Solutions</td></tr>
	<tr><td>Avron Barr</td><td>Aldo Ventures, Inc.</td></tr>
	<tr><td>Ben Clark</td><td>Rustici Software</td></tr>
	<tr><td>Bill McDonald</td><td>Boeing</td></tr>
	<tr><td>Brian J. Miller</td><td>Rustici Software</td></tr>
	<tr><td>Chad Udell</td><td>Float Mobile Learning</td></tr>
	<tr><td>Chris Sawwa</td><td>Meridian Knowledge Solutions</td></tr>
	<tr><td>Dan Allen</td><td>Litmos</td></tr>
	<tr><td>Dan Kuemmel</td><td>Sentry Insurance</td></tr>
	<tr><td>Dave Mozealous</td><td>Articulate</td></tr>
	<tr><td>David Ells</td><td>Rustici Software</td></tr>
	<tr><td>David N. Johnson</td><td>Clear Learning Systems</td></tr>
	<tr><td>Doug Hagy</td><td>Twin Lakes Consulting Corporation</td></tr>
	<tr><td>Eric Johnson</td><td>Planning and Learning Technologies, Inc.</td></tr>
	<tr><td>Fiona Leteney</td><td>Feenix e-learning</td></tr>
	<tr><td>Greg Tatka</td><td>Menco Social Learning</td></tr>
	<tr><td>Ingo Dahn</td><td>University Koblenz-Landau</td></tr>
	<tr><td>Jason Haag</td><td>ADL</td></tr>
	<tr><td>Jeff Place</td><td>Questionmark</td></tr>
	<tr><td>Jennifer Cameron</td><td>Sencia Corporate Web Solutions</td></tr>
	<tr><td>Jeremy Brockman</td><td> </td></tr>
	<tr><td>Jhorlin De Armas</td><td>Riptide Software</td></tr>
	<tr><td>Joe Gorup</td><td>CourseAvenue</td></tr>
	<tr><td>John Kleeman</td><td>Questionmark</td></tr>
	<tr><td>Jonathan Archibald</td><td>Brightwave</td></tr>
	<tr><td>Jonathan Poltrack</td><td>ADL</td></tr>
	<tr><td>Kris Miller</td><td>edcetra Training</td></tr>
	<tr><td>Kris Rockwell</td><td>Hybrid Learning Systems</td></tr>
	<tr><td>Lang Holloman</td><td> </td></tr>
	<tr><td>Lou Wolford</td><td>ADL</td></tr>
	<tr><td>Luke Hickey</td><td>dominKnow</td></tr>
	<tr><td>Marcus Birtwhistle</td><td>ADL</td></tr>
	<tr><td>Mark Davis</td><td>Exambuilder</td></tr>
	<tr><td>Matteo Scaramuccia</td><td> </td></tr>
	<tr><td>Megan Bowe</td><td>Rustici Software</td></tr>
	<tr><td>Melanie VanHorn</td><td>ADL</td></tr>
	<tr><td>Michael Flores</td><td>Here Everything's Better</td></tr>
	<tr><td>Michael Roberts</td><td>vTrainingRoom</td></tr>
	<tr><td>Mike Palmer</td><td>OnPoint Digital</td></tr>
	<tr><td>Mike Rustici</td><td>Rustici Software</td></tr>
	<tr><td>Nick Washburn</td><td>Riptide Software</td></tr>
	<tr><td>Nikolaus Hruska</td><td>ADL</td></tr>
	<tr><td>Pankaj Agrawal</td><td>Next Software Solutions</td></tr>
	<tr><td>Patrick Kedziora</td><td>Kedzoh</td></tr>
	<tr><td>Paul Esch</td><td>Nine Set</td></tr>
	<tr><td>Paul Roberts</td><td>Questionmark</td></tr>
	<tr><td>Rich Chetwynd</td><td>Litmos</td></tr>
	<tr><td>Richard Fouchaux</td><td>Ontario Human Rights  Commission</td></tr>
	<tr><td>Richard Lenz</td><td>Organizational Strategies, Inc.</td></tr>
	<tr><td>Rick Raymer</td><td></td></tr>
	<tr><td>Rob Chadwick</td><td>ADL</td></tr>
	<tr><td>Robert Lowe</td><td>NetDimensions</td></tr>
	<tr><td>Russell Duhon</td><td>SaLTBOX</td></tr>
	<tr><td>Stephen Trevorrow</td><td>Problem Solutions, LLC.</td></tr>
	<tr><td>Steve Baumgartner</td><td></td></tr>
	<tr><td>Steve Flowers</td><td>XPConcept</td></tr>
	<tr><td>Thomas Ho</td><td></td></tr>
	<tr><td>Tim Martin</td><td>Rustici Software</td></tr>
	<tr><td>Tom Creighton</td><td>ADL</td></tr>
	<tr><td>Walt Grata</td><td>ADL</td></tr>
</table> 
##### Авторы перевода
<table>
	<tr><td>Копилов Александр</td><td>СПб НИУ ИТМО</td></tr>
</table>

<a name="reqparticipants"/> 

#### 2.2.2 Участники сбора требований  
В коллекции требований к Квалификационному интерфейсу многие люди и
компании предоставляли неоценимые отзывы о SCORM, попытках проведения дистанционного
обучения и образования в целом. Хотя список и не полный, документы, собранные
в 2008 году группой Совместимость стандартов обучения (Learning Education and
Training Standards Interoperability, LETSI), на сайте Rustici Software _UserVoice_,
в личных интервью и различных блогах были важнымми источниками требований к
спецификации Квалификационного интерфейса.

<a name="readingguidelines"/> 

### 2.3 Указания к прочтению для нетехнического уклона

Это точный документ, описывающий, как Квалификационный интерфейс должен быть реализован
в различных системах. Это технический документ, написанный специально для лиц
и организаций, реализующих данную технологию, чтобы они могли разрабатывать
совместимые инструменты, системы и сервисы, независимые друг от друга
и совместимые между собой. 

Насколько возможно, язык и форматирование в этом документе целенаправленно сделаны
_дружелюбными_ к нетехническим читателям, поскольку многие инструменты, системы и сервисы
основаны на описанной ниже спецификации. Поэтому, разделы, предоставляющие
_общий обзор_ аспектов помечены, как **описание** или **обоснование**.
Элементы, помеченные как **требования**, **детали** или **примеры** более технические.

<a name="definitions"/>
 
## 3.0 Определения и сокращения  

* [IRI](#def-iri)
* [IRL](#def-irl)
* [LMS](#def-learning-management-system)
* [LRS](#def-learning-record-store)
* [REST](#def-rest)
* [Tin Can API (TCAPI)](#def-tcapi)
* [Авторизация](#def-authorization)
* [Аутентификация](#def-authentication)
* [Действие (Verb)](#def-verb)
* [Задача (Activity)](#def-activity)
* [Исполнитель (Actor)](#def-actor)
* [Источник задач (Activity Provider, AP)](#def-activity-provider)
* [Квалификационный интерфейс (Experience API, xAPI)](#def-experience-api)
* [Клиент (Client)](#def-client)
* [Неизменный](#def-immutable)
* [Обратный идентификатор (Inverse Functional Identifier)](#def-inverse-functional-identifier)
* [ОБЯЗАН / ДОЛЖЕН / МОЖЕТ (MUST / SHOULD / MAY)](#def-must-should-may)
* [Профиль (Profile)](#def-profile)
* [Регистрация (Registration)](#def-registration)
* [Сeрвис](#def-service)
* [Сообщество пракующих](#def-community-of-practice)
* [Утверждение (Statement)](#def-statement)

<a name="def-iri" />

__IRI (Internationalized Resource Identifier, Интернационализированный идентификатор ресурса)__:  
Уникальный идентификатор, в частности IRL.
В xAPI все IRI должны быть абсолютными (включать имя схемы). Относительные IRI
использоваться не должны. IRL должны быть на домене, принадлежащем автору(???).

<a name="def-irl" />

__IRL (Internationalized Resource Locator, Интернационализированный локатор ресурса)__:  
В контексте данного документа, IRL -- это IRI, который при преобразовании IRI в URI
по соответствующим правилам, образует URL. 
Некоторые практикуют обычное использование URL, даже если они являются IRI, что в
xAPI не вполне корректно.

<a name="def-learning-management-system" />

__LMS (Learning Management System, Система управления обучением)__:
«Программный продукт, используемый для администрирования одного или более учебного курса для одного или более учащегося.
Обычно LMS -- web-системы, позволяющие учащимся аутентифицироваться, записываться на курсы, проходить курсы и получать
оценки» (определение Лаборатории архитектуры обучающих систем, Learning Systems Architecture Lab). В этом документе
термин подразумевает существующие системы, реализующие стандарты обучения.

<a name="def-learning-record-store" />

__LRS (Learning Record Store, Хранилище записей об обучении)__: Система, сохраняющая информацию об обучении. До xAPI 
большинство LRS были системами управления обучением (LMS); однако этот документ использует термин 
LRS, подразумевая, что полноценая LMS не обязательно должна поддерживать xAPI. Реализация xAPI
необходима для функционирования LRS.

<a name="def-rest" />

__REST (Representational State Transfer, Передача репрезентативного состояния)__:
Архитектура построения сетевых сервисов.
Она основана на протоколе HTTP и использует лучшие принципы web.

<a name="def-tcapi"/>

__Tin Can API (TCAPI)__: Предыдущее название API, определённого эти документом, часто используемое
в информационных ссылках на Квалификационный интерфейс.  

<a name="def-authorization" />

__Авторизация__: Определение допустимых прав, основанных на роли пользователя в системе; 
процесс получение одним пользователем или системой «доверия» у другой.

<a name="def-authentication" />

__Аутентификация__: Понятие подтверждения подлинности пользователя или системы. Аутентификация 
обеспечивает взаимодействие двух «доверенных» сторон.

<a name="def-verb" />

__Действие (Verb)__: Действие, выполняемое Исполнителем над Задачей при Утверждении. 

<a name="def-activity" />

__Задача (Activity)__: Задача -- тип Объекта, переходящего из «нечто» в «Я сделал „это“»; это что-то, 
с чем взаимодействует Исполнитель. Это может быть теоретический конспект, практикум или работа, выполняемая через 
осмысленное Действие в системе. Интерпретация Задачи широка, это значит, что Задачей может быть даже 
материальный объект, такой, как стул (реальный или виртуальный). В утверждении «Анна попыталась 
испечь торт по рецепту» рецепт выступает, как задача в терминах утверждения xAPI. Другими примерами 
задач могут быть книга, электронный курс, экскурсия ил собрание.

<a name="def-actor" />

__Исполнитель (Actor)__: Личность или образ физ. лица или группа, выполняющая Действие над Задачей
с помощью Утверждений.

<a name="def-activity-provider" />

__Источник задач (Activity Provider, AP)__: Программный объект, взаимодействующий с LRS
для записи информации об учебном процессе. Может быть похож на SCORM-пакет в том, что
возможно объединить учебные материалы в программе, осуществляющей эту связь, но
Источник задач может так же быть отделён от опыта, который передаёт.

<a name="def-experience-api" />

__Квалификационный интерфейс (Experience API, xAPI)__: Программный интерфейс (API), определённый этим документом, продукт
Проекта «Tin Can». Простой, легковесный способ, позволяющий имеющим право Исполнителям сохранять
и восстанавливать расширяемые записи об учёбе, профили учащегося и учебного процесса, 
независимо от платформы.  

<a name="def-client" />

__Клиент (Client)__: - относится к чему угодно, взаимодействующему с LRS. Клиентом может быть
Источник задач, система отчётов, LMS или другое LRS.

<a name ="def-immutable" />

__Неизменный__:  признак, обозначающий предметы, которые не могут измениться.
С некоторыми оговорками, Утверждения в xAPI неизменны. Это означает, что при
распространении Утверждений в LRS все копии Утверждений остаются одинаковыми.

<a name="def-inverse-functional-identifier" />

__Обратный идентификатор (Inverse Functional Identifier)__: Идентификатор, уникальный для человека или групы.
Используется для идентификации Субъектов и Групп.

<a name="def-must-should-may" />

__ОБЯЗАН / ДОЛЖЕН / МОЖЕТ (MUST / SHOULD / MAY)__: Три уровня обязательства, определяющие соответствие спецификации xAPI.
Система, не реализующая требования с пометкой ОБЯЗАН (или ОБЯЗАН НЕ), не соответствует спецификации.
Отсутствие реализации требования ДОЛЖЕН не является нарушением совместимости, но делает систему неполноценной.
МОЖЕТ обозначает варианты, оставленные на решение разработчика и не влияющие на соответствие.

<a name="def-profile" />

__Профиль (Profile)__: Структура, содержащая информацию об учащемся или задаче, 
обычно в виде пар имя/документ, относящийся к компоненту учебной системы.

<a name="def-registration" />

__Регистрация (Registration)__: Ссылка на конкретного учащегося, решающего конкретную Задачу.

<a name="def-service" />

__Сервис__: Программный компонент, отвечающий за один или более аспект процесса дистанционного обучения.
LMS традиционно сочетают в себе много сервисов для формирования полноценного учебного процесса.

<a name="def-community-of-practice" />

__Сообщество практикующих__: Группа, обычно объединённая общей целью, ролью или
намерениями, действующая по общей методике.

<a name="def-statement" />

__Утверждние (Statement)__: Простая конструкция, состоящая из ```<исполнителя (учащегося)>``` ```<действия>``` ```<объека>```, 
с ```<результатом>```, в ```<контексте>``` для описания учебного процесса. Набор из нескольких
утверждений позволяет детально описать учебный процесс.

<a name="statement"/> 

## 4.0 Утверждение  

###### Описание 
Утверждение явяется основой xAPI. Все события процесса обучения сохраняются в виде Утверждений.
Утверждения схожи с предложениями в форме «Я сделал это».

<a name="stmtprops"/>

### 4.1 Свойства Утверждения  

###### Детали
Детали каждого свойства утверждения описаны в таблице ниже.  

<table>
	<tr><th>Свойство</th><th>тип</th><th>Описание</th><th>Обязательность</th></tr>
	<tr><td>id</td><td>UUID</td>
	<td>UUID, присвоенное LRS, если не было задано Источником задач.</td>
	<td>Рекомендуется</td></tr>
	<tr><td><a href="#actor">actor</a></td><td>Объект</td>
	<td>Исполнитель. О ком говорится в Утверждении, например, <a href="#agent">Субъект</a> или 
		<a href="#group">Группа</a>. Отображает «Я» в «Я сделал это».</td>
	<td>Обязательно</td></tr>
	<tr><td><a href="#verb">verb</a></td><td>Объект</td>
	<td>Действие Учащегося или Команды. Отображает «Сделал» в «Я сделал это».</td>
	<td>Обязательно</td></tr>
	<tr><td><a href="#object">object</a></td><td>Объект</td>
	<td>Объект. Задача, Субъект или другое Утверждение, являющеея объектом данного Утверждения. 
	Отображает «Это» в «Я сделал это». Заметьте, что Объект, подаваемый в качестве значения данного поля, должен 
	включать поле «Тип объекта». При его отсутствии Объект принимается 
	за Задачу.</td>
	<td>Обязательно</td></tr>
	<tr><td><a href="#result">result</a></td><td>Объект</td>
	<td>Результат Действия, дополнительные подробности и оценки.</td>
	<td>Опционально</td></tr>
	<tr><td><a href="#context">context</a></td><td>Объект</td>
	<td>Контекст, дающий больше смысла Утверждению. Например: команда, в которой работает 
	Исполнитель, высота выполнения трюка в авиасимуляторе.</td>
	<td>Опционально</td></tr>
	<tr><td><a href="#timestamp">timestamp</a></td><td>Дата/время</td>
	<td>Timestamp (временная отметка, отформатированная по стандарту <a href="https://ru.wikipedia.org/wiki/ISO_8601">ISO 8601</a>) 
	с датой и временем, когда произошло событие, описанное в Утверждении. Если не указано, LRS 
	должно присвоить ему то же значение, что и полю "stored".</td>
	<td>Опционально</td></tr>
	<tr><td><a href="#stored">stored</a></td><td>Дата/время</td>
	<td>Timestamp (временная отметка, отформатированная по стандарту <a href="https://ru.wikipedia.org/wiki/ISO_8601">ISO 8601</a>) 
	с датой и временем, когда Утверждение было сохранено. Задаётся LRS.</td>
	<td>Задаётся LRS</td></tr>
	<tr><td><a href="#authority">authority</a></td><td>Object</td>
	<td>Авторитет. Субъект, подтверждающий подлинность Утверждения. Проверяется LRS согласно 
	аутентификации, устанавливается LRS, если не задано.</td>
	<td>Опционально</td></tr>
	<tr><td><a href="#version">version</a></td><td>Версия</td>
	<td>Версия xAPI, использованная для данного Утверждения, отформатированная по стандарту <a href="http://semver.org/spec/v1.0.0.html">Semantic Versioning 1.0.0</a>.</td>
	<td>Не рекомендуется</td></tr>
	<tr>
		<td><a href="#attachments">attachments</a></td>
		<td>Масив объектов-вложений</td>
	    <td>Заголовки вложений к Утверждению</td>
	<td>Опционально</td></tr>
</table>  

Не считая возможности (или обязанности) LRS присваивать некоторые свойства 
("id", "authority", "stored", "timestamp", "version") в процессе сохранения,
Утверждения неизменны. Заметьте, что содержимое 
Задач, ссылки на которые даны в Утверждениях, не рассматривается, как содержимое 
самого Утверждения. Таким образом, хотя Утверждения являются неизменными, связанные с ними
Задачи таковыми не являются. Это означает, что детальная выгрузка Утверждения в формате 
JSON изменится при изменении связанных Задач (подробнее смотрите параметр
[API Утверждения](#stmtapi) "format").  

###### Требования 

* Утверждение ОБЯЗЯНО содержать каждое свойство не более одного раза.
* Утверждение ОБЯЗЯНО содержать свойства "actor", "verb", и "object".
* Утверждение МОЖЕТ содержать свойства в любом порядке.

###### Пример

Пример простейшего Утверждения, использующего все свойства, которые ОБЯЗАНЫ или ДОЛЖНЫ быть использованы:  
```
{
	"id": "12345678-1234-5678-1234-567812345678",
	"actor":{
		"mbox":"mailto:xapi@adlnet.gov"
	},
	"verb":{
		"id":"http://adlnet.gov/expapi/verbs/created",
		"display":{
			"en-US":"created"
		}
	},
	"object":{
		"id":"http://example.adlnet.gov/xapi/example/activity"
	}
}
```  
Больше примеров приведено в [Приложении C: Примеры Утверждений](#AppendixC). 
