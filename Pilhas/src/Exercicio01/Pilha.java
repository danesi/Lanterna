/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio01;

/**
 *
 * @author danesi
 */
public class Pilha {
    
    private Elemento topo;
    
    public void empilhar(String info){
        if(this.topo == null){
            this.topo = new Elemento(info);
        }else{
            Elemento ele = this.topo;
            this.topo = new Elemento(info);
            this.topo.setProx(ele);
        }
    }
    
    public String desempilhar(){
        if(this.topo == null){
            return null;
        }else{
            Elemento ele = this.topo;
            this.topo = ele.getProx();
            return ele.getInfo();
        }
    }
    public String vazia(){
        if(this.topo != null){
            return "Não esta vazia";
        }else{
            return "Lista vazia";
        }
    }
}
