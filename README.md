# Java_spring_boot
##Step 1
start with making mariadb user database,
<details>
```create table rpdd_user_list(
      id INTEGER NOT NULL ,
      ADD active BOOL NOT NULL,
      login INT(10) PRIMARY KEY,
      password VARCHAR(10) NOT NULL,
      grp TINYINT(2) NOT NULL,
      ADD UNIQUE(id));
      ```
</details>

| Field    | Type        | Null | Key | Default | Extra |
|----------|-------------|------|-----|---------|-------|
| id       | int(11)     | NO   | UNI | NULL    |       |
| active   | tinyint(1)  | NO   |     | NULL    |       |
| login    | int(10)     | NO   | PRI | NULL    |       |
| password | varchar(10) | NO   |     | NULL    |       |
| grp      | tinyint(2)  | NO   |     | NULL    |       |
|----------|-------------|------|-----|---------|-------|


login will act as loginID and ID to count on the users or perform any future task if needed.
'active' was taken BOOL , will use it to check if there's any user active or not.
'grp' , to group users for NoSQL and SQL , equals to 1 and 2 respectively.

adding a few values,


| id | active | login | password | grp |
|----|--------|-------|----------|-----|
|  1 |      0 |     1 | one      |   2 |
|  2 |      0 |     2 | two      |   1 |
|----|--------|-------|----------|-----|


using spring initliazer to create initial project file.


