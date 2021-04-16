package Service;

import Entity.Post;
import Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post save(Post post){
        return postRepository.save(post);
    }

    public List<Post> saveAll(List<Post> post){
        return postRepository.saveAll(post);
    }

    public List<Post> getAllPost(){
        return postRepository.findAll();
    }

    public Post getById(Long id){
        return postRepository.findById(id).orElse(null);
    }

    public Post getByTitle(String name){
        return postRepository.findByTitle(name);
    }

    public String deleteById(Long id){
        postRepository.deleteById(id);
        return "removed post success";
    }

    public Post updateProduct(Post post){
        Post exists = postRepository.findById(post.getId()).orElse(null);
        assert exists != null;
        exists.setTitle(post.getTitle());
        exists.setDescription(post.getDescription());
        return postRepository.save(exists);
    }

}
