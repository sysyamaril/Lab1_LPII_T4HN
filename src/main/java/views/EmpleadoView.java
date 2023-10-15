package views;

import javax.swing.*;
import controllers.EmpleadoController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmpleadoView {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("CRUD de Empleados");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Crear Empleado", createCreateEmpleadoPanel());
        tabbedPane.addTab("Leer Empleado", createReadEmpleadoPanel());
        tabbedPane.addTab("Actualizar Empleado", createUpdateEmpleadoPanel());
        tabbedPane.addTab("Eliminar Empleado", createDeleteEmpleadoPanel());

        frame.add(tabbedPane);
        frame.pack();
        frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        frame.setVisible(true);
    }

    private static JPanel createCreateEmpleadoPanel() {
        JPanel panel = new JPanel(new GridLayout(6, 2));
        JTextField apellidosField = new JTextField();
        JTextField nombresField = new JTextField();
        JTextField edadField = new JTextField();
        JTextField sexoField = new JTextField();
        JTextField salarioField = new JTextField();
        JButton crearButton = new JButton("Crear Empleado");

        panel.add(new JLabel("Apellidos: "));
        panel.add(apellidosField);
        panel.add(new JLabel("Nombres: "));
        panel.add(nombresField);
        panel.add(new JLabel("Edad: "));
        panel.add(edadField);
        panel.add(new JLabel("Sexo: "));
        panel.add(sexoField);
        panel.add(new JLabel("Salario: "));
        panel.add(salarioField);
        panel.add(new JLabel("Crear Empleado: "));
        panel.add(crearButton);

        crearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String apellidos = apellidosField.getText();
                String nombres = nombresField.getText();
                int edad = Integer.parseInt(edadField.getText());
                String sexo = sexoField.getText();
                double salario = Double.parseDouble(salarioField.getText());

                EmpleadoController empleadoController = new EmpleadoController();
                String mensaje = empleadoController.createEmpleado(apellidos, nombres, edad, sexo, salario);

                JOptionPane.showMessageDialog(null, mensaje);
            }
        });

        return panel;
    }

    private static JPanel createReadEmpleadoPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 2));
        JTextField idField = new JTextField();
        JButton leerButton = new JButton("Leer Empleado");
        JTextArea resultArea = new JTextArea();

        panel.add(new JLabel("ID del Empleado: "));
        panel.add(idField);
        panel.add(leerButton);
        panel.add(resultArea);

        leerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());

                EmpleadoController empleadoController = new EmpleadoController();
                String empleadoInfo = empleadoController.getEmpleado(id);

                resultArea.setText(empleadoInfo);
            }
        });

        return panel;
    }

    private static JPanel createUpdateEmpleadoPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2));
        JTextField idField = new JTextField();
        JTextField nuevoApellidosField = new JTextField();
        JButton actualizarButton = new JButton("Actualizar Empleado");

        panel.add(new JLabel("ID del Empleado: "));
        panel.add(idField);
        panel.add(new JLabel("Nuevo Apellidos: "));
        panel.add(nuevoApellidosField);
        panel.add(new JLabel(" "));
        panel.add(actualizarButton);

        actualizarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());
                String nuevoApellidos = nuevoApellidosField.getText();

                EmpleadoController empleadoController = new EmpleadoController();
                String mensaje = empleadoController.updateEmpleado(id, nuevoApellidos);

                JOptionPane.showMessageDialog(null, mensaje);
            }
        });

        return panel;
    }

    private static JPanel createDeleteEmpleadoPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 2));
        JTextField idField = new JTextField();
        JButton eliminarButton = new JButton("Eliminar Empleado");

        panel.add(new JLabel("ID del Empleado: "));
        panel.add(idField);
        panel.add(new JLabel(" "));
        panel.add(eliminarButton);

        eliminarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());

                EmpleadoController empleadoController = new EmpleadoController();
                String mensaje = empleadoController.deleteEmpleado(id);

                JOptionPane.showMessageDialog(null, mensaje);
            }
        });

        return panel;
    }
}
