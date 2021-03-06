package vista;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.GridLayout;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import java.awt.Toolkit;
import javax.swing.JRadioButton;

public class UI extends JFrame {

	protected JPanel contentPane;
	protected JTextField path;
	protected JButton buscar;
	protected JLabel resultados;
	protected JTextArea resultado;
	protected JButton limpiar;
	protected JTextArea traza;
	protected JProgressBar progreso;
	protected JScrollPane scrollListado;
	protected JScrollPane scrollRecorrido;
	protected JButton exportar;
	protected JRadioButton mp3;
	protected JRadioButton wav;
	protected JRadioButton flac;
	protected ButtonGroup formatos;
	protected JLabel tiempo;

	public UI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UI.class.getResource("/assets/icon.png")));
		setSize(new Dimension(1000, 800));
		setPreferredSize(new Dimension(800, 800));
		setTitle("BUSCAMP3");
		setMinimumSize(new Dimension(1100, 650));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("TabbedPane.light"));
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelInferior = new JPanel();
		panelInferior.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelInferior.setOpaque(false);
		contentPane.add(panelInferior, BorderLayout.SOUTH);
		panelInferior.setLayout(new BorderLayout(10, 0));
		
		JPanel panelPath = new JPanel();
		panelPath.setBorder(new MatteBorder(1, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		panelInferior.add(panelPath, BorderLayout.WEST);
		panelPath.setLayout(new BorderLayout(0, 0));
		
		JLabel lblRutaDeBsqueda = new JLabel("Ruta de b\u00FAsqueda");
		lblRutaDeBsqueda.setBorder(new EmptyBorder(5, 5, 5, 0));
		lblRutaDeBsqueda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelPath.add(lblRutaDeBsqueda, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(500, 25));
		panel.setBackground(Color.WHITE);
		panel.setBorder(null);
		panelPath.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		path = new JTextField();
		path.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.add(path);
		path.setColumns(10);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setOpaque(false);
		panelInferior.add(panelBotones, BorderLayout.EAST);
		panelBotones.setLayout(new GridLayout(0, 3, 10, 0));
		
		JPanel panelSelector = new JPanel();
		panelSelector.setBorder(new MatteBorder(1, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		panelBotones.add(panelSelector);
		
		mp3 = new JRadioButton("MP3");
		mp3.setOpaque(false);
		mp3.setActionCommand(".mp3");
		mp3.setSelected(true);
		mp3.setFocusPainted(false);
		mp3.setBorder(new EmptyBorder(0, 10, 0, 0));
		
		wav = new JRadioButton("WAV");
		wav.setOpaque(false);
		wav.setBorder(null);
		wav.setActionCommand(".wav");
		wav.setFocusPainted(false);
		
		flac = new JRadioButton("FLAC");
		flac.setOpaque(false);
		flac.setBorder(new EmptyBorder(0, 0, 0, 10));
		flac.setActionCommand(".flac");
		flac.setFocusPainted(false);
		
		panelSelector.setLayout(new GridLayout(0, 3, 5, 0));
		panelSelector.add(mp3);
		panelSelector.add(wav);
		panelSelector.add(flac);
		
		formatos = new ButtonGroup();
		formatos.add(mp3);
		formatos.add(wav);
		formatos.add(flac);
		
		buscar = new JButton("Buscar");
		panelBotones.add(buscar);
		buscar.setPreferredSize(new Dimension(105, 23));
		buscar.setForeground(Color.WHITE);
		buscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buscar.setFocusPainted(false);
		buscar.setBackground(Color.DARK_GRAY);
		buscar.setBorder(new EmptyBorder(10, 15, 10, 15));
		buscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		exportar = new JButton("Exportar b\u00FAsqueda");
		exportar.setFocusPainted(false);
		exportar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exportar.setForeground(Color.WHITE);
		exportar.setFont(new Font("Tahoma", Font.BOLD, 12));
		exportar.setBorder(new EmptyBorder(10, 15, 10, 15));
		exportar.setBackground(Color.DARK_GRAY);
		panelBotones.add(exportar);
		
		JPanel panelCentral = new JPanel();
		panelCentral.setOpaque(false);
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCantidad = new JPanel();
		panelCantidad.setBackground(Color.LIGHT_GRAY);
		panelCantidad.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelCentral.add(panelCantidad, BorderLayout.SOUTH);
		panelCantidad.setLayout(new BorderLayout(5, 0));
		
		JLabel lblResultados = new JLabel("Resultados:");
		lblResultados.setBorder(new EmptyBorder(2, 2, 2, 2));
		lblResultados.setBackground(SystemColor.inactiveCaption);
		lblResultados.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		panelCantidad.add(lblResultados, BorderLayout.WEST);
		
		resultados = new JLabel("");
		panelCantidad.add(resultados, BorderLayout.CENTER);
		
		limpiar = new JButton("Limpiar b\u00FAsqueda");
		limpiar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		limpiar.setForeground(Color.WHITE);
		limpiar.setBackground(Color.GRAY);
		limpiar.setBorder(new EmptyBorder(5, 10, 5, 10));
		limpiar.setFocusPainted(false);
		panelCantidad.add(limpiar, BorderLayout.EAST);
		
		JPanel panelBusqueda = new JPanel();
		panelCentral.add(panelBusqueda, BorderLayout.CENTER);
		panelBusqueda.setLayout(new BoxLayout(panelBusqueda, BoxLayout.X_AXIS));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBorder(null);
		splitPane.setContinuousLayout(true);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panelBusqueda.add(splitPane);
		
		JPanel panelListado = new JPanel();
		splitPane.setLeftComponent(panelListado);
		panelListado.setLayout(new BoxLayout(panelListado, BoxLayout.X_AXIS));
		
		resultado = new JTextArea();
		resultado.setEnabled(false);
		resultado.setBorder(new EmptyBorder(10, 10, 10, 10));
		resultado.setEditable(false);
		resultado.setDisabledTextColor(Color.BLACK);
		
		scrollListado = new JScrollPane(resultado);
		panelListado.add(scrollListado);
		scrollListado.setBorder(null);
		
		JLabel lblResultadosDeBsqueda = new JLabel("Resultado");
		lblResultadosDeBsqueda.setOpaque(true);
		lblResultadosDeBsqueda.setBackground(SystemColor.controlHighlight);
		lblResultadosDeBsqueda.setForeground(Color.DARK_GRAY);
		lblResultadosDeBsqueda.setFont(new Font("Arial", Font.BOLD, 12));
		lblResultadosDeBsqueda.setBorder(new EmptyBorder(5, 5, 5, 5));
		scrollListado.setColumnHeaderView(lblResultadosDeBsqueda);
		
		JPanel panelRecorrido = new JPanel();
		splitPane.setRightComponent(panelRecorrido);
		panelRecorrido.setLayout(new BoxLayout(panelRecorrido, BoxLayout.X_AXIS));
		
		traza = new JTextArea();
		traza.setEnabled(false);
		traza.setBorder(new EmptyBorder(10, 10, 10, 10));
		traza.setForeground(Color.WHITE);
		traza.setBackground(Color.DARK_GRAY);
		traza.setEditable(false);
		traza.setDisabledTextColor(Color.WHITE);
		
		scrollRecorrido = new JScrollPane(traza);
		panelRecorrido.add(scrollRecorrido);
		scrollRecorrido.setBorder(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.controlHighlight);
		scrollRecorrido.setColumnHeaderView(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_1.add(panel_2, BorderLayout.WEST);
		panel_2.setLayout(new BorderLayout(5, 0));
		
		JLabel lblTrazaDeBsqueda = new JLabel("Traza de b\u00FAsqueda");
		panel_2.add(lblTrazaDeBsqueda);
		lblTrazaDeBsqueda.setOpaque(true);
		lblTrazaDeBsqueda.setBackground(SystemColor.controlHighlight);
		lblTrazaDeBsqueda.setForeground(Color.DARK_GRAY);
		lblTrazaDeBsqueda.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTrazaDeBsqueda.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		tiempo = new JLabel("");
		tiempo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		panel_2.add(tiempo, BorderLayout.EAST);
		
		progreso = new JProgressBar();
		progreso.setPreferredSize(new Dimension(146, 20));
		progreso.setBorder(null);
		progreso.setForeground(new Color(0, 204, 102));
		panelCentral.add(progreso, BorderLayout.NORTH);
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(65, 105, 225)));
		panelSuperior.setBackground(SystemColor.activeCaption);
		contentPane.add(panelSuperior, BorderLayout.NORTH);
		panelSuperior.setLayout(new BorderLayout(0, 0));
		
		JLabel lblBuscadorDeArchivos = new JLabel("BUSCAMP3");
		lblBuscadorDeArchivos.setForeground(Color.WHITE);
		lblBuscadorDeArchivos.setHorizontalAlignment(SwingConstants.LEFT);
		lblBuscadorDeArchivos.setBorder(new EmptyBorder(10, 10, 10, 10));
		lblBuscadorDeArchivos.setFont(new Font("Tahoma", Font.BOLD, 40));
		panelSuperior.add(lblBuscadorDeArchivos, BorderLayout.WEST);
		
		JLabel lblNewLabel = new JLabel("Ahora busca m\u00E1s que antes");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBorder(new EmptyBorder(15, 0, 0, 0));
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 13));
		panelSuperior.add(lblNewLabel, BorderLayout.CENTER);
	}
	
	public boolean isPathEmpty() {
		return this.path.getText().equals("");
	}
	
	public void vaciarResultado() {
		this.resultado.setText("");
	}
	
	public void vaciarTraza() {
		this.traza.setText("");
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getPath() {
		return path;
	}

	public JButton getBuscar() {
		return buscar;
	}

	public JLabel getResultados() {
		return resultados;
	}

	public JTextArea getResultado() {
		return resultado;
	}

	public JTextArea getTraza() {
		return traza;
	}

	public JProgressBar getProgreso() {
		return progreso;
	}

	public JScrollPane getScrollListado() {
		return scrollListado;
	}

	public JScrollPane getScrollRecorrido() {
		return scrollRecorrido;
	}

	public JButton getExportar() {
		return exportar;
	}

	public ButtonGroup getFormatos() {
		return formatos;
	}

	public JLabel getTiempo() {
		return tiempo;
	}

}
