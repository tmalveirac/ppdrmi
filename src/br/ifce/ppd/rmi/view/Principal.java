package br.ifce.ppd.rmi.view;

/**
 * Classe: Principal.java
 * Código View da janela Principal da Aplicação
 * @author Tiago Malveira
 * 
 */

import br.ifce.ppd.rmi.control.Cliente;
import br.ifce.ppd.rmi.utils.Abas;
import br.ifce.ppd.rmi.utils.SortFileIgnoreCase;
import br.ifce.ppd.rmi.utils.Usuario;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.rmi.RemoteException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class Principal extends javax.swing.JFrame {

    public Principal(String login, String servidor, File pasta) throws RemoteException {
        initComponents();
        inicializar();
        jFileChooser = new JFileChooser();
        try{
            cliente = new Cliente(login, servidor, pasta);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,
                "Servidor Indisponível. Tente novamente!",
                "Atenção",
                JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }
       
        txtMinhaPasta.setText(pasta.getPath());
        listarArquivos(Abas.MINHA_PASTA);
        listarArquivos(Abas.TODOS_ARQUIVOS);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbtgNomeExtensao = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblTodosArquivos = new javax.swing.JTable();
        btnAtualizarTodoArquivos = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtMinhaPasta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnAtualizarMinhaPasta = new javax.swing.JButton();
        btnAlterarPasta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMinhaPasta = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnFazerDownloadRB = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbResultadoBusca = new javax.swing.JTable();
        lbTextoResultado = new javax.swing.JLabel();
        lbQtdResultado = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDownloads = new javax.swing.JTable();
        btnLimparDownloads = new javax.swing.JButton();
        txtBuscaArquivo = new javax.swing.JTextField();
        lbBuscarArquivo = new javax.swing.JLabel();
        rbtNome = new javax.swing.JRadioButton();
        rbtExtensao = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuAlterarPasta = new javax.swing.JMenuItem();
        jMenuSair = new javax.swing.JMenuItem();

        rbtgNomeExtensao.add(rbtNome);
        rbtgNomeExtensao.add(rbtExtensao);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblTodosArquivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Arquivo", "Tamanho (Bytes)", "Cliente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblTodosArquivos);

        btnAtualizarTodoArquivos.setText("Atualizar");
        btnAtualizarTodoArquivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarTodoArquivosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addComponent(btnAtualizarTodoArquivos)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAtualizarTodoArquivos)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Todos os Arquivos", jPanel1);

        txtMinhaPasta.setEditable(false);

        jLabel2.setText("Pasta:");

        btnAtualizarMinhaPasta.setText("Atualizar");
        btnAtualizarMinhaPasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarMinhaPastaActionPerformed(evt);
            }
        });

        btnAlterarPasta.setText("Alterar Pasta");
        btnAlterarPasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarPastaActionPerformed(evt);
            }
        });

        tblMinhaPasta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Arquivo", "Tamanho (Bytes)", "Usuário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Long.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblMinhaPasta);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAtualizarMinhaPasta)
                .addGap(333, 333, 333))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(39, 39, 39)
                        .addComponent(txtMinhaPasta, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnAlterarPasta)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMinhaPasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnAlterarPasta))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAtualizarMinhaPasta)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Minha Pasta", jPanel2);

        btnFazerDownloadRB.setText("Download");
        btnFazerDownloadRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFazerDownloadRBActionPerformed(evt);
            }
        });

        tbResultadoBusca.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbResultadoBusca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Arquivo", "Tamanho (Bytes)", "Cliente"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Long.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tbResultadoBusca);

        lbTextoResultado.setText("Quantidade de arquivos encontrados: ");

        lbQtdResultado.setText("___");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(lbTextoResultado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbQtdResultado))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(btnFazerDownloadRB, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTextoResultado)
                    .addComponent(lbQtdResultado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnFazerDownloadRB)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Resultado de Busca", jPanel4);

        tbDownloads.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Arquivo", "Tamanho (Bytes)", "Cliente", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbDownloads);

        btnLimparDownloads.setText("Limpar Downloads");
        btnLimparDownloads.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparDownloadsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(297, 297, 297)
                        .addComponent(btnLimparDownloads)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnLimparDownloads)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Download", jPanel3);

        txtBuscaArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscaArquivoActionPerformed(evt);
            }
        });

        lbBuscarArquivo.setText("Buscar Arquivo:");

        rbtNome.setText("nome");
        rbtNome.setSelected(true);

        rbtExtensao.setText("extensão");

        jMenu1.setText("Arquivo");

        jMenuAlterarPasta.setText("Alterar pasta");
        jMenuAlterarPasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAlterarPastaActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuAlterarPasta);

        jMenuSair.setText("Sair");
        jMenuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSairActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuSair);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lbBuscarArquivo)
                .addGap(18, 18, 18)
                .addComponent(txtBuscaArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtExtensao)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscaArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbBuscarArquivo)
                    .addComponent(rbtNome)
                    .addComponent(rbtExtensao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtualizarMinhaPastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarMinhaPastaActionPerformed
        try {
            listarArquivos(Abas.MINHA_PASTA);
            listarArquivos(Abas.TODOS_ARQUIVOS);
        } catch (RemoteException ex) {
            sair();
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAtualizarMinhaPastaActionPerformed

    private void jMenuAlterarPastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAlterarPastaActionPerformed
        try {
            alterarPasta();
        } catch (RemoteException ex) {
            sair();
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jMenuAlterarPastaActionPerformed

    private void jMenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSairActionPerformed
        try {
            cliente.getServidor().desconectar(cliente.getLogin());
        } catch (RemoteException ex) {
            sair();
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }//GEN-LAST:event_jMenuSairActionPerformed

    private void btnAlterarPastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarPastaActionPerformed
        try {
            alterarPasta();
        } catch (RemoteException ex) {
            sair();
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAlterarPastaActionPerformed

    private void btnAtualizarTodoArquivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarTodoArquivosActionPerformed
        try {
            listarArquivos(Abas.TODOS_ARQUIVOS);
        } catch (RemoteException ex) {
            sair();
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAtualizarTodoArquivosActionPerformed

    private void txtBuscaArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaArquivoActionPerformed
        try {
            //Pesquisa na lista de arquivos do servidor
            if (txtBuscaArquivo.getText().length()<2){
                JOptionPane.showMessageDialog(null,
                "Informe pelo menos 2 caracteres para a busca!",
                "Atenção",
                JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            //Se for pelo nome
            if (rbtNome.isSelected()){
                buscaArquivosServidor(txtBuscaArquivo.getText(), "nome");
            }
            else {
                //Se for pela extensão
                buscaArquivosServidor(txtBuscaArquivo.getText(), "extensão");
            }
            
            //Selecionar aba de resultado
            jTabbedPane1.setSelectedComponent(jPanel4);
        } catch (RemoteException ex) {
            sair();
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_txtBuscaArquivoActionPerformed

    private void btnFazerDownloadRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFazerDownloadRBActionPerformed
        try {
            int linhaSelecionada = tbResultadoBusca.getSelectedRow();
            System.err.println("linha= " + linhaSelecionada);
            if (linhaSelecionada == -1){
                JOptionPane.showMessageDialog(null,
                "Selecione uma linha válida!",
                "Atenção",
                JOptionPane.WARNING_MESSAGE);
            }
            else{
                String login = (String) tbResultadoBusca.getValueAt(linhaSelecionada, 2);
                String nomeArquivo = (String) tbResultadoBusca.getValueAt(linhaSelecionada, 0);
                baixarArquivo(login, nomeArquivo);    
                listarArquivoDownload(login,nomeArquivo);
                cliente.getServidor().atualizarPasta(cliente.getLogin());
                jTabbedPane1.setSelectedComponent(jPanel3);
            }
        } catch (RemoteException ex) {
            sair();
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnFazerDownloadRBActionPerformed

    private void btnLimparDownloadsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparDownloadsActionPerformed
        limparListaDownload();
    }//GEN-LAST:event_btnLimparDownloadsActionPerformed
    
    /**
    * Código para Tratar evento Fechar Janela pelo X 
    *             
    * @return       void
    */
    private void inicializar() {
        addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent we) {
                 //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowClosing(WindowEvent we) {
            if (we.getID() == WindowEvent.WINDOW_CLOSING) {
                try {
                    cliente.getServidor().desconectar(cliente.getLogin());
                } catch (RemoteException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            }

            @Override
            public void windowClosed(WindowEvent we) {
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowIconified(WindowEvent we) {
                 //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowDeiconified(WindowEvent we) {
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowActivated(WindowEvent we) {
                 //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void windowDeactivated(WindowEvent we) {
                //To change body of generated methods, choose Tools | Templates.
            }      
        });   
    }
    
    /**
    * Altera a pasta do usuário
    *             
    * @return   void   
    */
    public void alterarPasta() throws RemoteException{
        jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jFileChooser.showOpenDialog(this);
        if (jFileChooser.getSelectedFile() != null){
            cliente.setPasta(jFileChooser.getSelectedFile());
            txtMinhaPasta.setText(jFileChooser.getSelectedFile().getPath());
            listarArquivos(Abas.MINHA_PASTA);
            listarArquivos(Abas.TODOS_ARQUIVOS);
            cliente.getServidor().atualizarPasta(cliente.getLogin());
        }
    }
 
    /**
    * Atualiza a lista de arquivos em uma tabela
    *             
    * @param    tipoLista   tipo da lista de arquivos (MinhaPasta ou TodosArquivos)
    * @return   void   
    */
    public void listarArquivos(String tipoLista) throws RemoteException{

        DefaultTableModel dtm;
       
        switch (tipoLista){

            case Abas.MINHA_PASTA:
                List<File> listaArquivos =  cliente.listarArquivos();
       
                //Ordenando arquivos
                Collections.sort(listaArquivos,new SortFileIgnoreCase());

                dtm = (DefaultTableModel) tblMinhaPasta.getModel();
                for (int i=0;i<dtm.getRowCount();){
                    dtm.removeRow(i);
                }

                //Popula lista
                for (File f : listaArquivos){
                    dtm.addRow(new Object[]{f.getName(),f.length(),cliente.getLogin()});        
                }
                break;
                
            case Abas.TODOS_ARQUIVOS:
                List<Usuario> listaUsuario = cliente.getServidor().listarUsuarios();
        
                //Copia a lista de arquivos de todos
                System.err.println("Tamanho da lista de Arquivos" + listaUsuario.size());

                dtm = (DefaultTableModel) tblTodosArquivos.getModel();
                for (int i=0;i<dtm.getRowCount();){
                    dtm.removeRow(i);
                }

                //Popula lista
                for (Usuario u : listaUsuario){
                    for (File f : u.getListaArquivo()){
                        dtm.addRow(new Object[]{f.getName(),f.length(), u.getLogin()});  
                    }
                }
                break;       
        }      
    } 

    /**
    * Busca arquivos no Servidor
    *             
    * @param    palavraChave    chave de busca
    *           tipoBusca       tipo da busca (nome ou extensão)
    * @return   void   
    */
    public void buscaArquivosServidor(String palavraChave, String tipoBusca) throws RemoteException {
        List<Usuario> listaUsuario = cliente.getServidor().listarUsuarios();
        DefaultTableModel dtm;
        String[] listaPalavra = palavraChave.split(" ");
        int qtdPalavra = listaPalavra.length;
        
        //Copia a lista de arquivos de todo
        System.err.println("Tamanho da lista de Arquivos" + listaUsuario.size());
        dtm = (DefaultTableModel) tbResultadoBusca.getModel();
        for (int i=0;i<dtm.getRowCount();){
            dtm.removeRow(i);
        }

        //Compara as strings Popula lista de resultado
        for (Usuario u : listaUsuario){
            //Não pesquisa nos meus arquivos
            if (u.getLogin().equals(cliente.getLogin())){
                continue;
            }
            for (File f : u.getListaArquivo()){
                for (String s : listaPalavra){
                    //Busca conforme o tipo
                    if (tipoBusca.equals("nome")){       
                        //Retira 3 últimos nomes
                        if (f.getName().substring(0, f.getName().length()-3).toLowerCase().contains(s.toLowerCase())){
                            dtm.addRow(new Object[]{f.getName(),f.length(), u.getLogin()});      
                            break;
                        }
                    }
                    else{
                        //Busca por extensão
                        if (f.getName().toLowerCase().endsWith("."+s.toLowerCase())){
                            dtm.addRow(new Object[]{f.getName(),f.length(), u.getLogin()});      
                            break;
                        }
                    }
                    
                }           
            }
        }
        
        //Informa quantidade de resultados:
        lbQtdResultado.setText(""+dtm.getRowCount());     
    }
    
    /**
    * Lista o arquivo na tabela de downloads
    *             
    * @param    login           loging do cliente
    *           nomeArquivo     nome do arquivo
    * @return   void   
    */
    public void listarArquivoDownload(String login, String nomeArquivo) throws RemoteException{
        
        DefaultTableModel dtm = (DefaultTableModel) tbDownloads.getModel();
        List<File> listaArquivos =  cliente.listarArquivos();

         for (File f : listaArquivos){
             if (f.getName().equals(nomeArquivo)){
                //Popula lista
                dtm.addRow(new Object[]{f.getName(),f.length(),login,"Completo"});      
             }
         }
          
    }
    
    /**
    * Faz o download de uma arquivo
    *             
    * @param    login           loging do cliente
    *           nomeArquivo     Nome do arquivo
    * @return   boolean         true, baixou sem problemas. False, caso contrário.   
    */
    public boolean baixarArquivo(String login, String nomeArquivo) {
         File file = new File(cliente.getPasta().getPath()+"/" +nomeArquivo);
        try {
            //File file = new File(cliente.getPasta().getPath()+"/" +nomeArquivo);
            
            OutputStream outStream = null;
            outStream = new FileOutputStream(file);

            outStream.write(cliente.downloadArquivoOutroUsuario(login, nomeArquivo), 0, 
                    cliente.downloadArquivoOutroUsuario(login, nomeArquivo).length);

            outStream.close();
            return true;
        } catch (Exception ex) {
            file.delete();
            JOptionPane.showMessageDialog(null,
                "O arquivo não está mais disponível. Refaça a busca!",
                "Atenção",
                JOptionPane.WARNING_MESSAGE);
            jTabbedPane1.setSelectedComponent(jPanel1);
            return false;
        }
        
        
    }

    /**
    * Limpa tabela de downloads
    *             
    * @return   void   
    */
    public void limparListaDownload() {
        DefaultTableModel dtm = (DefaultTableModel) tbDownloads.getModel();
        for (int i=0;i<dtm.getRowCount();){
            dtm.removeRow(i);
        }
    }
    
    /**
    * Sai da aplicação
    *             
    * @return   void   
    */
    public void sair(){
        JOptionPane.showMessageDialog(null,
                "Servidor Indisponível. Reinicie a aplicação!",
                "Atenção",
                JOptionPane.WARNING_MESSAGE);
        System.exit(0);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarPasta;
    private javax.swing.JButton btnAtualizarMinhaPasta;
    private javax.swing.JButton btnAtualizarTodoArquivos;
    private javax.swing.JButton btnFazerDownloadRB;
    private javax.swing.JButton btnLimparDownloads;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuAlterarPasta;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuSair;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbBuscarArquivo;
    private javax.swing.JLabel lbQtdResultado;
    private javax.swing.JLabel lbTextoResultado;
    private javax.swing.JRadioButton rbtExtensao;
    private javax.swing.JRadioButton rbtNome;
    private javax.swing.ButtonGroup rbtgNomeExtensao;
    private javax.swing.JTable tbDownloads;
    private javax.swing.JTable tbResultadoBusca;
    private javax.swing.JTable tblMinhaPasta;
    private javax.swing.JTable tblTodosArquivos;
    private javax.swing.JTextField txtBuscaArquivo;
    private javax.swing.JTextField txtMinhaPasta;
    // End of variables declaration//GEN-END:variables
    private JFileChooser jFileChooser;
    private Cliente cliente;
    
}
