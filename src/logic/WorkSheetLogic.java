package logic;

import entity.PostType;
import entity.Reporter;
import entity.WorkSheet;
import entity.WorkSheetDetail;

import java.util.Scanner;

public class WorkSheetLogic {

    private final ReporterLogic reporterLogic;
    private final PostTypeLogic postTypeLogic;
    private WorkSheet[] workSheets;

    public WorkSheetLogic(ReporterLogic reporterLogic, PostTypeLogic postTypeLogic, WorkSheet[] workSheets) {
        this.reporterLogic = reporterLogic;
        this.postTypeLogic = postTypeLogic;
        this.workSheets = workSheets;
    }

    public void showSheet() {
        for (int i = 0; i < workSheets.length; i++) {
            if(workSheets[i] != null){
                System.out.println(workSheets[i]);
            }
        }
    }
    public void sheet(){
        if (!isEmpty()) {
            System.out.println("Chưa có thông tin phóng viên hoặc bài viết, vui lòng nhập danh sách phóng viên và bài viết trước");
            return;
        }
        System.out.print("Có bao nhiêu phóng viên cần tính công: ");
        int reporterNumber;
        do{
            reporterNumber = new Scanner(System.in).nextInt();
            if (reporterNumber > 0 && reporterNumber <= reporterLogic.getTotalReporter()) {
                break;
            }
            System.out.println("Số lượng phóng viên cần tính công phải là số dương và nhỏ hơn số lượng phóng viên có trong tòa soạn");
        } while(true);
        for (int i = 0; i < reporterNumber; i++) {
            System.out.println("Nhập thông tin phóng viên thứ " + (i + 1));
            Reporter reporter = inputReporterForWorkSheet();
            System.out.print("Bạn muốn lập bảng tính công cho bao nhiêu kiểu bài viết: ");
            // lập danh sách các thể loại mà ông này viết bài và số lượng bài viết tương ứng
            WorkSheetDetail[] details = inputWorkSheetDetail();
            WorkSheet workSheet = new WorkSheet(reporter, details);
            saveSheet(workSheet);
        }
    }
    private WorkSheetDetail[] inputWorkSheetDetail() {
        int postTypeNumber;
        do{
        System.out.print("Phóng viên này viết bao nhiêu kiểu bài viết: ");
        postTypeNumber = new Scanner(System.in).nextInt();
        if (postTypeNumber >= 1 && postTypeNumber <= 5 && postTypeNumber <= postTypeLogic.getTotalPostType()) {
            break;
        }
        System.out.print("Số kiểu bài viết phải là số dương và nhỏ hơn tổng số lượng bài viết mà tòa soạn đang có, đồng thời phải nhỏ hơn hoặc bẳng 5, vui lòng nhập lại:");
    } while (true);
    WorkSheetDetail[] details = new WorkSheetDetail[postTypeNumber];
        int count = 0;
        for (int j = 0; j < postTypeNumber; j++) {
            System.out.println("Nhập thông tin cho kiểu bài viết thứ " + (j + 1));
            System.out.print("Nhập mã kiểu bài viết: ");
            int postTypeId;
            PostType postType = null;
            do {
                postTypeId = new Scanner(System.in).nextInt();
                postType = postTypeLogic.findPostTypeById(postTypeId);
                if (postType != null) {
                    break;
                }
                System.out.println("Không có kiểu bài viết nào mang mã " + postTypeId + ", vui lòng nhập lại: ");
            } while (true);
            System.out.print("Kiểu bài viết mã " + postType.getId() + " được viết bao nhiêu bài: ");
            int posts;
            do {
                posts = new Scanner(System.in).nextInt();
                if (posts > 0) {
                    break;
                }
                System.out.println("Số lượng bài viết là một số nguyên dương, vui lòng nhập lại");
            } while(true);
            WorkSheetDetail detail = new WorkSheetDetail(postType, posts);
            details[count] = detail;
            count++;
        }
        return details;
    }
    private Reporter inputReporterForWorkSheet() {
        System.out.print("Nhập mã phóng viên muốn tính công: ");
        int reporterId;
        Reporter reporter;
        do {
            reporterId = new Scanner(System.in).nextInt();
            reporter = reporterLogic.findReporterById(reporterId);
            if (reporter != null) {
                break;
            }
            System.out.print("Không tồn tại phóng viên mang mã " + reporter + ", vui lòng nhập lại: ");
        } while (true);
        return reporter;
    }
    private void saveSheet(WorkSheet workSheet) {
        for (int j = 0; j < workSheets.length; j++) {
            if (workSheets[j] == null) {
                workSheets[j] = workSheet;
                break;
            }
        }
    }
    private void showWorkSheet() {
        for (int i = 0; i < workSheets.length; i++) {
            if (workSheets[i] != null) {
                System.out.println(workSheets[i]);
            }
        }
    }

