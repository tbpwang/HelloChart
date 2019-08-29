import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zheng WANG
 * @create 2019/8/29
 * @description
 */

public class HelloChart extends ApplicationFrame {

    /**
     * Constructs a new application frame.
     *
     * @param title the frame title.
     */
    public HelloChart(String title) {
        super(title);
        JPanel pieChartPanel = createPane("My PieChart");
        pieChartPanel.setPreferredSize(new Dimension(500,300));
        setContentPane(pieChartPanel);
    }
    private static PieDataset createPieDataset()
    {
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        // Map(Key,Value)
        // 存放名称(Key)
        List<String> pieName = new ArrayList<>();
        pieName.add("One");
        pieName.add("Two");
        pieName.add("Three");
        pieName.add("Four");
        pieName.add("Five");
        // 存放数据(Value)
        List<Double> pieValue = new ArrayList<>();
        pieValue.add(30.0);
        pieValue.add(40.0);
        pieValue.add(80.0);
        pieValue.add(10.0);
        pieValue.add(100.0);
        for (int i = 0; i < 5; i++) {
            pieDataset.setValue(pieName.get(i),pieValue.get(i));
        }
        return pieDataset;
    }

//    private static JFreeChart createChart(PieDataset pieDataset,String pieName)
//    {
//        JFreeChart pieChart = ChartFactory.createPieChart(pieName,createPieDataset());
//    }
    static JPanel createPane(String name)
    {
        JFreeChart freeChart = ChartFactory.createPieChart(name,createPieDataset());
        return new ChartPanel(freeChart);
    }

    public static void main(String[] args) {
        String pieName = "TestPieName";
        HelloChart pieChart = new HelloChart(pieName);
        pieChart.pack();
        pieChart.setVisible(true);
    }
}
