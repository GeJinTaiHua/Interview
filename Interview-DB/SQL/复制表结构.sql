#复制表（只复制结构）
SELECT * INTO tab_new FROM tab_old
WHERE 1 <> 1;-- 仅用于 SQlServer

SELECT top 0 * INTO tab_new FROM tab_old;