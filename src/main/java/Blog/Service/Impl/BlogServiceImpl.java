package Blog.Service.Impl;

import Blog.Repository.BlogRepository;
import Blog.Model.Blog;

import Blog.Service.BlogService;

import org.springframework.beans.factory.annotation.Autowired;

public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findOne(id);
    }

    @Override
    public void save(Blog Blog) {
        blogRepository.save(Blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.delete(id);
    }
}