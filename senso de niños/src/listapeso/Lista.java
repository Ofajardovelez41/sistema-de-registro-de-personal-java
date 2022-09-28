package listapeso;

import javax.swing.JOptionPane;

public class Lista {

    public ninio Cab;
    public int Tamanio;

    public Lista() {
        Cab = null;
        Tamanio = 0;
    }

    public void Pedir_Datos(int opc){
        ninio n = new ninio();
        boolean v = false;
        int opcMun = 0;
        
        do{
            n.setRegistro_civil(JOptionPane.showInputDialog("Ingrese numero de registro civil"));
            v = Verificar_Registro_Civil(n.getRegistro_civil());
            
            if(v){
                JOptionPane.showMessageDialog(null, "Este numero de registro civil ya se encuentra registrado");
            }
        }while(v);
        
        n.setNombre(JOptionPane.showInputDialog("Ingrese nombre del niño"));
        n.setTalla(Float.parseFloat(JOptionPane.showInputDialog("Ingrese talla")));
        n.setPeso(Float.parseFloat(JOptionPane.showInputDialog("Ingrese peso")));
        n.setEdad(Integer.parseInt(JOptionPane.showInputDialog("Ingrese edad del niño")));
        
        do{
            n.setIdentificacionPadre(JOptionPane.showInputDialog("Ingrese numero de identificacion del padre"));
            v = Verificar_Identificacion_Padre(n.getIdentificacionPadre());
            
            if(v){
                JOptionPane.showMessageDialog(null, "Este numero de identificacion ya se ha relacionado a dos niños");
            }
        }while(v);
        
        n.setNombrePadre(JOptionPane.showInputDialog("Ingrese nombre del padre"));
        
        do{
            opcMun = Integer.parseInt(JOptionPane.showInputDialog("Municipio\n"
                    + "1. Sahagun\n"
                    + "2. Monteria\n"
                    + "3. Lorica\n"
                    + "Elija una opcion"));
        }while(opcMun < 1 && opcMun > 3);
        
        switch(opcMun){
            case 1 : {
                n.setMunicipio("Sahagun");
                break;
            }
            
            case 2 : {
                n.setMunicipio("Monteria");
                break;
            } 
            
            case 3 : {
                n.setMunicipio("Lorica");
                break;
            }
        }
        
        switch(opc){
            case 1:{
                this.Agregar_Inicio(n);
                break;
            }
            
            case 2:{
                this.Agregar_Entre_Dos(n);
                break;
            }
            
            case 3:{
                this.Agregar_Final(n);
                break;
            }
        }
    }
    
    public boolean Verificar_Registro_Civil(String r){
        boolean existe = false;
        
        if (Cab == null) {
            return existe;
        } else {
            ninio aux = Cab;

            while (aux != null && !existe) {
                if(aux.getRegistro_civil().equalsIgnoreCase(r)){
                    existe = true;
                }
                aux = aux.getSig();
            }
            return existe;
        }
    }
    
    public boolean Verificar_Identificacion_Padre(String id){
        boolean existe = false;
        
        if (Cab == null) {
            return existe;
        } else {
            ninio aux = Cab;
            int Cont = 0;
            
            while (aux != null && Cont < 2) {
                if(aux.getIdentificacionPadre().equalsIgnoreCase(id)){
                    Cont++;
                }
                aux = aux.getSig();
            }
            
            if (Cont > 1){
                existe = true;
            }
            return existe;
        }
    }
    
    public void Agregar_Inicio(ninio nodo) {
        if (Cab == null) {
            Cab = nodo;
        } else {
            nodo.setSig(Cab);
            Cab = nodo;
        }
        Tamanio++;
        JOptionPane.showMessageDialog(null, "Se ha agregado al inicio");
    }

    public void Agregar_Final(ninio nodo) {
        if (Cab == null) {
            Cab = nodo;
        } else {
            ninio aux = Cab;

            while (aux.getSig() != null) {
                aux = aux.getSig();
            }

            aux.setSig(nodo);
        }
        Tamanio++;
        JOptionPane.showMessageDialog(null, "Se ha agregado al final");
    }

