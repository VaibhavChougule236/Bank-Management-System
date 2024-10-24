
drop table user;
use bank;
CREATE TABLE user (
    SR_NO INT PRIMARY KEY AUTO_INCREMENT,
    UName VARCHAR(50) NOT NULL,
    E_mail VARCHAR(50),
    Address VARCHAR(120) NOT NULL,
    Gender VARCHAR(15) NOT NULL,
    Mobile_No BIGINT NOT NULL,  
    City VARCHAR(50) NOT NULL,
    State VARCHAR(50) NOT NULL,
    Pincode INT NOT NULL,
    Qualification VARCHAR(50),
    Username VARCHAR(15) NOT NULL,
    Password VARCHAR(50) NOT NULL,  
    Religion VARCHAR(10) NOT NULL,
    Category VARCHAR(10) NOT NULL,  
    Income INT NOT NULL,
    PAN_NO VARCHAR(14) NOT NULL,
    Occupation VARCHAR(20) NOT NULL,
    Adhar_Number VARCHAR(12)
);

UPDATE user
SET BankId = 'BOJP01'
where SR_NO is not null; 

ALTER TABLE user
ADD COLUMN BankId varchar(14)
AFTER SR_NO;

DESCRIBE user;

SET SQL_SAFE_UPDATES = 0;

ALTER TABLE user
ADD COLUMN Amount Double default 00.0000 
AFTER Password;

ALTER TABLE user
ADD COLUMN dob date 
AFTER Gender;

-- Add AccountCreated column
ALTER TABLE user
ADD COLUMN AccountCreated TIMESTAMP DEFAULT CURRENT_TIMESTAMP 
AFTER BankId;

-- Add AccountUpdated column
ALTER TABLE user
ADD COLUMN AccountUpdated TIMESTAMP DEFAULT CURRENT_TIMESTAMP 
AFTER AccountCreated;


ALTER TABLE  user
CHANGE AccNo AccNo VARCHAR(20);

select * from user;

UPDATE user
SET AccNo = '5040510026061001'
WHERE Username='Vaibhav';

UPDATE user
SET Amount=1000
WHERE Username='Vaibhav';


ALTER TABLE user
ADD CONSTRAINT unique_user_credentials UNIQUE (Username, Password);


DELETE FROM user
WHERE SR_NO NOT IN (1, 2, 3);


CREATE TABLE documents (
    Document_ID INT PRIMARY KEY AUTO_INCREMENT,
    Username VARCHAR(15),
    Password VARCHAR(50),
    Photo LONGBLOB,
    PanCard LONGBLOB,
    AdharCard LONGBLOB,
    FOREIGN KEY (Username, Password) REFERENCES user(Username, Password) On delete restrict
);

select * from documents;
drop table documents;
ALTER TABLE user 
CHANGE  Mobile_No  Mobile_No VARCHAR(12);
delete  from documents where Document_ID=1;
SELECT Photo FROM documents WHERE Username = 'Rav';
truncate table documents;

CREATE TABLE money_transition_history (
    Transaction_id SERIAL PRIMARY KEY,           
    SenderAccNo varchar(20) NOT NULL,                        
    ReceiverAccNo varchar(20) NOT NULL,                    
    Amount DOUBLE NOT NULL,                     
    Date_Time TIMESTAMP DEFAULT CURRENT_TIMESTAMP                     
);

ALTER TABLE money_transition_history
ADD COLUMN Sender_Name varchar(50)
AFTER Transaction_id;

ALTER TABLE money_transition_history
ADD COLUMN Receiver_Name varchar(50)
AFTER SenderAccNo;

ALTER TABLE money_transition_history
MODIFY COLUMN SenderAccNo VARCHAR(30),
MODIFY COLUMN ReceiverAccNo VARCHAR(30);


insert into money_transition_history values(1,'515135156','545544668',555.0,'2024-10-03 15:30:00');
Drop TABLE money_transition_history;
select * from money_transition_history;


-- create table totalBalance(
-- Username VARCHAR(15),
--     Password VARCHAR(50),
--     Amount Double default 00.0000 ,
--     FOREIGN KEY (Username, Password) REFERENCES user(Username, Password)
--     );
--     insert into totalBalance values('vaibhav',1245,500);
--     
--     select * from totalBalance;
--     drop table totalBalance;

delete  from user where BankId is null;