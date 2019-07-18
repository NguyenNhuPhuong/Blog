package Blog.Service;


import Blog.Model.Blog;

public interface BlogService {
    Iterable<Blog> findAll();

    Blog findById(Long id);

    void save(Blog Blog);

    void remove(Long id);
}