    public void Agregar_Entre_Dos(ninio nodo) {
        if (Tamanio > 1) {
            ninio aux = Cab;

            nodo.setSig(aux.getSig());
            aux.setSig(nodo);

            Tamanio++;
            JOptionPane.showMessageDialog(null, "Se ha agregado entre el primer nodo y el segundo nodo");
        } else {
            JOptionPane.showMessageDialog(null, "No hay suficientes nodos para agregar entre dos");
        }
    }

    public void Mostrar_Datos(String id) {
        String format = "";

        if (Cab != null) {
            ninio aux = Cab;
            boolean s = true;

            while (aux != null && s) {
                if (aux.getRegistro_civil().equalsIgnoreCase(id)) {
                    format = "Registro Civil: " + aux.getRegistro_civil() + "\nNombre: " + aux.getNombre() + "\nTalla: " + aux.getTalla() + "\nPeso: "
                            + aux.getPeso() + "\nEdad: " + aux.getEdad() + "\nIdentificacion Padre: " + aux.getIdentificacionPadre() + "\nNombre Padre: " + aux.getNombrePadre()
                            + "\nMunicipio: " + aux.getMunicipio();
                    s = false;
                }
                aux = aux.getSig();
            }

            if (s) {
                JOptionPane.showMessageDialog(null, "No hay registro de este niño");
            } else {
                JOptionPane.showMessageDialog(null, format);
            }
        } else {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        }
    }

    public void Eliminar(String id) {
        if (Cab != null) {
            ninio aux = Cab;
            boolean s = true;

            if (aux.getRegistro_civil().equalsIgnoreCase(id)) {
                Cab = aux.getSig();
                s = false;
            } else {
                while (aux.getSig() != null && s) {
                    if (aux.getSig().getRegistro_civil().equalsIgnoreCase(id)) {
                        ninio aux2 = aux.getSig();
                        aux.setSig(aux.getSig().getSig());
                        aux2.setSig(null);
                        aux2 = null;
                        s = false;
                    }
                    aux = aux.getSig();
                }

            }

            if (!s) {
                JOptionPane.showMessageDialog(null, "Se elimino el nodo con Registro civil: " + id);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro el nodo a eliminar");
            }
        } else {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        }
    }

    public void OrdenarLista() {
        if (Cab != null) {
            ninio aux = Cab;
            ninio aux2;
            ninio auxcambio = null;

            while (aux != null) {
                aux2 = Cab.getSig();
                while (aux2 != null) {
                    if (aux.getPeso() > aux2.getPeso()) {
                        Cambiar(aux, aux2);
                    }
                    aux2 = aux2.getSig();
                }

                aux = aux.getSig();
            }
            JOptionPane.showMessageDialog(null, "Se ha ordenado la lista de menor a mayor peso");
        } else {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        }
    }

    public void Cambiar(ninio aux, ninio aux2) {
        ninio cambio = new ninio();

        cambio.setRegistro_civil(aux.getRegistro_civil());
        cambio.setNombre(aux.getNombre());
        cambio.setTalla(aux.getTalla());
        cambio.setPeso(aux.getPeso());
        cambio.setEdad(aux.getEdad());
        cambio.setIdentificacionPadre(aux.getIdentificacionPadre());
        cambio.setNombrePadre(aux.getNombrePadre());
        cambio.setMunicipio(aux.getMunicipio());

        aux.setRegistro_civil(aux2.getRegistro_civil());
        aux.setNombre(aux2.getNombre());
        aux.setTalla(aux2.getTalla());
        aux.setPeso(aux2.getPeso());
        aux.setEdad(aux2.getEdad());
        aux.setIdentificacionPadre(aux2.getIdentificacionPadre());
        aux.setNombrePadre(aux2.getNombrePadre());
        aux.setMunicipio(aux2.getMunicipio());

        aux2.setRegistro_civil(cambio.getRegistro_civil());
        aux2.setNombre(cambio.getNombre());
        aux2.setTalla(cambio.getTalla());
        aux2.setPeso(cambio.getPeso());
        aux2.setEdad(cambio.getEdad());
        aux2.setIdentificacionPadre(cambio.getIdentificacionPadre());
        aux2.setNombrePadre(cambio.getNombrePadre());
        aux2.setMunicipio(cambio.getMunicipio());
    }

