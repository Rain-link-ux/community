package life.majiang.community.provider;

/**
 * Author: 奔跑的狮子
 * Date: 2022/9/26 12:07
 */


public class GitubUser {

    private String name;

    private Long id;

    private String bio;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
