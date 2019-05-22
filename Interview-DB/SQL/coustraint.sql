#主键约束
alter table stuInfo
add constraint PK_stuNo primary key (stuNo);

-- ---------------------------------------
#唯一约束
alter table stuInfo
add constraint UQ_stuID unique(stuID);

-- ---------------------------------------
#检查约束
alter table stuInfo
add constraint CK_stuAge check (stuAge between 15 and 40);

-- ---------------------------------------
#默认约束
alter table stuInfo
add constraint DF_stuAddress default ('地址不详') for stuAddress;

-- ---------------------------------------
#外键约束
alter table stuInfo
add constraint FK_stuNo foreign key(stuNo)references stuinfo(stuNo);



