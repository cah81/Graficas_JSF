package graficoJSFprueba;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

@ManagedBean
@ViewScoped
public class GraficoBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pastelChartImage;
	private String pastelChartImage2;
   

  

	public void setPastelChartImage2(String pastelChartImage2) {
		this.pastelChartImage2 = pastelChartImage2;
	}

	@PostConstruct
    public void init() {
        crearGraficoPastel();
        List<String> etiquetas = Arrays.asList("otro1", "otro2", "Ws otro3", "otroa", "Otroa2");
        List<Double> valores =Arrays.asList(39.2, 22.9, 15.5, 18.3, 12.3);
       // crearGraficoPastel2(etiquetas,valores);
       
        
    }

    public String getPastelChartImage() {
        return pastelChartImage;
    }
    public String getPastelChartImage2() {
  		return pastelChartImage2;
  	}

   

    private void crearGraficoPastel() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        /*dataset.setValue("Android", 39.2);
	    dataset.setValue("iOs", 22.9);
	    dataset.setValue("Windows Mobile", 15.5);
	    dataset.setValue("Symbian", 18.3);
	    dataset.setValue("Otros", 12.3);*/
    	List<String> etiquetas = Arrays.asList("otro1", "otro2", "Ws otro3", "otroa", "Otroa2");
    	List<Double> valores =Arrays.asList(39.2, 22.9, 15.5, 18.3, 12.3);
    	
    	for(int i=0;i<etiquetas.size();i++) {
    		dataset.setValue(etiquetas.get(i), valores.get(i));
    	}
    	
    	
	    
	    
	    

        JFreeChart chart = ChartFactory.createPieChart3D("Grafica pastel", dataset, true, true, false);
       
        // Ruta donde se guardará la imagen
        //String rutaImagen = "D:\\desarrollos\\workspace-java\\graficoJSFprueba\\src\\main\\webapp\\imagenes\\grafica_pastel.png";
        String rutaImagen = "/imagenes/grafica_pastel.png";
        // Guardar la gráfica como imagen PNG
        try {
            ChartUtilities.saveChartAsPNG(new File(rutaImagen), chart, 400, 300);
            System.out.println("Imagen guardada con éxito en: " + rutaImagen);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
		 ChartFrame frame = new ChartFrame("Graficador", chart);
			    
			    frame.pack();
			    frame.setVisible(true);
    }
    
    private void crearGraficoPastel2(List<String>etiquetas, List<Double> valores) {
    	
    	
    	
    	
    	DefaultPieDataset dataset= new DefaultPieDataset();
    	if(etiquetas.size()!=valores.size()) {
    		throw new IllegalArgumentException("la cantidad de etiquetas no corresponde a la cantida de datos");
    	}
    	for(int i=0;i<etiquetas.size();i++) {
    		dataset.setValue(etiquetas.get(i), valores.get(i));
    	}
    	
    	JFreeChart chart = ChartFactory.createPieChart3D("Grafica pastel", dataset, true, true, false);
    	// Ruta donde se guardará la imagen
    	 String rutaImagen = "/imagenes/grafica_paste2.png";
     // Guardar la gráfica como imagen PNG
    	try {
            ChartUtilities.saveChartAsPNG(new File(rutaImagen), chart, 400, 300);
            System.out.println("Imagen guardada con éxito en: " + rutaImagen);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
		 ChartFrame frame = new ChartFrame("Graficador2", chart);
			    
			    frame.pack();
			    frame.setVisible(true);
    }
    
    
    
    
    

}
