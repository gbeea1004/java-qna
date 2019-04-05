package codesquad.question;

/**
 * Created by Geon Hee Sung.
 * Date: 2019-04-05
 * Time: 오후 1:30
 */
public class Question {
    private int id;
    private String writer;
    private String title;
    private String contents;

    public Question() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
