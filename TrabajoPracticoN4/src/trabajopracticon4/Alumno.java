package trabajopracticon4;

import java.util.HashSet;
public class Alumno {
   private int legajo;
    private String apellido;
    private String nombre;
    private HashSet<Materia> materias;

    public Alumno(int legajo, String apellido, String nombre, HashSet<Materia> materias) {
        this.legajo = legajo;
        this.apellido = apellido;
        this.nombre = nombre;
        // Si mandan null desde la vista, inicializamos un HashSet vacío para evitar NullPointerException
        this.materias = (materias != null) ? materias : new HashSet<>();
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public HashSet<Materia> getMaterias() {
        if (this.materias == null) {
            this.materias = new HashSet<>();
        }
        return materias;
    }

    public void setMaterias(HashSet<Materia> materias) {
        this.materias = materias;
    }
    
    // Método en singular para la vista
    public void agregarMateria(Materia m) {
        if (this.materias == null) {
            this.materias = new HashSet<>();
        }
        boolean yaAgregada = materias.add(m);
        if (!yaAgregada) {
            System.out.println("El alumno ya esta en la materia");
        }
    }

    public void agregarMaterias(Materia m) {
        agregarMateria(m);
    }

    public int cantidadMaterias() {
        if (this.materias == null) {
            return 0;
        }
        return materias.size();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.legajo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alumno other = (Alumno) obj;
        return this.legajo == other.legajo;
    }

    // Crucial para que el JComboBox muestre el texto correcto
    @Override
    public String toString() {
        return apellido + ", " + nombre + " (Legajo: " + legajo + ")";
    }
}
