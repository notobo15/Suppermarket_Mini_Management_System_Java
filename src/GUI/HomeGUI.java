/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author minht
 */
public class HomeGUI extends javax.swing.JFrame {

    /**
     * Creates new form HomeGUI
     */
    public HomeGUI() {
        initComponents();
        Session s = new Session();
        lblId.setText(""+s.getId());
        lblName.setText(s.getName());
        lblRole.setText(""+s.getRole());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnHeader = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblRole = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblLogout = new javax.swing.JLabel();
        pnBody = new javax.swing.JPanel();
        btnTaoDonHang = new javax.swing.JButton();
        btnDonHang = new javax.swing.JButton();
        btnKhachHang = new javax.swing.JButton();
        btnTaiKhoan = new javax.swing.JButton();
        btnNhapHang = new javax.swing.JButton();
        btnKhuyenMai = new javax.swing.JButton();
        btnHangHoa = new javax.swing.JButton();
        btnLoaiHangHoa = new javax.swing.JButton();
        btnThongKe = new javax.swing.JButton();
        btnNhaCungCap = new javax.swing.JButton();
        clockGUI1 = new GUI.Components.ClockGUI();
        pnFooter = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnHeader.setBackground(new java.awt.Color(51, 0, 153));
        pnHeader.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnHeader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/icons8-customer-96.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnHeader.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 8, 96, 96));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID         :");
        pnHeader.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 8, 60, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tên      :");
        pnHeader.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 44, 60, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Vai trò :");
        pnHeader.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 80, 60, 30));

        lblId.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblId.setForeground(new java.awt.Color(255, 255, 255));
        lblId.setText("129313241234");
        pnHeader.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 8, 200, 30));

        lblName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 255, 255));
        lblName.setText("129313241234");
        pnHeader.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 44, 200, 30));

        lblRole.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblRole.setForeground(new java.awt.Color(255, 255, 255));
        lblRole.setText("129313241234");
        pnHeader.add(lblRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 80, 200, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("QUẢN LÝ SIÊU THỊ MINI");
        pnHeader.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 500, 115));

        lblLogout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/icons8-log-out-50.png"))); // NOI18N
        lblLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoutMouseClicked(evt);
            }
        });
        pnHeader.add(lblLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 20, 70, 70));

        getContentPane().add(pnHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 115));

        pnBody.setOpaque(false);
        pnBody.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTaoDonHang.setBackground(new java.awt.Color(51, 0, 102));
        btnTaoDonHang.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnTaoDonHang.setForeground(new java.awt.Color(255, 255, 255));
        btnTaoDonHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/purchase-order-white-48.png"))); // NOI18N
        btnTaoDonHang.setText("TẠO ĐƠN HÀNG");
        btnTaoDonHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTaoDonHang.setFocusable(false);
        btnTaoDonHang.setRequestFocusEnabled(false);
        btnTaoDonHang.setVerifyInputWhenFocusTarget(false);
        btnTaoDonHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoDonHangActionPerformed(evt);
            }
        });
        pnBody.add(btnTaoDonHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 50, 200, 100));

        btnDonHang.setBackground(new java.awt.Color(51, 0, 102));
        btnDonHang.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnDonHang.setForeground(new java.awt.Color(255, 255, 255));
        btnDonHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/order-history-white-48.png"))); // NOI18N
        btnDonHang.setText("ĐƠN HÀNG");
        btnDonHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDonHang.setFocusable(false);
        btnDonHang.setRequestFocusEnabled(false);
        btnDonHang.setVerifyInputWhenFocusTarget(false);
        btnDonHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDonHangActionPerformed(evt);
            }
        });
        pnBody.add(btnDonHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 50, 200, 100));

        btnKhachHang.setBackground(new java.awt.Color(51, 0, 102));
        btnKhachHang.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        btnKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/customer-white-48.png"))); // NOI18N
        btnKhachHang.setText("KHÁCH HÀNG");
        btnKhachHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKhachHang.setFocusable(false);
        btnKhachHang.setRequestFocusEnabled(false);
        btnKhachHang.setVerifyInputWhenFocusTarget(false);
        btnKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachHangActionPerformed(evt);
            }
        });
        pnBody.add(btnKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 50, 200, 100));

        btnTaiKhoan.setBackground(new java.awt.Color(51, 0, 102));
        btnTaiKhoan.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnTaiKhoan.setForeground(new java.awt.Color(255, 255, 255));
        btnTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/account-white-48.png"))); // NOI18N
        btnTaiKhoan.setText("TÀI KHOẢN");
        btnTaiKhoan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTaiKhoan.setFocusable(false);
        btnTaiKhoan.setRequestFocusEnabled(false);
        btnTaiKhoan.setVerifyInputWhenFocusTarget(false);
        btnTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaiKhoanActionPerformed(evt);
            }
        });
        pnBody.add(btnTaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(875, 50, 200, 100));

        btnNhapHang.setBackground(new java.awt.Color(51, 0, 102));
        btnNhapHang.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnNhapHang.setForeground(new java.awt.Color(255, 255, 255));
        btnNhapHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/create-order-white-48.png"))); // NOI18N
        btnNhapHang.setText("NHẬP HÀNG");
        btnNhapHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNhapHang.setFocusable(false);
        btnNhapHang.setRequestFocusEnabled(false);
        btnNhapHang.setVerifyInputWhenFocusTarget(false);
        btnNhapHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapHangActionPerformed(evt);
            }
        });
        pnBody.add(btnNhapHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 200, 200, 100));

        btnKhuyenMai.setBackground(new java.awt.Color(51, 0, 102));
        btnKhuyenMai.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        btnKhuyenMai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/discount-white-48.png"))); // NOI18N
        btnKhuyenMai.setText("KHUYẾN MÃI");
        btnKhuyenMai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKhuyenMai.setFocusable(false);
        btnKhuyenMai.setRequestFocusEnabled(false);
        btnKhuyenMai.setVerifyInputWhenFocusTarget(false);
        btnKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhuyenMaiActionPerformed(evt);
            }
        });
        pnBody.add(btnKhuyenMai, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 200, 200, 100));

        btnHangHoa.setBackground(new java.awt.Color(51, 0, 102));
        btnHangHoa.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnHangHoa.setForeground(new java.awt.Color(255, 255, 255));
        btnHangHoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/product-white-48.png"))); // NOI18N
        btnHangHoa.setText("HÀNG HÓA");
        btnHangHoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHangHoa.setFocusable(false);
        btnHangHoa.setRequestFocusEnabled(false);
        btnHangHoa.setVerifyInputWhenFocusTarget(false);
        btnHangHoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHangHoaActionPerformed(evt);
            }
        });
        pnBody.add(btnHangHoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 200, 200, 100));

        btnLoaiHangHoa.setBackground(new java.awt.Color(51, 0, 102));
        btnLoaiHangHoa.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnLoaiHangHoa.setForeground(new java.awt.Color(255, 255, 255));
        btnLoaiHangHoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/product-type-white-48.png"))); // NOI18N
        btnLoaiHangHoa.setText("LOẠI HÀNG HÓA");
        btnLoaiHangHoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLoaiHangHoa.setFocusable(false);
        btnLoaiHangHoa.setRequestFocusEnabled(false);
        btnLoaiHangHoa.setVerifyInputWhenFocusTarget(false);
        btnLoaiHangHoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoaiHangHoaActionPerformed(evt);
            }
        });
        pnBody.add(btnLoaiHangHoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(875, 200, 200, 100));

        btnThongKe.setBackground(new java.awt.Color(51, 0, 102));
        btnThongKe.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnThongKe.setForeground(new java.awt.Color(255, 255, 255));
        btnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/statistics-white-48.png"))); // NOI18N
        btnThongKe.setText("THỐNG KÊ");
        btnThongKe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThongKe.setFocusable(false);
        btnThongKe.setRequestFocusEnabled(false);
        btnThongKe.setVerifyInputWhenFocusTarget(false);
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });
        pnBody.add(btnThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 350, 200, 100));

        btnNhaCungCap.setBackground(new java.awt.Color(51, 0, 102));
        btnNhaCungCap.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnNhaCungCap.setForeground(new java.awt.Color(255, 255, 255));
        btnNhaCungCap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/supplier-white-48.png"))); // NOI18N
        btnNhaCungCap.setText("NHÀ CUNG CẤP");
        btnNhaCungCap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNhaCungCap.setFocusable(false);
        btnNhaCungCap.setRequestFocusEnabled(false);
        btnNhaCungCap.setVerifyInputWhenFocusTarget(false);
        btnNhaCungCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhaCungCapActionPerformed(evt);
            }
        });
        pnBody.add(btnNhaCungCap, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 350, 200, 100));
        pnBody.add(clockGUI1, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 10, -1, -1));

        getContentPane().add(pnBody, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 115, 1200, 500));

        pnFooter.setBackground(new java.awt.Color(51, 0, 153));
        pnFooter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnFooter.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Member: Nguyễn Thanh Bình");
        pnFooter.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 200, 25));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Mssv: 3121410082");
        pnFooter.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 200, 25));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Member: Kim Hỷ Nhật");
        pnFooter.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 10, 200, 25));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Mssv: 3121410363");
        pnFooter.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 40, 200, 25));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Member: Nguyễn Đặng Vũ Tiến");
        pnFooter.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 200, 25));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Mssv: 3121410499");
        pnFooter.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 200, 25));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Member: Tràn Phan Minh Thông");
        pnFooter.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, 200, 25));

        jLabel16.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Mssv: 3121410015");
        pnFooter.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 40, 200, 25));

        jLabel17.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Member: Thân Trọng Hoài Nam");
        pnFooter.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 10, 200, 25));

        jLabel18.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Mssv: 3121410082");
        pnFooter.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 40, 200, 25));

        getContentPane().add(pnFooter, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 615, 1200, 85));

        lblBackground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/background-blue.png"))); // NOI18N
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 700));

        setSize(new java.awt.Dimension(1214, 717));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
        // TODO add your handling code here:
        this.dispose();
        new LoginGUI().setVisible(true);
    }//GEN-LAST:event_lblLogoutMouseClicked

    private void btnTaoDonHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoDonHangActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new TaoDonHangGUI().setVisible(true);
        
    }//GEN-LAST:event_btnTaoDonHangActionPerformed

    private void btnDonHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDonHangActionPerformed
        this.dispose();
        new OrderGUI().setVisible(true);
    }//GEN-LAST:event_btnDonHangActionPerformed

    private void btnKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhachHangActionPerformed
       this.dispose();
        try {
            new CustomerGUI().setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(HomeGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnKhachHangActionPerformed

    private void btnTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaiKhoanActionPerformed
        this.dispose();
        try {
            new AccountGUI().setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(HomeGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTaiKhoanActionPerformed

    private void btnNhapHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapHangActionPerformed
        this.dispose();
        new PhieuNhap().setVisible(true);
    }//GEN-LAST:event_btnNhapHangActionPerformed

    private void btnKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhuyenMaiActionPerformed
        this.dispose();
        new DiscountCategoryGUI().setVisible(true);
    }//GEN-LAST:event_btnKhuyenMaiActionPerformed

    private void btnHangHoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHangHoaActionPerformed
        this.dispose();
        new ProductGUI().setVisible(true);
    }//GEN-LAST:event_btnHangHoaActionPerformed

    private void btnLoaiHangHoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoaiHangHoaActionPerformed
        this.dispose();
        new CategoryProductGUI().setVisible(true);
    }//GEN-LAST:event_btnLoaiHangHoaActionPerformed

    private void btnNhaCungCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhaCungCapActionPerformed
        this.dispose();
        try {
            new SuppilierGUI().setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(HomeGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNhaCungCapActionPerformed

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThongKeActionPerformed


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
                if ("FlatLaf Light".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDonHang;
    private javax.swing.JButton btnHangHoa;
    private javax.swing.JButton btnKhachHang;
    private javax.swing.JButton btnKhuyenMai;
    private javax.swing.JButton btnLoaiHangHoa;
    private javax.swing.JButton btnNhaCungCap;
    private javax.swing.JButton btnNhapHang;
    private javax.swing.JButton btnTaiKhoan;
    private javax.swing.JButton btnTaoDonHang;
    private javax.swing.JButton btnThongKe;
    private GUI.Components.ClockGUI clockGUI1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblRole;
    private javax.swing.JPanel pnBody;
    private javax.swing.JPanel pnFooter;
    private javax.swing.JPanel pnHeader;
    // End of variables declaration//GEN-END:variables
}
