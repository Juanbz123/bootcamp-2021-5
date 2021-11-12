package pom.equipo1.test;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pom.equipo1.base.TestBase;
import pom.equipo1.pages.VFHomePage;
import pom.equipo1.pages.VFpaquetesPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class testpaquetes extends TestBase {

    protected VFHomePage paginaHome = null;
    protected VFpaquetesPage paginaPaquetes = null;

    @Before
    public void init(){
        paginaHome = new VFHomePage(driver);
        paginaHome.irHomePage();
        paginaPaquetes = new VFpaquetesPage(driver);
        paginaPaquetes.irPaquetesDesdeHome();
    }

    @Test
    public void CdP03_busquedaPaquetes(){
        paginaPaquetes.seleccionarVuelo1Alojamiento();
        paginaPaquetes.llenarCasillaOrigen("santiago","Santiago de Chile");
        paginaPaquetes.llenarCasillaDestino("san pedro","San Pedro de Atacama");
        paginaPaquetes.seleccionarFechas(1,2);
        paginaPaquetes.seleccionarCantidadPasajeros(2);
        paginaPaquetes.darClickBuscar();
        int lista = paginaPaquetes.resultadosBusqueda();
        assertTrue(lista>1);
    }

    @Test
    public void CdP02_busquedaPaquetes(){
        paginaPaquetes.llenarCasillaOrigen("santiago","Santiago de Chile");
        paginaPaquetes.llenarCasillaDestino("buenos aires","Ciudad de Buenos Aires");
        paginaPaquetes.seleccionarFechas(1,2);
        paginaPaquetes.darClickBuscar();
        paginaPaquetes.resultadosBusqueda();

    }
}
