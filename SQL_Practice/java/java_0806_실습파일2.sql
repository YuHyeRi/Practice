CREATE OR REPLACE PACKAGE BODY PACK_ENCRYPTION_DECRYPTION
IS
FUNCTION FUNC_ENCRYPT
(V_INPUT_STRING  IN  VARCHAR2, KEY_DATA IN  VARCHAR2:= 'java1234$!') 
RETURN RAW
IS
V_ORIGINAL_RAW RAW(64);
V_KEY_DATA_RAW RAW(64);
ENCRYTED_RAW RAW(64);

BEGIN

-- INPUT값을 RAW 타입으로 변경
V_ORIGINAL_RAW := UTL_I18N.STRING_TO_RAW(V_INPUT_STRING, 'AL32UTF8');  

--키 또한  RAW 타입으로 변경.
V_KEY_DATA_RAW := UTL_I18N.STRING_TO_RAW(KEY_DATA, 'AL32UTF8');  
ENCRYTED_RAW := DBMS_CRYPTO.ENCRYPT(
SRC => V_ORIGINAL_RAW,
TYP => DBMS_CRYPTO.DES_CBC_PKCS5,
KEY => V_KEY_DATA_RAW,
IV => NULL);
RETURN ENCRYTED_RAW;
END FUNC_ENCRYPT;

FUNCTION FUNC_DECRYPT
(V_INPUT_STRING  IN  VARCHAR2, KEY_DATA IN  VARCHAR2 := 'java1234$!') 
RETURN VARCHAR2
IS
V_KEY_DATA_RAW  RAW(64);
DECRYPTED_RAW   RAW(64);
CONVERTED_STRING  VARCHAR2(64);
BEGIN
V_KEY_DATA_RAW := UTL_I18N.STRING_TO_RAW(KEY_DATA, 'AL32UTF8');            
DECRYPTED_RAW := DBMS_CRYPTO.DECRYPT(
SRC => V_INPUT_STRING,
TYP => DBMS_CRYPTO.DES_CBC_PKCS5,
KEY => V_KEY_DATA_RAW,
IV => NULL);

CONVERTED_STRING :=  UTL_I18N.RAW_TO_CHAR(DECRYPTED_RAW, 'AL32UTF8');     
RETURN CONVERTED_STRING;
END FUNC_DECRYPT;
END PACK_ENCRYPTION_DECRYPTION;
/