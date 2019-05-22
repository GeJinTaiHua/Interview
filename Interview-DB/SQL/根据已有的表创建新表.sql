# 根据已有的表创建新表
CREATE TABLE tab_new LIKE tab_old;

CREATE TABLE tab_new AS
  SELECT col1, col2…
  FROM tab_old definition only;