package logic;

import entity.PostType;

import java.util.Scanner;

public class PostTypeLogic {
    private PostType[] postTypes;
    private int totalPostType;

    public PostTypeLogic(PostType[] postTypes) {
        this.postTypes = postTypes;
    }

    public PostType[] getPostTypes() {
        return postTypes;
    }

    public void setPostTypes(PostType[] postTypes) {
        this.postTypes = postTypes;
    }

    public int getTotalPostType() {
        return totalPostType;
    }

    public void setTotalPostType(int totalPostType) {
        this.totalPostType = totalPostType;
    }

    public void inputPostType() {
        System.out.print("Có bao nhiêu kiểu bài viết muốn thêm mới: ");
        int postTypeNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < postTypeNumber; i++) {
            System.out.println("Nhập thông tin cho kiểu bài viết thứ: "+ (i + 1));
            PostType postType = new PostType();
            postType.inputInfo();
            savePostType(postType);
        }
        totalPostType += postTypeNumber;
    }

    private void savePostType(PostType postType) {
        for (int j = 0; j < postTypes.length; j++) {
            if(postTypes[j] == null){
                postTypes[j] = postType;
                break;
            }
        }

    }
    public void showPostType() {
        for (int i = 0; i < postTypes.length; i++) {
            if(postTypes[i] != null){
                System.out.println(postTypes[i]);
            }
        }
    }

    public PostType findPostTypeById(int postTypeId) {
        PostType result = null;
        for (int k = 0; k < postTypes.length; k++) {
            if (postTypes[k] != null && postTypes[k].getId() == postTypeId) {
                result = postTypes[k];
                break;
            }
        }
        return result;
    }
}

