package main.java.uia.com.contabilidad;

import java.util.ArrayList;

import main.java.uia.com.contabilidad.clientes.InfoUIA;
import main.java.uia.com.contabilidad.gestor.DecoradorProveedores;
import main.java.uia.com.contabilidad.gestor.Gestor;
import main.java.uia.com.contabilidad.proveedores.Proveedor;
import main.java.uia.com.presentacion.ClienteJSP;

public class ContabilidadUIA {
		
	    public Gestor contabilidad =  null;
		public DecoradorProveedores gestorProveedores = null;		
		public ArrayList<ClienteJSP> listaProveedores = null;
		public ArrayList<ClienteJSP> listaCuentas = null;
		public ArrayList<ClienteJSP> listaCompras = null;
		public ArrayList<ClienteJSP> listaReqs = null;
		public ArrayList<ClienteJSP> listaCheques = null;
		public Proveedor proveedor = null;
		public String clienteId="";

		public ContabilidadUIA()
		{
		 contabilidad = new Gestor("/Users/vogel/eclipse-workspace/ContabilidadUIA-MVC-JSP-Examen-master/ContabilidadUIA-web-MVC-JSP/ListaProveedores.json");		
		 gestorProveedores = new DecoradorProveedores(contabilidad, "proveedor");		 
		 gestorProveedores.Print();
		 listaProveedores = gestorProveedores.getLista();
		}
		
		
		public ArrayList<ClienteJSP> getListaProveedores(String clienteName) {
			return listaProveedores;
		}

		public ArrayList<ClienteJSP> getListaProveedores() {
			return listaProveedores;
		}


		public void setListaProveedores(ArrayList<ClienteJSP> listaProveedores) {
			this.listaProveedores = listaProveedores;
		}


		public DecoradorProveedores getGestorProveedores() {
			return gestorProveedores;
		}

		public void setGestorProveedores(DecoradorProveedores gestorProveedores) {
			this.gestorProveedores = gestorProveedores;
		}


		public ClienteJSP getClienteById(String clienteId) {
			// TODO Auto-generated method stub
			return null;
		}


		public void borraCliente(String clienteId) {
			// TODO Auto-generated method stub
			
		}


		public ArrayList<ClienteJSP> getAllClientes() {
			// TODO Auto-generated method stub
			return null;
		}


		public void checkCliente(ClienteJSP cliente) {
			// TODO Auto-generated method stub
			
		}

		public ArrayList<ClienteJSP> getCompras(String clienteId) {
			this.clienteId = clienteId;
			proveedor = (Proveedor) this.gestorProveedores.busca(clienteId);
			listaCompras = proveedor.getLista();
			this.getCuentas(clienteId);
			return listaCompras;
		}

		public ArrayList<ClienteJSP> getListaCompras(String clienteId) {
			this.clienteId = clienteId;
			getCompras(this.clienteId);
			return listaCompras;
		}

		public ArrayList<ClienteJSP> getListaCompras() {
			return listaCompras;
		}
		
		public ArrayList<ClienteJSP> getCuentas(String clienteName) 
		{			
			this.listaCuentas = proveedor.getListaCuentas();
			this.getReqs(clienteId);
			return this.listaCuentas;
		}

		public ArrayList<ClienteJSP> getListaCuentas() {
			return listaCuentas;
		}
		
		public ArrayList<ClienteJSP> getReqs(String clienteId) 
		{
			this.listaReqs = proveedor.getListaReqs();
			this.getCheques(clienteId);
			return this.listaReqs;
		}
		
		public ArrayList<ClienteJSP> getListaReqs() {
			return this.listaReqs;
		}
		
		public ArrayList<ClienteJSP> getCheques(String clienteId) 
		{
			this.listaCheques = proveedor.getListaCheques();
			return this.listaCheques;
		}
		
		//Devuelve la lista a ClientesController
		public ArrayList<ClienteJSP> getListaCheques() {
			return listaCheques;
		}		
		
		
}
