package forms;

import entities.GPSTracker;
import entities.Position;
import entities.Vehicule;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JInternalFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import service.GPSTrackerService;
import service.PositionService;
import service.VehiculeGPSTrackerService;
import service.VehiculeService;

public class Chart extends JInternalFrame {

    PositionService ps;
    GPSTrackerService ts;
    VehiculeService vs;
    VehiculeGPSTrackerService vgs;
    private static final long serialVersionUID = 1L;

    public Chart(GPSTracker t) {
        ps = new PositionService();
        ts = new GPSTrackerService();
        vs = new VehiculeService();
        // Create Dataset  
        CategoryDataset dataset = createDataset(t);

        //Create chart  
        JFreeChart chart = ChartFactory.createBarChart(
                "Nombre de position annuelle du tracker " + t.getSimNulmber(), //Chart Title  
                "année", // Category axis  
                "NB de positions", // Value axis  
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false
        );

        ChartPanel panel = new ChartPanel(chart);
        panel.setPreferredSize(new java.awt.Dimension(560, 367));
        setContentPane(panel);
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        pack();
    }

    public Chart(Vehicule v) {
        ps = new PositionService();
        ts = new GPSTrackerService();
        vs = new VehiculeService();
        // Create Dataset  
        CategoryDataset dataset = createDataset(v);

        //Create chart  
        JFreeChart chart = ChartFactory.createBarChart(
                "Nombre de position annuelle du Vehicule " + v.getMatricule(), //Chart Title  
                "année", // Category axis  
                "NB de positions", // Value axis  
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false
        );

        ChartPanel panel = new ChartPanel(chart);
        panel.setPreferredSize(new java.awt.Dimension(560, 367));
        setContentPane(panel);
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        pack();
    }

    private CategoryDataset createDataset(GPSTracker t) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        //   Date seek1 = (new GregorianCalendar(2020, 1, 1, 0, 0)).getTime();
        //      dataset.addValue(ps.findGpsBetweenDates(t, seek1, new Date()).size(), "Positions renvoyer","2021");

        Date date = new GregorianCalendar().getTime();
        for (Position p : ps.findAll()) {
            if (p.getDate().before(date)) {
                date = p.getDate();
                System.out.println(date);
            }
        }

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        System.out.println(calendar.get(Calendar.YEAR));
        calendar.setTime(new Date());

        for (int i = year; i <= ((calendar.get(Calendar.YEAR)) + 1); i++) {
            Date seek1 = (new GregorianCalendar(i, 1, 1, 0, 0)).getTime();
            Date seek2 = (new GregorianCalendar(i + 1, 1, 1, 0, 0)).getTime();

            dataset.addValue(ps.findGpsBetweenDates(t, seek1, seek2).size(), "Positions renvoyer", Integer.toString(i));

        }
        return dataset;
    }

    private CategoryDataset createDataset(Vehicule t) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        //dataset.addValue(10, "Positions renvoyer", "1910");
        ps = new PositionService();
        ts = new GPSTrackerService();
        vs = new VehiculeService();
        vgs = new VehiculeGPSTrackerService();

 Date date = new GregorianCalendar().getTime();
        for (Position p : ps.findAll()) {
            if (p.getDate().before(date)) {
                date = p.getDate();
                System.out.println(date);
            }
        }

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        System.out.println(calendar.get(Calendar.YEAR));
        calendar.setTime(new Date());

        for (int i = year; i <= ((calendar.get(Calendar.YEAR)) + 1); i++) {
            Date seek1 = (new GregorianCalendar(i, 1, 1, 0, 0)).getTime();
            Date seek2 = (new GregorianCalendar(i + 1, 1, 1, 0, 0)).getTime();

            dataset.addValue(vgs.findVehiculeBetweenDates(t, seek1, seek2).size(), "Positions renvoyer", Integer.toString(i));

        }
        return dataset;
    }
}
