package main.java.functions;

import main.java.activities.Activity;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Integer> numberOfVehiclesSold;
    private List<Double> dailyFNCDAmount;
    private List<Double> dailyStaffAmount;
    public Graph() {
        numberOfVehiclesSold = new ArrayList<>();
        dailyFNCDAmount = new ArrayList<>();
        dailyStaffAmount = new ArrayList<>();
    }

    public void plotGraphs(Activity activity) throws IOException {
        plotVehiclesSold(activity);
        plotFNCDAmount(activity);
        plotStaffAmount(activity);
    }

    private void plotStaffAmount(Activity activity) throws IOException {
        DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
        line_chart_dataset.addValue(dailyStaffAmount.get(0), "daily Staff Amount", Integer.toString(1));

        for(int i=2; i<=31; i++) {
            line_chart_dataset.addValue(dailyStaffAmount.get(i-1) - dailyStaffAmount.get(i-2), "daily Staff Amount", Integer.toString(i));
        }

        JFreeChart lineChartObject = ChartFactory.createLineChart(
                "Daily Staff Amount Vs Day" +"("+activity.getNameOfFNCD()+")","Day",
                "Staff Amount",
                line_chart_dataset,PlotOrientation.VERTICAL,
                true,true,false);

        int width = 800;    /* Width of the image */
        int height = 480;   /* Height of the image */
        File lineChart = null;
        if(activity.getNameOfFNCD().equals("North")) {
            lineChart = new File( "/Users/nik/Downloads/Spring2023/OOAD/Assignments/4/charts/north/DailyStaffAmountLineChart.jpeg" );
        }
        else {
            lineChart = new File( "/Users/nik/Downloads/Spring2023/OOAD/Assignments/4/charts/south/DailyStaffAmountLineChart.jpeg" );
        }

        ChartUtilities.saveChartAsJPEG(lineChart ,lineChartObject, width ,height);

    }

    private void plotFNCDAmount(Activity activity) throws IOException {
        DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
        line_chart_dataset.addValue(dailyFNCDAmount.get(0), "daily FNCD Amount", Integer.toString(1));

        for(int i=2; i<=31; i++) {
            line_chart_dataset.addValue(dailyFNCDAmount.get(i-1) - dailyFNCDAmount.get(i-2), "daily FNCD Amount", Integer.toString(i));
        }

        JFreeChart lineChartObject = ChartFactory.createLineChart(
                "Daily FNCD Amount Vs Day" +"("+activity.getNameOfFNCD()+")","Day",
                "FNCD Amount",
                line_chart_dataset,PlotOrientation.VERTICAL,
                true,true,false);

        int width = 800;    /* Width of the image */
        int height = 480;   /* Height of the image */
        File lineChart = null;
        if(activity.getNameOfFNCD().equals("North")) {
            lineChart = new File( "/Users/nik/Downloads/Spring2023/OOAD/Assignments/4/charts/north/DailyFNCDAmountLineChart.jpeg" );
        }
        else {
            lineChart = new File( "/Users/nik/Downloads/Spring2023/OOAD/Assignments/4/charts/south/DailyFNCDAmountLineChart.jpeg" );
        }

        ChartUtilities.saveChartAsJPEG(lineChart ,lineChartObject, width ,height);
    }

    private void plotVehiclesSold(Activity activity) throws IOException {
        DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();

        for(int i=1; i<=31; i++) {
            line_chart_dataset.addValue(numberOfVehiclesSold.get(i-1), "number of vehicles sold", Integer.toString(i));
        }

        JFreeChart lineChartObject = ChartFactory.createLineChart(
                "Number of Vehicles Sold Vs Day" +"("+activity.getNameOfFNCD()+")","Day",
                "Vehicles sold",
                line_chart_dataset,PlotOrientation.VERTICAL,
                true,true,false);

        int width = 800;    /* Width of the image */
        int height = 480;   /* Height of the image */
        File lineChart = null;
        if(activity.getNameOfFNCD().equals("North")) {
            lineChart = new File( "/Users/nik/Downloads/Spring2023/OOAD/Assignments/4/charts/north/NumberOfVehiclesLineChart.jpeg" );
        }
        else {
            lineChart = new File( "/Users/nik/Downloads/Spring2023/OOAD/Assignments/4/charts/south/NumberOfVehiclesLineChart.jpeg" );
        }

        ChartUtilities.saveChartAsJPEG(lineChart ,lineChartObject, width ,height);
    }

    public List<Integer> getNumberOfVehiclesSold() {
        return numberOfVehiclesSold;
    }

    public void setNumberOfVehiclesSold(List<Integer> numberOfVehiclesSold) {
        this.numberOfVehiclesSold = numberOfVehiclesSold;
    }

    public List<Double> getDailyFNCDAmount() {
        return dailyFNCDAmount;
    }

    public void setDailyFNCDAmount(List<Double> dailyFNCDAmount) {
        this.dailyFNCDAmount = dailyFNCDAmount;
    }

    public List<Double> getDailyStaffAmount() {
        return dailyStaffAmount;
    }

    public void setDailyStaffAmount(List<Double> dailyStaffAmount) {
        this.dailyStaffAmount = dailyStaffAmount;
    }
}