CREATE TABLE IF NOT EXISTS contact(
  id integer PRIMARY KEY AUTOINCREMENT,
  name text,
  birth text,
  email text,
  phone text,
  address text,
  organization text,
  position text
);

insert into contact(name, birth, email, phone, address, organization, position) values ('Walter White', '11-03-1970', 'walterwhite@gmail.com', '6565989865', 'NM Albuquerque Lincoln st. 34.', 'Blue Meth Lab', 'senior laborant');
