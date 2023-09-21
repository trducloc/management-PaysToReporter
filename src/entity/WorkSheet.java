package entity;

import java.util.Arrays;

public class WorkSheet {

    private Reporter reporter;
    private WorkSheetDetail[] workSheetDetails; // danh sách các thể loại mà phóng viên này viết
    // kèm theo số lượng bài ở mỗi loại
    private int totalPost;

    public WorkSheet(Reporter reporter, WorkSheetDetail[] workSheetDetails) {
        this.reporter = reporter;
        this.workSheetDetails = workSheetDetails;

        int tempTotal = 0;
        for (int i = 0; i < workSheetDetails.length; i++) {
            tempTotal += workSheetDetails[i].getPosts();
        }
        this.totalPost = tempTotal;
    }

    public WorkSheet(Reporter reporter, WorkSheetDetail[] details, int totalPost) {
        this.reporter = reporter;
        this.workSheetDetails = workSheetDetails;
        this.totalPost = totalPost;
    }

    public Reporter getReporter() {
        return reporter;
    }

    public void setReporter(Reporter reporter) {
        this.reporter = reporter;
    }

    public WorkSheetDetail[] getWorkSheetDetails() {
        return workSheetDetails;
    }

    public void setDetails(WorkSheetDetail[] details) {
        this.workSheetDetails = workSheetDetails;
    }

    public int getTotalPost() {
        return totalPost;
    }

    public void setTotalPost(int totalPost) {
        this.totalPost = totalPost;
    }

    @Override
    public String toString() {
        return "WorkSheet{" +
                "reporter=" + reporter +
                ", details=" + Arrays.toString(workSheetDetails) +
                ", totalPost=" + totalPost +
                '}';
    }
}
