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
public class Transferencia {
    int cuentaUnillanosIncentivos= 1000000;
    private int sincr=0, desincr=0, estudiantes=10;
    private final int [] cuentas;
    public Transferencia(){
        cuentas=new int [estudiantes];
        for (int i=0;i<cuentas.length;i++){
            cuentas[i]= cuentaUnillanosIncentivos/estudiantes;
        }
    }
    public synchronized void transferencia(int cuentaOrigen, int cuentaDestino, int cantidad) throws InterruptedException{
        while(cuentas[cuentaOrigen]<cantidad){
            //return;
            wait();
        }
        cuentas[cuentaOrigen]-=cantidad;
        System.out.printf("giro del estudiante # %d para el estudiante # %d por una cantidad de: %d pesos\n" ,(cuentaOrigen+1),(cuentaDestino+1),cantidad );
        cuentas[cuentaDestino]+=cantidad;
        System.out.printf("saldo total: %d\n", getSaldoTotal());
        if(getSaldoTotal()==cuentaUnillanosIncentivos){
            sincr++;
        }else {
            desincr++;
        }
        System.out.println("giros sincrinizados: "+sincr+" \nGiros Desincronizados: "+desincr);
        notifyAll();
    }

    private int getSaldoTotal() {
        int saldo_total=0;
        for(int a: cuentas){
            saldo_total+=a;
        }
        return saldo_total;
    }
}
