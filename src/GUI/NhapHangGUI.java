/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.BUS_CategoryProduct;
import BUS.BUS_Customer;
import BUS.BUS_Product;
import BUS.BUS_Suppilier;
import DAO.DAO_Account;
import DTO.DTO_CategoryProduct;
import DTO.DTO_Customer;
import DTO.DTO_Product;
import DTO.DTO_Suppilier;
import GUI.Components.ThemKhachHang;
import GUI.Components.ThemNCC;
import GUI.Components.ThemSanPham;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class NhapHangGUI extends javax.swing.JFrame {

    private ArrayList<DTO_Product> list_product = new ArrayList<DTO_Product>();
    private DTO_Product product = new DTO_Product();
    private ArrayList<DTO_Product> all_product = new ArrayList<DTO_Product>();
    private int indexGioHangTable;

    public NhapHangGUI() throws SQLException {
        initComponents();

        jtf_cap_nhat_quantity.setEditable(false);
        btn_cap_nhat_quantity.setEnabled(false);
        jtf_update_gia.setEditable(false);
        btn_cap_nhap_gia.setEnabled(false);
        this.setLocationRelativeTo(null);

        BUS_Product bus_product = new BUS_Product();
        all_product = bus_product.getList();

        renderTableProduct(all_product);

        renderNCC();

        // tim kiem
        DefaultComboBoxModel<String> model_jcb_ten_or_id = new DefaultComboBoxModel<>(new String[]{"Tất Cả", "Theo Tên", "Theo Id"});
        jcb_search_ten_or_id.setModel(model_jcb_ten_or_id);

        BUS_CategoryProduct bus_category = new BUS_CategoryProduct();
        ArrayList<DTO_CategoryProduct> list_category = bus_category.getList();
        String[] list_name_category = new String[list_category.size()];
        list_name_category[0] = "0 - Tất Cả";
        for (int i = 1; i < list_category.size(); i++) {
            list_name_category[i] = list_category.get(i).getId() + " - " + list_category.get(i).getName();
        }
        DefaultComboBoxModel<String> model_cate = new DefaultComboBoxModel<>(list_name_category);
        jcb_loai_san_pham.setModel(model_cate);

    }

    private void renderNCC() throws SQLException {
        BUS_Suppilier bus_ncc = new BUS_Suppilier();
        ArrayList<DTO_Suppilier> list_customer = bus_ncc.getList();
        String list_name_customer[] = new String[list_customer.size()];
        for (int i = 0; i < list_customer.size(); i++) {
            list_name_customer[i] = list_customer.get(i).getSuppilierId() + " - " + list_customer.get(i).getName();

        }
        DefaultComboBoxModel<String> modelComboBox = new DefaultComboBoxModel<>(list_name_customer);
        jcb_khach_hang.setModel(modelComboBox);
    }

    private void renderTableProduct(ArrayList<DTO_Product> all_product) {

        DefaultTableModel model = (DefaultTableModel) SanPhamTable.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }

        Object rowData[] = new Object[7];
        for (int i = 0; i < all_product.size(); i++) {
            rowData[0] = all_product.get(i).getProductId();
            rowData[1] = all_product.get(i).getName();
            rowData[2] = all_product.get(i).getMass();
            rowData[3] = all_product.get(i).getQuantity();
            rowData[4] = all_product.get(i).getPrice();
            rowData[5] = all_product.get(i).getCategoryId();
            rowData[6] = all_product.get(i).getImg();
            model.addRow(rowData);
        }
    }

    public void addRowToJTable() throws SQLException {
        BUS_Customer bus_customer = new BUS_Customer();
        ArrayList<DTO_Customer> list = bus_customer.getList();
//        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object rowData[] = new Object[6];

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getBirthDate());
            rowData[0] = list.get(i).getCustomerId();
            rowData[1] = list.get(i).getName();
            rowData[2] = list.get(i).getPhone();
            rowData[3] = list.get(i).getGender();
            rowData[4] = list.get(i).getBirthDate();
            rowData[5] = list.get(i).getAddress();