    public void Listado_Municipio(String municipio) {
        String format = "/////" + municipio + "/////\n";
        int Cont = 0;

        if (Cab != null) {
            ninio aux = Cab;

            while (aux != null) {
                if (aux.getMunicipio().equalsIgnoreCase(municipio)) {
                    Cont++;
                    format += "Registro Civil: " + aux.getRegistro_civil() + "\nNombre: " + aux.getNombre() + "\nTalla: " + aux.getTalla() + "\nPeso: " + aux.getPeso()
                            + "\nEdad: " + aux.getEdad() + "\nIdentificacion Padre: " + aux.getIdentificacionPadre() + "\nNombre Padre: "
                            + aux.getNombrePadre() + "\n------------------------------\n";
                }
                aux = aux.getSig();
            }

            if (Cont == 0) {
                format += "No hay registro de este municipio";
                JOptionPane.showMessageDialog(null, format);
            } else {
                format += "Numero de niños en el municipio: " + Cont;
                JOptionPane.showMessageDialog(null, format);
            }
        } else {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        }
    }

    public void Bajos_Peso(String municipio) {
        String format = "/////" + municipio + "/////\n";
        int Cont1 = 0;
        int Cont2 = 0;

        if (Cab != null) {
            ninio aux = Cab;

            while (aux != null) {
                if (aux.getMunicipio().equalsIgnoreCase(municipio)) {
                    if (aux.getEdad()>=2 && aux.getEdad()<=3 && aux.getPeso() < 15) {
                        Cont1++;
                        format += "Registro Civil: " + aux.getRegistro_civil() + "\nNombre: " + aux.getNombre() + "\nTalla: " + aux.getTalla() + "\nPeso: " + aux.getPeso()
                                + "Edad: " + aux.getEdad() + "\nIdentificacion Padre: " + aux.getIdentificacionPadre() + "\nNombre Padre: "
                                + aux.getNombrePadre() + "\n------------------------------\n";
                    }else if(aux.getEdad()>=4 && aux.getEdad()<=6 && aux.getPeso() < 25){
                        Cont2++;
                        format += "Registro Civil: " + aux.getRegistro_civil() + "\nNombre: " + aux.getNombre() + "\nTalla: " + aux.getTalla() + "\nPeso: " + aux.getPeso()
                                + "Edad: " + aux.getEdad() + "\nIdentificacion Padre: " + aux.getIdentificacionPadre() + "\nNombre Padre: "
                                + aux.getNombrePadre() + "\n------------------------------\n";
                    }
                }
                aux = aux.getSig();
            }

            if (Cont1+Cont2 == 0) {
                format += "No hay registro de este municipio";
                JOptionPane.showMessageDialog(null, format);
            } else {
                format += "Niños de bajo peso entre 2 y 3 años: " + Cont1
                        +"\nNiños de bajo peso entre 4 y 6 años: "+ Cont2
                        +"\nTotal de niños bajos de peso: "+(Cont1+Cont2);
                JOptionPane.showMessageDialog(null, format);
            }
        } else {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        }
    }
    
    public void Bajos_Estatura(String municipio) {
        String format = "/////" + municipio + "/////\n";
        int Cont1 = 0;

        if (Cab != null) {
            ninio aux = Cab;

            while (aux != null) {
                if (aux.getMunicipio().equalsIgnoreCase(municipio)) {
                    if(aux.getEdad()>=4 && aux.getEdad()<=6 && aux.getTalla() < 1){
                        Cont1++;
                        format += "Registro Civil: " + aux.getRegistro_civil() + "\nNombre: " + aux.getNombre() + "\nTalla: " + aux.getTalla() + "\nPeso: " + aux.getPeso()
                                + "Edad: " + aux.getEdad() + "\nIdentificacion Padre: " + aux.getIdentificacionPadre() + "\nNombre Padre: "
                                + aux.getNombrePadre() + "\n------------------------------\n";
                    }
                }
                aux = aux.getSig();
            }

            if (Cont1 == 0) {
                format += "No hay registro de este municipio";
                JOptionPane.showMessageDialog(null, format);
            } else {
                format += "Niños de baja estatura entre 4 y 6 años: "+ Cont1;
                JOptionPane.showMessageDialog(null, format);
            }
        } else {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        }
    }
}
