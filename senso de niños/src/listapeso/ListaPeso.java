package listapeso;

import javax.swing.JOptionPane;

public class ListaPeso {

    Lista obj1;

    public ListaPeso() {
        obj1 = new Lista();
    }

    public void menu() {
        int opc = 0;

        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog(null, "Menu\n"
                    + "1.Ingresar informacion del niño al inicio de la lista\n"
                    + "2.Ingresar informacion del niño entre dos nodos\n"
                    + "3.Ingresar informacion del niño al final de la lista\n"
                    + "4.Buscar informacion del niño\n"
                    + "5.Ordenar listar por peso\n"
                    + "6.Eliminar informacion de un niño\n"
                    + "7.Listado por municipios de los niños\n"
                    + "8.Listado por municipio para niños bajos de peso entre 2 y 3, 4 y 6 años\n"
                    + "9.Listado por municipio para niños bajos de estatura entre 4 y 6 años\n"
                    + "10.Salir\n"
                    + "Elija una opcion"));

            switch (opc) {
                case 1: {
                    obj1.Pedir_Datos(1);
                    break;
                }

                case 2: {
                    obj1.Pedir_Datos(2);
                    break;
                }

                case 3: {
                    obj1.Pedir_Datos(3);
                    break;
                }

                case 4: {
                    obj1.Mostrar_Datos(JOptionPane.showInputDialog("Ingrese numero de registro civil"));
                    break;
                }

                case 5: {
                    obj1.OrdenarLista();
                    break;
                }

                case 6: {
                    obj1.Eliminar(JOptionPane.showInputDialog("Ingrese numero de registro civil"));
                    break;
                }

                case 7: {
                    obj1.Listado_Municipio("Sahagun");
                    obj1.Listado_Municipio("Monteria");
                    obj1.Listado_Municipio("Lorica");
                    break;
                }

                case 8: {
                    obj1.Bajos_Peso("Sahagun");
                    obj1.Bajos_Peso("Monteria");
                    obj1.Bajos_Peso("Lorica");
                    break;
                }

                case 9: {
                    obj1.Bajos_Estatura("Sahagun");
                    obj1.Bajos_Estatura("Monteria");
                    obj1.Bajos_Estatura("Lorica");
                    break;
                }
                
                case 10: {
                    JOptionPane.showMessageDialog(null, "Vuelve pronto (*_*) ");
                    break;
                }
                
                default:{
                    JOptionPane.showMessageDialog(null, "Opcion invalida");
                    break;
                }
            }
        } while (opc != 10);
    }

    public static void main(String[] args) {
        ListaPeso lp = new ListaPeso();
        lp.menu();
    }

}
