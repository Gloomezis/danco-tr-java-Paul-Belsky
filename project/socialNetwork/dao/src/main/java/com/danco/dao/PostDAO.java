package com.danco.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import com.danco.api.dao.IPostDAO;
import com.danco.model.Post;

@Repository
@ComponentScan("com.danco.dao")  
public class PostDAO implements IPostDAO {

	
	
		
	    private SessionFactory sf;
		
	    public PostDAO() {
			System.out.println("Post dao created");
		} 

	    @Required
		@Autowired 
		public void setSf(SessionFactory sf) {
			this.sf = sf;
		}

		
		/* (non-Javadoc)
		 * @see com.danco.dao.IPostDAO#create(com.danco.model.Post)
		 */
		@Override
		public void create(Post post) throws Exception{
			sf.getCurrentSession().save(post);
		}

		
		/* (non-Javadoc)
		 * @see com.danco.dao.IPostDAO#update(com.danco.model.Post)
		 */
		@Override
		public void update(Post post) throws Exception{
			sf.getCurrentSession().update(post);
		}
		
		/* (non-Javadoc)
		 * @see com.danco.dao.IPostDAO#delete(com.danco.model.Post)
		 */
		@Override
		public void delete(Post post) throws Exception{
			sf.getCurrentSession().delete(post);
		} 
		

		
		/* (non-Javadoc)
		 * @see com.danco.dao.IPostDAO#getById(int)
		 */
		@Override
		public Post getById(int idPost)  throws Exception{
		return	(Post) sf.getCurrentSession().get(Post.class, idPost);
				
		    
		}

		
		
		/* (non-Javadoc)
		 * @see com.danco.dao.IPostDAO#getList()
		 */
		@Override
		public List<Post> getList()  throws Exception{
		
		    @SuppressWarnings("unchecked")
	        List<Post> listPost = (List<Post>) sf.getCurrentSession()
	                .createCriteria(Post.class)
	                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	        return listPost;
		   
		}
}
