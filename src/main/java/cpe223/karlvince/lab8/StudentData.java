package cpe223.karlvince.lab8;

public class StudentData {

    public static final String[] SUBJECTS = {
        "Math", "Science", "English", "History", "Art"
    };

    public static final String[] STUDENTS = {
        "Lara Croft", "Joel Miller", "Ezio Auditore da Firenze", "Trevor Philips", "Jin Sakai"
    };

    public static final String[] GRADE_LABELS = { "A", "B", "C", "D", "F" };
    public static final double[][] MIDTERM_SCORES = {
        { 85, 78, 92, 70, 88 },   // Lara Croft
        { 72, 65, 80, 60, 75 },   // Joel Miller
        { 90, 88, 95, 82, 91 },   // Ezio Auditore da Firenze
        { 68, 72, 74, 65, 80 },   // Trevor Philips
        { 77, 80, 85, 73, 82 }    // Jin Sakai
    };

    public static final int[] MIDTERM_GRADE_DIST = { 6, 10, 5, 3, 1 };
    public static final double[][] MIDTERM_STUDY = {
        { 2, 68, 3 }, { 4, 75, 4 }, { 6, 85, 5 },
        { 3, 72, 3 }, { 5, 80, 4 }, { 7, 90, 6 },
        { 1, 60, 2 }, { 8, 95, 7 }, { 3, 70, 3 },
        { 5, 82, 5 }
    };

    public static final double[] MIDTERM_AVG = { 78.4, 76.6, 85.2, 70.0, 83.2 };
    public static final double[][] FINAL_SCORES = {
        { 90, 85, 95, 78, 92 },   // Lara Croft
        { 78, 70, 85, 68, 80 },   // Joel Miller
        { 95, 92, 98, 88, 96 },   // Ezio Auditore da Firenze
        { 74, 78, 80, 72, 85 },   // Trevor Philips
        { 82, 86, 90, 80, 88 }    // Jin Sakai
    };

    public static final int[] FINAL_GRADE_DIST = { 9, 11, 3, 2, 0 };

    public static final double[][] FINAL_STUDY = {
        { 3, 74, 4 }, { 5, 80, 5 }, { 7, 90, 6 },
        { 4, 78, 4 }, { 6, 85, 5 }, { 8, 95, 7 },
        { 2, 68, 3 }, { 9, 98, 8 }, { 4, 76, 4 },
        { 6, 88, 6 }
    };

    public static final double[] FINAL_AVG = { 83.8, 82.2, 89.6, 77.2, 88.2 };

    public static boolean isMidterm(String dataset) {
        return "Midterm Results".equals(dataset);
    }

    public static double[][] getScores(boolean midterm) {
        return midterm ? MIDTERM_SCORES : FINAL_SCORES;
    }

    public static int[] getGradeDist(boolean midterm) {
        return midterm ? MIDTERM_GRADE_DIST : FINAL_GRADE_DIST;
    }

    public static double[][] getStudyData(boolean midterm) {
        return midterm ? MIDTERM_STUDY : FINAL_STUDY;
    }

    public static double[] getAverages(boolean midterm) {
        return midterm ? MIDTERM_AVG : FINAL_AVG;
    }
}
