create table author(
    author_id int primary key auto_increment not null,
    first_name nvarchar(30),
    last_name nvarchar(20),
    birth_day datetime
)