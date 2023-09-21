package entity;

import statics.ReporterType;

import java.util.Scanner;

public class Reporter extends Person {
    private static int AUTO_ID = 10000;
    private int id;
    private ReporterType reporterType;


    public static int getAutoId() {
        return AUTO_ID;
    }

    public static void setAutoId(int autoId) {
        AUTO_ID = autoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ReporterType getReporterType() {
        return reporterType;
    }

    public void setReporterType(ReporterType reporterType) {
        this.reporterType = reporterType;
    }

    @Override
    public String toString() {
        return "Reporter{" +
                "id=" + id +
                ", reporterType=" + reporterType +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
    public void inputInfo(){
        super.inputInfo();
        this.id = AUTO_ID;
        AUTO_ID++;
        System.out.println("Nhập loại phóng viên, chọn 1 trong các loại dưới đây: ");
        System.out.println("1. Chuyên nghiệp.");
        System.out.println("2. Nghiệp dư.");
        System.out.println("3. Cộng tác viên.");
        int type = 0;
        System.out.println("Xin mời nhập lựa chọn: ");
        do{
            type = new Scanner(System.in).nextInt();
            if (type >= 1 && type <= 3) {
                break;
            }
            System.out.print("Lựa chọn không hợp lệ, vui lòng chọn lại: ");
        } while(true);
        switch (type){
            case 1:
                this.setReporterType(ReporterType.PROFESSIONAL);
                break;
            case 2:
                this.setReporterType(ReporterType.CAREER);
                break;
            case 3:
                this.setReporterType(ReporterType.COLLABORATORS);
                break;
        }
    }
}
