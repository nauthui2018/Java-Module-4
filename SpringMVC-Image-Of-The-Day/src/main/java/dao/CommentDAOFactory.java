package dao;

import model.Comment;

public class CommentDAOFactory {
    private static BaseDAO<Comment> singleton;

    public static synchronized BaseDAO<Comment> getInstance() {
        if (singleton == null) {
            singleton = new CommentDAO();
        }
        return singleton;
    }
}
