--------------------------------------------------------
--  File created - niedziela-sierpnia-30-2020   
--------------------------------------------------------

--------------------------------------------------------
--  DDL for Table CAR
--------------------------------------------------------

  CREATE TABLE "G2_MARCHEWKAM"."CAR" 
   (	"CAR_ID" NUMBER, 
	"LICENSE_PLATE" VARCHAR2(10 BYTE), 
	"MARK" VARCHAR2(15 BYTE), 
	"MODEL" VARCHAR2(15 BYTE), 
	"VIN" VARCHAR2(17 BYTE), 
	"BODY_TYPE" VARCHAR2(10 BYTE), 
	"MODEL_YEAR" NUMBER(4,0), 
	"ENGINE_SIZE" NUMBER, 
	"FUEL_TYPE" VARCHAR2(10 BYTE), 
	"MILEAGE" NUMBER, 
	"PRICE_ID" NUMBER, 
	"OFFICE_ID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "G2" ;
--------------------------------------------------------
--  DDL for Table CAR_PRICE
--------------------------------------------------------

  CREATE TABLE "G2_MARCHEWKAM"."CAR_PRICE" 
   (	"PRICE_ID" NUMBER, 
	"PER_DAY" NUMBER, 
	"FOR_ENGINE_SIZE" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "G2" ;
--------------------------------------------------------
--  DDL for Table CLIENT
--------------------------------------------------------

  CREATE TABLE "G2_MARCHEWKAM"."CLIENT" 
   (	"CLIENT_ID" NUMBER, 
	"FIRST_NAME" VARCHAR2(20 BYTE), 
	"LAST_NAME" VARCHAR2(30 BYTE), 
	"PESEL" VARCHAR2(11 BYTE), 
	"PHONE" VARCHAR2(11 BYTE), 
	"DRIVING_LICENSE_NUM" VARCHAR2(10 BYTE), 
	"LOGIN" VARCHAR2(20 BYTE), 
	"PASSWORD" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "G2" ;
--------------------------------------------------------
--  DDL for Table OFFICE
--------------------------------------------------------

  CREATE TABLE "G2_MARCHEWKAM"."OFFICE" 
   (	"OFFICE_ID" NUMBER, 
	"ADDRESS" VARCHAR2(50 BYTE), 
	"PHONE" VARCHAR2(11 BYTE), 
	"CITY" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "G2" ;
--------------------------------------------------------
--  DDL for Table RENT
--------------------------------------------------------

  CREATE TABLE "G2_MARCHEWKAM"."RENT" 
   (	"RENT_ID" NUMBER, 
	"RENT_DATE" DATE, 
	"RETURN_DATE" DATE, 
	"NOTE" VARCHAR2(30 BYTE), 
	"CLIENT_ID" NUMBER, 
	"CAR_ID" NUMBER, 
	"SUM" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "G2" ;


REM INSERTING into G2_MARCHEWKAM.CAR
SET DEFINE OFF;
Insert into G2_MARCHEWKAM.CAR (CAR_ID,LICENSE_PLATE,MARK,MODEL,VIN,BODY_TYPE,MODEL_YEAR,ENGINE_SIZE,FUEL_TYPE,MILEAGE,PRICE_ID,OFFICE_ID) values ('1','TK78903','OPEL','CORSA','12345678900987654','HATCHBACK','2019','1598','BENZYNA','20000','1','1');
Insert into G2_MARCHEWKAM.CAR (CAR_ID,LICENSE_PLATE,MARK,MODEL,VIN,BODY_TYPE,MODEL_YEAR,ENGINE_SIZE,FUEL_TYPE,MILEAGE,PRICE_ID,OFFICE_ID) values ('2','LU5K32','VOLKSWAGEN','PASSAT','34567892136543298','SEDAN','2017','1999','DIESEL','60000','2','2');
Insert into G2_MARCHEWKAM.CAR (CAR_ID,LICENSE_PLATE,MARK,MODEL,VIN,BODY_TYPE,MODEL_YEAR,ENGINE_SIZE,FUEL_TYPE,MILEAGE,PRICE_ID,OFFICE_ID) values ('6','LU35242','BMW','3','2345678987654','KOMBII','2017','2200','DIESEL','12344','2','2');
Insert into G2_MARCHEWKAM.CAR (CAR_ID,LICENSE_PLATE,MARK,MODEL,VIN,BODY_TYPE,MODEL_YEAR,ENGINE_SIZE,FUEL_TYPE,MILEAGE,PRICE_ID,OFFICE_ID) values ('3','TK74635','VOLVO','S60','74926385647382916','SEDAN','2020','2000','BENZYNA','5000','2','1');
Insert into G2_MARCHEWKAM.CAR (CAR_ID,LICENSE_PLATE,MARK,MODEL,VIN,BODY_TYPE,MODEL_YEAR,ENGINE_SIZE,FUEL_TYPE,MILEAGE,PRICE_ID,OFFICE_ID) values ('5','LU37493','FIAT','500','46392648291648362','HATCHBACK','2018','1200','BENZYNA','34000','1','2');
REM INSERTING into G2_MARCHEWKAM.CAR_PRICE
SET DEFINE OFF;
Insert into G2_MARCHEWKAM.CAR_PRICE (PRICE_ID,PER_DAY,FOR_ENGINE_SIZE) values ('1','30','1600');
Insert into G2_MARCHEWKAM.CAR_PRICE (PRICE_ID,PER_DAY,FOR_ENGINE_SIZE) values ('2','60','2000');
Insert into G2_MARCHEWKAM.CAR_PRICE (PRICE_ID,PER_DAY,FOR_ENGINE_SIZE) values ('3','90','2400');
REM INSERTING into G2_MARCHEWKAM.CLIENT
SET DEFINE OFF;
Insert into G2_MARCHEWKAM.CLIENT (CLIENT_ID,FIRST_NAME,LAST_NAME,PESEL,PHONE,DRIVING_LICENSE_NUM,LOGIN,PASSWORD) values ('3','Ela','Opos','87043198374','877643234','KBT89543','Opos','Opos1234');
Insert into G2_MARCHEWKAM.CLIENT (CLIENT_ID,FIRST_NAME,LAST_NAME,PESEL,PHONE,DRIVING_LICENSE_NUM,LOGIN,PASSWORD) values ('5','Jan','Kowalski','93021358461','837146124','BNT73812','Kowalski','Kowalski123');
Insert into G2_MARCHEWKAM.CLIENT (CLIENT_ID,FIRST_NAME,LAST_NAME,PESEL,PHONE,DRIVING_LICENSE_NUM,LOGIN,PASSWORD) values ('7','Jolanta','Kwiatek','76051284732','784623442','BMT37234','Kwiatek','Kwiatek123');
Insert into G2_MARCHEWKAM.CLIENT (CLIENT_ID,FIRST_NAME,LAST_NAME,PESEL,PHONE,DRIVING_LICENSE_NUM,LOGIN,PASSWORD) values ('4','Klaudia','Juga','87031198234','876972413','JKB78312','Juga','Juga123');
Insert into G2_MARCHEWKAM.CLIENT (CLIENT_ID,FIRST_NAME,LAST_NAME,PESEL,PHONE,DRIVING_LICENSE_NUM,LOGIN,PASSWORD) values ('6','Tomasz','Klawisz','84123157432','759302284','JWE37593','Klawisz','Klawisz123');
Insert into G2_MARCHEWKAM.CLIENT (CLIENT_ID,FIRST_NAME,LAST_NAME,PESEL,PHONE,DRIVING_LICENSE_NUM,LOGIN,PASSWORD) values ('1','Adam','Ibis','34020306432','453113564','CBT78532','Ibis','Ibis123');
REM INSERTING into G2_MARCHEWKAM.OFFICE
SET DEFINE OFF;
Insert into G2_MARCHEWKAM.OFFICE (OFFICE_ID,ADDRESS,PHONE,CITY) values ('1','POLNA 20','666999222','KIELCE');
Insert into G2_MARCHEWKAM.OFFICE (OFFICE_ID,ADDRESS,PHONE,CITY) values ('2','KWIATOWA 4','111222444','LUBLIN');
REM INSERTING into G2_MARCHEWKAM.RENT
SET DEFINE OFF;
Insert into G2_MARCHEWKAM.RENT (RENT_ID,RENT_DATE,RETURN_DATE,NOTE,CLIENT_ID,CAR_ID,SUM) values ('2',to_date('20/08/25','RR/MM/DD'),to_date('20/08/30','RR/MM/DD'),'Brak','1','1','150');
Insert into G2_MARCHEWKAM.RENT (RENT_ID,RENT_DATE,RETURN_DATE,NOTE,CLIENT_ID,CAR_ID,SUM) values ('4',to_date('20/08/24','RR/MM/DD'),to_date('20/08/28','RR/MM/DD'),'Brak','3','1','120');
Insert into G2_MARCHEWKAM.RENT (RENT_ID,RENT_DATE,RETURN_DATE,NOTE,CLIENT_ID,CAR_ID,SUM) values ('1',to_date('20/08/11','RR/MM/DD'),to_date('20/08/15','RR/MM/DD'),'Brak','1','1','120');
Insert into G2_MARCHEWKAM.RENT (RENT_ID,RENT_DATE,RETURN_DATE,NOTE,CLIENT_ID,CAR_ID,SUM) values ('3',to_date('20/08/12','RR/MM/DD'),to_date('20/08/14','RR/MM/DD'),'Brak','4','1','60');
Insert into G2_MARCHEWKAM.RENT (RENT_ID,RENT_DATE,RETURN_DATE,NOTE,CLIENT_ID,CAR_ID,SUM) values ('5',to_date('20/08/26','RR/MM/DD'),to_date('20/08/29','RR/MM/DD'),'Brak','1','2','180');
--------------------------------------------------------
--  DDL for Index CAR_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "G2_MARCHEWKAM"."CAR_PK" ON "G2_MARCHEWKAM"."CAR" ("CAR_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "G2" ;
--------------------------------------------------------
--  DDL for Index CAR_PRICE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "G2_MARCHEWKAM"."CAR_PRICE_PK" ON "G2_MARCHEWKAM"."CAR_PRICE" ("PRICE_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "G2" ;
--------------------------------------------------------
--  DDL for Index CLIENT_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "G2_MARCHEWKAM"."CLIENT_PK" ON "G2_MARCHEWKAM"."CLIENT" ("CLIENT_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "G2" ;
--------------------------------------------------------
--  DDL for Index OFFICE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "G2_MARCHEWKAM"."OFFICE_PK" ON "G2_MARCHEWKAM"."OFFICE" ("OFFICE_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "G2" ;
--------------------------------------------------------
--  DDL for Index RENT_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "G2_MARCHEWKAM"."RENT_PK" ON "G2_MARCHEWKAM"."RENT" ("RENT_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "G2" ;
--------------------------------------------------------
--  DDL for Index SYS_C0038138
--------------------------------------------------------

  CREATE UNIQUE INDEX "G2_MARCHEWKAM"."SYS_C0038138" ON "G2_MARCHEWKAM"."CLIENT" ("LOGIN") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "G2" ;
--------------------------------------------------------
--  DDL for Trigger CAR_TRIGGER
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "G2_MARCHEWKAM"."CAR_TRIGGER" 
BEFORE DELETE OR INSERT OR UPDATE OF CAR_ID, LICENSE_PLATE, MARK, MODEL, VIN, BODY_TYPE, MODEL_YEAR, ENGINE_SIZE, FUEL_TYPE, MILEAGE, PRICE_ID, OFFICE_ID ON CAR
DECLARE
    id number(4);
    tabela varchar2(50);
    uzytkownik varchar2(30);
    data date;
    operacja varchar2(15);
BEGIN
   SELECT user INTO uzytkownik FROM dual;
    SELECT sysdate INTO data FROM dual;
    SELECT MAX(id) INTO id FROM logi;
    id:=id+1;
    IF id IS NULL THEN 
        id:=1;
    END IF;
    IF DELETING THEN
        INSERT INTO logi(id,tabela,uzytkownik,data,operacja) 
        VALUES(id, 'CAR', uzytkownik, data,'Usuniecie');
    END IF;
    
    IF INSERTING THEN 
        INSERT INTO logi(id,tabela,uzytkownik,data,operacja) 
        VALUES(id, 'CAR', uzytkownik, data,'Dodanie');
    END IF;
    
    IF UPDATING THEN 
        INSERT INTO logi(id,tabela,uzytkownik,data,operacja) 
        VALUES(id, 'CAR', uzytkownik, data,'Modyfikacja');
    END IF;
END;
/
ALTER TRIGGER "G2_MARCHEWKAM"."CAR_TRIGGER" ENABLE;


--------------------------------------------------------
--  Constraints for Table CAR
--------------------------------------------------------

  ALTER TABLE "G2_MARCHEWKAM"."CAR" ADD CONSTRAINT "CAR_PK" PRIMARY KEY ("CAR_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "G2"  ENABLE;
 
  ALTER TABLE "G2_MARCHEWKAM"."CAR" MODIFY ("CAR_ID" NOT NULL ENABLE);
 
  ALTER TABLE "G2_MARCHEWKAM"."CAR" MODIFY ("PRICE_ID" NOT NULL ENABLE);
 
  ALTER TABLE "G2_MARCHEWKAM"."CAR" MODIFY ("OFFICE_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CAR_PRICE
--------------------------------------------------------

  ALTER TABLE "G2_MARCHEWKAM"."CAR_PRICE" ADD CONSTRAINT "CAR_PRICE_PK" PRIMARY KEY ("PRICE_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "G2"  ENABLE;
 
  ALTER TABLE "G2_MARCHEWKAM"."CAR_PRICE" MODIFY ("PRICE_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CLIENT
--------------------------------------------------------

  ALTER TABLE "G2_MARCHEWKAM"."CLIENT" ADD CONSTRAINT "CLIENT_PK" PRIMARY KEY ("CLIENT_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "G2"  ENABLE;
 
  ALTER TABLE "G2_MARCHEWKAM"."CLIENT" MODIFY ("CLIENT_ID" NOT NULL ENABLE);
 
  ALTER TABLE "G2_MARCHEWKAM"."CLIENT" ADD UNIQUE ("LOGIN")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "G2"  ENABLE;
 
  ALTER TABLE "G2_MARCHEWKAM"."CLIENT" MODIFY ("LOGIN" NOT NULL ENABLE);
 
  ALTER TABLE "G2_MARCHEWKAM"."CLIENT" MODIFY ("PASSWORD" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table OFFICE
--------------------------------------------------------

  ALTER TABLE "G2_MARCHEWKAM"."OFFICE" ADD CONSTRAINT "OFFICE_PK" PRIMARY KEY ("OFFICE_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "G2"  ENABLE;
 
  ALTER TABLE "G2_MARCHEWKAM"."OFFICE" MODIFY ("OFFICE_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table RENT
--------------------------------------------------------

  ALTER TABLE "G2_MARCHEWKAM"."RENT" ADD CONSTRAINT "RENT_PK" PRIMARY KEY ("RENT_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "G2"  ENABLE;
 
  ALTER TABLE "G2_MARCHEWKAM"."RENT" MODIFY ("RENT_ID" NOT NULL ENABLE);
 
  ALTER TABLE "G2_MARCHEWKAM"."RENT" MODIFY ("CLIENT_ID" NOT NULL ENABLE);
 
  ALTER TABLE "G2_MARCHEWKAM"."RENT" MODIFY ("CAR_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table CAR
--------------------------------------------------------

  ALTER TABLE "G2_MARCHEWKAM"."CAR" ADD CONSTRAINT "CAR_CAR_PRICE_FK" FOREIGN KEY ("PRICE_ID")
	  REFERENCES "G2_MARCHEWKAM"."CAR_PRICE" ("PRICE_ID") ENABLE;
 
  ALTER TABLE "G2_MARCHEWKAM"."CAR" ADD CONSTRAINT "CAR_OFFICE_FK" FOREIGN KEY ("OFFICE_ID")
	  REFERENCES "G2_MARCHEWKAM"."OFFICE" ("OFFICE_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table RENT
--------------------------------------------------------

  ALTER TABLE "G2_MARCHEWKAM"."RENT" ADD CONSTRAINT "RENT_CAR_FK" FOREIGN KEY ("CAR_ID")
	  REFERENCES "G2_MARCHEWKAM"."CAR" ("CAR_ID") ENABLE;
 
  ALTER TABLE "G2_MARCHEWKAM"."RENT" ADD CONSTRAINT "RENT_CLIENT_FK" FOREIGN KEY ("CLIENT_ID")
	  REFERENCES "G2_MARCHEWKAM"."CLIENT" ("CLIENT_ID") ENABLE;
