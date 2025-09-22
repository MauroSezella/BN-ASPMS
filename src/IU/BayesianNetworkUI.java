package IU;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.image.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import smile.Network;

public class BayesianNetworkUI {
    
    private Network net;
    private JComboBox<String> frecuenciaComCliDesComboBox;
    private JComboBox<String> comunicacionEquipoComboBox;
    private JComboBox<String> aportesClienteComboBox;
    private JComboBox<String> tamanioEquipoComboBox;
    private JComboBox<String> documentacionComboBox;
    private JComboBox<String> variabilidadRequerimientosComboBox;
    private JComboBox<String> tecnologiaComboBox;
    private JComboBox<String> complejidadComboBox;
    private JComboBox<String> comunicacionComboBox;
    private JComboBox<String> equipoComboBox;
    private JComboBox<String> formalidadComboBox;

    private JButton applyButton;
    private JButton clearButton;
    private JTextArea resultArea;


    public BayesianNetworkUI() {
       
        net = new Network();
        net.readFile("RB_Model_Process.xdsl");
        
        JFrame frame = new JFrame("Asistente en la Elección del Modelo de Proceso de Software");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 850);
        frame.setLocationRelativeTo(null);
        
        JPanel panelMain = new JPanel();
        panelMain.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelMain.setBorder(new EmptyBorder(10, 30, 10, 30));
        
        Color customColor = new Color(192, 230, 237);
        panelMain.setBackground(customColor);

        JPanel panelBanner = new JPanel() {
            // Sobrescribir el método paintComponent para pintar la imagen
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    // Cargar la imagen PNG
                    BufferedImage image = ImageIO.read(new File("banner.jpeg")); // Reemplaza con la ruta de tu imagen

                    // Escalar la imagen al tamaño del JPanel
                    Image scaledImage = image.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);

