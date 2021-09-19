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
public class RealizarGiros extends Thread{
    private Transferencia transferencia;
    private int cuentaOrigen, cantidadMax;
    
    public RealizarGiros(Transferencia transferencia, int cuentaOrigen, int cantidadMax){
        this.transferencia=transferencia;
        this.cuentaOrigen=cuentaOrigen;
        this.cantidadMax=cantidadMax;
    }
    public void run (){
        while (true){
            try{
                int cuentaDestino=(int)(Math.random()*10);
                int cantidad= Math.round((float)(cantidadMax*Math.random()));
                transferencia.transferencia(cuentaOrigen, cuentaDestino, cantidad);
                Thread.sleep(250);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
