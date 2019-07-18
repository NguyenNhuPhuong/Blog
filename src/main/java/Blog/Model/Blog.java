package Blog.Model;

import javax.persistence.*;

@Entity
@Table(name="blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;
    private String title;
    private String author;

    public Blog(Long id, String content, String title, String author) {
        this.id = id;
        this.content = content;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public Blog() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
