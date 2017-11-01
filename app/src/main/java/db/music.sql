DROP TABLE artists;
DROP TABLE albums;

CREATE TABLE artists (
  ID INTEGER PRIMARY KEY AUTOINCREMENT,
  name VARCHAR(50)
);

CREATE TABLE albums (
  ID INTEGER primary key AUTOINCREMENT,
  title VARCHAR(50),
  genre VARCHAR(50),
  artist_id INTEGER references artists(id)
);