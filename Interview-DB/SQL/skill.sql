#根据已有的表创建新表
CREATE TABLE tab_new LIKE tab_old;

CREATE TABLE tab_new AS
SELECT col1,col2 …
FROM tab_old definition only;

-- ---------------------------------------
#复制表（只复制结构）
SELECT * INTO tab_new
FROM tab_old
WHERE 1 <> 1;
-- 仅用于 SQlServer

SELECT top 0 * INTO tab_new
FROM tab_old;

-- ---------------------------------------
#删除重复记录
DELETE FROM tablename
WHERE id NOT IN ( SELECT max( id ) FROM tablename GROUP BY col1, col2,...); -- 推荐

SELECT DISTINCT * INTO temp FROM tablename;
DELETE FROM tablename;
INSERT INTO tablename SELECT * FROM temp;