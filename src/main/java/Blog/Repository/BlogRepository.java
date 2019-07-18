package Blog.Repository;

import Blog.Model.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BlogRepository extends PagingAndSortingRepository<Blog, Long> {

}