/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.BUS_Product;
import DTO.DTO_Product;
import DTO.DTO_CategoryProduct;
import BUS.BUS_CategoryProduct;
import BUS.BUS_Suppilier;
import DTO.DTO_Suppilier;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
// import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import BUS.BUS_Account;
import DAO.DAO_Account;
import DTO.DTO_Account;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import jxl.write.WritableSheet;
import org.apache.poi.ss.usermodel.Cell;
import static org.apache.poi.ss.usermodel.CellType.BLANK;
import static org.apache.poi.ss.usermodel.CellType.BOOLEAN;
import static org.apache.poi.ss.usermodel.CellType.ERROR;
import static org.apache.poi.ss.usermodel.CellType.FORMULA;
import static org.apache.poi.ss.usermodel.CellType.NUMERIC;
import static org.apache.poi.ss.usermodel.CellType.STRING;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author EV
 */
public class ProductGUI extends javax.swing.JFrame {

    private ArrayList<DTO_Product> list = new ArrayList<>();

    public ProductGUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        try {
            BUS_Product bus_product = new BUS_Product();
            list = bus_product.getList();
            addRowToJTable(list);
        } catch (SQLException ex) {
            Logger.getLogger(SuppilierGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        input_productId.setEnabled(false);
        input_productId.setText("0");
        btn_themsanpham.setEnabled(true);
        btn_suasanpham.setEnabled(false);
        btn_xoasanpham.setEnabled(false);
        btn_themDB.setEnabled(false);
    }

    public void clear() {
        input_productId.setText("");
        input_ten.setText("");
        input_mota.setText("");
        input_gia.setText("");
        input_trongluong.setText("");
        input_noiban.setText("");
        input_maloai.setText("");
        input_soluong.setText("");
        input_img.setText("");
        Date date;

        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse("2000-01-01");
            input_hansudung.setDate(date);

        } catch (ParseException ex) {
            Logger.getLogger(AccountGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addRowToJTable(ArrayList<DTO_Product> list) throws SQLException {
        DefaultTableModel model = (DefaultTableModel) TableSanPham.getModel();
        model.setRowCount(0);
        Object rowData[] = new Object[11];
        for (int i = 0; i < list.size(); i++) {
            rowData[0] = list.get(i).getProductId();
            rowData[1] = list.get(i).getName();
            rowData[2] = list.get(i).getDescription();
            rowData[3] = list.get(i).getPrice();
            rowData[4] = list.get(i).getImg();
            rowData[5] = list.get(i).getMass();
            rowData[6] = list.get(i).gettrademark();
            rowData[7] = list.get(i).getCategoryId();
            rowData[8] = list.get(i).getQuantity();
            rowData[9] = list.get(i).isStatus();
            rowData[10] = list.get(i).getExpireDate();
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
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableSanPham = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        input_gia = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        input_trongluong = new javax.swing.JTextField();
        input_ten = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        input_noiban = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        input_mota = new javax.swing.JTextArea();
        input_soluong = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        input_hansudung = new com.toedter.calendar.JDateChooser();
        jlb_img = new javax.swing.JLabel();
        input_maloai = new javax.swing.JTextField();
        input_img = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        input_productId = new javax.swing.JTextField();
        btn_themsanpham = new javax.swing.JButton();
        btn_xoasanpham = new javax.swing.JButton();
        btn_resetsanpham = new javax.swing.JButton();
        btn_suasanpham = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        clockGUI1 = new GUI.Components.ClockGUI();
        header1 = new GUI.Components.Header();
        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        input_timkiemma = new javax.swing.JTextField();
        input_timkiemten = new javax.swing.JTextField();
        btn_timkiemsanpham = new javax.swing.JButton();
        btn_huytimkiemsanpham = new javax.swing.JButton();
        input_timkiemmaloai = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btn_nhapExcel = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btn_xuatExcel = new javax.swing.JButton();
        btn_themDB = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(141, 169, 196));

        TableSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên", "Mô tả", "Giá", "Hình", "Trọng lượng", "Nơi bán", "Mã loại", "Số lượng", "Tình trạng", "Hạn sử dụng"
            }
        ));
        TableSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableSanPham);

        jPanel6.setBackground(new java.awt.Color(208, 244, 222));

