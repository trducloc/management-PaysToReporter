package logic;

import entity.Reporter;

import java.util.Scanner;

public class ReporterLogic {
    private Reporter[] reporters;
    private int totalReporter;

    public ReporterLogic(Reporter[] reporters) {
        this.reporters = reporters;
    }

    public Reporter[] getReporters() {
        return reporters;
    }

    public void setReporters(Reporter[] reporters) {
        this.reporters = reporters;
    }

    public int getTotalReporter() {
        return totalReporter;
    }

    public void setTotalReporter(int totalReporter) {
        this.totalReporter = totalReporter;
    }

    public void inputReporter() {
        System.out.print("Có bao nhiêu phóng viên muốn thêm mới: ");
        int reporterNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < reporterNumber; i++) {
            System.out.println("Nhập thông tin cho phóng viên thứ: "+ (i + 1));
            Reporter reporter = new Reporter();
            reporter.inputInfo();
            saveReporter(reporter);
        }
        totalReporter += reporterNumber;

    }

    private void saveReporter(Reporter reporter) {
        for (int j = 0; j < reporters.length; j++) {
            if(reporters[j] == null){
                reporters[j] = reporter;
                break;
            }
        }

    }
    public void showReporter() {
        for (int i = 0; i < reporters.length; i++) {
            if(reporters[i] != null){
                System.out.println(reporters[i]);
            }
        }
    }

    public Reporter findReporterById(int reporterId) {
        Reporter result = null;
        for (int j = 0; j < reporters.length; j++) {
            if (reporters[j] != null && reporters[j].getId() == reporterId) {
                result = reporters[j];
                break;
            }
        }
        return result;


    }
}
