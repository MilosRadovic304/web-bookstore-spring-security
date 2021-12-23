--------------------------------------------------------
--  File created - Thursday-December-23-2021   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table SALES2
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."SALES2" 
   (	"BOOK_ID" NUMBER(11,0), 
	"CUSTOMER_ID" NUMBER(11,0)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into SYSTEM.SALES2
SET DEFINE OFF;
Insert into SYSTEM.SALES2 (BOOK_ID,CUSTOMER_ID) values (1,101);
Insert into SYSTEM.SALES2 (BOOK_ID,CUSTOMER_ID) values (25,101);
--------------------------------------------------------
--  Constraints for Table SALES2
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."SALES2" MODIFY ("BOOK_ID" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."SALES2" MODIFY ("CUSTOMER_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table SALES2
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."SALES2" ADD CONSTRAINT "FK_BOOK_CUSTOMER2" FOREIGN KEY ("BOOK_ID")
	  REFERENCES "SYSTEM"."BOOK2" ("ID") ENABLE;
  ALTER TABLE "SYSTEM"."SALES2" ADD CONSTRAINT "FK_CUSTOMER_BOOK2" FOREIGN KEY ("CUSTOMER_ID")
	  REFERENCES "SYSTEM"."CUSTOMER2" ("ID") ENABLE;
