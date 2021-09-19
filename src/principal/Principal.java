/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

/**
 *
 * @author caballo
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Transferencia transferencia=new Transferencia();
        for (int i=0;i<10;i++){
            int cuentaOrigen=1;
            RealizarGiros giro=new RealizarGiros(transferencia, cuentaOrigen,100000);
            giro.start();
        }
    }
    
}
