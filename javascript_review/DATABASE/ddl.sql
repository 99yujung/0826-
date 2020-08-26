create user jsp identified by jsp;
grant resource, connect to jsp;

create table member (
id 		varchar2(20),
pw		varchar2(20),
gender  varchar2(3), 
job		varchar2(20),
reason	varchar2(500),
mailyn  varchar2(3),
primary key (id)
);

insert into member(id,pw,gender,job,reason,mailyn) values('user1','남','program',null,'yes')
insert into member(id,pw,gender,job,reason,mailyn) values('user1','남','program',null,'yes')






create table board (
	no 		  number primary key, 
	poster    varchar2(20),   -- 작성자
	subject   varchar2(100),  -- 제목           ins
	contents  varchar2(2000), -- 내용           ins
	lastpost  date,           -- 작성일자      ins
	views     number(5)       -- 조회수
	filename  varchar2(50)    -- 첨부파일      ins
);

	
	