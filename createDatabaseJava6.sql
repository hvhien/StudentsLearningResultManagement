
create database QL_diem_SV
go
use QL_diem_SV
go


Create table TAIKHOAN
(
	Username Char(20) NOT NULL,
	Password Nvarchar(50) NULL,
	Roles_name Nvarchar(50) NULL,
	Roles_number Integer NULL,
Primary Key (Username)
) 
go

Create table MONHOC
(
	MaMonHoc Char(20) NOT NULL,
	TenMonHoc Nvarchar(50) NULL,
	SoTinChi Integer NULL,
	HocKy Integer NULL,
Primary Key (MaMonHoc)
) 
go

Create table SINHVIEN
(
	MaSV Char(20) NOT NULL,
	MaLop Char(20) NOT NULL,
	TenSV Nvarchar(50) NULL,
	NgaySinh Text NULL,
	GioiTinh Char(10) NULL,
	DiaChi Text NULL,
	MatKhau Nvarchar(50) NULL,
Primary Key (MaSV)
) 
go

Create table DIEM
(
	MaSV Char(20) NOT NULL,
	MaMonHoc Char(20) NOT NULL,
	DiemHS1 Float NULL,
	DiemHS2 Float NULL,
	DiemThi Float NULL,
Primary Key (MaSV,MaMonHoc)
) 
go

Create table LOP
(
	MaLop Char(20) NOT NULL,
	TenLop Text NULL,
	KhoaHoc Nvarchar(50) NULL,
	MaGV Char(20) NOT NULL,
Primary Key (MaLop)
) 
go

Create table GIANGVIEN
(
	MaGV Char(20) NOT NULL,
	TenGV Text NULL,
	Email Text NULL,
	SDT Char(10) NULL,
	MatKhau Nvarchar(50) NULL,
Primary Key (MaGV)
) 
go

Create table BAOLUU_KQ
(
	MaBaoLuu Char(20) NOT NULL,
	LyDo Text NULL,
	MaSV Char(20) NOT NULL,
Primary Key (MaBaoLuu)
) 
go


Alter table DIEM add  foreign key(MaMonHoc) references MONHOC (MaMonHoc)  on update no action on delete no action 
go
Alter table DIEM add  foreign key(MaSV) references SINHVIEN (MaSV)  on update no action on delete no action 
go
Alter table BAOLUU_KQ add  foreign key(MaSV) references SINHVIEN (MaSV)  on update no action on delete no action 
go
Alter table SINHVIEN add  foreign key(MaLop) references LOP (MaLop)  on update no action on delete no action 
go
Alter table LOP add  foreign key(MaGV) references GIANGVIEN (MaGV)  on update no action on delete no action 
go


Set quoted_identifier on
go


Set quoted_identifier off
go




create trigger insert_Account_sv on SINHVIEN
for insert
as 
	insert into TAIKHOAN(Username,Password,Roles_name,Roles_number)
	select MaSV,MatKhau,'Sinh vien',1 from inserted
go
create trigger insert_Account_gv on GIANGVIEN
for insert
as 
	insert into TAIKHOAN(Username,Password,Roles_name,Roles_number)
	select MaGV,MatKhau,'Giao vien',2 from inserted
go
insert into GIANGVIEN values ('GV001',N'Dương Vũ Thị','vuthiduong@gmail.com','0123456789','duongvuthi')
go
insert into LOP values ('LOP001',N'Lập trình java','K13','GV001')
go
insert into SINHVIEN values('2018604963','LOP001',N'Hà Văn Hiển','10/12/2000','Nam',N'Hà Nam','havanhien')

select * from TAIKHOAN