        jPanel7.setBackground(new java.awt.Color(208, 244, 222));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Tên");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Mô tả");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Giá");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Trọng lượng");

        input_ten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_tenActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("Nơi bán");

        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setText("Mã loại");

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setText("Số lượng");

        input_noiban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_noibanActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setText("Thông tin");

        input_mota.setColumns(20);
        input_mota.setRows(5);
        jScrollPane2.setViewportView(input_mota);

        jLabel21.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel21.setText("Hạn sử dụng");

        jLabel22.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel22.setText("Hình");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("ID");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(input_ten, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(input_productId))))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlb_img, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(input_img))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(input_hansudung, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addComponent(input_gia)
                    .addComponent(input_trongluong)
                    .addComponent(input_noiban)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(input_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(input_maloai))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(input_productId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(input_gia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(input_ten, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(input_trongluong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(input_noiban, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(input_maloai, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(input_soluong)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(input_hansudung, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(input_img, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlb_img, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        btn_themsanpham.setBackground(new java.awt.Color(103, 148, 54));
        btn_themsanpham.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_themsanpham.setForeground(new java.awt.Color(255, 255, 255));
        btn_themsanpham.setText("Thêm");
        btn_themsanpham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themsanphamActionPerformed(evt);
            }
        });

        btn_xoasanpham.setBackground(new java.awt.Color(217, 4, 41));
        btn_xoasanpham.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_xoasanpham.setForeground(new java.awt.Color(255, 255, 255));
        btn_xoasanpham.setText("Xóa");
        btn_xoasanpham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoasanphamActionPerformed(evt);
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

        btn_suasanpham.setBackground(new java.awt.Color(255, 202, 58));
        btn_suasanpham.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_suasanpham.setForeground(new java.awt.Color(255, 255, 255));
        btn_suasanpham.setText("Sửa");
        btn_suasanpham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suasanphamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_themsanpham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_suasanpham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_xoasanpham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_resetsanpham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(btn_themsanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_suasanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_xoasanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_resetsanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel19.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel19.setText("Hàng hóa");

        jPanel3.setBackground(new java.awt.Color(241, 192, 232));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel18.setText("Tìm kiếm");

        jLabel16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel16.setText("Mã sản phẩm");

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setText("Tên sản phẩm");

        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setText("Mã loại");

        input_timkiemten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_timkiemtenActionPerformed(evt);
            }
        });

        btn_timkiemsanpham.setBackground(new java.awt.Color(103, 148, 54));
        btn_timkiemsanpham.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_timkiemsanpham.setForeground(new java.awt.Color(255, 255, 255));
        btn_timkiemsanpham.setText("Tìm kiếm");
        btn_timkiemsanpham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemsanphamActionPerformed(evt);
            }
        });

        btn_huytimkiemsanpham.setBackground(new java.awt.Color(217, 4, 41));
        btn_huytimkiemsanpham.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btn_huytimkiemsanpham.setForeground(new java.awt.Color(255, 255, 255));
        btn_huytimkiemsanpham.setText("Hủy tìm kiếm");
        btn_huytimkiemsanpham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huytimkiemsanphamActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(241, 192, 232));

        btn_nhapExcel.setBackground(new java.awt.Color(20, 168, 255));
        btn_nhapExcel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_nhapExcel.setForeground(new java.awt.Color(255, 255, 255));
        btn_nhapExcel.setText("NHẬP");
        btn_nhapExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nhapExcelActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setText("Nhập Excel");

        jLabel20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel20.setText("Xuất Excel");

        btn_xuatExcel.setBackground(new java.awt.Color(103, 148, 54));
        btn_xuatExcel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_xuatExcel.setForeground(new java.awt.Color(255, 255, 255));
        btn_xuatExcel.setText("XUẤT");
        btn_xuatExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xuatExcelActionPerformed(evt);
            }
        });

        btn_themDB.setBackground(new java.awt.Color(0, 204, 204));
        btn_themDB.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_themDB.setForeground(new java.awt.Color(255, 255, 255));
        btn_themDB.setText("Thêm Vào DB");
        btn_themDB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_themDBMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_nhapExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_themDB, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_xuatExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_themDB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_nhapExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_xuatExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel14)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(input_timkiemten, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(input_timkiemma, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(input_timkiemmaloai))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_huytimkiemsanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_timkiemsanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(input_timkiemma, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(input_timkiemten, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(input_timkiemmaloai, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_timkiemsanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_huytimkiemsanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(102, 102, 102)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(251, 251, 251)
                        .addComponent(clockGUI1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(jButton18)))
                .addContainerGap())
            .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clockGUI1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_timkiemsanphamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemsanphamActionPerformed
        // TODO add your handling code here:
        String id = input_timkiemma.getText();
        String ten = input_timkiemten.getText();
        String maloai = input_timkiemmaloai.getText();
        ArrayList<DTO_Product> filter_id = new ArrayList<>();
        ArrayList<DTO_Product> filter_ten = new ArrayList<>();
        ArrayList<DTO_Product> filter_maloai = new ArrayList<>();
        ArrayList<DTO_Product> filter = new ArrayList<>();
        if (id.length() != 0) {
            filter.clear();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getProductId() == Integer.parseInt(id)) {
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

        if (maloai.length() != 0) {
            filter.clear();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getCategoryId() == Integer.parseInt(maloai)) {
                    filter_maloai.add(list.get(i));
                }
            }
            filter = filter_maloai;
        }

        if (ten.length() != 0 && id.length() != 0 && maloai.length() != 0) {
            filter.clear();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getName().toLowerCase().contains(ten.toLowerCase()) && list.get(i).getProductId() == Integer.parseInt(id) && list.get(i).getCategoryId() == Integer.parseInt(maloai)) {
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

    }//GEN-LAST:event_btn_timkiemsanphamActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        btn_themsanpham.setEnabled(true);
        btn_suasanpham.setEnabled(false);
        btn_xoasanpham.setEnabled(false);

        clear();
        try {
            DefaultTableModel model = (DefaultTableModel) TableSanPham.getModel();
            model.setRowCount(0);
            BUS_Product bus_product = new BUS_Product();
            list = bus_product.getList();
            addRowToJTable(list);
        } catch (SQLException ex) {
            Logger.getLogger(SuppilierGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btn_xuatExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xuatExcelActionPerformed
        // TODO add your handling code here:

        try {
            JFileChooser jfile = new JFileChooser();
            jfile.setSelectedFile(new File("untitled.xls"));

            int seleted = jfile.showSaveDialog(this);

            if (seleted == JFileChooser.APPROVE_OPTION) {
                String FilePath = jfile.getSelectedFile().getPath();
                System.out.println(FilePath);

                HSSFWorkbook workbook = new HSSFWorkbook();
                HSSFSheet sheet = workbook.createSheet("product");
                BUS_Product bus_product = new BUS_Product();
                ArrayList<DTO_Product> list = bus_product.getList();
                int rowPos = 0;
                HSSFRow row = sheet.createRow(rowPos);
                row.createCell(0, CellType.NUMERIC).setCellValue("id");
                row.createCell(1, CellType.STRING).setCellValue("ten");
                row.createCell(2, CellType.STRING).setCellValue("mo ta");
                row.createCell(3, CellType.STRING).setCellValue("gia");
                row.createCell(4, CellType.STRING).setCellValue("hinh");
                row.createCell(5, CellType.STRING).setCellValue("trong luong");
                row.createCell(6, CellType.STRING).setCellValue("noi ban");
                row.createCell(7, CellType.NUMERIC).setCellValue("ma loai");
                row.createCell(8, CellType.STRING).setCellValue("so luong");
                row.createCell(9, CellType.STRING).setCellValue("tinh trang");
                row.createCell(10, CellType.STRING).setCellValue("han su dung");

                for (int i = 0; i < list.size(); i++) {
                    rowPos++;
                    row = sheet.createRow(rowPos);
                    row.createCell(0, CellType.NUMERIC).setCellValue(list.get(i).getProductId());
                    row.createCell(1, CellType.STRING).setCellValue(list.get(i).getName());
                    row.createCell(2, CellType.STRING).setCellValue(list.get(i).getDescription());
                    row.createCell(3, CellType.STRING).setCellValue(list.get(i).getPrice());
                    row.createCell(4, CellType.STRING).setCellValue(list.get(i).getImg());
                    row.createCell(5, CellType.STRING).setCellValue(list.get(i).getMass());
                    row.createCell(6, CellType.STRING).setCellValue(list.get(i).gettrademark());
                    row.createCell(7, CellType.NUMERIC).setCellValue(list.get(i).getCategoryId());
                    row.createCell(8, CellType.STRING).setCellValue(list.get(i).getQuantity());
                    row.createCell(9, CellType.STRING).setCellValue(list.get(i).isStatus());
                    row.createCell(10, CellType.STRING).setCellValue(list.get(i).getExpireDate());

                }

                File file = new File(FilePath);
                try {
                    FileOutputStream fos = new FileOutputStream(file);
                    workbook.write(fos);
                    fos.close();

                } catch (Exception e) {
                    System.out.println("GUI.Table.jButton1MouseClicked()");
                }

            }
            if (seleted == JFileChooser.CANCEL_OPTION) {
            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_xuatExcelActionPerformed

    private void btn_nhapExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nhapExcelActionPerformed
        // TODO add your handling code here:
        btn_themDB.setEnabled(true);
        try {

            JFileChooser jfile = new JFileChooser();
            jfile.setFileFilter(new FileFilter() {

                public String getDescription() {
                    return "File Excel (*.xls)";
                }

                public boolean accept(File f) {
                    if (f.isDirectory()) {
                        return true;
                    } else {
                        String filename = f.getName().toLowerCase();
                        return filename.endsWith(".xls");
                    }
                }
            });
            int seleted = jfile.showOpenDialog(this);
            if (seleted == JFileChooser.APPROVE_OPTION) {
                String FilePath = jfile.getSelectedFile().getPath();

                FileInputStream fis = new FileInputStream(new File(FilePath));
                HSSFWorkbook workbook = new HSSFWorkbook(fis);
                HSSFSheet sheet = workbook.getSheetAt(0);
                sheet.setRowBreak(0);
                FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

                DefaultTableModel model = (DefaultTableModel) TableSanPham.getModel();
                while (model.getRowCount() > 0) {
                    model.removeRow(0);
                }
                int i = 0;
                ArrayList<DTO_Product> list = new ArrayList<>();
                for (Row row : sheet) {
                    DTO_Product acc = new DTO_Product();
                    if (i > 0) {
                        ArrayList<String> item = new ArrayList<String>();
                        for (Cell cell : row) {

                            switch (evaluator.evaluateInCell(cell).getCellType()) {
                                case BOOLEAN:
                                    item.add("" + cell.getBooleanCellValue());
//                                System.out.println(cell.getBooleanCellValue());
                                    break;
                                case NUMERIC:
                                    item.add("" + cell.getNumericCellValue());
//                                System.out.println(cell.getNumericCellValue());
                                    break;
                                case STRING:
//                                System.out.println(cell.getStringCellValue());
                                    item.add("" + cell.getStringCellValue());
                                    break;
                                case BLANK:
                                    break;
                                case ERROR:
//                                System.out.println(cell.getErrorCellValue());
                                    break;

                                case FORMULA:
                                    break;
                            }

                        }
                        Object rowData[] = new Object[11];
                        System.out.println(item.get(0));
                        rowData[0] = item.get(0);
                        rowData[1] = item.get(1);
                        rowData[2] = item.get(2);
                        rowData[3] = item.get(3);
                        rowData[4] = item.get(4);
                        rowData[5] = item.get(5);
                        rowData[6] = item.get(6);
                        rowData[7] = item.get(7);
                        rowData[8] = item.get(8);
                        rowData[9] = item.get(9);
                        rowData[10] = item.get(10);
                        model.addRow(rowData);

                    }

                    i++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_btn_nhapExcelActionPerformed

    private void jButton18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton18MouseClicked
        // TODO add your handling code here:

        this.dispose();
        try {
            new HomeGUI().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(ProductGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton18MouseClicked

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    private void btn_themDBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_themDBMouseClicked
        // TODO add your handling code here:

        DefaultTableModel model = (DefaultTableModel) TableSanPham.getModel();
        ArrayList<DTO_Product> list = new ArrayList<>();
        BUS_Product bus_product = new BUS_Product();
        for (int count = 0; count < model.getRowCount(); count++) {
            DTO_Product pro = new DTO_Product();
            pro.setName(model.getValueAt(count, 1).toString());
            pro.setDescription(model.getValueAt(count, 2).toString());
            pro.setPrice(Float.parseFloat((String) model.getValueAt(count, 3)));
            pro.setImg(model.getValueAt(count, 4).toString());
            pro.setMass(model.getValueAt(count, 5).toString());
            pro.settrademark(model.getValueAt(count, 6).toString());
            pro.setCategoryId((int) Float.parseFloat((String) model.getValueAt(count, 7)));
            pro.setQuantity(Float.parseFloat((String) model.getValueAt(count, 8)));
            pro.setExpireDate(model.getValueAt(count, 10).toString());

            try {
                bus_product.add(pro);
            } catch (SQLException ex) {
                Logger.getLogger(ProductGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_btn_themDBMouseClicked

    private void btn_xoasanphamActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_xoasanphamActionPerformed
        // TODO add your handling code here:
        BUS_Product tmp = new BUS_Product();
        int i = TableSanPham.getSelectedRow();
        int id = (int) TableSanPham.getModel().getValueAt(i, 0);
        try {
            tmp.delete(id);
        } catch (SQLException ex) {
            Logger.getLogger(AccountGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// GEN-LAST:event_btn_xoasanphamActionPerformed

    private void btn_suasanphamActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_suasanphamActionPerformed
        // TODO add your handling code here:

        DTO_Product pro = new DTO_Product();
        BUS_Product tmp = new BUS_Product();
        int a = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn sửa chứ!!");

        if (a == JOptionPane.YES_OPTION) {

            pro.setProductId(Integer.parseInt(input_productId.getText()));
            pro.setName(input_ten.getText());
            pro.setDescription(input_mota.getText());
            pro.setPrice(Float.parseFloat(input_gia.getText()));
            pro.setMass(input_trongluong.getText());
            pro.settrademark(input_noiban.getText());
            pro.setCategoryId(Integer.parseInt(input_maloai.getText()));
            pro.setQuantity(Float.parseFloat(input_soluong.getText()));
            pro.setImg(input_img.getText());
            String temp = new SimpleDateFormat("yyyy-MM-dd").format(input_hansudung.getDate());
            pro.setExpireDate(temp);

            try {
                tmp.update(pro);
            } catch (Exception ex) {
                Logger.getLogger(ProductGUI.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }// GEN-LAST:event_btn_suasanphamActionPerformed

    private void btn_resetsanphamActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_resetsanphamActionPerformed
        // TODO add your handling code here:
        clear();
        input_productId.setEnabled(false);
        input_productId.setText("0");
        ImageIcon imageIcon = new ImageIcon(""); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(180, 150, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);  // transform it back
        jlb_img.setIcon(imageIcon);

        btn_themsanpham.setEnabled(true);
        btn_suasanpham.setEnabled(false);
        btn_xoasanpham.setEnabled(false);

    }// GEN-LAST:event_btn_resetsanphamActionPerformed

    private void btn_themsanphamActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_themsanphamActionPerformed
        // TODO add your handling code here:

        DTO_Product pro = new DTO_Product();
        BUS_Product tmp = new BUS_Product();

        int a = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn them chứ!!");

        if (a == JOptionPane.YES_OPTION) {
            pro.setProductId(Integer.parseInt(input_productId.getText()));
            pro.setName(input_ten.getText());
            pro.setDescription(input_mota.getText());
            if (input_gia.getText().equals("")) {
                input_gia.setText("0");
            }
            pro.setPrice(Float.parseFloat(input_gia.getText()));
            pro.setMass(input_trongluong.getText());
            pro.settrademark(input_noiban.getText());

            pro.setCategoryId(Integer.parseInt(input_maloai.getText()));

            if (input_soluong.getText().equals("")) {
                input_soluong.setText("0");
            }
            pro.setQuantity(Float.parseFloat(input_soluong.getText()));

            pro.setImg(input_img.getText());

            String temp = new SimpleDateFormat("yyyy-MM-dd").format(input_hansudung.getDate());
            pro.setExpireDate(temp);

            try {
                tmp.add(pro);
            } catch (Exception ex) {
                Logger.getLogger(ProductGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }// GEN-LAST:event_btn_themsanphamActionPerformed

    private void btn_luusanphamActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_luusanphamActionPerformed
        // TODO add your handling code here:

        try {
            DefaultTableModel model = (DefaultTableModel) TableSanPham.getModel();
            model.setRowCount(0);
            addRowToJTable(list);
        } catch (SQLException ex) {
            Logger.getLogger(AccountGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }// GEN-LAST:event_btn_luusanphamActionPerformed

    private void input_noibanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_input_noibanActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_input_noibanActionPerformed

    private void input_tenActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_input_tenActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_input_tenActionPerformed

    private void input_timkiemtenActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_input_timkiemtenActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_input_timkiemtenActionPerformed

    private void btn_huytimkiemsanphamActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_huytimkiemsanphamActionPerformed
        // TODO add your handling code here:
        BUS_Product bus_product = new BUS_Product();

        input_timkiemma.setText("");
        input_timkiemten.setText("");
        input_timkiemmaloai.setText("");

        try {
            list = bus_product.getList();
            addRowToJTable(list);

        } catch (SQLException ex) {
            Logger.getLogger(SuppilierGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }// GEN-LAST:event_btn_huytimkiemsanphamActionPerformed

    private void input_maloaiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_input_maloaiActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_input_maloaiActionPerformed

    private void TableSanPhamMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_TableSanPhamMouseClicked
        // TODO add your handling code here:
        int i = TableSanPham.getSelectedRow();
        System.out.println(i);

        input_productId.setText(TableSanPham.getModel().getValueAt(i, 0).toString());
        input_ten.setText(TableSanPham.getModel().getValueAt(i, 1).toString());
        input_mota.setText(TableSanPham.getModel().getValueAt(i, 2).toString());
        input_gia.setText(TableSanPham.getModel().getValueAt(i, 3).toString());
        input_trongluong.setText(TableSanPham.getModel().getValueAt(i, 5).toString());
        input_noiban.setText(TableSanPham.getModel().getValueAt(i, 6).toString());
        input_maloai.setText(TableSanPham.getModel().getValueAt(i, 7).toString());
        input_soluong.setText(TableSanPham.getModel().getValueAt(i, 8).toString());

        Date date;

        try {
            System.out.println("birst date :" + TableSanPham.getModel().getValueAt(i, 10).toString());
            date = new SimpleDateFormat("yyyy-MM-dd").parse(TableSanPham.getModel().getValueAt(i, 10).toString());
            input_hansudung.setDate(date);

        } catch (ParseException ex) {
            Logger.getLogger(AccountGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("\\Images\\products\\" + TableSanPham.getModel().getValueAt(i, 4))); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(180, 150, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);  // transform it back
        jlb_img.setIcon(imageIcon);

        btn_themsanpham.setEnabled(false);
        btn_suasanpham.setEnabled(true);
        btn_xoasanpham.setEnabled(true);

    }// GEN-LAST:event_TableSanPhamMouseClicked

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
            java.util.logging.Logger.getLogger(ProductGUI.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductGUI.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductGUI.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductGUI.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableSanPham;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btn_huytimkiemsanpham;
    private javax.swing.JButton btn_nhapExcel;
    private javax.swing.JButton btn_resetsanpham;
    private javax.swing.JButton btn_suasanpham;
    private javax.swing.JButton btn_themDB;
    private javax.swing.JButton btn_themsanpham;
    private javax.swing.JButton btn_timkiemsanpham;
    private javax.swing.JButton btn_xoasanpham;
    private javax.swing.JButton btn_xuatExcel;
    private GUI.Components.ClockGUI clockGUI1;
    private GUI.Components.Header header1;
    private javax.swing.JTextField input_gia;
    private com.toedter.calendar.JDateChooser input_hansudung;
    private javax.swing.JTextField input_img;
    private javax.swing.JTextField input_maloai;
    private javax.swing.JTextArea input_mota;
    private javax.swing.JTextField input_noiban;
    private javax.swing.JTextField input_productId;
    private javax.swing.JTextField input_soluong;
    private javax.swing.JTextField input_ten;
    private javax.swing.JTextField input_timkiemma;
    private javax.swing.JTextField input_timkiemmaloai;
    private javax.swing.JTextField input_timkiemten;
    private javax.swing.JTextField input_trongluong;
    private javax.swing.JButton jButton18;
    private javax.swing.JFileChooser jFileChooser1;
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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlb_img;
    // End of variables declaration//GEN-END:variables
}
