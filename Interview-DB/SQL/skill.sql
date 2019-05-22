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

-- ---------------------------------------
#随机取出10条数据
select top 10 * from tablename order by newid();

-- ---------------------------------------
#分组查询每组前三
select t3.id,t3.country,t3.score
from (select t1.*, (select count(*)
                    from tb_score t2
                    where t1.score<=t2.score and t1.country=t2.country) as rownum
      from tb_score t1) t3
where rownum <=3 order by country,score DESC;

select a.id,a.country,a.name,a.score
from tb_score a
where exists
(select count(*)
 from tb_score
 where country = a.country and score > a.score having Count(*) < 3)
order by a.country,score DESC;

select a.id,a.country,a.name,a.score
from tb_score a
where
  (select count(*)
   from tb_score
   where country = a.country  -- 确定分组字段
         and score > a.score   -- 排序条件
  )<3 -- 取前三条数据，可以多次修改
order by a.country,score DESC;

-- ---------------------------------------
#按数字大小排序String字段 str
SELECT * FROM  tb WHERE 1 = 1 ORDER BY -str DESC;

SELECT * FROM  tb WHERE 1 = 1 ORDER BY (str + 1);

-- ---------------------------------------
#



