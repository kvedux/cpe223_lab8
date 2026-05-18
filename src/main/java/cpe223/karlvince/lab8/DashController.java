package cpe223.karlvince.lab8;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public class DashController implements Initializable {

    private static final String[] CHART_TYPES = {
        "Bar Chart", "Pie Chart", "Area Chart", "Bubble Chart",
        "Line Chart", "Scatter Chart", "Stacked Area Chart", "Stacked Bar Chart"
    };

    @FXML private ComboBox<String> datasetCombo;
    @FXML private ComboBox<String> chartCombo;
    @FXML private StackPane        chartContainer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // dataset selector
        datasetCombo.setItems(FXCollections.observableArrayList("Midterm Results", "Final Results"));
        datasetCombo.setValue("Midterm Results");

        // chart type selector
        chartCombo.setItems(FXCollections.observableArrayList(CHART_TYPES));
        chartCombo.setValue("Bar Chart");

        // refresh chart on change
        datasetCombo.setOnAction(e -> refreshChart());
        chartCombo.setOnAction(e -> refreshChart());

        // initial render
        refreshChart();
    }

    private void refreshChart() {
        boolean midterm   = StudentData.isMidterm(datasetCombo.getValue());
        String  chartType = chartCombo.getValue();

        Node chart = buildChart(chartType, midterm);

        chartContainer.getChildren().setAll(chart);
    }

    private Node buildChart(String chartType, boolean midterm) {
        switch (chartType) {
            case "Bar Chart":
                return ChartImpl.createBarChart(StudentData.getScores(midterm));
            case "Pie Chart":
                return ChartImpl.createPieChart(StudentData.getGradeDist(midterm));
            case "Area Chart":
                return ChartImpl.createAreaChart(StudentData.getAverages(midterm));
            case "Bubble Chart":
                return ChartImpl.createBubbleChart(StudentData.getStudyData(midterm));
            case "Line Chart":
                return ChartImpl.createLineChart(StudentData.getScores(midterm));
            case "Scatter Chart":
                return ChartImpl.createScatterChart(StudentData.getStudyData(midterm));
            case "Stacked Area Chart":
                return ChartImpl.createStackedAreaChart(StudentData.getScores(midterm));
            case "Stacked Bar Chart":
                return ChartImpl.createStackedBarChart(StudentData.getScores(midterm));
            default:
                return ChartImpl.createBarChart(StudentData.getScores(midterm));
        }
    }
}
