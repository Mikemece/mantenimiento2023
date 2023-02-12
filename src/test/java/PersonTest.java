import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
public class PersonTest {
    Person p,m,mal,p2,p3,m2,m3;
    List<Person> lista;
    @BeforeEach
    void setup(){
        p=new Person("Prueba", 1,"male");
        m=new Person("Prueba", 10,"female");
        mal = new Person("mal", 1, "otro");
        p2 = new Person("Prueba", 2,"male");
        p3 = new Person("Prueba", 3,"male");
        m2 = new Person("Prueba", 50,"female");
        m3 = new Person("Prueba", 13,"female");
        lista= new ArrayList<>();
    }

    @AfterEach
    void shutdown(){
        p=null;
        m=null;
        mal=null;
        lista=null;
        p2=null;
        p3=null;
        m2=null;
        m3=null;
    }

    /**
     * CASOS DE PRUEBA:
     * 1. Dar error si la lista esta vacia
     * 2. Comprobar que si la lista solo tiene un hombre muestra su edad (media de 1 es su valor)
     * 3. Comprobar que si la lista solo tiene una mujer muestra su edad (media de 1 es su valor)
     * 4. Comprobar que si la lista tiene 1 hombre y 1 mujer salen sus edades
     * 5. Si detecta un genero que no es "male" o "female" dar error
     * 6. Hacer la prueba con 3 hombres y 3 mujeres
     */

    @Test
    void listaVaciaError(){
        assertThrows(RuntimeException.class, ()->p.averageAgePerGender(lista));
    }

    @Test
    void unHombreDaSuEdad(){
        lista.add(p);
        double valorObtenido = p.averageAgePerGender(lista)[0];
        int valorEsperado = p.age();
        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    void unaMujerDaSuEdad(){
        lista.add(m);
        double valorObtenido = p.averageAgePerGender(lista)[1];
        int valorEsperado = m.age();
        assertEquals(valorEsperado,valorObtenido);
    }

    @Test
    void unHombreYMujerDanEdadBien(){
        lista.add(p);
        lista.add(m);
        double[] valoresObtenido = p.averageAgePerGender(lista);
        double[] valoresEsperado = {p.age(), m.age()};
        assertArrayEquals(valoresEsperado,valoresObtenido);
    }

    @Test
    void errorGenero(){
        lista.add(mal);
        assertThrows(RuntimeException.class, ()->p.averageAgePerGender(lista));
    }

    @Test
    void tresHombresYMujeres(){
        lista.add(p);
        lista.add(p2);
        lista.add(p3);
        lista.add(m);
        lista.add(m2);
        lista.add(m3);
        double[] valoresObtenido = p.averageAgePerGender(lista);
        double[] valoresEsperado = {2,24.333333333333332};
        assertArrayEquals(valoresEsperado,valoresObtenido);
    }
}
