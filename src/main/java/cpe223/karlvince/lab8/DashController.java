package cpe223.karlvince.lab8;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public class DashController implements Initializable {

    @FXML private ComboBox<String> datasetCombo;

    // one StackPane per tab
    @FXML private StackPane barChartPane;
    @FXML private StackPane pieChartPane;
    @FXML private StackPane areaChartPane;
    @FXML private StackPane bubbleChartPane;
    @FXML private StackPane lineChartPane;
    @FXML private StackPane scatterChartPane;
    @FXML private StackPane stackedAreaChartPane;
    @FXML private StackPane stackedBarChartPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        datasetCombo.setItems(FXCollections.observableArrayList("Midterm Results", "Final Results"));
        datasetCombo.setValue("Midterm Results");

        // refresh all charts whenever the dataset changes
        datasetCombo.setOnAction(e -> refreshAllCharts());

        // initial render for all tabs
        refreshAllCharts();
    }

    private void refreshAllCharts() {
        boolean midterm = StudentData.isMidterm(datasetCombo.getValue());

        barChartPane.getChildren().setAll(
            ChartImpl.createBarChart(StudentData.getScores(midterm)));

        pieChartPane.getChildren().setAll(
            ChartImpl.createPieChart(StudentData.getGradeDist(midterm)));

        areaChartPane.getChildren().setAll(
            ChartImpl.createAreaChart(StudentData.getAverages(midterm)));

        bubbleChartPane.getChildren().setAll(
            ChartImpl.createBubbleChart(StudentData.getStudyData(midterm)));

        lineChartPane.getChildren().setAll(
            ChartImpl.createLineChart(StudentData.getScores(midterm)));

        scatterChartPane.getChildren().setAll(
            ChartImpl.createScatterChart(StudentData.getStudyData(midterm)));

        stackedAreaChartPane.getChildren().setAll(
            ChartImpl.createStackedAreaChart(StudentData.getScores(midterm)));

        stackedBarChartPane.getChildren().setAll(
            ChartImpl.createStackedBarChart(StudentData.getScores(midterm)));
    }
}
