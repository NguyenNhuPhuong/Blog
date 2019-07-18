package Blog.Controller;


import Blog.Model.Blog;
import Blog.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("blog-list")
    public ModelAndView listBloger() {
        Iterable<Blog> blogs = blogService.findAll();
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }

    @GetMapping("blog-create")
    public ModelAndView createBlog() {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("blog-create")
    public ModelAndView save(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);

        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("message", "Save successfully");
        return modelAndView;
    }

    @GetMapping("blog-edit/{id}")
    public ModelAndView showEdit(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }
    @PostMapping("blog-edit")
    public ModelAndView Update(@ModelAttribute("blog")Blog blog){
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message","Update successfully ");
        return modelAndView;
    }
    @GetMapping("blog-delete/{id}")
    public ModelAndView deleteForm(@PathVariable Long id){
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/blog/delete");
        modelAndView.addObject("blog",blog);
        return modelAndView;
    }

    @PostMapping("blog-delete")
    public String delete(@ModelAttribute("blog") Blog blog){
        blogService.remove(blog.getId());
        return "redirect:blog-list";
    }
}
