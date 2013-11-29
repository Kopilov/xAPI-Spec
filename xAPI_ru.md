# Квалификационный интерфейс
## Лаборатория Продвинутого дистанционного обучения (ADL)

>"Инициировано ADL, Министерство обороны США, 2013. Все права сохранены.

>Лицензировано лицензией Apache 2.0 (далее "Лицензия"). Вы не можете использовать этот документ без
>согласования с Лицензией. Вы можете получить копию Лицензии тут:
>http://www.apache.org/licenses/LICENSE-2.0

>При отсутствии законодательных требований или письменных соглашений, программное обеспечение по лицензии
>распространяется "КАК ЕСТЬ", БЕЗ КАКИХ-ЛИБО ГАРАНТИЙ ИЛИ УСЛОВИЙ, явных или подразумеваемых.
>Основные разрешения и ограничения смотрите в Лицензии."

>Данный документ написан участниками команды  разработчиков Квалификационного интерфейса (см.
>список на стр. 7-8) при поддержке Заместитель помощника секретаря обороны ADL.
>Пожалуйста, отправляйте отзывы и вопросы на адрес helpdesk@adlnet.gov

>Перевод написан студентами СПб НИУ ИТМО. de@mail.ifmo.ru

## Содержание
*	1.0.	[Обзор истории](#revhistory)  
*	2.0.	[Роль Квалификационного интерфейса](#roleofxapi)
	*	2.1.	[ADL's Role in the Experience API](#adlrole)  
 	*	2.2.	[Contributors](#contributors)
 		*	2.2.1.	[Working Group Participants](#wg)  
		*	2.2.2.	[Requirements Gathering Participants](#reqparticipants) 
	*	2.2.3	[Reading Guidelines for the Non-Technically Inclined](#readingguidelines)
*	3.0.	[Definitions](#definitions)  
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

"Основные" Команды (Verb) и типы Действий (Activity) удалены из спецификации. Ссылки 
на эти команды так же удалены. При реализации API рекомендуется использовать команды, 
определённые сообществом, а не создавать свои собственные.
- Команды, типы Действий и ключи расширений теперь в виде URI.
- Переписано и уточнено (???) о некоторых других деталях и объёме реализации.
- Переход от человек-ориентированного представления Cубъекта (Agent) к образ-ориентированному
- Требование объединения Друга Друга (Friend of a Friend, FOAF) Субъекта удалено.
- Субъект должен иметь ровно одно уникальное идентифицирующее свойство, а не хотя бы одно.

###### 0.95 - 1.0.0 (26 апреля 2013) 
Различные усовершенствования и оптимизация, в том числе:
- Вложения
- Данные о действиях сохраняются в JSON, а не в XML
- Изменения в Операторах аннулирования (voiding Statements)
- Оптимизация и именование API Документа (Document)
- Изменения в вызывании API Операторов
- Подписанные Операторы

###### 1.0.0 - 1.0.1 (1 октября 2013)
Оптиизация и примеры, в том числе:
- Исправление опечаток
- Дополнительные примеры в приложениях

