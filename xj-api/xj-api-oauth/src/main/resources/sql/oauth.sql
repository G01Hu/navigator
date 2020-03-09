begin
    declare
        tableExist number;
        tableName  VARCHAR(255) := 'oauth_client_details';
        dropSQL    VARCHAR(255) := 'drop table oauth_client_details';
        createSQL  VARCHAR(999) := 'create table oauth_client_details
(
    client_id               VARCHAR(255) PRIMARY KEY,
    resource_ids            VARCHAR(255),
    client_secret           VARCHAR(255),
    scope                   VARCHAR(255),
    authorized_grant_types  VARCHAR(255),
    web_server_redirect_uri VARCHAR(255),
    authorities             VARCHAR(255),
    access_token_validity   INTEGER,
    refresh_token_validity  INTEGER,
    additional_information  VARCHAR(255),
    create_time             DATE    default sysdate,
    archived                NUMBER       default ''0'',
    trusted                 NUMBER       default ''0'',
    autoapprove             VARCHAR(255) default ''false''
)';
    begin
        select count(1) into tableExist from user_tables where table_name = upper(tableName);
--      不存在 直接创建
        if tableExist = 0 then
            execute immediate createSQL;
--      存在删除后创建
        else
            execute immediate dropSQL;
            execute immediate createSQL;
        end if;
    end;
end;

begin
    declare
        tableExist number;
        tableName  VARCHAR(255) := 'oauth_access_token';
        dropSQL    VARCHAR(255) := 'drop table oauth_access_token';
        createSQL  VARCHAR(999) := 'create table oauth_access_token
(
    create_time       DATE default sysdate,
    token_id          VARCHAR(255),
    token             BLOB,
    authentication_id VARCHAR(255) UNIQUE,
    user_name         VARCHAR(255),
    client_id         VARCHAR(255),
    authentication    BLOB,
    refresh_token     VARCHAR(255)
)';
    begin
        select count(1) into tableExist from user_tables where table_name = upper(tableName);
--      不存在
        if tableExist = 0 then
            execute immediate createSQL;
--      存在删除后创建
        else
            execute immediate dropSQL;
            execute immediate createSQL;
        end if;
    end;
end;
begin
    declare
        tableExist number;
        tableName  VARCHAR(255) := 'oauth_refresh_token';
        dropSQL    VARCHAR(255) := 'drop table oauth_refresh_token';
        createSQL  VARCHAR(999) := 'create table oauth_refresh_token
(
    create_time    DATE default sysdate,
    token_id       VARCHAR(255),
    token          BLOB,
    authentication BLOB
)';
    begin
        select count(1) into tableExist from user_tables where table_name = upper(tableName);
--      不存在
        if tableExist = 0 then
            execute immediate createSQL;
--      存在删除后创建
        else
            execute immediate dropSQL;
            execute immediate createSQL;
        end if;
    end;
end;
begin
    declare
        tableExist number;
        tableName  VARCHAR(255) := 'oauth_code';
        dropSQL    VARCHAR(255) := 'drop table oauth_code';
        createSQL  VARCHAR(999) := 'create table oauth_code
(
    create_time    DATE default sysdate,
    code           VARCHAR(255),
    authentication BLOB
)';
    begin
        select count(1) into tableExist from user_tables where table_name = upper(tableName);
--      不存在
        if tableExist = 0 then
            execute immediate createSQL;
--      存在删除后创建
        else
            execute immediate dropSQL;
            execute immediate createSQL;
        end if;
    end;
end;
--

--
-- Add indexes
create index token_id_index on oauth_access_token (token_id);
create index user_name_index on oauth_access_token (user_name);
create index client_id_index on oauth_access_token (client_id);
create index refresh_token_index on oauth_access_token (refresh_token);

create index refresh_id_index on oauth_refresh_token (token_id);

create index code_index on oauth_code (code);