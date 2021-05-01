package entidades;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class DirectorioTelefonico {

    private TreeMap<Long,Cliente> lista = new TreeMap<>();
    
    public Cliente agregarCliente(Long numero, Cliente cliente) {
       
        if (lista.containsKey(numero)){
           return null;
        }
        lista.put(numero,cliente);
               return cliente;             
        }

    public Cliente buscarCliente(Long tel) {
        Set<Long> cliente = lista.keySet();
        long x=0;
        for(Long i: cliente){
            if(lista.get(i).equals(lista.get(tel))){
                x=i;
            }
        }
        return lista.get(x);
    }

    public Set<Long> buscarTelefono(String apellido) {
       Set<Long> aux = new HashSet<>();
        for(Long tele:lista.keySet()){
            if(lista.get(tele).getApellido().equals(apellido))aux.add(tele);
        }
        return aux;
    }
    public Set<Cliente> buscarClientes(String ciudad) {
       
       Set<Cliente> aux = new HashSet<>();
        
        for(Long tel:lista.keySet()){
            Cliente auxCliente = lista.get(tel);
            if(auxCliente.getCiudad().equals(ciudad))aux.add(auxCliente);
        }
        return aux;
    }

    public TreeMap<Long, Cliente> borrarCliente(long dni) {
       TreeMap<Long, Cliente> clienteBorrado = new TreeMap<>();
       Set<Long> aux = lista.keySet();
       Long[] arreglo = new Long[aux.size()];
       aux.toArray(arreglo);
       long tele = 0;
       Cliente cliente = null;
       for(int i=0; i<arreglo.length;i++){
           Long tel= arreglo[i];
           if(lista.get(tel).getDni()==dni){
               tele+=tel;
               cliente=lista.get(tel);
               lista.remove(tel);
           }
       }
       clienteBorrado.put(tele,cliente);
       return clienteBorrado;
    }
               
        //con boolean
        /*for(Long tel:lista.keySet()){
            Cliente auxClient = lista.get(tel);
            if(auxClient.getDni() == dni){
                lista.remove(tel);
                return true;
            }
        }
        return false;
        }*/
}

