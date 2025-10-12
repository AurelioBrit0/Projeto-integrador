package coomponete;

import evento.EventMenuSelected;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import modelo.Modelo_Menu;

public class Menu extends javax.swing.JPanel {

    private EventMenuSelected event;
    
    public void addEventMenuSelected(EventMenuSelected event) {
        this.event = event;
        listMenu.addEventMenuSelected(event);
    }
    
    public Menu() {
        initComponents();
        setOpaque(false);
        listMenu.setOpaque(false);
        init();
    }
    
    private void init() {
        listMenu.addItem(new Modelo_Menu("", "", Modelo_Menu.MenuType.EMPTY));
        listMenu.addItem(new Modelo_Menu("", "", Modelo_Menu.MenuType.EMPTY));
        listMenu.addItem(new Modelo_Menu("1", "Estado", Modelo_Menu.MenuType.MENU));
        listMenu.addItem(new Modelo_Menu("2", "Cidade", Modelo_Menu.MenuType.MENU));
        listMenu.addItem(new Modelo_Menu("3", "Cliente", Modelo_Menu.MenuType.MENU));
        listMenu.addItem(new Modelo_Menu("4", "Fornecedor", Modelo_Menu.MenuType.MENU));
        listMenu.addItem(new Modelo_Menu("5", "Grupo produto", Modelo_Menu.MenuType.MENU));
        listMenu.addItem(new Modelo_Menu("6", "Marcar", Modelo_Menu.MenuType.MENU));
        listMenu.addItem(new Modelo_Menu("7", "Produto", Modelo_Menu.MenuType.MENU));
        listMenu.addItem(new Modelo_Menu("8", "Compra", Modelo_Menu.MenuType.MENU));
        listMenu.addItem(new Modelo_Menu("9", "Venda", Modelo_Menu.MenuType.MENU));
        listMenu.addItem(new Modelo_Menu("10", "Ordem de serviço", Modelo_Menu.MenuType.MENU));
        listMenu.addItem(new Modelo_Menu("11", "Sobre", Modelo_Menu.MenuType.MENU));
        listMenu.addItem(new Modelo_Menu("12", "Receber", Modelo_Menu.MenuType.MENU));
        listMenu.addItem(new Modelo_Menu("13", "Pagar", Modelo_Menu.MenuType.MENU));
        listMenu.addItem(new Modelo_Menu("14", "Registrar", Modelo_Menu.MenuType.MENU));
        listMenu.addItem(new Modelo_Menu("15", "Relatórios", Modelo_Menu.MenuType.MENU));
        listMenu.addItem(new Modelo_Menu("15", "Logout", Modelo_Menu.MenuType.MENU));
        listMenu.addItem(new Modelo_Menu("16", "sair", Modelo_Menu.MenuType.MENU));
        listMenu.addItem(new Modelo_Menu("", "", Modelo_Menu.MenuType.EMPTY));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMoving = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        listMenu = new modelo.ListMenu<>();

        panelMoving.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("<html><u>SGEV</u></html>");

        javax.swing.GroupLayout panelMovingLayout = new javax.swing.GroupLayout(panelMoving);
        panelMoving.setLayout(panelMovingLayout);
        panelMovingLayout.setHorizontalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );
        panelMovingLayout.setVerticalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(listMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintChildren(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint grpphcs = new GradientPaint(0, 0, Color.decode("#222426"), 0, getHeight(), Color.decode("#18191b"));
        g2.setPaint(grpphcs);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        super.paintChildren(g);
    }
    
    private int x;
    private int y;

    public void initMoving(JFrame fram) {
        panelMoving.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                x = me.getX();
                y = me.getY();
            }

        });
        panelMoving.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                fram.setLocation(me.getXOnScreen() - x, me.getYOnScreen() - y);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private modelo.ListMenu<String> listMenu;
    private javax.swing.JPanel panelMoving;
    // End of variables declaration//GEN-END:variables

    
}
