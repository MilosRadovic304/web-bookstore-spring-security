--------------------------------------------------------
--  File created - Thursday-December-23-2021   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table BOOK2
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."BOOK2" 
   (	"ID" NUMBER(11,0) GENERATED ALWAYS AS IDENTITY MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE , 
	"TITLE" VARCHAR2(100 BYTE), 
	"AUTHOR" VARCHAR2(45 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into SYSTEM.BOOK2
SET DEFINE OFF;
Insert into SYSTEM.BOOK2 (ID,TITLE,AUTHOR) values (1,'Python Crash Course','Eric Matthes');
Insert into SYSTEM.BOOK2 (ID,TITLE,AUTHOR) values (23,'OCA: Oracle Certified Associate Java SE 8 Programmer I Study
Guide','Jeanne Boyarsky and Scott Selikoff');
Insert into SYSTEM.BOOK2 (ID,TITLE,AUTHOR) values (24,'OCP: Oracle Certified Professional
Java SE 8 Programmer II Study
Guide','Jeanne Boyarsky and Scott Selikoff');
Insert into SYSTEM.BOOK2 (ID,TITLE,AUTHOR) values (25,'Masterig Selenium WebDriver','Mark Collin');
Insert into SYSTEM.BOOK2 (ID,TITLE,AUTHOR) values (26,'Ruby Cookbook','Lucas Carlson and Leonard Richardson');
Insert into SYSTEM.BOOK2 (ID,TITLE,AUTHOR) values (27,'PHP In a Nutshell','Paul Hudson');
Insert into SYSTEM.BOOK2 (ID,TITLE,AUTHOR) values (28,'JavaScript Bible Gold Edition','Danny Goodman');
Insert into SYSTEM.BOOK2 (ID,TITLE,AUTHOR) values (29,'Effective Java','Joshua Bloch');
Insert into SYSTEM.BOOK2 (ID,TITLE,AUTHOR) values (30,'Oracle PL/SQL Best Practices','Steven Feuerstein');
--------------------------------------------------------
--  DDL for Index SYS_C008352
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYSTEM"."SYS_C008352" ON "SYSTEM"."BOOK2" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table BOOK2
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."BOOK2" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."BOOK2" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
