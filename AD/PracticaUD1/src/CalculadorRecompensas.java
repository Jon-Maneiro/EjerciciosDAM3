import java.util.ArrayList;

public class CalculadorRecompensas {

    private ListaRecompensas recompensasL = new ListaRecompensas(true);

    private ListaRecompensas recompensas = new ListaRecompensas(false);

    private int crMaximoEncuentro;

    private enum rangos {
        ENTRE_0_Y_4,
        ENTRE_5_Y_10,
        ENTRE_11_Y_16,
        SUPERIOR_A_17
    }

    /**
     * Rangos y posibilidades de objetos:
     * <p>
     * 0-4 - (150-1.000 gp(gold pieces)) 2-4 objetos comunes
     * 5-10 - (2.000-7.000gp) 6 objetos comunes || 2-4 objetos poco comunes || 1-2 objetos raros
     * 11-16 - (20.000-50.000gp) 8 uncommon || 4-6 rare || 3-4 very rare || 1-3 legendary
     * +17 - (100.000-500.000gp) 8 rare || 4-6 very rare|| 3-4 legendary || 1 artifact
     * <p>
     * no tengo explicacion para esto, son unos rangos genericos que hay en el Dungeon Masters Guide, modificados un poco
     * con info que he buscado
     */

    public CalculadorRecompensas(int crMaximoEncuentro) {
        this.crMaximoEncuentro = crMaximoEncuentro;
    }

    public ListaRecompensas calc() {
        hacerCalculosDeRecompensas();
        return recompensas;
    }

    private void hacerCalculosDeRecompensas() {
        //Esto va a ser un siwtch rarete

        switch ((0 <= crMaximoEncuentro && crMaximoEncuentro <= 4) ? rangos.ENTRE_0_Y_4 :
                (5 <= crMaximoEncuentro && crMaximoEncuentro <= 10) ? rangos.ENTRE_5_Y_10 :
                (11 <= crMaximoEncuentro && crMaximoEncuentro <= 16) ? rangos.ENTRE_11_Y_16 : rangos.SUPERIOR_A_17) {
            case ENTRE_0_Y_4:

                break;

            case ENTRE_5_Y_10:

                break;

            case ENTRE_11_Y_16:

                break;

            case SUPERIOR_A_17:

                break;
        }


    }

    private Recompensa objetoAleatorio(int rareza) {
        ArrayList<Recompensa> recompensasPorRareza = recompensasL.filtrarRareza(rareza);

        Recompensa objetoElegido = recompensasPorRareza.get((int) Math.floor(Math.random() * recompensasPorRareza.size() - 1));

        return objetoElegido;

    }

}