//            model.addRow(rowData);
        }

    }

    private void CapNhatTongTien() {
        float s = 0;
        for (DTO_Product pro : list_product) {
            s += pro.getPrice() * pro.getQuantity();
        }
        jlb_tong_tien.setText("" + s);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        clockGUI1 = new GUI.Components.ClockGUI();
        jPanel4 = new javax.swing.JPanel();
        jtf_search = new javax.swing.JTextField();
        jcb_loai_san_pham = new javax.swing.JComboBox<>();
        jcb_search_ten_or_id = new javax.swing.JComboBox<>();
        btn_search = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        SanPhamTable = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        Jlb_img = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jcb_khach_hang = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        GioHangTable = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jtf_cap_nhat_quantity = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btn_xoa_product = new javax.swing.JButton();
        btn_clear_cart = new javax.swing.JButton();
        DatHangBtn = new javax.swing.JButton();
        btn_cap_nhat_quantity = new javax.swing.JButton();
        jlb_tong_tien = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_cap_nhap_gia = new javax.swing.JButton();
        jtf_update_gia = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        ThemGHBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jtf_so_luong_product = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtf_gia_nhap = new javax.swing.JTextField();
        jButton18 = new javax.swing.JButton();
        header1 = new GUI.Components.Header();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Title.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Title.setText("TẠO ĐƠN NHẬP HÀNG");
        jPanel2.add(Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, -1, -1));
        jPanel2.add(clockGUI1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 20, 209, -1));

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setMaximumSize(new java.awt.Dimension(1000, 1000));
        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        jtf_search.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtf_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtf_searchMouseClicked(evt);
            }
        });
        jtf_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_searchActionPerformed(evt);
            }
        });
        jPanel4.add(jtf_search);

        jcb_loai_san_pham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel4.add(jcb_loai_san_pham);

        jcb_search_ten_or_id.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcb_search_ten_or_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_search_ten_or_idActionPerformed(evt);
            }
        });
        jPanel4.add(jcb_search_ten_or_id);

        btn_search.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_search.setText("Tìm");
        btn_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_searchMouseClicked(evt);
            }
        });
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });
        jPanel4.add(btn_search);

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 620, 40));

        SanPhamTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên", "Khối lượng", "Số lượng", "Giá", "Loại", "img"
            }
        ));
        SanPhamTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SanPhamTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(SanPhamTable);
        if (SanPhamTable.getColumnModel().getColumnCount() > 0) {
            SanPhamTable.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 620, 231));

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setLayout(new java.awt.BorderLayout());
        jPanel6.add(Jlb_img, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 180, 170));

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Nhà Cung Cấp");

        jcb_khach_hang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jcb_khach_hang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("Thêm NCC Mới");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/reset-32px.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setText("Thêm SP");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jcb_khach_hang, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(49, 49, 49))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcb_khach_hang, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, 440, -1));

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel9.setPreferredSize(new java.awt.Dimension(146, 44));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 102, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Danh Sách SP Nhập");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(655, 59, 540, -1));

        GioHangTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Giá", "Số lượng", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        GioHangTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GioHangTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(GioHangTable);
        if (GioHangTable.getColumnModel().getColumnCount() > 0) {
            GioHangTable.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(655, 109, 540, 172));

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Nhập số lượng cần sửa");
        jPanel10.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 250, 31));

        jtf_cap_nhat_quantity.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jtf_cap_nhat_quantity.setText("1");
        jtf_cap_nhat_quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_cap_nhat_quantityActionPerformed(evt);
            }
        });
        jPanel10.add(jtf_cap_nhat_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 110, 50));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Tổng số tiền");
        jPanel10.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 140, 31));

        btn_xoa_product.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_xoa_product.setText("Xoá sản phẩm");
        btn_xoa_product.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_xoa_productMouseClicked(evt);
            }
        });
        jPanel10.add(btn_xoa_product, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 200, 70));

        btn_clear_cart.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_clear_cart.setText("Làm sạch");
        btn_clear_cart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_clear_cartMouseClicked(evt);
            }
        });
        btn_clear_cart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clear_cartActionPerformed(evt);
            }
        });
        jPanel10.add(btn_clear_cart, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 200, 70));

        DatHangBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DatHangBtn.setText("IN HÓA ĐƠN & NHẬP HÀNG");
        DatHangBtn.setToolTipText("");
        DatHangBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DatHangBtnActionPerformed(evt);
            }
        });
        jPanel10.add(DatHangBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 270, 70));

        btn_cap_nhat_quantity.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_cap_nhat_quantity.setText("Cập Nhật");
        btn_cap_nhat_quantity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cap_nhat_quantityMouseClicked(evt);
            }
        });
        jPanel10.add(btn_cap_nhat_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 100, 50));

        jlb_tong_tien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlb_tong_tien.setText("0");
        jPanel10.add(jlb_tong_tien, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 120, 30));

        jLabel4.setText("VNĐ");
        jPanel10.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, 60, 30));

        btn_cap_nhap_gia.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btn_cap_nhap_gia.setText("Cập Nhật");
        btn_cap_nhap_gia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cap_nhap_giaMouseClicked(evt);
            }
        });
        jPanel10.add(btn_cap_nhap_gia, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 120, 50));

        jtf_update_gia.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jtf_update_gia.setText("1");
        jPanel10.add(jtf_update_gia, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 100, 50));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Nhập giá cần sửa");
        jPanel10.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 230, 30));

        jPanel2.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(655, 287, 540, 281));

        ThemGHBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ThemGHBtn.setText("Thêm");
        ThemGHBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ThemGHBtnMouseClicked(evt);
            }
        });
        jPanel2.add(ThemGHBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 340, 190, 53));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Số Lượng");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, 50));

        jtf_so_luong_product.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jtf_so_luong_product.setText("100");
        jPanel2.add(jtf_so_luong_product, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 110, 50));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Giá Nhập");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, 90, 50));

        jtf_gia_nhap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jtf_gia_nhap.setText("0");
        jPanel2.add(jtf_gia_nhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 150, 50));

        jButton18.setBackground(new java.awt.Color(255, 193, 7));
        jButton18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/back.png"))); // NOI18N
        jButton18.setLabel("BACK");
        jButton18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton18MouseClicked(evt);
            }
        });
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 0, -1, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_searchActionPerformed

    private void jtf_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_searchActionPerformed

    private void btn_clear_cartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clear_cartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_clear_cartActionPerformed

    private void DatHangBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DatHangBtnActionPerformed
        try {
            // TODO add your handling code here
            BUS_Customer bus_customer = new BUS_Customer();
            String cus = jcb_khach_hang.getSelectedItem().toString();
            int a = cus.charAt(0);
            int cus_id = Character.getNumericValue(a);

            DTO_Customer customer = bus_customer.getSingleById(cus_id);
            new InPhieuNhap(list_product,customer).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(NhapHangGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_DatHangBtnActionPerformed

    private void jtf_cap_nhat_quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_cap_nhat_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_cap_nhat_quantityActionPerformed

    private void SanPhamTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SanPhamTableMouseClicked
        // TODO add your handling code here:
        jtf_so_luong_product.setText("1");
        int i = SanPhamTable.getSelectedRow();
        System.out.println(i);

        product.setProductId((int) SanPhamTable.getModel().getValueAt(i, 0));
        product.setName((String) SanPhamTable.getModel().getValueAt(i, 1));
        product.setPrice((float) SanPhamTable.getModel().getValueAt(i, 4));

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("\\Images\\products\\" + SanPhamTable.getModel().getValueAt(i, 6))); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(180, 150, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);  // transform it back
        Jlb_img.setIcon(imageIcon);

    }//GEN-LAST:event_SanPhamTableMouseClicked
    private void renderTableGioHang() {
        DefaultTableModel model = (DefaultTableModel) GioHangTable.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }

        Object rowData[] = new Object[6];

        for (int i = 0; i < list_product.size(); i++) {
            int stt = i;
            rowData[0] = ++stt;
            rowData[1] = list_product.get(i).getProductId();
            rowData[2] = list_product.get(i).getName();
            rowData[3] = list_product.get(i).getPrice();
            rowData[4] = list_product.get(i).getQuantity();
            rowData[5] = list_product.get(i).getPrice() * list_product.get(i).getQuantity();
            model.addRow(rowData);
        }
        CapNhatTongTien();
    }
    private void ThemGHBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThemGHBtnMouseClicked
        // TODO add your handling code here:

        if (product.getProductId() != 0) {
            try {
                product.setQuantity(Float.parseFloat(jtf_so_luong_product.getText()));
                product.setPrice(Float.parseFloat(jtf_gia_nhap.getText()));
            } catch (Exception e) {
                System.out.println("CHi nhap so");
                return;
            }
            list_product.add(product);
            renderTableGioHang();
            product = new DTO_Product();

        } else {
            System.out.println("GUI.TaoDonHangGUI.ThemGHBtnMouseClicked()");
        }

    }//GEN-LAST:event_ThemGHBtnMouseClicked

    private void btn_cap_nhat_quantityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cap_nhat_quantityMouseClicked
        // TODO add your handling code here:
        try {
            float quantity = Float.parseFloat(jtf_cap_nhat_quantity.getText());
            System.out.println(quantity);
            for (int i = 0; i < list_product.size(); i++) {
                if (indexGioHangTable == i) {
                    list_product.get(i).setQuantity(quantity);
                    break;
                }

            }
            renderTableGioHang();

        } catch (Exception e) {
            System.out.println("GUI.TaoDonHangGUI.btn_cap_nhat_quantityMouseClicked()");
            return;
        }


    }//GEN-LAST:event_btn_cap_nhat_quantityMouseClicked

    private void GioHangTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GioHangTableMouseClicked
        // TODO add your handling code here:

        indexGioHangTable = GioHangTable.getSelectedRow();
        if (indexGioHangTable >= 0) {
            jtf_cap_nhat_quantity.setEditable(true);
            btn_cap_nhat_quantity.setEnabled(true);
            jtf_update_gia.setEditable(true);
            btn_cap_nhap_gia.setEnabled(true);
            for (int i = 0; i < list_product.size(); i++) {
                if (indexGioHangTable == i) {
                    jtf_cap_nhat_quantity.setText("" + list_product.get(i).getQuantity());
                    jtf_update_gia.setText("" + list_product.get(i).getPrice());
                    break;
                }

            }
        }


    }//GEN-LAST:event_GioHangTableMouseClicked

    private void btn_xoa_productMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_xoa_productMouseClicked
        if (indexGioHangTable >= 0) {
            for (int i = 0; i < list_product.size(); i++) {
                if (indexGioHangTable == i) {
                    list_product.remove(i);
                    break;
                }

            }
            renderTableGioHang();
        } else {
            for (int i = 0; i < list_product.size(); i++) {
                if (indexGioHangTable == i) {
                    list_product.remove(i);
                    break;
                }

            }
            renderTableGioHang();
        }
    }//GEN-LAST:event_btn_xoa_productMouseClicked


    private void btn_clear_cartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_clear_cartMouseClicked
        if (true) {
            list_product.clear();
            renderTableGioHang();

        }
    }//GEN-LAST:event_btn_clear_cartMouseClicked

    private void jcb_search_ten_or_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_search_ten_or_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_search_ten_or_idActionPerformed

    private void jtf_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtf_searchMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jtf_searchMouseClicked

    private void btn_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchMouseClicked
        // TODO add your handling code here:
        String key = jtf_search.getText();
        String cate = String.valueOf(jcb_loai_san_pham.getSelectedItem());
        String ten_or_id = String.valueOf(jcb_search_ten_or_id.getSelectedItem());
        System.out.println(key);
        System.out.println(cate);
        System.out.println(ten_or_id);
        //||cate.equalsIgnoreCase("tất cả") 
        if (key.length() != 0) {
            ArrayList<DTO_Product> list_product_filter = new ArrayList<DTO_Product>();
            ArrayList<DTO_Product> list_product_filter2 = new ArrayList<DTO_Product>();
            if (cate.contains("0")) {
                list_product_filter = this.all_product;

            } else {
                for (DTO_Product pro : this.all_product) {
                    if (cate.contains("" + pro.getCategoryId())) {
                        list_product_filter.add(pro);
                    }
                }
            }
            System.out.println("GUI.TaoDonHangGUI.btn_searchMouseClicked()" + ten_or_id);
            if (ten_or_id.contains("Id") || ten_or_id.contains("Tên")) {

                if (ten_or_id.contains("Id")) {

                    for (DTO_Product pro : list_product_filter) {
                        if (pro.getProductId() == Integer.parseInt(key)) {
                            list_product_filter2.add(pro);
                        }
                    }

                } else {
                    for (DTO_Product pro : list_product_filter) {
                        key = key.toLowerCase();
                        if (pro.getName().toLowerCase().contains(key)) {
                            list_product_filter2.add(pro);
                        }
                    }

                }

            } else {
                list_product_filter2 = list_product_filter;

            }

//            for (DTO_Product pro : list_product_filter) {
//                if (pro.getName().contains(jtf_search)) {
//                    list_product_filter.add(pro);
//                }
//            }
            renderTableProduct(list_product_filter2);

        }
