create database Top3Results;
create table _2006(
States varchar(20),
Population int);
create table _2007(
States varchar(20),
Population int);
create table _2008(
States varchar(20),
Population int);
create table _2009(
States varchar(20),
Population int);
create table _2010(
States varchar(20),
Population int);
create table _2011(
States varchar(20),
Population int);
create table _2012(
States varchar(20),
Population int);
insert into _2006 select accidents.States, accidents.`2006` from first_db.accidents order by accidents.`2006` desc limit 3;
insert into _2007 select accidents.States, accidents.`2007` from first_db.accidents order by accidents.`2007` desc limit 3;
insert into _2008 select accidents.States, accidents.`2008` from first_db.accidents order by accidents.`2008` desc limit 3;
insert into _2009 select accidents.States, accidents.`2009` from first_db.accidents order by accidents.`2009` desc limit 3;
insert into _2010 select accidents.States, accidents.`2010` from first_db.accidents order by accidents.`2010` desc limit 3;
insert into _2011 select accidents.States, accidents.`2011` from first_db.accidents order by accidents.`2011` desc limit 3;
insert into _2012 select accidents.States, accidents.`2012` from first_db.accidents order by accidents.`2012` desc limit 3;
