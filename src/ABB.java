public class ABB {
    private Nodo raiz;

    public ABB() {
        raiz = null;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void insertar(double numero) {
        raiz = insertarAux(raiz, numero);
    }

    private Nodo insertarAux(Nodo nodo, double numero) {
        if (nodo == null) {
            return new Nodo(numero);
        }
        if (numero < nodo.getNumero()) {
            nodo.setIzquierdo(insertarAux(nodo.getIzquierdo(), numero));
        } else if (numero > nodo.getNumero()) {
            nodo.setDerecho(insertarAux(nodo.getDerecho(), numero));
        }
        return nodo;
    }

    public void eliminar(double numero) {
        raiz = eliminarAux(raiz, numero);
    }

    private Nodo eliminarAux(Nodo nodo, double numero) {
        if (nodo == null) {
            return null;
        }
        if (numero < nodo.getNumero()) {
            nodo.setIzquierdo(eliminarAux(nodo.getIzquierdo(), numero));
        } else if (numero > nodo.getNumero()) {
            nodo.setDerecho(eliminarAux(nodo.getDerecho(), numero));
        } else {
            if (nodo.getIzquierdo() == null) {
                return nodo.getDerecho();
            } else if (nodo.getDerecho() == null) {
                return nodo.getIzquierdo();
            }
            Nodo sucesor = encontrarSucesor(nodo.getDerecho());
            nodo.setNumero(sucesor.getNumero());
            nodo.setDerecho(eliminarAux(nodo.getDerecho(), sucesor.getNumero()));
        }
        return nodo;
    }

    private Nodo encontrarSucesor(Nodo nodo) {
        Nodo actual = nodo;
        while (actual.getIzquierdo() != null) {
            actual = actual.getIzquierdo();
        }
        return actual;
    }

    public String buscar(double numero) {
        Nodo actual = raiz;
        while (actual != null) {
            if (numero == actual.getNumero()) {
                return "El numero se encuentra en el arbol";
            } else if (numero < actual.getNumero()) {
                actual = actual.getIzquierdo();
            } else {
                actual = actual.getDerecho();
            }
        }
        return "El numero no se encuentra en el arbol";
    }

    public String mostrarOrden(Nodo nodo) {
        String resultado = "";
        if (nodo != null) {
            resultado += mostrarOrden(nodo.getIzquierdo());
            resultado += nodo.getNumero() + "\n";
            resultado += mostrarOrden(nodo.getDerecho());
        }
        return resultado;
    }

    public String mostrarPreOrden(Nodo nodo) {
        String resultado = "";
        if (nodo != null) {
            resultado += nodo.getNumero() + "\n";
            resultado += mostrarPreOrden(nodo.getIzquierdo());
            resultado += mostrarPreOrden(nodo.getDerecho());
        }
        return resultado;
    }

    public String mostrarPosOrden(Nodo nodo) {
        String resultado = "";
        if (nodo != null) {
            resultado += mostrarPosOrden(nodo.getIzquierdo());
            resultado += mostrarPosOrden(nodo.getDerecho());
            resultado += nodo.getNumero() + "\n";
        }
        return resultado;
    }

}
