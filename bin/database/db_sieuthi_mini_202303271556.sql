--
-- Script was generated by Devart dbForge Studio 2020 for MySQL, Version 9.0.338.0
-- Product home page: http://www.devart.com/dbforge/mysql/studio
-- Script date 3/27/2023 3:56:56 PM
-- Server version: 10.4.27
-- Client version: 4.1
--

-- 
-- Disable foreign keys
-- 
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;

-- 
-- Set SQL mode
-- 
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

--
-- Set default database
--
USE db_sieuthi_mini;

--
-- Drop table `coupon_orders`
--
DROP TABLE IF EXISTS coupon_orders;

--
-- Drop table `coupon`
--
DROP TABLE IF EXISTS coupon;

--
-- Drop table `order_detail`
--
DROP TABLE IF EXISTS order_detail;

--
-- Drop table `orders`
--
DROP TABLE IF EXISTS orders;

--
-- Drop table `customer`
--
DROP TABLE IF EXISTS customer;

--
-- Drop table `discount_category`
--
DROP TABLE IF EXISTS discount_category;

--
-- Drop table `discount_product`
--
DROP TABLE IF EXISTS discount_product;

--
-- Drop table `import_detail`
--
DROP TABLE IF EXISTS import_detail;

--
-- Drop table `product`
--
DROP TABLE IF EXISTS product;

--
-- Drop table `category_product`
--
DROP TABLE IF EXISTS category_product;

--
-- Drop table `import_product`
--
DROP TABLE IF EXISTS import_product;

--
-- Drop table `suppilier`
--
DROP TABLE IF EXISTS suppilier;

--
-- Drop table `account`
--
DROP TABLE IF EXISTS account;

--
-- Drop table `role`
--
DROP TABLE IF EXISTS role;

--
-- Set default database
--
USE db_sieuthi_mini;

