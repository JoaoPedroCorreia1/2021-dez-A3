/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend.projetos.jframes;

import backend.controllers.AplicacaoController;
import backend.dto.ProjetoDTO;
import backend.dto.UsuarioDTO;
import database.dao.ProjetoDAO;
import database.dao.UsuarioDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author joao
 */
public class ParticipantesProjetos extends javax.swing.JFrame {

    private DefaultTableModel defaultTableModel;
    private List<UsuarioDTO> usuarios;
    
    public ParticipantesProjetos() {
        initComponents();
        inicializarComponentes();
    }

    
    public void inicializarComponentes()
    {
        // tabela
        defaultTableModel = (DefaultTableModel) tabelaProjetos.getModel();
        
        if(AplicacaoController.getIdProjetoSelecionado() != -1)
        {
            usuarios
                    = UsuarioDAO
                            .getByIdProjeto(
                                    AplicacaoController
                                            .getIdProjetoSelecionado()
                            );

            if (!usuarios.isEmpty()) {
                for (UsuarioDTO usuario : usuarios) {
                    defaultTableModel.addRow(
                            new Object[]{
                                usuario.getNomeUsuario(),
                                usuario.getEmail()
                            });
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Projeto não selecionado");
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

        tituloTabelaProjetos = new javax.swing.JLabel();
        scrollPaneTabelaProjetos = new javax.swing.JScrollPane();
        tabelaProjetos = new javax.swing.JTable();
        textFieldPesquisar = new javax.swing.JTextField();
        botaoPesquisar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1295, 697));

        tituloTabelaProjetos.setText("Participantes");

        tabelaProjetos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "E-mail"
            }
        ));
        tabelaProjetos.setRowHeight(40);
        scrollPaneTabelaProjetos.setViewportView(tabelaProjetos);

        textFieldPesquisar.setPreferredSize(new java.awt.Dimension(443, 40));

        botaoPesquisar1.setText("Pesquisar");
        botaoPesquisar1.setPreferredSize(new java.awt.Dimension(137, 40));
        botaoPesquisar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPesquisar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(423, 423, 423)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tituloTabelaProjetos)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(scrollPaneTabelaProjetos)
                            .addComponent(textFieldPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addComponent(botaoPesquisar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(254, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoPesquisar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(tituloTabelaProjetos)
                .addGap(18, 18, 18)
                .addComponent(scrollPaneTabelaProjetos, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(182, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoPesquisar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoPesquisar1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoPesquisar1;
    private javax.swing.JScrollPane scrollPaneTabelaProjetos;
    private javax.swing.JTable tabelaProjetos;
    private javax.swing.JTextField textFieldPesquisar;
    private javax.swing.JLabel tituloTabelaProjetos;
    // End of variables declaration//GEN-END:variables
}