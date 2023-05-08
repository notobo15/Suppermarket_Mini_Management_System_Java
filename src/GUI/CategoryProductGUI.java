/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.BUS_CategoryProduct;
import BUS.BUS_Product;
import BUS.BUS_Suppilier;
import DTO.DTO_CategoryProduct;
import DTO.DTO_Product;
import DTO.DTO_Suppilier;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EV
 */
public class CategoryProductGUI extends javax.swing.JFrame {

   private ArrayList<DTO_CategoryProduct> list = new ArrayList<>();
    
    
    
    public CategoryProductGUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        try {
            BUS_CategoryProduct bus_categoryproduct = new BUS_CategoryProduct();
            list = bus_categoryproduct.getList();
            addRowToJTable(list);
        } catch (SQLException ex) {
            Logger.getLogger(SuppilierGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
     btn_themloaisanpham.setEnabled(true);
        btn_sualoaisanpham.setEnabled(false);
        btn_xoaloaisanpham.setEnabled(false);

    }
    
    
      public void clear() {
        input_maloai.setText("");
        input_tenloai.setText("");
    }
    
    

    public void addRowToJTable(ArrayList<DTO_CategoryProduct> list) throws SQLException {
        
        
        DefaultTableModel model = (DefaultTableModel) TableLoaiHangHoa.getModel();
        model.setRowCount(0);
        Object rowData[] = new Object[2];
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName());
            rowData[0] = list.get(i).getId();
            rowData[1] = list.get(i).getName();
            model.addRow(rowData);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TableLoaiHangHoa = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        input_maloai = new javax.swing.JTextField();
        input_tenloai = new javax.swing.JTextField();
        btn_themloaisanpham = new javax.swing.JButton();
        btn_sualoaisanpham = new javax.swing.JButton();
        btn_xoaloaisanpham = new javax.swing.JButton();
        btn_resetsanpham = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        input_timkiemtenloai = new javax.swing.JTextField();
        btn_timkiemloaisanpham = new javax.swing.JButton();
        btn_huytimkiemloaisanpham = new javax.swing.JButton();
        input_timkiemmaloai = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        clockGUI1 = new GUI.Components.ClockGUI();
        header1 = new GUI.Components.Header();
        btnRefresh = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(141, 169, 196));
        setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        TableLoaiHangHoa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        TableLoaiHangHoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã loại", "Tên"
            }
        ));
        TableLoaiHangHoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableLoaiHangHoaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableLoaiHangHoa);

        jPanel2.setBackground(new java.awt.Color(208, 244, 222));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("Thông tin");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Mã loại");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Tên");

        input_tenloai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_tenloaiActionPerformed(evt);
            }
        });

        btn_themloaisanpham.setBackground(new java.awt.Color(103, 148, 54));
        btn_themloaisanpham.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_themloaisanpham.setForeground(new java.awt.Color(255, 255, 255));
        btn_themloaisanpham.setText("Thêm");
        btn_themloaisanpham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themloaisanphamActionPerformed(evt);
            }
        });

        btn_sualoaisanpham.setBackground(new java.awt.Color(255, 202, 58));
        btn_sualoaisanpham.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_sualoaisanpham.setForeground(new java.awt.Color(255, 255, 255));
        btn_sualoaisanpham.setText("Sửa");
        btn_sualoaisanpham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sualoaisanphamActionPerformed(evt);
            }
        });

        btn_xoaloaisanpham.setBackground(new java.awt.Color(217, 4, 41));
        btn_xoaloaisanpham.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_xoaloaisanpham.setForeground(new java.awt.Color(255, 255, 255));
        btn_xoaloaisanpham.setText("Xóa");
        btn_xoaloaisanpham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaloaisanphamActionPerformed(evt);
            }
        });

        btn_resetsanpham.setBackground(new java.awt.Color(199, 125, 255));
        btn_resetsanpham.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_resetsanpham.setForeground(new java.awt.Color(255, 255, 255));
        btn_resetsanpham.setText("Reset");
        btn_resetsanpham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetsanphamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(input_maloai, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                            .addComponent(input_tenloai)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_themloaisanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_sualoaisanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_xoaloaisanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_resetsanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(input_maloai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(input_tenloai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_themloaisanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_sualoaisanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_xoaloaisanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_resetsanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(136, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(241, 192, 232));
        jPanel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setText("Tìm kiếm");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Mã loại");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Tên");

        btn_timkiemloaisanpham.setBackground(new java.awt.Color(103, 148, 54));
        btn_timkiemloaisanpham.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_timkiemloaisanpham.setForeground(new java.awt.Color(255, 255, 255));
        btn_timkiemloaisanpham.setText("Tìm kiếm");
        btn_timkiemloaisanpham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemloaisanphamActionPerformed(evt);
            }
        });

        btn_huytimkiemloaisanpham.setBackground(new java.awt.Color(217, 4, 41));
        btn_huytimkiemloaisanpham.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_huytimkiemloaisanpham.setForeground(new java.awt.Color(255, 255, 255));
        btn_huytimkiemloaisanpham.setText("Hủy tìm kiếm");
        btn_huytimkiemloaisanpham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huytimkiemloaisanphamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(input_timkiemtenloai, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(input_timkiemmaloai))
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_timkiemloaisanpham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_huytimkiemloaisanpham, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(input_timkiemmaloai, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(input_timkiemtenloai, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_timkiemloaisanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_huytimkiemloaisanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel19.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel19.setText("LOẠI HÀNG HÓA");

        btnRefresh.setBackground(new java.awt.Color(204, 204, 204));
        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/reset-32px.png"))); // NOI18N
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(clockGUI1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(jButton18)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(clockGUI1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_themloaisanphamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themloaisanphamActionPerformed
        // TODO add your handling code here:

        DTO_CategoryProduct pro = new DTO_CategoryProduct();
        BUS_CategoryProduct tmp = new BUS_CategoryProduct();

        int a = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thêm chứ!!");

        if (a == JOptionPane.YES_OPTION) {

            pro.setId(Integer.parseInt(input_maloai.getText()));
            pro.setName(input_tenloai.getText());        
            try {
                tmp.add(pro);
           } catch (Exception ex) {
                Logger.getLogger(ProductGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btn_themloaisanphamActionPerformed

    private void btn_xoaloaisanphamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaloaisanphamActionPerformed
        // TODO add your handling code here:
        BUS_CategoryProduct tmp = new BUS_CategoryProduct();
        int i = TableLoaiHangHoa.getSelectedRow();
        int id = (int) TableLoaiHangHoa.getModel().getValueAt(i, 0);
        try {
            tmp.delete(id);
        } catch (SQLException ex) {
            Logger.getLogger(AccountGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_xoaloaisanphamActionPerformed

    
    
    
    
    private void btn_luuloaisanphamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_luuloaisanphamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_luuloaisanphamActionPerformed

    private void btn_huytimkiemloaisanphamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_huytimkiemloaisanphamActionPerformed
        // TODO add your handling code here:

        input_timkiemmaloai.setText("");
        input_timkiemtenloai.setText("");
        BUS_CategoryProduct bus_categoryproduct = new BUS_CategoryProduct();
        try {
            list = bus_categoryproduct.getList();
            addRowToJTable(list);

        } catch (SQLException ex) {
            Logger.getLogger(SuppilierGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }//GEN-LAST:event_btn_huytimkiemloaisanphamActionPerformed

    private void btn_timkiemloaisanphamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemloaisanphamActionPerformed
        // TODO add your handling code here:
        
        
        
        String id = input_timkiemmaloai.getText();
        String ten = input_timkiemtenloai.getText();

        ArrayList<DTO_CategoryProduct> filter_id = new ArrayList<>();
        ArrayList<DTO_CategoryProduct> filter_ten = new ArrayList<>();
        ArrayList<DTO_CategoryProduct> filter = new ArrayList<>();
        if (id.length() != 0) {
            filter.clear();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId() == Integer.parseInt(id)) {
                    filter_id.add(list.get(i));
                }
            }
            filter = filter_id;

        }

        if (ten.length() != 0) {
            filter.clear();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getName().toLowerCase().contains(ten.toLowerCase())) {
                    filter_ten.add(list.get(i));
                }
            }
            filter = filter_ten;

        }
        if (ten.length() != 0 && id.length() != 0) {
            filter.clear();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getName().toLowerCase().contains(ten.toLowerCase()) && list.get(i).getId() == Integer.parseInt(id)) {
                    filter.add(list.get(i));
                }
            }
        }
        try {
            System.out.println(filter);
            addRowToJTable(filter);
        } catch (SQLException ex) {
            Logger.getLogger(SuppilierGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_timkiemloaisanphamActionPerformed

    private void btn_resetloaisanphamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetloaisanphamActionPerformed
        // TODO add your handling code here:

    
  
 


    }//GEN-LAST:event_btn_resetloaisanphamActionPerformed

    private void input_tenloaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_tenloaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_tenloaiActionPerformed

    private void btn_resetsanphamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetsanphamActionPerformed
        // TODO add your handling code here:
        clear();
        btn_themloaisanpham.setEnabled(true);
        btn_sualoaisanpham.setEnabled(false);
        btn_xoaloaisanpham.setEnabled(false);
      input_maloai.setEnabled(true);
    }//GEN-LAST:event_btn_resetsanphamActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        btn_themloaisanpham.setEnabled(true);
        btn_sualoaisanpham.setEnabled(false);
        btn_xoaloaisanpham.setEnabled(false);
        input_maloai.setEnabled(true);
        clear();
        try {
            DefaultTableModel model = (DefaultTableModel) TableLoaiHangHoa.getModel();
            model.setRowCount(0);
            BUS_CategoryProduct bus_categoryproduct = new BUS_CategoryProduct();
            list = bus_categoryproduct.getList();
            addRowToJTable(list);
        } catch (SQLException ex) {
            Logger.getLogger(SuppilierGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void jButton18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton18MouseClicked
       try {
           // TODO add your handling code here:
           
           this.dispose();
           new HomeGUI().setVisible(true);
       } catch (SQLException ex) {
           Logger.getLogger(CategoryProductGUI.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_jButton18MouseClicked

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    private void btn_sualoaisanphamActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_sualoaisanphamActionPerformed
        // TODO add your handling code here:
        DTO_CategoryProduct pro = new DTO_CategoryProduct();
        BUS_CategoryProduct tmp = new BUS_CategoryProduct();
        int a = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn sửa chứ!!");

        if (a == JOptionPane.YES_OPTION) {

            pro.setId(Integer.parseInt(input_maloai.getText()));
            pro.setName(input_tenloai.getText());
 
            try {
                tmp.update(pro);
            } catch (Exception ex) {
                Logger.getLogger(ProductGUI.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }// GEN-LAST:event_btn_sualoaisanphamActionPerformed

    private void TableLoaiHangHoaMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_TableLoaiHangHoaMouseClicked
        // TODO add your handling code here:
        
         btn_themloaisanpham.setEnabled(false);
        btn_sualoaisanpham.setEnabled(true);
        btn_xoaloaisanpham.setEnabled(true);
        int i = TableLoaiHangHoa.getSelectedRow();
        input_maloai.setText(TableLoaiHangHoa.getModel().getValueAt(i, 0).toString());
        input_tenloai.setText(TableLoaiHangHoa.getModel().getValueAt(i, 1).toString());
input_maloai.setEnabled(false);

       
     

    }// GEN-LAST:event_TableLoaiHangHoaMouseClicked

//    public void cbbMaLoai() throws Exception {
//        DTO_CategoryProduct pro = new DTO_CategoryProduct();
//        BUS_CategoryProduct tmp = new BUS_CategoryProduct();
//        ArrayList<DTO_CategoryProduct> list = tmp.getList();
//        String[] array = new String[list.size()];
//
//        String[] listCI;
//        String ar = null;
//        for (int i = 0; i < array.length; i++) {
//            array[i] = Integer.toString(list.get(i).getId());
//            String[] array1 = {"--Select--"};
//            String[] result = Arrays.copyOf(array1, array1.length + array.length);
//            System.arraycopy(array, 0, result, array1.length, array.length);
//            ar = Arrays.toString(result).substring(1);
//            ar = ar.substring(0, ar.length() - 1);
//        }
//
//        listCI = ar.split(", ");
//
//        input_timkiemmaloai.setModel(new DefaultComboBoxModel<>(listCI));
//    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CategoryProductGUI.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CategoryProductGUI.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CategoryProductGUI.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CategoryProductGUI.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CategoryProductGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableLoaiHangHoa;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btn_huytimkiemloaisanpham;
    private javax.swing.JButton btn_resetsanpham;
    private javax.swing.JButton btn_sualoaisanpham;
    private javax.swing.JButton btn_themloaisanpham;
    private javax.swing.JButton btn_timkiemloaisanpham;
    private javax.swing.JButton btn_xoaloaisanpham;
    private GUI.Components.ClockGUI clockGUI1;
    private GUI.Components.Header header1;
    private javax.swing.JTextField input_maloai;
    private javax.swing.JTextField input_tenloai;
    private javax.swing.JTextField input_timkiemmaloai;
    private javax.swing.JTextField input_timkiemtenloai;
    private javax.swing.JButton jButton18;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
