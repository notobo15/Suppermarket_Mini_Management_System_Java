/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.BUS_CategoryProduct;
import BUS.BUS_Product;
import DTO.DTO_CategoryProduct;
import DTO.DTO_Product;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
public class ThongKeGUI extends javax.swing.JFrame {
    Random rand = new Random();
    /**
     * Creates new form ThongKeGUI
     */
    public ThongKeGUI() {
        initComponents();
    }
    private void hideExcept(JPanel p1,JPanel p2)
    {
        btnSanPham.setBackground(new Color(242,242,242));
        btnDonHang.setBackground(new Color(242,242,242));
        btnDoanhThu.setBackground(new Color(242,242,242));
        p1.setBackground(new Color(255,255,255));
        p1.setEnabled(false);
        pnlTron.setVisible(false);
        pnlCot.setVisible(false);
        pnlDuong.setVisible(false);
        p2.setVisible(true);
    }
    private void showPieChart() throws SQLException{
        BUS_CategoryProduct bus_categoryproduct = new BUS_CategoryProduct();
        ArrayList<DTO_CategoryProduct> list = bus_categoryproduct.getList();
        BUS_Product bus_product = new BUS_Product();
        ArrayList<DTO_Product> arr = bus_product.getList();
        DefaultPieDataset barDataset = new DefaultPieDataset( );
        
        for (int i = 0; i < list.size(); i++)
        {
            for(int j=0;j<arr.size();j++)
            {
                if(arr.get(j).getCategoryId()==list.get(i).getId())
                {
                    //create dataset
                    barDataset.setValue( list.get(i).getName() , arr.get(j).getQuantity() );  
                }
            }
        }

      //create chart
       JFreeChart piechart = ChartFactory.createPieChart("Số lượng loại sản phẩm",barDataset, false,true,false);//explain
      
        PiePlot piePlot =(PiePlot) piechart.getPlot();
      
       //changing pie chart blocks colors
       for (int i = 0; i < list.size(); i++)
        {
            for(int j=0;j<arr.size();j++)
            {
                if(arr.get(j).getCategoryId()==list.get(i).getId())
                {
                    float r = rand.nextFloat();
                    float g = rand.nextFloat();
                    float b = rand.nextFloat();
                    piePlot.setSectionPaint(list.get(i).getName(), new Color(r,g,b)); 
                }
            }
        }

        piePlot.setBackgroundPaint(Color.white);
        
        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        pnlTron.removeAll();
        pnlTron.add(barChartPanel, BorderLayout.CENTER);
        pnlTron.validate();
    }
     public void showLineChart(){
        //create dataset for the graph
         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(200000, "Amount", "tháng 1");
        dataset.setValue(150000, "Amount", "tháng 2");
        dataset.setValue(18000, "Amount", "tháng 3");
        dataset.setValue(100000, "Amount", "tháng 4");
        dataset.setValue(80000, "Amount", "tháng 5");
        dataset.setValue(0, "Amount", "tháng 6");
        dataset.setValue(0, "Amount", "tháng 7");
        dataset.setValue(0, "Amount", "tháng 8");
        dataset.setValue(0, "Amount", "tháng 9");
        dataset.setValue(0, "Amount", "tháng 10");
        dataset.setValue(0, "Amount", "tháng 11");
        dataset.setValue(0, "Amount", "tháng 12");
        
        //create chart
        JFreeChart linechart = ChartFactory.createLineChart("Doanh thu theo tháng","Tháng","Tiền", 
                dataset, PlotOrientation.VERTICAL, false,true,false);
        
        //create plot object
         CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
       // lineCategoryPlot.setRangeGridlinePaint(Color.BLUE);
        lineCategoryPlot.setBackgroundPaint(Color.white);
        
        //create render object to change the moficy the line properties like color
        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
        Color lineChartColor = new Color(204,0,51);
        lineRenderer.setSeriesPaint(0, lineChartColor);
        
         //create chartPanel to display chart(graph)
        ChartPanel lineChartPanel = new ChartPanel(linechart);
        pnlDuong.removeAll();
        pnlDuong.add(lineChartPanel, BorderLayout.CENTER);
        pnlDuong.validate();
    }
     public void showBarChart(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
         dataset.setValue(200, "Amount", "tháng 1");
        dataset.setValue(150, "Amount", "tháng 2");
        dataset.setValue(18, "Amount", "tháng 3");
        dataset.setValue(100, "Amount", "tháng 4");
        dataset.setValue(80, "Amount", "tháng 5");
        dataset.setValue(0, "Amount", "tháng 6");
        dataset.setValue(0, "Amount", "tháng 7");
        dataset.setValue(0, "Amount", "tháng 8");
        dataset.setValue(0, "Amount", "tháng 9");
        dataset.setValue(0, "Amount", "tháng 10");
        dataset.setValue(0, "Amount", "tháng 11");
        dataset.setValue(0, "Amount", "tháng 12");
        
        JFreeChart chart = ChartFactory.createBarChart("Số lượng đơn hàng","Tháng","Số lượng", 
                dataset, PlotOrientation.VERTICAL, false,true,false);
        
        CategoryPlot categoryPlot = chart.getCategoryPlot();
        //categoryPlot.setRangeGridlinePaint(Color.BLUE);
        categoryPlot.setBackgroundPaint(Color.WHITE);
        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
        Color clr3 = new Color(204,0,51);
        renderer.setSeriesPaint(0, clr3);
        
        ChartPanel barpChartPanel = new ChartPanel(chart);
        pnlCot.removeAll();
        pnlCot.add(barpChartPanel, BorderLayout.CENTER);
        pnlCot.validate();
        
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        header1 = new GUI.Components.Header();
        jPanel3 = new javax.swing.JPanel();
        Title = new javax.swing.JPanel();
        jButton18 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnSanPham = new javax.swing.JPanel();
        lblSanPham = new javax.swing.JLabel();
        btnDonHang = new javax.swing.JPanel();
        lblDonHang = new javax.swing.JLabel();
        btnDoanhThu = new javax.swing.JPanel();
        lblDoanhThu = new javax.swing.JLabel();
        pnlTron = new javax.swing.JPanel();
        pnlCot = new javax.swing.JPanel();
        pnlDuong = new javax.swing.JPanel();

        jMenu1.setText("jMenu1");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu1.setDebugGraphicsOptions(javax.swing.DebugGraphics.FLASH_OPTION);

        jMenuItem1.setText("jMenuItem1");
        jMenu1.add(jMenuItem1);
        jMenuItem1.getAccessibleContext().setAccessibleParent(jMenu1);

        jMenuItem2.setText("jMenuItem2");
        jMenu1.add(jMenuItem2);
        jMenuItem2.getAccessibleContext().setAccessibleParent(jMenu1);

        jMenuItem3.setText("jMenuItem3");
        jMenu1.add(jMenuItem3);
        jMenuItem3.getAccessibleContext().setAccessibleParent(jMenu1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(header1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel3.setBackground(new java.awt.Color(245, 245, 245));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Title.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Title.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        Title.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 10, -1, 50));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("THỐNG KÊ");
        Title.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 80));

        jPanel3.add(Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 80));

        btnSanPham.setFocusable(false);
        btnSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSanPhamMouseClicked(evt);
            }
        });
        btnSanPham.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSanPham.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblSanPham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSanPham.setText("Sản phẩm");
        lblSanPham.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblSanPham.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSanPham.setFocusable(false);
        btnSanPham.add(lblSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 28));

        jPanel3.add(btnSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 400, 28));

        btnDonHang.setFocusable(false);
        btnDonHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDonHangMouseClicked(evt);
            }
        });
        btnDonHang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDonHang.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblDonHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDonHang.setText("Đơn hàng");
        lblDonHang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblDonHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDonHang.setFocusable(false);
        btnDonHang.add(lblDonHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 28));

        jPanel3.add(btnDonHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 400, 28));

        btnDoanhThu.setFocusable(false);
        btnDoanhThu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDoanhThuMouseClicked(evt);
            }
        });
        btnDoanhThu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDoanhThu.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblDoanhThu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDoanhThu.setText("Doanh thu");
        lblDoanhThu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblDoanhThu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDoanhThu.setFocusable(false);
        btnDoanhThu.add(lblDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 28));

        jPanel3.add(btnDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 80, 400, 28));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 92, 1200, 108));

        pnlTron.setBackground(new java.awt.Color(255, 255, 255));
        pnlTron.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlTron.setLayout(new java.awt.BorderLayout());
        getContentPane().add(pnlTron, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 1200, 500));

        pnlCot.setBackground(new java.awt.Color(255, 255, 255));
        pnlCot.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlCot.setLayout(new java.awt.BorderLayout());
        getContentPane().add(pnlCot, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 1200, 500));

        pnlDuong.setBackground(new java.awt.Color(255, 255, 255));
        pnlDuong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlDuong.setLayout(new java.awt.BorderLayout());
        getContentPane().add(pnlDuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 1200, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSanPhamMouseClicked
        // TODO add your handling code here:
        hideExcept(btnSanPham, pnlTron);
        try {
            showPieChart();
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSanPhamMouseClicked

    private void btnDonHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDonHangMouseClicked
        // TODO add your handling code here:
        hideExcept(btnDonHang, pnlCot);
        showBarChart();
    }//GEN-LAST:event_btnDonHangMouseClicked

    private void btnDoanhThuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDoanhThuMouseClicked
        // TODO add your handling code here:
        hideExcept(btnDoanhThu, pnlDuong);
        showLineChart();
    }//GEN-LAST:event_btnDoanhThuMouseClicked

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
            java.util.logging.Logger.getLogger(ThongKeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongKeGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Title;
    private javax.swing.JPanel btnDoanhThu;
    private javax.swing.JPanel btnDonHang;
    private javax.swing.JPanel btnSanPham;
    private GUI.Components.Header header1;
    private javax.swing.JButton jButton18;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblDoanhThu;
    private javax.swing.JLabel lblDonHang;
    private javax.swing.JLabel lblSanPham;
    private javax.swing.JPanel pnlCot;
    private javax.swing.JPanel pnlDuong;
    private javax.swing.JPanel pnlTron;
    // End of variables declaration//GEN-END:variables
}