    public void sortByReporterName() {
        if (!isEmpty()) {
            System.out.println("Chưa có thông tin phóng viên hoặc bài viết, vui lòng nhập danh sách phóng viên và bài viết trước");
            return;
        }
        for (int i = 0; i < workSheets.length - 1; i++) {
            if (workSheets[i] == null) {
                continue;
            }
            for (int j = i + 1; j < workSheets.length; j++) {
                if (workSheets[j] == null) {
                    continue;
                }
                if (workSheets[i].getReporter().getName().trim().compareToIgnoreCase(workSheets[j].getReporter().getName().trim()) > 0) {
                    WorkSheet temp = workSheets[i];
                    workSheets[i] = workSheets[j];
                    workSheets[j] = temp;
                }
            }
        }
        showWorkSheet();
    }

    public void sortByPostNumber() {
        if (!isEmpty()) {
            System.out.println("Chưa có thông tin phóng viên hoặc bài viết, vui lòng nhập danh sách phóng viên và bài viết trước");
            return;
        }
        for (int i = 0; i < workSheets.length - 1; i++) {
            if (workSheets[i] == null) {
                continue;
            }
            for (int j = i + 1; j < workSheets.length; j++) {
                if (workSheets[j] == null) {
                    continue;
                }
                if (workSheets[i].getTotalPost() < workSheets[j].getTotalPost()) {
                    WorkSheet temp = workSheets[i];
                    workSheets[i] = workSheets[j];
                    workSheets[j] = temp;
                }
            }
        }
        showWorkSheet();
    }

    public void salary() {
        if (!isEmpty()) {
            System.out.println("Chưa có thông tin phóng viên hoặc bài viết, vui lòng nhập danh sách phóng viên và bài viết trước");
            return;
        }
        for (int i = 0; i < workSheets.length; i++) {
            double salary = 0;
            WorkSheet baoCaoBaiViet = workSheets[i];
            WorkSheetDetail[] danhSachBaiViet = baoCaoBaiViet.getWorkSheetDetails();
            for (int j = 0; j < danhSachBaiViet.length; j++) {
                salary += danhSachBaiViet[j].getPostType().getPrice() * danhSachBaiViet[j].getPosts();
            }
            System.out.println("Tổng thu nhập của phóng viên " + workSheets[i].getReporter().getName() + " là " + salary);
        }
    }
//    public void searchByReporterName(){
//        System.out.println("Nhap ten phong vien muon tim kiem: ");
//        String reporterName = new Scanner(System.in).nextLine();
//        for (int i = 0; i < workSheets.length; i++) {
//            if(workSheets[i]!=null && workSheets[i].getReporter().getName().toLowerCase().contains(reporterName.toLowerCase())){
//                System.out.println(workSheets[i]);
//            }
//        }
//    }

    private boolean isEmpty() {
        boolean haveDataReporter = false;
        for (int i = 0; i < reporterLogic.getReporters().length; i++) {
            if (reporterLogic.getReporters()[i] != null) {
                haveDataReporter = true;
                break;
            }
        }

        boolean haveDataPost = false;
        for (int i = 0; i < postTypeLogic.getPostTypes().length; i++) {
            if (postTypeLogic.getPostTypes()[i] != null) {
                haveDataPost = true;
                break;
            }
        }

        return haveDataReporter && haveDataPost;
    }
}
