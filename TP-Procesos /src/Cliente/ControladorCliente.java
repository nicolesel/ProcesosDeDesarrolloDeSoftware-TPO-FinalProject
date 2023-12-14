
package Cliente;

import java.util.ArrayList;
import java.util.List;

import Cliente.LogIn.LogIn;
import Cliente.LogIn.LogInAdapter;

public class ControladorCliente {
	
	private List<Cliente> clientes;
	private LogInAdapter login;
	
	
	public ControladorCliente() {
		clientes = new ArrayList<Cliente>();	
		this.login= new LogIn(this);
	}
	
	public int crearCliente(String nombre, String apellido, int dni, int telefono, String email, String usuario, String contraseña, String estrategia) {
		Cliente c = new Cliente(nombre, apellido, dni, telefono, email, usuario, contraseña, estrategia);
		clientes.add(c);	
		return c.getId();			
	}
	
	public Cliente loguear(String usuario, String contraseña) {
		
		return login.loguear(usuario, contraseña);
	}

	public Cliente buscarCliente(int idCliente) {
		for (Cliente cliente: clientes) {
			if (idCliente == cliente.getId())
				return cliente;
		}
		return null;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	

}
