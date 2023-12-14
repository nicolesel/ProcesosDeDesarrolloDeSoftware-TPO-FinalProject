package Cliente.LogIn;

import Cliente.Cliente;
import Cliente.ControladorCliente;

public class LogIn implements LogInAdapter {
	
	private ControladorCliente cl;
	
	public LogIn(ControladorCliente cl) {
		this.cl= cl;
	}

	@Override
	public Cliente loguear(String usuario, String contraseña) { 
		for(Cliente c:cl.getClientes()) {
			if(c.getUsuario()==usuario && c.getContraseña() == contraseña) {
				return c;
			}
		}
		return cl.buscarCliente(0);
	}

}
