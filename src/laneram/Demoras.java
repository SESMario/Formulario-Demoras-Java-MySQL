package laneram;

import conectar.conectar;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Mario Serrano Serrano
 */
public class Demoras extends javax.swing.JFrame {

    conectar con = new conectar();
    Connection CN = con.getConnection();
    PreparedStatement PS;
    ResultSet RS;
    DefaultTableModel DT;

    public Demoras() {
	initComponents();
	this.setLocationRelativeTo(null);
	jbtGCambios.setVisible(false);
	jbtCancelarE.setVisible(false);
	turnos();
	telares();
	Codigos();
	jcbBusqueda();
	listar();
	resultados();
    }

    public void resultados() {
	int Filas = jTable1.getRowCount();//numero de filas en la tabla
	jlbResBus.setText("" + Filas);
    }

    private void listar() {
	jTable1.setModel(DatosDemoras());
	resultados();
	//Cambia el color y letra de la cabecera del jtable
	jTable1.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
	    @Override
	    public Component getTableCellRendererComponent(JTable table, Object value,
		    boolean isSelected, boolean hasFocus, int row, int column) {
		JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		//l.setBorder(new LineBorder(Color.black, 1));
		l.setBackground(new java.awt.Color(102, 0, 0));
		l.setForeground(new java.awt.Color(255, 255, 255));
		l.setFont(new java.awt.Font("Arial", 1, 15));
		l.setHorizontalAlignment(SwingConstants.CENTER);
		//Cambiar el tamaño de la columna ID, Telar y Codigo 
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(10);
		columnModel.getColumn(6).setPreferredWidth(10);
		columnModel.getColumn(7).setPreferredWidth(10);
		///columnModel.getColumn(8).setPreferredWidth(50);
		//Alinear, centrar, etc, posicion de los datos en la tabla
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		DefaultTableCellRenderer tcr1 = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		tcr1.setHorizontalAlignment(SwingConstants.LEFT);
		jTable1.getColumnModel().getColumn(column).setCellRenderer(tcr);//Todas las columnas cetradas
		jTable1.getColumnModel().getColumn(8).setCellRenderer(tcr1);//columna decripcion alineada a la izquierda

		return l;
	    }
	});
    }

    private DefaultTableModel setTitulos() {
	DT = new DefaultTableModel();
	DT.addColumn("ID");
	DT.addColumn("Fecha");
	DT.addColumn("Inicio");
	DT.addColumn("Fin");
	DT.addColumn("Duración");
	DT.addColumn("Turno");
	DT.addColumn("Telar");
	DT.addColumn("Codigo");
	DT.addColumn("Descripción");
	return DT;
    }

    public void jcbBusqueda() {
	this.jcbBuscar.addItem("ID");
	this.jcbBuscar.addItem("Fecha");
	this.jcbBuscar.addItem("Duración");
	this.jcbBuscar.addItem("Turno");
	this.jcbBuscar.addItem("Telar");
	this.jcbBuscar.addItem("Codigo");
	this.jcbBuscar.addItem("Descripción");
    }

    public void turnos() {
	try {
	    Statement st = CN.createStatement();
	    ResultSet rs = st.executeQuery("select Turno from turno");
	    this.jcb_Turno.addItem("Selecciona turno");
	    this.busquedaTurno.addItem("Turno");
	    while (rs.next()) {
		this.jcb_Turno.addItem(rs.getString("Turno"));
		this.busquedaTurno.addItem(rs.getString("Turno"));
	    }
	} catch (SQLException ex) {
	    JOptionPane.showMessageDialog(null, ex);
	}
    }

    public void telares() {
	try {
	    Statement st = CN.createStatement();
	    ResultSet rs = st.executeQuery("select Telar from telar");
	    this.jcb_Telar.addItem("Selecciona telar");
	    this.busquedaTelar.addItem("Telar");
	    while (rs.next()) {
		this.jcb_Telar.addItem(rs.getString("Telar"));
		this.busquedaTelar.addItem(rs.getString("Telar"));
	    }
	} catch (SQLException ex) {
	    JOptionPane.showMessageDialog(null, ex);
	}
    }

    public void Codigos() {
	try {
	    Statement st = CN.createStatement();
	    ResultSet rs = st.executeQuery("select Codigo from tipo");
	    this.jcb_Codigo.addItem("Selecciona codigo");
	    this.busquedaCodigo.addItem("Codigo");
	    while (rs.next()) {
		this.jcb_Codigo.addItem(rs.getString("Codigo"));
		this.busquedaCodigo.addItem(rs.getString("Codigo"));
	    }

	} catch (SQLException ex) {
	    JOptionPane.showMessageDialog(null, ex);
	}
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jspInicio = new javax.swing.JSpinner();
        jspFin = new javax.swing.JSpinner();
        jcb_Turno = new javax.swing.JComboBox<>();
        jcb_Telar = new javax.swing.JComboBox<>();
        jcb_Codigo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaDescripcion = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jbtGuardar = new javax.swing.JButton();
        jbtGCambios = new javax.swing.JButton();
        jbtCancelarE = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jbtEliminar = new javax.swing.JButton();
        jbtEditar = new javax.swing.JButton();
        jbtSalir = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        busquedaTurno = new javax.swing.JComboBox<>();
        busquedaTelar = new javax.swing.JComboBox<>();
        busquedaCodigo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jbtBuscaFiltro = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jcbBuscar = new javax.swing.JComboBox<>();
        jtfBusqueda = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jlbResBus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(102, 0, 0));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Formulario de demoras");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jDateChooser1.setDateFormatString("yyyy/MM/dd");

        SpinnerDateModel myTime = new SpinnerDateModel();
        jspInicio.setModel(myTime);

        jspInicio.setEditor(new JSpinner.DateEditor(jspInicio, "HH:mm:ss"));
        //Original  HH:mm
        //h:mm:ss a

        SpinnerDateModel myTime2 = new SpinnerDateModel();
        jspFin.setModel(myTime2);

        jspFin.setEditor(new JSpinner.DateEditor(jspFin, "HH:mm:ss"));
        // El código que agrega el componente al contenedor superior - no se muestra aquí

        //h:mm:ss a

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Fin:");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Fecha:");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Inicio:");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Turno:");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Telar:");

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Codigo:");

        jtaDescripcion.setColumns(20);
        jtaDescripcion.setRows(5);
        jScrollPane2.setViewportView(jtaDescripcion);

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Descripción:");

        jbtGuardar.setText("Guardar");
        jbtGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtGuardarActionPerformed(evt);
            }
        });

        jbtGCambios.setText("Guardar cambios");
        jbtGCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtGCambiosActionPerformed(evt);
            }
        });

        jbtCancelarE.setText("Cancelar actualización");
        jbtCancelarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCancelarEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jspFin)
                                    .addComponent(jspInicio))
                                .addGap(109, 109, 109)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcb_Telar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcb_Turno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcb_Codigo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(41, 41, 41))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtGCambios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtCancelarE, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))))
                .addGap(27, 27, 27))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcb_Turno)
                        .addComponent(jLabel5))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jspInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcb_Telar)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jcb_Codigo))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jspFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtGuardar)
                            .addComponent(jbtGCambios))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtCancelarE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                .addGap(7, 7, 7))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1 = jTable1 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jTable1.setSelectionBackground(new java.awt.Color(102, 0, 0));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jbtEliminar.setText("Eliminar");
        jbtEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtEliminarActionPerformed(evt);
            }
        });

        jbtEditar.setText("Editar");
        jbtEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtEditarActionPerformed(evt);
            }
        });

        jbtSalir.setText("Salir");
        jbtSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(jbtEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jbtEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtro de demoras", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N

        jDateChooser2.setDateFormatString("yyyy/MM/d");

        jDateChooser3.setDateFormatString("yyyy/MM/d");

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Del");

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("al");

        jbtBuscaFiltro.setText("Buscar");
        jbtBuscaFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtBuscaFiltroActionPerformed(evt);
            }
        });

        jButton2.setText("Imprimir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(busquedaTurno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(busquedaTelar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(busquedaCodigo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtBuscaFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbtBuscaFiltro)
                        .addComponent(jButton2))
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(busquedaTurno, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(busquedaTelar)
                    .addComponent(busquedaCodigo, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Busqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N

        jtfBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfBusquedaActionPerformed(evt);
            }
        });
        jtfBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfBusquedaKeyReleased(evt);
            }
        });

        jButton3.setText("Imprimir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jcbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfBusqueda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbBuscar)
                    .addComponent(jtfBusqueda)
                    .addComponent(jButton3))
                .addGap(12, 12, 12))
        );

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(102, 0, 0))); // NOI18N

        jlbResBus.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlbResBus.setForeground(new java.awt.Color(0, 0, 0));
        jlbResBus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbResBus.setAlignmentY(0.0F);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jlbResBus, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbResBus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfBusquedaActionPerformed
	// TODO add your handling code here:
    }//GEN-LAST:event_jtfBusquedaActionPerformed

    private void jbtGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtGuardarActionPerformed
	try {
//            java.util.Date myTime = new java.util.Date();
//            java.sql.Time sqlTime = new java.sql.Time(myTime.getTime());
	    SimpleDateFormat sdf = new SimpleDateFormat("kk:mm:ss");
	    sdf.setTimeZone(TimeZone.getDefault());
	    String da = sdf.format(jspInicio.getValue());
	    //*********************************************
//            java.util.Date myTime2 = new java.util.Date();
//            java.sql.Time sqlTime2 = new java.sql.Time(myTime2.getTime());
	    SimpleDateFormat sdf2 = new SimpleDateFormat("kk:mm:ss");
	    sdf2.setTimeZone(TimeZone.getDefault());
	    String da2 = sdf2.format(jspFin.getValue());

	    if (jcb_Codigo.getSelectedItem().equals("Selecciona codigo")
		    || jcb_Telar.getSelectedItem().equals("Selecciona telar")
		    || jcb_Turno.getSelectedItem().equals("Selecciona turno")
		    || jDateChooser1.getDate() == null) {
		JOptionPane.showMessageDialog(null, "Verifique que los campos necesarios esten completos");
	    } else if (da.equals(da2)) {
		JOptionPane.showMessageDialog(null, "Los campos de hora de inicio y fin no pueden ser iguales");
	    } else {
		PreparedStatement PS = CN.prepareStatement("INSERT INTO demora (Fecha, Inicio, Fin, Turno, Telar,Tipo,Descripcion) values(?,?,?,?,?,?,?)");
		//System.out.println("Fecha " + ((JTextField) jDateChooser1.getDateEditor().getUiComponent()));
		PS.setString(1, ((JTextField) jDateChooser1.getDateEditor().getUiComponent()).getText());
		PS.setString(2, da);
		PS.setString(3, da2);
		PS.setInt(4, jcb_Turno.getSelectedIndex());
		PS.setInt(5, jcb_Telar.getSelectedIndex());
		PS.setInt(6, jcb_Codigo.getSelectedIndex());
		PS.setString(7, jtaDescripcion.getText());
		PS.executeUpdate();
		JOptionPane.showMessageDialog(null, "Registro guardado...");
		jDateChooser1.setDate(null);
		SpinnerDateModel myTime = new SpinnerDateModel();
		SpinnerDateModel myTime1 = new SpinnerDateModel();
		jspInicio.setModel(myTime);
		jspInicio.setEditor(new JSpinner.DateEditor(jspInicio, "HH:mm:ss"));
		jspFin.setModel(myTime1);
		jspFin.setEditor(new JSpinner.DateEditor(jspFin, "HH:mm:ss"));
		jtaDescripcion.setText("");
		jcb_Turno.setSelectedIndex(0);
		jcb_Telar.setSelectedIndex(0);
		jcb_Codigo.setSelectedIndex(0);
		listar();
	    }
	} catch (SQLException e) {
	    System.err.println("Error al guardar los datos... " + e.getMessage());
	}
    }//GEN-LAST:event_jbtGuardarActionPerformed

    private void jbtEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtEliminarActionPerformed
	int fila = jTable1.getSelectedRowCount();
	//System.out.println("fila:   "+fila);
	//System.out.println("id    "+id);
	if (fila < 1) {
	    JOptionPane.showMessageDialog(null, "Seleccione un registro de la tabla");
	} else {
	    try {
		int id = (int) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
		PreparedStatement PS = CN.prepareStatement("delete from demora where ID=" + id);
		PS.executeUpdate();
		JOptionPane.showMessageDialog(null, "Demora eliminada...");
		listar();
	    } catch (SQLException e) {
		System.err.println("Error al eliminar los datos... " + e.getMessage());
	    }
	}
    }//GEN-LAST:event_jbtEliminarActionPerformed

    private void jbtSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSalirActionPerformed
	System.exit(0);
    }//GEN-LAST:event_jbtSalirActionPerformed

    private void jbtEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtEditarActionPerformed
	int fila = jTable1.getSelectedRowCount();
	if (fila < 1) {
	    JOptionPane.showMessageDialog(null, "Seleccione un registro de la tabla");
	} else {
	    jbtGCambios.setVisible(true);
	    jbtCancelarE.setVisible(true);
	    jbtGuardar.setVisible(false);
	    jPanel3.setBackground(new java.awt.Color(235, 99, 107));
	    //jTable1.setRowSelectionAllowed(false);
	    jTable1.disable();
	    // try catch para obtener la fecha y mandarla a jdateChooser
	    try {
		String f = jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaDate = formato.parse(f);
		//System.out.println("Fecha" + f);
		jDateChooser1.setDate(fechaDate);
		jcb_Turno.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 5));
		jcb_Telar.setSelectedIndex((int) jTable1.getValueAt(jTable1.getSelectedRow(), 6));
		jcb_Codigo.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 7));
		jtaDescripcion.setText((String) jTable1.getValueAt(jTable1.getSelectedRow(), 8));
		//Enviar valor de jtable a JSpinner de tiempo
		String h1 = jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString();//Hora inicio jtable
		String h2 = jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString();//Hora fin jtable
		SimpleDateFormat formath1 = new SimpleDateFormat("HH:mm:ss");//Formato de la hora
		SimpleDateFormat formath2 = new SimpleDateFormat("HH:mm:ss");
		Date hora1 = formath1.parse(h1);
		Date hor2 = formath2.parse(h2);
		jspInicio.setValue(hora1);
		jspFin.setValue(hor2);
	    } catch (ParseException ex) {
		Logger.getLogger(Demoras.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
    }//GEN-LAST:event_jbtEditarActionPerformed

    private void jbtGCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtGCambiosActionPerformed
	try {
	    java.util.Date myTime = new java.util.Date();
	    java.sql.Time sqlTime = new java.sql.Time(myTime.getTime());
	    SimpleDateFormat sdf = new SimpleDateFormat("kk:mm:ss");
	    sdf.setTimeZone(TimeZone.getDefault());
	    String da = sdf.format(jspInicio.getValue());
	    //*********************************************
	    java.util.Date myTime2 = new java.util.Date();
	    java.sql.Time sqlTime2 = new java.sql.Time(myTime2.getTime());
	    SimpleDateFormat sdf2 = new SimpleDateFormat("kk:mm:ss");
	    sdf2.setTimeZone(TimeZone.getDefault());
	    String da2 = sdf2.format(jspFin.getValue());

	    if (jcb_Codigo.getSelectedItem().equals("Selecciona codigo")
		    || jcb_Telar.getSelectedItem().equals("Selecciona telar")
		    || jcb_Turno.getSelectedItem().equals("Selecciona turno")
		    || jDateChooser1.getDate() == null) {
		JOptionPane.showMessageDialog(null, "Verifique que los campos necesarios esten completos");
	    } else if (da.equals(da2)) {
		JOptionPane.showMessageDialog(null, "Los campos de hora de inicio y fin no pueden ser iguales");
	    } else {
		int idd = (int) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
		int tu = jcb_Turno.getSelectedIndex();
		int te = jcb_Telar.getSelectedIndex();
		int co = jcb_Codigo.getSelectedIndex();
		String de = jtaDescripcion.getText();
		//***************************************************
		//Para obtener la fecha seleccionada en jDateChooser1 y mandarla a la base de datos
		String formato = jDateChooser1.getDateFormatString();
		Date date = jDateChooser1.getDate();
		SimpleDateFormat sdfe = new SimpleDateFormat("yyyy-MM-dd");
		String fec = String.valueOf(sdfe.format(date));
		//***************************************************
		PreparedStatement PS = CN.prepareStatement("update demora set Fecha='" + fec + "', Inicio='" + da + "', Fin='" + da2 + "', Turno='" + tu + "', Telar='" + te + "',Tipo='" + co + "',Descripcion='" + de + "'where ID='" + idd + "'");
		PS.executeUpdate();
		JOptionPane.showMessageDialog(null, "Registro actualizado...");
		jDateChooser1.setDate(null);
		SpinnerDateModel myTime3 = new SpinnerDateModel();
		SpinnerDateModel myTime4 = new SpinnerDateModel();
		jspInicio.setModel(myTime3);
		jspInicio.setEditor(new JSpinner.DateEditor(jspInicio, "HH:mm:ss"));
		jspFin.setModel(myTime4);
		jspFin.setEditor(new JSpinner.DateEditor(jspFin, "HH:mm:ss"));
		jtaDescripcion.setText("");
		jcb_Turno.setSelectedIndex(0);
		jcb_Telar.setSelectedIndex(0);
		jcb_Codigo.setSelectedIndex(0);
		jbtGCambios.setVisible(false);
		jbtCancelarE.setVisible(false);
		jbtGuardar.setVisible(true);
		jPanel3.setBackground(new java.awt.Color(204, 204, 204));
		jTable1.enable();
		listar();
	    }
	} catch (SQLException e) {
	    System.err.println("Error al actualizar los datos... " + e.getMessage());
	}
    }//GEN-LAST:event_jbtGCambiosActionPerformed

    private void jtfBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfBusquedaKeyReleased
	jTable1.setModel(busqueda(jcbBuscar.getSelectedIndex(), jtfBusqueda.getText()));
	resultados();
	if (jtfBusqueda.getText().isEmpty()) {
	    listar();
	    resultados();
	}
    }//GEN-LAST:event_jtfBusquedaKeyReleased

    private void jbtBuscaFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtBuscaFiltroActionPerformed
	//resultados();
	if ((jDateChooser2.getDate() == null && jDateChooser3.getDate() == null && busquedaTurno.getSelectedItem().equals("Turno") && busquedaTelar.getSelectedItem().equals("Telar") && busquedaCodigo.getSelectedItem().equals("Codigo"))) {
	    //Cuando todos los campos estan vacios
	    JOptionPane.showMessageDialog(null, "No ha selecionado ningun parametro para filtrar");
	    listar();
	} else if ((jDateChooser2.getDate() != null && jDateChooser3.getDate() != null && !busquedaTurno.getSelectedItem().equals("Turno") && !busquedaTelar.getSelectedItem().equals("Telar") && !busquedaCodigo.getSelectedItem().equals("Codigo"))) {
	    //Cuando todos los campos estan llenos
	    String formato2 = jDateChooser2.getDateFormatString();
	    Date date2 = jDateChooser2.getDate();
	    SimpleDateFormat sdfe2 = new SimpleDateFormat("yyyy-MM-dd");
	    String fec1 = String.valueOf(sdfe2.format(date2));
	    //******jdc3
	    String formato3 = jDateChooser3.getDateFormatString();
	    Date date3 = jDateChooser3.getDate();
	    SimpleDateFormat sdfe3 = new SimpleDateFormat("yyyy-MM-dd");
	    String fec3 = String.valueOf(sdfe3.format(date3));
	    //**********
	    String turno = (String) busquedaTurno.getSelectedItem();
	    int telar = busquedaTelar.getSelectedIndex();
	    String codigo = (String) busquedaCodigo.getSelectedItem();
	    System.out.println("" + fec1 + fec3 + turno + telar + codigo);
	    jTable1.setModel(filtro(fec1, fec3, turno, telar, codigo));
	} else if ((jDateChooser2.getDate() != null && jDateChooser3.getDate() != null && !busquedaTurno.getSelectedItem().equals("Turno") && !busquedaTelar.getSelectedItem().equals("Telar"))) {
	    //Cuando falat el campo codigo
	    String formato2 = jDateChooser2.getDateFormatString();
	    Date date2 = jDateChooser2.getDate();
	    SimpleDateFormat sdfe2 = new SimpleDateFormat("yyyy-MM-dd");
	    String fec1 = String.valueOf(sdfe2.format(date2));
	    //******jdc3
	    String formato3 = jDateChooser3.getDateFormatString();
	    Date date3 = jDateChooser3.getDate();
	    SimpleDateFormat sdfe3 = new SimpleDateFormat("yyyy-MM-dd");
	    String fec3 = String.valueOf(sdfe3.format(date3));
	    //**********
	    String turno = (String) busquedaTurno.getSelectedItem();
	    int telar = busquedaTelar.getSelectedIndex();
	    String codigo = null;
	    System.out.println("" + fec1 + fec3 + turno + telar + codigo);
	    jTable1.setModel(filtro(fec1, fec3, turno, telar, codigo));
	} else if ((jDateChooser2.getDate() != null && jDateChooser3.getDate() != null && !busquedaTurno.getSelectedItem().equals("Turno") && !busquedaCodigo.getSelectedItem().equals("Codigo"))) {
	    //Cuando falta el campo telar
	    String formato2 = jDateChooser2.getDateFormatString();
	    Date date2 = jDateChooser2.getDate();
	    SimpleDateFormat sdfe2 = new SimpleDateFormat("yyyy-MM-dd");
	    String fec1 = String.valueOf(sdfe2.format(date2));
	    //******jdc3
	    String formato3 = jDateChooser3.getDateFormatString();
	    Date date3 = jDateChooser3.getDate();
	    SimpleDateFormat sdfe3 = new SimpleDateFormat("yyyy-MM-dd");
	    String fec3 = String.valueOf(sdfe3.format(date3));
	    //**********
	    String turno = (String) busquedaTurno.getSelectedItem();
	    int telar = 0;
	    String codigo = (String) busquedaCodigo.getSelectedItem();
	    System.out.println("" + fec1 + fec3 + turno + telar + codigo);
	    jTable1.setModel(filtro(fec1, fec3, turno, telar, codigo));
	} else if ((jDateChooser2.getDate() != null && jDateChooser3.getDate() != null && !busquedaTelar.getSelectedItem().equals("Telar") && !busquedaCodigo.getSelectedItem().equals("Codigo"))) {
	    //Cuando falta el campo turno
	    String formato2 = jDateChooser2.getDateFormatString();
	    Date date2 = jDateChooser2.getDate();
	    SimpleDateFormat sdfe2 = new SimpleDateFormat("yyyy-MM-dd");
	    String fec1 = String.valueOf(sdfe2.format(date2));
	    //******jdc3
	    String formato3 = jDateChooser3.getDateFormatString();
	    Date date3 = jDateChooser3.getDate();
	    SimpleDateFormat sdfe3 = new SimpleDateFormat("yyyy-MM-dd");
	    String fec3 = String.valueOf(sdfe3.format(date3));
	    //**********
	    String turno = null;
	    int telar = busquedaTelar.getSelectedIndex();
	    String codigo = (String) busquedaCodigo.getSelectedItem();
	    System.out.println("" + fec1 + fec3 + turno + telar + codigo);
	    jTable1.setModel(filtro(fec1, fec3, turno, telar, codigo));
	} else if ((jDateChooser2.getDate() != null && !busquedaTurno.getSelectedItem().equals("Turno") && !busquedaTelar.getSelectedItem().equals("Telar") && !busquedaCodigo.getSelectedItem().equals("Codigo"))) {
	    //Cuando falta jdateChooser3
	    String formato2 = jDateChooser2.getDateFormatString();
	    Date date2 = jDateChooser2.getDate();
	    SimpleDateFormat sdfe2 = new SimpleDateFormat("yyyy-MM-dd");
	    String fec1 = String.valueOf(sdfe2.format(date2));
	    //******jdc3
	    String fec3 = null;
	    //**********
	    String turno = (String) busquedaTurno.getSelectedItem();
	    int telar = busquedaTelar.getSelectedIndex();
	    String codigo = (String) busquedaCodigo.getSelectedItem();
	    System.out.println("" + fec1 + fec3 + turno + telar + codigo);
	    jTable1.setModel(filtro(fec1, fec3, turno, telar, codigo));
	} else if ((jDateChooser3.getDate() != null && !busquedaTurno.getSelectedItem().equals("Turno") && !busquedaTelar.getSelectedItem().equals("Telar") && !busquedaCodigo.getSelectedItem().equals("Codigo"))) {
	    //Cuando falta jdateChooser2
	    String fec1 = null;
	    //******jdc3
	    String formato3 = jDateChooser3.getDateFormatString();
	    Date date3 = jDateChooser3.getDate();
	    SimpleDateFormat sdfe3 = new SimpleDateFormat("yyyy-MM-dd");
	    String fec3 = String.valueOf(sdfe3.format(date3));
	    //**********
	    String turno = (String) busquedaTurno.getSelectedItem();
	    int telar = busquedaTelar.getSelectedIndex();
	    String codigo = (String) busquedaCodigo.getSelectedItem();
	    System.out.println("" + fec1 + fec3 + turno + telar + codigo);
	    jTable1.setModel(filtro(fec1, fec3, turno, telar, codigo));
	} else {
	    JOptionPane.showMessageDialog(null, "Asegurece de seleccionar los campos necesarios");
	}
	resultados();//funcionando para el filtro
    }//GEN-LAST:event_jbtBuscaFiltroActionPerformed

    private void jbtCancelarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCancelarEActionPerformed
	jDateChooser1.setDate(null);
	SpinnerDateModel myTime = new SpinnerDateModel();
	SpinnerDateModel myTime1 = new SpinnerDateModel();
	jspInicio.setModel(myTime);
	jspInicio.setEditor(new JSpinner.DateEditor(jspInicio, "HH:mm:ss"));
	jspFin.setModel(myTime1);
	jspFin.setEditor(new JSpinner.DateEditor(jspFin, "HH:mm:ss"));
	jtaDescripcion.setText("");
	jcb_Turno.setSelectedIndex(0);
	jcb_Telar.setSelectedIndex(0);
	jcb_Codigo.setSelectedIndex(0);
	jbtGCambios.setVisible(false);
	jbtCancelarE.setVisible(false);
	jbtGuardar.setVisible(true);
	jPanel3.setBackground(new java.awt.Color(204, 204, 204));
	jTable1.enable();
	//listar();
    }//GEN-LAST:event_jbtCancelarEActionPerformed

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
	if (evt.getClickCount() == 2) {

	    int fila = jTable1.getSelectedRow();
	    int Ndem = (int) jTable1.getValueAt(fila, 0);
	    //JOptionPane.showMessageDialog(null, "Hola xd " + Ndem);
	    try {
		setTitulos();
		PreparedStatement PS = CN.prepareStatement("select ID,Fecha,Inicio,Fin,timestampdiff(minute,Inicio,Fin) as Duracion,Turno.turno,Telar,Tipo.Codigo,Demora.Descripcion,tipo.descripcion from demora inner join turno inner join tipo where Demora.Turno=Turno.IDTurno and Demora.Tipo=Tipo.IDTipo and ID='" + Ndem + "' order by demora.ID;");
		RS = PS.executeQuery();
		Object[] fil = new Object[11];
		while (RS.next()) {
		    fil[0] = RS.getInt(1);//ID
		    fil[1] = RS.getString(2);//Fecha
		    fil[2] = RS.getString(3);//Inicio
		    fil[3] = RS.getString(4);//Fin
		    fil[4] = RS.getInt(5) + " minutos";//Duracion
		    fil[5] = RS.getString(6);//Turno
		    fil[6] = RS.getInt(7);//Telar
		    fil[7] = RS.getString(8);//Codigo
		    fil[8] = RS.getString(9);//DemoraDescripción
		    fil[9] = RS.getString(10);//TipoDescripción
		    DT.addRow(fil);
		}
		JOptionPane.showMessageDialog(this, "ID: " + fil[0] + "\n"
			+ "Fecha: " + fil[1] + "\n"
			+ "Inicio: " + fil[2] + "\n"
			+ "Fin: " + fil[3] + "\n"
			+ "Duración : " + fil[4] + "\n"
			+ "Turno: " + fil[5] + "\n"
			+ "Telar: " + fil[6] + "\n"
			+ "Codigo: " + fil[7] + "\n"
			+ "DemDesc: " + fil[8] + "\n"
			+ "TipoDes: " + fil[9], "Detalles de la demora", JOptionPane.INFORMATION_MESSAGE);

	    } catch (SQLException e) {
		System.out.println("Error al listar... " + e.getMessage());
	    }
	}
    }//GEN-LAST:event_jTable1MousePressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
	// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    public DefaultTableModel DatosDemoras() {
	try {
	    setTitulos();
	    PreparedStatement PS = CN.prepareStatement("select ID,Fecha,Inicio,Fin,timestampdiff(minute,Inicio,Fin) as Duracion,Turno.turno,Telar,Tipo.Codigo,Demora.Descripcion from demora inner join turno inner join tipo where Demora.Turno=Turno.IDTurno and Demora.Tipo=Tipo.IDTipo order by demora.ID;");
	    RS = PS.executeQuery();
//            PS = CN.getConnection().prepareStatement(SQL_SELECT);
//            RS = PS.executeQuery();
	    Object[] fila = new Object[10];
	    while (RS.next()) {
		fila[0] = RS.getInt(1);//ID
		fila[1] = RS.getString(2);//Fecha
		fila[2] = RS.getString(3);//Inicio
		fila[3] = RS.getString(4);//Fin
		fila[4] = RS.getInt(5) + " min";//Duracion
		fila[5] = RS.getString(6);//Turno
		fila[6] = RS.getInt(7);//Telar
		fila[7] = RS.getString(8);//Codigo
		fila[8] = RS.getString(9);//Descripción
		DT.addRow(fila);
	    }

	} catch (SQLException e) {
	    System.out.println("Error al listar... " + e.getMessage());
	}
	return DT;
    }

    public DefaultTableModel filtro(String fec1, String fec2, String tu, int tel, String cd) {
	String SQLfiltro = null;
	//resultados();
	System.out.println("filtro:   " + fec1 + fec2 + tu + tel + cd);
	if (fec1 != null && fec2 != null && tu != null && tel != 0 && cd != null) {
	    //Cuando todos los campos estan llenos
	    System.out.println("filtro1:   " + fec1 + fec2 + tu + tel + cd);
	    SQLfiltro = "select * from detdem where fecha between '" + fec1 + "' and '" + fec2 + "' and turno='" + tu + "' and telar='" + tel + "' and codigo='" + cd + "'";
	} else if (cd == null) {
	    //Cuando falta el campo codigo
	    System.out.println("filtro2:   " + fec1 + fec2 + tu + tel + cd);
	    SQLfiltro = "select * from detdem where fecha between '" + fec1 + "' and '" + fec2 + "' and turno='" + tu + "' and telar='" + tel + "'";
	} else if (tel == 0) {
	    System.out.println("filtro3:   " + fec1 + fec2 + tu + tel + cd);
	    //Cuando falta el campo telar
	    SQLfiltro = "select * from detdem where fecha between '" + fec1 + "' and '" + fec2 + "' and turno='" + tu + "' and codigo='" + cd + "'";
	} else if (tu == null) {
	    System.out.println("filtro4:   " + fec1 + fec2 + tu + tel + cd);
	    //Cuando falta el campo turno
	    SQLfiltro = "select * from detdem where fecha between '" + fec1 + "' and '" + fec2 + "' and telar='" + tel + "' and codigo='" + cd + "'";
	} else if (fec2 == null) {
	    //Cuando falta fecha2
	    System.out.println("filtro5:   " + fec1 + fec2 + tu + tel + cd);
	    SQLfiltro = "select * from detdem where fecha = '" + fec1 + "' and telar='" + tel + "' and codigo='" + cd + "'";
	} else if (fec1 == null) {
	    //Cuando falta fecha1
	    System.out.println("filtro6:   " + fec1 + fec2 + tu + tel + cd);
	    SQLfiltro = "select * from detdem where fecha = '" + fec2 + "' and telar='" + tel + "' and codigo='" + cd + "'";
	}
	try {
	    setTitulos();
	    PreparedStatement PS = CN.prepareStatement(SQLfiltro);
	    RS = PS.executeQuery();
//            PS = CN2.getConnection().prepareStatement(SQL);
//            RS = PS.executeQuery();
	    Object[] fila = new Object[10];
	    while (RS.next()) {
		fila[0] = RS.getInt(1);//ID
		fila[1] = RS.getString(2);//Fecha
		fila[2] = RS.getString(3);//Inicio
		fila[3] = RS.getString(4);//Fin
		fila[4] = RS.getInt(5) + " min";//Duración
		fila[5] = RS.getString(6);//Turno
		fila[6] = RS.getInt(7);//Telar
		fila[7] = RS.getString(8);//Codigo
		fila[8] = RS.getString(9);//Descripción
		DT.addRow(fila);
	    }
	    //resultados();
	} catch (SQLException e) {
	    System.out.println("Error al filtrar los datos: " + e.getMessage());
	}
	return DT;
    }

    public DefaultTableModel busqueda(int crt, String prm) {
	String SQL = null;
	switch (crt) {
	    case 0:
		SQL = "select * from detdem where id = '" + prm + "' order by id";
		break;
	    case 1:
		SQL = "select * from detdem where Fecha like '" + prm + "%' order by id";
		break;
	    case 2:
		SQL = "select * from detdem where duracion = '" + prm + "' order by id";
		break;
	    case 3:
		SQL = "select * from detdem where Turno like '" + prm + "%' order by id";
		break;
	    case 4:
		SQL = "select * from detdem where Telar = '" + prm + "' order by id";
		break;
	    case 5:
		SQL = "select * from detdem where Codigo like '" + prm + "%' order by id";
		break;
	    case 6:
		SQL = "select * from detdem where match(Descripcion) against('" + prm + "') order by id";
		break;
	}

	try {
	    setTitulos();
	    PreparedStatement PS = CN.prepareStatement(SQL);
	    RS = PS.executeQuery();
	    Object[] fila = new Object[10];
	    while (RS.next()) {
		fila[0] = RS.getInt(1);//ID
		fila[1] = RS.getString(2);//Fecha
		fila[2] = RS.getString(3);//Inicio
		fila[3] = RS.getString(4);//Fin
		fila[4] = RS.getInt(5) + " min";//Duración
		fila[5] = RS.getString(6);//Turno
		fila[6] = RS.getInt(7);//Telar
		fila[7] = RS.getString(8);//Codigo
		fila[8] = RS.getString(9);//Descripción
		DT.addRow(fila);
		resultados();
	    }
	    //resultados();
	} catch (SQLException e) {
	    System.out.println("Error al listar..." + e.getMessage());
	}
	return DT;
    }

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
	    //JFrame.setDefaultLookAndFeelDecorated(true);
	    //JDialog.setDefaultLookAndFeelDecorated(true);
	    //UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
	    //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
	    //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	    //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
	    //UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
	    //UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");

	    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		if ("Windows".equals(info.getName())) {
		    javax.swing.UIManager.setLookAndFeel(info.getClassName());
		    break;
		}
	    }
	} catch (ClassNotFoundException ex) {
	    java.util.logging.Logger.getLogger(Demoras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (InstantiationException ex) {
	    java.util.logging.Logger.getLogger(Demoras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (IllegalAccessException ex) {
	    java.util.logging.Logger.getLogger(Demoras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(Demoras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (Exception e) {
	    e.printStackTrace();
	}
//        //</editor-fold>
//
//        /* Create and display the form */
	java.awt.EventQueue.invokeLater(new Runnable() {
	    public void run() {
		new Demoras().setVisible(true);
	    }
	});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> busquedaCodigo;
    private javax.swing.JComboBox<String> busquedaTelar;
    private javax.swing.JComboBox<String> busquedaTurno;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    public static com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbtBuscaFiltro;
    private javax.swing.JButton jbtCancelarE;
    private javax.swing.JButton jbtEditar;
    private javax.swing.JButton jbtEliminar;
    private javax.swing.JButton jbtGCambios;
    private javax.swing.JButton jbtGuardar;
    private javax.swing.JButton jbtSalir;
    private javax.swing.JComboBox<String> jcbBuscar;
    private javax.swing.JComboBox<String> jcb_Codigo;
    private javax.swing.JComboBox<String> jcb_Telar;
    private javax.swing.JComboBox<String> jcb_Turno;
    private javax.swing.JLabel jlbResBus;
    public static javax.swing.JSpinner jspFin;
    public static javax.swing.JSpinner jspInicio;
    private javax.swing.JTextArea jtaDescripcion;
    private javax.swing.JTextField jtfBusqueda;
    // End of variables declaration//GEN-END:variables

}
