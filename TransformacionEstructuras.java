
public class Main {
    public static void main(String[] args) {
        // Paso 1: Crear una cola dinámica
        ColaDinamica colaDinamica = new ColaDinamica();
        colaDinamica.inicializar();

        // Acolar elementos
        colaDinamica.acolar(10);
        colaDinamica.acolar(20);
        colaDinamica.acolar(30);
        colaDinamica.acolar(40);

        System.out.println("Cola: 10 → 20 → 30 → 40");
        System.out.println("Primero (frente): " + colaDinamica.primero());
        System.out.println("Desacolo 10, nuevo frente: " + colaDinamica.primero());
        colaDinamica.desacolar();
        System.out.println("Desacolo 20, nuevo frente: " + colaDinamica.primero());
        colaDinamica.desacolar();
        System.out.println("Cola actual: 30 → 40\n");

        // Paso 2: TRANSFORMAR a Pila Dinámica
        // Vaciamos la cola en una pila (invierte el orden)
        PilaDinamica pilaDinamica = new PilaDinamica();
        pilaDinamica.inicializar();

        while (!colaDinamica.estaVacia()) {
            int valor = colaDinamica.primero();
            colaDinamica.desacolar();
            pilaDinamica.apilar(valor);
            System.out.println("  Desacolo de cola: " + valor + " → Apilo en pila");
        }

        System.out.println("Pila: 40 (tope) ← 30");
        System.out.println("Tope de pila: " + pilaDinamica.tope());
        System.out.println("Desapilo: " + pilaDinamica.tope());
        pilaDinamica.desapilar();
        System.out.println("Nuevo tope: " + pilaDinamica.tope());
        pilaDinamica.desapilar();
        System.out.println("Pila vacía: " + pilaDinamica.estaVacia() + "\n");

        // Paso 3: TRANSFORMAR a Pila Estática
        PilaEstatica pilaEstatica = new PilaEstatica(100);
        pilaEstatica.inicializar();

        // Rehacemos la pila dinámica para la demo
        PilaDinamica pilaDinamica2 = new PilaDinamica();
        pilaDinamica2.inicializar();
        pilaDinamica2.apilar(5);
        pilaDinamica2.apilar(15);
        pilaDinamica2.apilar(25);

        while (!pilaDinamica2.estaVacia()) {
            int valor = pilaDinamica2.tope();
            pilaDinamica2.desapilar();
            pilaEstatica.apilar(valor);
            System.out.println("Desapilo de pila dinámica: " + valor + " → Apilo en pila estática");
        }

        System.out.println("Pila estática (array): [25, 15, 5]");
        System.out.println("Tope de pila estática: " + pilaEstatica.tope());
        System.out.println("Desapilo: " + pilaEstatica.tope());
        pilaEstatica.desapilar();
        System.out.println("Nuevo tope: " + pilaEstatica.tope());
        pilaEstatica.desapilar();
        System.out.println("Pila vacía: " + pilaEstatica.estaVacia() + "\n");

        // Paso 4: TRANSFORMAR a Cola Estática
        ColaEstatica colaEstatica = new ColaEstatica(100);
        colaEstatica.inicializar();

        // Rehacemos la cola para la estatica
        System.out.println("Creando nueva cola y copiándola a cola estática:");
        colaEstatica.acolar(10);
        colaEstatica.acolar(20);
        colaEstatica.acolar(30);
        colaEstatica.acolar(40);

        System.out.println("Primero (frente): " + colaEstatica.primero());
        System.out.println("Desacolo: " + colaEstatica.primero());
        colaEstatica.desacolar();
        System.out.println("Nuevo frente: " + colaEstatica.primero());
        colaEstatica.desacolar();
        System.out.println("Cola actual: [300, 400]");
        System.out.println("Cola vacía: " + colaEstatica.estaVacia());

    }
}