                    // Dibujar la imagen escalada
                    g.drawImage(scaledImage, 0, 0, this.getWidth(), this.getHeight(), this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        panelBanner.setBackground(customColor);
        panelBanner.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelBanner.setPreferredSize(new Dimension(520, 80)); 

        panelMain.add(panelBanner);

        JPanel panelComboBox1 = new JPanel();
        panelComboBox1.setBackground(customColor);
        panelComboBox1.setLayout(new BoxLayout(panelComboBox1, BoxLayout.X_AXIS));
        panelComboBox1.setPreferredSize(new Dimension(500, 25)); 
        panelComboBox1.setMinimumSize(new Dimension(500, 25));   
        panelComboBox1.setMaximumSize(new Dimension(500, 25)); 
        frecuenciaComCliDesComboBox = new JComboBox<>(new String[]{"poco_frecuente", "frecuente", "muy_frecuente"});
        frecuenciaComCliDesComboBox.setSelectedItem(null);
        panelComboBox1.add(new JLabel("Frecuencia Comunicacion Cliente-Desarrollador:"));
        panelComboBox1.add(Box.createHorizontalStrut(20));
        panelComboBox1.add(frecuenciaComCliDesComboBox);

        JPanel panelComboBox2 = new JPanel();
        panelComboBox2.setBackground(customColor);
        panelComboBox2.setLayout(new BoxLayout(panelComboBox2, BoxLayout.X_AXIS));
        panelComboBox2.setPreferredSize(new Dimension(400, 25)); 
        panelComboBox2.setMinimumSize(new Dimension(400, 25));  
        panelComboBox2.setMaximumSize(new Dimension(400, 25));  
        comunicacionEquipoComboBox = new JComboBox<>(new String[]{"informal", "semi_formal", "formal"});
        comunicacionEquipoComboBox.setSelectedItem(null);
        panelComboBox2.add(new JLabel("Comunicacion del Equipo:"));
        panelComboBox2.add(Box.createHorizontalStrut(20));
        panelComboBox2.add(comunicacionEquipoComboBox);


        JPanel panelComboBox3 = new JPanel();
        panelComboBox3.setBackground(customColor);
        panelComboBox3.setLayout(new BoxLayout(panelComboBox3, BoxLayout.X_AXIS));
        panelComboBox3.setPreferredSize(new Dimension(400, 25)); 
        panelComboBox3.setMinimumSize(new Dimension(400, 25));  
        panelComboBox3.setMaximumSize(new Dimension(400, 25));
        aportesClienteComboBox = new JComboBox<>(new String[]{"baja", "moderada", "alta"});
        aportesClienteComboBox.setSelectedItem(null);
        panelComboBox3.add(new JLabel("Aportes del cliente:"));
        panelComboBox3.add(Box.createHorizontalStrut(20));
        panelComboBox3.add(aportesClienteComboBox);

        JPanel panelComboBox4 = new JPanel();
        panelComboBox4.setBackground(customColor);
        panelComboBox4.setLayout(new BoxLayout(panelComboBox4, BoxLayout.X_AXIS));
        panelComboBox4.setPreferredSize(new Dimension(400, 25)); 
        panelComboBox4.setMinimumSize(new Dimension(400, 25));  
        panelComboBox4.setMaximumSize(new Dimension(400, 25));
        tamanioEquipoComboBox = new JComboBox<>(new String[]{"pequenio", "mediano", "grande"});
        tamanioEquipoComboBox.setSelectedItem(null);
        panelComboBox4.add(new JLabel("Tamaño del Equipo:"));
        panelComboBox4.add(Box.createHorizontalStrut(20));
        panelComboBox4.add(tamanioEquipoComboBox);

        JPanel panelComboBox5 = new JPanel();
        panelComboBox5.setBackground(customColor);
        panelComboBox5.setLayout(new BoxLayout(panelComboBox5, BoxLayout.X_AXIS));
        panelComboBox5.setPreferredSize(new Dimension(400, 25)); 
        panelComboBox5.setMinimumSize(new Dimension(400, 25));  
        panelComboBox5.setMaximumSize(new Dimension(400, 25));
        documentacionComboBox = new JComboBox<>(new String[]{"baja", "media", "alta"});
        documentacionComboBox.setSelectedItem(null);
        panelComboBox5.add(new JLabel("Documentacion:"));
        panelComboBox5.add(Box.createHorizontalStrut(20));
        panelComboBox5.add(documentacionComboBox);

        JPanel panelComboBox6 = new JPanel();
        panelComboBox6.setBackground(customColor);
        panelComboBox6.setLayout(new BoxLayout(panelComboBox6, BoxLayout.X_AXIS));
        panelComboBox6.setPreferredSize(new Dimension(400, 25)); 
        panelComboBox6.setMinimumSize(new Dimension(400, 25));  
        panelComboBox6.setMaximumSize(new Dimension(400, 25));
        variabilidadRequerimientosComboBox = new JComboBox<>(new String[]{"estables", "volatiles"});
        variabilidadRequerimientosComboBox.setSelectedItem(null);
        panelComboBox6.add(new JLabel("Variabilidad de los Requerimientos:"));
        panelComboBox6.add(Box.createHorizontalStrut(20));
        panelComboBox6.add(variabilidadRequerimientosComboBox);

        JPanel panelComboBox7 = new JPanel();
        panelComboBox7.setBackground(customColor);
        panelComboBox7.setLayout(new BoxLayout(panelComboBox7, BoxLayout.X_AXIS));
        panelComboBox7.setPreferredSize(new Dimension(400, 25)); 
        panelComboBox7.setMinimumSize(new Dimension(400, 25));  
        panelComboBox7.setMaximumSize(new Dimension(400, 25));
        tecnologiaComboBox = new JComboBox<>(new String[]{"conocida", "conocida_nueva", "nueva"});
        tecnologiaComboBox.setSelectedItem(null);
        panelComboBox7.add(new JLabel("Tecnologia:"));
        panelComboBox7.add(Box.createHorizontalStrut(20));
        panelComboBox7.add(tecnologiaComboBox);

        JPanel panelComboBox8 = new JPanel();
        panelComboBox8.setBackground(customColor);
        panelComboBox8.setLayout(new BoxLayout(panelComboBox8, BoxLayout.X_AXIS));
        panelComboBox8.setPreferredSize(new Dimension(400, 25)); 
        panelComboBox8.setMinimumSize(new Dimension(400, 25));  
        panelComboBox8.setMaximumSize(new Dimension(400, 25));
        complejidadComboBox = new JComboBox<>(new String[]{"baja", "media", "alta"});
        complejidadComboBox.setSelectedItem(null);
        panelComboBox8.add(new JLabel("Compeljidad:"));
        panelComboBox8.add(Box.createHorizontalStrut(20));
        panelComboBox8.add(complejidadComboBox);

        JPanel panelComboBox9 = new JPanel();
        panelComboBox9.setBackground(customColor);
        panelComboBox9.setLayout(new BoxLayout(panelComboBox9, BoxLayout.X_AXIS));
        panelComboBox9.setPreferredSize(new Dimension(400, 25)); 
        panelComboBox9.setMinimumSize(new Dimension(400, 25));  
        panelComboBox9.setMaximumSize(new Dimension(400, 25));
        comunicacionComboBox = new JComboBox<>(new String[]{"regular", "buena", "muy_buena"});
        comunicacionComboBox.setSelectedItem(null);
        panelComboBox9.add(new JLabel("Comunicacion:"));
        panelComboBox9.add(Box.createHorizontalStrut(20));
        panelComboBox9.add(comunicacionComboBox);

        JPanel panelComboBox10 = new JPanel();
        panelComboBox10.setBackground(customColor);
        panelComboBox10.setLayout(new BoxLayout(panelComboBox10, BoxLayout.X_AXIS));
        panelComboBox10.setPreferredSize(new Dimension(400, 25)); 
        panelComboBox10.setMinimumSize(new Dimension(400, 25));  
        panelComboBox10.setMaximumSize(new Dimension(400, 25));
        equipoComboBox = new JComboBox<>(new String[]{"inexperimentado", "adecuado", "experimentado"});
        equipoComboBox.setSelectedItem(null);
        panelComboBox10.add(new JLabel("Equipo:"));
        panelComboBox10.add(Box.createHorizontalStrut(20));
        panelComboBox10.add(equipoComboBox);

        JPanel panelComboBox11 = new JPanel();
        panelComboBox11.setBackground(customColor);
        panelComboBox11.setLayout(new BoxLayout(panelComboBox11, BoxLayout.X_AXIS));
        panelComboBox11.setPreferredSize(new Dimension(400, 25)); 
        panelComboBox11.setMinimumSize(new Dimension(400, 25));  
        panelComboBox11.setMaximumSize(new Dimension(400, 25));
        formalidadComboBox = new JComboBox<>(new String[]{"baja", "media", "alta"});
        formalidadComboBox.setSelectedItem(null);
        panelComboBox11.add(new JLabel("Formalidad:"));
        panelComboBox11.add(Box.createHorizontalStrut(20));
        panelComboBox11.add(formalidadComboBox);


        panelMain.add(panelComboBox1);
        panelMain.add(Box.createVerticalStrut(40));
        panelMain.add(panelComboBox2);
        panelMain.add(Box.createVerticalStrut(40));
        panelMain.add(panelComboBox3);
        panelMain.add(Box.createVerticalStrut(40));
        panelMain.add(panelComboBox4);
        panelMain.add(Box.createVerticalStrut(40));
        panelMain.add(panelComboBox5);
        panelMain.add(Box.createVerticalStrut(40));
        panelMain.add(panelComboBox6);
        panelMain.add(Box.createVerticalStrut(40));
        panelMain.add(panelComboBox7);
        panelMain.add(Box.createVerticalStrut(40));
        panelMain.add(panelComboBox8);
        panelMain.add(Box.createVerticalStrut(40));
        panelMain.add(panelComboBox9);
        panelMain.add(Box.createVerticalStrut(40));
        panelMain.add(panelComboBox10);
        panelMain.add(Box.createVerticalStrut(40));
        panelMain.add(panelComboBox11);
        panelMain.add(Box.createVerticalStrut(60));


    
        applyButton = new JButton("Calcular");
        clearButton = new JButton("Limpiar");

        JPanel panelBoton = new JPanel();
        panelBoton.setBackground(customColor);
        panelBoton.setPreferredSize(new Dimension(500, 50)); 
        panelBoton.setMinimumSize(new Dimension(500, 50));  
        panelBoton.setMaximumSize(new Dimension(500, 50));
        panelBoton.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 0));
        panelBoton.add(clearButton);
        panelBoton.add(applyButton);


        panelMain.add(panelBoton);

        JPanel panelResultado = new JPanel();
        panelResultado.setBackground(customColor);
        panelResultado.setLayout(new BoxLayout(panelResultado, BoxLayout.Y_AXIS));

        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(customColor);
        panelTitulo.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelTitulo.setPreferredSize(new Dimension(500, 30));
        panelTitulo.setMinimumSize(new Dimension(500, 30));  
        panelTitulo.setMaximumSize(new Dimension(500, 30));
        JLabel tituloResultado = new JLabel("RESULTADOS");
        tituloResultado.setFont(new Font(tituloResultado.getFont().getName(), Font.BOLD, 14));
        panelTitulo.add(tituloResultado);

        JPanel panelTextArea = new JPanel();
        panelTextArea.setLayout(new FlowLayout(FlowLayout.CENTER));
        resultArea = new JTextArea(3, 50);
        resultArea.setEditable(false);
        panelTextArea.add(resultArea);
        panelTextArea.add(new JScrollPane(resultArea));

        panelResultado.add(panelTitulo);
        panelResultado.add(panelTextArea);

        panelMain.add(panelResultado);

        frame.getContentPane().add(panelMain);

          applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applyEvidence();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
          
                frecuenciaComCliDesComboBox.setSelectedItem(null);
                comunicacionEquipoComboBox.setSelectedItem(null);
                aportesClienteComboBox.setSelectedItem(null);
                tamanioEquipoComboBox.setSelectedItem(null);
                documentacionComboBox.setSelectedItem(null);
                variabilidadRequerimientosComboBox.setSelectedItem(null);
                tecnologiaComboBox.setSelectedItem(null);
                complejidadComboBox.setSelectedItem(null);
                comunicacionComboBox.setSelectedItem(null);
                equipoComboBox.setSelectedItem(null);
                formalidadComboBox.setSelectedItem(null);

                resultArea.setText("");

                net.clearAllEvidence();

            }
        });


        frame.setVisible(true);
    }

    private void applyEvidence() {

        resultArea.setText("");
        net.clearAllEvidence();

        boolean flag = false; 

        String frecuenciaComCliDes = (String) frecuenciaComCliDesComboBox.getSelectedItem();
        String comunicacionEquipo = (String) comunicacionEquipoComboBox.getSelectedItem();
        String aportesCliente = (String) aportesClienteComboBox.getSelectedItem();
        String tamanioEquipo = (String) tamanioEquipoComboBox.getSelectedItem();
        String documentacion = (String) documentacionComboBox.getSelectedItem();
        String variabilidadRequerimientos = (String) variabilidadRequerimientosComboBox.getSelectedItem();
        String tecnologia = (String) tecnologiaComboBox.getSelectedItem();
        String complejidad = (String) complejidadComboBox.getSelectedItem();
        String comunicacion = (String) comunicacionComboBox.getSelectedItem();
        String equipo = (String) equipoComboBox.getSelectedItem();
        String formalidad = (String) formalidadComboBox.getSelectedItem();

        if(frecuenciaComCliDes != null){
            net.setEvidence("frecuencia_com_cli_des", frecuenciaComCliDes);
            flag = true; 
        }

        if(comunicacionEquipo != null){
            net.setEvidence("comunicacion_equipo", comunicacionEquipo);	
            flag = true; 
        }

        if(aportesCliente != null){
            net.setEvidence("aportes_cliente", aportesCliente);	
            flag = true; 
        }

        if(tamanioEquipo != null){
            net.setEvidence("tamanio_equipo", tamanioEquipo);	
            flag = true;         
        }

        if(documentacion != null){
            net.setEvidence("documentacion", documentacion);
            flag = true;        
        }

        if(variabilidadRequerimientos != null){
            net.setEvidence("var_req", variabilidadRequerimientos);	
            flag = true;        
        }

        if(tecnologia != null){
            net.setEvidence("tecnologia", tecnologia);	
            flag = true;       
        }

        if(complejidad != null){
            net.setEvidence("complejidad", complejidad);	
            flag = true;       
        }

        if(comunicacion != null){
            net.setEvidence("comunicacion", comunicacion);	
            flag = true;        
        }

        if(equipo != null){
            net.setEvidence("equipo", equipo);	
            flag = true;        
        }

        if(formalidad != null){
            net.setEvidence("formalidad", formalidad);	
            flag = true;      
        }

        if(flag){

            net.updateBeliefs();

            String nodeId = "modelo_proceso";
            int nodeHandle = net.getNode(nodeId);
            double[] posteriors = net.getNodeValue(nodeHandle);

            StringBuilder resultado = new StringBuilder();

            for (int i = 0; i < posteriors.length; i++) {
                String outcomeId = net.getOutcomeId(nodeHandle, i);
                double porcentaje = posteriors[i] * 100;
                resultado.append(String.format("Modelo de proceso: %s = %2.2f", outcomeId, porcentaje) + ("% \n"));
            }

            resultArea.setText(resultado.toString());

            //System.out.printf("------------------------------------------\n");

            /*if(posteriors[0] > posteriors[1]){
                resultArea.setForeground(Color.BLUE); 
                resultArea.setText("MODELO DE PROCESO TRADICIONAL");
            }else{
                resultArea.setForeground(Color.MAGENTA); 
                resultArea.setText("MODELO DE PROCESO ÁGIL");
            }*/

        }else{

            resultArea.setForeground(Color.RED); 
            resultArea.setText("NO SE CARGARON EVIDENCIAS");
        }


    }

}
