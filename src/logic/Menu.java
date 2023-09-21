package logic;

import entity.PostType;
import entity.Reporter;
import entity.WorkSheet;

import java.util.Scanner;

public class Menu {
    private ReporterLogic reporterLogic ;
    private PostTypeLogic postTypeLogic;
    private WorkSheetLogic workSheetLogic;
    public Menu() {
        Reporter[] reporters = new Reporter[1000];
        reporterLogic = new ReporterLogic(reporters);

        PostType[] postTypes = new PostType[1000];
        postTypeLogic = new PostTypeLogic(postTypes);

        WorkSheet[] workSheets = new WorkSheet[1000];
        workSheetLogic = new WorkSheetLogic(reporterLogic, postTypeLogic, workSheets);
    }

    public void show() {
        while(true){
            printMenu();
            int functionChoice = chooseFunction();

            switch (functionChoice) {
                case 1:
                    reporterLogic.inputReporter();
                    break;
                case 2:
                    reporterLogic.showReporter();
                    break;
                case 3:
                    postTypeLogic.inputPostType();
                    break;
                case 4:
                    postTypeLogic.showPostType();
                    break;
                case 5:
                    workSheetLogic.showSheet();
                    break;
                case 6:
                    menuSort();
                    break;
                case 7:
                    workSheetLogic.salary();
                    break;
                case 8:
                    return;
            }
        }
    }

    public void menuSort() {
        System.out.println("_______________Các lựa chọn sắp xếp_______________");
        System.out.println("1. Theo Họ tên phóng viên.");
        System.out.println("2. Theo Số lượng bài viết (giảm dần)");
        System.out.println("0. Trở lại menu chính.");
        int x = 0;
        System.out.print("Bạn chọn: ");
        do {
            x = new Scanner(System.in).nextInt();
            if (x == 1 || x == 2) {
                break;
            }
            System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại: ");
        } while(true);
        switch (x) {
            case 1:
                workSheetLogic.sortByReporterName();
                break;
            case 2:
                workSheetLogic.sortByPostNumber();
                break;
        }
    }

    private static int chooseFunction () {
        System.out.print("Xin mời lựa chọn chức năng: ");
        int functionChoice;
        do {
            functionChoice = new Scanner(System.in).nextInt();
            if (functionChoice >= 1 && functionChoice <= 9) {
                break;
            }
            System.out.print("Chức năng không hợp lệ, vui lòng chọn lại: ");

        } while (true);
        return functionChoice;
    }
    private static void printMenu () {
        System.out.println("------MANAGEMENT PAYS ROYALTIES TO REPORTERS-----");
        System.out.println("1. Nhập phóng viên mới.");
        System.out.println("2. In danh sách phóng viên.");
        System.out.println("3. Nhập kiểu bài viết mới");
        System.out.println("4. In danh sách các kiểu bài viết.");
        System.out.println("5. Lập bảng tính công cho phóng viên.");
        System.out.println("6. Sắp xếp Bảng tính công.");
        System.out.println("7. Lập bảng kê thu nhập của mỗi phóng viên.");
        System.out.println("8. Thoát");

    }

}
