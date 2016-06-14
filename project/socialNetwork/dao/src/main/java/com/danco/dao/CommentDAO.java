package com.danco.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;



import com.danco.api.dao.ICommentDAO;
import com.danco.model.Comment;


@Repository
@ComponentScan("com.danco.dao")  
public class CommentDAO implements ICommentDAO {

	
	
		
	    private SessionFactory sf;
		
	    public CommentDAO() {
			System.out.println("Comment dao created");
		} 

	    @Required
		@Autowired 
		public void setSf(SessionFactory sf) {
			this.sf = sf;
		}

		
		/* (non-Javadoc)
		 * @see com.danco.dao.ICommentDAO#create(com.danco.model.Comment)
		 */
		@Override
		public void create(Comment comment) throws Exception{
			sf.getCurrentSession().save(comment);
		}

		
		/* (non-Javadoc)
		 * @see com.danco.dao.ICommentDAO#update(com.danco.model.Comment)
		 */
		@Override
		public void update( Comment comment) throws Exception{
			sf.getCurrentSession().update(comment);
		}
		
		/* (non-Javadoc)
		 * @see com.danco.dao.ICommentDAO#delete(com.danco.model.Comment)
		 */
		@Override
		public void delete( Comment comment) throws Exception{
			sf.getCurrentSession().delete(comment);
		} 
		

		
		/* (non-Javadoc)
		 * @see com.danco.dao.ICommentDAO#getById(int)
		 */
		@Override
		public Comment getById(int idComment)  throws Exception{
		return	(Comment) sf.getCurrentSession().get(Comment.class, idComment);
				
		    
		}

		
		
		/* (non-Javadoc)
		 * @see com.danco.dao.ICommentDAO#getList()
		 */
		@Override
		public List<Comment> getList()  throws Exception{
		
		    @SuppressWarnings("unchecked")
	        List<Comment> listComment = (List<Comment>) sf.getCurrentSession()
	                .createCriteria(Comment.class)
	                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	 
	        return listComment;
		   
		}


}