//        else{
//            System.out.println("iput trong");
//        }


    }//GEN-LAST:event_btn_searchMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        new ThemNCC().setVisible(true);

    }//GEN-LAST:event_jButton1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        try {
            // TODO add your handling code here:

            renderNCC();
        } catch (SQLException ex) {
            Logger.getLogger(NhapHangGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void btn_cap_nhap_giaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cap_nhap_giaMouseClicked
        // TODO add your handling code here:
        try {
            float price = Float.parseFloat(jtf_update_gia.getText());
            System.out.println(price);
            for (int i = 0; i < list_product.size(); i++) {
                if (indexGioHangTable == i) {
                    list_product.get(i).setPrice(price);
                    break;
                }

            }
            renderTableGioHang();

        } catch (Exception e) {
            System.out.println("GUI.TaoDonHangGUI.btn_cap_nhat_quantityMouseClicked()");
            return;
        }
    }//GEN-LAST:event_btn_cap_nhap_giaMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        try {
            // TODO add your handling code here:
            new ThemSanPham().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(NhapHangGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton18MouseClicked
        // TODO add your handling code here:    

        this.dispose();
        try {
            new HomeGUI().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(NhapHangGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton18MouseClicked

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NhapHangGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhapHangGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhapHangGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhapHangGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new NhapHangGUI().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(NhapHangGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DatHangBtn;
    private javax.swing.JTable GioHangTable;
    private javax.swing.JLabel Jlb_img;
    private javax.swing.JTable SanPhamTable;
    private javax.swing.JButton ThemGHBtn;
    private javax.swing.JLabel Title;
    private javax.swing.JButton btn_cap_nhap_gia;
    private javax.swing.JButton btn_cap_nhat_quantity;
    private javax.swing.JButton btn_clear_cart;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_xoa_product;
    private GUI.Components.ClockGUI clockGUI1;
    private GUI.Components.Header header1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jcb_khach_hang;
    private javax.swing.JComboBox<String> jcb_loai_san_pham;
    private javax.swing.JComboBox<String> jcb_search_ten_or_id;
    private javax.swing.JLabel jlb_tong_tien;
    private javax.swing.JTextField jtf_cap_nhat_quantity;
    private javax.swing.JTextField jtf_gia_nhap;
    private javax.swing.JTextField jtf_search;
    private javax.swing.JTextField jtf_so_luong_product;
    private javax.swing.JTextField jtf_update_gia;
    // End of variables declaration//GEN-END:variables
}
