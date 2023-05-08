/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.BUS_Order;
import BUS.BUS_OrderDetail;
import DTO.DTO_Order;
import DTO.DTO_OrderDetail;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import GUI.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author ADMIN
 */
public class OrderGUI extends javax.swing.JFrame {

    private ArrayList<DTO_Order> list = new ArrayList<>();
    public OrderGUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        try {
            addRowToJTable();
        } catch (SQLException ex) {
            Logger.getLogger(OrderGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        OrderIDTxt.setEditable(false);
    }

    public void addRowToJTable() throws SQLException {
        BUS_Order bus_order = new BUS_Order();
        ArrayList<DTO_Order> list = bus_order.getList();
        DefaultTableModel model = (DefaultTableModel) DonHangTable.getModel();
        Object rowData[] = new Object[5];

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getOrderId());
            rowData[0] = list.get(i).getOrderId();
            rowData[1] = list.get(i).getAccountId();
            rowData[2] = list.get(i).getOrderDate();
//            rowData[3] = list.get(i).getStatus();
            rowData[3] = list.get(i).getCustomerId();
            model.addRow(rowData);
        }
    }

    public void renderOrderDetail(int order_id) throws SQLException {

        BUS_OrderDetail bus_detail = new BUS_OrderDetail();
        ArrayList<DTO_OrderDetail> get_all = bus_detail.getList();
        ArrayList<DTO_OrderDetail> list = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        Object rowData[] = new Object[5];

        for (int i = 0; i < get_all.size(); i++) {
            System.out.println(get_all.get(i));
            if (get_all.get(i).getOrder_id() == order_id) {
                list.add(get_all.get(i));
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getOrder_id() == order_id) {
                rowData[0] = list.get(i).getId();
                rowData[1] = list.get(i).getOrder_id();
                rowData[2] = list.get(i).getProduct_id();
                rowData[3] = list.get(i).getQuanity();
                rowData[4] = list.get(i).getPrice();
            }
            model.addRow(rowData);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DonHangLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DonHangTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        XoaBtn = new javax.swing.JButton();
        SuaBtn = new javax.swing.JButton();
        ResetBtn = new javax.swing.JButton();
        OrderIDLbl = new javax.swing.JLabel();
        AccIDLbl = new javax.swing.JLabel();
        CustomerIDLbl = new javax.swing.JLabel();
        ThongTinLbl = new javax.swing.JLabel();
        OrderDateLbl = new javax.swing.JLabel();
        OrderIDTxt = new javax.swing.JTextField();
        AccIDTxt = new javax.swing.JTextField();
        CustomerIDTxt = new javax.swing.JTextField();
        OrderDateCal = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        TimKiemBtn = new javax.swing.JButton();
        HuyTimKiemBtn = new javax.swing.JButton();
        TimKiemLbl = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jtf_order_id = new javax.swing.JTextField();
        jtf_account_id = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jtf_customer_id = new javax.swing.JTextField();
        header1 = new GUI.Components.Header();
        clockGUI1 = new GUI.Components.ClockGUI();
        jButton18 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        DonHangLbl.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        DonHangLbl.setText("ĐƠN HÀNG");

        DonHangTable.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        DonHangTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Account ID", "Order date", "Customer ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        DonHangTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DonHangTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(DonHangTable);

        jPanel3.setBackground(new java.awt.Color(255, 231, 224));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        XoaBtn.setText("Xóa");
        XoaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaBtnActionPerformed(evt);
            }
        });

        SuaBtn.setText("Sửa");
        SuaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuaBtnActionPerformed(evt);
            }
        });

        ResetBtn.setText("Reset");
        ResetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBtnActionPerformed(evt);
            }
        });

        OrderIDLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        OrderIDLbl.setText("Order ID");

        AccIDLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        AccIDLbl.setText("Account ID");

        CustomerIDLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CustomerIDLbl.setText("Customer ID");

        ThongTinLbl.setBackground(new java.awt.Color(255, 255, 255));
        ThongTinLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ThongTinLbl.setForeground(new java.awt.Color(255, 51, 51));
        ThongTinLbl.setText("Thông tin");

        OrderDateLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        OrderDateLbl.setText("Order date");

        CustomerIDTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerIDTxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ThongTinLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(OrderIDLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(OrderIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(OrderDateLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(OrderDateCal, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(AccIDLbl)
                .addGap(6, 6, 6)
                .addComponent(AccIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(CustomerIDLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(CustomerIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(XoaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(SuaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(ResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(ThongTinLbl)
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(OrderIDLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(OrderIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(OrderDateLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(OrderDateCal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AccIDLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(AccIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(CustomerIDLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(CustomerIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(XoaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SuaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(204, 231, 213));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        TimKiemBtn.setText("Tìm kiếm");
        TimKiemBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TimKiemBtnMouseClicked(evt);
            }
        });

        HuyTimKiemBtn.setText("Hủy tìm kiếm");

        TimKiemLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TimKiemLbl.setForeground(new java.awt.Color(255, 0, 51));
        TimKiemLbl.setText("Tìm kiếm");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel23.setText("Order ID");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel26.setText("Account ID");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel27.setText("Customer ID");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TimKiemLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtf_customer_id)
                            .addComponent(jtf_account_id)
                            .addComponent(jtf_order_id, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(HuyTimKiemBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TimKiemBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(TimKiemLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_order_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TimKiemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_account_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HuyTimKiemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtf_customer_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Order ID", "ProductID", "Giá", "Số Lượng"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("ĐƠN HÀNG");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("CHI TIẾT ĐƠN HÀNG");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(419, 419, 419)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(533, 533, 533)
                        .addComponent(DonHangLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clockGUI1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton18)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(DonHangLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clockGUI1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void displayDate() throws ParseException {
        Calendar ca = new GregorianCalendar();
        String day = ca.get(Calendar.DAY_OF_MONTH) + "";
        String month = ca.get(Calendar.MONTH) + 1 + "";
        String year = ca.get(Calendar.YEAR) + "";

        if (day.length() == 1) {
            day = "0" + day;
        }
        if (month.length() == 1) {
            month = "0" + month;
        }

        String dd = year + "-" + month + "-" + day;

        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dd);
        OrderDateCal.setDate(date);
    }
    private void ResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnActionPerformed
        try {
            ////        jDateChooser1.
            OrderIDTxt.setText("");
            AccIDTxt.setText("");
            CustomerIDTxt.setText("");
            displayDate();
        } catch (ParseException ex) {
            Logger.getLogger(OrderGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ResetBtnActionPerformed

    private void DonHangTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DonHangTableMouseClicked
        // TODO add your handling code here:
        int i = DonHangTable.getSelectedRow();
        System.out.println(i);
        OrderIDTxt.setText(DonHangTable.getModel().getValueAt(i, 0).toString());
        AccIDTxt.setText(DonHangTable.getModel().getValueAt(i, 1).toString());
//        jTextField17.setText(jTable1.getModel().getValueAt(i, 3).toString());
        Date date;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(DonHangTable.getModel().getValueAt(i, 2).toString());
            OrderDateCal.setDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(OrderGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        CustomerIDTxt.setText(DonHangTable.getModel().getValueAt(i, 3).toString());

        try {
            renderOrderDetail((int) DonHangTable.getModel().getValueAt(i, 0));
        } catch (SQLException ex) {
            Logger.getLogger(OrderGUI.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_DonHangTableMouseClicked

    private void SuaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuaBtnActionPerformed
        // TODO add your handling code here:
        BUS_Order bus = new BUS_Order();
        DTO_Order dto = new DTO_Order();
        int a = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn sửa chứ!!");
        // new AlertMessageYN();
        if (a == JOptionPane.YES_OPTION) {
            //acc.setAccountName(tfAccountname.getText());
            dto.setAccountId(Integer.parseInt(AccIDTxt.getText()));
            dto.setCustomerId(Integer.parseInt(CustomerIDTxt.getText()));
            dto.setOrderId(Integer.parseInt(OrderIDTxt.getText()));

            String temp = new SimpleDateFormat("yyyy-MM-dd").format(OrderDateCal.getDate());
            dto.setOrderDate(temp);
            int i = DonHangTable.getSelectedRow();
            int id = (int) DonHangTable.getModel().getValueAt(i, 0);
            dto.setAccountId(id);

            try {
                bus.update(dto);
            } catch (SQLException ex) {
                Logger.getLogger(AccountGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_SuaBtnActionPerformed

    private void XoaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaBtnActionPerformed
        // TODO add your handling code here:
        BUS_Order odr = new BUS_Order();
        int i = DonHangTable.getSelectedRow();
        int id = (int) DonHangTable.getModel().getValueAt(i, 0);
        try {
            odr.delete(id);
        } catch (SQLException ex) {
            Logger.getLogger(OrderGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_XoaBtnActionPerformed

    private void CustomerIDTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerIDTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CustomerIDTxtActionPerformed

    private void jButton18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton18MouseClicked
        // TODO add your handling code here:

        this.dispose();
        try {
            new HomeGUI().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(OrderGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton18MouseClicked

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    private void TimKiemBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TimKiemBtnMouseClicked
        // TODO add your handling code here:

        ArrayList<DTO_Order> filter = new ArrayList<>();
        String order_id = jtf_order_id.getText();
        String account_id = jtf_account_id.getText();
        String cusstomer_id = jtf_customer_id.getText();
        if (order_id.length() != 0) {
            filter.clear();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getAccountId() == Integer.parseInt(id)) {
                    filter_id.add(list.get(i));
                }
            }
            filter = filter_id;

        }
        if (ten.length() != 0) {
            filter.clear();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getAccountName().toLowerCase().contains(ten.toLowerCase())) {
                    filter_ten.add(list.get(i));
                }
            }
            filter = filter_ten;

        }
    }//GEN-LAST:event_TimKiemBtnMouseClicked

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
            java.util.logging.Logger.getLogger(OrderGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AccIDLbl;
    private javax.swing.JTextField AccIDTxt;
    private javax.swing.JLabel CustomerIDLbl;
    private javax.swing.JTextField CustomerIDTxt;
    private javax.swing.JLabel DonHangLbl;
    private javax.swing.JTable DonHangTable;
    private javax.swing.JButton HuyTimKiemBtn;
    private com.toedter.calendar.JDateChooser OrderDateCal;
    private javax.swing.JLabel OrderDateLbl;
    private javax.swing.JLabel OrderIDLbl;
    private javax.swing.JTextField OrderIDTxt;
    private javax.swing.JButton ResetBtn;
    private javax.swing.JButton SuaBtn;
    private javax.swing.JLabel ThongTinLbl;
    private javax.swing.JButton TimKiemBtn;
    private javax.swing.JLabel TimKiemLbl;
    private javax.swing.JButton XoaBtn;
    private GUI.Components.ClockGUI clockGUI1;
    private GUI.Components.Header header1;
    private javax.swing.JButton jButton18;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jtf_account_id;
    private javax.swing.JTextField jtf_customer_id;
    private javax.swing.JTextField jtf_order_id;
    // End of variables declaration//GEN-END:variables
}
