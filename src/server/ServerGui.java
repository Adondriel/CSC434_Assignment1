package server;
/**
*
* @author Adam Pine, Written using Netbeans.
*/
public class ServerGui extends javax.swing.JPanel {

   /**
    * Init's the gui when a new gui object is instanciated.
    */
   public ServerGui() {
       initComponents();
   }
/**
 * Generated using NetBeans (GUI creation in netbeans is super nice)
 * This just creates and makes sure all the components are in the correct placement.
 */
   private void initComponents() {

       jScrollPane1 = new javax.swing.JScrollPane();
       txtServerLog = new javax.swing.JTextArea();
       jLabel1 = new javax.swing.JLabel();

       txtServerLog.setColumns(20);
       txtServerLog.setRows(5);
       jScrollPane1.setViewportView(txtServerLog);

       jLabel1.setText("Log");

       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
       this.setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addContainerGap()
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   .addGroup(layout.createSequentialGroup()
                       .addComponent(jLabel1)
                       .addGap(0, 0, Short.MAX_VALUE))
                   .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE))
               .addContainerGap())
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addContainerGap()
               .addComponent(jLabel1)
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
               .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
               .addContainerGap())
       );
   }                    


   // Variables declaration - do not modify                     
   private javax.swing.JLabel jLabel1;
   private javax.swing.JScrollPane jScrollPane1;
   public javax.swing.JTextArea txtServerLog;
   // End of variables declaration                   
}
