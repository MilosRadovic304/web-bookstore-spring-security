--------------------------------------------------------
--  File created - Thursday-December-23-2021   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table CUSTOMER_ROLES
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."CUSTOMER_ROLES" 
   (	"CUSTOMER_ID" NUMBER(11,0), 
	"ROLE_ID" NUMBER(11,0)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into SYSTEM.CUSTOMER_ROLES
SET DEFINE OFF;
Insert into SYSTEM.CUSTOMER_ROLES (CUSTOMER_ID,ROLE_ID) values (89,1);
Insert into SYSTEM.CUSTOMER_ROLES (CUSTOMER_ID,ROLE_ID) values (90,1);
Insert into SYSTEM.CUSTOMER_ROLES (CUSTOMER_ID,ROLE_ID) values (101,1);
Insert into SYSTEM.CUSTOMER_ROLES (CUSTOMER_ID,ROLE_ID) values (101,3);
Insert into SYSTEM.CUSTOMER_ROLES (CUSTOMER_ID,ROLE_ID) values (102,1);
Insert into SYSTEM.CUSTOMER_ROLES (CUSTOMER_ID,ROLE_ID) values (102,2);
Insert into SYSTEM.CUSTOMER_ROLES (CUSTOMER_ID,ROLE_ID) values (121,1);
Insert into SYSTEM.CUSTOMER_ROLES (CUSTOMER_ID,ROLE_ID) values (145,1);
--------------------------------------------------------
--  Constraints for Table CUSTOMER_ROLES
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."CUSTOMER_ROLES" MODIFY ("CUSTOMER_ID" NOT NULL ENABLE);
  ALTER TABLE "SYSTEM"."CUSTOMER_ROLES" MODIFY ("ROLE_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table CUSTOMER_ROLES
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."CUSTOMER_ROLES" ADD CONSTRAINT "FK_ROLE_CUSTOMER" FOREIGN KEY ("ROLE_ID")
	  REFERENCES "SYSTEM"."ROLE" ("ID") ENABLE;
  ALTER TABLE "SYSTEM"."CUSTOMER_ROLES" ADD CONSTRAINT "FK_CUSTOMER_ROLE" FOREIGN KEY ("CUSTOMER_ID")
	  REFERENCES "SYSTEM"."CUSTOMER2" ("ID") ENABLE;
