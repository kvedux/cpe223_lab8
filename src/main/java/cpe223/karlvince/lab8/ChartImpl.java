package cpe223.karlvince.lab8;

import javafx.scene.Node;
import javafx.scene.chart.*;

public class ChartImpl {

    private ChartImpl() {}

    // bar chart

    public static Node createBarChart(double[][] scores) {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Subject");
        NumberAxis yAxis = new NumberAxis(0, 100, 10);
        yAxis.setLabel("Score");

        BarChart<String, Number> chart = new BarChart<>(xAxis, yAxis);
        chart.setTitle("Scores per Subject");
        chart.setAnimated(false);

        addStudentSeries(chart, scores);
        return chart;
    }

    // pie chart

    public static Node createPieChart(int[] gradeDist) {
        PieChart chart = new PieChart();
        chart.setTitle("Grade Distribution");
        chart.setAnimated(false);
        chart.setLabelsVisible(true);

        for (int i = 0; i < StudentData.GRADE_LABELS.length; i++) {
            chart.getData().add(
                new PieChart.Data(StudentData.GRADE_LABELS[i] + " (" + gradeDist[i] + ")", gradeDist[i])
            );
        }
        return chart;
    }

    // area chart

    public static Node createAreaChart(double[] avg) {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Subject");
        NumberAxis yAxis = new NumberAxis(0, 100, 10);
        yAxis.setLabel("Average Score");

        AreaChart<String, Number> chart = new AreaChart<>(xAxis, yAxis);
        chart.setTitle("Class Average per Subject");
        chart.setAnimated(false);

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Class Average");
        for (int i = 0; i < StudentData.SUBJECTS.length; i++) {
            series.getData().add(new XYChart.Data<>(StudentData.SUBJECTS[i], avg[i]));
        }
        chart.getData().add(series);
        return chart;
    }

    // bubble chart

    public static Node createBubbleChart(double[][] study) {
        NumberAxis xAxis = new NumberAxis(0, 10, 1);
        xAxis.setLabel("Study Hours");
        NumberAxis yAxis = new NumberAxis(50, 100, 10);
        yAxis.setLabel("Score");

        BubbleChart<Number, Number> chart = new BubbleChart<>(xAxis, yAxis);
        chart.setTitle("Study Hours vs Score (bubble = effort)");
        chart.setAnimated(false);

        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("Study Effort");
        for (double[] row : study) {
            series.getData().add(new XYChart.Data<>(row[0], row[1], row[2] * 0.3));
        }
        chart.getData().add(series);
        return chart;
    }

    // line chart

    public static Node createLineChart(double[][] scores) {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Subject");
        NumberAxis yAxis = new NumberAxis(0, 100, 10);
        yAxis.setLabel("Score");

        LineChart<String, Number> chart = new LineChart<>(xAxis, yAxis);
        chart.setTitle("Student Score Trends");
        chart.setAnimated(false);

        addStudentSeries(chart, scores);
        return chart;
    }

    // scatter chart

    public static Node createScatterChart(double[][] study) {
        NumberAxis xAxis = new NumberAxis(0, 10, 1);
        xAxis.setLabel("Study Hours");
        NumberAxis yAxis = new NumberAxis(50, 100, 10);
        yAxis.setLabel("Score");

        ScatterChart<Number, Number> chart = new ScatterChart<>(xAxis, yAxis);
        chart.setTitle("Study Hours vs Score");
        chart.setAnimated(false);

        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("Hours vs Score");
        for (double[] row : study) {
            series.getData().add(new XYChart.Data<>(row[0], row[1]));
        }
        chart.getData().add(series);
        return chart;
    }

    //stacked area chart

    public static Node createStackedAreaChart(double[][] scores) {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Subject");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Score");

        StackedAreaChart<String, Number> chart = new StackedAreaChart<>(xAxis, yAxis);
        chart.setTitle("Cumulative Scores by Student");
        chart.setAnimated(false);

        addStudentSeries(chart, scores);
        return chart;
    }

    // stacked bar chart

    public static Node createStackedBarChart(double[][] scores) {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Subject");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Total Score");

        StackedBarChart<String, Number> chart = new StackedBarChart<>(xAxis, yAxis);
        chart.setTitle("Score Composition by Subject");
        chart.setAnimated(false);

        addStudentSeries(chart, scores);
        return chart;
    }

   // helper

    private static void addStudentSeries(XYChart<String, Number> chart, double[][] scores) {
        for (int i = 0; i < StudentData.STUDENTS.length; i++) {
            XYChart.Series<String, Number> series = new XYChart.Series<>();
            series.setName(StudentData.STUDENTS[i]);
            for (int j = 0; j < StudentData.SUBJECTS.length; j++) {
                series.getData().add(new XYChart.Data<>(StudentData.SUBJECTS[j], scores[i][j]));
            }
            chart.getData().add(series);
        }
    }
}
