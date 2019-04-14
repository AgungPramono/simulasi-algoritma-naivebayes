package com.agung.nb;

import com.agung.nb.helper.ConnectionHelper;
import com.agung.nb.service.MasterService;
import com.agung.nb.service.ProgressService;
import com.agung.nb.ui.MainFrame;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author agung
 */
public class Main {

    private static MasterService masterService;
    private static ProgressService prosesService;
    private static MainFrame mainFrame;
    
    public static MainFrame getMainFrame(){
        return mainFrame;
    }
    
    public static MasterService getMasterService() {
        return masterService;
    }

    public static ProgressService getProsesService() {
        return prosesService;
    }

    public static void main(String[] args) throws Exception {
        masterService = new MasterService();
        prosesService = new ProgressService();
        masterService.setConnection(ConnectionHelper.getDataSource());
        prosesService.setConnection(ConnectionHelper.getDataSource());

        try {
//            Properties props = new Properties();
//
//            //props.put("macStyleWindowDecoration", "on");
//            //props.put("linuxStyleScrollBar", "on");
//
//            // Set the theme
//            //com.jtattoo.plaf.acryl.AcrylLookAndFeel.setCurrentTheme(props);
//
//            // Select the Look and Feel
//            //UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
//            //UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
//            //UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
//            //UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
//            UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
           
             for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
             
        } catch (ClassNotFoundException |
                InstantiationException |
                IllegalAccessException |
                UnsupportedLookAndFeelException e) {
        }

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                mainFrame = new MainFrame();
                mainFrame.setVisible(true);
            }
        });
    }
}
