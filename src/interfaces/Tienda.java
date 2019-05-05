package interfaces;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import componentes.Botones;
import componentes.LabelTexto;
import componentes.PanelTexto;
import componentes.Paneles;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Font;


public class Tienda extends Paneles{
	private Ventana ventana;
	
	public Tienda(Ventana v) {
		super();
		this.ventana=v;
		
		//Sonido
		String rutaSonido = "./sonidos/Comprar.wav";
		
		PanelTexto panelPrecioObjeto = new PanelTexto();
		panelPrecioObjeto.setText("Precio");
		panelPrecioObjeto.setBounds(300, 96, 54, 23);
		add(panelPrecioObjeto);
		
		PanelTexto panelComprar = new PanelTexto();
		panelComprar.setText("Comprar");
		panelComprar.setBounds(176, 96, 76, 23);
		add(panelComprar);
		
		PanelTexto panelCantidad = new PanelTexto();
		panelCantidad.setText("Cantidad");
		panelCantidad.setBounds(55, 96, 76, 23);
		add(panelCantidad);
		
		PanelTexto cantidadBombaP = new PanelTexto();
		cantidadBombaP.setText(Integer.toString(ventana.heroe.getObjetosArray().get(0).getCantidad()));
		cantidadBombaP.setBounds(81, 130, 41, 25);
		add(cantidadBombaP);
		
		PanelTexto cantidadBombaG = new PanelTexto();
		cantidadBombaG.setText(Integer.toString(ventana.heroe.getObjetosArray().get(1).getCantidad()));
		cantidadBombaG.setBounds(81, 160, 41, 23);
		add(cantidadBombaG);
		
		PanelTexto cantidadPocion = new PanelTexto();
		cantidadPocion.setText(Integer.toString(ventana.heroe.getObjetosArray().get(2).getCantidad()));
		cantidadPocion.setBounds(81, 190, 41, 23);
		add(cantidadPocion);
		
		PanelTexto precioBombaP = new PanelTexto();
		precioBombaP.setText(Integer.toString(ventana.heroe.getObjetosArray().get(0).getPrecio()));
		precioBombaP.setBounds(312, 130, 41, 23);
		add(precioBombaP);
		
		PanelTexto precioBombaG = new PanelTexto();
		precioBombaG.setText(Integer.toString(ventana.heroe.getObjetosArray().get(1).getPrecio()));
		precioBombaG.setBounds(312, 160, 41, 23);
		add(precioBombaG);
		
		PanelTexto precioPocion = new PanelTexto();
		precioPocion.setText(Integer.toString(ventana.heroe.getObjetosArray().get(2).getPrecio()));
		precioPocion.setBounds(312, 190, 41, 23);
		add(precioPocion);
		
		PanelTexto panelAtributosActual = new PanelTexto();
		panelAtributosActual.setText("Actual");
		panelAtributosActual.setBounds(65, 255, 59, 23);
		add(panelAtributosActual);
		
		PanelTexto panelMejorar = new PanelTexto();
		panelMejorar.setText("Mejorar");
		panelMejorar.setBounds(176, 255, 109, 23);
		add(panelMejorar);
		
		PanelTexto panelPrecioAtributo = new PanelTexto();
		panelPrecioAtributo.setText("Precio");
		panelPrecioAtributo.setBounds(300, 255, 54, 23);
		add(panelPrecioAtributo);
		
		PanelTexto precioSalud = new PanelTexto();
		precioSalud.setText("750");
		precioSalud.setBounds(312, 290, 33, 23);
		add(precioSalud);
		
		PanelTexto precioFuerza = new PanelTexto();
		precioFuerza.setText("1000");
		precioFuerza.setBounds(309, 322, 41, 23);
		add(precioFuerza);
		
		PanelTexto precioMagia = new PanelTexto();
		precioMagia.setText("1500");
		precioMagia.setBounds(309, 354, 41, 23);
		add(precioMagia);
		
		PanelTexto precioDefensa = new PanelTexto();
		precioDefensa.setText("1000");
		precioDefensa.setBounds(309, 386, 41, 23);
		add(precioDefensa);
		
		PanelTexto precioAgilidad = new PanelTexto();
		precioAgilidad.setText("1000");
		precioAgilidad.setBounds(309, 417, 41, 23);
		add(precioAgilidad);
		
		PanelTexto saludActual = new PanelTexto();
		saludActual.setText(Integer.toString(ventana.heroe.getSaludMaxima()));
		saludActual.setBounds(81, 290, 41, 23);
		add(saludActual);
		
		PanelTexto fuerzaActual = new PanelTexto();
		fuerzaActual.setText(Integer.toString(ventana.heroe.getFuerza()));
		fuerzaActual.setBounds(81, 322, 41, 23);
		add(fuerzaActual);
		
		PanelTexto magiaActual = new PanelTexto();
		magiaActual.setText(Integer.toString(ventana.heroe.getMagia()));
		magiaActual.setBounds(81, 354, 41, 23);
		add(magiaActual);
		
		PanelTexto defensaActual = new PanelTexto();
		defensaActual.setText(Integer.toString(ventana.heroe.getDefensa()));
		defensaActual.setBounds(81, 386, 41, 23);
		add(defensaActual);
		
		PanelTexto agilidadActual = new PanelTexto();
		agilidadActual.setText(Integer.toString(ventana.heroe.getAgilidad()));
		agilidadActual.setBounds(81, 417, 41, 23);
		add(agilidadActual);
		
		//Añadiendo botones
		//Eventos de botones
		Botones comprarBombaP = new Botones("Bomba Pequeña");
		comprarBombaP.setBounds(131, 130, 159, 25);
		add(comprarBombaP);
		
		Botones comprarBombaG = new Botones("Bomba Grande");
		comprarBombaG.setBounds(131, 160, 159, 25);
		add(comprarBombaG);
		
		Botones comprarPocion = new Botones("Pocion");
		comprarPocion.setBounds(131, 190, 159, 25);
		add(comprarPocion);
		
		Botones mejorarSalud = new Botones("Salud maxima +20");
		mejorarSalud.setBounds(131, 290, 159, 25);
		add(mejorarSalud);
		
		Botones mejorarFuerza = new Botones("Fuerza +5");
		mejorarFuerza.setBounds(131, 322, 159, 25);
		add(mejorarFuerza);
		
		Botones mejorarMagia = new Botones("Magia +1");
		mejorarMagia.setBounds(131, 354, 159, 25);
		add(mejorarMagia);
		
		Botones mejorarAgilidad = new Botones("Agilidad +2");
		mejorarAgilidad.setBounds(131, 417, 159, 25);
		add(mejorarAgilidad);
		
		Botones mejorarDefensa = new Botones("Defensa +2");
		mejorarDefensa.setBounds(131, 386, 159, 25);
		add(mejorarDefensa);
		
		
		Botones botonAtras = new Botones("Volver al mapa");
		botonAtras.setBounds(709, 428, 215, 23);
		add(botonAtras);
		
		LabelTexto mostrarDinero = new LabelTexto();
		mostrarDinero.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		mostrarDinero.setBackground(new Color(204, 204, 204));
		mostrarDinero.setText("<html><center><b>Oro:&ensp;"+Integer.toString(ventana.heroe.getDinero())
				+"</b></center></html>");
		mostrarDinero.setBounds(10, 29, 109, 40);
		add(mostrarDinero);
			
		//Eventos de botones
		comprarBombaP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.heroe.comprarObjetos(0, rutaSonido);
				mostrarDinero.setText(" Oro: "+Integer.toString(ventana.heroe.getDinero()));
				cantidadBombaP.setText(Integer.toString(ventana.heroe.getObjetosArray().get(0).getCantidad()));	
			}
		});

		comprarBombaG.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				ventana.heroe.comprarObjetos(1, rutaSonido);
				mostrarDinero.setText(" Oro: "+Integer.toString(ventana.heroe.getDinero()));
				cantidadBombaG.setText(Integer.toString(ventana.heroe.getObjetosArray().get(1).getCantidad()));					
			}
		});
		
		comprarPocion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.heroe.comprarObjetos(2, rutaSonido);
				mostrarDinero.setText(" Oro: "+Integer.toString(ventana.heroe.getDinero()));
				cantidadPocion.setText(Integer.toString(ventana.heroe.getObjetosArray().get(2).getCantidad()));	
			}
		});
		
		mejorarSalud.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.heroe.mejorarEstadisticas(0, rutaSonido);
				mostrarDinero.setText(" Oro: "+Integer.toString(ventana.heroe.getDinero()));
				saludActual.setText(Integer.toString(ventana.heroe.getSaludMaxima()));
			}
		});
		
		mejorarFuerza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.heroe.mejorarEstadisticas(1, rutaSonido);
				mostrarDinero.setText(" Oro: "+Integer.toString(ventana.heroe.getDinero()));
				fuerzaActual.setText(Integer.toString(ventana.heroe.getFuerza()));
			}
		});
		
		mejorarMagia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.heroe.mejorarEstadisticas(2, rutaSonido);
				mostrarDinero.setText(" Oro: "+Integer.toString(ventana.heroe.getDinero()));
				magiaActual.setText(Integer.toString(ventana.heroe.getMagia()));
			}
		});
		
		mejorarDefensa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.heroe.mejorarEstadisticas(3, rutaSonido);
				mostrarDinero.setText(" Oro: "+Integer.toString(ventana.heroe.getDinero()));
				defensaActual.setText(Integer.toString(ventana.heroe.getDefensa()));
			}
		});
		
		mejorarAgilidad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.heroe.mejorarEstadisticas(4, rutaSonido);
				mostrarDinero.setText(" Oro: "+Integer.toString(ventana.heroe.getDinero()));
				agilidadActual.setText(Integer.toString(ventana.heroe.getAgilidad()));
				defensaActual.setText(Integer.toString(ventana.heroe.getDefensa()));
			}
		});
		
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.volverPantallaPrincipal("Tienda");
			}
		});
		
		JLabel cuadro1 = new JLabel("");
		cuadro1.setBackground(new Color(204, 204, 204));
		cuadro1.setOpaque(true);
		cuadro1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		cuadro1.setBounds(51, 86, 327, 145);
		add(cuadro1);
	
		JLabel cuadro2 = new JLabel("");
		cuadro2.setBackground(new Color(204, 204, 204));
		cuadro2.setOpaque(true);
		cuadro2.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		cuadro2.setBounds(51, 242, 327, 221);
		add(cuadro2);		
		
		//Imagen de fondo
		JLabel imagenTienda = new JLabel("");
		imagenTienda.setBounds(0, 0, 1008, 536);
		imagenTienda.setIcon(new ImageIcon("./imagenes/tienda.jpg"));
		add(imagenTienda);
	}
}	