--
-- Create table `role`
--
CREATE TABLE role (
  role_id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(50) DEFAULT NULL,
  status tinyint(1) DEFAULT 1,
  PRIMARY KEY (role_id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 10,
AVG_ROW_LENGTH = 3276,
CHARACTER SET utf8mb4,
COLLATE utf8mb4_general_ci;

--
-- Create table `account`
--
CREATE TABLE account (
  account_id int(11) NOT NULL AUTO_INCREMENT,
  account_name varchar(255) NOT NULL DEFAULT '',
  password varchar(255) DEFAULT NULL,
  first_name varchar(255) DEFAULT NULL,
  last_name varchar(255) DEFAULT NULL,
  phone varchar(255) DEFAULT NULL,
  birth_date date DEFAULT NULL,
  address varchar(255) DEFAULT NULL,
  gender varchar(255) DEFAULT NULL,
  status tinyint(1) DEFAULT 1,
  role_id int(11) DEFAULT NULL,
  PRIMARY KEY (account_id, account_name),
  UNIQUE INDEX UK_account_account_id (account_id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 9,
AVG_ROW_LENGTH = 2048,
CHARACTER SET utf8mb4,
COLLATE utf8mb4_general_ci;

--
-- Create foreign key
--
ALTER TABLE account
ADD CONSTRAINT FK_account_role_id FOREIGN KEY (role_id)
REFERENCES role (role_id) ON DELETE NO ACTION;

--
-- Create table `suppilier`
--
CREATE TABLE suppilier (
  suppilier_id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(250) DEFAULT NULL,
  address varchar(255) DEFAULT NULL,
  phone varchar(20) DEFAULT NULL,
  status tinyint(1) DEFAULT 1,
  PRIMARY KEY (suppilier_id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 8,
AVG_ROW_LENGTH = 8192,
CHARACTER SET utf8mb4,
COLLATE utf8mb4_general_ci;

--
-- Create table `import_product`
--
CREATE TABLE import_product (
  import_id int(11) NOT NULL,
  date date DEFAULT curdate(),
  suppilier_id int(11) DEFAULT NULL,
  account_id int(11) DEFAULT NULL,
  status int(11) DEFAULT 1,
  PRIMARY KEY (import_id)
)
ENGINE = INNODB,
AVG_ROW_LENGTH = 5461,
CHARACTER SET utf8mb4,
COLLATE utf8mb4_general_ci;

--
-- Create foreign key
--
ALTER TABLE import_product
ADD CONSTRAINT FK_import_product_account_id FOREIGN KEY (account_id)
REFERENCES account (account_id) ON DELETE NO ACTION;

--
-- Create foreign key
--
ALTER TABLE import_product
ADD CONSTRAINT FK_import_product_suppilier_id FOREIGN KEY (suppilier_id)
REFERENCES suppilier (suppilier_id) ON DELETE NO ACTION;

--
-- Create table `category_product`
--
CREATE TABLE category_product (
  category_id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(200) NOT NULL,
  name_code varchar(200) NOT NULL,
  status tinyint(1) DEFAULT 1,
  PRIMARY KEY (category_id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 25,
AVG_ROW_LENGTH = 712,
CHARACTER SET utf8mb4,
COLLATE utf8mb4_general_ci;

--
-- Create table `product`
--
CREATE TABLE product (
  product_id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(300) NOT NULL,
  description text DEFAULT NULL,
  price double NOT NULL,
  img varchar(255) NOT NULL DEFAULT '',
  mass varchar(200) NOT NULL,
  trademark varchar(200) DEFAULT NULL,
  cate_id int(11) NOT NULL,
  quantity int(11) UNSIGNED NOT NULL,
  status tinyint(4) NOT NULL DEFAULT 1,
  createAt date DEFAULT curdate(),
  expire_date date DEFAULT NULL,
  PRIMARY KEY (product_id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 52,
AVG_ROW_LENGTH = 2730,
CHARACTER SET utf8mb4,
COLLATE utf8mb4_general_ci;

--
-- Create foreign key
--
ALTER TABLE product
ADD CONSTRAINT FK_product_cate_id FOREIGN KEY (cate_id)
REFERENCES category_product (category_id) ON DELETE NO ACTION;

--
-- Create table `import_detail`
--
CREATE TABLE import_detail (
  id int(11) NOT NULL AUTO_INCREMENT,
  import_id int(11) DEFAULT NULL,
  product_id int(11) DEFAULT NULL,
  quantity int(11) DEFAULT NULL,
  price decimal(19, 2) DEFAULT NULL,
  status tinyint(1) DEFAULT 1,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 7,
AVG_ROW_LENGTH = 5461,
CHARACTER SET utf8mb4,
COLLATE utf8mb4_general_ci;

--
-- Create foreign key
--
ALTER TABLE import_detail
ADD CONSTRAINT FK_import_detail_import_id FOREIGN KEY (import_id)
REFERENCES import_product (import_id) ON DELETE NO ACTION;

--
-- Create foreign key
--
ALTER TABLE import_detail
ADD CONSTRAINT FK_import_detail_product_id FOREIGN KEY (product_id)
REFERENCES product (product_id) ON DELETE NO ACTION;

--
-- Create table `discount_product`
--
CREATE TABLE discount_product (
  id int(11) NOT NULL AUTO_INCREMENT,
  product_id int(11) DEFAULT NULL,
  discount_value float DEFAULT NULL,
  valid_date date DEFAULT NULL,
  expire_date date DEFAULT NULL,
  status tinyint(1) DEFAULT 1,
  `desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 3,
AVG_ROW_LENGTH = 8192,
CHARACTER SET utf8mb4,
COLLATE utf8mb4_general_ci;

--
-- Create foreign key
--
ALTER TABLE discount_product
ADD CONSTRAINT FK_discount_product_product_id FOREIGN KEY (product_id)
REFERENCES product (product_id) ON DELETE NO ACTION;

--
-- Create table `discount_category`
--
CREATE TABLE discount_category (
  id int(11) NOT NULL AUTO_INCREMENT,
  category_id int(11) DEFAULT NULL,
  discount_value float DEFAULT NULL,
  valid_date date DEFAULT NULL,
  expire_date date DEFAULT NULL,
  status tinyint(1) DEFAULT 1,
  `desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
CHARACTER SET utf8mb4,
COLLATE utf8mb4_general_ci;

--
-- Create foreign key
--
ALTER TABLE discount_category
ADD CONSTRAINT FK_discount_category_category_id FOREIGN KEY (category_id)
REFERENCES category_product (category_id) ON DELETE NO ACTION;

--
-- Create table `customer`
--
CREATE TABLE customer (
  customer_id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(250) DEFAULT NULL,
  phone varchar(255) DEFAULT NULL,
  gender varchar(255) DEFAULT NULL,
  birth_date date DEFAULT NULL,
  address varchar(255) DEFAULT NULL,
  status tinyint(1) DEFAULT 1,
  PRIMARY KEY (customer_id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 11,
AVG_ROW_LENGTH = 1638,
CHARACTER SET utf8mb4,
COLLATE utf8mb4_general_ci;

--
-- Create table `orders`
--
CREATE TABLE orders (
  order_id int(11) NOT NULL AUTO_INCREMENT,
  account_id int(11) DEFAULT NULL,
  order_date date NOT NULL DEFAULT curdate(),
  customer_id int(11) DEFAULT NULL,
  status varchar(255) DEFAULT '1',
  PRIMARY KEY (order_id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 9,
AVG_ROW_LENGTH = 6553,
CHARACTER SET utf8mb4,
COLLATE utf8mb4_general_ci;

--
-- Create foreign key
--
ALTER TABLE orders
ADD CONSTRAINT FK_orders_account_id FOREIGN KEY (account_id)
REFERENCES account (account_id) ON DELETE NO ACTION;

--
-- Create foreign key
--
ALTER TABLE orders
ADD CONSTRAINT FK_orders_customer_id FOREIGN KEY (customer_id)
REFERENCES customer (customer_id) ON DELETE NO ACTION;

--
-- Create table `order_detail`
--
CREATE TABLE order_detail (
  order_det_id int(11) NOT NULL AUTO_INCREMENT,
  order_id int(11) DEFAULT NULL,
  product_id int(11) DEFAULT NULL,
  price decimal(19, 2) DEFAULT NULL,
  quantity int(11) DEFAULT NULL,
  status tinyint(1) DEFAULT 1,
  PRIMARY KEY (order_det_id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 18,
AVG_ROW_LENGTH = 4096,
CHARACTER SET utf8mb4,
COLLATE utf8mb4_general_ci;

--
-- Create foreign key
--
ALTER TABLE order_detail
ADD CONSTRAINT FK_order_detail_order_id FOREIGN KEY (order_id)
REFERENCES orders (order_id) ON DELETE NO ACTION;

--
-- Create foreign key
--
ALTER TABLE order_detail
ADD CONSTRAINT FK_order_detail_product_id FOREIGN KEY (product_id)
REFERENCES product (product_id) ON DELETE NO ACTION;

--
-- Create table `coupon`
--
CREATE TABLE coupon (
  coupon_id int(11) NOT NULL AUTO_INCREMENT,
  code_name varchar(255) DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  value float DEFAULT NULL,
  expire_date date DEFAULT NULL,
  quantity float DEFAULT NULL,
  status tinyint(1) DEFAULT 1,
  PRIMARY KEY (coupon_id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 6,
AVG_ROW_LENGTH = 16384,
CHARACTER SET utf8mb4,
COLLATE utf8mb4_general_ci;

--
-- Create table `coupon_orders`
--
CREATE TABLE coupon_orders (
  id int(11) NOT NULL AUTO_INCREMENT,
  order_id int(11) DEFAULT NULL,
  coupon_id int(11) DEFAULT NULL,
  status tinyint(1) DEFAULT 1,
  applied_date date DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
CHARACTER SET utf8mb4,
COLLATE utf8mb4_general_ci;

--
-- Create foreign key
--
ALTER TABLE coupon_orders
ADD CONSTRAINT FK_coupon_orders_coupon_id FOREIGN KEY (coupon_id)
REFERENCES coupon (coupon_id) ON DELETE NO ACTION;

--
-- Create foreign key
--
ALTER TABLE coupon_orders
ADD CONSTRAINT FK_coupon_orders_order_id FOREIGN KEY (order_id)
REFERENCES orders (order_id) ON DELETE NO ACTION;

-- 
-- Dumping data for table role
--
INSERT INTO role VALUES
(1, 'admin', NULL),
(2, 'quản lý', NULL),
(3, 'thu ngân', NULL),
(4, 'bán hàng', NULL),
(5, 'kế toán', NULL);

-- 
-- Dumping data for table suppilier
--
INSERT INTO suppilier VALUES
(1, 'Nh? cung c?p 1', 'HCM, Vi?t Name', '0123456789', 1),
(2, 'Nh? cung c?p 2', 'Th?i Lan', '0123131279', 1),
(3, 'Nh? cung c?p 3', 'M?', '0123412344', 1),
(4, 'Nh? cung c?p 4', 'L?o', '0142894624', 1),
(5, 'Nh? cung c?p 5', 'HCM, Vi?t Name', '0719312312', 1),
(6, 'Nh? cung c?p 6', 'HCM, Vi?t Name', '0191319202', 1),
(7, 'Nh? cung c?p 7', 'HCM, Vi?t Name', '0127837091', 1);

-- 
-- Dumping data for table category_product
--
INSERT INTO category_product VALUES
(1, 'Mì, hủ tiếu, phở gói', 'mi-hu-tieu-pho', 1),
(2, 'Gia Vị - Nguyên Liệu Nấu Ăn', 'gia-vi', 1),
(3, 'Gạo các loại', 'cac-loai-gao', 1),
(4, 'Đồ hộp các loại', 'do-dong-hop', 1),
(5, 'Rau lá', 'rau-sach', 1),
(6, 'Củ, quả', 'cu-qua', 1),
(7, 'Trái cây', 'trai-cay', 1),
(8, 'Thịt các loại', 'thit-cac-loai', 1),
(9, 'Cá, hải sản', 'ca-tom-muc-ech', 1),
(10, 'Bia', 'bia', 1),
(11, 'Nước ngọt', 'nuoc-ngot', 1),
(12, 'Bánh Snake', 'banh', 1),
(13, 'Nước giặt', 'nuoc-giat', 1),
(14, 'Nồi, niêu, xoong, chảo', 'noi-chao', 1);

-- 
-- Dumping data for table customer
--
INSERT INTO customer VALUES
(1, 'Tuấn Kiệt', '0123456789', 'nam', '2000-01-01', 'Hồ Chí Minh', 1),
(2, 'Quốc Lâm', '0723470234', 'nam', '1999-03-01', 'Dak Lak', 1),
(3, 'Nguyễn Tuấn Phát', '0123131237', 'nam', '2005-01-01', 'Hồ Chí Minh', 1),
(4, 'Nguyễn Minh Sang', '0843240033', 'nam', '2007-11-01', 'Đồng Nai', 1),
(5, 'Hồ Văn Sơn', '0123123787', 'nam', '1997-01-12', 'Long An', 1),
(6, 'Vân Anh', '0134237479', 'nu', '1987-01-12', 'Bình Dương', 1),
(7, 'Nguyễn Ngọc Như Lan', '0734237472', 'nu', '0000-00-00', 'Hà Nội', 1),
(8, 'Nguyễn Thanh Nam', '0234237940', 'nam', '1999-01-01', 'Cà Mau', 1),
(9, 'Nguyễn Xuân Trường', '0234234424', 'nam', '2002-02-02', 'Hồ Chí Minh', 1),
(10, 'Ngọc Mỹ', '0922384780', 'nu', '2003-09-09', 'Lâm Đồng', 1);

-- 
-- Dumping data for table account
--
INSERT INTO account VALUES
(1, 'admin1', '123', 'Bình', 'Nguyễn Văn', '0123456789', '2000-01-22', 'Thủ Đức, HCM', 'nam', 1, 1),
(2, 'teo123', '123', 'Tèo', 'Nguyễn Văn Tèo', '0987654321', '2001-03-22', 'Q5, HCM', 'nam', 1, 2),
(3, 'tam', '123', 'Tâm', 'Nguyễn Minh', '0412393123', '2023-05-01', 'Q5, HCM', 'nu', 1, 3),
(4, 'thien', '123', 'Thiện', 'Trần Minh', '0831223123', '1999-01-01', 'Q5, HCM', 'nam', 1, 4),
(5, 'anh', '123', 'Anh', 'Nguyễn Tuấn', '0691232731', '1995-10-01', 'Q5, HCM', 'nam', 1, 5),
(6, 'lan', '123', 'Lan', 'Lê Ngọc', '0612381239', '2001-01-10', 'Q5, HCM', 'nu', 1, 1),
(7, 'tung', '123', 'Tùng', 'Nguyen', '0123455678', '2000-01-01', 'LA', 'nam', 1, 2),
(8, 'dung', '123333333', 'Dũng', 'Chris', '0112334234', '1999-11-01', 'HCM', 'nu', 1, 5);

-- 
-- Dumping data for table import_product
--
INSERT INTO import_product VALUES
(1, '2023-02-25', 1, 1, 1),
(2, '2023-02-25', 2, 2, 1);

-- 
-- Dumping data for table product
--
INSERT INTO product VALUES
(1, 'Thùng 30 gói mì Hảo Hảo tôm chua cay 75g', 'Sợi mì vàng dai ngon hòa quyện trong nước súp tôm chua cay Hảo Hảo, đậm đà thấm đẫm từng sợi sóng sánh cùng hương thơm quyến rũ ngất ngây. Mì Hảo Hảo tôm chua cay gói 75g là lựa chọn hấp dẫn không thể bỏ qua đặc biệt là những ngày bận rộn cần bổ sung năng lượng nhanh chóng đơn giản mà vẫn đủ chất', 118000, 'thung-30-goi-mi-hao-hao-tom-chua-cay-75g-202110110920304347.jpg', '75g / gói', 'Hảo Hảo (Việt Nam)', 1, 10, 1, '2023-02-23', '2024-01-01'),
(2, 'Thùng 30 gói mì 3 Miền tôm chua cay 65g', 'Sở hữu nét đậm đà chuẩn hương vị truyền thống. Mì 3 Miền tôm chua cay gói 65g có được vị chua cay từ quá trình tìm tòi cũng như chắt lọc các nét đặc trưng nhất của các món chua cay dọc 3 miền tổ quốc. Để rồi thành phẩm mang đến cho người tiêu dùng hương vị tinh tế nhất và tuyệt hảo nhất', 89000, 'thung-30-goi-mi-3-mien-tom-chua-cay-65g-202211181138546073.jpg', '65g / gói', '3 Miền (Việt Nam)', 1, 10, 1, '2023-02-23', '2024-01-01'),
(3, 'Thùng 30 gói hủ tiếu Nam Vang Cung Đình 78g', 'Hủ tiếu ăn liền là bữa ăn cực tiện lợi và thơm ngon. 30 gói hủ tiếu Nam Vang Cung Đình 78g chính hãng hủ tiếu Cung Đình hương vị Nam Vang đặc trưng thấm đều trong từng sợi hủ tiếu dai ngon đậm đà cực đã cùng mùi hương hấp dẫn lôi cuốn không thể chối từ', 288000, 'thung-30-goi-hu-tieu-nam-vang-cung-dinh-78g-202008181316023474.jpg', '78g / gói', 'Cung Đình (Việt Nam)', 1, 10, 1, '2023-02-23', '2024-01-01'),
(4, 'Thùng 30 gói mì khoai tây Omachi xốt bò hầm 80g', 'Sợi mì từ trứng và khoai tây vàng dai ngon hòa trong nước súp Omachi xốt bò hầm đậm đà cùng hương thơm nứt mũi tạo ra siêu phẩm mì với sự kết hợp hương vị hài hòa, độc đáo. 30 gói mì khoai tây Omachi xốt bò hầm 80g tiện lợi, thơm ngon hấp dẫn không thể chối từ', 252000, 'thung-30-goi-mi-khoai-tay-omachi-xot-bo-ham-80g-201912081340008681.jpg', '65g / gói', 'Omachi (Việt Nam)', 1, 10, 1, '2023-02-23', '2024-01-01'),
(6, 'Bánh gạo cắt lát tokpokki Matamun gói 600g', 'Bánh gạo dạng gói chất lượng, dai ngon từ thương hiệu bánh gạo Matamun được sản xuất tại Hàn Quốc. Bánh gạo cắt lát tokpokki Matamun 600g tiện lợi cho bạn trổ tài sáng tạo chế biến các món ăn hấp dẫn như sốt cay, sốt phô mi, nấu lẩu,...Sản phẩm cam kết chính hãng và an toàn', 56000, 'banh-gao-cat-lat-tokpokki-matamun-goi-600g-202010311338517634.jpg', '600g/gói', 'Matamun (Hàn Quốc)', 12, 10, 1, '2023-02-23', '2024-01-01'),
(7, 'Thùng 30 gói bún giò heo Hằng Nga 75g', 'Sản phẩm bún ăn liền thương hiệu Hằng Nga được sản xuất từ các thành phần tự nhiên an toàn cho khỏe. 30 gói bún giò heo Hằng Nga 75g chất lượng thơm ngon với nước súp giò heo cực đậm đà và hấp dẫn cho bạn bữa ăn nhanh tiện lợi và dinh dưỡng', 260000, 'bun-gio-heo-hang-nga-goi-75g-thung-30-3-org.jpg', '75g', 'Hằng Nga (Việt Nam)', 1, 10, 1, '2023-02-23', '2024-01-01'),
(8, 'Thùng 24 lon bia Heineken Silver 330ml', 'Bia thơm ngon chất lượng chính hãng thương hiệu bia được ưa chuộng tại hơn 192 quốc gia trên thế giới đến từ Hà Lan - bia Heineken. 24 lon Heineken Silver 330ml thơm ngon hương vị bia tuyệt hảo, cân bằng và êm dịu, thiết kế đẹp mắt, cho người dùng cảm giác sang trọng, nâng tầm đẳng cấp.', 440000, 'thung-24-lon-bia-heineken-silver-330ml-202205111635132939.jpg', '330ml', 'Bảo quản nơi sạch sẽ, khô ráo thoáng mát Tránh ánh nắng mặt trời Tránh bị đông đá', 10, 10, 1, '2023-02-23', '2024-01-01'),
(16, 'Quýt giống Úc túi 1kg (5 - 9 trái)', 'Quýt Úc là trái cây có màu vàng ươm, quả hơi dẹp, trên vỏ quýt có các đốm tinh dầu to bóng. Quýt ngon, ngọt nhất khi trái hơi dẹt, cuống còn tươi, màu sáng đều. Quýt Úc tại Bách hóa XANH được trồng tại Trung Quốc chất lượng, tươi ngon', 640000, 'quyt-giong-uc-tui-1kg-5-9-trai-202205130905285767.jpg', '1kg', 'Quýt Úc', 7, 10, 1, '2023-03-01', '2024-01-01'),
(17, 'Nước giặt Surf hương nước hoa túi 3 lít', 'Surf là sản phẩm nước giặt thương hiệu đến từ Hà Lan và Anh, nước giặt Surf giúp sạch nhanh hiệu quả, đưa hương thơm lan toả dù ngày nắng hay mưa, giúp bạn tự tin với quần áo luôn thơm tho, sạch sẽ. Nước giặt Surf hương nước hoa túi 3 lít với hương cỏ hoa thơm mát dễ chịu.', 106000, 'nuoc-giat-surf-huong-nuoc-hoa-tui-3-lit-202204191521510721.png', '1kg', 'Surf (Anh và Hà Lan)', 13, 10, 1, '2023-03-17', '2024-01-01'),
(18, 'Nồi nhật nhôm Kim Hằng KHG9587 30cm', 'Bộ nồi bằng nhôm cao cấp,  bề mặt được xử lý theo công nghệ xi dương cực giúp nồi bền, sử dụng lâu và nấu thức ăn ngon hơn. Nồi nhật nhôm Kim Hằng KHG9587 30cm tiện lợi, có thể sử dụng cho bếp ga và bếp hồng ngoại. Nồi Kim Hằng chất lượng cao.', 360000, 'noi-nhat-nhom-kim-hang-khg9587-30cm-202108041419171460.jpg', '10.7 lít', 'Kim Hằng', 14, 10, 1, '2023-03-17', '2025-01-01'),
(19, 'Chảo bầu quantum chống dính Kim Hằng 36cm', 'Chảo làm bằng hợp kim nhôm tinh chất, giúp chảo bền, sử dụng tiện lợi chống dính và dễ vệ sinh. Chảo bầu quantum chống dính Kim Hằng 36cm chất lượng giúp nấu các món ăn trở nên thơm ngon và hấp dẫn. Chảo Kim Hằng chất lượng, tiện lợi', 312000, 'chao-bau-quantum-chong-dinh-kim-hang-36cm-202108030917190424.jpg', '36cm', 'Kim Hằng', 14, 10, 1, '2023-03-17', '2025-01-01'),
(20, 'Chảo chống dính đáy từ HappyCall Titanium 26cm', 'Chảo chống dính HappyCall được sản xuất từ chất liệu nhôm, thép không gỉ, chống móp méo tốt. Đáy chảo phẳng, tỏa nhiệt đều và giữ nhiệt lâu khi nấu. Chảo chống dính đáy từ HappyCall Titanium 26cm có tay cầm cách nhiệt an toàn, có lỗ treo tiện lợi.', 410000, 'chao-chong-dinh-day-tu-happycall-titanium-26cm-202107310901356076.jpg', '26cm', 'HappyCall', 14, 10, 1, '2023-03-17', '2025-01-01'),
(21, 'Khuôn bò bít tết nhôm Kim Hằng ADC', 'Chảo Kim Hằng được thiết kế nhỏ gọn, có khả năng làm nóng nhanh, khuôn giữ nhiệt tốt, giúp chế biến món trứng ốp la, bò bít tết nhanh chóng và thơm ngon hơn. Khuôn bò bít tết nhôm Kim Hằng ADC được làm từ chất liệu nhôm cao cấp, bền bỉ và an toàn cho sức khoẻ.', 304000, 'khuon-bo-bit-tech-nhom-kim-hang-adc-202108071010422453.jpg', '14inch', 'Kim Hằng', 14, 10, 1, '2023-03-17', '2025-01-01'),
(22, 'Khuôn bò bít tết nhôm Kim Hằng ADC', 'Có đường kính 18cm, thành cao, có thể chiên xào với một lượng thức ăn nhiều. Chảo được làm bằng chất liệu gang cực bền bỉ, dễ dàng sử dụng, vệ sinh. Chảo gang chống dính Tuyết Mai 18cm giúp truyền nhiệt nhanh, thức ăn chín đều. Cán chảo Tuyết Mai cách nhiệt hiệu quả, chắc chắn nếu cần di chuyển', 280000, 'chao-gang-chong-dinh-tuyet-mai-18cm-202202161309570230.jpg', '18cm', 'Tuyết Mai', 14, 10, 1, '2023-03-17', '2025-01-01'),
(23, 'Gạo thơm A An ST24 túi 5kg', 'Là loại gạo mềm thơm, giống gạo ST24 của thương hiệu gạo A An được trồng theo công nghệ hiện đại, tiên tiến không sử dụng chất kích thích tăng trưởng, mang đến cho bạn bữa cơm ngon miệng. Gạo thơm A An ST24 túi 5kg dẻo nhiều, cơm nhiều nhưng nở ít tạo cảm giác ngon miệng khi ăn.', 119000, 'gao-thom-a-an-st24-tui-5kg-202204021021313013.jpg', '5kg', 'A An', 3, 10, 1, '2023-03-17', '2025-01-01'),
(24, 'Gạo thơm Vua Gạo ST25 Lúa Tôm túi 5kg', 'Gạo thơm Vua Gạo ST25 Lúa Tôm túi 5kg là loại gạo thơm ngon, có độ dẻo và mềm đặc biệt, hạt gạo thon dài, không bị khô sau khi nấu. Sản phẩm gạo Vua Gạo được đánh giá cao về chất lượng sản phẩm, hương vị thơm ngon, hấp dẫn, túi 5kg thích hợp cho gia đình sử dụng.', 195000, 'gao-thom-vua-gao-st25-lua-tom-tui-5kg-202211170832226107.jpg', '5kg', 'Vua Gạo', 3, 10, 1, '2023-03-17', '2025-01-01'),
(25, 'Gạo thơm đặc sản Neptune ST25 túi 5kg', 'Gạo là lương thực thực phẩm thiết yếu có trong mọi căn bếp. Gạo thơm đặc sản Neptune ST25 túi 5kg với giống gạo ST25 ngon nhất thế giới vào năm 2019, hạt cơm ngọt, dẻo nhiều và ít nở, giúp bạn ăn ngon miệng. Gạo Neptune chất lượng, thơm ngon, giúp bạn ăn được nhiều cơm.', 185000, 'gao-thom-dac-san-neptune-st25-tui-5kg-202303010822397005.jpg', '5kg', 'Neptune', 3, 10, 1, '2023-03-17', '2025-01-01'),
(26, 'Gạo ST25 Thượng hạng Đồng Việt túi 5kg\n', 'Gạo ST25 Thượng hạng Đồng Việt túi 5kg là loại gạo thơm được thu hoạch từ giống lúa ST25. Gạo Đồng Việt là thương hiệu nổi tiếng với các sản phẩm gạo chất lượng, không chứa chất bảo quản, chất tạo mùi và không để lại dư lượng thuốc bảo vệ thực vật khác.', 179000, 'gao-st25-thuong-hang-dong-viet-tui-5kg-202212280854102020.jpg', '5kg', 'Đồng Việt', 3, 10, 1, '2023-03-17', '2025-01-01'),
(27, 'Gạo trắng Thiên Nhật túi 5kg', 'Gạo Thiên Nhật chất lượng, không chứa chất bảo quản, tạo mùi hay tẩy trắng. Gạo trắng Thiên Nhật túi 5kg cho ra cơm dẻo vừa, nở ít, giúp ăm ngon miệng hơn. Gạo túi 5kg tiện lợi và tiết kiệm cho cả gia đình cùng sử dụng.', 74000, 'gao-trang-thien-nhat-tui-5kg-202206220935467038.jpg', '5kg', 'Thiên Nhật', 3, 10, 1, '2023-03-17', '2025-01-01'),
(28, 'Gạo Lạc Việt đệ nhất ST25 túi 5kg', 'Gạo là nguyên liệu không thể thiếu trong bữa cơm hằng ngày của người Việt. Gạo Lạc Việt đệ nhất ST25 túi 5kg thơm ngon với giống lúa ST25 nổi tiếng, gạo có độ mềm dẻo cùng hương thơm nhẹ nhàng. Gạo Lạc Việt được sản xuất từ 100% hạt gạo tự nhiên đạt chất lượng.', 140000, 'gao-thom-a-an-st24-tui-5kg-202204021021313013.jpg', '5kg', 'Lạc Việt', 3, 10, 1, '2023-03-17', '2025-01-01'),
(29, 'Gạo đặc sản Trạng Nguyên Vinh Hiển ST25 túi 5kg', 'Gạo là lương thực quan trọng, không thể thiếu trong những bữa cơm gia đình. Gạo Vinh Hiển là thương hiệu lớn với sản phẩm Gạo đặc sản trạng nguyên Vinh Hiển ST25 túi 5kg dẻo, mềm và thơm giúp ăn ngon miệng, rất hợp khẩu vị nhiều người. Túi nhỏ thích hợp cho sử dụng cá nhân hoặc dùng thử.', 179000, 'gao-dac-san-trang-nguyen-vinh-hien-st25-tui-5kg-202212131033083592.jpg', '5kg', 'Vinh Hiển', 3, 10, 1, '2023-03-17', '2025-01-01'),
(30, 'Gạo hương lài Thiên Kim túi 5kg', 'Cơm dẻo mềm, thơm lài, ngọt nhẹ. Gạo Thiên Kim Hương Lài được sản xuất theo quy trình khoa học, đảm bảo mang lại những hạt gạo ngon, tươi mới, thơm lành, chất lượng nhất mà vẫn an toàn cho sức khoẻ của người tiêu dùng.', 91000, 'gao-thom-jasmine-5kg-2-org.jpg', '5kg', 'Thiên Kim', 3, 10, 1, '2023-03-17', '2025-01-01'),
(31, 'Gạo thơm lài Bách hoá XANH túi 5kg', 'Gạo khi nấu chín dẻo vừa, thơm nhẹ, nở vừa phải, cơm mềm. Gạo thơm lài Bách hoá XANH túi 5kg là gạo của Bách Hóa Xanh, được canh tác nuôi trồng theo quy trình hiện đại, tiên tiến, không sử dụng chất kích thích tăng trưởng,đảm bảo an toàn, chất lượng và mang đến bữa cơm tròn vị cho gia đình bạn.', 103000, 'gao-thom-lai-bach-hoa-xanh-tui-5kg-201910041050516831.jpg', '5kg', 'Bách hoá XANH', 3, 10, 1, '2023-03-17', '2025-01-01'),
(32, 'Gạo thơm Ngon ST24 túi 5kg', 'Gạo khi nấu cho cơm mềm ngọt, dẻo dai, rất ngon tạo cảm giác dễ chịu cho người ăn. Gạo thơm Ngon ST24 túi 5kg thuộc thương hiệu gạo Ngon được nuôi trồng canh tác theo quy trình tiên tiến, nghiêm ngặt đảm bảo không chất bảo quản, không thuốc trừ sâu, kích thích tăng trưởng.', 103000, 'gao-thom-ngon-st24-tui-5kg-202101261415591064.jpg', '5kg', 'Ngon', 3, 10, 1, '2023-03-17', '2025-01-01'),
(33, 'Gạo trắng 6868 Angel túi 5kg', 'Gạo các loại Angel là loại gạo chất lượng, hạt gạo trắng thơm ngon chất lượng, dẻo mềm với chất lượng được ưu tiên hàng đầu. Gạo trắng 6868 Angel túi 5kg với 100% chất lượng cao cấp, hạt gạo cho cớm nấu thành phẩm thơm ngon khó cưỡng, dẻo, nở, mềm cho bữa ăn thêm tròn vị, bắt cơm hơn rất nhiều.', 114000, 'gao-trang-6868-angel-tui-5kg-202204190842251152.jpg', '5kg', 'Angel', 3, 10, 1, '2023-03-17', '2024-01-01'),
(34, 'Gạo tấm thơm Angel Fine Foods túi 5kg', 'Gạo các loại, tấm các loại là thực phẩm chính trong bữa ăn của người Việt. Tấm, gạo các loại Angel được ưa chuộng bởi sự tiện lợi, độ thơm ngon và đảm bảo chất lượng. Gạo tấm thơm Angel Fine Foods túi 5kg ngon và mềm, vị thơm ngọt có độ nở vừa phải, phù hợp với khẩu vị của người Việt.', 114000, 'gao-tam-thom-angel-fine-foods-tui-5kg-202210050838168651.jpg', '5kg', 'Angel', 3, 10, 1, '2023-03-17', '2024-01-01'),
(35, 'Gạo thơm thượng hạng Neptune Nhãn Vàng túi 5kg', 'Gạo là lương thực không thể thiếu trong căn bếp người Việt ta. Gạo thơm thượng hạng Neptune Nhãn Vàng túi 5kg là loại gạo rất thơm, mềm và ít nở, khi nấu thành cơm ăn khá ngọt. Gạo Neptune chất lượng, giúp ăn ngon miệng, xứng đáng là loại gạo nên có trong mỗi căn bếp', 155000, 'gao-thom-thuong-hang-neptune-nhan-vang-tui-5kg-202111021832474882.jpg', '5kg', 'Neptune', 3, 10, 1, '2023-03-17', '2024-01-01'),
(36, 'Gạo thơm Vua Gạo ST25 túi 5kg', 'Gạo hạt dài, thơm đặc trưng và nở ít tạo giác ăn ngon miệng. Gạo thơm Vua Gạo ST25 túi 5kg vị dẻo, vị thơm đặc trưng sẽ kích thích vị giác giúp thưởng thức các món ăn khác tuyệt vời hơn. Gạo đảm bảo an toàn, không tẩy trắng, không chứa chất bảo quản. Túi 5kg phù hợp với cả gia đình.', 140000, 'gao-thom-vua-gao-st25-tui-5kg-202103131616343493.jpg', '5kg', 'Vua Gạo', 3, 10, 1, '2023-03-17', '2024-01-01'),
(37, 'Gạo lức huyết rồng PMT túi 2kg', 'Hạt gạo màu đỏ, chứa nhiều chất xơ, giàu canxi, sắt... khi nấu, gạo nở vừa, chứa nhều chất dinh dưỡng, hỗ trợ và phòng chống ung thư, tăng cường hệ miễn dịch. Gạo lứt huyết rồng PMT túi 2kg của hãng gạo PMT không sử dụng chất bảo quản, chất kích thích tăng trưởng đảm bảo an toàn đến tay người dùng.', 78000, 'gao-luc-huyet-rong-pmt-tui-2kg-201912111120503715.jpg', '2kg', 'PMT', 3, 10, 1, '2023-03-17', '2024-01-01'),
(38, 'Gia vị nêm sẵn lẩu Thái Aji-Quick gói 50g', 'Là loại gia vị nêm sẵn hiện đang được rất nhiều người ưa chuộng của thương hiệu gia vị nêm sẵn Aji-Quick. Gia vị nêm sẵn nấu lẩu Thái Aji-Quick gói 50g là sự kết hợp hài hòa của tất cả các loại gia vị cần thiết, cho món lẩu thái chua cay đậm vị như ở nhà hàng ngay tại nhà.', 8400, 'gia-vi-nem-san-lau-thai-aji-quick-goi-55g-201911211600565745.jpg', '50g', 'Aji-Quick', 2, 10, 1, '2023-03-17', '2024-01-01'),
(39, 'Xốt ướp thịt nướng Cholimex hũ 200g', 'Sản phẩm rất tiện dụng cho món thịt nướng vì tổng hợp đủ các gia vị như nước mắm, tỏi, hành, đường, muối ăn, mật ong, sả, tiêu, bột ngọt… Chỉ với 1 lượng xốt ướp vừa phải cùng với 1.5g thịt thì bạn sẽ có ngay món thịt nướng thơm ngon, đậm đà, khó cưỡng.', 22300, 'xot-uop-thit-nuong-cholimex-hu-200g-201911051032361300.jpg', '200g', 'Cholimex', 2, 10, 1, '2023-03-17', '2024-01-01'),
(40, 'Gia vị hoàn chỉnh dạng xốt thịt kho Chinsu gói 70g', 'Sản phẩm gia vị nêm sẵn kho thịt của thương hiệu gia vị nêm sẵn Chinsu giúp món ngon thấm gia vị, lên màu đẹp, bắt mắt. Gia vị hoàn chỉnh xốt thịt kho Chinsu gói 70g với sự kết hợp đầy đủ của nước màu, đường, muối và nước mắm, được phối trộn theo tỷ lệ chuẩn, giúp cho món thịt kho ngon chuẩn vị.', 6500, 'gia-vi-hoan-chinh-dang-xot-thit-kho-trung-chinsu-goi-70g-201905240016431259.jpg', '70g', 'Chinsu', 2, 10, 1, '2023-03-17', '2024-01-01'),
(41, 'Sốt lẩu Thái Cholimex chai 280g', 'Có thành phần gồm dầu ăn, tỏi, sả, gừng, riềng, lá chanh, me, ớt, đường, muối… Sản phẩm mang tới sự thơm ngon của những nguyên liệu tự nhiên, hương vị đậm đà, kích thích vị giác, phù hợp khẩu vị của người Việt Nam.', 20000, 'lau-thai-cholimex-chai-280g-201903170008408860.jfif', '280g', 'Cholimex', 2, 10, 1, '2023-03-17', '2024-01-01'),
(42, 'Nước chấm Đầu Bếp Tôm chai 900ml', 'Nước mắm của thương hiệu nước mắm Đầu Bếp Tôm được chế biến từ những con tôm tươi được tuyển chọn. Nước chấm Đầu Bếp Tôm chai 900ml được làm từ cốt tôm thật, với vị mặn dịu và ngọt nhẹ, giúp tăng thêm hương vị cho các món ăn hằng ngày.', 13000, 'nuoc-cham-dau-bep-tom-chai-900ml-202211040839259637.jpg', '900ml', 'Đầu Bếp Tôm', 2, 10, 1, '2023-03-17', '2024-01-01'),
(43, 'Nước mắm Nam Ngư 10 độ đạm chai 900ml', 'Nước mắm Nam Ngư đem đến cho người tiêu dùng Việt Nam những giọt nước mắm thơm ngon, sự lựa chọn hàng đầu của người Việt. Nước mắm Nam Ngư 10 độ đạm chai 900ml với dây chuyền khép kín với thành phần cá cơm tươi ngon tạo nên hương vị thơm ngon, đậm đà, màu sắc hấp dẫn.', 56500, 'nuoc-mam-nam-ngu-10-do-dam-chai-900ml-202212050916530690.png', '900ml', 'Nam Ngư', 2, 10, 1, '2023-03-17', '2024-01-01'),
(44, 'Nước mắm cá cơm đặc sản Hưng Thịnh 40 độ đạm chai 750ml', 'Nước mắm Hưng Thịnh được sản xuất từ cá cơm nguyên chất với phương pháp ủ chượp truyền thống. Nước mắm Hưng Thịnh đặc sản 40 độ đạm 750ml với hương vị đậm đà, đặc trưng của nước mắm cá cơm nguyên chất cùng độ đạm cao, mang đến những bữa ăn ngon, đậm vị.', 83200, 'nuoc-mam-hung-thinh-dac-san-40-do-dam-chai-750ml-201903151021148351.jpg', '750ml', 'Hưng Thịnh', 2, 10, 1, '2023-03-17', '2024-01-01'),
(45, 'Nước mắm cá cơm 584 Nha Trang 15 độ đạm can 2 lít', 'Cá cơm, nước, muối, chất điều vị, phẩm màu, chất bảo quản', 48000, 'nuoc-mam-ca-com-584-nha-trang-15-do-dam-can-2-lit-202210212109289660.jpg', '750ml', '584 Nha Trang', 2, 10, 1, '2023-03-17', '2024-01-01'),
(46, 'Muối ớt Guyumi hũ 110g', 'Muối tôm của thương hiệu muối Guyumi được tạo nên bởi hương vị ngọt của tôm, kết hợp với vị cay của ớt và gia vị, có độ mặn vừa phải, nguồn nguyên liệu sạch, tạo nên muối ớt kiểu Tây Ninh Guymi 110g thơm ngon, khó cưỡng.', 13000, 'muoi-ot-kieu-tay-ninh-guyumi-chai-110g-202101091722009078.jpg', '750ml', 'Guyumi', 2, 10, 1, '2023-03-17', '2024-01-01'),
(47, 'Cá ngừ xốt cà chua Tuna Việt Nam hộp 140g', 'Cá ngừ xốt cà chua Tuna Việt Nam lon 140g của cá hộp Tuna Việt Nam với hơn 60% cá ngừ , hòa quyện với sốt cà chua đặc cùng các gia vị được tuyển chọn kĩ càng đã tạo nên một món cá hộp đầy bổ dưỡng, lạ miệng, phù hợp cho việc chế biến các món ăn trong gia đình hoặc đi dã ngoại du lịch.', 16600, 'ca-ngu-xot-ca-chua-tuna-viet-nam-lon-140g-202011051454163555.jpg', '140g', 'Tuna Việt Nam', 4, 10, 1, '2023-03-17', '2024-01-01'),
(48, 'Cá mòi sốt cà vị ớt cay Ligo hộp 155g', 'Cá mòi sốt cà vị ớt cay Ligo hộp 155g với thành phần chính là cá mòi được chọn lọc kĩ càng, an toàn cho sức khỏe kết hợp với sốt cà chua đậm tạo nên món ăn hương vị cá hộp thơm ngon. Đặc biệt cá hộp Ligo có vị cay của ớt kích thích vị giác, tạo cảm giác ngon miệng.', 18000, 'ca-moi-sot-ca-vi-ot-cay-ligo-hop-155g-201905221108536465.jpg', '155g', 'Ligo (Mỹ)', 4, 10, 1, '2023-03-17', '2024-01-01'),
(49, 'Thịt áp chảo Ponnie hộp 340g', 'Thịt áp chảo Ponnie hộp 340g thơm ngon, hấp dẫn, có thể sử dụng để ăn liền hoặc ăn với cơm rất hấp dẫn. Heo hộp Ponnie là sản phẩm heo hộp được mọi người rất ưa chuộng, dinh dưỡng, tiện lợi.', 95000, 'thit-ap-chao-ponnie-hop-340g-202301141530060154.jpg', '340g', 'Ponnie (Hàn Quốc)', 4, 10, 1, '2023-03-17', '2024-01-01'),
(50, '6 lon nước ngọt Pepsi Cola 320ml', 'Từ thương hiệu nước ngọt có gas nổi tiếng toàn cầu - Pepsi - với mùi vị thơm ngon với hỗn hợp hương tự nhiên cùng chất tạo ngọt tổng hợp, giúp xua tan cơn khát và cảm giác mệt mỏi.  6 lon nước ngọt Pepsi Cola 320ml bổ sung năng lượng làm việc mỗi ngày. Cam kết sản phẩm chính hãng, chất lượng.', 54000, 'loc-6-lon-nuoc-ngot-pepsi-cola-330ml-202003201311477466.jfif', '320ml/6 lon', 'Pepsi (Mỹ)', 11, 10, 1, '2023-03-17', '2024-01-01'),
(51, '6 lon nước ngọt có ga Mirinda vị soda kem việt quất 320ml', 'Nước ngọt Mirinda vị soda kem việt quất là dòng sản phẩm nước ngọt mang đến cho bạn nguồn năng lượng mới mẻ với vị soda kem ngon bùng nổ cùng hương việt quất. Hãy mua lốc 6 lon nước ngọt Mirinda vị soda kem việt quất 320ml để thưởng thức và cảm nhận vị ngon đặc biệt nhé!', 62000, '6-lon-nuoc-ngot-co-ga-mirinda-vi-soda-kem-viet-quat-320ml-202204222251548830.jpg', '320ml/6 lon', 'Mirinda (Việt Nam)', 11, 10, 1, '2023-03-17', '2024-01-01');

-- 
-- Dumping data for table orders
--
INSERT INTO orders VALUES
(1, 3, '2023-03-27', 1, '1'),
(2, 3, '2023-03-27', 1, '1'),
(3, 3, '2023-03-27', 1, '1'),
(4, 3, '2023-03-27', 2, '1'),
(5, 3, '2023-03-27', 2, '1'),
(6, 3, '2023-03-27', 2, '1'),
(7, 3, '2023-03-27', 2, '1'),
(8, 3, '2023-03-27', 2, '1');

-- 
-- Dumping data for table coupon
--
INSERT INTO coupon VALUES
(1, 'COUPON01', 'giam gia 10%', 10, '2023-04-01', 50, 1);

-- 
-- Dumping data for table order_detail
--
INSERT INTO order_detail VALUES
(1, 1, 1, 118000.00, 1, 1),
(2, 1, 2, 89000.00, 1, 1),
(3, 1, 3, 288000.00, 1, 1),
(4, 2, 6, 56000.00, 1, 1),
(5, 2, 7, 260000.00, 1, 1),
(6, 3, 8, 440000.00, 1, 1),
(7, 3, 17, 106000.00, 1, 1),
(8, 4, 1, 118000.00, 1, 1),
(9, 5, 1, 118000.00, 1, 1),
(10, 5, 3, 288000.00, 1, 1),
(11, 6, 8, 440000.00, 1, 1),
(12, 6, 3, 288000.00, 1, 1),
(13, 7, 1, 118000.00, 1, 1),
(14, 7, 2, 89000.00, 1, 1),
(15, 8, 34, 114000.00, 1, 1),
(16, 8, 1, 118000.00, 1, 1),
(17, 8, 2, 89000.00, 1, 1);

-- 
-- Dumping data for table import_detail
--
INSERT INTO import_detail VALUES
(1, 1, 1, 50, 11000.00, 1),
(2, 1, 2, 50, 8000.00, 1),
(3, 1, 3, 50, 150000.00, 1),
(4, 1, 4, 50, 150000.00, 1),
(5, 2, 6, 50, 50000.00, 1),
(6, 2, 7, 50, 250000.00, 1);

-- 
-- Dumping data for table discount_product
--
INSERT INTO discount_product VALUES
(1, 1, 50, '2023-03-27', '2023-04-01', 1, 'le 8/3'),
(2, 2, 30, '2023-01-01', '2023-04-01', 1, 'xa hang');

-- 
-- Dumping data for table discount_category
--
-- Table db_sieuthi_mini.discount_category does not contain any data (it is empty)

-- 
-- Dumping data for table coupon_orders
--
-- Table db_sieuthi_mini.coupon_orders does not contain any data (it is empty)

-- 
-- Restore previous SQL mode
-- 
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;

-- 
-- Enable foreign keys
-- 
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;