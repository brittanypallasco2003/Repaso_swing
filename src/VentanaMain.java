import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

public class VentanaMain {
    private JTextField inputName;
    private JTable registrarAlumnosTable;
    private JButton borrarButton;
    private JComboBox comboBoxCarrera;
    private JComboBox comboBoxGrupo;
    private JComboBox comboBoxSemestre;
    private JSpinner spinnerPromedio;
    private JButton agregarButton;
    private JPanel rootPanel;

    DefaultTableModel model=new DefaultTableModel();/*Este modelo se pasara lo del array list a la jtable*/
    ArrayList <Alumno> alumnos= new ArrayList<Alumno>();


    public VentanaMain() {

        model.addColumn("Nombre");
        model.addColumn("Carrera");
        model.addColumn("Semestre");
        model.addColumn("Grupo");
        model.addColumn("Promedio");
        refrescarTabla();


        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Alumno alumno=new Alumno("","","",0,0);
                    alumno.setNombre(inputName.getText());
                    alumno.setCarrera(String.valueOf(comboBoxCarrera.getSelectedItem()));/*getselected, regresa un object que se transforma a string y luego a otro tipo de dato*/
                    alumno.setGrupo(Integer.parseInt(comboBoxGrupo.getSelectedItem().toString()));
                    alumno.setSemestre(comboBoxSemestre.getSelectedItem().toString());
                    alumno.setPromedio(Double.parseDouble(String.valueOf(spinnerPromedio.getValue())));
                    alumnos.add(alumno);
                    refrescarTabla();
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(null,"ERROR");
                }
            }
        });
        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputName.setText("");
                comboBoxSemestre.setSelectedIndex(0);
                comboBoxCarrera.setSelectedIndex(0);
                comboBoxGrupo.setSelectedIndex(0);
                spinnerPromedio.setValue(10);

            }
        });
    }

    public void refrescarTabla() {
        while (model.getRowCount() > 0) {
            //borar filaas del modelo
            model.removeRow(0);
            registrarAlumnosTable.setModel(model);
        }
        for (Alumno alumno:alumnos){
            Object al[]=new Object[5];
            al[0]=alumno.getNombre();
            al[1]=alumno.getCarrera();
            al[2]=alumno.getSemestre();
            al[3]=alumno.getGrupo();
            al[4]=alumno.getPromedio();
            model.addRow(al);
        }
        registrarAlumnosTable.setModel(model);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Formulario");
        frame.setSize(600,600);
        frame.setContentPane(new VentanaMain().rootPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}


/*
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
*/