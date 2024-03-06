import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import common.OpenPdf;
import dao.ConnectionProvider;
import dao.InventoryUtils;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ManageOrder extends javax.swing.JFrame {

    private int customer_pk = 0;
    private int product_pk = 0;
    private int finalTotalPrice = 0;
    private String orderId = "";

    public ManageOrder() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void clearProductFields() {
        product_pk = 0;
        txtProductName.setText("");
        txtProductPrice.setText("");
        txtProductDescription.setText("");
        txtOrderQuantity.setText("");
    }    
    
    public String getUniqueId(String prefix) {
        return prefix + System.nanoTime();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCustomerList = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableProductList = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableCart = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCustomerName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCustomerMobileNumber = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCustomerEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtProductPrice = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtProductDescription = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtOrderQuantity = new javax.swing.JTextField();
        btnAddToCart = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        lblFinalTotalPrice = new javax.swing.JLabel();
        btnSaveOrderDetails = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Manage Order");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(306, 306, 306))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jLabel2.setText("Customer List");

        tableCustomerList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Mobile Number", "Email"
            }
        ));
        tableCustomerList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCustomerListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCustomerList);

        jLabel3.setText("Product List");

        tableProductList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price", "Quantity", "Description", "Category ID", "Category Name"
            }
        ));
        tableProductList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableProductList);

        tableCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Name", "Quantity", "Price", "Description", "Sub Total"
            }
        ));
        tableCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCartMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableCart);

        jLabel4.setText("Cart");

        jLabel5.setText("Selected Customer:");

        jLabel6.setText("Name:");

        jLabel7.setText("Mobile Number:");

        jLabel8.setText("Email:");

        jLabel9.setText("Selected Product:");

        jLabel10.setText("Product Name:");

        jLabel11.setText("Product Price:");

        jLabel12.setText("Product Description:");

        jLabel13.setText("Order Quantity:");

        btnAddToCart.setText("Add To Cart");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });

        jLabel14.setText("Total Amount Rs.");

        lblFinalTotalPrice.setText("0000");

        btnSaveOrderDetails.setText("Save Order Details");
        btnSaveOrderDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveOrderDetailsActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 270, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(71, 71, 71))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtCustomerEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                .addComponent(txtCustomerMobileNumber, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCustomerName, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(txtProductName)
                            .addComponent(txtProductPrice)
                            .addComponent(txtProductDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtOrderQuantity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddToCart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jLabel4)
                        .addGap(179, 179, 179))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFinalTotalPrice)
                                .addGap(84, 84, 84))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSaveOrderDetails, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnReset, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(45, 45, 45))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10)
                    .addComponent(jLabel14)
                    .addComponent(lblFinalTotalPrice))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCustomerMobileNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(btnSaveOrderDetails))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProductPrice)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12)
                    .addComponent(btnReset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProductDescription)
                    .addComponent(txtCustomerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(btnClose))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtOrderQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAddToCart)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        txtCustomerName.setEditable(false);
        txtCustomerMobileNumber.setEditable(false);
        txtCustomerEmail.setEditable(false);

        txtProductName.setEditable(false);
        txtProductPrice.setEditable(false);
        txtProductDescription.setEditable(false);

        DefaultTableModel model = (DefaultTableModel) tableCustomerList.getModel();
        DefaultTableModel productModel = (DefaultTableModel) tableProductList.getModel();
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from customer");
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("customer_pk"), rs.getString("name"), rs.getString("mobileNumber"), rs.getString("email")});
            }

            rs = st.executeQuery("select * from product inner join category on product.category_fk = category.category_pk");
            while (rs.next()) {
                productModel.addRow(new Object[]{rs.getString("product_pk"), rs.getString("name"), rs.getString("price"), rs.getString("quantity"), rs.getString("description"), rs.getString("category_fk"), rs.getString(8)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_formComponentShown

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void tableCustomerListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCustomerListMouseClicked
        int index = tableCustomerList.getSelectedRow();
        TableModel model = tableCustomerList.getModel();

        String id = model.getValueAt(index, 0).toString();
        customer_pk = Integer.parseInt(id);

        String name = model.getValueAt(index, 1).toString();
        txtCustomerName.setText(name);

        String mobileNumber = model.getValueAt(index, 2).toString();
        txtCustomerMobileNumber.setText(mobileNumber);

        String email = model.getValueAt(index, 3).toString();
        txtCustomerEmail.setText(email);
    }//GEN-LAST:event_tableCustomerListMouseClicked

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        setVisible(false);
        new ManageOrder().setVisible(true);
    }//GEN-LAST:event_btnResetActionPerformed

    private void tableProductListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductListMouseClicked
        int index = tableProductList.getSelectedRow();
        TableModel model = tableProductList.getModel();

        String id = model.getValueAt(index, 0).toString();
        product_pk = Integer.parseInt(id);

        String productName = model.getValueAt(index, 1).toString();
        txtProductName.setText(productName);

        String productPrice = model.getValueAt(index, 2).toString();
        txtProductPrice.setText(productPrice);

        String productDescription = model.getValueAt(index, 3).toString();
        txtProductDescription.setText(productDescription);
    }//GEN-LAST:event_tableProductListMouseClicked

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
        String noOfUnits = txtOrderQuantity.getText();
        if (!noOfUnits.equals(" ")) {
            String productName = txtProductName.getText();
            String productPrice = txtProductPrice.getText();
            String productDescription = txtProductDescription.getText();

            int totalPrice = Integer.parseInt(txtOrderQuantity.getText()) * Integer.parseInt(productPrice);

            int checkStock = 0;
            int checkProductAlreadyExistInCart = 0;

            try {
                Connection con = ConnectionProvider.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from product where product_pk=" + product_pk + "");
                while (rs.next()) {
                    if (rs.getInt("quantity") >= Integer.parseInt(noOfUnits)) {
                        checkStock = 1;
                    } else {
                        JOptionPane.showMessageDialog(null, "Product is out of stock. Only " + rs.getInt("quantity") + "Left");
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            if (checkStock == 1) {
                DefaultTableModel model = (DefaultTableModel) tableCart.getModel();
                if (tableCart.getRowCount() != 0) {
                    for (int i = 0; i < tableCart.getRowCount(); i++) {
                        if (Integer.parseInt(model.getValueAt(i, 0).toString()) == product_pk) {
                            checkProductAlreadyExistInCart = i;
                            JOptionPane.showMessageDialog(null, "Product already exist in cart");
                        }
                    }
                }
                if(checkProductAlreadyExistInCart == 0) {
                    model.addRow(new Object[]{product_pk, productName, noOfUnits, productPrice, productDescription, totalPrice});
                    finalTotalPrice = finalTotalPrice + totalPrice;
                    lblFinalTotalPrice.setText(String.valueOf(finalTotalPrice));
                    JOptionPane.showMessageDialog(null, "Added Successfully");
                } else {
                }
                clearProductFields();
            }

        } else {
            JOptionPane.showMessageDialog(null, "No of Quantity and product field is required");
        }
    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void tableCartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCartMouseClicked
        int index = tableCart.getSelectedRow();
        int a = JOptionPane.showConfirmDialog(null, "Do you want to remove this product", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            TableModel model = tableCart.getModel();
            String subTotal = model.getValueAt(index, 5).toString();
            finalTotalPrice = finalTotalPrice + Integer.parseInt(subTotal);
            lblFinalTotalPrice.setText(String.valueOf(finalTotalPrice));
            ((DefaultTableModel) tableCart.getModel()).removeRow(index);
        }
    }//GEN-LAST:event_tableCartMouseClicked

    private void btnSaveOrderDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveOrderDetailsActionPerformed
        if (finalTotalPrice != 0 && !txtCustomerName.getText().equals("")) {
            orderId = getUniqueId("Bill-");

            DefaultTableModel dtm = (DefaultTableModel) tableCart.getModel();
            if (tableCart.getRowCount() != 0) {
                for (int i = 0; i < tableCart.getRowCount(); i++) {
                    try {
                        Connection con = ConnectionProvider.getCon();
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("update product set quantity=quantity-" + Integer.parseInt(dtm.getValueAt(i, 2).toString()) + " where product_pk=" + Integer.parseInt(dtm.getValueAt(i, 0).toString()));
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            }
            try {
                SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
                Calendar cal = Calendar.getInstance();
                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement("insert into orderDetail(orderId, customer_fk, orderDate, totalPaid) values(?,?,?,?)");
                ps.setString(1, orderId);
                ps.setInt(2, customer_pk);
                ps.setString(3, myFormat.format(cal.getTime()));
                ps.setInt(4, finalTotalPrice);
                ps.executeUpdate();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

            //creating Document
            com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
            try {
                SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
                Calendar cal = Calendar.getInstance();
                PdfWriter.getInstance(doc, new FileOutputStream(InventoryUtils.billPath + "" + orderId + ".pdf"));
                doc.open();
                Paragraph projectName = new Paragraph("                       Inventory Management System                      ");
                doc.add(projectName);
                Paragraph starLine = new Paragraph("***************************************************************************");
                doc.add(starLine);
                Paragraph details = new Paragraph("\tOrder ID:" + orderId + "\nDate:" + myFormat.format(cal.getTime()) + "\nTotal Paid:" + finalTotalPrice);
                doc.add(details);
                doc.add(starLine);
                PdfPTable tb1 = new PdfPTable(5);
                PdfPCell nameCell = new PdfPCell(new Phrase("Name"));
                PdfPCell descriptionCell = new PdfPCell(new Phrase("Description"));
                PdfPCell priceCell = new PdfPCell(new Phrase("Price Per Unit"));
                PdfPCell quantityCell = new PdfPCell(new Phrase("Quantity"));
                PdfPCell subTotalPriceCell = new PdfPCell(new Phrase("Sub Total Price"));

                BaseColor backgroundColor = new BaseColor(255, 204, 51);
                nameCell.setBackgroundColor(backgroundColor);
                descriptionCell.setBackgroundColor(backgroundColor);
                priceCell.setBackgroundColor(backgroundColor);
                quantityCell.setBackgroundColor(backgroundColor);
                subTotalPriceCell.setBackgroundColor(backgroundColor);

                tb1.addCell(nameCell);
                tb1.addCell(descriptionCell);
                tb1.addCell(priceCell);
                tb1.addCell(quantityCell);
                tb1.addCell(subTotalPriceCell);

                for (int i = 0; i < tableCart.getRowCount(); i++) {
                    tb1.addCell(tableCart.getValueAt(i, 1).toString());
                    tb1.addCell(tableCart.getValueAt(i, 2).toString());
                    tb1.addCell(tableCart.getValueAt(i, 3).toString());
                    tb1.addCell(tableCart.getValueAt(i, 4).toString());
                    tb1.addCell(tableCart.getValueAt(i, 5).toString());
                }
                
                doc.add(tb1);
                doc.add(starLine);
                Paragraph thanksMsg = new Paragraph("Thank you, Please visit again.");
                doc.add(thanksMsg);
                OpenPdf.OpenById(orderId);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            
            doc.close();
            setVisible(false);
            new ManageOrder().setVisible(true);
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Please add some product to Cart or select customer");
        }
    }//GEN-LAST:event_btnSaveOrderDetailsActionPerformed

//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ManageOrder().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSaveOrderDetails;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblFinalTotalPrice;
    private javax.swing.JTable tableCart;
    private javax.swing.JTable tableCustomerList;
    private javax.swing.JTable tableProductList;
    private javax.swing.JTextField txtCustomerEmail;
    private javax.swing.JTextField txtCustomerMobileNumber;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtOrderQuantity;
    private javax.swing.JTextField txtProductDescription;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtProductPrice;
    // End of variables declaration//GEN-END:variables
}
