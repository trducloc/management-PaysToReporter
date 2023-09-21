package entity;

public class WorkSheetDetail {

    private PostType postType;
    private int posts;

    public WorkSheetDetail(PostType postType, int posts) {
        this.postType = postType;
        this.posts = posts;
    }

    public PostType getPostType() {
        return postType;
    }

    public void setPostType(PostType postType) {
        this.postType = postType;
    }

    public int getPosts() {
        return posts;
    }

    public void setPosts(int posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "WorkSheetDetail{" +
                "postType=" + postType +
                ", posts=" + posts +
                '}';
    }
}
